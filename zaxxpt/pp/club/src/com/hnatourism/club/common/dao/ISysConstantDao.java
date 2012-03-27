/**
 * 项目名称:酒店预订系统
 * 
 * 功能描述:系统常量管理
 * 
 * 历史版本:
 *	2010-03-24 v1.0.0 (liulibo) 创建:
 * 
 */
package com.hnatourism.club.common.dao;

import java.util.List;

import com.hnatourism.club.common.domain.SysConstant;
import com.hnatourism.framework.BusinessException;

@SuppressWarnings("unchecked")
public interface ISysConstantDao {
	/**
	 * 根据条件查询系统常量记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysConstant domain) throws BusinessException ;

	/**
	 * 根据ID查询系统常量记录
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysConstant findById(String id) throws BusinessException ;

	/**
	 * 删除系统常量记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException ;

	/**
	 *  修改系统常量记录
	 * @param domain
	 * @throws BusinessException
	 */
	public void update(SysConstant domain) throws BusinessException ;

	/**
	 * 新增系统常量记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysConstant domain) throws BusinessException ;

	public List findByType(String type);
	public SysConstant findByCode(String code);
}
