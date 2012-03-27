<%@page import="com.hnatourism.club.flight.web.vo.FlightModifyVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightCancelVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.OrderFlightLogVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
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
String orderId = request.getParameter("orderId");
MemberInfoVo memberInfoVo=UserUtil.getUser(request.getSession().getId());
if(!StringUtils.isEmpty(orderId)){
	orderFlightDetailRequestMessage.setOrderId(orderId);
}
//发送请求并获取json字符串resultStr
String resultStr = "";
try {
	resultStr = orderFlightDetailRequestMessage.excute();
	//resultStr="{\"result\": {\"resultCode\":\"\",\"message\":\"\"},\"orderId\":\"629bb24326a148b78210299dd70e31c1\",\"code\":\"013671980\",\"createTime\":\"2011/08/25\",\"totalMoney\":\"3615\",\"actualMoney\":\"3615\",\"sts\":\"02\",\"payType\":\"netbank\",\"paySts\":\"0\",\"flightType\":\"1\",\"outBookingFlight\":{\"depAirportCode\":\"PEK\",\"depAirportCN\":\"北京首都\",\"arrAirportCode\":\"CAN\",\"arrAirportCN\":\"广州\",\"airlineCompany\":\"南航\",\"airlineCompanyCode\":\"CZ\",\"pnr\":\"JFC4JJ\",\"cabinRule\":\"一、更改条件：同等舱位免费更改。二、退票条件：需收取票面价5％的退票费。三、签转条件：不得签转。   \",\"flightNo\":\"3108\",\"cabinCode\":\"P\",\"cabinPrice\":\"3298\",\"deStop\":\"null\",\"arStop\":\"null\",\"cabinCN\":\"经济舱\",\"departureDate\":\"2011/09/09\",\"departureTime\":\"08:30\",\"arrivalTime\":\"11:45\"},\"flightPassenger\":[{\"passengerId\":\"254b0871467640e591813e36072e8aef\",\"name\":\"田永刚\",\"type\":\"01\",\"certType\":\"0\",\"certNo\":\"325556556565656565\",\"etNo\":\"null\",\"ticketSts\":\"00\",\"ticketPrice\":\"3400\",\"bafPrice\":\"150\",\"constructionPrice\":\"50\"}],\"rmk\":\"asdfasdf\",\"contact\":{\"name\":\"田永刚测试\",\"phone\":\"15210826379\",\"email\":\"dfdf@sdf.com\"},\"itinerary\":{\"address\":\"sdfasdf\",\"city\":\"100000001634\",\"deliveryType\":\"1\",\"deliveryFee\":\"15\",\"mobile\":\"15200000000\",\"postcode\":\"134561\",\"catchUser\":\"asdfasd\"}}";
	System.out.println(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
//定义解析json的对象
OrderFlightDetailResponseMessage orderFlightDetailResponseMessage = new OrderFlightDetailResponseMessage();
try {
	orderFlightDetailResponseMessage.parseResponse(resultStr);
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
List<BookingFlightVo> listBookingFlight=new ArrayList();
listBookingFlight.add(outBookingFlight);
listBookingFlight.add(inBookingFlight);
//乘机人信息
List<MemberPassengerVo> flightPassengerList = new ArrayList<MemberPassengerVo>();
flightPassengerList =orderFlightDetailResponseMessage.getFlightPassenger();
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
List<OrderFlightLogVo> orderFlightLogs = orderFlightDetailResponseMessage.getOrderFlightLogList();
//退票单信息
List<FlightCancelVo> flightCancelVoList = orderFlightDetailResponseMessage.getFlightCancelVoList();
//改期单信息
List<FlightModifyVo> flightModifyVoList = orderFlightDetailResponseMessage.getFlightModifyVoList();
%>