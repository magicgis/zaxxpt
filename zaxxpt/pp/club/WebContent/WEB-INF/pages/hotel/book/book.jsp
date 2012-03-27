<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select3css.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/common.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.w100{
		width: 100px;
	}
	.room_Price { background: none repeat scroll 0 0 #FFFFFF; border: 1px solid #FDA102; left: 0; line-height: 18px; padding: 5px; position: absolute; text-align: center; top: 0; width: 200px; z-index: 5; }
</style>
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<script src="${ctx}/web/js/clubJs/11.js" language="javascript" type="text/javascript"></script>
<script src="${ctx}/web/js/clubJs/travel.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<script type=text/javascript>
    var citySelect = new CitySelectWindow('cityselected');
    function setSearch(n) { var menu = document.getElementById("sea_nav").getElementsByTagName("li"); var showdiv = document.getElementById("sea_box").getElementsByTagName("li"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }
    function setList(m, n) { var menu = document.getElementById("tab" + m).getElementsByTagName("li"); var showdiv = document.getElementById("tablist" + m).getElementsByTagName("div"); for (i = 0; i < menu.length; i++) { menu[i].className = i == n ? "now" : ""; showdiv[i].style.display = i == n ? "block" : "none"; } }

    var status="false";
	function submitForm()
	{
		/*
		var peoplenumsave=document.getElementById("Room");
		var bednumsave=document.getElementById("Bed");
		var peoplenum=peoplenumsave.options[peoplenumsave.selectedIndex].value;
		var bednum=bednumsave.options[bednumsave.selectedIndex].value;
		if(bednum>peoplenum)
		{
			alert("增加的床位不能超过预订房间的数量！！！！！");
			return;
		}
		*/
		var people_name_list="";
		var pgnamelistview=document.getElementById("clientNameBox");
		var pgnamelist=pgnamelistview.childNodes;

		var contactName=$("#contactName").val();
		var regContactName= /^([\u4e00-\u9fa5]{2,6})|([A-Za-z]{5,25})$/;
        if(!regContactName.exec(contactName)){
			alert("联系人姓名不能为空,且必须符合真实姓名规则");
			return ;
        }

		var contactPhone=$("#contactPhone").val();
		var regContactPhone= /^(13[0-9]{9})|(15[0-9]{9})|(18[0-9]{9})$/;
        if(!regContactPhone.exec(contactPhone)){
			alert("联系方式不能为空,且必须符合不同手机号码规则");
			return ;
        }

		var contactEmail=$("#contactEmail").val();
		var regContactEmail= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        if(!regContactEmail.exec(contactEmail)){
			alert("邮箱不能为空,且必须符合普通邮箱地址规则");
			return ;
        }

        for(var i=0;i<pgnamelist.length;i++)
		{
			if(pgnamelist[i].nodeName=="SPAN")
			{
				var pgname_eachview=pgnamelist[i];
				if(pgname_eachview.getAttribute("id")=="eachpname")
				{
					var pgname_valuelist=pgname_eachview.childNodes;
					for(var x=0;x<pgname_valuelist.length;x++)
					{
						if(pgname_valuelist[x].nodeName=="INPUT")
						{
							var pgnameview=pgname_valuelist[x];
							var pgname=pgname_valuelist[x].value;
							if(pgname=="")
							{
								alert("客人姓名不能为空。");
								pgnameview.focus();
								return;
							}
							else
							{
								for(var index=0;index<pgname.length;index++)
								{
									if(pgname.charCodeAt(index)>8&&pgname.charCodeAt(index)<47)
									{
										alert("客人姓名包含非法字符，请填写汉字、字符和/。");
										pgnameview.focus();
										return;
									}
									else if(pgname.charCodeAt(index)>47&&pgname.charCodeAt(index)<65)
									{
										alert("客人姓名包含非法字符，请填写汉字、字符和/。");
										pgnameview.focus();
										return;
									}
									else if(pgname.charCodeAt(index)>90&&pgname.charCodeAt(index)<97)
									{
										alert("客人姓名包含非法字符，请填写汉字、字符和/。");
										pgnameview.focus();
										return;
									}
									else if(pgname.charCodeAt(index)>122&&pgname.charCodeAt(index)<255)
									{
										alert("客人姓名包含非法字符，请填写汉字、字符和/。");
										pgnameview.focus();
										return;
									}
								}
								if(people_name_list.indexOf(","+pgname+",")>=0)
								{
									alert("客人姓名不能重复，请自行添加标识区分。");
									pgnameview.focus();
									return;
								}
								people_name_list=people_name_list+","+pgname+",";
							}
						}
					}
				}
			}
		}
		
        if(status=="false")
        {
            //状态置为不可用,按钮置灰
        	status="true";
        	$(".button1").css("backgroundPosition", $(this).is(':checked')?"0 0":"0 -25px");
			document.forms.hotelOrderForm.submit();
        }
	}
	
	function cal_amountPrice()
	{
		var oneprice=document.getElementById("price").value;
		
		var peoplenumview=document.getElementById("Room");
		var bednumview=document.getElementById("Bed");
		var breakfastnumview=document.getElementById("Breakfast");
		var peoplenum=peoplenumview.options[peoplenumview.selectedIndex].value;
		var bednum=bednumview.value;//.options[bednumview.selectedIndex].value;
		var breakfastnum=breakfastnumview.value;//.options[breakfastnumview.selectedIndex].value;

		var amountprice=parseFloat(oneprice)*parseInt(peoplenum);//*parseInt(document.getElementById("date_distance").value);//+200*parseInt(bednum)+10*parseInt(breakfastnum);
		document.getElementById("amountPrice").value=amountprice;
		document.getElementById("amountPrice_show").innerHTML=amountprice;
	}
//加载时执行函数
/*
$(function (){
	$("#submitbutton").click(
		function (){
			if($("#confirmhotelCont").attr("checked")){
				submitForm();
			}else {
				alert("请您仔细阅读协议并选择同意。");
			}
		}
	);
	$("#goBack").click(
		function (){
			history.back();
		}
	);
});
*/
function doSubmit(){
	if($("#confirmhotelCont").attr("checked")){
		submitForm();
	}else {
		alert("请您仔细阅读协议并选择同意。");
	}
}
</script>
<title>酒店订单填写 - 酒店预订 - ${domain_cn }</title>
</head>

<body>
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg"></li>
        <li class="sebj"><a class="se" href="${ctx}/index.jsp">首页</a> &gt; <a href="${ctx}/hotel/index.jsp" class="se">酒店预订</a> &gt; <span class="se1">订单填写</span></li>
        <li><img src="${ctx}/web/images/seright.jpg"></li>
    </ul>
</div>
<div class="clear"></div>
<s:form action="bookhotel" name="hotelOrderForm" method="post">
    <input type="hidden" value="<s:property value="odate"/>" name="odate" />
    <input type="hidden" value="<s:property value="idate"/>" name="idate" />
    <input type="hidden" value="<s:property value="hcode"/>" name="hcode" />
    <input type="hidden" value="<s:property value="rcode"/>" name="rcode" />
    <input type="hidden" value="<s:property value="roomPlanCode"/>" name="roomPlanCode" /><!-- 新增加的 -->
    <input type="hidden" value="<s:property value="customCommission"/>" name="customCommission" /><%-- 佣金比例 --%>
    <input type="hidden" value="<s:property value="date_distance"/>" name="date_distance" id="date_distance"/>
    <input type="hidden" value="<s:property value="rateVos.get(0).channelCostPrice"/>" name="signPrice" />
    <input type="hidden" value="<s:property value="totalPrice"/>" name="price" id="price"/>
    <input type="hidden" value="<s:property value="payType"/>" name="payType" /><%--暂时写为预付类型 --%>
    
    <input type="hidden" name="amountPrice" id="amountPrice"/>
<div class="main980"> 
    <!--Module-->
    <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">预定酒店信息</b><b class="right">总计金额：<b class="red" id="amountPrice_show"></b>元</b><b class="right">单价金额：<b class="red"><s:property value="rateVos.get(0).salePrice"/></b>元&nbsp;&nbsp;&nbsp;&nbsp;</b></span><span class="r"></span></div>
        <div class="inner clearfix_">
            <ul class="clearfix_ x3">
                <li><span class="t"><s:property value="hotel.name"/></span></li>
                <li>预订房型：<b><s:property value="roomName"/></b></li>
                <li><a id="displayRoomInfo" class="margin_no" href="javascript:void(0);">查看每日房型价格明细</a></li>
            </ul>
            <ul class="clearfix_ x3">
                <li>入住时间：<b><s:property value="idate"/></b></li>
                <li>退房时间：<b><s:property value="odate"/></b></li>
                <li>入住天数：<b>共<span class="orange1"><s:property value="date_distance"/></span>晚</b></li>
            </ul>
            <ul class="clearfix_ Uncertain">
                <li>酒店地址：<b><s:property value="hotel.addr"/></b></li>
            </ul>
            <div class="separated_line"></div>
            <ul class="clearfix_ x2">
                <li><span class="t">退改规则</span></li>
            </ul>
            <ul class="h25">
                <li><b>房间保留到入住当天18:00，详情请咨询客服 ${site_tel}</b></li>
            </ul>
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
    <!--Module end--> 
    <!--Module-->
    <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">入住信息</b><b class="right tsInfo">请确保入住人姓名与入住时所持证件完全相同</b></span><span class="r"></span></div>
        <div class="inner clearfix_">
        	<ul class="clearfix_">
                <li id="clientNameCheckbox" class="Insert_select_box marginT10 Original clearfix_"> 
					<span class="left">常住客人姓名：</span>
				<s:iterator value="passengerlist" var="passenger" status="item">
					<span class="left czPassenger" id="pgnameview">&nbsp;
	                    <input type="checkbox" id="checkbox01" />
	                    <label><s:property value="#passenger.name"/></label>
					</span> 
				</s:iterator>
                </li>
            </ul>
            <ul class="clearfix_">
                <li class="Insert_select_box marginT10 Original"><span class="left">预订房间数量：</span>
                    <div id="tm2008style" class="left select_box_people">
                        <select name="Room" id="Room">
                            <option value="1">1</option>
                            <option value="2" >2</option>
                            <option value="3" >3</option>
                            <option value="4" >4</option>
                        </select>
                    </div>
                     
                    <span class="left marginL40">到店时间：</span>
                    <div id="tm2010style" class="left select_box_people">
						<select name="adate" id="language_tm2010">
							<option value="00:00-03:00">00:00-03:00</option>
							<option value="03:00-06:00">03:00-06:00</option>
							<option value="06:00-09:00">06:00-09:00</option>
							<option value="09:00-12:00">09:00-12:00</option>						
							<option value="12:00-14:00" selected="selected">12:00-14:00</option>
							<option value="14:00-18:00">14:00-18:00</option>
							<option value="18:00-21:00">18:00-21:00</option>
							<option value="21:00-24:00">21:00-24:00</option>
						</select>
                        </div>
                        <input type="hidden" value="0" id="Bed" name="Bed"/>
                        <input type="hidden" value="0" id="Breakfast" name="Breakfast"/>
                    <!--
                    <span class="left marginL40">加床：</span>
                    <div id="tm2008style" class="left select_box_people">
                        <select name="Bed" id="Bed">
                            <option value="0" selected="selected">0</option>
                            <option value="1">1</option>
                            <option value="2" >2</option>
                            <option value="3" >3</option>
                            <option value="4" >4</option>
                        </select>
                    </div>
                    <span class="left">&nbsp;张（200元/张）</span> 
                    
                    <span class="left marginL40">加早餐：</span>
                    <div id="tm2008style" class="left select_box_people">
                        <select name="Breakfast" id="Breakfast">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2" >2</option>
                            <option value="3" >3</option>
                            <option value="4" >4</option>
                        </select>
                    </div>
                    <span class="left">&nbsp;份 （10元/份）</span>  -->
                </li>
            </ul>
            
            <ul id="pnamelistview">
                <li id="clientNameBox" class="Insert_select_box marginT10 clearfix_ h_auto"> <span class="left">入住客人姓名：</span> 
                    <span class="left marginR5B5" id="eachpname">
                    <input type="text" class="text_w90" name="pname" value=""/>
                    </span>
                </li>
            </ul>
            <div class="separated_line"></div>
            <ul class="paddingT10B10">
                <li><span class="orange">温馨提示：</span><b>如果预订多间房间，建议你填写与房间数目相同的入住人姓名。实际入住时，前台会需要你出示相应数目的身份证。</b></li>
            </ul>
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
   
    <!--Module end-->
     <!--Module-->
    <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">特殊需求</b><b class="right tsInfo">我们会把您的需求转达给酒店,但该需求可能无法提供</b></span><span class="r"></span></div>
        <div class="inner clearfix_">
            <ul>
                <li class="Insert_select_box h_auto">
                    <textarea class="input_yq" rows="5" cols="45" id="textarea" name="rmk"></textarea>
                </li>
            </ul>
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
    <!--Module end--> 
</div>
<!--main980 end-->
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
            <input name="contactName" type="text" class="jdmc" value="<s:property value="member.name"/>" id="contactName" maxlength="25"/>
        </li>
        <li class="orange w3">联系方式：</li>
        <li class="w2">
            <input name="contactPhone" type="text" class="jdmc" value="<s:property value="member.mobile"/>" id="contactPhone" maxlength="25"/>
        </li>
        <li class="orange w3">邮箱地址：</li>
        <li class="w6">
            <input name="contactEmail" type="text" class="input2" value="<s:property value="member.email"/>" id="contactEmail" maxlength="30"/>
        </li>
    </ul>
</div>
<div id="content"><img src="${ctx}/web/images/xx_bottom.jpg" /></div>
<!---->

<div class=" Wmargin tijiao_frm1">
  <div class="Wmargin">
  <input type="checkbox" name="checkbox" id="confirmhotelCont"  checked="checked"/>
    <span class="gray">我已阅读并同意<a href="${ctx}/hotel/booknotice.jsp" class="orange" target="blank">订房协议</a></span>
  </div>
<a id="goBack" class="button2 cuti" href="javascript:void goBack();">&lt;&lt;&nbsp;返 回 </a>&nbsp;&nbsp;&nbsp;&nbsp;
<a id="submitbutton" class="button1 cuti commenminites" href="javascript:void doSubmit();">提交订单 &gt;&gt;</a> 
</div>
 </s:form>
<table cellspacing="0" cellpadding="0" border="0" align="center" class="room_Price" style="display:none;"  >
    <tbody>
    <tr>
    <th class="date">入住日期</th>
    <th class="w100">预订价格</th>
    </tr>
    <s:iterator value="rateVos">
    <tr>
    <td>${date }</td>
    <td>${salePrice }元</td>
    </tr>
    </s:iterator>
    </tbody>
</table>
<script type="text/javascript">
$(function(){
	//由于使用程序绑定click事件的方式可能导致ie6或者其他浏览器事件失效,所以修改为button事件属性
	/*
	//绑定操作按钮
	$("#submitbutton").click(
		function(){
			doSubmit();
			return false;
		}
	);
	*/
	/*
	$("#goBack").click(
		function (){
			history.back();
		}
	);*/
	// 每日房型价格
    $("#displayRoomInfo").hover(function(){
	    var h = $(this).height();
		var w2 = $(this).width();
		var table=$(".room_Price");
		var w = table.width();
	    var left = $(this).position().left;
		var top = $(this).position().top;
		table.css({"left":left-w+w2,"top":top+h+2});
	    table.show();
	},function(){$(".room_Price").hide();});
	
	// 入住人姓名处理 select
	$("#Room ").get(0).selectedIndex=0;
	function addClientName(){
		return $("#clientNameBox span").eq(1).clone().addClass("addSpan").children("input").attr("value","").end();
	}
	$("#options_Room li").live("click",function(){
		var index = $("#options_Room li").index(this);
		var len = $("#clientNameBox :input").length;
		var x =(index+1)-len;
	    var y =len-(index+1);
		if(index-len>=0){
    		for(var i=0; i<x; i++){
	    		$("#clientNameBox").append(addClientName());
	    	}
		}else{
			for(var i=0; i<y; i++){
				if($(".addSpan").eq($(".addSpan").length-1).children("input").val()==""){
				    $(".addSpan").eq($(".addSpan").length-1).remove();
				}else{
				    $("#clientNameCheckbox  :checkbox").next("label:contains('"+$(".addSpan").eq($(".addSpan").length-1).children("input").val()+"')").prev().attr('checked', false);
	    	    	$(".addSpan").eq($(".addSpan").length-1).remove();
				}
	    	}
		}
		
		cal_amountPrice();
	});
	
	$("#tm2008style").children("#Bed").live("click",function(){
		alert("!");
	});
	
	// 入住人姓名处理 checkbox
	$("#clientNameCheckbox  :checkbox").attr('checked', false); 
	$("#clientNameBox :input").val("");
	$("#clientNameCheckbox  :checkbox").click(function(){
		if($(this).is(":checked")){
			if($("#clientNameBox :input[value='']").length>0){
				$("#clientNameBox :input[value='']").eq(0).val($(this).next("label").text());
			}else{
				//$("#clientNameBox").append(addClientName());
				$("#select_info_Room").text($("#clientNameBox :input").length);
				$("#clientNameBox :input[value='']").eq(0).val($(this).next("label").text());
			}
		}else{
			$("#clientNameBox :input[value="+$(this).next("label").text()+"]").val("");
		}
	});
	 
	if(document.referrer.indexOf("login.jsp")>0)
	{
		$(".button2").attr("href","javascript:history.go(-2)");
	}
	//强制阅读协议
	$("#confirmhotelCont").click(function(){
		$(".button1").css("backgroundPosition", $(this).is(':checked')?"0 0":"0 -25px");
	});
});
cal_amountPrice();

function goBack(){
	history.back();
}
</script>
</body>




 
