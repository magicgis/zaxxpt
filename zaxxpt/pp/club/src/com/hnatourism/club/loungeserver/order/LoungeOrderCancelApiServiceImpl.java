package com.hnatourism.club.loungeserver.order;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.club.lounge.order.dao.ILogLoungeOrderDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeRoomDao;
import com.hnatourism.club.lounge.order.domain.LogLoungeOrder;
import com.hnatourism.club.lounge.order.domain.OrderLounge;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.loungeserver.LoungeApiService;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:取消机场休息室订单api
 * 
 * 历史版本: 2011-8-16 v1.0.0 (lixun) 创建
 * 
 */
public class LoungeOrderCancelApiServiceImpl extends LoungeApiService
		implements ILoungeOrderCancelApiService {
	/**
	 * 订单为已取消状态
	 */
	public static final String ORDER_STS_CANCELLED="0";
	/**
	 * 订单为已支付状态
	 */
	public static final String ORDER_STS_PAID="11";
	
	private ILogLoungeOrderDao logLoungeOrderDao;
	private IOrderLoungeDao orderLoungeDao;
	private IOrderLoungeRoomDao orderLoungeRoomDao;

	@Override
	public void endHandler() {
		// TODO Auto-generated method stub
	}

	@Override
	public  void execute() {
		OrderLounge orderLounge = orderLoungeDao.findById(((OrderLounge)super.permeters).getId());
			if(canCancel(orderLounge.getSts())){
				try {
					orderLounge.setSts(ORDER_STS_CANCELLED);
					orderLoungeDao.update(orderLounge);
					//记录日志
					LogLoungeOrder logLoungeOrder=new LogLoungeOrder();
					logLoungeOrder.setOrderId(orderLounge.getId());
					logLoungeOrder.setContent("取消订单!");
					logLoungeOrder.setType("正常");
					logLoungeOrder.setId(UUID.randomUUID().toString().replace("-", ""));
					logLoungeOrder.setCreateUser(orderLounge.getCreateUser());
					logLoungeOrder.setUpdateUser("");
					logLoungeOrder.setCreateTime(new Date());
					logLoungeOrder.setUpdateTime(null);
					logLoungeOrderDao.insert(logLoungeOrder);
					super.returnObj="订单已取消";
				} catch (Exception e) {
					super.returnObj="订单取消失败";
				}
			}else{
				super.returnObj="该订单处于不可取消的状态";
			}
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
		return super.returnObj;
	}

	
	/**
	 * 
	 * @description 判断订单是否处于可以取消的状态
	 * @param sts
	 * @return
	 * @createTime 2011-8-16 下午06:14:17
	 * @author lixun
	 */
	private boolean canCancel(String sts) {
		if(ORDER_STS_CANCELLED.equals(sts)||ORDER_STS_PAID.equals(sts)){
			return false;
		}else {
			return true;
		}
	}
	// setter && getter

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

	public IOrderLoungeRoomDao getOrderLoungeRoomDao() {
		return orderLoungeRoomDao;
	}

	public void setOrderLoungeRoomDao(IOrderLoungeRoomDao orderLoungeRoomDao) {
		this.orderLoungeRoomDao = orderLoungeRoomDao;
	}
	
	// setter && getter end
}
