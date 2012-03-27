package com.hnatourism.club.flight.passenger;

import java.util.Date;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员常用旅客信息
 * 
 * 历史版本: 2010-07-02 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class MemberPassengerVo extends AbstractVo {
	/**
	 * ID
	 */
	private String id;
	/**
	 * 会员ID
	 */
	private String memberId;
	/**
	 * 会员Code
	 */
	private String memberCode;
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
	 * 去程保险分数
	 */
	private String goInsuranceNum;
	/**
	 * 返程保险分数
	 */
	private String returnInsuranceNum;
	//备注
	private String disc;
	//创建时间
	private Date createTime;
	//创建人
	private String createUser;
	//修改时间
	private Date updateTime;
	//修改人
	private String updateUser;
	//汉语拼音
	private String nameSpell;
	/**
	 * @return the nameSpell
	 */
	public String getNameSpell() {
		return nameSpell;
	}
	/**
	 * @param nameSpell the nameSpell to set
	 */
	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * @return the disc
	 */
	public String getDisc() {
		return disc;
	}
	/**
	 * @param disc the disc to set
	 */
	public void setDisc(String disc) {
		this.disc = disc;
	}
	/**
	 * 获取ID
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置ID
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取会员ID
	 * 
	 * @return
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置会员ID
	 * 
	 * @param memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取姓名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置姓名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取证件类型
	 * 
	 * @return
	 */
	public String getCertType() {
		return certType;
	}
	/**
	 * 设置证件类型
	 * 
	 * @param certType
	 */
	public void setCertType(String certType) {
		this.certType = certType;
	}
	/**
	 * 获取证件号码
	 * 
	 * @return
	 */
	public String getCertNo() {
		return certNo;
	}
	/**
	 * 设置证件号码
	 * 
	 * @param certNo
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	/**
	 * 获取手机
	 * 
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置手机
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取邮箱
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置邮箱
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取电话
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置电话
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取性别
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置性别
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取人员类别01成人02儿童03婴儿
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置人员类别01成人02儿童03婴儿
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取出生年
	 * 
	 * @return
	 */
	public String getBirthdateYear() {
		return birthdateYear;
	}
	/**
	 * 设置出生年
	 * 
	 * @param birthdateYear
	 */
	public void setBirthdateYear(String birthdateYear) {
		this.birthdateYear = birthdateYear;
	}
	/**
	 * 获取出生月
	 * 
	 * @return
	 */
	public String getBirthdateMonth() {
		return birthdateMonth;
	}
	/**
	 * 设置出生月
	 * 
	 * @param birthdateMonth
	 */
	public void setBirthdateMonth(String birthdateMonth) {
		this.birthdateMonth = birthdateMonth;
	}
	/**
	 * 获取出生日
	 * 
	 * @return
	 */
	public String getBirthdateDay() {
		return birthdateDay;
	}
	/**
	 * 设置出生日
	 * 
	 * @param birthdateDay
	 */
	public void setBirthdateDay(String birthdateDay) {
		this.birthdateDay = birthdateDay;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getGoInsuranceNum() {
		return goInsuranceNum;
	}
	public void setGoInsuranceNum(String goInsuranceNum) {
		this.goInsuranceNum = goInsuranceNum;
	}
	public String getReturnInsuranceNum() {
		return returnInsuranceNum;
	}
	public void setReturnInsuranceNum(String returnInsuranceNum) {
		this.returnInsuranceNum = returnInsuranceNum;
	}
}