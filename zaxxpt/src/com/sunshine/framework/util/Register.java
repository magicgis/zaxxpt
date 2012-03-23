package com.sunshine.framework.util;

import java.io.File;
import java.util.Map;

import com.sunshine.framework.context.ConfigConstant;



public class Register {
	
	private String classPath = ConfigConstant.sysPath + "WEB-INF/classes";

	protected void handleFile(Map<String,String> calzzMap, final String endsWith, final File file){    	    	    	
    	if(!file.getName().endsWith(".class"))
    		return;
    	
    	String classFileName = file.getName().substring(0,file.getName().indexOf(".class"));
    	
    	if(classFileName.endsWith(endsWith)){
    		String moduleName = classFileName.substring(0,classFileName.lastIndexOf(endsWith)).toLowerCase();//file.getName().substring(0,file.getName().indexOf(endsWith)).toLowerCase();
    		
    		if(calzzMap.containsKey(moduleName))
    			SysLogger.info(moduleName + " isExist " + calzzMap.get(moduleName));
    		else
    			calzzMap.put(moduleName,getFullClassName(file));

    	}
    	
    }

	protected void handleFolder(Map<String,String> calzzMap,final String endsWith,final File folder) {
    	File[] allFiles = folder.listFiles();
    	
    	try {
    		for(File file:allFiles)
        		if(file.isFile())
        			handleFile(calzzMap,endsWith,file);
        		else
        			handleFolder(calzzMap,endsWith,file);    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    private String getFullClassName(final File classFile) {
    	String className = classFile.getAbsolutePath().substring(classPath.length(), classFile.getAbsolutePath().length() -6);
    	className = className.replace(File.separatorChar, '.').substring(1);
    	return className;
    }
    
}
