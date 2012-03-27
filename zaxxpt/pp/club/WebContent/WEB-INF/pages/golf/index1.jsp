<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>

<%@page import="com.hnatourism.club.common.web.vo.WeatherVo"%><jsp:useBean id="indexQryComponent" scope="page" class="com.hnatourism.club.common.web.javabean.IndexQryComponent" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Demo</title>
<link href="${ctx}/web/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/Public.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="container">
    <!--header end-->
    <div class="main clearfix">
        <div class="crumb_nav"><span class="l"></span><span class="c">当前位置：<a href="#">首页</a><b>&gt;</b><a class="current" href="#">高尔夫预定</a></span><span class="r"></span> </div>
        <!--crumb_nav end-->
        <div class="left">
            <div class="l-main-wrap">
                <div class="rc-block1"> <b class="tl"></b> <b class="tr"></b>
                    <div class="inner">
                        <ul class="search clearfix">
                            <li>
                                <input type="text" class="text" value="北京">
                                <span>省份 <img width="16" height="16" src="${ctx}/web/images/btn_inputSlct.gif"></span></li>
                            <li>
                                <input type="text" class="text" value="2011-08-01">
                                <span>下场日期 <img width="18" height="18" src="${ctx}/web/images/btn_inputSlct02.gif"></span></li>
                            <li>
                                <input type="text" class="text" value="北京">
                                <span>省份 <img width="16" height="16" src="${ctx}/web/images/btn_inputSlct.gif"></span></li>
                            <li>
                                <input type="text" class="text" value="北京">
                                <span>省份 <img width="16" height="16" src="${ctx}/web/images/btn_inputSlct.gif"></span></li>
                            <li>
                                <input type="text" class="text" value="北京">
                                <span>省份 <img width="16" height="16" src="${ctx}/web/images/btn_inputSlct.gif"></span></li>
                            <li>
                                <input type="text" class="text" value="北京">
                                <span>省份 <img width="16" height="16" src="${ctx}/web/images/btn_inputSlct.gif"></span></li>
                        </ul>
                        <div class="separated_line"> </div>
                        <div class="below">
                            <input type="submit" class="search_now" id="ibtnHome" name="ibtnHome"/>
                        </div>
                    </div>
                    <b class="bl"></b> <b class="br"></b> </div>
            </div>
            <!--l-main-wrap end-->
            <div class="l-main-wrap">
                <div class="rc-block1"> <b class="tl"></b> <b class="tr"></b>
                    <div class="inner">
                        <ul class="rec_golf clearfix">
                            <li><a href="#"><img src="${ctx}/web/images/demoImg/temp_g1.jpg" alt="" /><span>海口五月花高尔夫俱乐部</span></a></li>
                            <li><a href="#"><img src="${ctx}/web/images/demoImg/temp_g2.jpg" alt="" /><span>海口美兰高尔夫球会</span></a></li>
                            <li><a href="#"><img src="${ctx}/web/images/demoImg/temp_g3.jpg" alt="" /><span>珠海金湾高尔夫俱乐部</span></a></li>
                            <li><a href="#"><img src="${ctx}/web/images/demoImg/temp_g4.jpg" alt="" /><span>北京京华高尔夫俱乐部</span></a></li>
                        </ul>
                    </div>
                    <b class="bl"></b> <b class="br"></b> </div>
            </div>
            <!--img end-->
            <div class="module_a reservation">
                <div class="title"><span class="l"></span><span class="c">
                    <h2><span>GOLF RESERVAION</span>高尔夫推荐</h2>
                    <ul class="clearfix">
                        <li><a href="#">海南</a></li>
                        <li><a href="#">深圳</a></li>
                        <li><a href="#">广州</a></li>
                        <li><a href="#">上海</a></li>
                        <li class="on"><a href="#">北京</a></li>
                    </ul>
                    </span><span class="r"></span></div>
                <div class="inner clearfix">
                    <div class="content_box clearfix">
                        <ul class="lineL">
                            <li><a href="#"><em class="name">1</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                        <ul class="lineR">
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                    </div>
                    <!--content_box end-->
                    <div class="content_box clearfix" style="display:none;">
                        <ul class="lineL">
                            <li><a href="#"><em class="name">2</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                        <ul class="lineR">
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                    </div>
                    <!--content_box end-->
                    <div class="content_box clearfix" style="display:none;">
                        <ul class="lineL">
                            <li><a href="#"><em class="name">3</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                        <ul class="lineR">
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                    </div>
                    <!--content_box end-->
                    <div class="content_box clearfix" style="display:none;">
                        <ul class="lineL">
                            <li><a href="#"><em class="name">4</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                        <ul class="lineR">
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                    </div>
                    <!--content_box end-->
                    <div class="content_box clearfix" style="display:none;">
                        <ul class="lineL">
                            <li><a href="#"><em class="name">5</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                        <ul class="lineR">
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥3900元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场</em><em class="price">最低价:￥1390元/人</em></a></li>
                            <li><a href="#"><em class="name">北京乡村高尔夫球场夫球场</em><em class="price">最低价:￥22390元/人</em></a></li>
                        </ul>
                    </div>
                    <!--content_box end--> 
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--reservation end--> 
        </div>
        <!--left end-->
        <div class="right">
            <div class="module_a weather">
                <div class="title"><span class="l"></span><span class="c">北京天气</span><span class="r"></span></div>
                <div class="inner clearfix">
                    <ul class="clearfix">
                    <%WeatherVo weatherVo=new WeatherVo();
                    String weatherInfo = indexQryComponent.getWeather(weatherVo,request); 
                    %>
                        <li class="tobay">
                            <p>今天 (周日)</p>
                            <img src="${ctx}/web/images/weather/temp_w1.gif"/>
                            <p>23℃ / 32℃</p>
                            <p>转晴</p>
                        </li>
                        <li class="morn">
                            <p>明天 (周一)</p>
                            <img src="${ctx}/web/images/weather/temp_w2.gif"/>
                            <p>23℃ / 32℃</p>
                            <p>白天多云</p>
                        </li>
                    </ul>
                </div>
                <b class="bl"></b> <b class="br"></b> </div>
            <!--weather end-->
            <div class="ads_Location_g1"> <img src="${ctx}/web/images/demoImg/temp_ad1.png" alt="知行人生，品味商旅" /> </div>
            <!--xhlx ad--> 
        </div>
        <!--right end--> 
    </div>
    <!--main end-->
 
    <!--footer end--> 
</div>
<!--container end-->
</body>
<script type="text/javascript">
//推荐类Tab
$(function(){
	$(".reservation .title li").mouseover(function(){
	    var index = $(".reservation .title li").index(this);
		var total = $(".reservation .title li").length;
        $(this).attr("class","on").siblings().removeClass("on");
        $(this).parents(".title").siblings(".inner").children("div.content_box").eq(total-index-1).show().siblings("div").hide();
	});
});
</script>
<script src="${ctx}/web/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
