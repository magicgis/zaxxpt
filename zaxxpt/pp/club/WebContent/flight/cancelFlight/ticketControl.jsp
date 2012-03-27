<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.club.common.helper.flight.TicketCancelResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.TicketCancelRequestMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%
TicketCancelRequestMessage ticketCancelRequestMessage = new TicketCancelRequestMessage();
String[] passengerIds = request.getParameterValues("passengerId");
String cancelType = request.getParameter("cancelType");
String reason = request.getParameter("reason");
for(String clm :passengerIds){
	System.out.println(clm);
}
String resultCode = ""; 
String message = "";
String orderCode = request.getParameter("orderCode");
String orderId = request.getParameter("orderId");
String memberId =UserUtil.getUser(request.getSession().getId()).getId();
if(!StringUtils.isEmpty(memberId)){
	ticketCancelRequestMessage.setMemberId(memberId);
}
//System.out.println(orderCode);
if(!StringUtils.isEmpty(orderCode)){
	ticketCancelRequestMessage.setOrderCode(orderCode);
}
if(!StringUtils.isEmpty(cancelType)){
	ticketCancelRequestMessage.setCancelType(cancelType);
}
if(!StringUtils.isEmpty(reason)){
	ticketCancelRequestMessage.setReason(reason);
}
TicketCancelResponseMessage ticketCancelResponseMessage = new TicketCancelResponseMessage();
StringBuffer passengerId = new StringBuffer();
for(int i=0;i<passengerIds.length;i++){
	if(!StringUtils.isEmpty(passengerIds[i])){
		if(i==0){
			passengerId.append(passengerIds[i]);
		}else{
			passengerId.append(","+passengerIds[i]);
		}
	}	//OrderHotelId可以为空
}
System.out.println(passengerId.toString());
ticketCancelRequestMessage.setPassengerId(passengerId.toString());
String resultStr = "";
//发送请求并获取json字符串resultStr

try {
	resultStr = ticketCancelRequestMessage.excute2();
	//resultStr="{\"result\": {\"resultCode\":\"\",\"message\":\"\"}}";
	System.out.println(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
//定义解析json的对象

try {
	ticketCancelResponseMessage.parseResponse(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
//结果编码
resultCode = ticketCancelResponseMessage.getResultCode();

//结果说明
message = ticketCancelResponseMessage.getMessage();




%>