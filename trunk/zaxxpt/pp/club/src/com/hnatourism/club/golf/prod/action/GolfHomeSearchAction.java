package com.hnatourism.club.golf.prod.action;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.service.ICustomerProfitService;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.golf.prod.service.IGolfHomeSearchService;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.club.golf.prod.vo.SysHolidayVo;
import com.hnatourism.club.member.rule.dao.IRuleConfigDao;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转到高尔夫首页
 * 
 * 历史版本: ${2011.8.3} v1.0.0 (栾晓东) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class GolfHomeSearchAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	// 分页信息
	private PageInfo pageInfo = new PageInfo();
	// 产品信息VO
	private GolfInfoVo golfInfoVo;
	//产品信息数据
	private List<GolfInfoVo> data;
	//高尔夫ID
	private String id;
	//高尔夫城市ID
	private String city;
	//高尔夫预订时间
	private String bookTime;
	//高尔夫球场类型
	private String golfType;
	//高尔夫球场名称
	private String name;
	//当前页码
	private int currentPage;
	//查询时间是否是节假日
	private boolean isHoliday;
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
	
	private String provinceName;
	
	@Resource
	private IGolfHomeSearchService golfHomeSearchServ;

	public void setGolfHomeSearchServ(IGolfHomeSearchService golfHomeSearchServ) {
		this.golfHomeSearchServ = golfHomeSearchServ;
	}

	private IRuleConfigDao RuleConfigDaoImpl;
	private IMemberAccountDao memberAccountDao;
	private ICustomerProfitService CustomerProfitServiceImpl;
	private IMemberInfoService memberInfoService;
	private IMemberRoleService memberRoleService;
	
	
	
	/**
	 * 从Sring转换八大基本数据类型以及Date类型
	 * @param value 转换值
	 * @param classs  数据类型类对象
	 * @return 转换完成的对象
	 */
	public Object string2Type(String value,Class classs)
	{
		String typeName=classs.getName();
		if(null!=typeName)
		{
			try {
				if("int".equals(typeName))
				{
					return Integer.valueOf(value);
				}else if("short".equals(typeName))
				{
					return Short.valueOf(value);
				}else if("float".equals(typeName))
				{
					return Float.valueOf(value);
				}else if("long".equals(typeName))
				{
					return Long.valueOf(value);
				}else if("double".equals(typeName))
				{
					return Double.valueOf(value);
				}else if("char".equals(typeName))
				{
					return Character.valueOf(value.charAt(0));
				}else if("byte".equals(typeName))
				{
					return Byte.valueOf(value);
				}else if("boolean".equals(typeName))
				{
					return Boolean.valueOf(value);
				}else if("java.util.Date".equals(typeName))
				{
					value=value.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").trim();
					StringBuffer dateBuffer=new StringBuffer();
					for (int i = 0; i < value.length(); i++) {
						if(Character.isDigit(value.charAt(i)))
							dateBuffer.append(value.charAt(i));
					}
					String pattern="yyyyMMdd";
					if(dateBuffer.length()>=14)
						pattern="yyyyMMddHHmmss";
					SimpleDateFormat  format=new SimpleDateFormat(pattern);
					return format.parse(dateBuffer.toString());
					
				}
			} catch (Exception e) {
				log.error("类型转换错误："+e);
			}
		}
		return value;
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
	 * 2011-11-24
	 * @author wenz
	 */
	public void  backLink(){
		try {
			HttpSession session= this.getRequest().getSession();
			//获取已经保存的返回链接
			String backLink=session.getAttribute("backlink").toString();
			MemberInfoVo member=UserUtil.getUser(session.getId());
			if(null==member)
				session.setAttribute("isgolfsearchlogin", "false");
			if(member!=null&&null!=session.getAttribute("isgolfsearchlogin")){
				String isloungesearchlogin=session.getAttribute("isgolfsearchlogin").toString();
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
										Method method=this.matchMethod(classs, methodName);
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
							Method method=this.matchMethod(this.getClass(), methodName);
							Object valueObj=string2Type(value, field.getType());
							method.invoke(this, valueObj);
						}
					}
				}
				session.setAttribute("isgolfsearchlogin", "true");
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
//			session.setAttribute("backlink", url.toString()); wenz  2011-11-24  注释 避免其他代码受到此行代码影响
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}

	/**
	 * 高尔夫前台查寻页面。通过省份(golfSiteVo.getCity()  )、下场时期(golfSiteVo.getEndTime()  )、球场类型(golfSiteVo.getGolfType().getName() )、球场名称(golfInfoVo.getName() )。
	 * 2011-08-04 v1.1.0 (高杰、栾晓东) 
	 * @return
	 */
	public String search() {
		this.backLink();
	if(flagday!=null){
		if(flagday.equals("1")){
			getBeforeOneTime();
		}else if(flagday.equals("0")){
			getAfterOneTime();
		}
	}
	if(city!=null&&!city.equalsIgnoreCase(""))
	{
		this.id=null;//将上一次提交的定单ID清空。避免重复提交。
	}
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			if(bookTime==null||bookTime.equalsIgnoreCase(""))
			{
				bookTime=sdf.format(new Date());
			}
			
			//强制控制预定时间在今天以后--------------------------（服务器端验证）
			Date book = DateUtils.String2Date(this.bookTime,"yyyy-MM-dd");
			Date today = new Date();
			if(today.after(book)){//如果预定时间      在   今天  之前      那么预定时间只能停在今天。
				this.bookTime=DateUtils.getCurrentDateStr();//把当天的值赋过去。
			}
			
			//取得客户信息
			HttpSession session=this.getSession();
			MemberInfoVo member=UserUtil.getUser(getSession().getId());
			MemberAccountVo memberAccount=null;
			MemberRoleVo memberRole=null;
			if(member!=null)
			{
				memberAccount=member.getMemberAccount();
				memberRole=(MemberRoleVo)memberRoleService.findById(memberAccount.getRole());
			}
			else
			{
				memberAccount=new MemberAccountVo();
				memberAccount.setPrivilegeType("MINUS");
				memberRole=new MemberRoleVo();
				memberRole.setCode("GOLD");
			}
			
			ApiClient client=new ApiClient();
			Type type_golf = new TypeToken<List<GolfInfoVo>>(){}.getType();
			Type type_holiday = new TypeToken<List<SysHolidayVo>>(){}.getType();
			
			//显示预订日期
			Calendar calendar=Calendar.getInstance();
			if(bookTime==null||bookTime.equalsIgnoreCase(""))
			{
				calendar.setTime(new Date());
				dateDiff=0;
				bookTime=sdf.format(new Date());
			}
			else
			{
				calendar.setTime(sdf.parse(bookTime));
				Calendar calendar_now=Calendar.getInstance();
				calendar_now.setTime(sdf.parse(sdf.format(new Date()).toString()));
				dateDiff=(calendar.getTimeInMillis()-calendar_now.getTimeInMillis())/(1000*60*60*24);
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
			
			//数据库取值
			List<SysHolidayVo> holidaylist=(List<SysHolidayVo>)GsonUtil.jsonToObject(client.getHtml("/api/apiServer.action?method=api_findsysHolidayBydate&&date="+bookTime), type_holiday);
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
			data=(List<GolfInfoVo>)GsonUtil.jsonToObject(client.getHtml("/api/apiServer.action?method=api_findGolfInfoBySearch&&city="+city+"&&name="+name+"&&type="+golfType+"&&id="+id+"&&bookTime="+bookTime), type_golf);
			
			//分页
			pageInfo.setRowsOfPage(30);
			pageInfo.setTotalRowCount(data.size());
			pageInfo.setTotalPageCount(pageInfo.getRowsOfPage(), pageInfo.getTotalRowCount());
			pageInfo.setCurrentPageNum(currentPage==0?1:currentPage);
			
			if(pageInfo.getCurrentPageNum()>pageInfo.getTotalPageCount())
			{
				pageInfo.setCurrentPageNum(pageInfo.getTotalPageCount());
			}
			//计算分页的记录开始和结束
			int startnum=(pageInfo.getCurrentPageNum()-1)*pageInfo.getRowsOfPage();
			int endnum=0;
			if(pageInfo.getCurrentPageNum()==pageInfo.getTotalPageCount())
			{
				endnum=pageInfo.getTotalRowCount();
			}
			else
			{
				endnum=pageInfo.getCurrentPageNum()*pageInfo.getRowsOfPage();
			}
			
			List<GolfInfoVo> golflist=new ArrayList<GolfInfoVo>();
			if(data.size()>0)
			{
				//数据排除
				for(int i=startnum;i<endnum;i++)
				{
					GolfInfoVo golf=data.get(i);
					List<GolfSiteVo> sitelist=new ArrayList<GolfSiteVo>();
					Iterator<GolfSiteVo> sitelist_i=golf.getGolfsitelist().iterator();
					while(sitelist_i.hasNext())
					{
						GolfSiteVo site=sitelist_i.next();
						Iterator<GolfPriceVo> pricelist_i=site.getPricelist().iterator();
						while(pricelist_i.hasNext())
						{
							GolfPriceVo price=pricelist_i.next();
							Calendar calendar_endtime=Calendar.getInstance();
							calendar_endtime.setTime(price.getEndTime());
							Calendar calendar_starttime=Calendar.getInstance();
							calendar_starttime.setTime(price.getStartTime());
							long islt=calendar_endtime.getTimeInMillis()-calendar.getTimeInMillis();
							long isgt=calendar.getTimeInMillis()-calendar_starttime.getTimeInMillis();
							if(islt>=0&&isgt>=0)
							{
								if(price.getTargeDate()==null)
								{
									price.setTargeDate(0l);
								}
								
								if(site.getType()==1)
								{
									price.setHPrice(price.getPrice());
									price.setHTargeDate(price.getTargeDate());
								}
								
								SubRunBean subRunBean=new SubRunBean();
								subRunBean.setProdSignprice(price.getSigningPrice());
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
								
								if(memberAccount.getPrivilegeType()==null||memberAccount.getPrivilegeType().equalsIgnoreCase("MINUS"))
								{
									subRunBean.setProdSalePrice(price.getPrice());
									price.setPrice(SubRunUtils.getProdPrice(subRunBean));
									subRunBean.setProdSalePrice(price.getHPrice());
									price.setHPrice(SubRunUtils.getProdPrice(subRunBean));
								}
								
								if(site.getType()==0)
								{
									price.setPrice(Math.ceil(price.getPrice()));
									price.setHPrice(Math.ceil(price.getHPrice()));
								}
								
								site.setGolfPriceVo(price);
								sitelist.add(site);
								break;
							}
						}
					}
					
					if(sitelist.size()>0)
					{
						golf.setGolfsitelist(sitelist);
						golflist.add(golf);
					}
				}

				//排序
				//先对场地排序
				Iterator<GolfInfoVo> iterator_gf=golflist.iterator();
				while(iterator_gf.hasNext())
				{
					GolfInfoVo golf_reg=iterator_gf.next();
					
					//给高尔夫场地排序，判断是可以预定还是提前预订
					List<GolfSiteVo> sitelist_sort=new ArrayList<GolfSiteVo>();
					List<GolfSiteVo> site_bookable=new ArrayList<GolfSiteVo>();//有预订期限的球场集合
					List<GolfSiteVo> site_book=new ArrayList<GolfSiteVo>();//可直接预订的球场集合
					
					Iterator<GolfSiteVo> iterator_site=golf_reg.getGolfsitelist().iterator();
					while(iterator_site.hasNext())
					{
						GolfSiteVo site_reg=iterator_site.next();
						
						if(isHoliday)
						{
							if(site_reg.getGolfPriceVo().getTargeDate()==null)
							{
								site_reg.getGolfPriceVo().setTargeDate(0l);
							}
							
							//练习场没有节假日
							if(site_reg.getType()==1)
							{
								site_reg.getGolfPriceVo().setHPrice(site_reg.getGolfPriceVo().getPrice());
								site_reg.getGolfPriceVo().setHTargeDate(site_reg.getGolfPriceVo().getTargeDate());
							}
							
							//对有提前预订提示的球场排序
							if(dateDiff<site_reg.getGolfPriceVo().getHTargeDate())
							{
								//先加进一条记录
								if(site_bookable.size()==0)
								{
									site_bookable.add(site_reg);
								}
								else
								{
									//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
									for(int i_bookable=0;i_bookable<site_bookable.size();i_bookable++)
									{
										GolfSiteVo site_in=site_bookable.get(i_bookable);
										
										if(site_reg.getGolfPriceVo().getHPrice()<site_in.getGolfPriceVo().getHPrice())
										{
											site_bookable.add(i_bookable, site_reg);
											break;
										}
										else
										{
											if(i_bookable==site_bookable.size()-1)
											{
												site_bookable.add(site_reg);
												break;
											}
										}
									}
								}
							}
							else//对可以直接预订的球场排序
							{
								//先加进一条记录
								if(site_book.size()==0)
								{
									site_book.add(site_reg);
								}
								else
								{
									//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
									for(int i_book=0;i_book<site_book.size();i_book++)
									{
										GolfSiteVo site_in=site_book.get(i_book);
										
										if(site_reg.getGolfPriceVo().getHPrice()<site_in.getGolfPriceVo().getHPrice())
										{
											site_book.add(i_book, site_reg);
											break;
										}
										else
										{
											if(i_book==site_book.size()-1)
											{
												site_book.add(site_reg);
												break;
											}
										}
									}
								}
							}
						}
						else
						{
							
							//对有提前预订提示的球场排序
							if(dateDiff<site_reg.getGolfPriceVo().getTargeDate())
							{
								//先加进一条记录
								if(site_bookable.size()==0)
								{
									site_bookable.add(site_reg);
								}
								else
								{
									//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
									for(int i_bookable=0;i_bookable<site_bookable.size();i_bookable++)
									{
										GolfSiteVo site_in=site_bookable.get(i_bookable);
										
										if(site_reg.getGolfPriceVo().getPrice()<site_in.getGolfPriceVo().getPrice())
										{
											site_bookable.add(i_bookable, site_reg);
											break;
										}
										else
										{
											if(i_bookable==site_bookable.size()-1)
											{
												site_bookable.add(site_reg);
												break;
											}
										}
									}
								}
							}
							else//对可以直接预订的球场排序
							{
								//先加进一条记录
								if(site_book.size()==0)
								{
									site_book.add(site_reg);
								}
								else
								{
									//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
									for(int i_book=0;i_book<site_book.size();i_book++)
									{
										GolfSiteVo site_in=site_book.get(i_book);
										
										if(site_reg.getGolfPriceVo().getPrice()<site_in.getGolfPriceVo().getPrice())
										{
											site_book.add(i_book, site_reg);
											break;
										}
										else
										{
											if(i_book==site_book.size()-1)
											{
												site_book.add(site_reg);
												break;
											}
										}
									}
								}
							}
						}
					}
					
					sitelist_sort.addAll(site_book);
					sitelist_sort.addAll(site_bookable);
					golf_reg.setGolfsitelist(sitelist_sort);
					golf_reg.setGolfsite(golf_reg.getGolfsitelist().get(0));
				}

				//拍高尔夫产品的顺序
				List<GolfInfoVo> golf_result=new ArrayList<GolfInfoVo>();//封场的球场集合
				List<GolfInfoVo> golf_disabled=new ArrayList<GolfInfoVo>();//封场的球场集合
				List<GolfInfoVo> golf_bookable=new ArrayList<GolfInfoVo>();//有预订期限的球场集合
				List<GolfInfoVo> golf_book=new ArrayList<GolfInfoVo>();//可直接预订的球场集合
				
				iterator_gf=golflist.iterator();
				while(iterator_gf.hasNext())
				{
					GolfInfoVo golf_reg=iterator_gf.next();
					
					if(golf_reg.getSts().equalsIgnoreCase("0"))
					{
						golf_disabled.add(golf_reg);
					}
					else
					{
						if(isHoliday)
						{
							if(dateDiff<golf_reg.getGolfsite().getGolfPriceVo().getHTargeDate())
							{
								//先加进一条记录
								if(golf_bookable.size()==0)
								{
									golf_bookable.add(golf_reg);
								}
								else
								{
									//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
									for(int i_bookable=0;i_bookable<golf_bookable.size();i_bookable++)
									{
										GolfInfoVo golf_in=golf_bookable.get(i_bookable);
										
										if(golf_reg.getGolfsite().getGolfPriceVo().getHPrice()<golf_in.getGolfsite().getGolfPriceVo().getHPrice())
										{
											golf_bookable.add(i_bookable, golf_reg);
											break;
										}
										else
										{
											if(i_bookable==golf_bookable.size()-1)
											{
												golf_bookable.add(golf_reg);
												break;
											}
										}
									}
								}
							}
							else
							{
								//先加进一条记录
								if(golf_book.size()==0)
								{
									golf_book.add(golf_reg);
								}
								else
								{
									//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
									for(int i_book=0;i_book<golf_book.size();i_book++)
									{
										GolfInfoVo golf_in=golf_book.get(i_book);
										
										if(golf_reg.getGolfsite().getGolfPriceVo().getHPrice()<golf_in.getGolfsite().getGolfPriceVo().getHPrice())
										{
											golf_book.add(i_book, golf_reg);
											break;
										}
										else
										{
											if(i_book==golf_book.size()-1)
											{
												golf_book.add(golf_reg);
												break;
											}
										}
									}
								}
							}
						}
						else
						{
							if(dateDiff<golf_reg.getGolfsite().getGolfPriceVo().getTargeDate())
							{
								//先加进一条记录
								if(golf_bookable.size()==0)
								{
									golf_bookable.add(golf_reg);
								}
								else
								{
									//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
									for(int i_bookable=0;i_bookable<golf_bookable.size();i_bookable++)
									{
										GolfInfoVo golf_in=golf_bookable.get(i_bookable);
										
										if(golf_reg.getGolfsite().getGolfPriceVo().getPrice()<golf_in.getGolfsite().getGolfPriceVo().getPrice())
										{
											golf_bookable.add(i_bookable, golf_reg);
											break;
										}
										else
										{
											if(i_bookable==golf_bookable.size()-1)
											{
												golf_bookable.add(golf_reg);
												break;
											}
										}
									}
								}
							}
							else
							{
								//先加进一条记录
								if(golf_book.size()==0)
								{
									golf_book.add(golf_reg);
								}
								else
								{
									//判断没加进的记录和已经加进的记录价格大小，小的把大的往后挤
									for(int i_book=0;i_book<golf_book.size();i_book++)
									{
										GolfInfoVo golf_in=golf_book.get(i_book);
										
										if(golf_reg.getGolfsite().getGolfPriceVo().getPrice()<golf_in.getGolfsite().getGolfPriceVo().getPrice())
										{
											golf_book.add(i_book, golf_reg);
											break;
										}
										else
										{
											if(i_book==golf_book.size()-1)
											{
												golf_book.add(golf_reg);
												break;
											}
										}
									}
								}
							}
						}
					}
				}
				
				golf_result.addAll(golf_book);
				golf_result.addAll(golf_bookable);
				golf_result.addAll(golf_disabled);
				data=golf_result;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "success";
		}
		
		return "success";
	}
	
	/**
	 * 场地搜索
	 * @return
	 */
	public String searchSite(){
		if(name!=null && !"".equals(name)){
			search();
		}
		return "searchSite";
	}
	

	//下面专放getter and setter .................
	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public GolfInfoVo getGolfInfoVo() {
		return golfInfoVo;
	}

	public void setGolfInfoVo(GolfInfoVo golfInfoVo) {
		this.golfInfoVo = golfInfoVo;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBookTime() {
		return bookTime;
	}

	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}

	public String getGolfType() {
		return golfType;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public void setGolfType(String golfType) {
		this.golfType = golfType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	public long getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(long dateDiff) {
		this.dateDiff = dateDiff;
	}

	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
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

	public String getAfterOneTime() {//后一天
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

	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}

	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
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
	
}
