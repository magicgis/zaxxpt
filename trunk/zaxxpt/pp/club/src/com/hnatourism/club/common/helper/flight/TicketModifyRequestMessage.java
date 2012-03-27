package com.hnatourism.club.common.helper.flight;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
/**
 * 机票改期申请请求串
 * @author lianpeng
 *
 */
public class TicketModifyRequestMessage extends RequestMessage {
	private static final Log log = LogFactory.getLog(TicketModifyRequestMessage.class); 
	//基本参数
	private String memberId;
	private String passengerId;
	private String orderFlightId;
	private String prodType;
	private String rmk;
	private String source;
	//机票信息
	private String baf;
	private String constructionFee;
	private String ticketPrice;
	private String aircraftType;
	private String airlineCompanyCode;
	private String arrivalAirportCode;
	private String arrivalDateStr;
	private String arrivalTimeStr;
	private String cabinCode;
	private String departureAirportCode;
	private String departureDateStr;
	private String departureTimeStr;
	private String discount;
	private String flightNo;
	private String flightType;
	private String policyCode;
	private String spendTime;
	private String commissionRate;
	
	public String getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getOrderFlightId() {
		return orderFlightId;
	}
	public void setOrderFlightId(String orderFlightId) {
		this.orderFlightId = orderFlightId;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBaf() {
		return baf;
	}
	public void setBaf(String baf) {
		this.baf = baf;
	}
	public String getConstructionFee() {
		return constructionFee;
	}
	public void setConstructionFee(String constructionFee) {
		this.constructionFee = constructionFee;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getAircraftType() {
		return aircraftType;
	}
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}
	public String getAirlineCompanyCode() {
		return airlineCompanyCode;
	}
	public void setAirlineCompanyCode(String airlineCompanyCode) {
		this.airlineCompanyCode = airlineCompanyCode;
	}
	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}
	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}
	public String getArrivalDateStr() {
		return arrivalDateStr;
	}
	public void setArrivalDateStr(String arrivalDateStr) {
		this.arrivalDateStr = arrivalDateStr;
	}
	public String getArrivalTimeStr() {
		return arrivalTimeStr;
	}
	public void setArrivalTimeStr(String arrivalTimeStr) {
		this.arrivalTimeStr = arrivalTimeStr;
	}
	public String getCabinCode() {
		return cabinCode;
	}
	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}
	public String getDepartureDateStr() {
		return departureDateStr;
	}
	public void setDepartureDateStr(String departureDateStr) {
		this.departureDateStr = departureDateStr;
	}
	public String getDepartureTimeStr() {
		return departureTimeStr;
	}
	public void setDepartureTimeStr(String departureTimeStr) {
		this.departureTimeStr = departureTimeStr;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	public String getSpendTime() {
		return spendTime;
	}
	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}
	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL + "/order/flight/flightModifyPhone.jsp?"
		+"memberId="+memberId
		+"&passengerId="+passengerId
		+"&orderFlightId="+orderFlightId
		+"&prodType="+prodType
		+"&source=51666"
		+"&baf="+baf
		+"&constructionFee="+constructionFee
		+"&ticketPrice="+ticketPrice
		+"&aircraftType="+aircraftType
		+"&airlineCompanyCode="+airlineCompanyCode
		+"&arrivalAirportCode="+arrivalAirportCode
		+"&arrivalDateStr="+arrivalDateStr
		+"&arrivalTimeStr="+arrivalTimeStr
		+"&cabinCode="+cabinCode
		+"&departureAirportCode="+departureAirportCode
		+"&departureDateStr="+departureDateStr
		+"&departureTimeStr="+departureTimeStr
		+"&discount="+discount
		+"&flightNo="+flightNo
		+"&flightType="+flightType
		+"&spendTime="+spendTime
		+"&commissionRate"+commissionRate;
		if(rmk!=""&&rmk!=null){
			url = url+"&rmk="+rmk;
		}
		if(policyCode!=""&&policyCode!=null){
			url = url+"&policyCode="+policyCode;
		}
		log.info("获取改期url：：：：：：：：："+url);
		return url;
	}

}
