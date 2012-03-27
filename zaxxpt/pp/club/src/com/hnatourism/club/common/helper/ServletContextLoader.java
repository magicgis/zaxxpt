package com.hnatourism.club.common.helper;

import javax.servlet.ServletContext;

public interface ServletContextLoader {
	public void initServletContext(ServletContext servletContext); 
	public void closeServletContext(ServletContext servletContext); 
}
