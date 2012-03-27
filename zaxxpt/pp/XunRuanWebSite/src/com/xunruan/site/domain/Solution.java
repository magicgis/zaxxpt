package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Solution entity. @author MyEclipse Persistence Tools
 */

public class Solution extends BaseDomain{

	// Fields

	private String id;
	private Integer type;
	private String name;
	private String content;
	private String createUser;
	private Timestamp createTime;
	private Integer sts;
	private String remark;

	// Constructors

	/** default constructor */
	public Solution() {
	}

	/** minimal constructor */
	public Solution(Integer type, String name, String content,
			Timestamp createTime, Integer sts) {
		this.type = type;
		this.name = name;
		this.content = content;
		this.createTime = createTime;
		this.sts = sts;
	}

	/** full constructor */
	public Solution(Integer type, String name, String content,
			String createUser, Timestamp createTime, Integer sts, String remark) {
		this.type = type;
		this.name = name;
		this.content = content;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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