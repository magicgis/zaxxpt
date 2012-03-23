package com.sunshine.framework.util;

import java.io.File;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

final public class XMLUtil {
	
	/**
	 * 读取XML
	 * @param xmlPath	xml文件路径
	 * @return
	 */
	public static Document filedoc(String xmlPath){
		return filedoc(xmlPath, false);
	}
	
	/**
	 * 读取XML
	 * @param xmlPath
	 * @param validate
	 * @return
	 */
	public static Document filedoc(String xmlPath,boolean validate){
		SAXBuilder builder = new SAXBuilder(validate);
		Document doc = null;
		try {
			doc = builder.build(new File(xmlPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
	   
}
