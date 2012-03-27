package com.hnatourism.club.golf.dao.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.golf.dao.IGolfRecordDao;
import com.hnatourism.club.golf.domain.GolfRecord;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫充球记录表
 * 
 * 历史版本:
 *					2011-08-01 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class GolfRecordDaoImpl extends AbstractIBatisDaoSupport 
		implements IGolfRecordDao {
	private static final Log log = LogFactory.getLog(GolfRecordDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(GolfRecord domain) throws DataAccessException {
		return getPersistanceManager().find("findGolfRecordByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(GolfRecord domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findGolfRecordByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public GolfRecord findById(String id) throws DataAccessException {
		return (GolfRecord) getPersistanceManager().load("findGolfRecordById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		GolfRecord domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteGolfRecord", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(GolfRecord domain) throws DataAccessException {
		GolfRecord tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateGolfRecord", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(GolfRecord domain) throws DataAccessException {
		return getPersistanceManager().insert("insertGolfRecord", domain);
	}
	
}