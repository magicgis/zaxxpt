<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
    <head>
    <title>高尔夫球场预订 - ${domain_cn }</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/web/js/clubJs/tag.js" language="javascript" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
    <script>var cityArea="province";</script>
    <script>var cityDirectory="../";</script>    
	<script type="text/javascript" src="${ctx}/web/js/city/province.js"></script>
	<script type="text/javascript" src="${ctx}/web/js/city/allCity.js"></script>
	<link type="text/css" rel="stylesheet" href="${ctx}/web/js/city/style/city.css"/>
	<script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
	<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script>
    <script type=text/javascript>

	//初始化时,异步加载天气预报
    $(function (){
    	loadWeatherAjax("#tq_box","010","","H","H");
    });
    
    function submitForm(){
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
			//您未选日期
    		return;
    	}
    	var province=$("#province").val();
    	if(province==""){
    		$("#provinceNameId").val("");
    		  if(document.all){//IE
   			   document.getElementById("provinceNameId").click();
   			  }
   		   else{//其他
   			     var evt = document.createEvent("MouseEvents");    
   	    	     evt.initEvent("click", true, true);    
   	        	 document.getElementById("provinceNameId").dispatchEvent(evt);  
   			 }
    		return;
    	}
    	var provinceNameId=$("#provinceNameId").val();
    	if(provinceNameId=="中文/拼音"||provinceNameId==""){
    		$("#provinceNameId").val("");
    		 if(document.all){//IE
     			   document.getElementById("provinceNameId").click();
     			  }
     		   else{//其他
     			     var evt = document.createEvent("MouseEvents");    
     	    	     evt.initEvent("click", true, true);    
     	        	 document.getElementById("provinceNameId").dispatchEvent(evt);  
     			 }
    		return;
    	}
    	var productNames=$("#productNames").val();
    	for(var i=0;i<1;i--){
        	if(productNames.indexOf('<')>=0||productNames.indexOf('>')>=0||productNames.indexOf('"')>=0||productNames.indexOf("'")>=0||productNames.indexOf('(')>=0||productNames.indexOf(")")>=0||productNames.indexOf('/')>=0){	
				productNames=productNames.replace("<","");
				productNames=productNames.replace(">","");
				productNames=productNames.replace('"',"");
				productNames=productNames.replace("'","");
				productNames=productNames.replace("(","");
				productNames=productNames.replace(")","");
				productNames=productNames.replace("/","");
        	}else{
				break;
        	}
    	}
    	$("#productName").val(productNames);
		
            $("#controlColor").attr("disabled",true);	//栾晓东,按钮置灰。
 	        $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -38px");
    	
     	$("#myform").attr("action","${ctx}/golf/search.jsp");
    	$("#myform").submit();
    }
    </script>
    </head>
    <body>
<div class="senav">
        <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx}/index.jsp" class="se">首页</a> &gt;&nbsp; <span class="se">高尔夫首页</span></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
    </div>
<div class="clear"></div>
<div class="search">

<form action="" method="post" id="myform">
        <div class="search_left">
        <div class="searchform_frm">
                <div class="left_txt w1">省份：</div>
                <div class="r_form w2">
                <DIV class="inb">
	                	<input type="hidden" name="city" id="province"/>
						<input type="text" name="provinceName" id="provinceNameId" class="inps"
						onfocus="showSearch(this)" onblur="showSearch(this,1)"
						value="中文/拼音" style="color:#C1C1C1"
						onclick="suggest.display(this,'province',event)"
						onkeyup="suggest.display(this,'province',event)" value="<p:write key=''></p:write>"/>
						<%--
						<img class="set_city" src="${ctx}/web/images/tra1.jpg" width="16" height="16"  onclick="setFillObj('departureAirport','departureAirportId',this.parentNode,1,'city','airport')" style="float: none"/>
						 --%>
                </DIV>
            </div>
                <div class="left_txt w3">下场日期：</div>
                <div class="r_form w4">
                <DIV class=inb>
                		<%--
                        <INPUT id="plainDate1" readonly="readonly" class="inps" onfocus="return Calendar('plainDate1','true');" type="text" name="bookTime">
                        <A class="set_date" href="javascript:Calendar('plainDate1','true');"></A>
                		 --%>
                        
                          <input id="plainDate1" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})" value="${bookTime}" name="bookTime"/>
                        </DIV>
            </div>
                <div class="left_txt w5">球场类型：</div>
                <div class="r_form w6">
                    <div id="uboxstyle">
                    		 <f:select id="language" name="golfType" type="球场类型" blank="true" showValue="false" value="${golfType}"/>
                    </div>
                </div>
                <div class="left_txt w1">球场名称：</div>
                <div class="r_form w6 wide">
                <div id="uboxstyle">
                    <input type="text" class="jdmc" id="productNames">
                    <input type="hidden" name="name" id="productName">
                </div>
            </div>
                <div class="btn"><input id="controlColor" class="submitBTN" type="button" onclick="submitForm()"/></div>
                <div class="clear"></div>
            </div>
    </div>
</form> 
    <div class="tq_box" id="tq_box">
        <%-- 
        <div class="tq_title1">北京天气</div>
        <div class="tq_img">
                <ul>
                <li class="home_tqli1"><b class="home_tabay">今天(周一)</b><img src="${ctx}/web/images/tq.jpg" /><A href="####">1℃/12℃</A><span>转晴</span></li>
                <li><span class="home_tabay">明天(周二)</span><img src="${ctx}/web/images/tq.jpg" /><A href="####">1℃/12℃</A><span>转晴</span></li>
            </ul>
            </div>
    	</div>
    	--%>
    </div>
    </div>
	<div class="clear"></div>
	<div id="jcbottom">
        <div class="jc_content">
        	<%@include file="/web/html/golf/index_center.jsp" %>
        </div>
        <div class="jc_right1"> <img src="${ctx}/web/images/right1.jpg" /> </div>
        <div class="clear"></div>
    </div>
        <div class="clear"></div>
        
    <script type="text/javascript">
	$(function(){
	    $("li.jc_tag1").mouseover(function(){
	        $(this).children("a").attr("class","jc_ta1").parent().siblings("li").children("a").attr("class","jc_ta2")
	        var s = $("li.jc_tag1").length;
	        var index = $("li.jc_tag1").index(this);
	        $(".tag_right_boz >div").eq(index).show().siblings().hide();
	    });
	    $("#searchBtn").click(function(){
	    submitForm();
	    return false;
	    });
	    // IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
	    if(!-[1,]&&!window.XMLHttpRequest){
			$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	    }
	});
	</script>
</body>
<script src="${ctx}/web/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
