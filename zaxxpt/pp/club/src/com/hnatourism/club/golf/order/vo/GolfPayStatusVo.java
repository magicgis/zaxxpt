package com.hnatourism.club.golf.order.vo;

import com.hnatourism.framework.core.domain.AbstractEntity;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫支付状态VO
 * 
 * 历史版本:2011-08-05 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfPayStatusVo extends AbstractEntity
{
	//状态ID
	private char id;
	//状态名称
	private String name;
	
	
	public char getId() {
		return id;
	}
	public void setId(char id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
