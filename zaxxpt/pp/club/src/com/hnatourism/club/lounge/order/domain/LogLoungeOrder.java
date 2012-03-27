package com.hnatourism.club.lounge.order.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场订单日志表
 * 
 * 历史版本:
 *					2011-08-15 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class LogLoungeOrder extends AbstractEntity {
	//${c.getComments()}
	private String id;
	//订单ID
	private String orderId;
	//操作内容
	private String content;
	//操作类型
	private String type;
	//添加者
	private String createUser;
	//添加时间
	private Date createTime;
	//最后修改人
	private String updateUser;
	//最后修改时间
	private Date updateTime;

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
	 * 获取订单ID
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 设置订单ID
	 * @param orderId
	 */	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取操作内容
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置操作内容
	 * @param content
	 */	
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取操作类型
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置操作类型
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取添加者
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 设置添加者
	 * @param createUser
	 */	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取添加时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置添加时间
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取最后修改人
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * 设置最后修改人
	 * @param updateUser
	 */	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取最后修改时间
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置最后修改时间
	 * @param updateTime
	 */	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}