<%@ page pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberRoleVo"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<title>会员在线申请 - ${domain_cn }</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select3css.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/web/js/jquery1.3.2.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/select2css.js" language="javascript"></script>
<script type="text/javascript">
var ckCodeFlag=false,ckTypeFlag=false,ckNameFlag=false,ckCertNoFlag=false,ckPasswordFlag=false,ckPassword2Flag=false,ckEmailFlag=false,ckMobileFlag=false,invoiceFlag=true,ckTitleFlag=false,ckAddressFlag=false;

//检查会员类型
function ckType()
{
	var typeVal=$.trim($("#type").val());
	if(typeVal==""){
		$("#types").text("*请选择会员类型");
		$("#fees").text("");
		$("#types").css("color","red");
		hiddenDiv();
		ckTypeFlag=false;
		return false;
	}else{
		$("#types").text("√");
		$("#types").css("color","#66FF00");
		if(typeVal=="1"){
			$("#fees").text("金管家需交入会费￥1000");
			var div1=document.getElementById("div1");
			div1.style.display="block";
			document.getElementById("div2").style.display="none";
			document.getElementById("div3").style.display="none";
			$("#fee").val("1000");
		}else if(typeVal=="2"){
			$("#fees").text("白金管家需交入会费￥50000");
			document.getElementById("div1").style.display="none";
			document.getElementById("div3").style.display="none";
			var div2=document.getElementById("div2");
			div2.style.display="block";
			$("#fee").val("50000");
		}else if(typeVal=="3"){
			$("#fees").text("钻石管家需交入会费￥100000");
			document.getElementById("div1").style.display="none";
			document.getElementById("div2").style.display="none";
			var div3=document.getElementById("div3");
			div3.style.display="block";
			$("#fee").val("100000");
		}else{
			$("#fees").text("");
			$("#fee").val("");
		}
		ckTypeFlag=true;
		return true;
}}

//检查姓名
function ckName()
{
	if($.trim($("#name").val())==""){
		$("#names").text("*姓名不能为空");
		$("#names").css("color","red");
		ckNameFlag=false;
		return false;
	}else{
		var idf = $.trim($("#name").val());
		var pt1 = /^[\u4e00-\u9fa5]{1,10}$/
		var pt2 = /^[a-zA-Z]{1,20}$/
		if(!idf.match(pt1)&& !idf.match(pt2)){
			$("#names").text("*姓名输入不规范");
			$("#names").css("color","red");
			ckNameFlag=false;
			return false;
		}else{
			$("#names").text("√");
			$("#names").css("color","#66FF00");
			ckNameFlag=true;
			return true;
		}
	}
	}
//ajax检查管家用户名是否占用
function ckCode(code){
	var c = $.trim($(code).val());
	if(c == ""){
		$("#mcodes").text("*网站用户名不能为空!");
		$("#mcodes").css("color","red");
		ckCodeFlag=false;
		return false;
	}
	$.ajax({
	type : "POST",
	contentType :"application/json",
	url :"onLineApply!ckCode.action?memberInfo.code="+c+"&strtime="+new Date().getTime(),
	dataType :'html',
	success:function(data){
	        try{
	        	//返回0  可用
		        if( data == "0"){
		        	 $("#mcodes").text("√");
		        	 $("#mcodes").css("color","#66FF00");
		        	 ckCodeFlag=true;
		        	 rCode = true;
		        }else{
		        	//返回1 占用
		        	 $("#mcodes").text("*该网站用户名已经被占用，请更换一个");
		        	 $("#mcodes").css("color","red");
		        	ckCodeFlag=false;
		        	rCode = false;
		        }
	        } catch(ex){
		        alert(ex);
	        }
	}
});
}

//检查身份证
function ckCertNo()
{
	if($.trim($("#certNo").val())==""){
		$("#certNos").text("*身份证件号不能为空");
		 $("#certNos").css("color","red");
		ckCertNoFlag=false;
		return false;
	}else{
		var idf = $.trim($("#certNo").val());
		var pt = /([1-6]\d{5}(19|20)\d\d(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])\d{3}[0-9xX])|([1-6]\d{5}\d\d(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])\d{3})/
		if(!idf.match(pt)){
			$("#certNos").text("*身份证件输入有误");
			$("#certNos").css("color","red");
			ckCertNoFlag=false;
			return false;
		}else{
			$("#certNos").text("√");
			$("#certNos").css("color","#66FF00");
			ckCertNoFlag=true;
			return true;
		}
	}}

//检查密码
function ckPassword()
{
	var passStr=$.trim($("#password").val());
	if($.trim($("#password").val())==""){
		$("#passwords").text("*密码不能为空");
		$("#passwords").css("color","red");
		ckPasswordFlag=false;
		return false;
	}else{
		if(passStr.length<6){
			$("#passwords").text("*密码长度最小六位");
			$("#passwords").css("color","red");
			ckPasswordFlag=false;
			
			return false;
		}else{
			$("#passwords").text("√");
			$("#passwords").css("color","#66FF00");
			ckPasswordFlag=true;
			
			if($.trim($("#password2").val())!=""&&$.trim($("#password2").val())!=$.trim($("#password").val()))
			{
				$("#passwords2").text("*两个密码不相符");
				$("#passwords2").css("color","red");
				ckPassword2Flag=false;
				return false;
			}else{
				if($.trim($("#password2").val())==""){
					$("#passwords2").text("*");
					$("#passwords2").css("color","red");
					ckPassword2Flag=false;
					return false;
				}
				$("#passwords2").text("√");
				$("#passwords2").css("color","#66FF00");
				ckPassword2Flag=true;
				return true;
			}
			
			return true;
		}
	}}

//检查再输密码
function ckPassword2()
{
	if($.trim($("#password2").val())==""){
		$("#passwords2").text("*密码不能为空");
		$("#passwords2").css("color","red");
		ckPassword2Flag=false;
		return false;
	}else{
		if($.trim($("#password2").val())!=$.trim($("#password").val()))
		{
			$("#passwords2").text("*两个密码不相符");
			$("#passwords2").css("color","red");
			ckPassword2Flag=false;
			return false;
		}else{
			$("#passwords2").css("color","#66FF00");
			$("#passwords2").text("√");
			ckPassword2Flag=true;
			return true;
		}
	}}

//检查邮箱
//检查email是否唯一
	function ckEmail(email){
		var mailVal = $.trim($(email).val());
		if(mailVal == ""){
			$("#emails").text("*Email不能为空");
			$("#emails").css("color","red");
			ckEmailFlag=false;
			return false;
		}else{
			var patt = /\w+([-+.]\w+)*@\w+([-.] \w+)*\.\w+([-.]\w+)*/;
			if(!mailVal.match(patt)){
				$("#emails").text("*Email格式不正确");
				$("#emails").css("color","red");
				ckEmailFlag=false;
				return false;
			}
		}
		
		$.ajax({
			type : "POST",
			contentType :"application/json",
			url :"onLineApply!ckEmail.action?memberInfo.email="+mailVal+"&strtime="+new Date().getTime(),
			dataType :'html',
			success:function(data){
			        try{
			        	//返回0  可用
				        if( data == "0"){
				        	 $("#emails").text("√");
				        	 $("#emails").css("color","#66FF00");
				        	 ckEmailFlag=true;
				        	 return true;
				        }else{
				        	//返回1 占用
				        	$("#emails").text("该email已经被占用，请更换一个");
				        	$("#emails").css("color","red");
				        	ckEmailFlag=false;
				        	return false;
				        }
			        } catch(ex){
				        alert(ex);
			        }
			}
		});
	}
	
//检查手机号
function ckMobile()
{
	if($.trim($("#mobile").val())==""){
		$("#mobiles").text("*手机号不能为空");
		$("#mobiles").css("color","red");
		ckMobileFlag=false;
		return false;
	}else{
		var mobileVal = $.trim($("#mobile").val());
		//^(13[0-9]|15[0-9]|18[8|9])\d{8}$/
		//^1[3|4|5|8][0-9]\d{4,8}$/
		var patt = /^(13|15|18)[0-9]{9}$/;
		if(!mobileVal.match(patt))
		{
			$("#mobiles").text("*手机格式不正确,请重新输入");
			$("#mobiles").css("color","red");
			ckMobileFlag=false;
			return false;
		}else{
			$("#mobiles").css("color","#66FF00");
			$("#mobiles").text("√");
			ckMobileFlag=true;
			return true;
		}
	}}

//隐藏发票项
//function sts(s){
  	  	//if(s=='0'){
  	  		//$(".tohide").hide();
  	  		//invoiceFlag=false;
  	  //	}
  	  //	else{
  	  	  	//选择了开具发票
  	  		//$(".tohide").show();
  	  		//invoiceFlag=true;
  	  	//}
  	//}
	//检查发票Title
function ckTitle()
{
	if($.trim($("#title").val())==""){
		$("#titles").text("*发票Title不能为空");
		$("#titles").css("color","red");
		ckTitleFlag=false;
		return false;
	}else{
		$("#titles").text("√");
		$("#titles").css("color","#66FF00");
		ckTitleFlag=true;
		return true;
	}}
//检查邮寄地址
function ckAddress()
{
	if($.trim($("#address").val())==""){
		$("#addresss").text("*地址不能为空");
		$("#addresss").css("color","red");
		ckAddressFlag=false;
		return false;
	}else{
		$("#addresss").text("√");
		$("#addresss").css("color","#66FF00");
		ckAddressFlag=true;
		return true;
	}}

//提交申请
function checkSubmit()
{
	
	if(ckTypeFlag==false){
		ckType();
		return false;	
	}
	if(ckNameFlag==false){
		ckName();
		return false;	
	}
	if(ckCertNoFlag==false){
		ckCertNo();
		return false;	
	}
	if(ckCodeFlag==false){
		ckCode($("#code"));
		return false;	
	}
	if(ckPasswordFlag==false){
		ckPassword();
		return false;	
	}
	if(ckPassword2Flag==false){
		ckPassword2();
		return false;	
	}
	if(ckEmailFlag==false){
		ckEmail($("#email"));
		return false;	
	}
	if(ckMobileFlag==false){
		ckMobile();
		return false;	
	}
	var checked1=document.getElementById("checked1");
	if(!checked1.checked){
		return false;
	}
	/*if(invoiceFlag==true){

		if(ckTitleFlag==false){
			ckTitle();
			return false;	
		}
		if(ckAddressFlag==false){
			ckAddress();
			return false;	
		}
	}*/
	if(confirm("确认提交")){
			$("form").submit();
		}
	}
</script>
<script type="text/javascript">
	function hiddenDiv(){
		document.getElementById("div1").style.display="none";
		document.getElementById("div2").style.display="none";
		document.getElementById("div3").style.display="none";
	}
	
	function changeImg(){
		var checked1=document.getElementById("checked1");
		if(checked1.checked){
			$("#tijiao").show();
			$("#tijiaoOff").hide();
		}else{
			$("#tijiao").hide();
			$("#tijiaoOff").show();
		}	
	}
</script>
<style type="text/css" rel="Stylesheet">
#div1,#div2,#div3 {position: relative;top: -50px;background:#fff;display:none;}
#div1 td,#div2 td,#div3 td {border:1px #B7E0FF solid;background:#fff}
#div1 th,#div2 th,#div3 th {border:1px #B7E0FF solid;background:#F1FAFF;border-bottom:none;}
#PeopleInfoBox{height:700px;}
</style>
</head>
<body>
<form action="${ctx}/onLineApply!onLineApply.action" method="post"  name="memberInfoForm">
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg"></li>
        <li class="sebj"><a class="se" href="${ctx}">首页</a> &gt; <a class="se1" href="#">会员在线申请</a></li>
        <li><img src="${ctx}/web/images/seright.jpg"></li>
    </ul>
</div>
<div class="main980"> 
    <!--Module-->
    <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">填写申请单 </b></span><span class="r"></span></div>
        <div class="inner clearfix_" id="PeopleInfoBox">
            <dl class="Apply clearfix_">
                <dt>会员类型：</dt>
                <dd>
                    <div id="tm2010style" class="left select_box_people">
                        <select name="memberAccount.role" id="type" onchange="ckType();">
                            <option value="">请选择</option>
                            <%
                            List<MemberRoleVo> memberRoleVoList =(List<MemberRoleVo>)request.getAttribute("memberRoleVoList");
                            if(null!=memberRoleVoList)
	                        for (int i = 0; i < memberRoleVoList.size(); i++) {
	               				MemberRoleVo roleVo=memberRoleVoList.get(i);
	               				if(!roleVo.getName().equals("政企管家")){
	               					out.write("<option value='"+roleVo.getId()+"'>"+roleVo.getName()+"</option>");
	               				}
	               			}
                            %>
                        </select>
                    </div>
                    
                    <font color="red" id="types">*</font><font id="fees"></font><input type="hidden" name="memberAccount.fee" id="fee">  
                </dd>
                
					
					
                <dt>姓名：</dt>
                <dd>  
                   	<input type="text" id="name" name="memberInfo.name" type="text" value="" onblur="ckName();" maxlength="20" class="input2"><font color="red" id="names">*</font>
               <!-- <input type="text" id="code" name="memberInfo.code" type="text" value="" onblur="ckCode(this);" maxlength="20"  class="input2" ><font id="mcodes" color="red">*</font> -->
                </dd>
                <dt><span style="float:none; color:#F60; margin:0;">（姓名</span></dt>
                <dd>
                	<span style="float:none; color:#F60; margin:0;font-size:13px">可以是10个以内汉字或者20位以内英文字母）</span>
                </dd>
                <dt>性别：</dt>
                <dd>
                    <input type="radio" name="memberInfo.sex" id="sexM" checked="checked"/>
                    <label for="sexM">男</label>
                    <input type="radio" name="memberInfo.sex" id="sexW" />
                    <label for="sexW">女</label>
                </dd>
                <dt>身份证号码：</dt>
                <dd>
                    <input type="text" class="input2" name="memberInfo.certNo"  id="certNo" onblur="ckCertNo();" maxlength="18"><font color="red" id="certNos">*</font>
                </dd>
                <dt>网站用户名：</dt>
                <dd>
                    <input type="text" id="code" name="memberInfo.code" type="text" value="" onblur="ckCode(this);" maxlength="20"  class="input2" ><font id="mcodes" color="red">*</font>
                </dd>
                <dt>密码：</dt>
                <dd>
                    <input type="password" class="input2" name="memberInfo.password" id="password" onblur="ckPassword();" maxlength="18" ><font color="red" id="passwords">*</font>
                </dd>
                <dt>再输入一次：</dt>
                <dd>
                    <input type="password" class="input2" id="password2" onblur="ckPassword2();"><font color="red" id="passwords2">*</font>
                </dd>
                <dt>Email地址：</dt>
                <dd>
                    <input type="text" class="input2"  name="memberInfo.email" id="email" onblur="ckEmail(this);"><font color="red" id="emails">*</font>
                </dd>
                <dt>手机号码：</dt>
                <dd>
                    <input type="text" class="input2" name="memberInfo.mobile"  id="mobile"     onblur="ckMobile();" maxlength="11"> <font color="red" id="mobiles">*</font>
                </dd>
                <!--  
                <dt>是否开具发票：</dt>
                <dd>
                    <input type="radio" name="memberInvoiceVo.sts" id="InvoiceN" onclick="sts('0');"/>
                    <label for="InvoiceN">否</label>
                    <input type="radio" name="memberInvoiceVo.sts" id="InvoiceY"  checked="checked" onclick="sts('1');"  />
                    <label for="InvoiceY">是</label>
                    （每一笔消费开具一张发票） </dd>
                <dt class="tohide">发票Title：</dt>
                
                <dd class="tohide"> 
                    <input type="text" class="input2" name="memberInvoice.title" id="title" onblur="ckTitle();"><font color="red" id="titles">*</font>
                </dd>
                -->
                <dt class="tohide">邮寄地址：</dt>
                <dd class="tohide">
                    <input type="text" class="input2" style="width:350px;" name="memberInvoice.address" id="address" onblur="ckAddress();"> <font color="red" id="addresss">*</font>
                </dd>
                <dt class="tohide"></dt>
                <dd class="tohide">
                	<input type="checkbox" id="checked1" name="checked1" onclick="changeImg();">我已阅读并同意${domain_cn}入会协议
                </dd>
                <dt></dt>
                <dd class="tohide" style=" height:auto ;">
                	<textarea rows="15" cols="80" style="overflow-x:hidden; width:450px; padding:0 0 0 10px;" readonly="readonly">                	
&nbsp（一）本合同的成立、效力、解释、履行、争议解决等一切与合同相关问题适用中华人民共和国法律（香港、澳门与台湾地区的法律除外）本合同一经签署，即合法有效，对双方均具约束力。
&nbsp（二）因本合同引起的或与本合同有关的任何争议，双方应本着互谅互让的精神友好协商解决。如协商不成，可依法向北京市朝阳区人民法院提起诉讼。
&nbsp（三）除本合同另有约定外，未经合同另一方书面同意，一方不得将本合同项下的权利义务转让给第三方。
&nbsp（四）若乙方利用${domain_cn}发生扰乱商旅市场或违反商旅使用规则之行为，则甲方有权冻结卡内资金，并收回该会员的使用权，卡内资金不予退还。
&nbsp（五）本合同如需进行修改、补充或完善，甲、乙双方必须就所修改的内容签订书面的合同修改书，作为本合同的补充协议。补充协议与本合同具有同等法律效力，补充协议与本合同有冲突以补充协议为准。
&nbsp（六）如果本合同部分条款依据现行法律、法规被确认为无效或无法履行，且该部分无效或无法履行的条款不影响合同其他条款效力的，本合同其他条款继续有效。
&nbsp（七）本合同每一条款的标题只是为了方便使用，将不被认为是一部分或影响规定的解释和结构，除非另外明确规定。
&nbsp（八）${domain_cn}会员账户内可消费金额严禁用于非法资金运作以及各类扰乱市场之行为，一经发现，甲方将有权冻结乙方的会员账户，并终止该账户的一切消费行为，且卡内金额不予退还。
&nbsp（九）乙方持有${domain_cn}会员资格，仅在甲方旗下${domain_cn }网(${domain})进行消费时才可享受相应的消费优惠。
                	</textarea>
                </dd>
                
                <!--  <dt class="tohide">邮寄发票每月：</dt> 
                <dd class="tohide">
                    <div id="tm2008style" class="left select_box_people">
                        <select name="Date" id="Date" name="memberInvoice.period">
                            <option value="1">1日</option>
                            <option value="2" >2日</option>
                            <option value="3" >3日</option>
                            <option value="4" >4日</option>
                            <option value="5">5日</option>
                            <option value="6">6日</option>
                            <option value="7">7日</option>
                            <option value="8">8日</option>
                            <option value="9">9日</option>
                            <option value="10">10日</option>
                            <option value="11">11日</option>
                            <option value="12">12日</option>
                            <option value="13">13日</option>
                            <option value="14">14日</option>
                            <option value="15">15日</option>
                            <option value="16">16日</option>
                            <option value="17">17日</option>
                            <option value="18">18日</option>
                            <option value="19">19日</option>
                            <option value="20">20日</option>
                            <option value="21">21日</option>
                            <option value="22">22日</option>
                            <option value="23">23日</option>
                            <option value="24">24日</option>
                            <option value="25">25日</option>
                            <option value="26">26日</option>
                            <option value="27">27日</option>
                            <option value="28">28日</option>
                            <option value="29">29日</option>
                            <option value="30">30日</option>
                            <option value="31">31日</option>
                        </select>
                    </div>
                </dd> -->
            </dl>
            <!-- Process -->
             <!--   
            <dl class="Process">
                <dt>会员入会申请流程：</dt>
                <dd class="Bubble">提交入会申请</dd>
                <dd class="Arrow">↓</dd>
                <dd class="Bubble">汇款或转账俱乐部会员费</dd>
                <dd class="Arrow">↓</dd>
                <dd class="Bubble">俱乐部审核信息</dd>
                <dd class="Arrow">↓</dd>
                <dd class="Bubble">收到会员费一个工作日开通</dd>
            </dl>-->
            <dl class="Proces">
            <div  id="div1" style="">
					<table border="0" height="1%" width="100%">
					<tr height="13px"><th colspan="2"><b>金管家会员介绍</b></th><tr/>
					<tr>
						<td width="21%">
						<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">入会资格</span>
						</td>
						<td>
						<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">缴纳1千元,获得会员资格,亦可获得1千积分权限</span>
						</td>
					</tr>
					<tr>
						<td>
						<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">会员有效期</span>
						</td>
						<td>
						<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">永久</span>
						</td>
					</tr>
					<tr>
						<td>
						<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">优惠服务</span>
						</td>
						<td>
					
						<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">
						机票：经济舱直减≥3%+航空里程积分；不花头等钱，乘坐头等舱<br/>
						头等（公务）休息室：会员价再直减20%<br>
						酒店：市场最低价直减：≥10%<br>
						高尔夫：千元+N家球场较嘉宾价直减最高达30%</span>
						</td>
					</tr>
					</table>
					</div>
					
					<div id="div2">
					<table border="0" height="25%" width="100%">
					<tr><th colspan="2"><b>白金管家会员介绍</b></th><tr/>
					<tr>
					<td width="21%">
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">入会资格</span>
					</td>
					<td>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">缴纳5万元,获得会员资格,亦可获得5千积分权限</span>
					</td>
					</tr>
					<tr>
					<td>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">会员有效期</span>
					</td>
					<td>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">永久</span>
					</td>
					</tr>
					<tr>
					<td>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">优惠服务</span>
					</td>
					<td>
					<p>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">
					机票：经济舱直减≥3%+航空里程积分；不花头等钱，乘坐头等舱<br>
					头等（公务）休息室：会员价再直减20%<br>
					酒店：市场最低价直减：≥10%<br>
					高尔夫：千元+N家球场较嘉宾价直减最高达30%</span>
					</p>
					</td>
					</tr>
					</table>
					</div>
					
					<div id="div3">
					<table border="0" height="25%" width="100%">
					<tr><th colspan="2"><b>钻石管家会员介绍</b></th><tr/>
					<tr>
					<td width="21%">
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">入会资格</span>
					</td>
					<td>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">缴纳10万元,获得会员资格,亦可获得1万积分权限</span>
					</td>
					</tr>
					<tr>
					<td>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">会员有效期</span>
					</td>
					<td>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">永久</span>
					</td>
					</tr>
					<tr>
					<td>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">优惠服务</span>
					</td>
					<td>
					<p>
					<span style="font-family:Heiti SC;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">
					机票：经济舱直减≥3%+航空里程积分；不花头等钱，乘坐头等舱<br>
					头等（公务）休息室：会员价再直减20%<br>
					酒店：市场最低价直减：≥10%<br>
					高尔夫：千元+N家球场较嘉宾价直减最高达30%</span>
					</p>
					</td>
					</tr>
					</table>
					</div>
					
</dl>
            <!-- Process end --> 
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
    <!--Module end--> 
    
</div>
<div class="grf_borderb Wmargin tijiao_frm" id="tijiao" style="display:none"><img src="${ctx}/web/images/tijiao.jpg" onclick="checkSubmit();" style="cursor:pointer"/></div>
<div class="grf_borderb Wmargin tijiao_frm" id="tijiaoOff"><img src="${ctx}/web/images/tijiaoOff.jpg" style="cursor:pointer"/></div>
<script type="text/javascript">
$(function(){
    // IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
	if(!-[1,]&&!window.XMLHttpRequest){
		$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	}	
});
</script>
</form>
</body>