package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role extends BaseDomain{

	// Fields

	private String id;
	private String name;
	private String createName;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private Integer sts;
	private String remark;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String name, Timestamp createTime, Timestamp updateTime,
			Integer sts) {
		this.name = name;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.sts = sts;
	}

	/** full constructor */
	public Role(String name, String createName, Timestamp createTime,
			String updateUser, Timestamp updateTime, Integer sts, String remark) {
		this.name = name;
		this.createName = createName;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
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

	public String getCreateName() {
		return this.createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
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