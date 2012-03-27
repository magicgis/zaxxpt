package com.hnatourism.club.lounge.order.dao.impl;

import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.lounge.order.dao.ILogLoungeOrderDao;
import com.hnatourism.club.lounge.order.domain.LogLoungeOrder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场订单日志表
 * 
 * 历史版本:
 *					2011-08-15 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LogLoungeOrderDaoImpl extends AbstractIBatisDaoSupport 
		implements ILogLoungeOrderDao {
	// log 
	private static final Log log = LogFactory.getLog(LogLoungeOrderDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(LogLoungeOrder domain) throws DataAccessException {
		return getPersistanceManager().find("findLogLoungeOrderByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(LogLoungeOrder domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findLogLoungeOrderByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public LogLoungeOrder findById(String id) throws DataAccessException {
		return (LogLoungeOrder) getPersistanceManager().load("findLogLoungeOrderById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		LogLoungeOrder domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteLogLoungeOrder", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(LogLoungeOrder domain) throws DataAccessException {
		LogLoungeOrder tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateLogLoungeOrder", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(LogLoungeOrder domain) throws DataAccessException {
		return getPersistanceManager().insert("insertLogLoungeOrder", domain);
	}
	
	@Override
	public Object findByOrderId(String orderId) throws DataAccessException {
		return getPersistanceManager().find("findLogByOrderId", orderId);
	}
}