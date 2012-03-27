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
	var nameview=document.getElementById("xm_textfield");
	var xm_text=nameview.value;
	if(xm_text==""||xm_text.length>25)
	{
		alert("姓名填写不规范！！！！！");
		nameview.focus();
		return ;
	} 
	if(document.getElementById("mobile").value=="")
	{
		alert("联系电话填写不规范！！！！！");
		document.getElementById("mobile").focus();
		return ;
	} 
	if(document.getElementById("postcode").value=="")
	{
		alert("邮编填写不规范！！！！！");
		document.getElementById("postcode").focus();
		return ;
	} 
	if(document.getElementById("address").value=="")
	{
		alert("地址填写不规范！！！！！");
		document.getElementById("address").focus();
		return ;
	} 
	document.forms.passengerForm.submit();
}	
</script>
</head>
<body >
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
  <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
  <div class="listTAB rightbg">
    <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt; <a href="${ctx}/member/oftenaddress.jsp" class="cl0"> 我的常用地址信息 </a> &gt; <span class="cl1">编辑常用地址</span></div>
    <div id="Accountcenter">
      <div class="right_h">
        <ul>
          <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
          <li class="right_h_bg widtha">
            <div class="grf_tag4"><a href="#" class="ontag">
            <s:if test='action=="add"'>
            	新增常用地址信息
            </s:if>
            <s:else>
            	修改常用地址信息
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
      	<form name="passengerForm" action="${ctx}/memberPassengerAddrAction!add.action" method="post" >
      </s:if>
      <s:else>
      	<form name="passengerForm" action="${ctx}/memberPassengerAddrAction!modify.action" method="post">
      </s:else>
        <ul id="accoutcontent">
          <li>收 件 人：
            <input type="text" name="xm_textfield" class="textfields" id="xm_textfield" value="<s:property value="memberPassengerVo.name"/>"/>
          	<input type="hidden" name="id" value="<s:property value="memberPassengerVo.id"/>"></li>
          <li>联系电话:
              <input type="text" name="mobile" class="textfields" id="mobile" value="<s:property value="memberPassengerVo.mobile"/>"/>
          </li>
          <li>邮&nbsp;&nbsp;&nbsp;&nbsp;编：
            <input type="text" name="postcode" id="postcode" class="textfields" value="<s:property value="memberPassengerVo.postcode"/>"/>
          </li><br>
          <li>地&nbsp;&nbsp;&nbsp;&nbsp;址：
            <input type="text" name="address" id="address" class="textfields" value="<s:property value="memberPassengerVo.address"/>"/>
          </li>
          <li>
          <a href="#" onclick="submitForm()" class="button_qx">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="#" onclick="location.href='memberPassengerAddrAction!search.action'" class="button_qx">取消</a>
         </li>
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
</body>
