<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.common.helper.flight.BookingResponseMessage"%>
<%@page import="com.hnatourism.club.flight.passenger.MemberPassengerVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightItineraryVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightContactVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.BookingRequestMessage"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
MemberInfoVo memberVo = new MemberInfoVo();
if(null != UserUtil.getUser(request.getSession().getId())){
	memberVo=UserUtil.getUser(request.getSession().getId());
}
String flightType = request.getParameter("flightType");
BookingRequestMessage bookingRequestMessage = new BookingRequestMessage();
bookingRequestMessage.setMemberId(memberVo.getId());
bookingRequestMessage.setIsFirst("0");
bookingRequestMessage.setOrderSts("00");
bookingRequestMessage.setPaySts("0");
bookingRequestMessage.setProdType("0");
if(flightType.equals("2")){
	bookingRequestMessage.setProdType("1");
}
bookingRequestMessage.setRmk("");
bookingRequestMessage.setSource("51666");

String departureAirport = request.getParameter("departureAirportName");
String arrivalAirport = request.getParameter("arrivalAirportName");
String departureDate = request.getParameter("departureDateName");
String reDepartureDate = request.getParameter("reDepartureDateName");

String pName = request.getParameter("pName");
String pType = request.getParameter("pType");
String pCertType = request.getParameter("pCertType");
String pCertNo = request.getParameter("pCertNo");

String cName = request.getParameter("cName");
String cMobile = request.getParameter("cMobile");
String cEmail = request.getParameter("cEmail");

String time = "00:00:00";

BookingFlightVo bookingGoFlightVo = new BookingFlightVo();
bookingGoFlightVo.setDepartureAirportCode(departureAirport);
bookingGoFlightVo.setArrivalAirportCode(arrivalAirport);
bookingGoFlightVo.setDepartureDate(DateUtils.String2Date(departureDate+" "+time));
bookingGoFlightVo.setArrivalDate(DateUtils.String2Date(departureDate+" "+time));
bookingGoFlightVo.setDepartureTimeStr(time);
bookingGoFlightVo.setArrivalTimeStr(time);
bookingGoFlightVo.setDepartureDateStr(departureDate);
bookingGoFlightVo.setArrivalDateStr(departureDate);
bookingGoFlightVo.setPersonNum(1L);
bookingGoFlightVo.setFlightType("1");
bookingGoFlightVo.setProdType("7");
bookingGoFlightVo.setSource("51666");
bookingGoFlightVo.setOrderType("0");
bookingGoFlightVo.setTicketType("0");
bookingGoFlightVo.setCabinPriceOld(new BigDecimal(0));
bookingGoFlightVo.setCabinSeatNum("0");
bookingGoFlightVo.setDiscount(new BigDecimal(0));
bookingGoFlightVo.setTicketPrice(new BigDecimal(0));
bookingGoFlightVo.setTotalBaf(new BigDecimal(0));
bookingGoFlightVo.setTotalConstructionFee(new BigDecimal(0));
bookingGoFlightVo.setTotalMoney(new BigDecimal(0));
bookingGoFlightVo.setTotalTicketPrice(new BigDecimal(0));
bookingGoFlightVo.setTotalCommissionRate("0");
bookingGoFlightVo.setAdultNum(0L);
bookingGoFlightVo.setAdultBaf(new BigDecimal(0));
bookingGoFlightVo.setAdultConstructionFee(new BigDecimal(0));
bookingGoFlightVo.setAdultTicketPrice(new BigDecimal(0));
bookingGoFlightVo.setAdultTicketPricePar("0");
bookingGoFlightVo.setChildNum(0L);
bookingGoFlightVo.setChildBaf(new BigDecimal(0));
bookingGoFlightVo.setChildConstructionFee(new BigDecimal(0));
bookingGoFlightVo.setChildTicketPrice(new BigDecimal(0));
bookingGoFlightVo.setChildTicketPricePar("0");
bookingGoFlightVo.setAirlineCompanyCode("CZ");
bookingGoFlightVo.setFlightOrigin("SZ");

bookingRequestMessage.setBookingGoFlightVo(bookingGoFlightVo);

if(flightType.equals("2")){
BookingFlightVo bookingReturnFlightVo = new BookingFlightVo();
bookingReturnFlightVo.setDepartureAirportCode(arrivalAirport);
bookingReturnFlightVo.setArrivalAirportCode(departureAirport);
bookingReturnFlightVo.setDepartureDate(DateUtils.String2Date(reDepartureDate,"yyyy-MM-dd"));
bookingReturnFlightVo.setArrivalDate(DateUtils.String2Date(reDepartureDate,"yyyy-MM-dd"));
bookingReturnFlightVo.setPersonNum(1L);
bookingReturnFlightVo.setFlightType("2");
bookingReturnFlightVo.setProdType("7");
bookingReturnFlightVo.setSource("51666");
bookingReturnFlightVo.setOrderType("0");
bookingReturnFlightVo.setTicketType("0");
bookingReturnFlightVo.setCabinPriceOld(new BigDecimal(0));
bookingReturnFlightVo.setCabinSeatNum("0");
bookingReturnFlightVo.setDiscount(new BigDecimal(0));
bookingReturnFlightVo.setTicketPrice(new BigDecimal(0));
bookingReturnFlightVo.setTotalBaf(new BigDecimal(0));
bookingReturnFlightVo.setTotalConstructionFee(new BigDecimal(0));
bookingReturnFlightVo.setTotalMoney(new BigDecimal(0));
bookingReturnFlightVo.setTotalTicketPrice(new BigDecimal(0));
bookingReturnFlightVo.setTotalCommissionRate("0");
bookingReturnFlightVo.setAdultNum(0L);
bookingReturnFlightVo.setAdultBaf(new BigDecimal(0));
bookingReturnFlightVo.setAdultConstructionFee(new BigDecimal(0));
bookingReturnFlightVo.setAdultTicketPrice(new BigDecimal(0));
bookingReturnFlightVo.setAdultTicketPricePar("0");
bookingReturnFlightVo.setChildNum(0L);
bookingReturnFlightVo.setChildBaf(new BigDecimal(0));
bookingReturnFlightVo.setChildConstructionFee(new BigDecimal(0));
bookingReturnFlightVo.setChildTicketPrice(new BigDecimal(0));
bookingReturnFlightVo.setChildTicketPricePar("0");
bookingReturnFlightVo.setAirlineCompanyCode("CZ");
bookingReturnFlightVo.setFlightOrigin("SZ");
bookingRequestMessage.setBookingReturnFlightVo(bookingReturnFlightVo);
}

FlightContactVo flightContactVo = new FlightContactVo();
flightContactVo.setId(memberVo.getId());
flightContactVo.setName(cName);
flightContactVo.setMobile(cMobile);
flightContactVo.setEmail(cEmail);
flightContactVo.setProdType("F");

bookingRequestMessage.setFlightContactVo(flightContactVo);

FlightItineraryVo flightItineraryVo = new FlightItineraryVo();
flightItineraryVo.setDeliveryType("0");

bookingRequestMessage.setFlightItineraryVo(flightItineraryVo);

List<MemberPassengerVo> flightPassengerVoList = new ArrayList<MemberPassengerVo>();
MemberPassengerVo memberPassengerVo = new MemberPassengerVo();
memberPassengerVo.setType(pType);
memberPassengerVo.setName(pName);
memberPassengerVo.setCertType(pCertType);
memberPassengerVo.setCertNo(pCertNo);
flightPassengerVoList.add(memberPassengerVo);

bookingRequestMessage.setFlightPassengerVoList(flightPassengerVoList);

//接受错误信息
String errorMsg="";
//发送请求并获取json字符串resultStr
String resultStr = "";
try {
	resultStr = bookingRequestMessage.excute2();
} catch (Exception e) {
	errorMsg = e.getMessage()+"\r\n";
	e.printStackTrace();
}

//定义解析json的对象
BookingResponseMessage bookingResponseMessage = new BookingResponseMessage();
try {
	bookingResponseMessage.parseResponse(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
errorMsg+=bookingResponseMessage.getMessage();

if(StringUtils.isEmpty(errorMsg)) {
%>
<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript">
window.location="${ctx}/flight/order/orderFlightDetail.jsp?orderId=<%=bookingResponseMessage.getPayVo().getOrderId()%>";
</script>
<%
}else{
%>
<script>
var errorMsg='<%=errorMsg%>';
alert('预订失败!	错误原因:'+errorMsg);
window.location.href="search.jsp";
</script>
<%} %>
