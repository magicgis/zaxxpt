﻿<%@ page pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@ include file="/common/include/tags-lib.jsp"%>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" /> 
    <link href="${ctx}/web/css/paging.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/web/js/paging.js" ></script>
     <script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script>
     <script type="text/javascript" src="${ctx}/web/js/jquery1.3.2.js" ></script>
     <script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
    
    <style type="text/css">
	#productName {
		margin-top : auto;
		margin-right : auto;
		margin-bottom :auto;
		margin-left : auto;
		float : left;
	}
.myPageBox{width:980px; height:30px; line-height:30px; margin:5px auto 0; text-align:left; color:#666;}
.myPageBox input.inputText{ width:30px; padding:0 3px;}
.myPageBox input.btn{padding:0 3px;}
.myPageBox a{color:#F09E0E;}
.myPageBox a:hover{color:#D35D15;}
.myPageBox b{color:#F09E0E;}
	.jp_hb_xx ul.h95 li {padding:0;margin:30px 0;}
	.u134 {
	POSITION: absolute; TEXT-ALIGN: center; FONT-STYLE: normal; WIDTH: 100px; FONT-FAMILY: 'Heiti SC'; HEIGHT: 25px; COLOR: #000000; FONT-SIZE: 13px;  FONT-WEIGHT: normal; TEXT-DECORATION: none; 
}
#plainDate1{
   font-size:12px;
   padding:1px;
   vertical-align:middle;
   font-family:Verdana, Arial, Helvetica, sans-serif;
}
</style>

    <script language="javascript" type="text/javascript">
      function init(){
     	var city=window.top.document.getElementById("city");
     	var name=window.top.document.getElementById("name");
     	var bookTime=window.top.document.getElementById("bookTime");
     	var now_bookTime=document.getElementById("bookTime");
     	var fromPage=window.top.document.getElementById("fromPage");
    	document.getElementById("city").value=city.value;
    	document.getElementById("name").value=name.value;
    	if(bookTime.value==""){
    	 document.getElementById("plainDate1").value=document.getElementById("nowTime").value;
    	}
    	
    	if(document.getElementById("plainDate1").value==""){
    	 document.getElementById("plainDate1").value=bookTime.value;
    	}
    	if(now_bookTime.value!=""){document.getElementById("plainDate1").value=now_bookTime.value;}
    	
    	if(fromPage.value=="view"){
    		submitSearch();
    		window.top.document.getElementById("fromPage").value="oldPage";
    	}
    }
 function submitSearch()
        {//
        	var dateStr=document.getElementById("plainDate1").value;
        	var bookTime=window.top.document.getElementById("bookTime");
        	if(dateStr.length<6){
        		alert('您未选择日期！');
        		return false;
        	}
        	
        	document.getElementById("searchSiteForm").submit();
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

//预定
function book(url){
	window.top.location=url;
}


</script>
    <link type="text/css" rel="stylesheet" href="${ctx}/web/js/city/style/city.css"><link>
    <title></title>
    </head>
    <body onload="init()">
    <jsp:useBean id="now" class="java.util.Date" />
    <input type="hidden" value='<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />' id="nowTime"/>
      <s:hidden id="bookTime" name="bookTime"></s:hidden>
      <form name="searchSiteForm" id="searchSiteForm" action="${ctx}/golfHomeSearch!searchSite.action?flagday=3" onsubmit="return submitSearch()">
	    <input type="hidden" id="city" name="city" />
	    <input type="hidden"  id="name" name="name"/>
	    <br/> <br/> <br/>
	    <div class="qcbhss LoungeType">
        <span style="font-family:SimSun;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#666666;">请选择预定日期:</span>
        <input id="plainDate1" class="Wdate" type="text"  onfocus="WdatePicker({minDate:'%y-%M-%d',maxDate:'2020-01-01'})" 
         value="${bookTime}"
         name="bookTime"/>
		 <INPUT id=u134 type=submit class="u134" value="查询"  >
		 <br/>&nbsp;
		 </div>
	</form>
    <s:if test="data[0].golfsitelist!=null"> 
<div class="jp_hb_xx center Wmargin" id="searx1" style="display:block;">
        <ul class="h60">
        <li class="w3">球场类型</li>
        <li class="w6">产品名称</li>
        <li class="w5">场地</li>
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

       
        <li class="w3"><s:property escape="false" value="#g.golfsitelist[0].sysConst.conName"/></li>
        <li class="w6">
        	<s:property escape="false" value="#g.golfsitelist[0].explain"/>
        </li>
        <li class="w5"><s:property escape="false" value="#g.golfsitelist[0].name"/><br /></li>
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
        <li class="w8" >
        <f:write2 type="GF包含项目" value='${g.golfsitelist[0].golfPriceVo.containItem}' regexValue=","></f:write2>
        </li>
        <li class="w9">
        	<s:if test="isHoliday">
    			<s:if test='dateDiff<#g.golfsitelist[0].golfPriceVo.hTargeDate||#g.sts=="0"'>
    				<img src="${ctx}/web/images/yuding2.jpg" />
    			</s:if>
    			<s:else>
    				<a href="javascript:book('${ctx}/golf/book.jsp?id=<s:property value="#g.golfsitelist[0].id"/>&time=<s:property value="bookTime"/>&golfId=<s:property value="#g.id"/>')">
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
    				<a href="javascript:book('${ctx}/golf/book.jsp?id=<s:property value="#g.golfsitelist[0].id"/>&time=<s:property value="bookTime"/>&golfId=<s:property value="#g.id"/>')">
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
			<ul class="h95" id="wangxia">
		         <li class="w3"><s:property escape="false" value="#g.golfsitelist[0].sysConst.conName"/></li>
		         <li class="w6">
		         	<s:property escape="false" value="#g.golfsitelist[0].explain"/>
		         	<!--  
		         <s:property escape="false" value="#site.golfPriceVo.explain"/>
		         -->
		         </li>
		        <li class="w5"><s:property escape="false" value="#site.name"/></li>
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
		        <li class="w8" >
		        <f:write2 type="GF包含项目" value='${site.golfPriceVo.containItem}' regexValue=","></f:write2>
		        </li>
		    	<li class="w9"><s:property value=""/>
		    		<s:if test="holidayis">
		    			<s:if test='dateDiff<#site.golfPriceVo.targeDate||#site.golfPriceVo==null||#golfsts==0'>
		    				<img src="${ctx}/web/images/yuding2.jpg" />
		    			</s:if>
		    			<s:else>
		    				<a href="javascript:book('${ctx}/golf/book.jsp?id=<s:property value="#site.id"/>&time=<s:property value="booktime"/>&golfId=<s:property value="#g.id"/>')">
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
		    				<a href="javascript:book('${ctx}/golf/book.jsp?id=<s:property value="#site.id"/>&time=<s:property value="booktime"/>&golfId=<s:property value="#g.id"/>')">
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
    
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>

<!--翻页区开始-->
    <div id="changePage" class="myPageBox">
            <form action="${ctx}/golfHomeSearch!searchSite.action?flagday=3" method="post" id="pageFormId">
            <input type="hidden" name="city" value="${city}"/>
            <c:if test="${pageInfo.totalPageCount>1}">
           	 <%@include file="/common/include/paging.jsp"%>
           	</c:if>
            <input type="hidden" name="bookTime" value="${bookTime}"/>
            <input type="hidden" name="name" value="${name}"/>
            </form>
     </div>
     </s:if>
    <s:else>
       <div class="jp_hb_xx2 center Wmargin" id="searx1" style="display:block;">
    	<s:if test="bookTime!=null">
    	<b>非常抱歉,没有查询到相关信息的高尔夫场地。</b><br/><br/>
    	可能我们还尚未签约你要查询的高尔夫场地。如有疑问，请你致电${site_tel}进行咨询。
    	</s:if><s:else>
    	正在查询球场预订信息...
    	</s:else>
    	</div>
		 <div id="mydiv" style="display:block">
		 <br/>&nbsp;<br/>&nbsp;<br/>&nbsp;<br/>&nbsp;<br/>&nbsp;
		 </div>
    </s:else>
</body>




 
