package com.hnatourism.club.flight.web.vo;

import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机票查询信息
 * 
 * 历史版本: 2010-07-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class FlightQryVo extends AbstractVo {

	// 航程区域类型:0：国内，1：国际
	private String flightAreaType;
	// 航程类型 1 单程 2 返程
	private String flightType;
	// 政策类型:空为全部 1普通政策2.特殊政策 3 联程政策
	private String policyType;
	// 产品类型:空为全部 0,普通，1议价 2团购
	private String prodType;
	// 出发日期
	private String departureDate;
	// 出发城市
	private String departureCity;
	// 到达城市
	private String arrivalCity;
	// 返程时间
	private String returnDate;
	// 航空公司名称
	private String airlineCompany;
	// 机型
	private String aircraftType;
	// 起飞时间
	private String departureTime;
	private String goArrivalTime;
	// 到达时间
	private String arrivalTime;
	// 出发机场
	private String departureAirport;
	// 到达机场
	private String arrivalAirport;
	// 票价
	private String ticketPrice;
	// 查询周期类型：天，周，月
	private String periodType;
	// 舱位级别
	private String cabinClass;
	// 备选项Option
	private String option;
	// 航线类型D:直飞 S:经停.联程 A:所有（默认）
	private String stopType;
	// 查询结果返回数量
	private int returnNum;
	// 查询标记 price查询票价 flight查询航班 modify 改签(同航空公司 平舱或升舱 ) byCity 按城市查询
	private String qryFlag;
	// 查询状态 U 待更新 S 已更新  L 只查本地
	private String qrySts;
	// 航班接口连接配置：filght_config
	private String configFlag;
	// 航班接口连接配置名
	private String configName;
	// 是否获取最便宜
	private String isCheapest;
	// 渠道来源（如：B2B，ABE，KKKK，PID）
	private String channelType;
	//航班号
	private String flightNo;
	//舱位编码
	private String cabinCode;
	//折扣
	private String discount;
	//时间类型 筛选
	private String dateType;
	//改期仓位类型
	private String mCabinCode;
	//指令类型，从Bsp*Helper中获取指令
	private String commandType;
	//配置类型"C":代理人"B"：航空公司
	private String configType;
	//票号
	private String tiketNo;
	private PageInfo pageInfo;
	private boolean isAddZero;
	//是否直销
	private boolean saleDirect;
	//1:航班查询 2:舱位验证
	private String searchFor ;
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public String getConfigType() {
		return configType;
	}

	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
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

	/**
	 * @return the flightAreaType
	 */
	public String getFlightAreaType() {
		return flightAreaType;
	}

	/**
	 * @param flightAreaType the flightAreaType to set
	 */
	public void setFlightAreaType(String flightAreaType) {
		this.flightAreaType = flightAreaType;
	}

	/**
	 * @return the flightType
	 */
	public String getFlightType() {
		return flightType;
	}

	/**
	 * @param flightType the flightType to set
	 */
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	/**
	 * @return the policyType
	 */
	public String getPolicyType() {
		return policyType;
	}

	/**
	 * @param policyType the policyType to set
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
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
	 * @return the departureDate
	 */
	public String getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
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
	 * @return the returnDate
	 */
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the airlineCompany
	 */
	public String getAirlineCompany() {
		return airlineCompany;
	}

	/**
	 * @param airlineCompany the airlineCompany to set
	 */
	public void setAirlineCompany(String airlineCompany) {
		this.airlineCompany = airlineCompany;
	}

	/**
	 * @return the aircraftType
	 */
	public String getAircraftType() {
		return aircraftType;
	}

	/**
	 * @param aircraftType the aircraftType to set
	 */
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
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

	public String getGoArrivalTime() {
		return goArrivalTime;
	}

	public void setGoArrivalTime(String goArrivalTime) {
		this.goArrivalTime = goArrivalTime;
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
	 * @return the departureAirport
	 */
	public String getDepartureAirport() {
		return departureAirport;
	}

	/**
	 * @param departureAirport the departureAirport to set
	 */
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	/**
	 * @return the arrivalAirport
	 */
	public String getArrivalAirport() {
		return arrivalAirport;
	}

	/**
	 * @param arrivalAirport the arrivalAirport to set
	 */
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	/**
	 * @return the ticketPrice
	 */
	public String getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * @param ticketPrice the ticketPrice to set
	 */
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	/**
	 * @return the periodType
	 */
	public String getPeriodType() {
		return periodType;
	}

	/**
	 * @param periodType the periodType to set
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	/**
	 * @return the cabinClass
	 */
	public String getCabinClass() {
		return cabinClass;
	}

	/**
	 * @param cabinClass the cabinClass to set
	 */
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * @return the stopType
	 */
	public String getStopType() {
		return stopType;
	}

	/**
	 * @param stopType the stopType to set
	 */
	public void setStopType(String stopType) {
		this.stopType = stopType;
	}

	/**
	 * @return the returnNum
	 */
	public int getReturnNum() {
		return returnNum;
	}

	/**
	 * @param returnNum the returnNum to set
	 */
	public void setReturnNum(int returnNum) {
		this.returnNum = returnNum;
	}

	/**
	 * @return the qryFlag
	 */
	public String getQryFlag() {
		return qryFlag;
	}

	/**
	 * @param qryFlag the qryFlag to set
	 */
	public void setQryFlag(String qryFlag) {
		this.qryFlag = qryFlag;
	}

	/**
	 * @return the configFlag
	 */
	public String getConfigFlag() {
		return configFlag;
	}

	/**
	 * @param configFlag the configFlag to set
	 */
	public void setConfigFlag(String configFlag) {
		this.configFlag = configFlag;
	}

	/**
	 * @return the isCheapest
	 */
	public String getIsCheapest() {
		return isCheapest;
	}

	/**
	 * @param isCheapest the isCheapest to set
	 */
	public void setIsCheapest(String isCheapest) {
		this.isCheapest = isCheapest;
	}

	/**
	 * @return the channelType
	 */
	public String getChannelType() {
		return channelType;
	}

	/**
	 * @param channelType the channelType to set
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	/**
	 * @return the qrySts
	 */
	public String getQrySts() {
		return qrySts;
	}

	/**
	 * @param qrySts the qrySts to set
	 */
	public void setQrySts(String qrySts) {
		this.qrySts = qrySts;
	}

	/**
	 * @return the configName
	 */
	public String getConfigName() {
		return configName;
	}

	/**
	 * @param configName the configName to set
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public boolean getIsAddZero() {
		return isAddZero;
	}

	public void setIsAddZero(boolean isAddZero) {
		this.isAddZero = isAddZero;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getMCabinCode() {
		return mCabinCode;
	}

	public void setMCabinCode(String cabinCode) {
		mCabinCode = cabinCode;
	}

	public String getTiketNo() {
		return tiketNo;
	}

	public void setTiketNo(String tiketNo) {
		this.tiketNo = tiketNo;
	}

	public boolean getIsSaleDirect() {
		return saleDirect;
	}

	public void setSaleDirect(boolean saleDirect) {
		this.saleDirect = saleDirect;
	}

	public String getSearchFor() {
		return searchFor;
	}

	public void setSearchFor(String searchFor) {
		this.searchFor = searchFor;
	}
	
	

}
