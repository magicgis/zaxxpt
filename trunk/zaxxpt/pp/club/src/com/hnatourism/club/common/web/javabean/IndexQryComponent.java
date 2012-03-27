package com.hnatourism.club.common.web.javabean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.springframework.web.util.HtmlUtils;

import com.hnatourism.club.common.util.IpUtils;
import com.hnatourism.club.common.web.vo.WeatherVo;
import com.hnatourism.framework.cache.CacheDataManager;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.utils.StringUtils;

/**
 * @description 【首页查询组件】
 * @author zhangyun
 *
 */
public class IndexQryComponent {
//	// 广告服务
//	private ISysAdvertisingService sysAdvertisingService;
//	//热门城市
//	private IRecommendCityService recommendCityService;
//	//推荐酒店
//	private IHotelRecommendQryService hotelRecommendQryService;

	/**
	 *  获取推荐城市
	 * @param recommendCityVo
	 * @return
	 */
//	public List getRecommendAirCompany(RecommendCityQryVo recommendCityQryVo){
//		List<RecommendCityVo> listVo=null;
//		try {
//			recommendCityService=(IRecommendCityService)BeanUtils.getBeanObj("recommendCityService");
//			listVo = recommendCityService.findByWhere(recommendCityQryVo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return listVo;
//	}

	/**
	 * 获取推荐机票
	 * @param rowNum
	 * @return
	 */
//	public List<FlightRecommendVo> getRecommandFlight(String rowNum){
//		FlightQryAction flightQryAction=new FlightQryAction();
//		//返回数据
//		List<FlightRecommendVo> listFlight=flightQryAction.searchRecommendFlight(rowNum);
//		return listFlight;
//	}

	/**
	 * 获取推荐酒店
	 * @param hotelRecommendQryVo
	 * @return
	 */
//	public List<HotelRecommendVo> getRecommandHotel(HotelRecommendQryVo hotelRecommendQryVo){
//		List<HotelRecommendVo> list=new ArrayList<HotelRecommendVo>();
//		try {
//			hotelRecommendQryService=(IHotelRecommendQryService)BeanUtils.getBeanObj("hotelRecommendQryService");
//			list=hotelRecommendQryService.searchByWhere(hotelRecommendQryVo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	
 	/**
  	 * @description 获取天气
  	 * @author zhangyun
  	 */
  	public static String getWeather(WeatherVo weatherVo,HttpServletRequest request){
  		String weather = null;
  		String cityName = null;
		String defaultCity = PropertiesUtils.getVal("sysProps","city");
		String destn = PropertiesUtils.getVal("sysProps","destn");
		
  		if(weatherVo == null || StringUtils.isEmpty(weatherVo.getCitya())){
  			cityName = IpUtils.getCityByReq(request);
  			if(StringUtils.isEmpty(cityName) || cityName.equals("保留地址") || cityName.equals("本地局域网")) cityName = defaultCity;
  			if(cityName.indexOf(destn)>=0){
  				weather = IpUtils.getWeatherByCityName(cityName);
  				if(!weatherVo.getIsSingle()){
  					weather += "|"+IpUtils.getWeatherByCityName(defaultCity);
  				}
  			}
  			else{
  				weather = IpUtils.getWeatherByCityName(cityName);
  				if(!weatherVo.getIsSingle()){
  					weather += "|"+IpUtils.getWeatherByCityName(destn);
  				}
  			}
  		}
  		else{
  			if("F".equals(weatherVo.getProdType())){
  				weather = IpUtils.getWeatherByAirport(weatherVo.getCitya());
  				if(!weatherVo.getIsSingle()){
  				weather += "|"+IpUtils.getWeatherByAirport(weatherVo.getCityb());
  				}
  			}
  			else{
  				weather = IpUtils.getWeatherByCity(weatherVo.getCitya());
  				HashMap map = (HashMap) CacheDataManager.get("CITY_WEATHER_MAP");
  				DualHashBidiMap cityMap = (DualHashBidiMap) CacheDataManager.get("CITY_MAP");
  				String cityaName = (String) cityMap.get(weatherVo.getCitya());
  				if(cityaName.indexOf(destn)>=0){
  	  				weather = IpUtils.getWeatherByCityName(cityaName);
  	  				if(!weatherVo.getIsSingle()){
  	  					weather += "|"+IpUtils.getWeatherByCityName(defaultCity);
  	  				}
  	  			}
  	  			else{
  	  				weather = IpUtils.getWeatherByCityName(cityaName);
  	  				if(!weatherVo.getIsSingle()){
  	  					weather += "|"+IpUtils.getWeatherByCityName(destn);
  	  				}
  	  			}
  			}
  			
  		}
       return  weather;
  	}
}