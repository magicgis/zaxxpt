package com.hnatourism.club.loungeserver.order;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.club.lounge.order.dao.ILogLoungeOrderDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeExceptionDao;
import com.hnatourism.club.lounge.order.domain.OrderLounge;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeRoomDao;
import com.hnatourism.club.loungeserver.LoungeApiService;

public class LoungeOrderListApiServiceImpl extends LoungeApiService implements
ILoungeOrderListApiService {

	private ILoungeInfoDao loungeInfoDao;
	private IOrderLoungeDao  orderLoungeDao;
	private ILoungeRoomDao LoungeRoomDao;
	private ILogLoungeOrderDao logLoungeOrderDao;
	private IOrderLoungeExceptionDao orderLoungeExceptionDao;
	
	@Override
	public void endHandler() {
		// TODO Auto-generated method stub
	}

	//修改 lixun   原来的迭代的查询严重影响查询效率
	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		List<OrderLounge> orderLounges=orderLoungeDao.findByWhere((OrderLounge)super.permeters);
		List<OrderLoungeVo> OrderLoungeVos=new ArrayList<OrderLoungeVo>();
		for(OrderLounge orderLounge:orderLounges){
			OrderLoungeVo vo=new OrderLoungeVo();
			BeanUtils.copyProperties(orderLounge, vo);
			OrderLoungeVos.add(vo);
		}
		super.returnObj=OrderLoungeVos;
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
		OrderLoungeVo objVo=new OrderLoungeVo();
		OrderLounge  objTar=new OrderLounge();
		if(super.type==String.class){
			objVo=(OrderLoungeVo) ParameterHandler.urlPremeter2Object(String.valueOf(super.permeters),OrderLoungeVo.class);
		}else{
			objTar=(OrderLounge)super.permeters;
		}
		BeanUtils.copyProperties(objVo, objTar);
		super.permeters=objTar;
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return super.returnObj;
	}

	//setter && getter
	
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

	public ILoungeRoomDao getLoungeRoomDao() {
		return LoungeRoomDao;
	}

	public void setLoungeRoomDao(ILoungeRoomDao loungeRoomDao) {
		LoungeRoomDao = loungeRoomDao;
	}

	public ILogLoungeOrderDao getLogLoungeOrderDao() {
		return logLoungeOrderDao;
	}

	public void setLogLoungeOrderDao(ILogLoungeOrderDao logLoungeOrderDao) {
		this.logLoungeOrderDao = logLoungeOrderDao;
	}

	public IOrderLoungeExceptionDao getOrderLoungeExceptionDao() {
		return orderLoungeExceptionDao;
	}

	public void setOrderLoungeExceptionDao(
			IOrderLoungeExceptionDao orderLoungeExceptionDao) {
		this.orderLoungeExceptionDao = orderLoungeExceptionDao;
	}

	//setter && getter end
}
