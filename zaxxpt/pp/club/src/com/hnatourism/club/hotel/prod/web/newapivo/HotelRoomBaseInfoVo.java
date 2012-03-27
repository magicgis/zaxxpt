package com.hnatourism.club.hotel.prod.web.newapivo;

import java.util.List;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店房型基本信息
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelRoomBaseInfoVo {
	/** property 	*/
	private String code;

	/** property 	*/
	private String name;

	/** property 	*/
	private String bedName;

	/** property 	*/
	private String netDesc;

	/** property 	*/
	private String breakfastDesc;

	/** property 	*/
	private String inventory;

	/** property 	*/
	private String payType;

	/** property 	*/
	private String roomPlanCode;

	/** property 	*/
	private String avgSalePrice;

	/** property 	*/
	private String avgPrice;

	/** property 	*/
	private List<HotelRoomRateVo> rateList;
	
	/** property 	会员优惠前台展示需要*/
	private String privilege;

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

	public String getBedName() {
		return bedName;
	}

	public void setBedName(String bedName) {
		this.bedName = bedName;
	}

	public String getNetDesc() {
		return netDesc;
	}

	public void setNetDesc(String netDesc) {
		this.netDesc = netDesc;
	}

	public String getBreakfastDesc() {
		return breakfastDesc;
	}

	public void setBreakfastDesc(String breakfastDesc) {
		this.breakfastDesc = breakfastDesc;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getRoomPlanCode() {
		return roomPlanCode;
	}

	public void setRoomPlanCode(String roomPlanCode) {
		this.roomPlanCode = roomPlanCode;
	}

	public String getAvgSalePrice() {
		return avgSalePrice;
	}

	public void setAvgSalePrice(String avgSalePrice) {
		this.avgSalePrice = avgSalePrice;
	}

	public String getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}

	public List<HotelRoomRateVo> getRateList() {
		return rateList;
	}

	public void setRateList(List<HotelRoomRateVo> rateList) {
		this.rateList = rateList;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	
	
}
