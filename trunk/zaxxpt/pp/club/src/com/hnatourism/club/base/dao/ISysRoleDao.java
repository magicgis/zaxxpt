package com.hnatourism.club.base.dao;

import java.util.List;

import com.hnatourism.club.base.domain.SysRole;
import com.hnatourism.framework.core.exception.BusinessException;

@SuppressWarnings("unchecked")
public interface ISysRoleDao {
	/**
	 * 根据条件查询权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysRole domain) throws BusinessException ;

	/**
	 * 根据ID查询权限记录
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysRole findById(String id) throws BusinessException ;

	/**
	 * 删除权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException ;

	/**
	 *  修改权限记录
	 * @param domain
	 * @throws BusinessException
	 */
	public void update(SysRole domain) throws BusinessException ;

	/**
	 * 新增权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysRole domain) throws BusinessException ;

	/**
	 * 根据条件返回相应的角色列表
	 * @param systemRole
	 * @return
	 * @throws BusinessException
	 */
	public List<SysRole> querySystemRoles(SysRole systemRole) throws BusinessException;
	
	/**
	 * 根据roleId返回相应的角色列表
	 * @param roles
	 * @return
	 * @throws BusinessException
	 */
	public List<SysRole> retriveRoleByRoleIds(String roles) throws BusinessException;
	
	/**
	 * 根据角色key查询相应的角色
	 * @param roleKey
	 * @return
	 * @throws BusinessException
	 */
	public SysRole findByRoleKey(String roleKey) throws BusinessException;
}
