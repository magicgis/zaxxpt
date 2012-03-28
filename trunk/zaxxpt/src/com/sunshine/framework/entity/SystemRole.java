package com.sunshine.framework.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemRole extends BaseDomain {

	// Fields

	private String name;
	private int type;
	private Timestamp createTime;
	private String createUser;
	private int sts;
	private String remark;
	private Set systemRoleSources = new HashSet(0);
	private Set systemUsersRoles = new HashSet(0);
	private Set systemRoleFields = new HashSet(0);
	private Set systemRoleFunctions = new HashSet(0);

	// Constructors

	/** default constructor */
	public SystemRole() {
	}

	/** minimal constructor */
	public SystemRole(String id, String name, int type,
			Timestamp createTime, String createUser, int sts) {
		super(id);
		this.name = name;
		this.type = type;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
	}

	/** full constructor */
	public SystemRole(String id, String name, int type,
			Timestamp createTime, String createUser, int sts,
			String remark, Set systemRoleSources, Set systemUsersRoles,
			Set systemRoleFields, Set systemRoleFunctions) {
		super(id);
		this.name = name;
		this.type = type;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
		this.remark = remark;
		this.systemRoleSources = systemRoleSources;
		this.systemUsersRoles = systemUsersRoles;
		this.systemRoleFields = systemRoleFields;
		this.systemRoleFunctions = systemRoleFunctions;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public int getSts() {
		return this.sts;
	}

	public void setSts(int sts) {
		this.sts = sts;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSystemRoleSources() {
		return this.systemRoleSources;
	}

	public void setSystemRoleSources(Set systemRoleSources) {
		this.systemRoleSources = systemRoleSources;
	}

	public Set getSystemUsersRoles() {
		return this.systemUsersRoles;
	}

	public void setSystemUsersRoles(Set systemUsersRoles) {
		this.systemUsersRoles = systemUsersRoles;
	}

	public Set getSystemRoleFields() {
		return this.systemRoleFields;
	}

	public void setSystemRoleFields(Set systemRoleFields) {
		this.systemRoleFields = systemRoleFields;
	}

	public Set getSystemRoleFunctions() {
		return this.systemRoleFunctions;
	}

	public void setSystemRoleFunctions(Set systemRoleFunctions) {
		this.systemRoleFunctions = systemRoleFunctions;
	}

}