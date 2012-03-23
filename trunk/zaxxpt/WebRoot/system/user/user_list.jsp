<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.sunshine.com"  prefix="page"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyUser.jsp' starting page</title>
  <script type="text/javascript" src="<%=basePath %>js/jquery-1.4.2.min.js"></script><!--
  	<script type='text/javascript' src='<%=basePath %>dwr/interface/userdwr.js'></script>
  	<script type='text/javascript' src='<%=basePath %>dwr/engine.js'></script>
  	<script type="text/javascript" src="<%=basePath %>dwr/util.js"></script>  
    --><script type="text/javascript">
    	/*function deleteInfo(objId){
    		userdwr.deletess({"selectId":objId},function(dt){alert(dt);
    			if(dt=="delete")alert("OK");
    		});
    	}*/
    </script>
  </head>
  <body>
  	<!-- 查询条件 -->
  		<div style="margin-left: 30px;margin-top: 30px;">
  			<input size="30">&nbsp;&nbsp;<input type="button" value="查  询">
  			&nbsp;&nbsp;<a href="<%=basePath%>/system/user/user_info.jsp">添   加</a>
  		</div>
  	<!-- 查询结果 -->
  		<div style="margin-top: 20px;" align="center">
  			<h3>用户列表信息</h3>
  		</div>
    	<div>
    		<table  border="1" width="90%">
    			<tr>
    				<th>序号</th><th>用户ID</th><th>用户名</th><th>电话</th><th>电子邮件</th>
    				<th>编辑</th><th>删除</th>
    			</tr>
				<tbody>
    			<c:forEach items="${master}" var="user" varStatus="status">
    				<tr>
    					<td>${status.index+1}</td><td>${user.id }&nbsp;</td><td>${user.username }&nbsp;</td>
    					<td>${user.phone}&nbsp;</td><td>${user.email}&nbsp;</td>
    					<td><a href="<%=basePath %>sys/user_view.action?selectId=${user.id}">修改</a></td>
    					<td><a href="<%=basePath %>sys/user_delete.action?selectId=${user.id}">删除</a></td>
    				</tr>
    			</c:forEach>
    			</tbody>
    		</table>
    		<div style="margin-top: 20px" align="center">
    		<page:page controller="/sys/user_query.action" pageEntity="${page}"/>
    		</div>
    	</div>
  </body>
</html>
