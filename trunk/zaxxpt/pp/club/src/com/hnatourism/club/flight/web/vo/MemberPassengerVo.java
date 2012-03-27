package com.hnatourism.club.flight.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;

public class MemberPassengerVo extends AbstractVo {
	/**
	*乘机人详细信息 vo wuyuhu
	*2011-8-23
	*/
	private static final long serialVersionUID = 1L;
	// 乘机人ID
	private String id;
	// 乘机人名
	private String name;
	// 乘客类型01成人; 02儿童
	private String type;
	// 乘客类型为01成人时：证件类型: 0身份证;1护照; 2军官证;
	// 3港澳通行证 ; 4回乡证; 5台胞证; 6国际海员证; 7外国人永久居留证; 9其他；乘客类型为02儿童时：证件类型：0身份证;9出生日期
	private String certType;
	// 乘客航班类型 1去程 2返程
	private String flightType;
	//证件号码（类型为儿童，证件类型选择为出生日期时，格式为：YYYY-MM-DD）
	private String certNo;
	//票号
	private String etNo;
	//客票状态
	private String ticketSts;
	//票价
	private String ticketPrice;
	//燃油费
	private String bafPrice;
	//机建费
	private String constructionPrice;
	//票款总额
	private String applyMoney;
	//航空公司Code
	private String airlineCompanyCode;
	//航班号
	private String flightNo;
	//舱位编码
	private String cabinCode;
	//出发日期
	private String departureDate;
	//到达日期
	private String arrivalDate;
	//出发城市
	private String departureAirport;
	//到达城市
	private String arrivalAirport;
	//出发机场code
	private String departureAirportCode;
	//到达机场code
	private String arrivalAirportCode;
	//电子客票号
	private String ruleExlain;
	//佣金
	private String commission;
	//总佣金比例
	private String pnr;
	
	private String totalCommission;
	//总保险
	private String insurance;
	//保单号  PA-11111，12345
	private String insuranceCode;
	//保单状态 1已申请2已投保3退保中4已退保5已取消
	private String insuranceSts;
	//保单数量
	private String insuranceNum;
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public String getTotalCommission() {
		return totalCommission;
	}
	public void setTotalCommission(String totalCommission) {
		this.totalCommission = totalCommission;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getTicketSts() {
		return ticketSts;
	}
	public void setTicketSts(String ticketSts) {
		this.ticketSts = ticketSts;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getBafPrice() {
		return bafPrice;
	}
	public void setBafPrice(String bafPrice) {
		this.bafPrice = bafPrice;
	}
	public String getConstructionPrice() {
		return constructionPrice;
	}
	public void setConstructionPrice(String constructionPrice) {
		this.constructionPrice = constructionPrice;
	}
	public String getEtNo() {
		return etNo;
	}
	public void setEtNo(String etNo) {
		this.etNo = etNo;
	}
	public String getApplyMoney() {
		return applyMoney;
	}
	public void setApplyMoney(String applyMoney) {
		this.applyMoney = applyMoney;
	}
	public String getAirlineCompanyCode() {
		return airlineCompanyCode;
	}
	public void setAirlineCompanyCode(String airlineCompanyCode) {
		this.airlineCompanyCode = airlineCompanyCode;
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
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
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
	public String getRuleExlain() {
		return ruleExlain;
	}
	public void setRuleExlain(String ruleExlain) {
		this.ruleExlain = ruleExlain;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getInsuranceCode() {
		return insuranceCode;
	}
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}
	public String getInsuranceSts() {
		return insuranceSts;
	}
	public void setInsuranceSts(String insuranceSts) {
		this.insuranceSts = insuranceSts;
	}
	public String getInsuranceNum() {
		return insuranceNum;
	}
	public void setInsuranceNum(String insuranceNum) {
		this.insuranceNum = insuranceNum;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	
}
