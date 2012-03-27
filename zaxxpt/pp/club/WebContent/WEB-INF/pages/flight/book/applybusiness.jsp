<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
    <%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>

<%@page import="com.hnatourism.club.common.util.UserUtil"%><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
    <script type="text/javascript" src="${ctx}/web/js/city/allAirport.js"></script>
    <script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidator_min.js" defer="defer"></script>
	<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidatorRegex.js"></script>
	<script type="text/javascript" src="${ctx}/web/js/formValidator3.3/formValidator_helper.js"></script>
	<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->

    <script type="text/javascript" src="${ctx}/web/js/city/allAirport.js"></script>
    <title>公务机申请- ${domain_cn }</title>
    </head>
<%
MemberInfoVo memberVo=UserUtil.getUser(request.getSession().getId());
request.setAttribute("memberVo",memberVo);
%>
    <body>
<div class="jc_content">
        <div class="jc_left h670"> 
        <!---->
        <div class="module_a business businessApply">
                <div class="title"><span class="l"></span><span class="c">
                    <h3> <b class="orange">BUSINESS JET</b>公务机申请</h3>
                    </span><span class="r"></span></div>
                <div class="inner clearfix_ ">
                <ul class="Tickets70off" name="wish">
                        <li class="point">我们为您打造专享公务机服务！<br />请您填写申请信息，我们的客服人员会在第一时间通知您申请结果，<br />如有疑问，请拨打<em class="orange"> 400-88-51666 </em>进行咨询！</li>
                        <li><span class="left">企业名称：</span><span class="left ">
                            <input type="text" class="input5" name="company" id="companyId">
                            </span></li>
                        <li><span class="left">&nbsp;联&nbsp;系&nbsp;人：</span><span class="left ">
                            <input type="text" class="jdmc" name="name" id="nameId">
                            </span><span class="left L1em">联系电话：</span><span class="left ">
                            <input type="text" class="jdmc" name="contact" maxlength="11" id="contactId">
                            </span></li>
                        <li><span class="left">包机人数：</span><span class="left ">
                            <input type="text" class="jdmc" name="totalNumber" id="totalNumberId">
                            </span><span class="left L1em">包机时间：</span><span class="left ">
                            
                            <div class="inb">
                            <input id="plainDate3"  class="inps" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})"  name="startTime"/>
                        	<a class="set_date" href="javascript:WdatePicker({el:'plainDate3',minDate:'%y-%M-%d'});"></a></div>
                            
                            
                            </span></li>
                        <li><span class="left">出发城市：</span> <span class="left">
                            <div class="inb">
                            <input name="originCity" type="hidden" id="originCityOne" value="" />             
            				<input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="originCityTwo" name="departureAirport" onblur="blurEvt(this)"
           					value="中文/拼音" style="color:#C1C1C1"
            				onclick="suggest_Flight.display(this,'originCityOne',event)"
            				onkeyup="suggest_Flight.display(this,'originCityOne',event)"
            				value="<ap:write key="" isDisplayCity="true"></ap:write>" />
            				<img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('originCityTwo','originCityOne',this,1,'city','airport')" />
                            </div>
                            </span> <span class="left L1em">到达城市：</span> <span class="left">
                            <div class="inb">
                            <input name="destinationsCity" type="hidden" id="destinationsCityOne" value="" />             
            				<input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="destinationsCityTwo" name="arrivalAirport" onblur="blurEvt(this)"
           					value="中文/拼音" style="color:#C1C1C1"
            				onclick="suggest_Flight.display(this,'destinationsCityOne',event)"
            				onkeyup="suggest_Flight.display(this,'destinationsCityOne',event)"
            				value="<ap:write key="" isDisplayCity="true"></ap:write>" />
            				<img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('destinationsCityTwo','destinationsCityOne',this,1,'city','airport')" />    
                            </div>
                            </span> </li>
                        <li class="textareaBox clearfix_"><span class="left">其他要求：</span><span class="left ">
                            <textarea name="groupDesire" cols="" rows="4"></textarea>
                            </span></li>
                        <li><a href="javascript:void(0);addWish()"  class="business_btn">提交公务机申请</a></li>
                    </ul>
                    <%
                    String judge = "";
                    String isLoad = request.getParameter("isLoadName");
                    if("yes".equals(isLoad)){
                    %>
                    <%@include file="/flight/flightGroupControl.jsp" %>    
                    <%} %>
                    <form action="${ctx}/flight/applybusiness.jsp" id="addWishForm" method="post">
                    	<input type="hidden" name="nameName" id="nameIn" />
                    	<input type="hidden" name="contactName" id="contactIn" />
                    	<input type="hidden" name="totalNumberName" id="totalNumberIn" />
                    	<input type="hidden" name="originCityName" id="originCityIn" />
                    	<input type="hidden" name="destinationsCityName" id="destinationsCityIn" />
                    	<input type="hidden" name="startTimeName" id="startTimeIn" />
                    	<input type="hidden" name="groupDesireName" id="groupDesireIn" />
                    	<input type="hidden" name="isLoadName" id="isLoadId" value="yes"/>
                    </form>
            </div>
                <b class="bl"></b> <b class="br"></b> </div>
        <!----> 
    </div>
        <!--w-->
        <div class="tq_box1 marginT5">
        <div class="tq_img1">
                <div class="tq_title">北京</div>
                <ul>
                <li class="tqli1"><span class="today">今天</span><img src="${ctx}/web/images/tq.jpg"><a href="#">1℃/12℃</a><span>转晴</span></li>
                <li><span class="today">今天</span><img src="${ctx}/web/images/tq.jpg"><a href="#">1℃/12℃</a><span>转晴</span></li>
            </ul>
            </div>
        <div class="tq_img2">
                <div class="tq_title">天津</div>
                <ul>
                <li class="tqli1"><span class="today">前天</span><img src="${ctx}/web/images/tq.jpg"><a href="#">12℃/12℃</a><span>转晴</span></li>
                <li><span class="today">今天</span><img src="${ctx}/web/images/tq.jpg"><a href="#">1℃/12℃</a><span>转晴</span></li>
            </ul>
            </div>
    </div>
        <!--w end-->
        <div class="jc_right1"> <img src="${ctx}/web/images/right1.jpg"> </div>
        <div class="clear"></div>
    </div>
<div class="clear"></div>

<script type="text/javascript">
$(function(){
	// 特价机票Tag
    $("li.jc_tag1").mouseover(function(){
        $(this).children("a").attr("class","jc_ta1").parent().siblings("li").children("a").attr("class","jc_ta2")
        var s = $("li.jc_tag1").length;
        var index = $("li.jc_tag1").index(this);
        $(".tag_right_boz >div").eq(s-index-1).show().siblings().hide();
    });
	
	// 单程&往返radio
	$("#danCheng").attr('checked', true); 
	$("#wangFan").attr('checked', false); 
	$(".ReturnTime").children().hide();
	$("#wangFan,#danCheng").click(function(){
		$("#wangFan").is(":checked") ? $(".ReturnTime").children().show() : $(".ReturnTime").children().hide();
	});
});
function addWish(){
	var messageError=yzData();
	if(""!=messageError){
	 alert(messageError);
	 return;
	}
	
	else if($("#plainDate3").val()== null || $("#plainDate3").val() == "" ){
        $('#plainDate3').attr('value','');
        WdatePicker({el:'plainDate3',minDate:'%y-%M-%d'});
        return false;
    }
	else if($("#originCityTwo").val()== null || $("#originCityTwo").val() =="" || $("#originCityTwo").val() =="中文/拼音" || $("#originCityTwo").val()== null ||  $("#originCityTwo").val()== '' || $("#originCityTwo").val()== "null"){
        $('#originCityTwo').attr('value','');
        $('#originCityTwo').click();
        return false;
    }
    else if($("#destinationsCityTwo").val()== null || $("#destinationsCityTwo").val() =="" || $("#destinationsCityTwo").val() =="中文/拼音" || $("#destinationsCityTwo").val()== null ||  $("#destinationsCityTwo").val()== '' || $("#destinationsCityTwo").val()== "null"){
        $('#destinationsCityTwo').attr('value','');
        $('#destinationsCityTwo').click();
        return false;
    }
	else if($("#originCityOne").val()== $("#destinationsCityOne").val()){
        $('#originCityOne').attr('value','');
        $('#originCityOne').click();
        alert("对不起,你的出发地和目的地相同");
        return false;
    }
	
	var company=$("ul[name='wish']").find("input[name='company']").val();
	var name=$("ul[name='wish']").find("input[name='name']").val();
	var contact=$("ul[name='wish']").find("input[name='contact']").val();
	var totalNumber=$("ul[name='wish']").find("input[name='totalNumber']").val();
	var originCity=$("ul[name='wish']").find("input[name='originCity']").val();
	var destinationsCity=$("ul[name='wish']").find("input[name='destinationsCity']").val();
	var startTime=$("ul[name='wish']").find("input[name='startTime']").val();
	var groupDesire=$("ul[name='wish']").find("textarea[name='groupDesire']").val();
	
	$("#nameIn").attr("value",name);
	$("#contactIn").attr("value",contact);
	$("#totalNumberIn").attr("value",totalNumber);
	$("#originCityIn").attr("value",originCity);
	$("#destinationsCityIn").attr("value",destinationsCity);
	$("#startTimeIn").attr("value",startTime);
	$("#groupDesireIn").attr("value",company+"/"+groupDesire);
	
	$("#addWishForm").submit();
}

function yzData(){
	var errorMessage="";
	var name = $("#nameId");
	var contact = $("#contactId");
	var partten = /^[\u4e00-\u9fa5a-zA-Z]*$/;
	if($("#companyId").val()==null || $("#companyId").val()==""){
		errorMessage="企业名称不能为空";
		$("#companyId").focus();
	}
	else if(name.val() == null || name.val() ==""){
		errorMessage="联系人不能为空";
		name.focus();
	}
	else if((validateObj(regexEnum.letter,name) && name.val().indexOf("/") <0)
	        	|| (name.val().indexOf("/") ==0 || name.val().indexOf("/") == name.val().length-1)
	        	|| !validateObj(regexEnum.passenger,name)){
		errorMessage="请输入正确的联系人姓名，如zhang\/san,张san,张三";
	    name.focus();
	}
	else if(escape(name.val()).indexOf("%u")!=-1 && !partten.test(name.val())){
		errorMessage="姓名中不能带有特殊字符";
	    name.focus();
	}
	else if((validateObj(regexEnum.chinese,name) && name.val().length>10)
	    	        || (!validateObj(regexEnum.chinese,name) && name.val().length>30)){
		errorMessage="您输入的联系人姓名过长";
	    name.focus();
	}
	else if(contact.val() == null || contact.val() == ""){
		errorMessage="联系方式不能";
		contact.focus();
	}
	else if(!validate(regexEnum.mobile,"contactId")){
        errorMessage = "联系人手机号格式错误！";
        contact.focus();
    }
    else if($("#totalNumberId").val() == null || $("#totalNumberId").val() == ""){
    	errorMessage = "包机人数为空";
    	$("#totalNumberId").focus();
    }
    
    
    return errorMessage;
}
<%
	if("right".equals(judge)){
%>
alert("公务机申请成功，请您耐心等候");
window.location="${ctx}/flight/applybusiness.jsp";
<%
	}
	if("error".equals(judge)){
%>
alert("公务机申请失败！");
<%}%>
</script>
</body>
