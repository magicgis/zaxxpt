<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<TITLE>在线充值 _ ${domain_cn} </TITLE>
<script type="text/javascript">
 function onSumit(){
 	var account=document.getElementById("payVo.account");
 	if(account.value&&/^[1-9][0-9]*$/g.test(account.value)){
	 	document.savePay.submit();
 	}else {
 		alert("请输入正确的充值金额,且必须为整数");
 	}
 }
</script>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
  <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
  <div class="listTAB rightbg">
    <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt; <a href="${ctx}/member/account.jsp" class="cl0"> 我的资金账户 </a> &gt; <span class="cl1">在线充值</span></div>
    <div id="Accountcenter">
      <div class="right_h">
        <ul>
          <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
          <li class="right_h_bg widtha">
            <div class="grf_tag4"><a href="#" class="ontag">在线充值</a></div>
          </li>
          <li class="right_h_bg widthb">&nbsp;</li>
          <li class="right Accountwidth"><img src="${ctx}/web/images/right_h_r.jpg"/></li>
        </ul>
      </div>
      <div class="clear"></div>
      <form action="${ctx}/pay/payAction!depOnlineSave.action" name="savePay">
      <div class="password">
        <div id="Modify_pass">
          <ul>
            <li><font class="Modifypassword">请输入充值金额：</font>
              <input id="payVo.account" name="payVo.account" type="text" class="textfields" /> 
            </li>
            <li class="fc666 Tips">提示：充值金额请输入整数。</li>
            <li><span><a href="" onclick="onSumit();return false;" class="button_bc">立即充值</a></span></li>
          </ul>.
        </div>
        <div class="password mp mp_padbottom"></div>
      </div>
      </form>
    </div>
    <div class="clear"></div>
    <div class="lineclear Accountheight"></div>
  </div>
  <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
  <div class="clear"></div>
</div>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
</div>
</body>
