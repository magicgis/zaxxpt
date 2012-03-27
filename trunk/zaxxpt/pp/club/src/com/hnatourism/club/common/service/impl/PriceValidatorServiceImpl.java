package com.hnatourism.club.common.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.hnatourism.club.common.service.IPriceValidatorService;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.flight.web.vo.FlightAirport;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.golf.api.IApiDao;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.golf.order.vo.OrderContactVo;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.club.golf.prod.vo.SysHolidayVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeGuestVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
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
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.domain.MemberRole;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.web.vo.AbstractVo;

public class PriceValidatorServiceImpl implements IPriceValidatorService {
	
	//会员信息
	private IMemberAccountDao memberAccountDao;
	private IMemberInfoService memberInfoServ;
	private IMemberRoleService memberRoleServ;
	//高尔夫
	private IApiDao apiDao;
	//休息室
	private ILoungeInfoDao loungeInfoDao;
	private ILoungeRoomDao loungeRoomDao;
	private ILoungePriceDao loungePriceDao;

	
	/**
	 * 验证价格  
	 */
	@Override
	public Boolean validatPrice(Object obj,String memberId) {
		// TODO Auto-generated method stub
		Boolean result=true;
		MemberInfoVo memberInfoVo=null;
		
		try {
			memberInfoVo=new MemberInfoVo();
			memberInfoVo =(MemberInfoVo) memberInfoServ.findById(memberId);
			MemberAccount memberAccount=memberAccountDao.findByMember(memberId);
			MemberAccountVo meberAccountVo=new MemberAccountVo();
			BeanUtils.copyProperties(memberAccount, meberAccountVo);
			MemberRole memberRoleTemp=new MemberRole();
			memberRoleTemp.setId(memberAccount.getRole());
			MemberRoleVo memberRole=(MemberRoleVo) memberRoleServ.findByMember(memberRoleTemp);
			meberAccountVo.setMemberRole(memberRole);
			memberInfoVo.setMemberAccount(meberAccountVo);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(obj.getClass() == GolfOrderVo.class){
			result=validatGolf((GolfOrderVo)obj,memberInfoVo);
		}else if(obj.getClass() == OrderLoungeVo.class){
			result=validatLounge((OrderLoungeVo)obj,memberInfoVo);
		}else{
			result=false;
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean validatGolf(GolfOrderVo golfOrderVo,MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		
		GolfOrderVo sourceGolfOrderVo=new GolfOrderVo();
		Long ballCount=golfOrderVo.getTotalBall();//球数
		Long pepleCount=golfOrderVo.getCount();//打球人数
		Double signPrice=0.0;//签约价
		Double price=0.0;//销售价
		GolfPriceVo golfPriceVo=null;
		//查询
		HashMap<String,List<Map>> hm=new HashMap<String,List<Map>>();
		Map map=new HashMap();
		map.put("siteId", golfOrderVo.getSiteId());
		List<Map> list=new ArrayList<Map>();
		list.add(map);
		hm.put("api_findSitePriceBySite_Map",list);
		
		try {
			List<GolfPriceVo>  golfPricevoList= (List<GolfPriceVo>) apiDao.handler(new String[]{"api_findSitePriceBySite_Map"}, hm);
			if(golfPricevoList!=null){
				for(GolfPriceVo priceVo:golfPricevoList){
					Integer startDay=DateUtils.comDate(priceVo.getStartTime(), golfOrderVo.getBookTime());
					Integer endDays=DateUtils.comDate(golfOrderVo.getBookTime(), priceVo.getEndTime());
					if(startDay>=0 && endDays>=0){
						golfPriceVo=priceVo;
					}
				}
				if(golfPriceVo==null) return false;				
				if(isHoliday(golfOrderVo.getBookTime())){//判断是否是节假日
					signPrice=golfPriceVo.getHSigningprice()==null?golfPriceVo.getSigningPrice():golfPriceVo.getHSigningprice();
					price=golfPriceVo.getHPrice()==null?golfPriceVo.getPrice():golfPriceVo.getHPrice();
				}else{
					signPrice=golfPriceVo.getSigningPrice();
					price=golfPriceVo.getPrice();
				}
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		if(ballCount>0){
			sourceGolfOrderVo.setPrice(ballCount*price*100);
		}else{
			sourceGolfOrderVo.setPrice(pepleCount*price);
		}
		
		//计算分润
		double profitAmount=0.0;
		//如果 会员信息不为null  可以扩展对外接口  不提供会员信息
		if(memberInfoVo!=null){
			MemberAccountVo memberAccount=memberInfoVo.getMemberAccount();
			MemberRoleVo memberRole=memberAccount.getMemberRole();
			//计算优惠价
			SubRunBean subRunBean=new SubRunBean();
			subRunBean.setProdSignprice(signPrice);
			subRunBean.setProdSalePrice(price);
			subRunBean.setProdType("GF");
			subRunBean.setRoleCode(memberRole.getCode());
			
			if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
			{
				Map<String, String> rule_result=RuleConfigProfit.setRuleParam("GF", memberInfoVo.getRuleConfigList(), memberAccount.getOrganizationId());
				subRunBean.setSubCorpPoint(Double.parseDouble(rule_result.get("subCorpPoint")));
				subRunBean.setPlatformPoint(Double.parseDouble(rule_result.get("platformPoint")));
				subRunBean.setProfitpoint(rule_result.get("profitpoint"));
				subRunBean.setMemberFlowpoint(rule_result.get("memberFlowpoint"));
			}
			if(ballCount>0)
			{
				profitAmount=sourceGolfOrderVo.getPrice()-ballCount*100*SubRunUtils.getProdPrice(subRunBean);
			}
			else
			{
				profitAmount=sourceGolfOrderVo.getPrice()-pepleCount*SubRunUtils.getProdPrice(subRunBean);
			}
			
			
			String privilegeType="1";
			if(memberAccount.getPrivilegeType()!=null&&memberAccount.getPrivilegeType().equalsIgnoreCase("return"))
			{
				privilegeType="2";
			}
			if(!privilegeType.equalsIgnoreCase("1"))
			{
				//返积分
			}else{
				sourceGolfOrderVo.setPrice(sourceGolfOrderVo.getPrice()-profitAmount);
			}
		}
		sourceGolfOrderVo.setProfitAmount(profitAmount);
		sourceGolfOrderVo.setAdditionalFee(golfOrderVo.getAdditionalFee());
		sourceGolfOrderVo.setAmountPrice(golfOrderVo.getPrice()+golfOrderVo.getAdditionalFee());
		sourceGolfOrderVo.setSignPrice(signPrice);
		
		return validator(sourceGolfOrderVo,golfOrderVo,null,Date.class,Long.class,String.class,GolfPriceVo.class,GolfInfoVo.class,GolfSiteVo.class,List.class,OrderContactVo.class);
	}

	@Override
	public Boolean validatLounge(OrderLoungeVo orderLoungeVo,MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		
		OrderLoungeVo sourceOrderLoungeVo=new OrderLoungeVo();
		
		MemberAccountVo memberAccount=memberInfoVo.getMemberAccount();
		MemberRoleVo memberRole=memberAccount.getMemberRole();
		//休息室价格
		List<LoungePrice> pricelist=new ArrayList<LoungePrice>();
		//单收费项目
		List<LoungePrice> priceslist_temp=new ArrayList<LoungePrice>();
		Double childPrice=0.0;//儿童价
		Double adultPrice=0.0;//成人价
		Double priceMoney=0.0;//订单总价格
		
		Double additionalAllPrice_order=0.0;//单收费按单总价
		Double additionalAllPrice_peple=0.0;//单收费按人总价
		Double additionalAllPrice_order_down=0.0;//按单收费低价总价
		Double profitAmount=0.0;//返点金额或直减
		
		Integer timeCount=0;//贵宾间小时数
		Integer childCount=0;//儿童数量
		Integer adultCount=0;//成人数量
		
		List<OrderLoungeGuestVo> guestVoList=orderLoungeVo.getOrderLoungeGuestVoList();
		for(OrderLoungeGuestVo guestVo:guestVoList){
			if("儿童".equals(guestVo.getType())){
				childCount++;
			}else{
				adultCount++;
			}
		}
		
		try
		{
			LoungeRoom room_temp=loungeRoomDao.findById(orderLoungeVo.getRoomId());
			
			//价格列表
			LoungePrice price_condition=new LoungePrice();
			price_condition.setRoomId(room_temp.getId());
			pricelist=(List)loungePriceDao.findByRoomTypeN(price_condition);
			
			price_condition.setRoomType(room_temp.getType());
			price_condition.setRoomId(room_temp.getLoungeId());
			priceslist_temp=(List)loungePriceDao.findByRoomTypeS(price_condition);
			//计算单收费项目
			for(LoungePrice lop:priceslist_temp){
				if(orderLoungeVo.getAdditionalItemId().indexOf(lop.getItem())>=0){//判断该订单是否预定改收费项目
					if("1".equals(lop.getWay().trim())){//按单收费
						additionalAllPrice_order=additionalAllPrice_order+lop.getPrice();
						additionalAllPrice_order_down=additionalAllPrice_order_down+lop.getSigningPrice();
					}else{
						additionalAllPrice_peple=additionalAllPrice_peple+lop.getPrice();
					}
					profitAmount=profitAmount+(lop.getPrice()-lop.getSigningPrice());//将利润添加到 直减金额
				}
			}
			//价格处理
			if(pricelist!=null)
			{   
				LoungePriceVo loungepriceVo=new LoungePriceVo();
				BeanUtils.copyProperties(pricelist.get(0), loungepriceVo);
				if(loungepriceVo.getChildrenPrice()==null)
				{
					loungepriceVo.setChildrenPrice(loungepriceVo.getPrice());
				}
				
				SubRunBean subRunBean=new SubRunBean();
				subRunBean.setProdSignprice(loungepriceVo.getSigningPrice());
				subRunBean.setProdType("L");
				subRunBean.setRoleCode(memberRole.getCode());
				
				if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
				{
					Map<String, String> rule_result=RuleConfigProfit.setRuleParam("GF", memberInfoVo.getRuleConfigList(), memberAccount.getOrganizationId());
					subRunBean.setSubCorpPoint(Double.parseDouble(rule_result.get("subCorpPoint")));
					subRunBean.setPlatformPoint(Double.parseDouble(rule_result.get("platformPoint")));
					subRunBean.setProfitpoint(rule_result.get("profitpoint"));
					subRunBean.setMemberFlowpoint(rule_result.get("memberFlowpoint"));
				}
				if(memberAccount.getPrivilegeType()!=null&&memberAccount.getPrivilegeType().equalsIgnoreCase("return"))
				{  
					adultPrice=Math.ceil(loungepriceVo.getPrice());
					childPrice=Math.ceil(loungepriceVo.getChildrenPrice());
				}else{
					 //直减
					subRunBean.setProdSalePrice(loungepriceVo.getPrice());
					adultPrice=Math.ceil(SubRunUtils.getProdPrice(subRunBean));
					subRunBean.setProdSalePrice(loungepriceVo.getChildrenPrice());
					childPrice=Math.ceil(SubRunUtils.getProdPrice(subRunBean));
				}
				//贵宾间处理
				if("1".equals(room_temp.getType().trim())){
					timeCount=Integer.valueOf(String.valueOf(((orderLoungeVo.getEndTime().getTime()-orderLoungeVo.getStartTime().getTime())/(1000*60*60))));
					profitAmount=profitAmount+(loungepriceVo.getPrice()-adultPrice)*timeCount;
					//profitAmount=profitAmount+(loungepriceVo.getChildrenPrice()-childPrice)*timeCount;
					//childPrice=childPrice*timeCount;
					adultPrice=adultPrice*timeCount;
					additionalAllPrice_peple=additionalAllPrice_peple*(childCount+adultCount);
					priceMoney=adultPrice+additionalAllPrice_peple+additionalAllPrice_order;//无儿童
				}else{
					profitAmount=profitAmount+(loungepriceVo.getPrice()-adultPrice)*adultCount;
					profitAmount=profitAmount+(loungepriceVo.getChildrenPrice()-childPrice)*childCount;
					childPrice=childPrice*childCount;
					adultPrice=adultPrice*adultCount;
					additionalAllPrice_peple=additionalAllPrice_peple*(childCount+adultCount);
					priceMoney=childPrice+adultPrice+additionalAllPrice_peple+additionalAllPrice_order;
				}
				
				sourceOrderLoungeVo.setPrice(priceMoney);
				sourceOrderLoungeVo.setAdditionalFee(additionalAllPrice_peple+additionalAllPrice_order);
				sourceOrderLoungeVo.setAdditionalSignPrice(additionalAllPrice_order_down);
				sourceOrderLoungeVo.setSignPrice(loungepriceVo.getSigningPrice());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return validator(sourceOrderLoungeVo,orderLoungeVo,null,Date.class,Long.class,String.class,List.class,LoungeInfoVo.class,OrderContactVo.class,LoungeRoomVo.class,String [].class);
	}
	
	/**
	 * 验证属性值是否相等
	 */
	@Override
	public Boolean validator(Object source, Object target,
			String skipParameters, Type... skipType) {
		// TODO Auto-generated method stub
		Boolean result=true;
		
		if(source==null || target==null) return false;
		
		Field [] sourceFields= source.getClass().getDeclaredFields();
		for(Field  sourceField:sourceFields){
			Boolean isValidator=true;
			
			if(skipType!=null){
				for(Type sourceType:skipType){
					if(sourceField.getType()==sourceType) isValidator=false;
				}
			}
			if(skipParameters!=null){
				if(sourceField.getName().toLowerCase().indexOf(skipParameters.toLowerCase())>=0)
					isValidator=false;
			}
			
			if(isValidator){
				String methodName="get"+sourceField.getName().substring(0,1).toUpperCase()+sourceField.getName().substring(1);
				try {
					Method sourMethod=source.getClass().getMethod(methodName);
					Method targetMethod=target.getClass().getMethod(methodName);
					if(sourMethod!=null && targetMethod!=null){
						String sourvalue=String.valueOf(sourMethod.invoke(source));
						String targetvalue=String.valueOf(targetMethod.invoke(target));
						if(sourvalue!=null){
							if(!sourvalue.equals(targetvalue)) 
								result=false;
						}
					}
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					result=false;
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					result=false;
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					result=false;
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					result=false;
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					result=false;
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * 判断是否是节假日
	 * @param bookTime  yyyy-MM-dd
	 * @return
	 */
	public Boolean isHoliday(Date bookTime){
		Boolean isHoliday=false;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//显示预订日期
		Calendar calendar=Calendar.getInstance();
		try {
		if(bookTime==null){
			return false;
		}else{
			calendar.setTime(bookTime);
		}
		//数据库取值
		HashMap<String,List<Map>> hm=new HashMap<String,List<Map>>();
		Map map=new HashMap();
		map.put("date", sdf.format(bookTime));
		List<Map> list=new ArrayList<Map>();
		list.add(map);
		hm.put("api_findsysHolidayBydate",list);
		List<SysHolidayVo>  holidaylist= (List<SysHolidayVo>) apiDao.handler(new String[]{"api_findsysHolidayBydate"}, hm);
		if(holidaylist==null||holidaylist.size()==0){
			isHoliday=false;
		}else{
			isHoliday=true;
		}
		if(calendar.get(Calendar.DAY_OF_WEEK)==7||calendar.get(Calendar.DAY_OF_WEEK)==1)
		{
			isHoliday=true;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isHoliday=false;
		}
		return isHoliday;
	}
	
	public IApiDao getApiDao() {
		return apiDao;
	}

	public void setApiDao(IApiDao apiDao) {
		this.apiDao = apiDao;
	}
	

	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}

	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
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

	public static void main(String [] args){
		String sss="0.01";
		String sss1="Tue Nov 15 15:00:00 CST 2011";
		System.out.println(sss.equals(sss1));
	}

}
