package com.xunruan.framekork.lang;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/***
 * 
 * @author wenz
 * 
 * 2012-02-02 16:25
 * @version 1.0
 * 
 */
public class Application {
	
	private static Application system = new Application();
	private static Map<Class, Object> cache=new HashMap<Class, Object>();
	
	public HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}
	
	public void setRequest(HttpServletRequest request){
		ServletActionContext.setRequest(request);
	}

	public HttpSession getSession()
	{
		return getRequest().getSession();
	}

	public HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}

	public ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}

	/***
	 * 如果是main方法运行则获取至classs目录如果是web项目在容器中运行则获取至Application类目录下
	 * @return
	 */
	  public String getWebClassesPath() {    
	         String path = getClass().getProtectionDomain().getCodeSource()    
	                 .getLocation().getPath();    
	        return path;    
	 }    
	   
	 /***
	  *  获取路径 到WEB-INF/为止  
	  * @return  路径
	  * @throws IllegalAccessException
	  */
	 public String getWebInfPath() throws IllegalAccessException {    
	       String path = getWebClassesPath();    
	        if (path.indexOf("WEB-INF") > 0) {    
	             path = path.substring(0, path.indexOf("WEB-INF") + 8);    
	         } else {    
	            throw new IllegalAccessException("路径获取错误");    
	         }    
	        return path;    
	  }    
	   
	 /***
	  *  获取路径 到 projectname/为止  
	  * @return  路径
	  * @throws IllegalAccessException
	  */
	 public String getWebRoot() throws IllegalAccessException {    
	       String path = getWebClassesPath();    
	       if (path.indexOf("WEB-INF") > 0) {    
	             path = path.substring(0, path.indexOf("WEB-INF/classes"));    
	         } else {    
	            throw new IllegalAccessException("路径获取错误");    
	         }    
	        return path;    
	  }    

	/***
	 * 获取请求Ip地址，为防止用户使用代理则从请求头部信息中获取，忽略使用多级代理方式
	 * @return IP
	 */
	public String getIp(){
		String ip = this.getRequest().getHeader("x-forwarded-for"); 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = this.getRequest().getHeader("Proxy-Client-IP"); 
		} 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = this.getRequest().getHeader("WL-Proxy-Client-IP"); 
		} 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = this.getRequest().getRemoteAddr(); 
		} 
		return ip; 

	}
	public static Application get() {
		if (system == null) system=new Application();
		return system;
	}
	
	public Object getBean(String name)
	{
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getRequest().getSession().getServletContext());
		return ctx.getBean(name);
	}

}
