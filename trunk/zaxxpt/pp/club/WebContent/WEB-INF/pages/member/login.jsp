<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>

<%@page import="com.hnatourism.framework.utils.StringUtils"%><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<title>登录${domain_cn} ，快速订机票，订酒店 _ ${domain_cn} </title>
<script type="text/javascript">
	
	function goLogin()
	{
		rule=/^\w+$/;
		
		if(!rule.exec(document.getElementById("code").value))
		{
			alert("卡号或者账号填写不规范！！！！！");
			document.getElementById("code").focus();
			return;
		}
		rulePsw=/^[\dA-Za-z0-9(!@#$%&*_,./;)]{6,18}$/;
		if(!rulePsw.exec(document.getElementById("pw").value))
		{
			alert("密码填写不规范！！！！！");
			document.getElementById("pw").focus();
			return;
		}
		
		document.forms.loginForm.submit();
	}
	
</script>
<style type="text/css">
#td1{}
#td2{text-align:left;}
</style>
</head>

<%
	String name = "";
	String password = "";
	Cookie[] cookies = request.getCookies(); 
	if(cookies!=null){ 
		for(int i=0;i<cookies.length;i++){
			
			if(cookies[i].getName().equals("login_code")){
				name=cookies[i].getValue().replace("-","@");
				request.setAttribute("name",name);
				//out.print(request.getCookies()[i].getName()+"      "+name+"</br>");
			}
			if(cookies[i].getName().equals("login_pw")){
				password=cookies[i].getValue();
				request.setAttribute("password",password);
			//out.print(request.getCookies()[i].getName()+"      "+password+"</br>");
			}
			
			//out.print(request.getCookies()[i].getName()+"      "+request.getCookies()[i].getValue()+"</br>" + request.getCookies().length);
		}
	}
%>
<body>
<div class="clear"></div>
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx }/index.jsp" class="se">首页</a> > 会员登录</li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
</div>
<div class="width_m5"><img src="${ctx}/web/images/xx_top.jpg" width="980" height="6" /></div>
<div class="border_e4 Wmargin bg_fb" onkeydown="if(event.keyCode == 13){goLogin();}">
<form action="${ctx}/login.action" name="loginForm" id="loginForm" method="post">
<!-- 
  <div class="loginhead yhdl_border">会员登录</div>
  <div class="login">
    <div class="w1 l_h40 pt10">卡号/账号：</div>
    <div class="w2 l_h40 pt10">
      <input type="text" name="member.code" id="code" class="input2" maxLength=20 value="<%=request.getAttribute("name")==null?"":request.getAttribute("name") %>"/>
      <input type="hidden" name="member.id" id="id" value="${member.id}" />
      <input type="hidden" name="id" id="id" value="<%=request.getParameter("id") %>" />
      <input type="hidden" name="time" id="time" value="<%=request.getParameter("time") %>" />
      <input type="hidden" name="idate" id="idate" value="<%=request.getParameter("idate") %>" />
      <input type="hidden" name="odate" id="odate" value="<%=request.getParameter("odate") %>" />
      <input type="hidden" name="hcode" id="id" value="<%=request.getParameter("hcode") %>" />
      <input type="hidden" name="rcode" id="time" value="<%=request.getParameter("rcode") %>" />
    </div>
    <div class="w1 l_h30">&nbsp;</div>
    <div class="w2 l_h30 color74"></div>
    <div class="w1 l_h40 pt10">密码：</div>
    <div class="w2 l_h40 pt10">
      <input type="password" name="member.password" id="pw" class="input2" value="<%=request.getAttribute("password")==null?"":request.getAttribute("password") %>"/>
    </div><a href="${ctx}/toFindPwd.action" title="忘记密码？">忘记密码？</a>
    <div class="w1 l_h30 color74"></div>
    <div class="w2 l_h30 color74"><% 
		String url=request.getParameter("url");
    url = StringUtils.isEmpty(url)?(String)session.getAttribute("backlink"):url;
	%>
	<input type="hidden" name="url" value="<%=url%>">
    <input name="isRememberPsw" type="checkbox" class="checkBox" id="isRememberPsw" value="on"/>
            记住密码，下次自动登录<font color="red"></font></div>
    <div class="w1 pt30 h50">&nbsp;</div>
    <div class="w3 pt20"><a href="javascript:goLogin()"><img src="${ctx}/web/images/dl1.jpg" /></a></div>
    <div class="w4 pt30 h50"></div>
    
  </div>
   -->
   <table width="100%">
   	<tr>
   		<td width="50%"><div class="loginhead yhdl_border" id="td1">会员登录</div></td>
   		<td align="left"><div class="loginhead yhdl_border" id="td2">你还不是俱乐部会员？</div></td>
   	</tr>
   	<tr height="200px">
   		<td align="center">
   			会员卡号/账号：<input type="text" name="member.code" id="code" class="input2" maxLength=20 value="<%=request.getAttribute("name")==null?"":request.getAttribute("name") %>"/>
		      <input type="hidden" name="member.id" id="id" value="${member.id}" />
		      <input type="hidden" name="id" id="id" value="<%=request.getParameter("id") %>" />
		      <input type="hidden" name="time" id="time" value="<%=request.getParameter("time") %>" />
		      <input type="hidden" name="idate" id="idate" value="<%=request.getParameter("idate") %>" />
		      <input type="hidden" name="odate" id="odate" value="<%=request.getParameter("odate") %>" />
		      <input type="hidden" name="hcode" id="id" value="<%=request.getParameter("hcode") %>" />
		      <input type="hidden" name="rcode" id="time" value="<%=request.getParameter("rcode") %>" />
		      <br/><br/>
		      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                密码：<input type="password" name="member.password" id="pw" class="input2" value="<%=request.getAttribute("password")==null?"":request.getAttribute("password") %>"/>
		      <!--  <a href="#" title="忘记密码？">忘记密码？</a>--><br/><br/>
		      <input name="isRememberPsw" type="checkbox" class="checkBox" id="isRememberPsw" value="on"/>记住密码，下次自动登录<br/><br/>
		      <a href="javascript:goLogin()"><img src="${ctx}/web/images/dl1.jpg" /></a>
   		</td>
   		<td>
   			<span style="font-size:17px">现在入会即可享受10%的积分权益！</span><br/><br/>
   			<span class="orange">机票：</span>经济舱直减≥3%+航空里程积分；不花头等钱，乘坐头等舱；<br/><br/>
   			<span class="orange">头等（公务）休息室：</span>会员价再直减20%；<br/><br/>
   			<span class="orange">酒店：</span>市场最低价直减：≥10%；<br/><br/>
   			<span class="orange">高尔夫：</span>千元+N家球场较嘉宾价直减最高达30%；<br/><br/>
   			<span class="orange">机场贵宾厅：</span>免年费+标准价再直减20%；<br/><br/>
   			<a href="${ctx }/onLineApplyView.action" style="background:#D7D7D7;font-size:15px">立即申请入会</a>
   		</td>
   	</tr>
   </table>
</form></div>
<div class="Wmargin"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<script type="text/javascript">
$(function(){
	var msg = '${mistakeInfo}';
	if(msg != null && msg != ""){
		alert(msg);
	}
})
</script>
<% request.getSession().setAttribute("mistakeInfo",""); %>
</body>
