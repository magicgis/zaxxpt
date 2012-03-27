package com.hnatourism.club.personal.member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.personal.member.dao.IMemberStsDao;
import com.hnatourism.club.personal.member.dao.IOrderBillDao;
import com.hnatourism.club.personal.member.domain.MemberSts;
import com.hnatourism.club.personal.member.domain.OrderBill;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员状态表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderBillDaoImpl extends AbstractIBatisDaoSupport 
		implements IOrderBillDao {
	// log 
	private static final Log log = LogFactory.getLog(OrderBillDaoImpl.class);
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByAccount(String account) throws DataAccessException {
		return getPersistanceManager().find("findOrderBillByAccount", account);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(OrderBill domain) throws DataAccessException {
		return getPersistanceManager().find("findOrderBillByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(OrderBill domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findOrderBillByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public OrderBill findById(String id) throws DataAccessException {
		return (OrderBill) getPersistanceManager().load("findOrderBillById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		OrderBill domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteOrderBill", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(OrderBill domain) throws DataAccessException {
		OrderBill tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateOrderBill", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(OrderBill domain) throws DataAccessException {
		return getPersistanceManager().insert("insertOrderBill", domain);
	}
	
}