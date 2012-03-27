<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.b2c.common.helper.protocol.HttpUtils"%>
<%@page import="com.hnatourism.b2c.common.helper.json.JSONArray"%>
<%@page import="com.hnatourism.b2c.common.helper.json.JSONObject"%>
<%@page import="com.hnatourism.b2c.common.helper.json.parser.JSONParser"%>
<%@page import="com.hnatourism.framework.utils.PropertiesUtils"%>
<%
String money="";
try{
	String domain=PropertiesUtils.getVal("sysProps","api_server_flight");
	//domain="http://localhost:8580/B2C";
	String url=domain+"/portalPayAction!queryChannelAccountMoneyByCode.action?flag=DKXD";
	String resultStr=HttpUtils.getJsonFromServer(HttpUtils.getConnection(url));
	if(resultStr!=null&&!resultStr.trim().equals("")){
		JSONParser parser=new JSONParser();
		JSONObject root=(JSONObject)parser.parse(resultStr);
		money=(String)root.get("amount");
	}	
	
}
catch(Exception e){
	
}


%>
<%=money %>