package com.sunshine.framework.context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import org.jdom.Element;
import com.ext3.unit.BeanUnit;


import com.sunshine.framework.util.SysLogger;
import com.sunshine.framework.util.XMLUtil;
/***
 * 配置加载监听器
 * @author ralphone.zhuo
 *
 */
public class ConfigListener implements ServletContextListener {
	
	@SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent event){
		
		System.out.println(BeanUnit.getFormatDateTimeStr() + " - INFO - 广州阳光耐特电子有限公司");
		
		// 系统物理路径
		String syspath=event.getServletContext().getRealPath("/");
		syspath=syspath+(syspath.endsWith(File.separator)?"":File.separator);
		ConfigConstant.sysPath = syspath;
		//配置文件
		String xmlFile = ConfigConstant.sysPath + "WEB-INF/classes/config.xml";
		Element root = XMLUtil.filedoc(xmlFile).getRootElement();
		
		// 处理Struts 2放过的栏截Action
		Element is = root.getChild("strutsInterceptors");
		List<Element> ms = is.getChildren();
		List<String> interceptor = new ArrayList<String>();
		for (Element method : ms) {
			System.out.println(BeanUnit.getFormatDateTimeStr() + " - INFO - Struts拦截器释放的Action:" + method.getValue());
			interceptor.add(method.getValue());			
		}
		ConfigConstant.strutsInterceptor = interceptor;
		
		// 操作日志
		ConfigConstant.databaseLogs = (new Boolean(root.getChild("dblogs").getAttributeValue("logs")));
		if (ConfigConstant.databaseLogs) 
			System.out.println(BeanUnit.getFormatDateTimeStr() + " - INFO - 操作日志已启动.");
		else
			System.out.println(BeanUnit.getFormatDateTimeStr() + " - INFO - 操作日志已禁用.");
	}

	public void contextDestroyed(ServletContextEvent event) {
		SysLogger.info("系统关闭");
	}

}