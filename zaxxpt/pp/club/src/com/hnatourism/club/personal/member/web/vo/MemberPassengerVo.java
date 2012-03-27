package com.hnatourism.club.personal.member.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员常用旅客信息
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class MemberPassengerVo extends AbstractVo{
	
	//新加字段
	 // 旅客地址
	private String address;
	//旅客邮编
	private String postcode;
	/**
	 * 乘机姓名
	 */
	private String psgName;
	/**
	 * SCONTACT系统联系人，PSG常旅客,CONTACT会员联系人
	 */
	private String role;
	/**
	 * 销售联系人，财务，预定
	 */
	private String subRole;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * ID
	 */
	private String id;
	/**
	 * 会员ID
	 */
	private String memberId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 证件类型
	 */
	private String certType;
	/**
	 * 证件号码
	 */
	private String certNo;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 人员类别01成人02儿童03婴儿
	 */
	private String type;
	/**
	 * 出生年
	 */
	private String birthdateYear;
	/**
	 * 出生月
	 */
	private String birthdateMonth;
	/**
	 * 出生日
	 */
	private String birthdateDay;
	/**
	 * ${c.getComments()}
	 */
	private Date createTime;
	/**
	 * ${c.getComments()}
	 */
	private String createUser;
	/**
	 * ${c.getComments()}
	 */
	private Date updateTime;
	/**
	 * ${c.getComments()}
	 */
	private String updateUser;
	/**
	 * 备注
	 */
	private String disc;
	/**
	 * 汉语拼写
	 */
	private String nameSpell;
	/**
	 * 国籍
	 */
	private String country;
	/**
	 * 证件有效期
	 */
	private Date certValidateDate;

	/**
	 * 获取乘机姓名
	 * @return
	 */
	public String getPsgName() {
		return psgName;
	}

	/**
	 * 设置乘机姓名
	 * @param psgName
	 */	
	public void setPsgName(String psgName) {
		this.psgName = psgName;
	}
	/**
	 * 获取SCONTACT系统联系人，PSG常旅客,CONTACT会员联系人
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * 设置SCONTACT系统联系人，PSG常旅客,CONTACT会员联系人
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
	 * 获取证件类型
	 * @return
	 */
	public String getCertType() {
		return certType;
	}

	/**
	 * 设置证件类型
	 * @param certType
	 */	
	public void setCertType(String certType) {
		this.certType = certType;
	}
	/**
	 * 获取证件号码
	 * @return
	 */
	public String getCertNo() {
		return certNo;
	}

	/**
	 * 设置证件号码
	 * @param certNo
	 */	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
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
	 * 获取人员类别01成人02儿童03婴儿
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置人员类别01成人02儿童03婴儿
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取出生年
	 * @return
	 */
	public String getBirthdateYear() {
		return birthdateYear;
	}

	/**
	 * 设置出生年
	 * @param birthdateYear
	 */	
	public void setBirthdateYear(String birthdateYear) {
		this.birthdateYear = birthdateYear;
	}
	/**
	 * 获取出生月
	 * @return
	 */
	public String getBirthdateMonth() {
		return birthdateMonth;
	}

	/**
	 * 设置出生月
	 * @param birthdateMonth
	 */	
	public void setBirthdateMonth(String birthdateMonth) {
		this.birthdateMonth = birthdateMonth;
	}
	/**
	 * 获取出生日
	 * @return
	 */
	public String getBirthdateDay() {
		return birthdateDay;
	}

	/**
	 * 设置出生日
	 * @param birthdateDay
	 */	
	public void setBirthdateDay(String birthdateDay) {
		this.birthdateDay = birthdateDay;
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
	 * 获取备注
	 * @return
	 */
	public String getDisc() {
		return disc;
	}

	/**
	 * 设置备注
	 * @param disc
	 */	
	public void setDisc(String disc) {
		this.disc = disc;
	}
	/**
	 * 获取汉语拼写
	 * @return
	 */
	public String getNameSpell() {
		return nameSpell;
	}

	/**
	 * 设置汉语拼写
	 * @param nameSpell
	 */	
	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}
	/**
	 * 获取国籍
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 设置国籍
	 * @param country
	 */	
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取证件有效期
	 * @return
	 */
	public Date getCertValidateDate() {
		return certValidateDate;
	}

	/**
	 * 设置证件有效期
	 * @param certValidateDate
	 */	
	public void setCertValidateDate(Date certValidateDate) {
		this.certValidateDate = certValidateDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}