package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.weather.WeatherVo;

/**
*天气预报 解析类 quhailong
*/

public class WeatherResponseMessage extends ResponseMessage{

	private String resultCode;
	private String message;
	private WeatherVo deCityWeatherVo;
	private WeatherVo arCityWeatherVo;
	@Override
	protected void parseBody(JSONObject obj) throws ParseException {		
		//解析出发城市天气信息
		paraseDeCityWeather((JSONObject)obj.get("deCity"));
		//解析到达城市天气信息
		paraseArCityWeather((JSONObject)obj.get("arCity"));
	}
	
	private void paraseDeCityWeather(JSONObject deCityWeatherJsonObj) {
		if(deCityWeatherJsonObj == null) return ;
		deCityWeatherVo = new WeatherVo();
		deCityWeatherVo.setCityName((String)deCityWeatherJsonObj.get("deCityName"));
		deCityWeatherVo.setToDay((String)deCityWeatherJsonObj.get("toDay"));
		deCityWeatherVo.setNowWeatherName((String)deCityWeatherJsonObj.get("nowWeatherName"));
		deCityWeatherVo.setNowWeatherEngName((String)deCityWeatherJsonObj.get("nowWeatherEngName"));
		deCityWeatherVo.setNowDeTemperature((String)deCityWeatherJsonObj.get("nowDeTemperature"));
		deCityWeatherVo.setNextDay((String)deCityWeatherJsonObj.get("nextDay"));
		deCityWeatherVo.setNextWeatherName((String)deCityWeatherJsonObj.get("nextWeatherName"));
		deCityWeatherVo.setNextWeatherEngName((String)deCityWeatherJsonObj.get("nextWeatherEngName"));
		deCityWeatherVo.setNextDeTemperature((String)deCityWeatherJsonObj.get("nextDeTemperature"));
		
	}
	
	private void paraseArCityWeather(JSONObject arCityWeatherJsonObj) {
		if(arCityWeatherJsonObj == null) return ;
		arCityWeatherVo = new WeatherVo();
		arCityWeatherVo.setCityName((String)arCityWeatherJsonObj.get("arCityName"));
		arCityWeatherVo.setToDay((String)arCityWeatherJsonObj.get("toDay"));
		arCityWeatherVo.setNowWeatherName((String)arCityWeatherJsonObj.get("nowWeatherName"));
		arCityWeatherVo.setNowWeatherEngName((String)arCityWeatherJsonObj.get("nowWeatherEngName"));
		arCityWeatherVo.setNowDeTemperature((String)arCityWeatherJsonObj.get("nowDeTemperature"));
		arCityWeatherVo.setNextDay((String)arCityWeatherJsonObj.get("nextDay"));
		arCityWeatherVo.setNextWeatherName((String)arCityWeatherJsonObj.get("nextWeatherName"));
		arCityWeatherVo.setNextWeatherEngName((String)arCityWeatherJsonObj.get("nextWeatherEngName"));
		arCityWeatherVo.setNextDeTemperature((String)arCityWeatherJsonObj.get("nextDeTemperature"));
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public WeatherVo getDeCityWeatherVo() {
		return deCityWeatherVo;
	}

	public void setDeCityWeatherVo(WeatherVo deCityWeatherVo) {
		this.deCityWeatherVo = deCityWeatherVo;
	}

	public WeatherVo getArCityWeatherVo() {
		return arCityWeatherVo;
	}

	public void setArCityWeatherVo(WeatherVo arCityWeatherVo) {
		this.arCityWeatherVo = arCityWeatherVo;
	}
	
}
