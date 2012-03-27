<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightMemberPassenVo"%>
<%@page import="java.util.ArrayList"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet"
		type="text/css" />
	<link href="${ctx}/web/css/select2css.css" rel="stylesheet"
		type="text/css" />
	<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js"
		language="javascript"></script>
	<title>出售积分</title>
	<script type="text/javascript">
	//去除空格
	String.prototype.trim = function() {
		//   用正则表达式将前后空格
		//   用空字符串替代。
		return this.replace(/(^\s*)|(\s*$)/g, "");
	}
	//判断是否为数字
	function isdigit(s) {
		var r, re;
		re = /\d*/i; //\d表示数字,*表示匹配多个数字
		r = s.match(re);
		return (r == s) ? 1 : 0;
	}

	function submitForm() {

		var points = document.getElementById("orderPointsExchangeVo.points");
		var price = document.getElementById("orderPointsExchangeVo.price");
		var expiredDay = document.getElementById("orderPointsExchangeVo.expiredDay");
		var remainingPoints=document.getElementById("remainingPoints");
		
		if (points.value.trim() == "" || isdigit(points.value.trim())==0 || points.value.trim()==0 || points.value.trim()%100!=0) {
			alert("请正确输入积分");
			points.focus();
			return;
		}
		if(parseInt(points.value.trim())>parseInt(remainingPoints.value)){
			alert("输入积分大于可出售积分");
			points.focus();
			return;
		}
		if (price.value.trim() == "" || isdigit(price.value.trim())==0) {
			alert("请正确输入价格");
			price.focus();
			return;
		}
		if(parseInt(points.value.trim())<parseInt(price.value.trim())){
			alert("价格大于积分");
			price.focus();
			return;
		}
		if (expiredDay.value.trim() == "" || isdigit(expiredDay.value.trim())==0 || expiredDay.value.trim()==0) {
			alert("请正确输入过期天数");
			expiredDay.focus();
			return;
		}
		document.forms.passengerForm.submit();
	}
</script>
</head>
<body>
	<div class="main">
		<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
		<!----------------------------------------- RIGHT ------------------------------------>
		<div class="floatleft width783">
			<div class="lineclear">
				<img src="${ctx}/web/images/right_top.jpg" />
			</div>
			<div class="listTAB rightbg">
				<div id="path">
					<a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt;
					<a href="${ctx}/member/often.jsp" class="cl0"> 我的积分兑换 </a>
				</div>
				<div id="Accountcenter">
					<div class="right_h">
						<ul>
							<li class="left Accountwidth">
								<img src="${ctx}/web/images/right_h_l.jpg" />
							</li>
							<li class="right_h_bg widtha">
								<div class="grf_tag4">
									<a href="#" class="ontag"> <s:if test='action=="add"'>
            	修改
            </s:if> <s:else>
            	发布兑换信息
            </s:else> </a>
								</div>
							</li>
							<li class="right_h_bg widthb"></li>
							<li class="right Accountwidth">
								<img src="${ctx}/web/images/right_h_r.jpg" />
							</li>
						</ul>
					</div>
					<div class="clear"></div>
					<div class="listTAB width760">
						<form name="passengerForm"
							action="${ctx}/orderPointsExchangeAction!add.action"
							method="post">
							<ul id="accoutcontent">
								<li>
									积分兑换是指您自行转让您的权益积，其他会员可以购买。兑换信息发布后，我们将冻结您所转让的积分。直至订单取消。成交后，系统自动从您的账户中，扣除该笔积分，并自动为您账户充值该转让信息的成交金额。
								</li>
								<li>
									<B>您当前可供兑换的权益积分
									<s:if test="remainingPoints<100">
										<s:if test="remainingPoints<0">
										0
										</s:if><s:else>
										 ${remainingPoints }小于100
										</s:else>
									</s:if><s:else>
									${remainingPoints }
									</s:else>
									 </B>
								</li>
							<s:if test="remainingPoints>=100">
								<li>
									兑换积分：
									<s:textfield id="orderPointsExchangeVo.points" theme="simple"
										name="orderPointsExchangeVo.points"></s:textfield>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*必须为100的整数倍，并且不能多于您的权益积分
								</li>
								<li>
									&nbsp;&nbsp;&nbsp;&nbsp;报价：
									<s:textfield id="orderPointsExchangeVo.price" theme="simple"
										name="orderPointsExchangeVo.price"></s:textfield>
									元&nbsp;&nbsp;&nbsp;&nbsp;*必须为整数，并且不可以大于出售积分
								</li>
								<li>
									&nbsp;&nbsp;有效期：
									<s:textfield id="orderPointsExchangeVo.expiredDay"
										theme="simple" name="orderPointsExchangeVo.expiredDay"></s:textfield>
									天&nbsp;&nbsp;&nbsp;&nbsp;*必须为整数
								</li>
								<li>
									<span><a href="javascript:submitForm()"
										class="button_qx">发布</a>
									</span>
								</li>
								</s:if>
							</ul>
						</form>
						
						<s:hidden id="remainingPoints" name="remainingPoints"></s:hidden>
					</div>
					<div class="lineclear left">
						<img src="${ctx}/web/images/right_l_bott.jpg" />
					</div>
				</div>
				<div class="clear"></div>
				<div class="lineclear Accountheight"></div>
			</div>
			<div class="lineclear">
				<img src="${ctx}/web/images/right_bott.jpg" />
			</div>
		</div>
		<!-----------------------------------------RIGHT END------------------------------------>
		<div class="clear"></div>
	</div>
	<script type="text/javascript" defer="defer">
	function showUpdResult(result) {
		if (result == "success") {
			alert("修改成功！！！！！！");
		} else if (result == "error") {
			alert("修改失败！！！！！！");
		}
	}

	//	showUpdResult('__tag_185$18_');
</script>
</body>
