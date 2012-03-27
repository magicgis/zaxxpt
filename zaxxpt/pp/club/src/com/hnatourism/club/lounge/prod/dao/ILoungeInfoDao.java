package com.hnatourism.club.lounge.prod.dao;

import java.util.HashMap;
import java.util.List;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场休息室产品信息表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface ILoungeInfoDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * 2011-08-15 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findByComm(LoungeInfo domain) throws DataAccessException;
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(LoungeInfo domain) throws DataAccessException;

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-16 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
 	public List findBySearchPage(Object o) throws DataAccessException;
 	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-16 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findBySearchCityPage(Object o) throws DataAccessException;
 	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-16 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findBySearch(Object o) throws DataAccessException;
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * 2011-08-16 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findBySearchCity(Object o) throws DataAccessException;

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
 	public Page findByWhere(LoungeInfo domain,PageInfo pageInfo) throws DataAccessException;
 
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public LoungeInfo findById(String id) throws DataAccessException;

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException ;

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(LoungeInfo domain) throws DataAccessException;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(LoungeInfo domain) throws DataAccessException;
}
