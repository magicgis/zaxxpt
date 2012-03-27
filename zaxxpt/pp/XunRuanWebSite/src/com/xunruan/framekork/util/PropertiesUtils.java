package com.xunruan.framekork.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.xunruan.framekork.lang.Application;


/****
 * 属性文件操作
 * @version 1.0
 * @author wenz
 *  2012-02-10 16:01
 */
public class PropertiesUtils
{

	private static final Log log = LogFactory.getLog(PropertiesUtils.class);
	private static final String DEFAULT_INCLUDE="include";
	private static String DEFAULT_PROPERTIES_NAME;
	private static String DEFAULT_PROPERTIES;
	private static Properties properties=null;

	public PropertiesUtils()
	{
	}

	private static void loadProperties(String fileName)
	{
		if (fileName.indexOf(".properties") >= 0)
		{
			if(null==properties){
				properties=new Properties();
				setProperties(properties, fileName);
				String include=properties.getProperty(DEFAULT_INCLUDE);
				if(null!=include){
					String[] files=include.split(",");
					if(null!=files&&files.length>1)
					for (int i = 0; i < files.length; i++) {
						setProperties(properties, files[i]);
					}
				}
			}
		}
	}

	public static String getVal(String key)
	{
		
		return getVal(DEFAULT_PROPERTIES, key);
	}

	public static String getVal(String fileName, String key)
	{
		String val = null;
		try {
			loadProperties(fileName);
			val = properties.getProperty(key);
		} catch (Exception e) {
			log.error("", e);
		}
		return val;
	}



	private static void setProperties(Properties properties, String fileName)
	{
		try
		{
			String file=Application.get().getWebInfPath()+"classes/"+fileName;
			InputStream inputStream =new FileInputStream(new File(file));
			properties.load(inputStream);
			inputStream.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	static 
	{
		DEFAULT_PROPERTIES_NAME = "sysProps";
		DEFAULT_PROPERTIES = (new StringBuilder(String.valueOf(DEFAULT_PROPERTIES_NAME))).append(".properties").toString();
	}
	
}
