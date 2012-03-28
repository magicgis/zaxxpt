package com.sunshine.framework.entity;

import java.math.BigDecimal;

/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemRoleField extends BaseDomain {

	// Fields

	private SystemRole systemRole;
	private SystemFieldPopedom systemFieldPopedom;
	private int readOnly;
	private int hidden;

	// Constructors

	/** default constructor */
	public SystemRoleField() {
	}

	/** full constructor */
	public SystemRoleField(String id, SystemRole systemRole,
			SystemFieldPopedom systemFieldPopedom,
			int readOnly,int hidden) {
		super(id);
		this.systemRole = systemRole;
		this.systemFieldPopedom = systemFieldPopedom;
		this.readOnly=readOnly;
		this.hidden=hidden;
	}

	// Property accessors


	public SystemRole getSystemRole() {
		return this.systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	public SystemFieldPopedom getSystemFieldPopedom() {
		return this.systemFieldPopedom;
	}

	public void setSystemFieldPopedom(SystemFieldPopedom systemFieldPopedom) {
		this.systemFieldPopedom = systemFieldPopedom;
	}

	public int getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(int readOnly) {
		this.readOnly = readOnly;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}
	

}