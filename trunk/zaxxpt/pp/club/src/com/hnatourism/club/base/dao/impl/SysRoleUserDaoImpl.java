package com.hnatourism.club.base.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.base.dao.ISysRoleUserDao;
import com.hnatourism.club.base.domain.SysRoleUser;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;

@SuppressWarnings("unchecked")
public class SysRoleUserDaoImpl extends AbstractIBatisDaoSupport implements ISysRoleUserDao {
	/**
	 * 根据条件查询用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysRoleUser domain) throws BusinessException {
		List list = new ArrayList();
		PageInfo pageInfo = (PageInfo) ContextHolder.getContext().getAttribute(PageInfo.PAGEINFO);
		if (pageInfo == null){
			list = getPersistanceManager().find("findSysRoleUserByWhere", domain);
		} else {
			Page page = this.getPersistanceManager().find("findSysRoleUserByWhere", domain, pageInfo);
			ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, page.getPageInfo());
			list = page.getData();
		}
		return list;
	}
	
	/**
	 * 根据条件查询用户权限记录
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	public Page findByWhere(SysRoleUser domain,PageInfo pageInfo) throws BusinessException {
		Page page = new Page();
		if (pageInfo == null){
			List list = getPersistanceManager().find("findSysRoleUserByWhere", domain);
			page.setData(list);
		} else {
			page = this.getPersistanceManager().find("findSysRoleUserByWhere", domain, pageInfo);
		}
		return page;
	}
	
	/**
	 * 根据ID查询用户权限记录
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysRoleUser findById(String id) throws BusinessException {
		return (SysRoleUser) getPersistanceManager().load("findSysRoleUserById", id);
	}

	/**
	 * 删除用户权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException {
		SysRoleUser domain = findById(id);
		if (domain == null) {
			throw new BusinessException("NOT EXISTS", "ID = '"+id+ "' object not exist");
		}	
		getPersistanceManager().delete("deleteSysRoleUser", id);
	}

	public void deleteBySystemUserId(String systemUserId) throws BusinessException {
		List<SysRoleUser> list=findByUserId(systemUserId);
		SysRoleUser tempSystemRoleUser = null;
		if(list != null && list.size()>0){
			for(int i = 0 ; i < list.size() ; i++ ){
				tempSystemRoleUser = list.get(i);
				getPersistanceManager().delete("deleteSysRoleUser", tempSystemRoleUser.getId());
			}
		}
		/*if(systemUserId != null && systemUserId != ""){
			getPersistanceManager().delete("deleteSystemRoleUserBySystemUserId", systemUserId);
		}*/		
	}
	
	/**
	 *  修改用户权限记录
	 * @param domain
	 * @throws BusinessException
	 */
	public void update(SysRoleUser domain) throws BusinessException {
		SysRoleUser tmp = findById(domain.getId());
		if (tmp == null) {
			throw new BusinessException("NOT EXISTS", "ID = '"+domain.getId()+ "' object not exist");
		}
		getPersistanceManager().insert("updateSysRoleUser", domain);
	}

	/**
	 * 新增用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysRoleUser domain) throws BusinessException {
		return getPersistanceManager().insert("insertSysRoleUser", domain);
	}
	
	public List loadUserRole(String sysUserId) throws BusinessException{
		return getPersistanceManager().find("retriveUserByUserCode",sysUserId);
	}

	public List<SysRoleUser> findByUserId(String sysUserId) throws BusinessException {
		return (List<SysRoleUser>) getPersistanceManager().find("findRoleUserByUserId", sysUserId);
	}
	
	public void delByRoleId(String sysRoleId) throws BusinessException {
		getPersistanceManager().delete("deleteSysRoleUserByRoleId", sysRoleId);
	}
	
	public List findRoleName(SysRoleUser domain) throws BusinessException{
		return getPersistanceManager().find("findSysRoleUser",domain);
	}
}