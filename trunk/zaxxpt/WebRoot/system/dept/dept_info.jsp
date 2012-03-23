<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dept_info.jsp' starting page</title>
    <script type="text/javascript" src="<%=basePath %>system/js/jquery-1.3.2.js"></script>
	
  </head>
  
  <body>
  
  <form name="deptForm" action="<%=basePath%>sys/dept_add.action" method="post" onsubmit="return subForm()">
  <table>
  	<tr><td><input type="hidden" name="deptEntity.id" value="${master.id}"/>
	               编号：</td><td> <input size="20" name="deptEntity.deptno" value="${master.deptno}"> 
	</td>
	<tr><td>
		组织机构名称：</td><td> <input size="20" name="deptEntity.deptname" value="${master.deptname}">
	</td>
	<tr><td>
		    备注：</td><td>  <input size="20" name="deptEntity.remark" value="${master.remark}">
	</td>
	<tr><td>
		    父级ID：</td><td> <input size="30" name="deptEntity.parentdept" value="${master.parentdept}">
	</td>
	<tr><td colspan="2">
		    <input type="submit" id="submit" name="submit" value="添  加">
	</td></tr>
	</table> 
    </form>
  </body>
  <script type="text/javascript">
		var dept='${master}';
		jQuery("#submit").val(isNaN(dept)?"修  改":"添  加");
		
		function subForm(){
			var subVal=jQuery("#submit").val();
			if(subVal=="修  改") document.deptForm.action="<%=basePath%>sys/dept_edit.action";
			return true;
			
		}
	</script>
 
</html>
