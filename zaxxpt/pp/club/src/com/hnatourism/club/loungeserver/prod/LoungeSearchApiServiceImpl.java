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

import org.springframework.beans.BeanUtils;

import com.hnatourism.club.common.domain.FlightAirport;
import com.hnatourism.club.common.service.ICustomerProfitService;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.lounge.prod.dao.IFlightAirlineComDao;
import com.hnatourism.club.lounge.prod.dao.IFlightAirportDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeImgDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
import com.hnatourism.club.lounge.prod.dao.ILoungePriceDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeRoomDao;
import com.hnatourism.club.lounge.prod.domain.FilghtAirlineCom;
import com.hnatourism.club.lounge.prod.domain.LoungeImg;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
import com.hnatourism.club.lounge.prod.domain.LoungePrice;
import com.hnatourism.club.lounge.prod.domain.LoungeRoom;
import com.hnatourism.club.lounge.prod.vo.FilghtAirlineComVo;
import com.hnatourism.club.lounge.prod.vo.FilghtAirportVo;
import com.hnatourism.club.lounge.prod.vo.LoungeImgVo;
import com.hnatourism.club.lounge.prod.vo.LoungeInfoVo;
import com.hnatourism.club.lounge.prod.vo.LoungePriceVo;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;
import com.hnatourism.club.lounge.prod.vo.PageVo;
import com.hnatourism.club.loungeserver.IloungeSearchApiService;
import com.hnatourism.club.loungeserver.LoungeApiService;
import com.hnatourism.club.member.rule.dao.IRuleConfigDao;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.utils.ListUtils;


public class LoungeSearchApiServiceImpl extends LoungeApiService implements
IloungeSearchApiService {

	private ILoungeInfoDao loungeInfoDao;
	private ILoungeRoomDao loungeRoomDao;
	private ILoungePriceDao loungePriceDao;
	private IFlightAirportDao flightAirportDao;
	private IFlightAirlineComDao flightAirlineComDao;
	private ILoungeImgDao loungeImgDAO;
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
	/**
	 * 2011-08-15 v1.1.0 (高杰) :
	 */
	public void execute() {
		// TODO Auto-generated method stub
		HashMap<String, Object> perme=(HashMap<String, Object>)super.permeters;
		
		List<LoungeInfo> loungelist_temp=null;
		if(perme.get("cityorap").toString().equalsIgnoreCase("yes"))
		{
			loungelist_temp=loungeInfoDao.findBySearchCity(perme);
		}
		else
		{
			loungelist_temp=loungeInfoDao.findBySearch(perme);
		}
		List<LoungeInfoVo> loungelist=new ArrayList<LoungeInfoVo>();
		PageInfo pageInfo=new PageInfo();
		PageVo page=new PageVo();
		
		try
		{
			//计算分页信息
			String currentpage=perme.get("currentPage").toString();
			pageInfo.setCurrentPageNum(currentpage.equalsIgnoreCase("0")?1:Integer.parseInt(currentpage));
			pageInfo.setRowsOfPage(30);
			pageInfo.setTotalRowCount(loungelist_temp.size());
			pageInfo.setTotalPageCount(pageInfo.getRowsOfPage(), loungelist_temp.size());
			
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
			
			perme.put("startnum", startnum);
			perme.put("endnum", endnum);
			
			if(perme.get("cityorap").toString().equalsIgnoreCase("yes"))
			{
				loungelist_temp=loungeInfoDao.findBySearchCityPage(perme);
			}
			else
			{
				loungelist_temp=loungeInfoDao.findBySearchPage(perme);
			}
			Iterator lounge_i=loungelist_temp.iterator();
			while(lounge_i.hasNext())
			{
				int index=0;
				LoungeInfoVo lounge=new LoungeInfoVo();
				BeanUtils.copyProperties(lounge_i.next(), lounge);
				List<LoungeRoomVo> roomlist=new ArrayList<LoungeRoomVo>();
				LoungeRoom room_condition=new LoungeRoom();
				room_condition.setLoungeId(lounge.getId());
				
				//谷建亮添加
				LoungePrice pricec=new LoungePrice();
				pricec.setRoomId(lounge.getId());//数据库中存放的是loungid
				pricec.setType("S");
				pricec.setSts("1");
				List<LoungePrice> s_price_list=loungePriceDao.findByWhere(pricec);
				
				if(perme.get("type")!=null)
				{
					room_condition.setType(perme.get("type").toString());
				}
				List<LoungeRoom> roomlist_temp=loungeRoomDao.findBySearch(room_condition);
				Iterator<LoungeRoom> roomlist_i=roomlist_temp.iterator();
				while(roomlist_i.hasNext())
				{
					LoungeRoomVo room=new LoungeRoomVo();
					BeanUtils.copyProperties(roomlist_i.next(), room);
					
					Calendar calendar_time=Calendar.getInstance();
					try {
						if(perme.get("time")!=null){
							calendar_time.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(perme.get("time").toString()));
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Calendar calendar_start=Calendar.getInstance();
					calendar_start.setTime(room.getStartDate());
					Calendar calendar_end=Calendar.getInstance();
					calendar_end.setTime(room.getEndDate());
					
					if((calendar_start.getTimeInMillis()<=calendar_time.getTimeInMillis()&&calendar_end.getTimeInMillis()>=calendar_time.getTimeInMillis())||perme.get("id")!=null)
					{
						LoungePriceVo price=new LoungePriceVo();
						LoungePrice price_condition=new LoungePrice();
						price_condition.setRoomId(room.getId());
						List<LoungePrice> pricelist=loungePriceDao.findByRoomTypeN(price_condition);
						if(pricelist!=null&&pricelist.size()!=0)
						{
							BeanUtils.copyProperties(pricelist.get(0), price);
							if(price.getChildrenPrice()==null)
							{
								price.setChildrenPrice(price.getPrice());
							}
							
							SubRunBean subRunBean=new SubRunBean();
							subRunBean.setProdSignprice(price.getSigningPrice());
							subRunBean.setProdType("L");
							subRunBean.setRoleCode(perme.get("rolecode").toString());
							
							if(perme.get("rolecode").toString().equalsIgnoreCase("GOVERNMENT"))
							{
								subRunBean.setSubCorpPoint(Double.parseDouble(perme.get("subCorpPoint").toString()));
								subRunBean.setPlatformPoint(Double.parseDouble(perme.get("platformPoint").toString()));
								subRunBean.setProfitpoint(perme.get("profitpoint").toString());
								subRunBean.setMemberFlowpoint(perme.get("memberFlowpoint").toString());
							}
							
							if(perme.get("privilegetype")==null||perme.get("privilegetype").toString().equalsIgnoreCase("MINUS"))
							{
								subRunBean.setProdSalePrice(price.getPrice());
								price.setPrice(SubRunUtils.getProdPrice(subRunBean));
								subRunBean.setProdSalePrice(price.getChildrenPrice());
								price.setChildrenPrice(SubRunUtils.getProdPrice(subRunBean));
							}
							
							price.setPrice(Math.ceil(price.getPrice()));
							price.setChildrenPrice(Math.ceil(price.getChildrenPrice()));
							//谷建亮添加查询单收费项目价格
							if(perme.get("id")!=null){
								List<LoungePriceVo> priceLv=new ArrayList<LoungePriceVo>();
								for(LoungePrice lprice:s_price_list){
									//判断该单收费项目中 有没有该休息室类型
									if(lprice.getResources_type().contains(room.getType())){
										LoungePriceVo lpvo=new LoungePriceVo();
										BeanUtils.copyProperties(lprice, lpvo);
										priceLv.add(lpvo);
									}
								}
								room.setPricelist(priceLv);
							}
							
							room.setLoungePriceVo(price);
							//查询缩略图
							LoungeImg loungeImg=new LoungeImg();
							loungeImg.setType("2");
							loungeImg.setLoungeId(room.getId());
							List<LoungeImg> loungeImgList=loungeImgDAO.findByWhere(loungeImg);
							if(!ListUtils.isEmpty(loungeImgList)){
								loungeImg=loungeImgList.get(0);
								LoungeImgVo loungeImgVo=new LoungeImgVo();
								BeanUtils.copyProperties(loungeImg, loungeImgVo);
								room.setLoungeImgVo(loungeImgVo);
							}
							//roomlist.add(room);
							if((calendar_start.getTimeInMillis()<=calendar_time.getTimeInMillis()&&calendar_end.getTimeInMillis()>=calendar_time.getTimeInMillis())){
								
							
							if(index==0)
							{
								roomlist.add(room);
							}
							else
							{
								for(int i=0;i<roomlist.size();i++)
								{
									LoungeRoomVo room_after=roomlist.get(i);
									if(room.getLoungePriceVo().getPrice()<room_after.getLoungePriceVo().getPrice())
									{
										roomlist.add(i, room);
										break;
									}
									else
									{
										if(i==roomlist.size()-1)
										{
											roomlist.add(room);
											break;
										}
										else
										{
											continue;
										}
									}
								}
							}
							index++;
							
							}
						}
						else
						{
							price=null;
						}
					}
				}
				
				//机场
				FilghtAirportVo airport=new FilghtAirportVo();
				List<FlightAirport> airportlist=(List<FlightAirport>)flightAirportDao.findByCode(lounge.getAirportCode());
				if(airportlist!=null&&airportlist.size()>0)
				{
					BeanUtils.copyProperties(airportlist.get(0), airport);
				}
				
				//航空公司
				List<FilghtAirlineComVo> airlinelist=new ArrayList<FilghtAirlineComVo>();
				if(lounge.getAirlineCorp()!=null)
				{
					String[] airlinestr=lounge.getAirlineCorp().split(",");
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
				}
				
				//图片
				LoungeImgVo image=new LoungeImgVo();
				Object o=loungeImgDAO.findBySearch(lounge.getId());
				if(o!=null)
				{
					BeanUtils.copyProperties(o, image);
				}
				//查询平面图  谷建亮添加
				if(perme.get("id")!=null){
					LoungeImg  imageVo=new LoungeImg ();
					imageVo.setLoungeId(lounge.getId());
					imageVo.setType("1");
					imageVo.setSts("1");
					List<LoungeImg> loungeImgList=loungeImgDAO.findByWhere(imageVo);
					List<LoungeImgVo> loungeImgVoList=new ArrayList<LoungeImgVo>();
					for(LoungeImg li:loungeImgList){
						LoungeImgVo v=new LoungeImgVo();
						BeanUtils.copyProperties(li, v);
						loungeImgVoList.add(v);
					}
					
					lounge.setLoungeImgVoList(loungeImgVoList);
				}
				
				
				lounge.setRoomlist(roomlist);
				lounge.setAirlinelist(airlinelist);
				lounge.setAirport(airport);
				lounge.setImage(image);
				
				if(lounge.getRoomlist().size()>0 ||perme.get("id")!=null )
				{
					loungelist.add(lounge);
				}
			}
			
			page.setLoungeList(loungelist);
			pageInfo.setTotalRowCount(loungelist.size());
			page.setPageInfo(pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.returnObj=page;
	}

	@Override
	public void init(Object permeters, Type type) {
		// TODO Auto-generated method stub
		super.permeters=permeters;
		super.type=type;
	}

	@Override
	/**
	 * 2011-08-15 v1.1.0 (高杰) :
	 */
	public void parameterHandler() throws Exception {
		// TODO Auto-generated method stub
		//对象初始化
		Map<String, Object> parems=new HashMap<String, Object>();
		String[] parem=super.permeters.toString().split("&&");
		for(int i=0;i<parem.length;i++)
		{
			String each_parem=parem[i];
			String key=each_parem.substring(0,each_parem.indexOf("="));
			String value=each_parem.substring(each_parem.indexOf("=")+1);
			
			if(!value.equalsIgnoreCase("null"))
			{
				parems.put(key, value);
			}
		}
		
		super.permeters=parems;
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return super.returnObj;
	}

	public ILoungeRoomDao getLoungeRoomDao() {
		return loungeRoomDao;
	}

	public void setLoungeRoomDao(ILoungeRoomDao loungeRoomDao) {
		this.loungeRoomDao = loungeRoomDao;
	}

	public ILoungeInfoDao getLoungeInfoDao() {
		return loungeInfoDao;
	}

	public void setLoungeInfoDao(ILoungeInfoDao loungeInfoDao) {
		this.loungeInfoDao = loungeInfoDao;
	}

	public ILoungePriceDao getLoungePriceDao() {
		return loungePriceDao;
	}

	public void setLoungePriceDao(ILoungePriceDao loungePriceDao) {
		this.loungePriceDao = loungePriceDao;
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

	public ILoungeImgDao getLoungeImgDAO() {
		return loungeImgDAO;
	}

	public void setLoungeImgDAO(ILoungeImgDao loungeImgDAO) {
		this.loungeImgDAO = loungeImgDAO;
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
