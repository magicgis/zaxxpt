package com.hnatourism.club.personal.member.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员信息
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class MemberInfo extends AbstractEntity {
	//ID
	private String id;
	//会员编号
	private String code;
	//注册邮箱
	private String email;
	//密码
	private String password;
	//姓名
	private String name;
	//性别
	private String sex;
	//出生日期年
	private String birthdateYear;
	//出生日期月
	private String birthdateMonth;
	//出生日期日
	private String birthdateDay;
	//联系电话
	private String phone;
	//手机号码
	private String mobile;
	//详细地址
	private String address;
	//邮箱验证
	private String emailChecking;
	//手机绑定
	private String mobileBinding;
	//注册时间
	private Date registrationDate;
	//状态:01正常02锁定
	private String status;
	//上次登录时间
	private Date lastLoginTime;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date updateTime;
	//${c.getComments()}
	private String updateUser;
	//光大：100011743农商行：NSHBANK富滇：FDBANK 网站：B2C
	private String source;
	//用户根源
	private String rootSource;
	//${c.getComments()}
	private Long loginNum;
	//${c.getComments()}
	private String activeSts;
	//是否直接预订的系统自动生成用户 ：1（为系统生成）
	private String isFirst;
	//公司
	private String crop;
	//集团
	private String bloc;
	//工作地址
	private String workAddr;
	//工作编号
	private String employeeCard;

	//证件类型
	private String certType;
	
	//证件号
	private String certNo;
	

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
	 * 获取会员编号
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置会员编号
	 * @param code
	 */	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取注册邮箱
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置注册邮箱
	 * @param email
	 */	
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * @param password
	 */	
	public void setPassword(String password) {
		this.password = password;
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
	 * 获取出生日期年
	 * @return
	 */
	public String getBirthdateYear() {
		return birthdateYear;
	}

	/**
	 * 设置出生日期年
	 * @param birthdateYear
	 */	
	public void setBirthdateYear(String birthdateYear) {
		this.birthdateYear = birthdateYear;
	}
	/**
	 * 获取出生日期月
	 * @return
	 */
	public String getBirthdateMonth() {
		return birthdateMonth;
	}

	/**
	 * 设置出生日期月
	 * @param birthdateMonth
	 */	
	public void setBirthdateMonth(String birthdateMonth) {
		this.birthdateMonth = birthdateMonth;
	}
	/**
	 * 获取出生日期日
	 * @return
	 */
	public String getBirthdateDay() {
		return birthdateDay;
	}

	/**
	 * 设置出生日期日
	 * @param birthdateDay
	 */	
	public void setBirthdateDay(String birthdateDay) {
		this.birthdateDay = birthdateDay;
	}
	/**
	 * 获取联系电话
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置联系电话
	 * @param phone
	 */	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取手机号码
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置手机号码
	 * @param mobile
	 */	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取详细地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置详细地址
	 * @param address
	 */	
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取邮箱验证
	 * @return
	 */
	public String getEmailChecking() {
		return emailChecking;
	}

	/**
	 * 设置邮箱验证
	 * @param emailChecking
	 */	
	public void setEmailChecking(String emailChecking) {
		this.emailChecking = emailChecking;
	}
	/**
	 * 获取手机绑定
	 * @return
	 */
	public String getMobileBinding() {
		return mobileBinding;
	}

	/**
	 * 设置手机绑定
	 * @param mobileBinding
	 */	
	public void setMobileBinding(String mobileBinding) {
		this.mobileBinding = mobileBinding;
	}
	/**
	 * 获取注册时间
	 * @return
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * 设置注册时间
	 * @param registrationDate
	 */	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	/**
	 * 获取状态:01正常02锁定
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置状态:01正常02锁定
	 * @param status
	 */	
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取上次登录时间
	 * @return
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 设置上次登录时间
	 * @param lastLoginTime
	 */	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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
	 * 获取光大：100011743农商行：NSHBANK富滇：FDBANK 网站：B2C
	 * @return
	 */
	public String getSource() {
		return source;
	}

	/**
	 * 设置光大：100011743农商行：NSHBANK富滇：FDBANK 网站：B2C
	 * @param source
	 */	
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取用户根源
	 * @return
	 */
	public String getRootSource() {
		return rootSource;
	}

	/**
	 * 设置用户根源
	 * @param rootSource
	 */	
	public void setRootSource(String rootSource) {
		this.rootSource = rootSource;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getLoginNum() {
		return loginNum;
	}

	/**
	 * 设置${c.getComments()}
	 * @param loginNum
	 */	
	public void setLoginNum(Long loginNum) {
		this.loginNum = loginNum;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getActiveSts() {
		return activeSts;
	}

	/**
	 * 设置${c.getComments()}
	 * @param activeSts
	 */	
	public void setActiveSts(String activeSts) {
		this.activeSts = activeSts;
	}
	/**
	 * 获取是否直接预订的系统自动生成用户 ：1（为系统生成）
	 * @return
	 */
	public String getIsFirst() {
		return isFirst;
	}

	/**
	 * 设置是否直接预订的系统自动生成用户 ：1（为系统生成）
	 * @param isFirst
	 */	
	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}
	/**
	 * 获取公司
	 * @return
	 */
	public String getCrop() {
		return crop;
	}

	/**
	 * 设置公司
	 * @param crop
	 */	
	public void setCrop(String crop) {
		this.crop = crop;
	}
	/**
	 * 获取集团
	 * @return
	 */
	public String getBloc() {
		return bloc;
	}

	/**
	 * 设置集团
	 * @param bloc
	 */	
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}
	/**
	 * 获取工作地址
	 * @return
	 */
	public String getWorkAddr() {
		return workAddr;
	}

	/**
	 * 设置工作地址
	 * @param workAddr
	 */	
	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
	}
	/**
	 * 获取工作编号
	 * @return
	 */
	public String getEmployeeCard() {
		return employeeCard;
	}

	/**
	 * 设置工作编号
	 * @param employeeCard
	 */	
	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}
	
	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
}