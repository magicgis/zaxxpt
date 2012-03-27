package com.hnatourism.club.hotel.prod.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店房间图片
 * 
 * 历史版本:2011-08-09 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HotelPicsVo extends AbstractVo
{
	private String name;
	private String value;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}