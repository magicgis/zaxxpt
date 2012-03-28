package com.sunshine.framework.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemFieldPopedom extends BaseDomain {

	// Fields

	private String cName;
	private String eName;
	private String tID;
	private Timestamp createTime;
	private String createUser;
	private int sts;
	private String remark;
	private Set systemRoleFields = new HashSet(0);

	// Constructors

	/** default constructor */
	public SystemFieldPopedom() {
	}

	/** minimal constructor */
	public SystemFieldPopedom(String id, String cName, String eName,
			String tID,Timestamp createTime, String createUser, int sts) {
		super(id);
		this.cName = cName;
		this.eName = eName;
		this.tID = tID;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
	}

	/** full constructor */
	public SystemFieldPopedom(String id, String cName, String eName,
			String tID, 
			Timestamp createTime, String createUser, int sts,
			String remark, Set systemRoleFields) {
		super(id);
		this.cName = cName;
		this.eName = eName;
		this.tID = tID;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
		this.remark = remark;
		this.systemRoleFields = systemRoleFields;
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

	public String gettID() {
		return tID;
	}

	public void settID(String tID) {
		this.tID = tID;
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

	public Set getSystemRoleFields() {
		return this.systemRoleFields;
	}

	public void setSystemRoleFields(Set systemRoleFields) {
		this.systemRoleFields = systemRoleFields;
	}

}