package com.hnatourism.club.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.dao.IHnaProcityDao;
import com.hnatourism.club.common.domain.HnaProcity;
import com.hnatourism.framework.BusinessException;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.jdbc.support.JdbcDAOSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;

@SuppressWarnings("unchecked")
public class HnaProcityDaoImpl extends AbstractIBatisDaoSupport implements
		IHnaProcityDao {
	private static final Log log = LogFactory.getLog(HnaProcityDaoImpl.class);
	private JdbcDAOSupport jdbcDAOSupport;

	/**
	 * 根据省份编码获取所有城市
	 * 
	 * @param cityCode
	 * @return List<HnaProcity>
	 * @throws BusinessException
	 */
	public List<HnaProcity> getAllSonCityByCode(String cityCode)
			throws BusinessException {
		return (List<HnaProcity>) this.getPersistanceManager().find(
				"findAllSonCityByCode", cityCode);
	}

	/**
	 * 根据城市编码获取城市信息
	 * 
	 * @param cityCode
	 * @return HnaProcity
	 * @throws BusinessException
	 */
	public HnaProcity getHnaProcityByCityCode(String cityCode)
			throws BusinessException {
		return (HnaProcity) this.getPersistanceManager().load(
				"findHnaProcityByCityCode", cityCode);
	}

	/**
	 * 得到所有城市
	 * 
	 * @return List<HnaProcity>
	 * @throws BusinessException
	 */
	public List<HnaProcity> getAllOrderByShortname() throws BusinessException {
		return (List<HnaProcity>) this.getPersistanceManager().find(
				"findAllOrderByShortname");
	}

	/**
	 * 根据城市或省份名称得到其对应的code
	 * 
	 * @return HnaProcity
	 * @throws BusinessException
	 */
	public HnaProcity getCodeByName(HnaProcity hnaProcity) {
		List<HnaProcity> list = (List<HnaProcity>) this.getPersistanceManager()
				.find("getAllHnaCityareaByCityCode", hnaProcity);
		if (list != null && list.size() > 0) {
			HnaProcity result = list.get(0);
			return result;
		} else {
			return null;
		}
	}

	public List<HnaProcity> getAllCityByArea(String area) {

		return (List<HnaProcity>) this.getPersistanceManager().find(
				"getAllCityByArea", area);
	}

	public List<HnaProcity> loadAllCity() {

		return (List<HnaProcity>) this.getPersistanceManager().find(
				"getAllCity");
	}

	public List<HnaProcity> getCitiesByType(String pctype) {
		return (List<HnaProcity>) this.getPersistanceManager().find(
				"getCitiesByType", pctype);
	}

	public List<HnaProcity> getCitiesByType4JDBC(String pctype) {
		// 使用link表
		String sql = "select * from hna_procity" + Constants.LINK_NAME;
		List<String> values = null;
		if (!StringUtils.isEmpty(pctype)) {
			sql = sql + " where pctype= ? order by ishot desc, pcname";
			values = new ArrayList<String>();
			values.add(pctype);
		} else {
			values = null;
		}
		return this.jdbcDAOSupport.findObjs(sql, values, HnaProcity.class);
	}

	/**
	 * 导出时取得所有的城市
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<HnaProcity> getAllProCityAndArea() throws BusinessException {
		return (List<HnaProcity>) this.getPersistanceManager().find(
				"getAllProCity", "");
	}

	public HnaProcity findHnaProvinceOrCity(HnaProcity hnaProcity) {
		List<HnaProcity> list = (List<HnaProcity>) this.getPersistanceManager()
				.find("findHnaProvinceOrCity", hnaProcity);
		if (list != null && list.size() > 0) {
			HnaProcity result = list.get(0);
			return result;
		} else {
			return null;
		}
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(HnaProcity domain) throws DataAccessException {
		return getPersistanceManager().find("findHnaProcityByWhere", domain);
	}

	public List<HnaProcity> findByWhere4JDBC(HnaProcity domain) {
		StringBuffer sb = new StringBuffer();
		sb.append("select t.pccode, t.pcname, t.parentcode, t.parentname,");
		sb.append(" t.area, t.isopen, t.ishot, t.searchkey,  t.mapbarkey,");
		sb.append(" t.weatherkey, t.rmk, t.shortname, t.pctype");
		// 使用link表
		sb.append(" from hna_procity").append(Constants.LINK_NAME);
		sb.append(" t");
		sb.append(" where t.isopen <> ?");
		sb.append(" and t.pctype = ?");
		sb.append(" order by t.ishot desc, pcname");

		List<String> values = new ArrayList<String>();
		values.add("0");
		values.add(domain.getPctype());
		return this.jdbcDAOSupport.findObjs(sb.toString(), values,
				HnaProcity.class);
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(HnaProcity domain, PageInfo pageInfo)
			throws DataAccessException {
		return this.getPersistanceManager().find("findHnaProcityByWhere",
				domain, pageInfo);
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * 
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public HnaProcity findById(String id) throws DataAccessException {
		return (HnaProcity) getPersistanceManager().load("findHnaProcityById",
				id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * 
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		HnaProcity domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '" + id
					+ "' object not exist");
		}
		return getPersistanceManager().delete("deleteHnaProcity", id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * 
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(HnaProcity domain) throws DataAccessException {
		HnaProcity tmp = findById(domain.getPccode());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '" + domain.getPccode()
					+ "' object not exist");
		}
		return getPersistanceManager().update("updateHnaProcity", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(HnaProcity domain) throws DataAccessException {
		return getPersistanceManager().insert("insertHnaProcity", domain);
	}

	public void setJdbcDAOSupport(JdbcDAOSupport jdbcDAOSupport) {
		this.jdbcDAOSupport = jdbcDAOSupport;
	}
}
