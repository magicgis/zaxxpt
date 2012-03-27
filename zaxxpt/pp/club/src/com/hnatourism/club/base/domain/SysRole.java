package com.hnatourism.club.base.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:用户角色信息
 * 
 * 历史版本: 2010-07-07 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class SysRole extends AbstractEntity {
	/**
	 * pk
	 */
	private String id;
	/**
	 * 角色名称（也是唯一的）
	 */
	private String name;
	/**
	 * 角色的英文名
	 */
	private String code;
	/**
	 * 备注
	 */
	private String rmk;
	/**
	 * 状态：0(禁用)1(启用)
	 */
	private Long sts;

	/**
	 * 获取pk
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置pk
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取角色名称（也是唯一的）
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置角色名称（也是唯一的）
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取角色的英文名
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置角色的英文名
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取备注
	 * 
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * 设置备注
	 * 
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取状态：0(禁用)1(启用)
	 * 
	 * @return
	 */
	public Long getSts() {
		return sts;
	}
	/**
	 * 设置状态：0(禁用)1(启用)
	 * 
	 * @param sts
	 */
	public void setSts(Long sts) {
		this.sts = sts;
	}
}