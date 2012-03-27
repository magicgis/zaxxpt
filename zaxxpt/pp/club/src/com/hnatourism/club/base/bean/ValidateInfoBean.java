package com.hnatourism.club.base.bean;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述: 验证信息
 * 
 * 历史版本: 2010-7-8 v1.0.0 (wang-wl) 创建
 * 
 */
public class ValidateInfoBean {
	/**
	 * ID
	 */
	private Long id;
	/**
	 * 字段
	 */
	private String field;
	/**
	 * 错误类型
	 */
	private String type;
	/**
	 * 验证结果信息
	 */
	private String message;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
