package com.hnatourism.club.hotel.prod.web.vo;

import java.util.Date;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店基本信息
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HotelDetailVo extends AbstractVo{
	String code;
	String name;
	String star;
	String origin;
	String longitude;
	String latitude;
	String govarea;
	String ecoarea;
	String addr;
	String phone;
	String hdesc;
	String price;
	String signin;
	String govareaCode;
	String ecoareaCode;
	String picpath;
	String oneModule;
	String twoModule;
	String threeModule;
	String traffic;
	/*新增属性*/

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
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getGovarea() {
		return govarea;
	}
	public void setGovarea(String govarea) {
		this.govarea = govarea;
	}
	public String getEcoarea() {
		return ecoarea;
	}
	public void setEcoarea(String ecoarea) {
		this.ecoarea = ecoarea;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHdesc() {
		return hdesc;
	}
	public void setHdesc(String hdesc) {
		this.hdesc = hdesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSignin() {
		return signin;
	}
	public void setSignin(String signin) {
		this.signin = signin;
	}
	public String getGovareaCode() {
		return govareaCode;
	}
	public void setGovareaCode(String govareaCode) {
		this.govareaCode = govareaCode;
	}
	public String getEcoareaCode() {
		return ecoareaCode;
	}
	public void setEcoareaCode(String ecoareaCode) {
		this.ecoareaCode = ecoareaCode;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getOneModule() {
		return oneModule;
	}
	public void setOneModule(String oneModule) {
		this.oneModule = oneModule;
	}
	public String getTwoModule() {
		return twoModule;
	}
	public void setTwoModule(String twoModule) {
		this.twoModule = twoModule;
	}
	public String getThreeModule() {
		return threeModule;
	}
	public void setThreeModule(String threeModule) {
		this.threeModule = threeModule;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	
}