package com.sunshine.framework.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.sunshine.framework.context.ConfigConstant;



public class SysLogger {

	private static Logger logger = Logger.getLogger(SysLogger.class);
	
	private static final int INFO  = 1;
	
	private static final int DEBUG = 2;
	
	private static boolean init(int o) {
		
		boolean result = false;
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		
		String logPath = ConfigConstant.sysPath + "WEB-INF/classes/log4j.properties";
		String logName = ConfigConstant.sysPath + "WEB-INF/logs/" + simpleDateFormat.format(date)+"_";
        
		//给log4j.properties中变量${logs}赋值
		System.setProperty("logs",logName);
		//指定log4j.properties文件物理位置
		PropertyConfigurator.configure(logPath);
		
		InputStream file = null;
		try {
			Properties pFile = new Properties();     
			file = new FileInputStream(logPath);
			pFile.load(file);
			switch(o){
              case INFO:
                 result = new Boolean(pFile.getProperty("log4j.set.info"));
                 break;
              case DEBUG:
                 result = new Boolean(pFile.getProperty("log4j.set.debug"));
                 break;
            }
		} catch(Exception e) {
			logger.error("ERROR:Read " + logPath + " error.",e);
			e.printStackTrace();
		} finally {
			if (file != null)
			   try {
				   file.close();
			   } catch (Exception ex) {
				   logger.error("ERROR:close " + logPath + " file error.",ex);
				   ex.printStackTrace();
			   }
		}
		
		return result;
	}

	public static void info(String infoMessage) {
		if (init(INFO))
			logger.info(infoMessage);
	}

	public static void debug(String debugMessage) {
		if (init(DEBUG))
			logger.debug("DEBUG:" + debugMessage);
	}
	
	public static void error(String errorMessage, Exception e) {
    	logger.error("ERROR:" + errorMessage, e);
	    e.printStackTrace();
	}

	public static void error(String errorMessage) {
		logger.error("ERROR:" + errorMessage);
	}

}