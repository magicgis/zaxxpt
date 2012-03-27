<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<title>入会申请成功 - ${domain_cn }</title>
</head>
<body>
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg"></li>
        <li class="sebj"><a class="se" href="#">首页</a> &gt; <a class="se1" href="#">会员在线申请</a></li>
        <li><img src="${ctx}/web/images/seright.jpg"></li>
    </ul>
</div>
<div class="width_m5"><img src="${ctx}/web/images/xx_top.jpg" /></div>
<div class="border_e4 Wmargin bg_fb">
    <div class="bordere0 Wmargin96 height100f automargin h_auto pb_20 Processs"> 
        <dl class="Tips">
            <dt>您的入会申请我们已经收到！</dt>
            <dd>俱乐部将在收到会费后的一个工作日内为您开通会员身份。</dd>
            <dd>入会收款帐号：<span class="orange">  6666 6666 6666 6666 666</span>。</dd>
            <dd>开户行名称：交通银行北京市分行三元桥营业室</dd>
            <dd>如有疑问，请即致电<span class="orange">${site_tel }</span></dd>
        </dl>
        		<%--
	            <dt>短信内容：</dt>
	            <dd>尊敬的【姓名】先生/小姐，您的入会申请我们已经收到。${domain_cn }收款帐号：6666 6666 6666 6666 666。开户行名称：交通银行北京市分行三元桥营业室。我们将在收到会员费1个工作日内为您开通会员身份。如有疑问，请即致电${site_tel}。[${domain_cn}]。</dd>
        		 --%>
        <dl class="Tips">
	            <dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</dt>
	            <dd>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            </dd>
        </dl>
        <%--
        <button type="button" class="Btn101_25" onclick="javascript:history.go(-1)" >返 回</button>
         --%>
        <button type="button" class="Btn101_25" onclick="javascript:goback();" >返 回</button>
    </div>
</div>
<form action="" method="post" id="myform"></form>
<script type="text/javascript">
	function goback(){
		$("#myform").attr("action","${ctx}/index.jsp");
		$("#myform").submit();
	}
</script>
<div class="Wmargin"><img src="${ctx}/web/images/jd_list_bbottom.jpg" /></div>
</body>
</html>