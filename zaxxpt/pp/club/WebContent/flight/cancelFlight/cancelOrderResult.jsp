<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.framework.utils.DateFormatUtils"%>
<%@page import="com.hnatourism.club.flight.web.vo.MemberPassengerVo"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/web/js/jquery1.3.2.js" language="javascript" type="text/javascript"></script>
<title>${domain_cn }</title>
</head>
<body>
<%@include file="/flight/order/orderControl.jsp" %>

<%			String msg = "";
              if("".equals(resultCode)||resultCode==null){
            	  msg = "取消订单成功";
              }
              else{
            	  msg = message;
              }
            %>
<div class="main">
	<center><h1><%=msg %>,5秒后跳转回<a href="${ctx}/flight/order/orderFlightDetail.jsp?orderId=<%=orderHotelId%>">订单详情</a>页面</h1></center>
</div>
<script type="text/javascript">
	setTimeout(function load(){
		window.location.href = "${pageContext.request.contextPath}/flight/order/orderFlightDetail.jsp?orderId=<%=orderHotelId%>";
	},5000);
</script>
</body>