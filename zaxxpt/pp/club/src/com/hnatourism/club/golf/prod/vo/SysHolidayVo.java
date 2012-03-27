package com.hnatourism.club.golf.prod.vo;

import com.hnatourism.framework.core.domain.AbstractEntity;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:系统表sys_Haoliday的VO
 * 
 * 历史版本:2010-08-08 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class SysHolidayVo extends AbstractEntity
{
	//ID
	private String id;
	//列类型ID
	private String holidayDate;
	//列名称
	private String name;
	//列值
	private String sts;
	//状态
	private String rmk;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
}
