<%@ page pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
	.module_a {
    	margin-top : auto;
		margin-right : auto;
		margin-bottom :10px;
		margin-left : auto;
		
    }
	#yddiv {
		
		height:200px;
    }
	li.exitsite {
    	margin-top : auto;
		margin-right : 50px;
		margin-bottom :auto;
		margin-left : auto;
    }
    .myA{ color:black }
</style>
<script type="text/javascript">
$(document).ready(function(){
	//输出操作提示信息
	var optTip=$("#optTipMsg").val();
	if(optTip){
		try{
			var optStr=eval("("+optTip+")");
			if(optStr=="error"){
				alert("确认失败!");
			}else if(optStr=="success"){
				alert("确认成功!");
			}
		}catch(ex){

		}
	}
	$(".changedate").hide();//先把退场与改的控件都隐藏了。
	$(".exitsite").hide();//先把退场与改的控件都隐藏了。
	$("#submitorder").hide();
	$(".checkBoxName").each(function(){
		$(this).hide();
	});
	bindCancel();
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
	//判断贵宾间不能再退
	if("${orderLoungeVo.loungeRoomVo.type}"=="1"){
		if($("#lastExpOrderSts").val()&&$("#lastExpOrderSts").val()=="6"){
			$("#exitbutton").hide();
		}
	}
}

function submitorder(){
	var loungeType="${orderLoungeVo.loungeRoomVo.type}";
	var applyflag=$("#applyflag").val();//取得applyflag标记位
	if(applyflag=='1'){//-------------------------退场地跑这个action
		var errorTip="";
		var rmkId=$("#rmkId").val();
		if(rmkId){
			if(rmkId.length>199){//理由不能输入太长！！！
				errorTip="您输入的退场理由过长,请重新输入！"
			}
		}else {
			errorTip="您未输入退场理由,请输入退场理由";
		}
		
		//person 要退改的人员
		var personNames=getPersonNames();
		var confirmTip="您确定要申请退场吗？";
		if(loungeType!="1"){
			if(!personNames){
				errorTip+="\n请至少选择一位需要退场的贵宾";
			}else {
				confirmTip="您确定要为"+personNames+"申请退场吗？";
			}	
		}
		if(errorTip){
			alert(errorTip);
			return ;
		}
		$("#myform").attr("action","${ctx}/loungeOrderAction!unsubscribeOrder.action");
		if(confirm(confirmTip)){
			$("#myform").submit();
	    }else{
	          return;
	    }
	}
	if(applyflag=='0'){//-------------------------改期必须跑这个
		var startTime=$.trim($("#startTime").val());
		var errorTip="";
		if(startTime=="" || startTime<10){
			errorTip="您的改期开始日期必填，而且格式一定要正确！";
		}
		
		var endTime=$.trim($("#endTime").val());
		if("${orderLoungeVo.loungeRoomVo.type}"=="1"){
			if(endTime=="" || endTime<10){
				errorTip+="\n您的改期结束日期必填，而且格式一定要正确！";
			}
		}
		//贵宾间开始和结束时间应该是在同一天的不同时间段
		if(loungeType==1){
			if(startTime.substr(0,10)==endTime.substr(0,10)){
					//是同一天了时间必须大于改签的时间
				if(parseInt(endTime.substr(10))<=parseInt(startTime.substr(10))){
					alert("改期结束时间必须大于开始时间");
					return ;
				}
			}else{
				alert("贵宾间开始和结束时间应该是在同一天的不同时间段");
				return ;
				}
		}
		var personNames=getPersonNames();
		var confirmTip="您确定要申请改期吗？";
		if(loungeType!="1"){
			if(!personNames){
				errorTip+="\n请至少选择一位需要退场的贵宾";
			}else {
				confirmTip="您确定要为"+personNames+"申请改期吗？";
			}	
		}
		if(errorTip){
			alert(errorTip);
			return ;
		}
		$("#myform").attr("action","${ctx}/loungeOrderAction!changeOrder.action");
		if(confirm(confirmTip)){
			$("#myform").submit();
	    }else{
	          return;
	    }
	}
	/*
	if(applyflag!=0 && applyflag!=1){
		alert("您现在不能申请退场或者申请改期！");
		return;
	}
	*/
}
function getPersonNames(){
		var personNames="";
		var names=$(".guestNames");
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
		$("#cancelbutton").hide();//隐藏取消按钮。
		$("#applyflag").val('1');//将退的标志位改为      1  
		$("#submitorder").show(); 
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
function changebuttion1(){//点击"申请改期"按钮时
		$(".exitsite").hide();//隐藏退的控件。
		$(".changedate").show();//且显示改的控件。
		$("#cancelbutton").hide();//隐藏取消按钮。
		$("#applyflag").val('0');//将退的标志位改为      0 
		$("#submitorder").show(); 
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

function bindCancel(){
	var cancelUrl=$("#cancelbutton").attr("href");
	$("#cancelbutton").click(function(){
		if(confirm("你确定要取消吗?")){
		window.location=cancelUrl;
		}
	});
	var confirmUrl=$("#confirmbutton").attr("href");
	$("#confirmbutton").click(function(){
		if(confirm("你确定要确认吗?")){
		window.location=confirmUrl;
		}
	});
}

function resonClear(){
	var reason=$("#rmkId").val();
	var flag=false;
	if(reason=='请输入理由' || flag){
		flag=true;
		$("#rmkId").val("");
	}
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
	var mydiv = document.getElementById("divshow");
	if(mydiv.style.display=="none"){
		$("#sss").html('<a href="javascript:void(new Date())" onclick="openmydiv()" class="myA">查看退改记录▲&nbsp;</a>');
		$("#mydiv").hide();
		$("#divshow").show();
	}else{
		$("#sss").html('<a href="javascript:void(new Date())" onclick="openmydiv()" class="myA">查看退改记录▼</a>');
		$("#divshow").hide();
		$("#mydiv").show();
	}
}
</script>
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<%--
<link href="${ctx}/web/css/select3css.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/web/js/clubJs/js/11.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/js/select2css.js" language="javascript"></script>
 --%>


<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js"></script>

<title>${loungeInfoVo.name}订单详情-机场休息室球场预订 - ${domain_cn }</title>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>

<form action="" id="myform" method="post">
<input type="hidden" value="${orderLoungeVo.id}" name="id"/><!-- 要退的订单ID -->
<input type="hidden" value="${orderLoungeVo.id}" name="orderLoungeVo.id"/>
<input type="hidden" value="${orderLoungeVo.loungeRoomVo.type}" name="orderLoungeVo.loungeRoomVo.type"/>
<input type="hidden" value="<s:property value="orderLoungeVo.loungeRoomVo.type"/>" name="roomType"/><!-- 贵宾间、贵宾厅、二舱 -->
<input type="hidden" value="${orderLoungeVo.paySts}" id="applyflag" />
<input type="hidden" value='${msg}' id="optTipMsg">
<div class="floatleft width783">
    <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
    <div class="listTAB rightbg">
        <!--Module-->
        <div class="module_a Order" style="height:100%;">
            <div class="title"><span class="l"></span><span class="c">预订机场信息</span><span class="r"></span></div>
            <div class="inner clearfix_" >
                <ul class="clearfix_ x3">
                    <li>休息室类型：<b><f:write type="休息室类型" value="${orderLoungeVo.loungeRoomVo.type}"/></b></li>
                    <!-- 需要通过数字找出类型 -->
                    <li>机场：<b>
                    	<ap:write key="${orderLoungeVo.flightNo}"></ap:write>
                    </b></li>
                    <li>提供商：<b>
                    	<s:property escape="false" value="orderLoungeVo.loungeName"/>
                    </b></li>
                </ul>
                <ul class="clearfix_ Uncertain">
                
                    <li>免费项目：
                    	<b>
                    		<f:write2 type="L包含项目" value="${orderLoungeVo.loungeRoomVo.loungePriceVo.item}" regexValue=","/>
                    	</b>
                    </li>
                </ul>
            </div>
            <b class="bl"></b> <b class="br"></b> </div>
        <!--Module end--> 
        <!--Module-->
        <div class="module_a Order" id="yddiv" style="height:100%">
            <div class="title"><span class="l"></span><span class="c"><b class="left">预订信息</b><b class="right">订单总金额：<b class="red" id="amountPrice"><s:property value="orderLoungeVo.price"/></b>元</b></span><span class="r"></span></div>
            <div class="inner clearfix_">
                <ul class="clearfix_ x3">
                    <li>订单号：<b><s:property escape="false" value="orderLoungeVo.code"/> </b></li>
                    <li>订单状态：<b><f:write type="机场休息室订单状态" value="${orderLoungeVo.sts}"/></b></li>
                    <li>订单生成时间：<b><s:date name="orderLoungeVo.createTime" format="yyyy-MM-dd HH:mm"/></b></li><!--yyyy年MM月dd日  HH时mm分 -->
                </ul>
                <s:if test="orderLoungeVo.loungeRoomVo.type==1">
                <ul class="clearfix_ x3">
                    <li>预订时间：<b><s:date name="orderLoungeVo.startTime" format="yyyy-MM-dd HH:mm"/>-<s:date name="orderLoungeVo.endTime" format="HH:mm"/></b></li>
                    <li>共计：<b><s:property value="hours"/>小时</b></li>
                    <li>预订人数：
                    	<b><s:property  value="orderLoungeVo.orderLoungeGuestVoList.size()"/></b>
                    </li>
                </ul>
                </s:if>
                <s:else>
                <ul class="clearfix_ x3">
                    <li>预订人数：
                    	<b><s:property  value="orderLoungeVo.orderLoungeGuestVoList.size()"/></b>
                    </li>
                    <li>到达时间：<b><s:date name="orderLoungeVo.startTime" format="yyyy-MM-dd HH:mm"/></b></li>
                </ul>
                </s:else>
                <ul class="clearfix_ Uncertain">
                    <li>贵宾姓名：
                    	<b>
                    	<s:iterator value="orderLoungeVo.orderLoungeGuestVoList" status="status">
	                        <label>
	                        	 <s:if test="isShowRM&&orderLoungeVo.loungeRoomVo.type!=1">
	                        		<input type="checkbox"  value="<s:property escape="false" value="id"/>" 
	                        		<%--将已退场的贵宾checkbox 至于不可用状态--%>
	                        		<s:if test="consumerSts==2||consumerSts==1">disabled="disabled"</s:if>
	                        		name="orderLoungeVo.guestIdArray" class="checkBoxName" consumerSts="${consumerSts }">
	                       		 </s:if>
								<s:if test="(#status.index+1)%6==0"><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</s:if>
								<font class="guestNames"><s:property escape="false" value="name"/></font>&nbsp;<s:property escape="false" value="type"/>&nbsp;<s:property escape="false" value="flightNo"/>
	                       		 <!-- 如果只有一条数据就不显示 -->
	                       		 <s:if test="#status.index!=orderLoungeVo.orderLoungeGuestVoList.size-1">|&nbsp;</s:if>
							</label>
						</s:iterator>
                        </b>
                     </li>
                </ul>
                <ul class="clearfix_ Uncertain">
                    <li>单买项目：
		                      <b>
		                      ${orderLoungeVo.additionalItemId}
		                      </b>
                    </li>
                </ul>
                <!-- 改期可以显示的页面！！！！ -->  
                <ul class="clearfix_ Uncertain">
                    <li>退改规则：
                    	<b><s:property escape="false" value="orderLoungeVo.loungeRoomVo.rmk"/></b>
                    </li>
                </ul>
               <%-- 将该逻辑放到java代码中--%>
               <s:if test="orderLoungeVo.sts==3||orderLoungeVo.sts==6||orderLoungeVo.sts==9||orderLoungeVo.sts==12">
	               <ul class="clearfix_ Uncertain">
	                    <li>原因：<b><s:property escape="false" value="orderLoungeVo.rmk"/></b></li>
	               </ul>
	               </s:if>
               <s:if test="isShowRM">
                <ul class="clearfix_ Uncertain">
                 	<li>
   			          	<button type="button" id="exitbutton" onclick="exitbutton1()">申请退场</button>
                    	<button type="button" id="changebuttion" onclick="changebuttion1()">申请改期</button>
                    </li>
                     </ul>
                 <!-- 退场可以显示的页面begin --> 
                 <ul class="clearfix_ x4 Date_Box">
                    <li class="exitsite">退场理由：<b></b><textarea style="width:300px;" name="orderLoungeVo.rmk" id="rmkId" onclick="resonClear()" >请输入理由</textarea></li>
                    <li class="exitsite"></li>
               </ul>
                 <!-- 退场可以显示的页面end -->
               
              <!-- 改期可以显示的页面！！！！ -->  
              <%--贵宾间有开始和结束时间，两舱和贵宾厅没有 --%>
              <s:if test="orderLoungeVo.loungeRoomVo.type==1">
                 <ul class="clearfix_ x4 Date_Box">
                    <li class="changedate">所改日期：从 </li>
                    <li class="changedate">
                        <div class="inb Order_inb">
                            <input type="text" name="orderLoungeVo.startTime" id="startTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'endTime\')||\'2020-01-01\'}'})" class="inps"/>
                        </div>
                    </li>
                    <li class="changedate">到 </li>
                    <li class="changedate">
                        <div class="inb Order_inb">
                            <input type="text" name="orderLoungeVo.endTime" id="endTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00',minDate:'#F{$dp.$D(\'startTime\')||\'%y-%M-%d\'}',maxDate:'2020-01-01'})" class="inps"/>
                        </div>
                    </li>
                </ul>
                </s:if>
                <s:else>
                 <ul class="clearfix_ x4 Date_Box">
                    <li class="changedate">所改日期： </li>
                    <li class="changedate">
                        <div class="inb Order_inb">
                            <input type="text" name="orderLoungeVo.startTime" id="startTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00',minDate:'${startTime}',maxDate:'2020-01-01'})" class="inps"/>
                        </div>
                    </li>
                </ul>
                </s:else>
              </s:if>
            </div>
            <b class="bl"></b> <b class="br"></b> </div>
            <%--如果有异常信息才显示 --%>
           <s:if test="orderLoungeVo.loungeExceptionVoList.size()>0">
            <% request.setAttribute("count",((List)request.getAttribute("orderLoungeVo.loungeExceptionVoList")).size()); %>
	           <div class="module_a Order" style="height:100%;">
	            <div class="title"><span class="l"></span><span class="c"><font id="sss"><a href="javascript:void(new Date())" onclick="openmydiv()" class="myA">订单退改记录▼</a></font></span><span class="r"></span></div>
	            <div style="display:none" id="divshow">
	            <s:iterator value="orderLoungeVo.loungeExceptionVoList" var="orderExceptions" status="in">
	            <div class="inner clearfix_">
	                <ul class="clearfix_ x4">
	                    <li>订单号：<b><s:if test="#orderExceptions.sts==4 || #orderExceptions.sts==5 || #orderExceptions.sts==6">T</s:if><s:if test="#orderExceptions.sts==7 || #orderExceptions.sts==8 || #orderExceptions.sts==9 || #orderExceptions.sts==11">G</s:if><s:property escape="false" value="#orderExceptions.code"/></b></li>
	                    <li>状态：<b><f:write type="机场休息室订单状态" value="${sts}"/></b></li>
	                    <c:if test="${orderExceptions.type=='M'}">
	                    <!-- 判断休息室类型是否为vip包房 -->
		                    <c:if test="${orderLoungeVo.loungeRoomVo.type=='1'}"><!-- vip包房显示时间段 -->
		                    <li>改期时间：<b><s:date name="#orderExceptions.bookTime" format="yyyy-MM-dd HH:mm"/>&nbsp;-</b></li>
		                    <li><b><s:date name="#orderExceptions.bookEndTime" format="yyyy-MM-dd HH:mm"/></b></li>
		                    </c:if>
		                    <c:if test="${orderLoungeVo.loungeRoomVo.type!='1'}">
		                    <li>改期时间：<b><s:date name="#orderExceptions.bookTime" format="yyyy-MM-dd HH:mm"/></b></li>
		                    </c:if>
	                    </c:if>
	                </ul>
	                 <ul class="clearfix_ x4">
	                    <li>理由：<b><s:property escape="false" value="#orderExceptions.rmk"/></b></li>
	                    <li>申请时间：<b><s:date name="#orderExceptions.createTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                    <s:if test="#orderExceptions.sts==4||#orderExceptions.sts==5||#orderExceptions.sts==6">
	                    	<li>退款金额：<b><s:property value="#orderExceptions.price"/></b></li>
	                    </s:if>
	                    <s:else>
	                    	<li>补款金额：<b><s:property value="#orderExceptions.price"/></b></li>
	                    </s:else>
	                    <c:if test="${orderExceptions.confirmTime!=''&&orderExceptions.confirmTime!=null}">
	                     <li>确认时间：<b><s:date name="#orderExceptions.confirmTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                    </c:if>
	                </ul>
	                  <c:if test="${orderLoungeVo.loungeRoomVo.type!='1'}">
	                  <ul class="clearfix_ Uncertain">
	                  	<li>贵宾姓名：<b>
	                    	<s:iterator  value="#orderExceptions.orderLoungeGuestVoList" var="guest">
	                   			 <s:property escape="false" value="#guest.name"/>&nbsp;&nbsp;
	                    	</s:iterator>
	                    </b></li>
	                     </ul>
	                  </c:if>
	            </div>
	            </s:iterator>
	           </div>
	           <s:iterator value="orderLoungeVo.loungeExceptionVoList" var="orderExceptions" status="in">
	            <c:if test="${in.count==1}">
	            <div class="inner clearfix_" id="mydiv">
	                <ul class="clearfix_ x4">
	                    <li>订单号：<b><s:if test="#orderExceptions.sts==4 || #orderExceptions.sts==5 || #sts==6">T</s:if><s:if test="#orderExceptions.sts==7 || #orderExceptions.sts==8 || #orderExceptions.sts==9 || #orderExceptions.sts==11">G</s:if><s:property escape="false" value="#orderExceptions.code"/></b></li>
	                    <li>状态：<b><f:write type="机场休息室订单状态" value="${sts}"/></b></li>
	                    <c:if test="${orderExceptions.type=='M'}">
	                    <!-- 判断休息室类型是否为vip包房 -->
	                    	<c:if test="${orderLoungeVo.loungeRoomVo.type=='1'}"><!-- vip包房显示时间段 -->
		                    <li>改期时间：<b><s:date name="#orderExceptions.bookTime" format="yyyy-MM-dd HH:mm"/>&nbsp;-</b></li>
		                    <li><b><s:date name="#orderExceptions.bookEndTime" format="yyyy-MM-dd HH:mm"/></b></li>
		                    </c:if>
		                    <c:if test="${orderLoungeVo.loungeRoomVo.type!='1'}">
		                    <li>改期时间：<b><s:date name="#orderExceptions.bookTime" format="yyyy-MM-dd HH:mm"/></b></li>
		                    </c:if>
	                    </c:if>
	                </ul>
	                 <ul class="clearfix_ x4">
	                    <li>理由：<b><s:property escape="false" value="#orderExceptions.rmk"/></b></li>
	                    <li>申请时间：<b><s:date name="#orderExceptions.createTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                    <s:if test="#orderExceptions.sts==4||#orderExceptions.sts==5||#orderExceptions.sts==6">
	                    	<li>退款金额：<b><s:property value="#orderExceptions.price"/></b></li>
	                    </s:if>
	                    <s:else>
	                    	<li>补款金额：<b><s:property value="#orderExceptions.price"/></b></li>
	                    </s:else>
	                    <c:if test="${orderExceptions.confirmTime!=''&&orderExceptions.confirmTime!=null}">
	                     <li>确认时间：<b><s:date name="#orderExceptions.confirmTime" format="yyyy-MM-dd HH:mm"/></b></li>
	                    </c:if>
	                </ul>
	                   <c:if test="${orderLoungeVo.loungeRoomVo.type!='1'}">
	                  <ul class="clearfix_ Uncertain">
	                  	<li>贵宾姓名：<b>
	                    	<s:iterator  value="#orderExceptions.orderLoungeGuestVoList" var="guest">
	                   			 <s:property escape="false" value="#guest.name"/>&nbsp;&nbsp;
	                    	</s:iterator>
	                    </b></li>
	                     </ul>
	                  </c:if>
	            </div>
	            </c:if>
	            </s:iterator>
	            
	            <b class="bl"></b> <b class="br"></b> 
            </s:if>
        <!--Module end--> 
        
        <!--Module-->
        <div class="module_a Order" style="height:100%;width: 98%">        
            <div class="title"><span class="l"></span><span class="c">联系人信息</span><span class="r"></span></div>
            <div class="inner clearfix_">
                <ul class="clearfix_ x3">
                    <li>姓名：<b><s:property escape="false" value="orderLoungeVo.orderContactVo.name"/></b></li>
                    <li>联系方式：<b><s:property value="orderLoungeVo.orderContactVo.mobile"/></b></li>
                    <li>邮箱地址：<b><s:property value="orderLoungeVo.orderContactVo.email"/></b></li>
                </ul>
            </div>
            <b class="bl"></b> <b class="br"></b> </div>
            <div class="module_a Order" >
				 <div class="title"><span class="l"></span><span class="c" id='ss'><a href="javascript:void(new Date())" onclick="opendiv()" class="myA">订单状态跟踪▼</a></span><span class="r"></span></div>
				<div class="" id="orderStsdiv" style="display:none" >
					<table style="width: 100%" align="left" cellspacing="0" cellpadding="0"
						border="0" class="BuyCard Table_w762 innerOrder">
						<tbody>
							<tr>
								<th width="100">
									时间
								</th>
								<th>
									跟踪记录显示
								</th>
							</tr>
							<s:iterator value="logLoungeOrderVoList" id="list">
								<tr>
									<td>
									<s:date name="#list.createTime" format="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td align="center">
										<s:if test="#list.content=='&#39044;&#23450;&#25104;&#21151;!'">
											预订成功!
										</s:if>
										<s:else>
											<s:property value="#list.content" escape="false"/>
										</s:else>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div> 
        <!--Module end-->
        <div class="clear"></div>
        <div class="greytext" id="pager">
        <a href="${ctx}/member/order.jsp?tabIndex=3" class="button2 cuti" >返 回 &gt;&gt;</a>
        <s:if test="isShowRM">
        <a href="javasrcipt:void(0);" id="submitorder" onclick="submitorder();return false;" class="button2">提交订单 &gt;&gt;</a>
        </s:if>
        <s:if test="orderLoungeVo.sts==10">
        	<%--正常确认 --%>
        	<a id="confirmbutton" 
        		href="${ctx}/loungeOrderAction!verifyLoungeOrder.action?id=${orderLoungeVo.id}&&orderLoungeVo.id=${orderLoungeVo.id}&&type=N" 
        		class="button2" onclick="return false;">${user_confirm} &gt;&gt;
        	</a>
        </s:if>
        <s:elseif test="orderLoungeVo.loungeExceptionVoList.size()>0&&orderLoungeVo.loungeExceptionVoList.get(0).sts==10">
        	<%--异常确认 --%>
        	<a id="confirmbutton" 
        		href="${ctx}/loungeOrderAction!verifyLoungeOrder.action?id=${orderLoungeVo.id}&&orderLoungeVo.id=<s:property value="orderLoungeVo.loungeExceptionVoList.get(0).id"/>&&type=E" 
        		class="button2" onclick="return false;">${user_confirm} &gt;&gt;
        	</a>
        </s:elseif>
        <s:if test="orderLoungeVo.paySts!=1">
	        <s:if test="orderLoungeVo.sts==10">
	        	<a id="cancelbutton" href="${ctx}/loungeOrderAction!cancelLoungeOrder.action?id=<s:property value="orderLoungeVo.id"/>" class="button2" onclick="return false;">取消 &gt;&gt;</a>
	        </s:if>
        </s:if>
        </div>
    </div>
    <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
</div>
</form>
<!-----------------------------------------RIGHT END------------------------------------>
</div>
<%--迭代所有人员 --%>
<s:iterator value="orderLoungeVo.orderLoungeGuestVoList" status="status">
<input type="hidden" value="${name }" id="${id}" class="allPerson">
</s:iterator>
<%-- 找出退场失败的订单中的人员--%>
<s:iterator value="orderLoungeVo.loungeExceptionVoList" status="status" var="exceptionVo">
<s:if test="sts==6">
<s:iterator value="#exceptionVo.orderLoungeGuestVoList" status="status" >
<input type="hidden"  value="${name }" class="unsubscribeExpPerson">
</s:iterator>
</s:if>
</s:iterator>
<s:iterator value="orderLoungeVo.loungeExceptionVoList">
<s:if test="sts==6">
<input type="hidden"  value="6" id="lastExpOrderSts">
</s:if>
</s:iterator>
<script>
	//订单总金额:将小数点去掉
	var amountPrice = new Number($("#amountPrice").html());
	$("#amountPrice").html(amountPrice.toFixed(0));
</script>
</body>