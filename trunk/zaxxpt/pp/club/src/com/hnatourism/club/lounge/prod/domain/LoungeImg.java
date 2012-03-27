package com.hnatourism.club.lounge.prod.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室产品图片表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class LoungeImg extends AbstractEntity {
	//${c.getComments()}
	private String id;
	//${c.getComments()}
	private String loungeId;
	//${c.getComments()}
	private String type;
	//${c.getComments()}
	private String name;
	//${c.getComments()}
	private String path;
	//${c.getComments()}
	private String sts;
	//${c.getComments()}
	private String rmk;
	//${c.getComments()}
	private String seq;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String updateUser;
	//${c.getComments()}
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
	public String getType() {
		return type;
	}

	/**
	 * 设置${c.getComments()}
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置${c.getComments()}
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 设置${c.getComments()}
	 * @param path
	 */	
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getSts() {
		return sts;
	}

	/**
	 * 设置${c.getComments()}
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * 设置${c.getComments()}
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * 设置${c.getComments()}
	 * @param seq
	 */	
	public void setSeq(String seq) {
		this.seq = seq;
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