package com.hnatourism.club.lounge.order.dao.impl;


import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeRoomDao;
import com.hnatourism.club.lounge.order.domain.OrderLoungeRoom;
import com.hnatourism.club.lounge.prod.dao.impl.LoungeRoomDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室房间表
 * 
 * 历史版本:
 *					2011-8-16  v1.1.0 (lixun) 创建:
 * 
 */
@SuppressWarnings("unused")
public class OrderLoungeRoomDaoImpl extends AbstractIBatisDaoSupport 
		implements IOrderLoungeRoomDao {
	// log 
	// log 
	private static final Log log = LogFactory.getLog(LoungeRoomDaoImpl.class);

	
	/**
	 * @description 修改
	 * @see com.hnatourism.club.lounge.order.dao.IOrderLoungeRoomDao#update(com.hnatourism.club.lounge.order.domain.OrderLoungeRoom)
	 * @createTime 2011-8-16 下午01:26:50
	 * @author lixun
	 */
	@Override
	public int update(OrderLoungeRoom domain) throws DataAccessException {
		return getPersistanceManager().update("updateOrderLoungeRoom", domain);
	}
	/**
	 * 
	 * @description 根据id查找
	 * @see com.hnatourism.club.lounge.order.dao.IOrderLoungeRoomDao#findById(java.lang.String)
	 * @createTime 2011-8-16 下午01:29:10
	 * @author lixun
	 */
	public OrderLoungeRoom findById(String id) throws DataAccessException {
		return (OrderLoungeRoom) getPersistanceManager().load("findOrderLoungeRoomById", id);
	}
	
	/**
	 * 
	 * @description 查询loungid 对应的orderLoungeRoom
	 * @see com.hnatourism.club.lounge.order.dao.IOrderLoungeRoomDao#findByLoungeId(java.lang.String)
	 * @createTime 2011-8-16 下午05:31:25
	 * @author lixun
	 */
	
	@Override
	public List<OrderLoungeRoom> findByLoungeId(String loungeId)
			throws DataAccessException {
		return (List<OrderLoungeRoom>)getPersistanceManager().find("findOrderLoungeRoomByLoungeId", loungeId);
	}

	
	
	
}