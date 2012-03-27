<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@ page import="com.hnatourism.club.common.util.UserUtil"%>
<%
String sessionId = session.getId();
request.setAttribute("_user_",UserUtil.getUser(sessionId));

request.setAttribute("_userObj_",UserUtil.getUserObj());
response.setHeader("Pragma","No-cache");    
response.setHeader("Cache-Control","no-cache");    
response.setDateHeader("Expires", 0);
%>
<!--heaader begin-->
<div id="header">
      <div class="header">
        <div class="top">
            <h1><a href="${ctx}/index.jsp"> - ${domain_cn }</a></h1>
            <span class="login_info"> 
          <span class="account">
	      ${_user_.code}
	      </span>&nbsp;&nbsp;&nbsp;&nbsp;
	      <c:if test="${not empty _user_ }">
	      	<a href="${ctx}/member/index.jsp">个人中心</a> | <a href="${ctx}/loginout.action">退出</a> 
	      </c:if>
	      <c:if test="${empty _user_ }">
	      	<a href="${ctx}/member/login.jsp">登录 ${_user_}</a> <!-- 二期开放 | <a href="${ctx}/register.jsp">注册</a>-->
	      </c:if>
	      | <a href="${ctx}/help.jsp" target="_blank">帮助中心</a>
            </span> <em class="hot_line">服务热线：${site_tel}</em> </div>
        <!--header .top end-->
        <div class="nav"> <span class="l"></span>
            <ul>
                <li><a href="${ctx}/">首页</a></li>
                <li><a href="${ctx}/subject/memberApply.jsp">俱乐部会员申请</a></li>
                <li><a href="${ctx}/subject/memberIntroduction.jsp">${domain_cn}介绍</a></li>
                <li><a href="${ctx}/flight/index.jsp">机票预订</a></li>
                <li><a href="${ctx}/hotel/index.jsp">酒店预订</a></li>
                <li><a href="${ctx}/golf/index.jsp">高尔夫预订</a></li>
                <li><a href="${ctx}/lounge/index.jsp">机场休息室预订</a></li>
                <c:if test="${!empty _user_}">
					<li><a href="${ctx}/member/index.jsp">我的个人中心</a></li>
                </c:if>
            </ul>
            <span class="r"></span> </div>
        <!--nav end--> 
    </div>
</div>
<input type="hidden" id="navIndexL"/>
<script type="text/javascript">
$("#loginHeader").css({right:(screen.width-1000)/2+"px",top:"75px",background:"transparent"});
var ctxValue="${ctx}";
$(function(){
	//  导航  最后一条去掉分隔线
    $(".nav ul li:last-child").attr("class","last");
});
</script>
<!--heaader finish-->

