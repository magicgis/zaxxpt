<%@ page pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@ include file="/common/include/tags-lib.jsp"%>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}/web/js/paging.js" ></script>
		<script type="text/javascript">var CTX='${ctx}';</script>
		    <script type="text/javascript" src="${ctx}/web/js/city/allAirport.js" ></script><!-- 用了 -->
		       <script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->
		       
		<script type="text/javascript" src="${ctx}/web/js/clubJs/tag.js" language="javascript"></script>
		<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
		<script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
<script type="text/javascript">
//加载天气预报,首页加载北京
$(function (){
	loadWeatherAjax("#tq_box","010","","H","H");
});

function submitSearch()
{
	var jichang=$("#departureAirportId").val();
	if(jichang=="null" ||jichang==""||jichang.length<3){
		$("#departureAirport").val("");
		//$("#departureAirport").click();//您未选择机场！
		//alert("请选择机场");.不需要alert了 
		   if(document.all){//IE
			   document.getElementById("departureAirport").click();
			  }
		   else{//其他
			     var evt = document.createEvent("MouseEvents");    
	    	     evt.initEvent("click", true, true);    
	        	 document.getElementById("departureAirport").dispatchEvent(evt);  
			 }
		return;
	}
	var dateStr=$("#plainDate1").val();
	if(dateStr.length<6){
		   if(document.all){//IE
			   document.getElementById("plainDate1").click();
			  }
		   else{//其他
			     var evt = document.createEvent("MouseEvents");    
	    	     evt.initEvent("click", true, true);    
	        	 document.getElementById("plainDate1").dispatchEvent(evt);  
			 }
		//$("#plainDate1").click();//您未选择日期！
		return;
	}
    
	var selected_airport=$(".inps").val();
	for(var i=0;i<commonAirport.length;i++)
	{
		if(selected_airport==commonAirport[i][2])
		{
			document.getElementById("cityorap").value="yes";
			break;
		}
		else
		{
			document.getElementById("cityorap").value="no";
		}
	}
	
	        $("#controlColor").attr("disabled",true);	//栾晓东,按钮置灰。
 	        $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -38px");
	
	$("#myform").attr("action","${ctx}/loungeHome!search.action?flagday="+"3");
	$("#myform").submit();
}
</script>
<title>机场休息室球场预订 - ${domain_cn }</title>
</head>
<body>
<form action="" method="post" id="myform">
<div class="senav">
  <ul>
    <li><img src="${ctx}/web/images/seleft.jpg" /></li>
    <li class="sebj"><a href="${ctx}/index.jsp" class="se">首页</a> &gt;&nbsp; <span class="se">机场休息室首页</span></li>
    <li><img src="${ctx}/web/images/seright.jpg" /></li>
  </ul>
</div>
<div class="search">
  <div class="search_left">
    <div class="searchform_frm">
      <div class="left_txt w1">机场：</div>
      <div class="r_form w2">
        <DIV class="inb">
          					<input name="airport" type="hidden" id="departureAirportId" />
                            <input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="departureAirport" name="departureAirport" onblur="blurEvt(this)"
            				value="中文/拼音" style="color:#C1C1C1" onclick="suggest_Flight.display(this,'departureAirportId',event)"
           					 onkeyup="suggest_Flight.display(this,'departureAirportId',event)"/>
		          			<img class="set_city" src="${ctx}/web/images/tra1.jpg" width="16" height="16"  onclick="showSearch_Flight(document.getElementById('departureAirport')),suggest_Flight.display(document.getElementById('departureAirport'),'departureAirportId',event)" style="float: none"/>
          
          </DIV>
      </div>
      <div class="left_txt w3">预定日期：</div>
      <div class="r_form w4">
        <div class="inb">
        <%--
          <input id="plainDate1" class="inps" onfocus="return Calendar('plainDate1','true');" type="text" name="bookTime" />
          <a class="set_date" href="javascript:Calendar('plainDate1','true');"></a>
         --%>
          <input id="plainDate1" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})" value="${bookTime}" name="bookTime"/>
         </div>
      </div>
      <div class="left_txt w1">休息室名称：</div>
      <div class="r_form w6">
        <div id="uboxstyle">
          <input name="loungeName" type="text" class="jdmc left" />
          <input name="cityorap" type="hidden" id="cityorap" />
        </div>
      </div>
      <div class="left_txt w1">休息室类型：</div>
      <div class="r_form w2">
        <div id="macstyle">
        	<f:select name="loungeType" type="休息室类型" blank="true" showValue="false" value="${loungeType}"/>
			<%--
                   <select name="loungeType" id="language_mac">
                   		<option value="">不限...</option>
                        <option value="1"  ${(golfType=='1')?'selected':'' }>贵宾间</option>
                        <option value="2" ${(golfType=='2')?'selected':'' }>贵宾厅</option>
                        <option value="3" ${(golfType=='3')?'selected':'' }>两舱休息室</option>
                   </select>
			--%>
        </div>
      </div>
      <div class="btn"><input id="controlColor" class="submitBTN" type="button" onclick="submitSearch()"/></div>
    </div>
  </div>
  <div class="tq_box" id="tq_box">
    <%--
    	String weatherCode = "";
    	String returnWeatherCode = "";
    	String weatherType = "H";
    --%>
    <%--@include file="/common/include/weatherControl.jsp" --%>
  	<%-- 
    <div class="tq_title1">北京天气</div>
    <div class="tq_img">
      <ul>
        <li class="home_tqli1"><b class="home_tabay">今天(周一)</b><img src="${ctx}/web/images/tq.jpg" /><A href="####">1℃/12℃</A><span>转晴</span></li>
        <li><span class="home_tabay">明天(周二)</span><img src="${ctx}/web/images/tq.jpg" /><A href="####">1℃/12℃</A><span>转晴</span></li>
      </ul>
    </div>
    --%>
  </div>
</div>
<div id="jcbottom">
  <div class="jc_content">
  	<%@include file="/web/html/lounge/index_content.jsp" %>
  </div>
</div>
</form>
<script type="text/javascript">
	$(function(){
	    // IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
	    if(!-[1,]&&!window.XMLHttpRequest){
			$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	    }
	});
	
</script>
</body>

