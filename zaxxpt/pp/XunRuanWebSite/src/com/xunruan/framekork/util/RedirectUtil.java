package com.xunruan.framekork.util;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class RedirectUtil {
	public static String dealurl(HttpServletRequest request){
	      String url="";
	      url=request.getRequestURL()+"?";
	      url+=param(request);
	      if(url.indexOf("&")>-1){
	          url=url.replace("&", "@@");
	      }
	      return url;
	   }
	 
	   public static String param(HttpServletRequest request) {
	       String url = "";
	       Enumeration param = request.getParameterNames();
	       while (param.hasMoreElements()) {
	           String pname = (String) param.nextElement();
	           url+=pname+"="+request.getParameter(pname)+"&";
	       }
	       if(url.endsWith("&")){
	           url=url.substring(0, url.lastIndexOf("&"));
	       }
	       return url;
	   }   
	      
	   public static String geturl(String url){
	       if(url.indexOf("@@")>-1){
	           url=url.replaceAll("@@","&");
	       }
	       return url;
	   }
}