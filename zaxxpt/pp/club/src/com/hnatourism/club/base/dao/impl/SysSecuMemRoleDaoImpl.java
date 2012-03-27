package com.hnatourism.club.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.base.dao.ISysSecuMemRoleDao;
import com.hnatourism.club.base.domain.SysSecuMemRole;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员角色关联
 * 
 * 历史版本:
 *					2010-08-23 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class SysSecuMemRoleDaoImpl extends AbstractIBatisDaoSupport 
		implements ISysSecuMemRoleDao {
	private static final Log log = LogFactory.getLog(SysSecuMemRoleDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(SysSecuMemRole domain) throws DataAccessException {
		return getPersistanceManager().find("findSysSecuMemRoleByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(SysSecuMemRole domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findSysSecuMemRoleByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public SysSecuMemRole findById(String id) throws DataAccessException {
		return (SysSecuMemRole) getPersistanceManager().load("findSysSecuMemRoleById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		SysSecuMemRole domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteSysSecuMemRole", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(SysSecuMemRole domain) throws DataAccessException {
		SysSecuMemRole tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateSysSecuMemRole", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(SysSecuMemRole domain) throws DataAccessException {
		return getPersistanceManager().insert("insertSysSecuMemRole", domain);
	}
	
}