package com.hnatourism.club.lounge.prod.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.sql.Timestamp;

import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室房间表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class LoungeRoom extends AbstractEntity {
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
	//提前几个小时预定
	private Integer advanceHours;

	private LoungePrice  loungePrice;
	private Timestamp bookTime;
	//休息室名称
	private String name;
	
	public LoungePrice getLoungePrice() {
		return loungePrice;
	}

	public void setLoungePrice(LoungePrice loungePrice) {
		this.loungePrice = loungePrice;
	}

	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置${c.getComments()}
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getLoungeId() {
		return loungeId;
	}

	/**
	 * 设置${c.getComments()}
	 * @param loungeId
	 */	
	public void setLoungeId(String loungeId) {
		this.loungeId = loungeId;
	}
	/**
	 * 获取贵宾间、贵宾厅还是两舱休息室,信息来源于sys_constant表
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置贵宾间、贵宾厅还是两舱休息室,信息来源于sys_constant表
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取只有贵宾间有房间类型，内容如：1-4人
	 * @return
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * 设置只有贵宾间有房间类型，内容如：1-4人
	 * @param roomType
	 */	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	/**
	 * 获取是否满员或不可使用
	 * @return
	 */
	public String getSts() {
		return sts;
	}

	/**
	 * 设置是否满员或不可使用
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取休息室数量
	 * @return
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * 设置休息室数量
	 * @param quantity
	 */	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取提前预定日期
	 * @return
	 */
	public Long getBookDate() {
		return bookDate;
	}

	/**
	 * 设置提前预定日期
	 * @param bookDate
	 */	
	public void setBookDate(Long bookDate) {
		this.bookDate = bookDate;
	}
	/**
	 * 获取工作开始时间
	 * @return
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * 设置工作开始时间
	 * @param startTime
	 */	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取工作结束时间
	 * @return
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * 设置工作结束时间
	 * @param endTime
	 */	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取合同有效期开始日期
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 设置合同有效期开始日期
	 * @param startDate
	 */	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取合同有效期结束日期
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 设置合同有效期结束日期
	 * @param endDate
	 */	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取退改规则
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * 设置退改规则
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 设置${c.getComments()}
	 * @param createUser
	 */	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置${c.getComments()}
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * 设置${c.getComments()}
	 * @param updateUser
	 */	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置${c.getComments()}
	 * @param updateTime
	 */	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getBookTime() {
		return bookTime;
	}

	public void setBookTime(Timestamp bookTime) {
		this.bookTime = bookTime;
	}

	public Integer getAdvanceHours() {
		return advanceHours;
	}

	public void setAdvanceHours(Integer advanceHours) {
		this.advanceHours = advanceHours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}