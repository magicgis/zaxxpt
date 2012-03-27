package com.hnatourism.club.golf.prod.vo;

import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:系统表sys_constantVO
 * 
 * 历史版本:2010-08-08 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class SysConstantVo extends AbstractEntity
{
	//ID
	private String id;
	//列类型ID
	private String conType;
	//列名称
	private String conName;
	//列值
	private String conValue;
	//状态
	private String status;
	//代码
	private String code;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	public String getConValue() {
		return conValue;
	}
	public void setConValue(String conValue) {
		this.conValue = conValue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
