package com.sunshine.framework.entity;

import java.io.Serializable;

import com.sunshine.framework.util.BeanUtils;


/***
 * ��ѯ��װentity
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
			searchDesc = "��������";
		return searchDesc;
	}

	public void setSearchDesc(String searchDesc) {
		this.searchDesc = searchDesc;
	}

	
}
