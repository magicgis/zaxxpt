package com.hnatourism.club.flight.MemberInfo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员信息
 * 
 * 历史版本: 2010-07-02 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class MemberInfoVo {
	/**
	 * ID
	 */
	private String id;
	/**
	 * 会员编号
	 */
	private String code;
	/**
	 * 注册邮箱
	 */
	private String email;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 确认密码
	 */
	private String passwordConfirm;
	/**
	 * 旧密码
	 */
	private String oldPassword;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 出生日期年
	 */
	private String birthdateYear;
	/**
	 * 出生日期月
	 */
	private String birthdateMonth;
	/**
	 * 出生日期日
	 */
	private String birthdateDay;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 邮箱验证
	 */
	private String emailChecking;
	/**
	 * 手机绑定
	 */
	private String mobileBinding;
	/**
	 * 注册时间
	 */
	private Date registrationDate;
	/**
	 * 状态:01正常02锁定
	 */
	private String status;
	/**
	 * 上次登录时间
	 */
	private Date lastLoginTime;
	
	//验证码
	private String verifyCode;
	//Session验证码
	private String verifyCodeSession;
	
	//登录帐号
	private String account;
	
	//帐号类型01网站用户 02 金鹏卡 03易生卡
	private String accountType;
	
	//是否记住密码
	private String rememberPSW;
    
	//创建时间
	private Date createTime;
	
	//创建人
	private String createUser;
	
	//修改时间
	private Date updateTime;
	
	//修改人
	private String updateUser;
	
	//网站授权
	private String authSePr;
	
	//用户来源
	private String source;
	
	//来源汉字名
	private String rootSource;
	
	// 连续登陆次数
	private String loginNum;
	// 活动状态
	private String activeSts;
	//是否是用户自动生成用户
	private String isFirst;
	
	
	
	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	/**
	 * @return the loginNum
	 */
	public String getLoginNum() {
		return loginNum;
	}

	/**
	 * @param loginNum the loginNum to set
	 */
	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}

	/**
	 * @return the activeSts
	 */
	public String getActiveSts() {
		return activeSts;
	}

	/**
	 * @param activeSts the activeSts to set
	 */
	public void setActiveSts(String activeSts) {
		this.activeSts = activeSts;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取会员编号
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置会员编号
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取注册邮箱
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置注册邮箱
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * 获取出生日期
	 * 
	 * @return
	 */
	public String getBirthdateYear() {
		return birthdateYear;
	}

	/**
	 * 设置出生日期
	 * 
	 * @param birthdateYear
	 */
	public void setBirthdateYear(String birthdateYear) {
		this.birthdateYear = birthdateYear;
	}

	/**
	 * 获取出生日期月
	 * 
	 * @return
	 */
	public String getBirthdateMonth() {
		return birthdateMonth;
	}

	/**
	 * 设置出生日期月
	 * 
	 * @param birthdateMonth
	 */
	public void setBirthdateMonth(String birthdateMonth) {
		this.birthdateMonth = birthdateMonth;
	}

	/**
	 * 获取出生日期日
	 * 
	 * @return
	 */
	public String getBirthdateDay() {
		return birthdateDay;
	}

	/**
	 * 设置出生日期日
	 * 
	 * @param birthdateDay
	 */
	public void setBirthdateDay(String birthdateDay) {
		this.birthdateDay = birthdateDay;
	}

	/**
	 * 获取联系电话
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置联系电话
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取手机号码
	 * 
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置手机号码
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取详细地址
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置详细地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取邮箱验证
	 * 
	 * @return
	 */
	public String getEmailChecking() {
		return emailChecking;
	}

	/**
	 * 设置邮箱验证
	 * 
	 * @param emailChecking
	 */
	public void setEmailChecking(String emailChecking) {
		this.emailChecking = emailChecking;
	}

	/**
	 * 获取手机绑定
	 * 
	 * @return
	 */
	public String getMobileBinding() {
		return mobileBinding;
	}

	/**
	 * 设置手机绑定
	 * 
	 * @param mobileBinding
	 */
	public void setMobileBinding(String mobileBinding) {
		this.mobileBinding = mobileBinding;
	}

	/**
	 * 获取注册时间
	 * 
	 * @return
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * 设置注册时间
	 * 
	 * @param registrationDate
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * 获取状态:01正常02锁定
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置状态:01正常02锁定
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取上次登录时间
	 * 
	 * @return
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 设置上次登录时间
	 * 
	 * @param lastLoginTime
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the verifyCode
	 */
	public String getVerifyCode() {
		return verifyCode;
	}

	/**
	 * @param verifyCode the verifyCode to set
	 */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the rememberPSW
	 */
	public String getRememberPSW() {
		return rememberPSW;
	}

	/**
	 * @param rememberPSW the rememberPSW to set
	 */
	public void setRememberPSW(String rememberPSW) {
		this.rememberPSW = rememberPSW;
	}

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
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

	public String getAuthSePr() {
		return authSePr;
	}

	public void setAuthSePr(String authSePr) {
		this.authSePr = authSePr;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getVerifyCodeSession() {
		return verifyCodeSession;
	}

	public void setVerifyCodeSession(String verifyCodeSession) {
		this.verifyCodeSession = verifyCodeSession;
	}

	public String getRootSource() {
		return rootSource;
	}

	public void setRootSource(String rootSource) {
		this.rootSource = rootSource;
	}
	
	
}