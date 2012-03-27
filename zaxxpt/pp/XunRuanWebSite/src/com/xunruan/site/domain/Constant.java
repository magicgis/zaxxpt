package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Constant entity. @author MyEclipse Persistence Tools
 */

public class Constant extends BaseDomain{

	// Fields

	private String id;
	private String name;
	private String type;
	private String typeName;
	private Integer value;
	private String createUser;
	private Timestamp createTiem;
	private String updateUser;
	private Timestamp updateTime;
	private String remark;

	// Constructors

	/** default constructor */
	public Constant() {
	}

	/** minimal constructor */
	public Constant(String name, String type,String typeName, Integer value,
			Timestamp createTiem, Timestamp updateTime) {
		this.name = name;
		this.type = type;
		this.typeName = typeName;
		this.value = value;
		this.createTiem = createTiem;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Constant(String name, String type,String typeName, Integer value, String createUser,
			Timestamp createTiem, String updateUser, Timestamp updateTime,
			String remark) {
		this.name = name;
		this.type = type;
		this.typeName = typeName;
		this.value = value;
		this.createUser = createUser;
		this.createTiem = createTiem;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
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


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreateTiem() {
		return this.createTiem;
	}

	public void setCreateTiem(Timestamp createTiem) {
		this.createTiem = createTiem;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}