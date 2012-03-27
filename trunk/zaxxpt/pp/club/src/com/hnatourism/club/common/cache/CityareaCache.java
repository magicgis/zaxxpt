package com.hnatourism.club.common.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

import com.hnatourism.club.common.dao.IHnaProcityDao;
import com.hnatourism.club.common.domain.HnaProcity;
import com.hnatourism.framework.cache.CacheDataManager;
import com.hnatourism.framework.cache.abstractcache.AbstractEhCache;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.MapUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.core.daosupport.ConnectionManager;
import com.hnatourism.framework.core.exception.BusinessException;

/**
 * @author zhangyun
 * 
 */
@SuppressWarnings("unchecked")
public class CityareaCache extends AbstractEhCache {

//	private IHnaCityareaDao hnaCityareaDao;
	private IHnaProcityDao hnaProcityDao;

	/**
	 * @description 【加载缓存】
	 * @see com.hnatourism.framework.cache.abstractcache.IDataCache#loadCache()
	 * @author zhangyun
	 */
	@Override
	public void loadCache() throws Exception {
		try {
			ConnectionManager.getConnection();
//			// 全行政区
//			List<HnaCityarea> listAdminArea = hnaCityareaDao
//					.getAreaByType4JDBC("1");
//			// 全经济区
//			List<HnaCityarea> listEconArea = hnaCityareaDao
//					.getAreaByType4JDBC("2");
//			List<HnaCodeRef> hnaCodeRefList = hnaCityareaDao
//					.getAllHnaCodeRefs();

			// 全城市
			HnaProcity hnaProcity = new HnaProcity();
			hnaProcity.setPctype("2");
			List<HnaProcity> listCity = hnaProcityDao
					.findByWhere4JDBC(hnaProcity);
			// 全省份
			List<HnaProcity> listProvince = hnaProcityDao
					.getCitiesByType4JDBC("1");
			// 全国家
			List<HnaProcity> listCountry = hnaProcityDao
					.getCitiesByType4JDBC("0");
			// 全行政区域
			List<HnaProcity> listAllCities = hnaProcityDao
					.getCitiesByType4JDBC(null);

			Map<String, String> cityWeatherMap = new HashMap();
			Map<String, String> cityMap = new DualHashBidiMap();
			Map<String, HnaProcity> cityObjMap = new HashMap<String, HnaProcity>();
			if (!ListUtils.isEmpty(listCity)) {
				for (HnaProcity temp : listCity) {
					// 双向map code--name
					if (StringUtils.isNotEmpty(temp.getWeatherkey())) {
						cityWeatherMap.put(temp.getPcname(), temp
								.getWeatherkey());
					}
					cityMap.put(temp.getPccode(), temp.getPcname());
					cityObjMap.put(temp.getPccode(), temp);
				}
			}
			
			
			Map<String, String> countryMap = new DualHashBidiMap();
			if (!ListUtils.isEmpty(listCountry)) {
				for (HnaProcity temp : listCountry) {
					countryMap.put(temp.getPccode(), temp.getPcname());
				}
			}
			
			Map<String, String> provinceMap = new DualHashBidiMap();
			if (!ListUtils.isEmpty(listProvince)) {
				for (HnaProcity temp : listProvince) {
					provinceMap.put(temp.getPccode(), temp.getPcname());
				}
			}
			// 全行政区
//			put("ADMINAREA", listAdminArea);
//			// 全经济区
//			put("ECONAREA", listEconArea);
//			put("hnaCodeRefList", hnaCodeRefList);
			// 全城市
			put("CITY", listCity);
			// 全省份
			put("PROVINCE", listProvince);
			// 全国家
			put("COUNTRY", listCountry);
			// 全行政区域
			put("ALLCITIES", listAllCities);
			put("CITY_MAP", cityMap);
			put("CITY_OBJ_MAP", cityObjMap);
			put("CITY_WEATHER_MAP", cityWeatherMap);
			put("PROVINCE_MAP", provinceMap);
			put("COUNTRY_MAP", countryMap);

		} catch (Exception e) {
			throw new BusinessException("loadCache", e);

		} finally {
			ConnectionManager.freeConnection();
		}
	}

	/**
	 * 
	 * @param outCityCode
	 * @return
	 * @author lx
	 */
//	public static String getOutCityName(String outCityCode) {
//		List<HnaCodeRef> list = (List<HnaCodeRef>) CacheDataManager
//				.get("hnaCodeRefList");
//		String cityName = null;
//		for (HnaCodeRef temp : list) {
//			if (outCityCode.equals(temp.getOutCode())) {
//				cityName = temp.getCodeName();
//				break;
//			}
//		}
//		return cityName;
//	}
//
//	public static String getOutCityCode(String cityCode) {
//		List<HnaCodeRef> list = (List<HnaCodeRef>) CacheDataManager
//				.get("hnaCodeRefList");
//		String outCityCode = null;
//		for (HnaCodeRef temp : list) {
//			if (cityCode.equals(temp.getHnaCode())) {
//				outCityCode = temp.getOutCode();
//				break;
//			}
//		}
//		return outCityCode;
//	}

	/**
	 * @description 【通过code获取城市常量值】
	 * @param code
	 * @return
	 * @author zhangyun
	 */
	public static String getCityName(String code) {
		Map<String, String> map = (Map<String, String>) CacheDataManager
				.get("CITY_MAP");
		String cityName = null;
		if (!MapUtils.isEmpty(map)) {
			cityName = (String) map.get(code);
		}
		return cityName;
	}
	/**
	 * @description 【通过code获取国家常量值】
	 * @param code
	 * @return
	 * @author zhangyun
	 */
	public static String getCountryName(String code) {
		Map<String, String> map = (Map<String, String>) CacheDataManager
				.get("COUNTRY_MAP");
		String countryName = null;
		if (!MapUtils.isEmpty(map)) {
			countryName = (String) map.get(code);
		}
		return countryName;
	}
	/**
	 * @description 【通过code获取省份常量值】
	 * @param code
	 * @return
	 * @author zhangyun
	 */
	public static String getProvinceName(String code) {
		Map<String, String> map = (Map<String, String>) CacheDataManager
				.get("PROVINCE_MAP");
		String provinceName = null;
		if (!MapUtils.isEmpty(map)) {
			provinceName = (String) map.get(code);
		}
		return provinceName;
	}
	/**
	 * @description 【通过code获取天气常量值】
	 * @param code
	 * @return
	 * @author zhangyun
	 */
	public static String getWeatherCityCode(String cityName) {
		String weatherCityCode = null;
		HashMap map = (HashMap) CacheDataManager.get("CITY_WEATHER_MAP");
		if (!MapUtils.isEmpty(map)) {
			weatherCityCode = (String) map.get(cityName);
		}
		return weatherCityCode;
	}


//	public void setHnaCityareaDao(IHnaCityareaDao hnaCityareaDao) {
//		this.hnaCityareaDao = hnaCityareaDao;
//	}

	public void setHnaProcityDao(IHnaProcityDao hnaProcityDao) {
		this.hnaProcityDao = hnaProcityDao;
	}

	public static void main(String[] args) {
		if ("ADMINAREA".equalsIgnoreCase("adminarea")) {
			System.out.println("true!");
		} else {
			System.out.println("false!");
		}
	}

}
