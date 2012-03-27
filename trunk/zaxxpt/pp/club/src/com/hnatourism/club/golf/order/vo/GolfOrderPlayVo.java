package com.hnatourism.club.golf.order.vo;

import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫打球人员信息VO
 * 
 * 历史版本:2011-08-05 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfOrderPlayVo extends AbstractEntity
{
	//ID
	private String id ;
	//订单ID
	private String orderId ;
	//姓名
	private String name ;
	//消费状态
	private String sts ;
	//备注
	private String rmk ;
	//添加者
	private String createUser ;
	//添加时间
	private Date createTime ;
	//最后修改人
	private String updateUser ;
	//最后修改时间
	private Date updateTime ;
	private String orderType;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
	 
}
