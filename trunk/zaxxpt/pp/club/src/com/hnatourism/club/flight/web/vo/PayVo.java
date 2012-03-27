package com.hnatourism.club.flight.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
	*支付 vo wuyuhu
	*2011-8-23
	*/	

public class PayVo extends AbstractVo {
	
	private String orderId;
	
	private String code;
	
	private String totalMoney;
	
	private String actualMoney;
	
	private String isFirst;
	
	private String email;
	
	private String password;
	
	private String memberId;
	
	private String webAccount;
	
	private String xlbAccount;
	
	private String cabinPriceChange;
	
	private String source;
	
	private String deliveryFee;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(String actualMoney) {
		this.actualMoney = actualMoney;
	}

	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getWebAccount() {
		return webAccount;
	}

	public void setWebAccount(String webAccount) {
		this.webAccount = webAccount;
	}

	public String getXlbAccount() {
		return xlbAccount;
	}

	public void setXlbAccount(String xlbAccount) {
		this.xlbAccount = xlbAccount;
	}

	public String getCabinPriceChange() {
		return cabinPriceChange;
	}

	public void setCabinPriceChange(String cabinPriceChange) {
		this.cabinPriceChange = cabinPriceChange;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the deliveryFee
	 */
	public String getDeliveryFee() {
		return deliveryFee;
	}

	/**
	 * @param deliveryFee the deliveryFee to set
	 */
	public void setDeliveryFee(String deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
}
 
