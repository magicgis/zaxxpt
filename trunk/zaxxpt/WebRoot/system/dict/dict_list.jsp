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
  			&nbsp;&nbsp;<a href="<%=basePath%>/system/dict/dict_info.jsp">添   加</a>
  		</div>
  <!-- 查询结果 -->
  		<div style="margin-top: 20px;width:900px;" align="center">
  			<h3>系统字典列表信息</h3>
    		<table  border="1" width="100%">
    			<tr>
    				<th>序号</th><th>字典类型</th><th>代码</th>
    				<th>编辑</th><th>删除</th>
    			</tr>
				<tbody>
    			<c:forEach items="${master}" var="dict" varStatus="status">
    				<tr>
    					<td>${status.index+1}</td><td>${dict.dicttype }</td><td>${dict.dictcode}&nbsp;</td>
    					<td><a href="<%=basePath %>sys/dict_view.action?selectId=${dict.id}">修改</a></td>
    					<td><a href="<%=basePath %>sys/dict_delete.action?selectId=${dict.id}">删除</a></td>
    				</tr>
    			</c:forEach>
    			</tbody>
    		</table>
    		<div style="margin-top: 20px" align="center">
    		<page:page controller="/sys/dict_query.action" pageEntity="${page}"/>
    		</div>
    	</div>
  </body>
</html>
