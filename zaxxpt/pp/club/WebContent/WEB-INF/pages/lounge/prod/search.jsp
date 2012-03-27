﻿<%@ page pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@ include file="/common/include/tags-lib.jsp"%>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/web/css/paging.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}/web/js/paging.js" ></script>
		<script type="text/javascript">var CTX='${ctx}';</script>
		<script type="text/javascript" src="${ctx}/web/js/city/allAirport.js" ></script><!-- 用了 -->
		<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->
		<script type="text/javascript" src="${ctx}/web/js/clubJs/tag.js" language="javascript"></script>
		<script type="text/javascript" src="${ctx}/web/js/clubJs/travel.js" language="javascript"></script>
		<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
		<script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
<style type="text/css">
    <style type="text/css">
    
    #myrest{
    	margin-top : auto;
		margin-right : auto;
		margin-bottom :auto;
		margin-left : -60px;
    }
    .myresttext{
    	margin :auto 250px 10 auto;
    	
    }

	#wangxia {
		margin-top : 30px;
		margin-right : auto;
		margin-bottom :auto;
		margin-left : auto;
	}
</style>

    <script language="javascript" type="text/javascript">

	//天气预报异步加载
    $(function (){
    	var cityCode=$("#departureAirportId").val();
    	if(cityCode){
    		loadWeatherAjax("#tq_box",cityCode,"","H","F");
    	}else {
    		cityCode="010";
    		loadWeatherAjax("#tq_box",cityCode,"","H","F");
    	}
    });
/*机场休息厅查询*/
function before(){
	var dateStr=$("#plainDate1").val();
	if(dateStr.length<6){
		$("#plainDate1").click();//未选择日期！
		return;
	}
	$("#controlColor").attr("disabled",true);	//wenz,按钮置灰。
    $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -38px");
	$("#myform").attr("action","${ctx}/loungeHome!search.action?flagday="+"1");
	$("#myform").submit();
	 
}
function after(){
	var dateStr=$("#plainDate1").val();
	if(dateStr.length<6){
		$("#plainDate1").click();//未选择日期！
		return;
	}
	$("#controlColor").attr("disabled",true);	//wenz,按钮置灰。
    $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -38px");
	$("#myform").attr("action","${ctx}/loungeHome!search.action?flagday="+"0");
	$("#myform").submit();
}
function doClickx(o){
	var dateStr=$("#plainDate1").val();
	if(dateStr.length<6){
		$("#plainDate1").click();//您未选择日期！
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
		if(id != o.id){
			j.className="day2";
			e.style.display = "none";
//--------------------------------------------------------------------
			before();
//-------------------------------------------------------------------------------------------
			
		}else{
			e.style.display = "block";
//--------------------------------------------------------------------
			after();
//-------------------------------------------------------------------------------------------
		}
	}
}
//字符串截取
jQuery.fn.limit=function(){ 
    var self = $("li[limit]"); 
    self.each(function(){ 
        var objString = $(this).text(); 
        var objLength = $(this).text().length; 
        var num = $(this).attr("limit"); 
        if(objLength > num){ 
$(this).attr("title",objString); 
            objString = $(this).text(objString.substring(0,num) + "..."); 
        } 
    }) 
} 
$(function(){ 
    $(document.body).limit(); 
}) 
</script>
    <SCRIPT type=text/javascript>
        var citySelect = new CitySelectWindow('cityselected');
        function setSearch(n) { var menu = document.getElementById("sea_nav").getElementsByTagName("li"); var showdiv = document.getElementById("sea_box").getElementsByTagName("li"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
        function setList(m, n) { var menu = document.getElementById("tab" + m).getElementsByTagName("li"); var showdiv = document.getElementById("tablist" + m).getElementsByTagName("div"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
    </SCRIPT>
    <SCRIPT type=text/javascript>
        function submitSearch()
        {
        	var jichang=$("#departureAirportId").val();
        	if(jichang=="null" ||jichang=="" ||jichang.length<3){
        		$("#departureAirport").val("");
        		//$("#departureAirport").click();//您未选择机场！
        		alert("请选择机场");
        		document.getElementById("departureAirport").click();
        		return;
        	}
        	var dateStr=$("#plainDate1").val();
        	if(dateStr.length<6){
        		$("#plainDate1").click();//您未选择日期！
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
    </SCRIPT>
    <title>${departureAirport}休息室查询 - 机场休息室预订 - ${domain_cn }</title>
    </head>
    <body>
<form action="loungeHome!search.action" id="myform" method="post">
<div class="clear"></div>
<div class="senav">
        <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx}/index.jsp" class="se">首页</a> &gt;&nbsp; <a href="${ctx}/lounge/index.jsp" class="se">机场休息室首页</a> &gt;&nbsp; <span class="se1">机场休息室查询</span></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
    </div>
<div class="clear"></div>

<div class="search">
        <div class="search_left">
        <div class="search_left">
                <div class="searchform_frm">
                  <div class="left_txt w1">机场：</div>
                  <div class="r_form w2">
	                <div class="inb">
		          			<input name="airport" type="hidden" id="departureAirportId" value="${airport}"/>
                            <input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="departureAirport" name="departureAirport" onblur="blurEvt(this)"
            				value="${ departureAirport}"
            				<c:if test="${empty departureAirport}">
							value="中文/拼音" 
							</c:if>
            				style="color:#C1C1C1" onclick="suggest_Flight.display(this,'departureAirportId',event)"
           					 onkeyup="suggest_Flight.display(this,'departureAirportId',event)"/>
		          			<img class="set_city" src="${ctx}/web/images/tra1.jpg" width="16" height="16"  onclick="showSearch_Flight(document.getElementById('departureAirport')),suggest_Flight.display(document.getElementById('departureAirport'),'departureAirportId',event)" style="float: none"/>
	                </div>
	              </div>
                  <div class="left_txt w3">预定日期：</div>
                  <div class="r_form w4">
                    <div class=inb>
                        <input id="plainDate1" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})" value="${bookTime}" name="bookTime"/>
                     </div>
            	  </div>
            	  <div class="left_txt w1">休息室名称：</div>
            	  <div class="r_form w6">
            		 <div id="uboxstyle">
	                    <input name="loungeName" type="text" class="jdmc" value="${loungeName }" value="aa" name="loungeName"/>
	                 	<input name="cityorap" type="hidden" id="cityorap" value="${cityorap}"/>
	                 </div>
	              </div>
                <div class="left_txt w1">休息室类型：</div>
                <div class="r_form w2" id="myresttypetext">
                  <div id="uboxstyle">        
                  	<%--
                  	<s:select name="loungeType" id="language_mac"  list="#{'':'不限...','1':'贵宾间','2':'贵宾厅','3':'两舱休息室'}"></s:select>
                  	 --%>
                  	  <f:select name="loungeType" type="休息室类型" blank="true" showValue="false" value="${loungeType}"/>
                   </div>
                 </div>
                 <div class="btn"><input id="controlColor" class="submitBTN" type="button" onclick="submitSearch()"/></div>
            </div>
            </div>
    </div>
        <div class="tq_box" id="tq_box">
    	
    	</div>
    </div>
</form> 
<div class="clear"></div>
<div class="jd_fy_box margin5" id="btop">
        <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy">${theTime } <input type="button" class="day1" id="navx1" onclick="before()" value="《前一天"></input>/<input type="button" class="day2" id="navx2" onclick="after()" value="后一天》"></input></li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
    </div>
    <c:if test="${isLoungeList}">
    <div class="jp_hb_xx2 center Wmargin" id="searx1" style="display:block;">
        <ul class="h60">
        <li class="w1">休息室名称</li>
        <li class="w2">机场</li>
       <!--  <li class="w3">地址描述</li> -->
        <li class="w4">休息室类型</li>
        <li class="w5">当前状态</li>
        <li class="w6">价格</li>
        <li class="w7" style="width: 200px;">支持的航空公司</li>
        <li class="w8" style="width: 160px;">操作</li>
    </ul>
    </c:if>
       <c:if test="${!isLoungeList}">
        <div class="jp_hb_xx2 center Wmargin" id="searx1" style="display:block;">
		   <b>非常抱歉，没有符合您查询条件的休息室，或此预定日期的休息室已售完。   建议您选择其他休息室类型或预定日期进行查询。</b><br/><br/> 如有疑问请致电 ${site_tel} 。</td></tr>
		   </div>
          </c:if>
        <s:set value="dateDiff" name="datediff"/>
        <s:set value="memberRole.code" name="rolecode"/>
        <s:iterator value="loungelist" var="lounge" status="item">
        <div class="innerBox">
        <ul class="h95">
            <li class="w1 pt">
            <s:property escape="false" value="#lounge.name"/><br />
            <a target="blank" class="orangea" href="${ctx}/loungeDetailAction!loungeDetail.action?id=<s:property escape="false" value="#lounge.id"/>&airport=${airport.code}&bookTime=${bookTime}" >
       		     查看详情
            </a>
                <!-- <a href="###" onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'" class="orangea">查看位置</a> -->
            </li>
            	<input type="hidden" name="loungeimage" id="loungeimage" value="<s:property value="#lounge.image.path"/>"/>
            <li class="w2">
            	<s:property escape="false" value="#lounge.airport.name"/>
            </li><!-- 通过机场三字码获得机场名称的方法未知（待会问） -->
           <!--  <li class="w3" limit="13"><s:property escape="false" value="#lounge.address"/></li> -->
            <li class="w4 pt">
            	<f:write type="休息室类型" value='${lounge.roomlist[0].type}'></f:write><br />
                <s:property escape="false" value="#lounge.roomlist[0].roomType"/>
               	<s:if test='#lounge.roomlist[0].type=="1"'>
               		人间
               	</s:if>
            </li>
            <li class="w5">
            	<s:if test="#lounge.roomlist[0].sts==0">
            		已满
            	</s:if>
            	<s:else>
            		未满
            	</s:else>
            </li>
            <li class="w6"><span class="orange">
            	<s:property value="#lounge.roomlist[0].loungePriceVo.price"/>
            	<s:if test='#lounge.roomlist[0].type=="1"'>
            		元/小时
            	</s:if>
            	<s:else>
            		元/人
            	</s:else>
            </span><br /><!-- 其中贵宾厅与两仓都是200元/人             而只有贵宾间200元/时 -->
                <s:if test='#lounge.roomlist.size>1'><a href="javascript:void(0)" id="pricebutton0<s:property value="#item.index"/>" class="openInner">查看全部价格</a></s:if></li>
            <li class="w7 pt Restrict" style="width: 200px;">
            <span><s:iterator value="#lounge.airlinelist" var="airline"><s:property escape="false" value="#airline.name"/>、</s:iterator>的机票用户预定</span>
            </li>
            <li class="w8 pt20" style="width: 160px;">
            	<s:if test="#lounge.roomlist[0].loungePriceVo==NULL||dateDiff<#lounge.roomlist[0].bookDate||#lounge.roomlist[0].sts==0">
            		<img src="${ctx}/web/images/yuding2.jpg" />
            	</s:if>
            	<s:elseif test='memberRole.code!="DIAMOND"&&#lounge.roomlist[0].type==1'>
            		<img src="${ctx}/web/images/yuding2.jpg" />
            	</s:elseif>
            	<s:elseif test='memberRole.code!="DIAMOND"&&#lounge.roomlist[0].type==2'>
            		<img src="${ctx}/web/images/yuding2.jpg" />
            	</s:elseif>
            	<s:else>
            		<a href="lounge/book.jsp?roomid=<s:property value="#lounge.roomlist[0].id"/>&bookTime=<s:property value="bookTime"/>">
	            		<img src="${ctx}/web/images/yuding1.jpg" />
	            	</a>
            	</s:else>
            	<s:if test="#lounge.roomlist[0].bookDate!=null&&dateDiff<#lounge.roomlist[0].bookDate&&#lounge.roomlist[0].bookDate!=0">
            		<br />
            		需提前<span class="orange">
	            		<s:property value="#lounge.roomlist[0].bookDate"/>
	            	</span>天预订
            	</s:if>
            	<s:elseif test='memberRole.code!="DIAMOND"&&#lounge.roomlist[0].type==1'>
            		<br />
            		<span class="orange">
	            		钻石管家
	            	</span>专享
            	</s:elseif>
            	<s:elseif test='memberRole.code!="DIAMOND"&&#lounge.roomlist[0].type==2'>
            		<br />
            		<span class="orange">
	            		钻石管家
	            	</span>专享
            	</s:elseif>
            </li>
        </ul>
        	<s:set value="#lounge" name="innerlounge"></s:set>
        	<s:set value="#item.index" name="loungeindex"></s:set>
        	 <s:iterator value="#lounge.roomlist" var="room" status="item">
	        	  <s:if test="#item.index!=0">
			        <ul  class="h95 inner" id="pricedetail0<s:property value="#loungeindex"/>" style="display:none;">
			            <li class="w1 pt">&nbsp;<br />
			                <a href="#" class="orangea"></a></li>
			            <li class="w2">&nbsp;</li>
			            <!--  <li class="w3">&nbsp;</li>--> 
			            <li class="w4 pt">
			            	<f:write type="休息室类型" value='${room.type}'></f:write><br />
			                <s:property escape="false" value="#room.roomType"/>
			                <s:if test='#room.type=="1"'>
			               		人间
			               	</s:if>
			            </li>
			            <li class="w5">
			            	<s:if test="#room.sts==0">
			            		已满
			            	</s:if>
			            	<s:else>
			            		未满
			            	</s:else>
			            </li>
			            <li class="w6"><span class="orange">
			            	<s:property escape="false" value="#room.loungePriceVo.price"/>
			            	<s:if test='#room.type=="1"'>
			            		元/小时
			            	</s:if>
			            	<s:else>
			            		元/人
			            	</s:else>
			            </span></li><!-- 其中贵宾厅与两仓都是200元/人             而只有贵宾间200元/时 -->
			            <li class="w7 pt Restrict" style="width: 200px;"><span>
			            <s:iterator value="#innerlounge.airlinelist" var="airline">
			            	<s:property escape="false" value="#airline.name"/>、
			            </s:iterator>的机票用户预定</span></li>
			            
			            <li class="w8" style="width: 160px;">
			            	<s:if test="#room.loungePriceVo==NULL||#datediff<#room.bookDate||#room.sts==0">
			            		<img src="${ctx}/web/images/yuding2.jpg" />
			            	</s:if>
			            	<s:elseif test='#rolecode!="DIAMOND"&&#room.type==1'>
			            		<img src="${ctx}/web/images/yuding2.jpg" />
			            	</s:elseif>
			            	<s:elseif test='#rolecode!="DIAMOND"&&#room.type==2'>
			            		<img src="${ctx}/web/images/yuding2.jpg" />
			            	</s:elseif>
			            	<s:else>
			            		<a href="lounge/book.jsp?roomid=<s:property value="#room.id"/>&bookTime=<s:property value="bookTime"/>">
				            		<img src="${ctx}/web/images/yuding1.jpg" />
				            	</a>
			            	</s:else>
			            	<s:if test="#room.bookDate!=null&&#datediff<#room.bookDate&&#room.bookDate!=0">
			            		<br />
			            		需提前<span class="orange">
				            		<s:property value="#room.bookDate"/>
				            	</span>天预订
			            	</s:if>
			            	<s:elseif test='#rolecode!="DIAMOND"&&#room.type==1'>
			            		<br />
			            		<span class="orange">
				            		钻石管家
				            	</span>专享
			            	</s:elseif>
			            	<s:elseif test='#rolecode!="DIAMOND"&&#room.type==2'>
			            		<br />
			            		<span class="orange">
				            		钻石管家
				            	</span>专享
			            	</s:elseif>
			            </li>
			        </ul>
			        
			     </s:if>
		      </s:iterator>
		      </div> 
         </s:iterator> 
   
<div class="jp_hb_xx center Wmargin" id="searx2" style="display:none;">
	   <ul class="h60">
	        <li class="w1">休息室名称</li>
	        <li class="w2">机场</li>
	       <!--  <li class="w3">地址描述</li> -->
	        <li class="w4">休息室类型</li>
	        <li class="w5">当前状态</li>
	        <li class="w6">价格</li>
	        <li class="w7" style="width: 200px;">支持的航空公司</li>
	        <li class="w8" style="width: 160px;">操作</li>
	    </ul>
	</div>
 </div>
	<!--前一天后一天区结束-->
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<!--翻页区开始-->
<s:if test="pageInfo.totalPageCount>1">
  <c:if test="${isLoungeList}">
    <div id="changePage" class="PageBox"> 
            <form action="loungeHome!search.action" method="post" id="pageFormId">
            <input type="hidden" name="airport" value="${airport}"/>
            <input type="hidden" name="bookTime" value="${bookTime}"/>
            <input type="hidden" name="loungeName" value="${loungeName}"/>
            <input type="hidden" name="loungeType" value="${loungeType}"/>
            
            <%@include file="/common/include/paging.jsp"%>
            </form>
     </div>
 </c:if>
 </s:if>
 <s:else>
 	 <div id="changePage" class="PageBox" align="right">  共有<b>${pageInfo.totalRowCount}</b>条符合条件 的休息室信息 </div>
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
				$(this).text("只显示最低价")
				}else{
				inner.hide();
				$(this).text("查看全部价格")
			}
		});
		// IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
	    if(!-[1,]&&!window.XMLHttpRequest){
			$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	    }
	    // 限制条件鼠标经过显示隐藏
	    $(".jp_hb_xx2 ul li.w7 > span").mouseover(function(){
	        $(this).attr("title",$(this).text());
	    });
	});
</script>
<script>
	var date = new Date();//如果时间是今天那么就不让回去
	var dateStr=$("#plainDate1").val();
	if(dateStr.substr(8,2)==date.getDate()&&dateStr.substr(5,2)==(parseInt(date.getMonth())+1)&&dateStr.substr(0,4)==date.getYear()){
		$("#navx1").attr("disabled",true);	//wenz,按钮置灰。
	}
</script>
</body>






 
