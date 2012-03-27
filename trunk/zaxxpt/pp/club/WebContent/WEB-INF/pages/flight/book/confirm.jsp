<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.framework.utils.DateFormatUtils"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
    <script type=text/javascript>
        var cityDirectory = '${ctx}/';
    </script>
    <script src="${ctx}/web/js/city/allCity.js" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
	<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidator_min.js" defer="defer"></script>
	<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidatorRegex.js"></script>
	<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidator_helper.js"></script>
    <title>机票订单核对-机票预订- ${domain_cn }</title>
    <script src="${ctx}/web/js/clubJs/travel.js" language="javascript" type="text/javascript"></script>
    <script type=text/javascript>
        var citySelect = new CitySelectWindow('cityselected');
        function setSearch(n) { var menu = document.getElementById("sea_nav").getElementsByTagName("li"); var showdiv = document.getElementById("sea_box").getElementsByTagName("li"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
        function setList(m, n) { var menu = document.getElementById("tab" + m).getElementsByTagName("li"); var showdiv = document.getElementById("tablist" + m).getElementsByTagName("div"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
    </script>
    </head>
	<%@include file="/flight/order/confirmAnalysis.jsp" %>
    <body>
    <form action="bookControl.jsp" id="bookingFlightForm" method="post" >
    <input type="hidden" name="bookingGoFlightVo.adultBaf" value="<%=bookingGoFlightVo.getAdultBaf()%>" />
	<input type="hidden" name="bookingGoFlightVo.adultConstructionFee" value="<%=bookingGoFlightVo.getAdultConstructionFee()%>" />
	<input type="hidden" name="bookingGoFlightVo.adultTicketPrice" value="<%=bookingGoFlightVo.getAdultTicketPrice()%>" />
	<input type="hidden" name="bookingGoFlightVo.adultTicketPricePar" value="<%=bookingGoFlightVo.getAdultTicketPricePar()%>" />
	<input type="hidden" name="bookingGoFlightVo.aircraftType" value="<%=bookingGoFlightVo.getAircraftType()%>" />
	<input type="hidden" name="bookingGoFlightVo.airlineCompany" value="<%=bookingGoFlightVo.getAirlineCompany()%>" />
	<input type="hidden" name="bookingGoFlightVo.airlineCompanyCode" value="<%=bookingGoFlightVo.getAirlineCompanyCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalAirport" value="<%=bookingGoFlightVo.getArrivalAirport()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalAirportCode" value="<%=bookingGoFlightVo.getArrivalAirportCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalCity" value="<%=bookingGoFlightVo.getArrivalCity()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureDate" value="<%=DateFormatUtils.format(bookingGoFlightVo.getDepartureDate(),"yyyy-MM-dd HH:mm:ss")%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalDate" value="<%=DateFormatUtils.format(bookingGoFlightVo.getArrivalDate(),"yyyy-MM-dd HH:mm:ss")%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalDateStr" value="<%=bookingGoFlightVo.getArrivalDateStr()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalTimeStr" value="<%=bookingGoFlightVo.getArrivalTimeStr()%>" />
	<input type="hidden" name="bookingGoFlightVo.cabinCode" value="<%=bookingGoFlightVo.getCabinCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.cabinPriceOld" value="<%=bookingGoFlightVo.getCabinPriceOld()%>" />
	<input type="hidden" name="bookingGoFlightVo.cabinSeatNum" value="<%=bookingGoFlightVo.getCabinSeatNum()%>" />
	<input type="hidden" name="bookingGoFlightVo.childTicketPrice" value="<%=bookingGoFlightVo.getChildTicketPrice()%>" />
	<input type="hidden" name="bookingGoFlightVo.childTicketPricePar" value="<%=bookingGoFlightVo.getChildTicketPricePar()%>" />
	<input type="hidden" name="bookingGoFlightVo.childConstructionFee" value="<%=bookingGoFlightVo.getChildConstructionFee()%>" />
	<input type="hidden" name="bookingGoFlightVo.childBaf" value="<%=bookingGoFlightVo.getChildBaf()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureAirport" value="<%=bookingGoFlightVo.getDepartureAirport()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureAirportCode" value="<%=bookingGoFlightVo.getDepartureAirportCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureCity" value="<%=bookingGoFlightVo.getDepartureCity()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureDateStr" value="<%=bookingGoFlightVo.getDepartureDateStr()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureTimeStr" value="<%=bookingGoFlightVo.getDepartureTimeStr()%>" />
	<input type="hidden" name="bookingGoFlightVo.discount" value="<%=bookingGoFlightVo.getDiscount()%>" />
	<input type="hidden" name="bookingGoFlightVo.flightNo" value="<%=bookingGoFlightVo.getFlightNo()%>" />
	<input type="hidden" name="bookingGoFlightVo.flightType" value="<%=bookingGoFlightVo.getFlightType()%>" />
	<input type="hidden" name="bookingGoFlightVo.orderType" value="<%=bookingGoFlightVo.getOrderType()%>" />
	<input type="hidden" name="bookingGoFlightVo.policyCode" value="<%=bookingGoFlightVo.getPolicyCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.prodType" value="<%=bookingGoFlightVo.getProdType()%>" />
	<input type="hidden" name="bookingGoFlightVo.flightOrgin" value="<%=bookingGoFlightVo.getFlightOrigin()%>" />
	<input type="hidden" name="bookingGoFlightVo.totalCommissionRate" value="<%=bookingGoFlightVo.getTotalCommissionRate()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureTerminal" value="<%=bookingGoFlightVo.getDepartureTerminal()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalTerminal" value="<%=bookingGoFlightVo.getArrivalTerminal()%>" />
	<% if("2".equals(request.getParameter("bookingReturnFlightVo.flightType"))){%>
	<input type="hidden" name="bookingReturnFlightVo.adultBaf" value="<%=bookingReturnFlightVo.getAdultBaf()%>" />
	<input type="hidden" name="bookingReturnFlightVo.adultConstructionFee" value="<%=bookingReturnFlightVo.getAdultConstructionFee()%>" />
	<input type="hidden" name="bookingReturnFlightVo.adultTicketPrice" value="<%=bookingReturnFlightVo.getAdultTicketPrice()%>" />
	<input type="hidden" name="bookingReturnFlightVo.adultTicketPricePar" value="<%=bookingReturnFlightVo.getAdultTicketPricePar()%>" />
	<input type="hidden" name="bookingReturnFlightVo.aircraftType" value="<%=bookingReturnFlightVo.getAircraftType()%>" />
	<input type="hidden" name="bookingReturnFlightVo.airlineCompany" value="<%=bookingReturnFlightVo.getAirlineCompany()%>" />
	<input type="hidden" name="bookingReturnFlightVo.airlineCompanyCode" value="<%=bookingReturnFlightVo.getAirlineCompanyCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalAirport" value="<%=bookingReturnFlightVo.getArrivalAirport()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalAirportCode" value="<%=bookingReturnFlightVo.getArrivalAirportCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalCity" value="<%=bookingReturnFlightVo.getArrivalCity()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureDate" value="<%=DateFormatUtils.format(bookingReturnFlightVo.getDepartureDate(),"yyyy-MM-dd HH:mm:ss")%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalDate" value="<%=DateFormatUtils.format(bookingReturnFlightVo.getArrivalDate(),"yyyy-MM-dd HH:mm:ss")%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalDateStr" value="<%=bookingReturnFlightVo.getArrivalDateStr()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalTimeStr" value="<%=bookingReturnFlightVo.getArrivalTimeStr()%>" />
	<input type="hidden" name="bookingReturnFlightVo.cabinCode" value="<%=bookingReturnFlightVo.getCabinCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.cabinPriceOld" value="<%=bookingReturnFlightVo.getCabinPriceOld()%>" />
	<input type="hidden" name="bookingReturnFlightVo.cabinSeatNum" value="<%=bookingReturnFlightVo.getCabinSeatNum()%>" />
	<input type="hidden" name="bookingReturnFlightVo.childTicketPrice" value="<%=bookingReturnFlightVo.getChildTicketPrice()%>" />
	<input type="hidden" name="bookingReturnFlightVo.childTicketPricePar" value="<%=bookingReturnFlightVo.getChildTicketPricePar()%>" />
	<input type="hidden" name="bookingReturnFlightVo.childConstructionFee" value="<%=bookingReturnFlightVo.getChildConstructionFee()%>" />
	<input type="hidden" name="bookingReturnFlightVo.childBaf" value="<%=bookingReturnFlightVo.getChildBaf()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureAirport" value="<%=bookingReturnFlightVo.getDepartureAirport()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureAirportCode" value="<%=bookingReturnFlightVo.getDepartureAirportCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureCity" value="<%=bookingReturnFlightVo.getDepartureCity()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureDateStr" value="<%=bookingReturnFlightVo.getDepartureDateStr()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureTimeStr" value="<%=bookingReturnFlightVo.getDepartureTimeStr()%>" />
	<input type="hidden" name="bookingReturnFlightVo.discount" value="<%=bookingReturnFlightVo.getDiscount()%>" />
	<input type="hidden" name="bookingReturnFlightVo.flightNo" value="<%=bookingReturnFlightVo.getFlightNo()%>" />
	<input type="hidden" name="bookingReturnFlightVo.flightType" value="<%=bookingReturnFlightVo.getFlightType()%>" />
	<input type="hidden" name="bookingReturnFlightVo.orderType" value="<%=bookingReturnFlightVo.getOrderType()%>" />
	<input type="hidden" name="bookingReturnFlightVo.policyCode" value="<%=bookingReturnFlightVo.getPolicyCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.prodType" value="<%=bookingReturnFlightVo.getProdType()%>" />
	<input type="hidden" name="bookingReturnFlightVo.flightOrgin" value="<%=bookingReturnFlightVo.getFlightOrigin()%>" />
	<input type="hidden" name="bookingReturnFlightVo.totalCommissionRate" value="<%=bookingReturnFlightVo.getTotalCommissionRate()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureTerminal" value="<%=bookingReturnFlightVo.getDepartureTerminal()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalTerminal" value="<%=bookingReturnFlightVo.getArrivalTerminal()%>" />
    <%} %>
    	<input type="hidden" name="passengerNum" value="<%=request.getParameter("passengerNum")%>" />
	<%
	
	for(int j=0; j<passengerNum; j++){
	%>
		<input type="hidden" name="memberPassengerVoList[<%=j%>].passName" value="<%=request.getParameter("memberPassengerVoList["+j+"].passName")%>"/>
		<input type="hidden" name="memberPassengerVoList[<%=j%>].insure" value="<%=request.getParameter("memberPassengerVoList["+j+"].insure")%>"/>
		<input type="hidden" name="memberPassengerVoList[<%=j%>].ticketsType" value="<%=request.getParameter("memberPassengerVoList["+j+"].ticketsType")%>"/>
		<input type="hidden" name="memberPassengerVoList[<%=j%>].id" value="<%=request.getParameter("memberPassengerVoList["+j+"].id")%>"/>
		<input type="hidden" name="memberPassengerVoList[<%=j%>].credentials" value="<%=request.getParameter("memberPassengerVoList["+j+"].credentials")%>"/>

		<input type="hidden" name="memberPassengerVoList[<%=j%>].idCard" value="<%=request.getParameter("memberPassengerVoList["+j+"].idCard")%>"/>
	<%
	}%>
		<input type="hidden" name="contactName" value="<%=request.getParameter("contactName")%>" />
		<input type="hidden" name="contactPhone" value="<%=request.getParameter("contactPhone")%>" />
		<input type="hidden" name="contactEmail" value="<%=request.getParameter("contactEmail")%>" />
		
		<input type="hidden" name="deliveryType" id="deliveryType" />
		<input type="hidden" name="catchName" id="catchName"/>
		<input type="hidden" name="catchMobile" id="catchMobile"/>
		<input type="hidden" name="catchPostCode" id="catchPostCode"/>
		<input type="hidden" name="catchCity" id="catchCity"/>
		<input type="hidden" name="catchAddress" id="catchAddress"/>
	</form>
<div class="xx_nav">
        <ul>
        <li><img src="${ctx}/web/images/xileft.jpg" /></li>
        <li class="se_nav"><span class="jd_ddxx">确认订单信息</span></li>
        <li><img src="${ctx}/web/images/xiright.jpg" /></li>
    </ul>
    </div>
<div class="clear"></div>
<div class="main980"> 
    <!--订单合计开始-->
 <div class="module_a Order">
    <div class="title">
    	<span class="l"></span>
    	<span class="c">
    		<b class="left" style="font-size:12px">
    			总计:&nbsp;&nbsp;￥<%=totalPrice.toBigInteger()%>&nbsp;
    			成人<%=adultNum%>张&nbsp;（票价:￥<%=adultTotalTicketPrice.toBigInteger()%>，机建费:￥<%=adultTotalConstructionFee%>，燃油费:￥<%=adultTotalBaf%>，保险费:￥<%=adultTotalInsurance%>）　
    			<%
    			  if(childNum!=0){
    			%>
    			儿童<%=childNum%>张&nbsp;（票价:￥<%=childTotalTicketPrice.toBigInteger()%>，机建费:￥<%=childTotalConstructionFee%>，燃油费:￥<%=childTotalBaf%>，保险费:￥<%=childTotalInsurance%>） 
    			<%} %>
    		</b>
    	</span>
    	<span class="r"></span>
    </div>
    <div class="clearFloat"></div>
  </div>
  <!--订单合计结束-->
        <!--Module-->
        <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">去程航班 </b><b class="right">出发日期：<%=bookingGoFlightVo.getDepartureDateStr()%></b></span><span class="r"></span></div>
        <div class="inner air_Selected clearfix_">
                <table class="table_style">
                <thead>
                        <tr>
                        <th class="airline">航班信息</th>
                        <th class="airtime">起降时间</th>
                        <th class="airport">起降机场</th>
                        <th class="">经停机场</th>
                        <th class="airprice">舱位</th>
                        <th class="airtax">机建+燃油</th>
                        <th class="airtotal">单张合计</th>
                    </tr>
                    </thead>
                <tbody>
                        <tr>
                        <td class="airline"><span class="airlogo airlogo_hu"><img src="${ctx}/web/images/32_32/icon_airport<%=bookingGoFlightVo.getAirlineCompanyCode()%>.gif"></span> <strong><al:write key="<%=bookingGoFlightVo.getAirlineCompanyCode()%>"></al:write><br>
                            <%=bookingGoFlightVo.getAirlineCompanyCode()%><%=bookingGoFlightVo.getFlightNo()%></strong></td>
                        <td class="airtime"><%=bookingGoFlightVo.getDepartureTimeStr() %><br>
                            <%=bookingGoFlightVo.getArrivalTimeStr() %></td>
                        <td class="airport">
                        	<ap:write key="<%=bookingGoFlightVo.getDepartureAirport()%>" isDisplayLname="true" /><%= bookingGoFlightVo.getDepartureTerminal() == null || "".equals(bookingGoFlightVo.getDepartureTerminal())? "" : "[" + bookingGoFlightVo.getDepartureTerminal() + "]"%><br>
                            <ap:write key="<%=bookingGoFlightVo.getArrivalAirport()%>" isDisplayLname="true" /><%= bookingGoFlightVo.getArrivalTerminal() == null || "".equals(bookingGoFlightVo.getArrivalTerminal())? "" : "[" + bookingGoFlightVo.getArrivalTerminal() + "]"%>
                        </td>
                        <td>无<br /></td>
                        <td class="airprice"><%=bookingGoFlightVo.getCabinCode()%> 舱</td>
                        <td class="airtax"><%=bookingGoFlightVo.getAdultConstructionFee() %>/<%=bookingGoFlightVo.getAdultBaf() %></td>
                        <td class="airtotal"><strong>¥<%=bookingGoFlightVo.getAdultTicketPrice().add(bookingGoFlightVo.getAdultBaf()).add(bookingGoFlightVo.getAdultConstructionFee())%></strong><br />
                            <a href="#" class="orangea Tickets_TG">退改签规则</a><div class="Tickets_TGBox"><%=bookingGoFlightVo.getChangeInfo()%></div></td>
                    </tr>
                    </tbody>
            </table>
            </div>
        <b class="bl"></b> <b class="br"></b> </div>
        <!--Module end--> 
        <!--Module-->
        <%
	        if("2".equals(request.getParameter("bookingReturnFlightVo.flightType"))){
        %>
        <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">返程航班 </b><b class="right">返程日期：<%=bookingReturnFlightVo.getDepartureDateStr()%></b></span><span class="r"></span></div>
        <div class="inner air_Selected clearfix_">
                <table class="table_style">
                <thead>
                        <tr>
                        <th class="airline">航班信息</th>
                        <th class="airtime">起降时间</th>
                        <th class="airport">起降机场</th>
                        <th class="">经停机场</th>
                        <th class="airprice">舱位</th>
                        <th class="airtax">机建+燃油</th>
                        <th class="airtotal">单张合计</th>
                    </tr>
                    </thead>
                <tbody>
                        <tr>
                        <td class="airline"><span class="airlogo airlogo_hu"><img src="${ctx}/web/images/32_32/icon_airport<%=bookingReturnFlightVo.getAirlineCompanyCode()%>.gif"></span> <strong><al:write key="<%=bookingReturnFlightVo.getAirlineCompanyCode()%>"></al:write><br>
                            <%=bookingReturnFlightVo.getAirlineCompanyCode()%><%=bookingReturnFlightVo.getFlightNo()%></strong></td>
                        <td class="airtime"><%=bookingReturnFlightVo.getDepartureTimeStr() %><br>
                            <%=bookingReturnFlightVo.getArrivalTimeStr() %></td>
                        <td class="airport">
                        	<ap:write key="<%=bookingReturnFlightVo.getDepartureAirport()%>" isDisplayLname="true" /><%= bookingReturnFlightVo.getDepartureTerminal() == null || "".equals(bookingReturnFlightVo.getDepartureTerminal())? "" : "[" + bookingReturnFlightVo.getDepartureTerminal() + "]"%><br>
                            <ap:write key="<%=bookingReturnFlightVo.getArrivalAirport()%>" isDisplayLname="true" /><%= bookingReturnFlightVo.getArrivalTerminal() == null || "".equals(bookingReturnFlightVo.getArrivalTerminal())? "" : "[" + bookingReturnFlightVo.getArrivalTerminal() + "]"%>
                        </td>
                        <td>无<br /></td>
                        <td class="airprice"><%=bookingReturnFlightVo.getCabinCode() %> 舱</td>
                        <td class="airtax"><%=bookingReturnFlightVo.getAdultConstructionFee() %>/<%=bookingReturnFlightVo.getAdultBaf() %></td>
                        <td class="airtotal"><strong>¥<%=bookingReturnFlightVo.getAdultTicketPrice().add(bookingReturnFlightVo.getAdultBaf()).add(bookingReturnFlightVo.getAdultConstructionFee())%></strong><br />
                            <a href="#" class="orangea Tickets_TG">退改签规则</a><div class="Tickets_TGBox"><%=bookingReturnFlightVo.getChangeInfo()%></div></td>
                    </tr>
                    </tbody>
            </table>
            </div>
        <b class="bl"></b> <b class="br"></b> </div>
        <%} %>
        <!--Module end--> 
        <!--Module-->
        <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">乘机人信息 </b></span><span class="r"></span></div>
        <div class="inner PeopleInfo ConfirmOrder" id="PeopleInfoBox"> 
                <!--PeopleInfo-->
        <%
       		for(int i = 0; i<=Integer.parseInt(request.getParameter("passengerNum")); i++){
        %>
                <dl name = "passenger">
                <dt><span class="left">乘机人<b class="PassengerNo"><%=i+1%></b></span></dt>
                <dd>
                        <ul class="clearfix_">
                        <li>乘客姓名：<b><%=request.getParameter("memberPassengerVoList["+i+"].passName") %></b></li>
                        <%
                        String certType = "";
                        if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("1")){
                    	 	certType = "护照";
                       	 }else if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("2")){
                       		certType = "军官证";
                       	 }else if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("3")){
                       		certType = "港澳通行证";
                       	 }else if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("4")){
                       		certType = "回乡证";
                       	 }else if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("5")){
                       		certType = "台胞证";
                       	 }else if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("6")){
                       		certType = "国际海员证";
                       	 }else if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("7")){
                       		certType = "外国人永久居留证";
                       	 }else if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("9")){
                       		certType = "其他";
                       	 }else if(request.getParameter("memberPassengerVoList["+i+"].credentials").equals("0")){
                       		certType = "身份证";
                       	 }
                        %>
                        <li><span class="left">证件类型：</span><b><%=certType%></b> </li>
                        <li>证件号码：<b><%=request.getParameter("memberPassengerVoList["+i+"].idCard") %></b> </li>
                        <%
                        String type = "";
                        if(request.getParameter("memberPassengerVoList["+i+"].ticketsType").equals("01")){
                        	type = "成人票";
                        } else if(request.getParameter("memberPassengerVoList["+i+"].ticketsType").equals("02")){
                        	type = "儿童票";
                        }
                        %>
                        <li><span class="left">购票类型：</span><b><%=type%></b></li>
                        <li><span class="left">航空保险：</span><b><%=request.getParameter("memberPassengerVoList["+i+"].insure")%> 份</b></li>
						<!-- 
                        <li>常旅客卡：<b><%=request.getParameter("memberPassengerVoList["+i+"].passengerCard") %></b></li>
                        <li><span class="left">特殊餐食：</span><b><%=request.getParameter("memberPassengerVoList["+i+"].catering") %></b></li>
                    	-->
                    </ul>
                    </dd>
            </dl>
            <%} %>
                <!--PeopleInfo end--> 
               
            </div>
        <b class="bl"></b> <b class="br"></b> </div>
        <!--Module end--> 
        <!--Module-->
        <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c">联系人信息</span><span class="r"></span></div>
        <div class="inner clearfix_">
                <ul class="clearfix_ x3">
                <li>姓名：<b><%=request.getParameter("contactName") %></b></li>
                <li>联系方式：<b><%=request.getParameter("contactPhone") %></b></li>
                <li>邮箱地址：<b><%=request.getParameter("contactEmail") %></b></li>
            </ul>
            </div>
        <b class="bl"></b> <b class="br"></b> </div>
        <!--Module end--> 
        <!--Module-->
        <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">行程单配送</b></span><span class="r"></span></div>
        <div class="inner clearfix_">
                <ul class="clearfix_ x3" id="ItinerarySelect" name="ItinerarySelect">
                <li>
                        <input type="radio" value="0" id="radioid0"  name="payItinerarySelect" checked="">
                        <label for="radioid0">无需配送</label>
                    </li>
                <li>
                        <input type="radio" value="1" id="radioid1"  name="payItinerarySelect">
                        <label for="radioid1">需要配送</label>
<!--                        <b>(北京地区:10元 其他地区:15元)</b></li>-->
<!--                <li>-->
<!--                        <input type="radio" value="2" id="radioid2" name="payItinerarySelect">-->
<!--                        <label for="radioid2">挂号信</label>-->
<!--                        <b>(全国范围5元)</b></li>-->
            </ul>
                <dl class="Itinerary" id="ItineraryContent" = name="ItineraryContent">
                <dt>邮寄行程单 - <b>行程单只作为报销凭证.如需要行程单,我们会在飞机起飞后7天内进行打印并邮寄给你,请勿着急.超过7天不再提供打印服务.</b></dt>
                <dd class="clearfix_"> <span class="left">收<b style="width:0.5em; display:inline-block;"></b>件<b style="width:0.5em; display:inline-block;"></b>人：<input type="text" name="catchName" class="jdmc">
                    </span><span class="left marginL10">联系电话：
                    <input type="text" name="catchMobile" class="jdmc" id="phoneId" maxlength="11">
                    </span><span class="left marginL10">邮编：
                    <input type="text" name="catchPostCode" class="jdmc" id="PostCodeId">
                    </span> </dd>
                <dd class="clearfix_"> <span class="left">收件地址：</span><span class="left">
                    <div class="inb">
                    <input name="catchCity" type="hidden" id="itineraryCity" value="" width="100"/>
                    <input name="itineraryCityName" 
                   type="text" class="inputText" 
                   id="itineraryCityName" 
                   autoComplete="off"
                   value="中文/拼音"
                   onfocus="showSearch(this)" 
                   onblur="blurEvt(this)"
                   onclick="suggest.display(this,'itineraryCity',event)" 
                   onkeyup="suggest.display(this,'itineraryCity',event)"
                   style="height:20px;"
                   />       
                        </div>
                    </span> <span class="left"> &nbsp;
                    <input type="text" class="input4" name="catchAddress" >
                    </span></dd>
            </dl>
            </div>
        <b class="bl"></b> <b class="br"></b> </div>
        <!--Module end--> 
    </div>

<div class="grf_borderb Wmargin tijiao_frm">
<!--	<a href="#" onclick="returnLastPage();return false;" ><img src="${ctx}/web/images/fhup.jpg"/></a>-->
	<input type="image" onclick="returnLastPage()" src="${ctx}/web/images/fhup.jpg" id="reb"/>&nbsp;&nbsp;&nbsp;
	<input type="image" onclick="getPassengerDetail()" src="${ctx}/web/images/tijiao.jpg" id="tjb"/>
<!--	<a href="#" onclick="getPassengerDetail();return false;"><img src="${ctx}/web/images/tijiao.jpg"/></a>-->
</div>
<form action="${ctx}/flight/book.jsp" id="returnLastPageForm" method="post" >
	<input type="hidden" name="flightType" value="<%=request.getParameter("flightType")%>" />
	<input type="hidden" name="goflightInfoJson" value="<%=request.getParameter("goflightInfoJson")%>" />
	<input type="hidden" name="gocabinInfoJson" value="<%=request.getParameter("gocabinInfoJson")%>" />
	<input type="hidden" name="gospecialInfoJson" value="<%=request.getParameter("gospecialInfoJson")%>" />
	<input type="hidden" name="reflightInfoJson" value="<%=request.getParameter("reflightInfoJson")%>" />
	<input type="hidden" name="recabinInfoJson" value="<%=request.getParameter("recabinInfoJson")%>" />
	<input type="hidden" name="respecialInfoJson" value="<%=request.getParameter("respecialInfoJson")%>" />
	
	<input type="hidden" name="contactName" value="<%=request.getParameter("contactName")%>" />
	<input type="hidden" name="contactPhone" value="<%=request.getParameter("contactPhone")%>" />
	<input type="hidden" name="contactEmail" value="<%=request.getParameter("contactEmail")%>" />
   
</form>



<script type="text/javascript">
//获取DOM对象的绝对位置
function getAbsPoint(e) {   
    var x = e.offsetLeft;   
    var y = e.offsetTop;   
    while(e = e.offsetParent) {   
        x += e.offsetLeft;   
        y += e.offsetTop;   
    }   
    return {x:x,y:y};   
} 

$(".Tickets_TG").live("mouseover",function(){
	$(this).next().show();
	var temp=getAbsPoint(this);
	var intX=temp.x+$(this).next().width()-$(window).width();
	if(intX<0)$(this).next().css({left:temp.x+"px",top:temp.y+18+"px"});
	else $(this).next().css({left:temp.x-$(this).next().width()+$(this).width()-10+"px",top:temp.y+15+"px"});
});
$(".Tickets_TG").live("mouseout",function(){
	$(this).next().hide();
});


$(function(){
	// 行程单配送
	var radios =$("#ItinerarySelect :radio[name=payItinerarySelect]"), box =$(".Itinerary");
	box.hide();
	radios.eq(0).attr("checked",true);
	radios.click(function(){
		radios.index(this)===0?box.hide():box.show();
	});
	
   
});
function returnLastPage(){
	$("#returnLastPageForm").submit();
	$("#reb").attr("disabled",true);
}
function getPassengerDetail(){
	var messageError=yzData();
	if(""!=messageError){
	 alert(messageError);
	 return;
	}
	var deliveryType = "";
	$("ul[name='ItinerarySelect']").each(function(i){
		deliveryType = $(this).find("input:radio[checked='true']").val();
	});
	
	//alert($("#ItineraryContent").html());
	//alert($("#ItineraryContent").find("input:text[name='catchName']").val());
	if(deliveryType!=0){
		var catchName = $("#ItineraryContent").find("input:text[name='catchName']").val();
		var catchMobile = $("#ItineraryContent").find("input:text[name='catchMobile']").val();
		var catchPostCode = $("#ItineraryContent").find("input:text[name='catchPostCode']").val();
		var catchCity = $("#ItineraryContent").find("input:hidden[name='catchCity']").val();
		var catchAddress = $("#ItineraryContent").find("input:text[name='catchAddress']").val();
	
		
		$("#catchName").attr("value",catchName);
		$("#catchMobile").attr("value",catchMobile);
		$("#catchPostCode").attr("value",catchPostCode);
		$("#catchCity").attr("value",catchCity);
		$("#catchAddress").attr("value",catchAddress);
	}
	else{
		$("#catchName").attr("value","");
		$("#catchMobile").attr("value",catchMobile);
		$("#catchPostCode").attr("value",catchPostCode);
		$("#catchCity").attr("value",catchCity);
		$("#catchAddress").attr("value",catchAddress);
	}
	$("#deliveryType").attr("value",deliveryType);
	$("#bookingFlightForm").submit();
	$("#tjb").attr("disabled",true);
	$("#tjb").attr("src","${ctx}/web/images/tijiaoOff.jpg");
}

function yzData(){
	var errorMessage="";
	var deliveryType="";
	var partten = /^[\u4e00-\u9fa5a-zA-Z]*$/
	var catchName = $("#ItineraryContent").find("input:text[name='catchName']");
	$("ul[name='ItinerarySelect']").each(function(i){
		deliveryType = $(this).find("input:radio[checked='true']").val();
	});
	if(deliveryType!=0){
		if($("#ItineraryContent").find("input:text[name='catchName']").val()=="" || $("#ItineraryContent").find("input:text[name='catchName']").val()==null){
			errorMessage = "收件人为空";
		}
		else if((validateObj(regexEnum.letter,catchName) && catchName.val().indexOf("/") <0)
	        	|| (catchName.val().indexOf("/") ==0 || catchName.val().indexOf("/") == catchName.val().length-1)
	        	|| !validateObj(regexEnum.passenger,catchName) ){
	     		errorMessage="请输入正确的收件人姓名，如zhang\/san,张san,张三";
	    		catchName.focus();
		}
		else if(escape(catchName.val()).indexOf("%u")!=-1 && !partten.test(catchName.val())){
	    		errorMessage="姓名中不能带有特殊字符";
	     		catchName.focus();
		}
		else if((validateObj(regexEnum.chinese,catchName) && catchName.val().length>10)
		    	        || (!validateObj(regexEnum.chinese,catchName) && catchName.val().length>30)){
		     errorMessage="您输入的收件人姓名过长";
		     catchName.focus();
		        	
		}
		else if($("#ItineraryContent").find("input:text[name='catchMobile']").val()=="" || $("#ItineraryContent").find("input:text[name='catchMobile']").val()==null){
			errorMessage = "联系电话为空"
		}
		else if($("#ItineraryContent").find("input:text[name='catchPostCode']").val()!="" && $("#ItineraryContent").find("input:text[name='catchPostCode']").val()!=null){
			if(!validate(regexEnum.zipcode,"PostCodeId")){
			errorMessage = "请输入正确的邮编";
			$('#PostCodeId').focus();
			}
		}
		else if($("#ItineraryContent").find("input:hidden[name='catchCity']").val()=="" || $("#ItineraryContent").find("input:hidden[name='catchCity']").val()==null){
			errorMessage = "收件地址为空"
		}
		else if($("#ItineraryContent").find("input:text[name='catchAddress']").val()=="" || $("#ItineraryContent").find("input:text[name='catchAddress']").val()==null){
			errorMessage = "收件地址为空"
		}
		else if(!validate(regexEnum.mobile,"phoneId")){
        errorMessage = "收件人手机号格式错误！";
        $("#phoneId").focus();
    }
	}
	return errorMessage;
}
//alert($("#bookingFlightForm").html());
</script>
</body>
