<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/web/js/clubJs/jquery1.3.2.js" language="javascript" type="text/javascript"></script>
<title>改期申请 - ${domain_cn }</title>
<style type="text/css">
#win { position:fixed; _position:absolute; -webkit-box-shadow:5px 2px 6px #333; -moz-box-shadow:5px 2px 6px #333; -moz-border-radius: 7px; border-radius: 7px; }
.myA { color:black; }
</style>
</head>
<body>

<div class="main"> 
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<%@include file="/flight/order/ticketModifyPrepareControl.jsp" %>
    <!----------------------------------------- RIGHT ------------------------------------>
    <div class="floatleft width783">
        <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
        <div class="listTAB rightbg"> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">订单详情</b><b class="right">总计金额：<b class="red"><%=totalMoney%>元</b> 共<%=flightPassengerList==null?"0":flightPassengerList.size()%>人 （保险：<%=totalInsurance%>元）</b></span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3 ">
                        <li><span>订单号：<%=code %></span></li>
                        <li>订单状态：<b>出票成功
                        </b></li>
                        <li>订单成生时间：<b><%=createTime%></b></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left"><%if(flightType.equals("2")){ %>航班信息（去程）<%} %><%if(flightType.equals("1")){ %>航班信息（单程）<%} %></b><b class="right">出发日期：<%=outBookingFlight.getDepartureDateStr()%></b></span><span class="r"></span></div>
                <div class="inner air_Selected air_Selected_r clearfix_">
                    <table class="table_style">
                        <thead>
                            <tr>
                                <th class="airline">航班信息</th>
                                <th class="">航段</th>
                                <th class="airtime">起飞</th>
                                <th class="airport">抵达</th>
                                <th class="">经停机场</th>
                                <th class="">舱位</th>
                                <th class="airtax">机建+燃油</th>
                                <th class="airtotal">退改规则</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="airline">
                                	<span class="airlogo airlogo_hu">
                                		<img src="${ctx}/web/images/32_32/icon_airport<%=outBookingFlight.getAirlineCompanyCode()%>.gif">
                                	</span> 
                                	<strong>
                                		<%=outBookingFlight.getAirlineCompany()%><br>
                                    	<%=outBookingFlight.getAirlineCompanyCode()%>
                                    	<%=outBookingFlight.getFlightNo()%>
                                    </strong>
                                </td>
                                <td class="Range">
                                	<ap:write key="<%=outBookingFlight.getDepartureAirportCode()%>" isDisplayCity="true"/>-
                                	<ap:write key="<%=outBookingFlight.getArrivalAirportCode()%>" isDisplayCity="true"/>
                                </td>
                                <td class="airtime">
                                	<%=outBookingFlight.getDepartureTimeStr()%><br>
                                	<%=outBookingFlight.getDepartureAirport()%>机场
                                </td>
                                <td class="airport">
                                	<%=outBookingFlight.getArrivalTimeStr()%><br>
                                	<%=outBookingFlight.getArrivalAirport()%>机场
                                </td>
                                <td>无</td>
                                <td class="cabinSeat">
                                	<%=outBookingFlight.getCabinCode()%>
                                </td>
                                <td class="airtax">
                                	<%=constructionPrice%>/
                                    <%=bafPrice%>
                                </td>
                                <td class="airtotal">
                                	<a class="orangea Tickets_TG" href="#">退改签规则</a>
                                	<div class="Tickets_TGBox"><%=outBookingFlight.getCabinRule()%></div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <b class="bl"></b> 
                <b class="br"></b> 
            </div>
            <!--Module end-->
            <!--Module-->
            <%if(flightType.equals("2")){ %>
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">航班信息（返程） </b><b class="right">返程日期：<%=inBookingFlight.getDepartureDateStr()%></b></span><span class="r"></span></div>
                <div class="inner air_Selected air_Selected_r clearfix_">
                    <table class="table_style">
                        <thead>
                            <tr>
                                <th class="airline">航班信息</th>
                                <th class="">航段</th>
                                <th class="airtime">起飞</th>
                                <th class="airport">抵达</th>
                                <th class="">经停机场</th>
                                <th class="">舱位</th>
                                <th class="airtax">机建+燃油</th>
                                <th class="airtotal">退改规则</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="airline">
                                	<span class="airlogo airlogo_hu">
                                		<img src="${ctx}/web/images/32_32/icon_airport<%=inBookingFlight.getAirlineCompanyCode()%>.gif">
                                	</span> 
                                	<strong>
                                		<%=inBookingFlight.getAirlineCompany()%><br>
                                    	<%=inBookingFlight.getAirlineCompanyCode()%>
                                    	<%=inBookingFlight.getFlightNo()%>
                                    </strong>
                                </td>
                                <td class="Range">
                                	<%=inBookingFlight.getDepartureAirportCode() %>-
                                	<%=inBookingFlight.getArrivalAirportCode() %>
                                </td>
                                <td class="airtime">
                                	<%=inBookingFlight.getDepartureTimeStr()%><br>
                                	<%=inBookingFlight.getDepartureAirport()%>
                                </td>
                                <td class="airport">
                                	<%=inBookingFlight.getArrivalTimeStr()%><br>
                                	<%=inBookingFlight.getArrivalAirport()%>
                                </td>
                                <td>无</td>
                                <td class="cabinSeat">
                                	<%=inBookingFlight.getCabinCode()%>
                                </td>
                                <td class="airtax">
                                	<%=inBookingFlight.getTotalConstructionFee()%>/
                                    <%=inBookingFlight.getTotalBaf()%>
                                </td>
                                <td class="airtotal">
                                	<a class="orangea Tickets_TG" href="#">退改签规则</a>
                                	<div class="Tickets_TGBox"><%=inBookingFlight.getCabinRule()%></div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <b class="bl"></b> 
                <b class="br"></b> 
           	</div>
                <%} %>
            <!--Module end--> 
            <!--Module-->
           	<form action="${ctx}/flight/modifySearch2.jsp" id="form1" method="post">
            <%
            for(int j=0;j<flightPassengerList.size();j++){
            	MemberPassengerVo memberPassengerVo=flightPassengerList.get(j);
            	if(null != memberPassengerVo){
            			
            %>
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">乘机人<%=j+1%> </b></span><span class="r"></span></div>
                <div id="PeopleInfoBox" class="inner Peop
                leInfo ConfirmOrder">
                    <table width="758" cellspacing="1" cellpadding="0" border="0" class="table_style2">
                        <tbody>
                            <tr>
                                <th scope="col">旅客姓名</th>
                                <th scope="col">客票状态</th>
                                <th scope="col">旅客类型</th>
                                <th scope="col">航班号</th> 
                                <th scope="col">舱位编码</th>
                                <th scope="col">常旅客卡号</th>
                                <th width="100" scope="col">票 号</th>
                                <th width="100" scope="col">航段</th>
                                <th width="60" scope="col">选择航段</th>
                            </tr>
                            <tr>
                                <td>
                                	<%=memberPassengerVo.getName()%>
                                </td>
                                <td>
                                	<f:write type="客票状态" value="<%=memberPassengerVo.getTicketSts()%>" />
                                </td>
                                <td>
                                	<f:write type="乘客类型" value="<%=memberPassengerVo.getType()%>" />
                                </td>
                                <td>
                                	<%=memberPassengerVo.getAirlineCompanyCode()%><%=memberPassengerVo.getFlightNo()%>
                                </td>
                                <td>
                                	<%=memberPassengerVo.getCabinCode()%>
                                </td>
                                <td>无</td>
                                <td colspan="3">
                                    <%
                                    	String ftype="2";
                                    	if(memberPassengerVo.getDepartureAirportCode().equals(outBookingFlight.getDepartureAirportCode())){
                                    		ftype="1";
                                    	}
                                    %>
                                    <table width="260" cellspacing="1" cellpadding="0" border="0" class="table_style2">
                                        <tbody>
                                            <tr>
                                                <td width="100" rowspan="2"><%=memberPassengerVo.getEtNo()%></td>
                                                <td>
                                                    <table width="160" cellspacing="1" cellpadding="0" border="0" class="table_style2">
                                                        <tbody>
                                                            <tr>
                                                                <td width="100"><ap:write key="<%=memberPassengerVo.getDepartureAirportCode()%>" isDisplayCity="true" />-<ap:write key="<%=memberPassengerVo.getArrivalAirportCode()%>" isDisplayCity="true" /><br />
                                                                   </td>
                                                                <td width="40"><input type="radio" value="<%=memberPassengerVo.getAirlineCompanyCode()%>_<%=memberPassengerVo.getEtNo()%>_<%=memberPassengerVo.getCabinCode()%>_<%=memberPassengerVo.getDepartureAirportCode()%>_<%=memberPassengerVo.getArrivalAirportCode()%>_<%=memberPassengerVo.getId()%>_<%=memberPassengerVo.getType()%>" name="passenger" <%if(!"01".equals(memberPassengerVo.getTicketSts())){ %> disabled="disabled" <%} %>></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                 </td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <!----></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
                <% 	
            	}
                %>
                <input type="hidden" value="<%=orderId%>" name="orderId">
            </form>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c">配送内容
               
                  <!--<%
                if(flightItineraryVo.getDeliveryType().equals("0")){
                %>
                  （无需配送）
                <%
                }
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
                --></span>
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
                        <li>邮政编码：<b><%=flightItineraryVo.getPostCode()==null?"":flightItineraryVo.getPostCode()%></b></li>
                    </ul>
                    <ul>
                        <li>配送地址：<b><%=flightItineraryVo.getAddress() %></b></li>
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
                <div class="title" ><span class="l"></span><span class="c">联系人信息</span><span class="r"></span></div>
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
                <div class="title" ><span class="l"></span><span class="c"><span id="ss"><a href="javascript:void(new Date())" onclick="opendiv()" class="myA">订单状态跟踪▼</a></span><span class="Order_Status">订单状态：<b class="red"><%
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
                %></b></span></span><span class="r"></span></div>
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
                            <td><%=logs.getCreateTime() %></td>
                            <td align="center"><%=logs.getContent() %></td>
                        </tr>
                        <%} }%>
                    </tbody>
                </table>
            </div><b class="bl"></b> <b class="br"></b> </div>
            <!--Module end-->
            
            <div class="lineclear Accountheight"></div>
        </div>
        <div class="clear"></div>
        <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
        <div class="greytext" id="pager"><a id="submitModify" class="button2 " onclick="formsubmit();" style="cursor:pointer">提交申请</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);" class="button2">返 回</a></div>
        <div class="clear"></div>
    </div>
</div>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
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
function checkbox_once(obj){
        if(obj.checked==true){
        	if(obj.className=="2"){
        		var inputs = $(":checkbox[class='1']");
        			for(var i = 0; i < inputs.length; i++){
        					if(inputs[i].checked==true){  
            					inputs[i].checked = false; 
            					alert("暂时只支持一次退一种（去程/返程）类型航段的票，如需要请跳转后再行退其他机票");
            				}
         			}
        	}
        	if(obj.className=="1"){
        		var outputs = $(":checkbox[class='2']");
        			for(var j = 0; j < outputs.length; j++){   
            				if(outputs[j].checked==true){
            					outputs[j].checked = false;
            					alert("暂时只支持一次退一种（去程/返程）类型航段的票，如需要请跳转后再行退其他机票");
            				}
         			}
        	}
        
        }
}
function formsubmit(){

	var flag;
	var checks = document.getElementsByName("passenger");
	for(var i=0;i<checks.length;i++){
		if(checks[i].checked){
			flag = true;
			document.getElementById("form1").submit();
			return true;
			break;
	}
	}
	if(!flag){
		alert("请至少选择一项");
		return false;
	}
}
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
