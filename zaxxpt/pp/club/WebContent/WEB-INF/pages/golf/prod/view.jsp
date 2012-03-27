<%@ page pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.PropertiesUtils"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script>
<script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
<script language="javascript" type="text/javascript">
//初始化时,异步加载天气预报,高尔夫只加载北京天气
$(function (){
	loadWeatherAjax("#tq_box","010","","H","H");
});
function tosearch(){
	$("#myform").attr("action","${ctx}/golf/search.jsp");
	$("#myform").submit();
}

jQuery.fn.limit=function(){ 
    var self = $("div[limit]"); 
    self.each(function(){ 
        var objString = $(this).text(); 
        var objLength = $(this).text().length; 
        var num = $(this).attr("limit"); 
        if(objLength > num){ 
$(this).attr("value",objString); 
            objString = $(this).html(objString.substring(0,num) + "...<a href='javascript:openOrClose()'>更多</a>&nbsp;&nbsp;&nbsp; "); 
        } 
    }) 
} 
$(function(){ 
    $(document.body).limit(); 
}) 
/*高尔夫球场*/
	
/**
 * 鼠标经过调用显示层
 */
function doClickg(o){
	$("#searg1s").css("display","none");
	o.className="grf_a1";
	var j,id,e;
	for(var i=1;i<=3;i++){
		id ="navg"+i;
		j = document.getElementById(id);
		e = document.getElementById("searg"+i);
		if(id != o.id){
			j.className="grf_a2";
		e.style.display = "none";
		}else{
			e.style.display = "block";
		}
	}
}

function openOrClose(){
	if($("#searg1").css("display")=="none"){
		$("#searg1").css("display","block");
		$("#searg1s").css("display","none");
	}else{
		$("#searg1s").css("display","block");
		$("#searg1").css("display","none");
	}
	
}
</script>
<script src="${ctx}/web/js/clubJs/jquery1.3.2.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<title><s:property escape="false" value="golfinfovo.name"/>详情 - 高尔夫预订 - ${domain_cn }</title>
</head>
<body>
<form action="" method="post" id="myform">
	<input type="hidden" name="id" value='<s:property value="golfinfovo.id"/>'/>
</form>
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx}/index.jsp" class="se">首页</a> &gt;&nbsp; <a href="${ctx}/golf/index.jsp" class="se">高尔夫首页</a> &gt;&nbsp; <span class="se">高尔夫详情</span> &gt; <span class="se1"><s:property escape="false" value="golfinfovo.name"/></span></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
</div>
<div id="content" class="padd5">
    <div class="content_left">
        <div class=" left" style="width:652px;">
        <%
        String basePath=PropertiesUtils.getVal("sysProps","resource.server.address"); 
        %>
            <div class="img_news"><img src="<%=basePath %>/<s:property escape="false"  value="golfinfovo.golfimage.path"/>" class="img_p4" />
                <div><b class="orange14"><s:property escape="false" value="golfinfovo.name"/></b></div>
            </div>
            <div  class="imgright">
                <div>
                    <div class="left"><img src="${ctx}/web/images/bj_left.jpg" /></div>
                    <div class="xxbj">
                        <div>
                            <ul>
                                <li class="grf_tag1"><a href="javascript:void(0);" class="grf_a1" id="navg1" onmouseover="doClickg(this)">球场概况</a></li>
                                <li class="grf_tag1"><a href="javascript:void(0);" class="grf_a2" id="navg2" onmouseover="doClickg(this)">基本信息</a></li>
                                <li class="grf_tag2"><a href="javascript:void(0);" class="grf_a2" id="navg3" onmouseover="doClickg(this)">联系方式</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="left"><img src="${ctx}/web/images/bj_right.jpg" /></div>
                </div>
               
                <div class="grf_p1" id="searg1" style="display:block;" limit="220"> <s:property escape="false" value="golfinfovo.courseDescription"/></div>
                <div class="grf_p1" id="searg1s" style="display:none;" ><s:property escape="false" value="golfinfovo.courseDescription"/>&nbsp;&nbsp;&nbsp;<a href='javascript:openOrClose()'>隐藏</a></div>
                <div class="grf_p1" id="searg2" style="display:none; overflow:visible;">
                    <table width="100%">
                    <tr>
                        <td width="50%">球场模式：${golfinfovo.pattern}</td>
                        <td>球道长度：<s:property escape="false" value="golfinfovo.fairwayLength"/>码</td>
                    </tr>
                   	<tr>
                        <td>建立时间：<s:date  name="golfinfovo.setupTime" format="yyyy"/>年</td>
                        <td>果岭草种：<s:property escape="false" value="golfinfovo.greenGrass"/></td>
                    </tr>
                    <tr>
                        <td>球场面积：<s:property escape="false" value="golfinfovo.stadiumArea"/>亩</td>
                        <td>球道草种：<s:property escape="false" value="golfinfovo.fairwayGrass"/></td>
                     </tr>
                     <tr>
                        <td>设计师：<s:property escape="false" value="golfinfovo.designer"/></td>
                        <td>球场数据：<s:property escape="false" value="golfinfovo.courseData"/></td>
                      </tr>
                    </table>
                </div>
                 <div class="grf_p1" id="searg3" style="display:none; overflow:visible;"> <!-- 2011-11-25  wenz 因页面显示参考路线文字较多一行没显示完就换行  将dl改为ul dt与dd改为li -->
                    <ul>
                        <li>地&nbsp;&nbsp;&nbsp;&nbsp;址：<s:property escape="false" value="golfinfovo.address"/></li>
                        <li>联系电话：
                        <s:if test="golfinfovo.sysContactList.size()>0">
                        	<s:property escape="false" value="golfinfovo.sysContactList.get(0).phone"/>
                        </s:if>
                        </li>
                        <li>邮&nbsp;&nbsp;&nbsp;&nbsp;箱：
                        <s:if test="golfinfovo.sysContactList.size()>0">
                         	<s:property escape="false" value="golfinfovo.sysContactList.get(0).email"/>
                        </s:if>
                       </li>
                        <li>参考路线：<s:property escape="false" value="golfinfovo.referenceLine"/></li>
                    </ul>
                </div>
                <s:if test="pop == 'null'">
                <!-- 
                <div class="btn_frm"> 
                <a href="javascript:tosearch();" class="yuding">预定 >></a>
                </div>
                 -->
                </s:if>
            </div>
        </div>
        <div class=" qcbhss" style="height:100%">
            <div style="width:650px; height:35px; line-height:35px;"><b class="orange14">球场包含设施</b></div>
            <ul class="qcbhss_list" style="height:100%">
                <li style="height:100%; text-align: left; color:#747474;">
                <s:property value="golfinfovo.facilityInformation" escape="false"/>
                <!--  
                <f:write2 type="球场设施" value="golfinfovo.facilityInformation" regexValue=","></f:write2>
               -->
               </li>

            </ul>
        </div>
        
        <!-- ifram  传参 场地搜索 -->
	    <input type="hidden" id="city" name="city" value="<s:property value="golfinfovo.city"/>"/>
	    <input type="hidden"  id="name" name="name" value="<s:property value="golfinfovo.name" escape="false"/> "/>
	    <input type="hidden"  id="bookTime" name="bookTime" value="<s:property value="bookTime"/>"/>
	    <input type="hidden"  id="fromPage" name="fromPage" value="view"/>
	    <iframe src="${ctx}/golfHomeSearch!searchSite.action?flagday=3" onload="this.height=this.contentWindow.document.body.scrollHeight;this.width=this.contentWindow.document.body.scrollWidth;" width="98%"  marginwidth="0" scrolling="no" frameborder="0" scrolling="no"></iframe>
        
        <div class="left_heads margin5">
            <div class="left"><img src="${ctx}/web/images/bj_left.jpg" /></div>
            <div class="xxbj til">高尔夫相册</div>
            <div class="left"><img src="${ctx}/web/images/bj_right.jpg" /></div>
        </div>
        <ul class="grfxc jp_xx_black" style="">
        	<s:iterator value="golfinfovo.golfiamgelist" status="status">
            	<li><img src="<%=basePath %>/<s:property value="path" escape="false"/>"class="img_p4" /></li>
            </s:iterator>
        </ul>
        <div style=" float:left;width:652px;"><img src="${ctx}/web/images/wb652.jpg" width="652" height="7" /></div>
</div>
    <div class="content_right">
        <div class="tq_box" id="tq_box">
        </div>
        <div class="clear"></div>
        <div class="margin5" style="width:323px;"><img src="${ctx}/web/images/right1.jpg" /></div>
    </div>
    <div class="clear"></div>
</div>
</body>




 
