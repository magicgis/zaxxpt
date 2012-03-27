package com.hnatourism.club.lounge.prod.action;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.cache.FlightCache;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.lounge.prod.vo.LoungeInfoVo;
import com.hnatourism.club.lounge.prod.vo.LoungePriceVo;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;
import com.hnatourism.club.lounge.prod.vo.PageVo;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.StringUtils;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场休息室产品信息表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeInfoAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(LoungeInfoAction.class);
  	//休息室信息List
  	private List<LoungeInfoVo> loungelist;
  	//机场休息室
  	private LoungeInfoVo  loungeInfoVo;
	//休息室信息List
  	private List<LoungeRoomVo> roomlist;
  	//分页信息
  	private PageInfo pageInfo;
  	private MemberRoleVo memberRole;
  	
  	//机场休息室id
  	private String id;

	//机场
	private String airport;
	//休息室预订时间
	private String bookTime;
	//休息室名称
	private String loungeName;
	//休息室类型
	private String loungeType;
	//房间ID
	private String roomId;
	//机场名 用于回显
	private String departureAirport;
	
	//预订时间和当前时间的差值，以日为单位
	private long dateDiff;
	//前一天
	private String beforeOneTime;
	//后一天
	private String afterOneTime;
	//前天后天标志位。
	private String flagday;
	//带星期的日期
	private String theTime;
	private int page;
	private String cityorap;
	
	
	private IMemberInfoService memberInfoServ;
	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}
	private IMemberAccountService memberAccountServ;
	public void setMemberAccountServ(IMemberAccountService memberAccountServ) {
		this.memberAccountServ = memberAccountServ;
	}
	private IMemberRoleService memberRoleServ;
	public void setMemberRoleServ(IMemberRoleService memberRoleServ) {
		this.memberRoleServ = memberRoleServ;
	}
	public LoungeInfoVo getLoungeInfoVo() {
		return loungeInfoVo;
	}


	public void setLoungeInfoVo(LoungeInfoVo loungeInfoVo) {
		this.loungeInfoVo = loungeInfoVo;
	}
	
	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			//loungeInfoService.insert(loungeInfoVo);
		}
		catch(Exception e){
				log.error("",e);
		}
		return TO_SEARCH;
	}
	
  	/**
	 * 【删除】（系统生成方法）
	 */
	public String del(){
		try{
			//loungeInfoService.delete(loungeInfoVo.getId());
			//loungeInfoService.delete(loungeInfo);
		}
		catch(Exception e){
				log.error("",e);
		}
		return TO_SEARCH;
	}
	
	/**
	 * 【修改】（系统生成方法）
	 * @return
	 */
	public String modify()  {
		try{
			//loungeInfoService.update(loungeInfoVo);
		}
		catch(Exception e){
				log.error("",e);
		}
		return TO_SEARCH;
	}
	
	/***
	 * 匹配类对象中 的字段
	 * @param classs  类对象
	 * @param name    字段名称
	 * @return 字段对象
	 * @author wenz
	 */
	public Field matchField(Class classs,String name){
		Field[] fields=classs.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if(fields[i].getName().equals(name))
				return fields[i];
		}
		return null;
	}
	
	/***
	 * 匹配类对象中的方法
	 * @param classs  类对象
	 * @param name   方法名
	 * @return   方法对象
	 * @author wenz
	 */
	public Method matchMethod(Class classs,String name){
		Method[] methods=classs.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			if(methods[i].getName().equals(name))
				return methods[i];
		}
		return null;
	}
	
	/**
	 * 设置返回链接  并且获取当前的url以及url中的属性通过反射设置属性值
	 * @author wenz
	 */
	public void  backLink(){
		try {
			HttpSession session= this.getRequest().getSession();
			//获取已经保存的返回链接
			String backLink=session.getAttribute("backlink").toString();
			MemberInfoVo member=UserUtil.getUser(session.getId());
			if(null==member)
				session.setAttribute("isloungesearchlogin", "false");
			if(member!=null&&null!=session.getAttribute("isloungesearchlogin")){
				String isloungesearchlogin=session.getAttribute("isloungesearchlogin").toString();
				if("false".equals(isloungesearchlogin)){
					String backlinkurl=session.getAttribute("backlinkurl").toString();
					backlinkurl=backlinkurl.substring(backlinkurl.indexOf("?")+1);
					String[] param=backlinkurl.split("&");
					for (int i = 0; i < param.length; i++) 
					{
						String key=param[i].substring(0,param[i].indexOf("="));
						String value=param[i].substring(param[i].indexOf("=")+1);
						if(key.split(".").length>0)
						{
							String[] keys =key.split(".");
							Class<?>  classs=null;
							Object objInstance=null;
							for (int j = 0; j < keys.length; j++) 
							{
								if(keys.length>1)
								{
									if(i==0)
									{
										if("1".equals(keys[j])) continue;
										Field field=this.matchField(this.getClass(), keys[j]);
										if(null==field)continue;
										String methodName="set"+keys[j].substring(0,1).toUpperCase()+""+keys[j].substring(1);
										Method method=this.matchMethod(classs, methodName);
										objInstance=field.get(this);
										method.invoke(this, objInstance);
										classs=field.getType();
									}else{
										if("1".equals(keys[j])) continue;
										Field field=this.matchField(classs, keys[j]);
										if(null==field)continue;
										String methodName="set"+keys[j].substring(0,1).toUpperCase()+""+keys[j].substring(1);
										Method method=classs.getMethod(methodName, field.getType());
										Object obj=field.get(objInstance);
										method.invoke(objInstance, obj);
										classs=field.getType();
										objInstance=obj;
									}
								}
							}
						}else{
							if("1".equals(key)) continue;
							Field field=this.matchField(this.getClass(), key);
							if(null==field)continue;
							String methodName="set"+key.substring(0,1).toUpperCase()+""+key.substring(1);
							Method method=this.getClass().getMethod(methodName, field.getType());
							method.invoke(this, value);
						}
					}
				}
				session.setAttribute("isloungesearchlogin", "true");
			}
			Map<String, Object> map=this.getRequest().getParameterMap();
			StringBuffer url=new StringBuffer(backLink.substring(0, backLink.indexOf("?")));
			url.append("?1=1");
			Set<Entry<String, Object>> entryseSet = map.entrySet(); 
			for(Map.Entry<String, Object> entry:entryseSet){ 
				String key=entry.getKey(); 
				String value=this.getRequest().getParameter(key);
				if(null!=value&&!"".equals(value))
					url.append("&"+key+"="+value);
			}
			session.setAttribute("backlinkurl", url.toString());
//			session.setAttribute("backlink", url.toString()); wenz  2011-11-24  注释 避免其他程序收到此行代码影响
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
  	/**
	 * 
	 */
	public String search()  {//总查寻方法---------------------------------------search!
		this.backLink();
		if(flagday!=null){
			if(flagday.equals("1")){
				getBeforeOneTime();
			}else if(flagday.equals("0")){
				getAfterOneTime();
			}
		}
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Calendar calendar=Calendar.getInstance();
		 try {
			 if(bookTime==null||bookTime.equalsIgnoreCase(""))
			 {
				 bookTime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				 dateDiff=0;
			 }
			 else
			 {
				 calendar.setTime(sdf.parse(bookTime));
				 Calendar calendar_now=Calendar.getInstance();
				 calendar_now.setTime(sdf.parse(sdf.format(new Date())));
				 dateDiff=(calendar.getTimeInMillis()-calendar_now.getTimeInMillis())/(1000*60*60*24);
			 }
		} catch (Exception e) {
			log.error("",e);
		}
		 theTime=new SimpleDateFormat("yyyy年MM月dd日").format(calendar.getTime());
		 switch(calendar.get(Calendar.DAY_OF_WEEK)-1)
			{
				case 0:
					theTime=theTime+" 星期日";
					break;
				case 1:
					theTime=theTime+" 星期一";
					break;
				case 2:
					theTime=theTime+" 星期二";
					break;
				case 3:
					theTime=theTime+" 星期三";
					break;
				case 4:
					theTime=theTime+" 星期四";
					break;
				case 5:
					theTime=theTime+" 星期五";
					break;
				case 6:
					theTime=theTime+" 星期六";
					break;
			}
		try {//强制控制预定时间在今天以后--------------------------（服务器端验证）
			 Date book = DateUtils.String2Date(this.bookTime,"yyyy-MM-dd");
			Date today = new Date();
			if(null==book)
				return "success";
			if(today.after(book)){//如果预定时间      在   今天  之前      那么预定时间只能停在今天。
				this.bookTime=DateUtils.getCurrentDateStr();//把当天的值赋过去。
			}
		} catch (ParseException e1) {
			throw new RuntimeException("日期输入格式有误！");
		}

		/**
		 * 2011-08-15 v1.1.0 (高杰) :
		 */
		 try
		 {
			 MemberInfoVo member=null;
			 MemberAccountVo memberAccount=null;
			if(UserUtil.getUser(getSession().getId())==null)
			{
				memberAccount=new MemberAccountVo();
				memberAccount.setPrivilegeType("MINUS");
				memberRole=new MemberRoleVo();
				memberRole.setCode("GOLD");
			}
			else
			{
				member=UserUtil.getUser(getSession().getId());
				memberAccount=member.getMemberAccount();
				memberRole=memberAccount.getMemberRole();
			}
			
			String subCorpPoint="";//分公司分点
			String platformPoint="";//平台分点
			String profitpoint="";//平台和分公司分点    ALL为全分
			String memberFlowpoint="";//会员享受最低点    ALL为全分
			if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
			{
				Map<String, String> rule_result=RuleConfigProfit.setRuleParam("L", member.getRuleConfigList(), memberAccount.getOrganizationId());
				subCorpPoint=rule_result.get("subCorpPoint");
				platformPoint=rule_result.get("platformPoint");
				profitpoint=rule_result.get("profitpoint");
				memberFlowpoint=rule_result.get("memberFlowpoint");
			}
			
			 ApiClient client=new ApiClient();
			 Type type_page = new TypeToken<PageVo>(){}.getType();
			 PageVo pageVo=null;
			 //判断搜索的是城市还是机场
			 if(cityorap.equalsIgnoreCase("yes"))
			 {
				 String cityDeCode = FlightCache.getCityCodeByAirport(airport);
				 if(null==cityDeCode||"".endsWith(cityDeCode))
					 return TO_SEARCH;
				 pageVo=(PageVo)GsonUtil.jsonToObject(ApiClient.getHtml("/api/apiServer.action?method=findLoungeInfoBySearch&&cityorap="+cityorap+"&&cityDeCode="+cityDeCode+"&&memberFlowpoint="+memberFlowpoint+"&&profitpoint="+profitpoint+"&&platformPoint="+platformPoint+"&&subCorpPoint="+subCorpPoint+"&&airportCode="+airport+"&&name="+loungeName+"&&type="+loungeType+"&&currentPage="+page+"&&time="+bookTime+"&&rolecode="+memberRole.getCode()+"&&privilegetype="+memberAccount.getPrivilegeType()), type_page);
			 }
			 else
			 {
				 pageVo=(PageVo)GsonUtil.jsonToObject(ApiClient.getHtml("/api/apiServer.action?method=findLoungeInfoBySearch&&cityorap="+cityorap+"&&memberFlowpoint="+memberFlowpoint+"&&profitpoint="+profitpoint+"&&platformPoint="+platformPoint+"&&subCorpPoint="+subCorpPoint+"&&airportCode="+airport+"&&name="+loungeName+"&&type="+loungeType+"&&currentPage="+page+"&&time="+bookTime+"&&rolecode="+memberRole.getCode()+"&&privilegetype="+memberAccount.getPrivilegeType()), type_page);
			 }
			 pageInfo=pageVo.getPageInfo();
			 loungelist=pageVo.getLoungeList();
			 if(!ListUtils.isEmpty(loungelist))
				ServletActionContext.getRequest().setAttribute("isLoungeList", true);
			 
			 
			 //排序
			 //先排房间
			 Iterator<LoungeInfoVo> iterator_l=loungelist.iterator();
			 while(iterator_l.hasNext())
			 {
				 List<LoungeRoomVo> room_result=new ArrayList<LoungeRoomVo>();
				 List<LoungeRoomVo> room_book=new ArrayList<LoungeRoomVo>();
				 List<LoungeRoomVo> room_bookable=new ArrayList<LoungeRoomVo>();
				 LoungeInfoVo lounge_reg=iterator_l.next();
				 
				 Iterator<LoungeRoomVo> iterator_r=lounge_reg.getRoomlist().iterator();
				 while(iterator_r.hasNext())
				 {
					 LoungeRoomVo room_reg=iterator_r.next();
					 
					 if(dateDiff<room_reg.getBookDate())
					 {
						//先加进一条记录
						if(room_bookable.size()==0)
						{
							room_bookable.add(room_reg);
						}
						else
						{
							//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
							for(int i_bookable=0;i_bookable<room_bookable.size();i_bookable++)
							{
								LoungeRoomVo room_in=room_bookable.get(i_bookable);
								
								if(room_reg.getLoungePriceVo().getPrice()<room_in.getLoungePriceVo().getPrice())
								{
									room_bookable.add(i_bookable, room_reg);
									break;
								}
								else
								{
									if(i_bookable==room_bookable.size()-1)
									{
										room_bookable.add(room_reg);
										break;
									}
								}
							}
						}
					 }
					 else
					 {
						//先加进一条记录
						if(room_book.size()==0)
						{
							room_book.add(room_reg);
						}
						else
						{
							//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
							for(int i_book=0;i_book<room_book.size();i_book++)
							{
								LoungeRoomVo room_in=room_book.get(i_book);
								
								if(room_reg.getLoungePriceVo().getPrice()<room_in.getLoungePriceVo().getPrice())
								{
									room_book.add(i_book, room_reg);
									break;
								}
								else
								{
									if(i_book==room_book.size()-1)
									{
										room_book.add(room_reg);
										break;
									}
								}
							}
						}
					 }
				 }
				 
				 room_result.addAll(room_book);//System.out.println(room_book+"=============room_book");
				 room_result.addAll(room_bookable);//System.out.println(room_bookable+"=============room_bookable");
				 lounge_reg.setRoomlist(room_result);
			 }
			 
			 
			 List<LoungeInfoVo> lounge_result=new ArrayList<LoungeInfoVo>();
			 List<LoungeInfoVo> lounge_book=new ArrayList<LoungeInfoVo>();
			 List<LoungeInfoVo> lounge_bookable=new ArrayList<LoungeInfoVo>();
			 
			 iterator_l=loungelist.iterator();
			 while(iterator_l.hasNext())
			 {
				 LoungeInfoVo lounge_reg=iterator_l.next();
				 LoungeRoomVo lounge_room_reg=(LoungeRoomVo)lounge_reg.getRoomlist().get(0);
				 
				 if(dateDiff<lounge_room_reg.getBookDate())
				 {
					//先加进一条记录
					if(lounge_bookable.size()==0)
					{
						lounge_bookable.add(lounge_reg);
					}
					else
					{
						//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
						for(int i_bookable=0;i_bookable<lounge_bookable.size();i_bookable++)
						{
							LoungeInfoVo lounge_in=lounge_bookable.get(i_bookable);
							LoungeRoomVo lounge_room_in=(LoungeRoomVo)lounge_in.getRoomlist().get(0);
							
							if(lounge_room_reg.getLoungePriceVo().getPrice()<lounge_room_in.getLoungePriceVo().getPrice())
							{
								lounge_bookable.add(i_bookable, lounge_reg);
								break;
							}
							else
							{
								if(i_bookable==lounge_bookable.size()-1)
								{
									lounge_bookable.add(lounge_reg);
									break;
								}
							}
						}
					}
				 }
				 else
				 {
					//先加进一条记录
					if(lounge_book.size()==0)
					{
						lounge_book.add(lounge_reg);
					}
					else
					{
						//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
						for(int i_book=0;i_book<lounge_book.size();i_book++)
						{
							LoungeInfoVo lounge_in=lounge_book.get(i_book);
							LoungeRoomVo lounge_room_in=(LoungeRoomVo)lounge_in.getRoomlist().get(0);
							
							if(lounge_room_reg.getLoungePriceVo().getPrice()<lounge_room_in.getLoungePriceVo().getPrice())
							{
								lounge_book.add(i_book, lounge_reg);
								break;
							}
							else
							{
								if(i_book==lounge_book.size()-1)
								{
									lounge_book.add(lounge_reg);
									break;
								}
							}
						}
					}
				 }
			 }
			 
			 lounge_result.addAll(lounge_book);
			 lounge_result.addAll(lounge_bookable);
			 loungelist=lounge_result;
			 
			 
		 }
		 catch(Exception e){
				log.error("",e);
		 }
		 return TO_SEARCH;
	}
	/**
	 * 
	 */
	public LoungeInfoVo detailSearch()  {
		
		try
		{
			MemberInfoVo member=null;
			MemberAccountVo memberAccount=null;
			if(UserUtil.getUser(getSession().getId())==null)
			{
				memberAccount=new MemberAccountVo();
				memberAccount.setPrivilegeType("MINUS");
				memberRole=new MemberRoleVo();
				memberRole.setCode("GOLD");
			}
			else
			{
				member=UserUtil.getUser(getSession().getId());
				memberAccount=member.getMemberAccount();
				memberRole=memberAccount.getMemberRole();
			}
			
			String subCorpPoint="";//分公司分点
			String platformPoint="";//平台分点
			String profitpoint="";//平台和分公司分点    ALL为全分
			String memberFlowpoint="";//会员享受最低点    ALL为全分
			if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
			{
				Map<String, String> rule_result=RuleConfigProfit.setRuleParam("L", member.getRuleConfigList(), memberAccount.getOrganizationId());
				subCorpPoint=rule_result.get("subCorpPoint");
				platformPoint=rule_result.get("platformPoint");
				profitpoint=rule_result.get("profitpoint");
				memberFlowpoint=rule_result.get("memberFlowpoint");
			}
			
			Type type_page = new TypeToken<PageVo>(){}.getType();
			PageVo pageVo=null;
			pageVo=(PageVo)GsonUtil.jsonToObject(ApiClient.getHtml("/api/apiServer.action?method=findLoungeInfoBySearch&&cityorap=no&&id="+id+"&&cityDeCode=no&&memberFlowpoint="+memberFlowpoint+"&&profitpoint="+profitpoint+"&&platformPoint="+platformPoint+"&&subCorpPoint="+subCorpPoint+"&&rolecode="+memberRole.getCode()+"&&time="+bookTime+"&&privilegetype="+memberAccount.getPrivilegeType()+"&&currentPage=1"), type_page);
			pageInfo=pageVo.getPageInfo();
			loungelist=pageVo.getLoungeList();
			if(!ListUtils.isEmpty(loungelist))
				return loungelist.get(0);
		}
		catch(Exception e){
			log.error("",e);
		}
		return null;
	}
	
	/**
	 * 机场休息室详情查询
	 * @return
	 */
	public String loungeDetail(){
		try {
			MemberInfoVo member=UserUtil.getUser(getSession().getId());
			//取得客户信息
			if(null!=member)
				ServletActionContext.getRequest().setAttribute("islogin", true);
			//获取预订时间和当前时间的差值，以日为单位
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			 Calendar calendar=Calendar.getInstance();
			 if(bookTime==null||bookTime.equalsIgnoreCase(""))
			 {
				 bookTime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				 dateDiff=0;
			 }
			 else
			 {
				 calendar.setTime(sdf.parse(bookTime));
				 Calendar calendar_now=Calendar.getInstance();
				 calendar_now.setTime(sdf.parse(sdf.format(new Date())));
				 dateDiff=(calendar.getTimeInMillis()-calendar_now.getTimeInMillis())/(1000*60*60*24);
			 }
			 loungeInfoVo=(LoungeInfoVo)this.detailSearch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "detail";
	}
	
	/**
	 * 2011-08-15 v1.1.0 (高杰) :
	 */
	public String toHome()
	{
		 try
		 {
//			 ApiClient client=new ApiClient();
			 Type type_lounge = new TypeToken<List<LoungeRoomVo>>(){}.getType();
			 roomlist=(List<LoungeRoomVo>)GsonUtil.jsonToObject(ApiClient.getHtml("/api/apiServer.action?method=findLoungeInfoByComm"), type_lounge);
			 
			 if(ServletActionContext.getRequest().getParameter("source")!=null)
			 {
				HttpServletRequest request=ServletActionContext.getRequest();
				HttpSession session=request.getSession();
				
				MemberInfoVo member=(MemberInfoVo)memberInfoServ.findById(request.getParameter("memid").toString());
				MemberAccountVo memberAccount=(MemberAccountVo)memberAccountServ.findByMember(member.getId());
				MemberRoleVo memberRole=(MemberRoleVo)memberRoleServ.findById(memberAccount.getRole());
				memberAccount.setMemberRole(memberRole);
				member.setMemberAccount(memberAccount);
				
				session.setAttribute("createUser", request.getParameter("createuser"));
				session.setAttribute("source", request.getParameter("source"));
				session.setAttribute("memberId", member.getId());
				UserUtil.set("sessionId", getSession().getId(),member);
				session.setAttribute("memberCode", member.getCode());
				session.setAttribute("cardNo", memberAccount.getCardNo());
			 }
			 
			//显示预订日期
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//			Calendar calendar=Calendar.getInstance();
//			calendar.setTime(new Date());
			bookTime=sdf.format(new Date());
		 }
		 catch(Exception e)
		 {
			 log.error("",e);
			 return "success";
		 }
		 return "success";
	}
	
	/**
	 * 
	 * @return
	 */
	public String toAdd(){
		return TO_ADD;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toModify(){
		return TO_MODIFY;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toSearch(){
		return TO_SEARCH;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toView(){
		try{
	  	//loungeInfoService.findById(loungeInfoVo.getId());
	  }
		catch(Exception e){
			log.error("",e);
		}
		return TO_VIEW;
	}
	public String getBookTime() {
		return bookTime;
	}

	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}

	public long getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(long dateDiff) {
		this.dateDiff = dateDiff;
	}

	public String getBeforeOneTime() {//前一天
		if(bookTime!=null && bookTime.length()>8){
			Date string2Date;
			try {
				string2Date = DateUtils.String2Date(this.bookTime,"yyyy-MM-dd");
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
			this.beforeOneTime = DateUtils.getFutureDay(string2Date, "yyyy-MM-dd", -1);
		}
		this.bookTime=this.beforeOneTime;
		return this.beforeOneTime;
	}

	public void setBeforeOneTime(String beforeOneTime) {
		this.beforeOneTime = beforeOneTime;
	}

	public String getAfterOneTime() {
		if(bookTime!=null && bookTime.length()>8){
			Date string2Date;
			try {
				string2Date = DateUtils.String2Date(this.bookTime,"yyyy-MM-dd");
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
			this.afterOneTime = DateUtils.getFutureDay(string2Date, "yyyy-MM-dd", 1);
		}
		this.bookTime=this.afterOneTime;
		return this.afterOneTime;
	}

	public void setAfterOneTime(String afterOneTime) {
		this.afterOneTime = afterOneTime;
	}

	public String getFlagday() {
		return flagday;
	}

	public void setFlagday(String flagday) {
		this.flagday = flagday;
	}

	public String getTheTime() {
		return theTime;
	}

	public void setTheTime(String theTime) {
		this.theTime = theTime;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public String getLoungeName() {
		return loungeName;
	}

	public void setLoungeName(String loungeName) {
		this.loungeName = loungeName;
	}

	public String getLoungeType() {
		return loungeType;
	}

	public void setLoungeType(String loungeType) {
		this.loungeType = loungeType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<LoungeInfoVo> getLoungelist() {
		return loungelist;
	}

	public void setLoungelist(List<LoungeInfoVo> loungelist) {
		this.loungelist = loungelist;
	}

	public List<LoungeRoomVo> getRoomlist() {
		return roomlist;
	}

	public void setRoomlist(List<LoungeRoomVo> roomlist) {
		this.roomlist = roomlist;
	}


	public MemberRoleVo getMemberRole() {
		return memberRole;
	}


	public void setMemberRole(MemberRoleVo memberRole) {
		this.memberRole = memberRole;
	}


	public String getCityorap() {
		return cityorap;
	}


	public void setCityorap(String cityorap) {
		this.cityorap = cityorap;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public static void main(String[] args) {
//		Type type_page = new TypeToken<PageVo>(){}.getType();
//		 PageVo pageVo=null;
//		 //判断搜索的是城市还是机场
////		String cityDeCode = FlightCache.getCityCodeByAirport(airport);
//		String jsonStr="{\"pageInfo\":{\"totalPageCount\":2,\"totalRowCount\":3,\"currentPageNum\":1,\"rowsOfPage\":15,\"groupsOfPage\":10,\"currentGroupNum\":0,\"totalGroupNum\":0},\"loungeList\":[{\"id\":\"4268bb97027848a6903469e289af844a\",\"name\":\"首都机场\",\"airportCode\":\"null\",\"address\":\"顺义空港区\",\"airlineCorp\":\"8L,GS,HU,JD\",\"sts\":\"1\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-08 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-08 00:00:00\",\"roomlist\":[{\"id\":\"c0be51088b8540f78828885a643c6a1b\",\"loungeId\":\"4268bb97027848a6903469e289af844a\",\"type\":\"2\",\"sts\":\"1\",\"bookDate\":2,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-31 00:00:00\",\"rmk\":\"收取10%手续费\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-08 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-08 00:00:00\",\"loungePriceVo\":{\"id\":\"57b8a15e4bdc4095887e37db9c450d87\",\"roomId\":\"c0be51088b8540f78828885a643c6a1b\",\"signingPrice\":100.0,\"price\":800.0,\"childrenPrice\":500.0,\"item\":\"0\",\"type\":\"N\",\"way\":\"0\"}},{\"id\":\"59ee5898d50f4cec8e087f7a3ab81fbe\",\"loungeId\":\"4268bb97027848a6903469e289af844a\",\"type\":\"1\",\"roomType\":\"5\",\"sts\":\"1\",\"quantity\":3,\"bookDate\":3,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-31 00:00:00\",\"rmk\":\"收取10%手续费\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-08 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-08 00:00:00\",\"loungePriceVo\":{\"id\":\"11a5a28b9a8d4b2d8a6d9471fe48848b\",\"roomId\":\"59ee5898d50f4cec8e087f7a3ab81fbe\",\"signingPrice\":1000.0,\"price\":5000.0,\"childrenPrice\":5000.0,\"item\":\"0\",\"type\":\"N\",\"way\":\"1\"}},{\"id\":\"bcb5e2d2a10d42b5a2059499c4c93c16\",\"loungeId\":\"4268bb97027848a6903469e289af844a\",\"type\":\"1\",\"roomType\":\"3\",\"sts\":\"1\",\"quantity\":2,\"bookDate\":3,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-31 00:00:00\",\"rmk\":\"收取10%手续费\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-08 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-08 00:00:00\",\"loungePriceVo\":{\"id\":\"612c020dca2344fa85cb9656662ff568\",\"roomId\":\"bcb5e2d2a10d42b5a2059499c4c93c16\",\"signingPrice\":2000.0,\"price\":8000.0,\"childrenPrice\":8000.0,\"item\":\"0\",\"type\":\"N\",\"way\":\"1\"}}],\"airport\":{},\"airlinelist\":[{\"id\":\"PF100200000000000000000000000000\",\"code\":\"8L\",\"name\":\"祥鹏\",\"sts\":\"\u0000\"},{\"id\":\"PF101200000000000000000000000000\",\"code\":\"GS\",\"name\":\"天津\",\"sts\":\"\u0000\"},{\"id\":\"PF101400000000000000000000000000\",\"code\":\"HU\",\"name\":\"海航\",\"sts\":\"\u0000\"},{\"id\":\"PF101500000000000000000000000000\",\"code\":\"JD\",\"name\":\"首航\",\"sts\":\"\u0000\"}],\"organizationId\":\"c521a50e47e7462a8503ade207127d16\",\"image\":{}},{\"id\":\"fca9196a6e9d47428bb35c5a6c1f3afa\",\"name\":\"首都机场休息室\",\"airportCode\":\"PEK\",\"address\":\"顺义空港区\",\"airlineCorp\":\"8L,CN,HU,JD\",\"sts\":\"1\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-09 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-09 00:00:00\",\"roomlist\":[{\"id\":\"c2b4521504a344e4ab42b5f5b879bcdd\",\"loungeId\":\"fca9196a6e9d47428bb35c5a6c1f3afa\",\"type\":\"3\",\"sts\":\"1\",\"bookDate\":1,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-31 00:00:00\",\"rmk\":\"退订收10%手续费\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-16 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-16 00:00:00\",\"loungePriceVo\":{\"id\":\"00c84732a84b402d9d08944a9c23525e\",\"roomId\":\"c2b4521504a344e4ab42b5f5b879bcdd\",\"signingPrice\":50.0,\"price\":150.0,\"childrenPrice\":100.0,\"item\":\"0,1\",\"type\":\"N\",\"way\":\"0\"}},{\"id\":\"a2ff4734e5be44f5baaa1f13e2e3e0ff\",\"loungeId\":\"fca9196a6e9d47428bb35c5a6c1f3afa\",\"type\":\"2\",\"sts\":\"1\",\"bookDate\":1,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-31 00:00:00\",\"rmk\":\"退订收10%手续费\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-16 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-16 00:00:00\",\"loungePriceVo\":{\"id\":\"4f54233c2c564643bd9b06e14d586fd9\",\"roomId\":\"a2ff4734e5be44f5baaa1f13e2e3e0ff\",\"signingPrice\":100.0,\"price\":300.0,\"childrenPrice\":200.0,\"item\":\"0,1\",\"type\":\"N\",\"way\":\"0\"}},{\"id\":\"9e3e61c4e45d4c1db4143c3b6e20e389\",\"loungeId\":\"fca9196a6e9d47428bb35c5a6c1f3afa\",\"type\":\"1\",\"roomType\":\"5\",\"sts\":\"1\",\"quantity\":5,\"bookDate\":3,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-31 00:00:00\",\"rmk\":\"退订收30%手续费\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-09 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-09 00:00:00\",\"loungePriceVo\":{\"id\":\"9589627353854ed49a6beb594853a2a0\",\"roomId\":\"9e3e61c4e45d4c1db4143c3b6e20e389\",\"signingPrice\":2000.0,\"price\":5000.0,\"childrenPrice\":5000.0,\"item\":\"0\",\"type\":\"N\",\"way\":\"1\"}},{\"id\":\"d5be6df001d149b39cdea9d5ce46038a\",\"loungeId\":\"fca9196a6e9d47428bb35c5a6c1f3afa\",\"type\":\"1\",\"roomType\":\"3\",\"sts\":\"1\",\"quantity\":2,\"bookDate\":3,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-31 00:00:00\",\"rmk\":\"退订收30%手续费\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-09 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-09 00:00:00\",\"loungePriceVo\":{\"id\":\"590e6279d8a44ed9be68c656661f3de2\",\"roomId\":\"d5be6df001d149b39cdea9d5ce46038a\",\"signingPrice\":5000.0,\"price\":8000.0,\"childrenPrice\":8000.0,\"item\":\"0\",\"type\":\"N\",\"way\":\"1\"}}],\"airport\":{\"createUser\":\"admin\",\"id\":\"PF100521035356015561300000000000\",\"city\":\"010\",\"code\":\"PEK\",\"name\":\"北京首都\",\"airportEname\":\"beijingshoudu\",\"sts\":\"1\",\"updateUser\":\"admin\",\"rmk\":\"admin\",\"createTime\":\"2010-04-30 08:43:42\",\"isMain\":\"1\",\"lname\":\"北京首都机场\",\"ename\":\"BEIJING\"},\"airlinelist\":[{\"id\":\"PF100200000000000000000000000000\",\"code\":\"8L\",\"name\":\"祥鹏\",\"sts\":\"\u0000\"},{\"id\":\"PF100600000000000000000000000000\",\"code\":\"CN\",\"name\":\"大新华\",\"sts\":\"\u0000\"},{\"id\":\"PF101400000000000000000000000000\",\"code\":\"HU\",\"name\":\"海航\",\"sts\":\"\u0000\"},{\"id\":\"PF101500000000000000000000000000\",\"code\":\"JD\",\"name\":\"首航\",\"sts\":\"\u0000\"}],\"organizationId\":\"7c22aec8c05b43aa879e400d0b1e9875\",\"image\":{}},{\"id\":\"754fe121daf640b989472ea66df1f169\",\"name\":\"方明TEST机场2\",\"airportCode\":\"PEK\",\"address\":\"北京\",\"airlineCorp\":\"JR,CX,3U,9C,CN,CZ,EU,G5,GS,HO,HU,JD,KN,MF,MU,OQ,SC,ZH\",\"sts\":\"1\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-10 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-10 00:00:00\",\"roomlist\":[{\"id\":\"b11b5d37a83b4fed86cdf86cf661a2bd\",\"loungeId\":\"754fe121daf640b989472ea66df1f169\",\"type\":\"3\",\"sts\":\"1\",\"bookDate\":5,\"startTime\":\"09:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-27 00:00:00\",\"rmk\":\"退25% 改15%\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-10 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-10 00:00:00\",\"loungePriceVo\":{\"id\":\"c7576e045ceb433fb22c01cd538f987c\",\"roomId\":\"b11b5d37a83b4fed86cdf86cf661a2bd\",\"signingPrice\":5.0,\"price\":7.0,\"childrenPrice\":6.0,\"item\":\"0\",\"type\":\"N\",\"way\":\"0\"}},{\"id\":\"e3109c1287234b4b9436eb6416e6fc5e\",\"loungeId\":\"754fe121daf640b989472ea66df1f169\",\"type\":\"1\",\"roomType\":\"3\",\"sts\":\"1\",\"quantity\":5,\"bookDate\":5,\"startTime\":\"09:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-27 00:00:00\",\"rmk\":\"退30% 改20%\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-10 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-10-08 00:00:00\",\"loungePriceVo\":{\"id\":\"b4aef4307dc9457c8348b006fa762860\",\"roomId\":\"e3109c1287234b4b9436eb6416e6fc5e\",\"signingPrice\":20.0,\"price\":50.0,\"childrenPrice\":50.0,\"item\":\"0\",\"type\":\"N\",\"way\":\"1\"}},{\"id\":\"089066edf27f4e038840ab21e804a067\",\"loungeId\":\"754fe121daf640b989472ea66df1f169\",\"type\":\"2\",\"sts\":\"1\",\"bookDate\":3,\"startTime\":\"09:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-27 00:00:00\",\"rmk\":\"退40% 改30%\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-10 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-10 00:00:00\",\"loungePriceVo\":{\"id\":\"21b1b56b060a44f0aa8d82212641a3bc\",\"roomId\":\"089066edf27f4e038840ab21e804a067\",\"signingPrice\":30.0,\"price\":50.0,\"childrenPrice\":40.0,\"item\":\"0,1\",\"type\":\"N\",\"way\":\"0\"}},{\"id\":\"eb63877838214ab39c5776ba09ac60bc\",\"loungeId\":\"754fe121daf640b989472ea66df1f169\",\"type\":\"1\",\"roomType\":\"4\",\"sts\":\"1\",\"quantity\":10,\"bookDate\":5,\"startTime\":\"09:00\",\"endTime\":\"23:59\",\"startDate\":\"2011-09-01 00:00:00\",\"endDate\":\"2011-10-27 00:00:00\",\"rmk\":\"退30% 改20%\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-10 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-10-08 00:00:00\",\"loungePriceVo\":{\"id\":\"e51766c1ee034107a695e9b4877979f4\",\"roomId\":\"eb63877838214ab39c5776ba09ac60bc\",\"signingPrice\":50.0,\"price\":70.0,\"childrenPrice\":70.0,\"item\":\"0\",\"type\":\"N\",\"way\":\"1\"}}],\"airport\":{\"createUser\":\"admin\",\"id\":\"PF100521035356015561300000000000\",\"city\":\"010\",\"code\":\"PEK\",\"name\":\"北京首都\",\"airportEname\":\"beijingshoudu\",\"sts\":\"1\",\"updateUser\":\"admin\",\"rmk\":\"admin\",\"createTime\":\"2010-04-30 08:43:42\",\"isMain\":\"1\",\"lname\":\"北京首都机场\",\"ename\":\"BEIJING\"},\"airlinelist\":[{\"id\":\"PF102600000000000000000000000000\",\"code\":\"JR\",\"name\":\"幸福\",\"sts\":\"\u0000\"},{\"id\":\"PF102400000000000000410000000000\",\"code\":\"CX\",\"name\":\"国泰\",\"sts\":\"\u0000\"},{\"id\":\"PF100000000000000000000000000000\",\"code\":\"3U\",\"name\":\"川航\",\"sts\":\"\u0000\"},{\"id\":\"PF100300000000000000000000000000\",\"code\":\"9C\",\"name\":\"春秋\",\"sts\":\"\u0000\"},{\"id\":\"PF100600000000000000000000000000\",\"code\":\"CN\",\"name\":\"大新华\",\"sts\":\"\u0000\"},{\"id\":\"PF100800000000000000000000000000\",\"code\":\"CZ\",\"name\":\"南航\",\"sts\":\"\u0000\"},{\"id\":\"PF100900000000000000000000000000\",\"code\":\"EU\",\"name\":\"成都\",\"sts\":\"\u0000\"},{\"id\":\"PF101100000000000000000000000000\",\"code\":\"G5\",\"name\":\"华夏\",\"sts\":\"\u0000\"},{\"id\":\"PF101200000000000000000000000000\",\"code\":\"GS\",\"name\":\"天津\",\"sts\":\"\u0000\"},{\"id\":\"PF101300000000000000000000000000\",\"code\":\"HO\",\"name\":\"吉祥\",\"sts\":\"\u0000\"},{\"id\":\"PF101400000000000000000000000000\",\"code\":\"HU\",\"name\":\"海航\",\"sts\":\"\u0000\"},{\"id\":\"PF101500000000000000000000000000\",\"code\":\"JD\",\"name\":\"首航\",\"sts\":\"\u0000\"},{\"id\":\"PF101600000000000000000000000000\",\"code\":\"KN\",\"name\":\"联航\",\"sts\":\"\u0000\"},{\"id\":\"PF101700000000000000000000000000\",\"code\":\"MF\",\"name\":\"厦航\",\"sts\":\"\u0000\"},{\"id\":\"PF101800000000000000000000000000\",\"code\":\"MU\",\"name\":\"东航\",\"sts\":\"\u0000\"},{\"id\":\"PF102000000000000000000000000000\",\"code\":\"OQ\",\"name\":\"重庆\",\"sts\":\"\u0000\"},{\"id\":\"PF102200000000000000000000000000\",\"code\":\"SC\",\"name\":\"山航\",\"sts\":\"\u0000\"},{\"id\":\"PF102400000000000000000000000000\",\"code\":\"ZH\",\"name\":\"深航\",\"sts\":\"\u0000\"}],\"organizationId\":\"60f7a2c38188453698da25d6a7f273f6\",\"image\":{\"id\":\"ebe5186d523b4d2cb7ad7025f072da7c\",\"loungeId\":\"754fe121daf640b989472ea66df1f169\",\"type\":\"0\",\"name\":\"1\",\"path\":\"db9c6b96-99c6-4c31-9a5d-a88121fd27951.jpg\",\"sts\":\"1\",\"rmk\":\"1\",\"createUser\":\"管理员\",\"createTime\":\"2011-09-10 00:00:00\",\"updateUser\":\"管理员\",\"updateTime\":\"2011-09-10 00:00:00\"}}]} ";
//		pageVo=(PageVo)GsonUtil.jsonToObject(jsonStr, type_page);
//		System.out.println(pageVo);
//		System.out.println(pageVo.getLoungeList());
////		
////		if(StringUtils.isEmpty(json) || objectType == null){
////			return null;
////		}
//		GsonBuilder builder=new GsonBuilder();
//		Gson gson=builder.create();
////		gson.
//	try {
//			
//			LoungeInfoAction l=new LoungeInfoAction();
//			l.setLoungeInfoVo(new LoungeInfoVo());
//			Field f=l.getClass().getDeclaredField("loungeInfoVo");
//			Object obj=f.get(l);
//			System.out.println("obj:"+obj);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
	}
}