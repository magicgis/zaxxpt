package com.hnatourism.club.flight.web.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FlightCancelVo {
	/**
	*改期单详细信息 add by quhailong
	*2011-11-23
	*/
	// PK
	private String id;
	// 订单号
	private String orderCode;
	// 退款申请单号
	private String applyNo;
	// 乘客ID
	private String passengerId;
	// 申请退款
	private BigDecimal applyMoney;
	// 实际退款
	private BigDecimal returnMoney;
	// 手续费率
	private BigDecimal returnRate;
	// 手续费
	private BigDecimal procedureFee;
	// 机建费
	private BigDecimal constructionFee;
	// 燃油费
	private BigDecimal baf;
	// 保险费
	private BigDecimal insurance;
	// 机油保费：机场建设费+燃油费+保险费
	private BigDecimal airOilInsurFee;
	// 附加费
	private BigDecimal annexrefundment;
	// 退票申请人电话
	private String applyUserTel;
	// 退票申请人Code
	private String applyUserCode;
	// 退票申请日期
	private Date applyDate;
	// 退票申请单创建人code
	private String createUserCode;
	// 退票类型
	private String returnType;
	// 一审核人CODE
	private String checkUserCode;
	// 一审核内容
	private String checkContent;
	// 一审核日期
	private Date checkDate;
	// 二审核人CODE
	private String checkUserCodeT;
	// 二审核内容
	private String checkContentT;
	// 二审核日期
	private Date checkDateT;
	// 退款单来源 0：ABE接口生成的订单；1：PGS接口生成的订单
	private String applyOrderType;
	// 退款单状态：1审核中，2待二审，3审核通过，4已退款，5审核拒绝
	private String state;
	// 备注
	private String disc;
	// 创建时间
	private Date createTime;
	// 创建人
	private String createUser;
	// 更新时间
	private Date updateTime;
	// 更新人
	private String updateUser;
	// 备用字段1
	private String filed1;
	// 备用字段2
	private String filed2;
	// 备用字段3
	private String filed3;
	// 备用字段4
	private String filed4;
	// 备用字段5
	private String filed5;
	
	private String source;
	//乘机人信息
	private List<MemberPassengerVo> flightPassenger;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public BigDecimal getApplyMoney() {
		return applyMoney;
	}

	public void setApplyMoney(BigDecimal applyMoney) {
		this.applyMoney = applyMoney;
	}

	public BigDecimal getReturnMoney() {
		return returnMoney;
	}

	public void setReturnMoney(BigDecimal returnMoney) {
		this.returnMoney = returnMoney;
	}

	public BigDecimal getReturnRate() {
		return returnRate;
	}

	public void setReturnRate(BigDecimal returnRate) {
		this.returnRate = returnRate;
	}

	public BigDecimal getProcedureFee() {
		return procedureFee;
	}

	public void setProcedureFee(BigDecimal procedureFee) {
		this.procedureFee = procedureFee;
	}

	public BigDecimal getConstructionFee() {
		return constructionFee;
	}

	public void setConstructionFee(BigDecimal constructionFee) {
		this.constructionFee = constructionFee;
	}

	public BigDecimal getBaf() {
		return baf;
	}

	public void setBaf(BigDecimal baf) {
		this.baf = baf;
	}

	public BigDecimal getInsurance() {
		return insurance;
	}

	public void setInsurance(BigDecimal insurance) {
		this.insurance = insurance;
	}

	public BigDecimal getAirOilInsurFee() {
		return airOilInsurFee;
	}

	public void setAirOilInsurFee(BigDecimal airOilInsurFee) {
		this.airOilInsurFee = airOilInsurFee;
	}

	public BigDecimal getAnnexrefundment() {
		return annexrefundment;
	}

	public void setAnnexrefundment(BigDecimal annexrefundment) {
		this.annexrefundment = annexrefundment;
	}

	public String getApplyUserTel() {
		return applyUserTel;
	}

	public void setApplyUserTel(String applyUserTel) {
		this.applyUserTel = applyUserTel;
	}

	public String getApplyUserCode() {
		return applyUserCode;
	}

	public void setApplyUserCode(String applyUserCode) {
		this.applyUserCode = applyUserCode;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getCheckUserCode() {
		return checkUserCode;
	}

	public void setCheckUserCode(String checkUserCode) {
		this.checkUserCode = checkUserCode;
	}

	public String getCheckContent() {
		return checkContent;
	}

	public void setCheckContent(String checkContent) {
		this.checkContent = checkContent;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckUserCodeT() {
		return checkUserCodeT;
	}

	public void setCheckUserCodeT(String checkUserCodeT) {
		this.checkUserCodeT = checkUserCodeT;
	}

	public String getCheckContentT() {
		return checkContentT;
	}

	public void setCheckContentT(String checkContentT) {
		this.checkContentT = checkContentT;
	}

	public Date getCheckDateT() {
		return checkDateT;
	}

	public void setCheckDateT(Date checkDateT) {
		this.checkDateT = checkDateT;
	}

	public String getApplyOrderType() {
		return applyOrderType;
	}

	public void setApplyOrderType(String applyOrderType) {
		this.applyOrderType = applyOrderType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getFiled1() {
		return filed1;
	}

	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}

	public String getFiled2() {
		return filed2;
	}

	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}

	public String getFiled3() {
		return filed3;
	}

	public void setFiled3(String filed3) {
		this.filed3 = filed3;
	}

	public String getFiled4() {
		return filed4;
	}

	public void setFiled4(String filed4) {
		this.filed4 = filed4;
	}

	public String getFiled5() {
		return filed5;
	}

	public void setFiled5(String filed5) {
		this.filed5 = filed5;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<MemberPassengerVo> getFlightPassenger() {
		return flightPassenger;
	}

	public void setFlightPassenger(List<MemberPassengerVo> flightPassenger) {
		this.flightPassenger = flightPassenger;
	}
}
