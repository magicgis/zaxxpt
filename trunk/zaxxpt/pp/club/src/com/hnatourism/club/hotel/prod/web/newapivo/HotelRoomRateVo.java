package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店房型动态vo
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelRoomRateVo {
	/** property 	*/
	private String date;

	/** property 	*/
	private String salePrice;

	/** property 	*/
	private String price;

	/** property 	*/
	private String channelCostPrice;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getChannelCostPrice() {
		return channelCostPrice;
	}

	public void setChannelCostPrice(String channelCostPrice) {
		this.channelCostPrice = channelCostPrice;
	}
	
	
}
