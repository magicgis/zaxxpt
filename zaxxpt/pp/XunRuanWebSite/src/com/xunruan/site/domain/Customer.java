package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer extends BaseDomain {

	// Fields

	private String id;
	private String name;
	private String contactUser;
	private String email;
	private String contactPhone;
	private String contactAdd;
	private String createUser;
	private Timestamp createTime;
	private Integer sts;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(String name, Timestamp createTime, Integer sts) {
		this.name = name;
		this.createTime = createTime;
		this.sts = sts;
	}

	/** full constructor */
	public Customer(String name, String contactUser, String email,
			String contactPhone, String contactAdd, String createUser,
			Timestamp createTime, Integer sts) {
		this.name = name;
		this.contactUser = contactUser;
		this.email = email;
		this.contactPhone = contactPhone;
		this.contactAdd = contactAdd;
		this.createUser = createUser;
		this.createTime = createTime;
		this.sts = sts;
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

	public String getContactUser() {
		return this.contactUser;
	}

	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactAdd() {
		return this.contactAdd;
	}

	public void setContactAdd(String contactAdd) {
		this.contactAdd = contactAdd;
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

}