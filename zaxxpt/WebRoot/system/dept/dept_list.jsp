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
  			&nbsp;&nbsp;<a href="<%=basePath%>/system/dept/dept_info.jsp">��   ��</a>
  		</div>
  <!-- ��ѯ��� -->
  		<div style="margin-top: 20px;" align="center">
  			<h3>��֯�����б���Ϣ</h3>
  		</div>
    	<div>
    		<table  border="1" width="70%">
    			<tr>
    				<th>���</th><th>��֯�������</th><th>��֯��������</th><th>��ע</th><th>�ϼ���֯</th>
    				<th>�༭</th><th>ɾ��</th>
    			</tr>
				<tbody>
    			<c:forEach items="${master}" var="dept" varStatus="status">
    				<tr>
    					<td>${status.index}</td><td>${dept.deptno }&nbsp;</td>
    					<td><a href="<%=basePath %>sys/user_query.action?searchEntity.searchCmd=deptid=${dept.deptno }">${dept.deptname}</a>&nbsp;</td>
    					<td>${dept.remark}&nbsp;</td><td>${dept.parentdept}&nbsp;</td>
    					<td><a href="<%=basePath %>sys/dept_view.action?selectId=${dept.id}">�޸�</a></td>
    					<td><a href="<%=basePath %>sys/dept_delete.action?selectId=${dept.id}">ɾ��</a></td>
    				</tr>
    			</c:forEach>
    			</tbody>
    		</table>
    		<div style="margin-top: 20px" align="center">
    		<page:page controller="/sys/dept_query.action" pageEntity="${page}"/>
    		</div>
    	</div>
  </body>
</html>
