package com.system.source.datasource.entity;

import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;

@TableMethod(TableName = "system_datasource")
public class DataSourceEntity implements BaseEntity {

	@FieldMethod(IsField = true, IsPK = true, AutoKey = true)
	private String id;
	
	@FieldMethod(IsField = true)
	private String name;
	
	@FieldMethod(IsField = true)
	private String description;
	
	@FieldMethod(IsField = true)
	private String isdefault;
	
	@FieldMethod(IsField = true)
	private String jndiname;
	
	@FieldMethod(IsField = true)
	private String delfalg;
	
	@FieldMethod(IsField = true)
	private String remark;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public String getJndiname() {
		return jndiname;
	}

	public void setJndiname(String jndiname) {
		this.jndiname = jndiname;
	}

	public String getDelfalg() {
		return delfalg;
	}

	public void setDelfalg(String delfalg) {
		this.delfalg = delfalg;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
