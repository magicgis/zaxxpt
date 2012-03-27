package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser extends BaseDomain {

	// Fields

	private String id;
	private String name;
	private String password;
	private String position;
	private String fullName;
	private String telephone;
	private String createUser;
	private Timestamp createTime;
	private Integer sts;
	private String remark;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String name, String password, Timestamp createTime,
			Integer sts) {
		this.name = name;
		this.password = password;
		this.createTime = createTime;
		this.sts = sts;
	}

	/** full constructor */
	public SysUser(String name, String password, String position,
			String fullName, String telephone, String createUser,
			Timestamp createTime, Integer sts, String remark) {
		this.name = name;
		this.password = password;
		this.position = position;
		this.fullName = fullName;
		this.telephone = telephone;
		this.createUser = createUser;
		this.createTime = createTime;
		this.sts = sts;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getSts() {
		return this.sts;
	}

	public void setSts(Integer sts) {
		this.sts = sts;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}