package com.hnatourism.club.hotel.prod.web.vo;

import java.util.List;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店房间设施
 * 
 * 历史版本:2011-08-09 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HotelRoomVo extends AbstractVo
{
	private String code;
	private String name;
	private String bed;
	private String breakfast;
	private String internet;
	private String area;
	private String rateproCode;
	private String preference;
	private String limit;
	//C销售价
	private Long price;
	//门市价
	private String costAvgPrice;
	private String roomSts;
	//底价
	private String avgPrice;
	private List<HotelPicsVo> pics;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public String getInternet() {
		return internet;
	}
	public void setInternet(String internet) {
		this.internet = internet;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRateproCode() {
		return rateproCode;
	}
	public void setRateproCode(String rateproCode) {
		this.rateproCode = rateproCode;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCostAvgPrice() {
		return costAvgPrice;
	}
	public void setCostAvgPrice(String costAvgPrice) {
		this.costAvgPrice = costAvgPrice;
	}
	public String getRoomSts() {
		return roomSts;
	}
	public void setRoomSts(String roomSts) {
		this.roomSts = roomSts;
	}
	public List<HotelPicsVo> getPics() {
		return pics;
	}
	public void setPics(List<HotelPicsVo> pics) {
		this.pics = pics;
	}
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
	
}