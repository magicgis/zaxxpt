<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 显示底部的广告 value: 四位的广告位代码--%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightDynamicRequestMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightDynamicResponseMessage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightDynamicVo"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
     <link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/web/js/clubJs/11.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/web/js/clubJs/travel.js" language="javascript" type="text/javascript"></script>
    
    <script type=text/javascript>
        var citySelect = new CitySelectWindow('cityselected');
        function setSearch(n) { var menu = document.getElementById("sea_nav").getElementsByTagName("li"); var showdiv = document.getElementById("sea_box").getElementsByTagName("li"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
        function setList(m, n) { var menu = document.getElementById("tab" + m).getElementsByTagName("li"); var showdiv = document.getElementById("tablist" + m).getElementsByTagName("div"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
   </script>
   <script type="text/javascript" src="${ctx}/web/js/city/allAirport.js"></script>
    <title>航班动态 - ${domain_cn }</title>
    </head>
    <body>
<div class="clear"></div>
<div class="senav">
        <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="#" class="se">首页</a> > <a href="#" class="se">航班动态</a></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
    </div>
    <%
    
    String dpt =request.getParameter("dpt");
    String arr =request.getParameter("arr");
    String fno =request.getParameter("fno");
    request.setAttribute("dpt",dpt);
    request.setAttribute("arr",arr);
    request.setAttribute("fno",fno);
    
  if(StringUtils.isEmpty(fno) ){
    	fno="";
    }
    %>
<div class="clear"></div>
<div class="search">
        <div class="search_left">
        <ul class="hbss colorf0">
                <li class="w1">出发城市：</li>
                <li class="w2">
                <DIV class="inb">
                   <!--     <INPUT id="txtplain1" class="inps" onfocus="this.select();" onkeyup="PlainCheck();" value="北京" type="text" name=s"earchDepartureAirport">
                        <A class="set_city" href="javascript:citySelect.GetContentData('txtplain1');"></A> </DIV>
                         -->
		     <input name="deAirport" type="hidden" id="departureAirportId" value="<%=dpt%>" />             
            <input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="departureAirport" name="departureAirport" onblur="blurEvt(this)"
            <% if(StringUtils.isBlank(dpt)){%>value="中文/拼音" style="color:#C1C1C1"<%} %>
            onclick="suggest_Flight.display(this,'departureAirportId',event)"
            onkeyup="suggest_Flight.display(this,'departureAirportId',event)"
            value="<ap:write key="<%=dpt %>" isDisplayCity="true"></ap:write>" />
       <!--      <img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('departureAirport','departureAirportId',this,1,'city','airport')" />
          
             -->   
              </li>
                <li class="w1">到达城市：</li>
                <li class="w2">
                <DIV class="inb">
                     <!--  <INPUT id="txtplain2" class="inps" onfocus="this.select();" onkeyup="PlainCheck();" value="上海" type="text" name=s"earchDepartureAirport">
                        <A class="set_city" href="javascript:citySelect.GetContentData('txtplain2');"></A> </DIV>
			                        -->
			 <input name="arAirport" type="hidden" id="arrivalAirportId" value="<%=arr %>" />             
            <input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="arrivalAirport" name="arrivalAirport" onblur="blurEvt(this)"
            <% if(StringUtils.isBlank(arr)){%>value="中文/拼音" style="color:#C1C1C1"<%} %>
            onclick="suggest_Flight.display(this,'arrivalAirportId',event)"
            onkeyup="suggest_Flight.display(this,'arrivalAirportId',event)"
            value="<ap:write key="<%=arr %>" isDisplayCity="true"></ap:write>" />
            <!-- <img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('arrivalAirport','arrivalAirportId',this,1,'city','airport')" />    
             -->     
            </li>
                <li class="w3 SearchBtn"><input id="controlColor1"  class="submitBTN2" type="button" onclick="searchDynamic1()"/></li>
                
                <li class="w1">航班号：</li>
                <li class="w2">
                <input name="input2" type="text" class="jdmc" id="flightFno" value="<%=fno%>"/>
            </li>
            
                <li class="w3 SearchBtn"><input id="controlColor2"  class="submitBTN2" type="button" onclick="searchDynamic2()"/></li>
            </ul>
    </div>
    	<%
    		String weatherCode = dpt;
    		String returnWeatherCode = arr;
    		String weatherType = "F";
    	%>
    	<%@include file="/flight/weatherControl.jsp" %>
        
    </div>
    
    
    
   
    
<div class="clear"></div>
<div class="jd_fy_box margin5">
        <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy">
        <%if(!StringUtils.isEmpty(dpt)&&!StringUtils.isEmpty(arr)){ %>
        <ap:write key="<%=dpt%>"></ap:write>－<ap:write key="<%=arr%>"></ap:write>
        <%}else if(!StringUtils.isEmpty(fno)){ %>
               航班号:<%=fno%>
        <%} %></li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
       </ul>
    </div>
<div class="jp_xx jd_fwtd center Wmargin1 hbdt">
        <ul class="hd">
        <li class="w1"></li>
        <li class="w2">航班号</li>
        <li class="w5">出发城市</li>
        <li class="w4">到达城市</li>
        <li class="w5">计划(预计)起飞</li>
        <li class="w3">实际起飞</li>
        <li class="w5">计划(预计)到达</li>
        <li class="w3">实际到达</li>
        <li class="w6">状态</li>
        </ul>
<%
if(!StringUtils.isEmpty(fno)||(!StringUtils.isEmpty(dpt)&&!StringUtils.isEmpty(arr)) ){
	  String result;
	  FlightDynamicRequestMessage flightDynamicRequestMessage = new FlightDynamicRequestMessage();
	    
	    flightDynamicRequestMessage.setArr(arr);
	    flightDynamicRequestMessage.setDpt(dpt);
	    flightDynamicRequestMessage.setFno(fno);
	    
	    result=flightDynamicRequestMessage.excute();
	    FlightDynamicResponseMessage flightDynamicResponseMessage =new FlightDynamicResponseMessage();
	    flightDynamicResponseMessage.parseResponse(result);
	     ArrayList<FlightDynamicVo> dynamiclist;
	    dynamiclist =new  ArrayList<FlightDynamicVo>(); 
	    dynamiclist=flightDynamicResponseMessage.getFlightDynamicList();
	    if(dynamiclist!=null){
	  	for(int i=0;i<dynamiclist.size();i++){ 
	    FlightDynamicVo dynamic = dynamiclist.get(i);
	    
	    String realDeptTime =dynamic.getRealDeptTime();
	    if(realDeptTime.equals("false")){
	    	realDeptTime="未定";
	    }
	    
	    String realArrTime =dynamic.getRealArrTime();
	    if(realArrTime.equals("false")){
	    	realArrTime="未定";
	    }
	    String airlineCompanyCode =dynamic.getFlightNum().substring(0,2);
%>
        <ul class="">
        <li class="w1"><img src="${ctx}/web/images/32_32/icon_airport<%=airlineCompanyCode %>.gif"></li>
        <li class="w2"><%=dynamic.getFlightNum() %></li>
        <li class="w5"><%=dynamic.getDeptAirport() %></li>
        <li class="w4"><%=dynamic.getArrAirport() %></li>
        <li class="w5"><%=dynamic.getExpectedDeptTime() %></li>
        <li class="w3"><%=realDeptTime %></li>
        <li class="w5"><%=dynamic.getExpectedArrTime() %></li>
        <li class="w3"><%=realArrTime %></li>
        <li class="w6"><%=dynamic.getFlightState() %></li>
        </ul>
        <%
}
	    }
}
        %>
    </div>
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>

<script type="text/javascript">
	
//航班动态
 function searchDynamic1(){
     if(yzInfo()){
	 var dpt=$("#departureAirportId").attr("value");
	 var arr=$("#arrivalAirportId").attr("value");
	
	 var url="${ctx}/flight/searchdynamic.jsp?dpt="+dpt+"&arr="+arr;
	 
	  $("#controlColor1").attr("disabled",true).css("backgroundPosition","0 -32px");
        if(dpt!=null&&dpt!=''&&arr!=null&&arr!=''){
         window.location=url;
     }
        }
	}
	
function yzInfo(){
  
  		 if($("#departureAirport").val()== null || $("#departureAirport").val() =="" || $("#departureAirport").val() =="中文/拼音" || $("#departureAirportId").val()== null ||  $("#departureAirportId").val()== '' || $("#departureAirportId").val()== "null"){
            $('#departureAirport').attr('value','');
            $('#departureAirport').click();
            return false;
        }
        if($("#arrivalAirport").val()== null || $("#arrivalAirport").val() =="" || $("#arrivalAirport").val() =="中文/拼音" || $("#arrivalAirportId").val()== null ||  $("#arrivalAirportId").val()== '' || $("#arrivalAirportId").val()== "null"){
            $('#arrivalAirport').attr('value','');
            $('#arrivalAirport').click();
            return false;
        }
         if($("#departureAirportId").val()== $("#arrivalAirportId").val()){
            $('#departureAirport').attr('value','');
            $('#departureAirport').click();
            alert("对不起,你的出发地和目的地相同");
            return false;
        }
        return true;
        }
        
function searchDynamic2(){
	
	var fno =$("#flightFno").attr("value");
	  
	 
	  var url="${ctx}/flight/searchdynamic.jsp?fno="+fno;
        
             if(fno!=null&&fno!=''){
             $("#controlColor2").attr("disabled",true).css("backgroundPosition","0 -32px");
               window.location=url;
             }else{
               alert("您输入的航班号有误!");
            
            }
   }

</script>
</body>
