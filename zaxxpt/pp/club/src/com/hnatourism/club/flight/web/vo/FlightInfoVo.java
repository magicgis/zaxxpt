package com.hnatourism.club.flight.web.vo;

import java.util.List;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机票舱位信息
 * 
 * 历史版本: 2010-07-09 v1.0.0 (hna) 创建:
 * 
 */
public class FlightInfoVo  extends AbstractVo{

	private String tripDate;//旅行日期（去程出发时间或返程出发时间）yyyy-mm-dd
	private String airlineCompanyImg;	//航空公司图片地址
	private String airlineCompany;	// 航空公司名称
	private String airlineCompanyCode;//航空公司code 
	private String flightNo;	// 航班号
	private String aircraftType;	//机型 
	private String aircraftName;	//机型名 
	private String departureTime;	//起飞时间hh-mi
	private String arrivalDate;	//到达日期
	private String arrivalTime;	//到达时间hh-mi
	private String departureCity;	//出发城市code
	private String departureAirport;	//出发机场
	private String departureAirportCode;	//出发机场code
	private String arrivalCity;	//到达城市code
	private String arrivalAirport;	//到达机场	 
	private String arrivalAirportCode;	//到达机场code	
	private String departureTerminal;	// 出发机场航站 
	private String arrivalTerminal;	//到达机场航站
	private String isBargaining;	//是否可议价
	private String groupBookingSts;	//团购状态
	private String prodType;		//航班类型 0,普通，1议价 2团购
	private String ticketPrice;	// 票价
	private String departureDayWeek;	// 星期
	private String flightId;	//中转航班对应序号
	private String elementNo;	//航信系统(1E)对应的显示序号 
	private String eticket;	//电子票标识
	private String meal;	//餐食代码 
	private String viapoint;	//经停点
	private String asr;	//中转标志
	private String linkLevel;	//连接级别
	private String mileage;	// 里程数
	private String usableClasses;	//可用舱位
	private String constructionFee;	// 机建费
	private String adultBaf;	//成人燃油费
	private String childBaf;//儿童燃油费
	private String yprice;	// Y舱价格
	private String spendTime;	//历时 
	private String cabinName;//仓位名称
	private String arrivalDateStr;//到达日期
	private String departureDateStr;//出发日期
	private String arrivalTimeStr;//到达时间
	private String departureTimeStr;//出发时间
	private String disCount;//折扣
	//推荐最便宜舱位信息
	private FlightCabinInfoVo flightCabinInfoVo;	
	 
	//可用舱位信息
	private List<FlightCabinInfoVo> flightCabinInfoVoList;
	
	// 联程的航班信息
	private FlightInfoVo flightInfoConnect;
	
	//航空公司政策
	private boolean isAirCompanyPolicy;

	public String getAirlineCompanyImg() {
		return airlineCompanyImg;
	}
	

	public void setAirlineCompanyImg(String airlineCompanyImg) {
		this.airlineCompanyImg = airlineCompanyImg;
	}

	public String getAirlineCompany() {
		return airlineCompany;
	}

	public void setAirlineCompany(String airlineCompany) {
		this.airlineCompany = airlineCompany;
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

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
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

	public String getDepartureTerminal() {
		return departureTerminal;
	}

	public void setDepartureTerminal(String departureTerminal) {
		this.departureTerminal = departureTerminal;
	}

	public String getArrivalTerminal() {
		return arrivalTerminal;
	}

	public void setArrivalTerminal(String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}

	public String getIsBargaining() {
		return isBargaining;
	}

	public void setIsBargaining(String isBargaining) {
		this.isBargaining = isBargaining;
	}

	public String getGroupBookingSts() {
		return groupBookingSts;
	}

	public void setGroupBookingSts(String groupBookingSts) {
		this.groupBookingSts = groupBookingSts;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getDepartureDayWeek() {
		return departureDayWeek;
	}

	public void setDepartureDayWeek(String departureDayWeek) {
		this.departureDayWeek = departureDayWeek;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getElementNo() {
		return elementNo;
	}

	public void setElementNo(String elementNo) {
		this.elementNo = elementNo;
	}

	public String getEticket() {
		return eticket;
	}

	public void setEticket(String eticket) {
		this.eticket = eticket;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getViapoint() {
		return viapoint;
	}

	public void setViapoint(String viapoint) {
		this.viapoint = viapoint;
	}

	public String getAsr() {
		return asr;
	}

	public void setAsr(String asr) {
		this.asr = asr;
	}

	public String getLinkLevel() {
		return linkLevel;
	}

	public void setLinkLevel(String linkLevel) {
		this.linkLevel = linkLevel;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getUsableClasses() {
		return usableClasses;
	}

	public void setUsableClasses(String usableClasses) {
		this.usableClasses = usableClasses;
	}

	public String getConstructionFee() {
		return constructionFee;
	}

	public void setConstructionFee(String constructionFee) {
		this.constructionFee = constructionFee;
	}

	public String getAdultBaf() {
		return adultBaf;
	}

	public void setAdultBaf(String adultBaf) {
		this.adultBaf = adultBaf;
	}

	public String getChildBaf() {
		return childBaf;
	}

	public void setChildBaf(String childBaf) {
		this.childBaf = childBaf;
	}

	public String getYprice() {
		return yprice;
	}

	public void setYprice(String yprice) {
		this.yprice = yprice;
	}

	public String getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}

	public FlightCabinInfoVo getFlightCabinInfoVo() {
		return flightCabinInfoVo;
	}

	public void setFlightCabinInfoVo(FlightCabinInfoVo flightCabinInfoVo) {
		this.flightCabinInfoVo = flightCabinInfoVo;
	}

	/**
	 * @return the flightCabinInfoVoList
	 */
	public List<FlightCabinInfoVo> getFlightCabinInfoVoList() {
		return flightCabinInfoVoList;
	}

	/**
	 * @param flightCabinInfoVoList the flightCabinInfoVoList to set
	 */
	public void setFlightCabinInfoVoList(
			List<FlightCabinInfoVo> flightCabinInfoVoList) {
		this.flightCabinInfoVoList = flightCabinInfoVoList;
	}

	/**
	 * @return the departureAirportCode
	 */
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	/**
	 * @param departureAirportCode the departureAirportCode to set
	 */
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	/**
	 * @return the arrivalAirportCode
	 */
	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	/**
	 * @param arrivalAirportCode the arrivalAirportCode to set
	 */
	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	/**
	 * @return the tripDate
	 */
	public String getTripDate() {
		return tripDate;
	}

	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the prodType
	 */
	public String getProdType() {
		return prodType;
	}

	/**
	 * @param prodType the prodType to set
	 */
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	/**
	 * @return the departureCity
	 */
	public String getDepartureCity() {
		return departureCity;
	}

	/**
	 * @param departureCity the departureCity to set
	 */
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	/**
	 * @return the arrivalCity
	 */
	public String getArrivalCity() {
		return arrivalCity;
	}

	/**
	 * @param arrivalCity the arrivalCity to set
	 */
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	/**
	 * @return the aircraftName
	 */
	public String getAircraftName() {
		return aircraftName;
	}

	/**
	 * @param aircraftName the aircraftName to set
	 */
	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}

	/**
	 * @return the flightInfoConnect
	 */
	public FlightInfoVo getFlightInfoConnect() {
		return flightInfoConnect;
	}

	/**
	 * @param flightInfoConnect the flightInfoConnect to set
	 */
	public void setFlightInfoConnect(FlightInfoVo flightInfoConnect) {
		this.flightInfoConnect = flightInfoConnect;
	}

	public String getCabinName() {
		return cabinName;
	}

	public void setCabinName(String cabinName) {
		this.cabinName = cabinName;
	}


	public boolean getIsAirCompanyPolicy() {
		return isAirCompanyPolicy;
	}


	public void setIsAirCompanyPolicy(boolean isAirCompanyPolicy) {
		this.isAirCompanyPolicy = isAirCompanyPolicy;
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


	public String getDepartureTimeStr() {
		return departureTimeStr;
	}


	public void setDepartureTimeStr(String departureTimeStr) {
		this.departureTimeStr = departureTimeStr;
	}


	public String getDepartureDateStr() {
		return departureDateStr;
	}


	public void setDepartureDateStr(String departureDateStr) {
		this.departureDateStr = departureDateStr;
	}


	public String getDisCount() {
		return disCount;
	}


	public void setDisCount(String disCount) {
		this.disCount = disCount;
	}

 
}