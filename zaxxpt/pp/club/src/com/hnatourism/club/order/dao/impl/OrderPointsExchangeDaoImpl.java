package com.hnatourism.club.order.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.order.dao.IOrderPointsExchangeDao;
import com.hnatourism.club.order.domain.OrderPointsExchange;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:积分兑换订单
 * 
 * 历史版本:
 *					2011-10-12 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderPointsExchangeDaoImpl extends AbstractIBatisDaoSupport 
		implements IOrderPointsExchangeDao {
	private static final Log log = LogFactory.getLog(OrderPointsExchangeDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(OrderPointsExchange domain) throws DataAccessException {
		return getPersistanceManager().find("findOrderPointsExchangeByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(OrderPointsExchange domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findOrderPointsExchangeByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public OrderPointsExchange findById(String id) throws DataAccessException {
		return (OrderPointsExchange) getPersistanceManager().load("findOrderPointsExchangeById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		OrderPointsExchange domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteOrderPointsExchange", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(OrderPointsExchange domain) throws DataAccessException {
		OrderPointsExchange tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateOrderPointsExchange", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(OrderPointsExchange domain) throws DataAccessException {
		return getPersistanceManager().insert("insertOrderPointsExchange", domain);
	}
	
	/**
	 * 查询积分
	 * @param findId
	 * @param obj
	 * @return
	 */
	public Integer getRemainingPoints(String findId,Object obj) throws DataAccessException {
		Object obj1=this.getPersistanceManager().getSqlMapClientTemplate().queryForObject(findId, obj);
		if(obj1!=null){
			Double objDou=(Double) obj1;
			return objDou.intValue();
		}else{
			return 0;
		}
	}
	
}