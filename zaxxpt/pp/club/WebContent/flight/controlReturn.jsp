<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightGWVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightQryVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightInfoVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightCabinInfoVo"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
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
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.hnatourism.club.golf.api.GsonUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="org.apache.commons.logging.LogFactory"%>
<%--声明分润的方法以及初始化的方法--%>
<%!
	private SubRunBean subRunBeanCabin=null;
	private MemberInfoVo memberInfoVo=null;
	private String userid = "";
	private String commissionRateCabin="0";
	private Gson gson=new Gson(); 
	Log log = (Log) LogFactory.getLog("controlReturn.jsp");
	
	/**
	*初始化方法
	*/
	private void initMethod(HttpServletRequest request){
		memberInfoVo=UserUtil.getUser(request.getSession().getId());
		if(null != UserUtil.getUser(request.getSession().getId())){
			userid=UserUtil.getUser(request.getSession().getId()).getId();
		}
		//request.setAttribute("userid",userid);
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
		return json.toString();		
	}
	
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
		log.error(e+"@controlReturn.jsp copyProterty(FlightInfoVo flightInfoVo,BookingFlightVo bookingFlightVo)");
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
		log.error(e+"@controlReturn.jsp copyProterty(FlightCabinInfoVo flightCabinInfoVo,BookingFlightVo bookingFlightVo)");
	}
}

%>
<%
	initMethod(request);
	
	String goflightInfoJson=request.getParameter("goflightInfoJson");
	String gocabinInfoJson=request.getParameter("gocabinInfoJson");
	String gospecialInfoJson=request.getParameter("gospecialInfoJson");

	BookingFlightVo bookingGoFlightVo=new BookingFlightVo();
	if(gocabinInfoJson!=null&&goflightInfoJson!=null){
  	pageContext.setAttribute("gocabinInfoJson",gocabinInfoJson);
  	pageContext.setAttribute("goflightInfoJson",goflightInfoJson);
  	
  	FlightInfoVo goFlightInfoVo=gson.fromJson(goflightInfoJson,FlightInfoVo.class);
  	FlightCabinInfoVo goCabinInfoVo=gson.fromJson(gocabinInfoJson,FlightCabinInfoVo.class);
  	
  	copyProterty(goFlightInfoVo,bookingGoFlightVo);
  	copyProterty(goCabinInfoVo,bookingGoFlightVo);
  	
  	if(!StringUtils.isBlank(gospecialInfoJson)) {
  		pageContext.setAttribute("gospecialInfoJson",gospecialInfoJson);
		//Json to 特价信息
		FlightCabinInfoVo specialCabinInfoVo=gson.fromJson(gospecialInfoJson,FlightCabinInfoVo.class);
		//copyProterty(specialCabinInfoVo,bookingGoFlightVo);
		//by lixun 特价机票只是取得价格信息、退改信息、舱位信息、来源
		bookingGoFlightVo.setAdultTicketPrice(new BigDecimal(specialCabinInfoVo.getAdultTicketPrice()));
		//bookingGoFlightVo.setChildTicketPrice(specialCabinInfoVo.getAdultTicketPrice());
		bookingGoFlightVo.setCabinCode(specialCabinInfoVo.getCabinCode());
		bookingGoFlightVo.setFlightOrigin(specialCabinInfoVo.getFlightOrgin());
		bookingGoFlightVo.setChangeInfo(specialCabinInfoVo.getChangeInfo());
	}
	}else{
		//重定向到重新预订页面
		//pageContext.setAttribute("noBookingGoFllight","1");
		response.sendRedirect(request.getContextPath()+"/flight/index.jsp");
	}

	request.setAttribute("userid",userid);
	Date date = new Date();
	String yesterday =DateFormatUtils.format(DateUtils.addDays(date,-1),"yyyy-MM-dd");
	request.setAttribute("yesterday",yesterday);
	
	//请求参数获取 
	//返程时出发城市和到达城市和原来的相反
	String departureAirportCode =request.getParameter("deAirport");//==null?(String)request.getAttribute("flightQryVo.departureAirport"):request.getParameter("deAirport");
	String arrivalAirportCode =request.getParameter("arAirport");//==null?(String)request.getAttribute("flightQryVo.arrivalAirport"):request.getParameter("arAirport");
	String departureDate = request.getParameter("departureDate");//==null?(String)request.getAttribute("flightQryVo.departureDate"):request.getParameter("departureDate");
	String returnDate = request.getParameter("returnDate");//==null?(String)request.getAttribute("flightQryVo.returnDate"):request.getParameter("returnDate");
	String flightType = request.getParameter("flightType");//==null?(String)request.getAttribute("flightQryVo.flightType"):request.getParameter("flightType");
	
	
	try{
		departureDate = DateFormatUtils.formatDateStr(departureDate,"yyyy-MM-dd");
		returnDate = DateFormatUtils.formatDateStr(returnDate,"yyyy-MM-dd");
	}catch(Exception e){
		
	}
	
	//request 属性设置
	request.setAttribute("departureAirportCode",departureAirportCode);
	request.setAttribute("arrivalAirportCode",arrivalAirportCode);
	request.setAttribute("departureDate",departureDate);
	request.setAttribute("returnDate",returnDate);
	request.setAttribute("flightType",flightType);
	
	boolean returnFlight=true;
	String deAirportDateStr=departureDate+" "+bookingGoFlightVo.getArrivalTimeStr();
	
	String beforeDateStr="";
	String afterDateStr="";
	if(!StringUtils.isEmpty(returnDate)){
		Date reDate=DateUtils.String2Date(returnDate+" 00:00:00");
		//前1天
		Date beforeDate = DateUtils.addDays(reDate,-1);
	    beforeDateStr=DateFormatUtils.format(beforeDate,"yyyy-MM-dd");
	    request.setAttribute("beforeDateStr",beforeDateStr);
		//后1天
		Date afterDate = DateUtils.addDays(reDate,1);
		afterDateStr=DateFormatUtils.format(afterDate,"yyyy-MM-dd");
		request.setAttribute("afterDateStr",afterDateStr);
	}
	
	
	//通过response对象可以获取其中的子对象
	List<FlightInfoVo> inFlightList =null; 
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
			searchResponse.setDeAirportDateStr(deAirportDateStr);
			searchResponse.setIsReturnFlight(returnFlight);
			searchResponse.parseResponse(resultStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		inFlightList=searchResponse.getInBoundsList();
			
		String code = searchResponse.getResultCode();
		String message = searchResponse.getMessage();
	}
	
	
	//航班信息不为空的标志位,因为展示页面上需要多次判断航班数据取得情况
	boolean flightIsNullFlag=ListUtils.isEmpty(inFlightList);
	//防止页面上出现空指针异常
	inFlightList=!flightIsNullFlag?inFlightList:new ArrayList<FlightInfoVo>();
	//放置航空公司
    Set<String> setCompany = new HashSet<String>();
    if(!flightIsNullFlag){
    	for(int c=0; c<inFlightList.size(); c++){
    		setCompany.add(inFlightList.get(c).getAirlineCompanyCode());
        }
    }
    
	String dao="-";
	if(StringUtils.isEmpty(departureAirportCode)||StringUtils.isEmpty(arrivalAirportCode)){
		dao=" ";
	}	
	
    String bookingName = "预&nbsp;&nbsp;&nbsp订";
  	


%>
