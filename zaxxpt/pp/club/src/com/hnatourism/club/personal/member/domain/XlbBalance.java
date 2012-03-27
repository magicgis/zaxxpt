package com.hnatourism.club.personal.member.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:金币账户信息
 * 
 * 历史版本:
 *					2010-07-16 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class XlbBalance extends AbstractEntity {
	//ID
	private String id ;
	//会员ID
	private String memberId ;
	//币值
	private BigDecimal amount ;
	//邀请码
	private String inviteNo ;
	//状态
	private String status ;
	//创建时间
	private Date createTime ;
	//创建人
	private String createUser ;
	//更新时间
	private Date updateTime ;
	//更新人
	private String updateUser ;
	//备用字段1
	private String filed1 ;
	//备用字段2
	private String filed2 ;
	//备用字段3
	private String filed3 ;
	//备用字段4
	private String filed4 ;
	//备用字段5
	private String filed5 ;

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
	 * 获取会员ID
	 * @return
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置会员ID
	 * @param memberId
	 */	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取币值
	 * @return
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置币值
	 * @param amount
	 */	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取邀请码
	 * @return
	 */
	public String getInviteNo() {
		return inviteNo;
	}
	/**
	 * 设置邀请码
	 * @param inviteNo
	 */	
	public void setInviteNo(String inviteNo) {
		this.inviteNo = inviteNo;
	}
	/**
	 * 获取状态
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置状态
	 * @param status
	 */	
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置创建时间
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	 * 获取备用字段1
	 * @return
	 */
	public String getFiled1() {
		return filed1;
	}
	/**
	 * 设置备用字段1
	 * @param filed1
	 */	
	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}
	/**
	 * 获取备用字段2
	 * @return
	 */
	public String getFiled2() {
		return filed2;
	}
	/**
	 * 设置备用字段2
	 * @param filed2
	 */	
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}
	/**
	 * 获取备用字段3
	 * @return
	 */
	public String getFiled3() {
		return filed3;
	}
	/**
	 * 设置备用字段3
	 * @param filed3
	 */	
	public void setFiled3(String filed3) {
		this.filed3 = filed3;
	}
	/**
	 * 获取备用字段4
	 * @return
	 */
	public String getFiled4() {
		return filed4;
	}
	/**
	 * 设置备用字段4
	 * @param filed4
	 */	
	public void setFiled4(String filed4) {
		this.filed4 = filed4;
	}
	/**
	 * 获取备用字段5
	 * @return
	 */
	public String getFiled5() {
		return filed5;
	}
	/**
	 * 设置备用字段5
	 * @param filed5
	 */	
	public void setFiled5(String filed5) {
		this.filed5 = filed5;
	}
}