package com.hnatourism.club.flight.web.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FlightModifyVo {
	/**
	*乘机人改期单详细信息 add by quhailong
	*2011-11-23
	*/
	//PK
	private String id ;
	//订单号
	private String orderCode ;
	//航班Id
	private String bookingFlightId ;
	//乘客ID
	private String passengerId ;
	//改签申请单号
	private String applyNo ;
	//改签申请人电话
	private String applyUserTel ;
	//改签申请人CODE
	private String applyUserCode ;
	//改签申请日期
	private Date applyDate ;
	//改签申请单创建人code
	private String createUserCode ;
	//改签单来源  0：ABE接口生成的订单；1：PGS接口生成的订单
	private String applyOrderType ;
	//改签状态
	private String state ;
	//改签前舱位Code
	private String cabinCode ;
	//第一次改签前机票价格
	private BigDecimal ticketPrice ;
	//备注
	private String disc ;
	//改期费
	private BigDecimal modifyfee ;
	//创建时间
	private Date createTime ;
	//创建人
	private String createUser ;
	//更新时间
	private Date updateTime ;
	//更新人
	private String updateUser ;
	//改签类型
	private String type;
	//来源
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
	public String getBookingFlightId() {
		return bookingFlightId;
	}
	public void setBookingFlightId(String bookingFlightId) {
		this.bookingFlightId = bookingFlightId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
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
	public String getCabinCode() {
		return cabinCode;
	}
	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public BigDecimal getModifyfee() {
		return modifyfee;
	}
	public void setModifyfee(BigDecimal modifyfee) {
		this.modifyfee = modifyfee;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
