package com.hnatourism.club.common.domain;


import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:用户所属组织机构表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class SysOrganizationUser extends AbstractEntity {
	//${c.getComments()}
	private String id;
	//组织机构编码
	private String organizationId;
	//用户编码
	private String userId;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date createTime;

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
	 * 获取组织机构编码
	 * @return
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	/**
	 * 设置组织机构编码
	 * @param organizationId
	 */	
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * 获取用户编码
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置用户编码
	 * @param userId
	 */	
	public void setUserId(String userId) {
		this.userId = userId;
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
}
