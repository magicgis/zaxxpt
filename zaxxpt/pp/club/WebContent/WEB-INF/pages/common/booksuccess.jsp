<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<title>${domain_cn }</title>
<script type="text/javascript">
	function jump(id)
	{
		window.location.href="viewOrderDetailAction.action?id="+id;
	}
</script>
</head>
<body>
<div class="width_m5"><img src="${ctx}/web/images/xx_top.jpg" /></div>
<div class="border_e4 Wmargin bg_fb">
    <div class="ddh_xq ddh_xq1">订单号：<span class="orange"><s:property value="orderCode"/></span> 订单总额：<span class="orange"><s:property value="amountPrice"/></span>元</div>
    <div class="bordere0 Wmargin96 height100f automargin h_auto pb_20"> 
        <dl class="Tips">
            <dt>友情提示：</dt>
            <dd>您的订单已经提交，请等待客服确认。</dd>
            <dd>如有疑问请您咨询客服热线<span class="orange">  4008851666</span>。</dd>
        </dl>
        <!--<s:if test='golfType=="1"'>
        	<button type="button" class="Btn101_25" >立即支付</button>
        </s:if>
        -->
        <button type="button" class="Btn101_25" onclick="jump('<s:property value="orderId"/>')">查看订单详情</button>
    </div>
</div>
<div class="Wmargin"><img src="${ctx}/web/images/jd_list_bbottom.jpg" /></div>
</body>




 
