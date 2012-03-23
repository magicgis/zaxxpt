<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_info.jsp' starting page</title>
    <script type="text/javascript" src="<%=basePath %>system/js/jquery-1.3.2.js"></script>
	
  </head>
  <body>
    <table>
  	<tr><td>
		   菜单ID：</td><td>${master.menuid}
	</td>
  	<tr><td>
		    操作：</td><td>${master.type}
	</td>
  	<tr><td>
		    用户ID：</td><td>${master.userid}
	</td>
  	<tr><td>
	               时间：</td><td>${master.datetime}
	</td>
  	<tr><td>
	     IP：</td><td>${master.ip}
	</td>
	<tr><td colspan="2">
		<a href="<%=basePath %>/sys/log_query.action">返  回 列 表</a>
	</td></tr>
	</table> 
  </body>
</html>
