package com.hnatourism.club.golf.domain;


import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫预定时间表
 * 
 * 历史版本:
 *					2011-08-01 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfTimeMaintain extends AbstractEntity {
	//${c.getComments()}
	private String id ;
	//${c.getComments()}
	private String golfId ;
	//${c.getComments()}
	private String endTime ;
	//${c.getComments()}
	private String startTime ;
	//${c.getComments()}
	private Date createTime ;
	//${c.getComments()}
	private String createUser ;
	//${c.getComments()}
	private String updateUser ;
	//${c.getComments()}
	private Date updateTime ;

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
	public String getGolfId() {
		return golfId;
	}
	/**
	 * 设置${c.getComments()}
	 * @param golfId
	 */	
	public void setGolfId(String golfId) {
		this.golfId = golfId;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param endTime
	 */	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param startTime
	 */	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
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