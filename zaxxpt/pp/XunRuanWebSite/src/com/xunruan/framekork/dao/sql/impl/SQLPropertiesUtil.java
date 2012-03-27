package com.xunruan.framekork.dao.sql.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xunruan.framekork.dao.sql.SQLProperties;
import com.xunruan.framekork.dao.sql.SQLTitle;
import com.xunruan.framekork.dao.sql.TablePropertiest;
import com.xunruan.framekork.util.StringUtil;
import com.xunruan.framekork.util.StringUtils;
import com.xunruan.site.domain.Produce;

public class SQLPropertiesUtil {

	
	/***
	 * 获取from的sql语句
	 * @return
	 */
	public static String getFormSql(Class classs){
		if(null!=classs){
			return SQLTitle.FROM+" "+classs.getName()+" "+SQLTitle.WHERE;
		}
		return null;
	}
	
	
	/***
	 * 获取单个的属性条件
	 * @param sqlProperties
	 * @return
	 */
	public static String getWhereProperties(SQLProperties sqlProperties){
		StringBuffer sql=new StringBuffer();
		if(StringUtil.isNotEmpty(sqlProperties.getWhere())){
			sql.append(" "+sqlProperties.getWhere());
		}else{
			sql.append(sqlProperties.getStartLink());
			if(sqlProperties.getWholeSQLPropertiesList()!=null){
				sql.append(SQLTitle.LEFTBRACE+""+getWhereSql(sqlProperties.getWholeSQLPropertiesList()));
			}
			if(StringUtil.isNotEmpty(sqlProperties.getColumn())){
				sql.append(sqlProperties.getTable().getAlias()+""+SQLTitle.POINT+""+sqlProperties.getColumn());
			}
			if(sqlProperties.getSameSQLPropertiesList()!=null){
				sql.append(getWhereSql(sqlProperties.getSameSQLPropertiesList()));
			}
			if(StringUtil.isNotEmpty(sqlProperties.getOperation())){
				sql.append(sqlProperties.getOperation());
			}
			if(sqlProperties.getQuotedSQLProperties()!=null){
				sql.append(getWhereProperties(sqlProperties.getQuotedSQLProperties()));
			}
			if(StringUtil.isNotEmpty(sqlProperties.getKey())){
				sql.append(sqlProperties.getKey());
			}
			if(StringUtil.isNotEmpty(sqlProperties.getEndLink())){
				sql.append(sqlProperties.getEndLink());
			}
			if(sqlProperties.getWholeSQLPropertiesList()!=null){
				sql.append(SQLTitle.RIGHTBRACE);
			}
		}
		return sql.toString();
	}
	
	/***
	 * 获取where的sql语句
	 * @return
	 */
	public static  String getWhereSql(List<SQLProperties> whereList){
		StringBuffer sql=new StringBuffer();
		if(null!=whereList&&whereList.size()>0){
			for (int i = 0; i < whereList.size(); i++) {
				sql.append(getWhereProperties(whereList.get(i)));
			}
		}
		return sql.toString();
	}
	
	public static void main(String[] args) {
		SQLProperties p=new SQLProperties();
		TablePropertiest t=new TablePropertiest();
		p.setColumn("ID");
		t.setAlias(SQLTitle.DOMAIN1);
		t.setClasss(Produce.class);
		p.setTable(t);
		p.setStartLink(SQLTitle.AND);
		p.setOperation(SQLTitle.EQ);
		p.setKey(":id");
		List<SQLProperties> list=new ArrayList<SQLProperties>();
		list.add(p);
		System.out.println(SQLPropertiesUtil.getFormSql(t.getClasss())+""+SQLPropertiesUtil.getWhereSql(list));
		
		
	}
}
