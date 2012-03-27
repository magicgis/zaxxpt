package com.hnatourism.club.flight.web.vo;

import java.math.BigDecimal;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:舱位信息
 * 
 * 历史版本: 2010-07-09 v1.0.0 (hna) 创建:
 * 
 */
public class FlightCabinInfoVo  extends AbstractVo{

	/**
	 * 政策编号
	 */
	private String policyCode;
	private String policyId;
	private String deposit;
	// 团ID
	private String groupId;	
	private String groupCode;	
	/**
	 * 变更信息（退改签）
	 */
	private String changeInfo;

	/**
	 * 舱位编码
	 */
	private String cabinCode;

	/**
	 * 舱位数
	 */
	private String cabinSeatNum;

	/**
	 * 舱级别
	 */
	private String cabinClass;

	/**
	 * 成人建设费
	 */
	private String adultConstructionFee;

	/**
	 * 成人燃油费
	 */
	private String adultBaf;

	/**
	 * 成人机票价=舱位价*折扣
	 */
	private String adultTicketPrice;
	//成人票面价
	private String adultTicketPricePar;

	/**
	 * 儿童机建费 为0
	 */
	private String childConstructionFee;

	/**
	 * 儿童燃油费
	 */
	private String childBaf;

	/**
	 * 如果有Y舱位，半价，否则与成人一致
	 */
	private String childTicketPrice;
	//儿童票面价
	private String childTicketPricePar;
	/**
	 * 婴儿机建费 0
	 */
	private String babyConstructionFee;

	/**
	 * 婴儿燃油费 0
	 */
	private String babyBaf;

	/**
	 * 0
	 */
	private String babyTicketPrice;
	
	// 折扣
	private BigDecimal discount;

	/**
	 * 是否特价卖 0非; 1特价
	 */
	private String isSale;
	//仓位中文名
	private String cabinName;
	//航空公司政策
	private String airCompanyPolicy;
	
	//佣金比率
	private String commissionRate;
	//来源
	private String flightOrgin;
	
	private String cabinDiscount;
	
	private FlightGWVo flightGWVo;


	public String getFlightOrgin() {
		return flightOrgin;
	}


	public void setFlightOrgin(String flightOrgin) {
		this.flightOrgin = flightOrgin;
	}


	public String getAirCompanyPolicy() {
		return airCompanyPolicy;
	}


	public void setAirCompanyPolicy(String airCompanyPolicy) {
		this.airCompanyPolicy = airCompanyPolicy;
	}

	/**
	 * 出票时限 分钟
	 */
	private String issuePeriod;

	public String getPolicyCode() {
		return policyCode;
	}

	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}

	public String getChangeInfo() {
		return changeInfo;
	}

	public void setChangeInfo(String changeInfo) {
		this.changeInfo = changeInfo;
	}

	public String getCabinCode() {
		return cabinCode;
	}

	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}

	public String getCabinSeatNum() {
		return cabinSeatNum;
	}

	public void setCabinSeatNum(String cabinSeatNum) {
		this.cabinSeatNum = cabinSeatNum;
	}

	public String getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}

	public String getAdultConstructionFee() {
		return adultConstructionFee;
	}

	public void setAdultConstructionFee(String adultConstructionFee) {
		this.adultConstructionFee = adultConstructionFee;
	}

	public String getAdultBaf() {
		return adultBaf;
	}

	public void setAdultBaf(String adultBaf) {
		this.adultBaf = adultBaf;
	}

	public String getAdultTicketPrice() {
		return adultTicketPrice;
	}

	public void setAdultTicketPrice(String adultTicketPrice) {
		this.adultTicketPrice = adultTicketPrice;
	}

	public String getChildConstructionFee() {
		return childConstructionFee;
	}

	public void setChildConstructionFee(String childConstructionFee) {
		this.childConstructionFee = childConstructionFee;
	}

	public String getChildBaf() {
		return childBaf;
	}

	public void setChildBaf(String childBaf) {
		this.childBaf = childBaf;
	}

	public String getChildTicketPrice() {
		return childTicketPrice;
	}

	public void setChildTicketPrice(String childTicketPrice) {
		this.childTicketPrice = childTicketPrice;
	}

	public String getBabyConstructionFee() {
		return babyConstructionFee;
	}

	public void setBabyConstructionFee(String babyConstructionFee) {
		this.babyConstructionFee = babyConstructionFee;
	}

	public String getBabyBaf() {
		return babyBaf;
	}

	public void setBabyBaf(String babyBaf) {
		this.babyBaf = babyBaf;
	}

	public String getBabyTicketPrice() {
		return babyTicketPrice;
	}

	public void setBabyTicketPrice(String babyTicketPrice) {
		this.babyTicketPrice = babyTicketPrice;
	}

	public String getIsSale() {
		return isSale;
	}

	public void setIsSale(String isSale) {
		this.isSale = isSale;
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

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}

	/**
	 * @param groupCode the groupCode to set
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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

	public String getCabinName() {
		return cabinName;
	}

	public void setCabinName(String cabinName) {
		this.cabinName = cabinName;
	}


	public String getCommissionRate() {
		return commissionRate;
	}


	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}

	public String getAdultTicketPricePar() {
		return adultTicketPricePar;
	}

	public void setAdultTicketPricePar(String adultTicketPricePar) {
		this.adultTicketPricePar = adultTicketPricePar;
	}


	public String getChildTicketPricePar() {
		return childTicketPricePar;
	}


	public void setChildTicketPricePar(String childTicketPricePar) {
		this.childTicketPricePar = childTicketPricePar;
	}


	public FlightGWVo getFlightGWVo() {
		return flightGWVo;
	}


	public void setFlightGWVo(FlightGWVo flightGWVo) {
		this.flightGWVo = flightGWVo;
	}


	public String getCabinDiscount() {
		return cabinDiscount;
	}


	public void setCabinDiscount(String cabinDiscount) {
		this.cabinDiscount = cabinDiscount;
	}
	
	

}
