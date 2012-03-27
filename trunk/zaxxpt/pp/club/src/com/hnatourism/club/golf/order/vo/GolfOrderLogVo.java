package com.hnatourism.club.golf.order.vo;

import java.util.Date;
import java.util.UUID;

import com.hnatourism.framework.core.domain.AbstractEntity;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫订单日志信息VO
 * 
 * 历史版本:2011-08-05 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfOrderLogVo extends AbstractEntity
{
	//ID
	private String id;
	//订单ID
	private String orderId;
	//操作内容
	private String content;
	private String type;
	//添加者
	private String createUser;
	//添加时间
	private Date createTime;
	//最后修改人
	private String updateUser;
	//最后修改时间
	private String updateTime;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
