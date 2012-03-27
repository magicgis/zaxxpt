package com.hnatourism.club.lounge.prod.action;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.service.ICustomerProfitService;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.golf.prod.vo.LoginerVo;
import com.hnatourism.club.hotel.prod.web.vo.HotelReturnMessage;
import com.hnatourism.club.hotel.prod.web.vo.Passenger;
import com.hnatourism.club.hotel.prod.web.vo.Result;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberPassengerVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室订单表
 * 
 * 历史版本:2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderLoungeAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(OrderLoungeAction.class);
	
	private String airportName;
	private String rmk;
  	private LoginerVo loginer;//登录者VO
	private LoungeRoomVo bookRoom;//房间VO
  	private String passengerName;//顾客姓名集合
  	private String passengerairline;//顾客航班集合
  	private String pginfo;//顾客类型和航班编号
  	private Double amountPrice;//总金额
  	private String signingPrice;
  	private String bookstarttime;//预订开始时间
  	private String bookendtime;//预订结束时间，贵宾间才有
  	private String roomid;//房间ID
	private String bookTime;//休息室预订时间
	private String bookTime_show;//休息室预订时间，全显示
	private String loginerName;//联系人姓名
	private String loginerContact;//联系人联系方式
	private String loginerEmail;//联系人邮箱
	private String orderId;//订单ID
	private String additionalItemId;//单收费项目ID集合
	private Long people;//人数
	private String way;//包含项目为N的支付方式
	private String additionalway;//单收费项目支付方式集合
	private String additionalsprice;//单收费项目签约价
	private MemberInfoVo member;
	private String orderCode;
	private String flightNo;
	private String roomType;
	private int sts;
	private Double price_reg;
	private Double cprice_reg;
	private Double price;//成人价
	private Double childrenPrice;//儿童价
	private Double amountPrice_reg;
	private int orderSts;
	private String message;
	private IMemberInfoService memberInfoServ;
	private IMemberAccountService memberAccountServ;
	private ICustomerProfitService customerProfitServ;
	private IMemberRoleService memberRoleServ;
	private List<MemberPassengerVo> passengerlist;
	public List<MemberPassengerVo> getPassengerlist() {
		return passengerlist;
	}

	public void setPassengerlist(List<MemberPassengerVo> passengerlist) {
		this.passengerlist = passengerlist;
	}
	
	/**
	 * 2011-08-15 v1.1.0 (高杰) :
	 */
	@SuppressWarnings("static-access")
	public String add()
	{
		try
		{
			HttpSession session=this.getSession();
			MemberAccountVo memberAccount=null;
			MemberRoleVo memberRole=null;
			MemberInfoVo vo = UserUtil.getUser(getSession().getId());
			if(vo==null)
			{
				return "notlogin";
			}
			else
			{
				member=vo;
				memberAccount=member.getMemberAccount();
				memberRole=memberAccount.getMemberRole();
			}
			
			passengerName=passengerName.replace(", ",",");
			passengerName=passengerName.replace("/","_");
			passengerairline=passengerairline.replace(", ", ",");
			pginfo=pginfo.substring(1);

			//组建收费项的id和类型
			Map<String, String> additionalMap=new HashMap<String, String>();
			if(additionalway!=null)
			{
				String[] additionwaylist=additionalway.split(", ");
				for(int i=0;i<additionwaylist.length;i++)
				{
					String one_additionway=additionwaylist[i];
					String key=one_additionway.substring(0,one_additionway.indexOf('_'));
					String value=one_additionway.substring(one_additionway.indexOf('_')+1);
					additionalMap.put(key, value);
				}
			}
			//组建收费项的id和签约价
			Map<String, String> additionalSpriceMap=new HashMap<String, String>();
			if(additionalsprice!=null)
			{
				String[] additionspricelist=additionalsprice.split(", ");
				for(int i=0;i<additionspricelist.length;i++)
				{
					String one_additionsprice=additionspricelist[i];
					String key=one_additionsprice.substring(0,one_additionsprice.indexOf('_'));
					String value=one_additionsprice.substring(one_additionsprice.indexOf('_')+1);
					additionalSpriceMap.put(key, value);
				}
			}
			
			//根据支付方式，分别组建收费项目
			String idlist_order="";
			String idlist_people="";
			Double price_order=0d;
			Double price_people=0d;
			Double sprice_order=0d;
			Double sprice_people=0d;
			if(additionalItemId!=null)
			{
				String[] idfeelist=additionalItemId.split(", ");
				for(int i=0;i<idfeelist.length;i++)
				{
					String one_idfee=idfeelist[i];
					int pos=one_idfee.indexOf('_');
					String additionId=one_idfee.substring(0,pos);
					
					//计算支付附加费总价和签约总价
					if(additionalMap.get(additionId)!=null&&additionalSpriceMap.get(additionId)!=null)
					{
						if(additionalMap.get(additionId).equalsIgnoreCase("1"))
						{
							sprice_order+=Double.parseDouble(additionalSpriceMap.get(additionId).toString());
							price_order+=Double.parseDouble(one_idfee.substring(pos+1));
							idlist_order=idlist_order+","+additionId;
						}
						else
						{
							sprice_people+=Double.parseDouble(additionalSpriceMap.get(additionId).toString())*people;
							price_people=price_people+Double.parseDouble(one_idfee.substring(pos+1))*people;
							idlist_people=idlist_people+","+additionId;
						}
					}
				}
				
				price_order=price_order+price_people;
				
				idlist_order=idlist_order.equalsIgnoreCase("")?"":idlist_order.substring(1);
				idlist_people=idlist_people.equalsIgnoreCase("")?"":idlist_people.substring(1);
				if(idlist_order.equalsIgnoreCase("")&&!idlist_people.equalsIgnoreCase(""))
				{
					idlist_order=idlist_people;
				}
				else if(!idlist_order.equalsIgnoreCase("")&&!idlist_people.equalsIgnoreCase(""))
				{
					idlist_order=idlist_order+","+idlist_people;
				}
			}
			
			ApiClient client=new ApiClient();
			Gson gson = new Gson();
			Type lounge_type = new TypeToken<OrderLoungeVo>(){}.getType();

			//计算分润
			double amountPrice_temp=amountPrice-price_order;//非单收费总价格
			double amountPrice_reg_temp=amountPrice_reg-price_order;//非单收费原始总价格
			Double profitAmount=amountPrice_reg_temp-amountPrice_temp;
			String privilegeType="1";
			if(memberAccount.getPrivilegeType()!=null&&memberAccount.getPrivilegeType().equalsIgnoreCase("return"))
			{
				privilegeType="2";
			}
			if(!privilegeType.equalsIgnoreCase("1"))
			{
				SubRunBean subRunBean=new SubRunBean();
				subRunBean.setProdSignprice(Double.parseDouble(signingPrice));
				subRunBean.setProdType("L");
				subRunBean.setRoleCode(memberRole.getCode());
				
				if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
				{
					Map<String, String> rule_result=RuleConfigProfit.setRuleParam("GF", member.getRuleConfigList(), memberAccount.getOrganizationId());
					subRunBean.setSubCorpPoint(Double.parseDouble(rule_result.get("subCorpPoint")));
					subRunBean.setPlatformPoint(Double.parseDouble(rule_result.get("platformPoint")));
					subRunBean.setProfitpoint(rule_result.get("profitpoint"));
					subRunBean.setMemberFlowpoint(rule_result.get("memberFlowpoint"));
				}
				//贵宾间处理   谷建亮添加
				if(roomType.equalsIgnoreCase("1")){
					SimpleDateFormat sf=new SimpleDateFormat("HH:mm");
					long between=(sf.parse(bookendtime).getTime()-sf.parse(bookstarttime).getTime())/1000;//除以1000是为了转换成秒
					long hour=between/(60*60);
					//System.out.println(hour);
					subRunBean.setProdSalePrice(amountPrice_temp/hour);
					//System.out.println(subRunBean.getProdSalePrice());
					profitAmount=(amountPrice_temp/hour-SubRunUtils.getProdPrice(subRunBean))*hour;
				}else{
					subRunBean.setProdSalePrice(amountPrice_temp/people);
					profitAmount=(amountPrice_temp/people-SubRunUtils.getProdPrice(subRunBean))*people;
				}
			}
			
			String source_temp=session.getAttribute("source")!=null?session.getAttribute("source").toString():"51666";
			String createUser_temp=session.getAttribute("createUser")!=null?session.getAttribute("createUser").toString():"";
			
			if(roomType.equalsIgnoreCase("3"))
			{
				sts=1;//现在暂时没有会员确认.这个状态. 所以要先变成待客服确认
			}
			else
			{
				sts=1;
			}
			
			String paremstr="&&sts="+sts+"&&createUser="+createUser_temp+"&&source="+source_temp+"&&flightNo="+flightNo
			+"&&profit="+privilegeType+"&&signPrice="+signingPrice+"&&profitAmount="+profitAmount+"&&price_people="+price_people
			+"&&price_order="+price_order+"&&idlist_people="+idlist_people+"&&idlist_order="+idlist_order+"&&way="+way
			+"&&roomId="+roomid+"&&starttime="+bookstarttime+"&&endtime="+bookendtime+"&&loginerName="+loginerName
			+"&&loginerContact="+loginerContact+"&&loginerEmail="+loginerEmail+"&&price="+amountPrice+"&&bookTime="+bookTime
			+"&&pginfo="+pginfo+"&&passengerairline="+passengerairline+"&&passengerName="+passengerName+"&&count="+people
			+"&&memberCode="+member.getCode()+"&&memberId="+member.getId()+"&&sprice_order="+sprice_order
			+"&&sprice_people="+sprice_people+"&&roomType="+roomType+"&&childrenPrice="+childrenPrice+"&&auPrice="+price;//添加成人价格和儿童价格

			OrderLoungeVo order=(OrderLoungeVo)gson.fromJson(client.getHtml("/api/apiServer.action?method=saveOrderLounge"+paremstr),lounge_type);
			orderId=order.getId();
			orderCode=order.getCode();
			
			//获得机场
			this.getSession().setAttribute("airportName", airportName);
			this.getSession().setAttribute("bookTime", bookTime);
			this.getSession().setAttribute("bookstarttime", bookstarttime);
			this.getSession().setAttribute("passengerName", passengerName);
			this.getSession().setAttribute("rmk", rmk);
			this.getSession().setAttribute("roomType", roomType);
			message="success";
			//将两舱改为在预定是支付分润
			if(roomType.equalsIgnoreCase("3")&&orderId!=null)
			{
				//支付分润一定的要
				         message = ApiClient.getHtml("/api/apiServer.action?method=verifyLoungeOrder&&id="
						+ orderId + "&&type=N"
						+"&&createUser="+session.getAttribute("createUser").toString()
						+"&&rolecode="+member.getMemberAccount().getMemberRole().getCode()
						+"&&memberCode="+member.getCode());
				         
				        session.setAttribute("payMessage", message.replace("\"", ""));
				        this.setMessage(message.replace("\"", ""));
				        //message= message.substring(0,6);
				        
			}
			
		}
		catch(Exception e){
			this.setMessage("预定失败!");
			orderId="";
			orderCode="";
			amountPrice=0d;
			message="error";
			e.printStackTrace();
				return "success";
		}
		finally
		{
			additionalItemId=null;
		}
		return "success";
	}
	
	/**
	 * 2011-08-15 v1.1.0 (高杰) :
	 */
	public String toAdd()
	{
		try
		 {
			HttpSession session=this.getSession();
			MemberRoleVo memberRole=null;
			MemberAccountVo memberAccount=null;
			MemberInfoVo vo = UserUtil.getUser(getSession().getId());
			if(vo==null)
			{
				//session.setAttribute("backlink", "loungebook");
				return "notlogin";
			}
			else
			{
				member=vo;
				memberAccount=member.getMemberAccount();
				memberRole=memberAccount.getMemberRole();
			}
			
			
			
			//常旅客 查询改为查询c站数据库  调用接口
			ApiClient client1 = new ApiClient();
			//调接口返回数据 字符串
			String api_server_xhlx=Constants.API_SERVER_XHLX;
			String returnStr = client1.getHtml(api_server_xhlx+"/web/phone/prod/flight/memberPassengerSearch.jsp?memberId="+member.getId());
//			String returnStr = client1.getHtml("http://210.51.165.170:9180/web/phone/prod/flight/memberPassengerSearch.jsp?memberId="+member.getId());
			//log.info("url:"+api_server_xhlx+"/web/phone/prod/flight/memberPassengerSearch.jsp?memberId="+member.getId());
			//获取 HotelReturnMessage类型
			Type type_hotel = new TypeToken<HotelReturnMessage>(){}.getType();
			//将字符串转换成对象
			HotelReturnMessage hotelReturnMessage = null ;
			try{
				hotelReturnMessage = (HotelReturnMessage) GsonUtil.jsonToObject(returnStr, type_hotel);
			}catch(Exception e){
				hotelReturnMessage = new HotelReturnMessage();
				Result result = new Result();
				result.setResultCode("NULL");
				hotelReturnMessage.setResult(result);
				log.error("网络异常,返回结果错误：",e);
			}
			
			//判断是否获取成功
			if(hotelReturnMessage.getResult().getResultCode() == null ||
					hotelReturnMessage.getResult().getResultCode().equals("")){
				//成功   获取常用旅客list
				passengerlist = new ArrayList<MemberPassengerVo>();
				List<Passenger> list = hotelReturnMessage.getPassenger();
				for( Passenger temp: list){
					MemberPassengerVo vo1 = new MemberPassengerVo();
					vo1.setId(temp.getId());
					vo1.setName(temp.getName());
					vo1.setType(temp.getType());
					vo1.setCertNo(temp.getCertNo());
					vo1.setCertType(temp.getCertType());
					//增加到list
					passengerlist.add(vo1);
				}
			}
			
			
			
			String subCorpPoint="";//分公司分点
			String platformPoint="";//平台分点
			String profitpoint="";//平台和分公司分点    ALL为全分
			String memberFlowpoint="";//会员享受最低点    ALL为全分
			if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
			{
				Map<String, String> rule_result=RuleConfigProfit.setRuleParam("GF", member.getRuleConfigList(), memberAccount.getOrganizationId());
				subCorpPoint=rule_result.get("subCorpPoint");
				platformPoint=rule_result.get("platformPoint");
				profitpoint=rule_result.get("profitpoint");
				memberFlowpoint=rule_result.get("memberFlowpoint");
			}
			
			ApiClient client=new ApiClient();
			Type type_room = new TypeToken<LoungeRoomVo>(){}.getType();
			bookRoom=(LoungeRoomVo)GsonUtil.jsonToObject(client.getHtml("/api/apiServer.action?method=findLoungeRoomById&&memberFlowpoint="+memberFlowpoint+"&&profitpoint="+profitpoint+"&&platformPoint="+platformPoint+"&&subCorpPoint="+subCorpPoint+"&&id="+roomid+"&&bookTime="+bookTime+"&&rolecode="+memberRole.getCode()+"&&privilegetype="+memberAccount.getPrivilegeType()), type_room);
			 
			
			
//-----------------------------------------------------------------------------------begin:			
			//查询当日的,直接根据当前时间进行判断.该提前时间限制是后台维护的
			//在前台限制：预订当日的贵宾厅,必须提前1小时.当日贵宾间必须提前4小时.
			List<String> workTimeList = bookRoom.getWorkTimeList();
			String toDay=DateUtils.getCurrentDateStr();//返回当前日期的yyyy-MM-dd
			Integer advanceHours = bookRoom.getAdvanceHours();
			
			if(toDay.equals(bookTime) && advanceHours!=null && advanceHours>0){//如果预定时间等于当天时间。---------暂停测试（要还原）
					for(int i=0;workTimeList!=null&&i<workTimeList.size();i++){
						String time=workTimeList.get(i);
						if(time.trim().length()==4){
							time="0"+time;
						}
						
						//拿到当天时减预定时间的小时。
						double hours=0;
						if(time!=null && time.length()==5){
							String myBookTime=bookTime+" "+time;
							//用当天所有的时间去减当前时间
//							hours = DateUtils.getIntervalHours(DateUtils.String2Date("2011-12-01 19:00","yyyy-MM-dd HH:mm"), DateUtils.String2Date(myBookTime,"yyyy-MM-dd HH:mm"));
							hours = DateUtils.getIntervalHours(DateUtils.getCurrentDate(), DateUtils.String2Date(myBookTime,"yyyy-MM-dd HH:mm"));//--------暂停测试（要还原）
						//如果说    拿到当天时减预定时间的小时     小于	 预定的时间，就不能显示。就把里面的list中的值直接删除掉。
						}
						if(hours<=advanceHours){//如果不是提前几个小时完成，就删掉。
							bookRoom.getWorkTimeStatusList().set(i, "1");//就让那一项置灰。
//							bookRoom.getWorkTimeList().remove(oldTime);
						}
						
					}
			} else if(toDay.equals(bookTime) && advanceHours!=null && advanceHours==0){  //当前日期并且提前预定小时不限
				for(int i=0;workTimeList!=null&&i<workTimeList.size();i++){
					String time=workTimeList.get(i);
					int hours=Integer.parseInt(time.substring(0,2).replaceAll(":",""));
					Calendar c=Calendar.getInstance();  
					int currentHours=c.get(Calendar.HOUR_OF_DAY)+1;  //当前时间的下一个小时
					if(hours<currentHours){//如果比当前时间小 就置灰。
						bookRoom.getWorkTimeStatusList().set(i, "1");//就让那一项置灰。
//						bookRoom.getWorkTimeList().remove(oldTime);
					}
					
				}
			}
//-----------------------------------------------------------------------------------end:			
			
			
			
			
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(bookTime));
			bookTime_show=new SimpleDateFormat("yyyy年MM月dd日").format(calendar.getTime());
			switch(calendar.get(Calendar.DAY_OF_WEEK)-1)
			{
				case 0:
					bookTime_show=bookTime_show+" 星期日";
					break;
				case 1:
					bookTime_show=bookTime_show+" 星期一";
					break;
				case 2:
					bookTime_show=bookTime_show+" 星期二";
					break;
				case 3:
					bookTime_show=bookTime_show+" 星期三";
					break;
				case 4:
					bookTime_show=bookTime_show+" 星期四";
					break;
				case 5:
					bookTime_show=bookTime_show+" 星期五";
					break;
				case 6:
					bookTime_show=bookTime_show+" 星期六";
					break;
			}
		 }
		 catch(Exception e)
		 {
			 log.error("",e);
			 e.printStackTrace();
			 return "success";
		 }
		 return "success";
	}

	public String getBookstarttime() {
		return bookstarttime;
	}
	public void setBookstarttime(String bookstarttime) {
		this.bookstarttime = bookstarttime;
	}
	public String getBookendtime() {
		return bookendtime;
	}
	public void setBookendtime(String bookendtime) {
		this.bookendtime = bookendtime;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public LoginerVo getLoginer() {
		return loginer;
	}
	public void setLoginer(LoginerVo loginer) {
		this.loginer = loginer;
	}
	public LoungeRoomVo getBookRoom() {
		return bookRoom;
	}
	public void setBookRoom(LoungeRoomVo bookRoom) {
		this.bookRoom = bookRoom;
	}
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
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
	public String getBookTime_show() {
		return bookTime_show;
	}
	public void setBookTime_show(String bookTimeShow) {
		bookTime_show = bookTimeShow;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerairline() {
		return passengerairline;
	}
	public void setPassengerairline(String passengerairline) {
		this.passengerairline = passengerairline;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPginfo() {
		return pginfo;
	}
	public void setPginfo(String pginfo) {
		this.pginfo = pginfo;
	}
	public String getAdditionalItemId() {
		return additionalItemId;
	}
	public void setAdditionalItemId(String additionalItemId) {
		this.additionalItemId = additionalItemId;
	}
	public Long getPeople() {
		return people;
	}
	public void setPeople(Long people) {
		this.people = people;
	}
	

	@Override
	public String del() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toModify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toView() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getAdditionalway() {
		return additionalway;
	}

	public void setAdditionalway(String additionalway) {
		this.additionalway = additionalway;
	}

	public Double getAmountPrice() {
		return amountPrice;
	}

	public void setAmountPrice(Double amountPrice) {
		this.amountPrice = amountPrice;
	}

	public String getSigningPrice() {
		return signingPrice;
	}

	public void setSigningPrice(String signingPrice) {
		this.signingPrice = signingPrice;
	}

	public IMemberInfoService getMemberInfoServ() {
		return memberInfoServ;
	}

	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}

	public IMemberAccountService getMemberAccountServ() {
		return memberAccountServ;
	}

	public void setMemberAccountServ(IMemberAccountService memberAccountServ) {
		this.memberAccountServ = memberAccountServ;
	}

	public MemberInfoVo getMember() {
		return member;
	}

	public void setMember(MemberInfoVo member) {
		this.member = member;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}


	public void setCustomerProfitServ(ICustomerProfitService customerProfitServ) {
		this.customerProfitServ = customerProfitServ;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getSts() {
		return sts;
	}

	public void setSts(int sts) {
		this.sts = sts;
	}

	public Double getPrice_reg() {
		return price_reg;
	}

	public void setPrice_reg(Double priceReg) {
		price_reg = priceReg;
	}

	public Double getCprice_reg() {
		return cprice_reg;
	}

	public void setCprice_reg(Double cpriceReg) {
		cprice_reg = cpriceReg;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getChildrenPrice() {
		return childrenPrice;
	}

	public void setChildrenPrice(Double childrenPrice) {
		this.childrenPrice = childrenPrice;
	}

	public Double getAmountPrice_reg() {
		return amountPrice_reg;
	}

	public void setAmountPrice_reg(Double amountPriceReg) {
		amountPrice_reg = amountPriceReg;
	}

	public IMemberRoleService getMemberRoleServ() {
		return memberRoleServ;
	}

	public void setMemberRoleServ(IMemberRoleService memberRoleServ) {
		this.memberRoleServ = memberRoleServ;
	}

	public String getAdditionalsprice() {
		return additionalsprice;
	}

	public void setAdditionalsprice(String additionalsprice) {
		this.additionalsprice = additionalsprice;
	}


	public int getOrderSts() {
		return orderSts;
	}


	public void setOrderSts(int orderSts) {
		this.orderSts = orderSts;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getAirportName() {
		return airportName;
	}


	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}


	public String getRmk() {
		return rmk;
	}


	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	
}