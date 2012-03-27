package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * ProductCustomer entity. @author MyEclipse Persistence Tools
 */

public class ProductCustomer extends BaseDomain {

	// Fields

	private String id;
	private String productId;
	private String customerId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public ProductCustomer() {
	}

	/** full constructor */
	public ProductCustomer(String productId, String customerId,
			Timestamp createTime) {
		this.productId = productId;
		this.customerId = customerId;
		this.createTime = createTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}