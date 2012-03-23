<%@page language="java" contentType="text/html;charset=GB2312"%>
<html>
<head>
    <title>权限不够</title>
	<link rel="stylesheet" href="${path}/resources/css/font_style.css" type="text/css"/>
</head>

<body>

	<div align="center" style="margin-top: 80px;">
		<table width="511" border="0" cellspacing="0" cellpadding="0" class="TextBlack">
		  <tr>
		    <td width="28"><img src="${path}/resources/images/msg_01.gif" width="28" height="27" /></td>
		    <td width="455" style="background:url(${path}/resources/images/msg_03.gif)" class="TextWhite1">系统提示</td>
		    <td width="28"><img src="${path}/resources/images/msg_05.gif" width="28" height="27" /></td>
		  </tr>
		  <tr>
		    <td style="border-bottom: solid #608da8 1px;"><img src="${path}/resources/images/msg_06.gif" width="28" height="138" /></td>
		    <td style="border-bottom: solid #608da8 1px;">
			    <table width="100%" border="0" cellspacing="4" cellpadding="0" class="TextBlack">
			      <tr>
			        <td width="20%" rowspan="3"><img src="${path}/resources/images/msg_00.gif" width="72" height="71" /></td>
			        <td width="80%" height="25" valign="top" class="EM3">您的权限不够，可以与系统管理员联系!</td>
			      </tr>
			      <tr>
			        <td>为什么需要与系统管理员联系？</td>
			      </tr>
			      <tr>
			        <td>为了系统安全，系统管理员通过权限管理程序来为每位用户分配相应的使用权限，如果您需要使用此功能，可以联系系统管理员为您分配此权限。</td>
			      </tr>
			    </table>
		    </td>
		    <td style="border-bottom: solid #608da8 1px;"><img src="${path}/resources/images/msg_08.gif" width="28" height="138" /></td>
		  </tr>
		</table>
	</div>
	
</body>
</html>