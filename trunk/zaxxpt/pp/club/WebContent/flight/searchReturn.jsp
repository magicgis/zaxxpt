<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>

<%
MemberInfoVo memberVo=UserUtil.getUser(request.getSession().getId());
%>
<%if(memberVo==null){
	response.sendRedirect(request.getContextPath()+"/member/login.jsp");
}
%>
<%else {//跳转到预定页面
	request.setAttribute("memberVo",memberVo);//登陆之后放置memberVo对象到request作用域中
%>
<jsp:forward page="/WEB-INF/pages/flight/prod/searchReturn.jsp"></jsp:forward>
<%} %>
