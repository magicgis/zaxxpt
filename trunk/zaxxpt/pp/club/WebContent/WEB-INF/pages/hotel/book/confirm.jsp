<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<META HTTP-EQUIV="pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache,   must-revalidate">
	<META HTTP-EQUIV="expires" CONTENT="0">
	<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet"
		type="text/css" />
	<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
	<title>酒店订单确认</title>
	<script type="text/javascript">
function firm(code, memberId, source) {

	if (window.confirm("确认取消订单吗？")) {
		if (totalBall != 0 && totalBall != "") {
			amount = amount + totalBall * 100;
		}
		window.location = "${ctx}/hotelOrderAction!toModify.action?hotel.code="
				+ code;
	}
}
window.onload = init;
function init() {
	var message = document.getElementById("message");
	if (message.value != "") {
		alert(message.value);
		document.getElementById("closeButtom").style.display = "none";
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
					<span class="l"></span><span class="c"><s:property
							value="hotel.hname" />
					</span><span class="r"></span>
					<span><s:property value="hotel.totalMoney" />
					</span><span class="r"></span>
				</div>
				<div class="inner clearfix_">
					<ul class="clearfix_ x3">
						<li>
							订单号：
							<b><s:property value="hotel.code" /> </b>
						</li>
						<li>
							订单状态：
							<b><f:write type="酒店订单状态" value="${hotel.sts}" /> </b>
						</li>
						<li>
							订单生成时间：
							<b><s:date name="hotel.orderCreateDate"
									format="yyyy-MM-dd HH:mm" />
							</b>
						</li>
					</ul>
					<ul class="clearfix_ x3">
						<li>
							预订房型：
							<b><s:property value="hotel.rname" escape="false" /> </b>
						</li>
						<li>
							房间数量：
							<b><s:property value="hotel.rnum" escape="false" /> </b>
						</li>
						<li>
							加床数量：
							<b><s:property value="hotel.bedCount" escape="false" /> </b>
						</li>
					</ul>
					<ul class="clearfix_ x3">
						<li>
							入住时间：
							<b><s:date name="hotel.idate" format="yyyy-MM-dd HH:mm" /> </b>
						</li>
						<li>
							退房时间：
							<b><s:date name="hotel.odate" format="yyyy-MM-dd HH:mm" /> </b>
						</li>
						<li>
							入住天数：
							<b><s:property value="hotel.dayCount" escape="false" /> </b>
						</li>
					</ul>
					<ul class="clearfix_ x3">
						<li>
							到店时间：
							<b><s:date name="hotel.adate" format="yyyy-MM-dd HH:mm" /> </b>
						</li>
						<li align="">
							<a href="#">查看每日房型价格明细 </a>
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
					<span class="l"></span><span class="c">入住人</span><span class="r"></span>
				</div>
				<div class="inner clearfix_">
					<ul class="clearfix_ x2">
						<li>
							<span class="t"><s:property value="hotel.pnames"
									escape="false" /> </span>
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
					<span class="l"></span><span class="c">特殊要求</span><span class="r"></span>
				</div>
				<div class="inner clearfix_">
					<ul class="clearfix_ x2">
						<li>
							<b><s:property value="hotel.rmk" escape="false" /> </b>
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
					<span class="l"></span><span class="c">联系人信息</span><span class="r"></span>
				</div>
				<div class="inner clearfix_">
					<ul class="clearfix_ x2">
						<li>
							姓名：
							<b><s:property value="hotel.name" escape="false" /> </b>
						</li>
						<li>
							联系方式：
							<b><s:property value="hotel.phone" escape="false" /> </b>
						</li>
						<li>
							邮箱地址：
							<b><s:property value="hotel.email" escape="false" /> </b>
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
					<span class="l"></span><span class="c">结算信息</span><span class="r"></span>
				</div>
				<div class="inner clearfix_">
					<ul class="clearfix_ x2">
						<li>
							<b><s:property value="hotel.rmk" escape="false" /> </b>
						</li>
					</ul>
				</div>
				<b class="bl"></b>
				<b class="br"></b>
			</div>
			<!--Module end-->
			<div class="clear"></div>
			<div class="greytext" id="pager">
				<s:if test="order.sts!=0">
				</s:if>
				<span id="closeButtom" style="cursor: pointer;"
					onclick="firm('<s:property value="hotel.code"/>')"
					class="button1 cuti commenminites">取消订单 &gt;&gt;</span>

				<span id="closeButtom" style="cursor: pointer;" onclick=""
					class="button1 cuti commenminites">返&nbsp;&nbsp;回 &gt;&gt;</span>
			</div>
			<div class="clear"></div>

		</div>
		<div width="982px" class="lineclear">
			<img src="${ctx}/web/images/right_bott.jpg" width="982px" />
		</div>
	</div>
	<!-----------------------------------------RIGHT END------------------------------------>
	<div class="clear"></div>
	<s:hidden name="message" id="message"></s:hidden>
</body>





