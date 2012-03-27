package com.xunruan.framekork.dao.sql.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xunruan.framekork.dao.sql.SQLProperties;
import com.xunruan.framekork.dao.sql.SQLSupport;

/***
 * 2012-02-16
 * @author wenz
 * @version 1.0
 */
public class SQLFactory {

	private Class classs;
	private static final Log log = LogFactory.getLog(SQLFactory.class);
	private SQLFactory(){}
	
	public SQLFactory  newInstance(DATABASE_TYPE database_type){
		try {
			this.classs=Class.forName(database_type.getValue());
		} catch (Exception e) {
			log.error("",e);
		}
		return new SQLFactory();
	}
	
	
	public SQLSupport getSQLSupport(List<SQLProperties> list){
		try {
			return (SQLSupport)classs.getConstructor(List.class).newInstance(list);
		} catch (Exception e) {
			log.error("",e);
		}
		return null;
	}
	
	public enum DATABASE_TYPE{
		MYSQL("com.xunruan.framekork.dao.sql.impl.MysqlSqlSupportImpl"),
		ORACLE(""),
		DB2(""),
		SQLSERVER(""),
		SYBASE("");
		 private final String value;
	        public String getValue() {
	            return value;
	        }
	        //构造器默认也只能是private, 从而保证构造函数只能在内部使用
	        DATABASE_TYPE(String value) {
	            this.value = value;
	       }
	}
}
