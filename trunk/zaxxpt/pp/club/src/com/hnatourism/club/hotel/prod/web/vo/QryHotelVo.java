package com.hnatourism.club.hotel.prod.web.vo;

import com.hnatourism.club.common.Constants;
import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店信息查询vo
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class QryHotelVo extends AbstractVo{
	/**
	 * 来源
	 */
	String origin;
	/**
	 * 酒店code
	 */
	String hotelCode;
	/**
	 * 入住时间
	 */
	String idate;
	/**
	 * 离店时间
	 */
	String odate;
	//城市来源类型
	String cityType = Constants.CLUB_HOTEL_CITY_STYPE;
	//城市
	String citycode;
	//城市名
	String cityname;
	//酒店星级
	String star;
	//酒店名称
	String hotelname;
	//价格
	String price;
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
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
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	/**
	 * @return the cityType
	 */
	public String getCityType() {
		return cityType;
	}
	/**
	 * @param cityType the cityType to set
	 */
	public void setCityType(String cityType) {
		this.cityType = cityType;
	}
}