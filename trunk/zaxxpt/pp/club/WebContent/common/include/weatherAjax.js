/**
*异步加载天气预报
* author lixun  
* createdate  2011-9-15 
*/

/**
 * boxSelector 容器选择器
 * cityCode  可以为城市编码或者三字码,具体类型关联关系取决于cityCodeType
 * returnCityCode 返回城市编码,机票会用
 * type  F则为出发+返回     H 为单个城市 (机票类型F具有两个城市的天气,酒店类型H只有一个城市的天气)
 * cityCodeType  城市码类型    F 为三字码   H  为城市编码
 * 
 */
function loadWeatherAjax(boxSelector,cityCode,returnCityCode,type,cityCodeType){
 		var box=$(boxSelector);
 		if(!cityCode){
 			cityCode="010";
 		}
 		if(!returnCityCode){
 			returnCityCode="020";
 		} 	
 		if(!type){
 			type="H";
 		}
 		if(!cityCodeType){
 			cityCodeType="H";
 		}
 		//可以换成图片
 		box.html("天气预报加载中...");
 		var requestUrl=ctxValue+"/common/include/weatherAjax.jsp?weatherCode="+cityCode+"&&returnWeatherCode="+returnCityCode+"&&weatherType="+type+"&&cityCodeType="+cityCodeType;
 		$.ajax({
 			type: "POST",
 			url: requestUrl,
 			dataType: "html",
 			success: function(data){
 				box.html(data);
 			}
 		});
}

