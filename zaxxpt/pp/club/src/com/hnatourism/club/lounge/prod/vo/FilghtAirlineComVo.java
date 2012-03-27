package com.hnatourism.club.lounge.prod.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:航空公司
 * 
 * 历史版本:2011-08-19 v1.1.0 (高杰) 创建:
 * 
 */
public class FilghtAirlineComVo extends AbstractVo{
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
	private String lname;
	private String ename;
	private String addr;
	private String tel;
	private String fax;
	private String country;
	private String settlementCode;
	
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSettlementCode() {
		return settlementCode;
	}
	public void setSettlementCode(String settlementCode) {
		this.settlementCode = settlementCode;
	}
}