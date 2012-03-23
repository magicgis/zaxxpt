<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="ext" uri="/ext3" %>

<ext:html>
  <head>
	 <ext:init href="${path}" lang="CN" />
	 <link rel="stylesheet" type="text/css" href="${path}/resources/css/body.css" />
	 <link rel="stylesheet" href="${path}/resources/css/font_style.css" type="text/css"/>
  </head>

<body style="border-left: #99bbe8 solid 1px;">
	<table width="100%" height="70%" border="0" cellpadding="5" cellspacing="0" class="TextBlack">
        <tr>
            <td width="38%" rowspan="2" align="right">
                <img src="${path}/resources/images/message.gif" border="0"/>
            </td>
	        <td width="62%" valign="bottom" class="TextRed">
	             ${message}
	        </td>
        </tr>
        <tr>
            <td valign="top"><a href="javascript:history.back();"><span class="TextBlue">·µ»Ø</span> </td>
        </tr>
	</table>
	
</body>
</ext:html>