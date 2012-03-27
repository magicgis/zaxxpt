package com.hnatourism.club.personal.member.dao;

import java.util.List;

import com.hnatourism.club.personal.member.domain.XlbBalance;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:金币账户信息
 * 
 * 历史版本:
 *					2010-07-16 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface IXlbBalanceDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(XlbBalance domain) throws DataAccessException;

	/**
	 * 【根据条件查询- 分页】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(XlbBalance domain, PageInfo pageInfo)
			throws DataAccessException;

	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public XlbBalance findById(String id) throws DataAccessException;

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException;

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(XlbBalance domain) throws DataAccessException;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(XlbBalance domain) throws DataAccessException;

	/**
	 * @description 【通过用户ID查找】
	 * @param memberId
	 * @return
	 * @throws DataAccessException
	 * @createTime 2010-8-17 下午12:55:56
	 * @author lzb
	 */
	public XlbBalance findByMemberId(String memberId) throws DataAccessException;
}
