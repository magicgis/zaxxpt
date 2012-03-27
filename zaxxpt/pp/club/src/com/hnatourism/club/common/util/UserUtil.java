package com.hnatourism.club.common.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:用户Util
 * 
 * 历史版本: 2010-07-02 v1.0.0 (zhangyun) 创建
 * 
 */
public class UserUtil{
	//线程变量，注意new的一定是个Hashtable而不是HashMap   
	private static final ThreadLocal<Map> sessionMap = new ThreadLocal<Map>(){ 
		@Override
		protected Map initialValue() {return new Hashtable();}   
	};
//	private static final Hashtable sessionMap = new Hashtable();
	/**
	 * @description 【获取用户信息】
	 * @return
	 * @author zhangyun
	 */
	public static MemberInfoVo getUser() {
		MemberInfoVo user = null;
		Object userObj = getUserObj();
		if (userObj != null && userObj instanceof MemberInfoVo) {
			user = (MemberInfoVo) userObj;
		}
		return user;
	}
	public static MemberInfoVo getUser(String sessionId) {
		MemberInfoVo user = null;
		Object userObj = getUserObj(sessionId);
		if (userObj != null && userObj instanceof MemberInfoVo) {
			user = (MemberInfoVo) userObj;
		}
		return user;
	}
	/**
	 * @description 【没有登录，获取匿名用户】
	 * @return
	 * @author zhangyun
	 */
	public String getAnonymousUser(){
		String user = null;
		Object userObj = getUserObj();
		if (userObj != null && userObj instanceof String) {
			user = (String) userObj;
		}
		return user;
	}
	public static ServletContext getServletContext(){
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		return wac.getServletContext();
	}
	/**
	 * @description 【获取用户对象】
	 * @return
	 * @author zhangyun
	 */
	public static Object getUserObj(){
		Object user = null;
		ServletContext context = getServletContext();
		
		if (context != null) {
			String sessionId = (String)get("sessionId");
			if(sessionId!=null)
				user = context.getAttribute(sessionId);
		}
		return user;
	}
	public static Object getUserObj(String sessionId){
		Object user = null;
		ServletContext context = getServletContext();
		if (context != null) {
			if(sessionId!=null)
				user = context.getAttribute(sessionId);
		}
		return user;
	}
	/**  
	* 设置制定属性名的值.  
	*   
	* @param attribute  
	*            属性名称  
	* @param value  
	*            属性值  
	*/  
	public static void set(String attribute, Object value) {
		Map map = (Map) sessionMap.get();
//		if (map == null) {
//			map = new Hashtable();
//			sessionMap.set(map);
//		}
		map.put(attribute, value);
	}
	
	public static void set(String attribute, Object value,MemberInfoVo vo) {
		set(attribute, value);
		ServletContext context = getServletContext();
		context.setAttribute((String)value, vo);
	}
	/**  
	* 设置制定属性名的值.  
	*   
	* @param attribute  
	*            属性名称  
	* @param value  
	*            属性值  
	*/  
	public static void remove(String attribute) {
		Map map = (Map) sessionMap.get();
		if (map != null) {
			map.remove(attribute);
		}
	}
	public static void remove(String attribute, Object value) {
		remove(attribute);
		ServletContext context = getServletContext();
		context.removeAttribute((String)value);
	}
	/**  
	 * 获得线程中保存的属性. 
	 *   
	 * @param attribute  
	 *            属性名称  
	 * @return 属性值  
	 */  
	public static Object get(String attribute) {   
	    Map map = (Map) sessionMap.get();
	    if(map==null){
	    	return null;
	    }
	    return map.get(attribute);
	} 
}
