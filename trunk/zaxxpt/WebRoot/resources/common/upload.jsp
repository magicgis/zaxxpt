<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="s" uri="/struts-tags"%> 
<%@taglib prefix="ext" uri="/ext3" %>

<%--由upload.js文件控制,upload.js文件放在home.jsp引入--%>

<ext:html>

<head>
	<ext:init href="${path}" lang="CN" />
	
	<link rel="stylesheet" href="${path}/resources/css/font_style.css" type="text/css"/>
	
	<c:if test="${method eq 'success'}">
	    <script>
		    top.uploadFile         = '${uploadFile}';
		    top.uploadFileName     = '${uploadFileName}';
		    top.uploadFileNameExt  = '${uploadFileNameExt}';
		    top.uploadFileNameSize = '${uploadFileNameSize}';
			top.uploadFileRemark   = '${uploadFileRemark}';
			top.uploadFileUserid   = '${uploadFileUserid}';
			top.uploadFileUsername = '${uploadFileUsername}';
			top.uploadFileDate     = '${uploadFileDate}';
		    top.uploadWindow.close();
	    </script>
	</c:if>
	<c:if test="${method ne 'success'}">
	    <script>
			top.uploadFile         = '';
		    top.uploadFileName     = '';
		    top.uploadFileNameExt  = '';
		    top.uploadFileNameSize = '';
			top.uploadFileRemark   = '';
			top.uploadFileUserid   = '';
			top.uploadFileUsername = '';
			top.uploadFileDate     = '';
	    </script>
	</c:if>

</head>

<body topmargin="0" leftmargin="0">
	<s:form id="uploadForm" name="uploadForm" action="/files/upload.action" method="post" enctype="multipart/form-data">
		 <input type="hidden" name="method" value="upload" >
		 <input type="hidden" name="uploadFileUserid" value="${loginEntity.id}" >
		 <input type="hidden" name="uploadFileUsername" value="${loginEntity.username}" >
		 
         <table border="0" align="center" cellpadding="0" cellspacing="10" class="Labels">
			<tr>
			  <td width="50">上传文件</td> 
			  <td height="20">
		          <input id="file" type="file" name="upload" onkeydown='return false' size="32" class=" x-form-text x-form-field"/>
		   	  </td>
			</tr>
			<tr>
			  <td valign="top">文件备注</td> 
			  <td><ext:textarea id="remark" name="uploadFileRemark" size="400" width="260" blank="true" value=""/></td>
			</tr>
         </table>
	</s:form>
</body>
</ext:html>