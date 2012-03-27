package com.hnatourism.club.base.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:用户角色关系信息
 * 
 * 历史版本:
 *					2010-07-05 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class SysRoleUser extends AbstractEntity {
	/**
	 * pk
	 */
	private String id ;
	/**
	 * ${c.getComments()}
	 */
	private String sysUserId ;
	/**
	 * ${c.getComments()}
	 */
	private String sysRoleId ;

	
	private String name;
	
	private String code;
	/**
	 * 获取pk
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置pk
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getSysUserId() {
		return sysUserId;
	}
	/**
	 * 设置${c.getComments()}
	 * @param sysUserId
	 */	
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getSysRoleId() {
		return sysRoleId;
	}
	/**
	 * 设置${c.getComments()}
	 * @param sysRoleId
	 */	
	public void setSysRoleId(String sysRoleId) {
		this.sysRoleId = sysRoleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}