<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightGWVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightQryVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightInfoVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightCabinInfoVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightCompare"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightGWResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightGWRequestMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.SearchResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.SearchRequestMessage"%>
<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="com.hnatourism.club.common.util.SubRunBean"%>
<%@page import="com.hnatourism.club.common.util.SubRunUtils"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.framework.utils.ListUtils"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.framework.utils.DateFormatUtils"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.hnatourism.club.golf.api.GsonUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%--声明分润的方法以及初始化的方法--%>
<%!
	private SubRunBean subRunBeanCabin=null;
	private MemberInfoVo memberInfoVo=null;
	private String userid = "";
	private String commissionRateCabin="0";
	//private Gson gson=null;
	
	/**
	*初始化方法
	*/
	private void initMethod(HttpServletRequest request,HttpSession session){
		memberInfoVo=UserUtil.getUser(session.getId());
		if(null != memberInfoVo){
			userid=memberInfoVo.getId();
		}
		subRunBeanCabin=new SubRunBean();
		subRunBeanCabin.setRoleCode("GOLD");
		subRunBeanCabin.setProdType("F");
		if(null != memberInfoVo){
			subRunBeanCabin.setRoleCode(memberInfoVo.getMemberAccount().getMemberRole().getCode());
		}
	}
	
	/**
	*计算分润
	*/
	
	private void calculateSubRun(FlightCabinInfoVo cabInfo){
		double priceCabin=Double.parseDouble(cabInfo.getAdultTicketPricePar());
		subRunBeanCabin.setProdSalePrice(priceCabin);
		subRunBeanCabin.setProdSignprice(priceCabin);
		subRunBeanCabin.setSalerPoint(Double.parseDouble(cabInfo.getCommissionRate()));
		//计算金额
		priceCabin=new BigDecimal(SubRunUtils.getProdPrice(subRunBeanCabin)).setScale(0, BigDecimal.ROUND_UP).doubleValue();
		//计算折扣点数
		commissionRateCabin=SubRunUtils.getMemberPointStr();
		
		cabInfo.setAdultTicketPrice(String.valueOf(priceCabin));
		cabInfo.setCommissionRate(commissionRateCabin);
	}
	
	/**
	*航班信息vo转json
	*/
	private String flightVoToJson(FlightInfoVo flightInfoVo){
		StringBuffer json=new StringBuffer();
		json.append("{")
		    .append("'airlineCompany':'").append(flightInfoVo.getAirlineCompany())
		    .append("','airlineCompanyCode':'").append(flightInfoVo.getAirlineCompanyCode())
		    .append("','flightNo':'").append(flightInfoVo.getFlightNo())
		    .append("','aircraftType':'").append(flightInfoVo.getAircraftType())
		    .append("','departureAirport':'").append(flightInfoVo.getDepartureAirport())
		    .append("','arrivalAirport':'").append(flightInfoVo.getArrivalAirport())
		    .append("','departureTerminal':'").append(flightInfoVo.getDepartureTerminal())
		    .append("','arrivalTerminal':'").append(flightInfoVo.getArrivalTerminal())
		    .append("','departureAirportCode':'").append(flightInfoVo.getDepartureAirportCode())
		    .append("','arrivalAirportCode':'").append(flightInfoVo.getArrivalAirportCode())
		    .append("','tripDate':'").append(flightInfoVo.getTripDate())
		    .append("','departureTime':'").append(flightInfoVo.getDepartureTime())
		    .append("','arrivalDate':'").append(flightInfoVo.getArrivalDate())
		    .append("','arrivalTime':'").append(flightInfoVo.getArrivalTime())
//		    .append("','yprice':'").append(flightInfoVo.getYprice())
//		    .append("','airlineCompanyImg':'").append(flightInfoVo.getAirlineCompanyImg())
//		    .append("','constructionFee':'").append(flightInfoVo.getConstructionFee())
//		    .append("','adultBaf':'").append(flightInfoVo.getAdultBaf())
//		    .append("','childBaf':'").append(flightInfoVo.getChildBaf())
//		    .append("','isBargaining':'").append(flightInfoVo.getIsBargaining())
//		    .append("','groupBookingSts':'").append(flightInfoVo.getGroupBookingSts())
//		    .append("','ticketPrice':'").append(flightInfoVo.getTicketPrice())
//		    .append("','departureDayWeek':'").append(flightInfoVo.getDepartureDayWeek())
//		    .append("','flightId':'").append(flightInfoVo.getFlightId())
//		    .append("','elementNo':'").append(flightInfoVo.getElementNo())
//		    .append("','eticket':'").append(flightInfoVo.getEticket())
//		    .append("','meal':'").append(flightInfoVo.getMeal())
//		    .append("','viapoint':'").append(flightInfoVo.getViapoint())
//		    .append("','asr':'").append(flightInfoVo.getAsr())
//		    .append("','linkLevel':'").append(flightInfoVo.getLinkLevel())
//		    .append("','mileage':'").append(flightInfoVo.getMileage())
//		    .append("','usableClasses':'").append(flightInfoVo.getUsableClasses())
//		    .append("','spendTime':'").append(flightInfoVo.getSpendTime())
//		    .append("','prodType':'").append(flightInfoVo.getProdType())
//		    .append("','departureCity':'").append(flightInfoVo.getDepartureCity())
//		    .append("','arrivalCity':'").append(flightInfoVo.getArrivalCity())
//		    .append("','aircraftName':'").append(flightInfoVo.getAircraftName())
//		    .append("','cabinName':'").append(flightInfoVo.getCabinName())
//		    .append("','isAirCompanyPolicy':'").append(flightInfoVo.getIsAirCompanyPolicy())
//		    .append("','arrivalDateStr':'").append(flightInfoVo.getArrivalDateStr())
//		    .append("','arrivalTimeStr':'").append(flightInfoVo.getArrivalTimeStr())
//		    .append("','departureTimeStr':'").append(flightInfoVo.getDepartureTimeStr())
//		    .append("','departureDateStr':'").append(flightInfoVo.getDepartureDateStr())
//		    .append("','disCount':'").append(flightInfoVo.getDisCount())
//		    .append("','tDisCount':'").append(flightInfoVo.getDisCount())
		    .append("'}");
		//System.out.println(json.toString());
		return json.toString();
	}
	
	private String cabinVoToJson(FlightCabinInfoVo cabinVo){
		StringBuffer json=new StringBuffer();
		json.append("{")
		    .append("'flightOrgin':'").append(cabinVo.getFlightOrgin())
		    .append("','policyCode':'").append(cabinVo.getPolicyCode())
		    .append("','changeInfo':'").append(cabinVo.getChangeInfo())
		    .append("','cabinCode':'").append(cabinVo.getCabinCode())
		    .append("','cabinSeatNum':'").append(cabinVo.getCabinSeatNum())
		    .append("','adultConstructionFee':'").append(cabinVo.getAdultConstructionFee())
		    .append("','adultBaf':'").append(cabinVo.getAdultBaf())
		    .append("','adultTicketPrice':'").append(cabinVo.getAdultTicketPrice())
		    .append("','childConstructionFee':'").append(cabinVo.getChildConstructionFee())
		    .append("','childBaf':'").append(cabinVo.getChildBaf())
		    .append("','childTicketPrice':'").append(cabinVo.getChildTicketPrice())
		    .append("','discount':'").append(cabinVo.getDiscount())
		    .append("','cabinName':'").append(cabinVo.getCabinName())
		    .append("','commissionRate':'").append(cabinVo.getCommissionRate())
		    .append("','childTicketPricePar':'").append(cabinVo.getChildTicketPricePar())
		    .append("','adultTicketPricePar':'").append(cabinVo.getAdultTicketPricePar())
		    .append("','cabinDiscount':'").append(cabinVo.getCabinDiscount())
//		    .append("','babyConstructionFee':'").append(cabinVo.getBabyConstructionFee())
//		    .append("','babyBaf':'").append(cabinVo.getBabyBaf())
//		    .append("','babyTicketPrice':'").append(cabinVo.getBabyTicketPrice())
//		    .append("','cabinClass':'").append(cabinVo.getCabinClass())
//		    .append("','airCompanyPolicy':'").append(cabinVo.getAirCompanyPolicy())
//		    .append("','isSale':'").append(cabinVo.getIsSale())
//		    .append("','policyId':'").append(cabinVo.getPolicyId())
//		    .append("','deposit':'").append(cabinVo.getDeposit())
//		    .append("','groupId':'").append(cabinVo.getGroupId())
//		    .append("','groupCode':'").append(cabinVo.getGroupCode())
//		    .append("','issuePeriod':'").append(cabinVo.getIssuePeriod())
		    .append("'}");
		//System.out.println(json.toString());
		return json.toString();		
	}
%>
<%
	initMethod(request,session);

	request.setAttribute("userid",userid);
	Date date = new Date();
	String yesterday =DateFormatUtils.format(DateUtils.addDays(date,-1),"yyyy-MM-dd");
	request.setAttribute("yesterday",yesterday);
	
	//请求参数获取
	String departureAirportCode =request.getParameter("deAirport");//==null?(String)request.getAttribute("flightQryVo.departureAirport"):request.getParameter("deAirport");
	String arrivalAirportCode =request.getParameter("arAirport");//==null?(String)request.getAttribute("flightQryVo.arrivalAirport"):request.getParameter("arAirport");
	String departureDate = request.getParameter("departureDate");//==null?(String)request.getAttribute("flightQryVo.departureDate"):request.getParameter("departureDate");
	String returnDate = request.getParameter("returnDate");//==null?(String)request.getAttribute("flightQryVo.returnDate"):request.getParameter("returnDate");
	String flightType = request.getParameter("flightType");//==null?(String)request.getAttribute("flightQryVo.flightType"):request.getParameter("flightType");
	// 默认取得去程
	if("null".equals(flightType)){
		flightType = "1";
	}

	try{
		departureDate = DateFormatUtils.formatDateStr(departureDate,"yyyy-MM-dd");
		returnDate = DateFormatUtils.formatDateStr(returnDate,"yyyy-MM-dd");
	}
		catch(Exception e){
	}
		
	//request 属性设置
	request.setAttribute("departureAirportCode",departureAirportCode);
	request.setAttribute("arrivalAirportCode",arrivalAirportCode);
	request.setAttribute("departureDate",departureDate);
	request.setAttribute("returnDate",returnDate);
	request.setAttribute("flightType",flightType);
	
	boolean returnFlight=false;
	
	String beforeDateStr="";
	String afterDateStr="";
	if(!StringUtils.isEmpty(departureDate)){
		Date deDate=DateUtils.String2Date(departureDate+" 00:00:00");
		//前1天
		Date beforeDate = DateUtils.addDays(deDate,-1);
	    beforeDateStr=DateFormatUtils.format(beforeDate,"yyyy-MM-dd");
	    request.setAttribute("beforeDateStr",beforeDateStr);
		//后1天
		Date afterDate = DateUtils.addDays(deDate,1);
		afterDateStr=DateFormatUtils.format(afterDate,"yyyy-MM-dd");
		request.setAttribute("afterDateStr",afterDateStr);
	}
	
	//通过response对象可以获取其中的子对象
	List<FlightInfoVo> flightList =null;  
	if(!StringUtils.isEmpty(departureAirportCode) && !StringUtils.isEmpty(arrivalAirportCode) && !StringUtils.isEmpty(departureDate)){
	//定义发送请求的对象
	SearchRequestMessage searchRequest=new SearchRequestMessage();
	
	searchRequest.setArr(request.getParameter("arAirport"));
	searchRequest.setDate(request.getParameter("departureDate"));
	searchRequest.setDpt(request.getParameter("deAirport"));
	searchRequest.setFtype(request.getParameter("flightType"));
	searchRequest.setBackDate(request.getParameter("returnDate"));

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
	
//	String type=request.getParameter("type");
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
			searchResponse.setIsReturnFlight(returnFlight);
			searchResponse.parseResponse(resultStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		flightList=searchResponse.getOutBoundsList();
			
		String code = searchResponse.getResultCode();
		String message = searchResponse.getMessage();
	}
	
	
	//航班信息不为空的标志位,因为展示页面上需要多次判断航班数据取得情况
	boolean flightIsNullFlag=ListUtils.isEmpty(flightList);
	//防止页面上出现空指针异常
	flightList=!flightIsNullFlag?flightList:new ArrayList<FlightInfoVo>();
	//放置航空公司
    Set<String> setCompany = new HashSet<String>();
    if(!flightIsNullFlag){
    	for(int c=0; c<flightList.size(); c++){
    		setCompany.add(flightList.get(c).getAirlineCompanyCode());
        }
    }
    
	String dao="-";
	if(StringUtils.isEmpty(departureAirportCode)||StringUtils.isEmpty(arrivalAirportCode)){
		dao=" ";
	}	
	
    String bookingName="";
	if("2".equalsIgnoreCase(flightType)){
  		bookingName = "预订&返程";
  	}else{
  		bookingName = "预&nbsp;&nbsp;&nbsp订";
  	}

%>
