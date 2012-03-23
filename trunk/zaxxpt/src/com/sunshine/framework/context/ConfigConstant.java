package com.sunshine.framework.context;

import java.util.List;
/***
 * 全局字段
 * @author ralphone.zhuo
 *
 */
public class ConfigConstant {	
	
	// 数据库类型 Microsoft SQL Server 
	public static final String SQLSERVER = "sqlserver";

	// 数据库类型 Oracle	
	public static final String ORACLE = "oracle";
	
	// 数据库类型 MySQL
	public static final String MYSQL  = "mysql";	
	

	
	// 查询返回结果集存放在request对象中的主表数据集合名称
	public static final String MASTER = "master";
	
	// 查询返回结果集存放在request对象中的子表数据集合名称	
	public static final String DETAIL = "detail";
	
	// 存放在session对象中的查询条件名称
	public static final String SEARCH = "search";
	
	// 存放在session对象中的分页条件名称
	public static final String PAGE = "page";
	
	// 存放在session对象中的用户登录信息名称
	public static final String LOGIN_ENTITY = "loginEntity";
	
	//存放在session对象中的用户角色信息名称
	public static final String ROLE_LIST = "roleList";

	//存放在session对象中的角色对应资源信息名称
	public static final String DATASOURCE = "datasourcemap";
	
	
	

	// 系统本地路径
	public static String sysPath;
	
	// 系统URL
	public static String sysUrl;
	
	// 当前系统数据库连接方式
	public static String connectionMethod;
	
	// 默认数据库
	public static String defaultDatabase;
	
//	// 数据库JNDI集合
//	public static List<Jndis> jndis;
//	
//	// 数据库JDBC集合
//	public static List<Jdbcs> Jdbcs;
//	
	// Struts 在栏截器中释放的Class或Method
	public static List<String> strutsInterceptor;
	
	// 开启数据库system_logs表的日志记录
	public static Boolean databaseLogs;

	
	
	
	// Job中的线程信号量
	public static int semaphore = 5;  // 默认5 个Job中信号量
	
	// Job每天所触发时间
	public static String delFileTime = "01";  // HH 删除Flash文件时间
	
	
}
