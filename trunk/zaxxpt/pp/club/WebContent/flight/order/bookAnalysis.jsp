<%@page import="java.math.BigInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightMemberPassenVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.MemberPassenResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.MemberPassenRequestMessage"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@ page import="org.apache.commons.logging.Log"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightInfoVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightCabinInfoVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%!
//日志对象
String flightOrigin="";
Log log = (Log) LogFactory.getLog("bookAnalysis.jsp");
//复制FlightInfoVo的属性到BookingFlightVo
private void copyProterty(FlightInfoVo flightInfoVo,BookingFlightVo bookingFlightVo){
	try{
		
		
		bookingFlightVo.setAirlineCompany(flightInfoVo.getAirlineCompany());
		bookingFlightVo.setAirlineCompanyCode(flightInfoVo.getAirlineCompanyCode());
		bookingFlightVo.setFlightNo(flightInfoVo.getFlightNo());
		bookingFlightVo.setAircraftType(flightInfoVo.getAircraftType());
		bookingFlightVo.setDepartureAirport(flightInfoVo.getDepartureAirport());
		bookingFlightVo.setArrivalAirport(flightInfoVo.getArrivalAirport());
		bookingFlightVo.setDepartureTerminal(flightInfoVo.getDepartureTerminal());
		bookingFlightVo.setArrivalTerminal(flightInfoVo.getArrivalTerminal());
		bookingFlightVo.setDepartureAirportCode(flightInfoVo.getDepartureAirportCode());
		bookingFlightVo.setArrivalAirportCode(flightInfoVo.getArrivalAirportCode());
//		bookingFlightVo.setAirlineCompanyImg(flightInfoVo.getAirlineCompanyImg());
//		bookingFlightVo.setTicketPrice(new BigDecimal("null".equalsIgnoreCase(flightInfoVo.getTicketPrice())?"0":flightInfoVo.getTicketPrice()));
//		bookingFlightVo.setMeal(flightInfoVo.getMeal());
//		bookingFlightVo.setAdultBaf(new BigDecimal("null".equalsIgnoreCase(flightInfoVo.getAdultBaf())?"0":flightInfoVo.getAdultBaf()));
//		bookingFlightVo.setChildBaf(new BigDecimal("null".equalsIgnoreCase(flightInfoVo.getChildBaf())?"0":flightInfoVo.getChildBaf()));
//		bookingFlightVo.setSpendTime(flightInfoVo.getSpendTime());
//		bookingFlightVo.setProdType(flightInfoVo.getProdType()==null?"0":flightInfoVo.getProdType());
//		bookingFlightVo.setDepartureCity(flightInfoVo.getDepartureCity());
//		bookingFlightVo.setArrivalCity(flightInfoVo.getArrivalCity());
		
		bookingFlightVo.setArrivalDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(flightInfoVo.getArrivalDate()));
		bookingFlightVo.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(flightInfoVo.getTripDate()));
		bookingFlightVo.setArrivalTimeStr(new SimpleDateFormat("HH:mm").format(bookingFlightVo.getArrivalDate()));
		bookingFlightVo.setDepartureTimeStr(new SimpleDateFormat("HH:mm").format(bookingFlightVo.getDepartureDate()));
		bookingFlightVo.setArrivalDateStr(new SimpleDateFormat("yyyy-MM-dd").format(bookingFlightVo.getArrivalDate()));
		bookingFlightVo.setDepartureDateStr(new SimpleDateFormat("yyyy-MM-dd").format(bookingFlightVo.getDepartureDate()));
		
		//System.out.print(bookingFlightVo.getDepartureDate()+"61       ................");
		//System.out.print(bookingFlightVo.getArrivalDate()+"62       ................");
		
		
	}catch(Exception e){
		e.printStackTrace();
		log.error(e+"@bookAnalysis.jsp copyProterty(FlightInfoVo flightInfoVo,BookingFlightVo bookingFlightVo)");
	}
}

private void copyProterty(FlightCabinInfoVo flightCabinInfoVo,BookingFlightVo bookingFlightVo){
	try{
		
		bookingFlightVo.setFlightOrigin(flightCabinInfoVo.getFlightOrgin());//来源
		bookingFlightVo.setPolicyCode(flightCabinInfoVo.getPolicyCode());
		bookingFlightVo.setChangeInfo(flightCabinInfoVo.getChangeInfo());
		bookingFlightVo.setCabinCode(flightCabinInfoVo.getCabinCode());
		bookingFlightVo.setCabinSeatNum(flightCabinInfoVo.getCabinSeatNum());
		bookingFlightVo.setAdultConstructionFee(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getAdultConstructionFee())?"0":flightCabinInfoVo.getAdultConstructionFee()));
		bookingFlightVo.setAdultBaf(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getAdultBaf())?"0":flightCabinInfoVo.getAdultBaf()));
		bookingFlightVo.setAdultTicketPrice(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getAdultTicketPrice())?"0":flightCabinInfoVo.getAdultTicketPrice()));
		bookingFlightVo.setChildConstructionFee(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getChildConstructionFee())?"0":flightCabinInfoVo.getChildConstructionFee()));
		bookingFlightVo.setChildBaf(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getChildBaf())?"0":flightCabinInfoVo.getChildBaf()));
		bookingFlightVo.setChildTicketPrice(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getChildTicketPrice())?"0":flightCabinInfoVo.getChildTicketPrice()));
		bookingFlightVo.setDiscount(flightCabinInfoVo.getDiscount());
		bookingFlightVo.setAdultTicketPricePar("null".equals(flightCabinInfoVo.getAdultTicketPricePar())?"0":flightCabinInfoVo.getAdultTicketPricePar());
		bookingFlightVo.setChildTicketPricePar("null".equals(flightCabinInfoVo.getChildTicketPricePar())?"0":flightCabinInfoVo.getChildTicketPricePar());
		bookingFlightVo.setTotalCommissionRate(flightCabinInfoVo.getCommissionRate());
		bookingFlightVo.setCabinDiscount(flightCabinInfoVo.getCabinDiscount());
//		bookingFlightVo.setCabinClass(flightCabinInfoVo.getCabinClass());
//		bookingFlightVo.setBabyConstructionFee(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getBabyConstructionFee())?"0":flightCabinInfoVo.getBabyConstructionFee()));
//		bookingFlightVo.setBabyBaf(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getBabyBaf())?"0":flightCabinInfoVo.getBabyBaf()));
//		bookingFlightVo.setBabyTicketPrice(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getBabyTicketPrice())?"0":flightCabinInfoVo.getBabyTicketPrice()));
//		bookingFlightVo.setCabinPriceOld(new BigDecimal("0"));
//		bookingFlightVo.setCabinPrice(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getAdultTicketPrice())?"0":flightCabinInfoVo.getAdultTicketPrice()));
//		bookingFlightVo.setCabinPrice(new BigDecimal("null".equalsIgnoreCase(flightCabinInfoVo.getAdultTicketPrice())?"0":flightCabinInfoVo.getAdultTicketPrice()));


	}catch(Exception e){
		log.error(e+"@bookAnalysis.jsp copyProterty(FlightCabinInfoVo flightCabinInfoVo,BookingFlightVo bookingFlightVo)");
	}
}

private Gson gson=new Gson(); 

%>

<%
	String memberId = "";
	if(null != UserUtil.getUser(request.getSession().getId())){
		memberId=UserUtil.getUser(request.getSession().getId()).getId();
	}
	MemberPassenRequestMessage memberPassenRequestMessage = new MemberPassenRequestMessage();
	MemberPassenResponseMessage memberPassenResponseMessage = new MemberPassenResponseMessage();
	
	String returnStr = "";
	memberPassenRequestMessage.setMemberId(memberId);
	try{
		returnStr = memberPassenRequestMessage.excute();
		memberPassenResponseMessage.parseResponse(returnStr);
	}catch(Exception e){
		log.error("常用乘机人接口访问失败"+e.getMessage());
	}
	//常用乘机人
	List<FlightMemberPassenVo> flightMemberPassenVoList = memberPassenResponseMessage.getMemberPassenList();

	Date dptDate = null;
	Date arrDate = null;
	BigInteger adultPrice = null;
	BigInteger childPrice = null;
	String goSeatNum= null;
	Date returnDptDate = null;
	Date returnArrDate = null;
	String reSeatNum= null;
	
	String filghtType=request.getParameter("flightType");
	flightOrigin=request.getParameter("gsource");//机票来源
	
	
	BookingFlightVo bookingReturnFlightVo=null;//去程
	BookingFlightVo bookingGoFlightVo=null;//返程
	try{

			//从表单中取出json数据
		String goflightInfoJson=request.getParameter("goflightInfoJson");
		String gocabinInfoJson=request.getParameter("gocabinInfoJson");
		String gospecialInfoJson=request.getParameter("gospecialInfoJson");
		//向前传递json预订信息的json数据
		pageContext.setAttribute("goflightInfoJson",goflightInfoJson);
		pageContext.setAttribute("gocabinInfoJson",gocabinInfoJson);
		pageContext.setAttribute("gospecialInfoJson",gospecialInfoJson);
		
		
		bookingGoFlightVo=new BookingFlightVo();
		//Json to 航班信息
		FlightInfoVo flightInfoVo=gson.fromJson(goflightInfoJson,FlightInfoVo.class);
		//Json to 舱位信息
		FlightCabinInfoVo cabinInfoVo=gson.fromJson(gocabinInfoJson,FlightCabinInfoVo.class);
		//将flightInfoVo中的属性copy到BookingFlightVo中
		copyProterty(flightInfoVo,bookingGoFlightVo);
		copyProterty(cabinInfoVo,bookingGoFlightVo);
		//如果存在特价舱位
		if(!StringUtils.isBlank(gospecialInfoJson)) {
			//Json to 特价信息
			FlightCabinInfoVo specialCabinInfoVo=gson.fromJson(gospecialInfoJson,FlightCabinInfoVo.class);
			//copyProterty(specialCabinInfoVo,bookingGoFlightVo);
			bookingGoFlightVo.setAdultTicketPrice(new BigDecimal(specialCabinInfoVo.getAdultTicketPrice()));
			//bookingGoFlightVo.setChildTicketPrice(specialCabinInfoVo.getAdultTicketPrice());
			bookingGoFlightVo.setCabinCode(specialCabinInfoVo.getCabinCode());
			bookingGoFlightVo.setFlightOrigin(specialCabinInfoVo.getFlightOrgin());
			bookingGoFlightVo.setChangeInfo(specialCabinInfoVo.getChangeInfo());
		}
	
		//计算票价 票面价+燃油+机建
		adultPrice = bookingGoFlightVo.getAdultTicketPrice().add(bookingGoFlightVo.getAdultBaf()).add(bookingGoFlightVo.getAdultConstructionFee()).toBigInteger();
		childPrice = bookingGoFlightVo.getChildTicketPrice().add(bookingGoFlightVo.getChildBaf()).add(bookingGoFlightVo.getChildConstructionFee()).toBigInteger();
		request.setAttribute("adultPrice",adultPrice);
		request.setAttribute("childPrice",childPrice);
		if("A".equals(bookingGoFlightVo.getCabinSeatNum())){
			bookingGoFlightVo.setCabinSeatNum("9");
		}
		bookingGoFlightVo.setSource("51666");
		bookingGoFlightVo.setTicketType("0");
		bookingGoFlightVo.setFlightType("1");
		
		//往返程
		if("2".equals(filghtType)){
			//预订返程信息数据传递链
			pageContext.setAttribute("arAirport",request.getParameter("arAirport"));
			pageContext.setAttribute("deAirport",request.getParameter("deAirport"));
			pageContext.setAttribute("departureDate",request.getParameter("departureDate"));
			pageContext.setAttribute("returnDate",request.getParameter("returnDate"));
			
			//从表单中取出json数据
			String reflightInfoJson=request.getParameter("reflightInfoJson");
			String recabinInfoJson=request.getParameter("recabinInfoJson");
			String respecialInfoJson=request.getParameter("respecialInfoJson");
			//向前传递json预订信息的json数据
			pageContext.setAttribute("reflightInfoJson",reflightInfoJson);
			pageContext.setAttribute("recabinInfoJson",recabinInfoJson);
			pageContext.setAttribute("respecialInfoJson",respecialInfoJson);
			
			bookingReturnFlightVo=new BookingFlightVo();
			//Json to 航班信息
			FlightInfoVo reflightInfoVo=gson.fromJson(reflightInfoJson,FlightInfoVo.class);
			//Json to 舱位信息
			FlightCabinInfoVo recabinInfoVo=gson.fromJson(recabinInfoJson,FlightCabinInfoVo.class);
			//将flightInfoVo中的属性copy到BookingFlightVo中
			copyProterty(reflightInfoVo,bookingReturnFlightVo);
			copyProterty(recabinInfoVo,bookingReturnFlightVo);
			//如果存在特价舱位
			if(!StringUtils.isBlank(respecialInfoJson)) {
				//Json to 特价信息
				FlightCabinInfoVo specialCabinInfoVo=gson.fromJson(respecialInfoJson,FlightCabinInfoVo.class);
				//将flightInfoVo中的属性copy到BookingFlightVo中
				//copyProterty(specialCabinInfoVo,bookingReturnFlightVo);
				bookingReturnFlightVo.setAdultTicketPrice(new BigDecimal(specialCabinInfoVo.getAdultTicketPrice()));
				//bookingGoFlightVo.setChildTicketPrice(specialCabinInfoVo.getAdultTicketPrice());
				bookingReturnFlightVo.setCabinCode(specialCabinInfoVo.getCabinCode());
				bookingReturnFlightVo.setFlightOrigin(specialCabinInfoVo.getFlightOrgin());
				bookingReturnFlightVo.setChangeInfo(specialCabinInfoVo.getChangeInfo());
			}
			
			//计算票价 票面价+燃油+机建
			adultPrice = new BigDecimal(adultPrice).add(bookingReturnFlightVo.getAdultTicketPrice()).add(bookingReturnFlightVo.getAdultBaf()).add(bookingReturnFlightVo.getAdultConstructionFee()).toBigInteger();
			childPrice = new BigDecimal(childPrice).add(bookingReturnFlightVo.getChildTicketPrice()).add(bookingReturnFlightVo.getChildBaf()).add(bookingReturnFlightVo.getChildConstructionFee()).toBigInteger();
			request.setAttribute("adultPrice",adultPrice);
			request.setAttribute("childPrice",childPrice);
			if("A".equals(bookingReturnFlightVo.getCabinSeatNum())){
				bookingReturnFlightVo.setCabinSeatNum("9");
			}
			bookingReturnFlightVo.setSource("51666");
			bookingReturnFlightVo.setTicketType("0");
			bookingReturnFlightVo.setFlightType("2");
		}
		
	}catch(Exception e){
		log.error("转换数据出错："+e.getMessage());
	}
%>