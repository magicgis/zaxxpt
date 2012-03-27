<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@ page import="com.hnatourism.club.common.helper.protocol.Constants"%>
<html>
<head></head>
<body>
<% 
	String url = request.getRequestURL().toString(); 
	String uri = request.getRequestURI(); 
	String hoturl = url.replace(uri,"");
	String isource = null;
	String sessionId = session.getId();
	isource = (String)session.getAttribute("isource_"+sessionId);
	if(StringUtils.isEmpty(isource)){
		if("/".equals(uri)&& url !=null && url.length()>0){
			hoturl = url.substring(0,url.length()-1);
		}
		//根据二级域名设定来源
	}
	String ctx=request.getContextPath();
	String logout = ctx+"/flight/searchFlightBox.jsp?isource="+isource;
	session.removeAttribute("user_"+sessionId);
	session.invalidate();
	response.sendRedirect(logout);
%>
</body>
</html>