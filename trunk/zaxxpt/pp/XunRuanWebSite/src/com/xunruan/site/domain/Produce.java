package com.xunruan.site.domain;

import java.sql.Timestamp;
import java.util.Set;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Produce entity. @author MyEclipse Persistence Tools
 */

public class Produce extends BaseDomain {

	// Fields

	private String id;
	private String name;
	private String title;
	private Integer type;
	private String special;
	private String introduction;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private Integer sts;
	private RealInfo realInfo;
	private Set<Source> sources;

	// Constructors

	/** default constructor */
	public Produce() {
	}

	/** minimal constructor */
	public Produce(String name, Integer type, String special,
			String introduction, Timestamp createTime, Timestamp updateTime,
			Integer sts) {
		this.name = name;
		this.type = type;
		this.special = special;
		this.introduction = introduction;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.sts = sts;
	}

	/** full constructor */
	public Produce(String name,String title, Integer type, String special,
			String introduction, String createUser, Timestamp createTime,
			String updateUser, Timestamp updateTime, Integer sts) {
		this.name = name;
		this.title=title;
		this.type = type;
		this.special = special;
		this.introduction = introduction;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.sts = sts;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getSts() {
		return this.sts;
	}

	public void setSts(Integer sts) {
		this.sts = sts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public RealInfo getRealInfo() {
		return realInfo;
	}

	public void setRealInfo(RealInfo realInfo) {
		this.realInfo = realInfo;
	}

	public Set<Source> getSources() {
		return sources;
	}

	public void setSources(Set<Source> sources) {
		this.sources = sources;
	}

	
	
}