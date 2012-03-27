<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 显示底部的广告 value: 四位的广告位代码--%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.club.flight.web.action.MemberSleCountBean"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/common.css" rel="stylesheet" type="text/css" />
<link href = "${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<script  src="${ctx}/web/js/clubJs/select2css.js" language="javascript" type="text/javascript"></script>

<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/city/allAirport.js"></script>
<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidator_min.js" defer="defer"></script>
<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidatorRegex.js"></script>
<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidator_helper.js"></script>
<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->

<script type="text/javascript" src="${ctx}/web/js/city/allAirport.js"></script>
<title>会员三折往返票申请 - ${domain_cn }</title>
</head>
<body>
<% 
MemberInfoVo memberVo=UserUtil.getUser(request.getSession().getId());
String userid = "";
String role = "";
if(null != UserUtil.getUser(request.getSession().getId())){
	userid=UserUtil.getUser(request.getSession().getId()).getId();
	role = UserUtil.getUser(request.getSession().getId()).getMemberAccount().getMemberRole().getCode();
}
MemberSleCountBean memberSleCountBean = new MemberSleCountBean();
String count = memberSleCountBean.findMemberSleCount(userid);
	
int roleCount = 0;
if("GOLD".equals(role)){ 
	roleCount = 2;
}else if("PLATINUM".equals(role)){
	roleCount = 4;
}else if("DIAMOND".equals(role)){
	roleCount = 6;
}
request.setAttribute("count",count);
request.setAttribute("roleCount",roleCount);
%>
<div id="fade" class="black_overlay"></div>
<div id="tips" class="ck1" style="display:none; width:238px;"> <a title="关闭" href="javascript:closeTips('tips')">X</a>
    <h2>退票规定：</h2>
    <p>收取票面价（不含税）的10%作为退票费;</p>
    <h2>改签规定：</h2>
    <p>不论在航班离站前或后，同舱位免费变更，不限次数。</p>
</div>
<div class="clear"></div>
<div class="xx_nav">
    <ul>
        <li><img src="${ctx}/web/images/xileft.jpg" /></li>
        <li class="se_nav"><span class="jd_ddxx">填写订单</span><span class="jd_ts">可申请次数：<%=roleCount%> &nbsp;&nbsp; 已申请次数：<%=count%> </span></li>
        <li><img src="${ctx}/web/images/xiright.jpg" /></li>
    </ul>
</div>
<div class="clear"></div>
<div class="jd_dd_box">
    <div><img src="${ctx}/web/images/xx_top.jpg" /></div>
    <div class="jc_bj_box">
        <div class="qrddxx_box automargin">
            <div class="qrddxx_b_head"><span class="slogo1">航班信息</span></div>
            <ul class="qrddxx_b_l"  style="width:98%">
                <li  style="width:98%"><span class="gray">
                	<span class="left">出发城市：</span> <span class="left">
                            <div class="inb">
                            <input name="originCity" type="hidden" id="departureAirport" value="" />             
            				<input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="originCityTwo" name="departureAirport" onblur="blurEvt(this)"
           					value="中文/拼音" style="color:#C1C1C1"
            				onclick="suggest_Flight.display(this,'departureAirport',event)"
            				onkeyup="suggest_Flight.display(this,'departureAirport',event)"
            				value="<ap:write key="" isDisplayCity="true"></ap:write>" />
            				<img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('originCityTwo','departureAirport',this,1,'city','airport')" />
                            </div>
                    </span> 
                    <span class="left L1em">到达城市：</span> <span class="left">
                            <div class="inb">
                            <input name="destinationsCity" type="hidden" id="arrivalAirport" value="" />             
            				<input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="destinationsCityTwo" name="arrivalAirport" onblur="blurEvt(this)"
           					value="中文/拼音" style="color:#C1C1C1"
            				onclick="suggest_Flight.display(this,'arrivalAirport',event)"
            				onkeyup="suggest_Flight.display(this,'arrivalAirport',event)"
            				value="<ap:write key="" isDisplayCity="true"></ap:write>" />
            				<img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('destinationsCityTwo','arrivalAirport',this,1,'city','airport')" />    
                            </div>
                	</span>   
                	<div class="r_form w6" style="margin-bottom:5px;margin-left:20px;height:20px;line-height:20px;">
                		<input type="radio" name="redio_searchFlight" value="1" id="danCheng" checked="checked">
                		<label for="danCheng"> 单程 </label>
                		&nbsp;&nbsp;
                		<input type="radio" name="redio_searchFlight" value="2" id="wangFan" >
                		<label for="wangFan"> 往返 </label>
            		</div> 
                </li>
                <li  style="width:98%">
                	<div class="left_txt w1">出发时间：</div>
               		<div class="r_form w2">
                	<DIV class=inb>
                        <input id="departureDate" class="inps" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})"  name="searchDepartureTime" value="" onclick="WdatePicker({maxDate:'#F{\'2050-10-01\'}',minDate:'%y-%M-%d'})" onchange="checkWhenBack()"/>
                        <a class="set_date" href="javascript:WdatePicker({el:'departureDate',maxDate:'#F{\'2050-10-01\'}',minDate:'%y-%M-%d'})"></a></DIV>
            		</div>
                	<div class="left_txt w3 ReturnTime"><span>&nbsp;&nbsp;返程时间：</span></div>
                	<div class="r_form w4 ReturnTime">
                	<div id="labPlain2" class="inb">
                        <input id="reDepartureDate" class="inps" type="text" onfocus="WdatePicker({minDate:$('#departureDate').val()})"  name="" value="" onclick="WdatePicker({maxDate:'#F{\'2050-10-01\'}',minDate:$('#departureDate').val()})"/>
                        <a class="set_date" href="javascript:WdatePicker({el:'reDepartureDate',maxDate:'#F{\'2050-10-01\'}',minDate:$('#departureDate').val()})"></a></DIV>
            		</div>
                </li>
            </ul>
        </div>
    </div>
    <div><img src="${ctx}/web/images/jc_bottom.jpg" /></div>
</div>
<div class="clear"></div>
<div class="jd_fy_box margin5">
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy"><span class="black">乘机人信息</span></li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
</div>
<div class="jp_xx Wmargin1 bg_fb cjrxx1">
    <ul>
        <li class="w1">姓 名：</li>
        <li class="w2">
            <div class="xmbox">
                <input name="input2" type="text" class="jdmc" id="pName" />
            </div>
        </li>
        <li class="w3">
            <div id="uboxstyle1">
                <select name="language" id="pType">
                    <option value="01"  selected="selected">成人</option>
                </select>
            </div>
        </li>
        <li class="w4">证件：</li>
        <li class="w5">
            <div id="uboxstyle3">
            	<f:select type="证件类型" name="language_sfz1" id="pCertType" showValue="false"></f:select>
            </div>
        </li>
        <li class="w6">
            <input name="input" type="text" class="input2" id="pCertNo" />
        </li>
    </ul>
</div>
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<div class="jd_fy_box margin5">
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy"><span class="black">联系信息</span></li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
</div>
<div class="jp_xx_black Wmargin1 bg_fb lxr1">
    <ul>
    	<li class="w1">姓 名：</li>
        <li class="w2">
            <input name="input4" type="text" class="jdmc" id="cName" value="<%=memberVo.getName()%>"/>
        </li>
        <li class="w3">手 机：</li>
        <li class="w4">
            <input name="input5" type="text" class="jdmc" id="cMobile" value="<%=memberVo.getMobile()%>"/>
        </li>
        <li class="w5">邮 件：</li>
        <li class="w6">
            <input name="input6" type="text" class="input1" id="cEmail" value="<%=memberVo.getEmail()%>" />
        </li>
    </ul>
</div>
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<form action="${ctx}/flight/discountControl.jsp"  method="post" id="threeDiscountForm">
	<input type="hidden" name="flightType" id="flightType">
	<input type="hidden" name="arrivalAirportName" id="arrivalAirportId" />
	<input type="hidden" name="departureAirportName" id="departureAirportId" />
	<input type="hidden" name="departureDateName" id="departureDateId" />
	<input type="hidden" name="reDepartureDateName" id="reDepartureDateId" />
	
	<input type="hidden" name="pName" id="pNameId" />
	<input type="hidden" name="pType" id="pTypeId" />
	<input type="hidden" name="pCertType" id="pCertTypeId" />
	<input type="hidden" name="pCertNo" id="pCertNoId" />
	
	<input type="hidden" name="cName" id="cNameId" />
	<input type="hidden" name="cMobile" id="cMobileId" />
	<input type="hidden" name="cEmail" id="cEmailId" />
</form>
<div class=" Wmargin tijiao_frm1">
 
<%
if(roleCount<=Integer.parseInt(count)){
%>
<a class="ndingp" href="javascript:" onclick="void function(){}">提交申请 >></a>
<%}else{ %>
<a class="dingp" href="javascript:void threeDiscount();">提交申请 >></a>
<%} %>
</div>
<script type="text/javascript">
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
		if(${roleCount}-${count}==1){
			alert("只剩余一次申请机会！");
			$("#danCheng").attr('checked', true); 
			$("#wangFan").attr('checked', false); 
			return;
		}
		$("#wangFan").is(":checked") ? $(".ReturnTime").children().show() : $(".ReturnTime").children().hide();
	});

function threeDiscount(){
	var staDate=$("#departureDate").val();
    var eDate=$("#reDepartureDate").val();
    var starDate=new Date(staDate.split("-").join("/"));
	
	var  flightType = 1;
	if($("#wangFan").attr('checked') == true){
		flightType = 2;
	}	
	if(!$("#originCityTwo").val()||$("#originCityTwo").val() =="中文/拼音"){   
	//if($("#originCityTwo").val()== null || $("#originCityTwo").val() =="" || $("#originCityTwo").val() =="中文/拼音" || $("#originCityTwo").val()== null ||  $("#originCityTwo").val()== '' || $("#originCityTwo").val()== "null"){
        $('#originCityTwo').attr('value','');
        $('#originCityTwo').trigger("click");
        return ;
    }
    if($("#destinationsCityTwo").val()== null || $("#destinationsCityTwo").val() =="" || $("#destinationsCityTwo").val() =="中文/拼音" || $("#destinationsCityTwo").val()== null ||  $("#destinationsCityTwo").val()== '' || $("#destinationsCityTwo").val()== "null"){
        $('#destinationsCityTwo').attr('value','');
        $('#destinationsCityTwo').click();
        return false;
    }
	if($("#departureAirport").val()== $("#arrivalAirport").val()){
        $('#departureAirport').attr('value','');
        $('#departureAirport').click();
        alert("对不起,你的出发地和目的地相同");
        return false;
    }
    if($("#departureDate").val()== null || $("#departureDate").val() == "" ){
        $('#departureDate').attr('value','');
        WdatePicker({el:'departureDate',minDate:'%y-%M-%d'});
        return false;
    }
    if(flightType==2){
    if($("#reDepartureDate").val()== null || $("#reDepartureDate").val() == "" ){
	          $('#reDepartureDate').attr('value','');
	          WdatePicker({el:'reDepartureDate',minDate:$('#departureDate').val()});
	          return false;
	}
	}
    if(eDate!=null && eDate!=""){
    	var endDate=new Date(eDate.split("-").join("/"));
        if(starDate>endDate){
       		alert("返程时间小于出发时间!");
       		return false;
       	}
    }
    
    var messageError=yzData();
	if(""!=messageError){
	 alert(messageError);
	 return;
	}
	var departureAirport = $("#departureAirport").val();
	var arrivalAirport = $("#arrivalAirport").val();
	var departureDate = $("#departureDate").val();
	var reDepartureDate = $("#reDepartureDate").val();
	
	var pName = $("#pName").val();
	var pType = $("#pType").val();
	var pCertType = $("#pCertType").val();
	var pCertNo = $("#pCertNo").val();
	
	var cName = $("#cName").val();
	var cMobile = $("#cMobile").val();
	var cEmail = $("#cEmail").val();
	
	$("#flightType").attr("value",flightType);
	$("#departureAirportId").attr("value",departureAirport);
	$("#arrivalAirportId").attr("value",arrivalAirport);
	$("#departureDateId").attr("value",departureDate);
	$("#reDepartureDateId").attr("value",reDepartureDate);
	$("#pNameId").attr("value",pName);
	$("#pTypeId").attr("value",pType);
	$("#pCertTypeId").attr("value",pCertType);
	$("#pCertNoId").attr("value",pCertNo);
	$("#cNameId").attr("value",cName);
	$("#cMobileId").attr("value",cMobile);
	$("#cEmailId").attr("value",cEmail);
	
	var result=window.confirm("确认要提交申请吗？");
		if(result)
		{
			$("#threeDiscountForm").submit();
		}
	
}
function yzData(){
	var errorMessage="";
	var pName = $("#pName");
	var pCertNo = $("#pCertNo");
	var cName = $("#cName");
	var cMobile = $("#cMobile");
	var pCertType = $("#pCertType").val();
	var regex = regexEnum.idcard;
	var partten = /^[\u4e00-\u9fa5a-zA-Z]*$/;
	
	if(pCertType == 0){
	   regex = regexEnum.idcard;
	}
	else if(pCertType == 1){
       regex = regexEnum.passport;
    }
    else {
       regex =regexEnum.notempty;
    }
	
	if(pName.val()==null || pName.val()==""){
		errorMessage="乘机人姓名不能为空";
		pName.focus();
	}
	else if((validateObj(regexEnum.letter,pName) && pName.val().indexOf("/") <0)
	        	|| (pName.val().indexOf("/") ==0 || pName.val().indexOf("/") == pName.val().length-1)
	        	|| !validateObj(regexEnum.passenger,pName)){
		errorMessage="请输入正确的乘机人姓名，如zhang\/san,张san,张三";
	    pName.focus();
	}
	else if(escape(pName.val()).indexOf("%u")!=-1 && !partten.test(pName.val())){
		errorMessage="乘机人姓名中不能带有特殊字符";
	    pName.focus();
	}
	else if((validateObj(regexEnum.chinese,pName) && pName.val().length>10)
	    	        || (!validateObj(regexEnum.chinese,pName) && pName.val().length>30)){
		errorMessage="您输入的乘机人姓名过长";
	    pName.focus();
	}
	else if(pCertNo.val()=="" || pCertNo.val()==null){
		errorMessage="证件号码为空";
		pCertNo.focus();
	}
	else if(!validateObj(regex,pCertNo)){
      errorMessage="请输入正确的乘机人证件号码";
      pCertNo.focus();
              
  	} 
	else if(cName.val() == null || cName.val() ==""){
		errorMessage="联系人不能为空";
		cName.focus();
	}
	else if((validateObj(regexEnum.letter,cName) && cName.val().indexOf("/") <0)
	        	|| (cName.val().indexOf("/") ==0 || cName.val().indexOf("/") == cName.val().length-1)
	        	|| !validateObj(regexEnum.passenger,cName)){
		errorMessage="请输入正确的联系人姓名，如zhang\/san,张san,张三";
	    cName.focus();
	}
	else if(escape(cName.val()).indexOf("%u")!=-1 && !partten.test(cName.val())){
		errorMessage="联系人姓名中不能带有特殊字符";
	    cName.focus();
	}
	else if((validateObj(regexEnum.chinese,cName) && cName.val().length>10)
	    	        || (!validateObj(regexEnum.chinese,cName) && cName.val().length>30)){
		errorMessage="您输入的联系人姓名过长";
	    cName.focus();
	}
	else if(cMobile.val() == null || cMobile.val() == ""){
		errorMessage="联系方式不能为空";
		cMobile.focus();
	}
	else if(!validate(regexEnum.mobile,"cMobile")){
        errorMessage = "联系人手机号格式错误！";
        cMobile.focus();
    }
    
    
    
    return errorMessage;
}

				// 取当前时间毫秒数 
var nowTime = Date.parse(new Date());

// 更新离开日期
function checkWhenBack() {
	var checkInDate = document.getElementById("departureDate").value;
	var checkOutDate = document.getElementById("reDepartureDate").value;
	var checkInTime = new Date(checkInDate.split("-").join("/"));
	nowTime = Date.parse(checkInTime);
	var nextdate = getFormatDate(24 * 60 * 60 * 1000);
	var start = new Date(nextdate.replace(/\-/g, "\/"));
    var end = new Date(document.getElementById("reDepartureDate").value.replace(/\-/g, "\/"));
    if (start > end) {
	    document.getElementById("reDepartureDate").value = nextdate;
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
