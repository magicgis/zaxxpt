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
		   �˵�ID��</td><td>${master.menuid}
	</td>
  	<tr><td>
		    ������</td><td>${master.type}
	</td>
  	<tr><td>
		    �û�ID��</td><td>${master.userid}
	</td>
  	<tr><td>
	               ʱ�䣺</td><td>${master.datetime}
	</td>
  	<tr><td>
	     IP��</td><td>${master.ip}
	</td>
	<tr><td colspan="2">
		<a href="<%=basePath %>/sys/log_query.action">��  �� �� ��</a>
	</td></tr>
	</table> 
  </body>
</html>
