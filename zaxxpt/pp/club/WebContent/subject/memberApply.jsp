<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<title>会员申请 --${domain_cn}</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select3css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#memberlength{width:980px;}
</style>
</head>
<body>
<div class="clear"></div>
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx }/index.jsp" class="se">首页</a> > ${domain_cn}会员申请</li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
</div>
<div class="clear"></div>
<div class="clear"></div>

<div class="jd_fy_box margin5">
<!-- 
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy">${domain_cn}会员申请：<a href="#" id="preMember"><input type="button" height="43px" value="网上会员申请"/></a></li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
    -->
    <div class="nav" id="memberlength"> 
            <ul>
                <li><span style="font-size:14px; font-family:'微软雅黑', '宋体';">${domain_cn}会员申请</span></li>
                <li><a href="${ctx }/onLineApplyView.action" style="border-bottom:3px solid #f09e0e;"><span class="orange">网上会员申请</span></a></li>
            </ul>
            <span class="r"></span> 
     </div>
</div>
 
	
	<div class="jd_fj_list">
    <div class="gmslgjk">
        <div class="w950 th1 Introduction">
       &nbsp;&nbsp;&nbsp;&nbsp; 新旅国际在全国设立40多家${domain_cn }会员加入机构，客户可通过上述渠道获取会员资格。客户亦可致电24小时客服电话<span class="orange"> ${site_tel}</span>，由客服人员告知便捷申请方式。除此之外，我们即将开通网上会员申请和续费业务（ ${domain_cn }官网通知及短信形式通知会员），客户直接登录 ${domain_cn }网站（<span class="orange">${domain}</span>）进行在线申请和续费操作。会员申请时，新旅国际将以密封函的方式分配客户会员卡及会员密码，并在客户的配合下完善客户系统资料。客户入会资格费到帐后，${domain_cn}会员权限会在1个工作日内被激活，激活后客户方可进行消费。

        </div>
    </div>
</div>
<div id="content"><img src="${ctx}/web/images/xx_bottom.jpg" /></div>
<!---->
<div class="jd_fy_box margin5">
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy">入会机构分布详情： </li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
</div>
<div class="Wmargin">
    <table cellspacing="1" cellpadding="0" border="0" class="BuyCard">
        <tbody>
            <tr>
                <th>区域</th>
                <th>详细地址</th>
                <th>联系方式</th>
            </tr>
            <tr>
                <td>北京</td>
                <td>北京市复兴门外大街丁23号金泰盛达园饭店</td>
                <td>13810809800</td>
            </tr>
            <tr>
                <td>海口</td>
                <td>海口市国贸大道周昌大厦1层国美电器旁</td>
                <td>13907583877</td>
            </tr>
            <tr>
                <td>重庆</td>
                <td>重庆市渝中区上青寺美专街53号汇美大厦16-4</td>
                <td>13368056277</td>
            </tr>
            <tr>
                <td>成都</td>
                <td>成都市武侯区洗面桥街22号（博美装饰城7层704室）</td>
                <td></td>
            </tr>
            <tr>
                <td>天津</td>
                <td>天津市河西区永安道罗马花园G座17层</td>
                <td>022-23265003</td>
            </tr>
            <tr>
                <td>昆明</td>
                <td>昆明市官渡区永康路16号3楼 </td>
                <td>13577178988</td>
            </tr>
        </tbody>
    </table>
</div>
<div class="Wmargin">
    <div id="content"><img src="${ctx}/web/images/xx_bottom.jpg" /></div>
</div>
</body>
