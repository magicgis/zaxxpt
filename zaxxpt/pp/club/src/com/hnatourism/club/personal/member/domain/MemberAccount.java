package com.hnatourism.club.personal.member.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员账户表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class MemberAccount extends AbstractEntity {
	//${c.getComments()}
	private String id;
	//USER_TYPE为CORP，则为企业编号，否则为会员编号
	private String memberId;
	//汇付账号
	private String account;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String createUser;
	//CORP公司
	private String userType;
	//卡号
	private String cardNo;
	//入会费
	private Long fee;
	//账户角色，见member_role表
	private String role;
	private String organizationId;

	private String privilegeType;
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
	 * 获取USER_TYPE为CORP，则为企业编号，否则为会员编号
	 * @return
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 设置USER_TYPE为CORP，则为企业编号，否则为会员编号
	 * @param memberId
	 */	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取汇付账号
	 * @return
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 设置汇付账号
	 * @param account
	 */	
	public void setAccount(String account) {
		this.account = account;
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
	 * 获取CORP公司
	 * @return
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 设置CORP公司
	 * @param userType
	 */	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * 获取卡号
	 * @return
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * 设置卡号
	 * @param cardNo
	 */	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * 获取入会费
	 * @return
	 */
	public Long getFee() {
		return fee;
	}

	/**
	 * 设置入会费
	 * @param fee
	 */	
	public void setFee(Long fee) {
		this.fee = fee;
	}
	/**
	 * 获取账户角色，见member_role表
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * 设置账户角色，见member_role表
	 * @param role
	 */	
	public void setRole(String role) {
		this.role = role;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(String privilegeType) {
		this.privilegeType = privilegeType;
	}
}