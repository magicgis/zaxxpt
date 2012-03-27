<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@include file="/common/include/common.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<TITLE>修改密码 _ ${domain_cn} </TITLE>
<script type="text/javascript">
	function submitPw()
	{
		if(document.getElementById("pw").value=="")
		{
			alert("当前密码不能为空！！！！！");
			return;
		}
		if(document.getElementById("newPw").value=="")
		{
			alert("新密码不能为空！！！！！");
			return;
		}
		if(document.getElementById("newPwConfirm").value=="")
		{
			alert("新密码确认不能为空！！！！！");
			return;
		}
		var newPw=document.getElementById("newPw").value;
		var newPwConfirm=document.getElementById("newPwConfirm").value;
		if(newPw.length<6||newPwConfirm.length<6)
		{
			alert("密码不能小于六位数！！！！！");
			return;
		}
		if(document.getElementById("newPwConfirm").value!=document.getElementById("newPw").value)
		{
			alert("新密码2次输入不一致！！！！！");
			return;
		}
		
		document.forms.memberPwForm.submit();
	}

</script>

</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<s:form action="updPw" name="memberPwForm" method="post">
<input type="hidden" value="upd" name="pwaction"/>
<div class="floatleft width783">
  <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
  <div class="listTAB rightbg">
    <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt;<span class="cl1">修改登录密码</span></div>
    <div id="Accountcenter">
      <div class="right_h">
        <ul>
          <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
          <li class="right_h_bg widtha">
            <div class="grf_tag4"><a href="#" class="ontag">修改登录密码</a></div>
          </li>
          <li class="right_h_bg widthb"></li>
          <li class="right Accountwidth"><img src="${ctx}/web/images/right_h_r.jpg"/></li>
        </ul>
      </div>
      <div class="clear"></div>
      <div class="listTAB">
        <div class="password">
          <div id="Modify_pass">
            <ul>
              <li><font class="Modifypassword">当前密码：</font>
                <input type="text" name="pw" id="pw" class="textfields" />
              </li>
              <li><font class="Modifypassword">新 密 码：</font>
                <input type="password" name="newPw" id="newPw" class="textfields" maxlength="20"/>
              </li>
              <li><font class="Modifypassword">重复新密码：</font>
                <input type="password" name="newPwConfirm" id="newPwConfirm" class="textfields" maxlength="20"/>
              </li>
              <li><span><a href="javascript:submitPw()" class="button_bc">保存修改</a></span></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>
    </div>
    <div class="lineclear Accountheight"></div>
  </div>
  <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
</div>
</s:form>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
</div>
<script type="text/javascript" defer="defer">
	function showUpdResult(result)
	{
		if(result=="success")
		{
			alert("修改成功！！！！！！");
		}
		else if(result=="error")
		{
			alert("修改失败！！！！！！");
		}
	}
	
	showUpdResult('<s:property value="#session.updmember"/>');
</script>
</body>
