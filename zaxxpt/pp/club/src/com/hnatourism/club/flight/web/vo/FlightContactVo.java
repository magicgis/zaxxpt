package com.hnatourism.club.flight.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机票订单联系人信息
 * 
 * 历史版本: 2010-07-09 v1.0.0 (hna) 创建:
 * 
 */
public class FlightContactVo extends AbstractVo {
	// PK
	private String id;
	// 姓名
	private String name;
	// 手机
	private String mobile;
	// 邮箱
	private String email;
	//类型 0：单程航班；1：往返航班 2:机+酒
	private String prodType;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
}
