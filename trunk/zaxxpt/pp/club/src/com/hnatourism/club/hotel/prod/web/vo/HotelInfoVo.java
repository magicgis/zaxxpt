package com.hnatourism.club.hotel.prod.web.vo;

import java.util.List;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店信息
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HotelInfoVo extends AbstractVo{
	String maptype;
	/**
	 * 城市code
	 */
	String citycode;
	/**
	 * 城市名称
	 */
	String cityname;
	/**
	 * 入住时间
	 */
	String idate;
	/**
	 * 离店时间
	 */
	String odate;
	/**
	 * 酒店名字
	 */
	String hname;
	String origin;
	String hcode;
	/**
	 * 图片信息
	 */
	List<PictureVo> pics;
	/**
	 * 酒店基本信息
	 */
	HotelDetailVo hotel;
	/*
	 * 酒店详细列表
	 */
	List<HotelDetailVo> hotels;
	/**
	 * 酒店房间设施
	 */
	HotelEquipVo details;
	List<HotelRoomVo> rooms;
	
	
	public List<HotelRoomVo> getRooms() {
		return rooms;
	}
	public void setRooms(List<HotelRoomVo> rooms) {
		this.rooms = rooms;
	}
	public HotelDetailVo getHotel() {
		return hotel;
	}
	public void setHotel(HotelDetailVo hotel) {
		this.hotel = hotel;
	}
	public HotelEquipVo getDetails() {
		return details;
	}
	public void setDetails(HotelEquipVo details) {
		this.details = details;
	}
	public String getMaptype() {
		return maptype;
	}
	public void setMaptype(String maptype) {
		this.maptype = maptype;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public List<PictureVo> getPics() {
		return pics;
	}
	public void setPics(List<PictureVo> pics) {
		this.pics = pics;
	}
	public List<HotelDetailVo> getHotels() {
		return hotels;
	}
	public void setHotels(List<HotelDetailVo> hotels) {
		this.hotels = hotels;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getHcode() {
		return hcode;
	}
	public void setHcode(String hcode) {
		this.hcode = hcode;
	}
}