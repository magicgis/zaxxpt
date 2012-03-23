package com.system.source.datasource.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.sunshine.framework.entity.ActionException;
import com.sunshine.framework.entity.DataException;
import com.sunshine.framework.util.SysLogger;
import com.system.role.entity.RoleEntity;
import com.system.source.datasource.entity.DataSourceEntity;

public class DataSourceAction extends BaseAction{
	
	private DataSourceEntity dataSourceEntity;
	
	public String getDataSourceMap() throws ActionException{
		//装载角色对应的资源
	try {
		Map<String,DataSourceEntity> dsmap=new HashMap();
		List<RoleEntity> roleList=(List<RoleEntity>) this.getSession().getAttribute(ConfigConstant.ROLE_LIST);
		String roles="";
		for(RoleEntity role:roleList){
			roles+=role.getId()+",";
		}
		if(roles.endsWith(","))roles=roles.substring(0, roles.length()-1);
		
			List<DataSourceEntity> list=this.getService().selectBySql("select b.* from system_role_source a " +
					" left join system_datasource b on a.sourceid = b.id where roleid in("+roles+")", null, DataSourceEntity.class);
			for(DataSourceEntity dataSource:list){
				dsmap.put(dataSource.getName(), dataSourceEntity);
			}
			if(list!=null&&list.size()>0)
				//设置角色所有资源
				this.getSession().setAttribute(ConfigConstant.DATASOURCE, dsmap);
			else
				return "input";
		} catch (DataException e) {
			SysLogger.error("Action error when query role's datasource list",e);
			throw new ActionException(e);
		}
		return SUCCESS;
	}
	
	public void registerEntity() {
		this.getEntityMap().put(ConfigConstant.MASTER, DataSourceEntity.class);
	}
	public DataSourceEntity getDataSourceEntity() {
		return dataSourceEntity;
	}
	public void setDataSourceEntity(DataSourceEntity dataSourceEntity) {
		this.dataSourceEntity = dataSourceEntity;
	}
	
}
