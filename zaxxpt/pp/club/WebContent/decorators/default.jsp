<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@ page import="com.hnatourism.club.common.helper.protocol.Constants"%>
<%@include file="/common/include/tags-lib.jsp"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%
	// 来源
	String isource = null;
	String url = request.getRequestURL().toString(); 
	String uri = request.getRequestURI(); 
	String hoturl = url.replace(uri,"");
	if("/".equals(uri)&& url !=null && url.length()>0){
		hoturl = url.substring(0,url.length()-1);
	}
	
	//isource = request.getParameter("isource");
	String sessionId = session.getId();
	if(StringUtils.isEmpty(isource)){// 二级域名（ihzly.xhlx.cn）使用之前兼容用
		isource = request.getParameter("isource");
		if(StringUtils.isEmpty(isource)){
			isource = (String)session.getAttribute("isource_"+sessionId);
		}
	}
	session.setAttribute("isource_"+sessionId,isource);
	request.setAttribute("isource",isource);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
			<meta http-equiv="x-ua-compatible" content="ie=7" />
			<script type="text/javascript" src="${ctx}/web/js/jquery/js/jquery-1.5.2.min.js"></script>
     	<title>
     	<decorator:title  />
        </title> 
     	<decorator:head />
    </head>
	<body>
		<page:applyDecorator page="/decorators/header.jsp" name="main" />
        <decorator:body />
        <page:applyDecorator page="/decorators/footer.jsp" name="main" />
	</body>
</html>