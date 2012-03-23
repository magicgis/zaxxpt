<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type="text/javascript">
  	/*var s="stringEntity[11].username";
  	var i=9;
  	alert(s.replace(/\[\d+\]/g,i));*/
  </script>
  
  </head>
  <body> <form action="<%=basePath %>platform/login_enter.action" name="loginFrom" method="post">
     <div style=" marign-top:300px;marign-left: 300px;width:300px;height:200px;">
     	<h4  style="margin-left: 80px;">用户登录</h4>
     	<div style="margin-left: 30px;">
     		<table align="center" ><tr><td>用户名：</td><td><input name="userEntity.username" value="cesss"/></td></tr>
     		<tr><td>密码：</td><td><input name="userEntity.password" type="password" value="123456"/></td></tr>
     		<tr><td>&nbsp;</td><td><input type="submit" value="登  陆">
     					<input type="reset" value="取 消">
     				</td></tr>
     		</table>
     	</div>
     </div></form>
  </body>
</html>
