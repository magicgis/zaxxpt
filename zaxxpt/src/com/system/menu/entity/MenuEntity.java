package com.system.menu.entity;

import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;

@TableMethod(TableName = "system_menu")
public class MenuEntity implements BaseEntity{
	@FieldMethod(IsField = true, IsPK = true,AutoKey=true)
	private String id;

	@FieldMethod(IsField = true)
	private String sid;
	
	@FieldMethod(IsField = true)
	private String type;
	
	@FieldMethod(IsField = true)
	private String menulevel;
	
	@FieldMethod(IsField = true)
	private String colid;
	
	@FieldMethod(IsField = true)
	private String menu;
	
	@FieldMethod(IsField = true)
	private String url;
	
	@FieldMethod(IsField = true)
	private String ico;
	
	@FieldMethod(IsField = true)
	private String isflow;
	
	@FieldMethod(IsField = true)
	private String ispower;
	
	@FieldMethod(IsField = true)
	private String isbutton;
	
	@FieldMethod(IsField = true)
	private String delflag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMenulevel() {
		return menulevel;
	}

	public void setMenulevel(String menulevel) {
		this.menulevel = menulevel;
	}

	public String getColid() {
		return colid;
	}

	public void setColid(String colid) {
		this.colid = colid;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getIsflow() {
		return isflow;
	}

	public void setIsflow(String isflow) {
		this.isflow = isflow;
	}

	public String getIspower() {
		return ispower;
	}

	public void setIspower(String ispower) {
		this.ispower = ispower;
	}

	public String getIsbutton() {
		return isbutton;
	}

	public void setIsbutton(String isbutton) {
		this.isbutton = isbutton;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	
}
