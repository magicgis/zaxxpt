package com.hnatourism.club.flight.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:行程单信息
 * 
 * 历史版本: 2010-07-09 v1.0.0 (hna) 创建:
 * 
 */
public class FlightItineraryVo extends AbstractVo {
	// 订单号
	private String orderCode;
	// 配送方式 2：邮寄 0:无需配送(低碳出行) 3:机场自取 4:制定地点领取 1:快递
	private String deliveryType;
	// 收信人
	private String catchUser;
	// 收信地址
	private String address;
	// 城市
	private String city;
	// 邮政编码
	private String postCode;
	// 自取时间
	private String catchTime;
	// 电话
	private String mobile;
	// 提示邮递费用
	private String isPromptMailCost;
	/**
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * @param orderCode
	 *            the orderCode to set
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
	 * @param deliveryType
	 *            the deliveryType to set
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
	 * @param catchUser
	 *            the catchUser to set
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
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the catchTime
	 */
	public String getCatchTime() {
		return catchTime;
	}

	/**
	 * @param catchTime
	 *            the catchTime to set
	 */
	public void setCatchTime(String catchTime) {
		this.catchTime = catchTime;
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
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getIsPromptMailCost() {
		return isPromptMailCost;
	}

	public void setIsPromptMailCost(String isPromptMailCost) {
		this.isPromptMailCost = isPromptMailCost;
	}
}
