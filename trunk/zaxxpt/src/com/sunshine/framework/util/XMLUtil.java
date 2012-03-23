package com.sunshine.framework.util;

import java.io.File;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

final public class XMLUtil {
	
	/**
	 * ��ȡXML
	 * @param xmlPath	xml�ļ�·��
	 * @return
	 */
	public static Document filedoc(String xmlPath){
		return filedoc(xmlPath, false);
	}
	
	/**
	 * ��ȡXML
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
