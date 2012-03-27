<%@page import="com.hnatourism.club.common.helper.flight.BookingResponseMessage"%>
<%@page import="java.util.Date"%>
<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.common.helper.flight.BookingRequestMessage"%>
<%@page import="com.hnatourism.club.flight.passenger.MemberPassengerVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.MemberPassengerAddRequestMessage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightContactVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightItineraryVo"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

MemberInfoVo memberVo = new MemberInfoVo();
if(null != UserUtil.getUser(request.getSession().getId())){
	memberVo=UserUtil.getUser(request.getSession().getId());
}
BookingRequestMessage bookingRequestMessage = new BookingRequestMessage();
if(memberVo != null){
bookingRequestMessage.setMemberId(memberVo.getId());
}
bookingRequestMessage.setIsFirst("0");
String rmk = "";
bookingRequestMessage.setRmk(rmk);
String orderSts = "00";
bookingRequestMessage.setOrderSts(orderSts);
String paySts = "0";
bookingRequestMessage.setPaySts(paySts);
String prodType = "0";
if("2".equals(request.getParameter("bookingReturnFlightVo.flightType"))){
	prodType = "1";
}
bookingRequestMessage.setProdType(prodType);
String source = "51666";
bookingRequestMessage.setSource(source);

//乘机人人数
String passengerNumStr = request.getParameter("passengerNum");
int passengerNum = Integer.parseInt(passengerNumStr)+1;
//乘机人信息
ArrayList<MemberPassengerVo> flightPassengerVoList = new ArrayList<MemberPassengerVo>();
for(int i=0; i<passengerNum; i++){
	MemberPassengerVo memberPassengerVo = new MemberPassengerVo();
	memberPassengerVo.setName(request.getParameter("memberPassengerVoList["+i+"].passName"));
	memberPassengerVo.setCertType(request.getParameter("memberPassengerVoList["+i+"].credentials"));
	memberPassengerVo.setCertNo(request.getParameter("memberPassengerVoList["+i+"].idCard"));
	memberPassengerVo.setType(request.getParameter("memberPassengerVoList["+i+"].ticketsType"));
	memberPassengerVo.setId(request.getParameter("memberPassengerVoList["+i+"].id"));
	memberPassengerVo.setGoInsuranceNum(request.getParameter("memberPassengerVoList["+i+"].insure"));
	if("2".equals(request.getParameter("bookingReturnFlightVo.flightType"))){
		memberPassengerVo.setReturnInsuranceNum(request.getParameter("memberPassengerVoList["+i+"].insure"));
	}
	flightPassengerVoList.add(memberPassengerVo);
}
bookingRequestMessage.setFlightPassengerVoList(flightPassengerVoList);
long adultNum = 0;
long childNum = 0;
for(MemberPassengerVo m:flightPassengerVoList){
	if(m.getType().equals("01")){
		adultNum++;
	}
	if(m.getType().equals("02")){
		childNum++;
	}
}
BigDecimal goTicketPrice = new BigDecimal(request.getParameter("bookingGoFlightVo.adultTicketPrice"));
BigDecimal goTotalBaf = (new BigDecimal(request.getParameter("bookingGoFlightVo.adultBaf")).multiply(new BigDecimal(adultNum))).add((new BigDecimal(request.getParameter("bookingGoFlightVo.childBaf")).multiply(new BigDecimal(childNum))));
BigDecimal goTotalConstructionFee = (new BigDecimal(request.getParameter("bookingGoFlightVo.adultConstructionFee")).multiply(new BigDecimal(adultNum))).add((new BigDecimal(request.getParameter("bookingGoFlightVo.childConstructionFee")).multiply(new BigDecimal(childNum))));
BigDecimal goTotalTicketPrice = (new BigDecimal(request.getParameter("bookingGoFlightVo.adultTicketPrice")).multiply(new BigDecimal(adultNum))).add((new BigDecimal(request.getParameter("bookingGoFlightVo.childTicketPrice")).multiply(new BigDecimal(childNum))));
BigDecimal goTotalMoney = goTotalBaf.add(goTotalConstructionFee).add(goTotalTicketPrice);
//去程航班信息
BookingFlightVo bookingGoFlightVo = new BookingFlightVo();
bookingGoFlightVo.setPersonNum(Long.parseLong(passengerNumStr)+1);
bookingGoFlightVo.setAdultBaf(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.adultBaf"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.adultBaf")));
bookingGoFlightVo.setAdultConstructionFee(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.adultConstructionFee"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.adultConstructionFee")));
bookingGoFlightVo.setAdultNum(adultNum);
bookingGoFlightVo.setAdultTicketPrice(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.adultTicketPrice"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.adultTicketPrice")));
bookingGoFlightVo.setAircraftType(request.getParameter("bookingGoFlightVo.aircraftType"));
bookingGoFlightVo.setAirlineCompany(request.getParameter("bookingGoFlightVo.airlineCompany"));
bookingGoFlightVo.setAirlineCompanyCode(request.getParameter("bookingGoFlightVo.airlineCompanyCode"));
bookingGoFlightVo.setArrivalAirport(request.getParameter("bookingGoFlightVo.arrivalAirport"));
bookingGoFlightVo.setArrivalAirportCode(request.getParameter("bookingGoFlightVo.arrivalAirportCode"));
bookingGoFlightVo.setArrivalCity(request.getParameter("bookingGoFlightVo.arrivalAirportCode"));
Date dptDate = null;
Date arrDate = null;
try{
	dptDate = DateUtils.String2Date(request.getParameter("bookingGoFlightVo.departureDate"));
	arrDate = DateUtils.String2Date(request.getParameter("bookingGoFlightVo.arrivalDate"));
}catch(Exception e){
	e.printStackTrace();
}

bookingGoFlightVo.setArrivalDate(arrDate);
bookingGoFlightVo.setArrivalDateStr(request.getParameter("bookingGoFlightVo.arrivalDateStr"));
bookingGoFlightVo.setArrivalTimeStr(request.getParameter("bookingGoFlightVo.arrivalTimeStr"));
//bookingGoFlightVo.setBabyBaf(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.babyBaf"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.babyBaf")));
//bookingGoFlightVo.setBabyConstructionFee(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.babyConstructionFee"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.babyConstructionFee")));
//bookingGoFlightVo.setBabyTicketPrice(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.babyTicketPrice"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.babyTicketPrice")));
bookingGoFlightVo.setCabinCode(request.getParameter("bookingGoFlightVo.cabinCode"));
bookingGoFlightVo.setCabinPriceOld(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.adultTicketPricePar"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.adultTicketPricePar")));
bookingGoFlightVo.setCabinSeatNum(request.getParameter("bookingGoFlightVo.cabinSeatNum"));
bookingGoFlightVo.setChildTicketPrice(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.childTicketPrice"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.childTicketPrice")));
bookingGoFlightVo.setChildConstructionFee(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.childConstructionFee"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.childConstructionFee")));
bookingGoFlightVo.setChildNum(childNum);
bookingGoFlightVo.setChildBaf(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.childBaf"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.childBaf")));
bookingGoFlightVo.setDepartureAirport(request.getParameter("bookingGoFlightVo.departureAirport"));
bookingGoFlightVo.setDepartureAirportCode(request.getParameter("bookingGoFlightVo.departureAirportCode"));
bookingGoFlightVo.setDepartureCity(request.getParameter("bookingGoFlightVo.departureAirportCode"));
bookingGoFlightVo.setDepartureDate(dptDate);
bookingGoFlightVo.setDepartureDateStr(request.getParameter("bookingGoFlightVo.departureDateStr"));
bookingGoFlightVo.setDepartureTimeStr(request.getParameter("bookingGoFlightVo.departureTimeStr"));
bookingGoFlightVo.setDepartureTerminal(request.getParameter("bookingGoFlightVo.departureTerminal"));
bookingGoFlightVo.setArrivalTerminal(request.getParameter("bookingGoFlightVo.arrivalTerminal"));
bookingGoFlightVo.setDiscount(StringUtils.isEmpty(request.getParameter("bookingGoFlightVo.discount"))?null:new BigDecimal(request.getParameter("bookingGoFlightVo.discount")));
bookingGoFlightVo.setFlightNo(request.getParameter("bookingGoFlightVo.flightNo"));
bookingGoFlightVo.setPolicyCode(request.getParameter("bookingGoFlightVo.policyCode"));
bookingGoFlightVo.setFlightOrigin(request.getParameter("bookingGoFlightVo.flightOrgin"));
bookingGoFlightVo.setAdultTicketPricePar(request.getParameter("bookingGoFlightVo.adultTicketPricePar"));
bookingGoFlightVo.setChildTicketPricePar(request.getParameter("bookingGoFlightVo.childTicketPricePar"));
bookingGoFlightVo.setTotalCommissionRate(request.getParameter("bookingGoFlightVo.totalCommissionRate"));
bookingGoFlightVo.setSource(source);
bookingGoFlightVo.setTicketType("0");
bookingGoFlightVo.setOrderType("0");
bookingGoFlightVo.setFlightType("1");
bookingGoFlightVo.setProdType("0");
bookingGoFlightVo.setTicketPrice(goTicketPrice);
bookingGoFlightVo.setTotalBaf(goTotalBaf);
bookingGoFlightVo.setTotalConstructionFee(goTotalConstructionFee);
bookingGoFlightVo.setTotalTicketPrice(goTotalTicketPrice);
bookingGoFlightVo.setTotalMoney(goTotalMoney);
bookingRequestMessage.setBookingGoFlightVo(bookingGoFlightVo);
if("GW".equals(bookingGoFlightVo.getFlightOrigin()) ){
	bookingGoFlightVo.setTotalCommissionRate("0");
	bookingGoFlightVo.setAdultTicketPricePar(request.getParameter("bookingGoFlightVo.adultTicketPrice"));
	bookingGoFlightVo.setChildTicketPricePar(request.getParameter("bookingGoFlightVo.childTicketPrice"));
}
//返程航班信息
if("2".equals(request.getParameter("bookingReturnFlightVo.flightType"))){

	BigDecimal returnTicketPrice = new BigDecimal(request.getParameter("bookingReturnFlightVo.adultTicketPrice"));
	BigDecimal returnTotalBaf = (new BigDecimal(request.getParameter("bookingReturnFlightVo.adultBaf")).multiply(new BigDecimal(adultNum))).add((new BigDecimal(request.getParameter("bookingReturnFlightVo.childBaf")).multiply(new BigDecimal(childNum))));
	BigDecimal returnTotalConstructionFee = (new BigDecimal(request.getParameter("bookingReturnFlightVo.adultConstructionFee")).multiply(new BigDecimal(adultNum))).add((new BigDecimal(request.getParameter("bookingReturnFlightVo.childConstructionFee")).multiply(new BigDecimal(childNum))));
	BigDecimal returnTotalTicketPrice = (new BigDecimal(request.getParameter("bookingReturnFlightVo.adultTicketPrice")).multiply(new BigDecimal(adultNum))).add((new BigDecimal(request.getParameter("bookingReturnFlightVo.childTicketPrice")).multiply(new BigDecimal(childNum))));
	BigDecimal returnTotalMoney = returnTotalBaf.add(returnTotalConstructionFee).add(returnTotalTicketPrice);
	
BookingFlightVo bookingReturnFlightVo = new BookingFlightVo();
bookingReturnFlightVo.setPersonNum(Long.parseLong(passengerNumStr)+1);
bookingReturnFlightVo.setAdultBaf(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.adultBaf"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.adultBaf")));
bookingReturnFlightVo.setAdultConstructionFee(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.adultConstructionFee"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.adultConstructionFee")));
bookingReturnFlightVo.setAdultNum(adultNum);
bookingReturnFlightVo.setAdultTicketPrice(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.adultTicketPrice"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.adultTicketPrice")));
bookingReturnFlightVo.setAircraftType(request.getParameter("bookingReturnFlightVo.aircraftType"));
bookingReturnFlightVo.setAirlineCompany(request.getParameter("bookingReturnFlightVo.airlineCompany"));
bookingReturnFlightVo.setAirlineCompanyCode(request.getParameter("bookingReturnFlightVo.airlineCompanyCode"));
bookingReturnFlightVo.setArrivalAirport(request.getParameter("bookingReturnFlightVo.arrivalAirport"));
bookingReturnFlightVo.setArrivalAirportCode(request.getParameter("bookingReturnFlightVo.arrivalAirportCode"));
bookingReturnFlightVo.setArrivalCity(request.getParameter("bookingReturnFlightVo.arrivalAirportCode"));
Date returnDptDate = null;
Date returnArrDate = null;
try{
	returnDptDate = DateUtils.String2Date(request.getParameter("bookingReturnFlightVo.departureDate"));
	returnArrDate = DateUtils.String2Date(request.getParameter("bookingReturnFlightVo.arrivalDate"));
}catch(Exception e){
	e.printStackTrace();
}

bookingReturnFlightVo.setArrivalDate(returnArrDate);
bookingReturnFlightVo.setArrivalDateStr(request.getParameter("bookingReturnFlightVo.arrivalDateStr"));
bookingReturnFlightVo.setArrivalTimeStr(request.getParameter("bookingReturnFlightVo.arrivalTimeStr"));
bookingReturnFlightVo.setDepartureTerminal(request.getParameter("bookingReturnFlightVo.departureTerminal"));
bookingReturnFlightVo.setArrivalTerminal(request.getParameter("bookingReturnFlightVo.arrivalTerminal"));
//bookingReturnFlightVo.setBabyBaf(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.babyBaf"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.babyBaf")));
//bookingReturnFlightVo.setBabyConstructionFee(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.babyConstructionFee"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.babyConstructionFee")));
//bookingReturnFlightVo.setBabyTicketPrice(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.babyTicketPrice"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.babyTicketPrice")));
bookingReturnFlightVo.setCabinCode(request.getParameter("bookingReturnFlightVo.cabinCode"));
bookingReturnFlightVo.setCabinPriceOld(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.adultTicketPricePar"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.adultTicketPricePar")));
bookingReturnFlightVo.setCabinSeatNum(request.getParameter("bookingReturnFlightVo.cabinSeatNum"));
bookingReturnFlightVo.setChildTicketPrice(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.childTicketPrice"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.childTicketPrice")));
bookingReturnFlightVo.setChildConstructionFee(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.childConstructionFee"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.childConstructionFee")));
bookingReturnFlightVo.setChildNum(childNum);
bookingReturnFlightVo.setChildBaf(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.childBaf"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.childBaf")));
bookingReturnFlightVo.setDepartureAirport(request.getParameter("bookingReturnFlightVo.departureAirport"));
bookingReturnFlightVo.setDepartureAirportCode(request.getParameter("bookingReturnFlightVo.departureAirportCode"));
bookingReturnFlightVo.setDepartureCity(request.getParameter("bookingReturnFlightVo.departureAirportCode"));
bookingReturnFlightVo.setDepartureDate(returnDptDate);
bookingReturnFlightVo.setDepartureDateStr(request.getParameter("bookingReturnFlightVo.departureDateStr"));
bookingReturnFlightVo.setDepartureTimeStr(request.getParameter("bookingReturnFlightVo.departureTimeStr"));
bookingReturnFlightVo.setDiscount(StringUtils.isEmpty(request.getParameter("bookingReturnFlightVo.discount"))?null:new BigDecimal(request.getParameter("bookingReturnFlightVo.discount")));
bookingReturnFlightVo.setFlightNo(request.getParameter("bookingReturnFlightVo.flightNo"));
bookingReturnFlightVo.setPolicyCode(request.getParameter("bookingReturnFlightVo.policyCode"));
bookingReturnFlightVo.setFlightOrigin(request.getParameter("bookingReturnFlightVo.flightOrgin"));
bookingReturnFlightVo.setAdultTicketPricePar(request.getParameter("bookingReturnFlightVo.adultTicketPricePar"));
bookingReturnFlightVo.setChildTicketPricePar(request.getParameter("bookingReturnFlightVo.childTicketPricePar"));
bookingReturnFlightVo.setTotalCommissionRate(request.getParameter("bookingReturnFlightVo.totalCommissionRate"));
bookingReturnFlightVo.setSource(source);
bookingReturnFlightVo.setFlightType("2");
bookingReturnFlightVo.setOrderType("0");
bookingReturnFlightVo.setProdType("0");
bookingReturnFlightVo.setTicketType("0");
bookingReturnFlightVo.setTicketPrice(returnTicketPrice);
bookingReturnFlightVo.setTotalBaf(returnTotalBaf);
bookingReturnFlightVo.setTotalConstructionFee(returnTotalConstructionFee);
bookingReturnFlightVo.setTotalTicketPrice(returnTotalTicketPrice);
bookingReturnFlightVo.setTotalMoney(returnTotalMoney);
bookingRequestMessage.setBookingReturnFlightVo(bookingReturnFlightVo);
if("GW".equals(bookingReturnFlightVo.getFlightOrigin())){
	bookingReturnFlightVo.setTotalCommissionRate("0");
	bookingReturnFlightVo.setAdultTicketPricePar(request.getParameter("bookingReturnFlightVo.adultTicketPrice"));
	bookingReturnFlightVo.setChildTicketPricePar(request.getParameter("bookingReturnFlightVo.childTicketPrice"));
}
}

FlightContactVo flightContactVo = new FlightContactVo();
if(memberVo != null){
flightContactVo.setId(memberVo.getId());
}
flightContactVo.setName(request.getParameter("contactName"));
flightContactVo.setMobile(request.getParameter("contactPhone"));
flightContactVo.setEmail(request.getParameter("contactEmail"));
flightContactVo.setProdType(request.getParameter("F"));
bookingRequestMessage.setFlightContactVo(flightContactVo);

FlightItineraryVo flightItineraryVo = new FlightItineraryVo();
flightItineraryVo.setDeliveryType(request.getParameter("deliveryType"));
flightItineraryVo.setCatchUser(request.getParameter("catchName"));
flightItineraryVo.setMobile(request.getParameter("catchMobile"));
flightItineraryVo.setPostCode(request.getParameter("catchPostCode"));
flightItineraryVo.setCity(request.getParameter("catchCity"));
flightItineraryVo.setAddress(request.getParameter("catchAddress"));
flightItineraryVo.setIsPromptMailCost("0");
bookingRequestMessage.setFlightItineraryVo(flightItineraryVo);

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
<script type="text/javascript">
window.location="${ctx}/flight/order/orderFlightDetail.jsp?orderId=<%=bookingResponseMessage.getPayVo().getOrderId()%>";
</script>
<%
}else{
%>
<script>
alert("非常抱歉，您的订单提交失败。")
window.location.href="search.jsp";
</script>
<%} %>
