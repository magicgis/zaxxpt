package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * RealInfo entity. @author MyEclipse Persistence Tools
 */

public class RealInfo extends BaseDomain {

	// Fields

	private String id;
	private String title;
	private String content;
	private String link;
	private Integer type;
	private String summary;
	private String createUser;
	private Timestamp createTime;
	private String source;
	private Integer sts;
	private Source sources;

	// Constructors

	/** default constructor */
	public RealInfo() {
	}

	/** minimal constructor */
	public RealInfo(String title, String content, Integer type,
			Timestamp createTime, Integer sts) {
		this.title = title;
		this.content = content;
		this.type = type;
		this.createTime = createTime;
		this.sts = sts;
	}

	/** full constructor */
	public RealInfo(String title, String content, String link, Integer type,
			String summary, String createUser, Timestamp createTime,
			String source, Integer sts) {
		this.title = title;
		this.content = content;
		this.link = link;
		this.type = type;
		this.summary = summary;
		this.createUser = createUser;
		this.createTime = createTime;
		this.source = source;
		this.sts = sts;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Source getSources() {
		return sources;
	}

	public void setSources(Source sources) {
		this.sources = sources;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getSts() {
		return this.sts;
	}

	public void setSts(Integer sts) {
		this.sts = sts;
	}

}