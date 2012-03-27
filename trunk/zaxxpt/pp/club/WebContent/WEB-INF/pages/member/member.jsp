<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js"></script>
<title>我的账户信息</title>
<script type="text/javascript">
	function submitForm()
	{
		if(document.getElementById("save").innerHTML=="修改"){
			showText()
			return ;
		}
		if(document.forms.memberForm.name.value==""||document.forms.memberForm.name.value.length>100)
		{
			alert("联系人填写不规范！！！！！");
			document.forms.memberForm.name.focus();
			return;
		}
		var rule=/^(\d{4})\-(\d{2})\-(\d{2})$/;
		if (!rule.exec(document.forms.memberForm.birth.value))
		{
			alert("出生日期填写不规范！！！！！");
			document.forms.memberForm.birth.focus();
			return;
		}
		if(document.forms.memberForm.mobile.value==""||document.forms.memberForm.mobile.value.length>11)
		{
			alert("手机填写不规范！！！！！");
			document.forms.memberForm.mobile.focus();
			return;
		}
		if(document.forms.memberForm.address.value=="")
		{
			document.forms.memberForm.address.value=" ";
		}
		var email=document.getElementById("emails").value;
		ckEmail(email);
		
	}
</script>
<script type="text/javascript">
	//检查邮箱
//检查email是否唯一
	function ckEmail(email){
		var mailVal = document.getElementById("emails").value;
		if(mailVal == ""){
			alert("email不能为空！！！！！");
			return false;
		}else{
			var patt = /\w+([-+.]\w+)*@\w+([-.] \w+)*\.\w+([-.]\w+)*/;
			if(!mailVal.match(patt)){
				alert("email填写不规范！！！！！");
				return false;
			}
		}
		
		$.ajax({
			type : "POST",
			contentType :"application/json",
			url :"${ctx}/onLineApply!ckEmail.action?memberInfo.email="+mailVal+"&strtime="+new Date().getTime(),
			dataType :'html',
			success:function(data){
			        try{
			        	if(document.getElementById("emails").value!=mailVal){
			        	//返回0  可用
					        if( data == "0"){
					        	 document.forms.memberForm.submit();
					        }else{
					        	//返回1 占用
					        	alert("该email已经被占用，请更换一个！！！！！");
					        	return false;
					        }
				        }
				        document.forms.memberForm.submit();
			        } catch(ex){
				        alert(ex);
			        }
			}
		});
	}
</script>
</head>
<body onload="init()">

<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
  <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
  <div class="listTAB rightbg">
    <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt;<span class="cl1">我的账户信息</span></div>
    <div id="Accountcenter">
      <div class="right_h">
        <ul>
          <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
          <li class="right_h_bg widtha">
            <div class="grf_tag4">账户信息</div>
          </li>
          <li class="right_h_bg widthb">&nbsp;</li>
          <li class="right Accountwidth"><img src="${ctx}/web/images/right_h_r.jpg"/></li>
        </ul>
      </div>
      <div class="clear"></div>
      <div class="listTAB"><s:form name="memberForm" action="updMember" method="post">
        <ul id="accoutcontent">
          <li><font class="Modifypassword">帐户名：</font>
          	<s:property value="member.code"/>
          	<input type="hidden" name="code" value="<s:property value="member.code"/>" />
          	<input type="hidden" name="id" value="<s:property value="member.id"/>" />
          	<input type="hidden" name="rolename" value="<s:property value="rolename"/>" />
          	<span style="float:none;">类型：<s:property value="rolename"/></span>
          </li>
          <li><font class="Modifypassword">联系人：</font>
            <input type="text" style="display:none" name="name" id="name" class="medium_textfield" value="<s:property value="member.name"/>"/>
            <input type="text" disabled="disabled" id="names" class="medium_textfield" value="<s:property value="member.name"/>"/>
            <span style="float:none; color:#F60; margin:0;">（英文姓名请参照格式：Family Name/Name）</span>
          </li>
          <li disabled="disabled" id="sexs"><font class="Modifypassword">性别：</font>
			<s:if test='member.sex=="男"'>
         	 <input  type="radio" id="radio" value="男" checked="checked" />男
         	 <input type="radio"  id="radio2" value="女" />女
			</s:if>
			<s:else>
				<input type="radio" id="radio" value="男" /> 男
				<input type="radio"  id="radio2" value="女" checked="checked" /> 女
			</s:else>
          </li>
          <li id="sex" style="display:none"><font class="Modifypassword">性别：</font>
			<s:if test='member.sex=="男"'>
         	 <input name="sex" type="radio" id="radio" value="男" checked="checked" />男
         	 <input type="radio" name="sex" id="radio2" value="女" />女
			</s:if>
			<s:else>
				<input name="sex" type="radio" id="radio" value="男" /> 男
				<input type="radio" name="sex" id="radio2" value="女" checked="checked" /> 女
			</s:else>
          </li>
          <li><font class="Modifypassword">出生日期：</font>
            <input type="text" style="display:none" id="birth" name="birth" class="medium_textfield" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'1900-01-01',maxDate:'2020-12-31'})" value="<s:property value="member.birthdateYear"/>-<s:property value="member.birthdateMonth"/>-<s:property value="member.birthdateDay"/>"/>
            <input type="text" disabled="disabled" id="births" class="medium_textfield"  value="<s:property value="member.birthdateYear"/>-<s:property value="member.birthdateMonth"/>-<s:property value="member.birthdateDay"/>"/>
            <span style="float:none; color:#F60; margin:0;">（格式为：YYYY-MM-DD 例:1990-01-01）</span>
          </li>
          <li><font class="Modifypassword">手机号码：</font>
            <input type="text" style="display:none" id="mobile" name="mobile" class="medium_textfield" value="<s:property value="member.mobile"/>"/>
            <input type="text" disabled="disabled" id="mobiles" class="medium_textfield" value="<s:property value="member.mobile"/>"/>
          </li>
          <li><font class="Modifypassword">Email地址：</font>
            <input type="text" style="display:none" id="emails" name="email" class="medium_textfield" value="<s:property value="member.email"/>"/>
            <input type="text" disabled="disabled" id="emailss" class="medium_textfield" value="<s:property value="member.email"/>"/>
          </li>
          <li><font class="Modifypassword">详细地址：</font>
            <label>
              <textarea style="display:none" name="address" id="textarea" cols="45" rows="5" style="width:248px;"><s:property value="member.address"/></textarea>
              <textarea disabled="disabled" id="textareas" cols="45" rows="5" style="width:248px;"><s:property value="member.address"/></textarea>
            </label>
          </li>
          <li>
          <span ><a href="javascript:submitForm()" id="save" class="button_qx" >修改</a>&nbsp;&nbsp;</span>
          </li>
          <li><br />
提示：为了更好的为你服务，请完善你的个人资料，你的个人信息我们会为你保密。</li>
        </ul>
      </s:form></div>
      <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>
    </div>
    <div class="lineclear Accountheight"></div>
  </div>
  <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
</div>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
</div>
<script type="text/javascript" defer="defer">
	//修改和保存的切换
	function showText(){
		document.getElementById("save").innerHTML="保存";
		document.getElementById("name").style.display="inline";
		document.getElementById("names").style.display="none";
		document.getElementById("birth").style.display="inline";
		document.getElementById("births").style.display="none";
		document.getElementById("mobile").style.display="inline";
		document.getElementById("mobiles").style.display="none";
		document.getElementById("emails").style.display="inline";
		document.getElementById("emailss").style.display="none";
		document.getElementById("textarea").style.display="inline";
		document.getElementById("textareas").style.display="none";
		document.getElementById("sex").style.display="inline";
		document.getElementById("sexs").style.display="none";
	}
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
