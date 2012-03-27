package com.xunruan.framekork.dao.sql;

import java.util.List;

/***
 * 2012-02-16
 * @author wenz
 * @version 1.0
 */
public class SQLProperties {

	//条件语句 如果有条件语句则下列  属性不做任何处理 只取用条件语句
	private String where;
	//连接符如  ordery by  、and、 or
	private String startLink;
	//整体连接运算属性 大括号() list表示大括号里面的运算
	private List<SQLProperties>  wholeSQLPropertiesList;
	//列名称
	private String column;
	//相同运算的 属性 如 order by a,b,c,d  
	private List<SQLProperties>  sameSQLPropertiesList;
	//操作符
	private String operation;
	//引用的另一列  比如 本列  Table1.column1=Table2.colmn2
	private SQLProperties quotedSQLProperties;
	//预编译占位符名称 
	private String key;
	//连接符 如  desc  asc
	private String endLink;
	//表对象
	private TablePropertiest table;
	
	
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getStartLink() {
		return startLink;
	}
	public void setStartLink(String startLink) {
		this.startLink = startLink;
	}
	public String getEndLink() {
		return endLink;
	}
	public void setEndLink(String endLink) {
		this.endLink = endLink;
	}
	public TablePropertiest getTable() {
		return table;
	}
	public void setTable(TablePropertiest table) {
		this.table = table;
	}
	public SQLProperties getQuotedSQLProperties() {
		return quotedSQLProperties;
	}
	public void setQuotedSQLProperties(SQLProperties quotedSQLProperties) {
		this.quotedSQLProperties = quotedSQLProperties;
	}
	public List<SQLProperties> getSameSQLPropertiesList() {
		return sameSQLPropertiesList;
	}
	public void setSameSQLPropertiesList(List<SQLProperties> sameSQLPropertiesList) {
		this.sameSQLPropertiesList = sameSQLPropertiesList;
	}
	public List<SQLProperties> getWholeSQLPropertiesList() {
		return wholeSQLPropertiesList;
	}
	public void setWholeSQLPropertiesList(List<SQLProperties> wholeSQLPropertiesList) {
		this.wholeSQLPropertiesList = wholeSQLPropertiesList;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	
	
	
}
