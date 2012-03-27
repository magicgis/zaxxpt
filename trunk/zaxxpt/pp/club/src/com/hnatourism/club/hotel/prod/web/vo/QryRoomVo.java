package com.hnatourism.club.hotel.prod.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店信息查询vo
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class QryRoomVo extends AbstractVo{
	/**
	 * 城市编号
	 */
	String city;
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
	/**
	 * 来源
	 */
	String orign;
	
	
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
	public String getOrign() {
		return orign;
	}
	public void setOrign(String orign) {
		this.orign = orign;
	}
}