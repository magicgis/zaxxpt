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
	               ��ţ�</td><td> <input size="20" name="deptEntity.deptno" value="${master.deptno}"> 
	</td>
	<tr><td>
		��֯�������ƣ�</td><td> <input size="20" name="deptEntity.deptname" value="${master.deptname}">
	</td>
	<tr><td>
		    ��ע��</td><td>  <input size="20" name="deptEntity.remark" value="${master.remark}">
	</td>
	<tr><td>
		    ����ID��</td><td> <input size="30" name="deptEntity.parentdept" value="${master.parentdept}">
	</td>
	<tr><td colspan="2">
		    <input type="submit" id="submit" name="submit" value="��  ��">
	</td></tr>
	</table> 
    </form>
  </body>
  <script type="text/javascript">
		var dept='${master}';
		jQuery("#submit").val(isNaN(dept)?"��  ��":"��  ��");
		
		function subForm(){
			var subVal=jQuery("#submit").val();
			if(subVal=="��  ��") document.deptForm.action="<%=basePath%>sys/dept_edit.action";
			return true;
			
		}
	</script>
 
</html>
