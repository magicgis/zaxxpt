package com.hnatourism.club.member.log.dao;

import java.util.List;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.club.member.log.domain.LogOperate;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员操作日志表
 * 
 * 历史版本:
 *					2011-10-17 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface ILogOperateDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(LogOperate domain) throws DataAccessException ;
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
  public Page findByWhere(LogOperate domain,PageInfo pageInfo) throws DataAccessException;
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public LogOperate findById(String id) throws DataAccessException ;

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
	public int update(LogOperate domain) throws DataAccessException ;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(LogOperate domain) throws DataAccessException ;
}
