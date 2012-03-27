<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select3css.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/web/js/clubJs/tag.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<title>高尔夫订单填写 - 高尔夫预订- ${domain_cn }</title>
<script type="text/javascript">
$(document).ready(function(){
	var optMsg="${message}";
	if(optMsg){
		alert(optMsg);
	}
});
function showPlayerInput(sum)
	{
		var playerview=document.getElementById("playerview");
		//playerview.innerHTML="";
		for(var i=0;i<sum;i++)
		{
			var playinput=document.createElement("input");
			playinput.setAttribute("name","playerName");
			playinput.setAttribute("id","playerName"+i);
			playinput.setAttribute("type","text");
			playinput.setAttribute("class","jdmc");
			playinput.setAttribute("className","jdmc");
			
			playerview.appendChild(playinput);
		}
		if(sum<0){
			var len=$("#playerview :input").length;
			playerview.innerHTML="";
			showPlayerInput(len+sum);
		}
	}
	function showPlayerInputOne()
	{
		var playerview=document.getElementById("playerview");
		var playinput=document.createElement("input");
		playinput.setAttribute("name","playerName");
		playinput.setAttribute("id","playerName"+i);
		playinput.setAttribute("type","text");
		playinput.setAttribute("class","jdmc");
		playinput.setAttribute("className","jdmc");
		
		playerview.appendChild(playinput);
	}
	
	function pracVal(textview)
	{
		var patrn=/^[0-9]{1,3}$/;
		if (!patrn.exec(textview.value))
		{
			alert("购买球数只能是3位以内的数字！！！！！");
			textview.focus();
			return;
		}
		
		var ballnum=document.getElementById("totalBall").value;
		var pricesum=parseFloat(ballnum)*parseFloat(document.getElementById("siteprice").value)*100;
		document.getElementById("pricesum").innerHTML=pricesum.toFixed(0);
	}
	
	var playtimesave=null;
	function choosePlayTime(item)
	{
		if(playtimesave!=null)
		{
			playtimesave.setAttribute("class","");
			playtimesave.setAttribute("className","");
		}
		
		item.setAttribute("class","Selected");
		item.setAttribute("className","Selected");
		
		playtimesave=item;
		document.getElementById("playTime").value=item.innerHTML;
	}
	
	var status="false";
	function valForm(type)
	{
		var people_name_list="";
		var childs=document.getElementById("playerview").childNodes;
		for(var i=0;i<childs.length;i++)
		{
			var child=childs[i];
			if(child.nodeType==1)
			{
				var each_people=childs[i];
				if(each_people.value==""||each_people.value.length>50)
				{
					alert("打球人员姓名长度不规范！！！！！");
					return;
				}
				for(var index=0;index<each_people.value.length;index++)
				{
					if(each_people.value.charCodeAt(index)>8&&each_people.value.charCodeAt(index)<47)
					{
						alert("打球人员姓名包含非法字符！！！！！");
						each_people.focus();
						return;
					}
					else if(each_people.value.charCodeAt(index)>47&&each_people.value.charCodeAt(index)<65)
					{
						alert("打球人员姓名包含非法字符！！！！！");
						each_people.focus();
						return;
					}
					else if(each_people.value.charCodeAt(index)>90&&each_people.value.charCodeAt(index)<97)
					{
						alert("打球人员姓名包含非法字符！！！！！");
						each_people.focus();
						return;
					}
					else if(each_people.value.charCodeAt(index)>122&&each_people.value.charCodeAt(index)<255)
					{
						alert("打球人员姓名包含非法字符！！！！！");
						each_people.focus();
						return;
					}
				}
				if(people_name_list.indexOf(","+each_people.value+",")>=0)
				{
					alert("客人姓名不能重复，请自行添加标识区分！！！！！");
					each_people.focus();
					return;
				}
				people_name_list=people_name_list+","+each_people.value+",";
			}
		}
		if(document.getElementById("playTime").value=="")
		{
			alert("请选择开球时间！！！！！");
			return;
		}
		var contactName=document.getElementById("loginerName");
		var contactNameValue=document.getElementById("loginerName").value;
		if(contactName.value==""||contactName.value.length>50)
		{
			alert("联系人姓名不规范！！！！！");
			contactName.focus();
			return;
		}
		else
		{
			for(var index=0;index<contactNameValue.length;index++)
			{
				if(contactNameValue.charCodeAt(index)>8&&contactNameValue.charCodeAt(index)<47)
				{
					alert("联系人姓名包含非法字符！！！！！");
					contactName.focus();
					return;
				}
				else if(contactNameValue.charCodeAt(index)>47&&contactNameValue.charCodeAt(index)<65)
				{
					alert("联系人姓名包含非法字符！！！！！");
					contactName.focus();
					return;
				}
				else if(contactNameValue.charCodeAt(index)>90&&contactNameValue.charCodeAt(index)<97)
				{
					alert("联系人姓名包含非法字符！！！！！");
					contactName.focus();
					return;
				}
				else if(contactNameValue.charCodeAt(index)>122&&contactNameValue.charCodeAt(index)<255)
				{
					alert("联系人姓名包含非法字符！！！！！");
					contactName.focus();
					return;
				}
			}
		}
		var rule=/^(0(\d){1,3})([ ]?|[-]?)((\d){8})$/;
		if(!rule.exec(document.getElementById("loginerContact").value))
		{
			rule=/^(\d){11}$/;
			if(!rule.exec(document.getElementById("loginerContact").value))
			{
				alert("联系人联系方式不规范！！！！！");
				document.getElementById("loginerContact").focus();
				return;
			}
		}
		rule=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if(!rule.exec(document.getElementById("loginerEmail").value))
		{
			alert("邮箱地址填写不规范！！！！！");
			document.getElementById("loginerEmail").focus();
			return;
		}
		
		if(type==1)
		{
			var totalballview=document.getElementById("totalBall");
			var totalballvalue=document.getElementById("totalBall").value;
			if(totalballvalue==""||totalballvalue=="0")
			{
				alert("请填写购买球数！！！！！");
				totalballview.focus();
				return;
			}
			else
			{
				var icounts=document.getElementById("select_info_count").innerHTML;
				var diff=totalballvalue-icounts;
				if(diff<0){
					alert("每人最低消费一百球");
					document.getElementById("totalBall").focus();
					return;
				}
				var patrn=/^[0-9]{1,3}$/;
				if (!patrn.exec(totalballvalue))
				{
					alert("购买球数填写不规范！！！！！");
					totalballview.focus();
					return;
				}
			}
		}
		if(status=="false")
		{
			document.forms.bookform.submit();
			status="true";
		}
	}
</script>

</head>
<body>
<div class="clear"></div>
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx}" class="se">首页</a> &gt;&nbsp; <a href="${ctx}/golf/index.jsp" class="se">高尔夫首页</a> &gt;&nbsp; <span class="se1">预订球场</span></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
</div>
<div class="main980">
<div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">填写订单</b></span><span class="r"></span></div>
        <div class="inner clearfix_">
            <ul class="clearfix_ x2">
                <li><span class="t"><s:property escape="false" value="golfBook.golfInfoVo.name"/></span><a href="view.jsp?id=<s:property escape="false" value="golfBook.golfInfoVo.id"/>&pop" target="blank" class="orangea">查看详情</a></li>
                <li>下场日期：<b><s:property escape="false" value="golfBook.bookTime_show"/></b></li>
            </ul>
            <ul class="clearfix_ x2">
            <li>球场类型：<b><s:property escape="false" value="golfBook.sysConst.conName"/></b></li>
            <li>场地：<b><s:property escape="false" value="golfBook.name"/></b></li>
            </ul>
            <ul class="clearfix_ x2">
            <li>产品名称：<b><s:property escape="false" value="golfBook.explain"/></b></li>
            <li>免费项目：<b><s:iterator value="golfBook.pricelist" var="iprice">
			<s:if test="#iprice.startTime.compareTo(time)<=0&&#iprice.endTime.compareTo(time)>=0">
				<f:write2 type="GF包含项目" value='${iprice.containItem}' regexValue=","></f:write2>
			</s:if>
			</s:iterator></b></li>
            </ul>
            <ul class="clearfix_ x2">
                <li>价格：<b class="jp_jq">
                <s:iterator value="golfBook.pricelist" var="price">
       			<s:if test="#price.startTime.compareTo(time)<=0&&#price.endTime.compareTo(time)>=0">
       				<s:if test='isHoliday'>
       					<s:property value="#price.hPrice"/>
       				</s:if>
	       			<s:else>
	       				<s:property value="#price.price"/>
	       			</s:else>
       			</s:if>
       		    </s:iterator>
       			<s:if test='golfBook.type=="0"'>元/人</s:if><s:else> 元/球</s:else>
	            </b></li>
            </ul>
            <div class="separated_line"></div>
            <ul class="clearfix_ x2">
                <li><span class="t">退改规则</span></li>
            </ul>
            <ul class=" Uncertain"><li><b><s:property escape="false" value="golfBook.rmk"/></b></li></ul>
        </div>
        <b class="bl"></b> <b class="br"></b> 
    </div>
</div>

<div class="clear"></div>
<div class="jd_fy_box margin5">
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy">预订信息</li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
</div>
<s:form action="/golfSubmit.action" name="bookform" id="myform" method="post">

<input type="hidden" id="golfId" name="golfId" value="<s:property value="golfId"/>"/>
<input type="hidden" id="golfType" name="golfType" value="<s:property value="golfBook.type"/>"/>
<input type="hidden" name="siteId" value="<s:property value="golfBook.id"/>"/>
<input type="hidden" name="time" value="<s:property value="time"/>"/>
<input type="hidden" name="playTime" id="playTime" value=""/><s:property value="#iprice.signingprice"/>
<s:iterator value="golfBook.pricelist" var="iprice">
<s:if test="#iprice.startTime.compareTo(time)<=0&&#iprice.endTime.compareTo(time)>=0">
	<input type="hidden" name="ballamount" id="ballamount" value="<s:property value="#iprice.amount"/>"/>
	<input type="hidden" name="priceid" id="priceid" value="<s:property value="#iprice.id"/>"/>
	<input type="hidden" name="action" id="priceid" value="confirm"/>
	<s:if test='isHoliday==true&&golfBook.type=="1"'>
		<s:if test="#iprice.hPrice!=null &&#iprice.hSigningprice!=null">
		<input type="hidden" name="price" id="siteprice" value="<s:property value="#iprice.hPrice"/>"/>
		<input type="hidden" name="signPrice" id="signPrice" value="<s:property value="#iprice.hSigningprice"/>"/>
		</s:if><s:else>
		<input type="hidden" name="price" id="siteprice" value="<s:property value="#iprice.price"/>"/>
		<input type="hidden" name="signPrice" id="signPrice" value="<s:property value="#iprice.signingPrice"/>"/>
		</s:else>
		<input type="hidden" name="price_reg" id="price_reg" value="<s:property value="#iprice.hprice_reg"/>"/>
	</s:if>
	<s:elseif test='isHoliday==true&&golfBook.type=="0"'>
		<s:if test="#iprice.hPrice!=null &&#iprice.hSigningprice!=null">
		<input type="hidden" name="price" id="siteprice" value="<s:property value="#iprice.hPrice"/>"/>
		<input type="hidden" name="signPrice" id="signPrice" value="<s:property value="#iprice.hSigningprice"/>"/>
		</s:if><s:else>
		<input type="hidden" name="price" id="siteprice" value="<s:property value="#iprice.price"/>"/>
		<input type="hidden" name="signPrice" id="signPrice" value="<s:property value="#iprice.signingPrice"/>"/>
		</s:else>
		<input type="hidden" name="price_reg" id="price_reg" value="<s:property value="#iprice.hprice_reg"/>"/>
	</s:elseif>
	<s:elseif test='isHoliday==false&&golfBook.type=="0"'>
		<input type="hidden" name="price" id="siteprice" value="<s:property value="#iprice.price"/>"/>
		<input type="hidden" name="signPrice" id="signPrice" value="<s:property value="#iprice.signingPrice"/>"/>
		<input type="hidden" name="price_reg" id="price_reg" value="<s:property value="#iprice.price_reg"/>"/>
	</s:elseif>
	<s:else>
		<input type="hidden" name="price" id="siteprice" value="<s:property value="#iprice.price"/>"/>
		<input type="hidden" name="signPrice" id="signPrice" value="<s:property value="#iprice.signingPrice"/>"/>
		<input type="hidden" name="price_reg" id="price_reg" value="<s:property value="#iprice.price_reg"/>"/>
	</s:else>
</s:if>
</s:iterator>
<div class="jd_fj_list1">
	
    <ul> 
    	<s:if test="!passengerlist.isEmpty()">
    	<li class="w1" style="width:75px;">常用人姓名：</li>
        <li class="w5" id="clientNameCheckbox" style="width:90%; height:auto;">
            <s:iterator value="passengerlist" var="passenger" status="item">
					<span class="left czPassenger w6" id="pgnameview">&nbsp;
	                    <input type="checkbox" id="checkbox01" />
	                    <label><s:property value="#passenger.name"/></label>
					</span> 
				</s:iterator>
    	</li>	
    	</s:if>	
    	<br/>
    <s:if test='golfBook.type=="0"'>
        <li class="w1">打球人数：</li>
        <li class="w5">
            <div id="tm2008style" class="left select_box_people">
                <select name="count" id="language_dataq">
                <s:iterator begin="1" end="10" step="1" status="item">
                	<option value="<s:property value="#item.index+1"/>"><s:property value="#item.index+1"/></option>
                </s:iterator>
                </select>
            </div>
        </li>
     </s:if>
     <s:else>
        <li class="w1">打位数：</li>
        <li class="w5">
            <div class="left select_box_people"  id="tm2008style">
                <select name="count" id="language_dataq">
                    <option value="1">1</option>
                    <option value="2" >2</option>
                    <option value="3" >3</option>
                    <option value="4" >4</option>
                    <option value="5" >5</option>
                    <option value="6" >6</option>
                    <option value="7" >7</option>
                    <option value="8" >8</option>
                    <option value="9" >9</option>
                    <option value="10" >10</option>
                </select>
            </div>
        </li>
     	<li class="w1">购买球数：</li>
        <li class="w5">
            <input value="1" onkeyup="pracVal(this)" id="totalBall" name="totalBall" type="text" class="jdmc" style="width:60px;"/>×100
        </li>
     </s:else>
     
        <li class="w1" style="width:100%;">球员姓名：</li>
        <li class="w6" style="width:76%; height:auto;" id="playerview">
            <input name="playerName" id="playerName0" type="text" class="jdmc" maxlength="20"/>
        </li>
        <li class="w5g">支付总金额：<B class="jp_jq"><span id="pricesum">
        
        <s:iterator value="golfBook.pricelist" var="price">
   			<s:if test="#price.startTime.compareTo(time)<=0&&#price.endTime.compareTo(time)>=0">
   				<s:if test='isHoliday==true&&golfBook.type=="1"'>
   					<s:property value="#price.hPrice*100"/>
   				</s:if>
   				<s:elseif test='isHoliday==true&&golfBook.type=="0"'>
   					<s:property value="#price.hPrice"/>
   				</s:elseif>
   				<s:elseif test='isHoliday==false&&golfBook.type=="0"'>
   					<s:property value="#price.price"/>
   				</s:elseif>
    			<s:else>
    				<s:property value="#price.price*100"/>
    			</s:else>
   			</s:if>
   		</s:iterator>
        </span>元</B></li>
        <li class="w1 clearL">开球时间：</li>
        <!-- <li class="w2">
            <div id="uboxstyle5">
                <select name="bookTime" id="language_tm2008">
                <s:iterator value="golfBook.workTimeList" var="worktime" status="st">
                	<s:if test='#st.index==0&&golfBook.workTimeStatusList[#st.index]=="0"'>
                		<option value="<s:property value="#worktime"/>" selected="selected"><s:property value="#worktime"/></option>
                	</s:if>
                	<s:elseif test='golfBook.workTimeStatusList[#st.index]=="0"'>
                		<option value="<s:property value="#worktime"/>" ><s:property value="#worktime"/></option>
                	</s:elseif>
			    </s:iterator>
                </select>
            </div>
        </li> -->
    </ul>
    <ul class="times">
    <s:iterator value="golfBook.workTimeList" var="worktime" status="item">
    	<s:if test='golfBook.workTimeStatusList[#item.index]=="1"'>
    		<li class="Disable"><s:property value="#worktime"/></li>
    	</s:if>
    	<s:else>
    		<li onclick="choosePlayTime(this)"><s:property value="#worktime"/></li>
    	</s:else>
    </s:iterator>
    </ul>
    <ul class="Explain">
    <li><b class="Disable"></b>灰色不可选</li>
    <li><b></b>白色,可选</li>
    <li><b class="Selected"></b>红色,选中</li>
    </ul>
</div>
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<div class="clear"></div>
<div class="jd_fy_box margin5">
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy">联系人信息</li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
</div>
<div class="jd_fj_list2">
    <ul>
        <li class="orange w1">姓名：</li>
        <li class="w2">
            <input name="loginerName" id="loginerName" type="text" class="jdmc" value="<s:property value="member.name"/>"/>
        </li>
        <li class="orange w3">联系方式：</li>
        <li class="w2">
            <input name="loginerContact" id="loginerContact" type="text" class="jdmc" value="<s:property value="member.mobile"/>"/>
        </li>
        <li class="orange w3">邮箱地址：</li>
        <li class="w6">
            <input name="loginerEmail" id="loginerEmail" type="text" class="input2" value="<s:property value="member.email"/>"/>
        </li>
    </ul>
</div>
<s:hidden name="message" id="message"></s:hidden>
<div id="content"><img src="${ctx}/web/images/xx_bottom.jpg" /></div>
<div class=" Wmargin tijiao_frm"><a id="button2" class="button2 cuti" href="javascript:history.go(-1)">返 回 &gt;&gt;</a>
<a  class="button2 cuti" href="javascript:valForm(<s:property value="golfBook.type"/>)">提 交 &gt;&gt;</a></div>
</s:form>
<script type="text/javascript">
$(function(){
	// 入住人姓名处理 checkbox
	$("#clientNameCheckbox  :checkbox").attr('checked', false); 
	$("#playerview :input").val("");
	$("#clientNameCheckbox  :checkbox").click(function(){
		if($(this).is(":checked")){
			if($("#playerview :input[value='']").length==1&&$("#playerview :input").length==1){
				var playerview=document.getElementById("playerview");
				playerview.innerHTML="";
				showPlayerInputOne();
			}	
				if($("#playerview :input[value='']").length<=0){
					showPlayerInputOne();
				}
			//alert($("#playerview :input").length);
			var selectId=document.getElementById("language_dataq");

			for(var i=0;i<selectId.options.length;i++) 
			{ 
				if(selectId.options[i].text == $("#playerview :input").length) 
				{ 
					selectId.options[i].selected = true; 
					isExit = true; 
					break; 	
				} 
			}
			
			var s=document.getElementById("select_info_count");
			document.getElementById("language_dataq").value=$("#playerview :input").length;
			s.innerHTML=$("#playerview :input").length;
			if($("#playerview :input[value='']").length>0){
					var inp=$("#playerview :input[value="+$(this).next("label").text()+"]");
		    inp.remove();
					$("#playerview :input[value='']").eq(0).val($(this).next("label").text());
			}else{
				//$("#clientNameBox").append(addClientName());
				$("#select_info_Room").text($("#playerview :input").length);
				$("#playerview :input[value='']").eq(0).val($(this).next("label").text());
			}
			
			var playnum=0;
			if(document.getElementById("golfType").value=="0")
			{
			playnum=$("#playerview :input").length;
			var pricesumshow=parseFloat(playnum)*parseFloat(document.getElementById("siteprice").value);
			document.getElementById("pricesum").innerHTML=pricesumshow.toFixed(0);
			}
		}else{
			if($("#playerview :input").length!=1){
				var inp=$("#playerview :input[value="+$(this).next("label").text()+"]");
			    inp.remove();
				var s=document.getElementById("select_info_count");
				document.getElementById("language_dataq").value=$("#playerview :input").length;
				s.innerHTML=$("#playerview :input").length;
				var playnum=0;
				if(document.getElementById("golfType").value=="0")
				{
				playnum=$("#playerview :input").length;
				var pricesumshow=parseFloat(playnum)*parseFloat(document.getElementById("siteprice").value);
				document.getElementById("pricesum").innerHTML=pricesumshow.toFixed(0);
				}
			}else{
				$("#playerview :input[value="+$(this).next("label").text()+"]").val("");
			}
		}
	});
	 
	
	// 单击li后的一些操作
	$(".select_box_people").live("click",function(){
		var playnumsave=document.getElementById("language_dataq");
		var playnum=playnumsave.options[playnumsave.selectedIndex].value;
		//$("#clientNameCheckbox  :checkbox").attr('checked', false); 
		if($("#playerview :input[value='']").length==1&&$("#playerview :input").length==1){
			var playerview=document.getElementById("playerview");
			playerview.innerHTML="";
			playnum=playnum-$("#playerview :input").length;
			showPlayerInput(playnum);
		}
		playnum=playnum-$("#playerview :input").length;
		showPlayerInput(playnum);
		if(playnum<0){$("#clientNameCheckbox  :checkbox").attr('checked', false);}
		if(document.getElementById("golfType").value=="0")
		{
			playnum=$("#playerview :input").length;
			var pricesumshow=parseFloat(playnum)*parseFloat(document.getElementById("siteprice").value);
			document.getElementById("pricesum").innerHTML=pricesumshow.toFixed(0);
		}
    });
    // IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
	if(!-[1,]&&!window.XMLHttpRequest){
		$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	}
	
	if(document.referrer.indexOf("login.jsp")>0)
	{
		$("#button2").attr("href","javascript:history.go(-2)");
	}
});

</script> 
<script type="text/javascript" defer="defer">
	function showMessage(result)
	{
		if(result=="error")
		{
			alert("预订球数超过库存！！！！！");
		}
	}
	showMessage('${param.msg}');
</script>

<script type="text/javascript">
	//进入当前页面格式化总金额
	var ballnum = document.getElementById("totalBall");//球数
	var pricesumshow = document.getElementById("siteprice").value;
	if(ballnum!=null){
		pricesumshow=pricesumshow*ballnum.value*100;//总价格
	}
	pricesumshow = new Number(pricesumshow);//使其转换成number
	document.getElementById("pricesum").innerHTML=pricesumshow.toFixed(0);//保留小数点位数(这里不保留)
</script>
</body>





 
