package com.sunshine.framework.entity;

/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemUsersRole extends BaseDomain {

	// Fields

	private SystemRole systemRole;
	private SystemUsers systemUsers;

	// Constructors

	/** default constructor */
	public SystemUsersRole() {
	}

	/** full constructor */
	public SystemUsersRole(String id, SystemRole systemRole,
			SystemUsers systemUsers) {
		super(id);
		this.systemRole = systemRole;
		this.systemUsers = systemUsers;
	}

	// Property accessors


	public SystemRole getSystemRole() {
		return this.systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	public SystemUsers getSystemUsers() {
		return this.systemUsers;
	}

	public void setSystemUsers(SystemUsers systemUsers) {
		this.systemUsers = systemUsers;
	}

}