<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/include/tags-lib.jsp"%>
<head>
<TITLE>404错误 - ${domain_cn }</TITLE>
<meta name="keywords" content="飞机票,机票,预订机票,特价机票预订,国内机票,航班查询,特价机票查询,打折机票,国内航班" />
<meta name="description" Content="提供国内航班机票预订、特价机票预订、打折机票预订和实时航班信息查询服务。在${domain_cn} 快捷预订飞往全国各地的单程、往返特价机票、打折机票" />
<meta name="classification" content="飞机票/机票/航空/航班" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/flash/flash.js"></script>

<style>
    body{text-align:center;}
</style>


</head>
<body>
<%@ include file="/decorators/header.jsp"%>
<!--mainContainer begin-->
<div class="">
  <div class="width_m5"><img src="${ctx}/web/images/xx_top.jpg" /></div>
  <div class="border_e4 error_Wmargin">
   <!--   <div class="error"><b class="xxx">错误内容</b></div>-->
  
<div id="mainC_f">
  <div class="error404">
	  <div style="background:#D7D7D7;">
		<table width="700px">
		<tr>
		<td>&nbsp;</td>
		</tr>
		<tr>
		<td><img src="${ctx}/web/images/u39_origina.png" /></td>

		<td>
		<p style="text-align:left;">
	     <span style="font-family:Applied Font;font-size:19px;font-weight:bold;font-style:normal;text-decoration:none;color:#000000;">非常抱歉！您访问的页面不存在，或已经过期。</span>
	     </p>
	     <br/>
	     <p style="text-align:left;">
	     <span style="font-family:Applied Font;font-size:16px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">您可以：</span>
	     </p>
	     <br/>
	     <p style="text-align:left;">
	     <span style="font-family:Applied Font;font-size:16px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">访问${domain_cn }首页：</span><span style="font-family:Applied Font;font-size:16px;font-weight:normal;font-style:normal;text-decoration:underline;color:#0000FF;"><a href="http://${domain }" target="_self" >${domain }</a></span>
	     </p>
	     <br/>
	     <p style="text-align:left;">
	     <span style="font-family:Applied Font;font-size:16px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">或致电</span><span style="font-family:Applied Font;font-size:16px;font-weight:normal;font-style:normal;text-decoration:none;color:#FF9900;">${site_tel}</span><span style="font-family:Applied Font;font-size:16px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">预订机票、酒店、高尔夫、机场休息室等。</span>
	     </p>  
		</td>
		</tr>
     </table>
	  </div>

    <!--   <dl>
        <dt>咦。你访问的页面貌似不存在，是不是输错了...</dt>
        <dd>我猜你想：<a href="${ctx}/flight/index.jsp" title="预订机票">预订机票</a> 
        <a href="${ctx}/hotel/index.jsp" title="预订酒店">预订酒店</a> 
        <a href="${ctx}/golf/index.jsp" title="预订高尔夫">预订高尔夫</a> 
        <a href="${ctx}/lounge/index.jsp" title="预订机场休息室">预订机场休息室</a> 
        <a href="${ctx}/index.jsp" title="访问网站首页">访问网站首页</a></dd>
     </dl>
     
     <h2>很无聊？那来玩玩游戏吧，吃豆豆吃豆豆，很经典的哈....</h2>-->
</div>

</div>
  <div class="error_m5"><img src="${ctx}/web/images/jd_list_bbottom.jpg" /></div>
</div>
<%@ include file="/decorators/footer.jsp"%>
</div>
</body>

