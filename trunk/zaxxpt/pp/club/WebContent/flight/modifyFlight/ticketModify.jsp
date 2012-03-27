<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/web/js/clubJs/jquery1.3.2.js" language="javascript" type="text/javascript"></script>
<title>${domain_cn }</title>
<style type="text/css">
#win { position:fixed; _position:absolute; -webkit-box-shadow:5px 2px 6px #333; -moz-box-shadow:5px 2px 6px #333; -moz-border-radius: 7px; border-radius: 7px; }
.win_abnormal p{ font-size:14px; padding:30px 30px 40px 30px;}
</style>
</head>
<body>

<div class="main"> 
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<%@include file="/flight/order/detailControl.jsp" %>
    <!----------------------------------------- RIGHT ------------------------------------>
    <div class="floatleft width783">
        <div class="lineclear"><img src="images/right_top.jpg"/></div>
        <div class="listTAB rightbg"> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">订单详情</b><b class="right">总计金额：<b class="red"><%=totalMoney %></b> 共 1人 （保险：0元）</b></span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3 ">
                        <li><span>订单号：<%=code %></span></li>
                        <li>订单状态：<b><%
                        String stsCha = "";
                        if(sts.equals("00")){
                        	stsCha = "等待支付";
                        }else if(sts.equals("01")){
                        	stsCha = "等待出票";
                        }else if(sts.equals("02")){
                        	stsCha = "出票成功";
                        }else if(sts.equals("03")){
                        	stsCha = "出票失败";
                        }else if(sts.equals("04")){
                        	stsCha = "已取消";
                        }else if(sts.equals("05")){
                        	stsCha = "申请中";
                        }else if(sts.equals("06")){
                        	stsCha = "申请成功";
                        }else if(sts.equals("07")){
                        	stsCha = "申请失败";
                        }
                        %>
                        <%=stsCha %>
                        </b></li>
                        <li>订单成生时间：<b><%=createTime%></b></li>
                    </ul>
                    <ul class="clearfix_ x3 ">
                        <li><span>PNR：ALK222</span></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">航班信息<%if(flightType.equals("2")){ %>（往返）<%} %><%if(flightType.equals("1")){ %>（单程）<%} %></b><b class="right">出发日期：<%=outBookingFlight.getDepartureDateStr() %></b></span><span class="r"></span></div>
                <div class="inner air_Selected air_Selected_r clearfix_">
                    <table class="table_style">
                        <thead>
                            <tr>
                                <th class="airline">航班信息</th>
                                <th class="airtime">起降时间</th>
                                <th class="airport">起降机场</th>
                                <th class="">经停机场</th>
                                <th class="airprice">舱位</th>
                                <th class="airtax">机建+燃油</th>
                                <th class="airtotal">单张合计</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="airline"><span class="airlogo airlogo_hu"><img src="images/slogo1.gif"></span> <strong><%=outBookingFlight.getAirlineCompany() %><br>
                                    <%=outBookingFlight.getAirlineCompanyCode() %></strong></td>
                                <td class="airtime"><%=outBookingFlight.getDepartureTimeStr() %><br>
                                    <%=outBookingFlight.getArrivalTimeStr() %></td>
                                <td class="airport"><%=outBookingFlight.getDepartureAirport() %><br>
                                    <%=outBookingFlight.getArrivalAirport() %></td>
                                <td>青岛流亭机场<br>
                                    (14:20-15:00)</td>
                                <td class="airprice"><%=outBookingFlight.getCabinCode() %><br />
                                    <span class="red bold"><%=outBookingFlight.getDiscount() %></span> 折</td>
                                <td class="airtax"><%=outBookingFlight.getTotalConstructionFee() %><br />
                                    <%=outBookingFlight.getTotalBaf() %></td>
                                <td class="airtotal"><strong>¥<%=outBookingFlight.getTotalTicketPrice() %></strong><br>
                                    <a class="orangea Tickets_TG" href="#">退改签规则</a></td>
                            </tr>
                            <%
                    if(flightType.equals("2")){
                    %>
                    <tr>
                        <td class="airline"><span class="airlogo airlogo_hu"><img src="${ctx}/web/images/slogo1.gif"></span> <strong><%=inBookingFlight.getAirlineCompany() %><br>
                            <%=inBookingFlight.getAirlineCompanyCode() %></strong></td>
                        <td class="airtime"><%=inBookingFlight.getDepartureTimeStr() %><br>
                                <%=inBookingFlight.getArrivalTimeStr() %></td>
                        <td class="airport"><%=inBookingFlight.getDepartureAirport() %><br>
                                <%=inBookingFlight.getArrivalAirport() %></td>
                        <td>青岛流亭机场<br>
                                (14:20-15:00)</td>
                        <td class="airprice"><%=inBookingFlight.getCabinCode() %><br /><span class="red bold"><%=inBookingFlight.getDiscount() %></span> 折</td>
                        <td class="airtax"><%=inBookingFlight.getTotalConstructionFee() %><br /><%=inBookingFlight.getTotalBaf() %></td>
                        <td class="airtotal"><strong>¥<%=inBookingFlight.getTotalTicketPrice() %></strong><br>
                                <a class="orangea Tickets_TG" href="#">退改签规则</a></td>
                    </tr>
                    <%} %>
                        </tbody>
                    </table>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
            <form action="${ctx}/flight/modifyFlight/ticketModifyResult.jsp">
            <%
                int i = 1;
                String certType = "";
                for(MemberPassengerVo m:flightPassengerList){ 
                %>
                <div class="title"><span class="l"></span><span class="c"><b class="left">乘机人<%=i %></b></span><span class="r"></span></div>
                <div id="PeopleInfoBox" class="inner PeopleInfo ConfirmOrder">
                    <table width="758" cellspacing="0" cellpadding="0" border="0" class="table_style2">
                        <tbody>
                            <tr>
                                <th scope="col">旅客姓名</th>
                                <th scope="col">旅客类型</th>
                                <th scope="col">证件类型</th>
                                <th scope="col">证件号码</th>
                                <th scope="col">常旅客卡号</th>
                                <th width="80" scope="col">票 号</th>
                                <th width="90" scope="col">航段/特殊航食</th>
                                <th width="70" scope="col">日期</th>
                                <th width="80" scope="col">航班号/操作</th>
                            </tr>
                            <tr>
                                <td><%= m.getName() %></td>
                                <td><%
                        String type = "";
                        if(m.getType().equals("01")){
                        	type = "成人";
                        } else if(m.getType().equals("02")){
                        	type = "儿童";
                        }
                        %>
                        <%=type %></td>
                                <td><%if(m.getCertType().equals("1")){
                    	 	certType = "护照";
                       	 }else if(m.getCertType().equals("2")){
                       		certType = "军官证";
                       	 }else if(m.getCertType().equals("3")){
                       		certType = "港澳通行证";
                       	 }else if(m.getCertType().equals("4")){
                       		certType = "回乡证";
                       	 }else if(m.getCertType().equals("5")){
                       		certType = "台胞证";
                       	 }else if(m.getCertType().equals("6")){
                       		certType = "国际海员证";
                       	 }else if(m.getCertType().equals("7")){
                       		certType = "外国人永久居留证";
                       	 }else if(m.getCertType().equals("9")){
                       		certType = "其他";
                       	 }else if(m.getCertType().equals("0")){
                       		certType = "身份证";
                       	 }
                       %>
                        <%=certType %></td>
                                <td><%=m.getCertNo() %></td>
                                <td></td>
                                <td colspan="4"><!---->
                                    
                                    <table width="340" cellspacing="0" cellpadding="0" border="0" class="table_style2" style="float:right;">
                                        <tbody>
                                            <tr>
                                                <td width="80" rowspan="2"><%=m.getEtNo() %></td>
                                                <td><!---->
                                                    
                                                    <table width="240" cellspacing="0" cellpadding="0" border="0" class="table_style2">
                                                        <tbody>
                                                            <tr>
                                                                <td width="70" class="postponeMem"><%=outBookingFlight.getDepartureAirport() %>-<%=outBookingFlight.getArrivalAirport() %><br />
                                                                    <%=outBookingFlight.getMeal() %></td>
                                                                <td width="60" class="postponeDate"><%=outBookingFlight.getDepartureDateStr()+" "%> <%=outBookingFlight.getDepartureTimeStr() %><span></span></td>
                                                                <td width="60" class="postponeFlight"><span><%=outBookingFlight.getFlightNo() %></span><br /><a href="#" class="postpone">申请改期</a><input type="checkbox" class="out" name="<%="modifymes"+i %>" onclick="checkbox_max(this);" value="<%=m.getId() %>"><input type="hidden" name="<%=m.getId() %>" value="<%=outBookingFlight.getDepartureDateStr()%>,<%=outBookingFlight.getDepartureTimeStr()%>,<%=outBookingFlight.getFlightNo()%>"/></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    
                                                    <!----></td>
                                            </tr>
                    <%
                    if(flightType.equals("1")){
                    %>
                                            <tr>
                                                <td><!---->
                                                    
                                                    <table width="240" cellspacing="0" cellpadding="0" border="0" class="table_style2">
                                                        <tbody>
                                                            <tr>
                                                                <td width="70" class="postponeMem"><%=outBookingFlight.getDepartureAirport() %>-<%=outBookingFlight.getArrivalAirport() %><br />
                                                                    <%=outBookingFlight.getMeal() %></td>
                                                                <td width="60" class="postponeDate"><%=outBookingFlight.getDepartureDateStr()+" "%> <%=outBookingFlight.getDepartureTimeStr() %><span></span></td>
                                                                <td width="60" class="postponeFlight"><span><%=outBookingFlight.getFlightNo() %></span><br /><a href="#" class="postpone">申请改期</a><input type="checkbox" class="in" name="<%="modifymes"+i %>" onclick="checkbox_max(this);" value="<%=m.getId() %>"><input type="hidden" name="<%=m.getId() %>" value="<%=outBookingFlight.getDepartureDateStr()%>,<%=outBookingFlight.getDepartureTimeStr()%>,<%=outBookingFlight.getFlightNo()%>"/></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    
                                                    <!----></td>
                                            </tr>
                    <%} %>
                                        </tbody>
                                    </table>
                                    
                                    <!----> 
                                    <!---->
                                    
                                    
                                    <!----></td>
                            </tr>
                        </tbody>
                    </table>
                    <%i++;} %>
                    <input type="hidden" name="size" value="<%=i-1 %>">
                </div>
                </form>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c">配送内容</span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3">
                        <li>收件人：<b><%=flightItineraryVo.getCatchUser() %></b></li>
                        <li>联系电话：<b><%=flightItineraryVo.getMobile() %></b></li>
                        <li>邮政编码：<b><%=flightItineraryVo.getPostCode() %></b></li>
                    </ul>
                    <ul>
                        <li>配送地址：<b><%=flightItineraryVo.getAddress() %></b></li>
                    </ul>
                    <div class="separated_line"></div>
                    <ul class="paddingT10B10">
                        <li><span class="orange">温馨提示：</span><b>${domain_cn }平台机票100%电子客票，凭身份证去机场登机。行程单仅作为报销凭证，不是登机的必要凭证。</b></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c">联系人信息</span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3">
                        <li>姓名：<b><%=flightContactVo.getName() %></b></li>
                        <li>联系方式：<b><%=flightContactVo.getMobile() %></b></li>
                        <li>邮箱地址：<b><%=flightContactVo.getEmail() %></b></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><span>订单状态跟踪信息</span><span class="Order_Status">订单状态：<b class="red">已出票</b></span></span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <table cellspacing="0" cellpadding="0" border="0" class="BuyCard Table_w762 innerOrder">
                        <tbody>
                            <tr>
                                <th width="150">时间</th>
                                <th>跟踪记录显示</th>
                            </tr>
                            <tr>
                                <td>2011-06-30 19:30</td>
                                <td>您的订单已提交，等待您的支付。</td>
                            </tr>
                            <tr>
                                <td>2011-06-30 20:10</td>
                                <td>您已支付成功，请等待出票。</td>
                            </tr>
                            <tr>
                                <td>2011-06-30 21:05</td>
                                <td>出票成功。</td>
                            </tr>
                            <tr>
                                <td>2011-06-30 21:05</td>
                                <td>审核。</td>
                            </tr>
                            <tr>
                                <td>2011-06-30 21:05</td>
                                <td>已退款。</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end-->
            
            <div class="lineclear Accountheight"></div>
        </div>
        <div class="clear"></div>
        <div class="lineclear"><img src="images/right_bott.jpg" /></div>
        <div class="greytext" id="pager"><a class="button2" style="cursor:pointer" onclick="submitform()">提交申请</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);" class="button2">返 回</a></div>
        <div class="clear"></div>
    </div>
</div>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
</div>
<!--Tickets_TG_Box-->
<div class="Tickets_TG_Box" >
    <table cellspacing="0" cellpadding="0" border="0" class="Tickets_TG_Table" >
        <tbody>
            <tr>
                <th width="72">退改签规定：</th>
                <th></th>
            </tr>
            <tr>
                <td>更改条件</td>
                <td>您的订单已提交，等待客服确认。</td>
            </tr>
            <tr>
                <td>退票条件</td>
                <td>您的订单已确认，请尽快支付请尽快支付请尽快支付请尽快支付请尽快支付。</td>
            </tr>
            <tr>
                <td>签转条件</td>
                <td>已支付，预订成功！</td>
            </tr>
        </tbody>
    </table>
</div>
<!--Tickets_TG_Box end--> 
<!--pop-->
<div id="InsertContent_1" style="display:none;" >
        <table cellspacing="0" cellpadding="0" border="0" class="Tickets_TG_Table postponeBox" >
        <tbody>
            <tr>
                <th>改期航班号：</th>
                <th>改期日期：</th>
                <th>起飞时间：</th>
            </tr>
            <tr>
                <td><input type="text" class="jdmc" name="input4"></td>
                <td><input type="text" class="jdmc" name="input4"></td>
                <td><input type="text" class="jdmc" name="input4"></td>
            </tr>
        </tbody>
    </table>
</div>
<!--pop end-->
<script type="text/javascript">
function checkbox_max(obj){
        if(obj.checked==true){
        	if(obj.className=="out"){
        		var inputs = $(":checkbox[class='in']");
        			for(var i = 0; i < inputs.length; i++){
        					if(inputs[i].checked==true){  
            					inputs[i].checked = false; 
            					alert("暂时只支持修改单程，如需要请跳转后再行修改其他机票");
            				}
         			}
        	}
        	if(obj.className=="in"){
        		var outputs = $(":checkbox[class='out']");
        			for(var j = 0; j < outputs.length; j++){   
            				if(outputs[j].checked==true){
            					outputs[j].checked = false;
            					alert("暂时只支持修改单程，如需要请跳转后再行修改其他机票");
            				}
         			}
        	}
        
        }
    }
function submitform(){
	$("form").submit();
}
$(function(){
    // 退改签条款、表单填写说明
	function winPosition(Start,Box){
	$(Start).live("mouseover",function(){
		var w = $(Box).width(), x = $(this).offset().left, y = $(this).offset().top , u=$(this).width();
		var body_w = $(document.body).width();
		x<body_w/2?$(Box).css("left",x):$(Box).css("left",x-w+u);
		$(Box).show().css("top",y+20);
	}).live("mouseout",function(){
			$(Box).hide();
		});
	}
	winPosition(".Tickets_TG",".Tickets_TG_Box");  // 退改签条款调用	
});

/*
               遮罩层需引入jquery库
*/
function jlsPop(btn,popContent){
	$(btn).click(function(){
    $("body").append($('<div id="screen"></div>'));  
    $("#screen").css({
    "background":"#000",
    "filter":"alpha(opacity=40)",
    "-moz-opacity":"0.4",
    "opacity":"0.4",
    "position":"absolute",
    "zIndex":"99",
    "top":"0px",
    "left":"0px",
    "height":$("body").height(),
    "width":$("body").width()
    });
    
    // 创建弹出窗
    $("#screen").after($('<div id="win"><span id="close">保存</span></div>'));
    // 插入内容到弹出窗口
    $("#win").append($(popContent).html());

    var heightA=$(window).height(), 
        heightB=$("#win").height(), 
        widthA=$(window).width(), 
        widthB=$("#win").width();
			
    heightA > heightB ? $("#win").css("top",(heightA-heightB)/2-10) : $("#win").css("top","20px");
	// ie6不支持 "position:fixed;" 故 判断用户浏览器为ie6时返顶；
	var isIE6 = !-[1,]&&!window.XMLHttpRequest;
	if (isIE6){
        $('html').animate({scrollTop: '0px'}, 700); 
	};

    // 弹出窗样式
    $("#win").css({
    "border":"4px solid #FBB225",
    "padding":"20px 10px 10px",
    "left":(widthA-widthB)/2-13,
    "background":"#FFF",
    "zIndex":"100"
    });
		
    // 关闭按钮样式
    $("#close").css({
    "position":"absolute",
    "width":"30px",
    "textAlign":"center",
    "top":"1px",
    "right":"1px",
    "cursor":"pointer",
    "fontSize":"12px",
    "lineHeight":"18px"
    });
		
    // 监听窗口尺寸变化，调整屏蔽层尺寸和弹出窗位置
    $(window).resize(function(){
        $("#screen").css({
        "height":$("body").height(),
        "width":$("body").width()
        });	
        $("#win").css(
        "left",($("body").width()-widthB)/2-13
        );
    });
	// call the  function, get postpone date and flight.
	getPostpone(this);
	
    // 关闭事件
    $("#close").click(function(){
	// get postpone date and flight.
	setPostpone(this);
    $("#screen,#win").remove();
    });
	return false;
	});
};

jlsPop('.postpone','#InsertContent_1');

// get postpone date and flight.
function getPostpone(obj){
	$(".postponeFlight").each(function(i) {
        $(this).parent("tr").attr("id","postponeData"+i)
    });
	var id = $(obj).parent(".postponeFlight").parent("tr").attr("id");
	$(".postponeBox :input").attr("name",$(obj).parent(".postponeFlight").parent().attr("id"));
	var date = $(obj).parent(".postponeFlight").siblings(".postponeDate").text().split(' ');
	var flight = $(obj).siblings("span").text();
	$("#win .postponeBox :input").eq(0).val(flight);
	$("#win .postponeBox :input").eq(1).val(date[0]);
	$("#win .postponeBox :input").eq(2).val(date[1]);
	$("#win .postponeBox :input").change(function(){
		$("#"+$(this).attr("name")).children(".postponeDate").css("color","red");
		$("#"+$(this).attr("name")).children(".postponeFlight").children("span").css("color","red");
    });
};
// set postpone date and flight.
function setPostpone(obj){
	var input = $(obj).siblings("table").children("tbody").children("tr").children("td").children("input");
	var id=$(input).eq(0).attr("name");
	var flight=$(input).eq(0).val();
	var date=$(input).eq(1).val();
	var time=$(input).eq(2).val();
    $("#"+id).children(".postponeDate").text(date+" "+time);
	$("#"+id).children(".postponeFlight").children("span").text(flight);
	$("#"+id).children(".postponeFlight").children("input:hidden").attr("value",date+","+time+","+flight);
};
</script>
</body>
</html>
