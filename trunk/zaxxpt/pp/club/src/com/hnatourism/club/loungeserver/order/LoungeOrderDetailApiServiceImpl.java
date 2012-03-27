package com.hnatourism.club.loungeserver.order;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.club.lounge.order.dao.ILogLoungeOrderDao;
import com.hnatourism.club.lounge.order.dao.IOrderContactDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeExceptionDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeGuestDao;
import com.hnatourism.club.lounge.order.domain.LogLoungeOrder;
import com.hnatourism.club.lounge.order.domain.OrderContact;
import com.hnatourism.club.lounge.order.domain.OrderLounge;
import com.hnatourism.club.lounge.order.domain.OrderLoungeException;
import com.hnatourism.club.lounge.order.domain.OrderLoungeGuest;
import com.hnatourism.club.lounge.order.vo.LogLoungeOrderVo;
import com.hnatourism.club.lounge.order.vo.OrderContactVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeExceptionVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeGuestVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.lounge.prod.dao.IFlightAirportDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
import com.hnatourism.club.lounge.prod.dao.ILoungePriceDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeRoomDao;
import com.hnatourism.club.lounge.prod.domain.LoungePrice;
import com.hnatourism.club.lounge.prod.domain.LoungeRoom;
import com.hnatourism.club.lounge.prod.vo.LoungePriceVo;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;
import com.hnatourism.club.loungeserver.LoungeApiService;

public class LoungeOrderDetailApiServiceImpl extends LoungeApiService implements
IloungeOrderDetailApiService {

	private ILoungeInfoDao loungeInfoDao;
	private IOrderLoungeDao  orderLoungeDao;
	private ILoungeRoomDao iLoungeRoomDao;
	private ILoungePriceDao loungePriceDao;
	private IOrderLoungeGuestDao orderLoungeGuestDao;
	private IOrderContactDao orderContactDao;
	private IFlightAirportDao flightAirportDao;
	private IOrderLoungeExceptionDao orderLoungeExceptionDao;
	private ILogLoungeOrderDao loungeOrderLogDao;
	
	@Override
	public void endHandler() {
		// TODO Auto-generated method stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//根据id查找订单
		OrderLounge orderInfo=orderLoungeDao.findById(((OrderLounge)super.permeters).getId());
		OrderLoungeVo vo=new OrderLoungeVo();
		
		if(orderInfo!=null){
			BeanUtils.copyProperties(orderInfo, vo);
			
			
			//根据订单查询房间
			LoungeRoom loungeRoom=iLoungeRoomDao.findById(vo.getRoomId());
			LoungeRoomVo lrv=new LoungeRoomVo();
			if(loungeRoom!=null){
				BeanUtils.copyProperties(loungeRoom,lrv);
				if(loungeRoom.getLoungePrice()!=null){
					LoungePriceVo lpv=new LoungePriceVo();
					BeanUtils.copyProperties(loungeRoom.getLoungePrice(), lpv);
				}
				//查询包含项目
				if(loungeRoom.getLoungePrice()==null){
					LoungePrice price=new LoungePrice();
					price.setRoomId(vo.getRoomId());
					List pricelist=loungePriceDao.findByRoomTypeN(price);
					if(pricelist!=null&&pricelist.size()>0)
					{
						LoungePrice price_temp=(LoungePrice)pricelist.get(0);
						LoungePriceVo loungePriceVo=new LoungePriceVo();
						BeanUtils.copyProperties(price_temp,loungePriceVo);
						lrv.setLoungePriceVo(loungePriceVo);
					}
				}
				else{
					LoungePriceVo lpv=new LoungePriceVo();
					BeanUtils.copyProperties(loungeRoom.getLoungePrice(), lpv);
					
				}
				//查询收费项目  根据,间隔符查
				String atts=orderInfo.getAdditionalItemId();
				List<LoungePriceVo> lpvList=new ArrayList<LoungePriceVo>();
				//wenz 2011-11-30 订单信息中如果没有查询出单收费项则查询单收费项并设置到订单信息VO中
				if(null==atts||"".equals(atts)){
					String item="";
					LoungePrice price=new LoungePrice();
					price.setRoomId(loungeRoom.getLoungeId());
					List<LoungePrice> pricelist=loungePriceDao.findByWhere(price);
					for (LoungePrice pricei : pricelist) {
						String resourctType=pricei.getResources_type();
						if(resourctType.indexOf(loungeRoom.getType())!=-1){
							if(null==item||"".equals(item))
								item=","+pricei.getItem();
							else
								item=pricei.getItem();
						}
					}
					vo.setAdditionalItemId(item);
				}
				if(atts!=null){
					String [] attArray=atts.split(",");
					for(String lpId:attArray){
						//查找单收费项目
						LoungePrice lpi=loungePriceDao.findById(lpId);
						if(lpi!=null){
							LoungePriceVo lpv=new LoungePriceVo();
							BeanUtils.copyProperties(lpi, lpv);
							lpvList.add(lpv);
						}
					}
				}
				vo.setLoungePriceVoList(lpvList);
				vo.setLoungeRoomVo(lrv);
			}
			//人员查询
			OrderLoungeGuest olg=new OrderLoungeGuest();
			olg.setOrderId(orderInfo.getId());
			olg.setOrderType("NML");
			List<OrderLoungeGuest> olgList=orderLoungeGuestDao.findByWhere(olg);
			List<OrderLoungeGuestVo> olgListVo=new ArrayList<OrderLoungeGuestVo>();
			for(OrderLoungeGuest olgl:olgList){
				OrderLoungeGuestVo olgv=new OrderLoungeGuestVo();
				BeanUtils.copyProperties(olgl, olgv);
				olgListVo.add(olgv);
			}
			//添加联系人
			OrderContact oc=new OrderContact();
			OrderContactVo ocVo=new OrderContactVo();
			oc.setOrderId(orderInfo.getId());
			List<OrderContact> orderContactList=orderContactDao.findByWhere(oc);
			if(orderContactList!=null && orderContactList.size()>0){
				BeanUtils.copyProperties(orderContactList.get(0),ocVo);
			}
			vo.setOrderContactVo(ocVo);
			vo.setOrderLoungeGuestVoList(olgListVo);
			
			//查找异常订单
			OrderLoungeException ole=new OrderLoungeException();
			ole.setOrderId(orderInfo.getId());
			List<OrderLoungeException> orderExceptionList=orderLoungeExceptionDao.findByWhere(ole);
			if(orderExceptionList!=null){
				List<OrderLoungeExceptionVo> orderExceptionListVo=new ArrayList<OrderLoungeExceptionVo>();
				for(OrderLoungeException oles:orderExceptionList){   // wenz  获取异常订单并且通过异常订单号获取异常订单人员
					OrderLoungeExceptionVo olgv=new OrderLoungeExceptionVo();
					BeanUtils.copyProperties(oles, olgv);
					OrderLoungeGuest guest=new OrderLoungeGuest();
					guest.setOrderId(olgv.getId());
					List<OrderLoungeGuest> guestList=orderLoungeGuestDao.findByWhere(guest);
					OrderLoungeGuestVo returnVo = null;
					List<OrderLoungeGuestVo> voList = new ArrayList();
					for (OrderLoungeGuest temp : guestList) {
						returnVo = new OrderLoungeGuestVo();
						BeanUtils.copyProperties(temp, returnVo);
						voList.add(returnVo);
					}
					olgv.setOrderLoungeGuestVoList(voList);
					orderExceptionListVo.add(olgv);
				}
				vo.setLoungeExceptionVoList(orderExceptionListVo);
			}
			
			//查找日志表
			List<LogLoungeOrder> logList=(List<LogLoungeOrder>) loungeOrderLogDao.findByOrderId(vo.getId());
			if(logList!=null){
				List<LogLoungeOrderVo> logLoungeOrderVoList=new ArrayList<LogLoungeOrderVo>();
				for(LogLoungeOrder oles:logList){
					LogLoungeOrderVo olgv=new LogLoungeOrderVo();
					BeanUtils.copyProperties(oles, olgv);
					logLoungeOrderVoList.add(olgv);
				}
				vo.setLogLoungeOrderVoList(logLoungeOrderVoList);
			}
			
		}
			
		super.returnObj=vo;
	}

	@Override
	public void init(Object permeters, Type type) {
		// TODO Auto-generated method stub
		super.permeters=permeters;
		super.type=type;
		//System.out.println("参数"+super.permeters+"类型："+ super.type);
	}

	@Override
	public void parameterHandler() throws Exception {
		//System.out.println("super.permeters====="+super.permeters);
		// TODO Auto-generated method stub
		//对象初始化
		OrderLoungeVo objVo=new OrderLoungeVo();
		OrderLounge  objTar=new OrderLounge();
		if(super.type==String.class){
			objVo=(OrderLoungeVo) ParameterHandler.urlPremeter2Object(String.valueOf(super.permeters),OrderLoungeVo.class);
		}else{
			objTar=(OrderLounge)super.permeters;
		}
		BeanUtils.copyProperties(objVo, objTar);
		//System.out.println("id:====="+objTar.getId());
		super.permeters=objTar;
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

	public IOrderLoungeDao getOrderLoungeDao() {
		return orderLoungeDao;
	}

	public void setOrderLoungeDao(IOrderLoungeDao orderLoungeDao) {
		this.orderLoungeDao = orderLoungeDao;
	}

	public ILoungeRoomDao getiLoungeRoomDao() {
		return iLoungeRoomDao;
	}

	public void setiLoungeRoomDao(ILoungeRoomDao iLoungeRoomDao) {
		this.iLoungeRoomDao = iLoungeRoomDao;
	}

	public ILoungePriceDao getLoungePriceDao() {
		return loungePriceDao;
	}

	public void setLoungePriceDao(ILoungePriceDao loungePriceDao) {
		this.loungePriceDao = loungePriceDao;
	}

	public IOrderLoungeGuestDao getOrderLoungeGuestDao() {
		return orderLoungeGuestDao;
	}

	public void setOrderLoungeGuestDao(IOrderLoungeGuestDao orderLoungeGuestDao) {
		this.orderLoungeGuestDao = orderLoungeGuestDao;
	}

	public IOrderContactDao getOrderContactDao() {
		return orderContactDao;
	}

	public void setOrderContactDao(IOrderContactDao orderContactDao) {
		this.orderContactDao = orderContactDao;
	}

	public IFlightAirportDao getFlightAirportDao() {
		return flightAirportDao;
	}

	public void setFlightAirportDao(IFlightAirportDao flightAirportDao) {
		this.flightAirportDao = flightAirportDao;
	}

	public IOrderLoungeExceptionDao getOrderLoungeExceptionDao() {
		return orderLoungeExceptionDao;
	}

	public void setOrderLoungeExceptionDao(
			IOrderLoungeExceptionDao orderLoungeExceptionDao) {
		this.orderLoungeExceptionDao = orderLoungeExceptionDao;
	}

	public ILogLoungeOrderDao getLoungeOrderLogDao() {
		return loungeOrderLogDao;
	}

	public void setLoungeOrderLogDao(ILogLoungeOrderDao loungeOrderLogDao) {
		this.loungeOrderLogDao = loungeOrderLogDao;
	}
	
}
