package com.hnatourism.club.common.domain;



import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:联系人表
 * 
 * 历史版本:
 *					2011-08-12 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class SysContact extends AbstractEntity {
	//ID
	private String id ;
	//如果是会员联系人为MEMBER_ID（会员ID）/如果是产品联系人为产品编号/如果是系统联系人则为系统用户编号
	private String scope ;
	//姓名
	private String name ;
	//备注
	private String rmk ;
	//手机
	private String mobile ;
	//邮箱
	private String email ;
	//电话
	private String phone ;
	//性别
	private String sex ;
	//${c.getComments()}
	private Date createTime ;
	//${c.getComments()}
	private String createUser ;
	//${c.getComments()}
	private Date updateTime ;
	//${c.getComments()}
	private String updateUser ;
	//SCONTACT系统联系人,CONTACT会员联系人,LCONTACT机场产品联系人,GCONTACT高尔夫产品联系人
	private String role ;
	//销售联系人，财务，预定
	private String subRole ;
	//传真
	private String fax ;

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
	 * 获取如果是会员联系人为MEMBER_ID（会员ID）/如果是产品联系人为产品编号/如果是系统联系人则为系统用户编号
	 * @return
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * 设置如果是会员联系人为MEMBER_ID（会员ID）/如果是产品联系人为产品编号/如果是系统联系人则为系统用户编号
	 * @param scope
	 */	
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * 获取姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置姓名
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
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
	 * 获取手机
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置手机
	 * @param mobile
	 */	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取邮箱
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置邮箱
	 * @param email
	 */	
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取电话
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置电话
	 * @param phone
	 */	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取性别
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置性别
	 * @param sex
	 */	
	public void setSex(String sex) {
		this.sex = sex;
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
	 * 获取SCONTACT系统联系人,CONTACT会员联系人,LCONTACT机场产品联系人,GCONTACT高尔夫产品联系人
	 * @return
	 */
	public String getRole() {
		return role;
	}
	/**
	 * 设置SCONTACT系统联系人,CONTACT会员联系人,LCONTACT机场产品联系人,GCONTACT高尔夫产品联系人
	 * @param role
	 */	
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 获取销售联系人，财务，预定
	 * @return
	 */
	public String getSubRole() {
		return subRole;
	}
	/**
	 * 设置销售联系人，财务，预定
	 * @param subRole
	 */	
	public void setSubRole(String subRole) {
		this.subRole = subRole;
	}
	/**
	 * 获取传真
	 * @return
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 设置传真
	 * @param fax
	 */	
	public void setFax(String fax) {
		this.fax = fax;
	}
}