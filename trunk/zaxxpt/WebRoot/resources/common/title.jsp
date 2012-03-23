<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="ext" uri="/ext3" %>

<%--
��ҳ�湲2������
title
remark
--%>

<style type="text/css">
<!--
.TITLEFONTS {
	font-size: 14px;
	font-weight: bold;
	color: #000066;
}
.REMARKFONTS {
	font-size: 12px;
}
-->
</style>

<script>
   document.body.style.borderLeft = "#99bbe8 1px solid";
   document.body.style.borderRight = "#99bbe8 1px solid";
   document.body.style.borderBottom = "#99bbe8 1px solid";
   document.body.style.backgroundColor = "#deebf4";
</script>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background: url('${path}/resources/images/title.jpg') no-repeat;background-color:#deebf4">
  <tr>
    <td height="27" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="70%" height="25" class="TITLEFONTS">
	   &nbsp;
       <c:if test="${method eq 'append' || method eq 'copy'}">
       		�½� 
       </c:if>
       <c:if test="${method eq 'modify'}">
       		�޸� 
       </c:if>
       <c:if test="${method eq 'view'}">
       		��� 
       </c:if>
       ${param.title}
    </td>
    <td class="REMARKFONTS" align="right" valign="bottom">
    	${param.remark} 
  	    <ext:format date="${param.createdate}" format="yyyy-MM-dd HH:mm"></ext:format>
	    &nbsp;&nbsp;
	</td>
  </tr>
</table>