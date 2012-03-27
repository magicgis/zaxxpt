<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.club.flight.web.vo.MemberPassengerVo"%>
<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hnatourism.club.common.helper.flight.TicketModifyResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.TicketModifyRequestMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightCabinInfoVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightInfoVo"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
<%
TicketModifyRequestMessage ticketModifyRequestMessage = new TicketModifyRequestMessage();
String passenger = request.getParameter("passenger");
String[] strArr = passenger.split("_");
String airlineCompanyCode = strArr[0];
String etNo = strArr[1];
String cabinCode = strArr[2];
String departureAirportCode = strArr[3];
String arrivalAirportCode = strArr[4];
String passengerId = strArr[5];
String passengerType = strArr[6];

String memberId = UserUtil.getUser(request.getSession().getId()).getId();
String orderId = request.getParameter("orderId");
if(!StringUtils.isEmpty(orderId)){
	ticketModifyRequestMessage.setOrderFlightId(orderId);
}
if(!StringUtils.isEmpty(memberId)){
	ticketModifyRequestMessage.setMemberId(memberId);
}
if(!StringUtils.isEmpty(passengerId)){
	ticketModifyRequestMessage.setPassengerId(passengerId);
}
ticketModifyRequestMessage.setSource("51666");

if("01".equals(passengerType)){
	ticketModifyRequestMessage.setTicketPrice(request.getParameter("adultTicketPrice"));
	ticketModifyRequestMessage.setBaf(request.getParameter("adultBaf"));
	ticketModifyRequestMessage.setConstructionFee(request.getParameter("adultConstructionFee"));
}else{
	ticketModifyRequestMessage.setTicketPrice(request.getParameter("childTicketPrice"));
	ticketModifyRequestMessage.setBaf(request.getParameter("childBaf"));
	ticketModifyRequestMessage.setConstructionFee(request.getParameter("childConstructionFee"));
}
ticketModifyRequestMessage.setAircraftType(request.getParameter("aircraftType"));
ticketModifyRequestMessage.setAirlineCompanyCode(airlineCompanyCode);
ticketModifyRequestMessage.setDepartureAirportCode(request.getParameter("departureAirportCode"));
ticketModifyRequestMessage.setArrivalAirportCode(request.getParameter("arrivalAirportCode"));
ticketModifyRequestMessage.setCabinCode(cabinCode);
ticketModifyRequestMessage.setDiscount(request.getParameter("discount"));
ticketModifyRequestMessage.setFlightNo(request.getParameter("flightNo"));
ticketModifyRequestMessage.setPolicyCode(request.getParameter("policyCode"));
ticketModifyRequestMessage.setCommissionRate(request.getParameter("commissionRate"));
ticketModifyRequestMessage.setDepartureDateStr(request.getParameter("date"));
ticketModifyRequestMessage.setDepartureTimeStr(request.getParameter("departureTimeStr")+":00");
ticketModifyRequestMessage.setArrivalDateStr(request.getParameter("date"));
ticketModifyRequestMessage.setArrivalTimeStr(request.getParameter("arrivalTimeStr")+":00");

String resultStr = "";
//发送请求并获取json字符串resultStr
try {
	resultStr = ticketModifyRequestMessage.excute2();
	//resultStr="{\"result\": {\"resultCode\":\"\",\"message\":\"\"}}";
	System.out.println(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
//定义解析json的对象
TicketModifyResponseMessage ticketModifyResponseMessage = new TicketModifyResponseMessage();
try {
	ticketModifyResponseMessage.parseResponse(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
//结果编码
String resultCode = ticketModifyResponseMessage.getResultCode();
//结果说明
String message = ticketModifyResponseMessage.getMessage();

%>