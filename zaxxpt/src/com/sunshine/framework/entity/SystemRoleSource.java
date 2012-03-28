package com.sunshine.framework.entity;

/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemRoleSource extends BaseDomain {

	// Fields

	private SystemRole systemRole;
	private SystemSourcePopedom systemSourcePopedom;

	// Constructors

	/** default constructor */
	public SystemRoleSource() {
	}

	/** minimal constructor */
	public SystemRoleSource(String id, SystemRole systemRole) {
		super(id);
		this.systemRole = systemRole;
	}

	/** full constructor */
	public SystemRoleSource(String id, SystemRole systemRole,
			SystemSourcePopedom systemSourcePopedom) {
		super(id);
		this.systemRole = systemRole;
		this.systemSourcePopedom = systemSourcePopedom;
	}

	// Property accessors


	public SystemRole getSystemRole() {
		return this.systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	public SystemSourcePopedom getSystemSourcePopedom() {
		return this.systemSourcePopedom;
	}

	public void setSystemSourcePopedom(SystemSourcePopedom systemSourcePopedom) {
		this.systemSourcePopedom = systemSourcePopedom;
	}

}