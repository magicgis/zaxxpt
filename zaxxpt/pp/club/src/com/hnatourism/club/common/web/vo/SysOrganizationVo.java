package com.hnatourism.club.common.web.vo;

import com.hnatourism.club.golf.prod.vo.HnaProCityVo;
import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:组织机构表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class SysOrganizationVo extends AbstractVo{
	/**
	 * ${c.getComments()}
	 */
	private String id;
	/**
	 * 组织机构全称
	 */
	private String lName;
	/**
	 * 组织机构编码
	 */
	private String code;
	/**
	 * 组织机构名称
	 */
	private String name;
	/**
	 * 区域
	 */
	private String area;
	/**
	 * 状态0未激活1未激活
	 */
	private String sts;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * ${c.getComments()}
	 */
	private String createUser;
	/**
	 * ${c.getComments()}
	 */
	private Date createTime;
	/**
	 * ${c.getComments()}
	 */
	private String updateUser;
	/**
	 * ${c.getComments()}
	 */
	private Date updateTime;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 电邮
	 */
	private String email;
	/**
	 * 组织机构角色类型：分销/供应，见sys_role
	 */
	private String roleType;
	/**
	 * 产品类型
	 */
	private String prodType;
	/**
	 * 组织机构类型：集团/公司/分公司/部门
	 */
	private String type;
	/**
	 * 组织机构营业执照编号
	 */
	private String businessLicenceNo;
	/**
	 * 组织机构代码证编号
	 */
	private String organizationNo;
	/**
	 * 税务登记编号
	 */
	private String taxRegistrationNo;
	/**
	 * 注册资金
	 */
	private Long registeredCapital;
	//只做前台显示使用（勿删）-------------------------begin---------------------------------
	
	/**
	 * 上级单位superiorName 来自sys_organization_ralation表
	 */
	private String superiorName;
	/**
	 * 上级单位superiorName 来自sys_organization_ralation通过user_id去关联sys_user表
	 */
	private String userName;
	
	
	/**
	 * 联系人表ID		来自 sys_contact   id
	 */
	private String contactId;
	
	/**
	 * 组织机构联系人      来自 sys_contact   name
	 */
	private String contactName;
	/**
	 * 组织机构电话	      来自 sys_contact   phone
	 */
	private String contactPhone;
	
	
	/**
	 * 联系人表ID		来自 sys_user   id
	 */
	private String sysUserId;
	
	/**
	 * 组织机构系统用户名。	来自SYS_USER	    code
	 */
	private String sysUserName;
	/**
	 * 组织机构系统用户密码1
	 */
	private String password1;
	/**
	 *  组织机构系统用户密码2
	 */
	private String password2;
	//城市（省份）
	private HnaProCityVo cityVo;
	
	//只做前台显示使用（勿删）--------------------------end----------------------------------
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
	 * 获取组织机构全称
	 * @return
	 */
	public String getLName() {
		return lName;
	}

	/**
	 * 设置组织机构全称
	 * @param lName
	 */	
	public void setLName(String lName) {
		this.lName = lName;
	}
	/**
	 * 获取组织机构编码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置组织机构编码
	 * @param code
	 */	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取组织机构名称
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置组织机构名称
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取区域
	 * @return
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 设置区域
	 * @param area
	 */	
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取状态0未激活1未激活
	 * @return
	 */
	public String getSts() {
		return sts;
	}

	/**
	 * 设置状态0未激活1未激活
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置地址
	 * @param address
	 */	
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取邮编
	 * @return
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * 设置邮编
	 * @param zipCode
	 */	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	 * 获取电邮
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置电邮
	 * @param email
	 */	
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取组织机构角色类型：分销/供应，见sys_role
	 * @return
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * 设置组织机构角色类型：分销/供应，见sys_role
	 * @param roleType
	 */	
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	/**
	 * 获取产品类型
	 * @return
	 */
	public String getProdType() {
		return prodType;
	}

	/**
	 * 设置产品类型
	 * @param prodType
	 */	
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	/**
	 * 获取组织机构类型：集团/公司/分公司/部门
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置组织机构类型：集团/公司/分公司/部门
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取组织机构营业执照编号
	 * @return
	 */
	public String getBusinessLicenceNo() {
		return businessLicenceNo;
	}

	/**
	 * 设置组织机构营业执照编号
	 * @param businessLicenceNo
	 */	
	public void setBusinessLicenceNo(String businessLicenceNo) {
		this.businessLicenceNo = businessLicenceNo;
	}
	/**
	 * 获取组织机构代码证编号
	 * @return
	 */
	public String getOrganizationNo() {
		return organizationNo;
	}

	/**
	 * 设置组织机构代码证编号
	 * @param organizationNo
	 */	
	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}
	/**
	 * 获取税务登记编号
	 * @return
	 */
	public String getTaxRegistrationNo() {
		return taxRegistrationNo;
	}

	/**
	 * 设置税务登记编号
	 * @param taxRegistrationNo
	 */	
	public void setTaxRegistrationNo(String taxRegistrationNo) {
		this.taxRegistrationNo = taxRegistrationNo;
	}
	/**
	 * 获取注册资金
	 * @return
	 */
	public Long getRegisteredCapital() {
		return registeredCapital;
	}

	/**
	 * 设置注册资金
	 * @param registeredCapital
	 */	
	public void setRegisteredCapital(Long registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String getSuperiorName() {
		return superiorName;
	}

	public void setSuperiorName(String superiorName) {
		this.superiorName = superiorName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}

	public HnaProCityVo getCityVo() {
		return cityVo;
	}

	public void setCityVo(HnaProCityVo cityVo) {
		this.cityVo = cityVo;
	}
}