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
	               �û�����</td><td> <input size="20" name="userEntity.username" value="${master.username}"> 
	</td>
	<tr><td>
		    ������</td><td>  <input size="20" name="userEntity.xm" value="${master.xm}">
	</td>
	<tr><td>
		    �Ա�</td><td> <input size="30" name="userEntity.sex" value="${master.sex}">
	</td>
	<tr><td>
		    �����ʼ���</td><td> <input size="30" name="userEntity.email" value="${master.email}">
	</td>
	<tr><td>
		    �绰��</td><td>  <input size="20" name="userEntity.phone" value="${master.phone}">
	</td>
	<tr><td>
		    ���֤��ţ�</td><td> <input size="30" name="userEntity.zjhm" value="${master.zjhm}">
	</td>
	<tr><td>
		   ���ţ�</td><td>  <input size="20" name="userEntity.jh" value="${master.jh}">
	</td>
	<tr><td>
		    �칫�绰��</td><td> <input size="20" name="userEntity.bgdh" value="${master.bgdh}">
	</td>
	<tr><td>
		    ��ͥ�绰��</td><td>  <input size="20" name="userEntity.jtdh" value="${master.jtdh}">
	</td>
	<tr><td>
		    ���棺</td><td>  <input size="30" name="userEntity.fax" value="${master.fax}">
	</td>
	<tr><td>
		    �칫��ַ��</td><td> <input size="30" name="userEntity.bgdz" value="${master.bgdz}">
	</td>
	<tr><td>
		    ��ϵ��ַ�� </td><td>  <input size="20" name="userEntity.lxdz" value="${master.lxdz}">
	</td>
	<tr><td>
		   �û�����</td><td> <input size="30" name="userEntity.yhjb" value="${master.yhjb}">
	</td>
	<tr><td>
		    ��֯������</td><td> <input size="30" name="userEntity.deptid" value="${master.deptid}">
	</td>
	<tr><td>
		    ��ע��</td><td> <input size="30" name="userEntity.remark" value="${master.remark}">
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
			if(subVal=="��  ��") document.userForm.action="<%=basePath%>sys/user_edit.action";
			return true;
			
		}
	</script>
 
</html>
