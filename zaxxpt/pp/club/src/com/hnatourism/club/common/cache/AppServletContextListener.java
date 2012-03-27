package com.hnatourism.club.common.cache;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hnatourism.club.common.helper.flight.SearchFlightCacheResponseMessage;
/**
*起服务加载缓存 fanghw
*/
public class AppServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		SearchFlightCacheResponseMessage searchFlightCacheResponseMessage=new SearchFlightCacheResponseMessage();
		searchFlightCacheResponseMessage.getFlightCache();

	}

}
