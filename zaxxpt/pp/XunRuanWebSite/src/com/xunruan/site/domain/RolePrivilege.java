package com.xunruan.site.domain;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * RolePrivilege entity. @author MyEclipse Persistence Tools
 */

public class RolePrivilege extends BaseDomain {

	// Fields

	private String id;
	private String roleId;
	private String privilegeId;
	private Integer sts;
	private String remark;

	// Constructors

	/** default constructor */
	public RolePrivilege() {
	}

	/** minimal constructor */
	public RolePrivilege(String roleId, String privilegeId, Integer sts) {
		this.roleId = roleId;
		this.privilegeId = privilegeId;
		this.sts = sts;
	}

	/** full constructor */
	public RolePrivilege(String roleId, String privilegeId, Integer sts,
			String remark) {
		this.roleId = roleId;
		this.privilegeId = privilegeId;
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

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
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