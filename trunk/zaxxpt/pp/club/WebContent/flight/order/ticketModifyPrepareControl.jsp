<%@page import="com.hnatourism.club.flight.web.vo.OrderFlightLogVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.TicketCancelSearchlResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.TicketCancelSearchRequestMessage"%>
<%@page import="com.hnatourism.club.flight.web.vo.MemberPassengerVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightItineraryVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightContactVo"%>
<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.club.common.helper.flight.OrderFlightDetailRequestMessage"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.common.helper.flight.OrderFlightDetailResponseMessage"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
<%
OrderFlightDetailRequestMessage orderFlightDetailRequestMessage = new OrderFlightDetailRequestMessage();
TicketCancelSearchRequestMessage cancelSearchRequestMessage = new TicketCancelSearchRequestMessage();
String orderId = request.getParameter("orderId");
String orderCode = request.getParameter("orderCode");
if(!StringUtils.isEmpty(orderId)){
	orderFlightDetailRequestMessage.setOrderId(orderId);
	cancelSearchRequestMessage.setOrderCode(orderCode);
}
//发送请求并获取json字符串resultStr
String resultStr = "";
String resultStr2 = "";
try {
	resultStr = orderFlightDetailRequestMessage.excute();
	resultStr2 = cancelSearchRequestMessage.excute();
} catch (Exception e) {
	e.printStackTrace();
}
//定义解析json的对象
OrderFlightDetailResponseMessage orderFlightDetailResponseMessage = new OrderFlightDetailResponseMessage();
TicketCancelSearchlResponseMessage cancelSearchlResponseMessage = new TicketCancelSearchlResponseMessage();
try {
	orderFlightDetailResponseMessage.parseResponse(resultStr);
	cancelSearchlResponseMessage.parseResponse(resultStr2);
} catch (Exception e) {
	e.printStackTrace();
}

//订单ID
orderId = orderFlightDetailResponseMessage.getOrderId();
//订单号
String code = orderFlightDetailResponseMessage.getCode();
//订单日期
String createTime = DateUtils.format(orderFlightDetailResponseMessage.getCreateDate(),"yyyy-MM-dd HH:mm:ss");
//订单总额
String totalMoney=orderFlightDetailResponseMessage.getTotalMoney();
//保险金额
String totalInsurance = orderFlightDetailResponseMessage.getTotalinsurance();
if("null".equals(totalInsurance)||StringUtils.isEmpty(totalInsurance)){
	totalInsurance = "0";
}
//还需支付金额
String actualMoney = orderFlightDetailResponseMessage.getActualMoney();
//订单状态
String sts = orderFlightDetailResponseMessage.getSts();
//支付方式
String payType = orderFlightDetailResponseMessage.getPayType();
//支付状态
String paySts = orderFlightDetailResponseMessage.getPaySts();
//航班类型
String flightType = orderFlightDetailResponseMessage.getFlightType();
//去程航班信息
BookingFlightVo outBookingFlight = orderFlightDetailResponseMessage.getOutBookingFlight();
//返程航班信息
BookingFlightVo inBookingFlight = orderFlightDetailResponseMessage.getInBookingFlight();
//联系人信息
FlightContactVo flightContactVo = orderFlightDetailResponseMessage.getContact();
//行程单信息
FlightItineraryVo flightItineraryVo = orderFlightDetailResponseMessage.getFlightItineraryVo();
//总票价
String ticketPrice = orderFlightDetailResponseMessage.getTotalTicketPrice().toString();
//总机建费
String constructionPrice = orderFlightDetailResponseMessage.getTotalConstructionFee().toString();
//总燃油费
String bafPrice = orderFlightDetailResponseMessage.getTotalBaf().toString();
//日志信息
List<OrderFlightLogVo> orderFlightLogs = orderFlightDetailResponseMessage.getOrderFlightLogList();

//乘机人信息
List<MemberPassengerVo> flightPassengerList = new ArrayList<MemberPassengerVo>();
flightPassengerList = cancelSearchlResponseMessage.getFlightPassengers();
%>