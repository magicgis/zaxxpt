package com.hnatourism.club.base.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员角色关联
 * 
 * 历史版本:
 *					2010-08-23 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class SysSecuMemRole extends AbstractEntity {
	//ID
	private String id;
	//用户ID
	private String memberId ;
	//角色编码
	private String roleCode ;

	/**
	 * 获取ID
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置ID
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取用户ID
	 * @return
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置用户ID
	 * @param memberId
	 */	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取角色编码
	 * @return
	 */
	public String getRoleCode() {
		return roleCode;
	}
	/**
	 * 设置角色编码
	 * @param roleCode
	 */	
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
}