<%@page language="java" contentType="text/html;charset=GB2312"%>
<html>
<head>
	<link rel="stylesheet" href="${path}/resources/css/font_style.css" type="text/css"/>
</head>

<body>
	<div align="center" style="margin-top: 80px;">
		<table width="450" border="0" cellspacing="0" cellpadding="0" class="TextBlack">
		  <tr>
		    <td width="28"><img src="${path}/resources/images/msg_01.gif" width="28" height="27" /></td>
		    <td style="background:url(${path}/resources/images/msg_03.gif)" class="TextWhite1">系统提示</td>
		    <td width="28"><img src="${path}/resources/images/msg_05.gif" width="28" height="27" /></td>
		  </tr>
		  <tr>
		    <td><img src="${path}/resources/images/msg_06.gif" width="28" height="138" /></td>
		    <td>
			    <table width="100%" border="0" cellspacing="4" cellpadding="0" class="TextBlack">
			      <tr>
			        <td width="30%" rowspan="2" align="center"><img src="${path}/resources/images/msg_001.gif" /></td>
			        <td width="70%" class="EM3"><br/>保存失败。</td>
			      </tr>
			      <tr>
			        <td valign="top">原因：${replaceMessage}</td>
			      </tr>
			    </table>
		    </td>
		    <td><img src="${path}/resources/images/msg_08.gif" width="28" height="138" /></td>
		  </tr>
		  <tr>
		    <td><img src="${path}/resources/images/msg_09.gif" width="28" height="51" /></td>
		    <td style="background:url(${path}/resources/images/msg_10.gif)" align="center">
		        <img src="${path}/resources/images/msgreturn.gif" style="cursor: pointer;" onclick="javascript:history.back();"/>
		    </td>
		    <td><img src="${path}/resources/images/msg_11.gif" width="28" height="51" /></td>
		  </tr>
		</table>
	</div>
	
</body>
</html>