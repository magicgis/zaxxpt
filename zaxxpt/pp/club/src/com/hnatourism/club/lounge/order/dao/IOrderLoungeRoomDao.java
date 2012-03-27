package com.hnatourism.club.lounge.order.dao;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.club.lounge.order.domain.OrderLoungeRoom;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室订单房间表
 * 
 * 历史版本:
 *					2011-8-16  v1.1.0 (lixun) 创建:
 * 
 */
public interface IOrderLoungeRoomDao {
	
	/**
	 * 
	 * @description 根据查询条件查询
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 * @createTime 2011-8-16 下午05:28:13
	 * @author lixun
	 */
	public List<OrderLoungeRoom> findByLoungeId(String loungeId) throws DataAccessException;
//
//	/**
//	 * 【根据条件查询】（系统生成方法）
//	 * @param domain
//	 * @param pageInfo
//	 * @return
//	 * @throws DataAccessException
//	 */
// 	public Page findByWhere(OrderLoungeRoom domain,PageInfo pageInfo) throws DataAccessException;
 
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public OrderLoungeRoom findById(String id) throws DataAccessException;



	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(OrderLoungeRoom domain) throws DataAccessException;

}
