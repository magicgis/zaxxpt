package com.hnatourism.club.golf.dao.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.golf.dao.IGolfInfoDao;
import com.hnatourism.club.golf.domain.GolfInfo;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫表
 * 
 * 历史版本:
 *					2011-08-01 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class GolfInfoDaoImpl extends AbstractIBatisDaoSupport 
		implements IGolfInfoDao {
	private static final Log log = LogFactory.getLog(GolfInfoDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(GolfInfo domain) throws DataAccessException {
		return getPersistanceManager().find("findGolfInfoByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(GolfInfo domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findGolfInfoByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public GolfInfo findById(String id) throws DataAccessException {
		return (GolfInfo) getPersistanceManager().load("findGolfInfoById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		GolfInfo domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteGolfInfo", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(GolfInfo domain) throws DataAccessException {
		GolfInfo tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateGolfInfo", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(GolfInfo domain) throws DataAccessException {
		return getPersistanceManager().insert("insertGolfInfo", domain);
	}
	
}