<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.club.common.helper.flight.OrderCancelResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.OrderCancelRequestMessage"%>
<%@page import="com.hnatourism.club.flight.web.vo.MemberPassengerVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightItineraryVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightContactVo"%>
<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
<%
OrderCancelRequestMessage orderCancelRequestMessage = new OrderCancelRequestMessage();
String orderCode = request.getParameter("orderCode");
String orderHotelId = request.getParameter("orderId");
String memberId = UserUtil.getUser(request.getSession().getId()).getId();
if(!StringUtils.isEmpty(orderCode)){
	orderCancelRequestMessage.setOrderCode(orderCode);
}
if(!StringUtils.isEmpty(memberId)){
	orderCancelRequestMessage.setMemberId(memberId);
}
//OrderHotelId可以为空
orderCancelRequestMessage.setOrderHotelId("");
//发送请求并获取json字符串resultStr
String resultStr = "";
try {
	resultStr = orderCancelRequestMessage.excute();
	//resultStr="{\"result\": {\"resultCode\":\"123\",\"message\":\"订单号不存在\"},\"orderId\":\"629bb24326a148b78210299dd70e31c1\",\"code\":\"013671980\",\"createTime\":\"2011/08/25\",\"totalMoney\":\"3615\",\"actualMoney\":\"3615\",\"sts\":\"02\",\"payType\":\"netbank\",\"paySts\":\"0\",\"flightType\":\"1\",\"outBookingFlight\":{\"depAirportCode\":\"PEK\",\"depAirportCN\":\"北京首都\",\"arrAirportCode\":\"CAN\",\"arrAirportCN\":\"广州\",\"airlineCompany\":\"南航\",\"airlineCompanyCode\":\"CZ\",\"pnr\":\"JFC4JJ\",\"cabinRule\":\"一、更改条件：同等舱位免费更改。二、退票条件：需收取票面价5％的退票费。三、签转条件：不得签转。   \",\"flightNo\":\"3108\",\"cabinCode\":\"P\",\"cabinPrice\":\"3298\",\"deStop\":\"null\",\"arStop\":\"null\",\"cabinCN\":\"经济舱\",\"departureDate\":\"2011/09/09\",\"departureTime\":\"08:30\",\"arrivalTime\":\"11:45\"},\"flightPassenger\":[{\"passengerId\":\"254b0871467640e591813e36072e8aef\",\"name\":\"田永刚\",\"type\":\"01\",\"certType\":\"0\",\"certNo\":\"325556556565656565\",\"etNo\":\"null\",\"ticketSts\":\"00\",\"ticketPrice\":\"3400\",\"bafPrice\":\"150\",\"constructionPrice\":\"50\"}],\"rmk\":\"asdfasdf\",\"contact\":{\"name\":\"田永刚测试\",\"phone\":\"15210826379\",\"email\":\"dfdf@sdf.com\"},\"itinerary\":{\"address\":\"sdfasdf\",\"city\":\"100000001634\",\"deliveryType\":\"1\",\"deliveryFee\":\"15\",\"mobile\":\"15200000000\",\"postcode\":\"134561\",\"catchUser\":\"asdfasd\"}}";
	System.out.println(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
//定义解析json的对象
OrderCancelResponseMessage orderCancelResponseMessage = new OrderCancelResponseMessage();
try {
	orderCancelResponseMessage.parseResponse(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
//结果编码
String resultCode = orderCancelResponseMessage.getResultCode();
//结果说明
String message = orderCancelResponseMessage.getMessage();

%>