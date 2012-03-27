package com.hnatourism.club.flight.web.vo;

import java.util.List;
/**
*机票缓存vo wuyuhu
*2011-8-23
*/
public class FlightCacheVo {

	private String name;
	private String code;
	private String pinyin;
	private String hotcity;
	private List<FlightAirport> flightAirportList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getHotcity() {
		return hotcity;
	}
	public void setHotcity(String hotcity) {
		this.hotcity = hotcity;
	}
	public List<FlightAirport> getFlightAirportList() {
		return flightAirportList;
	}
	public void setFlightAirportList(List<FlightAirport> flightAirportList) {
		this.flightAirportList = flightAirportList;
	}
	
}
