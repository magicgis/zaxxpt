package com.sunshine.framework.entity;

/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemRoleFunction extends BaseDomain {

	// Fields

	private SystemRole systemRole;
	private SystemFunctionPopedom systemFunctionPopedom;

	// Constructors

	/** default constructor */
	public SystemRoleFunction() {
	}

	/** full constructor */
	public SystemRoleFunction(String id, SystemRole systemRole,
			SystemFunctionPopedom systemFunctionPopedom) {
		super(id);
		this.systemRole = systemRole;
		this.systemFunctionPopedom = systemFunctionPopedom;
	}

	// Property accessors


	public SystemRole getSystemRole() {
		return this.systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	public SystemFunctionPopedom getSystemFunctionPopedom() {
		return this.systemFunctionPopedom;
	}

	public void setSystemFunctionPopedom(
			SystemFunctionPopedom systemFunctionPopedom) {
		this.systemFunctionPopedom = systemFunctionPopedom;
	}

}