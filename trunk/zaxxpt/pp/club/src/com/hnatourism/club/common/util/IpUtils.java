package com.hnatourism.club.common.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.bidimap.DualHashBidiMap;

import com.hnatourism.club.common.cache.CityareaCache;
import com.hnatourism.framework.cache.CacheDataManager;

/**
 * ip相关工具类
 * @author zhangyun
 *
 */
public class IpUtils extends com.hnatourism.framework.utils.IpUtils{
	/**
	 * @description 【通过请求ip获取天气】
	 * @param request
	 * @return
	 * @author zhangyun
	 */
	public static String getWeatherByIp(HttpServletRequest request){
		String ip = getIp(request);
		String cityName = getCityByIp(ip);
		return getWeatherByCityName(cityName);
	}
	/**
	 * @description 【通过请求城市名称获取天气】
	 * @param cityName
	 * @return
	 * @author zhangyun
	 */
	public static String getWeatherByCityName(String cityName){
		String weatherCityCode = CityareaCache.getWeatherCityCode(cityName);
		return getWeather(weatherCityCode,cityName);
	}
	/**
	 * @description 【通过请求城市编码获取天气】
	 * @param cityCode
	 * @return
	 * @author zhangyun
	 */
	public static String getWeatherByCity(String cityCode){
		DualHashBidiMap cityMap = (DualHashBidiMap) CacheDataManager.get("CITY_MAP");
		String cityName = (String) cityMap.get(cityCode);
		return getWeatherByCityName(cityName);
	}
	
	/**
	 * @description 【通过请求机场编码获取天气】
	 * @param airportCode
	 * @return
	 * @author zhangyun
	 */
	public static String getWeatherByAirport(String airportCode){
//		Map<String, FlightAirport> map = (Map<String, FlightAirport>) CacheDataManager.get("FLIGHT_AIRPORT_MAP");
//		FlightAirport flightAirport = (FlightAirport) map.get(airportCode);
//		return getWeatherByCity(flightAirport.getCity());
		return null;
	}
		public static void main(String[] args) {
//			IpUtils info = new IpUtils();
//			String weather = info.getWeather("CHXX0023");
//			System.out.println(weather);
//			System.out.println(getCityByIp("180.77.83.88"));
//			System.out.println(getIp(new HttpServletRequest()));
//			try {
//				InetAddress cont =InetAddress.getByName("www.google.com");
//				System.out.println(cont.getHostAddress()); 
//			} catch (UnknownHostException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			System.out.println(getCityByIp("180.77.83.88"));
//
//			InetAddress address = null;
//			try {
//				address = InetAddress.getByName(args[0]);
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
			

			
		}
		
}
