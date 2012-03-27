<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="java.util.Map"%>
<%@page import="com.hnatourism.club.common.helper.flight.HotAirLineRequestMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.HotAirLineResponseMessage"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.web.vo.HotAirLineVo"%>
<%@page import="com.hnatourism.club.common.cache.CityareaCache"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%
    String userid = "";
	 if(null != UserUtil.getUser(request.getSession().getId())){
		 userid=UserUtil.getUser(request.getSession().getId()).getId();
	 }
    request.setAttribute("userid",userid);
    %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
    <script type="text/javascript" src="${ctx}/web/js/paging.js" ></script>
	<script type="text/javascript">var CTX='${ctx}';var isDisplayCity='Y';</script>
    <script type="text/javascript" src="${ctx}/web/js/city/allAirport.js" ></script><!-- 用了 -->
	<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->
    <script type="text/javascript" src="${ctx}/web/js/city/allAirport.js"></script>
    <script type="text/javascript" src="${ctx}/common/include/weatherAjax.js"></script>
    <title>机票预订 - ${domain_cn }</title>
    </head>
    <body>
<div class="clear"></div>
<div class="senav">
        <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="#" class="se">首页</a> > <a href="#" class="se">机票预订</a></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
    </div>
    
 
 
<div class="clear"></div>
<div class="search">
        <div class="search_left">
        <div class="searchform_frm clearfix_">
                <div class="left_txt w1">出发城市：</div>
                <div class="r_form w2">
                <DIV class="inb">
            <input name="deAirport" type="hidden" id="departureAirportId" value="" />             
            <input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="departureAirport" name="departureAirport" onblur="blurEvt(this)"
           value="中文/拼音" style="color:#C1C1C1"
            onclick="suggest_Flight.display(this,'departureAirportId',event)"
            onkeyup="suggest_Flight.display(this,'departureAirportId',event)"
            value="<ap:write key="" isDisplayCity="true"></ap:write>" />
         <!--   <img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('departureAirport','departureAirportId',this,1,'city','airport')" />
           -->
              </DIV>
            </div>
                <div class="left_txt w3">到达城市：</div>
                <div class="r_form w4">
                <DIV class="inb">
            <input name="arAirport" type="hidden" id="arrivalAirportId" value="" />             
            <input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="arrivalAirport" name="arrivalAirport" onblur="blurEvt(this)"
           value="中文/拼音" style="color:#C1C1C1"
            onclick="suggest_Flight.display(this,'arrivalAirportId',event)"
            onkeyup="suggest_Flight.display(this,'arrivalAirportId',event)"
            value="<ap:write key="" isDisplayCity="true"></ap:write>" />
           <!--  <img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('arrivalAirport','arrivalAirportId',this,1,'city','airport')" />    
             --> 
               </DIV>
            </div>
                <div class="left_txt w5"></div>
                <div class="r_form w6">
                <input type="radio" name="redio_searchFlight" value="1" id="danCheng" checked="checked">
                <label for="danCheng"> 单程 </label>
                &nbsp;&nbsp;
                <input type="radio" name="redio_searchFlight" value="2" id="wangFan">
                <label for="wangFan"> 往返 </label>
            </div>
                <div class="left_txt w1">出发时间：</div>
                <div class="r_form w2">
                <DIV class=inb>
                        <input id="plainDate1" onchange="checkWhenBack()" class="inps" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})"  name="searchDepartureTime"/>
                  <!--       <a class="set_date" href="javascript:WdatePicker({el:'plainDate1',minDate:'%y-%M-%d'});"></a>\
                  -->
                  </DIV>
            </div>
                <div class="left_txt w3 ReturnTime"><span>返程时间：</span></div>
                <div class="r_form w4 ReturnTime">
                <div class="inb" id="labPlain2">
                        <input id="plainDate2"  class="inps" type="text" onfocus="WdatePicker({minDate:$('#plainDate1').val()})"  name=""/>
                    <!--     <a class="set_date" href="javascript:WdatePicker({el:'plainDate2',minDate:$('#plainDate1').val()});"></a>
                    -->
                    </DIV>
            </div>
                <div class="btn"><input id="controlColor" class="submitBTN" type="button" onclick="searchFlight()"/></div>
            </div>
    </div>
    <%--
    	String weatherCode = "";
    	String returnWeatherCode = "";
    	String weatherType = "F";
   
    <%@include file="/flight/weatherControl.jsp" %> 
    --%>
    <%--天气预报--%>
    <div id="tq_box" class="tq_box1"></div>
    </div>
<div class="clear"></div>
<div id="jcbottom">
        <div class="jc_content">
        <div class="jc_left h330">
            <!---->
            <div class="module_a business">
            <div class="title"><span class="l"></span><span class="c"><h3> <b class="orange">SPECIAL FARES</b>会员三折机票申请 </h3><h3 class="L130"> <b class="orange">BUSINESS JET</b>公务机申请</h3></span><span class="r"></span></div>
        	<div class="inner clearfix_ ">
            <ul class="Tickets70off">
                        <li class="point">金管家，享受一年1人次国内往返三折票，<br>白金管家，享受一年2人次国内往返三折机票，<br>钻石管家，享受一年3人次国内往返三折机票；</li>
                         <li class="btnBox"><a href="javascript:void(0);threeDiscountTicket()" class="business_btn">提交特价申请</a></li>
                    </ul>

                    <%
                    String judge = "";
                    String isLoad = request.getParameter("isLoadName");
                    if("yes".equals(isLoad)){
                    %>
                    <%@include file="/flight/flightGroupControl.jsp" %>    
                    <%} %>
                    <form action="${ctx}/flight/index.jsp" id="addWishForm" />
                    	<input type="hidden" name="originCityName" id="originCityId" />
                    	<input type="hidden" name="destinationsCityName" id="destinationsCityId" />
                    	<input type="hidden" name="startTimeName" id="startTimeId" />
                    	<input type="hidden" name="priceName" id="priceId" />
                    	<input type="hidden" name="isLoadName" id="isLoadId" value="yes"/>
                    </form>
                <ul class="noBG">
                        <li class="point">想要高效、专享、尊贵的公务机，那么在这里申请吧！我们为您打造专享公务机服务！</li>
                         <li class="btnBox"><a href="javascript:void(0);addWish()" class="business_btn">提交公务机申请</a></li>
                    </ul>
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
            <!---->
            </div>
        
        <!---->
        <div class="jc_right">
                <div class="jc_title">
                <h3> <b class="orange">FLIGHT</b>航班进出港动态</h3>
            </div>
                <div class="jc_righta1">
                <ul>
                        <li class="w1"><span class="orange">出发地：</span></li>
                        <li class="w2">
                       <!-- <input type="text" class="input3" name="input"  id="txtplain1"> -->
                       
               
			            <input name="deAirport" type="hidden" id="txtplain1" value="" />             
			            <input  type="text" class="input3 w1" autoComplete="off" onfocus="showSearch_Flight(this)" id="txtplain11" name="txtplain11" onblur="blurEvt(this)"
			           value="中文/拼音" style="color:#C1C1C1"
			            onclick="suggest_Flight.display(this,'txtplain1',event)"
			            onkeyup="suggest_Flight.display(this,'txtplain1',event)"
			            value="<ap:write key="" isDisplayCity="true"></ap:write>" />   
                    </li>
                        <li class="w1"><span class="orange">目的地：</span></li>
                        <li class="w2">
                      <!--    <input type="text" class="input3" name="input3" id="txtplain2"> -->
                
			            <input name="arAirport" type="hidden" id="txtplain2" value="" />             
			            <input  type="text" class="input3 w1" autoComplete="off" onfocus="showSearch_Flight(this)" id="txtplain22" name="txtplain22" onblur="blurEvt(this)"
			           value="中文/拼音" style="color:#C1C1C1"
			            onclick="suggest_Flight.display(this,'txtplain2',event)"
			            onkeyup="suggest_Flight.display(this,'txtplain2',event)"
			            value="<ap:write key="" isDisplayCity="true"></ap:write>" />
                    </li>
                       <li class="w3"><input id="controlColor1"  class="submitBTN1" type="button" onclick="searchDynamic1()"/></li> 
                       <li class="w1"><span class="orange">航班号：</span></li>
                        <li class="w2">
                        <input type="text" class="input3" name="input4"  id="flightFno">
                    </li>
                        <li class="w3"><input id="controlColor2"  class="submitBTN1" type="button" onclick="searchDynamic2()"/></li>   
                     
                    </ul>
            </div>
            </div>
        <!----> 
        <%
         	String result;

         	HotAirLineRequestMessage hotAirLineRequestMessage = new HotAirLineRequestMessage();
			long a = System.currentTimeMillis();
         	result = hotAirLineRequestMessage.excute();
         	long b = System.currentTimeMillis();
         	System.out.println("热门航线用时："+(b-a));

         	HotAirLineResponseMessage hotAirLineResponseMessage = new HotAirLineResponseMessage();

         	hotAirLineResponseMessage.parseResponse(result);

         
         	Map<String, List<HotAirLineVo>> map = hotAirLineResponseMessage.getMap();
         	
       
         
         %>
        <!--tag-->
        <div class="DiscountTicket">
       
                <ul class="float_li left clearfix_">
              
                <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
                <li class="jc_tagbj">
                        <div class="tag_right">
                        <ul>
                           <%  
                           int j=1;
                           int c=map.size();
                           String id="";
                           String classStr="jc_ta2";
                           String liClass="jc_tag1";
                           String sb="";
                           for(String name:map.keySet()){ 
                             id="navjd"+String.valueOf(c);
                             if(c==1){
                            	 classStr="jc_ta1";
                             }
                             else{
                            	 classStr="jc_ta2";
                             }
                             classStr="";
                             if(j==map.size()){
                            	 liClass="jc_tag1 last";
                             }
                             if(j==1){
                            	 sb="<li class=\""+liClass+"\"><a href=\"#\" class=\""+classStr+"\" id=\""+id+"\">"+CityareaCache.getCityName(name)+"</a></li>"; 
                             }
                             else{
                            	 
                            	 sb="<li class=\""+liClass+"\"><a href=\"#\" class=\""+classStr+"\" id=\""+id+"\">"+CityareaCache.getCityName(name)+"</a></li>"+sb;  
                             }
                             
                             ++j;--c;}
                           out.print(sb);
                           %>
                        </ul>
                       </div>
                   </li>
                <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
                </ul>
             
                <div class="tag_right_boz left">
                 <%
                    String style="display:block;";
                    for(String name:map.keySet()){ 
                   	 int i=0;
                   	 if(i!=0){
                       	 style="display:none;";
                        }
                    	%>
                    	  <div class="golf_recommend Ticket_recommend" style="<%=style%>">
                    	<%
                	 for(HotAirLineVo mapInfo:map.get(name)){
                		 
                		 
                		String today = mapInfo.getDptDate();
                		
                		String todayNow=today.substring(today.indexOf("-")+1);
                		
                		String depCity=mapInfo.getDepartureAirport();
                		String arrCity=mapInfo.getArrivalAirport();
                	    
                	 %>
                 		<%
                 		if(i==0){
                 			%>
                 			 <ul class="noBG">
                 			<%
                 		}
                 		if(i<=8){ %>
                        <li><a href="javascript:searchHot('<%=depCity%>','<%=arrCity%>','<%=today%>')" ><span class="date"><%=todayNow %></span> <span class="goto"><p:write key="<%=mapInfo.getDepartureCity() %>" ></p:write>-<p:write key="<%=mapInfo.getArrivalCity() %>" ></p:write></span><span class="dis"><%=mapInfo.getDiscount()%>折</span><span class="price orange"><%=mapInfo.getTodayPrice()%>元</span></a></li>
                        
                         <%}if(i==8){
                        		%>
                    			 </ul>
                    			<% 
                         } %>
                       <%
                 		if(i==9){
                 			%>
                 			 <ul class="noBG">
                 			<%
                 		}
                        if(i>8&&i<=17){ %>
                        <li><a href="javascript:searchHot('<%=depCity%>','<%=arrCity%>','<%=today%>')" ><span class="date"><%=todayNow %></span> <span class="goto"><p:write key="<%=mapInfo.getDepartureCity() %>" ></p:write>-<p:write key="<%=mapInfo.getArrivalCity() %>" ></p:write></span><span class="dis"><%=mapInfo.getDiscount()%>折</span><span class="price orange"><%=mapInfo.getTodayPrice()%>元</span></a></li>
                       
                        <%}
                        if(i==17){
                    	%>
               			 </ul>
               			<% }
                        i++;
                	  }
                    %>
                     </div>                    
                    <%
                    }
                    %>
              
               
            </div>
      </div>
        <!--tab end-->
        
        <div class="jc_right1"> <img src="${ctx}/web/images/right1.jpg"> </div>
        <div class="clear"></div>
    </div>
        <div class="clear"></div>
        
    </div>
    
<script type="text/javascript">

$(function(){
	//加载天气预报
	loadWeatherAjax("#tq_box","PEK","SHA","F","F");
// 特价机票Tag
    $("li.jc_tag1").mouseover(function(){
        $(this).children("a").attr("class","jc_ta1").parent().siblings("li").children("a").attr("class","jc_ta2")
        var s = $("li.jc_tag1").length;
        var index = $("li.jc_tag1").index(this);
        $(".tag_right_boz >div").eq(s-index-1).show().siblings().hide();
    });
	
// 单程&往返radio
	
	
	if('${flightType}'==2){
	$("#danCheng").attr('checked', false); 
	$("#wangFan").attr('checked', true); 
	$(".ReturnTime").children().show();
	}
	else{
	$("#danCheng").attr('checked', true); 
	$("#wangFan").attr('checked', false); 
	$(".ReturnTime").children().hide();
	}
	$("#wangFan,#danCheng").click(function(){
		$("#wangFan").is(":checked") ? $(".ReturnTime").children().show() : $(".ReturnTime").children().hide();
	});
});
//三折票
function threeDiscountTicket(){
	if(null == '${userid}' || '' == '${userid}' || 'null' == '${userid}'){
				   var url="${ctx}/member/login.jsp";
			       window.location=url;
			       return;
	}
	var url="${ctx}/flight/discount.jsp";
	window.location=url;
}
//添加心愿
function addWish(){
	if(null == '${userid}' || '' == '${userid}' || 'null' == '${userid}'){
				   var url="${ctx}/member/login.jsp";
			       window.location=url;
			       return;
	}
	var url="${ctx}/flight/applybusiness.jsp";
	window.location=url;
		if($("#originCityTwo").val()== null || $("#originCityTwo").val() =="" || $("#originCityTwo").val() =="中文/拼音" || $("#originCityTwo").val()== null ||  $("#originCityTwo").val()== '' || $("#originCityTwo").val()== "null"){
            $('#originCityTwo').attr('value','');
            $('#originCityTwo').click();
            return false;
        }
        if($("#destinationsCityTwo").val()== null || $("#destinationsCityTwo").val() =="" || $("#destinationsCityTwo").val() =="中文/拼音" || $("#destinationsCityTwo").val()== null ||  $("#destinationsCityTwo").val()== '' || $("#destinationsCityTwo").val()== "null"){
            $('#destinationsCityTwo').attr('value','');
            $('#destinationsCityTwo').click();
            return false;
        }
	
	if($("#originCityOne").val()== $("#destinationsCityOne").val()){
            $('#originCityOne').attr('value','');
            $('#originCityOne').click();
            alert("对不起,你的出发地和目的地相同");
            return false;
    }
    
    if($("#plainDate3").val()== null || $("#plainDate3").val() == "" ){
            $('#plainDate3').attr('value','');
            WdatePicker({el:'plainDate3',minDate:'%y-%M-%d'});
            return false;
    }
    if($("#price").val()==null || $("#price").val()==""){
    	alert("价格不能为空");
    	$("#price").focus();
    	return false;
    }
	var originCity=$("ul[name='wish']").find("input[name='originCity']").val();
	var destinationsCity=$("ul[name='wish']").find("input[name='destinationsCity']").val();
	var startTime=$("ul[name='wish']").find("input[name='startTime']").val();
	var price=$("ul[name='wish']").find("input[name='price']").val();
	$("#originCityId").attr("value",originCity);
	$("#destinationsCityId").attr("value",destinationsCity);
	$("#startTimeId").attr("value",startTime);
	$("#priceId").attr("value",price);
	
	$("#addWishForm").submit();
	
}

//航班动态
  
 function searchDynamic1(){
 
     if(yzInfo()){
	 var dpt=$("#txtplain1").attr("value");
	 var arr=$("#txtplain2").attr("value");
	 var url="${ctx}/flight/searchdynamic.jsp?dpt="+dpt+"&arr="+arr;
	  $("#controlColor1").attr("disabled",true).css("backgroundPosition","0 -38px");
	 if(dpt!=null&&dpt!=''&&arr!=null&&arr!=''){
     window.location=url;
     
     
     }
    	
     }
	}

function yzInfo(){

	   if($("#txtplain1").val()== null || $("#txtplain1").val() =="" || $("#txtplain1").val() =="中文/拼音" || $("#txtplain11").val()== null ||  $("#txtplain11").val()== '' || $("#txtplain11").val()== "null"){
            $('#txtplain11').attr('value','');
            $('#txtplain11').click();
            return false;
        }
        if($("#txtplain2").val()== null || $("#txtplain2").val() =="" || $("#txtplain2").val() =="中文/拼音" || $("#txtplain22").val()== null ||  $("#txtplain22").val()== '' || $("#txtplain22").val()== "null"){
            $('#txtplain22').attr('value','');
            $('#txtplain22').click();
            return false;
        }
         if($("#txtplain11").val()== $("#txtplain22").val()){
            $('#txtplain1').attr('value','');
            $('#txtplain1').click();
            alert("对不起,你的出发地和目的地相同");
            return false;
        }
        return true;
        }
        
function searchDynamic2(){
	
	  var fno =$("#flightFno").attr("value");
	//  var fno="MU5126";
	 
	  var url="${ctx}/flight/searchdynamic.jsp?fno="+fno;
        
           if(fno!=null&&fno!=''){
            $("#controlColor2").attr("disabled",true);	
 	         $("#controlColor2").attr("disabled",true).css("backgroundPosition","0 -38px");
            window.location=url;
             }else{
            alert("您输入的航班号有误!");
           }
   }
   
   
//查询航班
 function searchFlight(){
 	
 		
	 if(yzData()){
	 var  flightType = 1;
	 if($("#wangFan").attr('checked') == true){
          flightType = 2;
     }		
	 var deFlight=$("#departureAirportId").attr("value");
	 var arFlight=$("#arrivalAirportId").attr("value");
	 var deDate=$("#plainDate1").attr("value");
	 var reDate=$("#plainDate2").attr("value");
	 var url="${ctx}/flight/search.jsp?flightType="+flightType+"&deAirport="+deFlight+"&arAirport="+arFlight+"&departureDate="+deDate;
	 
         if(reDate!=null && reDate!=''){
             url+="&returnDate="+reDate;
           }
              $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -41px");
              window.location=url;
             
	 }
   }
   
function yzData(){

	     var  flightType = 1;
		 if($("#wangFan").attr('checked') == true){
	          flightType = 2;
	     }		
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
        
       if($("#plainDate1").val()== null || $("#plainDate1").val() == "" ){
            $('#plainDate1').attr('value','');
            WdatePicker({el:'plainDate1',minDate:'%y-%M-%d'});
            return false;
            }
       if( flightType == 2){
	       if($("#plainDate2").val()== null || $("#plainDate2").val() == "" ){
	          $('#plainDate2').attr('value','');
	          WdatePicker({el:'plainDate2',minDate:$('#plainDate1').val()});
	          return false;
	        }
        }
        var staDate=$("#plainDate1").val();
        var eDate=$("#plainDate2").val();
        var starDate=new Date(staDate.split("-").join("/"));
        if(eDate!=null && eDate!=""){
         var endDate=new Date(eDate.split("-").join("/"));
         if(starDate>endDate){
       		alert("返程时间小于出发时间！");
       		return false;
       	}
        }
        
        return true;
}
//查询热门航班

function searchHot(deFlight,arFlight,deDate){

     var flightType = 1;
     
      var url="${ctx}/flight/search.jsp?flightType="+flightType+"&deAirport="+deFlight+"&arAirport="+arFlight+"&departureDate="+deDate;
      
           window.location=url;
}
<%
	if("right".equals(judge)){
%>
alert("心愿提交成功");
window.location="${ctx}/flight/index.jsp";
<%
	}
	if("error".equals(judge)){
%>
alert("心愿提交失败");
<%}%>


// 取当前时间毫秒数 
var nowTime = Date.parse(new Date());

// 更新离开日期
function checkWhenBack() {
	var checkInDate = document.getElementById("plainDate1").value;
	var checkOutDate = document.getElementById("plainDate2").value;
	var checkInTime = new Date(checkInDate.split("-").join("/"));
	nowTime = Date.parse(checkInTime);
	var nextdate = getFormatDate(24 * 60 * 60 * 1000);
	var start = new Date(nextdate.replace(/\-/g, "\/"));
    var end = new Date(document.getElementById("plainDate2").value.replace(/\-/g, "\/"));
    if (start > end) {
	    document.getElementById("plainDate2").value = nextdate;
	}
}

    function getFormatDate(enterTime) {
		if(enterTime){
			var now = new Date(nowTime+enterTime);
		}
		 else{
			 var now = new Date();
		 }
		    var _year = now.getFullYear();   
		   	var _month = now.getMonth()+1;
		   	var a = _month.toString();
            if ('1' == a.length) {
                _month = '0' + _month;
            }
		    var _day = now.getDate();
		    var b = _day.toString();
		    if ('1' == b.length) {
                _day = '0' + _day;
            }
		    var myDate=_year+"-"+_month+"-"+_day;
		    return myDate; 	    
     }	
</script>
</body>
