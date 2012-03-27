package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
//申请回调修改订单 wuyuhu
public class FlightCallBackRequestMessage extends RequestMessage{
	private String orderCode;
	private String actualPay;
	private String memberId;
	private String payFlag;
	
	@Override
	public String getRequsetString() {
		StringBuffer sb=new StringBuffer();
		sb.append(BASE_REQUEST_URL);
		sb.append("/order/flight/orderFlightBack.jsp?code="+orderCode);
		sb.append("&actualPay="+actualPay);
		sb.append("&memberId="+memberId);
		sb.append("&payFlag="+payFlag);
		return sb.toString();
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getActualPay() {
		return actualPay;
	}
	public void setActualPay(String actualPay) {
		this.actualPay = actualPay;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPayFlag() {
		return payFlag;
	}
	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}
}
