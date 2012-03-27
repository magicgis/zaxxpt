package com.hnatourism.club.flight.web.vo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:官网机票信息
 * 
 * 历史版本: 2011-09-02 v1.0.0 (hna) 创建:
 * 
 */
public class FlightGWVo {
	//航班号
	private String flightNo;
	//航空公司编码
	private String airlineCompanyCode;
	//出发机场Code
	private String departureAirportCode;
	//到达机场Code
	private String arrivalAirportCode;
	//仓位
	private String cabinCode;
	//退改签规则
	private String cabinInfo;
	//价格
	private String price;
	//来源
	private String origin;
	//出发时间
	private String departureTime;
	//到达时间
	private String arrivalTime;
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirlineCompanyCode() {
		return airlineCompanyCode;
	}
	public void setAirlineCompanyCode(String airlineCompanyCode) {
		this.airlineCompanyCode = airlineCompanyCode;
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
	public String getCabinCode() {
		return cabinCode;
	}
	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}
	public String getCabinInfo() {
		return cabinInfo;
	}
	public void setCabinInfo(String cabinInfo) {
		this.cabinInfo = cabinInfo;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
}
