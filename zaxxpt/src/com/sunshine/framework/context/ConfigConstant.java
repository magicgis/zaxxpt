package com.sunshine.framework.context;

import java.util.List;
/***
 * ȫ���ֶ�
 * @author ralphone.zhuo
 *
 */
public class ConfigConstant {	
	
	// ���ݿ����� Microsoft SQL Server 
	public static final String SQLSERVER = "sqlserver";

	// ���ݿ����� Oracle	
	public static final String ORACLE = "oracle";
	
	// ���ݿ����� MySQL
	public static final String MYSQL  = "mysql";	
	

	
	// ��ѯ���ؽ���������request�����е��������ݼ�������
	public static final String MASTER = "master";
	
	// ��ѯ���ؽ���������request�����е��ӱ����ݼ�������	
	public static final String DETAIL = "detail";
	
	// �����session�����еĲ�ѯ��������
	public static final String SEARCH = "search";
	
	// �����session�����еķ�ҳ��������
	public static final String PAGE = "page";
	
	// �����session�����е��û���¼��Ϣ����
	public static final String LOGIN_ENTITY = "loginEntity";
	
	//�����session�����е��û���ɫ��Ϣ����
	public static final String ROLE_LIST = "roleList";

	//�����session�����еĽ�ɫ��Ӧ��Դ��Ϣ����
	public static final String DATASOURCE = "datasourcemap";
	
	
	

	// ϵͳ����·��
	public static String sysPath;
	
	// ϵͳURL
	public static String sysUrl;
	
	// ��ǰϵͳ���ݿ����ӷ�ʽ
	public static String connectionMethod;
	
	// Ĭ�����ݿ�
	public static String defaultDatabase;
	
//	// ���ݿ�JNDI����
//	public static List<Jndis> jndis;
//	
//	// ���ݿ�JDBC����
//	public static List<Jdbcs> Jdbcs;
//	
	// Struts �����������ͷŵ�Class��Method
	public static List<String> strutsInterceptor;
	
	// �������ݿ�system_logs�����־��¼
	public static Boolean databaseLogs;

	
	
	
	// Job�е��߳��ź���
	public static int semaphore = 5;  // Ĭ��5 ��Job���ź���
	
	// Jobÿ��������ʱ��
	public static String delFileTime = "01";  // HH ɾ��Flash�ļ�ʱ��
	
	
}
