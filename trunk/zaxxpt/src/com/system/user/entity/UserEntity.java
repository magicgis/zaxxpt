package com.system.user.entity;

import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;
/***
 * ”√ªß¿‡
 * @author ralphone.zhuo
 *
 */
@TableMethod(TableName = "system_user")
public class UserEntity implements BaseEntity {

	@FieldMethod(IsField = true, IsPK = true, AutoKey = true)
	private String id;
	
	@FieldMethod(IsField = true)
	private String sex;
	
	@FieldMethod(IsField = true)
	private String email;
	
	@FieldMethod(IsField = true)
	private String username;
	
	@FieldMethod(IsField = true)
	private String phone;
	
	@FieldMethod(IsField = true)
	private String xm;
	
	@FieldMethod(IsField = true)
	private String zjhm;
	
	@FieldMethod(IsField = true)
	private String jh;
	
	@FieldMethod(IsField = true)
	private String bgdh;
	
	@FieldMethod(IsField = true)
	private String jtdh;
	
	@FieldMethod(IsField = true)
	private String fax;
	
	@FieldMethod(IsField = true)
	private String bgdz;
	
	@FieldMethod(IsField = true)
	private String lxdz;
	
	@FieldMethod(IsField = true)
	private String zhyxq;
	
	@FieldMethod(IsField = true)
	private String mmyxq;
	
	@FieldMethod(IsField = true)
	private String password;
	
	@FieldMethod(IsField = true)
	private String status;
	
	@FieldMethod(IsField = true)
	private String remark;
	
	@FieldMethod(IsField = true)
	private String yhjb;
	
	@FieldMethod(IsField = true)
	private String delflag;

	@FieldMethod(IsField = true)
	private String deptid;

	
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getJh() {
		return jh;
	}

	public void setJh(String jh) {
		this.jh = jh;
	}

	public String getBgdh() {
		return bgdh;
	}

	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}

	public String getJtdh() {
		return jtdh;
	}

	public void setJtdh(String jtdh) {
		this.jtdh = jtdh;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getBgdz() {
		return bgdz;
	}

	public void setBgdz(String bgdz) {
		this.bgdz = bgdz;
	}

	public String getLxdz() {
		return lxdz;
	}

	public void setLxdz(String lxdz) {
		this.lxdz = lxdz;
	}

	

	public String getZhyxq() {
		return zhyxq;
	}

	public void setZhyxq(String zhyxq) {
		this.zhyxq = zhyxq;
	}

	public String getMmyxq() {
		return mmyxq;
	}

	public void setMmyxq(String mmyxq) {
		this.mmyxq = mmyxq;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getYhjb() {
		return yhjb;
	}

	public void setYhjb(String yhjb) {
		this.yhjb = yhjb;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

}