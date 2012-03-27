package com.hnatourism.club.common.helper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CacheLoader implements ServletContextLoader {
	private static final Log logger = LogFactory.getLog(CacheLoader.class); 
	@Override
	public void closeServletContext(ServletContext servletContext) {
		// close security related information 
		if (logger.isDebugEnabled()) { 
		logger.debug("Close Context For Security and Clean the Servlet Context"); 
		} 

		// 清空缓存 
		servletContext.removeAttribute("URL_MAPPING"); 
		servletContext.removeAttribute("menus"); 
		servletContext.removeAttribute("submenus"); 
		
	}

	@Override
	public void initServletContext(ServletContext servletContext) {
		if (logger.isDebugEnabled()) { 
			logger.debug("Initial Context For Security [UrlMapping, Menu, Submenu]"); 
			} 

			//从数据库中读取要缓存的数据 
			// 放入 servletContext中 
//			List menus = systemService.listMenu(); 
//			Map submenus = systemService.listSubmenu(); 
//			Map urlMapping = systemService.listUrlMapping(); 
//			servletContext.setAttribute(\"URL_MAPPING\", urlMapping); 
//			servletContext.setAttribute(\"menus\", menus); 
//			servletContext.setAttribute(\"submenus\", submenus); 
		
	}


}
