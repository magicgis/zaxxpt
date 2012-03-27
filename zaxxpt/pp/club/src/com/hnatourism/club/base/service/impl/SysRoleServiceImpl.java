/**
 * 项目名称:酒店预订系统
 * 
 * 功能描述:权限管理
 * 
 * 历史版本:
 *	2010-04-06 v1.0.0 (liulibo) 创建:
 * 
 */
package com.hnatourism.club.base.service.impl;

import java.util.List;

import com.hnatourism.club.base.bean.SysRoleBean;
import com.hnatourism.club.base.dao.ISysRoleDao;
import com.hnatourism.club.base.domain.SysRole;
import com.hnatourism.club.base.service.ISysRoleService;
import com.hnatourism.club.base.service.ISysRoleUserService;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.service.AbstractService;
import com.hnatourism.framework.utils.SequenceHelper;

@SuppressWarnings("unchecked")
public class SysRoleServiceImpl extends AbstractService implements ISysRoleService {
	private ISysRoleDao sysRoleDao;
	private ISysRoleUserService sysRoleUserService;


	public ISysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}

	public void setSysRoleDao(ISysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	/**
	 * 根据条件查询权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysRole domain) throws BusinessException {
		return sysRoleDao.findByWhere(domain);
	}

	/**
	 * 删除权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException {
		//删除角色同时删除角色-权限里的对应关系，以防空指针
		sysRoleUserService.delByRoleId(id);
		sysRoleDao.delete(id);
	}

	/**
	 * 根据ID查询权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public SysRole findById(String id) throws BusinessException {
		return sysRoleDao.findById(id);
	}

	/**
	 * 新增权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysRole domain) throws BusinessException {
		domain.setId(SequenceHelper.next());
		return sysRoleDao.insert(domain);
	}

	/**
	 * 修改权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public void update(SysRole domain) throws BusinessException {
		sysRoleDao.update(domain);
	}

	public List<SysRole> querySystemRoles(SysRoleBean sysRoleBean)
			throws BusinessException {
		SysRole sysRole=new SysRole();
		if(sysRoleBean!=null){
			sysRole.setName(sysRoleBean.getSysRoleName());
			sysRole.setCode(sysRoleBean.getRoleKey());
		}
		return sysRoleDao.querySystemRoles(sysRole);
	}

	public SysRole findByRoleKey(String roleKey) throws BusinessException{
		SysRole role = null;
		if(roleKey != null){
			role = sysRoleDao.findByRoleKey(roleKey);
		}
		return role;
	}

	/**
	 * @return the sysRoleUserService
	 */
	public ISysRoleUserService getSysRoleUserService() {
		return sysRoleUserService;
	}

	/**
	 * @param sysRoleUserService the sysRoleUserService to set
	 */
	public void setSysRoleUserService(ISysRoleUserService sysRoleUserService) {
		this.sysRoleUserService = sysRoleUserService;
	}
	
}