<%@ page pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<style type="text/css">
	.module_a {
    	margin-top : auto;
		margin-right : auto;
		margin-bottom :10px;
		margin-left : auto;
		height:100%;
    }
	#divh {
    	margin-top : auto;
		margin-right : auto;
		margin-bottom :auto;
		margin-left : auto;
		height:100%;
    }
.myA{ color:black }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js"></script>
<title>订单详情- 高尔夫预订 - ${domain_cn } </title>
<script type="text/javascript">
//初始化时执行
$(document).ready(function(){
	$(".changedate").hide();//先把退场与改的控件都隐藏了。
	$(".exitsite").hide();//先把退场与改的控件都隐藏了。
	$("#submitorder").hide();
	$(".checkBoxName").each(function(){
		$(this).hide();
	});
	var optMsg="${message}";
	if(optMsg){
		alert(optMsg);
	}
	//初始化人员
	initPerson();
});

var unsubscribeExpPersonArr=[];
function initPerson(){
	var tempArr=[];
	var allPersonCount=0;
	$(".allPerson").each(function(){
		tempArr[$(this).attr("value")]=$(this).attr("id");
		allPersonCount++;
	});
	$(".unsubscribeExpPerson").each(function(){
		if(tempArr[$(this).attr("value")]){
			unsubscribeExpPersonArr[tempArr[$(this).attr("value")]]=true;
		}
	});
	
	var countE=0;
	$(".checkBoxName").each(function(){
		if(unsubscribeExpPersonArr[$(this).attr("value")]){
			countE++;
		}
	});
	//所有人都异常隐藏退订按钮
	if(countE >= allPersonCount){
		$("#exitbutton").hide();
	}
}

//取消订单
function firm(orderId,totalBall,priceidOrExpId,amount,action) {
	//alert(orderId);
	if(action=="confirm")
	{
		if (window.confirm("确认订单吗？")) {
		   window.location="${ctx}/golfCancel.action?orderId="+orderId+"&&priceid="+priceidOrExpId+"&&action="+action;
		}
	}
	else if(action=="cancel")
	{
		if (window.confirm("取消订单吗？")) {
			/*
			if(totalBall){
				amount=(amount-0)+(totalBall-0);
			}*/
			var url="${ctx}/golfCancel.action?orderId="+orderId+"&&priceid="+priceidOrExpId+"&&amount="+amount+"&&golfOrderVo.totalBall="+totalBall+"&&action="+action;
		  	window.location=url;
		}
	}else if(action="confirmExp"){
		if (window.confirm("确认订单吗？")) {
			var orderIdValue=document.getElementById("orderIdValue").value;
			//alert("${ctx}/golfCancel.action?orderId="+orderIdValue+"&&expOrderId="+priceidOrExpId+"&&action="+action);
		   window.location="${ctx}/golfCancel.action?orderId="+orderIdValue+"&&expOrderId="+priceidOrExpId+"&&action="+action;
		}
	}
	
}

function submitorder(){
	var applyflag=$("#applyflag").val();//取得applyflag标记位
	//球场类型
	var siteType="${golfOrderVo.golfSiteVo.type}";
	if(applyflag=='1'){//------------------------------------退场action
		var errorTip="";
		var reason=$("#exReason").val();
		if(reason.length>199 || reason.length<1){//理由不能输入太长！！！
			errorTip+="您的退场理由输入不合法，请重新输入！";
		}
		var confirmTip="您确定要申请退场吗？";
		var personNames=getPersonNames();
	 	if(siteType!="1"){
			if(!personNames){
				errorTip+="\n请至少选择一位需要退场的打球人员";
			}else {
				confirmTip="您确定要为"+personNames+"申请退场吗?";
			}	
		}
		if(errorTip){
			alert(errorTip);
			return ;
		}
		$("#myform").attr("action","${ctx}/golfOrderAction!quitOrChangeOrder.action");
		if(confirm(confirmTip)){
			$("#myform").submit();
	    }else{
	          return;
	    }
	}
	if(applyflag=='0'){//-------------------------------------改期action
		var exdate=$.trim($("#d241").val());
		var errorTip="";
		if(!exdate){//理由不能输入太长！！！
			errorTip+="您未输入正确的改期时间";
		}
		var confirmTip="您确定要申请改期吗？";
		var personNames=getPersonNames();
	 	if(siteType!="1"){
			if(!personNames){
				errorTip+="\n请至少选择一位需要改期的打球人员";
			}else {
				confirmTip="您确定要为"+personNames+"申请改期吗?";
			}	
		}
		if(errorTip){
			alert(errorTip);
			return ;
		}
		
		$("#myform").attr("action","${ctx}/golfOrderAction!quitOrChangeOrder.action");
		if(confirm(confirmTip)){
			$("#myform").submit();
	    }else{
	          return;
	    }
	}
}

function getPersonNames(){
		var personNames="";
		var names=$(".playerNames");
		$(".checkBoxName").each(function (index){
			if($(this).attr("checked")){
				personNames+=(names.eq(index).text()+",");
			}
		});
		//guestNames
		if(personNames){
			personNames=personNames.substr(0,personNames.lastIndexOf(","));
		}
		return personNames;
}
function exitbutton1(){//点击"申请退场"按钮时
		$(".exitsite").show();//显示退的控件。
		$(".changedate").hide();//且隐藏改的控件。
		$("#cancelbutton").hide();//取消按钮置为隐藏。
		$("#applyflag").val('1');//将退的标志位改为      1  
		$("#submitorder").show(); 
		var siteType="${golfOrderVo.golfSiteVo.type}";
		if(siteType!="1"){
				$(".checkBoxName").each(function(){
				if($(this).attr("consumerSts")==0&&!unsubscribeExpPersonArr[$(this).attr("value")]){
					$(this).removeAttr("disabled");
				}else {
					$(this).attr("checked",false);
					$(this).attr("disabled",true);
				}			
				$(this).show();
			});
		}
}
function changebuttion1(){//点击"申请改期"按钮时
		$(".exitsite").hide();//隐藏退的控件。
		$(".changedate").show();//且显示改的控件。
		$("#cancelbutton").hide();//取消按钮置为隐藏。
		$("#applyflag").val('0');//将退的标志位改为      0   
		$("#submitorder").show(); 
		var siteType="${golfOrderVo.golfSiteVo.type}";
		if(siteType!="1"){
			$(".checkBoxName").each(function(){
				if($(this).attr("consumerSts")==0){
					$(this).removeAttr("disabled");
				}else {
					$(this).attr("checked",false);
					$(this).attr("disabled",true);
				}				
				$(this).show();
			});
		}	
}

function resonClear(){
	$("#exReason").val("");
}
//打开订单状态div
function opendiv(){
	var mydiv = document.getElementById("orderStsdiv");
	if(mydiv.style.display=="none"){
		$("#ss").html('<a href="javascript:void(new Date())" onclick="opendiv()" class="myA">订单状态跟踪▲</a>');
		$("#orderStsdiv").show();
	}else{
		$("#ss").html('<a href="javascript:void(new Date())" onclick="opendiv()" class="myA">订单状态跟踪▼</a>');
		$("#orderStsdiv").hide();
	}
}
//打开退改记录div
function openmydiv(){
	var mydiv = document.getElementById("mydiv");
	if(mydiv.style.display=="none"){
		$("#sss").html('<a href="javascript:void(new Date())" onclick="openmydiv()" class="myA">查看退改记录▲&nbsp;</a>');
		$("#mydiv").show();
	}else{
		$("#sss").html('<a href="javascript:void(new Date())" onclick="openmydiv()" class="myA">查看退改记录▼</a>');
		$("#mydiv").hide();
	}
}
</script>
</head>
<body>
<div id="tips" class="ck1" style="display:none; width:238px;"> <a title="关闭" href="javascript:closeTips('tips')">X</a>
    <h2>退票规定：</h2>
    <p>收取票面价（不含税）的10%作为退票费;</p>
    <h2>改签规定：</h2>
    <p>不论在航班离站前或后，同舱位免费变更，不限次数。</p>
</div>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<form action="" id="myform" method="post">
<input type="hidden" id="applyflag" value="" name="applyflag"/><!-- 申请退改标志位 -->
<input type="hidden" name="orderId" value=""/><!-- 定单  ID -->
<!-- 退改要传的值begin -->
<input type="hidden" value="${golfOrderVo.id}" name="golfOrderExceptionVo.orderId"/><!-- 要退的定单ID -->
<input type="hidden" value="${golfOrderVo.id}" name="id"/><!-- 要退的定单ID -->
<!-- 退款理由 下面已取！-->
<input type="hidden" value="${golfOrderVo.additionalFee}" name="golfOrderExceptionVo.feeRate"/>
<input type="hidden" value="${golfOrderVo.amountPrice}" name="golfOrderExceptionVo.fee"/>
<input type="hidden" value="${golfOrderVo.price}" name="golfOrderExceptionVo.price"/>
<input type="hidden" value="${golfOrderVo.createUser }" name="golfOrderExceptionVo.createUser"/>
<input type="hidden" value="${golfOrderVo.sts}" name="golfOrderSts"/>
<input type="hidden" value="" name="logGolfOrderContent"/><!-- 上哪儿取日志内容！！！ -->
<!-- 退改要传的值end -->
<div class="floatleft width783">
    <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
    <div class="listTAB rightbg">
        <div class="clear"></div>
        <!--Module-->
        <div class="module_a Order">
            <div class="title"><span class="l"></span><span class="c"><span>高尔夫订单详情</span><span class="Order_Status">订单总金额：<b class="red" id="amountPrice"><s:property escape="false" value="golfOrderVo.amountPrice"/></b>元</span></span><span class="r"></span></div>
            <div class="inner clearfix_">
                <ul class="clearfix_ x3">
                    <li>订单号：<b><s:property escape="false" value="golfOrderVo.code"/></b></li>
                    <li>订单状态：<b><f:write type="高尔夫订单状态" value="${golfOrderVo.sts}"/></b></li>
                    <li>订单生成时间：<b><fmt:formatDate value="${golfOrderVo.createTime}" type="date" pattern="yyyy-MM-dd HH:mm" /></b></li>
                </ul>
                <ul class="clearfix_ Uncertain">
                    <li>订场规则：<b><s:property escape="false" value="golfOrderVo.golfSiteVo.rmk"/></b></li>
                </ul>
            </div>
            <b class="bl"></b> <b class="br"></b> </div>
        <!--Module end--> 
        <!--Module-->
        <div class="module_a Order">
            <div class="title"><span class="l"></span><span class="c">预订球场信息</span><span class="r"></span></div>
            <div class="inner clearfix_">
                <ul class="clearfix_ x2">
                    <li><span class="t"></span>产品名称：<b><s:property escape="false" value="golfOrderVo.golfInfoVo.name"/></b><a href="${ctx}/golf/view.jsp?id=<s:property value="golfInfoVo.id"/>&pop" target="_blank">查看详情</a></li>
                    <li>下场日期：<b><s:date name="golfOrderVo.bookTime" format="yyyy-MM-dd"/> </b></li>
                </ul>
                <ul class="clearfix_ x2">
                    <li>球场类型：<b><f:write type="球场类型" value="${golfOrderVo.golfSiteVo.type}"/></b></li>
                    <li>场地：<b><s:property escape="false" value="golfOrderVo.golfSiteVo.name"/></b></li>
                </ul>
                <ul class="clearfix_ Uncertain">
                    <li>免费项目：<b><f:write2 type="GF包含项目" value="${golfPriceVo.containItem}" regexValue=","></f:write2></b></li>
                </ul>
            </div>
            <b class="bl"></b> <b class="br"></b> </div>
        <!--Module end--> 
        <!--Module-->
        <div class="module_a Order">
            <div class="title"><span class="l"></span><span class="c">预订信息</span><span class="r"></span></div>
            <div class="inner clearfix_" id="divh">
                <ul class="clearfix_ x3">
                    <li>打球人数：<b><s:property escape="false" value="golfOrderVo.count"/></b></li>
                    <s:if test="golfOrderVo.golfSiteVo.type==1">
                    <li>球数：<b>${golfOrderVo.totalBall}</b>×100个
                    </li>
                    <li>
                    	单价：<b>${golfOrderVo.golfPriceVo.price}</b>元/球
                    </li>
                    </s:if>
                </ul>
                <ul class="clearfix_ x3">
                    <li>预订时间：<b><s:date name="golfOrderVo.bookTime" format="yyyy-MM-dd HH:mm"/></b></li>
                    <li> 确认开球时间：<s:date name="golfOrderVo.confirmTime" format="yyyy-MM-dd HH:mm"/></li>
					<%-- 改期可以显示的页面end --%>
                </ul>
                  <ul class="clearfix_ Uncertain">
                    <li>姓名：<b>
                    <s:iterator value="golfOrderPlayVoList">
                    		<label>
	                    		<s:if test="isShowRM">
	                    			 <input type="checkbox" name="playerIds" value="<s:property value="id" escape="false"/>" 
	                    			   <s:if test="golfOrderVo.golfSiteVo.type!=0">checked="checked"</s:if>
	                    			   class="checkBoxName" consumerSts="${sts }"/>
	                    		</s:if>
								<font class="playerNames"><s:property value="name" escape="false"/></font> &nbsp;
							</label>
					</s:iterator>
					</b></li>
                </ul>
               <br>
               <s:if test="isShowRM">
                  <ul class="clearfix_ x4">
                    <li>
                       <button type="button" id="exitbutton" onclick="exitbutton1()">申请退场</button>
		               <button type="button" id="changebuttion" onclick="changebuttion1()">申请改期</button>
                    </li>
                </ul>
		            </s:if>
                
                <ul class="clearfix_ x4">
<%--                   退场可以显示的页面begin--%>
                    <li class="exitsite" style="width:60px;">
                    	退场理由：
                    </li>
                    <li class="exitsite">
                    	<textarea id="exReason" name="golfOrderExceptionVo.rmk" onclick="resonClear()">请输入理由..</textarea>
                    </li>
                    
                   <!-- 退场可以显示的页面end -->
                   
                    <!-- 改期可以显示的页面begin -->
                  	<li class="changedate" style="width:60px;">
                  		所改日期：
                  	</li>  
                    <li class="changedate">
	                    <div class="inb Order_inb">
		                    	<input type="text" name="updateTime" class="inps"
		                    	 id="d241" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd/HH:00',minDate:'${updateTime}',maxDate:'2020-01-01'})" />
                    	 </div>
                    </li>
					<!-- 改期可以显示的页面end -->
                </ul>
              
                <s:if test="golfOrderVo.sts==3||golfOrderVo.sts==6||golfOrderVo.sts==9">
               <ul class="clearfix_ Uncertain">
                    <li>原因：<b><s:property escape="false" value="golfOrderVo.rmk"/></b></li>
               </ul>
               </s:if>
            </div>
            <b class="bl"></b> <b class="br"></b> </div>
           <%--如果有退改信息才显示 --%>
           <s:if test="golfOrderExceptionList.size()>0">
	           <% request.setAttribute("count",((List)request.getAttribute("golfOrderExceptionList")).size()); %>
	           <div class="module_a Order">
	           <div class="title"><span class="l"></span><span class="c"><font id="sss"><a href="javascript:void(new Date())" onclick="openmydiv()" class="myA">订单退改记录▼</a></font></span><span class="r"></span></div>
	           <s:iterator value="golfOrderExceptionList" var="orderException" status="in">
	           <c:if test="${in.count==1}">
	           		  <div class="inner clearfix_">
	                <ul class="clearfix_ x4">
	                    <li>订单号：<b><s:if test="#orderException.sts==4 || #orderException.sts==5 || #orderException.sts==6">T</s:if><s:if test="#orderException.sts==7 || #orderException.sts==8 || #orderException.sts==9 || #orderException.sts==11">G</s:if><s:property escape="false" value="#orderException.code"/></b></li>
	                    <li>状态：<b><f:write type="高尔夫订单状态" value="${sts}"/> </b></li>               
	                    <c:if test="${orderException.type=='M'}">
	                     <li>改期时间：<b><s:date name="#orderException.bookTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                    </c:if>
	                     <c:if test="${orderException.confirmTime!=''&&orderException.confirmTime!=null}">
	                     <li>确认时间：<b><s:date name="#orderException.confirmTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                     </c:if>
	                </ul>
	                <ul class="clearfix_ x4">
	                    <li>理由：<b><s:property escape="false" value="#orderException.rmk"/></b></li>
	                    <li>申请时间：<b><s:date name="#orderException.createTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                    <s:if test="#orderException.sts==4||#orderException.sts==5||#orderException.sts==6">
	                    	<li>退款金额：<b><s:property value="#orderException.price"/></b></li>
	                    </s:if>
	                    <s:else>
	                    	<li>补款金额：<b><s:property value="#orderException.price"/></b></li>
	                    </s:else>
	                    <%--废弃原来的费用显示,客户不能看到手续费   	lixun
	                  <li>手续费：<b><s:property escape="false" value="#orderException.fee"/></b></li>
	                    <li>交易金额：<b><s:property escape="false" value="#orderException.price"/></b></li>
	                    --%>
	                    <!-- 如果打球人员少于3人则本行显示 如果大于等于三人则换行显示  wenz-->
	                    <s:if test="#orderException.golfOrderPlayVoList.size<3">
		                    <li>姓名：<b>
		                    	<s:iterator value="#orderException.golfOrderPlayVoList" var="player">
		                    		<s:property escape="false" value="#player.name"/>&nbsp;&nbsp;
		                    	</s:iterator>
		                    </b></li>
	                    </s:if>
	                </ul> 
	                <s:if test="#orderException.golfOrderPlayVoList.size>=3">
	                  <ul class="clearfix_ Uncertain">
		                    <li>姓名：<b>
		                    	<s:iterator value="#orderException.golfOrderPlayVoList" var="player">
		                    		<s:property escape="false" value="#player.name"/>&nbsp;&nbsp;
		                    	</s:iterator>
		                    </b></li>
		               </ul>
	                </s:if>
	            </div>
	             <div id="mydiv" style="display:none">
	           </c:if>
	           <c:if test="${in.count!=1}">
	            <div class="inner clearfix_" >
	                <ul class="clearfix_ x4">
	                    <li>订单号：<b><s:if test="#orderException.sts==4 || #orderException.sts==5 || #orderException.sts==6">T</s:if><s:if test="#orderException.sts==7 || #orderException.sts==8 || #orderException.sts==9 || #orderException.sts==11">G</s:if><s:property escape="false" value="#orderException.code"/></b></li>
	                    <li>状态：<b><f:write type="高尔夫订单状态" value="${sts}"/> </b></li>
	                    <c:if test="${orderException.type=='M'}">
	                     <li>改期时间：<b><s:date name="#orderException.bookTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                    </c:if>
	                    <c:if test="${orderException.confirmTime!=''&&orderException.confirmTime!=null}">
	                     <li>确认时间：<b><s:date name="#orderException.confirmTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                     </c:if>
	                </ul>
	                <ul class="clearfix_ x4">
	                    <li>理由：<b><s:property escape="false" value="#orderException.rmk"/></b></li>
	                    <li>申请时间：<b><s:date name="#orderException.createTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                    <s:if test="#orderException.sts==4||#orderException.sts==5||#orderException.sts==6">
	                    	<li>退款金额：<b><s:property value="#orderException.price"/></b></li>
	                    </s:if>
	                    <s:else>
	                    	<li>补款金额：<b><s:property value="#orderException.price"/></b></li>
	                    </s:else>
	                    <%--废弃原来的费用显示,客户不能看到手续费   	lixun
	                  <li>手续费：<b><s:property escape="false" value="#orderException.fee"/></b></li>
	                    <li>交易金额：<b><s:property escape="false" value="#orderException.price"/></b></li>
	                    --%>
	                    <s:if test="#orderException.golfOrderPlayVoList.size<3">
		                    <li>姓名：<b>
		                    	<s:iterator value="#orderException.golfOrderPlayVoList" var="player">
		                    		<s:property escape="false" value="#player.name"/>&nbsp;&nbsp;
		                    	</s:iterator>
		                    </b></li>
	                    </s:if>
	                </ul> 
	                <s:if test="#orderException.golfOrderPlayVoList.size>=3">
	                  <ul class="clearfix_ Uncertain">
		                    <li>姓名：<b>
		                    	<s:iterator value="#orderException.golfOrderPlayVoList" var="player">
		                    		<s:property escape="false" value="#player.name"/>&nbsp;&nbsp;
		                    	</s:iterator>
		                    </b></li>
		               </ul>
	                </s:if>
	            </div>
	            </c:if>
	      		</s:iterator>
	      		</div>
	      		<c:if test="${count>1}">
	      		</c:if>
				 <b class="bl"></b> <b class="br"></b> 
				</div>
			</s:if>
        <!--Module end--> 
        <!--Module-->
        <div class="module_a Order" style="width: 98%">
            <div class="title"><span class="l"></span><span class="c">联系人信息</span><span class="r"></span></div>
            <div class="inner clearfix_">
                <ul class="clearfix_ x2">
                    <li>姓名：<b><s:property escape="false" value="orderContactVo.name"/></b></li>
                    <li>联系方式：<b><s:property value="orderContactVo.mobile" /></b></li>
                    <li>邮箱地址：<b><s:property value="orderContactVo.email" /></b></li>
                </ul>
            </div>
            <b class="bl"></b> <b class="br"></b> </div>
           <div class="module_a Order"   >
				 <div class="title"><span class="l"></span><span class="c" id="ss"><a href="javascript:void(new Date())" onclick="opendiv()" class="myA">订单状态跟踪▼</a></span><span class="r"></span></div>
				<div class="inner clearfix_" id="orderStsdiv" style="display: none" >
					<table style="width: 100%" align="left" cellspacing="1" cellpadding="0"
						border="0" class="BuyCard Table_w762 innerOrder">
						<tbody>
							<tr>
								<th width="150">
									时间
								</th>
								<th>
									跟踪记录显示
								</th>
							</tr>
							<s:iterator value="golfOrderLogVoList" id="list">
								<tr>
									<td>
									<s:date name="#list.createTime" format="yyyy-MM-dd HH:mm:ss"/>
									</td >
									<td align="center">
										
											<s:property value="#list.content" escape="false"/>
										
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<b class="bl"></b>
				<b class="br"></b>
			</div> 
        <!--Module end-->
        <div class="clear"></div>
        <div class="greytext" id="pager">
        <a href="${ctx}/member/order.jsp?tabIndex=2" class="button2 cuti">返 回 &gt;&gt;</a> 
        <a href="" id="submitorder" onclick="submitorder();return false;" class="button2 cuti">提交&gt;&gt;</a>
     		<s:if test="golfOrderVo.sts !=0&&golfOrderVo.paySts == 0">
               		<s:if test="golfOrderVo.sts==10">
               			<a href="javascript:firm('<s:property value="id"/>','','<s:property value="golfPriceVo.id"/>','','confirm')" id="confirmbutton" class="button2 cuti">${user_confirm} &gt;&gt;</a>
               			<a href="javascript:firm('${id}','${golfOrderVo.totalBall}','${golfPriceVo.id}','${golfPriceVo.amount}','cancel')" id="cancelbutton" class="button2 cuti">取消 &gt;&gt;</a>
               		</s:if>
           </s:if>
           <s:iterator value="golfOrderExceptionList" var="orderException" status="status">
	           <s:if test="golfOrderExceptionList.get(#status.index).sts==10">
	               	<a href="javascript:firm('<s:property value="id"/>','','<s:property value="golfOrderExceptionList.get(#status.index).id"/>','','confirmExp')" id="cancelbutton" class="button2 cuti">${user_confirm} &gt;&gt;</a>
	           </s:if>
          </s:iterator>
          <input type="hidden" id="orderIdValue" value="<s:property value="id"/>">
           <!-- 
           golfOrderExceptionList.get(0).sts
           <s:iterator value="golfOrderExceptionList" var="orderException" status="status">
	           <s:if test="golfOrderExceptionList.get(#status.index).sts==10">
	               	<a href="javascript:firm('<s:property value="id"/>','','<s:property value="golfOrderExceptionList.get(0).id"/>','','confirmExp')" id="cancelbutton" class="button2 cuti">${user_confirm} &gt;&gt;</a>
	           </s:if>
          </s:iterator>
            -->
        <div class="clear"></div>
    </div>
    <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
</div>
</div>
</form>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
</div>
<%--迭代所有人员 --%>
<s:iterator value="golfOrderPlayVoList" status="status">
<input type="hidden" value="${name }" id="${id}" class="allPerson">
</s:iterator>
<%-- 找出退场失败的订单中的人员--%>
<s:iterator value="golfOrderExceptionList" status="status" var="exceptionVo">
<s:if test="sts==6">
<s:iterator value="#exceptionVo.golfOrderPlayVoList" status="status" >
<input type="hidden"  value="${name }" class="unsubscribeExpPerson">
</s:iterator>
</s:if>
</s:iterator>
<script>
	//订单总金额:将小数点去掉
	var amountPrice = new Number($("#amountPrice").html());
	$("#amountPrice").html(amountPrice.toFixed(0));
</script>
</body>