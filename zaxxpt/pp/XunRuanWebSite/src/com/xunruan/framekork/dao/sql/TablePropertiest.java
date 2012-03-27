package com.xunruan.framekork.dao.sql;

public class TablePropertiest {

	//表名
	private String name;
	//对应实体类对象
	private Class classs;
	//别名
	private  String alias;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class getClasss() {
		return classs;
	}
	public void setClasss(Class classs) {
		this.classs = classs;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
}
