<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<title>我的资金账户明细</title>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
    <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
    <div class="listTAB rightbg">
        <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt; <span class="cl1">我的资金账户明细</span></div>
        <div id="Accountcenter">
            <div class="Current">
                <ul>
                    <li class="left Accountwidth"><img src="${ctx}/web/images/czmx_03.jpg"/></li>
                    <li  class="top_se currentwidth"> <font class="fc666 cuti"> 账户余额：<b class="db7c00"><s:property value="payInfo.AcctBal"/>元</b></font>&nbsp;&nbsp;积分兑换交易中：<b class="db7c00"><s:property value="currentlyTradingPoint"/>积分</b></li>
                    <li class="right Accountwidth"><img src="${ctx}/web/images/czmx_06.jpg"/></li>
                </ul>
            </div>
            <div class="right_h Tab_w762">
                <ul>
                    <li> <span class="ontag">收入/支出明细</span> </li>
                    <!-- <li> <a class="offtag" href="#">充值明细</a> </li> -->
                </ul>
            </div>
            <div class="clear"></div>
            <div class="listTAB" id="ContentBox_w762">
                <div id="Guests">
                    <ul>
                    	<li>
                    		<font class="Guests1" style="width: 11%;">产品</font>
                    		<font class="Guests2" style="width: 15%;">类型</font>
                    		<font class="Guests3" style="width: 19%;">日期</font>
                    		<font class="Guests4" style="width: 15%;">交易流水号</font>
                    		<font class="Guests9" style="width: 11%;">相关订单号</font>
                    		<font class="Guests10" style="width: 9%;">金额</font>
                    		<font class="Guests11">状态</font>
                    	</li>
                    <s:iterator value="orderbilllist" var="bill" status="item">
                    	<s:if test="#item.last">
                    		<li class="greytext none">
                    			<font class="Guests1 F0B24A" style="width: 11%;">
                    				<s:if test='#bill.prodType=="GF"'>高尔夫</s:if>
                    				<s:elseif test='#bill.prodType=="L"'>机场休息室</s:elseif>
                    				<s:elseif test='#bill.prodType=="F"'>机票</s:elseif>
                    				<s:elseif test='#bill.prodType=="H"'>酒店</s:elseif>
                    				<s:elseif test='#bill.prodType=="P"'>
                    				<s:if test="#bill.transactionType==1">
                    				返积分
                    				</s:if>
                    				<s:if test="#bill.transactionType==3">
                    				充值
                    				</s:if>
                    				</s:elseif><s:else>
                    				其它产品
                    				</s:else>
                    			</font>
                    			<font class="Guests2" style="width: 15%;">
                    				<f:write type="订单消费状态" value="${bill.consumeSts}"></f:write>
                    				<s:if test='#bill.orderType=="N"'>
                    					（订单）
                    				</s:if>
                    				<s:else>
                    					（退改）
                    				</s:else>
                    			</font>
                    			<font class="Guests3" style="width: 19%;"><s:date name="#bill.tradeTime" format="yyyy-MM-dd HH:mm:ss"/></font>
                    			<font class="Guests4" style="width: 15%;"><s:property value="#bill.tradeNo" default="无"/></font>
                    			<font class="Guests9" style="width: 11%;"><s:property value="#bill.orderCode" default="无"/></font>
                    			<font class="Guests10" style="width: 9%;"><b class="db7c00"><s:property value="#bill.mny"/>元</b></font>
                    			<font class="Guests11">
                   				<s:if test='#bill.status=="00"'>
                   					未支付
                   				</s:if>
                   				<s:elseif test='#bill.status=="01"'>
                   					成功
                   				</s:elseif>
                   				<s:elseif test='#bill.status=="02"'>
                   					失败
                   				</s:elseif>
                   				<s:elseif test='#bill.status=="03"'>
                   					审核中
                   				</s:elseif>
                    			</font>
                    		</li>
                    	</s:if>
                    	<s:else>
                    		<li class="greytext">
                    			<font class="Guests1 F0B24A" style="width: 11%;">
                    				<s:if test='#bill.prodType=="GF"'>高尔夫</s:if>
                    				<s:elseif test='#bill.prodType=="L"'>机场休息室</s:elseif>
                    				<s:elseif test='#bill.prodType=="F"'>机票</s:elseif>
                    				<s:elseif test='#bill.prodType=="H"'>酒店</s:elseif>
                    				<s:elseif test='#bill.prodType=="P"'>
                    				<s:if test="#bill.transactionType==1">
                    				返积分
                    				</s:if>
                    				<s:if test="#bill.transactionType==3">
                    				充值
                    				</s:if>
                    				</s:elseif><s:else>
                    				其它产品
                    				</s:else>
                    			</font>
                    			<font class="Guests2" style="width: 15%;">
                    				<f:write type="订单消费状态" value="${bill.consumeSts}"></f:write>
                    				<s:if test='#bill.orderType=="N"'>
                    					（订单）
                    				</s:if>
                    				<s:else>
                    					（退改）
                    				</s:else>
                    			</font>
                    			<font class="Guests3" style="width: 19%;"><s:date name="#bill.tradeTime" format="yyyy-MM-dd HH:mm:ss"/></font>
                    			<font class="Guests4" style="width: 15%;"><s:property value="#bill.tradeNo" default="无"/></font>
                    			<font class="Guests9" style="width: 11%;"><s:property value="#bill.orderCode" default="无"/></font>
                    			<font class="Guests10" style="width: 9%;"><b class="db7c00"><s:property value="#bill.mny"/>元</b></font>
                    			<font class="Guests11">
                    			<s:if test='#bill.status=="00"'>
                   					未支付
                   				</s:if>
                   				<s:elseif test='#bill.status=="01"'>
                   					成功
                   				</s:elseif>
                   				<s:elseif test='#bill.status=="02"'>
                   					失败
                   				</s:elseif>
                   				<s:elseif test='#bill.status=="03"'>
                   					审核中
                   				</s:elseif>
                    			</font>
                    		</li>
                    	</s:else>
                    </s:iterator>
                    </ul>
                </div>
                <div id="Guests_" style="display:none;">
                    <ul>
                        <li><font class="Guests1">类型</font><font class="Guests2">交易日期</font><font class="Guests3">交易流水号</font><font class="Guests4">充值方式</font><font class="Guests9">充值金额</font><font class="Guests10">状态</font><font class="Guests11">备注</font></li>
                        <li class="greytext"><font class="Guests1 F0B24A">消费（酒店）</font><font class="Guests2">2010-6-10</font><font class="Guests3">111111111111</font><font class="Guests4">11111111111111</font><font class="Guests9"><b class="db7c00">3000元</b></font><font class="Guests10">成功</font><font class="Guests11">成功</font></li>
                        <li class="greytext"><font class="Guests1 F0B24A">消费（酒店）</font><font class="Guests2">2010-6-10</font><font class="Guests3">111111111111</font><font class="Guests4">11111111111111</font><font class="Guests9"><b class="db7c00">3000元</b></font><font class="Guests10">成功</font><font class="Guests11">成功</font></li>
                        <li class="greytext"><font class="Guests1 F0B24A">消费（酒店）</font><font class="Guests2">2010-6-10</font><font class="Guests3">111111111111</font><font class="Guests4">11111111111111</font><font class="Guests9"><b class="db7c00">3000元</b></font><font class="Guests10">成功</font><font class="Guests11">成功</font></li>
                        <li class="greytext"><font class="Guests1 F0B24A">消费（酒店）</font><font class="Guests2">2010-6-10</font><font class="Guests3">111111111111</font><font class="Guests4">11111111111111</font><font class="Guests9"><b class="db7c00">3000元</b></font><font class="Guests10">成功</font><font class="Guests11">成功</font></li>
                        <li class="greytext"><font class="Guests1 F0B24A">消费（酒店）</font><font class="Guests2">2010-6-10</font><font class="Guests3">111111111111</font><font class="Guests4">11111111111111</font><font class="Guests9"><b class="db7c00">3000元</b></font><font class="Guests10">成功</font><font class="Guests11">成功</font></li>
                        <li class="greytext none"><font class="Guests1 F0B24A">消费（酒店）</font><font class="Guests2">2010-6-10</font><font class="Guests3">111111111111</font><font class="Guests4">11111111111111</font><font class="Guests9"><b class="db7c00">3000元</b></font><font class="Guests10">成功</font><font class="Guests11">成功</font></li>
                    </ul>
                </div>
            </div>
            <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>
        </div>
        <div class="clear"></div>
        <div class="greytext" id="pager"><font class="Guests7"></font>
        <font class="Guests2"> </font><font class="yema Guests8">
        <s:if test="pageInfo.currentPageNum==1">
            	<img src="${ctx}/web/images/yema1.jpg" />
            </s:if>
            <s:else>
            	<a href="${ctx}/member/account.jsp?page=<s:property value="pageInfo.currentPageNum-1"/>"><img src="${ctx}/web/images/yema1.jpg" /></a>
            </s:else>
            	<A href="${ctx}/member/account.jsp">首页</A>
            <s:iterator begin="1" end="pageInfo.totalPageCount" step="1" status="item">
            <s:if test="pageInfo.currentPageNum==#item.index+1">
            	<A href="${ctx}/member/account.jsp?page=<s:property value="#item.index+1"/>" class="yemaa">
            </s:if>
            <s:else>
            	<A href="${ctx}/member/account.jsp?page=<s:property value="#item.index+1"/>">
            </s:else>
            	<s:property value="#item.index+1"/></A>
            </s:iterator>
            	<A href="${ctx}/member/account.jsp?page=<s:property value="pageInfo.totalPageCount"/>">尾页</A>
            <s:if test="pageInfo.currentPageNum==pageInfo.totalPageCount">
            	<img src="${ctx}/web/images/yema2.jpg" />
            </s:if>
            <s:else>
            	<a href="${ctx}/member/account.jsp?page=<s:property value="pageInfo.currentPageNum+1"/>"><img src="${ctx}/web/images/yema2.jpg" /></a>
            </s:else>
        <a href="#" name="btop"><img src="${ctx}/web/images/gototop.jpg" /></a></font></div>
        <div class="clear"></div>
        <div class="clear"></div>
        <div class="lineclear Accountheight"></div>
    </div>
    <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
</div>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
</div>

<script type="text/javascript">
$(function(){
	// tab
    $(".Tab_w762 > ul > li").click(function(){
        var index = $(".Tab_w762 > ul > li").index(this);
        $(this).children("a").attr("class","ontag").end().siblings().children("a").attr("class","offtag");
        $("#ContentBox_w762 >div").eq(index).show().siblings().hide();
    });
});
</script>
</body>

