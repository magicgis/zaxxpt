<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.framework.utils.DateFormatUtils"%>
<%@page import="java.math.BigDecimal"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<title>机票预订 - ${domain_cn }</title>
<style type="text/css">
	.myA{ color:black }
</style>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<%@include file="detailControl.jsp" %>
     <!----------------------------------------- RIGHT ------------------------------------>
    <div class="floatleft width783">
        <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
        
        <div class="listTAB rightbg"> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">订单详情</b><b class="right">总计金额：<b class="red">¥<%=totalMoney%></b></b></span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3 t20b20">
                        <li><span>订单号：<%=code%></span></li>
                        <li>订单状态：<b>
                        <f:write type="F订单状态" value="<%=sts%>"></f:write>
                        </b></li>
                        <li>订单成生时间：<b><%=createTime%></b></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">航班信息<%if(null!= inBookingFlight){ %>（往返）<%} %><%if(null== inBookingFlight){ %>（单程）<%} %> </b><b class="right">出发日期：<%=DateFormatUtils.format(outBookingFlight.getDepartureDate(),"yyyy-MM-dd") %><%if(null!= inBookingFlight){ %>&nbsp;&nbsp;&nbsp;返程日期：<%=DateFormatUtils.format(inBookingFlight.getDepartureDate(),"yyyy-MM-dd")%><%} %></b></span><span class="r"></span></div>
        <div class="inner air_Selected air_Selected_r clearfix_">
                <table class="table_style">
                <thead>
                        <tr>
                        <th class="airline">航班信息</th>
                        <th class="airtime">起降时间</th>
                        <th class="airport">起降机场</th>
                        <!--<th class="">经停机场</th>
                        --><th class="airprice">舱位</th>
                        <th class="airtax">机建+燃油</th>
                        <th class="airtotal">单张合计</th>
                    </tr>
                    </thead>
                <tbody>
                        <tr>
                        <td class="airline"><span class="airlogo airlogo_hu"><img src="${ctx}/web/images/32_32/icon_airport<%=outBookingFlight.getAirlineCompanyCode()%>.gif"></span> <strong><%=outBookingFlight.getAirlineCompany()%><br>
                            <%=outBookingFlight.getAirlineCompanyCode()%><%="null".equals(outBookingFlight.getFlightNo())?"":outBookingFlight.getFlightNo()%></strong></td>
                        <td class="airtime"><%=outBookingFlight.getDepartureTimeStr()%><br>
                                <%=outBookingFlight.getArrivalTimeStr()%></td>
                        <td class="airport">
                        		<ap:write key="<%=outBookingFlight.getDepartureAirportCode()%>" isDisplayLname="true" /><%= outBookingFlight.getDepartureTerminal() == null || "".equals(outBookingFlight.getDepartureTerminal()) || "null".equals(outBookingFlight.getDepartureTerminal())? "" : "[" + outBookingFlight.getDepartureTerminal() + "]"%><br>
                                <ap:write key="<%=outBookingFlight.getArrivalAirportCode()%>" isDisplayLname="true" /><%= outBookingFlight.getArrivalTerminal() == null || "".equals(outBookingFlight.getArrivalTerminal()) || "null".equals(outBookingFlight.getArrivalTerminal())? "" : "[" + outBookingFlight.getArrivalTerminal() + "]"%>
                        </td>
                        <!--<td>暂无数据<br>
                                </td>
                        --><td class="airprice"><%="null".equals(outBookingFlight.getCabinCode())?"":outBookingFlight.getCabinCode()%>舱<br /><!-- <span class="red bold"><%=outBookingFlight.getDiscount()%></span> 折 --></td>
                        <%
                        String goTicketPriceAll = "";
                        String goBafPrice = "";
                        String goConstructionPrice = "";
                        for(int i=0; i<flightPassengerList.size(); i++){
                        	if(flightPassengerList.get(i).getType().equals("01")&&flightPassengerList.get(i).getFlightType().equals("1")){
                        		goTicketPriceAll = new BigDecimal(flightPassengerList.get(i).getTicketPrice()).add(new BigDecimal(flightPassengerList.get(i).getBafPrice())).add(new BigDecimal(flightPassengerList.get(i).getConstructionPrice())).toString();
                        		goBafPrice = flightPassengerList.get(i).getBafPrice();
                        		goConstructionPrice = flightPassengerList.get(i).getConstructionPrice();
                        		break;
                        	}	
                        }
                        %>
                        <td class="airtax"><%=goConstructionPrice%><br /><%=goBafPrice%></td>
                        <td class="airtotal"><strong>¥<%=goTicketPriceAll%></strong><br>
                                <a class="orangea Tickets_TG" href="#">退改签规则</a><div class="Tickets_TGBox"><%=outBookingFlight.getCabinRule()%></div></td>
                    </tr>
                    <%
                    if(null!= inBookingFlight){
                    %>
                    <tr>
                        <td class="airline"><span class="airlogo airlogo_hu"><img src="${ctx}/web/images/32_32/icon_airport<%=inBookingFlight.getAirlineCompanyCode()%>.gif"></span> <strong><%=inBookingFlight.getAirlineCompany()%><br>
                            <%=inBookingFlight.getAirlineCompanyCode() %><%="null".equals(inBookingFlight.getFlightNo())?"":inBookingFlight.getFlightNo()%></strong></td>
                        <td class="airtime"><%=inBookingFlight.getDepartureTimeStr() %><br>
                                <%=inBookingFlight.getArrivalTimeStr() %></td>
                        <td class="airport">
                        		<ap:write key="<%=inBookingFlight.getDepartureAirportCode()%>" isDisplayLname="true" /><%= inBookingFlight.getDepartureTerminal() == null || "".equals(inBookingFlight.getDepartureTerminal()) || "null".equals(inBookingFlight.getDepartureTerminal())? "" : "[" + inBookingFlight.getDepartureTerminal() + "]"%><br>
                                <ap:write key="<%=inBookingFlight.getArrivalAirportCode()%>" isDisplayLname="true" /><%= inBookingFlight.getArrivalTerminal() == null || "".equals(inBookingFlight.getArrivalTerminal()) || "null".equals(inBookingFlight.getArrivalTerminal())? "" : "[" + inBookingFlight.getArrivalTerminal() + "]"%>
                        </td>
                        <!--<td>暂无数据<br>
                                </td>
                        --><td class="airprice"><%="null".equals(inBookingFlight.getCabinCode())?"":inBookingFlight.getCabinCode()%>舱<br /><!-- <span class="red bold"><%=inBookingFlight.getDiscount() %></span> 折 --></td>
                        <%
                        String reTicketPrice = "";
                        String reBafPrice = "";
                        String reConstructionPrice = "";
                        for(int j=0; j<flightPassengerList.size();j++){
                        	if(flightPassengerList.get(j).getType().equals("01")&&flightPassengerList.get(j).getFlightType().equals("2")){
                        		reTicketPrice = new BigDecimal(flightPassengerList.get(j).getTicketPrice()).add(new BigDecimal(flightPassengerList.get(j).getBafPrice())).add(new BigDecimal(flightPassengerList.get(j).getConstructionPrice())).toString();
                        		reBafPrice = flightPassengerList.get(j).getBafPrice();
                        		reConstructionPrice = flightPassengerList.get(j).getConstructionPrice();
                        		break;
                        	}
                        }
                        %>
                        <td class="airtax"><%=reConstructionPrice%><br /><%=reBafPrice%></td>
                        <td class="airtotal"><strong>¥<%=reTicketPrice%></strong><br>
                                <a class="orangea Tickets_TG" href="#">退改签规则</a><div class="Tickets_TGBox"><%=inBookingFlight.getCabinRule()%></div></td>
                    </tr>
                    <%} %>
                    </tbody>
            </table>
            </div>
        <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">乘机人信息 </b></span><span class="r"></span></div>
        <div id="PeopleInfoBox" class="inner PeopleInfo ConfirmOrder"> 
                <!--PeopleInfo-->
                
                <%
                int i = 1;
                String certType = "";
                for(MemberPassengerVo m:flightPassengerList){ 
                %>
			<dl>
                <dt><span class="left">乘机人<b class="PassengerNo"><%=i%></b> &nbsp;&nbsp;</span><span style="color: #FF0000"><f:write type="客票状态" value="<%=m.getTicketSts()%>" /></span></dt>
                <dd>
                        <ul class="clearfix_">
                        <li>乘客姓名：<b><%= m.getName()%></b></li>
                        <li><span class="left">证件类型：</span><b>
                        <f:write type="证件类型" value="<%=m.getCertType()%>"></f:write>
                       
                        </b> </li>
                        <li>证件号码：<b><%=m.getCertNo()%></b> </li>
                        <li><span class="left">购票类型：</span><b>
                        <f:write type="乘客类型" value="<%=m.getType()%>"></f:write>
                        </b></li>
                        <li><span class="left">票号：</span>
                        <%
                        String etNO = "尚未出票";
                        if(sts.equals("02")&&m.getEtNo()!=null&&!m.getEtNo().equals("null")){
                        	etNO = m.getEtNo();
                        }%>
                        <%=etNO%>
                        </li>
                        <%if(!"null".equals(m.getInsuranceNum())){ %>
                        <li><span class="left">航空保险：</span><b><%=m.getInsuranceNum()%>份 [￥20元/份]</b></li>
                        <%} %>
                        <!-- 
                        <li>常旅客卡：<b>无</b></li>
                        <li><span class="left">特殊餐食：</span><b>无</b></li>
                    	-->
                    </ul>
                    </dd>
            </dl>   
            <%i++;} %>
        </div>
        <%if(flightCancelVoList!=null||flightModifyVoList!=null){ %>
        <div class="title"><span class="l"></span><span class="c"><b class="left">退改签信息 </b></span><span class="r"></span></div>
        <div id="PeopleInfoBox" class="inner PeopleInfo ConfirmOrder"> 
                <!--PeopleInfo-->
<!--            退票单信息-->
            <%
            if(flightCancelVoList!=null){
                for(int j=0; j<flightCancelVoList.size(); j++){ 
                	FlightCancelVo c = flightCancelVoList.get(j);
            %>    
			<dl>
                <dt><span class="left">退票单<b class="PassengerNo"><%=j+1%></b> &nbsp;&nbsp;</span></dt>
                <dd>
                        <ul class="clearfix_">
                        <li>退票单号：<b><%=c.getApplyNo()%></b></li>
                        <li><span class="left">退票单状态：</span><b><f:write type="CLUB退票单状态" value="<%=c.getState()%>" /></b></li>
                        <li><span class="left">申请退款：</span><b><%=c.getApplyMoney()%></b></li>
                        <li>退票类型：<b><f:write type="退票类型" value="<%=c.getReturnType()%>" /></b></li>
                        <li><span class="left">退票原因：</span><b><%=c.getDisc()%></b></li>
                        <li><span class="left">退票申请日期：</span><b>
                        <fmt:formatDate value="<%=c.getApplyDate()%>" pattern="yyyy-MM-dd HH:mm"/>
                        </b></li>
                        <li>实际退款：<b><%=c.getReturnMoney()%></b> </li>
                        <li><span class="left">手续费：</span><b><%=c.getProcedureFee()%></b></li>
                        <li><span class="left">附加费用：</span><%=c.getAirOilInsurFee()%></li>
                        <li><span class="left">乘机人：</span><b>
                        <%
                        for(int cp=0; cp<c.getFlightPassenger().size(); cp++){ 
                        	MemberPassengerVo cmp = c.getFlightPassenger().get(cp);	
                        	if(cp==0){
                        %>
                            	<%=cmp.getName()%>
                        <%  }else{ %>
                            	,<%=cmp.getName()%>
                        <%  }
                        } 
                        %>
                        </b></li>
                        <!-- 
                        <li>常旅客卡：<b>无</b></li>
                        
                    	-->
                    </ul>
                    </dd>
            </dl>
            <%} }%>
<!--            退票单信息-->
<!--			改期单信息-->
            <%
            if(flightModifyVoList!=null){
            	 for(int j=0; j<flightModifyVoList.size(); j++){ 
            		 FlightModifyVo m = flightModifyVoList.get(j);
            %>
            <dl>
                <dt><span class="left">改期单<b class="PassengerNo"><%=j+1%></b> &nbsp;&nbsp;</span></dt>
                <dd>
                        <ul class="clearfix_">
                        <li>改期单号：<b><%=m.getApplyNo()%></b></li>
                        <li><span class="left">改期单状态：</span><b><f:write type="CLUB改期单状态" value="<%=m.getState()%>" /></b></li>
                        <li><span class="left">改期舱位：</span><b><%=m.getCabinCode()%></b></li>
                        <li>改期前机票价格：¥<b><%=m.getTicketPrice()%></b></li>
                        <li><span class="left">改期费：¥</span><b><%=m.getModifyfee().intValue()<0?"待定":m.getModifyfee()%></b></li>
                        <li><span class="left">改期申请日期：</span><b><%=DateUtils.format(m.getApplyDate(),"yyyy-MM-dd HH:mm:ss")%></b></li>
                        <li><span class="left">乘机人：</span><b>
                        <%
                        for(int mp=0; mp<m.getFlightPassenger().size(); mp++){ 
                        	MemberPassengerVo mmp = m.getFlightPassenger().get(mp);	
                        	if(mp==0){
                        %>
                            	<%=mmp.getName()%>
                        <%  }else{ %>
                            	,<%=mmp.getName()%>
                        <%  }
                        } 
                        %>
                        </b></li>
                        <!-- 
                        <li>常旅客卡：<b>无</b></li>
                        
                    	-->
                    </ul>
                    </dd>
            </dl>
            <%}} %>
<!--			改期单信息-->
        </div> 
        <%} %>   
        <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c">配送内容
               
                  <!--<%
                if(flightItineraryVo.getDeliveryType().equals("0")){
                %>
                  （无需配送）
                <%
                }%>--><% 
                if(flightItineraryVo.getDeliveryType().equals("1")){
                %>
                  （快递）
                <%
                }
                if(flightItineraryVo.getDeliveryType().equals("2")){
                %>
                  （挂号信）
                <%
                }
                %>
                </span>
                <span class="r"></span></div>
                <div class="inner clearfix_">
                	<%
                	if(flightItineraryVo.getDeliveryType().equals("0")){
                	%>
                	<ul class="clearfix_ x3">
                	<li>配送方式：<b>无需配送(低碳出行)</b></li>
                	</ul>
                	<%}%>
                    <%
                    if(!flightItineraryVo.getDeliveryType().equals("0")){
                    %>
                    <ul class="clearfix_ x3">
                        <li>收件人：<b><%=flightItineraryVo.getCatchUser() %></b></li>
                        <li>联系电话：<b><%=flightItineraryVo.getMobile() %></b></li>
                        <%if(flightItineraryVo.getPostCode()!=null){ %>
                        <li>邮政编码：<b><%=flightItineraryVo.getPostCode()%></b></li>
                    	<%} %>
                    </ul>
                    <ul>
                        <li>配送地址：<b><p:write key="<%=flightItineraryVo.getCity()%>"></p:write>&nbsp;&nbsp;<%=flightItineraryVo.getAddress() %></b></li>
                    </ul>
                    <%} %>
                    <div class="separated_line"></div>
                    <ul class="paddingT10B10">
                        <li><span class="orange">温馨提示：</span><b>${domain_cn }平台机票100%电子客票，凭身份证去机场登机。行程单仅作为报销凭证，不是登机的必要凭证。</b></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end-->
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c">联系人信息</span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3">
                        <li>姓名：<b><%=flightContactVo.getName() %></b></li>
                        <li>联系方式：<b><%=flightContactVo.getMobile() %></b></li>
                        <li>邮箱地址：<b><%=flightContactVo.getEmail() %></b></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
            <div class="title"  align="center"><span class="l"></span><span class="c"><span id="ss"><a href="javascript:void(new Date())" onclick="opendiv()" class="myA">订单状态跟踪▼</a></span><span class="Order_Status">支付状态：<b class="red">
              <%
                if(paySts.equals("0")){
                %>
                  未支付
                <%
                }
                if(paySts.equals("1")){
                %>
                  支付成功
                <%
                }
                if(paySts.equals("2")){
                %>
                  支付失败
                <%
                }
                %>
            </b></span></span><span class="r"></span></div>
             
            <div class="inner clearfix_" id="orderStsdiv" style="display: none">
                <table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 innerOrder">
                    <tbody>
                        <tr>
                            <th width="150">时间</th>
                            <th>跟踪记录显示</th>
                        </tr>
                        <%	if(orderFlightLogs.size()!=0){
                        	for(OrderFlightLogVo logs : orderFlightLogs){ %>
                        <tr>
                            <td ><%=logs.getCreateTime() %></td>
                            <td align="center"><%=logs.getContent() %></td>
                        </tr>
                        <%} }%>
                    </tbody>
                </table>
            </div>
            
            <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
           
                <div class="lineclear Accountheight"></div>
            </div>
            <div class="clear"></div>
            <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
            <div class="greytext" id="pager">
            <%
              if("00".equals(sts)){
            %>
            <a id="btn_pay" href="javascript:void(0);form2()" class="flight_button2 button2">支 付</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="btn_cancel_order" style="cursor:pointer" href="javascript:void(0);form1()" class="flight_button2 button2">取消订单</a>
            <%}else if("02".equals(sts)){ 
            	 for(MemberPassengerVo m:flightPassengerList){ 
					if("01".equals(m.getTicketSts())){
			%>
			<a id="btn_cancel" href="javascript:void(0);form3()" class="flight_button2 button2">申请退票</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="btn_modify" href="javascript:void(0);form4()" class="flight_button2 button2">申请改期</a>
			<%
				break;
					}        		 
            	 }
            %>
            <%}else if("05".equals(sts)){ %>
            <a id="btn_cancel_apply" style="cursor:pointer" href="javascript:void(0);form0()" class="flight_button2 button2">取消申请</a>
            <%} %>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/member/index.jsp" class="flight_button2 button2">返 回</a></div>
            <div class="clear"></div>
        </div>
    </div>
    <!-----------------------------------------RIGHT END------------------------------------>
    <div class="clear"></div>
<script type="text/javascript">
//获取DOM对象的绝对位置
function form0(){
	if(confirm("确定取消申请？")){
		$("#btn_cancel_apply").attr("href","javascript:void(0)");
		$("#btn_cancel_apply").removeClass().addClass("button2Disalbed");
		window.location.href="${ctx}/flight/cancelFlight/cancelOrderResult.jsp?orderId=<%=orderId %>&orderCode=<%=code %>";
	}
}
function form1(){
	if(confirm("确定取消订单？")){
		$("#btn_cancel_order").attr("href","javascript:void(0)");
		$("#btn_cancel_order").removeClass().addClass("button2Disalbed");
		$("#btn_pay").removeClass().addClass("button2Disalbed");
		window.location.href="${ctx}/flight/cancelFlight/cancelOrderResult.jsp?orderId=<%=orderId %>&orderCode=<%=code %>";
	}
}
function form2(){
	if(confirm("确认支付订单？")){
		$("#btn_pay").attr("href","javascript:void(0)");
		$("#btn_pay").removeClass().addClass("button2Disalbed");
		$("#btn_cancel_order").removeClass().addClass("button2Disalbed");
		window.location.href="${ctx}/flight/pay/payFlight.jsp?orderId=<%=orderId%>";
	}
}
function form3(){
	if(confirm("确认申请退票？")){
		$("#btn_cancel").attr("href","javascript:void(0)");
		$("#btn_cancel").removeClass().addClass("button2Disalbed");
		$("#btn_modify").removeClass().addClass("button2Disalbed");
		window.location.href="${ctx}/flight/cancelFlight/cancelFlight.jsp?orderId=<%=orderId%>&orderCode=<%=code%>";
	}
}
function form4(){
	if(confirm("确认申请改期？")){
		$("#btn_modify").attr("href","javascript:void(0)");
		$("#btn_modify").removeClass().addClass("button2Disalbed");
		$("#btn_cancel").removeClass().addClass("button2Disalbed");
		window.location.href="${ctx}/flight/modifyFlight/ticketModifySecond.jsp?orderId=<%=orderId%>&orderCode=<%=code%>";
	}
}
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

//打开订单状态div
function opendiv(){
	var mydiv = document.getElementById("orderStsdiv");
	if(mydiv.style.display=="none"){
		$("#ss").html('<a href="javascript:void(new Date())" onclick="opendiv()" class="myA">订单状态跟踪▲</a>');
		$("#orderStsdiv").show();
	}else{
		$("#ss").html('<a href="javascript:void(new Date())" onclick="opendiv()" class="myA">订单状态跟踪▼</a>');
		$("#orderStsdiv").hide();
	}
}
</script>
</body>
</html>
