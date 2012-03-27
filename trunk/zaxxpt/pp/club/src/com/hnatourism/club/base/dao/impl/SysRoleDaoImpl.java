/**
 * 项目名称:酒店预订系统
 * 
 * 功能描述:权限管理
 * 
 * 历史版本:
 *	2010-04-06 v1.0.0 (liulibo) 创建:
 * 
 */
package com.hnatourism.club.base.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.base.dao.ISysRoleDao;
import com.hnatourism.club.base.domain.SysRole;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;

@SuppressWarnings("unchecked")
public class SysRoleDaoImpl extends AbstractIBatisDaoSupport implements ISysRoleDao {
	/**
	 * 根据条件查询权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysRole domain) throws BusinessException {
		List list = new ArrayList();
		PageInfo pageInfo = (PageInfo) ContextHolder.getContext().getAttribute(PageInfo.PAGEINFO);
		if (pageInfo == null){
			list = getPersistanceManager().find("findSysRoleByWhere", domain);
		} else {
			Page page = this.getPersistanceManager().find("findSysRoleByWhere", domain, pageInfo);
			ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, page.getPageInfo());
			list = page.getData();
		}
		return list;
	}
	
	/**
	 * 根据ID查询权限记录
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysRole findById(String id) throws BusinessException {
		return (SysRole) getPersistanceManager().load("findSysRoleById", id);
	}

	/**
	 * 删除权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException {
		SysRole domain = findById(id);
		if (domain == null) {
			throw new BusinessException("NOT EXISTS", "ID = '"+id+ "' object not exist");
		}	
		getPersistanceManager().delete("deleteSysRole", id);
	}

	/**
	 *  修改权限记录
	 * @param domain
	 * @throws BusinessException
	 */
	public void update(SysRole domain) throws BusinessException {
		SysRole tmp = findById(domain.getId());
		if (tmp == null) {
			throw new BusinessException("NOT EXISTS", "ID = '"+domain.getId()+ "' object not exist");
		}
		getPersistanceManager().insert("updateSysRole", domain);
	}

	/**
	 * 新增权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysRole domain) throws BusinessException {
		return getPersistanceManager().insert("insertSysRole", domain);
	}

	public List<SysRole> querySystemRoles(SysRole systemRole)throws BusinessException {
		List<SysRole> users = new ArrayList<SysRole>();
		PageInfo pageInfo = (PageInfo) ContextHolder.getContext().getAttribute(PageInfo.PAGEINFO);
		if (pageInfo == null) {
			users = (List<SysRole>) getPersistanceManager().find("querySysRole", systemRole);
		} else {
			Page page = getPersistanceManager().find("querySysRole", systemRole, pageInfo);
			ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, page.getPageInfo());
			users = (List<SysRole>) page.getData();
		}
		return users;
	}
	
	public List<SysRole> retriveRoleByRoleIds(String roles) throws BusinessException{
		//List<SystemRole> list = getPersistanceManager().find("",);
		String[] ids = null;
		if(roles != null && roles.trim().length() > 0){
			ids = roles.split( "," );
		}		
		List list = Arrays.asList(ids);
		Map map = new HashMap();
		map.put("roleIds", list);
		return (List<SysRole>) getPersistanceManager().find("findSysRoleByRoleIds", map);
	}
	
	public SysRole findByRoleKey(String roleKey) throws BusinessException{
		SysRole role = null;
		if(roleKey != null){
			role = (SysRole) getPersistanceManager().find("findByRoleKey",roleKey);
		}		
		return role;
	}
}