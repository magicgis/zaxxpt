<%@ page pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.PropertiesUtils"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/paging.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/easydialog.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/paging.js" ></script>
<script type="text/javascript">var CTX='${ctx}';</script>
<script type="text/javascript" src="${ctx}/web/js/city/allAirport.js" ></script><!-- 用了 -->
<script type="text/javascript" src="${ctx}/web/js/clubJs/tag.js" language="javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/jquery/easydialog.min.js"></script>
<style type="text/css">
.u134 {
	POSITION: absolute; TEXT-ALIGN: center; FONT-STYLE: normal; WIDTH: 100px; FONT-FAMILY: 'Heiti SC'; HEIGHT: 25px; COLOR: #000000; FONT-SIZE: 13px;  FONT-WEIGHT: normal; TEXT-DECORATION: none; 
}
#plainDate1{
   font-size:12px;
   padding:3px;
   vertical-align:middle;
   font-family:Verdana, Arial, Helvetica, sans-serif;
}
</style>
<script type="text/javascript">
//天气预报异步加载
$(function (){
	var airport=$("#airport").val();
	if(airport){
		loadWeatherAjax("#tq_box",airport,"","H","F");
	}else {
		loadWeatherAjax("#tq_box","010","","H","F");
	}
});
function checkData(){
	if($.trim($("#plainDate1").val())==""){
        alert("预定时间不能为空!");
        return false;
	}
	return true;
}

//打开层
function openDiv(imgsrc){
	easyDialog.open({
		container : {  
		header : ' ',
		content : '<img  src="'+imgsrc+'"/>',  
		noFn : false,
		noText:'关闭'
		 } , 
		drag:false

	});	
}


</script>
<title>${domain_cn} - 休息室详细信息</title>
</head>
<body> 
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx}" class="se">首页</a> > <a href="${ctx}/lounge/index.jsp" class="se">休息室预定</a> > <a href="#" class="se1">休息室详细信息</a></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
</div>
<form action="${ctx}/loungeDetailAction!loungeDetail.action" method="post" onsubmit="return checkData();">
<input type="hidden" name="id" value="${id}"/><input type="hidden" name="airport" value="${airport }"/>
<div id="content" class="padd5">
    <div class="content_left LoungeDetails">
        <div class="grf_borderb left" style="width:652px;">
        <% String imagePath=PropertiesUtils.getVal("sysProps", "resource.server.address"); %>
        <input type="hidden"  id="airport" value="${airport}"/>
            <div class="img_news"><img src="<%=imagePath %>/${loungeInfoVo.image.path}" class="img_p4" />
                <div><b class="orange14">${loungeInfoVo.airport.name}</b></div>
            </div>
            <div  class="imgright">
                <div>
                    <div class="left"><img src="${ctx}/web/images/bj_left.jpg" /></div>
                    <div class="xxbj">
                        <div>
                            <ul>
                                <li class="grf_tag2"><a href="#" class="grf_a1" id="navg1" >基本信息</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="left"><img src="${ctx}/web/images/bj_right.jpg" /></div>
                </div>
                <div class="grf_p1 " id="searg1" style="display:block;">
                    <ul class="x2">
                        <li><b>单位名称：</b>${loungeInfoVo.name}</li>
                        <%-- <li><b>航站楼：</b></li>--%>
                    </ul>
                    <ul>
                        <li><b>休息室地址：</b>${loungeInfoVo.address}</li>
                    </ul>
                    <ul>
                    	<li><b>所支持航空公司：</b>
                    	 <s:iterator value="loungeInfoVo.airlinelist" var="airline" status="item">
                    	 	${airline.name}&nbsp;&nbsp;
                    	 </s:iterator>
                    	</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class=" qcbhss LoungeType">
       	 <span style="font-family:SimSun;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#666666;"> 请选择预定日期：</span>  
       	  <input id="plainDate1" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})" value="${bookTime}" name="bookTime"/>
            <INPUT id=u134 type=submit class="u134" value="查询"  >
        </div>
        <div class=" qcbhss LoungeType">
         </br>
       		<s:iterator value="loungeInfoVo.roomlist" var="room" status="roomItem">
	            <dl class="clearfix_">
	            	<dt style="width: 90px;"><b>${room.name}</b><br />
	            	<c:if test="${room.type=='1'}">
	            	<font size="2px;">  ${room.roomType}人间<br/></font>
	            	</c:if>
	            	<c:if test="${room.loungeImgVo!=null}">
	            	<!-- <a href="<%=imagePath %>/${room.loungeImgVo.path}" target="_blank">查看位置图</a> -->
	            	<a href="#" style="cursor: pointer" onclick="openDiv('<%=imagePath %>/${room.loungeImgVo.path}');">查看位置图</a>
	            	</c:if>
	            	</dt>
	            	<dd class=""> 
	                	<span class="title clearfix_"><b class="left">
	                	<c:if test="${islogin }">会员价</c:if>
	                	<c:if test="${!islogin }">	普通价</c:if>
	                	:<span class="red">￥${room.loungePriceVo.price}</span>元/<s:if test="#room.type==1">时</s:if><s:else>人</s:else>&nbsp;&nbsp;
	                	 <s:if test="#room.type!=1"><c:if test="${room.loungePriceVo.childrenPrice!=null}">儿童价:<span class="red">￥${room.loungePriceVo.childrenPrice}</span>元/人&nbsp;&nbsp;</c:if></s:if>(提前  ${room.bookDate }天  预订)</b>
	                	 <c:if test="${not empty bookTime}">
	                	    <s:if test="#room.loungePriceVo!=NULL&&dateDiff>=#room.bookDate&&#room.sts==1&&memberRole.code=='DIAMOND'||#room.type==3&&#room.loungePriceVo!=NULL&&dateDiff>=#room.bookDate&&#room.sts==1">
			            		<a href="${ctx}/lounge/book.jsp?roomid=${room.id}&bookTime=${bookTime}" class="Btn63_24">预 订</a>
			            	</s:if>
			            	<s:elseif test='#rolecode!="DIAMOND"&&#room.type==1'>
			            	<span class="orange" >
	            				钻石管家
	            			</span>专享
	            			<a href="#" class="Btn63_241" >预 订</a>
			            	</s:elseif>
			            	<s:elseif test='#rolecode!="DIAMOND"&&#room.type==2'>
			            	<span class="orange" >
	            				钻石管家
	            			</span>专享
	            			<a href="#" class="Btn63_241" >预 订</a>
			            	</s:elseif>
			            	<s:else>
			            		<a href="#" class="Btn63_241" >预 订</a>
			            	</s:else>
	                	 </c:if>
	                	 <c:if test="${!not empty bookTime}">
		                	<s:if test='#rolecode!="DIAMOND"&&#room.type==1'>
			            	<span class="orange" >
	            				钻石管家
	            			</span>专享
	            			<a href="#" class="Btn63_241" >预 订 </a>
			            	</s:if>
			            	<s:elseif test='#rolecode!="DIAMOND"&&#room.type==2'>
			            	<span class="orange" >
	            				钻石管家
	            			</span>专享
	            			<a href="#" class="Btn63_241" >预 订 </a>
			            	</s:elseif>
			            	<s:else>
			            		<a href="#" class="Btn63_241" >预 订 </a>
			            	</s:else>
	                	 </c:if>
	                	 </span>
	                    <ul>
	                    	<li><span>退改规则：</span>${room.rmk }</li>
	                    	<li><span>免费项目：</span>
	                    		  <f:write2 type="L包含项目" value="${room.loungePriceVo.item }" regexValue=","></f:write2>&nbsp;&nbsp;
	                    	 </li>
	                    	<li><span>单收费项目：</span>
	                    		<s:iterator value="#room.pricelist" var="priceVar" >
	                    			${priceVar.item}&nbsp;&nbsp; 
	                    		</s:iterator>
	                    	</li>
	                    </ul>
	                </dd>
	            </dl>
           </s:iterator>
           <s:if test="loungeInfoVo.roomlist.isEmpty()">
           	<div>
		   		<b>非常抱歉，没有符合您查询条件的休息室，或此预定日期的休息室已售完。 <br/><br/>  建议您选择其他休息室类型或预定日期进行查询。</b><br/><br/> 如有疑问请致电 ${site_tel} 。</td></tr>
		   	</div>
           </s:if>
        </div>
        <div class="left_heads margin5">
            <div class="left"><img src="${ctx}/web/images/bj_left.jpg" /></div>
            <div class="xxbj til">机场休息室相册</div>
            <div class="left"><img src="${ctx}/web/images/bj_right.jpg" /></div>
        </div>
        <ul class="grfxc jp_xx_black" style="">
        <s:iterator value="loungeInfoVo.loungeImgVoList" var="imgVo" >
            <li><img src="<%=imagePath %>/${imgVo.path}"class="img_p4" /></li>
        </s:iterator>
        </ul>
        <div style=" float:left;width:652px;"><img src="${ctx}/web/images/wb652.jpg" width="652" height="7" /></div>
    </div>
    <div class="content_right">
        <div class="tq_box" id="tq_box">
        </div>
        <div class="clear"></div>
        <div class="margin5" style="width:323px;"><img src="${ctx}/web/images/right1.jpg" /></div>
    </div>
    <div class="clear"></div>
</div>
</body>
</form>


