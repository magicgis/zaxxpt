package com.hnatourism.club.common.dao.impl;


import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.common.dao.ISysOrganizationUserDao;
import com.hnatourism.club.common.domain.SysOrganizationUser;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:用户所属组织机构表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class SysOrganizationUserDaoImpl extends AbstractIBatisDaoSupport 
		implements ISysOrganizationUserDao {
	// log 
	private static final Log log = LogFactory.getLog(SysOrganizationUserDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(SysOrganizationUser domain) throws DataAccessException {
		return getPersistanceManager().find("findSysOrganizationUserByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(SysOrganizationUser domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findSysOrganizationUserByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public SysOrganizationUser findById(String id) throws DataAccessException {
		return (SysOrganizationUser) getPersistanceManager().load("findSysOrganizationUserById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		SysOrganizationUser domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteSysOrganizationUser", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(SysOrganizationUser domain) throws DataAccessException {
		SysOrganizationUser tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateSysOrganizationUser", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(SysOrganizationUser domain) throws DataAccessException {
		return getPersistanceManager().insert("insertSysOrganizationUser", domain);
	}
	
}