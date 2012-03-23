package com.system.duty.action;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.system.duty.entity.DutyEntity;
import com.system.user.entity.UserEntity;

public class DutyAction extends BaseAction{
	private DutyEntity dutyEntity;
	public DutyEntity getDutyEntity() {
		return dutyEntity;
	}
	public void setDutyEntity(DutyEntity dutyEntity) {
		this.dutyEntity = dutyEntity;
	}
	@Override
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER,DutyEntity.class);
	}
	
}
