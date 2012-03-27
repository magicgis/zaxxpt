package com.hnatourism.club.lounge.order.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.lounge.order.dao.IOrderContactDao;
import com.hnatourism.club.lounge.order.domain.OrderContact;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:订单联系人表
 * 
 * 历史版本:
 *					2011-08-19 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderContactDaoImpl extends AbstractIBatisDaoSupport 
		implements IOrderContactDao {
	private static final Log log = LogFactory.getLog(OrderContactDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(OrderContact domain) throws DataAccessException {
		return getPersistanceManager().find("findOrderContactByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(OrderContact domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findOrderContactByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public OrderContact findById(String id) throws DataAccessException {
		return (OrderContact) getPersistanceManager().load("findOrderContactById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		OrderContact domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteOrderContact", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(OrderContact domain) throws DataAccessException {
		OrderContact tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateOrderContact", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(OrderContact domain) throws DataAccessException {
		return getPersistanceManager().insert("insertOrderContact", domain);
	}
	
}