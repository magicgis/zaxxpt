<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/common/include/backTop.js" type="text/javascript"></script>
<title>我的订单管理_我的个人中心 _ ${domain_cn} </title>
<style>
.order_slc { margin:0; padding:0 6px; border-left:1px solid #DBDBDB; border-right:1px solid #DBDBDB; height:30px; line-height:30px; _padding-top:8px; }
.order_slc li { list-style:none; line-height:30px; height:30px; }
</style>

<script type="text/javascript">
$(function(){
  	var s="${showSts}";
	if(s!=null&&s!=""&&s==1){
		alert("申请成功！");
	}
})
</script>
</head>
<body>
<input type="hidden" id="tabIndex" value="<s:property value="tabIndex" />">
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
    <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
    <div class="listTAB rightbg">
        <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt; <span class="cl1">订单列表</span></div>
        <div id="Accountcenter">
            <div class="right_h Tab_w762">
                <ul>
                    <li> <a href="" class="offtag" onclick="return false;">机票订单</a> </li>
                    <li> <a href="" class="offtag" onclick="return false;">酒店订单</a> </li>
                    <li> <a href="" class="offtag" onclick="return false;">高尔夫订单</a></li>
                    <li> <a href="" class="offtag" onclick="return false;">机场休息室订单</a></li>
                </ul>
            </div>
            <div class="clear"></div>
            <!-- .ContentBox_w762 -->
            <div id="ContentBox_w762"> 
                <!-- .Content_w762 机票-->
                <div class="Content_w762" style="display:none;" id="flightTableDivId">
                	<ul class="order_slc">
                        <li style="float:left;">
                            <select name="language" id="flightQueryTime">
                                <option selected="selected" value="1">最近一周订单</option>
                                <option value="2">最近一个月订单</option>
                                <option value="3">最近三个月订单</option>
                                <option value="4">最近一年订单</option>
                            </select>
                            <select name="language" id="flightQueryType">
                                <option selected="selected">申退票</option>
                                <option>普通预订票</option>
                            </select>
                            <select name="language" id="flightQuerySts">
                                <option selected="selected" value="00">等待支付</option>
                                <option value="01">等待出票</option>
                                <option value="02">出票成功</option>
                                <option value="04">已取消</option>
                                <option value="03">出票失败</option>
                                <option value="07">申请失败</option>
                                <option value="06">申请成功</option>
                                <option value="05">申请中</option>
                            </select>
                            <input name="" value="查询 " type="button"  id="queryFlightOrder"/>
                        </li>
                        <li style="float:right;display: none;" class="notPaymentTip">
                        	<span style="color:#F60;">提示：有&nbsp;
                        	<strong style="color:#F00; font-size:14px; font-weight:bold" class="tipAmount"></strong>
                        	&nbsp;笔未支付订单
                        	</span>
                        </li>
                    </ul>
	                <table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 User_Center">
		                 <tbody>
                            <tr id="trTitle">
                                <th width="100">&nbsp;&nbsp;&nbsp;&nbsp;订单号
                                	<input type="hidden" name="sts" value="0">
                                	<input type="hidden" name="ctreatTime" value="1970-01-01">
                                </th>
                                <th width="83">行程</th>
                                <th width="96">生成订单时间</th>
                                <th width="50">类型</th>
                                <th width="51">总价</th>
                                <th width="80">订单类型</th>
                                <th width="88">订单状态</th>
                                <th width="73">操作</th>
                            </tr>
		                  </tbody>
	                  </table>
	                  <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>
                </div>
                <!-- /.Content_w762 --> 
                
                <!-- .Content_w762 酒店-->
                <div class="Content_w762" style="display:none;" id="hotelTableDivId">
					<ul class="order_slc">
                        <li style="float:left;">
                            <select name="language" id="hotelQueryTime">
                                <option  value="1" selected="selected">最近一周订单</option>
                                <option value="2">最近一个月订单</option>
                            </select>
							<f:select type="酒店订单状态"  showValue="false" blank="true" id="hotelQuerySts"></f:select>
                            <input name="" value="查询 " type="button" id="queryHotelOrder"/>
                        </li>
                        <li style="float:right;display: none;" class="notPaymentTip"><span style="color:#F60;">提示：有&nbsp;<strong style="color:#F00; font-size:14px; font-weight:bold" class="tipAmount"></strong>&nbsp;笔未支付订单</span></li>
                    </ul>  
                    <!-- 暂时取消支付状态 --> 
                    <%--            
					<table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 User_Center">
		                 <tbody>
                            <tr>
                                <th>&nbsp;&nbsp;&nbsp;&nbsp;订单号</th>
                                <th>入住酒店</th>
                                <th>在店日期</th>
                                <th>下单日期</th>
                                <th>房费</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th width="63">操作
	                                <input type="hidden" name="sts" value="0">
                                	<input type="hidden" name="bookTime" value="1970-01-01">
                                </th>
                            </tr>
		                  </tbody>
	                  </table>
	                  --%>  
	                  <table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 User_Center">
		                 <tbody>
                            <tr>
                                <th>&nbsp;&nbsp;&nbsp;&nbsp;订单号</th>
                                <th>入住酒店</th>
                                <th>在店日期</th>
                                <th>下单日期</th>
                                <th>房费</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th width="63">操作
	                                <input type="hidden" name="sts" value="0">
                                	<input type="hidden" name="bookTime" value="1970-01-01">
                                </th>
                            </tr>
		                  </tbody>
	                  </table>
	                  <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>                
                </div>
                <!-- /.Content_w762 --> 
                
                <!-- .Content_w762 高尔夫-->
                <div class="Content_w762" style="display:none;" id="golfTableDivId">
                    <ul class="order_slc">
                        <li style="float:left;">
                            <select name="language" id="golfQueryTime">
                                <option  value="1" selected="selected">最近一周订单</option>
                                <option value="2" >最近一个月订单</option>
                            </select>
                            <f:select type="高尔夫订单状态" value="${sts}" id="golfQuerySts" showValue="false" blank="true"></f:select>
							<input name="" value="查询 " type="button" id="queryGolfOrder"/>
                        </li>
                        <%-- <li style="float:right;display: none;" class="notPaymentTip"><span style="color:#F60;">提示：有&nbsp;<strong style="color:#F00; font-size:14px; font-weight:bold" class="tipAmount"></strong>&nbsp;笔未支付订单</span></li>
                    	--%>
                    </ul>                
					<table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 User_Center">
		                 <tbody>
                            <tr>
                                <th width="60">&nbsp;&nbsp;&nbsp;&nbsp;订单号</th>
                                <th width="100">球场名称</th>
                                <th width="60">球场类型</th>
                                <th width="60">下单时间</th>
                                <th width="80">确认开球时间</th>
                                <th width="60">订单金额</th>
                                <th width="80">订单状态</th>
                                <th width="63">消费状态</th>
                                <th width="73">
	                                <input type="hidden" name="sts" value="0"/>
	                                <input type="hidden" name="createTime" value="1970-01-01"/>
                                	管理
                                </th>
                            </tr>
		                  </tbody>
	                  </table> 
					 <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>                 
                </div>
                <!-- /.Content_w762 --> 
                
                <!-- .Content_w762 休息室-->
                <div class="Content_w762" style="display:none;" id="loungeTableDivId">
                   <ul class="order_slc">
                        <li style="float:left;">
                            <select name="language" id="loungeQueryTime">
                                <option  value="1">最近一周订单</option>
                                <option value="2">最近一个月订单</option>
                            </select>
                            <f:select type="机场休息室订单状态" value="${sts}" id="loungeQuerySts" showValue="false" blank="true"></f:select>
                            <input name="" value="查询 " type="button" id="queryLoungeOrder"/>
                        </li>
						<%--<li style="float:right;display: none;" class="notPaymentTip"><span style="color:#F60;">提示：有&nbsp;<strong style="color:#F00; font-size:14px; font-weight:bold" class="tipAmount"></strong>&nbsp;笔未支付订单</span></li>                        
                    	 --%>
                    </ul>
					<table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 User_Center">
		                 <tbody>
                            <tr>
                                <th>&nbsp;&nbsp;&nbsp;&nbsp;订单号</th>
                                <th>休息室名称</th>
                                <th>休息室类型</th>
                                <th>下单时间</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>消费状态</th>
                                <th width="63">
                                	管理
                                <input type="hidden" name="sts" value="0"/>
                               	<input type="hidden" name="createTime" value="1970-01-01"/>
                                </th>
                            </tr>
		                  </tbody>
	                  </table>   
	                  <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>               
                </div>
                <!-- /.Content_w762 --> 
            </div>
            <!-- /.ContentBox_w762 -->
            
            <div class="lineclear Accountheight"></div>
            <div class="clear"></div>
            <!--page-->
            <div class="greytext" id="pager" style="text-align: center;">
            </div>
            <!--page end-->
            <div class="clear"></div>
        </div>
    </div>
    <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
    <!-----------------------------------------RIGHT END------------------------------------>
    <div class="clear"></div>
</div>
<!--Order_Track_Box-->
<div class="Order_Track_Box" style="overflow: auto;" ></div>
<!--Order_Track_Box end--> 
<!--Order_TG_Box-->
<div class="Order_TG_Box" style="overflow: auto;"></div>
</div>
<div style="filter:alpha(opacity=0);position: absolute;background-color:#ffffff;moz-opacity:0.0;opacity:0.0" id="tempDiv"></div>
<!--Order_TG_Box end-->
<script type="text/javascript">
//<![CDATA[
var notPaymentOrderAmount="0";
//设置连接
var linkArray=new Array();
linkArray["机票订单"]="ajaxTableFlightOrderAction.action";
linkArray["酒店订单"]="ajaxTableHotelOrderAction.action";
linkArray["高尔夫订单"]="ajaxTableGolfOrderAction.action";
linkArray["机场休息室订单"]="ajaxTableLoungeOrderAction.action";

var exceptionApiArray=new Array();
exceptionApiArray["高尔夫订单"]="${ctx}/apiJson/apiJsonService.action?method=api_findGolfOrderExcepByOrder&&orderId=";
exceptionApiArray["机场休息室订单"]="${ctx}/apiJson/apiJsonService.action?method=findLoungeOrderException&&orderId=";

var logApiArray=new Array();
logApiArray["高尔夫订单"]="${ctx}/apiJson/apiJsonService.action?method=api_findOrderLogByOrderId_Map&&id=";
logApiArray["机场休息室订单"]="${ctx}/apiJson/apiJsonService.action?method=findLoungeOrderLog&&orderId=";
 
//数据加载记录数组
var loadArray=new Array();
//分页显示区域
var pagesArea=$("#pager");

var pager=new Object();
//默认每页数据的行数
pager.pageSize=10;
//当前页
pager.currentPage=1;
//总条数
pager.rowCount=0;
//总页数
pager.pageCount=1;
//当前使用table
pager.currentTable=null;
//显示的分页按钮数
pager.pushButtonCount=10;
//当前活动的连接
pager.currentActiveLinkName="";
//当前页面对象
pager.tabIndex=0;
//显示的条目的索引数组,行对应索引为的值为true则表示可以现实,为false则不可显示
pager.displayArray=null;

//标志是否可以刷新
var canFlush=false;
//存放未支付信息提示区域

var tipAmountLi=$(".tipAmount");
var notPaymentTip=$(".notPaymentTip");

//屏蔽json数据的空值等 
function processJsonStr(obj){
	if(obj&& typeof obj =="string"){
		return obj;
	}else {
		return "";
	}
}
var wH=$(window).height();

var tempDiv=$("#tempDiv");
/**
 * 页面浮动提示 日志
 * @param {Object} Start
 * @param {Object} Box
 */
function winPositionAjaxLog(Start,Box){
	var box=$(Box);
	$(Start).bind("mouseover",function(){
		var obj = $(this).position();
		var w= box.width();
		var x= obj.left;
		var y= obj.top;
		box.html("数据加载中.............");
		box.css({"left":x-w+26,"top":y+20});
		box.show();
		var orderId=$(this).attr("name");
		var logApiUrl=logApiArray[pager.currentActiveLinkName];
		var requestUrl=logApiUrl+orderId;
		if(canFlush){
			canFlush=false;
			$.ajax({
				   type: "POST",
				   url: requestUrl,
				   dataType: "json",
				   success: function(data){
					   var jsonData=$.parseJSON(data);
					   var htmlData="<table cellspacing=\"1\" cellpadding=\"0\" border=\"0\" class=\"Order_Track_Table\"><tr><th width='100'>时间</th> <th>跟踪记录显示</th></tr>";
						   $.each(jsonData, function (index, item) {
							   if(item.content.indexOf("预定成功")==0){
						   		   htmlData+=("<tr><td>"+item.createTime+"</td><td>"+"提交成功"+"</td></tr>");
							   }else{
								   htmlData+=("<tr><td>"+item.createTime+"</td><td>"+item.content+"</td></tr>");
							   }
						   });
					   	htmlData+="<table>";
						box.html(htmlData);
						canFlush=true;
						//box.css();
						tempDiv.css({"width":box.width()+40,"height":box.height()+60,"left":x-w+26,"top":y-20});
						tempDiv.show();
				   }
			});
		}
	});

	
	tempDiv.bind("mouseout",function(){
		box.hide();
		tempDiv.hide();
	});
	
}
 
 //操作类型-golf
 var optTypeGlof=new Array();
 optTypeGlof["M"]="改期申请";optTypeGlof["R"]="退场申请";optTypeGlof["m"]="改期申请";optTypeGlof["r"]="退场申请";
 //处理结果-golf
 var optRsualtGlof=new Array();
 optRsualtGlof["1"]="待客服确认";optRsualtGlof["2"]="预订成功";optRsualtGlof["3"]="预订失败";optRsualtGlof["4"]="退场待审核";optRsualtGlof["5"]="退场成功";optRsualtGlof["6"]="退场失败";optRsualtGlof["7"]="改期待审核";optRsualtGlof["8"]="改期成功";optRsualtGlof["9"]="改期失败";optRsualtGlof["10"]="";optRsualtGlof["11"]="";optRsualtGlof["12"]="";
 
 var priceTypeArray=new Array();
 priceTypeArray["M"]="补款金额: ";
 priceTypeArray["m"]="补款金额: ";
 priceTypeArray["R"]="退款金额: ";
 priceTypeArray["r"]="退款金额: ";
 //处理结果-lounge
 var optRsualtLounge=new Array();
 /**
 * 页面浮动提示 退改
 * @param {Object} Start
 * @param {Object} Box
 */
 function winPositionAjaxException(Start,Box){
 	var box=$(Box);
 	$(Start).bind("mouseover",function(){
 		var obj = $(this).position();
		var w= box.width();
		var x= obj.left;
		var y= obj.top;
		box.html("数据加载中.............");
		box.css({"left":x-w+26,"top":y+20});
		box.show();
		var orderId=$(this).attr("name");
		var exceptionApiUrl=exceptionApiArray[pager.currentActiveLinkName];
		var requestUrl=exceptionApiUrl+orderId;
		if(canFlush){
			canFlush=false;
			 $.ajax({
				   type: "POST",
				   url: requestUrl,
				   dataType: "json",
				   success: function(data){
					   var jsonData=$.parseJSON(data);
					   //box.html(typeof jsonData);
					   var htmlData="<table cellspacing=\"1\" cellpadding=\"0\" border=\"0\" class=\"Order_TG_Table\">";
					   var count=0;
					   $.each(jsonData, function (index, item) {
					   count++;
					   var optType=optTypeGlof[processJsonStr(item.type)];
					   var optResult=optRsualtGlof[processJsonStr(item.sts)];
					   var priceType=priceTypeArray[processJsonStr(item.type)];
					   var priceStr=item.price?priceType+item.price:"";
					   htmlData+=("<tr><th width=\"60\">"+optType+"</th><td>"+
							    "<ul class=\"clearfix_\">"+
								"<li>姓名："+processJsonStr(item.createUser)+"</li>"+
								"<li>申请时间："+processJsonStr(item.createTime)+"</li>"+
								"<li>理由："+processJsonStr(item.rmk)+"</li>"+
							    "</ul>"+
							    "<ul class=\"clearfix_\">"+
								"<li>处理结果："+optResult+"</li>"+
								"<li>"+priceStr+"</li>"+
							    "</ul>"+
							    "</td></tr>");
					   });
				   	htmlData+="<table>";
				   	if(count==0){
				   		htmlData="该订单目前没有退改信息!!!";
					}
					box.html(htmlData);
					canFlush=true;
					tempDiv.css({"width":box.width()+40,"height":box.height()+60,"left":x-w+26,"top":y-20});
					tempDiv.show();
				   }
				});
		}
 	});
 	
	tempDiv.bind("mouseout",function(){
		box.hide();
		tempDiv.hide();
	});
}

//页面成功加载时执行
$(function(){
	var tabIndex="<s:property value="tabIndex" />";
	
	if(!tabIndex){
		tabIndex=0;
	}
    setTab(tabIndex);
    $(".Tab_w762 > ul > li").click(function(){
        var index = $(".Tab_w762 > ul > li").index(this);
        setTab(index);
    });
});

//绑定返回顶部按钮功能
function doBackTop(){
	//反绑定函数
	$(".Order_Track").unbind("mouseover");
	$(".Order_TG").unbind("mouseover");
	//返回顶部
	backTop();
	//设置1100毫秒后启用日志功能
	setTimeout("topButtonCallBack()",1100);
	
}
function topButtonCallBack(){
	winPositionAjaxLog(".Order_Track",".Order_Track_Box");
	winPositionAjaxException(".Order_TG",".Order_TG_Box");
}
function setTab(tabIndex){
  	var index = tabIndex;
  	pager.tabIndex=index;
   	var tab=$(".Tab_w762 > ul > li").eq(index);
//获取当前活动的连接
	var currentActiveLink=tab.children("a");
	pager.currentActiveLinkName=currentActiveLink.html();
    currentActiveLink.attr("class","ontag").end().siblings().children("a").attr("class","offtag");
    $("#ContentBox_w762 >div").eq(index).show().siblings().hide();
//判断数据是否已加载
	if(linkArray[currentActiveLink.html()]==true){
		//成功加载则重新初始化表格
		var currentActiveLink=$(".Tab_w762 > ul > li:contains('"+currentActiveLink.html()+"')");
		var index = $(".Tab_w762 > ul > li").index(currentActiveLink);
		var currentActiveDiv=$("#ContentBox_w762 >div").eq(index);
		initTable(currentActiveDiv);
		flushButton();
	}else{
	//连接加载数据
		loadData(pager.currentActiveLinkName,"");
	}
}

//刷新按钮
function flushButton(){
	//数据加载完成才执行绘制按钮的操作
	if(canFlush){
		if($("#isLoadError"+pager.tabIndex).val()=="true"){
			var url="${ctx}/member/index.jsp?tabIndex="+pager.tabIndex;
			pagesArea.html("<font class=\"yema\">抱歉!加载数据失败,<a href=\""+url+"\">点此刷新</a></font>");
		}
	}
}
/**
 * 异步加载数据
 * @param {Object} currentActiveLinkName
 */
function loadData(currentActiveLinkName,queryStr){
	//从数组中获取设置的连接
	var linkLocation=linkArray[currentActiveLinkName];
		//获取当前活动的div
		var currentActiveLink=$(".Tab_w762 > ul > li:contains('"+currentActiveLinkName+"')");
		var index = $(".Tab_w762 > ul > li").index(currentActiveLink);
		var currentActiveDiv=$("#ContentBox_w762 >div").eq(index);
		var currentTime=new Date();
		var currentTimeStr=currentTime.getTime();
		//在请求路径后加上时间戳,防止ie的页面缓存
		var requestUrl="";
		requestUrl="${ctx}/"+linkArray[currentActiveLinkName]+"?currentTime="+currentTimeStr;
		pagesArea.html("数据加载中,请稍后......");
		linkArray[currentActiveLinkName]=true;
		canFlush=false;
		$.ajax({
			type: "POST",
			url: requestUrl,
			dataType: "html",
			success: function(data){
				$("#loadTip").hide();
				var tbody=currentActiveDiv.find("table tbody").eq(0);
				tbody.append(data);
				initTable(currentActiveDiv);
				canFlush=true;
				flushButton();
				var npoa=$("#notPaymentOrderAmount"+pager.tabIndex).val();
				//if(npoa){
					//tipAmountLi.eq(pager.tabIndex).html(npoa);
					//notPaymentTip.eq(pager.tabIndex).show();
				//}
			}
		});
}


/**
 * 重绘制分页区域
 */
function rePaintPageArea(){
	//通过加载页面传回的标记判断是否加载成功
	if($("#isLoadError"+pager.tabIndex).val()=="true"){
		pagesArea.html("");
	}else {
		if(pager.rowCount<=0){
			pagesArea.html("抱歉!没有找到您要查询的数据");
			return 0;
		}else {
			if(pager.rowCount%pager.pageSize!=0){
				pager.pageCount=Math.floor(pager.rowCount/pager.pageSize)+1;
			}else {
				pager.pageCount=pager.rowCount/pager.pageSize;
			}
	
			var minPage=1;
			//判断是否需要控制溢出
			if(pager.pageCount>pager.pushButtonCount){
				minPage=pager.currentPage-Math.floor(pager.pushButtonCount/2);
				//计算最小 页码
				if((minPage+pager.pushButtonCount)>=pager.pageCount){
					minPage=pager.pageCount-pager.pushButtonCount;
				}else {
					minPage=minPage>=1?minPage:1;
				}
			}
			//计算最大页码
			var maxPage=pager.pushButtonCount+minPage;
			maxPage=maxPage>=pager.pageCount?pager.pageCount:maxPage;
			var pagesHtml="<font class=\"yema\">"
					 +"<a href=\"javasrcipt:void(0);\" onclick=\"back();return false;\"><img src=\"${ctx}/web/images/yema1.jpg\" /></a>"
					 +"<a href=\"javasrcipt:void(0);\" onclick=\"first();return false;\">首页</a>"
					 +"共"+pager.rowCount+"条"
					 +"<font id=\"pages\">";
			for(var i=minPage;i<=maxPage;i++){
				if(i==pager.currentPage){
					var str=("<a href=\"javascript:void(0);\" class=\"yemaa\" onclick=\"gotoPage("+i+")\">"+i+"</a>");
				}else {
					var str=("<a href=\"javascript:void(0);\" class=\"uncheckedPageButton\" onclick=\"gotoPage("+i+")\">"+i+"</a>");
				}
				pagesHtml+=str;
			}
			//加入后续提示
			if(maxPage<pager.pageCount){
				pagesHtml+="...";
			}
			pagesHtml+=("</font>"
					    +"<a href=\"javasrcipt:void(0);\" onclick=\"last();return false;\">尾页</a>"
					    +"<a href=\"javasrcipt:void(0);\" onclick=\"next();return false;\"><img src=\"${ctx}/web/images/yema2.jpg\" /></a>"
					    +"<a href=\"\" onclick=\"doBackTop();return false;\"><img src=\"${ctx}/web/images/gototop.jpg\" /></a>"
					    +"</font>");
			pagesArea.html(pagesHtml);
			return 1;
		}
	}
	
}

/**
 * 跳转到x页
 * @param {Number} page
 */
function gotoPage(page){
	pager.displayArray=null==pager.displayArray?[]:pager.displayArray;
	pager.currentPage=page;
	//绘制分页控件区域
	rePaintPageArea();
	//计算显示的条目的索引最小值
	var minIndex=(pager.currentPage-1)*pager.pageSize;
	var maxIndex=minIndex+pager.pageSize;
	maxIndex=maxIndex>=pager.rowCount?pager.rowCount:maxIndex;

	for(var i=0;i<pager.rowCount;i++){
		if(i<maxIndex&&i>=minIndex){
			pager.displayArray[i].show();
		}else {
			pager.displayArray[i].hide();
		}
	}
}

/**
 * 第一页
 */
function first(){
	gotoPage(1);
}
/**
 * 下一页
 */
function next(){
	if(pager.currentPage+1<=pager.pageCount){
		gotoPage(pager.currentPage+1);
	}
}
/**
 * 最后一页
 */
function last(){
	gotoPage(pager.pageCount);
}
/**
 * 上一页
 */
function back(){
	if(pager.currentPage-1>=1){
		gotoPage(pager.currentPage-1);
	}	
}
/**
 * 初始化活动table
 * @param {Object} currentActiveDiv
 */
function initTable(currentActiveDiv){
	pager.currentTable=currentActiveDiv.children("table").eq(0);
	query(function(){return true;});
	//绑定操作功能
	winPositionAjaxLog(".Order_Track",".Order_Track_Box");
	winPositionAjaxException(".Order_TG",".Order_TG_Box");
	bindQuery();
}


function query(callback){
	pager.displayArray=null;
	pager.displayArray=[];
	var trs=pager.currentTable.children("tbody").children("tr").first().nextAll();
	trs.each(function(){
		var td=$(this);
		if(callback(td)){
			pager.displayArray.push(td);
		}else {
			td.hide();
		}
	});
	var tdLast=pager.displayArray.pop();
	if(tdLast&&tdLast.html()!=null&&!tdLast.html()==""){
		pager.displayArray.push(tdLast);
	}
	pager.rowCount=pager.displayArray.length;
	first();
}

//查询休息室订单
function queryLoungeOrder(){
	$("#loungeQueryTime").children().eq(0).attr("selected","selected");
	$("#loungeQuerySts").children().eq(0).attr("selected","selected");
	$("#queryLoungeOrder").click(function (){
			pager.displayArray=null;
			pager.displayArray=[];
			var queryTimeType=$("#loungeQueryTime").val();
			var querySts=$("#loungeQuerySts").val();
			var tagetTime=getCurrentTime();
			if(queryTimeType=="1"){
				tagetTime=tagetTime-604800000;
			}else {
				tagetTime=tagetTime-2592000000;
			}
			query(function(tr){
				if(!querySts){
					return true;
				}
				var sourceTd=tr.children().eq(7);
				var createTime=sourceTd.children("input[name='createTime']").val();
				var sts=sourceTd.children("input[name='sts']").val();
				//获取查询条件匹配标记
				var flag=sts==querySts?true:false;
				var queryTime=dateStrToTime(createTime);
				if(queryTime<tagetTime){
					flag=false;
				}
				return flag;
			});
		});
}
//查询高尔夫订单
function queryGlofOrder(){
	$("#golfQueryTime").children().eq(0).attr("selected","selected");
	$("#golfQuerySts").children().eq(0).attr("selected","selected");
	$("#queryGolfOrder").click(function (){
			var queryTimeType=$("#golfQueryTime").val();
			var querySts=$("#golfQuerySts").val();
			var trs=pager.currentTable.children("tbody").children("tr");
			var tagetTime=getCurrentTime();
			if(queryTimeType=="1"){
				tagetTime=tagetTime-604800000;
			}else {
				tagetTime=tagetTime-2592000000;
			}
			query(function(tr){
				if(!querySts){
					return true;
				}
				var sourceTd=tr.children().eq(8);
				var createTime=sourceTd.children("input[name='createTime']").val();
				var sts=sourceTd.children("input[name='sts']").val();
				var flag=sts==querySts?true:false;
				//判断时间
				var queryTime=dateStrToTime(createTime);
				if(queryTime<tagetTime){
					flag=false;
				}
				return flag;
			});
		});
}
//查询酒店订单
function queryHotelOrder(){
	$("#hotelQueryTime").children().eq(0).attr("selected","selected");
	$("#hotelQuerySts").children().eq(0).attr("selected","selected");
	$("#queryHotelOrder").click(function (){
			var queryTimeType=$("#hotelQueryTime").val();
			var querySts=$("#hotelQuerySts").val();
			var trs=pager.currentTable.children("tbody").children("tr");
			var tagetTime=getCurrentTime();
			if(queryTimeType=="1"){
				tagetTime=tagetTime-604800000;
			}else if(queryTimeType=="2"){
				tagetTime=tagetTime-2592000000;
			}
			query(function(tr){
				if(!querySts){
					return true;
				}
				var sourceTd=tr.children().eq(7);
				var bookTime=sourceTd.children("input[name='bookTime']").val();
				var sts=sourceTd.children("input[name='sts']").val();
				var flag=sts==querySts?true:false;
				//判断时间
				var queryTime=dateStrToTime(bookTime);
				if(queryTime<tagetTime){
					flag=false;
				}
				return flag;
			});
		});
}
//查询机票订单
function queryFlightOrder(){
	$("#flightQueryTime").children().eq(0).attr("selected","selected");
	$("#flightQuerySts").children().eq(0).attr("selected","selected");
	//$("#flightQueryType").children().eq(0).attr("selected","selected");
	$("#queryFlightOrder").click(function (){
			var queryTimeType=$("#flightQueryTime").val();
			var querySts=$("#flightQuerySts").val();
			var trs=pager.currentTable.children("tbody").children("tr");
			var tagetTime=getCurrentTime();
			if(queryTimeType=="1"){
				tagetTime=tagetTime-604800000;
			}else if(queryTimeType=="2"){
				tagetTime=tagetTime-2592000000;
			}else if(queryTimeType=="3"){
				tagetTime=tagetTime-7776000000;
			}else {
				tagetTime=tagetTime-31536000000;
			}
			query(function(tr){
				if(!querySts){
					return true;
				}
				var sourceTd=tr.children().eq(0);
				var createTime=sourceTd.children("input[name='createTime']").val();
				var sts=sourceTd.children("input[name='sts']").val();
				var flag=sts==querySts?true:false;
				//判断时间
				var queryTime=dateStrToTime(createTime);
				if(queryTime<tagetTime){
					flag=false;
				}
				return flag;
			});
			
		});	
}
//绑定查询
function bindQuery(){
	queryLoungeOrder();
	queryGlofOrder();
	queryHotelOrder();
	queryFlightOrder();
}

//yyyy-mm-dd类型的时间字符串转化为1970-01-01 00:00 到现在的毫秒
function dateStrToTime(dateStr){
	if(!dateStr){
		dateStr="1970-01-01";
	}
	var str=dateStr;
   	var date = new Date(str.replace(/-/g,"/"));
	return date.getTime();
}
//string 转date对象
function dateStrToDate(dateStr){
	var str=dateStr;
	return new Date(str.replace(/-/g,"/"));
}
//获取1970-01-01 00:00 到现在的毫秒
function getCurrentTime(){
	return new Date().getTime();
}
//]]>
</script>
</body>