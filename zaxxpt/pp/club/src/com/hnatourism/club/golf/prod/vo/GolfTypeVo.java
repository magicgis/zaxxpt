package com.hnatourism.club.golf.prod.vo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫球场类型VO
 * 
 * 历史版本:2010-08-04 v1.0.0 (高杰+栾晓东) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfTypeVo
{
	//ID
	private String id;
	//类型名称
	private String name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
