package com.hnatourism.club.common.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;

/**
 * HnaProcity entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class HnaProcity extends AbstractEntity{


	
	/**
	 * 城市编码
	 */
	private String pccode;
	/**
	 * 城市名称
	 */
	private String pcname;
	private String parentcode;
	private String parentname;
	private String area;
	private String isopen;
	private String ishot;
	private String searchkey;
	private String mapbarkey;
	private String weatherkey;
	private String rmk;
	private String shortname;
	private String pctype;
	private String licensePlate;
	private String areaCode;
	private String zipCode;
	private String code;
	private String domainCode;
	private String airCode;
	public String getPccode()
	{
		return this.pccode;
	}

	public void setPccode(String pccode)
	{
		this.pccode = pccode;
	}

	public String getPcname()
	{
		return this.pcname;
	}

	public void setPcname(String pcname)
	{
		this.pcname = pcname;
	}

	public String getParentcode()
	{
		return this.parentcode;
	}

	public void setParentcode(String parentcode)
	{
		this.parentcode = parentcode;
	}

	public String getParentname()
	{
		return this.parentname;
	}

	public void setParentname(String parentname)
	{
		this.parentname = parentname;
	}

	public String getArea()
	{
		return this.area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getIsopen()
	{
		return this.isopen;
	}

	public void setIsopen(String isopen)
	{
		this.isopen = isopen;
	}

	public String getIshot()
	{
		return this.ishot;
	}

	public void setIshot(String ishot)
	{
		this.ishot = ishot;
	}

	public String getSearchkey()
	{
		return this.searchkey;
	}

	public void setSearchkey(String searchkey)
	{
		this.searchkey = searchkey;
	}

	public String getMapbarkey()
	{
		return this.mapbarkey;
	}

	public void setMapbarkey(String mapbarkey)
	{
		this.mapbarkey = mapbarkey;
	}

	public String getWeatherkey()
	{
		return this.weatherkey;
	}

	public void setWeatherkey(String weatherkey)
	{
		this.weatherkey = weatherkey;
	}

	public String getRmk()
	{
		return this.rmk;
	}

	public void setRmk(String rmk)
	{
		this.rmk = rmk;
	}

	public String getShortname()
	{
		return shortname;
	}

	public void setShortname(String shortname)
	{
		this.shortname = shortname;
	}

	public String getPctype()
	{
		return pctype;
	}

	
	public void setPctype(String pctype)
	{
		this.pctype = pctype;
	}
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDomainCode() {
		return domainCode;
	}

	public void setDomainCode(String domainCode) {
		this.domainCode = domainCode;
	}

	public String getAirCode() {
		return airCode;
	}

	public void setAirCode(String airCode) {
		this.airCode = airCode;
	}


}
