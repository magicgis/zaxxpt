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
  	<!-- ��ѯ���� -->
  		<div style="margin-left: 30px;margin-top: 30px;">
  			<input size="30">&nbsp;&nbsp;<input type="button" value="��  ѯ">
  			&nbsp;&nbsp;<a href="<%=basePath%>/system/user/user_info.jsp">��   ��</a>
  		</div>
  	<!-- ��ѯ��� -->
  		<div style="margin-top: 20px;" align="center">
  			<h3>�û��б���Ϣ</h3>
  		</div>
    	<div>
    		<table  border="1" width="90%">
    			<tr>
    				<th>���</th><th>�û�ID</th><th>�û���</th><th>�绰</th><th>�����ʼ�</th>
    				<th>�༭</th><th>ɾ��</th>
    			</tr>
				<tbody>
    			<c:forEach items="${master}" var="user" varStatus="status">
    				<tr>
    					<td>${status.index+1}</td><td>${user.id }&nbsp;</td><td>${user.username }&nbsp;</td>
    					<td>${user.phone}&nbsp;</td><td>${user.email}&nbsp;</td>
    					<td><a href="<%=basePath %>sys/user_view.action?selectId=${user.id}">�޸�</a></td>
    					<td><a href="<%=basePath %>sys/user_delete.action?selectId=${user.id}">ɾ��</a></td>
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
