<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">var cityDirectory='${ctx}/';var isDisplayCity='N';</script>
<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->
<script type="text/javascript" src="${ctx}/web/js/city/allCity.js"></script>
<script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
<script language="javascript" type="text/javascript">

//鼠标移动时切换推荐信息
function winWiewFloat(){
	$("li.jc_tag1").mouseover(function(){
        $(this).children("a").attr("class","jc_ta1").parent().siblings("li").children("a").attr("class","jc_ta2")
        var index = $("li.jc_tag1").index(this);
        $(".tag_right_boz >div").eq(index).show().siblings().hide();
    });
    //触发第一次显示
    $(".tag_right_boz >div").eq(0).show();
}
	//初始化时,异步加载天气预报,首页默认加载北京
$(function (){
	//输入提示信息
	var errInfo="${errorMes}";
	if(errInfo){
		alert(errInfo);
	}
	loadWeatherAjax("#tq_box","010","","H","H");
	//异步加载酒店信息推荐
	$.ajax({
	   type: "POST",
	   url: "${ctx}/hotelInfoAction!findRecommInSearch.action",
	   dataType: "html",
	   success: function(data){
			$("#jcbottom").html(data);
			winWiewFloat();
	   }
	});

    // IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
    if(!-[1,]&&!window.XMLHttpRequest){
		$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
    }
});
</script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<title>酒店预订 - ${domain_cn }</title>
</head>
    <body>
<div class="clear"></div>
<div class="senav">
        <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx}/index.jsp" class="se">首页</a> &gt;&nbsp; <span class="se">酒店首页</span></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
    </div>
<div class="clear"></div>
<%--酒店查询表单--%>
<jsp:include page="prod/hotetSerachForm.jsp"></jsp:include>
<div class="clear"></div>
<%--酒店推荐信息div --%>
<div id="jcbottom"></div>
</body>


