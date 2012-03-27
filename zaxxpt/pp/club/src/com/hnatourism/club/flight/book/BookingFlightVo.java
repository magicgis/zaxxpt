package com.hnatourism.club.flight.book;

import java.math.BigDecimal;
import java.util.Date;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机票预订 航班信息
 * 
 * 历史版本: 2010-07-09 v1.0.0 (hna) 创建:
 * 
 */
public class BookingFlightVo extends AbstractVo {

	// =====================
	// 预定航班信息
	// =====================
	// 产品ID
	private String prodId;
	// 机票类型 0：普通票；1：团购票2:议价票
	private String ticketType;
	// 1 单程 2 返程 3 联程
	private String flightType;
	// 航班来源（B2C，B2B）
	private String flightOrigin;
	// 实际支付的钱>大于净结价
	private BigDecimal actualPay;
	// 票总价格 ：净结价=成本价扣除返点（相当于总佣金+总成本价）（用户看到的价，支付价）
	private BigDecimal totalTicketPrice;
	// 总机建费
	private BigDecimal totalConstructionFee;
	// 总燃油费
	private BigDecimal totalBaf;
	// 总价格=票总价格+总机建费+总燃油费
	private BigDecimal totalMoney;
	// 原总价格=原票总价格+总机建费+总燃油费
	private BigDecimal totalMoneyOld;
	// 婴儿数
	private Long babyNum;
	// 儿童数
	private Long childNum;
	// 成人数
	private Long adultNum;
	// 总人数（票数）
	private Long personNum;
	// 支付方式
	private String payType;
	// 支付日期
	private String payTime;
	// 备注
	private String rmk;
	// 团购ID
	private String bookingGroupId;
	// 航班ID
	private String bookingFlightId;
	// 订单编号
	private String orderCode;
	// 订单类型0：订单 1：改签单 2议价单
	private String orderType;
	// 订单ID
	private String orderId;
	// 复合订单ID
	private String orderCombinationId;
	// 航班预定PNR
	private String pnr;
	//退改签
	private String cabinRule;
	//到达时间，例如1540
	private String arrTime;
	//Y舱价格
	private String cabinYPrice;
	//是否支持电子票
	private String eTicket;
	//最低仓位code
	private String lowestCabinCode;
	//最低仓位对应的价格
	private String lowestPrice;
	//最低仓位对应的座位数
	private String lowestSeatNum;
	//可申请价格
	private String applyCabinPrice;
	//是否有餐食
	private String meal;
	// 配置信息
	private String hasConfig;
	// 折扣
	private BigDecimal discount;
	// 舱位折扣
	private String cabinDiscount;
	// 是否特价卖
	private String isSale;

	// =====================
	// 航班基本信息
	// =====================
	// 航班类型 0,普通，1议价 2团购
	private String prodType;
	// 航空公司图片地址
	private String airlineCompanyImg;
	// 航空公司名称
	private String airlineCompany;
	// 航空公司code
	private String airlineCompanyCode;
	// 航班号
	private String flightNo;
	// 机型
	private String aircraftType;
	// 起飞日期
	private Date departureDate;
	// 到达日期
	private Date arrivalDate;
	// 起飞日期
	private String departureDateStr;
	// 到达日期
	private String arrivalDateStr;
	// 起飞日期
	private String departureTimeStr;
	// 到达日期
	private String arrivalTimeStr;
	// 出发机场
	private String departureAirport;
	// 出发机场code
	private String departureAirportCode;
	// 出发城市
	private String departureCity;
	// 到达机场
	private String arrivalAirport;
	// 到达机场code
	private String arrivalAirportCode;
	// 到达城市
	private String arrivalCity;
	// 出发机场航站
	private String departureTerminal;
	// 到达机场航站
	private String arrivalTerminal;
	// 历时
	private String spendTime;
	// 政策编号
	private String policyCode;
	// 变更信息（退改签）
	private String changeInfo;
	// 舱位编码
	private String cabinCode;
	// 舱位数
	private String cabinSeatNum;
	// 舱级别
	private String cabinClass;
	// 成人建设费
	private BigDecimal adultConstructionFee;
	// 成人燃油费
	private BigDecimal adultBaf;
	// pat前的舱位价格 
	private BigDecimal cabinPriceOld;
	// pat后的舱位价格 
	private BigDecimal cabinPrice;
	// 成人机票价=舱位价*折扣
	private BigDecimal ticketPrice;
	private BigDecimal adultTicketPrice;
	// pat前的价格
	private BigDecimal adultTicketPriceOld;
	// 儿童机建费 为0
	private BigDecimal childConstructionFee;
	// 儿童燃油费
	private BigDecimal childBaf;
	// 如果有Y舱位，半价，否则与成人一致
	private BigDecimal childTicketPrice;
	// pat前的价格
	private BigDecimal childTicketPriceOld;
	// 婴儿机建费 0
	private BigDecimal babyConstructionFee;
	// 婴儿燃油费 0
	private BigDecimal babyBaf;
	// 0 婴儿票价
	private BigDecimal babyTicketPrice;
	//出票时限
	private String issuePeriod;
	//出票失败次数
	private String ticketFailTime;
	// pnr有效期
	private Date pnrValidity;
	// 取消PNR 同时记录取消时间，取消人，取消状态，PNR配置。是否被取消的标识符 wwl add 2010-10-18
	//PNR取消时间
	private Date pnrCancleDate;
	//PNR取消人
	private String pnrCancleUser;
	//是否被取消的标识符1取消
	private String pnrCancleSts;
	//航班序号
	private String flightSeq;
	//pnr配置
	private String pnrConfig;
	//来源
	private String source;
	//p编码
	private String pCode;
	//联合销售标识符
	private String flag;
	//成人票面价
	private String adultTicketPricePar;
	//儿童票面价
	private String childTicketPricePar;
	//总返点
	private String totalCommissionRate;
	public String getTotalCommissionRate() {
		return totalCommissionRate;
	}
	public void setTotalCommissionRate(String totalCommissionRate) {
		this.totalCommissionRate = totalCommissionRate;
	}
	public String getChildTicketPricePar() {
		return childTicketPricePar;
	}
	public void setChildTicketPricePar(String childTicketPricePar) {
		this.childTicketPricePar = childTicketPricePar;
	}
	public String getAdultTicketPricePar() {
		return adultTicketPricePar;
	}
	public void setAdultTicketPricePar(String adultTicketPricePar) {
		this.adultTicketPricePar = adultTicketPricePar;
	}
	public Date getPnrValidity() {
		return pnrValidity;
	}
	public void setPnrValidity(Date pnrValidity) {
		this.pnrValidity = pnrValidity;
	}
	/**
	 * @return the prodId
	 */
	public String getProdId() {
		return prodId;
	}
	/**
	 * @param prodId the prodId to set
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	/**
	 * @return the ticketType
	 */
	public String getTicketType() {
		return ticketType;
	}
	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
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
	 * @return the flightOrigin
	 */
	public String getFlightOrigin() {
		return flightOrigin;
	}
	/**
	 * @param flightOrigin the flightOrigin to set
	 */
	public void setFlightOrigin(String flightOrigin) {
		this.flightOrigin = flightOrigin;
	}
	/**
	 * @return the actualPay
	 */
	public BigDecimal getActualPay() {
		return actualPay;
	}
	/**
	 * @param actualPay the actualPay to set
	 */
	public void setActualPay(BigDecimal actualPay) {
		this.actualPay = actualPay;
	}
	/**
	 * @return the totalTicketPrice
	 */
	public BigDecimal getTotalTicketPrice() {
		return totalTicketPrice;
	}
	/**
	 * @param totalTicketPrice the totalTicketPrice to set
	 */
	public void setTotalTicketPrice(BigDecimal totalTicketPrice) {
		this.totalTicketPrice = totalTicketPrice;
	}
	/**
	 * @return the totalConstructionFee
	 */
	public BigDecimal getTotalConstructionFee() {
		return totalConstructionFee;
	}
	/**
	 * @param totalConstructionFee the totalConstructionFee to set
	 */
	public void setTotalConstructionFee(BigDecimal totalConstructionFee) {
		this.totalConstructionFee = totalConstructionFee;
	}
	/**
	 * @return the totalBaf
	 */
	public BigDecimal getTotalBaf() {
		return totalBaf;
	}
	/**
	 * @param totalBaf the totalBaf to set
	 */
	public void setTotalBaf(BigDecimal totalBaf) {
		this.totalBaf = totalBaf;
	}
	/**
	 * @return the totalMoney
	 */
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	/**
	 * @param totalMoney the totalMoney to set
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	/**
	 * @return the babyNum
	 */
	public Long getBabyNum() {
		return babyNum;
	}
	/**
	 * @param babyNum the babyNum to set
	 */
	public void setBabyNum(Long babyNum) {
		this.babyNum = babyNum;
	}
	/**
	 * @return the childNum
	 */
	public Long getChildNum() {
		return childNum;
	}
	/**
	 * @param childNum the childNum to set
	 */
	public void setChildNum(Long childNum) {
		this.childNum = childNum;
	}
	/**
	 * @return the adultNum
	 */
	public Long getAdultNum() {
		return adultNum;
	}
	/**
	 * @param adultNum the adultNum to set
	 */
	public void setAdultNum(Long adultNum) {
		this.adultNum = adultNum;
	}
	/**
	 * @return the personNum
	 */
	public Long getPersonNum() {
		return personNum;
	}
	/**
	 * @param personNum the personNum to set
	 */
	public void setPersonNum(Long personNum) {
		this.personNum = personNum;
	}
	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * @return the payTime
	 */
	public String getPayTime() {
		return payTime;
	}
	/**
	 * @param payTime the payTime to set
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * @return the bookingGroupId
	 */
	public String getBookingGroupId() {
		return bookingGroupId;
	}
	/**
	 * @param bookingGroupId the bookingGroupId to set
	 */
	public void setBookingGroupId(String bookingGroupId) {
		this.bookingGroupId = bookingGroupId;
	}
	/**
	 * @return the bookingFlightId
	 */
	public String getBookingFlightId() {
		return bookingFlightId;
	}
	/**
	 * @param bookingFlightId the bookingFlightId to set
	 */
	public void setBookingFlightId(String bookingFlightId) {
		this.bookingFlightId = bookingFlightId;
	}
	/**
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}
	/**
	 * @param orderCode the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderCombinationId
	 */
	public String getOrderCombinationId() {
		return orderCombinationId;
	}
	/**
	 * @param orderCombinationId the orderCombinationId to set
	 */
	public void setOrderCombinationId(String orderCombinationId) {
		this.orderCombinationId = orderCombinationId;
	}
	/**
	 * @return the pnr
	 */
	public String getPnr() {
		return pnr;
	}
	/**
	 * @param pnr the pnr to set
	 */
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	/**
	 * @return the hasConfig
	 */
	public String getHasConfig() {
		return hasConfig;
	}
	/**
	 * @param hasConfig the hasConfig to set
	 */
	public void setHasConfig(String hasConfig) {
		this.hasConfig = hasConfig;
	}
	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	/**
	 * @return the isSale
	 */
	public String getIsSale() {
		return isSale;
	}
	/**
	 * @param isSale the isSale to set
	 */
	public void setIsSale(String isSale) {
		this.isSale = isSale;
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
	 * @return the airlineCompanyImg
	 */
	public String getAirlineCompanyImg() {
		return airlineCompanyImg;
	}
	/**
	 * @param airlineCompanyImg the airlineCompanyImg to set
	 */
	public void setAirlineCompanyImg(String airlineCompanyImg) {
		this.airlineCompanyImg = airlineCompanyImg;
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
	 * @return the airlineCompanyCode
	 */
	public String getAirlineCompanyCode() {
		return airlineCompanyCode;
	}
	/**
	 * @param airlineCompanyCode the airlineCompanyCode to set
	 */
	public void setAirlineCompanyCode(String airlineCompanyCode) {
		this.airlineCompanyCode = airlineCompanyCode;
	}
	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}
	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
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
	 * @return the departureTerminal
	 */
	public String getDepartureTerminal() {
		return departureTerminal;
	}
	/**
	 * @param departureTerminal the departureTerminal to set
	 */
	public void setDepartureTerminal(String departureTerminal) {
		this.departureTerminal = departureTerminal;
	}
	/**
	 * @return the arrivalTerminal
	 */
	public String getArrivalTerminal() {
		return arrivalTerminal;
	}
	/**
	 * @param arrivalTerminal the arrivalTerminal to set
	 */
	public void setArrivalTerminal(String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}
	/**
	 * @return the spendTime
	 */
	public String getSpendTime() {
		return spendTime;
	}
	/**
	 * @param spendTime the spendTime to set
	 */
	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}
	/**
	 * @return the policyCode
	 */
	public String getPolicyCode() {
		return policyCode;
	}
	/**
	 * @param policyCode the policyCode to set
	 */
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	/**
	 * @return the changeInfo
	 */
	public String getChangeInfo() {
		return changeInfo;
	}
	/**
	 * @param changeInfo the changeInfo to set
	 */
	public void setChangeInfo(String changeInfo) {
		this.changeInfo = changeInfo;
	}
	/**
	 * @return the cabinCode
	 */
	public String getCabinCode() {
		return cabinCode;
	}
	/**
	 * @param cabinCode the cabinCode to set
	 */
	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}
	/**
	 * @return the cabinSeatNum
	 */
	public String getCabinSeatNum() {
		return cabinSeatNum;
	}
	/**
	 * @param cabinSeatNum the cabinSeatNum to set
	 */
	public void setCabinSeatNum(String cabinSeatNum) {
		this.cabinSeatNum = cabinSeatNum;
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
	 * @return the adultConstructionFee
	 */
	public BigDecimal getAdultConstructionFee() {
		return adultConstructionFee;
	}
	/**
	 * @param adultConstructionFee the adultConstructionFee to set
	 */
	public void setAdultConstructionFee(BigDecimal adultConstructionFee) {
		this.adultConstructionFee = adultConstructionFee;
	}
	/**
	 * @return the adultBaf
	 */
	public BigDecimal getAdultBaf() {
		return adultBaf;
	}
	/**
	 * @param adultBaf the adultBaf to set
	 */
	public void setAdultBaf(BigDecimal adultBaf) {
		this.adultBaf = adultBaf;
	}
	/**
	 * @return the adultTicketPrice
	 */
	public BigDecimal getAdultTicketPrice() {
		return adultTicketPrice;
	}
	/**
	 * @param adultTicketPrice the adultTicketPrice to set
	 */
	public void setAdultTicketPrice(BigDecimal adultTicketPrice) {
		this.adultTicketPrice = adultTicketPrice;
	}
	/**
	 * @return the childConstructionFee
	 */
	public BigDecimal getChildConstructionFee() {
		return childConstructionFee;
	}
	/**
	 * @param childConstructionFee the childConstructionFee to set
	 */
	public void setChildConstructionFee(BigDecimal childConstructionFee) {
		this.childConstructionFee = childConstructionFee;
	}
	/**
	 * @return the childBaf
	 */
	public BigDecimal getChildBaf() {
		return childBaf;
	}
	/**
	 * @param childBaf the childBaf to set
	 */
	public void setChildBaf(BigDecimal childBaf) {
		this.childBaf = childBaf;
	}
	/**
	 * @return the childTicketPrice
	 */
	public BigDecimal getChildTicketPrice() {
		return childTicketPrice;
	}
	/**
	 * @param childTicketPrice the childTicketPrice to set
	 */
	public void setChildTicketPrice(BigDecimal childTicketPrice) {
		this.childTicketPrice = childTicketPrice;
	}
	/**
	 * @return the babyConstructionFee
	 */
	public BigDecimal getBabyConstructionFee() {
		return babyConstructionFee;
	}
	/**
	 * @param babyConstructionFee the babyConstructionFee to set
	 */
	public void setBabyConstructionFee(BigDecimal babyConstructionFee) {
		this.babyConstructionFee = babyConstructionFee;
	}
	/**
	 * @return the babyBaf
	 */
	public BigDecimal getBabyBaf() {
		return babyBaf;
	}
	/**
	 * @param babyBaf the babyBaf to set
	 */
	public void setBabyBaf(BigDecimal babyBaf) {
		this.babyBaf = babyBaf;
	}
	/**
	 * @return the babyTicketPrice
	 */
	public BigDecimal getBabyTicketPrice() {
		return babyTicketPrice;
	}
	/**
	 * @param babyTicketPrice the babyTicketPrice to set
	 */
	public void setBabyTicketPrice(BigDecimal babyTicketPrice) {
		this.babyTicketPrice = babyTicketPrice;
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
	 * @return the issuePeriod
	 */
	public String getIssuePeriod() {
		return issuePeriod;
	}
	/**
	 * @param issuePeriod the issuePeriod to set
	 */
	public void setIssuePeriod(String issuePeriod) {
		this.issuePeriod = issuePeriod;
	}
	public String getTicketFailTime() {
		return ticketFailTime;
	}
	public void setTicketFailTime(String ticketFailTime) {
		this.ticketFailTime = ticketFailTime;
	}
	/**
	 * @return the pnrCancleDate
	 */
	public Date getPnrCancleDate() {
		return pnrCancleDate;
	}
	/**
	 * @param pnrCancleDate the pnrCancleDate to set
	 */
	public void setPnrCancleDate(Date pnrCancleDate) {
		this.pnrCancleDate = pnrCancleDate;
	}
	/**
	 * @return the pnrCancleUser
	 */
	public String getPnrCancleUser() {
		return pnrCancleUser;
	}
	/**
	 * @param pnrCancleUser the pnrCancleUser to set
	 */
	public void setPnrCancleUser(String pnrCancleUser) {
		this.pnrCancleUser = pnrCancleUser;
	}
	/**
	 * @return the pnrCancleSts
	 */
	public String getPnrCancleSts() {
		return pnrCancleSts;
	}
	/**
	 * @param pnrCancleSts the pnrCancleSts to set
	 */
	public void setPnrCancleSts(String pnrCancleSts) {
		this.pnrCancleSts = pnrCancleSts;
	}
	/**
	 * @return the pnrConfig
	 */
	public String getPnrConfig() {
		return pnrConfig;
	}
	/**
	 * @param pnrConfig the pnrConfig to set
	 */
	public void setPnrConfig(String pnrConfig) {
		this.pnrConfig = pnrConfig;
	}
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getDepartureTimeStr() {
		return departureTimeStr;
	}
	public void setDepartureTimeStr(String departureTimeStr) {
		this.departureTimeStr = departureTimeStr;
	}
	public String getArrivalTimeStr() {
		return arrivalTimeStr;
	}
	public void setArrivalTimeStr(String arrivalTimeStr) {
		this.arrivalTimeStr = arrivalTimeStr;
	}
	public String getDepartureDateStr() {
		return departureDateStr;
	}
	public void setDepartureDateStr(String departureDateStr) {
		this.departureDateStr = departureDateStr;
	}
	public String getArrivalDateStr() {
		return arrivalDateStr;
	}
	public void setArrivalDateStr(String arrivalDateStr) {
		this.arrivalDateStr = arrivalDateStr;
	}
	/**
	 * @return the adultTicketPriceOld
	 */
	public BigDecimal getAdultTicketPriceOld() {
		return adultTicketPriceOld;
	}
	/**
	 * @param adultTicketPriceOld the adultTicketPriceOld to set
	 */
	public void setAdultTicketPriceOld(BigDecimal adultTicketPriceOld) {
		this.adultTicketPriceOld = adultTicketPriceOld;
	}
	/**
	 * @return the childTicketPriceOld
	 */
	public BigDecimal getChildTicketPriceOld() {
		return childTicketPriceOld;
	}
	/**
	 * @param childTicketPriceOld the childTicketPriceOld to set
	 */
	public void setChildTicketPriceOld(BigDecimal childTicketPriceOld) {
		this.childTicketPriceOld = childTicketPriceOld;
	}
	public BigDecimal getCabinPriceOld() {
		return cabinPriceOld;
	}
	public void setCabinPriceOld(BigDecimal cabinPriceOld) {
		this.cabinPriceOld = cabinPriceOld;
	}
	public BigDecimal getCabinPrice() {
		return cabinPrice;
	}
	public void setCabinPrice(BigDecimal cabinPrice) {
		this.cabinPrice = cabinPrice;
	}
	/**
	 * @return the totalMoneyOld
	 */
	public BigDecimal getTotalMoneyOld() {
		return totalMoneyOld;
	}
	/**
	 * @param totalMoneyOld the totalMoneyOld to set
	 */
	public void setTotalMoneyOld(BigDecimal totalMoneyOld) {
		this.totalMoneyOld = totalMoneyOld;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getFlightSeq() {
		return flightSeq;
	}
	public void setFlightSeq(String flightSeq) {
		this.flightSeq = flightSeq;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCabinRule() {
		return cabinRule;
	}
	public void setCabinRule(String cabinRule) {
		this.cabinRule = cabinRule;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public String getCabinYPrice() {
		return cabinYPrice;
	}
	public void setCabinYPrice(String cabinYPrice) {
		this.cabinYPrice = cabinYPrice;
	}
	public String getETicket() {
		return eTicket;
	}
	public void setETicket(String ticket) {
		eTicket = ticket;
	}
	public String getLowestCabinCode() {
		return lowestCabinCode;
	}
	public void setLowestCabinCode(String lowestCabinCode) {
		this.lowestCabinCode = lowestCabinCode;
	}
	public String getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(String lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public String getLowestSeatNum() {
		return lowestSeatNum;
	}
	public void setLowestSeatNum(String lowestSeatNum) {
		this.lowestSeatNum = lowestSeatNum;
	}
	public String getApplyCabinPrice() {
		return applyCabinPrice;
	}
	public void setApplyCabinPrice(String applyCabinPrice) {
		this.applyCabinPrice = applyCabinPrice;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getPCode() {
		return pCode;
	}
	public void setPCode(String code) {
		pCode = code;
	}
	public String getCabinDiscount() {
		return cabinDiscount;
	}
	public void setCabinDiscount(String cabinDiscount) {
		this.cabinDiscount = cabinDiscount;
	}

	
}
