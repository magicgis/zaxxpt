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
  
  <form name="dictForm" action="<%=basePath%>sys/dict_add.action" method="post" onsubmit="return subForm()">
  <table>
  	<tr><td>
		    名称：</td><td>  <input size="20" name="dictEntity.dictname" value="${master.dictname}">
	</td>
  	<tr><td><input type="hidden" name="dictEntity.id" value="${master.id}"/>
	               类型：</td><td> <input size="20" name="dictEntity.dicttype" value="${master.dicttype}"> 
	</td>
	<tr><td>
		    代码：</td><td>  <input size="20" name="dictEntity.dictcode" value="${master.dictcode}">
	</td>
	<tr><td colspan="2">
		    <input type="submit" id="submit" name="submit" value="添  加">
	</td></tr>
	</table> 
    </form>
  </body>
  <script type="text/javascript">
		var user='${master}';
		jQuery("#submit").val(isNaN(user)?"修  改":"添  加");
		
		function subForm(){
			var subVal=jQuery("#submit").val();
			if(subVal=="修  改") document.dictForm.action="<%=basePath%>sys/dict_edit.action";
			return true;
			
		}
	</script>
 
</html>
