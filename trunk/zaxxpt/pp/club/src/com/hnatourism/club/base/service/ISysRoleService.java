package com.hnatourism.club.base.service;

import java.util.List;

import com.hnatourism.club.base.bean.SysRoleBean;
import com.hnatourism.club.base.domain.SysRole;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.service.IService;

@SuppressWarnings("unchecked")
public interface ISysRoleService extends IService {
	/**
	 * 根据条件查询角色记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysRole domain) throws BusinessException;

	/**
	 * 根据ID查询角色记录
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysRole findById(String id) throws BusinessException;

	/**
	 *  删除角色记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException;

	/**
	 * 修改角色记录
	 * @param domain
	 * @throws BusinessException
	 */
	public void update(SysRole domain) throws BusinessException;

	/**
	 * 新增角色记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysRole domain) throws BusinessException;

	/**
	 * 根据角色名称和角色key查询相应的角色记录
	 * @param SysRoleBean
	 * @return
	 * @throws BusinessException
	 */
	public List<SysRole> querySystemRoles(SysRoleBean SysRoleBean) throws BusinessException;
	
	/**
	 * 根据角色key(唯一)查询相应的角色
	 * @param roleKey
	 * @return
	 * @throws BusinessException
	 */
	public SysRole findByRoleKey(String roleKey) throws BusinessException;
}