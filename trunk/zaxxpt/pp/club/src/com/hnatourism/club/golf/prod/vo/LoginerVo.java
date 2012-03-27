package com.hnatourism.club.golf.prod.vo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫预订页面显示登陆者信息vo
 * 
 * 历史版本:2011-08-03 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class LoginerVo
{
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 联系方式
	 */
	private String contact;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
