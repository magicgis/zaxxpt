package com.hnatourism.club.common.dao;

import java.util.List;

import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.club.common.domain.FlightAirport;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机场信息
 * 
 * 历史版本:
 *					2010-07-08 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface IFlightAirportDao {
	public List findMultiByWhere(FlightAirport domain) throws DataAccessException;
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(FlightAirport domain) throws DataAccessException ;
	//多条件查询
	public Page findByWhere(FlightAirport domain,PageInfo pageInfo) throws DataAccessException;
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public FlightAirport findById(String id) throws DataAccessException ;

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
	public int update(FlightAirport domain) throws DataAccessException ;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(FlightAirport domain) throws DataAccessException ;
	
	public List<FlightAirport> findByWhere4JDBC();
}
