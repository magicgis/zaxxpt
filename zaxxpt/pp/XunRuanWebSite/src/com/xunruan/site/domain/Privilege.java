package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */

public class Privilege extends BaseDomain{

	// Fields

	private String id;
	private String name;
	private String code;
	private String createName;
	private Timestamp createTime;
	private String updateName;
	private Timestamp updateTime;
	private Integer sts;
	private String remark;

	// Constructors

	/** default constructor */
	public Privilege() {
	}

	/** minimal constructor */
	public Privilege(String name, String code, Timestamp createTime,
			Timestamp updateTime, Integer sts) {
		this.name = name;
		this.code = code;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.sts = sts;
	}

	/** full constructor */
	public Privilege(String name, String code, String createName,
			Timestamp createTime, String updateName, Timestamp updateTime,
			Integer sts, String remark) {
		this.name = name;
		this.code = code;
		this.createName = createName;
		this.createTime = createTime;
		this.updateName = updateName;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getUpdateName() {
		return this.updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
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