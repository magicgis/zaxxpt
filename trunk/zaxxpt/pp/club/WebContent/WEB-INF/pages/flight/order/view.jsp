<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<title> ${domain_cn }</title>
<style type="text/css">
#win { position:fixed; _position:absolute; -webkit-box-shadow:5px 2px 6px #333; -moz-box-shadow:5px 2px 6px #333; -moz-border-radius: 7px; border-radius: 7px; }
.win_abnormal p{ font-size:14px; padding:30px 30px 40px 30px;}
</style>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
    <!----------------------------------------- RIGHT ------------------------------------>
    <div class="floatleft width783">
        <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
        <div class="listTAB rightbg"> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">订单详情</b><b class="right">总计金额：<b class="red">820元</b> 共 1人 （保险：0元）</b></span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3 ">
                        <li><span>订单号：100487920300</span></li>
                        <li>订单状态：<b>已出票</b></li>
                        <li>订单成生时间：<b>2010-06-27 15:30</b></li>
                    </ul>
                    <ul class="clearfix_ x3 ">
                        <li><span>PNR：ALK222</span></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">航班信息（单程） </b><b class="right">出发日期：2011年7月16日</b></span><span class="r"></span></div>
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
                                <td class="airline"><span class="airlogo airlogo_hu"><img src="${ctx}/web/images/slogo1.gif"></span> <strong>海南航空<br>
                                    HU7702</strong></td>
                                <td class="airtime">21:00<br>
                                    23:55</td>
                                <td class="airport">宝安国际机场<br>
                                    首都国际机场</td>
                                <td>青岛流亭机场<br>
                                    (14:20-15:00)</td>
                                <td class="airprice">经济舱<br />
                                    <span class="red bold">7.5</span> 折</td>
                                <td class="airtax">50<br />
                                    140</td>
                                <td class="airtotal"><strong>¥820</strong><br>
                                    <a class="orangea Tickets_TG" href="#">退改签规则</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c"><b class="left">乘机人1</b></span><span class="r"></span></div>
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
                                <td>李四阿</td>
                                <td>成人</td>
                                <td>身份证</td>
                                <td>230124192098112837</td>
                                <td></td>
                                <td colspan="4"><!---->
                                    
                                    <table width="340" cellspacing="0" cellpadding="0" border="0" class="table_style2" style="float:right;">
                                        <tbody>
                                            <tr>
                                                <td width="80" rowspan="2">1234567890</td>
                                                <td><!---->
                                                    
                                                    <table width="240" cellspacing="0" cellpadding="0" border="0" class="table_style2">
                                                        <tbody>
                                                            <tr>
                                                                <td width="70">北京-成都<br />
                                                                    东方素食</td>
                                                                <td width="60">2010-06-27 15:30</td>
                                                                <td width="60">HU7148<br /><a href="#" class="postpone">申请改期</a></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    
                                                    <!----></td>
                                            </tr>
                                            <tr>
                                                <td><!---->
                                                    
                                                    <table width="240" cellspacing="0" cellpadding="0" border="0" class="table_style2">
                                                        <tbody>
                                                            <tr>
                                                                <td width="70">北京-成都</td>
                                                                <td width="60">2010-06-27 15:30</td>
                                                                <td width="60">HU7148<br /><a href="#" class="postpone">申请改期</a></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    
                                                    <!----></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    
                                    <!----> 
                                    <!---->
                                    
                                    <table width="340" cellspacing="0" cellpadding="0" border="0" class="table_style2" style="float:right;">
                                        <tbody>
                                            <tr>
                                                <td width="80" rowspan="2">1234567890</td>
                                                <td><!---->
                                                    
                                                    <table width="240" cellspacing="0" cellpadding="0" border="0" class="table_style2">
                                                        <tbody>
                                                            <tr>
                                                                <td width="70">北京-成都<br />
                                                                    水果餐</td>
                                                                <td width="60">2010-06-27 15:30</td>
                                                                <td width="60">HU7148<br /><a href="#" class="postpone">申请改期</a></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    
                                                    <!----></td>
                                            </tr>
                                            <tr>
                                                <td><!---->
                                                    
                                                    <table width="240" cellspacing="0" cellpadding="0" border="0" class="table_style2">
                                                        <tbody>
                                                            <tr>
                                                                <td width="70">北京-成都<br />
                                                                    低盐餐</td>
                                                                <td width="60">2010-06-27 15:30</td>
                                                                <td width="60">HU7148<br /><a href="#" class="postpone">申请改期</a></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    
                                                    <!----></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    
                                    <!----></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c">配送内容</span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3">
                        <li>收件人：<b>张小四</b></li>
                        <li>联系电话：<b>13887602119</b></li>
                        <li>邮政编码：<b>100020</b></li>
                    </ul>
                    <ul>
                        <li>配送地址：<b>北京北京市朝阳区安慧北里秀园北京北京市朝阳区安慧北里秀园21号楼</b></li>
                    </ul>
                    <div class="separated_line"></div>
                    <ul class="paddingT10B10">
                        <li><span class="orange">温馨提示：</span><b> ${domain_cn }平台机票100%电子客票，凭身份证去机场登机。行程单仅作为报销凭证，不是登机的必要凭证。</b></li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--Module end--> 
            <!--Module-->
            <div class="module_a Order">
                <div class="title"><span class="l"></span><span class="c">联系人信息</span><span class="r"></span></div>
                <div class="inner clearfix_">
                    <ul class="clearfix_ x3">
                        <li>姓名：<b>张小四</b></li>
                        <li>联系方式：<b>13887602119</b></li>
                        <li>邮箱地址：<b>w3c@gmail.com</b></li>
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
        <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
        <div class="greytext" id="pager"><a class="button2 " href="#">提交申请</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="button2 ">返 回</a></div>
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
    $("#win").append($(popContent).children().clone());

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
    // 关闭事件
    $("#close").click(function(){
    $("#screen,#win").remove();
    });
	return false;
	});
};

jlsPop('.postpone','#InsertContent_1');
</script>
</body>





 
