<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.flight.passenger.MemberPassengerVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

//乘机人人数
String passengerNumStr = request.getParameter("passengerNum");
int passengerNum = 0;
if(StringUtils.isNotEmpty(passengerNumStr)){
	passengerNum = Integer.parseInt(passengerNumStr)+1;
}
//乘机人信息
List<MemberPassengerVo> flightPassengerVoList = new ArrayList<MemberPassengerVo>();
for(int i=0; i<passengerNum; i++){
	MemberPassengerVo memberPassengerVo = new MemberPassengerVo();
	memberPassengerVo.setId(request.getParameter("memberPassengerVoList["+i+"].id"));
//	System.out.println(request.getParameter("memberPassengerVoList["+i+"].id"));
	memberPassengerVo.setName(request.getParameter("memberPassengerVoList["+i+"].passName"));
	memberPassengerVo.setCertType(request.getParameter("memberPassengerVoList["+i+"].credentials"));
	memberPassengerVo.setCertNo(request.getParameter("memberPassengerVoList["+i+"].idCard"));
	memberPassengerVo.setType(request.getParameter("memberPassengerVoList["+i+"].ticketsType"));
	memberPassengerVo.setGoInsuranceNum(request.getParameter("memberPassengerVoList["+i+"].insure"));
	flightPassengerVoList.add(memberPassengerVo);
}
long adultNum = 0;
long childNum = 0;
BigDecimal adultTotalInsurance = new BigDecimal(0);
BigDecimal childTotalInsurance = new BigDecimal(0);
for(MemberPassengerVo m:flightPassengerVoList){
	if(m.getType().equals("01")){
		adultNum++;
		adultTotalInsurance = adultTotalInsurance.add(new BigDecimal(m.getGoInsuranceNum()).multiply(new BigDecimal(20)));
	}
	if(m.getType().equals("02")){
		childNum++;
		childTotalInsurance = childTotalInsurance.add(new BigDecimal(m.getGoInsuranceNum()).multiply(new BigDecimal(20)));
	}
}



BigDecimal adultTotalTicketPrice = new BigDecimal(request.getParameter("bookingGoFlightVo.adultTicketPrice")).multiply(new BigDecimal(adultNum));
BigDecimal childTotalTicketPrice = new BigDecimal(request.getParameter("bookingGoFlightVo.childTicketPrice")).multiply(new BigDecimal(childNum));
BigDecimal adultTotalBaf = new BigDecimal(request.getParameter("bookingGoFlightVo.adultBaf")).multiply(new BigDecimal(adultNum));
BigDecimal childTotalBaf = new BigDecimal(request.getParameter("bookingGoFlightVo.childBaf")).multiply(new BigDecimal(childNum));
BigDecimal adultTotalConstructionFee = new BigDecimal(request.getParameter("bookingGoFlightVo.adultConstructionFee")).multiply(new BigDecimal(adultNum));
BigDecimal childTotalConstructionFee = new BigDecimal(request.getParameter("bookingGoFlightVo.childConstructionFee")).multiply(new BigDecimal(childNum));
BigDecimal totalPrice = adultTotalTicketPrice.add(childTotalTicketPrice).add(adultTotalBaf).add(childTotalBaf).add(adultTotalConstructionFee).add(childTotalConstructionFee).add(adultTotalInsurance).add(childTotalInsurance);

	BookingFlightVo bookingGoFlightVo=new BookingFlightVo();
	bookingGoFlightVo.setAdultBaf(new BigDecimal(request.getParameter("bookingGoFlightVo.adultBaf")));
	bookingGoFlightVo.setAdultConstructionFee(new BigDecimal(request.getParameter("bookingGoFlightVo.adultConstructionFee")));
	bookingGoFlightVo.setAdultTicketPrice(new BigDecimal(request.getParameter("bookingGoFlightVo.adultTicketPrice")));
	bookingGoFlightVo.setAircraftType(request.getParameter("bookingGoFlightVo.aircraftType"));
	bookingGoFlightVo.setAirlineCompany(request.getParameter("bookingGoFlightVo.airlineCompany"));
	bookingGoFlightVo.setAirlineCompanyCode(request.getParameter("bookingGoFlightVo.airlineCompanyCode"));
	bookingGoFlightVo.setArrivalAirport(request.getParameter("bookingGoFlightVo.arrivalAirport"));
	bookingGoFlightVo.setArrivalAirportCode(request.getParameter("bookingGoFlightVo.arrivalAirportCode"));
	bookingGoFlightVo.setArrivalTerminal(request.getParameter("bookingGoFlightVo.arrivalTerminal"));
	bookingGoFlightVo.setArrivalCity(request.getParameter("bookingGoFlightVo.arrivalCity"));
	Date dptDate = null;
	Date arrDate = null;
	try{
		dptDate = DateUtils.String2Date(request.getParameter("bookingGoFlightVo.departureDate")+":00");
		arrDate = DateUtils.String2Date(request.getParameter("bookingGoFlightVo.arrivalDate")+":00");
	}catch(Exception e){
		e.printStackTrace();
	}
	bookingGoFlightVo.setArrivalDate(arrDate);
	bookingGoFlightVo.setArrivalDateStr(request.getParameter("bookingGoFlightVo.arrivalDateStr"));
	bookingGoFlightVo.setArrivalTimeStr(request.getParameter("bookingGoFlightVo.arrivalTimeStr"));
	bookingGoFlightVo.setCabinCode(request.getParameter("bookingGoFlightVo.cabinCode"));
	bookingGoFlightVo.setCabinSeatNum(request.getParameter("bookingGoFlightVo.cabinSeatNum"));
	bookingGoFlightVo.setChildTicketPrice(new BigDecimal(request.getParameter("bookingGoFlightVo.childTicketPrice")));
	bookingGoFlightVo.setChildConstructionFee(new BigDecimal(request.getParameter("bookingGoFlightVo.childConstructionFee")));
	bookingGoFlightVo.setChildBaf(new BigDecimal(request.getParameter("bookingGoFlightVo.childBaf")));
	bookingGoFlightVo.setDepartureAirport(request.getParameter("bookingGoFlightVo.departureAirport"));
	bookingGoFlightVo.setDepartureAirportCode(request.getParameter("bookingGoFlightVo.departureAirportCode"));
	bookingGoFlightVo.setDepartureTerminal(request.getParameter("bookingGoFlightVo.departureTerminal"));
	bookingGoFlightVo.setDepartureCity(request.getParameter("bookingGoFlightVo.departureCity"));
	bookingGoFlightVo.setDepartureDate(dptDate);
	bookingGoFlightVo.setDepartureDateStr(request.getParameter("bookingGoFlightVo.departureDateStr"));
	bookingGoFlightVo.setDepartureTimeStr(request.getParameter("bookingGoFlightVo.departureTimeStr"));
	bookingGoFlightVo.setDiscount(new BigDecimal(request.getParameter("bookingGoFlightVo.discount")));
	bookingGoFlightVo.setFlightNo(request.getParameter("bookingGoFlightVo.flightNo"));
	bookingGoFlightVo.setFlightType(request.getParameter("bookingGoFlightVo.flightType"));
	bookingGoFlightVo.setOrderType(request.getParameter("bookingGoFlightVo.orderType"));
	bookingGoFlightVo.setPolicyCode(request.getParameter("bookingGoFlightVo.policyCode"));
	bookingGoFlightVo.setProdType(request.getParameter("bookingGoFlightVo.prodType"));
	bookingGoFlightVo.setSource("51666");
	bookingGoFlightVo.setTicketType("0");
	bookingGoFlightVo.setFlightOrigin(request.getParameter("bookingGoFlightVo.flightOrgin"));
	bookingGoFlightVo.setAdultTicketPricePar(request.getParameter("bookingGoFlightVo.adultTicketPricePar"));
	bookingGoFlightVo.setChildTicketPricePar(request.getParameter("bookingGoFlightVo.childTicketPricePar"));
	bookingGoFlightVo.setTotalCommissionRate(request.getParameter("bookingGoFlightVo.totalCommissionRate"));
	bookingGoFlightVo.setChangeInfo(request.getParameter("bookingGoFlightVo.changeInfo"));
	request.setAttribute("bookingGoFlightVo",bookingGoFlightVo);
	BookingFlightVo bookingReturnFlightVo=new BookingFlightVo();
	if("2".equals(request.getParameter("bookingReturnFlightVo.flightType"))){
		
		BigDecimal rAdultTotalTicketPrice = new BigDecimal(request.getParameter("bookingReturnFlightVo.adultTicketPrice")).multiply(new BigDecimal(adultNum));
		BigDecimal rChildTotalTicketPrice = new BigDecimal(request.getParameter("bookingReturnFlightVo.childTicketPrice")).multiply(new BigDecimal(childNum));
		BigDecimal rAdultTotalBaf = new BigDecimal(request.getParameter("bookingReturnFlightVo.adultBaf")).multiply(new BigDecimal(adultNum));
		BigDecimal rChildTotalBaf = new BigDecimal(request.getParameter("bookingReturnFlightVo.childBaf")).multiply(new BigDecimal(childNum));
		BigDecimal rAdultTotalConstructionFee = new BigDecimal(request.getParameter("bookingReturnFlightVo.adultConstructionFee")).multiply(new BigDecimal(adultNum));
		BigDecimal rChildTotalConstructionFee = new BigDecimal(request.getParameter("bookingReturnFlightVo.childConstructionFee")).multiply(new BigDecimal(childNum));
		BigDecimal rTotalPrice = rAdultTotalTicketPrice.add(rChildTotalTicketPrice).add(rAdultTotalBaf).add(rChildTotalBaf).add(rAdultTotalConstructionFee).add(rChildTotalConstructionFee);
		
		
		adultTotalTicketPrice = adultTotalTicketPrice.add(rAdultTotalTicketPrice);
		childTotalTicketPrice = childTotalTicketPrice.add(rChildTotalTicketPrice);
		adultTotalBaf = adultTotalBaf.add(rAdultTotalBaf);
		childTotalBaf = childTotalBaf.add(rChildTotalBaf);
		adultTotalConstructionFee = adultTotalConstructionFee.add(rAdultTotalConstructionFee);
		childTotalConstructionFee = childTotalConstructionFee.add(rChildTotalConstructionFee);
		totalPrice = totalPrice.add(rTotalPrice);
		adultNum = adultNum*2;
		childNum = childNum*2;
		adultTotalInsurance = adultTotalInsurance.multiply(new BigDecimal(2));
		childTotalInsurance = childTotalInsurance.multiply(new BigDecimal(2));
		
		bookingReturnFlightVo.setAdultBaf(new BigDecimal(request.getParameter("bookingReturnFlightVo.adultBaf")));
		bookingReturnFlightVo.setAdultConstructionFee(new BigDecimal(request.getParameter("bookingReturnFlightVo.adultConstructionFee")));
		bookingReturnFlightVo.setAdultTicketPrice(new BigDecimal(request.getParameter("bookingReturnFlightVo.adultTicketPrice")));
		bookingReturnFlightVo.setAircraftType(request.getParameter("bookingReturnFlightVo.aircraftType"));
		bookingReturnFlightVo.setAirlineCompany(request.getParameter("bookingReturnFlightVo.airlineCompany"));
		bookingReturnFlightVo.setAirlineCompanyCode(request.getParameter("bookingReturnFlightVo.airlineCompanyCode"));
		bookingReturnFlightVo.setArrivalAirport(request.getParameter("bookingReturnFlightVo.arrivalAirport"));
		bookingReturnFlightVo.setArrivalAirportCode(request.getParameter("bookingReturnFlightVo.arrivalAirportCode"));
		bookingReturnFlightVo.setArrivalTerminal(request.getParameter("bookingReturnFlightVo.arrivalTerminal"));
		bookingReturnFlightVo.setArrivalCity(request.getParameter("bookingReturnFlightVo.arrivalCity"));
		Date returnDptDate = null;
		Date returnArrDate = null;
		try{
			returnDptDate = DateUtils.String2Date(request.getParameter("bookingReturnFlightVo.departureDate")+":00");
			returnArrDate = DateUtils.String2Date(request.getParameter("bookingReturnFlightVo.arrivalDate")+":00");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		bookingReturnFlightVo.setArrivalDate(returnArrDate);
		bookingReturnFlightVo.setArrivalDateStr(request.getParameter("bookingReturnFlightVo.arrivalDateStr"));
		bookingReturnFlightVo.setArrivalTimeStr(request.getParameter("bookingReturnFlightVo.arrivalTimeStr"));
		bookingReturnFlightVo.setCabinCode(request.getParameter("bookingReturnFlightVo.cabinCode"));
		bookingReturnFlightVo.setCabinSeatNum(request.getParameter("bookingReturnFlightVo.cabinSeatNum"));
		bookingReturnFlightVo.setChildTicketPrice(new BigDecimal(request.getParameter("bookingReturnFlightVo.childTicketPrice")));
		bookingReturnFlightVo.setChildConstructionFee(new BigDecimal(request.getParameter("bookingReturnFlightVo.childConstructionFee")));
		bookingReturnFlightVo.setChildBaf(new BigDecimal(request.getParameter("bookingReturnFlightVo.childBaf")));
		bookingReturnFlightVo.setDepartureAirport(request.getParameter("bookingReturnFlightVo.departureAirport"));
		bookingReturnFlightVo.setDepartureAirportCode(request.getParameter("bookingReturnFlightVo.departureAirportCode"));
		bookingReturnFlightVo.setDepartureTerminal(request.getParameter("bookingReturnFlightVo.departureTerminal"));
		bookingReturnFlightVo.setDepartureCity(request.getParameter("bookingReturnFlightVo.departureCity"));
		bookingReturnFlightVo.setDepartureDate(returnDptDate);
		bookingReturnFlightVo.setDepartureDateStr(request.getParameter("bookingReturnFlightVo.departureDateStr"));
		bookingReturnFlightVo.setDepartureTimeStr(request.getParameter("bookingReturnFlightVo.departureTimeStr"));
		bookingReturnFlightVo.setDiscount(new BigDecimal(request.getParameter("bookingReturnFlightVo.discount")));
		bookingReturnFlightVo.setFlightNo(request.getParameter("bookingReturnFlightVo.flightNo"));
		bookingReturnFlightVo.setFlightType(request.getParameter("bookingReturnFlightVo.flightType"));
		bookingReturnFlightVo.setOrderType(request.getParameter("bookingReturnFlightVo.orderType"));
		bookingReturnFlightVo.setPolicyCode(request.getParameter("bookingReturnFlightVo.policyCode"));
		bookingReturnFlightVo.setProdType(request.getParameter("bookingReturnFlightVo.prodType"));
		bookingReturnFlightVo.setSource("51666");
		bookingReturnFlightVo.setTicketType("0");
		bookingReturnFlightVo.setFlightOrigin(request.getParameter("bookingReturnFlightVo.flightOrgin"));
		bookingReturnFlightVo.setAdultTicketPricePar(request.getParameter("bookingReturnFlightVo.adultTicketPricePar"));
		bookingReturnFlightVo.setChildTicketPricePar(request.getParameter("bookingReturnFlightVo.childTicketPricePar"));
		bookingReturnFlightVo.setTotalCommissionRate(request.getParameter("bookingReturnFlightVo.totalCommissionRate"));
		bookingReturnFlightVo.setChangeInfo(request.getParameter("bookingReturnFlightVo.changeInfo"));
		request.setAttribute("bookingReturnFlightVo",bookingReturnFlightVo);
		
		//FlightCache.flightAirport();
	}
%>