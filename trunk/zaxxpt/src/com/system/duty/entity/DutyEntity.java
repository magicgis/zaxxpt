package com.system.duty.entity;

import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;

@TableMethod(TableName = "system_duty")
public class DutyEntity implements BaseEntity {
	@FieldMethod(IsField = true, IsPK = true,AutoKey=true)
	private String id;

	@FieldMethod(IsField = true)
	private String dutyno;
	
	@FieldMethod(IsField = true)
	private String dutyname;

	@FieldMethod(IsField = true)
	private String remark;

	@FieldMethod(IsField = true)
	private String delflag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDutyno() {
		return dutyno;
	}

	public void setDutyno(String dutyno) {
		this.dutyno = dutyno;
	}

	public String getDutyname() {
		return dutyname;
	}

	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
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

}
