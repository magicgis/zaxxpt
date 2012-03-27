<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<TITLE>申请退会 _ ${domain_cn} </TITLE>

<script type="text/javascript">
	function shenqing(){//申请退会提交
	var sid =$("#sid").val();
	var mid =$("#mid").val();
	var rmk =$("#yuanyin").val();
	if(rmk == ""){
		alert("请输入原因！");
		return false;
	}
	if(confirm("确认申请退会吗?")){			
		document.forms[0].action="moveMember.action?memberStsVo.id="+sid+"&memberInfoVo.id="+mid+"&memberStsVo.sts=3";
		
		document.forms[0].submit();	 
	}
}

$(function(){
  	var s="${showSts}";
	if(s!=null&&s!=""&&s==0){
		alert("申请失败！");
	}
})
</script>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
  <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
  <div class="listTAB rightbg">
    <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt; <span class="cl1">申请退会</span></div>
    <div id="Accountcenter">
      <div class="right_h">
        <ul>
          <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
          <li class="right_h_bg widtha">
            <div class="grf_tag4"><a href="#" class="ontag">申请退会</a></div>
          </li>
          <li class="right_h_bg widthb">&nbsp;</li>
          <li class="right Accountwidth"><img src="${ctx}/web/images/right_h_r.jpg"/></li>
        </ul>
      </div>
      <div class="clear"></div>
      <form action="" name="savePay">
      <div class="password">
        <div id="Modify_pass">
          <ul>
            <li><font class="Modifypassword">请输入退会理由：</font>
              <input id="yuanyin" type="text" class="textfields" /> 
            </li>
            <input type="hidden" name="memberInfoVo.id" id="mid" value="${mid}"/>
			<input type="hidden" name="memberStsVo.id" id="sid" value="${sid}"/>
            <li><span><a href="" onclick="shenqing();return false;" class="button_bc">申请退会</a></span></li>
          </ul>
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
