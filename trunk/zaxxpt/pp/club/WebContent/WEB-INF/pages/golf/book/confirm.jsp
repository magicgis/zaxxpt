<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<META   HTTP-EQUIV="pragma"   CONTENT="no-cache">        
 <META   HTTP-EQUIV="Cache-Control"   CONTENT="no-cache,   must-revalidate">        
<META   HTTP-EQUIV="expires"   CONTENT="0">  
	<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet"
		type="text/css" />
	<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
	<title>高尔夫订单确认</title>
	<script type="text/javascript">
function firm(orderId,totalBall,priceid,amount) {

	if (window.confirm("确认取消订单吗？")) {
		if(totalBall!=0 && totalBall!=""){
			amount=amount+totalBall*100;
		}
	    window.location="${ctx}/golfCancel.action?orderId="+orderId+"&&priceid="+priceid+"&&amount="+amount;
	}
}
window.onload=init;
function init(){
	var message=document.getElementById("message");
	if(message.value!=""){
		alert(message.value);
		document.getElementById("closeButtom").style.display="none";
	}
}
</script>
</head>
<body>
	<div id="tips" class="ck1" style="display: none; width: 238px;">
		<a title="关闭" href="javascript:closeTips('tips')">X</a>
		<h2>
			退票规定：
		</h2>
		<p>
			收取票面价（不含税）的10%作为退票费;
		</p>
		<h2>
			改签规定：
		</h2>
		<p>
			不论在航班离站前或后，同舱位免费变更，不限次数。
		</p>
	</div>
	<!----------------------------------------- RIGHT ------------------------------------>

	<div style="margin: 0 auto; width: 982px;">
		<div style="width: 982px;" class="lineclear">
			<img src="${ctx}/web/images/right_top.jpg" width="982px" />
		</div>
		<div class="listTAB rightbg">
			<div class="clear"></div>
			<!--Module-->
			<div class="module_a Order">
				<div class="title">
					<span class="l"></span><span class="c">高尔夫订单确认</span><span
						class="r"></span>
				</div>
				<div class="inner clearfix_">
					<ul class="clearfix_ x3">
						<li>
							订单号：
							<b><s:property value="order.code" /> </b>
						</li>
						<li>
							订单状态：
							<b><f:write type="高尔夫订单状态" value="${order.sts}"/> </b>
						</li>
						<li>
							订单生成时间：
							<b><s:date name="order.createTime" format="yyyy-MM-dd HH:mm"/></b>
						</li>
					</ul>
					<ul class="clearfix_ x2">
						<li>
							订场规则：
							<b><s:property value="golfSiteVo.rmk"  escape="false"/> </b>
						</li>
						<li>
							<span class="fsz16 f_yh">订单总金额：<b><s:property
										value="order.amountPrice" /> </b> </span>
						</li>
					</ul>
				</div>
				<b class="bl"></b>
				<b class="br"></b>
			</div>
			<!--Module end-->
			<!--Module-->
			<div class="module_a Order">
				<div class="title">
					<span class="l"></span><span class="c">预订球场信息</span><span class="r"></span>
				</div>
				<div class="inner clearfix_">
					<ul class="clearfix_ x2">
						<li>
							<span class="t"><s:property value="golfSiteVo.name"  escape="false"/> </span><a
								href="${ctx}/golf/view.jsp?id=<s:property value="golfInfoVo.id" />">查看详情</a>
						</li>
						<li>
							下场日期：
							<b><s:date name="order.bookTime" format="yyyy-MM-dd"/> </b>
						</li>
					</ul>
					<ul class="clearfix_ x3">
						<li>
							球场类型：
							<b><f:write type="球场类型" value="${golfSiteVo.type}"/> </b>
						</li>
						<li>
							场地：
							<b><s:property value="golfSiteVo.name" escape="false"/> </b>
						</li>
						<s:if test="golfSiteVo.type ==0">
							<li>
								产品名称：
								<b><s:property value="golfInfoVo.name" escape="false"/> </b>
							</li>
						</s:if>
						<li>
						
							免费项目：
							<b><f:write2 type="GF包含项目" value="${golfPriceVo.containItem}" regexValue=","></f:write2> </b>
						</li>
					</ul>
				</div>
				<b class="bl"></b>
				<b class="br"></b>
			</div>
			<!--Module end-->
			<!--Module-->
			<div class="module_a Order">
				<div class="title">
					<span class="l"></span><span class="c">预订信息</span><span class="r"></span>
				</div>
				<div class="inner clearfix_">
				
				
					
						<ul class="clearfix_ x3">
							<s:if test="golfSiteVo.type == '1'">
							<li>
								所购球数：
								<b><s:property value="order.totalBall" /> </b>
							</li>
							</s:if>	
							<li>
								打位数：
								<b><s:property value="order.count" /> </b>
							</li>
							<li>
								姓名：
								<b>
								<s:iterator value="golfOrderPlayVoList">
								<s:property value="name" escape="false"/> &nbsp;
								</s:iterator>
								</b>
							</li>
						</ul>
						<ul class="clearfix_ x4">
							<li>
								开球时间：
								<b><s:date name="order.bookTime" format="yyyy-MM-dd HH:mm"/> </b>
							</li>
						</ul>
						<s:if test="order.STS == 1">   <!-- 预定成功   1-->
							<ul class="clearfix_ x3">
								<li>
									<button type="button">
										申请退场
									</button>
									<button type="button">
										申请改期
									</button>
								</li>
							</ul>
						</s:if>
					
					<s:if test="golfSiteVo.type == 0">
						<ul class="clearfix_ x3">
							<s:if test="order.STS == 0">  <!-- 等待确认  0 -->
								<li>
									打位数：
									<b><s:property value="order.playerCount" /> </b>
								</li>
								<li>
									姓名：
									<b><s:property value="order.playerNames" /> </b>
								</li>
								<li>
									开球时间：
									<b><s:date name="order.bookTime" format="yyyy-MM-dd HH:mm"/></b>
								</li>
							</s:if>
							<s:if test="order.STS == 2"> <!-- 已取消  2 -->
								<li>
									确认开球时间：
									<b><s:date name="order.bookDate" format="yyyy-MM-dd HH:mm"/></b>
								</li>
							</s:if>
						</ul>
						<s:if test="order.STS == 1">   <!-- 预定成功   1-->
							<ul class="clearfix_ x3">
								<li>
									<button type="button">
										申请退场
									</button>
									<button type="button">
										申请改期
									</button>
								</li>
							</ul>
						</s:if>
					</s:if>
				</div>
				<b class="bl"></b>
				<b class="br"></b>
			</div>
			<!--Module end-->
			<!--Module-->
			<div class="module_a Order">
				<div class="title">
					<span class="l"></span><span class="c">联系人信息</span><span class="r"></span>
				</div>
				<div class="inner clearfix_">
					<ul class="clearfix_ x2">
						<li>
							姓名：
							<b><s:property value="orderContactVo.name" escape="false"/> </b>
						</li>
						<li>
							联系方式：
							<b><s:property value="orderContactVo.mobile" /> </b>
						</li>
					</ul>
				</div>
				<b class="bl"></b>
				<b class="br"></b>
			</div>
			<!--Module end-->
			<div class="clear"></div>
				<div class="greytext" id="pager">
					<a href="${ctx}/member/order.jsp" class="button2 cuti">订单管理 &gt;&gt;</a>
					<s:if test="order.sts!=0">
					<span id="closeButtom"  style="cursor:pointer;" onclick="firm('<s:property value="orderId"/>','<s:property value="totalBall"/>','<s:property value="golfPriceVo.id"/>','<s:property value="golfPriceVo.amount"/>,')"
						class="button1 cuti commenminites">取消订单 &gt;&gt;</span>
					</s:if>
				</div>
			<div class="clear"></div>
			<!--Module-->
			<div class="module_a Order">
				<div class="title">
					<span class="l"></span><span class="c"><span>订单状态跟踪信息</span><span
						class="Order_Status"><b class="red"></b> </span> </span><span
						class="r"></span>
				</div>
				<div class="inner clearfix_">
					<table style="width: 982px;" cellspacing="1" cellpadding="0"
						border="0" class="BuyCard Table_w762 innerOrder">
						<tbody>
							<tr>
								<th width="150">
									时间
								</th>
								<th>
									跟踪记录显示
								</th>
							</tr>
							<s:iterator value="golfOrderLogVoList" id="list">
								<tr>
									<td>
									<s:date name="#list.createTime" format="yyyy-MM-dd HH:mm"/>
									</td>
									<td>
										<s:property value="#list.content"  escape="false"/>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<b class="bl"></b>
				<b class="br"></b>
			</div>
			<!--Module end-->
		</div>
		<div width="982px" class="lineclear">
			<img src="${ctx}/web/images/right_bott.jpg" width="982px" />
		</div>
	</div>
	<!-----------------------------------------RIGHT END------------------------------------>
	<div class="clear"></div>
	<s:hidden name="message" id="message"></s:hidden>
</body>






