package com.system.role.action;

import java.util.List;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.sunshine.framework.entity.ActionException;
import com.sunshine.framework.entity.DataException;
import com.sunshine.framework.util.SysLogger;
import com.system.role.entity.RoleEntity;
import com.system.user.entity.UserEntity;

public class RoleAction extends BaseAction{
	private RoleEntity roleEntity;
	//获取角色列表
	public String getRoleList() throws ActionException{
		//2.获取用户角色列表
		UserEntity user=(UserEntity)this.getSession().getAttribute(ConfigConstant.LOGIN_ENTITY);
		try {
			List<RoleEntity> roleList=this.getService().selectBySql("select b.* from system_user_role a " +
					" left join system_role b on a.roleid=b.id where userid = ?", new Object[]{user.getId()},RoleEntity.class);
			if(roleList!=null&&roleList.size()>0)
				this.getSession().setAttribute(ConfigConstant.ROLE_LIST,roleList);
			else 
				return "input";
		} catch (DataException e) {
			SysLogger.error("Action error when query user's role list",e);
			throw new ActionException(e);
		}				
		return "source";
	}
	
	public RoleEntity getRoleEntity() {
		return roleEntity;
	}
	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}
	@Override
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER,RoleEntity.class);
	}
	
}
