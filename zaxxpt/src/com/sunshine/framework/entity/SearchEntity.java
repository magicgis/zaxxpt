package com.sunshine.framework.entity;

import java.io.Serializable;

import com.sunshine.framework.util.BeanUtils;


/***
 * 查询封装entity
 * @author ralphone.zhuo
 *
 */
public class SearchEntity implements Serializable {
	
	private static final long serialVersionUID = 2302653730267390708L;

	private String searchCmd;

	private String searchDesc;

	
	
	
	public String getSearchCmd() {
		return searchCmd;
	}

	public void setSearchCmd(String searchCmd) {
		this.searchCmd = searchCmd;
	}

	public String getSearchDesc() {
		if (BeanUtils.isEmpty(searchDesc))
			searchDesc = "所有数据";
		return searchDesc;
	}

	public void setSearchDesc(String searchDesc) {
		this.searchDesc = searchDesc;
	}

	
}
