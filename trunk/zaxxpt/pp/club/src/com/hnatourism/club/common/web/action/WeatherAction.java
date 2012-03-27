package com.hnatourism.club.common.web.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.cache.CityareaCache;
import com.hnatourism.club.common.helper.flight.WeatherRequestMessage;
import com.hnatourism.club.common.service.ISysWeatherService;
import com.hnatourism.club.common.web.javabean.IndexQryComponent;
import com.hnatourism.club.common.web.vo.WeatherVo;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.web.action.BaseAction;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:官方公告
 * 
 * 历史版本:
 *					2010-08-03 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class WeatherAction extends BaseAction {
	private static final Log log = LogFactory.getLog(WeatherAction.class);

  	private WeatherVo weatherVo = null;
    
  	private ISysWeatherService sysWeatherService;
  	
	/**
  	 * @description 获取天气
  	 * @author zhangyun
  	 */
//  	public void getWeather(){
//  		StringBuffer weather = new StringBuffer();
//  		List<String> list=new ArrayList<String>();
//  		list.add(weatherVo.getCitya());
//  		list.add(weatherVo.getCityb());
//  		String weatherCityCode="";
//  		for(int i=0;i<list.size();i++){
//  		weatherVo.setCitya(list.get(i));
//  		weatherCityCode=weatherCityCode(weatherVo);
//  		String path=weatherVo.getRealPath()+"/html/common/include/weather/"+weatherCityCode+"/";
//  		//文件名
//  		String urlWeather="weather_Index_"+weatherCityCode;
//  		//判断是否存在此文件
//  		String boolWeather=GenerateUtils.isFileExists(urlWeather,weatherVo.getRealPath());
//  		if(boolWeather.equals("false")){
//  		//获取天气预报接口返回信息
//  		 weatherVo.setIsSingle(true);
//  		 String weatherStr = IndexQryComponent.getWeather(weatherVo, getRequest());
//  		 if(null != weatherStr && !"null".equals(weatherStr)){
//  			 GenerateUtils.fileExists(urlWeather,weatherStr,weatherVo.getRealPath());
//  		 }
//  		 else{
//  			weatherStr=IndexQryComponent.getWeather(weatherVo, getRequest());
//  		 }
//  		    weather.append(weatherStr);
//  			}
//  		else{
//  			try {
//  				path=path+boolWeather;
//				BufferedReader br = new BufferedReader(new FileReader(path));
//				if("null".equals( br.ready()) || false==br.ready()){
//					String weatherStr=IndexQryComponent.getWeather(weatherVo, getRequest());
//					weather.append(weatherStr);
//					GenerateUtils.fileExists(urlWeather,weatherStr,weatherVo.getRealPath());
//				}
//					while(br.ready()) {
//					weather.append(br.readLine());
//					}
//  			}catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}  catch (IOException e) {
//				e.printStackTrace();
//			}
//  		}
//  			weather.append("|");
//  		}
//  		try {
//			writeString(weather.toString(), "gson");
//  		} catch (IOException e) {
//			e.printStackTrace();
//			}
//  	}
//  	public String weatherCityCode(WeatherVo vo){
//  	//如果城市名为空 IP获取城市也为空 读取配置文件
//  		String cityNameWeatherA=null;
//  		if(vo == null || StringUtils.isEmpty(vo.getCitya())){
//  			cityNameWeatherA = IpUtils.getCityByReq(getRequest());
//  			if(cityNameWeatherA==null){
//  				cityNameWeatherA=PropertiesUtils.getVal("sysProps","city");
//  			}
//  		}
//  		//机票
//  		else if(vo.getProdType().equals("F")){
//  			Map<String, FlightAirport> mapA = (Map<String, FlightAirport>) CacheDataManager.get("FLIGHT_AIRPORT_MAP");
//  			FlightAirport flightAirport = (FlightAirport) mapA.get(vo.getCitya());
//  			cityNameWeatherA=CityareaCache.getCityName(flightAirport.getCity());
//  		}
//  		//酒店
//  		else if(vo.getProdType().equals("H")){
//  			cityNameWeatherA=CityareaCache.getCityName(vo.getCitya());
//  		}
//  		//天气预报城市code
//  		return CityareaCache.getWeatherCityCode(cityNameWeatherA);
//  	}
  public void searchWeather(){
	  StringBuffer weather = new StringBuffer("");
		List<String> list=new ArrayList<String>();
		list.add(weatherVo.getCitya());
		list.add(weatherVo.getCityb());
		for(int i=0;i<list.size();i++){
			weatherVo.setCitya(list.get(i));
			weatherVo.setIsSingle(true);
			String weatherCityCode=getWeatherCityCode(weatherVo);
			String content=(String)sysWeatherService.find(weatherCityCode);
			if(StringUtils.isEmpty(content)){
				content=IndexQryComponent.getWeather(weatherVo, getRequest());
			}
			weather.append(content+"|");
		}
		try {
			writeString(weather.toString());
		} catch (IOException e) {
		e.printStackTrace();
		}
  }
  
  	/**
	 * Ajax查询天气预报
	 */
	public void searchWeatherAjax() {
		String weatherCode = "010";
		String returnWeatherCode = "010";
		if(weatherVo != null){
			weatherCode = weatherVo.getCitya();
			returnWeatherCode = weatherVo.getCityb();
		}
		
		if (StringUtils.isEmpty(weatherCode)) {
			weatherCode = "010";
		}
		if (StringUtils.isEmpty(returnWeatherCode)) {
			weatherCode = "010";
		}
		
		log.info("weatherCode="+weatherCode);
		try {
			WeatherRequestMessage weatherRequestMessage = new WeatherRequestMessage();
			if (StringUtils.isEmpty(weatherCode)) {
				weatherCode = "010";
			}
			weatherRequestMessage.setDeCity(weatherCode);
			weatherRequestMessage.setArCity(returnWeatherCode);

			// 发送请求并获取json字符串resultStr
			String wResultStr = "";
			long a = System.currentTimeMillis();
			wResultStr = weatherRequestMessage.excute();
			long b = System.currentTimeMillis();
			System.out.println("天气预报用时：" + (b - a) + ";wResultStr="+wResultStr);

			writeString(wResultStr);
		} catch (Exception e) {
			log.error("天气预报错误信息：" + e.getMessage());
		}
	}

	public String getWeatherCityCode(WeatherVo vo){
	  		String cityNameWeatherA=null;
	  		//机票
	  	 if(vo.getProdType().equals("F")){
//	  			Map<String, FlightAirport> mapA = (Map<String, FlightAirport>) CacheDataManager.get("FLIGHT_AIRPORT_MAP");
//	  			FlightAirport flightAirport = (FlightAirport) mapA.get(vo.getCitya());
//	  			cityNameWeatherA=CityareaCache.getCityName(flightAirport.getCity());
	  		}
	  		//酒店，机场，高尔夫
	  		else{
	  			cityNameWeatherA=CityareaCache.getCityName(vo.getCitya());
	  		}
	  		//天气预报城市code
	  		return CityareaCache.getWeatherCityCode(cityNameWeatherA);
	 } 
	public WeatherVo getWeatherVo() {
		return weatherVo;
	}
	
	public void setWeatherVo(WeatherVo weatherVo) {
		this.weatherVo = weatherVo;
	}
	public ISysWeatherService getSysWeatherService() {
		return sysWeatherService;
	}
	public void setSysWeatherService(ISysWeatherService sysWeatherService) {
		this.sysWeatherService = sysWeatherService;
	}
	
	/**
	 * 调试方法 
	 * 注意此调用接口需要连接外网
	 */
	public static void main(String[] args) {
		WeatherAction weatherAction = new WeatherAction();
		weatherAction.searchWeatherAjax();
	}
	
}