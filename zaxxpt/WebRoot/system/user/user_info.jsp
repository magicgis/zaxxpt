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
  
  <form name="userForm" action="<%=basePath%>sys/user_add.action" method="post" onsubmit="return subForm()">
  <table>
  	<tr><td><input type="hidden" name="userEntity.id" value="${master.id}"/>
	               用户名：</td><td> <input size="20" name="userEntity.username" value="${master.username}"> 
	</td>
	<tr><td>
		    姓名：</td><td>  <input size="20" name="userEntity.xm" value="${master.xm}">
	</td>
	<tr><td>
		    性别：</td><td> <input size="30" name="userEntity.sex" value="${master.sex}">
	</td>
	<tr><td>
		    电子邮件：</td><td> <input size="30" name="userEntity.email" value="${master.email}">
	</td>
	<tr><td>
		    电话：</td><td>  <input size="20" name="userEntity.phone" value="${master.phone}">
	</td>
	<tr><td>
		    身份证编号：</td><td> <input size="30" name="userEntity.zjhm" value="${master.zjhm}">
	</td>
	<tr><td>
		   警号：</td><td>  <input size="20" name="userEntity.jh" value="${master.jh}">
	</td>
	<tr><td>
		    办公电话：</td><td> <input size="20" name="userEntity.bgdh" value="${master.bgdh}">
	</td>
	<tr><td>
		    家庭电话：</td><td>  <input size="20" name="userEntity.jtdh" value="${master.jtdh}">
	</td>
	<tr><td>
		    传真：</td><td>  <input size="30" name="userEntity.fax" value="${master.fax}">
	</td>
	<tr><td>
		    办公地址：</td><td> <input size="30" name="userEntity.bgdz" value="${master.bgdz}">
	</td>
	<tr><td>
		    联系地址： </td><td>  <input size="20" name="userEntity.lxdz" value="${master.lxdz}">
	</td>
	<tr><td>
		   用户级别：</td><td> <input size="30" name="userEntity.yhjb" value="${master.yhjb}">
	</td>
	<tr><td>
		    组织机构：</td><td> <input size="30" name="userEntity.deptid" value="${master.deptid}">
	</td>
	<tr><td>
		    备注：</td><td> <input size="30" name="userEntity.remark" value="${master.remark}">
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
			if(subVal=="修  改") document.userForm.action="<%=basePath%>sys/user_edit.action";
			return true;
			
		}
	</script>
 
</html>
