package com.hnatourism.club.flight.web.vo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:用户信息
 * 
 * 历史版本: 2011-9-5 v1.0.0 (wuyh) 创建
 * 
 */
public class MemberVo {
	//用户Id
	private String id;
	//用户Code
	private String code;
	//Email
	private String email;
	//用户密码
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
