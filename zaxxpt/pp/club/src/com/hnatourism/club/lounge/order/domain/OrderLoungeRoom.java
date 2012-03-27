package com.hnatourism.club.lounge.order.domain;

import java.util.Date;

import com.hnatourism.club.lounge.prod.domain.LoungePrice;
import com.hnatourism.framework.core.domain.AbstractEntity;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机场休息室订单房间表
 * 
 * 历史版本: 2011-8-16 v1.0.0 (lixun) 创建
 * 
 */
@SuppressWarnings("serial")
public class OrderLoungeRoom extends AbstractEntity{
	//${c.getComments()}
	private String id;
	//${c.getComments()}
	private String loungeId;
	//贵宾间、贵宾厅还是两舱休息室,信息来源于sys_constant表
	private String type;
	//只有贵宾间有房间类型，内容如：1-4人
	private String roomType;
	//是否满员或不可使用
	private String sts;
	//休息室数量
	private Long quantity;
	//提前预定日期
	private Long bookDate;
	//工作开始时间
	private String startTime;
	//工作结束时间
	private String endTime;
	//单收费项目ID集合
	private String item;
	//合同有效期开始日期
	private Date startDate;
	//合同有效期结束日期
	private Date endDate;
	//退改规则
	private String rmk;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String updateUser;
	//${c.getComments()}
	private Date updateTime;

	private LoungePrice  loungePrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoungeId() {
		return loungeId;
	}

	public void setLoungeId(String loungeId) {
		this.loungeId = loungeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getBookDate() {
		return bookDate;
	}

	public void setBookDate(Long bookDate) {
		this.bookDate = bookDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public LoungePrice getLoungePrice() {
		return loungePrice;
	}

	public void setLoungePrice(LoungePrice loungePrice) {
		this.loungePrice = loungePrice;
	}
	
	
	
	
//	   ID                   varchar(32)                     not null,
//	   LOUNGE_ID            varchar(32),
//	   TYPE                 varchar(2),
//	   ROOM_TYPE            varchar(50),
//	   STS                  char(1),
//	   QUANTITY             NUMBER,
//	   BOOK_DATE            NUMBER,
//	   START_TIME           varchar(10),
//	   END_TIME             varchar(10),
//	   ITEM                 varchar(100),
//	   START_DATE           TIMESTAMP(6),
//	   END_DATE             TIMESTAMP(6),
//	   RMK                  varchar(200),
//	   CREATE_USER          varchar(200)                    not null,
//	   CREATE_TIME          TIMESTAMP(6)                    not null,
//	   UPDATE_USER          varchar(200),
//	   UPDATE_TIME          TIMESTAMP(6),
}
