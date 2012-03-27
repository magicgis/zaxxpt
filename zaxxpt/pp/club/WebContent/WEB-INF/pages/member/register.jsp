<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@include file="/common/include/common.jsp"%>
<%-- 不显示底部的广告 --%>
<c:set var="AD_TYPE" value="" scope="session"/>
<TITLE>注册${domain_cn} ，享受特价机票，低价酒店 _ ${domain_cn} </TITLE>
<meta name="keywords" content="jipiao,飞机票,机票预订,酒店预订,旅游度假,订特价机票,机票团购,酒店团购,航班查询,机票,酒店,旅行" />
<meta name="description" Content="${domain_cn} 是国内创新的在线旅行服务网站，提供国内特价机票预订，团购1折特价机票，特价酒店团购，旅游套餐预订等全方位旅行服务。引领旅行新生活" />
<meta name="classification" content="飞机票/机票/酒店/航空/航班/旅行/度假/特价/团购/海南航空/航空公司/服务" />
<meta name="author" content="xhlx.cn">
<meta name="corpright" content="Copyright ${domain_cn}  版权所有">
<meta name="robots" content="index,follow" />
<link href="${ctx}/web/css/b2cCss/css-other.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="${ctx}/web/js/clubJs/formValidator3.3/formValidator_min.js" defer="defer"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/formValidator3.3/formValidatorRegex.js"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/formValidator3.3/formValidator_helper.js"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/jquery/js/jquery.query-2.1.7.js"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/jquery/js/jquery.form.js" defer="defer"></script>

<script type="text/javascript">
	var dtIdx=0;
	var ddIdx=0;
	var isemail=0;
	function regist(){
		//if(!jQuery.formValidator.pageIsValid(0)){
	    //	return;
	    //}
		var temail = $("#email").val();
		if(temail==''){
			$("#emailTip").html("<font color='red'>请输入账号，账号为你的邮箱地址</font>");
	    	return;
		}
	    if(temail.length>50){
			$("#emailTip").html("<font color='red'>注册账号最长为50位，你的账号超长了！</font>");
	    	return;
	    }
	    if(!validate(regexEnum.email,"email")){
			$("#emailTip").html("<font color='red'>邮箱格式错误，请正确输入邮箱</font>");
			$("#emailTip").focus();
			return;
		}
	    if($("#password").val()==''){
	    	$("#passwordTip").html("<font color='red'>请输入密码!</font>");
	    	return;
	    }
	    if($("#password2").val()!=$("#password").val()){
	    	$("#password2Tip").html("<font color='red'>你两次输入的密码不一致，请重新输入!</font>");
	    	return;
	    }
	    if($("#password2").val()==$("#password").val()){
	    	$("#password2Tip").html("&nbsp;");
	    }
		//按钮置灰
	   $('#registButton').attr('disabled',"false");
	   $('#registButton').val("加载中");
    	document.getElementById("registForm").submit();
  	}
  	function goLogin(){
	    if(window.event.keyCode == 13){
	  	    regist();
		}
	}
	function login3(){
		window.location.href='${ctx}/login.jsp';
	}
	function topassword(){
	    if($("#password2").val()!=$("#password").val()){
	    	$("#password2Tip").html("<font color='red'>你两次输入的密码不一致，请重新输入!</font>");
	    	return;
	    }
	    if($("#password2").val()==$("#password").val()){
	    	$("#password2Tip").html("&nbsp;");
	    }
	}
	function checkEmail(){
		var temail = $("#email").val();
		if(temail==''){
			$("#emailTip").html("<font color='red'>请输入账号，账号为你的邮箱地址</font>");
	    	return;
		}
	    if(temail.length>50){
			$("#emailTip").html("<font color='red'>注册账号最长为50位，你的账号超长了！</font>");
	    	return;
	    }
	    if(!validate(regexEnum.email,"email")){
			$("#emailTip").html("<font color='red'>邮箱格式错误，请正确输入邮箱</font>");
			$("#emailTip").focus();
			return;
		}
		if(temail!=''){
			$("#emailTip").html("&nbsp;");
		}
		var registAjax={
				type: "post",
				url: "registLoginAction!emailAjax.action",
				success: function(data){
					if(data !='' && data.length>0){
						$("#emailTip").html("<font color='green'>此账户未被注册，你可以使用</font>");
						isemail=1;
					}else{
						$("#emailTip").html("<font color='red'>此账户已被注册，请重新输入！</font>");
						isemail=0;
					}
				}
			};
		$("#registForm").ajaxSubmit(registAjax);
	}
	//$(document).ready(function(){
        //$.formValidator.initConfig({validatorgroup:"0",onerror:function(){}});
        //$("#email").formValidator({validatorgroup:"0",onshow:"请输入正确的邮箱",onfocus:"请输入邮箱,例:wuyuhu@hna.com,最长50位",oncorrect:"&nbsp;"}).regexValidator({regexp:"email",datatype:"enum",onerror:"你输入的邮箱格式不正确"});
        //$("#password").formValidator({validatorgroup:"0",onshow:"请输入正确格式的密码",onfocus:"请输入密码：6~18个字符，包括字母、数字、下划线",oncorrect:"&nbsp;"}).regexValidator({regexp:"password",datatype:"enum",onerror:"你输入的密码格式不正确"});
       	//$("#verifyCode").formValidator({validatorgroup:"0",onshow:"请输入验证码",onfocus:"验证码不能为空",oncorrect:""}).regexValidator({regexp:"notempty",datatype:"enum",onerror:"输入不能为空"});
       // $("#email").formValidator({validatorgroup:"0",onshow:"邮箱地址即为你的登录账号，请准确填写。",onfocus:"邮箱地址即为你的登录账号，请准确填写。",oncorrect:"输入正确"}).regexValidator({regexp:"email",onerror:"你输入的邮箱不正确"});
        //$("#password").formValidator({validatorgroup:"0",onshow:"6~18个字符，包括字母、数字、下划线",onfocus:"6~18个字符，包括字母、数字、下划线",oncorrect:"输入正确"}).regexValidator({regexp:"password",onerror:"你输入的密码格式不正确"});
    //});
    function checkbox(){
    	if($("#checkboxReg").attr("checked")==true){
    		$("#registButton").attr("disabled",false);
    		$("#registButton").css({color:"#FFF",filter:"alpha(opacity=100)",opacity:"1"})
    	}else{
    		$("#registButton").attr("disabled",true);
    		$("#registButton").css({color:"#CCC",filter:"alpha(opacity=50)",opacity:"0.5"})
    	}
    }
	/**刷新验证码**/
	function refreshCode(){
		var stime=new Date();
	    $("#randomImgCode").attr("src",'${ctx}/randomCode?'+stime.getTime());
	}
	$(function(){
	$("#email").focus();
	})

//回车时自动提交注册		
$("body").keydown(function(event){
  switch(event.keyCode) {
  case 13:
    bindEnter(event);
    break;
   default:
   break; 
  }
});
		
function bindEnter(event){     
	$("#registButton").click();           
	event.returnValue = false;
} 


</script>

<script type="text/javascript">
	//密码复杂度提示
	function chkpwd(obj){
		var t=obj.value;
		var id=getResult(t);
		
		//定义对应的消息提示
		var msg=new Array(4);
		msg[0]="密码不能为空或密码过短";
		msg[1]="密码强度差";
		msg[2]="密码强度良好";
		msg[3]="密码强度高";
		
		var sty=new Array(4);
		sty[0]=-45;
		sty[1]=-30;
		sty[2]=-15;
		sty[3]=0;
		
		var col=new Array(4);
		col[0]="gray";
		col[1]="red";
		col[2]="#ff6600";
		col[3]="Green";
		
		//设置显示效果
		var bImg="${ctx}/web/images/pwdlen_dSIPeEGQWxfO.gif";//一张显示用的图片
		var sWidth=300;
		var sHeight=15;
		var Bobj=document.getElementById("passwordTip");

		Bobj.style.fontSize="12px";
		Bobj.style.color=col[id];
		Bobj.style.width=sWidth + "px";
		Bobj.style.height=sHeight + "px";
		Bobj.style.lineHeight=sHeight + "px";
		Bobj.style.background="url(" + bImg + ") no-repeat left " + sty[id] + "px";
		Bobj.style.textIndent="20px";
		Bobj.innerHTML="检测提示：" + msg[id];
	}
	
	//定义检测函数,返回0/1/2/3分别代表无效/差/一般/强
	function getResult(s){
		if(s.length < 4){
			return 0;
		}
		var ls = 0;
		if (s.match(/[a-z]/ig)){
			ls++;
		}
		if (s.match(/[0-9]/ig)){
			ls++;
		}
	 	if (s.match(/(.[^a-z0-9])/ig)){
			ls++;
		}
		if (s.length < 6 && ls > 0){
			ls--;
		}
		return ls
	}
</script>
<!--mainContainer begin-->
<div id="mainC_f">
   <div id="registerPage">
       <div class="registerPageL">
		<form action="registLoginAction!regist.action" name="registForm" id="registForm"
			method="post">
        <h1>欢迎注册 </h1>
        <table width="80%" border="0" cellspacing="0" cellpadding="0">
      	<tr><td></td><td><c:if test="${!empty message}">${message}</c:if></td></tr>
          <tr>
            <td width="29%" align="right" valign="top" class="txt14black">邮箱地址：</td>
            <td width="71%">
            <input tabindex="1" name="memberInfoVo.email" id="email" type="text" class="inputText long" value="${memberInfoVo.email}" onchange="checkEmail();" maxlength="50"/>
            <div id="emailTip">请输入邮箱地址，最长50位&nbsp;</div>
            </td>
          </tr>
          <tr>
            <td align="right" valign="top" class="txt14black">密　　码：</td>
            <td>
            	<input tabindex="2" name="memberInfoVo.password" id="password" type="password" value="" class="inputText long" onkeydown="chkpwd(this)" />
            	<div id="passwordTip">&nbsp;</div>
            </td>
          </tr>
          <tr>
            <td align="right" valign="middle" class="txt14black">确认密码：</td>
            <td>
            	<input tabindex="3" name="memberInfoVo.passwordConfirm" type="password" id="password2" value="" class="inputText long" onchange="topassword();"/>
            </td>
            <tr>
            <td style="height:10px;"></td>
            <td style="height:10px;" id="password2Tip">&nbsp;</td>
            </tr>
          </tr>
          <!-- tr>
            <td align="right" valign="middle" class="txt14black">验证码：</td>
            <td>
            	<input name="memberInfoVo.verifyCode" id="verifyCode" type="text" class="inputText" class="short" />
          		<img style="cursor:pointer;" onclick="refreshCode();" id="randomImgCode" border=0 src='${ctx}/randomCode'>
          		<a href="javascript:void(0);" onclick="refreshCode();">换一张</a>
          	</td>
          </tr> -->
          <tr>
          	<td></td>
          	<td id="verifyCodeTip"></td>
          </tr>
          <tr>
            <td align="right">&nbsp;</td>
            <td><input type="checkbox" id="checkboxReg" checked="checked" onclick="checkbox();" class="checkBox"/> 
              我已阅读并接受《<a href="serviceAgreement.jsp" title="服务条款" target="_blank">${domain_cn} 服务条款</a>》</td>
          </tr>
          <tr>
            <td align="right">&nbsp;</td>
            <td>
            	<input tabindex="4" onkeydown="enterReg()" type="button" class="bgbtn" id="registButton" value="注 册" onclick="javascript:regist();" />
            </td>
          </tr>
          <tr>
            <td align="right">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
        </form>
     </div>
       <div class="registerPageR">
          <dl>
             <dt>已经注册过?</dt>
             <dd><input type="button" value="直接登录" class="bgbtn" onclick="javascript:login3();"/></dd>
          
          </dl>
          <dl>
             <dt> 在${domain_cn} ，你可以...</dt>
             <dd><a class="linkRegistTxt" href="${ctx}/searchFlight.jsp">1.预订机票</a></dd>
             <dd><a class="linkRegistTxt" href="${ctx}/indexHotel.jsp">2.预订酒店</a></dd>
             <dd><a class="linkRegistTxt" href="${ctx}/tourInfoAction!toTourIndex.action">3.预订旅游</a></dd>
             <dd><a class="linkRegistTxt" href="${ctx}/indexGroup.jsp">4.参加团购</a></dd>
          
          </dl>
       
       </div>
  
    <p class="lefttop"> </p>
    <p class="rightTop"></p>
    <p class="leftBottom"></p>
    <p class="rightBottom"></p>
    <div class="clearFloat"></div>
  </div>

</div>