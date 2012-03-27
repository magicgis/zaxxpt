package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Experience entity. @author MyEclipse Persistence Tools
 */

public class Experience extends BaseDomain{

	// Fields

	private String id;
	private String productName;
	private String productId;
	private String applyUser;
	private String email;
	private String contactPhone;
	private String contactAdd;
	private String companyName;
	private Timestamp createTime;
	private String remark;

	// Constructors

	/** default constructor */
	public Experience() {
	}

	/** minimal constructor */
	public Experience(String productName, String productId, String applyUser,
			String contactPhone, String companyName, Timestamp createTime) {
		this.productName = productName;
		this.productId = productId;
		this.applyUser = applyUser;
		this.contactPhone = contactPhone;
		this.companyName = companyName;
		this.createTime = createTime;
	}

	/** full constructor */
	public Experience(String productName, String productId, String applyUser,
			String email, String contactPhone, String contactAdd,
			String companyName, Timestamp createTime, String remark) {
		this.productName = productName;
		this.productId = productId;
		this.applyUser = applyUser;
		this.email = email;
		this.contactPhone = contactPhone;
		this.contactAdd = contactAdd;
		this.companyName = companyName;
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

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getApplyUser() {
		return this.applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
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

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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