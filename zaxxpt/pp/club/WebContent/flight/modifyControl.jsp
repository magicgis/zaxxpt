<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hnatourism.club.common.helper.flight.SearchResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.SearchRequestMessage"%>
<%@page import="com.hnatourism.club.flight.book.BookingFlightVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.MemberPassengerVo"%>
<%@page import="com.hnatourism.club.common.util.SubRunBean"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightInfoVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightCabinInfoVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.SearchModifyRequestMessage"%>
<%@page import="com.hnatourism.framework.utils.ListUtils"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.club.common.util.SubRunUtils"%>

<%!
	private SubRunBean subRunBeanCabin=null;
	private MemberInfoVo memberInfoVo=null;
	private String userid = "";
	private String commissionRateCabin="0";
	
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
	

%>


<%
	initMethod(request,session);
	request.setAttribute("userid",userid);
	
	
	ArrayList flightList =null;  
	String code = "";
	String message = "";
	//接收时间参数
	String date = request.getParameter("date");
	//接收查询条件
	String passenger = request.getParameter("passenger");
	request.setAttribute("passenger",passenger);
	String[] strArr = passenger.split("_");
	String airlineCompanyCode = strArr[0];
	String etNo = strArr[1];
	String cabinCode = strArr[2];
	String departureAirportCode = strArr[3];
	String arrivalAirportCode = strArr[4];
	String passengerId = strArr[5];
	String passengerType = strArr[6];
	String orderId = request.getParameter("orderId");
	request.setAttribute("orderId",orderId);
	//第一次进入重新选择航班页面默认当前日期
	if(StringUtils.isEmpty(date)){
		Date today = new Date();
		Date afterDate = DateUtils.addDays(today,1);
		date = DateUtils.format(afterDate, "yyyy-MM-dd");
	}
	
	SearchModifyRequestMessage searchRequest=new SearchModifyRequestMessage();
	searchRequest.setArr(arrivalAirportCode);
	searchRequest.setDate(date);
	searchRequest.setDpt(departureAirportCode);
	searchRequest.setFtype("1");
	searchRequest.setCarrier(airlineCompanyCode);
	searchRequest.setTktNo(etNo);
	searchRequest.setMCabinCode(cabinCode);
	String authoritys=(String)session.getAttribute("authoritys");
	//实时查询
	if(authoritys!=null&&authoritys.indexOf("RealTimeSearch,")!=-1){
		searchRequest.setQueryRealTimeFlight("true");
	}
	else{
		searchRequest.setQueryRealTimeFlight("");
	}
	
	String resultStr ="";
	try {
		resultStr = searchRequest.excute();
		System.out.println(resultStr);
	} catch (Exception e) {
		e.printStackTrace();
	}
	//定义解析json的对象
	SearchResponseMessage searchResponse = new SearchResponseMessage();
	try{
		searchResponse.parseResponse(resultStr);
	} catch (Exception e) {
		e.printStackTrace();
	}
	flightList=searchResponse.getOutBoundsList();

					
	code = searchResponse.getResultCode();
	message = searchResponse.getMessage();

	
	
	//航班信息不为空的标志位,因为展示页面上需要多次判断航班数据取得情况
	boolean flightIsNullFlag=ListUtils.isEmpty(flightList);
	//防止页面上出现空指针异常
	flightList=!flightIsNullFlag?flightList:new ArrayList<FlightInfoVo>();

%>
