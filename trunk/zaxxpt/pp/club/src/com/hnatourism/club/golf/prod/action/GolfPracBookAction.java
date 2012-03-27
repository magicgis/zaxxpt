package com.hnatourism.club.golf.prod.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.service.ICustomerProfitService;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.golf.prod.service.IGolfPracBookService;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.club.golf.prod.vo.GolfTimeMaintainVo;
import com.hnatourism.club.golf.prod.vo.SysHolidayVo;
import com.hnatourism.club.hotel.prod.web.vo.HotelReturnMessage;
import com.hnatourism.club.hotel.prod.web.vo.Passenger;
import com.hnatourism.club.hotel.prod.web.vo.Result;
import com.hnatourism.club.member.rule.dao.IRuleConfigDao;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberPassengerVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.framework.web.action.BaseAction;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转预订高尔夫练习场页面
 * 
 * 历史版本: ${2011.8.3} v1.0.0 (${高杰}) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class GolfPracBookAction extends BaseAction
{
	private static final long serialVersionUID = -2464043922722600510L;
	private static final Log log = LogFactory.getLog(GolfPracBookAction.class);
	private String golfId ;
	private GolfSiteVo golfBook;//高尔夫预订VO
	private Object loginer;//登录者VO
	private String time;//预订时间
	private String id;//高尔夫场地ID
	private String priceid;//当前价格ID
	private Long ballstore;//球的库存数
	private boolean isHoliday;//查询时间是否是节假日
	private MemberInfoVo member;
	private IMemberInfoService memberInfoService;
	private IMemberRoleService memberRoleService;

	private List<MemberPassengerVo> passengerlist;
	public List<MemberPassengerVo> getPassengerlist() {
		return passengerlist;
	}


	public void setPassengerlist(List<MemberPassengerVo> passengerlist) {
		this.passengerlist = passengerlist;
	}

	@Autowired
	private IGolfPracBookService golfPracBookServ;
	public void setGolfPracBookServ(IGolfPracBookService golfPracBookServ) {
		this.golfPracBookServ = golfPracBookServ;
	}

	private IRuleConfigDao RuleConfigDaoImpl;
	private IMemberAccountDao memberAccountDao;
	private ICustomerProfitService CustomerProfitServiceImpl;
	
	
	public String showGolfPracBook()
	{
		try
		{
			//取客户信息
			HttpSession session=this.getSession();
			MemberAccountVo memberAccount=null;
			MemberRoleVo memberRole=null;
			member =UserUtil.getUser(getSession().getId());
			if(member==null)
			{
				//session.setAttribute("backlink", "golfbook");
				return "notlogin";
			}
			else
			{
				memberAccount=member.getMemberAccount();
				memberRole=memberAccount.getMemberRole();
			}
			//常旅客 查询改为查询c站数据库  调用接口
			ApiClient client1 = new ApiClient();
			//调接口返回数据 字符串
			String serverIP = Constants.API_SERVER_XHLX;
			String returnStr = client1.getHtml(serverIP + "/web/phone/prod/flight/memberPassengerSearch.jsp?memberId="+member.getId());
			//log.info("url:"+serverIP + "/web/phone/prod/flight/memberPassengerSearch.jsp?memberId="+member.getId());
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
					MemberPassengerVo vo = new MemberPassengerVo();
					vo.setId(temp.getId());
					vo.setName(temp.getName());
					vo.setType(temp.getType());
					vo.setCertNo(temp.getCertNo());
					vo.setCertType(temp.getCertType());
					//增加到list
					passengerlist.add(vo);
				}
			}
			ApiClient client=new ApiClient();
			Type type_golf = new TypeToken<List<GolfSiteVo>>(){}.getType();
			Type type_holiday = new TypeToken<List<SysHolidayVo>>(){}.getType();

			Calendar calendar=Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time));
			
			//是否是节假日
			List<SysHolidayVo> holidaylist=(List<SysHolidayVo>)GsonUtil.jsonToObject(client.getHtml("/api/apiServer.action?method=api_findsysHolidayBydate&&date="+time), type_holiday);
			if(holidaylist==null||holidaylist.size()==0)
			{
				isHoliday=false;
			}
			else
			{
				isHoliday=true;
			}
			if(calendar.get(Calendar.DAY_OF_WEEK)==7||calendar.get(Calendar.DAY_OF_WEEK)==1)
			{
				isHoliday=true;
			}
			
			List<GolfSiteVo> golf=(List<GolfSiteVo>)GsonUtil.jsonToObject(client.getHtml("/api/apiServer.action?method=api_findGolfSiteById&&id="+id), type_golf);
			log.info("/api/apiServer.action?method=api_findGolfSiteById&&id="+id);
			golfBook=golf.get(0);
			golfBook.setBookTime(time);
			String thetime=new SimpleDateFormat("yyyy年MM月dd日").format(calendar.getTime());
			switch(calendar.get(Calendar.DAY_OF_WEEK)-1)
			{
				case 0:
					thetime=thetime+" 星期日";
					break;
				case 1:
					thetime=thetime+" 星期一";
					break;
				case 2:
					thetime=thetime+" 星期二";
					break;
				case 3:
					thetime=thetime+" 星期三";
					break;
				case 4:
					thetime=thetime+" 星期四";
					break;
				case 5:
					thetime=thetime+" 星期五";
					break;
				case 6:
					thetime=thetime+" 星期六";
					break;
			}
			golfBook.setBookTime_show(thetime);
			
			
			//判断时间是否可定
			if(golfBook.getStartTime()==null||golfBook.getStartTime().equalsIgnoreCase(""))
			{
				golfBook.setStartTime("8:00");
			}
			if(golfBook.getEndTime()==null||golfBook.getEndTime().equalsIgnoreCase(""))
			{
				golfBook.setEndTime("18:00");
			}
			
			int start=Integer.parseInt(golfBook.getStartTime().substring(0,golfBook.getStartTime().indexOf(":")));
			int end=Integer.parseInt(golfBook.getEndTime().substring(0,golfBook.getEndTime().indexOf(":")));
			List<String> worktimelist=new ArrayList<String>();
			List<String> worktimestatuslist=new ArrayList<String>();
			for(int x=start;x<=end;x++)
			{
				boolean x_is=false;
				if(golfBook.getMaintainList().size()>0)
				{
					for(int y=0;y<golfBook.getMaintainList().size();y++)
					{
						GolfTimeMaintainVo bookfix_temp=golfBook.getMaintainList().get(y);
						String yearmonthday_start=bookfix_temp.getStartTime().substring(0,bookfix_temp.getStartTime().indexOf(" "));
						String yearmonthday_end=bookfix_temp.getEndTime().substring(0,bookfix_temp.getEndTime().indexOf(" "));
						if(yearmonthday_start.compareTo(time)>0||yearmonthday_end.compareTo(time)<0)
						{	
							continue;
						}
						
						Calendar calendar_start=Calendar.getInstance();
						calendar_start.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(yearmonthday_start));
						Calendar calendar_end=Calendar.getInstance();
						calendar_end.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(yearmonthday_end));
						
						int startnum=0;
						int endnum=0;
						long start_book=(calendar.getTimeInMillis()-calendar_start.getTimeInMillis())/(1000*60*60);
						long end_book=(calendar_end.getTimeInMillis()-calendar.getTimeInMillis())/(1000*60*60);
						long start_end=(calendar_end.getTimeInMillis()-calendar_start.getTimeInMillis())/(1000*60*60);
						
						if(start_end==0)
						{
							String str_temp=bookfix_temp.getStartTime().substring(bookfix_temp.getStartTime().indexOf(" "));
							startnum=Integer.parseInt(str_temp.substring(1,str_temp.indexOf(":")));
							str_temp=bookfix_temp.getEndTime().substring(bookfix_temp.getStartTime().indexOf(" "));
							endnum=Integer.parseInt(str_temp.substring(1,str_temp.indexOf(":")));
						}
						else if(start_book==0)
						{
							String str_temp=bookfix_temp.getStartTime().substring(bookfix_temp.getStartTime().indexOf(" "));
							startnum=Integer.parseInt(str_temp.substring(1,str_temp.indexOf(":")));
							endnum=24;
						}
						else if(end_book==0)
						{
							String str_temp=bookfix_temp.getEndTime().substring(bookfix_temp.getStartTime().indexOf(" "));
							endnum=Integer.parseInt(str_temp.substring(1,str_temp.indexOf(":")));
						}
						else
						{
							endnum=24;
						}
						
						if(x>=startnum&&x<=endnum)
						{
							x_is=true;
							break;
						}
					}
				}
				
				if(x_is)
				{
					worktimestatuslist.add("1");
				}
				else
				{
					worktimestatuslist.add("0");
				}
				worktimelist.add(x+":00");
			}
			golfBook.setWorkTimeList(worktimelist);
			golfBook.setWorkTimeStatusList(worktimestatuslist);
			
			List<GolfPriceVo> priceshow=new ArrayList<GolfPriceVo>();
			Iterator<GolfPriceVo> price_i=golfBook.getPricelist().iterator();
			while(price_i.hasNext())
			{
				GolfPriceVo price=(GolfPriceVo)price_i.next();
				
				SubRunBean subRunBean=new SubRunBean();
				subRunBean.setProdSignprice(price.getSigningPrice());
				subRunBean.setRoleCode(memberRole.getCode());
				subRunBean.setProdType("GF");
				
				if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
				{
					Map<String, String> rule_result=RuleConfigProfit.setRuleParam("GF", member.getRuleConfigList(), memberAccount.getOrganizationId());
					subRunBean.setSubCorpPoint(Double.parseDouble(rule_result.get("subCorpPoint")));
					subRunBean.setPlatformPoint(Double.parseDouble(rule_result.get("platformPoint")));
					subRunBean.setProfitpoint(rule_result.get("profitpoint"));
					subRunBean.setMemberFlowpoint(rule_result.get("memberFlowpoint"));
				}
				
				if(golfBook.getType()==1)
				{
					price.setHPrice(price.getPrice());
					price.setHSigningprice(price.getSigningPrice());
				}
				
				price.setPrice_reg(price.getPrice());
				price.setHprice_reg(price.getHPrice());
				if(memberAccount.getPrivilegeType()==null||memberAccount.getPrivilegeType().equalsIgnoreCase("MINUS"))
				{
					subRunBean.setProdSalePrice(price.getPrice());
					price.setPrice(SubRunUtils.getProdPrice(subRunBean));
					subRunBean.setProdSalePrice(price.getHPrice());
					price.setHPrice(SubRunUtils.getProdPrice(subRunBean));
				}
				
				if(golfBook.getType()==0)
				{
					price.setPrice(Math.ceil(price.getPrice()));
					price.setHPrice(Math.ceil(price.getHPrice()));
				}
				
				priceshow.add(price);
			}
			golfBook.setPricelist(priceshow);
			
			
			
			//-----------------------------------------------------------------------------------begin:			
						//查询当日的,直接根据当前时间进行判断.该提前时间限制是后台维护的
						//在前台限制：预订当日的贵宾厅,必须提前1小时.当日贵宾间必须提前4小时.
						List<String> workTimeList = golfBook.getWorkTimeList();
						String toDay=DateUtils.getCurrentDateStr();//返回当前日期的yyyy-MM-dd
						//Integer advanceHours = 1;//bookRoom.getAdvanceHours();//暂时让它提前一个小时。***********《〈〈〈要改当前提前预定几天》》》》》
						Integer advanceHours = golfBook.getGolfPriceVo().getAdvanceTime();//暂时让它提前一个小时。***********《〈〈〈要改当前提前预定几天》》》》》
						
						if(toDay.equals(time) && advanceHours!=null && advanceHours>=0){//如果预定时间等于当天时间,且得到的小时数不为空，并且提前预定小时大于0或不限
								for(int i=0;workTimeList!=null&&i<workTimeList.size();i++){
									String myTime=workTimeList.get(i);
									if(myTime.trim().length()==4){
										myTime="0"+myTime;
									}
									
									//拿到当天时减预定时间的小时。
									double hours=0;
									if(myTime!=null && myTime.length()==5){
										String myBookTime=time+" "+myTime;
										//用当天所有的时间去减当前时间
//										hours = DateUtils.getIntervalHours(DateUtils.String2Date("2011-12-01 19:00","yyyy-MM-dd HH:mm"), DateUtils.String2Date(myBookTime,"yyyy-MM-dd HH:mm"));
										hours = DateUtils.getIntervalHours(DateUtils.getCurrentDate(), DateUtils.String2Date(myBookTime,"yyyy-MM-dd HH:mm"));//--------暂停测试（要还原）
									//如果说    拿到当天时减预定时间的小时     小于	 预定的时间，就不能显示。就把里面的list中的值直接删除掉。
									}
									if(hours<=advanceHours){//如果不是提前几个小时完成，就删掉。
										golfBook.getWorkTimeStatusList().set(i, "1");//就让那一项置灰。
//										bookRoom.getWorkTimeList().remove(oldTime);
									}
									
								}
						} else if(toDay.equals(time) && advanceHours==null){  //当天日期且小时数是空。
							
							for(int i=0;workTimeList!=null&&i<workTimeList.size();i++){
								String myTime=workTimeList.get(i);
								int hours=Integer.parseInt(myTime.substring(0,2).replaceAll(":",""));
								Calendar c=Calendar.getInstance();  
								int currentHours=c.get(Calendar.HOUR_OF_DAY)+1;  //当前时间的下一个小时
								if(hours<=currentHours){//如果比当前时间小 就置灰。
									golfBook.getWorkTimeStatusList().set(i, "1");//就让那一项置灰。
//									bookRoom.getWorkTimeList().remove(oldTime);
								}
								
							}
						}
			//-----------------------------------------------------------------------------------end:		
			
			
		}catch(JsonParseException e)
		{
			pageAlert("网络异常");
			log.error("网络异常,返回结果错误：",e);
			//e.printStackTrace();
			return "index";
		}catch(Exception e)
		{
			e.printStackTrace();
			return "index";
		}
		
		return "success";
	}
	
	/**
	 * 界面弹出信息
	 * @param msg
	 */
	public void pageAlert(String msg){
		HttpServletResponse response=this.getResponse();
        response.setContentType("text/html;charset=UTF-8");
         response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out;
		try {
			out = response.getWriter();
			out.print("<script>alert('"+msg+"')</script>");
		    //out.print("<script>window.location.href='"+directUrl+"'</script>");
		    out.flush();
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public GolfSiteVo getGolfBook() {
		return golfBook;
	}
	public void setGolfBook(GolfSiteVo golfBook) {
		this.golfBook = golfBook;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Object getLoginer() {
		return loginer;
	}
	public void setLoginer(Object loginer) {
		this.loginer = loginer;
	}


	public boolean getIsHoliday() {
		return isHoliday;
	}


	public void setIsHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}


	public MemberInfoVo getMember() {
		return member;
	}


	public void setMember(MemberInfoVo member) {
		this.member = member;
	}

	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}


	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
	}


	public IMemberInfoService getMemberInfoService() {
		return memberInfoService;
	}


	public void setMemberInfoService(IMemberInfoService memberInfoService) {
		this.memberInfoService = memberInfoService;
	}


	public IMemberRoleService getMemberRoleService() {
		return memberRoleService;
	}


	public void setMemberRoleService(IMemberRoleService memberRoleService) {
		this.memberRoleService = memberRoleService;
	}


	public IRuleConfigDao getRuleConfigDaoImpl() {
		return RuleConfigDaoImpl;
	}


	public void setRuleConfigDaoImpl(IRuleConfigDao ruleConfigDaoImpl) {
		RuleConfigDaoImpl = ruleConfigDaoImpl;
	}


	public ICustomerProfitService getCustomerProfitServiceImpl() {
		return CustomerProfitServiceImpl;
	}


	public void setCustomerProfitServiceImpl(
			ICustomerProfitService customerProfitServiceImpl) {
		CustomerProfitServiceImpl = customerProfitServiceImpl;
	}


	public String getPriceid() {
		return priceid;
	}


	public void setPriceid(String priceid) {
		this.priceid = priceid;
	}


	public Long getBallstore() {
		return ballstore;
	}


	public void setBallstore(Long ballstore) {
		this.ballstore = ballstore;
	}


	public String getGolfId() {
		return golfId;
	}


	public void setGolfId(String golfId) {
		this.golfId = golfId;
	}

}
