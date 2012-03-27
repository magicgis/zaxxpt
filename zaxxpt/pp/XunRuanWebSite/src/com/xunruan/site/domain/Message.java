package com.xunruan.site.domain;

import java.sql.Timestamp;

import com.xunruan.framekork.domain.BaseDomain;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message extends BaseDomain{

	// Fields

	private String id;
	private String messageUser;
	private String ip;
	private String content;
	private Integer type;
	private String replyContent;
	private Integer replySts;
	private String extendsId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(String messageUser, String ip, String content, Integer type,
			Timestamp createTime) {
		this.messageUser = messageUser;
		this.ip = ip;
		this.content = content;
		this.type = type;
		this.createTime = createTime;
	}

	/** full constructor */
	public Message(String messageUser, String ip, String content, Integer type,
			String replyContent, Integer replySts, String extendsId,
			Timestamp createTime) {
		this.messageUser = messageUser;
		this.ip = ip;
		this.content = content;
		this.type = type;
		this.replyContent = replyContent;
		this.replySts = replySts;
		this.extendsId = extendsId;
		this.createTime = createTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessageUser() {
		return this.messageUser;
	}

	public void setMessageUser(String messageUser) {
		this.messageUser = messageUser;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Integer getReplySts() {
		return this.replySts;
	}

	public void setReplySts(Integer replySts) {
		this.replySts = replySts;
	}

	public String getExtendsId() {
		return this.extendsId;
	}

	public void setExtendsId(String extendsId) {
		this.extendsId = extendsId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}