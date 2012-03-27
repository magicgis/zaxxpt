package com.hnatourism.club.lounge.prod.domain;

import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场VO
 * 
 * 历史版本:2011-08-10 v1.1.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class FilghtAirport extends AbstractVo{
	/**
	 * ${c.getComments()}
	 */
	private String id;
	/**
	 * ${c.getComments()}
	 */
	private String code;
	/**
	 * ${c.getComments()}
	 */
	private String name;
	/**
	 * ${c.getComments()}
	 */
	private Date airportEname;
	/**
	 * ${c.getComments()}
	 */
	private char sts;
	/**
	 * ${c.getComments()}
	 */
	private String createUser;
	/**
	 * ${c.getComments()}
	 */
	private Date createTime;
	/**
	 * ${c.getComments()}
	 */
	private String updateUser;
	/**
	 * ${c.getComments()}
	 */
	private Date updateTime;
	private String rmk;
	private String city;
	private String lname;
	private String ename;
	private String isHot;
	private String isMain;
	private String code4;
	private String lename;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Date getAirportEname() {
		return airportEname;
	}
	public void setAirportEname(Date airportEname) {
		this.airportEname = airportEname;
	}
	public char getSts() {
		return sts;
	}
	public void setSts(char sts) {
		this.sts = sts;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getCity() {
		return city;
	}
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
	public String getIsHot() {
		return isHot;
	}
	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
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