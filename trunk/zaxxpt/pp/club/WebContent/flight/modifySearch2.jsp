<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="java.util.Date"%>
<%@page import="com.hnatourism.club.common.util.DateUtils"%>
<%@page import="com.hnatourism.framework.utils.DateFormatUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.framework.utils.ListUtils"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightQryVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightInfoVo"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightCabinInfoVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/web/js/avflights.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/web/js/jquery1.3.2.js" language="javascript" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->
    <title>${domain_cn }</title>
    </head>
    <body>
<%@include file="modifyControl.jsp" %>
<div class="senav">
	<ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj">
        	<a href="${ctx}/flight/index.jsp" class="se">首页</a>&gt;
        	<a href="${ctx}/member/index.jsp" class="se">订单详情 &gt; </a>
        	<ap:write key="<%=departureAirportCode%>" isDisplayCity="true"/> - <ap:write key="<%=departureAirportCode%>" isDisplayCity="true"/> 航班信息
        </li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
</div>

<div class="clear"></div>
<div id="btop" class="wfpj wfpj2 Wmargin">
	<div class="jp_hb_left w1">
		<span class="left">
			<ap:write key="<%=departureAirportCode%>" isDisplayCity="true"/> - <ap:write key="<%=arrivalAirportCode%>" isDisplayCity="true"/>
		</span>
		<span class="left orange">出发时间：</span>
		<div class=inb>
			<input id="plainDate1" class="inps" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})"  name="searchDepartureTime" value="<%=date%>"/>
 			<a class="set_date" href="javascript:WdatePicker({el:'plainDate1',minDate:'%y-%M-%d'});"></a>
		</div>
		<span class="left">
			<a class="business_btn" onclick="formsubmit()" style="cursor:pointer">查询改期航班</a>
		</span>
	</div>
	<div class="jp_hb_right w2">
		<%if(date!=null){ %>出发日期：<%=date%>（共<span class="red"><%=flightList.size()%></span>个航班信息）<%} %>
	</div>
</div>
<div></br></div>
<!--Filter -->
<ul class="FilterSelectBox clearfix_">
    <li> <span class="left">航空公司：<al:write key="<%=airlineCompanyCode%>" /></span><% if(flightList.size()!=0) {%><a class="Btn63_24 Btn63_24_gq" onclick="form1()" style="cursor:pointer">提交申请</a><%} %></li>
</ul>
<!--Filter end--> 
<!--list-->
<!--list-->
<div class="main980">
	<div class="module_a Order">
	  	   <%
	         if(flightIsNullFlag){
	       %>
	        <div class="inner  go_mod_ticket list marginT_1" " id="FlightOut">
	        	<table id="flightListTable">
	              <tr  class='Tickets'><td colspan='9'>
	                <b>非常抱歉，没有符合您查询条件的航班，或此出发日期的舱位已售完。   建议您选择其他出发日期进行查询。</b><br/><br/> 如有疑问请致电 ${site_tel}。</td></tr>
	            </table>
	        </div>
	       <%}else {%>
	        <div class="title" id="AllDataTitle">
	        	<span class="l"></span>
	        	<div class="c go_mod_ticket">
	            <table>
	                <thead>
	                    <tr>
	                        <th class="airline">航空公司/航班</th>
	                        <!-- 4种状态 air_up air_down air_current_up air_current_down -->
	                        <th class="airtime">起降时间</th>
<!--	                        <th class="airtime"><a id="depTimeSorter"  href="javascript:void(0);" class="air_up">起降时间<b></b></a></th>-->
	                        <th class="airport">起降机场</th>
	                        <th class="airplane">机建/燃油</th>
	                        <th class="airprice">舱位</th>
	                        <th class="airminprice">票面价</th>
	                        <th class="airdis">优惠幅度</th>
	                        <th class="airorder">会员价</th>
<!--	                        <th class="airorder"><a id="payPriceSorter" href="javascript:void(0);" class="air_up2">会员价<b></b></a></th>-->
	                        <th class="airdis">修改</th>
	                    </tr>
	                </thead>
	           	 </table>
	            </div>
	            <span class="r"></span>
	         </div>
        <%--					迭代所有的航班信息--%>
			<%for(int i=0;i<flightList.size();i++){
				FlightInfoVo flightInfoVo=(FlightInfoVo)flightList.get(i);
			%>
        	<div class="inner  go_mod_ticket list marginT_1" id="allDataDiv">
        		<table>
        			<thead class="c go_mod_ticket">
<%--        				虚拟存在的表头,用于保持页面对齐 --%>
						<tr class="theadHide">
							<th class="airline" ></th>
							<th class="airtime" ></th>
							<th class="airport" ></th>
							<th class="airplane" ></th>
							<th class="airprice" ></th>
							<th class="airminprice" ></th>
							<th class="airdis"></th>
							<th class="airorder"></th>
							<th class="airdis"></th>
						</tr>
	                </thead>
	            	<tbody>
						<tr class="Tickets">
							<td class="airline">
								<span class="airlogo airlogo_hu">
                					<img src="${ctx}/web/images/32_32/icon_airport<%=flightInfoVo.getAirlineCompanyCode()%>.gif">
                				</span>
		                		<%=flightInfoVo.getAirlineCompany()%><br />
		                    	<%=flightInfoVo.getAirlineCompanyCode()%><%=flightInfoVo.getFlightNo()%>
							</td>
							<td class="airtime">
								<strong><%=flightInfoVo.getDepartureTime()%></strong><br />
								<strong><%=flightInfoVo.getArrivalTime()%></strong>					
							</td>
							<td class="airport">
								<ap:write key="<%=flightInfoVo.getDepartureAirport()%>" /><%= flightInfoVo.getDepartureTerminal() == null || "".equals(flightInfoVo.getDepartureTerminal())? "" : "[" + flightInfoVo.getDepartureTerminal() + "]"%><br />
	                        	<ap:write key="<%=flightInfoVo.getArrivalAirport()%>"  /><%= flightInfoVo.getArrivalTerminal() == null || "".equals(flightInfoVo.getArrivalTerminal())? "" : "[" + flightInfoVo.getArrivalTerminal() + "]"%>							
							</td>
							<td class="airplane">
								<%=flightInfoVo.getConstructionFee()%>/<%=flightInfoVo.getAdultBaf()%>
							</td>
							<td class="airprice">
								<%FlightCabinInfoVo cabinInfoVo=flightInfoVo.getFlightCabinInfoVo(); 
								String cabinDiscount="";
								if(!"null".equals(cabinInfoVo.getCabinDiscount())&&null!=cabinInfoVo.getCabinDiscount()&&!"".equals(cabinInfoVo.getCabinDiscount())){
								cabinDiscount = new BigDecimal(cabinInfoVo.getCabinDiscount()).multiply(new BigDecimal(10)).toBigInteger().toString();
								}
								List<FlightCabinInfoVo> cabinInfoVoList=flightInfoVo.getFlightCabinInfoVoList();
								//计算分润
								calculateSubRun(cabinInfoVo);
								%>
								<%=cabinInfoVo.getCabinName()%>
								(<span><%=cabinDiscount%>%/</span><%=cabinInfoVo.getCabinCode()%>)<br /> 
								座位数 <%="A".equals(cabinInfoVo.getCabinSeatNum())?"&gt;9":cabinInfoVo.getCabinSeatNum()%>
								<br>
								<a href="#" class="orangea Tickets_TG">退改签</a>
								<div class="Tickets_TGBox"><%=cabinInfoVo.getChangeInfo()%></div>
							</td>
							<td class="airminprice">
								<strong><span class="yen">¥</span><%=cabinInfoVo.getAdultTicketPricePar()%></strong><br />	
								<% if(!ListUtils.isEmpty(cabinInfoVoList)){ %>  
									<a class="jp_qbjg more_btn" href="#">全部价格</a>
								<%} %>						
							</td>
							<td class="airdis" title="<%=cabinInfoVo.getCommissionRate()%>">
								<%=cabinInfoVo.getCommissionRate()%>%
							</td>
							<td class="airorder" id="commonDataTd<%=i%>">
								<strong>
									<span class="yen red">¥</span>
									<strong  class="red"><%=cabinInfoVo.getAdultTicketPrice()%></strong>
								</strong><br />
								<input type="hidden" name="adultTicketPrice" value="<%=cabinInfoVo.getAdultTicketPrice()%>"/>
								<input type="hidden" name="adultBaf" value="<%=cabinInfoVo.getAdultBaf()%>"/>
								<input type="hidden" name="adultConstructionFee" value="<%=cabinInfoVo.getAdultConstructionFee()%>"/>
								<input type="hidden" name="childTicketPrice" value="<%=cabinInfoVo.getChildTicketPrice()%>"/>
								<input type="hidden" name="childBaf" value="<%=cabinInfoVo.getChildBaf()%>"/>
								<input type="hidden" name="childConstructionFee" value="<%=cabinInfoVo.getChildConstructionFee()%>"/>
								
								<input type="hidden" name="aircraftType" value="<%=flightInfoVo.getAircraftType()%>"/>
								<input type="hidden" name="departureAirportCode" value="<%=flightInfoVo.getDepartureAirportCode()%>"/>
								<input type="hidden" name="arrivalAirportCode" value="<%=flightInfoVo.getArrivalAirportCode()%>"/>
								<input type="hidden" name="arrivalTimeStr" value="<%=flightInfoVo.getArrivalTime()%>"/>
								<input type="hidden" name="departureTimeStr" value="<%=flightInfoVo.getDepartureTime()%>"/>
								<input type="hidden" name="discount" value="<%=cabinInfoVo.getDiscount()%>" />
								<input type="hidden" name="flightNo" value="<%=flightInfoVo.getFlightNo()%>"/>
								<input type="hidden" name="policyCode" value="<%=cabinInfoVo.getPolicyCode()%>"/>
								<input type="hidden" name="commissionRate" value="<%=cabinInfoVo.getCommissionRate()%>"/>
							</td>
							<td class="airdis">
								<input type="radio" name="modifyNO" value="commonDataTd<%=i%>"/>
							</td>
						</tr>

						</tbody>
	          			</table>
					</div>
					<%}%>
	       <%} %>
	</div>  
</div> 
<form action="${ctx}/flight/modifyFlight/ticketModifyResult.jsp" id="form1" method="post">
	<input type="hidden" name="orderId" value="<%=orderId%>"/>
	<input type="hidden" name="date"; value="<%=date%>"/>
	<input type="hidden" name="adultTicketPrice" id="adultTicketPrice"/>
	<input type="hidden" name="adultBaf" id="adultBaf"/>
	<input type="hidden" name="adultConstructionFee" id="adultConstructionFee"/>
	<input type="hidden" name="childTicketPrice" id="childTicketPrice"/>
	<input type="hidden" name="childBaf" id="childBaf"/>
	<input type="hidden" name="childConstructionFee" id="childConstructionFee"/>
	
	<input type="hidden" name="aircraftType" id="aircraftType"/>	
	<input type="hidden" name="departureAirportCode" id="departureAirportCode"/>
	<input type="hidden" name="arrivalAirportCode" id="arrivalAirportCode"/>
	
	<input type="hidden" name="arrivalTimeStr" id="arrivalTimeStr"/>
	<input type="hidden" name="departureTimeStr" id="departureTimeStr"/>
	
	<input type="hidden" name="discount" id="discount" />
	<input type="hidden" name="flightNo" id="flightNo"/>
	<input type="hidden" name="policyCode" id="policyCode"/>
	<input type="hidden" name="commissionRate" id="commissionRate"/>
	
	<input type="hidden" name="passenger" value="<%=passenger%>"> 
</form>
<div class=" Wmargin tijiao_frm">
	<a id="gotoTop" href="#"><img width="51" height="32" src="${ctx}/web/images/bottomtop.jpg"></a>
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

function formsubmit(){
	var date = document.getElementById("plainDate1");
	var reg=/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
	if(!date.value.match(reg)){
		alert("日期格式不对,正确格式为1970-01-01");
	}else{
		var url="${ctx}/flight/modifySearch2.jsp?date="+date.value+"&orderId="+'${orderId}'+"&passenger="+'${passenger}';
		window.location.href = url;
	}
}
function form1(){
	var result = window.confirm("确定参照所选航班进行改期？？");
	if(result==true){
		$("input[name='modifyNO']").each(function(i){
			if($(this).attr("checked") == true){
				var mod = $(this).parent().prev();
				$("#adultTicketPrice").attr("value",mod.find("input[name='adultTicketPrice']").val());
				$("#adultBaf").attr("value",mod.find("input[name='adultBaf']").val());
				$("#adultConstructionFee").attr("value",mod.find("input[name='adultConstructionFee']").val());
				$("#childTicketPrice").attr("value",mod.find("input[name='childTicketPrice']").val());
				$("#childBaf").attr("value",mod.find("input[name='childBaf']").val());
				$("#childConstructionFee").attr("value",mod.find("input[name='childConstructionFee']").val());
				$("#aircraftType").attr("value",mod.find("input[name='aircraftType']").val());
				$("#departureAirportCode").attr("value",mod.find("input[name='departureAirportCode']").val());
				$("#arrivalAirportCode").attr("value",mod.find("input[name='arrivalAirportCode']").val());
				$("#arrivalTimeStr").attr("value",mod.find("input[name='arrivalTimeStr']").val());
				$("#departureTimeStr").attr("value",mod.find("input[name='departureTimeStr']").val());
				$("#discount").attr("value",mod.find("input[name='discount']").val());
				$("#flightNo").attr("value",mod.find("input[name='flightNo']").val());
				$("#policyCode").attr("value",mod.find("input[name='policyCode']").val());
				$("#commissionRate").attr("value",mod.find("input[name='commissionRate']").val());
			}
		})
//		alert($("#form1").html());
		$("#form1").submit();
		return true;
	}else{
		return false;
	}
}

$(function(){
	// 搜索结果列表 - 查看全部价格
	$(".more_Tickets").hide();
	var radio = $(":radio");
	if(radio.length!=0){
	radio[0].checked = true;
	}
	$(".more_btn").click(function(){
		$(".more_Tickets").hide().prev(".Tickets");
		$(this).parents(".Tickets").next(".more_Tickets").show();
		return false;
	});
	$(".icon_close").click(function(){
		$(this).parents(".more_Tickets").hide().prev(".Tickets");
		return false;
	});
	// 机票搜索结果条件过滤箭头
	$(".air_up").toggle(function(){
		$(this).children("b").css("background-position","0 -4px");},
		function(){
			$(this).children("b").css("background-position","0 0");
	});

	// 单程&往返radio
	$("#danCheng").attr('checked', true); 
	$("#wangFan").attr('checked', false); 
	$(".ReturnTime").children().hide();
	$("#wangFan,#danCheng").click(function(){
		$("#wangFan").is(":checked") ? $(".ReturnTime").children().show() : $(".ReturnTime").children().hide();
	});
	
    
	
	// togoTop
	$("#gotoTop").click(function(){
		//$(window.parent.document.body).parent("html").animate({scrollTop: '0px'}, 200);   // If in iframe, use this.
		$("html").animate({scrollTop: '0px'}, 200); 
		return false;
	});
	
    // IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
	if(!-[1,]&&!window.XMLHttpRequest){
		$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	}
});
</script>
</body>
</html>

