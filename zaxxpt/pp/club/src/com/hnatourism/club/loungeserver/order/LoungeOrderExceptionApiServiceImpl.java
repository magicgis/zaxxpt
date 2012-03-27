package com.hnatourism.club.loungeserver.order;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeExceptionDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeGuestDao;
import com.hnatourism.club.lounge.order.domain.OrderLoungeException;
import com.hnatourism.club.lounge.order.domain.OrderLoungeGuest;
import com.hnatourism.club.lounge.order.vo.OrderLoungeExceptionVo;
import com.hnatourism.club.loungeserver.LoungeApiService;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机场休息室退改信息查询实现
 * 
 * 历史版本: 2011-8-17 v1.0.0 (lixun) 创建
 * 
 */
public class LoungeOrderExceptionApiServiceImpl extends LoungeApiService implements
		ILoungeOrderExceptionApiService {

	
	private IOrderLoungeExceptionDao orderLoungeExceptionDao;
	private IOrderLoungeGuestDao orderLoungeGuestDao;
	@Override
	public void endHandler() {
		// TODO Auto-generated method stub
	}

	@Override
	public  void execute() {
		List<OrderLoungeException> loungeExceptions=orderLoungeExceptionDao.findByWhere((OrderLoungeException)super.permeters);
		List<OrderLoungeExceptionVo> result=new ArrayList<OrderLoungeExceptionVo>();
		OrderLoungeGuest orderLoungeGuest=new OrderLoungeGuest();
		for(OrderLoungeException loungeException:loungeExceptions){
			OrderLoungeExceptionVo vo=new OrderLoungeExceptionVo();
			BeanUtils.copyProperties(loungeException, vo);
			orderLoungeGuest.setOrderId(vo.getId());
			orderLoungeGuest.setType("EXP");
			List<OrderLoungeGuest> guests=orderLoungeGuestDao.findByWhere(orderLoungeGuest);
			if(guests!=null&&guests.size()>0){
				vo.setGuestName(guests.get(0).getName());
			}
			result.add(vo);
		}
		super.returnObj=result;
	}

	@Override
	public void init(Object permeters, Type type) {
		super.permeters = permeters;
		super.type = type;
	}

	@Override
	public void parameterHandler() throws Exception {
		// TODO Auto-generated method stub
		//对象初始化
		OrderLoungeExceptionVo objVo=new OrderLoungeExceptionVo();
		OrderLoungeException  objTar=new OrderLoungeException();
		if(super.type==String.class){
			objVo=(OrderLoungeExceptionVo) ParameterHandler.urlPremeter2Object(String.valueOf(super.permeters),OrderLoungeExceptionVo.class);
		}else{
			objTar=(OrderLoungeException)super.permeters;
		}
		BeanUtils.copyProperties(objVo, objTar);
		super.permeters=objTar;
	}

	@Override
	public Object getResult() {
		return super.returnObj;
	}

	// setter && getter
	
	public IOrderLoungeExceptionDao getOrderLoungeExceptionDao() {
		return orderLoungeExceptionDao;
	}

	public void setOrderLoungeExceptionDao(
			IOrderLoungeExceptionDao orderLoungeExceptionDao) {
		this.orderLoungeExceptionDao = orderLoungeExceptionDao;
	}

	public IOrderLoungeGuestDao getOrderLoungeGuestDao() {
		return orderLoungeGuestDao;
	}

	public void setOrderLoungeGuestDao(IOrderLoungeGuestDao orderLoungeGuestDao) {
		this.orderLoungeGuestDao = orderLoungeGuestDao;
	}
	
	
	// setter && getter end

}
