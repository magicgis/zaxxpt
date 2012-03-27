package com.hnatourism.club.lounge.order.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeExceptionDao;
import com.hnatourism.club.lounge.order.domain.OrderLoungeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class OrderLoungeExceptionDaoImpl extends AbstractIBatisDaoSupport 
		implements IOrderLoungeExceptionDao {
	// log 
	private static final Log log = LogFactory.getLog(OrderLoungeExceptionDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(OrderLoungeException domain) throws DataAccessException {
		return getPersistanceManager().find("findOrderLoungeExceptionByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(OrderLoungeException domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findOrderLoungeExceptionByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public OrderLoungeException findById(String id) throws DataAccessException {
		return (OrderLoungeException) getPersistanceManager().load("findOrderLoungeExceptionById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		OrderLoungeException domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteOrderLoungeException", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(OrderLoungeException domain) throws DataAccessException {
		OrderLoungeException tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateOrderLoungeException", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(OrderLoungeException domain) throws DataAccessException {
		return getPersistanceManager().insert("saveOrderLoungeException", domain);
	}
	
}