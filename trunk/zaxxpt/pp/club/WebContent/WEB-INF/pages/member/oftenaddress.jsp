<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightMemberPassenVo"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<title>我的常用客人信息</title>
<style type="text/css">
div.sortBy { border-left:1px solid #E5E5E5; border-right:1px solid #E5E5E5; padding:5px; margin-top:5px; }
div.sortBy span { float:none; margin:0 2px; border:1px solid #f7f7f7; padding:2px 4px; cursor:pointer; font-size:12px; font-family:Arial, Helvetica, sans-serif; }
div.sortBy span:hover { border:1px solid #ccc; background:#fff; }
</style>
<script type="text/javascript"> 
<%--截断文本框内容太长 --%>
jQuery.fn.limit=function(){ 
    var self = $("font[limit]"); 
    self.each(function(){ 
        var objString = $(this).text(); 
        var objLength = $(this).text().length; 
        var num = $(this).attr("limit"); 
        if(objLength > num){ 
$(this).attr("title",objString); 
            objString = $(this).text(objString.substring(0,num) + "..."); 
        } 
    }) 
} 
$(function(){ 
    $(document.body).limit(); 
}) 
</script>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
    <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
    <div class="listTAB rightbg">
        <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt;<span class="cl1">我的常用地址信息</span></div>
        <div id="Accountcenter">
            <div class="right_h">
                <ul>
                    <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
                    <li class="right_h_bg widtha">
                        <div class="grf_tag4" ><a href="javascript:void(0);" class="ontag">常用地址信息</a></div>
                    </li>
                    <li class="right_h_bg widthd"></li>
                    <li class="right Accountwidth"><img src="${ctx}/web/images/right_h_r.jpg"/></li>
                </ul>
            </div>
            <div class="clear"></div>
           <div id="Guests">
                    <ul>
                        <li>
                        	<font class="Guests1T">收件人姓名</font><font class="Guests2">联系电话</font><font class="Guests3">地址</font><font class="Guests4">邮编</font><font class="Guests6">操作</font>
                        	<input type="hidden" id="pgsum" value="<s:property value="passengerlist.size"/>"/>
                        </li>
                    </ul>
                    <ul>
                    <s:iterator value="passengerlist" var="pg" status="item">
                    	<li class="greytext" name="liebiao">
                    		<font class="Guests1">
                    			<s:property value="#pg.name" default="无"/>
                    		</font>
                    		<font class="Guests2" >
                    			<s:property value="#pg.mobile" default="无" />
                    		</font>
                    		<font class="Guests3" limit="6">
                    			<s:property value="#pg.address" default="无"/>
                    		</font>
                    		<font class="Guests4"><s:property value="#pg.postcode" default="无"/></font>
                    		<font class="Guests5"> 
                    			<a href="${ctx}/memberPassengerAddrAction!toAdd.action?action=upd&id=<s:property value="#pg.id"/>" class="cl2">修改</a>&nbsp;&nbsp;&nbsp;
                    			<a href="javascript:if(confirm('确定删除数据?')){location.href='${ctx}/memberPassengerAddrAction!del.action?id=<s:property value="#pg.id"/>'}" class="cl2">删除</a></font>
                    	</li>
                    </s:iterator>
                    <li><div align="right"><a href="#" onclick="location.href='${ctx}/memberPassengerAddrAction!toAdd.action?action=add'" class="button_qx">添加</a></div></li>
                   </ul><br>
                   
                </div>
                
<!-----------------------------------------RIGHT END------------------------------------>

<div class="clear"></div>
</div>
</div>
</div>
</div>
</body>
