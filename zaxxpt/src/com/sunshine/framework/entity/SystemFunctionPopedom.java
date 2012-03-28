package com.sunshine.framework.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemFunctionPopedom extends BaseDomain {

	// Fields

	private SystemSourcePopedom systemSourcePopedom;
	private String name;
	private String action;
	private int level;
	private String parentId;
	private Timestamp createTime;
	private String createUser;
	private int sts;
	private String remark;
	private String image;
	private Set systemRoleFunctions = new HashSet(0);

	// Constructors

	/** default constructor */
	public SystemFunctionPopedom() {
	}

	/** minimal constructor */
	public SystemFunctionPopedom(String id, String name, int level,String image,
			Timestamp createTime, String createUser, int sts) {
		super(id);
		this.name = name;
		this.level = level;
		this.image=image;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
	}

	/** full constructor */
	public SystemFunctionPopedom(String id,
			SystemSourcePopedom systemSourcePopedom, String name,
			String action, int level, String parentId,String image,
			Timestamp createTime, String createUser, int sts,
			String remark, Set systemRoleFunctions) {
		super(id);
		this.systemSourcePopedom = systemSourcePopedom;
		this.name = name;
		this.action = action;
		this.level = level;
		this.parentId = parentId;
		this.createTime = createTime;
		this.createUser = createUser;
		this.sts = sts;
		this.image=image;
		this.remark = remark;
		this.systemRoleFunctions = systemRoleFunctions;
	}

	// Property accessors


	public SystemSourcePopedom getSystemSourcePopedom() {
		return this.systemSourcePopedom;
	}

	public void setSystemSourcePopedom(SystemSourcePopedom systemSourcePopedom) {
		this.systemSourcePopedom = systemSourcePopedom;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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

	public Set getSystemRoleFunctions() {
		return this.systemRoleFunctions;
	}

	public void setSystemRoleFunctions(Set systemRoleFunctions) {
		this.systemRoleFunctions = systemRoleFunctions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
}