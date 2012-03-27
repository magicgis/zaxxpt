<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<title>订单详情 - 酒店预订 - ${domain_cn} </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.room_Price { background: none repeat scroll 0 0 #FFFFFF; border: 1px solid #FDA102; left: 0; line-height: 18px; padding: 5px; position: absolute; text-align: center; top: 0; width: 200px; z-index: 5; }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
    <!----------------------------------------- RIGHT ------------------------------------>
    <div class="floatleft width783">
        <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
        <div class="listTAB rightbg"> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span>
                <span class="c">
                	<b class="left">${hotelOrderDetailsVo.hname}</b>
                		<b class="right">总计金额：<b class="red">${hotelOrderDetailsVo.totalMoney}元</b></b>
                </span>
               	<span class="r"></span>
                </div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3">
                        <li><span class="t">订单号：${hotelOrderDetailsVo.code}</span></li>
                        <%--将订单的状态翻译为文字 	目前暂时不显示，直接显示状态的字符 --%>
                        <%-- <li>订单状态：<b><f:write value="${hotelOrderDetailsVo.sts}" type="酒店订单状态"/></b></li>--%>
                        <li>订单状态：<b>
                        <%-- ${hotelOrderDetailsVo.stsValue} 2011-11-10 17:28 zhanghan edit--%>
                        	<s:if test="hotelOrderDetailsVo.sts=='SP_DQR'">
                        	下单成功
                        	</s:if>
                        	<s:elseif test="hotelOrderDetailsVo.sts=='SP_YJJ'">
                        	已取消
                        	</s:elseif>
                        	<s:elseif test="hotelOrderDetailsVo.sts=='SP_YQR'">
                        	预订成功
                        	</s:elseif>
                        	<s:else>
                        		<f:write type="酒店订单状态" value="${hotelOrderDetailsVo.sts}"></f:write>
                        	</s:else>
                       		 </b>
                        </li>
                        <c:if test="${not empty hotelOrderDetailsVo.ctime}">
                         <li>订单成生时间：<b>${hotelOrderDetailsVo.ctime}</b></li>
                        </c:if>
                       
                    </ul>
                    <ul class="clearfix_ x3">
                        <li>预订房型：<b>${hotelOrderDetailsVo.rname}</b></li>
                        <li>房间数量：<b><span class="orange1">${hotelOrderDetailsVo.rnum}</span>间</b></li>
                        <s:if test="hotelOrderDetailsVo.atime != null">
                       	 	<li>到店时间：<b>${hotelOrderDetailsVo.atime}-${hotelOrderDetailsVo.latime}</b></li>
                        </s:if>
                    </ul>
                    <ul class="clearfix_ x3">
                        <li>入住时间：<b>${hotelOrderDetailsVo.idate}</b></li>
                        <li>退房时间：<b>${hotelOrderDetailsVo.odate}</b></li>
                        <li>入住天数：<b>共<span class="orange1" id="daysIn">${hotelOrderDetailsVo.daysIn}</span>晚</b></li>
                    </ul>
                    <%--该段暂时注释		原因：接口数据不全 
                    <ul class="clearfix_ x3">
                        <li>加床数量：<b><span class="orange1">${hotelOrderDetailsVo.bedCount}*</span>张 (${hotelOrderDetailsVo.bedPrice}元/张)*</b></li>
                        <li>加床早餐数量:<b>${hotelOrderDetailsVo.breakfastCount}*</b></li>
                        <li><a href="javasrcipt:void(0);" class="margin_no" id="displayRoomInfo">查看每日房型价格明细</a></li>
                    </ul>
                    --%>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">入住人</b></span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ Uncertain paddingT10B10">
<!--                        <li><b>张小三</b><b>李小四</b><b>王宝</b><b>张三</b><b>李小平</b></li>-->
							<li>
								<b>${hotelOrderDetailsVo.pnames }</b>
							</li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">特殊要求</b></span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ Uncertain paddingT10B10">
                        <li>
                       		<b>${hotelOrderDetailsVo.sneed}&nbsp;</b>
                        </li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c">联系人信息</span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3">
                        <li>姓名：<b>${hotelOrderDetailsVo.name}</b></li>
                        <li>联系方式：<b>${hotelOrderDetailsVo.phone}</b></li>
                        <li>邮箱地址：<b>${hotelOrderDetailsVo.email}</b></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end-->
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">结算信息</b></span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ Uncertain paddingT10B10">
                        <li>
                        	<b>
                        	<%-- 2011-11-10 17:37 zhanghan edit
                        	<c:if test="${hotelOrderDetailsVo.paySts eq 'WZF'}">未支付</c:if>--%>
                        	<f:write type="酒店订单支付状态" value="${hotelOrderDetailsVo.paySts}"></f:write>
                        	&nbsp;</b>
                        </li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
                <div class="lineclear Accountheight"></div>
            </div>
            <div class="clear"></div>
            <div class="greytext" id="pager">
<%--				会员确认 		由于订单状态修改接口尚未提供,确认以开放--%>
            	<form action="${ctx}/hotelOrderAction!verifyHotelOrder.action" method="post" id="confirmForm">
            		<input type="hidden"  name="queryVo.code" value="${hotelOrderDetailsVo.code}">
            		<input type="hidden"  name="queryVo.sts" value="${hotelOrderDetailsVo.sts}">
            	</form>
            	<s:if test="hotelOrderDetailsVo.sts =='YQR' || hotelOrderDetailsVo.sts =='SP_YQR'">
            		<s:if test="hotelOrderDetailsVo.paySts == 'WZF'">
	            	 <a id="hotelOrderAction" 
	            	 	href="${ctx}/hotelOrderAction!verifyHotelOrder.action?queryVo.code=${hotelOrderDetailsVo.code}"
	        			class="button2" onclick="submitComfirm();return false;" id="submitConfirmButton">${user_confirm}
	        		</a>
	        		</s:if>
        		</s:if>
				<s:if test="hotelOrderDetailsVo.sts =='XD'||hotelOrderDetailsVo.sts =='SP_DQR'
						||(hotelOrderDetailsVo.sts=='YQR'&&hotelOrderDetailsVo.paySts=='YZF')
						||(hotelOrderDetailsVo.sts=='SP_YQR'&&hotelOrderDetailsVo.paySts=='YZF')">
            	<a href="javasrcipt:void(0);" class="button2 " id="cancel" onclick="return false;">取消订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
            	</s:if>
            	<a href="${ctx}/member/index.jsp?tabIndex=1" class="button2 ">返 回</a>
            </div>
            <div class="clear"></div>
            <div class="lineclear Accountheight"></div>
        </div>
        <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
    </div>
    <!-----------------------------------------RIGHT END------------------------------------>
    <div class="clear"></div>
<%--<table cellspacing="0" cellpadding="0" border="0" align="center" class="room_Price" style="display:none;"  >--%>
<%--    <tbody>--%>
<%--        <tr>--%>
<%--            <th class="date">01/07<br />--%>
<%--                01/14</th>--%>
<%--            <th>周三</th>--%>
<%--            <th>周四</th>--%>
<%--            <th>周五</th>--%>
<%--            <th class="orange1">周六</th>--%>
<%--            <th class="orange1">周日</th>--%>
<%--            <th>周一</th>--%>
<%--            <th>周二</th>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--	            <td>第一周</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	            <td class="blue">320<br>--%>
<%--	                双早</td>--%>
<%--	            <td class="blue">320<br>--%>
<%--	                双早</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	        </tr>--%>
<%--	        <tr>--%>
<%--	            <td>第二周</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	            <td class="blue">320<br>--%>
<%--	                双早</td>--%>
<%--	            <td class="blue">320<br>--%>
<%--	                双早</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--	            <td>320<br>--%>
<%--	                双早</td>--%>
<%--        </tr>--%>
<%--    </tbody>--%>
<%--</table>--%>
<script type="text/javascript">
//<![CDATA[
$(function(){
	// 每日房型价格
    $("#displayRoomInfo").hover(function(){
	    var h = $(this).height();
		var w2 = $(this).width();
		var w = $(".room_Price").width();
	    var left = $(this).position().left;
		var top = $(this).position().top;
	    $(".room_Price").show();
		$(".room_Price").css({"left":left-w+w2,"top":top+h+2});
	},function(){$(".room_Price").hide();});
	//取消
	$("#cancel").click(function(){
		cancel();
	});
	//计算天数
	computeDaysIn();
	//分割字符
	replaceSeparator();
	//输出提示信息
	outPutInfo();
});

//计算入住天数
function computeDaysIn(){
	var iDate="${hotelOrderDetailsVo.idate}";
	var oDate="${hotelOrderDetailsVo.odate}";
	if(iDate!=""&&oDate!=""){
		var timeI=dateStrToTime(iDate);
		var timeO=dateStrToTime(oDate);
		$("#daysIn").html(((timeO-timeI)/100000)/864);
	}
}
//替换分隔符
function replaceSeparator(){
	var tipInfo="${tipInfo}";
	if(tipInfo){
		alert(tipInfo);
	}
}

//取消
function cancel(){
	if(window.confirm("您确定要取消该订单吗?")){
		var url="${ctx}/hotelOrderAction!cancelOrder.action?code=${hotelOrderDetailsVo.code}";
		window.location=url;
	}
}

function outPutInfo(){
	
}
///////////////////////////////////////////工具函数
//yyyy-mm-dd类型的时间字符串转化为1970-01-01 00:00 到现在的毫秒
function dateStrToTime(dateStr){
	var str=dateStr;
   	var date = new Date(str.replace(/-/g,"/"));
	return date.getTime();
}
//string 转date对象
function dateStrToDate(dateStr){
	var str=dateStr;
	return new Date(str.replace(/-/g,"/"));
}
//获取1970-01-01 00:00 到现在的毫秒
function getCurrentTime(){
	return new Date().getTime();
}
function submitComfirm(){
	$("#confirmForm").submit();
	$("#submitConfirmButton").click(function (){return false;});
}
//]]>
</script>
</body>
