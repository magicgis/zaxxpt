package com.hnatourism.club.base.service;

import java.util.List;

import com.hnatourism.club.base.domain.SysRoleUser;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.service.IService;

@SuppressWarnings("unchecked")
public interface ISysRoleUserService extends IService {
	/**
	 * 根据条件查询用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysRoleUser domain) throws BusinessException;

	/**
	 * 根据ID查询用户权限记录
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysRoleUser findById(String id) throws BusinessException;

	/**
	 *  删除用户权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException;

	/**
	 * 修改用户权限记录
	 * @param domain
	 * @throws BusinessException
	 */
	public void update(SysRoleUser domain) throws BusinessException;

	/**
	 * 新增用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysRoleUser domain) throws BusinessException;

	/**
	 * 新增用户的角色
	 * @param SysUserId
	 * @param roles
	 * @throws BusinessException
	 */
	public void saveSystemRoleUser(String SysUserId,String roles) throws BusinessException;
	
	public List findRoleName(SysRoleUser domain) throws BusinessException;
	
	/**
	 * 通过用户sysUserId得到 List<SysRoleUser> 对象
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public List<SysRoleUser> findByUserId(String sysUserId) throws BusinessException ;
	/**
	 * 通过用户sysRoleId得删除角色-用户对应关系
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public void delByRoleId(String sysRoleId) throws BusinessException;
	//根据userid取得角色code
	public String getRolecodeByUserId(String id)throws BusinessException;
}