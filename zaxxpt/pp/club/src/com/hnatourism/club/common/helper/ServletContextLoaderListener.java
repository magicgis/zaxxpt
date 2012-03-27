package com.hnatourism.club.common.helper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServletContextLoaderListener implements ServletContextListener {
	private static final Log logger = LogFactory.getLog(ServletContextLoaderListener.class); 
	private ServletContextLoader servletContextLoader; 
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		this.servletContextLoader.closeServletContext(event.getServletContext()); 
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		this.servletContextLoader = createServletContextLoader(event); 
		this.servletContextLoader.initServletContext(event.getServletContext()); 
	}
	/** 
	* @param event 
	* @return Returns the ServletContextLoader 
	*/ 
	private ServletContextLoader createServletContextLoader(ServletContextEvent event) { 

	// 这个方法可以重写，如果没有使用spring来管理依赖关系的话 
	// 这个结构中，只有这个listener和spring容器产生了依赖 
//	ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()); 
//	return (ServletContextLoader) applicationContext.getBean(\"servletContextLoader\"); 
		return null;
	} 

}
