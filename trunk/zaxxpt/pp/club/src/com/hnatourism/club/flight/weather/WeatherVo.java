package com.hnatourism.club.flight.weather;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机票预订 城市天气预报
 * 
 * 历史版本: 2011-08-25 v1.0.0 (hna) 创建:
 * 
 */
public class WeatherVo {
	//城市名称
	private String cityName;
	//当天
	private String toDay;
	//当天天气名
	private String nowWeatherName;
	//当天天气英文名
	private String nowWeatherEngName;
	//当天温度
	private String nowDeTemperature;
	//明天
	private String nextDay;
	//明天天气名
	private String nextWeatherName;
	//明天天气英文名
	private String nextWeatherEngName;
	//明天温度
	private String nextDeTemperature;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getToDay() {
		return toDay;
	}
	public void setToDay(String toDay) {
		this.toDay = toDay;
	}
	public String getNowWeatherName() {
		return nowWeatherName;
	}
	public void setNowWeatherName(String nowWeatherName) {
		this.nowWeatherName = nowWeatherName;
	}
	public String getNowWeatherEngName() {
		return nowWeatherEngName;
	}
	public void setNowWeatherEngName(String nowWeatherEngName) {
		this.nowWeatherEngName = nowWeatherEngName;
	}
	public String getNowDeTemperature() {
		return nowDeTemperature;
	}
	public void setNowDeTemperature(String nowDeTemperature) {
		this.nowDeTemperature = nowDeTemperature;
	}
	public String getNextDay() {
		return nextDay;
	}
	public void setNextDay(String nextDay) {
		this.nextDay = nextDay;
	}
	public String getNextWeatherName() {
		return nextWeatherName;
	}
	public void setNextWeatherName(String nextWeatherName) {
		this.nextWeatherName = nextWeatherName;
	}
	public String getNextWeatherEngName() {
		return nextWeatherEngName;
	}
	public void setNextWeatherEngName(String nextWeatherEngName) {
		this.nextWeatherEngName = nextWeatherEngName;
	}
	public String getNextDeTemperature() {
		return nextDeTemperature;
	}
	public void setNextDeTemperature(String nextDeTemperature) {
		this.nextDeTemperature = nextDeTemperature;
	}
	
	
}
