package com.system.user.action;



import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.sunshine.framework.entity.ActionException;
import com.sunshine.framework.entity.DataException;
import com.sunshine.framework.entity.annotation.TableMethod;
import com.sunshine.framework.util.BeanUtils;
import com.sunshine.framework.util.SysLogger;

import com.system.user.entity.UserEntity;
/***
 * 用户管理Action
 * @author ralphone.zhuo
 *
 */
public class UserAction extends BaseAction{
	private UserEntity userEntity;
	
	public String add() throws ActionException{
		if(BeanUtils.isObjectNotNull(userEntity)){
			String userName=userEntity.getUsername();
			String tableName=UserEntity.class.getAnnotation(TableMethod.class).TableName();
			try {
				//验证用户名是否重复
				List list=this.getService().select(userEntity);
				if(list==null||list.size()<=0){
					String md5PWD=userName+"123456";
					md5PWD=BeanUtils.getMD5Str(md5PWD);
					userEntity.setPassword(md5PWD);
				}else{
					return "input";
				}
			} catch (DataException e) {
				SysLogger.error("unique error when add user.",e);
				throw  new ActionException(e);
			}
		}
		return super.add();
	}
	
	public UserEntity getUserEntity() {
		return userEntity;
	}
	
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	@Override
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER,UserEntity.class);
	}
	
	
	
	@Override
	public String query() throws ActionException {
		ServletActionContext.getRequest().getSession().setAttribute(ConfigConstant.SEARCH, getSearchEntity());
		return super.query();
	}
}
