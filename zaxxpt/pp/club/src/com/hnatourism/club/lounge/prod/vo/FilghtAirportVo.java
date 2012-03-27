package com.hnatourism.club.lounge.prod.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场VO
 * 
 * 历史版本:2011-08-19 v1.1.0 (高杰) 创建:
 * 
 */
public class FilghtAirportVo extends AbstractVo{
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
	
	private String code4;
	private String lename;
	
	
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAirportEname() {
		return airportEname;
	}
	public void setAirportEname(String airportEname) {
		this.airportEname = airportEname;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	
	
}