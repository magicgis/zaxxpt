package com.sunshine.framework.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemSourcePopedom extends BaseDomain {

	// Fields

	private String cName;
	private String eName;
	private Timestamp createTime;
	private String createUser;
	private int sts;
	private String remark;
	private Set systemFunctionPopedoms = new HashSet(0);
	private Set systemRoleSources = new HashSet(0);

	// Constructors

	/** default constructor */
	public SystemSourcePopedom() {
	}

	/** minimal constructor */
	public SystemSourcePopedom(String id, String cName, String eName,
			String image, Timestamp createTime, String createUser, int sts) {
		super(id);
		this.cName = cName;
		this.eName = eName;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
	}

	/** full constructor */
	public SystemSourcePopedom(String id, String cName, String eName,
			String image, Timestamp createTime, String createUser, int sts,
			String remark, Set systemFunctionPopedoms, Set systemRoleSources) {
		super(id);
		this.cName = cName;
		this.eName = eName;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
		this.remark = remark;
		this.systemFunctionPopedoms = systemFunctionPopedoms;
		this.systemRoleSources = systemRoleSources;
	}

	// Property accessors


	

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
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

	public Set getSystemFunctionPopedoms() {
		return this.systemFunctionPopedoms;
	}

	public void setSystemFunctionPopedoms(Set systemFunctionPopedoms) {
		this.systemFunctionPopedoms = systemFunctionPopedoms;
	}

	public Set getSystemRoleSources() {
		return this.systemRoleSources;
	}

	public void setSystemRoleSources(Set systemRoleSources) {
		this.systemRoleSources = systemRoleSources;
	}

}