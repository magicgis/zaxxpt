package com.hnatourism.club.loungeserver.order;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.service.IPriceValidatorService;
import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.lounge.order.dao.ILogLoungeOrderDao;
import com.hnatourism.club.lounge.order.dao.IOrderContactDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeGuestDao;
import com.hnatourism.club.lounge.order.domain.LogLoungeOrder;
import com.hnatourism.club.lounge.order.domain.OrderContact;
import com.hnatourism.club.lounge.order.domain.OrderLounge;
import com.hnatourism.club.lounge.order.domain.OrderLoungeGuest;
import com.hnatourism.club.lounge.order.vo.OrderLoungeGuestVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.lounge.prod.dao.ILoungeRoomDao;
import com.hnatourism.club.loungeserver.LoungeApiService;

public class LoungeOrderApiServiceImpl extends LoungeApiService implements
IloungeOrderApiService {

	private ILogLoungeOrderDao logLoungeOrderDao;
	private IOrderLoungeDao orderLoungeDao;
	private IOrderLoungeGuestDao orderLoungeGuestDao;
	private ILoungeRoomDao loungeRoomDao;
	private IOrderContactDao orderContactDao;
	private IPriceValidatorService priceValidatorService;
	
	@Override
	public void endHandler() {
		// TODO Auto-generated method stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Map<String, Object> parems=(Map<String, Object>)super.permeters;
		OrderLoungeVo result=new OrderLoungeVo();
		
		OrderLounge order=(OrderLounge)parems.get("order");
		List<OrderLoungeGuest> guestlist=(List<OrderLoungeGuest>)parems.get("guest");
		LogLoungeOrder log=(LogLoungeOrder)parems.get("log");
		OrderContact contact=(OrderContact)parems.get("contact");
		//LoungeRoom room=(LoungeRoom)parems.get("room");
		
		orderLoungeDao.insert(order);
		logLoungeOrderDao.insert(log);
		orderContactDao.insert(contact);
		//loungeRoomDao.updateOrder(room);
		for(int i=0;i<guestlist.size();i++)
		{
			orderLoungeGuestDao.insert(guestlist.get(i));
		}
		
		BeanUtils.copyProperties(order, result);
		
		super.returnObj=result;
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
		//对象初始化
		Map<String, Object> paremsObject=new HashMap<String, Object>();
		Map<String, Object> parems=new HashMap<String, Object>();
		OrderLounge order=new OrderLounge();
		List<OrderLoungeGuest> guestlist=new ArrayList<OrderLoungeGuest>();
		LogLoungeOrder log=new LogLoungeOrder();
		
		//组建参数MAP
		if(!super.permeters.toString().equalsIgnoreCase(""))
		{
			String[] paremlist=super.permeters.toString().split("&&");
			for(int i=0;i<paremlist.length;i++)
			{
				String parem=paremlist[i];
				String key=parem.substring(0,parem.indexOf('='));
				String value=parem.substring(parem.indexOf('=')+1);
				
				parems.put(key, value);
			}
		}
		
		//订单信息
		order.setId(SnoGerUtil.getUUID());
		order.setRoomId(parems.get("roomId").toString());
		order.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(parems.get("bookTime").toString()+" "+parems.get("starttime").toString()+":00"));
		
		if(parems.get("way").toString().equalsIgnoreCase("1"))
		{
			order.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(parems.get("bookTime").toString()+" "+parems.get("endtime").toString()+":00"));
		}
		order.setSts(parems.get("sts").toString());
		order.setConsumerSts("0");
		order.setCreateTime(new Date());
		order.setPrice(Double.parseDouble(parems.get("price").toString()));
		order.setOperateSts("0");
		order.setMemberId(parems.get("memberId").toString());
		order.setAdditionalItemId(parems.get("idlist_order").toString());
		order.setAdditionalFee(Double.parseDouble(parems.get("price_order").toString()));
		order.setAdditionalSignPrice(Double.parseDouble(parems.get("sprice_order").toString()));
		order.setConfirmEndTime(null);
		order.setProfitAmount(parems.get("profitAmount").toString());
		order.setSignPrice(Double.parseDouble(parems.get("signPrice").toString()));
		order.setProfit(parems.get("profit").toString());
		order.setRmk("");
		order.setPaySts("0");
		order.setCode(SnoGerUtil.getOrderNo());
		order.setFlightNo(parems.get("flightNo").toString());
		if(parems.get("roomType").toString().equalsIgnoreCase("3"))
		{
			order.setConfirmTime(order.getStartTime());
		}
		else
		{
			order.setConfirmTime(null);
		}
		if(parems.get("createUser")!=null&&!parems.get("createUser").toString().equalsIgnoreCase(""))
		{
			order.setCreateUser(parems.get("createUser").toString());
		}
		else
		{
			order.setCreateUser(parems.get("memberCode").toString());
		}
		// 订单来源
		if(parems.get("source") ==null || parems.get("source").toString().equalsIgnoreCase("")){
			order.setSource(Constants.CLUB_ORDER_SOURCE);
		}else{
			order.setSource(parems.get("source").toString());
		}

		//顾客信息
		String pgairline_str=parems.get("passengerairline").toString();
		String pgName_str=parems.get("passengerName").toString().replace("_", "/");
		String pginfo_str=parems.get("pginfo").toString();
		
		String[] pgairlinelist=pgairline_str.split(",");
		String[] pgNamelist=pgName_str.split(",");
		String[] pginfolist=pginfo_str.split(",");
		for(int x=0;x<pgairlinelist.length;x++)
		{
			OrderLoungeGuest guest=new OrderLoungeGuest();
			
			guest.setId(UUID.randomUUID().toString().replace("-", ""));
			guest.setName(pgNamelist[x]);
			guest.setType(pginfolist[2*x]);
			guest.setFlightNo(pginfolist[2*x+1]+pgairlinelist[x]);
			guest.setOrderId(order.getId());
			guest.setConsumerSts("0");
			guest.setCreateTime(new Date());
			guest.setCreateUser(parems.get("memberCode").toString());
			guest.setOrderType("NML");
			guest.setAdditionalItemId(parems.get("idlist_people").toString());
			guest.setAdditionalFee(Double.parseDouble(parems.get("price_people").toString())/pgairlinelist.length);
			guest.setAdditionalSignPrice(Double.parseDouble(parems.get("sprice_people").toString())/pgairlinelist.length);
			guest.setMemberPassengerId(null);
			
			if(parems.get("childrenPrice")!=null && "儿童".equals(guest.getType())){
				guest.setPrice(Double.valueOf((String) parems.get("childrenPrice")));//儿童价
			}else{
				if(parems.get("auPrice")!=null){
					guest.setPrice(Double.valueOf((String) parems.get("auPrice")));//成人价
				}
			}
			
			guestlist.add(guest);
		}
		if (order.getLoungeType()==null) {
			order.setLoungeType("");
		}
		//日志信息
		//两舱也是提交预订（在分润的时候预订成功）（这里不要判断）
		//贵宾间和贵宾房提交预订
			log.setId(UUID.randomUUID().toString().replace("-", ""));
			log.setOrderId(order.getId());
			log.setContent(Constants.OrderLogInfo.ORDER_BOOK);
			log.setCreateUser(parems.get("memberCode").toString());
			log.setCreateTime(new Date());
			log.setType(null);
		//订单联系人信息
		OrderContact contact=new OrderContact();
		contact.setId(UUID.randomUUID().toString().replace("-", ""));
		contact.setName(parems.get("loginerName").toString());
		contact.setMobile(parems.get("loginerContact").toString());
		contact.setEmail(parems.get("loginerEmail").toString());
		contact.setCreateTime(new Date());
		contact.setCreateUser(parems.get("memberCode").toString());
		contact.setOrderId(order.getId());
		contact.setOrderCode(order.getCode());
		contact.setProdType("2");
		
		//房间信息
//		LoungeRoom room=new LoungeRoom();
//		room.setId(parems.get("roomId").toString());
//		room.setQuantity(1l);
//		room.setUpdateTime(new Date());
//		room.setUpdateUser(parems.get("loginerName").toString());

		paremsObject.put("order", order);
		paremsObject.put("guest", guestlist);
		paremsObject.put("log", log);
		//paremsObject.put("room", room);
		paremsObject.put("contact", contact);
		
		//System.out.println("=====================");
		//价格验证
		OrderLoungeVo orderLoungeVo=new OrderLoungeVo();
		BeanUtils.copyProperties(order, orderLoungeVo);
		List<OrderLoungeGuestVo> guestlistVo=new ArrayList<OrderLoungeGuestVo>();
		for(OrderLoungeGuest olg:guestlist){
			OrderLoungeGuestVo olgv=new OrderLoungeGuestVo();
			BeanUtils.copyProperties(olg, olgv);
			guestlistVo.add(olgv);
		}
		orderLoungeVo.setOrderLoungeGuestVoList(guestlistVo);
		Boolean isThr=priceValidatorService.validatPrice(orderLoungeVo, order.getMemberId());
		if(!isThr){//验证失败
			return;
		}
		super.permeters=paremsObject;
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return super.returnObj;
	}
	public ILogLoungeOrderDao getLogLoungeOrderDao() {
		return logLoungeOrderDao;
	}

	public void setLogLoungeOrderDao(ILogLoungeOrderDao logLoungeOrderDao) {
		this.logLoungeOrderDao = logLoungeOrderDao;
	}

	public IOrderLoungeDao getOrderLoungeDao() {
		return orderLoungeDao;
	}

	public void setOrderLoungeDao(IOrderLoungeDao orderLoungeDao) {
		this.orderLoungeDao = orderLoungeDao;
	}

	public IOrderLoungeGuestDao getOrderLoungeGuestDao() {
		return orderLoungeGuestDao;
	}

	public void setOrderLoungeGuestDao(IOrderLoungeGuestDao orderLoungeGuestDao) {
		this.orderLoungeGuestDao = orderLoungeGuestDao;
	}

	public ILoungeRoomDao getLoungeRoomDao() {
		return loungeRoomDao;
	}

	public void setLoungeRoomDao(ILoungeRoomDao loungeRoomDao) {
		this.loungeRoomDao = loungeRoomDao;
	}

	public IOrderContactDao getOrderContactDao() {
		return orderContactDao;
	}

	public void setOrderContactDao(IOrderContactDao orderContactDao) {
		this.orderContactDao = orderContactDao;
	}

	public IPriceValidatorService getPriceValidatorService() {
		return priceValidatorService;
	}

	public void setPriceValidatorService(
			IPriceValidatorService priceValidatorService) {
		this.priceValidatorService = priceValidatorService;
	}
	
}
