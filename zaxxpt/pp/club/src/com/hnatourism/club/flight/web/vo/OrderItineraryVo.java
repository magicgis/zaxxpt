package com.hnatourism.club.flight.web.vo;


import java.math.BigDecimal;
import java.util.Date;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:行程单信息
 * 
 * 历史版本: 2010-7-21 v1.0.0 (wuyh) 创建
 * 
 */
public class OrderItineraryVo extends AbstractVo {
	// PK
	private String id;
	// 订单号
	private String orderCode;
	// 配送方式 0：邮寄 1:无需配送(低碳出行) 2:机场自取 3:制定地点领取4:：快递,
	private String deliveryType;
	// 收取人
	private String catchUser;
	// 收信地址
	private String address;
	// 邮政编码
	private String postcode;
	// 联系人手机
	private String mobile;
	// 联系人座机
	private String phone;
	// 城市
	private String city;
	// 自取时间
	private Date catchTime;
	// 更新时间
	private Date updateTime;
	// 更新人
	private String updateUser;
	// 备注
	private String rmk;
	// 创建时间
	private Date createTime;
	// 创建人
	private String createUser;
	//航班ID
	private String orderFlightId;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the deliveryType
	 */
	public String getDeliveryType() {
		return deliveryType;
	}
	/**
	 * @param deliveryType the deliveryType to set
	 */
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	/**
	 * @return the catchUser
	 */
	public String getCatchUser() {
		return catchUser;
	}
	/**
	 * @param catchUser the catchUser to set
	 */
	public void setCatchUser(String catchUser) {
		this.catchUser = catchUser;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * @return the orderFlightId
	 */
	public String getOrderFlightId() {
		return orderFlightId;
	}
	/**
	 * @param orderFlightId the orderFlightId to set
	 */
	public void setOrderFlightId(String orderFlightId) {
		this.orderFlightId = orderFlightId;
	}
	/**
	 * @return the catchTime
	 */
	public Date getCatchTime() {
		return catchTime;
	}
	/**
	 * @param catchTime the catchTime to set
	 */
	public void setCatchTime(Date catchTime) {
		this.catchTime = catchTime;
	}
}
