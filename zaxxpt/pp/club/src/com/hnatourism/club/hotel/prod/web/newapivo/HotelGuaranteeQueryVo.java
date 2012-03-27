package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店预订现付担保差查询vo
 * 
 * 历史版本: 2011-11-17 v1.0.0 (lixun) 创建
 * 
 */
public class HotelGuaranteeQueryVo {
	private String hotelCode;// 必填项;//酒店编码
	private String roomPlanCode;// 必填项;//房型计划编码
	private String checkInDate;// 必填项;//入住日期
	private String checkOutDate;// 必填项;//离店日期
	private String roomAmount;// 必填项;//房间数量
	private String arriveDate;// 必填项;//到店时间
	private String lastArriveDate;// 必填项;//最晚到店时间

	public String getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}

	public String getRoomPlanCode() {
		return roomPlanCode;
	}

	public void setRoomPlanCode(String roomPlanCode) {
		this.roomPlanCode = roomPlanCode;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getRoomAmount() {
		return roomAmount;
	}

	public void setRoomAmount(String roomAmount) {
		this.roomAmount = roomAmount;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getLastArriveDate() {
		return lastArriveDate;
	}

	public void setLastArriveDate(String lastArriveDate) {
		this.lastArriveDate = lastArriveDate;
	}

}
