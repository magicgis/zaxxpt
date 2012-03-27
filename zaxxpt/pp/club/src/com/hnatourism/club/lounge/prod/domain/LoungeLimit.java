package com.hnatourism.club.lounge.prod.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室不预定时间维护
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class LoungeLimit extends AbstractEntity {
	//${c.getComments()}
	private String id;
	//${c.getComments()}
	private String loungeId;
	//${c.getComments()}
	private Long type;
	//${c.getComments()}
	private Date startTime;
	//${c.getComments()}
	private Date endTime;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String updateUser;
	//${c.getComments()}
	private Date updateTime;
	private String roomId;

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
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
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getType() {
		return type;
	}

	/**
	 * 设置${c.getComments()}
	 * @param type
	 */	
	public void setType(Long type) {
		this.type = type;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 设置${c.getComments()}
	 * @param startTime
	 */	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 设置${c.getComments()}
	 * @param endTime
	 */	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
}