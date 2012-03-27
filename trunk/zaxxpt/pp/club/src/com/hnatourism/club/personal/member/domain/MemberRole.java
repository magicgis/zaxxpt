package com.hnatourism.club.personal.member.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员角色表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class MemberRole extends AbstractEntity {
	//主键
	private String id;
	//角色编码
	private String code;
	//角色名称
	private String name;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private String sts;

	/**
	 * 获取主键
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置主键
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取角色编码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置角色编码
	 * @param code
	 */	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取角色名称
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置角色名称
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
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
}