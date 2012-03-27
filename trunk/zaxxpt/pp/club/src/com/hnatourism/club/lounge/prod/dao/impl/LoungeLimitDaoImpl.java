package com.hnatourism.club.lounge.prod.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.lounge.prod.dao.ILoungeLimitDao;
import com.hnatourism.club.lounge.prod.domain.LoungeLimit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室不预定时间维护
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeLimitDaoImpl extends AbstractIBatisDaoSupport 
		implements ILoungeLimitDao {
	// log 
	private static final Log log = LogFactory.getLog(LoungeLimitDaoImpl.class);
		
		/**
		 * 【根据条件查询】（系统生成方法）
		 * @param domain
		 * @return
		 * 2011-08-15 v1.1.0 (高杰) 创建:
		 * @throws DataAccessException
		 */
		public List findByRoom(LoungeLimit domain) throws DataAccessException {
			return getPersistanceManager().find("findLoungeLimitByRoom", domain);
		}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(LoungeLimit domain) throws DataAccessException {
		return getPersistanceManager().find("findLoungeLimitByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(LoungeLimit domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findLoungeLimitByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public LoungeLimit findById(String id) throws DataAccessException {
		return (LoungeLimit) getPersistanceManager().load("findLoungeLimitById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		LoungeLimit domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteLoungeLimit", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(LoungeLimit domain) throws DataAccessException {
		LoungeLimit tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateLoungeLimit", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(LoungeLimit domain) throws DataAccessException {
		return getPersistanceManager().insert("insertLoungeLimit", domain);
	}
	
}