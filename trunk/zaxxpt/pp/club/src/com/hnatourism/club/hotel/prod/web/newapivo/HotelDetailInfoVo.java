package com.hnatourism.club.hotel.prod.web.newapivo;

import java.util.List;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店新版接口,酒店详情信息
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelDetailInfoVo {
	/** property 	*/
	private String maptype;

	/** property 	*/
	private String citycode;

	/** property 	*/
	private String cityname;

	/** property 	*/
	private String idate;

	/** property 	*/
	private String odate;
	
	/** property 酒店详情基本信息*/
	private HotelDetailsBaseVo hotel;

	/** property 酒店图片信息*/
	private List<HotelDetailsPicVo> pics;
	
	/** property 酒店详情的详细信息 */
	private HotelDetailsVo details;
	
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

	public HotelDetailsBaseVo getHotel() {
		return hotel;
	}

	public void setHotel(HotelDetailsBaseVo hotel) {
		this.hotel = hotel;
	}

	public List<HotelDetailsPicVo> getPics() {
		return pics;
	}

	public void setPics(List<HotelDetailsPicVo> pics) {
		this.pics = pics;
	}

	public HotelDetailsVo getDetails() {
		return details;
	}

	public void setDetails(HotelDetailsVo details) {
		this.details = details;
	}
	
	
}
