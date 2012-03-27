<%@ page pageEncoding="UTF-8"%>
<%@include file="/common/include/tags-lib.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
var　options = {　   
	　　　　  url:'weatherAction!searchWeather.action',
	　　　　  type:'POST',
	　　　　　success:function(data) {
	             if (null != data) {
		               if(data != "N"){
							var json = data.split("|");
							var citya = json[0];
							var cityb = json[1];
							if(citya != null && citya!="null"){
								var cityaIndex = citya.indexOf("\"");
								if(cityaIndex>=0){
									citya=citya.substring(cityaIndex+1,citya.length);
								}
								var weathera = citya.split("*");
								if(weathera.length>=3){
									var weatheraNow = weathera[1].split(" ");
									var weatheraNext = weathera[2].split(" ");
									//$("#citya").html(weathera[0]);   
									$("#weatheraNowImg").attr("src","images/b2cImg/frimages/weather/"+weatheraNow[1]+".jpg");
									$("#temperatureaNow").html(weatheraNow[3]);
									$("#weatheraNow").html(weatheraNow[2]);
									$("#weatheraNextImg").attr("src","images/b2cImg/frimages/weather/"+weatheraNext[1]+".jpg");
									$("#temperatureaNext").html(weatheraNext[3]);
									$("#weatheraNext").html(weatheraNext[2]);
								}
							}
							if(cityb != null && cityb!="null"){
								var weatherb = cityb.split("*");
								if(weatherb.length>=3){
									var weatherbNow = weatherb[1].split(" ");
									var weatherbNext = weatherb[2].split(" ");
									//$("#cityb").html(weatherb[0]);  
									$("#weatherbNowImg").attr("src","images/b2cImg/frimages/weather/"+weatherbNow[1]+".jpg");
									$("#temperaturebNow").html(weatherbNow[3]);
									$("#weatherbNow").html(weatherbNow[2]);
									$("#weatherbNextImg").attr("src","images/b2cImg/frimages/weather/"+weatherbNext[1]+".jpg");
									$("#temperaturebNext").html(weatherbNext[3]);
									$("#weatherbNext").html(weatherbNext[2]);
								}
							}
		               }
		               else{
		               		//alert("预订发生异常");
		               }
           		}
	         }　//显示操作提示
　　  };
$('#weatherForm').ajaxSubmit(options);
});
</script> 
<div class="searchboxmr">
   <div>
     <h3 id="citya">
       <c:if test="${weatherVo.prodType eq null}">
    	 北京市
     </c:if>
     <c:if test="${weatherVo.prodType eq 'F'}"><ap:write key="${qryDepartureAirportCode}" isDisplayCity="true"></ap:write></c:if>
     <c:if test="${weatherVo.prodType eq 'H'}"><p:write key="${hotelQryVo.city}"></p:write></c:if>
     </h3>
     <p>今天<img onerror="errorLoad(this,'images/b2cImg/frimages/weather/weather-loading.gif')" width="55" height="38" id="weatheraNowImg" src="images/b2cImg/frimages/weather/weather-loading.gif"/>
     	<span class="temperature" id="temperatureaNow"></span><span class="weather" id="weatheraNow"></span></p>
     <p>明天<img onerror="errorLoad(this,'http://${domain}/images/b2cImg/frimages/weather/weather-loading.gif')" width="55" height="38" id="weatheraNextImg" src="images/b2cImg/frimages/weather/weather-loading.gif"/>
     	<span class="temperature" id="temperatureaNext"></span><span class="weather" id="weatheraNext"></span></p>
   </div>
   <div>
     <h3 id="cityb">
      <c:if test="${weatherVo.prodType eq null || weatherVo.prodType eq 'H'}">
		上海市    
     </c:if>
     <c:if test="${weatherVo.prodType eq 'F'}">
     <ap:write key="${qryArrivalAirportCode}" isDisplayCity="true"></ap:write>
     </c:if>
     </h3>
     <p>今天<img onerror="errorLoad(this,'images/b2cImg/frimages/weather/weather-loading.gif')" width="55" height="38" id="weatherbNowImg" src="images/b2cImg/frimages/weather/weather-loading.gif"/>
     	<span class="temperature" id="temperaturebNow"></span><span class="weather" id="weatherbNow"></span></p>
     <p>明天<img  onerror="errorLoad(this,'images/b2cImg/frimages/weather/weather-loading.gif')" width="55" height="38" id="weatherbNextImg" src="images/b2cImg/frimages/weather/weather-loading.gif"/>
     	<span class="temperature" id="temperaturebNext"></span><span class="weather" id="weatherbNext"></span></p>
   </div>
 </div>

<form action="" id="weatherForm" method="POST"> 
<c:if test="${weatherVo.prodType eq 'F'}">
<input type="hidden" name="weatherVo.citya" id="weatherCitya" value="<c:if test='${weatherVo.citya eq null}'>PEK</c:if><c:if test='${weatherVo.citya ne null}'>${weatherVo.citya}</c:if>">
<input type="hidden" name="weatherVo.cityb" id="weatherCityb" value="<c:if test='${weatherVo.cityb eq null}'>SHA</c:if><c:if test='${weatherVo.cityb ne null}'>${weatherVo.cityb}</c:if>">
<input type="hidden" name="weatherVo.prodType" id="weatherProdType" value="F">
</c:if>
<c:if test="${weatherVo.prodType eq 'H'}">
<input type="hidden" name="weatherVo.citya" id="weatherCitya" value="<c:if test='${weatherVo.citya eq null}'>010</c:if><c:if test='${weatherVo.citya ne null}'>${weatherVo.citya}</c:if>">
<input type="hidden" name="weatherVo.cityb" id="weatherCityb" value="<c:if test='${weatherVo.cityb eq null}'>100000002194</c:if><c:if test='${weatherVo.cityb ne null}'>${weatherVo.cityb}</c:if>">
<input type="hidden" name="weatherVo.prodType" id="weatherProdType" value="H">
</c:if>
<c:if test="${weatherVo.prodType eq null}">
<input type="hidden" name="weatherVo.citya" id="weatherCitya" value="<c:if test='${weatherVo.citya eq null}'>PEK</c:if><c:if test='${weatherVo.citya ne null}'>${weatherVo.citya}</c:if>">
<input type="hidden" name="weatherVo.cityb" id="weatherCityb" value="<c:if test='${weatherVo.cityb eq null}'>SHA</c:if><c:if test='${weatherVo.cityb ne null}'>${weatherVo.cityb}</c:if>">
<input type="hidden" name="weatherVo.prodType" id="weatherProdType" value="F">
</c:if>
</form>