package com.system.dept.action;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.system.dept.entity.DeptEntity;
import com.system.user.entity.UserEntity;

public class DeptAction extends BaseAction{
	private DeptEntity deptEntity;
	public DeptEntity getDeptEntity() {
		return deptEntity;
	}
	public void setDeptEntity(DeptEntity deptEntity) {
		this.deptEntity = deptEntity;
	}
	@Override
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER,DeptEntity.class);
	}
	
}
