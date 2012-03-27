package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
import com.hnatourism.club.flight.web.vo.FlightGroupVo;
/**
*三折票请求串 quhailong
*/
public class FlightGroupRequestMessage extends RequestMessage{
	
	private FlightGroupVo flightGroupVo;
	
	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL+"/wish/flightGroupDesire.jsp?originCity="+flightGroupVo.getOriginCity();
		url+="&destinationsCity="+flightGroupVo.getDestinationsCity();
		url+="&startTime="+flightGroupVo.getStartTime();
		url+="&totalNumber="+flightGroupVo.getTotalNumber();
		url+="&price="+flightGroupVo.getPrice();
		url+="&name="+flightGroupVo.getName();
		url+="&contact="+flightGroupVo.getContact();
		url+="&groupDesire="+flightGroupVo.getGroupDesire();
		url+="&email="+flightGroupVo.getEmail();
		url+="&memberId="+flightGroupVo.getMemberId();
		url+="&memberCode="+flightGroupVo.getMemberCode();
		url+="&isLogin=2";
		url+="&source="+flightGroupVo.getSource();
		return url;
	}

	public FlightGroupVo getFlightGroupVo() {
		return flightGroupVo;
	}

	public void setFlightGroupVo(FlightGroupVo flightGroupVo) {
		this.flightGroupVo = flightGroupVo;
	}
	
}
