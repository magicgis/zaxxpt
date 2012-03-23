<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
request.setAttribute("path",path); 
%>
<html>
<head>
   <title>Base ERROR</title>
   <link rel="stylesheet" href="${path}/resources/css/font_style.css" type="text/css"/>
   <style>
		A{cursor:pointer}
		A:link { cursor:pointer; color: #000000; TEXT-DECORATION: none;}
		A:visited { COLOR: #000000; TEXT-DECORATION: none}
		A:active  { COLOR: #3333ff; TEXT-DECORATION: none}
		A:hover   { COLOR: #ff0000; TEXT-DECORATION: none}
   </style>
   <script>
        function ShowMessage(){
	       var d = document.getElementById("err500");
	       var i = document.getElementById("ico");
	       if (d.style.display == "none") {
		      d.style.display = "";
			  i.src = "${path}/resources/images/up.png";
		   } else {
		      d.style.display = "none";
			  i.src = "${path}/resources/images/down.png";
		   }
	    }
   </script>
</head>

<body topmargin="20" leftmargin="20" rightmargin="20">
    <table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td width="4%" rowspan="4" align="right" valign="top"><img src="${path}/resources/images/icon-error.gif" width="32" height="32"></td>
        <td width="96%"><H1>Internet Explorer Action ϵͳ����!</H1></td>
      </tr>
      <tr>
        <td>
          <span class="bold">����ܵ�ԭ����:</span><br>
          <span class="TextGray">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${path}/resources/images/bullet.png"> ϵͳ��̨�������ش���<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${path}/resources/images/bullet.png"> ����վ���������⡣<br>
          </span><br>

          <span class="bold">�����Գ������²���:</span><br>
          <span class="TextGray">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${path}/resources/images/bullet.png"> ����ϵͳ������ϵ��<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${path}/resources/images/bullet.png"> <a href="javascript:history.back();"><span class="TextBlue">���ص���һҳ</span></a>
          </span><br>
        </td>
      </tr>
      <tr>
        <td height="46" valign="bottom">
          <a href="#" onClick="ShowMessage();"><img id="ico" src="${path}/resources/images/down.png" width="15" height="15" border="0"></a>&nbsp;
          <a href="#" onClick="ShowMessage();"><span class="IE6">������Ϣ</span></a>
        </td>
      </tr>
    </table>

	<div id="err500" style="display:none;width:100%;margin-left:80px;" class="TextGray">
        <s:property value="exception.message"/>
		<s:property value="exceptionStack" />
    </div>

</body>
</html>
