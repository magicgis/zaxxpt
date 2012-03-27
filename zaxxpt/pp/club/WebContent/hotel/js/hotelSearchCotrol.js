$(function (){
	//初始化时,异步加载天气预报
	var cityCode=$("#cityCode").val();
	if(cityCode){
		loadWeatherAjax("#tq_box",cityCode,"","H","H");
	}else {
		cityCode="010";
		loadWeatherAjax("#tq_box",cityCode,"","H","H");
	}
	/*
	//按钮处理
    $("li.jc_tag1").mouseover(function(){
        $(this).children("a").attr("class","jc_ta1").parent().siblings("li").children("a").attr("class","jc_ta2")
        var s = $("li.jc_tag1").length;
        var index = $("li.jc_tag1").index(this);
        $(".tag_right_boz >div").eq(s-index-1).show().siblings().hide();
    });
    $("#searchBtn").click(function(){
	    submitForm($(this));
	    return false;
	});
	 */
	// IE6 不支持非a标签伪类:hover导致鼠标经过下拉选单无样式的处理
    if(!-[1,]&&!window.XMLHttpRequest){
		$(".tag_options li").live("mouseover",function(){$(this).css("background-color","#CCC")}).live("mouseout",function(){$(this).css("background-color","#FFF")});
	}
    //异步取得房型数据
    ajaxShowRoomDetail();
    //绘制分页区域
    showPageControl();
});


//控制是否展示
function showAllRooms(hotelcode){
	if("查看全部价格" == $("#pricebutton_"+hotelcode).html()){
		$("div[name='hotelCode_"+hotelcode+"']").show();//.parent().css("background","#f3f3f3").prev().css("background","#f3f3f3").prev().css("background","#f3f3f3");
		$("#pricebutton_"+hotelcode).html("只显示最低价格");
	}else{
		//收缩
		$("div[name='hotelCode_"+hotelcode+"']").hide();//.parent().css("background","none").prev().css("background","none").prev().css("background","none");
		$("#pricebutton_"+hotelcode).html("查看全部价格");
	}
}

function doClick(oSourceObj,oTargetObj){
	var sourceObj = typeof oSourceObj == "string" ? document.getElementById(oSourceObj) : oSourceObj;
	var targetObj = typeof oTargetObj == "string" ? document.getElementById(oTargetObj) : oTargetObj;
	if(targetObj.style.display!="none"){
	   oSourceObj.className="zhankai1";
	   targetObj.style.display="none";
	} else {
		oSourceObj.className="zhankai";
	   targetObj.style.display="block";
	}
}


function doClicks(oSourceObj,oTargetObj){
	var sourceObj = typeof oSourceObj == "string" ? document.getElementById(oSourceObj) : oSourceObj;
	var targetObj = typeof oTargetObj == "string" ? document.getElementById(oTargetObj) : oTargetObj;
	if(targetObj.style.display!="none"){
	   oSourceObj.className="qanbu";
	   targetObj.style.display="none";
	} else {
	   oSourceObj.className="qanbu";
	   targetObj.style.display="block";
	}
}
// 在页面显示提示
function alertMessage(str){
	$("#messagebox").html(str);
}


//分页信息对象
var pageInfo=new Object();
pageInfo.totalPage=0;
pageInfo.currentPageNum=0;
pageInfo.pageSize=0;
pageInfo.pageButtonAmount=10;
/*
// 提交查询表单
function submitForm(submitButton){
	//日期格式化正则表达式
	var dateFormatReg=/^(20\d{2})[\/|\-](0?[1-9]|10|11|12)[\/|\-]([1-2]?[0-9]|0[1-9]|30|31)$/g;
	var cityStr=$("#cityCode").val();
   	if(!cityStr){
   		//alertMessage('您未填写城市！');
   		//$("#city").click();//城市不能为空。
   		document.getElementById("city").click();
   		return;
   	}
   	var timei=$("#plainDate1").val();
   	if(!(dateFormatReg.test(timei))){
   		//alertMessage('您未填写正确的入住时间！入住时间格式如:2000-01-01');
   		WdatePicker({el:'plainDate1',minDate:'%y-%M-%d'});//入住时间不能为空。
   		return;
   	}
   	var timeo=$("#plainDate2").val();
   	if(!timeo){
   		//alertMessage('您未填写正确离店时间！离店时间格式如:2000-01-01');
   		WdatePicker({el:'plainDate2',minDate:'%y-%M-%d'});//离店时间不能为空。
   		return;
   	}

   	$("#hcitycode").val(cityStr);
   	$("#hidate").val(timei);
   	$("#hodate").val(timeo);
   	$("#hhotelname").val($("#hotelname").val());
   	$("#hstar").val($("#star").val());
   	$("#hprice").val($("#price").val());
   	// 提交
    $("#myform").attr("action",CTX+"/hotel/search.jsp");
   	$("#myform").submit();
}
*/
/**
 * 重新计算时间已达到入住时间和离店时间,自动调整的功能 author lixun createDate 2011-9-20
 */
/*
function reComputeTime(){
	var time1=$("#plainDate1").val();
    var time2=$("#plainDate2").val();
	if(time2){
	    var idate=dateStrToTime(time1);
	    var odate=dateStrToTime(time2);
	    // 86400000 一天的毫秒数
	    if(odate-idate<86400000){
	    	odate=idate+86400000;
	    }
	    $("#plainDate2").val(dateTimeToStr(odate,"-"));
	}
}

// 补0，不足两位补足两位
function fillZero(str){
	var str1 = "";
	str1 +=str;
	if(str1.length == 1){
		return "0"+str1;
	}else{
		return str1;
	}
}
// string 转date对象
function dateStrToDate(dateStr){
	var str=dateStr;
	return new Date(str.replace(/-/g,"/"));
}

// yyyy-mm-dd类型的时间字符串转化为1970-01-01 00:00 到现在的毫秒
function dateStrToTime(dateStr){
	var str=dateStr;
   	var date = dateStrToDate(dateStr);
	return date.getTime();
}
// 毫秒转日期字符串
function dateTimeToStr(time,separator){
	var dateTemp=new Date();
	dateTemp.setTime(time);
	var strTemp="";
	strTemp+=dateTemp.getFullYear();
	strTemp+=separator;
	strTemp+=fillZero(dateTemp.getMonth()-(-1));
	strTemp+=separator;
	strTemp+=fillZero(dateTemp.getDate());
	return strTemp;
}
// 获取1970-01-01 00:00 到现在的毫秒
function getCurrentTime(){
	return new Date().getTime();
}


//////////////////////////////////数据展示/////////////////////////////////
var hotelsList = [];			//过滤后的酒店列表

var itemPerPage = 10;			//每页条数
var amountItems;				//总条数
var amountPages;				//总页数
var lastPageItems;   			//最后一页的条数
var showPageNum = 10;			//翻页控件最多能显示的个数

function initPage(){
	//初始化酒店列表
	if(hotelAllData.result.message){
		alertMessage("<b>非常抱歉,没有查询到相关信息的酒店。</b><br/><br/><br/>	请重新查询。如有疑问，请你致电"+TEL+"进行咨询。");
	}else{
		//通过酒店名称过滤数据
		var hotelname = $("#hhotelname").val();
		for(var i=0;i<hotelAllData.resultBean.hotels.length;i++){
			if(hotelAllData.resultBean.hotels[i].name.indexOf(hotelname) != -1){
				hotelsList.push(hotelAllData.resultBean.hotels[i]);
			}
		}
		if(hotelsList.length>0){
			//初始化翻页控件参数
			amountItems = hotelsList.length;		//总条数
			amountPages = Math.ceil(amountItems/itemPerPage);	//总页数
			lastPageItems = amountItems-(amountPages-1)*itemPerPage;   //最后一页的条数
			//初始化列表
			showHotelList(1);
			//初始化翻页
			showPageControl(1);
		}else{
			alertMessage("<b>非常抱歉,没有查询到相关信息的酒店。</b><br/><br/><br/>	请重新查询。如有疑问，请你致电"+TEL+"进行咨询。");
		}	 
	}
}
*/
//重显翻页控件
function showPageControl(pageNum){
	if($("#totalPageCount").val()){
		pageInfo.totalPage=$("#totalPageCount").val()-0;
		//回传pageNum从0开始计数,和现实有出入所以加1处理
		pageInfo.currentPageNum=$("#currentPageNum").val()-0+1;
		pageInfo.pageSize=$("#pageSize").val()-0;
		var previous=pageInfo.currentPageNum;
		var next=pageInfo.currentPageNum==pageInfo.totalPage?pageInfo.totalPage:pageInfo.currentPageNum+1;
		var pageButton="";
		var min=pageInfo.currentPageNum;
		min=min>pageInfo.totalPage-pageInfo.pageButtonAmount?pageInfo.totalPage-pageInfo.pageButtonAmount+1:min;
		var max=min+pageInfo.pageButtonAmount;
		min=min<=1?1:min;
		for(var index=min;index<max;index++){
			if(index==pageInfo.currentPageNum){
				pageButton+="<a class=\"yemaa\" href=\"javascript:void gotoPage("+index+")\">"+index+"</a>";
			}else {
				pageButton+="<a href=\"javascript:void gotoPage("+index+")\">"+index+"</a>";
			}
		}
		var pageHtml="<a href=\"javascript:void gotoPage("+previous+");\"><img src=\""+CTX+"/web/images/up.jpg\"></a>"
		+"<a href=\"javascript:void gotoPage(1)\">首页</a>"
		+pageButton
		+"<a href=\"javascript:void gotoPage("+pageInfo.totalPage+");\">尾页</a>"
		+"<a href=\"javascript:void gotoPage("+next+");\"><img src=\""+CTX+"/web/images/down.jpg\"></a>"
		+"<a name=\"btop\" href=\"javascript:void backTop();\"><img src=\""+CTX+"/web/images/bottomtop.jpg\"></a>";
		$("#pageInfo").html(pageHtml);
	}
}

function gotoPage(pageNum){
	if(pageNum!=pageInfo.currentPageNum){
		$("#currentPageNum").val(pageNum-1);
		$("#pageForm").submit();
	}else {
		return false;
	}
}

var hotelRoomListAction=CTX+"/hotelInfoAction!searchRoomInfo.action";
//展示房型信息
function ajaxShowRoomDetail(){
	var currentCity=$("#currentCity").val();
	var currentIdate=$("#currentIdate").val();
	var currentOdate=$("#currentOdate").val();
	$(".jdlistimg").each(function(){
		var hotelDiv=$(this);
		try{
			var code=hotelDiv.attr("id").split("_")[1];
			var dataParam={
					"hotelRoomQueryVo.hotelCode":code,
					"hotelRoomQueryVo.city":currentCity,
					"hotelRoomQueryVo.idate":currentIdate,
					"hotelRoomQueryVo.odate":currentOdate
			};
			hotelDiv.after("<div class='jdlist1 automargin' id='roomHeader"+code+"'>房型数据正在加载中.........</div>");
			$.post(hotelRoomListAction,dataParam,function(jsonData){
				loadRoomCallback(hotelDiv,code,jsonData);
			});
		}catch(ex){
			//防止某个查找酒店房型过程中出现异常,导致整个程序不往下执行的问题
			hotelDiv.after("<div class='jdlist1 automargin' id='roomHeader"+code+"'>房型数据加载失败</div>");
		}
	});
}

var roomHeaderStr="<div class=\"jdlist1 automargin\"><ul class=\"liboder\"><li class=\"w1\">房型</li><li class=\"w3_new\">早餐</li><li class=\"w3_new\">宽带</li><li class=\"w3_new\">市场价</li><li class=\"w3_new\">会员优惠</li><li class=\"w3_new\">会员价</li><li class=\"w3_new\">&nbsp;</li></ul>";
//调用ajax
function loadRoomCallback(hotelDiv,code,jsonData){
	var roomHeader=$("#roomHeader"+code);
	var jsonObj=null;
	try{
		jsonObj=eval('('+jsonData+')');
	}catch(ex){
    	try{
    		jsonObj=eval("("+jsonData+")");
    	}catch(exception){
    		jsonObj=null;
    	}
    }
	if(jsonObj){
		if(jsonObj.result.message){
		   //查询房型信息失败
			roomHeader.html("抱歉!该酒店的房型信息查询失败");
		}else{
			//解析此房型列表
			var resultBean=jsonObj.resultBean;
			//房型信息数据
			var roomInfo="";
			var isFirst=true;
			//房型信息数据(默认隐藏)
			var roomInfoHide="";
			for(var index=0;index<resultBean.length;index++){
				var room=resultBean[index];
				//判断改时间段改房型是否可以预订,目前只可以预订现付的房型,由于目前接口尚未更新房型状态所有注释房型状态的判断
				//if(room.payType=="2"){
				var titlleTip="title=\"预付\"";
				if(room.payType==1){
					titlleTip="title=\"现付\"";
				}
				titlleTip="";
				if(isFirst&&room.inventory!="0"){
					roomInfo+=roomHeaderStr;
					roomInfo+="<ul class=\"liboder\"><li class=\"w1\"><a class=\"zhankai1\" href=\"javascript:void doClick(this,'sear_"+code+"_"+room.code+"');\">"+room.name+"</a>"
							+"</li><li class=\"w3_new\">"+room.breakfastDesc
							+"</li><li class=\"w3_new\">"+room.netDesc
							+"</li><li class=\"w3_new\">RMB"+room.avgSalePrice
							+"</li><li class=\"w3_new\">"+"10%"
							+"</li><li class=\"w3_new\"><b class=\"colordb\">RMB"+room.rateList[0].salePrice+"</b>"
							+"</li><li class=\"w3_new\">"+"<a "+titlleTip+"href=\"javascript:void bookHotelRoom('"+code+"','"+room.roomPlanCode+"');\">"
							+"<img src=\""+CTX+"/web/images/yd.jpg\" style=\"padding-right: 20px;\"/></a>"
							+"</li></ul></div>"
							+"<div style=\"display:none;\" id=\"sear_"+code+"_"+room.code+"\" class=\"jdlistxx\">"+
							+"<img>房间面积:"+"0"
							+"平米;早餐类型:"+room.breakfastDesc
							+";床型:"+room.bedName
							+";床型描述:"+""
							+";宽带类型:"+room.netDesc
							+";宽带描述:"+""
							+";有线宽带:"+""
							+";房间设施:"+""
							+"</br><b class=\"colorff3\">取消规则;</b>入住当天的18:00之前可以取消;</div>";
					isFirst=false;
				}else if(room.inventory!="0"){
					roomInfoHide+="<div style=\"display: none;\" name=\"hotelCode_"+code+"\"><div class=\"jdlist1 automargin\"><ul class=\"liboder\"><li class=\"w1\"><a class=\"zhankai1\" href=\"javascript:void doClick(this,'sear_"+code+"_"+room.code+"');\">"+room.name+"</a>"
							+"</li><li class=\"w3_new\">"+room.breakfastDesc
							+"</li><li class=\"w3_new\">"+room.netDesc
							+"</li><li class=\"w3_new\">RMB"+room.avgSalePrice
							+"</li><li class=\"w3_new\">"+"10%"
							+"</li><li class=\"w3_new\"><b class=\"colordb\">RMB"+room.rateList[0].salePrice+"</b>"
							+"</li><li class=\"w3_new\">"+"<a "+titlleTip+" href=\"javascript:void bookHotelRoom('"+code+"','"+room.roomPlanCode+"');\">"
							+"<img src=\""+CTX+"/web/images/yd.jpg\" style=\"padding-right: 20px;\"/></a>"
							+"</li></ul></div>"
							+"<div style=\"display:none;\" id=\"sear_"+code+"_"+room.code+"\" class=\"jdlistxx\">"+
							+"<img>房间面积:"+"0"
							+"平米;早餐类型:"+room.breakfastDesc
							+";床型:"+room.bedName
							+";床型描述:"+""
							+";宽带类型:"+room.netDesc
							+";宽带描述:"+""
							+";有线宽带:"+""
							+";房间设施:"+""
							+"</br><b class=\"colorff3\">取消规则;</b>入住当天的18:00之前可以取消;</div></div>";
				}
				//}
			}
			
			if(!roomInfo){
				roomHeader.html("抱歉!该酒店目前没有可以预订的房型");
			}else {
				roomHeader.html(roomInfo);
				roomInfoHide+="<div  class=\"jdlist2 automargin\"><a style=\"padding-left: 20px; padding-right: 20px;\" id=\"pricebutton_"+code+"\" class=\"jp_qbjg\" href=\"javascript:showAllRooms('"+code+"');\">查看全部价格</a> &nbsp;&nbsp;</div>";
				roomHeader.after(roomInfoHide);
			}
		}
	}else{
		roomHeader.html("抱歉!该酒店的房型信息查询失败");
	}
	hotelDiv=null;code=null;jsonData=null;
}

function bookHotelRoom(hotelCode,roomPlanCode){
	var url=CTX+"/hotel/book.jsp";
	var currentIdate=$("#currentIdate").val();
	var currentOdate=$("#currentOdate").val();
	var currentCity=$("#currentCity").val();
	url+="?hcode="+hotelCode+"&roomPlanCode="+roomPlanCode+"&idate="+currentIdate+"&odate="+currentOdate+"&city="+currentCity;
	window.location.href=url;
}
//对房型进行排序
function sortRoomByPrice(a,b){
	return parseInt(a.price)-parseInt(b.price);
}






