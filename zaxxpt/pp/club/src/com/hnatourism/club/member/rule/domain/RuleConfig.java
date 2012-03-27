package com.hnatourism.club.member.rule.domain;

import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:规则配置表
 * 
 * 历史版本:
 *					2011-08-23 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class RuleConfig extends AbstractEntity {
	//状态（0禁用 1启用）
	private String sts ;
	//有效截止日期
	private Date endTime ;
	//有效开始日期
	private Date startTime ;
	//${c.getComments()}
	private String id ;
	//MEMBER会员规则PROFIT分润规则
	private String type ;
	//名称
	private String name ;
	//CODE码
	private String code ;
	//值
	private String value ;
	//备注
	private String rmk ;
	//创建人
	private String createUser ;
	//有效截止日期
	private Date createTime ;
	//更新人
	private String updateUser ;
	//更新时间
	private Date updateTime ;

	/**
	 * 获取状态（0禁用 1启用）
	 * @return
	 */
	public String getSts() {
		return sts;
	}
	/**
	 * 设置状态（0禁用 1启用）
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取有效截止日期
	 * @return
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置有效截止日期
	 * @param endTime
	 */	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取有效开始日期
	 * @return
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置有效开始日期
	 * @param startTime
	 */	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
	 * 获取MEMBER会员规则PROFIT分润规则
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置MEMBER会员规则PROFIT分润规则
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置名称
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取CODE码
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置CODE码
	 * @param code
	 */	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取值
	 * @return
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置值
	 * @param value
	 */	
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取备注
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * 设置备注
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取创建人
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置创建人
	 * @param createUser
	 */	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取有效截止日期
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置有效截止日期
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取更新人
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置更新人
	 * @param updateUser
	 */	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取更新时间
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置更新时间
	 * @param updateTime
	 */	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}