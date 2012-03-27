package com.hnatourism.club.personal.member.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员发票表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class MemberInvoice extends AbstractEntity {
	//主键
	private String id;
	//发票TITLE
	private String title;
	//发票类型：统一开，分开开，见sys_constant
	private String type;
	//发票邮寄地址
	private String address;
	//发票备注
	private String rmk;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date updateTime;
	//${c.getComments()}
	private String updateUser;
	//如果是会员，则为会员编号/如果为企业用户，则为企业用户编号
	private String memberId;
	//0：不开，1：开
	private String sts;
	//CORP为企业
	private String userType;
	//邮寄日(每月)
	private String period;

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
	 * 获取发票TITLE
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置发票TITLE
	 * @param title
	 */	
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取发票类型：统一开，分开开，见sys_constant
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置发票类型：统一开，分开开，见sys_constant
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取发票邮寄地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置发票邮寄地址
	 * @param address
	 */	
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取发票备注
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * 设置发票备注
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
	 * 获取如果是会员，则为会员编号/如果为企业用户，则为企业用户编号
	 * @return
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 设置如果是会员，则为会员编号/如果为企业用户，则为企业用户编号
	 * @param memberId
	 */	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取0：不开，1：开
	 * @return
	 */
	public String getSts() {
		return sts;
	}

	/**
	 * 设置0：不开，1：开
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取CORP为企业
	 * @return
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 设置CORP为企业
	 * @param userType
	 */	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * 获取邮寄日(每月)
	 * @return
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * 设置邮寄日(每月)
	 * @param period
	 */	
	public void setPeriod(String period) {
		this.period = period;
	}
}