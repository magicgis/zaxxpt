package com.hnatourism.club.common.cache;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.springframework.util.LinkedMultiValueMap;

import com.hnatourism.club.common.dao.IFlightAirportDao;
import com.hnatourism.club.common.domain.FlightAirport;
import com.hnatourism.club.common.helper.flight.SearchFlightCacheResponseMessage;
import com.hnatourism.club.common.helper.protocol.AirlineCompanyUtils;
import com.hnatourism.club.flight.web.vo.FlightCacheVo;
import com.hnatourism.framework.cache.CacheDataManager;
import com.hnatourism.framework.cache.abstractcache.AbstractEhCache;
import com.hnatourism.framework.core.daosupport.ConnectionManager;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.MapUtils;
import com.hnatourism.framework.utils.StringUtils;
/**
*机票缓存 wuyuhu
*/

public class FlightCache extends AbstractEhCache{
	private IFlightAirportDao flightAirportDao = null;
	private SearchFlightCacheResponseMessage searchFlightCacheResponseMessage=new SearchFlightCacheResponseMessage();
	/**
	 * @description 【加载缓存】
	 * @see com.hnatourism.framework.cache.abstractcache.IDataCache#loadCache()
	 * @author zhangyun
	 */
	@Override
	public void loadCache() throws Exception {
		try {
			ConnectionManager.getConnection();
			// 机场信息
			List<FlightAirport> airportList = flightAirportDao
					.findByWhere4JDBC();
			Map<String, String> airportNameMap = new DualHashBidiMap();
			Map<String, FlightAirport> airportMap = new HashMap();
			LinkedMultiValueMap<String, Object> cityAirportMap = new LinkedMultiValueMap<String, Object>();
			for (FlightAirport temp : airportList) {
				// 双向map code--name
				airportNameMap.put(temp.getCode(), temp.getName());
				// 机场map
				airportMap.put(temp.getCode(), temp);
				cityAirportMap.add(temp.getCity(), temp);
			}

			// 临近机场信息
//			List<FlightNearAirport> nearAirportList = flightNearAirportDao
//					.findByWhere4JDBC();
//			LinkedMultiValueMap<String, Object> nearAirportMap = new LinkedMultiValueMap<String, Object>();
//			for (FlightNearAirport temp : nearAirportList) {
//				nearAirportMap.add(temp.getMainCode(), temp);
//			}

			put("FLIGHT_AIRPORT", airportList);
//			put("FLIGHT_NEAR_AIRPORT", nearAirportList);

			put("FLIGHT_AIRPORT_MAP", airportMap);// 机场CODE为key
			put("FLIGHT_AIRPORT_NAME_MAP", airportNameMap);// 机场CODE为key
			put("FLIGHT_AIRPORT_CITY_MAP", cityAirportMap);// 机场CODE为key
//			put("FLIGHT_NEAR_AIRPORT_MAP", nearAirportMap);// 主机场CODE为key
			// put("FLIGHT_BAF_MAP", airBafMap);//不能实现MAP
		} catch (Exception e) {
			throw new BusinessException("FlightCache.loadCache()", e);

		} finally {
			ConnectionManager.freeConnection();
		}
	}
	public IFlightAirportDao getFlightAirportDao() {
		return flightAirportDao;
	}
	public void setFlightAirportDao(IFlightAirportDao flightAirportDao) {
		this.flightAirportDao = flightAirportDao;
	}
	//所有航空公司键
	public static String [] getAirlineCorp() {
		String[] airlineCompanyArr = AirlineCompanyUtils.AIR_COMPANYS.values().toArray(new String[0]);
		return airlineCompanyArr;
	}
	//获取航空公司名称
	public static String companyName(String code){
		String name=AirlineCompanyUtils.getNameByCode(code);
		return name;
	}
	//获取航空公司code
	public static String companyCode(String name){
		String code=AirlineCompanyUtils.getCodeByName(name);
		return code;
	}
	//所有城市
	public static List<FlightCacheVo> cityAllList(){
		List<FlightCacheVo> cityAllList=SearchFlightCacheResponseMessage.cityAllCache;
		return cityAllList;
	}
	//获取所有机场
	public static List<FlightAirport> flightAllAirport(){
//		 List<FlightAirport> flightAllAirport=SearchFlightCacheResponseMessage.flightAirportListCache;
		 List<FlightAirport> flightAllAirport = (List<FlightAirport>) CacheDataManager.get("FLIGHT_AIRPORT");
		 return flightAllAirport;
	}
	//通过机场code获得机场
	public static FlightAirport flightAirport(){
		FlightAirport flightAirport=null;
		return flightAirport;
	}
	
	public static String getAircraftType(String code){
		return null;
	}
	
//	public static FlightAirlineCompany getAirlineCompany(String airlineCorpCode) {
//		Map<String, FlightAirlineCompany> airlineCorpMap = (Map<String, FlightAirlineCompany>) CacheDataManager
//				.get("FLIGHT_AIRLINE_COMPANY_MAP");
//		return airlineCorpMap.get(airlineCorpCode);
//	}

	/**
	 * @description 【根据航空公司编码获取航空公司名称】
	 * @param airportCode
	 * @return
	 * @author zhangyun
	 */
//	public static String getAirlineCorp(String airlineCorpCode) {
//		FlightAirlineCompany flightAirlineCompany = getAirlineCompany(airlineCorpCode);
//		if (null != flightAirlineCompany) {
//			return flightAirlineCompany.getName();
//		} else {
//			return null;
//		}
//
//	}

	/**
	 * @description 【根据机场编码获取城市编码】
	 * @param airportCode
	 * @return
	 * @author zhangyun
	 */
	public static String getCityCodeByAirport(String airportCode) {
		Map<String, FlightAirport> airportMap = (Map<String, FlightAirport>) CacheDataManager
				.get("FLIGHT_AIRPORT_MAP");
		FlightAirport flightAirport = airportMap.get(airportCode);
		String airportCity = null;
		if (flightAirport != null) {
			airportCity = flightAirport.getCity();
		}
		return airportCity;
	}

	/**
	 * 根据城市code获取同城下的全部机场code 类型: XXX,XXX,XXX
	 * 
	 * @param cityCode
	 * @return
	 * @author xianren2003
	 */
	public static String getSameCityAirportCodeByCityCode(String cityCode) {
		if (StringUtils.isEmpty(cityCode)) {
			return null;
		}
		String result = "";
		// 机场缓存
		LinkedMultiValueMap<String, Object> airPortCode = (LinkedMultiValueMap<String, Object>) CacheDataManager
				.get("FLIGHT_AIRPORT_CITY_MAP");
		List airPortList = (List) airPortCode.get(cityCode);
		if(ListUtils.isEmpty(airPortList)){
			return null;
		}
		for (FlightAirport flightAirport : (List<FlightAirport>) airPortList) {
			result += "".equals(result) ? flightAirport.getCode() : ","
					+ flightAirport.getCode();
		}
		return result;
	}

	/**
	 * 根据机场code获取同城下的全部机场code 类型: XXX,XXX,XXX
	 * 
	 * @param airportCode
	 * @return
	 * @author xianren2003
	 */
	public static String getSameCityAirportCodeByAirportCode(String airportCode) {
		if (StringUtils.isEmpty(airportCode)) {
			return null;
		}
		// 城市code
		String cityCode = FlightCache.getCityCodeByAirport(airportCode);
		return getSameCityAirportCodeByCityCode(cityCode);
	}

	/**
	 * @description 【根据机场编码获取机场名称】
	 * @param airportCode
	 * @return
	 * @author zhangyun
	 */
	public static String getAirportName(String airportCode) {
		Map<String, String> airportNameMap = (Map<String, String>) CacheDataManager
				.get("FLIGHT_AIRPORT_NAME_MAP");
		return airportNameMap.get(airportCode);
	}



	/**
	 * @description 【获取城市 双机场信息】
	 * @return
	 * @author zyun
	 */
	public static LinkedMultiValueMap<String, Object> getSlitAirportMap() {
		// String [] beijing=new String[]{"PEK","NAY"};
		// String [] shanghai=new String[]{"SHA","PVG"};
		// String [] wuhan=new String[]{"WJD","WUH"};
		// FlightCache.slitAirportMap.put("010", beijing);
		// FlightCache.slitAirportMap.put("100000002194", shanghai);
		// FlightCache.slitAirportMap.put("100000001748", wuhan);
		return (LinkedMultiValueMap<String, Object>) CacheDataManager
				.get("FLIGHT_AIRPORT_CITY_MAP");
	}

	/**
	 * 获取主机场编码
	 * 
	 * @param list
	 * @return
	 * @author zyun
	 */
	public static String getMainAirportCode(List list) {
		FlightAirport flightAirport = null;
		String mainAirport = null;
		for (int i = 0; i < list.size(); i++) {
			flightAirport = (FlightAirport) list.get(i);
			if ("1".equals(flightAirport.getIsMain())) {
				mainAirport = flightAirport.getCode();
				break;
			}
		}
		return mainAirport;
	}
}
