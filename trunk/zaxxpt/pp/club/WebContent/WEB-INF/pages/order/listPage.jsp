<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<title>我的积分兑换</title>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
    <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
    <div class="listTAB rightbg">
        <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt; <span class="cl1">我的积分兑换</span></div>
        <div id="Accountcenter">
            <div class="Current">
                <ul>
                    <li class="left Accountwidth"><img src="${ctx}/web/images/czmx_03.jpg"/></li>
                    <li  class="top_se currentwidth" style="width:100px"> <font class="fc666 cuti" color="#3b3b3b"> <a href="${ctx}/orderPointsExchangeAction!toAdd.action"> 发布积分兑换信息</a>
                    </font></li>
                    <li class="right Accountwidth"><img src="${ctx}/web/images/czmx_06.jpg"/></li>
                </ul>
            </div>
            <div class="right_h Tab_w762">
                <ul>
                    <li> <span class="ontag">我积分兑换信息
</span> </li>
                    <!-- <li> <a class="offtag" href="#">充值明细</a> </li> -->
                </ul>
            </div>
            <div class="clear"></div>
            <div class="listTAB" id="ContentBox_w762">
                <div id="Guests">
                    <ul>
                    	<li>
                    		<font class="Guests1" style="width: 11%;">兑换信息编号
</font>
                    		<font class="Guests2" style="width: 15%;">兑换积分
</font>
                    		<font class="Guests3" style="width: 10%;">报价
</font>
                    		<font class="Guests4" style="width: 20%;">发布时间
</font>
                    		<font class="Guests9" style="width: 15%;">信息状态</font>
                    		<font class="Guests10" style="width: 9%;">剩余时间
</font>
                    		<font class="Guests11">成交时间/操作</font>
                    	</li>
                    <s:iterator value="orderPointsExchangeVoList"  >
                    		<li class="greytext none">
                    			<font class="Guests1 F0B24A" style="width: 11%;">
                    				<s:property value="code"/>
                    			</font>
                    			<font class="Guests2" style="width: 15%;">
                    				<s:property value="points"/>
                    			</font>
                    			<font class="Guests3" style="width: 10%;">￥<s:property value="price"/></font>
                    			<font class="Guests4" style="width: 20%;"><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/></font>
                    			<font class="Guests9" style="width: 15%;"><f:write type="积分兑换状态" value="${sts}"></f:write></font>
                    			<font class="Guests10" style="width: 9%;">
                    			<!--判断是否过期  --> 
		              	 <s:set value="@com.hnatourism.club.common.util.DateUtils@comDate(createTime,expiredDay)" name="compVlaue"/> 
							<s:if test="@com.hnatourism.club.common.util.DateUtils@isExpired(createTime,expiredDay)" > <!-- 过期  -->
							<s:property value="compVlaue"/>天
							</s:if><s:else>
							过期 
							</s:else>
                    		</font>
                    			<font class="Guests11" style="width: 18%;">
                    			<s:if test="sts==1">
                    			<a href="${ctx}/orderPointsExchangeAction!modify.action?orderPointsExchangeVo.id=<s:property value="id"/>&&orderPointsExchangeVo.sts=3">取消</a>
                    			</s:if>
                    			<s:if test="sts==2 || sts==5">
                    			<s:date name="conversionTime" format="yyyy-MM-dd HH:mm:ss"/>
                    			</s:if>
                    			</font>
                    		</li>
                    </s:iterator>
                    </ul>
                </div>
            </div>
            <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>
        </div>
        <div class="clear"></div>
        <div class="greytext" id="pager"><font class="Guests7">共<s:property value="pageInfo.totalRowCount"/>条记录</font>
        <font class="Guests2"> </font><font class="yema Guests8">
        	<s:if test="pageInfo.currentPageNum==0">
            	<img src="${ctx}/web/images/yema1.jpg" />
            </s:if>
            <s:else>
            	<a href="${ctx}/orderPointsExchangeAction!search.action?pageInfo.currentPageNum=<s:property value="pageInfo.currentPageNum-1"/>"><img src="${ctx}/web/images/yema1.jpg" /></a>
            </s:else>
            	<A href="${ctx}/orderPointsExchangeAction!search.action">首页</A>
            <s:iterator begin="1" end="pageInfo.totalPageCount" step="1" status="item">
            <s:if test="pageInfo.currentPageNum==#item.index">
            	<A href="${ctx}/orderPointsExchangeAction!search.action?pageInfo.currentPageNum=<s:property value="#item.index"/>" class="yemaa">
            </s:if>
            <s:else>
            	<A href="${ctx}/orderPointsExchangeAction!search.action?pageInfo.currentPageNum=<s:property value="#item.index"/>">
            </s:else>
            	<s:property value="#item.index+1"/></A>
            </s:iterator>
            	<A href="${ctx}/orderPointsExchangeAction!search.action?pageInfo.currentPageNum=<s:property value="pageInfo.totalPageCount-1"/>">尾页</A>
            <s:if test="pageInfo.currentPageNum==pageInfo.totalPageCount-1">
            	<img src="${ctx}/web/images/yema2.jpg" />
            </s:if>
            <s:else>
            	<a href="${ctx}/orderPointsExchangeAction!search.action?pageInfo.currentPageNum=<s:property value="pageInfo.currentPageNum+1"/>"><img src="${ctx}/web/images/yema2.jpg" /></a>
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

