<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.flight.web.vo.FlightMemberPassenVo"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<title>我的常用客人信息</title>
<style type="text/css">
div.sortBy { border-left:1px solid #E5E5E5; border-right:1px solid #E5E5E5; padding:5px; margin-top:5px; }
div.sortBy span { float:none; margin:0 2px; border:1px solid #f7f7f7; padding:2px 4px; cursor:pointer; font-size:12px; font-family:Arial, Helvetica, sans-serif; }
div.sortBy span:hover { border:1px solid #ccc; background:#fff; }
</style>
<script type="text/javascript">
	function delPassenger()
	{
		var sum=document.getElementById("pgsum").value;
		var status=false;
		for(var i=0;i<sum;i++)
		{
			if(document.getElementById("passenger"+i).checked)
			{
				status=true;
				break;
			}
		}
		
		if(status==false)
		{
			alert("请选择要删除的常用客人！！！！！");
			return;
		}
		
		var result=window.confirm("确定删除选中的常用客人吗？");
		if(result)
		{
			document.forms.passengerForm.submit();;
		}
	}
	
	function chooseAll(only)
	{
		var sum=document.getElementById("pgsum").value;
		
		for(var i=0;i<sum;i++)
		{
			if(only.checked)
			{
				document.getElementById("passenger"+i).checked=true;
			}
			else
			{
				document.getElementById("passenger"+i).checked=false;
			}
		}
	}
</script>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
    <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
    <div class="listTAB rightbg">
        <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt;<span class="cl1">我的常用客人信息</span></div>
        <div id="Accountcenter">
            <div class="right_h">
                <ul>
                    <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
                    <li class="right_h_bg widtha">
                        <div class="grf_tag4"><a href="javascript:void(0);" class="ontag">常用客人信息</a></div>
                    </li>
                    <li class="right_h_bg widthe">
                        <div class="grf_tag_down add_clk"><a href="addoften.jsp?action=add" class="offtag">添加常旅客</a></div>
                    </li>
                    <li class="right_h_bg widthd"></li>
                    <li class="right Accountwidth"><img src="${ctx}/web/images/right_h_r.jpg"/></li>
                </ul>
            </div>
            <div class="clear"></div>
            <!-- <div class="sortBy"><span>A</span><span>B</span><span>C</span><span>D</span><span>E</span><span>F</span><span>G</span><span>H</span><span>I</span><span>J</span><span>K</span><span>L</span><span>M</span><span>N</span><span>O</span><span>P</span><span>Q</span><span>R</span><span>S</span><span>T</span><span>U</span><span>V</span><span>W</span><span>X</span><span>Y</span><span>Z</span><b style="clear:both;"></b></div>-->
            <div class="listTAB">
                <!-- <div class="infor bottomline">
                    <div id="uboxstyle3">
                        <select name="language" id="language">
                            <option value="全部客人信息"  selected="selected">全部客人信息</option>
                            <option value="张三" >张三</option>
                            <option value="张三" >张三</option>
                        </select>
                    </div>
                    <div class="cgdd">目前共有信息<b class="db7c00"><s:property value="passengerlist.size"/></b>条</div>
                </div> -->
                <div class="clear"></div>
                <div id="Guests">
                    <ul>
                        <li>
                        	<font class="Guests1T">客人姓名</font><font class="Guests2">用户类型</font><font class="Guests3">证件类型</font><font class="Guests4">证件号码</font><font class="Guests6">管理</font>
                        	<input type="hidden" id="pgsum" value="<s:property value="passengerlist.size"/>"/>
                        </li>
                    </ul>
                    <ul><s:form name="passengerForm" action="deloften">
                    <s:iterator value="passengerlist" var="pg" status="item">
                    	<li class="greytext" name="liebiao">
                    		<font class="Guests1">
                    			<input type="checkbox" id="passenger<s:property value="#item.index"/>" name="passengeridlist" value="<s:property value="#pg.id"/>"/>
                    			<s:property value="#pg.name"/>
                    		</font>
                    		<font class="Guests2">
                    		<s:if test='#pg.type=="01"'>
                    			成人
                    		</s:if>
                    		<s:elseif test='#pg.type=="02"'>
                    			儿童
                    		</s:elseif>
                    		<s:elseif test='#pg.type=="03"'>
                    			婴儿
                    		</s:elseif>
                    		<s:else>
                    			无
                    		</s:else>
                    		</font>
                    		<font class="Guests3">
                    			<f:write type="证件类型"  value="${pg.certType}"></f:write>
                    		</font>
                    		<font class="Guests4"><s:property value="#pg.certNo" default="无"/></font>
                    		<font class="Guests6">
                    			<a href="#" onclick="toUpdate(<s:property value='#item.index'/>)" class="cl2">修改</a>
                    		</font>
                    	</li>
                    </s:iterator>
                    </s:form></ul>
                    <s:iterator value="passengerlist" var="pg" status="item">
                   		<form action="addoften.jsp" method="post"  id="updateId<s:property value="#item.index"/>">
                    		<input type="hidden" name="id" value="<s:property value="#pg.id"/>" />
                    		<input type="hidden" name="xm_textfield" value="<s:property value="#pg.name"/>" />
                    		<input type="hidden" name="centType" value="<s:property value="#pg.certType"/>" />
                    		<input type="hidden" name="zj_textfield" value="<s:property value="#pg.certNo"/>" />
                    		<input type="hidden" name="type" value="<s:property value="#pg.type"/>" />
                    		<input type="hidden" name="action" value="upd" />
                    	</form>
                    </s:iterator>
                </div>
            </div>
            <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>
        </div>
        <div class="clear"></div>
		<input type="hidden"  id="nowPage" name="nowPage" value="${page}"/>
        <div class="greytext" id="pager"><font class="Guests7">
            <input type="checkbox" name="checkbox" id="checkbox" onclick="chooseAll(this)"/>
            全选 <a href="javascript:delPassenger()" class="button4">删除所选信息 >></a></font><font class="Guests2"> </font>
            <font class="yema Guests8">
            <!-- 
            <s:if test="">
            	<img src="${ctx}/web/images/yema1.jpg" />
            </s:if>
            <s:else>
            	<a href=""><img src="${ctx}/web/images/yema1.jpg" /></a>
            </s:else>
            	<A href="">首页</A>
            <s:iterator begin="1" end="5" step="1" status="item">
            <s:if test="">
            	<A href="" class="yemaa">
            </s:if>
            <s:else>
            	<A href="">
            </s:else>
            	<s:property value="#item.index+1"/></A>
            </s:iterator>
            	<A href="">尾页</A>
            <s:if test="">
            	<img src="${ctx}/web/images/yema2.jpg" />
            </s:if>
            <s:else>
            	<a href=""><img src="${ctx}/web/images/yema2.jpg" /></a>
            </s:else>
             -->
            	<a href="#" name="btop"><img src="${ctx}/web/images/gototop.jpg" /></a>
            </font>
        </div>
        <div class="lineclear Accountheight"></div>
    </div>
    <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
</div>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
</div>
<script type="text/javascript">
$(".add_clk  a").hover(function(){$(this).attr("class","ontag")},function(){$(this).attr("class","offtag")});

function toUpdate(demo){
	$("#updateId"+demo).submit();
}

</script>
</body>
