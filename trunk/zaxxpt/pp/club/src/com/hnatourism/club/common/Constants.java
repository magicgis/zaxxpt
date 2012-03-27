package com.hnatourism.club.common;

import com.hnatourism.framework.utils.PropertiesUtils;

public class Constants {
	/**
	 * B2C_LINK
	 */
	public static String LINK_NAME=PropertiesUtils.getVal("link_name");
	
	//API服务域名
	public static String API_SERVER_DOMAIN=PropertiesUtils.getVal("sysProps","api_server_domain");
	
	//预定来源
	public static String CLUB_ORDER_SOURCE=PropertiesUtils.getVal("sysProps","club_order_source");
	
	//来源
	public static String CLUB_SOURCE = PropertiesUtils.getVal("sysProps","club_order_source");
	
	//API服务xhlx地址
	public static String API_SERVER_XHLX=PropertiesUtils.getVal("sysProps","api_server_xhlx");
	
	//API服务机票地址
	public static String API_SERVER_FLIGHT=PropertiesUtils.getVal("sysProps","api_server_flight");
	
	//API服务酒店地址
	public static String API_SERVER_HOTEL=PropertiesUtils.getVal("sysProps","api_server_hotel");
	
	//酒店城市预定来源
	public static String CLUB_HOTEL_CITY_STYPE="B2C";
	
	/**
	 * 判断角色使用
	 *  add 20111118 w2l
	 */
	public static final class SysRoleCode {
		/** 管理员 */
		public final static String ADMIN_COMPANY = "ADMIN_COMPANY";
		/** 总公司 */
		public final static String MAIN_COMPANY = "MAIN_COMPANY";
		/** 分公司 */
		public final static String SUB_COMPANY = "SUB_COMPANY";
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
		/** 取消预订申请 */
		public final static String ORDER_CANCLE_APPLY = "取消预订申请";
		/** 取消成功 */
		public final static String ORDER_CANCLE_SUCCESS = "取消成功";
		/** 取消失败 */
		public final static String ORDER_CANCLE_FAIL = "取消失败";
	}
	
	/**
	 * 酒店预定时使用的分润点常量
	 * @author lixun
	 *
	 */
	public static final class HotelBookConstants{
		/** 酒店用户分润返点 */
		public final static Double HOTEL_MEMBER_POINT = 0.10D;
	}
}