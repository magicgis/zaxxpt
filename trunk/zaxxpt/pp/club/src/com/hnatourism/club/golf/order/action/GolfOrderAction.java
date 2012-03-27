package com.hnatourism.club.golf.order.action;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.order.service.GolfOrderService;
import com.hnatourism.club.golf.order.vo.GolfOrderExceptionVo;
import com.hnatourism.club.golf.order.vo.GolfOrderLogVo;
import com.hnatourism.club.golf.order.vo.GolfOrderPlayVo;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.golf.order.vo.OrderContactVo;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.domain.BaseUser;
import com.hnatourism.framework.web.action.BaseAction;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫定单
 * 
 * 历史版本: ${2011.8.4} v1.0.0 (栾晓东) 创建
 * 
 */
public class GolfOrderAction extends BaseAction{
	
	private static final Log log = (Log) LogFactory.getLog(GolfOrderAction.class);
	//高尔夫退改标志位                        1  就是退    0就是改
	private String applyflag;
	//高尔夫业务层。
	private GolfOrderService golfOrderService;
	//高尔夫定单VO
	private GolfOrderVo golfOrderVo;
	//高尔夫定单Id
	private String id;
	//支付状态。
	private String paySts;
	//高尔夫定单申请理由。
	private String rmk;
	//高尔夫定单的申请改期时间。
	private String updateTime;
	//定单分页
	private PageInfo pageInfo=new PageInfo();
	//高尔夫定单列表
	private List<GolfOrderVo> data;
	//高尔夫定单退改VO------------------
	private GolfOrderExceptionVo golfOrderExceptionVo=new GolfOrderExceptionVo();
	//高尔夫定单状态---------------------
	private String golfOrderSts;
	//高尔夫定单内容---------------------
	private String logGolfOrderContent;
	//用户
	private BaseUser baseUser;
	private String id1;//保存id状态 用于重新。
	
	private GolfSiteVo golfSiteVo;
	private GolfInfoVo golfInfoVo;
	private GolfPriceVo golfPriceVo;
	private List<GolfOrderLogVo> golfOrderLogVoList;
	private List<GolfOrderPlayVo>  golfOrderPlayVoList;
	private OrderContactVo orderContactVo=new OrderContactVo();
	private IMemberInfoService memberInfoServ;
	//异常订单
	private List<GolfOrderExceptionVo> golfOrderExceptionList=new ArrayList<GolfOrderExceptionVo>();
	//打球人员
	private String [] playerIds;
	
	private Boolean isShowRM=false;
	
	//查询出所有定单
	public String search(){
		//查寻出分页定单。传到order.jsp页面。
		return "search";
	}
	
	//高尔夫定单管理页面，根据ID查出一个定单，跳转到退与改的页面。
	public String searchOneOrder(){
		if(UserUtil.getUser(getSession().getId()) == null)
		{
			return "notlogin";
		}
		
		log.info("id="+id);
		try {
			//获取修改订单状态的操作提示	eidt by lixun  begin
			Object msgObj=getSession().getAttribute("golfStatusUpdateMsg");
			getSession().setAttribute("golfStatusUpdateMsg",null);
			if(msgObj!=null){
				setMessage((String)msgObj);
			}
			//end
			
			//跟据传过来的定单id找出一个定单。
//			ApiClient client1=new ApiClient();//得到API客户端。
			Gson gson1 = new Gson();//拿到google 的Gson
			Type collectionType1 = new TypeToken<List<GolfOrderVo>>(){}.getType(); //得到集合类型。
			List<GolfOrderVo> golfOrderVoList1=(List<GolfOrderVo>)gson1.fromJson(ApiClient.getHtml("/api/apiServer.action?method=api_findGolfOrderById&&id="+id),collectionType1);//通过集合类型根据传的id找出一个定单放到List的第0项中去。
			golfOrderVo=golfOrderVoList1.get(0);
			golfSiteVo=golfOrderVo.getGolfSiteVo();
			 golfInfoVo=golfOrderVo.getGolfInfoVo();
			 golfPriceVo=golfOrderVo.getGolfPriceVo();
			 orderContactVo=golfOrderVo.getOrderContactVo();
			 golfOrderLogVoList=golfOrderVo.getGolfOrderLogVoList();
			 golfOrderPlayVoList=golfOrderVo.getGolfOrderPlayVoList();
			 golfOrderExceptionList=golfOrderVo.getGolfOrderExceptionList();
			
			 //按钮显示控制
			 if( !"0".equals(golfOrderVo.getSts()) && "1".equals(golfOrderVo.getPaySts()) && !"1".equals(golfOrderVo.getConsumerSts())){
				 	isShowRM=true;
				 	if(golfOrderExceptionList!=null && golfOrderExceptionList.size()>=1){
				 		for (int i = 0; i < golfOrderExceptionList.size(); i++) {
				 			GolfOrderExceptionVo goev=golfOrderExceptionList.get(i);
							 if("7".equals(goev.getSts()) || "4".equals(goev.getSts()) || "10".equals(goev.getSts())|| "11".equals(goev.getSts())){
								 isShowRM=false;
							 }
						}
					}else {
						//处于没有异常的状态
						if("2".equals(golfOrderVo.getSts())){
							isShowRM=true;
						}
						
					}
					if(isShowRM){
						//增加对球场的判断,在球场中有尚未退场的球员就可以继续申请退改
						isShowRM=!isShowRM;
						for(GolfOrderPlayVo guestVo:golfOrderPlayVoList){
							if("0".equals(guestVo.getSts())){
								isShowRM=!isShowRM;
								break;
							}
						}
					}
				 }
		} catch (Exception e) {
			log.error("查找订单失败",e);
		}
		updateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return "view";//将数据传到view.jsp
	}
	
	//高尔夫球场退改页面提交这里。
	public String quitOrChangeOrder(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(UserUtil.getUser(getSession().getId()) == null)
		{
			return "notlogin";
		}
		//打球人员
		String playerIdStr="";
		if(playerIds!=null){
			for(String name:playerIds){
				playerIdStr=playerIdStr+name+",";
			}
		}
		try {
			if(applyflag.equals("1")){//如果是退定单，则将退场理由及id提交到后台。
				golfOrderExceptionVo.setType("R");
//				ApiClient client=new ApiClient();//得到API客户端。
				/**
				 * client.getHtml("/api/apiServer.action?method=api_saveGolfOrderException&&id="+id+"&&rmk="+golfOrderExceptionVo.getRmk()
						+"&&type="+golfOrderExceptionVo.getType()+"&&feeRate="+golfOrderExceptionVo.getFeeRate()
						+"&&fee="+golfOrderExceptionVo.getFee()+"&&price="+golfOrderExceptionVo.getPrice()+"&&createUser="+member.getCode()
						+"&&sts=4&&content="+golfOrderExceptionVo.getRmk()+"&&playerName="+playNameStr);
				
				 */
				ApiClient.getHtml("/api/apiServer.action?method=api_saveGolfOrderException&&id="+id+"&&rmk="+golfOrderExceptionVo.getRmk()
						+"&&type="+golfOrderExceptionVo.getType()
						+"&&createUser="+session.getAttribute("createUser").toString()
						+"&&memberCode="+session.getAttribute("createUser").toString()
						+"&&sts=4&&content="+"申请退场"+"&&playerIds="+playerIdStr);
				
				
				
			}else if(applyflag.equals("0")) {//如果是改期,则将改期时间及id提交到后台。
				golfOrderExceptionVo.setType("M");
				/*
				GolfOrderExceptionVo golfOrderExceptionVo=new GolfOrderExceptionVo();
				golfOrderExceptionVo.setOrderId("1111");
				golfOrderExceptionVo.setRmk("就是想退");
				golfOrderExceptionVo.setType("8");
				golfOrderExceptionVo.setFeeRate(9L);
				golfOrderExceptionVo.setFee(95L);
				golfOrderExceptionVo.setPrice(999L);
				golfOrderExceptionVo.setCreateUser("胡锦涛");
				String golfOrderSts="1";
				String logGolfOrderContent="laksdfjlaksjdflsajkf";
				*/
//				ApiClient client=new ApiClient();//得到API客户端。
				ApiClient.getHtml("/api/apiServer.action?method=api_saveGolfOrderException&&id="+id+"&&rmk=改期"
						+"&&type="+golfOrderExceptionVo.getType()
						+"&&createUser="+session.getAttribute("createUser").toString()
						+"&&memberCode="+session.getAttribute("createUser").toString()
						+"&&sts=7&&content=申请改期"+"&&playerIds="+playerIdStr+"&&bookTime="+updateTime);
				}
		}catch (Exception e) {
			log.error("退改失败");
			return "redirectView";
		}
		return "redirectView";//订单操作结束以后需要重定向到订单详情页面。
	}

	//getter setter.....
	
	public GolfOrderVo getGolfOrderVo() {
		return golfOrderVo;
	}
	
	public void setGolfOrderVo(GolfOrderVo golfOrderVo) {
		this.golfOrderVo = golfOrderVo;
	}

	public GolfOrderService getGolfOrderService() {
		return golfOrderService;
	}

	public void setGolfOrderService(GolfOrderService golfOrderService) {
		this.golfOrderService = golfOrderService;
	}

	
	public String getApplyflag() {
		return applyflag;
	}

	public void setApplyflag(String applyflag) {
		this.applyflag = applyflag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRmk() {
		return rmk;
	}

	
	public Boolean getIsShowRM() {
		return isShowRM;
	}

//	public void setIsShowRM(Boolean isShowRM) {
//		this.isShowRM = isShowRM;
//	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<GolfOrderVo> getData() {
		return data;
	}

	public void setData(List<GolfOrderVo> data) {
		this.data = data;
	}

	public String getPaySts() {
		return paySts;
	}

	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}

	public GolfOrderExceptionVo getGolfOrderExceptionVo() {
		return golfOrderExceptionVo;
	}

	public void setGolfOrderExceptionVo(GolfOrderExceptionVo golfOrderExceptionVo) {
		this.golfOrderExceptionVo = golfOrderExceptionVo;
	}

	public String getGolfOrderSts() {
		return golfOrderSts;
	}

	public void setGolfOrderSts(String golfOrderSts) {
		this.golfOrderSts = golfOrderSts;
	}

	public String getLogGolfOrderContent() {
		return logGolfOrderContent;
	}

	public void setLogGolfOrderContent(String logGolfOrderContent) {
		this.logGolfOrderContent = logGolfOrderContent;
	}

	public BaseUser getBaseUser() {
		return baseUser;
	}

	public void setBaseUser(BaseUser baseUser) {
		this.baseUser = baseUser;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public GolfSiteVo getGolfSiteVo() {
		return golfSiteVo;
	}

	public void setGolfSiteVo(GolfSiteVo golfSiteVo) {
		this.golfSiteVo = golfSiteVo;
	}

	public GolfInfoVo getGolfInfoVo() {
		return golfInfoVo;
	}

	public void setGolfInfoVo(GolfInfoVo golfInfoVo) {
		this.golfInfoVo = golfInfoVo;
	}

	public GolfPriceVo getGolfPriceVo() {
		return golfPriceVo;
	}

	public void setGolfPriceVo(GolfPriceVo golfPriceVo) {
		this.golfPriceVo = golfPriceVo;
	}

	public List<GolfOrderLogVo> getGolfOrderLogVoList() {
		return golfOrderLogVoList;
	}

	public void setGolfOrderLogVoList(List<GolfOrderLogVo> golfOrderLogVoList) {
		this.golfOrderLogVoList = golfOrderLogVoList;
	}

	public List<GolfOrderPlayVo> getGolfOrderPlayVoList() {
		return golfOrderPlayVoList;
	}

	public void setGolfOrderPlayVoList(List<GolfOrderPlayVo> golfOrderPlayVoList) {
		this.golfOrderPlayVoList = golfOrderPlayVoList;
	}

	public OrderContactVo getOrderContactVo() {
		return orderContactVo;
	}

	public void setOrderContactVo(OrderContactVo orderContactVo) {
		this.orderContactVo = orderContactVo;
	}

	public IMemberInfoService getMemberInfoServ() {
		return memberInfoServ;
	}

	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}


	public String[] getPlayerIds() {
		return playerIds;
	}

	public void setPlayerIds(String[] playerIds) {
		this.playerIds = playerIds;
	}

	public List<GolfOrderExceptionVo> getGolfOrderExceptionList() {
		return golfOrderExceptionList;
	}

	public void setGolfOrderExceptionList(
			List<GolfOrderExceptionVo> golfOrderExceptionList) {
		this.golfOrderExceptionList = golfOrderExceptionList;
	}

	public static Log getLog() {
		return log;
	}

//	@Override
//	public String add() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String del() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String modify() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String toAdd() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String toModify() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String toSearch() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String toView() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
