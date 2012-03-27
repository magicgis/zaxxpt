package com.hnatourism.club.product.base.dao;


import java.util.List;

import com.hnatourism.club.product.base.domain.ProdCaptcha;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:消费验证码
 * 
 * 历史版本:
 *					2011-08-29 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface IProdCaptchaDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(ProdCaptcha domain) throws DataAccessException;

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
 	public Page findByWhere(ProdCaptcha domain,PageInfo pageInfo) throws DataAccessException;
 
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public ProdCaptcha findById(String id) throws DataAccessException;

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
	public int update(ProdCaptcha domain) throws DataAccessException;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(ProdCaptcha domain) throws DataAccessException;
}
