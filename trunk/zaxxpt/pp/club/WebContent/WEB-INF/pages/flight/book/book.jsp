﻿<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.framework.utils.ListUtils"%>
<%@page import="com.hnatourism.framework.utils.DateFormatUtils"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select3css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidator_min.js" defer="defer"></script>
<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidatorRegex.js"></script>
<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidator_helper.js"></script>
<script  src="${ctx}/web/js/clubJs/addForm.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/ValidateFlightUtil.js"></script>
<title>机票订单填写-机票预订 - ${domain_cn }</title>
</head>
<%--包含机票信息解析处理功能的jsp--%>
<%@include file="/flight/order/bookAnalysis.jsp" %>  
<%MemberInfoVo memberVo=(MemberInfoVo)request.getAttribute("memberVo"); %>
<body>
<div class="xx_nav">
    <ul>
        <li><img src="${ctx}/web/images/xileft.jpg" /></li>
        <li class="se_nav"><span class="jd_ddxx">填写订单</span></li>
        <li><img src="${ctx}/web/images/xiright.jpg" /></li>
    </ul>
</div>
<div class="clear"></div>



<div class="main980"> 
    <!--Module-->
    <%
    String reSelect = "search.jsp?flightType="+bookingGoFlightVo.getFlightType()+"&deAirport="+bookingGoFlightVo.getDepartureAirportCode()+"&arAirport="+bookingGoFlightVo.getArrivalAirportCode()+"&departureDate="+bookingGoFlightVo.getDepartureDateStr();
    if(bookingReturnFlightVo!=null){
    	reSelect = "search.jsp?flightType="+bookingReturnFlightVo.getFlightType()+"&deAirport="+bookingGoFlightVo.getDepartureAirportCode()+"&arAirport="+bookingGoFlightVo.getArrivalAirportCode()+"&departureDate="+bookingGoFlightVo.getDepartureDateStr()+"&returnDate="+bookingReturnFlightVo.getDepartureDateStr();
    }
    %>
    
    <div class="module_a Order">
        <div class="title">
        	<span class="l"></span>
        	<span class="c">
        		<b class="left">已选定的去程航班 </b>
        		<b class="left">&nbsp;<a class="blue" href=<%=reSelect%>>[重新选择去程]</a></b>
        		<b class="right">出发日期：<%=bookingGoFlightVo.getDepartureDateStr()%></b>
        	</span>
        	<span class="r"></span></div>
        <div class="inner air_Selected">
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
                        <td class="airline">
                        	<span class="airlogo airlogo_hu">
                        		<img src="${ctx}/web/images/32_32/icon_airport<%=bookingGoFlightVo.getAirlineCompanyCode()%>.gif">
                        	</span> 
                        	<strong>
                        		<al:write key="<%=bookingGoFlightVo.getAirlineCompanyCode()%>"></al:write>
                        		<br>
                            	<%=bookingGoFlightVo.getAirlineCompanyCode()%><%=bookingGoFlightVo.getFlightNo()%>
                            </strong>
                        </td>
                        <td class="airtime">
                        	<%=bookingGoFlightVo.getDepartureTimeStr() %>
                        	<br>
                            <%=bookingGoFlightVo.getArrivalTimeStr() %>
                        </td>
                        <td class="airport">
                        	<ap:write key="<%=bookingGoFlightVo.getDepartureAirport()%>" isDisplayLname="true" /><%= bookingGoFlightVo.getDepartureTerminal() == null || "".equals(bookingGoFlightVo.getDepartureTerminal())? "" : "[" + bookingGoFlightVo.getDepartureTerminal() + "]"%><br>
                            <ap:write key="<%=bookingGoFlightVo.getArrivalAirport()%>" isDisplayLname="true" /><%= bookingGoFlightVo.getArrivalTerminal() == null || "".equals(bookingGoFlightVo.getArrivalTerminal())? "" : "[" + bookingGoFlightVo.getArrivalTerminal() + "]"%>
                        </td>
                        <td>
                        	无<br />
                        </td>
                        <td class="airprice"><%=bookingGoFlightVo.getCabinCode()%> 舱</td>
                        <td class="airtax"><%=bookingGoFlightVo.getAdultConstructionFee() %>/<%=bookingGoFlightVo.getAdultBaf() %></td>
                        <% BigDecimal amount = bookingGoFlightVo.getAdultTicketPrice();%>
                        <td class="airtotal">
	                        <strong>¥<%
	                        if(amount != null && bookingGoFlightVo.getAdultBaf() != null && bookingGoFlightVo.getAdultConstructionFee()!= null){
	               				out.print(bookingGoFlightVo.getAdultTicketPrice().add(bookingGoFlightVo.getAdultBaf()).add(bookingGoFlightVo.getAdultConstructionFee()).toBigInteger());
	                        }%>
	                        </strong><br />
	                        <a href="#" class="orangea Tickets_TG">退改签规则</a>
	                        <div class="Tickets_TGBox"><%=bookingGoFlightVo.getChangeInfo()%></div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
    <!--Module end--> 
    <!--Module-->
    <%
    if(bookingReturnFlightVo!=null){
    %>
    <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">已选定的返程航班 </b><b class="left">&nbsp;<a class="blue" href="javascript:void(0)" onclick="bookingFlightReturn()">[重新选择返程]</a></b><b class="right">返程日期：<%=bookingReturnFlightVo.getDepartureDateStr()%></b></span><span class="r"></span></div>
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
                        <td>无<br />
                            </td>
                  
                        <td class="airprice"><%=bookingReturnFlightVo.getCabinCode() %> 舱</td>
                        <td class="airtax"><%=bookingReturnFlightVo.getAdultConstructionFee() %>/<%=bookingReturnFlightVo.getAdultBaf() %></td>
                        <td class="airtotal"><strong>¥<%=bookingReturnFlightVo.getAdultTicketPrice().add(bookingReturnFlightVo.getAdultBaf()).add(bookingReturnFlightVo.getAdultConstructionFee()).toBigInteger() %></strong><br />
                            <a href="#" class="orangea Tickets_TG">退改签规则</a><div class="Tickets_TGBox"><%=bookingReturnFlightVo.getChangeInfo()%></div></td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <b class="bl"></b> <b class="br"></b> </div>
        
<%--        重新搜索返程数据时传递的去程数据和查询条件--%>
        <form action="${ctx}/flight/searchReturn.jsp" method="post" id="flightBookForm">
			<input type="hidden" name="flightType" value="2" id="flightType"/>
			<input type="hidden" name="deAirport" value="${deAirport }" />  
			<input type="hidden" name="arAirport" value="${arAirport }"/>   
			<input type="hidden" name="departureDate" value="${departureDate }" /> 
			<input type="hidden" name="returnDate" value="${returnDate }"/>
			<input type="hidden" name="goflightInfoJson" value="${goflightInfoJson}" />
			<input type="hidden" name="gocabinInfoJson" value="${gocabinInfoJson}" />
			<input type="hidden" name="gospecialInfoJson" value="${gospecialInfoJson}" />
		</form>
        
        <% }%>
    <!--Module end--> 
    <!--Module-->
    
    <div id="nodes" style="display:none;">
        	<li name="passenger">
        	<a class="icon_close" style="float:right;" href="#" title="删除">删除</a>
        	乘客姓名：<input onblur="inputFocus($(this))" class="orderPersonName" type="text" class="inputText" value="" name="pName">
        	<a href="#" class="orangea Tickets_TG">填写说明</a><div class="Tickets_TGBox">1、乘客姓名必须与登机时所使用证件上的名字一致。<br>2、如持护照登机，使用中文姓名，必须确认护照上有中文姓名。<br>3、持护照登机的外宾，必须按照护照顺序区分姓与名，例如“Smith/Black”，不区分大小写。<br>4、英文名字的长度不可超过29个字符，如名字过长请使用缩写。<br>5、如名字中包含生僻字可直接输入拼音代替。例如：“王鬳”可输入为“王yan”。</div>
        	&nbsp;&nbsp;
        	     购票类型：<f:select type="乘客类型" name="pType" styleClass="orderPersonAge" showValue="false" value="01"></f:select>
        	     <span name="price" style="padding-left:10px;">￥${adultPrice}元／成人</span>（含税费）
        	     &nbsp;&nbsp;
        	     证件类型：
        	     <f:select type="证件类型" name="pCertType" styleClass="orderPersonCre" showValue="false" style="width: 125px;"></f:select>
        	     <br/>证件号码：<input name="pCertNo" class="orderPersonNumber" type="text" class="inputText" value="" maxlength="18">
        	     <a href="#" class="orangea Tickets_TG">证件说明</a><div class="Tickets_TGBox">1、成人有效证件（12周岁以上）：身份证、护照、回乡证、台胞证、港澳通行证、军人证、国际海员证、外国人永久居留证、旅行证、户口簿等。<br>2、儿童有效证件（2-12周岁）：户口簿、身份证、护照、出生证明等。<br>3、婴儿有效证件（14天-2周岁）：出生证明、户口簿等。<br>备注:儿童和婴儿如使用“户口簿”、“出生证明”及“其它”证件登机时，“证件号码”栏如无身份证号可以填写出生年月日, 格式为yyyymmdd。</div>
        	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	     <span style="margin-left:2px;">航空保险：</span><select class="pInsurance" name="pInsurance" style="width: 40px;">
        	     	<option selected="selected">0</option>
        	     	<option>1</option>
        	     	<option>2</option>
        	     	<option>3</option>
        	     	<option>4</option>
        	     </select>
        	     ￥20元/份<a href="#" class="orangea Tickets_TG">保险说明</a><div class="Tickets_TGBox">保费：20元人民币。<br>保险金额：航空意外50万元人民币、火车轮船意外20万元人民币、汽车意外2万元人民币。<br>保险期限：七天。<br>投保份数：每一被保险人最多投保4份，多投无效。</div>
        	    
        	     <input type="hidden"  name="pIndex" class="pIndex" value="">
        	     <input type="hidden"  name="pId" class="pId" value="">
            </li>
            <!--[if IE 6]>
		    <iframe class=bgiframe style="display:block; z-index:-1; filter:Alpha(Opacity='0'); left:-1px; left:expression(((parseInt(this.parentNode.currentStyle.borderLeftWidth)||0)*-1)+'px'); width:0px; width:expression(this.parentNode.offsetWidth+'px'); position:absolute; top:-1px; top:expression(((parseInt(this.parentNode.currentStyle.borderTopWidth)||0)*-1)+'px'); height:0px; height:expression(this.parentNode.offsetHeight+'px')" tabIndex=-1 src="javascript:false;" frameBorder=0></iframe>
		    <![endif]-->
        </div> 
    
    
    <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">乘机人信息 </b><b class="right"><input value="增加新乘机人" class="add_btn margnT7" style="border:none; width:100px; padding-left:20px;" type="button"></b></span><span class="r"></span></div>
        <div class="inner PeopleInfo" id="PeopleInfoBox">
        <!--PeopleInfo-->
        <ul id="passengerList" class="clearfix_" style="width:auto;">
        <%
        if(!ListUtils.isEmpty(flightMemberPassenVoList)){
    		for(int i=0; i<flightMemberPassenVoList.size(); i++){
    	%>
   		<li>
   			<input type="checkbox" name="nameHistory" />
   			<%=flightMemberPassenVoList.get(i).getName()%>
   		</li>
    	<%		}
    		}
    	%>
        </ul>
        
         <div class="listBox"><ul id="totalMoneyUl"></ul></div>
           
            <!--PeopleInfo end-->
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
    <!--Module end--> 
    <!--订单合计开始-->
 <!--  <div class="module_a Order">
    <div class="title"><span class="l"></span><span class="c"><b class="left">总计：&nbsp;&nbsp;￥0&nbsp;&nbsp;成人0张&nbsp;&nbsp;￥0&nbsp;&nbsp;（机建费：￥0，燃油费：￥0）　儿童0张&nbsp;&nbsp;￥0&nbsp;&nbsp;(机建费：￥0，燃油费：￥0) </b></span><span class="r"></span></div>
    <div class="clearFloat"></div>
  </div>
  -->
  <!--订单合计结束-->
</div>

<div class="jd_fy_box margin5">
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy"><span class="black">联系人</span></li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
</div>
<div class="jp_xx_black Wmargin1 bg_fb lxr1">
    <ul name="contact">
        <li class="w1">姓 名：</li>
        <li class="w2">
            <input name="contactName" type="text" class="jdmc" value="<%=request.getParameter("contactName")==null?memberVo.getName():request.getParameter("contactName")%>"/>
        </li>
        <li class="w3">手机：</li>
        <li class="w4">
            <input id="phone" name="contactPhone" type="text" class="jdmc" value="<%=request.getParameter("contactPhone")==null?memberVo.getMobile():request.getParameter("contactPhone")%>" maxlength="11"/>
        </li>
        <li class="w5">邮箱地址：</li>
        <li class="w6">
            <input id="emailId" name="contactEmail" type="text" class="input1" value="<%=request.getParameter("contactEmail")==null?memberVo.getEmail():request.getParameter("contactEmail")%>" />
        </li>
    </ul>
</div>
<form action="confirm.jsp"  method="post" id="bookingFlightForm">
	<input type="hidden" name="flightType" value="<%=filghtType%>" />
	<input type="hidden" name="goflightInfoJson" value="${goflightInfoJson}" />
	<input type="hidden" name="gocabinInfoJson" value="${gocabinInfoJson}" />
	<input type="hidden" name="gospecialInfoJson" value="${gospecialInfoJson}" />
	
	
	<input type="hidden" name="bookingGoFlightVo.adultBaf" value="<%=bookingGoFlightVo.getAdultBaf()%>" />
	<input type="hidden" name="bookingGoFlightVo.adultConstructionFee" value="<%=bookingGoFlightVo.getAdultConstructionFee()%>" />
	<input type="hidden" name="bookingGoFlightVo.adultTicketPrice" value="<%=bookingGoFlightVo.getAdultTicketPrice()%>" />
	<input type="hidden" name="bookingGoFlightVo.aircraftType" value="<%=bookingGoFlightVo.getAircraftType()%>" />
	<input type="hidden" name="bookingGoFlightVo.airlineCompany" value="<%=bookingGoFlightVo.getAirlineCompany()%>" />
	<input type="hidden" name="bookingGoFlightVo.airlineCompanyCode" value="<%=bookingGoFlightVo.getAirlineCompanyCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalAirport" value="<%=bookingGoFlightVo.getArrivalAirport()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalAirportCode" value="<%=bookingGoFlightVo.getArrivalAirportCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalTerminal" value="<%=bookingGoFlightVo.getArrivalTerminal()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalCity" value="<%=bookingGoFlightVo.getArrivalCity()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureDate" value="<%=bookingGoFlightVo.getDepartureDate()!= null ? DateFormatUtils.format(bookingGoFlightVo.getDepartureDate(),"yyyy-MM-dd HH:mm:ss"):null%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalDate" value="<%=bookingGoFlightVo.getArrivalDate()!= null ? DateFormatUtils.format(bookingGoFlightVo.getArrivalDate(),"yyyy-MM-dd HH:mm:ss"):null%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalDateStr" value="<%=bookingGoFlightVo.getArrivalDateStr()%>" />
	<input type="hidden" name="bookingGoFlightVo.arrivalTimeStr" value="<%=bookingGoFlightVo.getArrivalTimeStr()%>" />
	<input type="hidden" name="bookingGoFlightVo.cabinCode" value="<%=bookingGoFlightVo.getCabinCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.cabinPriceOld" value="<%=bookingGoFlightVo.getCabinPriceOld()%>" />
	<input type="hidden" name="bookingGoFlightVo.cabinSeatNum" value="<%=bookingGoFlightVo.getCabinSeatNum()%>" />
	<input type="hidden" name="bookingGoFlightVo.childTicketPrice" value="<%=bookingGoFlightVo.getChildTicketPrice()%>" />
	<input type="hidden" name="bookingGoFlightVo.childConstructionFee" value="<%=bookingGoFlightVo.getChildConstructionFee()%>" />
	<input type="hidden" name="bookingGoFlightVo.childBaf" value="<%=bookingGoFlightVo.getChildBaf()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureAirport" value="<%=bookingGoFlightVo.getDepartureAirport()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureAirportCode" value="<%=bookingGoFlightVo.getDepartureAirportCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureTerminal" value="<%=bookingGoFlightVo.getDepartureTerminal()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureCity" value="<%=bookingGoFlightVo.getDepartureCity()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureDateStr" value="<%=bookingGoFlightVo.getDepartureDateStr()%>" />
	<input type="hidden" name="bookingGoFlightVo.departureTimeStr" value="<%=bookingGoFlightVo.getDepartureTimeStr()%>" />
	<input type="hidden" name="bookingGoFlightVo.discount" value="<%=bookingGoFlightVo.getDiscount()%>" />
	<input type="hidden" name="bookingGoFlightVo.flightNo" value="<%=bookingGoFlightVo.getFlightNo()%>" />
	<input type="hidden" name="bookingGoFlightVo.flightType" value="<%=bookingGoFlightVo.getFlightType()%>" />
	<input type="hidden" name="bookingGoFlightVo.orderType" value="<%=bookingGoFlightVo.getOrderType()%>" />
	<input type="hidden" name="bookingGoFlightVo.policyCode" value="<%=bookingGoFlightVo.getPolicyCode()%>" />
	<input type="hidden" name="bookingGoFlightVo.prodType" value="<%=bookingGoFlightVo.getProdType()%>" />
	<input type="hidden" name="bookingGoFlightVo.adultTicketPricePar" value="<%=bookingGoFlightVo.getAdultTicketPricePar()%>" />
	<input type="hidden" name="bookingGoFlightVo.childTicketPricePar" value="<%=bookingGoFlightVo.getChildTicketPricePar()%>" />
	<input type="hidden" name="bookingGoFlightVo.flightOrgin" value="<%=bookingGoFlightVo.getFlightOrigin()%>" />
	<input type="hidden" name="bookingGoFlightVo.totalCommissionRate" value="<%=bookingGoFlightVo.getTotalCommissionRate()%>" />
	<input type="hidden" name="bookingGoFlightVo.changeInfo" value="<%=bookingGoFlightVo.getChangeInfo()%>" />
	<% 
	if(bookingReturnFlightVo!=null){
	%>
	<input type="hidden" name="reflightInfoJson" value="${reflightInfoJson}" />
	<input type="hidden" name="recabinInfoJson" value="${recabinInfoJson}" />
	<input type="hidden" name="respecialInfoJson" value="${respecialInfoJson}" />
	
	<input type="hidden" name="bookingReturnFlightVo.adultBaf" value="<%=bookingReturnFlightVo.getAdultBaf()%>" />
	<input type="hidden" name="bookingReturnFlightVo.adultConstructionFee" value="<%=bookingReturnFlightVo.getAdultConstructionFee()%>" />
	<input type="hidden" name="bookingReturnFlightVo.adultTicketPrice" value="<%=bookingReturnFlightVo.getAdultTicketPrice()%>" />
	<input type="hidden" name="bookingReturnFlightVo.aircraftType" value="<%=bookingReturnFlightVo.getAircraftType()%>" />
	<input type="hidden" name="bookingReturnFlightVo.airlineCompany" value="<%=bookingReturnFlightVo.getAirlineCompany()%>" />
	<input type="hidden" name="bookingReturnFlightVo.airlineCompanyCode" value="<%=bookingReturnFlightVo.getAirlineCompanyCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalAirport" value="<%=bookingReturnFlightVo.getArrivalAirport()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalAirportCode" value="<%=bookingReturnFlightVo.getArrivalAirportCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalTerminal" value="<%=bookingReturnFlightVo.getArrivalTerminal()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalCity" value="<%=bookingReturnFlightVo.getArrivalCity()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureDate" value="<%=DateFormatUtils.format(bookingReturnFlightVo.getDepartureDate(),"yyyy-MM-dd HH:mm:ss")%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalDate" value="<%=bookingReturnFlightVo.getArrivalDate()!= null?DateFormatUtils.format(bookingReturnFlightVo.getArrivalDate(),"yyyy-MM-dd HH:mm:ss"):null%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalDateStr" value="<%=bookingReturnFlightVo.getArrivalDateStr()%>" />
	<input type="hidden" name="bookingReturnFlightVo.arrivalTimeStr" value="<%=bookingReturnFlightVo.getArrivalTimeStr()%>" />
	<input type="hidden" name="bookingReturnFlightVo.cabinCode" value="<%=bookingReturnFlightVo.getCabinCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.cabinPriceOld" value="<%=bookingReturnFlightVo.getCabinPriceOld()%>" />
	<input type="hidden" name="bookingReturnFlightVo.cabinSeatNum" value="<%=bookingReturnFlightVo.getCabinSeatNum()%>" />
	<input type="hidden" name="bookingReturnFlightVo.childTicketPrice" value="<%=bookingReturnFlightVo.getChildTicketPrice()%>" />
	<input type="hidden" name="bookingReturnFlightVo.childConstructionFee" value="<%=bookingReturnFlightVo.getChildConstructionFee()%>" />
	<input type="hidden" name="bookingReturnFlightVo.childBaf" value="<%=bookingReturnFlightVo.getChildBaf()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureAirport" value="<%=bookingReturnFlightVo.getDepartureAirport()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureAirportCode" value="<%=bookingReturnFlightVo.getDepartureAirportCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureTerminal" value="<%=bookingReturnFlightVo.getDepartureTerminal()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureCity" value="<%=bookingReturnFlightVo.getDepartureCity()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureDateStr" value="<%=bookingReturnFlightVo.getDepartureDateStr()%>" />
	<input type="hidden" name="bookingReturnFlightVo.departureTimeStr" value="<%=bookingReturnFlightVo.getDepartureTimeStr()%>" />
	<input type="hidden" name="bookingReturnFlightVo.discount" value="<%=bookingReturnFlightVo.getDiscount()%>" />
	<input type="hidden" name="bookingReturnFlightVo.flightNo" value="<%=bookingReturnFlightVo.getFlightNo()%>" />
	<input type="hidden" name="bookingReturnFlightVo.flightType" value="<%=bookingReturnFlightVo.getFlightType()%>" />
	<input type="hidden" name="bookingReturnFlightVo.orderType" value="<%=bookingReturnFlightVo.getOrderType()%>" />
	<input type="hidden" name="bookingReturnFlightVo.policyCode" value="<%=bookingReturnFlightVo.getPolicyCode()%>" />
	<input type="hidden" name="bookingReturnFlightVo.prodType" value="<%=bookingReturnFlightVo.getProdType()%>" />
	<input type="hidden" name="bookingReturnFlightVo.adultTicketPricePar" value="<%=bookingReturnFlightVo.getAdultTicketPricePar()%>" />
	<input type="hidden" name="bookingReturnFlightVo.childTicketPricePar" value="<%=bookingReturnFlightVo.getChildTicketPricePar()%>" />
	<input type="hidden" name="bookingReturnFlightVo.flightOrgin" value="<%=bookingReturnFlightVo.getFlightOrigin()%>" />
	<input type="hidden" name="bookingReturnFlightVo.totalCommissionRate" value="<%=bookingReturnFlightVo.getTotalCommissionRate()%>" />
	<input type="hidden" name="bookingReturnFlightVo.changeInfo" value="<%=bookingReturnFlightVo.getChangeInfo()%>" />
	<%} %>
</form>
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<div class=" Wmargin tijiao_frm1">
    <div class="Wmargin">
        <input type="checkbox" name="agree" id="agree" onclick="checkColor()"/>
        <span class="gray">我已阅读并同意<a href="booknotice.jsp" target="_blank">订票协议</a></span></div>
<!--     <a href="javascript:void(0);" onclick="getPassengerDetail()"><img src="${ctx}/web/images/xyb.jpg" /></a> -->
    <input id="control" type="image" src="${ctx}/web/images/xyb.jpg" onclick="getPassengerDetail()"/>
</div>


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


//测试数据
	var cabinSeatNum=Number('${cabinSeatNum}');
	var price_children="${childPrice}";
<%--    //var Arr_infoPassenger = ["李一筒,01,5,494949,2343433322323","李二筒,02,8,49455,33322323,2","李三筒,01,5,494949,2343433322323,0","李四筒,02,0,54523,112222221,3"];--%>
    
    var Arr_infoPassenger = [
    <%
    //使用jsp的程序片段来迭代常用旅客信息
    if(!ListUtils.isEmpty(flightMemberPassenVoList)){
    	for(int i=0; i<flightMemberPassenVoList.size(); i++){
    %>
    "<%=flightMemberPassenVoList.get(i).getName()%>,<%=flightMemberPassenVoList.get(i).getType()%>,<%=flightMemberPassenVoList.get(i).getCertType()%>,<%=flightMemberPassenVoList.get(i).getCertNo()%>,<%=flightMemberPassenVoList.get(i).getId()%>,",
    <%	}
     }
    %>
    ];
   $.each($("input:hidden[name=oldPassengers]"), function(i){       
     //alert(this.value); 
     Arr_infoPassenger[i] = ""+this.value;
    });
    //alert(Arr_infoPassenger); 


	function creatPassengerInfo(obj){ //obj为checkbox索引
		$("#nodes li").removeClass();
		$("#nodes li").addClass("passenger"+obj);
		var liNodes=$("#nodes").html();
		return liNodes;
	}
	
	function fillForm(obj,_infoPasenger){// _infoPasenger为Arr_infoPassenger中的单个元素
		var infos=_infoPasenger.split(",");
		var liObj = $(".listBox li[class='passenger"+obj+"']");
		liObj.find(".orderPersonName").val(infos[0]);
		liObj.find(".orderPersonAge").val(infos[1]);
		if(infos[1]=="02"){
			liObj.find(".orderPersonAge").next().html("&nbsp;&nbsp;&nbsp;￥"+price_children+"元／儿童");
			var temp=liObj.find(".orderPersonCre option");
			for(var i=0;i<temp.length;i++){
				if(temp.eq(i).text()!="身份证" && temp.eq(i).text()!="其他"){
					temp.eq(i).hide();
				}
			}
			
		}
		liObj.find(".orderPersonCre").val(infos[2]);
		liObj.find(".orderPersonNumber").val(infos[3]);
		if(infos[5]){
			liObj.find(".pInsurance option").eq(parseInt(infos[5])).attr("selected",true);
		}
		liObj.find(".pIndex").val(obj);
		liObj.find(".pId").val(infos[4]);
	}
	
	$(".listBox .orderPersonAge").live("change",function(){
		var temp=$(this).parent().find(".orderPersonCre option");
		if($(this).find("option:selected").text()=="儿童"){
			$(this).next().html("￥"+price_children+"元／儿童");
			for(var i=0;i<temp.length;i++){
				if(temp.eq(i).text()!="身份证" && temp.eq(i).text()!="其他"){
					temp.eq(i).hide();
					temp.eq(i).wrap("<span class='sp' style='display:none'></span>");
				}
				if(temp.eq(i).text()=="身份证"){
					temp.eq(i).attr("selected",true);
				}
			}
			
		}
		else{
			$(this).next().html("￥"+'${adultPrice}'+"元／成人");
			for(var i=0;i<temp.length;i++){
				temp.eq(i).show();
				if(temp.eq(i).parent()[0].className=="sp")temp.eq(i).unwrap();
			}	
		}
	});
		

$(function(){
	$("#agree").attr("checked",true);
    
});

function getPassengerDetail(){
	var passengerArr="";
	var bookContent="";
	var passengerNum="";
	var messageError=yzData();
	if(""!=messageError){
	 alert(messageError);
	 return;
	}
	bookContent=$("#bookingFlightForm").html();
	$(".listBox li[name=passenger]").each(function(i){
	passengerArr+="<input type=\"hidden\" name=\"memberPassengerVoList["+i+"].passName\" value=\""+$(this).find("input[name='pName']").val()+"\">";
	passengerArr+="<input type=\"hidden\" name=\"memberPassengerVoList["+i+"].ticketsType\" value=\""+$(this).find("select").eq(0).val()+"\">";
	passengerArr+="<input type=\"hidden\" name=\"memberPassengerVoList["+i+"].id\" value=\""+$(this).find("input[name='pId']").val()+"\">";
	passengerArr+="<input type=\"hidden\" name=\"memberPassengerVoList["+i+"].credentials\" value=\""+$(this).find("select").eq(1).val()+"\">";
//	passengerArr+="<input type=\"hidden\" name=\"memberPassengerVoList["+i+"].catering\" value=\""+$(this).find("select").eq(3).val()+"\">";
	passengerArr+="<input type=\"hidden\" name=\"memberPassengerVoList["+i+"].idCard\" value=\""+$(this).find("input[name='pCertNo']").val()+"\">";
	passengerArr+="<input type=\"hidden\" name=\"memberPassengerVoList["+i+"].insure\" value=\""+$(this).find("select").eq(2).val()+"\">";
	passengerNum = i;
	});
	passengerArr+="<input type=\"hidden\" name=\"contactName\" value=\""+$("ul[name=contact]").find("input[name='contactName']").val()+"\">";
	passengerArr+="<input type=\"hidden\" name=\"contactPhone\" value=\""+$("ul[name=contact]").find("input[name='contactPhone']").val()+"\">";
	passengerArr+="<input type=\"hidden\" name=\"contactEmail\" value=\""+$("ul[name=contact]").find("input[name='contactEmail']").val()+"\">";
	passengerArr+="<input type=\"hidden\" name=\"passengerNum\" value=\""+passengerNum+"\">";
	bookContent+=passengerArr;
	$("#bookingFlightForm").html(bookContent);
	//alert($("#bookingFlightForm").html());
	
	
	$("#bookingFlightForm").submit();
}	
function getPtypeArr(){
$("dl[name=passenger]").each(function(i){
var pType=$(this).find("div[class='select_box']").eq(1).find("div").eq(0).html();
alert(pType);
selectArr[i]=pType;
});
}

function yzData(){
var errorMessage="";
var partten = /^[\u4e00-\u9fa5a-zA-Z]*$/;
var contactNameObj=$("ul[name=contact]").find("input[name='contactName']");  
    contactNameObj.val($.trim(contactNameObj.val()));
var contactPhoneObj=$("ul[name=contact]").find("input[name='contactPhone']");  
    contactPhoneObj.val($.trim(contactPhoneObj.val()));
// 乘客姓名
var certNos = '';
var passenType = false ;
$(".listBox li[name=passenger]").each(function(i){
	var passNameObj = $(this).find("input[name='pName']");
	var certNo = $(this).find("input[name='pCertNo']")
	var pType=$(this).find("select").eq(0).val();
	var pCertType = $(this).find("select").eq(1).val();
	var m_pCertType=parseInt(pCertType);
    // 证件
	//类型 军官证: 2, 护照:  1,  身份证: 0 ,
	var regex = regexEnum.idcard;
	if(pCertType == 0){
	   regex = regexEnum.idcard;
	}
	else if(pCertType == 1){
       regex = regexEnum.passport;
    }
    else {
       regex =regexEnum.notempty;
    }
    if(pType == "01"){
    	passenType = true;
    }
	if(passNameObj.val()=="" || passNameObj.val()==null){
		errorMessage="第"+(i+1)+"个乘机人姓名为空";
		passNameObj.focus();
	}
	else if((validateObj(regexEnum.letter,passNameObj) && passNameObj.val().indexOf("/") <0)
	        	|| (passNameObj.val().indexOf("/") ==0 || passNameObj.val().indexOf("/") == passNameObj.val().length-1)
	        	|| !validateObj(regexEnum.passenger,passNameObj) ){
	     		errorMessage="请输入正确的乘机人姓名，如zhang\/san,张san,张三";
	    		passNameObj.focus();
	}
	else if(escape(passNameObj.val()).indexOf("%u")!=-1 && !partten.test(passNameObj.val())){
	     errorMessage="姓名中不能带有特殊字符";
	     passNameObj.focus();
	}
	else if((validateObj(regexEnum.chinese,passNameObj) && passNameObj.val().length>10)
	    	        || (!validateObj(regexEnum.chinese,passNameObj) && passNameObj.val().length>30)){
	     errorMessage="您输入的乘机人姓名过长";
	     passNameObj.focus();
	        	
	}
	//else if($(this).find("input[name='passengerCard']").val()=="" || $(this).find("input[name='passengerCard']").val()==null){
	//	errorMessage="第"+(i+1)+"个常旅客卡为空";
	//}
	else if(certNo.val()=="" || certNo.val()==null){
		errorMessage="第"+(i+1)+"个证件号码为空";
		certNo.focus();
	}
	else if (certNos.indexOf(certNo.val()) != -1) {
	                //如果是儿童且为出生日期,则允许相同
	                if(!(pType=="02"&&pCertType=="9")){	                
	                errorMessage="证件号码不能相同!";
		            certNo.focus();
	                }
	}
	else if(!validateObj(regex,certNo)){
      errorMessage="请输入正确的乘机人证件号码";
      certNo.focus();
              
  	} 
  	//验证乘客证件号中的出生日期与乘客类型是否吻合
	        
	else if((pType=="01"&&(m_pCertType==0||m_pCertType==9))||(pType=="02"&&(m_pCertType==0||m_pCertType==9))){
	        	if(m_pCertType==9){
	        		if(pType=="02"){
	        			if(!validateText(regexEnum.date,certNo.val())){
	        				errorMessage="出生日期格式错误，如2010-01-30";
	        			}
	        		}
	        	}else{
	        		var tmpPassType=new ValidateFlightUtil().validatePassengerTypeByCertNo(m_pCertType,certNo.val());
		        	if(pType=="02"&&tmpPassType=="adult"){
		        	 	errorMessage="证件号"+certNo.val()+"的乘机人出生日期验证失败!身份证年龄属于成人类型";
		       	 	}else if(pType=="01"&&tmpPassType!="adult"){
		        		errorMessage="证件号"+certNo.val()+"的乘机人出生日期验证失败!身份证年龄属于儿童类型";
		        
		       	 	}else if((pType=="01"&&tmpPassType!="adult")||(pType=="02"&&tmpPassType=="baby")){
		        	 	errorMessage="证件号"+certNo.val()+"的乘机人出生日期验证失败!身份证年龄属于婴儿或还未出生,无法预订";
		        		}
	        		}
	}
	certNos+=certNo.val();
	if(errorMessage!=""){
	return false;
	}
	});
	if(errorMessage!=""){
	
	}
	else if(passenType == false){
  		errorMessage = "至少需要有一个成人";
  	}
	else if($("#agree").attr("checked")==false){
	 errorMessage = "没有同意";
	 $("#agree").focus();
	}
	else if($("ul[name=contact]").find("input[name='contactName']").val()=="" || $("ul[name=contact]").find("input[name='contactName']").val()==null){
		errorMessage = "联系人为空";
		contactNameObj.focus();
	}
	else if($("ul[name=contact]").find("input[name='contactPhone']").val()=="" || $("ul[name=contact]").find("input[name='contactPhone']").val()==null){
		errorMessage = "联系方式为空";
		contactPhoneObj.focus();
	}
	else if($("ul[name=contact]").find("input[name='contactEmail']").val()=="" || $("ul[name=contact]").find("input[name='contactEmail']").val()==null){
		errorMessage = "邮箱地址为空";
	}
	else if(escape(contactNameObj.val()).indexOf("%u")!=-1 && !partten.test(contactNameObj.val())){
	    errorMessage = "姓名中不能带有特殊字符";
	    contactNameObj.focus();
	}
	else if((validateObj(regexEnum.letter,contactNameObj) && contactNameObj.val().indexOf("/") <0)
	        	|| (contactNameObj.val().indexOf("/") ==0 || contactNameObj.val().indexOf("/") == contactNameObj.val().length-1)
	        	|| !validateObj(regexEnum.passenger,contactNameObj) ){
	    errorMessage = "请输入正确的联系人姓名，如zhang\/san,张san,张三";
	    contactNameObj.focus();
	}
	else if((validateObj(regexEnum.chinese,contactNameObj) && contactNameObj.val().length>10)
	    	        || (!validateObj(regexEnum.chinese,contactNameObj) && contactNameObj.val().length>30)){
	    errorMessage = "您输入的联系人姓名过长";
	    contactNameObj.focus();
	}
	
    else if(!validate(regexEnum.mobile,"phone")){
        errorMessage = "联系人手机号格式错误！";
        contactPhoneObj.focus();
    }
    
	return errorMessage;
}
function bookingFlightReturn(){
	$("#flightBookForm").submit();
}
function checkColor(){
	if($("#agree").attr("checked")==false){
		$("#control").attr("disabled", true);
		$("#control").attr("src", "${ctx}/web/images/xybh.jpg");
	}
	if($("#agree").attr("checked")==true){
		$("#control").attr("disabled", false);
		$("#control").attr("src", "${ctx}/web/images/xyb.jpg");
	}
}
</script>
</body>


 
