package com.xunruan.framekork.dao.sql.impl;

import java.util.List;

import com.xunruan.framekork.dao.sql.SQLProperties;
import com.xunruan.framekork.dao.sql.SQLSupport;


/***
 * 2012-02-16
 * @author wenz
 * @version 1.0
 */
public class MysqlSqlSupportImpl  implements SQLSupport{

	private List<SQLProperties> list;
	private StringBuffer sql;
	
	protected MysqlSqlSupportImpl(List<SQLProperties> list){
		this.list=list;
	}
	
	public String getSingleSql() {
		// TODO Auto-generated method stub
		sql=new StringBuffer(SQLPropertiesUtil.getFormSql(list.get(0).getTable().getClasss())+""+SQLPropertiesUtil.getWhereSql(list));
		return sql.toString();
	}
	
	
}
