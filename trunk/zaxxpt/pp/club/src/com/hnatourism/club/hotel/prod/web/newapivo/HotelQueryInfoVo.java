package com.hnatourism.club.hotel.prod.web.newapivo;

import java.util.List;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店查询返回信息
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelQueryInfoVo {
	/** property 	*/
	private String maptype;

	/** property 	*/
	private String cityname;

	/** property 	*/
	private String idate;

	/** property 	*/
	private String odate;

	/** property 	*/
	private List<HotelBaseInfoVo> hotels;

	private HotelQueryPageInfo pageInfo;
	
	public String getMaptype() {
		return maptype;
	}

	public void setMaptype(String maptype) {
		this.maptype = maptype;
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

	public List<HotelBaseInfoVo> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelBaseInfoVo> hotels) {
		this.hotels = hotels;
	}

	public HotelQueryPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HotelQueryPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}
