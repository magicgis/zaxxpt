<%@ page pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
	<script type="text/javascript">var CTX='${ctx}';var isDisplayCity='Y';</script>
    <script type="text/javascript" src="${ctx}/web/js/city/allAirport.js"></script>
    <script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script>
<title>酒店预订 - ${domain_cn}</title>
<script type="text/javascript">
	function jump(id)
	{
		window.location.href="${ctx}/hotelOrderAction!viewDetails.action?code="+id;
	}
	function back()
	{
		window.location.href="${ctx}/hotel/index.jsp";
	}
	function go(){
		window.location.href="${ctx}/member/index.jsp?tabIndex=1";
	}
</script>
<style type="text/css">
	.orderDT{
	}
	.orderDT tr td {
		text-align: left;
	} 
</style>
</head>
<body>

<div class="width_m5"><img src="${ctx}/web/images/xx_top.jpg" /></div>
<div class="border_e4 Wmargin bg_fb">
    <div class="bordere0 Wmargin96 height100f automargin h_auto pb_20"> 
        <dl class="Tips">
<%--            <s:if test='orderCode!=null&&orderCode!=""&&hotelOrderDetailsVo!=null'>--%>
            <s:if test='#session.hotelOrderDetailsVo!=null'>
            	<div><font color="red" size="5">恭喜您，订单提交成功!</font></div>
            	尊敬的${_user_.memberRole.name}会员${_user_.name}，您的订单已提交成功.<br>您的专属秘书正在为您确认订单，订单确认后我们将以短信的方式通知您，请您保持电话畅通。如行程有变，请尽快致电<span class="orange">${site_tel}</span>！
            	<table border="0"  width="100%" class="orderDT">
            		<tr>
            		<td width="50%">
            			<table border="0" width="100%">
            			<tr><td width="50%">订单号:<font color="red">${hotelOrderDetailsVo.resultBean.code}</font></td>
            			<td> 订单总额:<font color="red">RMB ${hotelOrderDetailsVo.resultBean.totalMoney}</font></td>
            			</tr>
            			<tr>
            				<td>酒店名称：${hotelOrderDetailsVo.resultBean.hname}</td>
            			</tr>
            			<tr>
            				<td>酒店地址：${hotelOrderDetailsVo.resultBean.haddress }</td>
            			</tr>
            			<tr>
            				<td>客人姓名：${hotelOrderDetailsVo.resultBean.pnames }</td>
            			</tr>
            			<tr>
            				<td>入住日期：${hotelOrderDetailsVo.resultBean.idate}</td>
            				<td>离店日期：${hotelOrderDetailsVo.resultBean.odate}</td>
            			</tr>
            			<tr>
            				<td>房型名称：${hotelOrderDetailsVo.resultBean.rname}</td>
            				<td>数量：${hotelOrderDetailsVo.resultBean.rnum}间 </td>
            			</tr>
            		    </table>
            		</td>
            		<td width="50%" valign="top">
            			<table border="0" width="100%">
            				<tr>
            			<td> <font color="red">酒店退改规则：</font></td>
            			</tr>
            			<tr>
            				<td>${hotelOrderDetailsVo.resultBean.rmk}</td>
            			</tr>
            			<tr>
            				<td><font color="red">退改须知</font></td>
            			</tr>
            			<tr>
            				<td>登陆${domain_cn }订单管理人工退改或致电<span class="orange">${site_tel}</span>客服退改</td>
            			</tr>
            			</table>
            		</td>
            		</tr>
            	</table>
       			<a onclick="jump('${hotelOrderDetailsVo.resultBean.code}')" href="#">进入订单管理</a><br><br>
               <div style="position:relative;top:100;left:100">
       			<font color="red" size="4">是否还需预定机票？</font>
  <div class="search">
	<div class="search_left">
        <div class="searchform_frm">
                <div class="left_txt w1">出发城市：</div>
                <div class="r_form w2">
                	<div class="inb">
                        <!--<INPUT id="txtplain1" class="inps" onfocus="showSearch_Flight(this)" onkeyup="suggest_Flight.display(this,'departureAirportId',event)" " type="text" name=s"earchDepartureAirport">
                         <A class="set_city" href="javascript:suggest_Flight.display(this,'departureAirportId',event);"></A>--> 
            			<input name="deAirport" type="hidden" id="departureAirportId" value="" />             
            			<input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="departureAirport" name="departureAirport" onblur="blurEvt(this)"
            			value="中文/拼音" style="color:#C1C1C1"
            			onclick="suggest_Flight.display(this,'departureAirportId',event)"
            			onkeyup="suggest_Flight.display(this,'departureAirportId',event)"
            			value="<ap:write key="" isDisplayCity="true"></ap:write>" />
          				<!--   <img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('departureAirport','departureAirportId',this,1,'city','airport')" />
          				-->
               		</div>
            	</div>
                <div class="left_txt w3">到达城市：</div>
                <div class="r_form w4">
                	<div class="inb">
            			<input name="arAirport" type="hidden" id="arrivalAirportId" value="" />             
            			<input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="arrivalAirport" name="arrivalAirport" onblur="blurEvt(this)"
           				value="中文/拼音" style="color:#C1C1C1"
            			onclick="suggest_Flight.display(this,'arrivalAirportId',event)"
            			onkeyup="suggest_Flight.display(this,'arrivalAirportId',event)"
            			value="<ap:write key="" isDisplayCity="true"></ap:write>" />
                    </div>
            	</div>
                <div class="left_txt w5"></div>
                <div class="r_form w6">
                	<input type="radio" name="redio_searchFlight" value="1" id="danCheng" checked="checked" onclick="openOrCloseInput('1')">
                	<label for="danCheng"> 单程 </label>
                	&nbsp;&nbsp;
                	<input type="radio" name="redio_searchFlight" value="2" id="wangFan" onclick="openOrCloseInput('2')">
                	<label for="wangFan"> 往返 </label>
            	</div>
                <div class="left_txt w1" id="comeTimeDiv">出发时间：</div>
                <div class="r_form w2" id="comeTimeDivs">
                	<div class=inb>
                        <input id="plainDate1" class="inps" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})"  name="searchDepartureTime" value="" onclick="WdatePicker({maxDate:'#F{\'2050-10-01\'}',minDate:'%y-%M-%d'})" onchange="checkWhenBack()"/>
                    	<!--     <a class="set_date" href="javascript:WdatePicker({el:'plainDate1',maxDate:'#F{\'2050-10-01\'}',minDate:'%y-%M-%d'})"></a>
                    	-->
                    </div>
            	</div>
                <div class="left_txt w3 ReturnTime" id="backTimeDiv"><span>返程时间：</span></div>
                <div class="r_form w4 ReturnTime" id="backTimeDivs">
                	<div id="labPlain2" class="inb">
                    	<input id="plainDate2" class="inps" type="text" onfocus="WdatePicker({minDate:$('#plainDate1').val()})"  name="" value="" onclick="WdatePicker({maxDate:'#F{\'2050-10-01\'}',minDate:$('#plainDate1').val()})"/>
                    </div>
            	</div>
                <div class="btn"><input id="controlColor" class="submitBTN" type="button" onclick="searchFlight()"/></div>
		</div>
    </div>
    	<%-- <tr>
    		<td>舱位等级:&nbsp;&nbsp;<input type="radio" value="" checked="checked"/>经济舱
    		&nbsp;&nbsp;<input type="radio" value=""/>商务舱/头等舱

    		</td>
    	</tr>--%>
    	
    </table>
       			</div>
            </s:if>
            <s:elseif test="#session.hotelErrorMessage !=null">
            	<s:if test="#session.hotelErrorMessage =='timeout'">
		        	<dd>您的预订请求已经发出,请您查看您的酒店订单列表,如有疑问请致电${site_tel}进行咨询</dd>
		        	<button type="button" class="Btn101_25" onclick="javascript:go();">进入订单管理</button>
            	</s:if>
            	<s:else>
 	            	<dd>${hotelErrorMessage}.请重新预订。</dd>
	            	<button type="button" class="Btn101_25" onclick="javascript:back();">重新预订</button>
            	</s:else>
            </s:elseif>
            <s:else>
            	该页面已过期,请您进入您的个人中心
            	<button type="button" class="Btn101_25" onclick="javascript:go();">查看订单</button>
            </s:else>
        </dl>
    </div>
</div>
<div class="Wmargin"><img src="${ctx}/web/images/jd_list_bbottom.jpg" /></div>
<%
//去掉session里面的东西
session.removeAttribute("hotelOrderDetailsVo");
session.removeAttribute("hotelErrorMessage");
%>

<script type="text/javascript" defer="defer">
	//错误信息提示 2011-10-13 15:43 张晗 add
$(function (){
	var hotelErrorMes = "${hotelErrorMessage}";
	if(hotelErrorMes){
		if(hotelErrorMes=="timeout"){
			//预订时超时
			alert("预订酒店时网络超时");
		}else {
			alert(hotelErrorMes);
		}
	}
});

function showMessage(message)
{
	if(message&&message!="")
	{
		alert(message);
	}
}

showMessage('${message}')

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
        function openOrCloseInput(obj){
			if(obj=='1'){
				$("#backTimeDiv").hide();
				$("#backTimeDivs").hide();
			}else{
				$("#backTimeDiv").show();
				$("#backTimeDivs").show();
			}
           }
$(function(){
	$("#backTimeDiv").hide();
	$("#backTimeDivs").hide();
});
</script>
</body>