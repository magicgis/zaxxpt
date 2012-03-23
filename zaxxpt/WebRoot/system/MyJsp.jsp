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
  <body> 
     <form action="<%=basePath%>/sys/user_add.action" method="post">
    	<input type="text" name="userEntity.username" value="张三"/>
    	<input type="text" name="userEntity.sex" value="1"/>
    	<input type="text" name="userEntity.email" value="25"/>
    	<input type="submit" value="提交"/>
    </form>
    <a href="<%=basePath%>sys/user_query.action">用户列表</a>
    <a href="<%=basePath%>sys/dict_query.action">系统字典列表</a>
    <a href="<%=basePath%>sys/duty_query.action">职务列表</a>
    <a href="<%=basePath%>sys/role_query.action">角色列表</a>
    <a href="<%=basePath%>sys/log_query.action">日志列表</a>
    <a href="<%=basePath%>sys/dept_query.action">组织机构列表</a>
  </body>
</html>
