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
  
  <form name="roleForm" action="<%=basePath%>sys/role_add.action" method="post" onsubmit="return subForm()">
  <table>
  	<tr><td>
		    ���ƣ�</td><td>  <input size="20" name="roleEntity.rolename" value="${master.rolename}">
	</td>
  	<tr><td><input type="hidden" name="roleEntity.id" value="${master.id}"/>
	               ��ע��</td><td> <input size="20" name="roleEntity.remark" value="${master.remark}"> 
	</td>
	<tr><td colspan="2">
		    <input type="submit" id="submit" name="submit" value="��  ��">
	</td></tr>
	</table> 
    </form>
  </body>
  <script type="text/javascript">
		var user='${master}';
		jQuery("#submit").val(isNaN(user)?"��  ��":"��  ��");
		
		function subForm(){
			var subVal=jQuery("#submit").val();
			if(subVal=="��  ��") document.roleForm.action="<%=basePath%>sys/role_edit.action";
			return true;
			
		}
	</script>
 
</html>
