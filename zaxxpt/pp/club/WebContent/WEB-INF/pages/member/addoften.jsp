<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightMemberPassenVo"%>
<%@page import="java.util.ArrayList"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<title>我的常用客人信息</title>
<script type="text/javascript">
	function submitForm()
	{
		var rule;
		
		var nameview=document.getElementById("xm_textfield");
		var xm_text=document.getElementById("xm_textfield").value;
		if(xm_text==""||xm_text.length>25)
		{
			alert("姓名填写不规范！！！！！");
			nameview.focus();
			return;
		}
		else
		{
			for(var index=0;index<xm_text.length;index++)
			{
				if(xm_text.charCodeAt(index)>8&&xm_text.charCodeAt(index)<47)
				{
					alert("姓名包含非法字符！！！！！");
					nameview.focus();
					return;
				}
				else if(xm_text.charCodeAt(index)>47&&xm_text.charCodeAt(index)<65)
				{
					alert("姓名包含非法字符！！！！！");
					nameview.focus();
					return;
				}
				else if(xm_text.charCodeAt(index)>90&&xm_text.charCodeAt(index)<97)
				{
					alert("姓名包含非法字符！！！！！");
					nameview.focus();
					return;
				}
				else if(xm_text.charCodeAt(index)>122&&xm_text.charCodeAt(index)<255)
				{
					alert("姓名包含非法字符！！！！！");
					nameview.focus();
					return;
				}
			}
		}
		if(document.getElementById("centType").value=="")
		{
			alert("请选择证件类型！！！！！");
			return;
		}
		else
		{
			var centtype=document.getElementById("centType").value;
			var centNoView=document.getElementById("zj_textfield");
			var centNo=document.getElementById("zj_textfield").value;
			switch(parseInt(centtype))
			{
				case 0:
					rule=/^[1-9]([0-9]{13}|[0-9]{16})([0-9]{1}|[Xx])$/
					if(!rule.exec(centNo))
					{
						alert("证件号码填写不规范！！！！！");
						centNoView.focus();
						return;
					}
					break;
				case 1:
					
				case 2:
					
				case 3:
					
				case 4:
					
				case 5:
					
				case 6:
					
				case 7:
					
				case 9:
					if(centNo==''){
						alert("证件号码不能为空!");
						return;
						}
					break;
				default:
					rule=/(^\w{1,20}$)/
					if(!rule.exec(centNo))
					{
						alert("证件号码填写不规范！！！！！");
						centNoView.focus();
						return;
					}
					break;
			}
		}
		/*
		if(document.getElementById("rmk").value.length>50)
		{
			alert("备用信息长度过长！！！！！");
			document.getElementById("rmk").focus();
			return;
		}
		if(document.getElementById("mobile").value.length>0)
		{
			rule=/^[0-9]{0,20}$/;
			if(!rule.exec(document.getElementById("mobile").value))
			{
				alert("手机号码填写不规范！！！！！");
				document.getElementById("mobile").focus();
				return;
			}
		}
		if(document.getElementById("email").value.length>0)
		{
			rule=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
			if(!rule.exec(document.getElementById("email").value))
			{
				alert("邮箱地址填写不规范！！！！！");
				document.getElementById("email").focus();
				return;
			}
		}
		*/
		document.forms.passengerForm.submit();
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
    <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt; <a href="${ctx}/member/often.jsp" class="cl0"> 我的常用客人信息 </a> &gt; <span class="cl1">编辑常用旅客</span></div>
    <div id="Accountcenter">
      <div class="right_h">
        <ul>
          <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
          <li class="right_h_bg widtha">
            <div class="grf_tag4"><a href="#" class="ontag">
            <s:if test='action=="add"'>
            	新增常用旅客
            </s:if>
            <s:else>
            	修改常用旅客
            </s:else>
            </a></div>
          </li>
          <li class="right_h_bg widthb"></li>
          <li class="right Accountwidth"><img src="${ctx}/web/images/right_h_r.jpg"/></li>
        </ul>
      </div>
      <div class="clear"></div>
      <div class="listTAB width760">
      <s:if test='action=="add"'>
      	<form name="passengerForm" action="${ctx}/addoften.action" method="post">
      </s:if>
      <s:else>
      	<form name="passengerForm" action="${ctx}/updoften.action" method="post">
      </s:else>
        <ul id="accoutcontent">
       	  <li style="font-weight: bold">请选择乘机类型：
          <s:if test='type=="01"||type==null'>
			<input type="radio" name="type" id="type_01" value="01" checked="checked"/>成人
			&nbsp;&nbsp;
            <input type="radio" name="type" id="type_02" value="02" />儿童
          </s:if>
          <s:else>
          	<input type="radio" name="type" id="type_01" value="01" />成人
			&nbsp;&nbsp;
            <input type="radio" name="type" id="type_02" value="02" checked="checked"/>儿童
          </s:else>
          <li>姓&nbsp;&nbsp;名：
            <input type="text" name="xm_textfield" id="xm_textfield" value="<s:property value="memberPassengerVo.name"/>"/>
          	<input type="hidden" name="id" value="<s:property value="memberPassengerVo.id"/>">
          </li>
          <li>证&nbsp;&nbsp;件：
            <div class="zjcode">
            <div class="left" style="margin-left:5px;">
              <div id="uboxstyle">
              	<f:select id="centType" name="centType" type="证件类型" blank="true" showValue="false" value="${memberPassengerVo.certType}"/>
              </div>
              </div>
              <input type="text" name="zj_textfield" id="zj_textfield" value="<s:property value="memberPassengerVo.certNo"/>"/>
            </div>
          </li>
          <!-- 
          <li class="f_yh fc666 cuti fsz14">可选填项</li>
          <li>性&nbsp;&nbsp;&nbsp;&nbsp;别：&nbsp;
          <s:if test='sex=="m"||sex==null'>
			<input type="radio" name="sex" id="sex_m" value="m" checked="checked"/>男
			&nbsp;&nbsp;
            <input type="radio" name="sex" id="sex_f" value="f" />女
          </s:if>
          <s:else>
          	<input type="radio" name="sex" id="sex_m" value="m" />男
			&nbsp;&nbsp;
            <input type="radio" name="sex" id="sex_f" value="f" checked="checked"/>女
          </s:else>
            </li>
          <li>手机号码：
            <input type="text" name="mobile" id="mobile" class="textfields" value="<s:property value="memberPassengerVo.mobile"/>"/>
          </li>
          <li>电子邮箱：
            <input type="text" name="email" id="email" class="textfields" value="<s:property value="memberPassengerVo.email"/>"/>
          </li>
          <li>备注信息：
            <input type="text" name="rmk" id="rmk" class="textfields" value="<s:property value="memberPassengerVo.disc"/>"/>
          </li>
           -->
          <li><span><a href="javascript:submitForm()" class="button_qx">保存</a></span></li>
        </ul>
      </form></div>
      <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>
    </div>
    <div class="clear"></div>
    <div class="lineclear Accountheight"></div>
  </div>
  <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
</div>
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
	
//	showUpdResult('<s:property value="#session.updpg"/>');
</script>
<script type="text/javascript">
$(function(){
	if("${showInfo}"!=null&&"${showInfo}"!=""){
		if("${showInfo}"==1){
			alert("添加成功！");
		}else{
			alert("添加失败！");
		}
	}
})	
</script>
</body>
