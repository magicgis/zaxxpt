/**
 * 项目名称:酒店预订系统
 * 
 * 功能描述:系统常量管理
 * 
 * 历史版本:
 *	2010-03-24 v1.0.0 (liulibo) 创建:
 * 
 */
package com.hnatourism.club.common.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;

@SuppressWarnings("serial")
public class SysConstant extends AbstractEntity {
	/**
	 * ID
	 */
	private String id ;
	/**
	 * 常量类型
	 */
	private String conTyp ;
	/**
	 * 常量名称
	 */
	private String conNam ;
	/**
	 * 常量值
	 */
	private String conVal ;
	/**
	 * 状态
	 */
	private String status ;
	private String code ;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
	 * 获取常量类型
	 * @return
	 */
	public String getConTyp() {
		return conTyp;
	}
	/**
	 * 设置常量类型
	 * @param conTyp
	 */	
	public void setConTyp(String conTyp) {
		this.conTyp = conTyp;
	}
	/**
	 * 获取常量名称
	 * @return
	 */
	public String getConNam() {
		return conNam;
	}
	/**
	 * 设置常量名称
	 * @param conNam
	 */	
	public void setConNam(String conNam) {
		this.conNam = conNam;
	}
	/**
	 * 获取常量值
	 * @return
	 */
	public String getConVal() {
		return conVal;
	}
	/**
	 * 设置常量值
	 * @param conVal
	 */	
	public void setConVal(String conVal) {
		this.conVal = conVal;
	}
	/**
	 * 获取状态
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置状态
	 * @param status
	 */	
	public void setStatus(String status) {
		this.status = status;
	}
}