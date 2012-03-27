package com.hnatourism.club.hotel.prod.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店房间设施
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HotelEquipVo extends AbstractVo{
	String dinner;
	String hotelEquip;
	String roomEquip;
	String conference;
	String entertainment;
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
	public String getHotelEquip() {
		return hotelEquip;
	}
	public void setHotelEquip(String hotelEquip) {
		this.hotelEquip = hotelEquip;
	}
	public String getRoomEquip() {
		return roomEquip;
	}
	public void setRoomEquip(String roomEquip) {
		this.roomEquip = roomEquip;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	public String getEntertainment() {
		return entertainment;
	}
	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}
}