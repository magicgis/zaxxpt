package com.hnatourism.club.hotel.prod.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称：海航旅业B2C系统系统
 *
 * 功能描述：酒店常用旅客  （调用C站接口用）
 *
 * 历史版本：2011-10-31 v1.0.0 (zhanghan) 创建
 *
 */
public class Passenger extends AbstractVo {
	//常用旅客名称
	private String name;
	//用户类型
	private String type;
	//证件类型
	private String certType;
	// 证件号
	private String certNo;
	//id
	private String id;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the certType
	 */
	public String getCertType() {
		return certType;
	}
	/**
	 * @param certType the certType to set
	 */
	public void setCertType(String certType) {
		this.certType = certType;
	}
	/**
	 * @return the certNo
	 */
	public String getCertNo() {
		return certNo;
	}
	/**
	 * @param certNo the certNo to set
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	          
}
