package com.hnatourism.club.golf.dao.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.golf.dao.IGolfTimeMaintainDao;
import com.hnatourism.club.golf.domain.GolfTimeMaintain;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫预定时间表
 * 
 * 历史版本:
 *					2011-08-01 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class GolfTimeMaintainDaoImpl extends AbstractIBatisDaoSupport 
		implements IGolfTimeMaintainDao {
	private static final Log log = LogFactory.getLog(GolfTimeMaintainDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(GolfTimeMaintain domain) throws DataAccessException {
		return getPersistanceManager().find("findGolfTimeMaintainByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(GolfTimeMaintain domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findGolfTimeMaintainByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public GolfTimeMaintain findById(String id) throws DataAccessException {
		return (GolfTimeMaintain) getPersistanceManager().load("findGolfTimeMaintainById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		GolfTimeMaintain domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteGolfTimeMaintain", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(GolfTimeMaintain domain) throws DataAccessException {
		GolfTimeMaintain tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateGolfTimeMaintain", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(GolfTimeMaintain domain) throws DataAccessException {
		return getPersistanceManager().insert("insertGolfTimeMaintain", domain);
	}
	
}