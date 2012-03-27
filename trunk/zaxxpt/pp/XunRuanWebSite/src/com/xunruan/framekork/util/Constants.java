package com.xunruan.framekork.util;


public class Constants {
	//API服务域名
	public static String API_SERVER_DOMAIN="http://localhost:8080/openPlatform";
	
	//预定来源
	//public static String CLUB_ORDER_SOURCE=PropertiesUtils.getVal("sysProps","club_order_source");
	
	//来源
	//public static String CLUB_SOURCE = PropertiesUtils.getVal("sysProps","club_order_source");
	
	/**
	 * 判断角色使用
	 *  add 20111118 w2l
	 */
	public static final class SysRoleCode {
		/** 管理员 */
		public final static String ADMIN_COMPANY = "ADMIN_COMPANY";
	}
	/**
	 * 订单日志
	 *  add 20111121 w2l
	 */
	public static final class OrderLogInfo {
		/** 预订成功 */
		public final static String ORDER_SUCCESS = "预订成功";
		/** 确认订单 */
		public final static String ORDER_COMFIRM = "确认订单";
		/** 提交预订 */
		public final static String ORDER_BOOK = "提交预订";
	}
}