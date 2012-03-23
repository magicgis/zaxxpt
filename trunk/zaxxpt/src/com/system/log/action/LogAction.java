package com.system.log.action;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.system.log.entity.LogEntity;
import com.system.user.entity.UserEntity;

public class LogAction extends BaseAction{
	private LogEntity logEntity;
	public LogEntity getLogEntity() {
		return logEntity;
	}
	public void setLogEntity(LogEntity logEntity) {
		this.logEntity = logEntity;
	}
	@Override
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER,LogEntity.class);
	}
	
}
