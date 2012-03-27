package com.hnatourism.club.base.domain;

public class RoleUser {
	private String sysUserId;
	private String sysRoleId;
	private String sysRoleName;
	private String roleKey;
	public String getSysUserId() {
		return sysUserId;
	}
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}
	public String getSysRoleId() {
		return sysRoleId;
	}
	public void setSysRoleId(String sysRoleId) {
		this.sysRoleId = sysRoleId;
	}
	public String getSysRoleName() {
		return sysRoleName;
	}
	public void setSysRoleName(String sysRoleName) {
		this.sysRoleName = sysRoleName;
	}
	public String getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
}
