package com.sunshine.framework.entity;


/***
 *@author wenz
 *@Date 2012-3-27ÏÂÎç02:00:43
 *@version 1.0
 ***/
public class SystemUsersInfo extends BaseDomain {

	// Fields

	private SystemUsers systemUsers;
	private String name;
	private String organise;
	private String position;
	private String policamanCode;
	private String sex;
	private String idCard;
	private String birthday;
	private String email;
	private int mobile;
	private String familyPhone;
	private String familyAddress;
	private String officePhone;
	private String officeAddress;
	private String fax;
	private String remark;

	// Constructors

	/** default constructor */
	public SystemUsersInfo() {
	}

	/** minimal constructor */
	public SystemUsersInfo(String id, String name, String organise, String sex) {
		super(id);
		this.name = name;
		this.organise = organise;
		this.sex = sex;
	}

	/** full constructor */
	public SystemUsersInfo(String id, SystemUsers systemUsers, String name,
			String organise, String position, String policamanCode, String sex,
			String idCard, String birthday, String email, int mobile,
			String familyPhone, String familyAddress, String officePhone,
			String officeAddress, String fax, String remark) {
		super(id);
		this.systemUsers = systemUsers;
		this.name = name;
		this.organise = organise;
		this.position = position;
		this.policamanCode = policamanCode;
		this.sex = sex;
		this.idCard = idCard;
		this.birthday = birthday;
		this.email = email;
		this.mobile = mobile;
		this.familyPhone = familyPhone;
		this.familyAddress = familyAddress;
		this.officePhone = officePhone;
		this.officeAddress = officeAddress;
		this.fax = fax;
		this.remark = remark;
	}

	// Property accessors


	public SystemUsers getSystemUsers() {
		return this.systemUsers;
	}

	public void setSystemUsers(SystemUsers systemUsers) {
		this.systemUsers = systemUsers;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganise() {
		return this.organise;
	}

	public void setOrganise(String organise) {
		this.organise = organise;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPolicamanCode() {
		return this.policamanCode;
	}

	public void setPolicamanCode(String policamanCode) {
		this.policamanCode = policamanCode;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return this.mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getFamilyPhone() {
		return this.familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getFamilyAddress() {
		return this.familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficeAddress() {
		return this.officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}