package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

/**
*天气预报请求串 quhailong
*/

public class WeatherRequestMessage extends RequestMessage{
	private String deCity;
	private String arCity;
	private String type;
	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL + "/weather.jsp?"+"deCity="+deCity+"&arCity="+arCity+"&type="+type;
		return url;
	}
	

	public String getDeCity() {
		return deCity;
	}


	public void setDeCity(String deCity) {
		this.deCity = deCity;
	}


	public String getArCity() {
		return arCity;
	}
	public void setArCity(String arCity) {
		this.arCity = arCity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
