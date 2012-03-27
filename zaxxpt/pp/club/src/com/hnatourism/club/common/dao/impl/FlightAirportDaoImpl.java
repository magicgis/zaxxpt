package com.hnatourism.club.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.dao.IFlightAirportDao;
import com.hnatourism.club.common.domain.FlightAirport;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.jdbc.support.JdbcDAOSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机场信息
 * 
 * 历史版本: 2010-07-08 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class FlightAirportDaoImpl extends AbstractIBatisDaoSupport implements
		IFlightAirportDao {
	private static final Log log = LogFactory
			.getLog(FlightAirportDaoImpl.class);
	private JdbcDAOSupport jdbcDAOSupport;

	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findMultiByWhere(FlightAirport domain)
			throws DataAccessException {
		return getPersistanceManager().find("findMultiFlightAirportByWhere",
				domain);
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(FlightAirport domain) throws DataAccessException {
		List list = new ArrayList();
		PageInfo pageInfo = (PageInfo) ContextHolder.getContext().getAttribute(
				PageInfo.PAGEINFO);
		if (pageInfo == null) {
			list = getPersistanceManager().find("findFlightAirportByWhere",
					domain);
		} else {
			Page page = this.getPersistanceManager().find(
					"findFlightAirportByWhere", domain, pageInfo);
			ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO,
					page.getPageInfo());
			list = page.getData();
		}
		return list;
	}

	public List<FlightAirport> findByWhere4JDBC() {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select t.create_user, t.id, t.code, t.name, t.city,");
//		sb.append(" t.airport_ename, t.update_time, t.update_user,");
//		sb.append(" t.rmk, t.create_time, t.sts, t.is_main, t.lname");
//		sb.append(" from flight_airport t");
//		sb.append(" where t.sts != ?");
		// 使用link表
//		String sql = "select * from flight_airport"+ Constants.LINK_NAME + " t where t.sts != ?";
		
		// 机场信息SQL
		StringBuffer sql = new StringBuffer();
		
		// 查询条件
		List<String> values = new ArrayList<String>();

		sql.append("SELECT FA.*, C.PCNAME CITY_NAME, C.SEARCHKEY PINYIN ");
		sql.append(" FROM HNA_PROCITY").append(Constants.LINK_NAME).append(" C ");
		sql.append(" INNER JOIN FLIGHT_AIRPORT").append(Constants.LINK_NAME).append(" FA");
		sql.append(" ON C.PCCODE = FA.CITY");

		// 查询条件
		sql.append(" where FA.sts != ?");
		values.add("0");
		return this.jdbcDAOSupport.findObjs(sql.toString(), values,
				FlightAirport.class);
	}

	// 多条件查询
	@Override
	public Page findByWhere(FlightAirport domain, PageInfo pageInfo)
			throws DataAccessException {
		return this.getPersistanceManager().find("findFlightAirportByWhere",
				domain, pageInfo);
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * 
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public FlightAirport findById(String id) throws DataAccessException {
		return (FlightAirport) getPersistanceManager().load(
				"findFlightAirportById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * 
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		FlightAirport domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '" + id
					+ "' object not exist");
		}
		return getPersistanceManager().delete("deleteFlightAirport", id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * 
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(FlightAirport domain) throws DataAccessException {
		FlightAirport tmp = findById(domain.getId().toString());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '" + domain.getId()
					+ "' object not exist");
		}
		return getPersistanceManager().update("updateFlightAirport", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(FlightAirport domain) throws DataAccessException {
		return getPersistanceManager().insert("insertFlightAirport", domain);
	}

	public void setJdbcDAOSupport(JdbcDAOSupport jdbcDAOSupport) {
		this.jdbcDAOSupport = jdbcDAOSupport;
	}

}