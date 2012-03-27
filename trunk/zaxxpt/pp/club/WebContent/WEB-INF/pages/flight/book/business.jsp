<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/common.css" rel="stylesheet" type="text/css" />
<title>${domain_cn }</title>
</head>
<body>
<div class="clear"></div>
<div class="xx_nav">
    <ul>
        <li><img src="${ctx}/web/images/xileft.jpg" /></li>
        <li class="se_nav"><span class="jd_ddxx">填写订单</span><span class="jd_ts"> </span></li>
        <li><img src="${ctx}/web/images/xiright.jpg" /></li>
    </ul>
</div>
<div class="clear"></div>
<div class="jd_dd_box">
    <div><img src="${ctx}/web/images/xx_top.jpg" /></div>
    <div class="jc_bj_box">
        <div class="qrddxx_box automargin">
            <div class="qrddxx_b_head">航班信息</span></div>
            <ul class="qrddxx_b_l">
                <li><span class="gray">公务机型：
                    <input type="text" class="jdmc" name="input4">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span class="gray">起飞时间：
                    <input type="text" class="jdmc" name="input4">
                    </span></li>
                <li><span class="gray">起飞机场：
                    <input type="text" class="jdmc" name="input4">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    到达机场：
                    <input type="text" class="jdmc" name="input4">
                    </span></li>
            </ul>
            <ul class="qrddxx_b_r" style="width:350px; margin-top:-35px; margin-left:-30px;">
                <li class="price_detail" style="font-size:14px"> <span class="orange2">随时随地 只为您起飞</span></li>
                <li class="price_detail" style="font-size:12px; height:auto; line-height:18px;width:350px;">公务机服务没有航班时刻和航班线路的限制，可以真正做到随时随地自由快捷的飞行。 ${domain_cn }为会员提供的公务机，在年飞行小时、年飞行班次、飞行地域范围、客户数量、市场份额、服务质量等各方面在业内均遥遥领先。是各国政要、商业巨擘的不二之选。</li>
            </ul>
        </div>
    </div>
    <div><img src="${ctx}/web/images/jc_bottom.jpg" /></div>
</div>
<div class="clear"></div>
<div class="jd_fy_box margin5">
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy"><span class="black">联系人信息</span></li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
</div>
<div class="jp_xx_black Wmargin1 bg_fb lxr1">
    <ul>
        <li class="w1">姓 名：</li>
        <li class="w2">
            <input name="input4" type="text" class="jdmc" />
        </li>
        <li class="w3">手 机：</li>
        <li class="w4">
            <input name="input5" type="text" class="jdmc" />
        </li>
        <li class="w5">邮 件：</li>
        <li class="w6">
            <input name="input6" type="text" class="input1" />
        </li>
    </ul>
    <ul>
        <li class="w1">人 数：</li>
        <li class="w2">
            <input name="input4" type="text" class="jdmc" />
        </li>
        <li class="w3">传 真：</li>
        <li class="w4">
            <input name="input5" type="text" class="jdmc" />
        </li>
        <li class="w5">地 址：</li>
        <li class="w6">
            <input name="input6" type="text" class="input1" />
        </li>
    </ul>
</div>
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<div class=" Wmargin tijiao_frm1"> <a class="dingp" href="index.html">提交申请 >></a><span class="red">*</span> 请在提交申请前确认您已登录</div>
</body>

