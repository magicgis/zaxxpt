package com.system.log.entity;


import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;

@TableMethod(TableName = "system_logs")
public class LogEntity implements BaseEntity{

	@FieldMethod(IsField = true, IsPK = true,AutoKey=true)
	private String id;

	@FieldMethod(IsField = true)
	private String menuid;
	
	@FieldMethod(IsField = true)
	private String userid;

	@FieldMethod(IsField = true)
	private String ip;

	@FieldMethod(IsField = true)
	private String datetime;
	
	@FieldMethod(IsField = true)
	private String itemnoid;

	@FieldMethod(IsField = true)
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getItemnoid() {
		return itemnoid;
	}

	public void setItemnoid(String itemnoid) {
		this.itemnoid = itemnoid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
