package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店详情信息
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelDetailVo {
	/** property 	*/
	private String hotelEquip;
	
	/** property 	*/
	private String roomEquip;

	/** property 	*/
	private String dinner;

	/** property 	*/
	private String entertainment;

	/** property 	*/
	private String conference;

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

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public String getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}
	
}
