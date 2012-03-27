package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店订单状态更新返回vo
 * 
 * 历史版本: 2011-11-22 v1.0.0 (lixun) 创建
 * 
 */
public class HotelOrderStsUpdateVo {
	
	private String memberid;
	private String orderCode;
	private String paySts;
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getPaySts() {
		return paySts;
	}
	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}
	
}
