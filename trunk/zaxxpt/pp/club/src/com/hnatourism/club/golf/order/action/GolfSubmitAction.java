package com.hnatourism.club.golf.order.action;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.service.ICustomerProfitService;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.order.service.IOrderGolfSubRunService;
import com.hnatourism.club.golf.order.vo.GolfOrderLogVo;
import com.hnatourism.club.golf.order.vo.GolfOrderPlayVo;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.golf.order.vo.OrderContactVo;
import com.hnatourism.club.golf.prod.service.IGolfConfirmService;
import com.hnatourism.club.golf.prod.service.IGolfProdViewService;
import com.hnatourism.club.golf.prod.service.impl.GolfProdViewServiceImpl;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.club.pay.PayVo;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.framework.web.action.BaseAction;
import com.sun.jimi.core.vmem.PageMapper;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:提交高尔夫订单
 * 
 * 历史版本: ${2011.8.4} v1.0.0 (${高杰}) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class GolfSubmitAction extends BaseAction
{
	private static final long serialVersionUID = 3015241973896871170L;
	
	private String golfId;
	private String siteId;
	private long count;
	private String time;
	private String playerName;
	private String loginer;
	private long totalBall;
	private String golfType;
	private Double price;
	private Double amountPrice;
	private String orderId;
	private String playTime;
	private String loginerName;
	private String loginerContact;
	private String loginerEmail;
	private long ballamount;
	private String priceid;
	private String orderCode;
	private String memberId;
	private Double signPrice;
	private int sts;
	private double price_reg;
	private static String message="";
	private String payMessage;
	private String amount;
	private String action;
	private int  orderSts;//订单状态
	private IGolfConfirmService golfConfirmServ;
	private IMemberInfoService memberInfoService;
	private IMemberAccountService memberAccountService;
	private ICustomerProfitService CustomerProfitServiceImpl;
	private IMemberRoleService memberRoleService;
	private IOrderGolfSubRunService orderGolfSubRunService;
	
	private GolfInfoVo golfinfovo;//详细信息
	
	private IGolfProdViewService golfProdViewServ = new GolfProdViewServiceImpl();
	public void setGolfProdViewServ(IGolfProdViewService golfProdViewServ) {
		this.golfProdViewServ = golfProdViewServ;
	}
	/**
	 * 提交订单
	 * @return
	 */
	public String submitBook()
	{
		message=null;
		try
		{
			//如果预订球数超过库存，则返回预订页面
			if(!showPriceById())
			{
				return "overflow";
			}
			
			//取得客户信息
			HttpSession session=getSession();
			MemberInfoVo member=UserUtil.getUser(getSession().getId());
			MemberAccountVo memberAccount=null;
			MemberRoleVo memberRole=null;
			if(member==null)
			{
				return "notlogin";
			}
			else
			{
				memberAccount=member.getMemberAccount();
				memberRole=memberAccount.getMemberRole();
			}
			
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd/HH:mm");
			
			GolfOrderVo order=new GolfOrderVo();
			if(time==null||time.equalsIgnoreCase(""))
			{
				order.setBookTime(sdf.parse(sdf.format(date)));
			}
			else
			{
				order.setBookTime(sdf.parse(time+"/"+playTime));
			}
			order.setSiteId(siteId);
			order.setMemberCode(member.getCode());
			order.setId(SnoGerUtil.getUUID());
			order.setCount(count);
			order.setCode(SnoGerUtil.getOrderNo());
			
			Long amountL=Long.valueOf(ballamount)-Long.valueOf(totalBall);
			amount = amountL.toString();//总球数
			double amountPrice_should=0d;
			String confirmTime="&&confirmTime=";
			
			confirmTime=confirmTime+sdf.format(order.getBookTime());
			
			// 操作日志
			GolfOrderLogVo log=new GolfOrderLogVo();
			if(golfType.equalsIgnoreCase("1")){//张晓春修改.
				 
				// 练习场 预订成功
				log.setContent(Constants.OrderLogInfo.ORDER_SUCCESS);
				
				sts=1;//待客服确认
				order.setTotalBall(totalBall);
				order.setPrice(totalBall*price*100);
				amountPrice_should=totalBall*price_reg*100;
				ballamount=ballamount-totalBall;
			}
			else
			{
				// 球场  提交预订
				log.setContent(Constants.OrderLogInfo.ORDER_BOOK);
				
				order.setTotalBall(0l);
				order.setPrice(count*price);
				amountPrice_should=count*price_reg;
				sts=1;
			}
			
			order.setAdditionalFee(0d);
			order.setAmountPrice(order.getAdditionalFee()+order.getPrice());
			
			//测试-------------------------------------------------------
			GolfOrderPlayVo player=new GolfOrderPlayVo();
			player.setName(playerName.replace(", ", ","));
			player.setName(playerName.replace("/", "_"));
			
			// 联系人
			OrderContactVo contact=new OrderContactVo();
			contact.setName(loginerName);
			contact.setEmail(loginerEmail);
			contact.setMobile(loginerContact);
			
			//计算分润
			double profitAmount=amountPrice_should-order.getPrice();
			String privilegeType="1";
			if(memberAccount.getPrivilegeType()!=null&&memberAccount.getPrivilegeType().equalsIgnoreCase("return"))
			{
				privilegeType="2";
			}
			if(!privilegeType.equalsIgnoreCase("1"))
			{
				SubRunBean subRunBean=new SubRunBean();
				subRunBean.setProdSignprice(signPrice);
				//subRunBean.setProdSalePrice(order.getPrice());  谷建亮修改  解决返积分错误
				subRunBean.setProdSalePrice(price);
				subRunBean.setProdType("GF");
				subRunBean.setRoleCode(memberRole.getCode());
				
				if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
				{
					Map<String, String> rule_result=RuleConfigProfit.setRuleParam("GF", member.getRuleConfigList(), memberAccount.getOrganizationId());
					subRunBean.setSubCorpPoint(Double.parseDouble(rule_result.get("subCorpPoint")));
					subRunBean.setPlatformPoint(Double.parseDouble(rule_result.get("platformPoint")));
					subRunBean.setProfitpoint(rule_result.get("profitpoint"));
					subRunBean.setMemberFlowpoint(rule_result.get("memberFlowpoint"));
				}
				if(golfType.equalsIgnoreCase("1"))
				{
					profitAmount=order.getPrice()-totalBall*100*SubRunUtils.getProdPrice(subRunBean);
				}
				else
				{
					profitAmount=order.getPrice()-count*SubRunUtils.getProdPrice(subRunBean);
				}
				
			}
			String source_temp=session.getAttribute("source")!=null?session.getAttribute("source").toString():Constants.CLUB_ORDER_SOURCE;
			String createUser_temp=session.getAttribute("createUser")!=null?session.getAttribute("createUser").toString():"";
			
			//插入测试-------------------------------------------------------
			ApiClient client=new ApiClient();//得到API客户端。
			String newOrderUrl=golfType.equalsIgnoreCase("1")?"Papi_saveGolfOrder":"api_saveGolfOrder";
			client.getHtml("/api/apiServer.action?method="+newOrderUrl+"&&sts="+sts
					+"&&source="+source_temp+"&&memberId="+member.getId()+"&&createUser="+createUser_temp
					+"&&signPrice="+signPrice+"&&profit="+privilegeType+"&&profitAmount="+profitAmount
					+"&&orderCode="+order.getCode()+"&&priceid="+priceid+"&&amount="+ballamount+"&&content="
					+log.getContent()+"&&id="+order.getId()+"&&playerName="+player.getName()+"&&totalBall="
					+order.getTotalBall()+"&&price="+order.getPrice()+"&&additionalFee="+order.getAdditionalFee()
					+"&&amountPrice="+order.getPrice()+"&&siteId="+order.getSiteId()+"&&memberCode="
					+order.getMemberCode()+"&&count="+order.getCount()+"&&bookTime="+sdf.format(order.getBookTime())
					+"&&contactName="+contact.getName()+"&&mobile="+contact.getMobile()+"&&email="+contact.getEmail()
					+"&&prodType=9&&golfType="+golfType);//通过集合类型根据传的id找出一个定单放到List的第0项中去。
			orderId=order.getId();
			orderCode=order.getCode();
			amountPrice=Double.parseDouble(String.valueOf(order.getPrice().floatValue()));
			
			try
			{
				//订单详细需要的球场信息golfId
				golfProdViewServ = new GolfProdViewServiceImpl();
				GolfInfoVo golfinfovo=golfProdViewServ.findById(golfId);
				this.getSession().setAttribute("name", golfinfovo.getName());
				this.getSession().setAttribute("playerName", playerName);
				this.getSession().setAttribute("city", golfinfovo.getCity());
				List<GolfSiteVo> list = golfinfovo.getGolfsitelist();
				for (GolfSiteVo golfSiteVo : list) {
					if(golfSiteVo.getId().equals(siteId)){
						//设置球场的场地的退改规则
						this.getSession().setAttribute("rmk", golfSiteVo.getRmk());
					}
				}
				this.getSession().setAttribute("time", time);
				this.getSession().setAttribute("playTime", playTime);
				
				if(golfType.equalsIgnoreCase("1")){
					//如果是练习场..预定的时候直接支付分润.
					PayVo payVo=orderGolfSubRunService.payAndSubRun(orderId,getSession().getAttribute("createUser").toString());
					if("success".equalsIgnoreCase(payVo.getRespCode())){
//						String mess=golfConfirmServ.updateOrder(orderId,priceid,amount,action,getSession().getAttribute("createUser").toString(),2);
//						if(mess!=null&&!"false".equalsIgnoreCase(mess)){
//							message="1";//支付成功
//						}else{
//							message="0";//支付失败
//						}	
						message="2";//支付成功
					}else{
						message="3";//支付失败
						payMessage=payVo.getErrMsg();
						session.setAttribute("payMessage", payMessage);
					}
				}else{
					message="1";//球场.提交成功
				}
			}
			catch(Exception e)
			{
				message="3";//支付失败
			}
		}
		catch (Exception e)
		{
			message="0";
			e.printStackTrace();
			orderId="";
			orderCode="";
			amountPrice=0d;
			return "success";
		} finally {
		}
		return "success";
	}

	private boolean showPriceById()
	{
		try
		{
			ApiClient client=new ApiClient();
			Type type_price = new TypeToken<GolfPriceVo>(){}.getType();
			String json=client.getHtml("/api/apiServer.action?method=api_findGolfPriceById&&id="+priceid);
			String str="\"amount\":";
			json=json.substring(json.indexOf(str)+str.length());
			json=json.substring(0,json.indexOf("}]"));
			ballamount=Long.parseLong(json);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(ballamount<totalBall)
		{
			return false;
		}
		return true;
	}
	
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getLoginer() {
		return loginer;
	}
	public void setLoginer(String loginer) {
		this.loginer = loginer;
	}
	public long getTotalBall() {
		return totalBall;
	}
	public void setTotalBall(long totalBall) {
		this.totalBall = totalBall;
	}
	public String getGolfType() {
		return golfType;
	}
	public void setGolfType(String golfType) {
		this.golfType = golfType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAmountPrice() {
		return amountPrice;
	}
	public void setAmountPrice(Double amountPrice) {
		this.amountPrice = amountPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getLoginerName() {
		return loginerName;
	}

	public void setLoginerName(String loginerName) {
		this.loginerName = loginerName;
	}

	public String getLoginerContact() {
		return loginerContact;
	}

	public void setLoginerContact(String loginerContact) {
		this.loginerContact = loginerContact;
	}

	public String getLoginerEmail() {
		return loginerEmail;
	}

	public void setLoginerEmail(String loginerEmail) {
		this.loginerEmail = loginerEmail;
	}

	public long getBallamount() {
		return ballamount;
	}

	public void setBallamount(long ballamount) {
		this.ballamount = ballamount;
	}

	public String getPriceid() {
		return priceid;
	}

	public void setPriceid(String priceid) {
		this.priceid = priceid;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public Double getSignPrice() {
		return signPrice;
	}


	public void setSignPrice(Double signPrice) {
		this.signPrice = signPrice;
	}


	public int getSts() {
		return sts;
	}


	public void setSts(int sts) {
		this.sts = sts;
	}


	public double getPrice_reg() {
		return price_reg;
	}


	public void setPrice_reg(double priceReg) {
		price_reg = priceReg;
	}


	public IMemberInfoService getMemberInfoService() {
		return memberInfoService;
	}


	public void setMemberInfoService(IMemberInfoService memberInfoService) {
		this.memberInfoService = memberInfoService;
	}


	public IMemberAccountService getMemberAccountService() {
		return memberAccountService;
	}


	public void setMemberAccountService(IMemberAccountService memberAccountService) {
		this.memberAccountService = memberAccountService;
	}


	public ICustomerProfitService getCustomerProfitServiceImpl() {
		return CustomerProfitServiceImpl;
	}


	public void setCustomerProfitServiceImpl(
			ICustomerProfitService customerProfitServiceImpl) {
		CustomerProfitServiceImpl = customerProfitServiceImpl;
	}


	public IMemberRoleService getMemberRoleService() {
		return memberRoleService;
	}


	public void setMemberRoleService(IMemberRoleService memberRoleService) {
		this.memberRoleService = memberRoleService;
	}


	public IOrderGolfSubRunService getOrderGolfSubRunService() {
		return orderGolfSubRunService;
	}


	public void setOrderGolfSubRunService(
			IOrderGolfSubRunService orderGolfSubRunService) {
		this.orderGolfSubRunService = orderGolfSubRunService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public IGolfConfirmService getGolfConfirmServ() {
		return golfConfirmServ;
	}

	public void setGolfConfirmServ(IGolfConfirmService golfConfirmServ) {
		this.golfConfirmServ = golfConfirmServ;
	}

	public int getOrderSts() {
		return orderSts;
	}

	public void setOrderSts(int orderSts) {
		this.orderSts = orderSts;
	}
	public GolfInfoVo getGolfinfovo() {
		return golfinfovo;
	}
	public void setGolfinfovo(GolfInfoVo golfinfovo) {
		this.golfinfovo = golfinfovo;
	}
	public IGolfProdViewService getGolfProdViewServ() {
		return golfProdViewServ;
	}
	public String getGolfId() {
		return golfId;
	}
	public void setGolfId(String golfId) {
		this.golfId = golfId;
	}
	public String getPayMessage() {
		return payMessage;
	}
	public void setPayMessage(String payMessage) {
		this.payMessage = payMessage;
	}
	
}	
