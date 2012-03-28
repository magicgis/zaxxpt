package com.sunshine.framework.entity;

import java.sql.Timestamp;

/***
 *@author wenz
 *@Date 2012-3-28ÉÏÎç10:18:04
 *@version 1.0
 *@see com.sunshine.framework.entity.SystemSourceTable
 ***/
public class SystemSourceTable extends BaseDomain {

	private String cName;
	private String eName;
	private String sID;
	private Timestamp createTime;
	private String createUser;
	private int sts;
	private String remark;
	
	
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
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public int getSts() {
		return sts;
	}
	public void setSts(int sts) {
		this.sts = sts;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
