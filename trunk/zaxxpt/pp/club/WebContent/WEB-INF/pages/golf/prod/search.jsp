﻿<%@ page pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="java.util.List"%>
<%@ include file="/common/include/tags-lib.jsp"%>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" /> 
    <link href="${ctx}/web/css/paging.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/web/js/paging.js" ></script>
     <script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script>
     <script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
    
    <style type="text/css">
	#productName {
		margin-top : auto;
		margin-right : auto;
		margin-bottom :auto;
		margin-left : auto;
		float : left;
	}
</style>

    <script language="javascript" type="text/javascript">
	//初始化时,异步加载天气预报,高尔夫只加载北京天气                                                wenz 2011-11-28 如果下场日期等于当前日期则后一天置灰
    $(function (){
    	loadWeatherAjax("#tq_box","010","","H","H");
    	var now = new Date(); 
    	var months=now.getMonth()+1;
    	var nowDate=now.getYear()+"-"+months+"-"+now.getDate();
    	var bookDate="${bookTime}"
        if(nowDate==bookDate){
            document.getElementById("navx1").disabled=true;
            }

    });
    
/*机场休息厅查询*/
function before(){
	$("#myform").attr("action","${ctx}/golf/search.jsp?flagday="+"1");
	$("#controlColor").attr("disabled",true);	//wenz,按钮置灰。
     $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -38px");
	$("#myform").submit();
	
}
function after(){
	$("#myform").attr("action","${ctx}/golf/search.jsp?flagday="+"0");
	$("#controlColor").attr("disabled",true);	//wenz,按钮置灰。
     $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -38px");
	$("#myform").submit();
}
function doClickx(o){
	var dateStr=$("#plainDate1").val();
	if(dateStr.length<6){
		$("#plainDate1").click();//您未选日期
		return;
	}

	
	
	o.className="day1";
	var j;
	var id;
	var e;
	for(var i=1;i<=2;i++){
		id ="navx"+i;
		j = document.getElementById(id);
		e = document.getElementById("searx"+i);
		//alert(e);
		if(id != o.id){
			//if(e!=null&&j!=null){  wenz 取消显示或隐藏
			//	j.className="day2";
			
			//	e.style.display = "none";
		//	}	
//--------------------------------------------------------------------
			after();
			return;   //wenz 2011-11-25 调用完方法后跳出循环  否则则再次循环调用方法
//-------------------------------------------------------------------------------------------
			
		}else{
		//if(e!=null){   wenz 取消显示或隐藏
			//	e.style.display = "block";
	//		}	 
//--------------------------------------------------------------------
			before();
			return; //wenz 2011-11-25 调用完方法后跳出循环  否则则再次循环调用方法
//-------------------------------------------------------------------------------------------
		}
	}
}
</script>
    <script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
    <script src="${ctx}/web/js/clubJs/11.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/web/js/clubJs/travel.js" language="javascript" type="text/javascript"></script>
    <link type="text/css" rel="stylesheet" href="${ctx}/web/js/city/style/city.css"><link>
    <script>var cityArea="province";</script>
    <script>var cityDirectory="../";</script>
	<script type="text/javascript" src="${ctx}/web/js/city/province.js"></script>
	<script type="text/javascript" src="${ctx}/web/js/city/allCity.js"></script>
    <SCRIPT type=text/javascript>
        var citySelect = new CitySelectWindow('cityselected');
        function setSearch(n) { var menu = document.getElementById("sea_nav").getElementsByTagName("li"); var showdiv = document.getElementById("sea_box").getElementsByTagName("li"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
        function setList(m, n) { var menu = document.getElementById("tab" + m).getElementsByTagName("li"); var showdiv = document.getElementById("tablist" + m).getElementsByTagName("div"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
    </SCRIPT>
    <SCRIPT type=text/javascript>
        function submitSearch()
        {
        	var province=$("#province").val();
        	if(province==""){
        		$("#provinceNameId").val("");
        		$("#provinceNameId").click();//您未选省市
        		return;
        	}
        	var provinceNameId=$("#provinceNameId").val();
        	if(provinceNameId=="中文/拼音"){
        		$("#provinceNameId").val("");
        		$("#provinceNameId").click();//您未选省市
        		return;
        	}
        	var dateStr=$("#plainDate1").val();
        	if(dateStr.length<6){
        	
        		$("#plainDate1").click();//您未选日期
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
			
        	$("#myform").attr("action","${ctx}/golf/search.jsp?flagday="+"3");
        	$("#myform").submit();
        }
    </SCRIPT>
    <title><s:if test="provinceName!=null&&provinceName!='中文/拼音'">${provinceName}</s:if>高尔夫查询 - 高尔夫预订 - ${domain_cn }</title>
    </head>
    <body>
<form action="" id="myform" method="post">
<div class="clear"></div>
<div class="senav">
        <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx}/index.jsp" class="se">首页</a> &gt;&nbsp; <a href="${ctx}/golf/index.jsp" class="se">高尔夫首页</a> &gt;&nbsp; <span class="se1">高尔夫查询</span></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
    </div>
<div class="clear"></div>
<div class="search">
	<div class="search_left">
          <div class="searchform_frm">
          <div class="left_txt w1 ">省份：</div>
          <div class="r_form w2 ">
	           <div class="inb">
		           	<input type="hidden" name="id" id="id" value="${id }"/>
		           	<input type="hidden" name="city" id="province" value="${city }"/>
					<input type="text" name="provinceName" id="provinceNameId" class="inps"
					onfocus="showSearch(this)" onblur="showSearch(this,1)"
					<s:if test="city==null||city==''">
					value="中文/拼音" style="color:#C1C1C1" 
					</s:if>
					<s:else>
					value="${provinceName }"
					</s:else>
					onclick="suggest.display(this,'province',event)"
					onkeyup="suggest.display(this,'province',event)" />
	       		</div>
       		</div>
          	<div class="left_txt w3 ">下场日期：</div>
          	<div class="r_form w4 ">
          		<div class=inb>
                   <input id="plainDate1" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d',maxDate:'2020-01-01'})" value="${bookTime}" name="bookTime"/>
               </div>
      		</div>
       		<div class="left_txt w5">球场类型：</div>
          	<div class="r_form w6">
              <div id="uboxstyle">
              	<f:select id="language" name="golfType" type="球场类型" blank="true" showValue="false" value="${golfType}"/>
              </div>
          	</div>
          	<div class="left_txt w1">球场名称：</div>
          	<div class="r_form w6">
	          	<div id="uboxstyle">
	            	<input type="text" class="jdmc" value="${name}"  id="productNames"/>
	            	<input type="hidden" name="name" id="productName"/>
	          	</div>
      		</div>
			<div class="btn"><input id="controlColor" class="submitBTN" type="button" onclick="submitSearch()"/></div>
          	<div class="clear"></div>
      	</div>
	</div>
	<%--天气预报存放区域--%>
    <div class="tq_box" id="tq_box"></div>
</div>
<div class="clear"></div>
<div class="jd_fy_box margin5" id="btop">
        <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy">${theTime } <input type="button" class="day1" id="navx1" onclick="doClickx(this)" value="《前一天"></input>/<input type="button" class="day2" id="navx2" onclick="doClickx(this)" value="后一天》"></input></li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
    </div>
    <s:if test="data[0].golfsitelist!=null"> 
<div class="jp_hb_xx center Wmargin" id="searx1" style="display:block;">
        <ul class="h60">
        <li class="w1">球场名称</li>
        <li class="w2">省份</li>
        <li class="w3">球场类型</li>
        <li class="w4">当前状态</li>
        <li class="w5">场地</li>
        <li class="w6">产品名称</li>
        <li class="w7">价格</li>
        <li class="w8">免费项目</li>
        <li class="w9">操作</li>
    </ul>
        <s:set name="holidayis" value="isHoliday"></s:set>
        <s:set name="booktime" value="bookTime"></s:set>
        <s:set name="showprice"></s:set>
      
<s:iterator value="data" var="g">
 
    <div class="innerBox">
        <ul class="h95">

        <li class="w1 pt"><s:property escape="false" value="#g.name"/><br />
                <a href="view.jsp?id=<s:property value="#g.id"/>&bookTime=<s:property value="bookTime"/>&pop" target="blank" class="orangea">查看详情</a>
        </li>
        <li class="w2"><s:property escape="false" value="#g.cityVo.pcName"/></li>
        <li class="w3"><s:property escape="false" value="#g.golfsitelist[0].sysConst.conName"/></li>
        <li class="w4"><s:property escape="false" value="#g.sysConstantVo.conName"/></li>
        <li class="w5"><s:property escape="false" value="#g.golfsitelist[0].name"/><br /><s:if test='#g.golfsitelist[0].sysConst.conValue=="0"&&#g.golfsitelist.size>1'><a class="openInner" href="javascript:void(0);">查看所有场地</a></s:if></li>
        <li class="w6">
        	<s:property escape="false" value="#g.golfsitelist[0].explain"/>
        </li>
        <li class="w7"><span class="orange">
		<s:if test="isHoliday">
			<s:property value="#g.golfsitelist[0].golfPriceVo.hPrice"/>
		</s:if>
		<s:else>
			<s:property value="#g.golfsitelist[0].golfPriceVo.price"/>
		</s:else>
        <s:if test='#g.golfsitelist[0].type=="0"'>
        	元/人
        </s:if>
        <s:else>
        	元/球
        </s:else>
        </span></li>
        <li class="w8">
        <f:write2 type="GF包含项目" value='${g.golfsitelist[0].golfPriceVo.containItem}' regexValue=","></f:write2>
        </li>
        <li class="w9">
        	<s:if test="isHoliday">
    			<s:if test='dateDiff<#g.golfsitelist[0].golfPriceVo.hTargeDate||#g.sts=="0"'>
    				<img src="${ctx}/web/images/yuding2.jpg" />
    			</s:if>
    			<s:else>
    				<a href="book.jsp?id=<s:property value="#g.golfsitelist[0].id"/>&time=<s:property value="bookTime"/>&golfId=<s:property value="#g.id"/>">
		        		<img src="${ctx}/web/images/yuding1.jpg" />
		        	</a>
    			</s:else>
    			<s:if test='dateDiff<#g.golfsitelist[0].golfPriceVo.hTargeDate&&#g.golfsitelist[0].golfPriceVo.hTargeDate!=""&&#g.golfsitelist[0].golfPriceVo.hTargeDate>0'>
    				<br />需提前<span class="orange"><s:property value="#g.golfsitelist[0].golfPriceVo.hTargeDate"/></span>天预定
    			</s:if>
    		</s:if>
        	<s:else>
        		<s:if test='dateDiff<#g.golfsitelist[0].golfPriceVo.targeDate||#g.sts=="0"'>
    				<img src="${ctx}/web/images/yuding2.jpg" />
    			</s:if>
    			<s:else>
    				<a href="book.jsp?id=<s:property value="#g.golfsitelist[0].id"/>&time=<s:property value="bookTime"/>&golfId=<s:property value="#g.id"/>">
		        		<img src="${ctx}/web/images/yuding1.jpg" />
		        	</a>
    			</s:else>
    			<s:if test='dateDiff<#g.golfsitelist[0].golfPriceVo.targeDate&&#g.golfsitelist[0].golfPriceVo.targeDate!=""&&#g.golfsitelist[0].golfPriceVo.targeDate>0'>
    				<br />需提前<span class="orange"><s:property value="#g.golfsitelist[0].golfPriceVo.targeDate"/></span>天预定
    			</s:if>
        	</s:else>
        </li>
    </ul>
	<s:set name="golfsts" value="#g.sts"></s:set>
	<s:iterator value="#g.golfsitelist" var="site" status="item">
		<s:if test="#item.index!=0">
			<ul class="h95 inner" id="wangxia">
		        <li class="w1 pt"></li>
		        <li class="w2"></li>
		        <li class="w3"></li>
		        <li class="w4"></li>
		        <li class="w5"><s:property escape="false" value="#site.name"/></li>
		        <li class="w6"><s:property escape="false" value="#site.explain"/></li><!-- 由原来的site.golfPriceVo.explain改成site.explain -->
		        <li class="w7"><span class="orange">
		        <s:iterator value="#site.pricelist" var="price">
		   			<s:if test="#price.startTime.compareTo(#booktime)<=0&&#price.endTime.compareTo(#booktime)>=0">
		   				<s:if test="holidayis">
		   					<s:property value="#price.hPrice"/>
		   				</s:if>
		    			<s:else>
		    				<s:property value="#price.price"/>
		    			</s:else>
		   			</s:if>
		   		</s:iterator>
				<s:if test='#site.type=="0"'>
		        	元/人
		        </s:if>
		        <s:else>
		        	元/球
		        </s:else>
		        </span></li>
		        <li class="w8">
		        <f:write2 type="GF包含项目" value='${site.golfPriceVo.containItem}' regexValue=","></f:write2>
		        </li>
		    	<li class="w9"><s:property value=""/>
		    		<s:if test="holidayis">
		    			<s:if test='dateDiff<#site.golfPriceVo.targeDate||#site.golfPriceVo==null||#golfsts==0||dateDiff<#site.golfPriceVo.hTargeDate&&#site.golfPriceVo.hTargeDate!=""&&#site.golfPriceVo.hTargeDate>0'>
		    				<img src="${ctx}/web/images/yuding2.jpg" />
		    			</s:if>
		    			<s:else>
		    				<a href="book.jsp?id=<s:property value="#site.id"/>&time=<s:property value="booktime"/>&golfId=<s:property value="#g.id"/>">
				        		<img src="${ctx}/web/images/yuding1.jpg" />
				        	</a>
		    			</s:else>
		    			<s:if test='dateDiff<#site.golfPriceVo.hTargeDate&&#site.golfPriceVo.hTargeDate!=""&&#site.golfPriceVo.hTargeDate>0'>
		    				<br />需提前<span class="orange"><s:property value="#site.golfPriceVo.hTargeDate"/></span>天预定
		    			</s:if>
		    		</s:if>
		        	<s:else>
		        		<s:if test='dateDiff<#site.golfPriceVo.targeDate||#site.golfPriceVo==null||#golfsts==0'>
		    				<img src="${ctx}/web/images/yuding2.jpg" />
		    			</s:if>
		    			<s:else>
		    				<a href="book.jsp?id=<s:property value="#site.id"/>&time=<s:property value="booktime"/>&golfId=<s:property value="#g.id"/>">
				        		<img src="${ctx}/web/images/yuding1.jpg" />
				        	</a>
		    			</s:else>
		    			<s:if test='dateDiff<#site.golfPriceVo.targeDate&&#site.golfPriceVo.targeDate!=""&&#site.golfPriceVo.targeDate>0'>
		    				<br />需提前<span class="orange"><s:property value="#site.golfPriceVo.targeDate"/></span>天预定
		    			</s:if>
		        	</s:else>
		        </li>
		    </ul>
		</s:if>	
		
	</s:iterator>
    </div>
    
</s:iterator>    
    </div>
    
<div class="jp_hb_xx center Wmargin" id="searx2" style="display:none;">
<ul class="h60">
        <li class="w1">球场名称</li>
        <li class="w2">省份</li>
        <li class="w3">球场类型</li>
        <li class="w4">当前状态</li>
        <li class="w5">场地</li>
        <li class="w6">产品名称</li>
        <li class="w7">价格</li>
        <li class="w8">免费项目</li>
        <li class="w9">操作</li>
        
    </ul>
    </div>
    
 </form>   
 
	
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>

<!--翻页区开始-->
<%--如果页码数大于30才显示分页 --%>
	<c:if test="${pageInfo.totalPageCount>1}">
	    <div id="changePage" class="PageBox"> 
	            <form action="golfHomeSearch.action" method="post" id="pageFormId">
	            <input type="hidden" name="city" value="${city}"/>
	            <input type="hidden" name="bookTime" value="${bookTime}"/>
	            <input type="hidden" name="golfType" value="${golfType}"/>
	            <input type="hidden" name="name" value="${name}"/>
	            <%@include file="/common/include/paging.jsp"%>
	            </form>
	     </div>
	     </c:if>
	     <c:if test="${pageInfo.totalPageCount==1}">
	     	<div id="changePage" class="PageBox" align="right">  共有<b>${pageInfo.totalRowCount}</b>条符合条件 的球场信息 </div>
     	</c:if>
     </s:if>
    <s:else>
    	<div class="jp_hb_xx2 center Wmargin" id="searx1" style="display:block;">
    	<b>非常抱歉,没有查询到相关信息的高尔夫场地。</b><br/><br/>
    	可能我们还尚未签约你要查询的高尔夫场地。如有疑问，请你致电${site_tel}进行咨询。
    	</div>
    </s:else>
	<!--翻页区结束-->
	
<%-- 
<div class="yema yema_add Wmargin"> <a href="####"><img src="${ctx}/web/images/up.jpg" /></a> <A href="####">首页</A><A href="####" class="yemaa">1</A><A href="####">2</A><A href="####">3</A><A href="####">4</A><A href="####">5</A><A href="####">6</A><A href="####">6</A><A href="####">7</A><A href="####">8</A><A href="####">9</A><A href="####">尾页</A> <A href="####"><img src="${ctx}/web/images/down.jpg" /></A><a href="####" name="btop"><img src="${ctx}/web/images/bottomtop.jpg" /></a></div>
--%>


<script type="text/javascript">
	$(function(){
		$(".innerBox ul.inner").hide();
		$(".openInner").click(function(){
			var inner = $(this).parents("div.innerBox").children("ul.inner")
			if(inner.is(":hidden")){
				inner.show();
				$(this).text("隐藏场地")
				}else{
				inner.hide();
				$(this).text("查看所有场地")
			}
		});

    $("#searchBtn").click(function(){
	    submitSearch();
	    return false;
    });
    // IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
	if(!-[1,]&&!window.XMLHttpRequest){
		$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	}
	// 限制条件鼠标经过显示隐藏
	$(".jp_hb_xx ul li.w8").mouseover(function(){
	    $(this).attr("title",$(this).text());
	});
/*
		var cityid=$("#province").val();//取到城市ID值。
		alert(commonCity[1][1]);
		for(var i=0;i<commonCity.length;i++){
			if(commonCity[i][0]==cityid){
				$("#provinceNameId").val(commonCity[i][2]);
				alert(commonCity[i][2]);
			}
		}

*/
		
	});
</script>

</body>






 
