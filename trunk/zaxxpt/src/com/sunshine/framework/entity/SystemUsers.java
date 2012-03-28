package com.sunshine.framework.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemUsers extends BaseDomain {

	// Fields

	private String userName;
	private String password;
	private int level;
	private int cert;
	private String certInfo;
	private Timestamp certTime;
	private int popedomModel;
	private Timestamp createTime;
	private String createUser;
	private int sts;
	private String remark;
	private Set systemUsersRoles = new HashSet(0);
	private Set systemUsersInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public SystemUsers() {
	}

	/** minimal constructor */
	public SystemUsers(String id, String userName, String password,
			int level, int cert, Timestamp certTime,
			int popedomModel, Timestamp createTime, String createUser,
			int sts) {
		super(id);
		this.userName = userName;
		this.password = password;
		this.level = level;
		this.cert = cert;
		this.certTime = certTime;
		this.popedomModel = popedomModel;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
	}

	/** full constructor */
	public SystemUsers(String id, String userName, String password,
			int level, int cert, String certInfo,
			Timestamp certTime, int popedomModel, Timestamp createTime,
			String createUser, int sts, String remark,
			Set systemUsersRoles, Set systemUsersInfos) {
		super(id);
		this.userName = userName;
		this.password = password;
		this.level = level;
		this.cert = cert;
		this.certInfo = certInfo;
		this.certTime = certTime;
		this.popedomModel = popedomModel;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
		this.remark = remark;
		this.systemUsersRoles = systemUsersRoles;
		this.systemUsersInfos = systemUsersInfos;
	}

	// Property accessors


	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCert() {
		return this.cert;
	}

	public void setCert(int cert) {
		this.cert = cert;
	}

	public String getCertInfo() {
		return this.certInfo;
	}

	public void setCertInfo(String certInfo) {
		this.certInfo = certInfo;
	}

	public Timestamp getCertTime() {
		return this.certTime;
	}

	public void setCertTime(Timestamp certTime) {
		this.certTime = certTime;
	}

	public int getPopedomModel() {
		return this.popedomModel;
	}

	public void setPopedomModel(int popedomModel) {
		this.popedomModel = popedomModel;
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

	public Set getSystemUsersRoles() {
		return this.systemUsersRoles;
	}

	public void setSystemUsersRoles(Set systemUsersRoles) {
		this.systemUsersRoles = systemUsersRoles;
	}

	public Set getSystemUsersInfos() {
		return this.systemUsersInfos;
	}

	public void setSystemUsersInfos(Set systemUsersInfos) {
		this.systemUsersInfos = systemUsersInfos;
	}

}