package com.hnatourism.club.common.dao;

import java.util.List;

import com.hnatourism.club.common.domain.HnaProcity;
import com.hnatourism.framework.BusinessException;

public interface IHnaProcityDao  {

	/**
	 * 根据城市编码查询城市Bean
	 * @param cityCode 城市编码
	 * @return
	 * @throws ServiceException
	 */
	public List<HnaProcity> getAllSonCityByCode(String cityCode) throws BusinessException;
	
	/**
	 * 根据城市编码查询城市的Model
	 * @param cityCode
	 * @return
	 * @throws ServiceException
	 */
	public HnaProcity getHnaProcityByCityCode(String cityCode) throws BusinessException;
	
	/**
	 * 得到所有的城市
	 */
	public List<HnaProcity> getAllOrderByShortname() throws BusinessException;
	/**
	 * 根据城市或省份名称得到其所对应的model
	 */
	public HnaProcity getCodeByName(HnaProcity hnaProcity);

	public List<HnaProcity> getAllCityByArea(String area);

	public List findByWhere(HnaProcity hnaProcity);

	public List<HnaProcity> loadAllCity();

	public List<HnaProcity> getCitiesByType(String type);
	/**导出时取得所有的城市
	 * @return
	 * @throws BusinessException
	 */
	public List<HnaProcity> getAllProCityAndArea() throws BusinessException;
	
	public HnaProcity findHnaProvinceOrCity(HnaProcity hnaProcity);
	
	public List<HnaProcity> findByWhere4JDBC(HnaProcity domain);
	
	public List<HnaProcity> getCitiesByType4JDBC(String pctype);
	
}
