<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<script type="text/javascript">
function submitForm(){
   	var cityStr=$("#cityCode").val();
   	var city=$("#city");
   	if(!cityStr||city.val()=="中文/拼音"||!city.val()){
   		city.val("");
   		//city.click();//城市不能为空。
   		document.getElementById("city").click();
   		return;
   	}
   	var time1=$("#plainDate1");
   	if($("#plainDate1").val()==""){
   		showCalendar(1);
   		return;
   	}
   	var time2=$("#plainDate2");
   	if($("#plainDate2").val()==""){
   		showCalendar(2);
   		return;
   	}
   		    $("#controlColor").attr("disabled",true);	//栾晓东,按钮置灰。
 	        $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -38px");
   	$("#myform").submit();
}
</script>
<form  method="post" id="myform" action="${ctx}/hotel/search.jsp">
<div class="search">
        <div class="search_left">
        <div class="searchform_frm">
                <div class="left_txt w1">城市：</div>
                <div class="r_form w2">
               <div class="inb">
 				   <input type="hidden" name="hotelQueryVo.city" id="cityCode" value="${hotelQueryVo.city}" />
	               <input 
	                   type="text" 
	                   class="inps"
	                   autoComplete="off" 
	                   onfocus="showSearch(this)" 
	                   id="city"
	                   onblur="blurEvt(this);" 
	                   onclick="suggest.display(this,'cityCode',event)"
	                   onkeyup="suggest.display(this,'cityCode',event)"
	                   value='<s:if test="hotelQueryVo.city!=null"><p:write key="${hotelQueryVo.city }"/></s:if><s:else>中文/拼音</s:else>'
	                   />
		          <img class="set_city" src="${ctx}/web/images/tra1.jpg" width="16" height="16"  onclick="setFillObj('departureAirport','departureAirportId',this.parentNode,1,'city','airport')" style="float: none"/>
                </div>
            </div>
                <div class="left_txt w3">酒店名称：</div>
                <div class="r_form w4">
                <input name="hotelQueryVo.qword" type="text" class="jdmc" value="${hotelQueryVo.qword}"/>
            </div>
                <div class="left_txt w5">酒店星级：</div>
                <div class="r_form w6">
                <div id="uboxstyle">
					<select id="star"  name="hotelQueryVo.filterStar" style="display: none;">
						<option value="">请选择</option>
						<option 
						<c:if test="${hotelQueryVo.filterStar eq '3,3.5'}">selected="selected"</c:if> 
						value="3,3.5" >三星级</option>
						<option 
						<c:if test="${hotelQueryVo.filterStar eq '4,4.5'}">selected="selected"</c:if>
						value="4,4.5">四星级</option>
						<option 
						<c:if test="${hotelQueryVo.filterStar eq '5'}">selected="selected"</c:if>
						value="5" >五星级</option>
						<option 
						<c:if test="${hotelQueryVo.filterStar eq '1,1.5,2,2.5'}">selected="selected"</c:if>
						value="1,1.5,2,2.5">二星以下</option>						
					</select>                
                </div>
            </div>
                <div class="left_txt w1">入住时间：</div>
                <div class="r_form w2">
                <div class=inb>
	                <input id="plainDate1" class="inps" type="text" 
                	onfocus="WdatePicker({maxDate:'#F{\'2020-01-01\'}',minDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd'})"  
                	onchange="reComputeTime()"
                	name="hotelQueryVo.idate"
                	value="${hotelQueryVo.idate}"/>
	                <a class="set_date" href="javascript:void showCalendar(1);"></a>
                </div>
            </div>
                <div class="left_txt w3">离店时间：</div>
                <div class="r_form w4">
                <div id="labPlain2" class="inb">
	                <input id="plainDate2" class="inps" type="text" 
	                onfocus="WdatePicker({minDate:'#F{$dp.$D(\'plainDate1\',{d:1})||\'%y-%M-%d\'}',maxDate:'2020-01-01',dateFmt:'yyyy-MM-dd'})"  
	                name="hotelQueryVo.odate" value="${hotelQueryVo.odate}"/>
	                <a class="set_date" href="javascript:void showCalendar(2);"></a>
                </div>
            </div>
                <div class="left_txt w5">价格范围：</div>
            <div class="r_form w6">
	            <div id="uboxstyle">
					<select id="price" name="hotelQueryVo.filterPrice" style="display: none;">
						<option value="">请选择</option>
						<option 
						<c:if test="${hotelQueryVo.filterPrice eq '200,400'}">selected="selected"</c:if> 
						value="200,400" >200-400</option>
						<option 
						<c:if test="${hotelQueryVo.filterPrice eq '400,600'}">selected="selected"</c:if>
						value="400,600">400-600</option>
						<option 
						<c:if test="${hotelQueryVo.filterPrice eq '600,99999'}">selected="selected"</c:if>
						value="600,99999" >600以上</option>
						<option 
						<c:if test="${hotelQueryVo.filterPrice eq '0,200'}">selected="selected"</c:if>
						value="0,200">200以下</option>
					</select>
	            </div>
            </div>
            <div class="btn"><input id="controlColor" class="submitBTN" type="button" onclick="submitForm()"/></div>
            </div>
    </div>
    <div class="tq_box" id="tq_box">
    </div>
    </div>
</form>
<script type="text/javascript">

//+---------------------------------------------------  
//| 日期计算  
//+---------------------------------------------------  
Date.prototype.DateAdd = function(strInterval, Number) {
    var dtTmp = this;
    switch (strInterval) {
        case 's' :return new Date(Date.parse(dtTmp) + (1000 * Number));
        case 'n' :return new Date(Date.parse(dtTmp) + (60000 * Number));
        case 'h' :return new Date(Date.parse(dtTmp) + (3600000 * Number));
        case 'd' :return new Date(Date.parse(dtTmp) + (86400000 * Number));
        case 'w' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
        case 'q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());  
        case 'm' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());  
        case 'y' :return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());  
    }
}
//补0，不足两位补足两位
function fillZero(str){
	var str1 = "";
	str1 +=str;
	if(str1.length == 1){
		return "0"+str1;
	}else{
		return str1;
	}
}


//初始化日期
var myDate = new Date();
var newDate = myDate.DateAdd('d',1);
var newDate2 = myDate.DateAdd('d',2);
var dateStr1 = newDate.getFullYear()+"-"+fillZero(newDate.getMonth()+1)+"-"+fillZero(newDate.getDate());
var dateStr2 = newDate2.getFullYear()+"-"+fillZero(newDate2.getMonth()+1)+"-"+fillZero(newDate2.getDate());
//跳转详细页面
function redDetail(hotelcode){
	var time1=$("#plainDate1").val();
    if(!time1){
    	time1 = dateStr1;
    }
    var time2=$("#plainDate2").val();
    if(!time2){
      	time2 = dateStr2;
    }
    var url="${ctx}/hotel/view.jsp?";
    url+="hotelDetailsQueryVo.hotelCode="+hotelcode+"&hotelDetailsQueryVo.idate="+time1+"&hotelDetailsQueryVo.odate="+time2;
	window.location.href=url;
}

/**
 * 重新计算时间已达到入住时间和离店时间,自动调整的功能
 * author lixun
 * createDate 2011-9-20
 */
function reComputeTime(){
	var time1=$("#plainDate1").val();
    var time2=$("#plainDate2").val();
	if(time2){
	    var idate=dateStrToTime(time1);
	    var odate=dateStrToTime(time2);
	    //86400000   一天的毫秒数
	    if(odate-idate<86400000){
	    	odate=idate+86400000;
	    }
	    $("#plainDate2").val(dateTimeToStr(odate,"-"));
	}else {
		var idate=dateStrToTime(time1);
		idate+=86400000;
		$("#plainDate2").val(dateTimeToStr(idate,"-"));
	}
}

//string 转date对象
function dateStrToDate(dateStr){
	var str=dateStr;
	return new Date(str.replace(/-/g,"/"));
}

//yyyy-mm-dd类型的时间字符串转化为1970-01-01 00:00 到现在的毫秒
function dateStrToTime(dateStr){
	var str=dateStr;
   	var date = dateStrToDate(dateStr);
	return date.getTime();
}
//毫秒转日期字符串
function dateTimeToStr(time,separator){
	var dateTemp=new Date();
	dateTemp.setTime(time);
	var strTemp="";
	strTemp+=dateTemp.getFullYear();
	strTemp+=separator;
	strTemp+=fillZero(dateTemp.getMonth()-(-1));
	strTemp+=separator;
	strTemp+=fillZero(dateTemp.getDate());
	return strTemp;
}
//获取1970-01-01 00:00 到现在的毫秒
function getCurrentTime(){
	return new Date().getTime();
}
function showCalendar(dateType){
	switch(dateType)
   {
   case 1:
	 document.getElementById("plainDate1").focus();
     break
   case 2:
	 document.getElementById("plainDate2").focus();
     break
   }
}
</script>