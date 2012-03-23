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
 * ���ü��ؼ�����
 * @author ralphone.zhuo
 *
 */
public class ConfigListener implements ServletContextListener {
	
	@SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent event){
		
		System.out.println(BeanUnit.getFormatDateTimeStr() + " - INFO - �����������ص������޹�˾");
		
		// ϵͳ����·��
		String syspath=event.getServletContext().getRealPath("/");
		syspath=syspath+(syspath.endsWith(File.separator)?"":File.separator);
		ConfigConstant.sysPath = syspath;
		//�����ļ�
		String xmlFile = ConfigConstant.sysPath + "WEB-INF/classes/config.xml";
		Element root = XMLUtil.filedoc(xmlFile).getRootElement();
		
		// ����Struts 2�Ź�������Action
		Element is = root.getChild("strutsInterceptors");
		List<Element> ms = is.getChildren();
		List<String> interceptor = new ArrayList<String>();
		for (Element method : ms) {
			System.out.println(BeanUnit.getFormatDateTimeStr() + " - INFO - Struts�������ͷŵ�Action:" + method.getValue());
			interceptor.add(method.getValue());			
		}
		ConfigConstant.strutsInterceptor = interceptor;
		
		// ������־
		ConfigConstant.databaseLogs = (new Boolean(root.getChild("dblogs").getAttributeValue("logs")));
		if (ConfigConstant.databaseLogs) 
			System.out.println(BeanUnit.getFormatDateTimeStr() + " - INFO - ������־������.");
		else
			System.out.println(BeanUnit.getFormatDateTimeStr() + " - INFO - ������־�ѽ���.");
	}

	public void contextDestroyed(ServletContextEvent event) {
		SysLogger.info("ϵͳ�ر�");
	}

}