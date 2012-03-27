package com.hnatourism.club.common.helper.protocol;

import com.hnatourism.framework.utils.PropertiesUtils;
/**
	*常量类 vo wuyuhu
	*2011-8-23
	*/	
public class Constants {
	//public static String URL="http://211.147.220.5:9180";
	public static String FTYPE_DOUBLE="2";
	public static final String SERVER_URL=PropertiesUtils.getVal("sysProps","api_server_flight");
	public static final String SERVER_PAY_URL=PropertiesUtils.getVal("sysProps","api_server_flight");
	public static final String URL=PropertiesUtils.getVal("sysProps","api_server_flight");
	public static String SOURCE_IHZLY="ihzly";
	public static String SOURCE_IYSK="ecard";
	
	
	/**
	 * 以下常量为惠众联银常量
	 * 
	 * @author lk-yin
	 * @deprecated
	 */
	public static final class HzlyParam {
		/** 惠众联银登陆地址 */
//		public final static String URL_HZLY_LOGIN = "http://www.ihzly.com/cooperationChannal!loginOrRegist.do";
		public final static String URL_HZLY_LOGIN = "http://"+PropertiesUtils.getVal("sysProps","ihzly")+"/cooperationChannal!loginOrRegist.do";
		/** 商家id */
		public final static String COOPID = "1063618";
		/** 返回的地址 */
		public final static String RURL = URL+"/flight/searchFlightBox.jsp";
		
	}
}
