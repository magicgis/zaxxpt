package com.hnatourism.club.common.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:天气
 * 
 * 历史版本:
 *					2010-08-03 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class WeatherVo extends AbstractVo{
	String citya;
	String cityb;
	String date;
	String prodType;
	String realPath;
	boolean isSingle;
	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getCitya() {
		return citya;
	}
	public void setCitya(String citya) {
		this.citya = citya;
	}
	public String getCityb() {
		return cityb;
	}
	public void setCityb(String cityb) {
		this.cityb = cityb;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean getIsSingle() {
		return isSingle;
	}
	public void setIsSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}
}