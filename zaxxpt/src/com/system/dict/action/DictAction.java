package com.system.dict.action;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.system.dict.entity.DictEntity;
import com.system.user.entity.UserEntity;

public class DictAction extends BaseAction{
	private DictEntity dictEntity;
	public DictEntity getDictEntity() {
		return dictEntity;
	}
	public void setDictEntity(DictEntity dictEntity) {
		this.dictEntity = dictEntity;
	}
	@Override
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER,DictEntity.class);
	}
	
}
