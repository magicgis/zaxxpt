package com.hnatourism.club.common.domain;

import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机场信息
 * 
 * 历史版本:
 *					2010-07-08 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class FlightAirport extends AbstractEntity {
	//创建人
	private String createUser ;
	//PK
	private String id ;
	//城市Code
	private String city ;
	//机场Code
	private String code ;
	//机场短名称
	private String name ;
	//机场英文名
	private String airportEname ;
	//状态:0禁用1启用
	private String sts ;
	//更新时间
	private Date updateTime ;
	//更新人
	private String updateUser ;
	//备注
	private String rmk ;
	
	//创建时间
	private Date createTime ;
	//是否热门
	private String isHot ;
	//是否主机场
	private String isMain ;
	
	private String lname;
	
	private String ename;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	private String code4;
	private String lename;
	private String cityName;
	private String pinyin;
	
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	public String getIsHot() {
		return isHot;
	}
	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}
	/**
	 * 获取创建人
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置创建人
	 * @param createUser
	 */	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取PK
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置PK
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取机场Code
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置机场Code
	 * @param code
	 */	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取机场短名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置机场短名称
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取机场英文名
	 * @return
	 */
	public String getAirportEname() {
		return airportEname;
	}
	/**
	 * 设置机场英文名
	 * @param airportEname
	 */	
	public void setAirportEname(String airportEname) {
		this.airportEname = airportEname;
	}
	/**
	 * 获取状态:0禁用1启用
	 * @return
	 */
	public String getSts() {
		return sts;
	}
	/**
	 * 设置状态:0禁用1启用
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取更新时间
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置更新时间
	 * @param updateTime
	 */	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取更新人
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置更新人
	 * @param updateUser
	 */	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取备注
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * 设置备注
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置创建时间
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getCode4() {
		return code4;
	}
	public void setCode4(String code4) {
		this.code4 = code4;
	}
	public String getLename() {
		return lename;
	}
	public void setLename(String lename) {
		this.lename = lename;
	}
}