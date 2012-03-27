package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
/**
*官网请求串 quhailong
*/	

public class FlightGWRequestMessage extends RequestMessage{
	private String departureAirportCode;
	private String arrivalAirportCode;
	private String departureDate;
	private String source;
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL+"/prod/flight/special_fare.jsp?dpt="+departureAirportCode+"&arr="+arrivalAirportCode+"&dptDate="+departureDate+"&airCo=&source="+source;
		return url;
	}
	
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}
	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}
	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
}
