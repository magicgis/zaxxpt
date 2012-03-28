package com.sunshine.framework.entity;

import java.io.Serializable;


/***
 *@author wenz
 *@Date 2012-3-27обнГ02:00:43
 *@version 1.0
 *@see com.sunshine.framework.entity.BaseDomain
 ***/
public class BaseDomain implements Serializable{

	private String id;

	public BaseDomain(){
		
	}
	public BaseDomain(String id){
		this.id=id;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}