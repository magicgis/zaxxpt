<%@page language="java" contentType="text/html;charset=GB2312"%>
<html>
<head>
    <title>������ʱ</title>
	<link rel="stylesheet" href="${path}/resources/css/font_style.css" type="text/css"/>
	<script>
	   function gotoURL() {
	      top.window.location.href = "${path}/index.jsp";
	   }
	</script>
</head>

<body>
	
	<div align="center" style="margin-top: 80px;">
		<table width="511" border="0" cellspacing="0" cellpadding="0" class="TextBlack">
		  <tr>
		    <td width="28"><img src="${path}/resources/images/msg_01.gif" width="28" height="27" /></td>
		    <td width="455" style="background:url(${path}/resources/images/msg_03.gif)" class="TextWhite1">ϵͳ��ʾ</td>
		    <td width="28"><img src="${path}/resources/images/msg_05.gif" width="28" height="27" /></td>
		  </tr>
		  <tr>
		    <td><img src="${path}/resources/images/msg_06.gif" width="28" height="138" /></td>
		    <td>
			    <table width="100%" border="0" cellspacing="4" cellpadding="0" class="TextBlack">
			      <tr>
			        <td width="20%" rowspan="3"><img src="${path}/resources/images/msg_00.gif" width="72" height="71" /></td>
			        <td width="80%" height="25" valign="top" class="EM3">������ʱ�������µ�¼��</td>
			      </tr>
			      <tr>
			        <td>Ϊʲô��Ҫ���µ�¼��</td>
			      </tr>
			      <tr>
			        <td>��������ʱ��δ����ϵͳ����������������⣬Ϊ��֤ϵͳ��ȫ���Զ��˳�ϵͳ���������µ�¼��</td>
			      </tr>
			    </table>
		    </td>
		    <td><img src="${path}/resources/images/msg_08.gif" width="28" height="138" /></td>
		  </tr>
		  <tr>
		    <td><img src="${path}/resources/images/msg_09.gif" width="28" height="51" /></td>
		    <td style="background:url(${path}/resources/images/msg_10.gif)" align="center">
		        <img src="${path}/resources/images/msglogin.gif" style="cursor: pointer;" onclick="gotoURL();"/>
		    </td>
		    <td><img src="${path}/resources/images/msg_11.gif" width="28" height="51" /></td>
		  </tr>
		</table>
	</div>
</body>
</html>