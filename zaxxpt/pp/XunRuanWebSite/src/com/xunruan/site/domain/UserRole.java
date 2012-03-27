package com.xunruan.site.domain;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole extends BaseDomain  {

	// Fields

	private String id;
	private String userId;
	private String roleId;
	private Integer sts;
	private String remark;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** minimal constructor */
	public UserRole(String userId, String roleId, Integer sts) {
		this.userId = userId;
		this.roleId = roleId;
		this.sts = sts;
	}

	/** full constructor */
	public UserRole(String userId, String roleId, Integer sts, String remark) {
		this.userId = userId;
		this.roleId = roleId;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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