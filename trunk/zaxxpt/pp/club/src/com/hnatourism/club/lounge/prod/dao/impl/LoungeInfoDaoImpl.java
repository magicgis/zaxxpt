package com.hnatourism.club.lounge.prod.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场休息室产品信息表
 * 
 * 历史版本:2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeInfoDaoImpl extends AbstractIBatisDaoSupport 
		implements ILoungeInfoDao {
	// log 
	private static final Log log = LogFactory.getLog(LoungeInfoDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(LoungeInfo domain) throws DataAccessException {
		//System.out.println(this.getPersistanceManager());
		return getPersistanceManager().find("findLoungeInfoByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-15 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findByComm(LoungeInfo domain) throws DataAccessException {
			return getPersistanceManager().find("findLoungeInfoByComm", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(LoungeInfo domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findLoungeInfoByWhere", domain, pageInfo);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-16 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findBySearchPage(Object o) throws DataAccessException {
			return this.getPersistanceManager().find("findLoungeInfoBySearchPage", o);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-16 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findBySearchCityPage(Object o) throws DataAccessException {
			return this.getPersistanceManager().find("findLoungeInfoBySearchCityPage", o);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-16 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findBySearch(Object o) throws DataAccessException {
			return this.getPersistanceManager().find("findLoungeInfoBySearch", o);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-16 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findBySearchCity(Object o) throws DataAccessException {
			return this.getPersistanceManager().find("findLoungeInfoBySearchCity", o);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public LoungeInfo findById(String id) throws DataAccessException {
		return (LoungeInfo) getPersistanceManager().load("findLoungeInfoById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		LoungeInfo domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteLoungeInfo", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(LoungeInfo domain) throws DataAccessException {
		LoungeInfo tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateLoungeInfo", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(LoungeInfo domain) throws DataAccessException {
		return getPersistanceManager().insert("insertLoungeInfo", domain);
	}
	
}