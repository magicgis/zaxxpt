package com.hnatourism.club.loungeserver.prod;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;

import com.hnatourism.club.common.service.ICustomerProfitService;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.flight.web.vo.FlightAirport;
import com.hnatourism.club.lounge.prod.dao.IFlightAirlineComDao;
import com.hnatourism.club.lounge.prod.dao.IFlightAirportDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeLimitDao;
import com.hnatourism.club.lounge.prod.dao.ILoungePriceDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeRoomDao;
import com.hnatourism.club.lounge.prod.domain.FilghtAirlineCom;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
import com.hnatourism.club.lounge.prod.domain.LoungeLimit;
import com.hnatourism.club.lounge.prod.domain.LoungePrice;
import com.hnatourism.club.lounge.prod.domain.LoungeRoom;
import com.hnatourism.club.lounge.prod.vo.FilghtAirlineComVo;
import com.hnatourism.club.lounge.prod.vo.FilghtAirportVo;
import com.hnatourism.club.lounge.prod.vo.LoungeInfoVo;
import com.hnatourism.club.lounge.prod.vo.LoungeLimitVo;
import com.hnatourism.club.lounge.prod.vo.LoungePriceVo;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;
import com.hnatourism.club.loungeserver.IloungeBookApiService;
import com.hnatourism.club.loungeserver.LoungeApiService;
import com.hnatourism.club.member.rule.dao.IRuleConfigDao;
import com.hnatourism.club.member.rule.domain.RuleConfig;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;


/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室产品图片表
 * 
 * 历史版本:2011-08-15 v1.1.0 (高杰) 创建:
 * 
 */
public class LoungeBookApiServiceImpl extends LoungeApiService implements
IloungeBookApiService {

	private ILoungeInfoDao loungeInfoDao;
	private ILoungeRoomDao loungeRoomDao;
	private ILoungePriceDao loungePriceDao;
	private ILoungeLimitDao loungeLimitDao;
	private IFlightAirportDao flightAirportDao;
	private IFlightAirlineComDao flightAirlineComDao;
	private IRuleConfigDao ruleConfigDao;
	private IMemberAccountDao memberAccountDao;
	private ICustomerProfitService customerProfitServ;
	private IMemberInfoService memberInfoServ;
	private IMemberRoleService memberRoleServ;
	
	
	@Override
	public void endHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute()
	{
		
		LoungeRoomVo room=new LoungeRoomVo();
		LoungeInfoVo lounge=new LoungeInfoVo();
		LoungePriceVo priceN=new LoungePriceVo();
		FilghtAirportVo airport=new FilghtAirportVo();
		List<FilghtAirlineComVo> airlinelist=new ArrayList<FilghtAirlineComVo>();
		List<LoungePriceVo> pricelist=new ArrayList<LoungePriceVo>();
		List<LoungeLimitVo> limitlist=new ArrayList<LoungeLimitVo>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			//休息室信息
			Map<String,String> parems=(Map<String,String>)super.permeters;
			System.out.println(parems!=null);
			System.out.println(parems.size());
			LoungeRoom room_temp=loungeRoomDao.findById(parems.get("id"));
			LoungeInfo lounge_temp=loungeInfoDao.findById(room_temp.getLoungeId());
			
			//机场
			List<FlightAirport> airportlist=(List<FlightAirport>)flightAirportDao.findByCode(lounge_temp.getAirportCode());
			if(airportlist!=null&&airportlist.size()>0)
			{
				BeanUtils.copyProperties(airportlist.get(0), airport);
			}
			
			//航空公司
			String[] airlinestr=lounge_temp.getAirlineCorp().split(",");
			for(int i=0;i<airlinestr.length;i++)
			{
				FilghtAirlineComVo airline=new FilghtAirlineComVo();
				List<FilghtAirlineCom> airlinelist_temp=(List<FilghtAirlineCom>)flightAirlineComDao.findByCode(airlinestr[i]);
				if(airlinelist_temp!=null&&airlinelist_temp.size()>0)
				{
					BeanUtils.copyProperties(airlinelist_temp.get(0), airline);
					airlinelist.add(airline);
				}
			}
			
			//价格列表
			LoungePrice price_condition=new LoungePrice();
			price_condition.setRoomId(room_temp.getId());
			List pricenlist_temp=(List)loungePriceDao.findByRoomTypeN(price_condition);
			Iterator<LoungePrice> pricen_i=pricenlist_temp.iterator();
			while(pricen_i.hasNext())
			{
				LoungePriceVo price=new LoungePriceVo();
				BeanUtils.copyProperties(pricen_i.next(), price);
				
				price.setPrice_reg(price.getPrice());
				price.setCprice_reg(price.getChildrenPrice()==null?price.getPrice():price.getChildrenPrice());
				if(price.getChildrenPrice()==null)
				{
					price.setChildrenPrice(price.getPrice());
				}
				
				SubRunBean subRunBean=new SubRunBean();
				subRunBean.setProdSignprice(price.getSigningPrice());
				subRunBean.setProdType("L");
				subRunBean.setRoleCode(parems.get("rolecode"));
				
				if(parems.get("rolecode").toString().equalsIgnoreCase("GOVERNMENT"))
				{
					subRunBean.setSubCorpPoint(Double.parseDouble(parems.get("subCorpPoint").toString()));
					subRunBean.setPlatformPoint(Double.parseDouble(parems.get("platformPoint").toString()));
					subRunBean.setProfitpoint(parems.get("profitpoint").toString());
					subRunBean.setMemberFlowpoint(parems.get("memberFlowpoint").toString());
				}
				
				if(parems.get("privilegetype")==null||parems.get("privilegetype").equalsIgnoreCase("null")||parems.get("privilegetype").equalsIgnoreCase("MINUS"))
				{
					subRunBean.setProdSalePrice(price.getPrice());
					price.setPrice(SubRunUtils.getProdPrice(subRunBean));
					subRunBean.setProdSalePrice(price.getChildrenPrice());
					price.setChildrenPrice(SubRunUtils.getProdPrice(subRunBean));
				}
	
				price.setPrice(Math.ceil(price.getPrice()));
				price.setChildrenPrice(Math.ceil(price.getChildrenPrice()));
				
				priceN=price;
				pricelist.add(price);
			}
			price_condition.setRoomId(room_temp.getLoungeId());
			price_condition.setRoomType(room_temp.getType());
			List priceslist_temp=(List)loungePriceDao.findByRoomTypeS(price_condition);
			Iterator<LoungePrice> prices_i=priceslist_temp.iterator();
			while(prices_i.hasNext())
			{
				LoungePriceVo price=new LoungePriceVo();
				BeanUtils.copyProperties(prices_i.next(), price);
				
				if(price.getChildrenPrice()==null)
				{
					price.setChildrenPrice(price.getPrice());
				}
				
				pricelist.add(price);
			}
			
			//确认与预订时间相对应的维修时间
			LoungeLimit limit_condition=new LoungeLimit();
			limit_condition.setRoomId(room_temp.getId());
			List<LoungeLimit> limitlist_temp=(List<LoungeLimit>)loungeLimitDao.findByRoom(limit_condition);
			Iterator<LoungeLimit> limit_i=limitlist_temp.iterator();
			while(limit_i.hasNext())
			{
				LoungeLimitVo limit=new LoungeLimitVo();
				LoungeLimit limit_each=limit_i.next();
				String start_date_str=sdf.format(limit_each.getStartTime());
				String end_date_str=sdf.format(limit_each.getEndTime());
				if(start_date_str.compareTo(parems.get("bookTime").toString())<=0&&end_date_str.compareTo(parems.get("bookTime").toString())>=0)
				{
					BeanUtils.copyProperties(limit_each, limit);
					limitlist.add(limit);
				}
			}
			
			//预订时间区分
			List<String> workTimelist=new ArrayList<String>();
			List<String> workTimeStatusList=new ArrayList<String>();
			String starttime=room_temp.getStartTime();
			String endtime=room_temp.getEndTime();
			int start=Integer.parseInt(starttime.substring(0,starttime.indexOf(":")));
			int end=Integer.parseInt(endtime.substring(0,endtime.indexOf(":")));
			
			for(int i=start;i<=end;i++)
			{
				workTimelist.add(i+":00");
				boolean isfixing=false;
				
				Iterator<LoungeLimitVo> limit_match_i=limitlist.iterator();
				while(limit_match_i.hasNext())
				{
					LoungeLimitVo limit_match=limit_match_i.next();
					if(limit_match.getId()!=null||!limit_match.getId().equalsIgnoreCase(""))
					{
						String start_date=sdf.format(limit_match.getStartTime());
						String end_date=sdf.format(limit_match.getEndTime());
						
						Calendar calendar_start=Calendar.getInstance();
						Calendar calendar_end=Calendar.getInstance();
						Calendar calendar_now=Calendar.getInstance();
						try
						{
							calendar_start.setTime(sdf.parse(start_date));
							calendar_end.setTime(sdf.parse(end_date));
							calendar_now.setTime(sdf.parse(parems.get("bookTime").toString()));
						}
						catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						int start_hour=0;
						int end_hour=0;
						long start_book=(calendar_now.getTimeInMillis()-calendar_start.getTimeInMillis())/(1000*60*60);
						long end_book=(calendar_end.getTimeInMillis()-calendar_now.getTimeInMillis())/(1000*60*60);
						long start_end=(calendar_end.getTimeInMillis()-calendar_start.getTimeInMillis())/(1000*60*60);
						
						if(start_end==0)
						{
							start_hour=Integer.parseInt(new SimpleDateFormat("HH").format(limit_match.getStartTime()));
							end_hour=Integer.parseInt(new SimpleDateFormat("HH").format(limit_match.getEndTime()));
							String end_minite=new SimpleDateFormat("mm").format(limit_match.getEndTime());
							if(!end_minite.equalsIgnoreCase("00"))
							{
								end_hour+=1;
							}
						}
						else if(start_book==0)
						{
							start_hour=Integer.parseInt(new SimpleDateFormat("HH").format(limit_match.getStartTime()));
							end_hour=24;
						}
						else if(end_book==0)
						{
							end_hour=Integer.parseInt(new SimpleDateFormat("HH").format(limit_match.getEndTime()));
							String end_minite=new SimpleDateFormat("mm").format(limit_match.getEndTime());
							if(!end_minite.equalsIgnoreCase("00"))
							{
								end_hour+=1;
							}
						}
						else
						{
							end_hour=24;
						}
						
						
						if(i>=start_hour&&i<=end_hour)
						{
							isfixing=true;
							
							break;
						}
					}
				}
				
				if(!isfixing)
				{
					workTimeStatusList.add("0");
				}
				else
				{
					workTimeStatusList.add("1");
				}
			}
			
			BeanUtils.copyProperties(lounge_temp, lounge);
			BeanUtils.copyProperties(room_temp, room);
			
			lounge.setAirlinelist(airlinelist);
			lounge.setAirport(airport);
			room.setLounge(lounge);
			room.setLoungePriceVo(priceN);
			room.setPricelist(pricelist);
			room.setWorkTimeList(workTimelist);
			room.setWorkTimeStatusList(workTimeStatusList);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		super.returnObj=room;
	}

	@Override
	public void init(Object permeters, Type type) {
		// TODO Auto-generated method stub
		super.permeters=permeters;
		super.type=type;
	}

	@Override
	public void parameterHandler() throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> parems=new HashMap<String, String>();
		String[] parem=super.permeters.toString().split("&&");
		for(int i=0;i<parem.length;i++)
		{
			String each_parem=parem[i];
			String key=each_parem.substring(0,each_parem.indexOf("="));
			String value=each_parem.substring(each_parem.indexOf("=")+1);
			
			parems.put(key, value);
		}
		
		super.permeters=parems;
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return super.returnObj;
	}

	public ILoungeInfoDao getLoungeInfoDao() {
		return loungeInfoDao;
	}

	public void setLoungeInfoDao(ILoungeInfoDao loungeInfoDao) {
		this.loungeInfoDao = loungeInfoDao;
	}

	public ILoungeRoomDao getLoungeRoomDao() {
		return loungeRoomDao;
	}

	public void setLoungeRoomDao(ILoungeRoomDao loungeRoomDao) {
		this.loungeRoomDao = loungeRoomDao;
	}

	public ILoungePriceDao getLoungePriceDao() {
		return loungePriceDao;
	}

	public void setLoungePriceDao(ILoungePriceDao loungePriceDao) {
		this.loungePriceDao = loungePriceDao;
	}

	public ILoungeLimitDao getLoungeLimitDao() {
		return loungeLimitDao;
	}

	public void setLoungeLimitDao(ILoungeLimitDao loungeLimitDao) {
		this.loungeLimitDao = loungeLimitDao;
	}

	public IFlightAirportDao getFlightAirportDao() {
		return flightAirportDao;
	}

	public void setFlightAirportDao(IFlightAirportDao flightAirportDao) {
		this.flightAirportDao = flightAirportDao;
	}

	public IFlightAirlineComDao getFlightAirlineComDao() {
		return flightAirlineComDao;
	}

	public void setFlightAirlineComDao(IFlightAirlineComDao flightAirlineComDao) {
		this.flightAirlineComDao = flightAirlineComDao;
	}

	public IRuleConfigDao getRuleConfigDao() {
		return ruleConfigDao;
	}

	public void setRuleConfigDao(IRuleConfigDao ruleConfigDao) {
		this.ruleConfigDao = ruleConfigDao;
	}

	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}

	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
	}

	public void setCustomerProfitServ(ICustomerProfitService customerProfitServ) {
		this.customerProfitServ = customerProfitServ;
	}

	public IMemberInfoService getMemberInfoServ() {
		return memberInfoServ;
	}

	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}

	public IMemberRoleService getMemberRoleServ() {
		return memberRoleServ;
	}

	public void setMemberRoleServ(IMemberRoleService memberRoleServ) {
		this.memberRoleServ = memberRoleServ;
	}
}
