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
  
  <form name="dutyForm" action="<%=basePath%>sys/duty_add.action" method="post" onsubmit="return subForm()">
  <table>
  	<tr><td><input type="hidden" name="dutyEntity.id" value="${master.id}"/>
	               职务编号：</td><td> <input size="20" name="dutyEntity.dutyno" value="${master.dutyno}"> 
	</td>
  	<tr><td>
		    职务名称：</td><td>  <input size="20" name="dutyEntity.dutyname" value="${master.dutyname}">
	</td>
  	<tr><td>
		    备注：</td><td>  <input size="20" name="dutyEntity.remark" value="${master.remark}">
	</td>
	<tr><td colspan="2">
		    <input type="submit" id="submit" name="submit" value="添  加">
	</td></tr>
	</table> 
    </form>
  </body>
  <script type="text/javascript">
		var master='${master}';
		jQuery("#submit").val(isNaN(master)?"修  改":"添  加");
		
		function subForm(){
			var subVal=jQuery("#submit").val();
			if(subVal=="修  改") document.dutyForm.action="<%=basePath%>sys/duty_edit.action";
			return true;
			
		}
	</script>
 
</html>
