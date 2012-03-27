package com.hnatourism.club.hotel.prod.web.newapivo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店房型房态查询vo
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelRoomQueryVo {
	
	private String city;// 城市code;//
	private String hotelCode;// 酒店code;//必填
	private String idate;// 入住日期;//必填
	private String odate;// 离店日期;//必填
	private String source;// 客户端类型_客户端名称_渠道_版本号来源，如android_hotel_xhlx_v1.0;//必填
	private String key;// 新华旅行网分配的唯一授权码;//必填
	private String syssource;// 系统来源;//选填
	private String citySource="hna";//城市编码类型用于区分酒店的编码类型,取值为hbe 或者hna

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSyssource() {
		return syssource;
	}

	public void setSyssource(String syssource) {
		this.syssource = syssource;
	}

	public String getCitySource() {
		return citySource;
	}

	public void setCitySource(String citySource) {
		this.citySource = citySource;
	}

}
