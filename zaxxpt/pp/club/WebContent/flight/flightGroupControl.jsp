<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightGroupResponseMessage"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightGroupVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightGroupRequestMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
MemberInfoVo memberInfoVo = new MemberInfoVo();
if(null != UserUtil.getUser(request.getSession().getId())){
	 memberInfoVo=UserUtil.getUser(request.getSession().getId());
}
FlightGroupVo flightGroupVo = new FlightGroupVo();
flightGroupVo.setOriginCity(request.getParameter("originCityName"));
flightGroupVo.setDestinationsCity(request.getParameter("destinationsCityName"));
flightGroupVo.setStartTime(request.getParameter("startTimeName"));
flightGroupVo.setName(request.getParameter("nameName"));
flightGroupVo.setContact(request.getParameter("contactName"));
flightGroupVo.setTotalNumber(request.getParameter("totalNumberName"));
flightGroupVo.setPrice(request.getParameter("priceName"));
if(null == request.getParameter("priceName")|| "".equals(request.getParameter("priceName"))){
	flightGroupVo.setPrice("1");
}

flightGroupVo.setGroupDesire(request.getParameter("groupDesireName"));
flightGroupVo.setEmail(memberInfoVo.getEmail());
flightGroupVo.setMemberId(memberInfoVo.getId());
flightGroupVo.setMemberCode(memberInfoVo.getCode());
flightGroupVo.setIsLogin("2");
flightGroupVo.setSource("51666");
FlightGroupRequestMessage flightGroupRequestMessage = new FlightGroupRequestMessage();
flightGroupRequestMessage.setFlightGroupVo(flightGroupVo);

//发送请求并获取json字符串resultStr
String resultStr = "";
try {
	resultStr = flightGroupRequestMessage.excute2();
} catch (Exception e) {
	e.printStackTrace();
}

//定义解析json的对象
FlightGroupResponseMessage flightGroupResponseMessage = new FlightGroupResponseMessage();
try {
	flightGroupResponseMessage.parseResponse(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
judge = flightGroupResponseMessage.getJudge();
%>


