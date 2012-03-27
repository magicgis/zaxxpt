package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Source entity. @author MyEclipse Persistence Tools
 */

public class Source extends BaseDomain {

	// Fields

	private String id;
	private String name;
	private String path;
	private Integer type;
	private Integer orders;
	private String sourceId;
	private String createUser;
	private Timestamp createTime;
	private String remark;

	// Constructors

	/** default constructor */
	public Source() {
	}

	/** minimal constructor */
	public Source(String name, String path, Integer type, Integer orders,
			Timestamp createTime) {
		this.name = name;
		this.path = path;
		this.type = type;
		this.orders = orders;
		this.createTime = createTime;
	}

	/** full constructor */
	public Source(String name, String path, Integer type, Integer orders,
			String createUser, String sourceId,Timestamp createTime, String remark) {
		this.name = name;
		this.path = path;
		this.type = type;
		this.orders = orders;
		this.sourceId=sourceId;
		this.createUser = createUser;
		this.createTime = createTime;
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOrders() {
		return this.orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	
	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}