package com.hnatourism.club.loungeserver.order;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.club.lounge.order.dao.ILogLoungeOrderDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeExceptionDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeGuestDao;
import com.hnatourism.club.lounge.order.domain.LogLoungeOrder;
import com.hnatourism.club.lounge.order.domain.OrderLounge;
import com.hnatourism.club.lounge.order.domain.OrderLoungeException;
import com.hnatourism.club.lounge.order.domain.OrderLoungeGuest;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.loungeserver.LoungeApiService;

/**
 * 机场休息室订单改期
 * @author Administrator
 *
 */
public class LoungeOrderChangeApiServiceImpl extends LoungeApiService implements
ILoungeOrderChangeApiService {
	private static final Log log = (Log) LogFactory.getLog(LoungeOrderChangeApiServiceImpl.class);
	private IOrderLoungeDao  orderLoungeDao;
	private ILogLoungeOrderDao logLoungeOrderDao;
	private IOrderLoungeExceptionDao orderLoungeExceptionDao;
	private IOrderLoungeGuestDao orderLoungeGuestDao;
	
	
	@Override
	public void endHandler() {
		// TODO Auto-generated method stub
	}

	@Override
	public void execute() {
		OrderLoungeVo objVo=(OrderLoungeVo)super.permeters;
		OrderLounge ol=orderLoungeDao.findById(objVo.getId());
		if(ol!=null){
			//改期对象
			OrderLoungeException ole=new OrderLoungeException();
			String excOrderId=UUID.randomUUID().toString().replace("-","");
			ole.setOrderId(objVo.getId());
			ole.setCreateTime(new Date());
			ole.setSts("7");//改期待审核
			ole.setType("M");
			ole.setBookTime(objVo.getStartTime());
			ole.setBookEndTime(objVo.getEndTime());
			ole.setConsumerSts(ol.getConsumerSts());
			ole.setCreateUser(objVo.getCreateUser());
			ole.setUpdateUser(objVo.getCreateUser());
			ole.setAdditionalItemIds(objVo.getAdditionalItemId());//单收项
			ole.setUpdateTime(new Date());
			ole.setId(excOrderId);
			ole.setCode(SnoGerUtil.getOrderNo());
			orderLoungeExceptionDao.insert(ole);
			
			//人员处理
			if(objVo.getGuestIds()!=null && !"".equals(objVo.getGuestIds())){
				String [] ids =objVo.getGuestIds().split(",");
				for(String guestId:ids){
					OrderLoungeGuest  olg=orderLoungeGuestDao.findById(guestId);
					if(olg!=null){
						olg.setId(UUID.randomUUID().toString().replace("-",""));
						olg.setOrderId(excOrderId);
						olg.setCreateTime(new Date());
						olg.setCreateUser(objVo.getCreateUser());
						//olg.setType("EXP");
						olg.setUpdateTime(new Date());
						olg.setUpdateUser(objVo.getCreateUser());
						orderLoungeGuestDao.insert(olg);
					}else{
						log.info("com.hnatourism.club.loungeserver.order.LOUnsubscribeApiServiceImpl 未找到顾客 id："+guestId);
					}
				}
			}else{
				log.info("com.hnatourism.club.loungeserver.order.LOUnsubscribeApiServiceImpl 没有要处理的顾客");
			}
			//日志
			LogLoungeOrder llo=new 	LogLoungeOrder();
			llo.setCreateTime(new Date());
			llo.setCreateUser(objVo.getCreateUser());
			llo.setId(UUID.randomUUID().toString().replace("-",""));
			llo.setOrderId(objVo.getId());
			llo.setType("正常");
			llo.setUpdateTime(new Date());
			llo.setUpdateUser(objVo.getCreateUser());
			llo.setContent("申请改期！");
			logLoungeOrderDao.insert(llo);
			this.returnObj="申请改期成功";
		}else{
			this.returnObj="申请改期失败";
		}
	}

	/**
	 * 传入参数     订单id   改期原因  GuestIds
	 */
	@Override
	public void init(Object permeters, Type type) {
		// TODO Auto-generated method stub
		super.permeters=permeters;
		super.type=type;
		log.info("参数"+super.permeters+"类型："+ super.type);
	}

	/**
	 * 传入参数     订单id   改期原因    createUser  GuestIds
	 */
	@Override
	public void parameterHandler() throws Exception {
		//对象初始化
		OrderLoungeVo objVo=new OrderLoungeVo();
		if(super.type==String.class){
			objVo=(OrderLoungeVo) ParameterHandler.urlPremeter2Object(String.valueOf(super.permeters),OrderLoungeVo.class);
		}
		log.info("id:====="+objVo.getId());
		super.permeters=objVo;
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return super.returnObj;
	}

	public IOrderLoungeDao getOrderLoungeDao() {
		return orderLoungeDao;
	}

	public void setOrderLoungeDao(IOrderLoungeDao orderLoungeDao) {
		this.orderLoungeDao = orderLoungeDao;
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

	public IOrderLoungeGuestDao getOrderLoungeGuestDao() {
		return orderLoungeGuestDao;
	}

	public void setOrderLoungeGuestDao(IOrderLoungeGuestDao orderLoungeGuestDao) {
		this.orderLoungeGuestDao = orderLoungeGuestDao;
	}

	
}
