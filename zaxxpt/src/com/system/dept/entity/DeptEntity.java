package com.system.dept.entity;

import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;

@TableMethod(TableName = "system_dept")
public class DeptEntity implements BaseEntity {
	@FieldMethod(IsField = true, IsPK = true,AutoKey=true)
	private String id;

	@FieldMethod(IsField = true)
	private String deptno;
	
	@FieldMethod(IsField = true)
	private String deptname;

	@FieldMethod(IsField = true)
	private String remark;

	@FieldMethod(IsField = true)
	private String delflag;
	
	@FieldMethod(IsField = true)
	private String parentdept;
	
	@FieldMethod(IsField = true)
	private String bmjb;
	
	
	public String getParentdept() {
		return parentdept;
	}

	public void setParentdept(String parentdept) {
		this.parentdept = parentdept;
	}

	public String getBmjb() {
		return bmjb;
	}

	public void setBmjb(String bmjb) {
		this.bmjb = bmjb;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
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
