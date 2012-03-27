package com.hnatourism.club.hotel.order.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:订单联系人
 * 
 * 历史版本:2011-09-06 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HotelOrderContactVo extends AbstractVo
{
	/**
	 * 姓名
	 */
	String name;
	/**
	 * 联系电话
	 */
	String phone;
	/**
	 * 预订手机号
	 */
	String mobile;
	/**
	 * 电子邮箱
	 */
	String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}