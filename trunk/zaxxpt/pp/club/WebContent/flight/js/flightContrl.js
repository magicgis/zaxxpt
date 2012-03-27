//获取DOM对象的绝对位置
function getAbsPoint(e) {   
    var x = e.offsetLeft;   
    var y = e.offsetTop;   
    while(e = e.offsetParent) {   
        x += e.offsetLeft;   
        y += e.offsetTop;   
    }   
    return {x:x,y:y};   
} 
// 全局变量
var  flightType="1";

var departureAirport=null;
var arrivalAirport=null;
var departureDate=null;
var returnDate=null;

//var dataDiv=null;
// 页面加载执行
$(function(){
	// 初始化数据
	initData();
	// 显示退改信息
	$(".Tickets_TG").live("mouseover",function(){
		$(this).next().show();
		var temp=getAbsPoint(this);
		var intX=temp.x+$(this).next().width()-$(window).width();
		if(intX<0)$(this).next().css({left:temp.x+"px",top:temp.y+18+"px"});
		else $(this).next().css({left:temp.x-$(this).next().width()+$(this).width()-10+"px",top:temp.y+15+"px"});
	});
	
	$(".Tickets_TG").live("mouseout",function(){
		$(this).next().hide();
	});
  	// 下拉框 航空公司 add by wuyuhu
  	$("#Room").click(function(){
  		slit();
	});
  	
	// 下拉框 时间 add by wuyuhu
	$("#language_tm2010").click(function(){
		slit();
    });
	
	// 搜索结果列表 - 查看全部价格
	$(".more_Tickets").hide();
	$(".more_btn").live("click",function(){
	    if($(this).parents(".Tickets").next(".more_Tickets").is(":hidden")){
	        $(".more_Tickets").hide().prev(".Tickets");
		    $(this).text("隐藏价格").parents(".Tickets").next(".more_Tickets").show();
	    }else{
	        $(this).text("全部价格").parents(".Tickets").next(".more_Tickets").hide();
	    }
		return false;
	});
	
	
	$(".icon_close").click(function(){
		$(this).parents(".more_Tickets").hide().prev(".Tickets");
		return false;
	});
	// 时间排序 
	$(".air_up").toggle(
		function(){
			sortFlight(sortWay.date,sortWay.desc);
			$(this).children("b").css("background-position","0 -4px");
		},
		 function(){
			sortFlight(sortWay.date,sortWay.asc);
			$(this).children("b").css("background-position","0 0"); 
		}
	);
	 // 价格排序
	$(".air_up2").toggle(
			function(){
				sortFlight(sortWay.price,sortWay.desc);
				$(this).children("b").css("background-position","0 -4px");
			},
			 function(){
				sortFlight(sortWay.price,sortWay.desc);
				$(this).children("b").css("background-position","0 0"); 
			}
	);

	if(flightType=='2'){
		$("#danCheng").attr('checked', false); 
		$("#wangFan").attr('checked', true); 
		$(".ReturnTime").children().show();
	}else{
		$("#danCheng").attr('checked', true); 
		$("#wangFan").attr('checked', false); 
		$(".ReturnTime").children().hide();
	}
	$("#wangFan,#danCheng").click(function(){
		$("#wangFan").is(":checked") ? $(".ReturnTime").children().show() : $(".ReturnTime").children().hide();
	});

    // 退改签条款、表单填写说明
	// togoTop
	$("#gotoTop").click(function(){
		// $(window.parent.document.body).parent("html").animate({scrollTop:
		// '0px'}, 200); // If in iframe, use this.
		$("html").animate({scrollTop: '0px'}, 200); 
		return false;
	});
    // IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
	if(!-[1,]&&!window.XMLHttpRequest){
		$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	}

	// 异步加载天气预报
	loadWeatherAjax("#tq_box",$("#departureAirportCode").val(),$("#arrivalAirportCode").val(),"F","F");
	// 航空公司官网数据异步查询
	showSearchFlight();
});

// ///////////////////////////////////////////////////////显示控制/////////////////////////////////////////
// 所有数据div的数组
var dataDivArr=[];
// 用于显示的div的数组
var displayArr=[];
function initData(){
	//初始化公共参数/////////////////////////////////////////////
	departureAirport=$("#departureAirportCode").val();
	arrivalAirport=$("#arrivalAirportCode").val();
	departureDate=$("#departureDate").val();
	returnDate=$("#returnDate").val();
	// 单程&往返radio
	flightType=$("#flightType").val();
	
//	dataDiv=$("#allDataDiv");
	//初始化显示的数据//////////////////////////////////////////
	$(".marginT_1").each(function(){
		dataDivArr.push($(this));
		displayArr.push($(this));
	});
}

// 显示过滤
function colation(){
	// 将久的数据置为空
	displayArr=null;
	displayArr=[];
	// 航空公司
	var company=$("#Room").attr("value");
	var time=$("#language_tm2010").attr("value");
	// 遍历所有数据的div Tickets-显示是的td 可以认为是基本信息的头
	for(var i=0;i<dataDivArr.length;i++){
		var div=dataDivArr[i];
		var tickets=div.find(".Tickets");
		var flightCompany=tickets.find("input[name='gairlineCompanyCode']").val();
		var flightTime=tickets.find("input[name='gdepartureTime']").val()+"-"+tickets.find("input[name='garrivalTime']").val();
		if((company&&flightCompany!=company)||(time&&!timeProcess(time,flightTime))){
			div.hide();
		}else {
			div.show();
			displayArr.push(div);
		}
	}
}
//过滤  qu
function slit(){
	var selectCompany=$("#Room").val();
	var selectTime =$("#language_tm2010").val();
	$("div[name='allDataDiv']").each(function(){
  		var company=true;
  		var timeStr=true;
  		if("" == selectCompany){
  			company=true;
  		}else if(selectCompany==$(this).find("input:[name='gairlineCompanyCode']").val()){
  			company=true;
		}else{
  			company=false;
  		}
		var beginTime=selectTime.substring(0,2);
		var endTime=selectTime.substring(6,8);      
		var time=$(this).find("input[name='gdepartureTime']").val().substring(0,2);
		var minute=$(this).find("input[name='gdepartureTime']").val().substring(3);    
		if(Number(time)>=Number(beginTime) && Number(time)<=Number(endTime)-1 && Number(minute)<=59){  
			timeStr=true;
		}else if("" == selectTime){
		   timeStr=true;
		}else{ 
			timeStr=false;
		} 
		if(company && timeStr){
			$(this).show();
		}else{
			$(this).hide();
		}
	});
}

var sortWay={"price":1,"date":2,"desc":-1,"asc":1};

// 数据排序
var sortWayArr=[];
/**
 * 
 * @param way
 *            排序依据
 * @param order
 *            排序方式
 * @return
 */
function sortFlight(way,orderA){
	
	if(way==1){//价格排序
		var adultTicketPriceA=null;
		var adultTicketPriceB=null;
		displayArr.sort(function (a,b){
			adultTicketPriceA=a.find("input[name='adultTicketPrice']").val();
			adultTicketPriceB=b.find("input[name='adultTicketPrice']").val();
			return orderA*(adultTicketPriceA-adultTicketPriceB);
		});
		var adultTicketPriceA=null;
		var adultTicketPriceB=null;
	}else if(way==2){//起飞时间排序
		var gdepartureTimeA=null;
		var gdepartureTimeB=null;
		displayArr.sort(function (a,b){
			gdepartureTimeA=strToMin(a.find("input[name='gdepartureTime']").val());
			gdepartureTimeB=strToMin(a.find("input[name='gdepartureTime']").val());
			return orderA*(gdepartureTimeA-gdepartureTimeB);
		});
	}
	
	var len=displayArr.length;
	//allDataTail
	if(orderA==1){
		var previous=$("#AllDataTitle");
		for(var i=0;i<len-1;i++){
			displayArr[i].insertAfter(previous);
			previous=displayArr[i];
		}
	}

}
// ///////////////////////////////////////////////////////显示控制/////////////////////////////////////////


// ///////////////////////////////////////////////////////辅助函数/////////////////////////////////////////
// 航班起飞时间处理
function timeProcess(selectTime,flightTime){
	// 时间
	var time=strToHour(flightTime);
	var beginTime=strToHour(selectTime.substring(0,2));
	var endTime=strToHour(selectTime.substring(6,8));
	if(time<endTime&&time>=beginTime){
		return true;
	}else {
		return false;
	}
}
// hh:mm 格式的时间字符串转小时
function strToHour(timeStr){
	return timeStr.substring(0,2)-0;
}

//hh:mm 格式的时间字符串转分钟
function strToMin(timeStr){
	return (timeStr.substr(0,2)-0)*60+(timeStr.substr(3,2)-0);
}

// ///////////////////////////////////////////////////////辅助函数/////////////////////////////////////////


// ///////////////////////////////////////////////////////业务处理/////////////////////////////////////////
// 查询开始
function searchFlight(){
	 if(yzData()){
	 if($("#wangFan").attr('checked') == true){
		 flightType = "2";
	 }
	 var deFlight=$("#departureAirportId").attr("value");
	 var arFlight=$("#arrivalAirportId").attr("value");
	 var deDate=$("#plainDate1").attr("value");
	 var reDate=$("#plainDate2").attr("value");
	 var url=CTX+"/flight/search.jsp?flightType="+flightType+"&deAirport="+deFlight+"&arAirport="+arFlight+"&departureDate="+deDate;
	 var disabled = "disabled";
     if(reDate){
     	url+="&returnDate="+reDate;
     }
     $("#controlColor").attr("disabled",true).css("backgroundPosition","0 -41px");
     	window.location=url;
	 }
}

// 校验时间
function yzData(){
		 if($("#wangFan").attr('checked') == true){
	          flightType = "2";
	     }		
        if($("#departureAirport").val()== null || $("#departureAirport").val() =="" || $("#departureAirport").val() =="中文/拼音" || $("#departureAirportId").val()== null ||  $("#departureAirportId").val()== '' || $("#departureAirportId").val()== "null"){
            $('#departureAirport').attr('value','');
            $('#departureAirport').click();
            return false;
        }
        if($("#arrivalAirport").val()== null || $("#arrivalAirport").val() =="" || $("#arrivalAirport").val() =="中文/拼音" || $("#arrivalAirportId").val()== null ||  $("#arrivalAirportId").val()== '' || $("#arrivalAirportId").val()== "null"){
            $('#arrivalAirport').attr('value','');
            $('#arrivalAirport').click();
            return false;
        }
        if($("#departureAirportId").val()== $("#arrivalAirportId").val()){
            $('#departureAirport').attr('value','');
            $('#departureAirport').click();
            alert("对不起,你的出发地和目的地相同");
            return false;
        }
        if($("#plainDate1").val()== null || $("#plainDate1").val() == "" ){
           $('#plainDate1').attr('value','');
           WdatePicker({el:'plainDate1',minDate:'%y-%M-%d'});
            return false;
            }
       if( flightType == "2"){
	       if($("#plainDate2").val()== null || $("#plainDate2").val() == "" ){
	          $('#plainDate2').attr('value','');
	          WdatePicker({el:'plainDate2',minDate:$('#plainDate1').val()});
	          return false;
	        }
        }
        var staDate=$("#plainDate1").val();
        var eDate=$("#plainDate2").val();
        var starDate=new Date(staDate.split("-").join("/"));
        if(eDate!=null && eDate!=""){
         var endDate=new Date(eDate.split("-").join("/"));
         if(starDate>endDate){
       		alert("返程时间小于出发时间!");
       		return false;
       	}
        }
        return true;
}

// 前一天
function beforeDate(beforeDateStr,yesterday){
   if(beforeDateStr!==yesterday){
		if($("#wangFan").attr('checked') == true){
	          flightType = "2";
	    }		
		 var deFlight=$("#departureAirportId").attr("value");
		 var arFlight=$("#arrivalAirportId").attr("value");
		 var deDate=beforeDateStr;
		 var reDate=$("#plainDate2").attr("value");
		
		 var url=CTX+"/flight/"+pageName+"?flightType="+flightType+"&deAirport="+deFlight+"&arAirport="+arFlight+"&departureDate="+deDate;
	     if(reDate!=null && reDate!=''){
	         url+="&returnDate="+reDate;
	     }
	     var flightBookForm=$("#flightSearchForm");
	     if(deDate){
	    	 flightBookForm.attr("action",url);
	    	 flightBookForm.submit();
	     }else{
	    	alert("您查询的日期已过期！");
	    }
  	}
}
// 后一天
function afterDate(afterDateStr){
	 if($("#wangFan").attr('checked') == true){
          flightType = "2";
     }		
	 var deFlight=$("#departureAirportId").attr("value");
	 var arFlight=$("#arrivalAirportId").attr("value");
	 var deDate=afterDateStr;
	 var reDate=$("#plainDate2").attr("value");
	 var url=CTX+"/flight/"+pageName+"?flightType="+flightType+"&deAirport="+deFlight+"&arAirport="+arFlight+"&departureDate="+deDate;
     if(reDate!=null && reDate!=''){
         url+="&returnDate="+reDate;
     }
     var flightBookForm=$("#flightSearchForm"); 
     if(deDate){
    	 flightBookForm.attr("action",url);
    	 flightBookForm.submit();
     }
}

// ///////////////////////////////////////////////////////业务处理/////////////////////////////////////////

/**
 * 预订,param 格式为 {bookButton:$(this),type:1}的形式 bookButton为点击预订的按钮 其中type为1
 * 表示默认显示行,2为隐藏行,3为异步的特价机票
 */

				
				// 取当前时间毫秒数
var nowTime = Date.parse(new Date());

// 更新离开日期
function checkWhenBack() {
	var checkInDate = document.getElementById("plainDate1").value;
	var checkOutDate = document.getElementById("plainDate2").value;
	var checkInTime = new Date(checkInDate.split("-").join("/"));
	nowTime = Date.parse(checkInTime);
	var nextdate = getFormatDate(24 * 60 * 60 * 1000);
	var start = new Date(nextdate.replace(/\-/g, "\/"));
    var end = new Date(document.getElementById("plainDate2").value.replace(/\-/g, "\/"));
    if (start > end) {
	    document.getElementById("plainDate2").value = nextdate;
	}
}

function getFormatDate(enterTime) {
	if(enterTime){
		var now = new Date(nowTime+enterTime);
	}
	 else{
		 var now = new Date();
	 }
	    var _year = now.getFullYear();   
	   	var _month = now.getMonth()+1;
	   	var a = _month.toString();
        if ('1' == a.length) {
            _month = '0' + _month;
        }
	    var _day = now.getDate();
	    var b = _day.toString();
	    if ('1' == b.length) {
            _day = '0' + _day;
        }
	    var myDate=_year+"-"+_month+"-"+_day;
	    return myDate; 	    
}
 
/**
 * 异步抓取航空公司机票信息
 * @return
 */
function showSearchFlight(){
	var url=CTX+"/gWDetailAction!searchGwFlight.action?dep="+departureAirport+"&arr="+arrivalAirport+"&deDate="+departureDate;
	if(returnFlag){
		//返程页面交换出发到达机场 以及时间
		url=CTX+"/gWDetailAction!searchGwFlight.action?dep="+arrivalAirport+"&arr="+departureAirport+"&deDate="+returnDate;
	}
	$.ajax({
		 type :"POST",
		 contentType :"appliction/json",
		 url :url,
		 dataType:'xml',
		 success:function(xml){
//			遍历xml
		 	$(xml).find("entry").each(function(){
		 		var entry=$(this);
		 		var flightNo=entry.children("Key").text();
//		 	对象
		 		entry.find("FlightGWVo").each(function(j){
			 		var cabin=$(this);
				 	var cabinCode=cabin.children("CabinCode").text();
				 	var vipTd=$("#vip"+flightNo+"_"+cabinCode);
				 	if(vipTd){
				 		//价格
				 		var price=cabin.children("Price").text();
				 		if(vipTd.prev().find("input:[name='adultTicketPrice']").val()>=price){
				 		//出发时间
				 		var deDate=cabin.children("DepartureTime").text();
				 		//到达时间
				 		var arrDate=cabin.children("ArrivalTime").text();
				 		//退改签规则
				 		var cabinInfo=cabin.children("CabinInfo").text();
				 		//来源
				 		var orgin=cabin.children("Origin").text();
				 		
				 		var content="<strong><span class=\"yen\">¥</span>"+price+"&nbsp;&nbsp;&nbsp;</strong>"+cabinCode+"舱<br /><a class=\"Btn63_24\"  onclick=\"bookingFlight({bookButton:$(this),type:3});return false;\" href=\"javascript:void(0);\">特价申请</a> <a href=\"javascript:void (0);\" class=\"orangea Tickets_TG\">退改签</a><div class=\"Tickets_TGBox\">"+cabinInfo+"</div>"
				 		var content2="<a class=\"orangea Product_synopsis Tickets_TG\" href=\"#\">特价产品介绍</a><div class=\"Tickets_TGBox\">特价机票申请提示:<br>特价机票不支持退改签。<br>您申请的特价机票票源紧张可能无票！</div>"
				 		vipTd.html(content);
				 		vipTd.siblings(".vip2").html(content2);
				 		//特价
				 		var specialInfoJson="{";
				 		specialInfoJson+="'adultTicketPrice':'"+price
				 		+"','childTicketPrice':'"+price
				 		+"','cabinCode':'"+cabinCode
				 		+"','flightOrgin':'"+orgin
				 		+"','changeInfo':'"+cabinInfo
				 		+"'}"
				 		
				 		var specialInfo="<input type=\"hidden\" name=\""+specialInfoName+"\" value=\""+specialInfoJson+"\" />";
				 		
				 		vipTd.append(specialInfo);
				 		}
				 	}
		 		});
		 	});
		 }
	});
}

