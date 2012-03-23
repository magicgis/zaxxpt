package com.platform.login.action;

import java.util.List;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.sunshine.framework.entity.ActionException;
import com.sunshine.framework.entity.DataException;
import com.sunshine.framework.util.BeanUtils;
import com.sunshine.framework.util.SysLogger;
import com.system.role.entity.RoleEntity;
import com.system.user.entity.UserEntity;

public class LoginAction extends BaseAction {
	
	private UserEntity userEntity;
	
	public String enter() throws ActionException{
		if(BeanUtils.isObjectNull(userEntity)){
			return "input";
		}
		String username=userEntity.getUsername();
		String pwd=userEntity.getPassword();
		String md5PWD=BeanUtils.getMD5Str(username+pwd);
		userEntity.setPassword(md5PWD);
		try {
			List userList=this.getService().select(userEntity);
			if(userList!=null&&userList.size()>0){
				//1.验证通过
				UserEntity user=(UserEntity) userList.get(0);
				getSession().setAttribute(ConfigConstant.LOGIN_ENTITY, user);
				request.setAttribute("userid", user.getId());
				return SUCCESS;													
			}else{
				return "input";
			}
		} catch (DataException e) {
			SysLogger.error("LoginAction error.",e);
			throw new ActionException(e);
		}
	}
	
	@Override
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER, UserEntity.class);
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
}
