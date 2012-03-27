package com.hnatourism.club.base.dao;

import java.util.List;

import com.hnatourism.club.base.domain.SysRoleUser;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;

@SuppressWarnings("unchecked")
public interface ISysRoleUserDao {
	/**
	 * 根据条件查询用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysRoleUser domain) throws BusinessException ;
	
	/**
	 * 根据条件查询用户权限记录 分页显示
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	public Page findByWhere(SysRoleUser domain, PageInfo pageInfo) throws BusinessException ;

	/**
	 * 根据ID查询用户权限记录
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysRoleUser findById(String id) throws BusinessException ;

	/**
	 * 删除用户权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException ;

	/**
	 *  修改用户权限记录
	 * @param domain
	 * @throws BusinessException
	 */
	public void update(SysRoleUser domain) throws BusinessException ;

	/**
	 * 新增用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysRoleUser domain) throws BusinessException ;
	
	public List loadUserRole(String sysUserId) throws BusinessException ;

	/**
	 * 通过用户sysUserId得到 List<SystemRoleUser> 对象
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public List<SysRoleUser> findByUserId(String sysUserId) throws BusinessException ;
	
	/**
	 * 通过用户sysRoleId删除角色-对象关系
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public void delByRoleId(String sysRoleId) throws BusinessException ;
	
	/**
	 * 根据关系表中的关系获得user的所有角色名称
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findRoleName(SysRoleUser domain) throws BusinessException;
	
	/**
	 * 删除关系表中关于此id的所有数据
	 * @param systemUserId
	 * @throws BusinessException
	 */
	public void deleteBySystemUserId(String systemUserId) throws BusinessException;
}
