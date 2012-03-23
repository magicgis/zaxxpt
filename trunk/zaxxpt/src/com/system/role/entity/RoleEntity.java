package com.system.role.entity;

import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;

@TableMethod(TableName = "system_role")
public class RoleEntity implements BaseEntity {
	@FieldMethod(IsField = true, IsPK = true,AutoKey=true)
	private String id;

	@FieldMethod(IsField = true)
	private String rolename;

	@FieldMethod(IsField = true)
	private String remark;

	@FieldMethod(IsField = true)
	private String delflag;
	
	@FieldMethod(IsField = true)
	private String userlevel;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}
	
}
