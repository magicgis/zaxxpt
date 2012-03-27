package com.hnatourism.framework.core.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import com.hnatourism.framework.core.domain.AbstractEntity;

/**
 * 登录用户请继承该类
 * @author zhangyun
 *
 */
public class BaseUser extends AbstractEntity implements java.io.Serializable {
	//唯一标识
	private String id ;
	//用户帐号(也是唯一的，字母+数字)
	private String userCode ;
	//用户名称
	private String username ;
	//密码
	private String password ;
	//注册邮箱
	private String email;
	//手机
	private String mobile;
	//手机绑定状态
	private String mobileBinding;
	//上次登录时间
	private Date lastLoginTime;
	//账户资金
	private BigDecimal  accountAmount;
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobileBinding() {
		return mobileBinding;
	}
	public void setMobileBinding(String mobileBinding) {
		this.mobileBinding = mobileBinding;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public BigDecimal getAccountAmount() {
		return accountAmount;
	}
	public void setAccountAmount(BigDecimal accountAmount) {
		this.accountAmount = accountAmount;
	}
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}