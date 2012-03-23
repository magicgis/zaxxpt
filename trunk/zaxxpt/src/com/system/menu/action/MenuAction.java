package com.system.menu.action;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.system.menu.entity.MenuEntity;
import com.system.user.entity.UserEntity;

public class MenuAction extends BaseAction{
	private MenuEntity menuEntity;
	public MenuEntity getMenuEntity() {
		return menuEntity;
	}
	public void setMenuEntity(MenuEntity menuEntity) {
		this.menuEntity = menuEntity;
	}
	@Override
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER,MenuEntity.class);
	}
	
}
