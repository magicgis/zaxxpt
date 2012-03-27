package com.hnatourism.club.lounge.order.dao;

import java.util.List;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.club.lounge.order.domain.OrderLoungeException;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室订单退改表
 * 
 * 历史版本:
 *					2011-08-11 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface IOrderLoungeExceptionDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(OrderLoungeException domain) throws DataAccessException;

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
 	public Page findByWhere(OrderLoungeException domain,PageInfo pageInfo) throws DataAccessException;
 
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public OrderLoungeException findById(String id) throws DataAccessException;

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException ;

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(OrderLoungeException domain) throws DataAccessException;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(OrderLoungeException domain) throws DataAccessException;
}
