package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

/**
*仓位验证请求
*/

public class VerifyFlightphoneRequestMessage extends RequestMessage {
	
	private String airlineCompany;
	private String flightNo;
	private String cabinCode;
	private String dptAirport;
	private String arrAirport;
	private String flyDate;
	private String inFlyDate;
	private String flightType;

	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL + "/prod/flight/verifyFlightphone.jsp?"
		+"airlineCompany="+airlineCompany
		+"&flightNo="+flightNo
		+"&cabinCode="+cabinCode
		+"&dptAirport="+dptAirport
		+"&arrAirport="+arrAirport
		+"&flyDate="+flyDate
		+"&inFlyDate="+inFlyDate
		+"&flightType="+flightType;
		return url;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getCabinCode() {
		return cabinCode;
	}

	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}

	public String getDptAirport() {
		return dptAirport;
	}

	public void setDptAirport(String dptAirport) {
		this.dptAirport = dptAirport;
	}

	public String getArrAirport() {
		return arrAirport;
	}

	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}

	public String getFlyDate() {
		return flyDate;
	}

	public void setFlyDate(String flyDate) {
		this.flyDate = flyDate;
	}

	public String getInFlyDate() {
		return inFlyDate;
	}

	public void setInFlyDate(String inFlyDate) {
		this.inFlyDate = inFlyDate;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getAirlineCompany() {
		return airlineCompany;
	}

	public void setAirlineCompany(String airlineCompany) {
		this.airlineCompany = airlineCompany;
	}
}
