<%@page import="com.hnatourism.club.common.helper.flight.FlightCompare"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightGWVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightGWResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightGWRequestMessage"%>
<%@page import="com.hnatourism.framework.utils.ListUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hnatourism.club.common.helper.flight.SearchResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.SearchRequestMessage"%>
<%
	//通过response对象可以获取其中的子对象
ArrayList flightList =null;  
ArrayList inFlightList =null; 
if(!StringUtils.isEmpty(departureAirportCode) && !StringUtils.isEmpty(arrivalAirportCode) && !StringUtils.isEmpty(departureDate)){
//定义发送请求的对象
SearchRequestMessage searchRequest=new SearchRequestMessage();

searchRequest.setArr(request.getParameter("arAirport"));
searchRequest.setDate(request.getParameter("departureDate"));
searchRequest.setDpt(request.getParameter("deAirport"));
searchRequest.setFtype(request.getParameter("flightType"));
searchRequest.setBackDate(request.getParameter("returnDate"));
if(returnFlight==true){
	searchRequest.setDpt(request.getParameter("deFlight"));
	searchRequest.setArr(request.getParameter("arFlight"));
	searchRequest.setDate(request.getParameter("deDate"));
	searchRequest.setBackDate(request.getParameter("reDate"));
	searchRequest.setFtype(request.getParameter("flightType"));
}
searchRequest.setDptTime("");
searchRequest.setCarrier("");
searchRequest.setCabin("");

searchRequest.setIsource((String)session.getAttribute("isource"));

String authoritys=(String)session.getAttribute("authoritys");
//实时查询
if(authoritys!=null&&authoritys.indexOf("RealTimeSearch,")!=-1){
	searchRequest.setQueryRealTimeFlight("true");
}
else{
	searchRequest.setQueryRealTimeFlight("");
}

String type=request.getParameter("type");
//System.out.println("发送的url"+searchRequestgetRequsetString());
//发送请求并获取json字符串resultStr
String resultStr ="";
	try {
		long a = System.currentTimeMillis();
		resultStr = searchRequest.excute();
		long b = System.currentTimeMillis();
		System.out.println("查询航班用时："+(b-a));
	} catch (Exception e) {
		e.printStackTrace();
	}
//定义解析json的对象
	SearchResponseMessage searchResponse = new SearchResponseMessage();
	try {
		if(returnFlight==true){
	searchResponse.setDeAirportDateStr(deAirportDateStr);
		}
		searchResponse.setIsReturnFlight(returnFlight);
		searchResponse.parseResponse(resultStr);
//		System.out.println(searchResponse);
	} catch (Exception e) {
		e.printStackTrace();
	}
		if(returnFlight==false){
		flightList=searchResponse.getOutBoundsList();
		}
		else{
		inFlightList=searchResponse.getInBoundsList();
		}
	String code = searchResponse.getResultCode();
	String message = searchResponse.getMessage();
}
%>