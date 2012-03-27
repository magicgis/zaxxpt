<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.flight.weather.WeatherVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.WeatherResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.WeatherRequestMessage"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="org.apache.commons.logging.LogFactory"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%
Log log = (Log) LogFactory.getLog("weatherAjax.jsp");
String weatherCode = request.getParameter("weatherCode");
String returnWeatherCode = request.getParameter("returnWeatherCode");
String weatherType = request.getParameter("weatherType");
String cityCodeType=request.getParameter("cityCodeType");
if(StringUtils.isEmpty(cityCodeType)){
	cityCodeType="H";
}
WeatherVo deCityWeatherVo = new WeatherVo();
WeatherVo arCityWeatherVo = new WeatherVo();
if(StringUtils.isEmpty(weatherType)){
	weatherType="H";
}
try{
WeatherRequestMessage weatherRequestMessage = new WeatherRequestMessage();
if("F".equals(weatherType)){
	if(StringUtils.isEmpty(weatherCode)){
		weatherCode = "PEK";		
	}
	if(StringUtils.isEmpty(returnWeatherCode)){
		returnWeatherCode = "SHA";
	}
	weatherRequestMessage.setDeCity(weatherCode);
	weatherRequestMessage.setArCity(returnWeatherCode);
	weatherRequestMessage.setType(cityCodeType);
}
if("H".equals(weatherType)){
	if(StringUtils.isEmpty(weatherCode)){
		weatherCode = "010";
	}
	weatherRequestMessage.setDeCity(weatherCode);
	weatherRequestMessage.setArCity(weatherCode);
	weatherRequestMessage.setType(cityCodeType);
}
//发送请求并获取json字符串resultStr
String wResultStr = "";
wResultStr = weatherRequestMessage.excute();
//定义解析json的对象
WeatherResponseMessage weatherResponseMessage = new WeatherResponseMessage();
weatherResponseMessage.parseResponse(wResultStr);
deCityWeatherVo = weatherResponseMessage.getDeCityWeatherVo();
arCityWeatherVo = weatherResponseMessage.getArCityWeatherVo();
}catch(Exception e){
	log.error("天气预报错误信息："+e.getMessage());
}
%>
<%try{ %>
<%
	if(deCityWeatherVo==null||deCityWeatherVo.getCityName()==null||"null".equalsIgnoreCase(deCityWeatherVo.getCityName())){throw new Exception();}
%>
<%	
if("F".equals(weatherType)){ %>
        <div class="tq_img1">
                <div class="tq_title"><%=deCityWeatherVo.getCityName() %></div>
                <ul>
                <li class="tqli1"><span class="today">今天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=deCityWeatherVo.getNowWeatherEngName()%>.jpg" /><a href="" onclick="return false;"><%=deCityWeatherVo.getNowDeTemperature()==null?"":deCityWeatherVo.getNowDeTemperature()%></a><span><%=deCityWeatherVo.getNowWeatherName()==null?"暂无数据":deCityWeatherVo.getNowWeatherName()%></span></li>
                <li><span class="today">明天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=deCityWeatherVo.getNextWeatherEngName()%>.jpg" /><a href="#"><%=deCityWeatherVo.getNextDeTemperature()==null?"":deCityWeatherVo.getNextDeTemperature()%></a><span><%=deCityWeatherVo.getNextWeatherName()==null?"暂无数据":deCityWeatherVo.getNextWeatherName()%></span></li>
            </ul>
        </div>
        <div class="tq_img2">
                <div class="tq_title"><%=arCityWeatherVo.getCityName() %></div>
                <ul>
                <li class="tqli1"><span class="today">今天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=arCityWeatherVo.getNowWeatherEngName()%>.jpg" /><a href="" onclick="return false;"><%=arCityWeatherVo.getNowDeTemperature()==null?"":arCityWeatherVo.getNowDeTemperature()%></a><span><%=arCityWeatherVo.getNowWeatherName()==null?"暂无数据":arCityWeatherVo.getNowWeatherName()%></span></li>
                <li><span class="today">明天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=arCityWeatherVo.getNextWeatherEngName()%>.jpg" /><a href="" onclick="return false;"><%=arCityWeatherVo.getNextDeTemperature()==null?"":arCityWeatherVo.getNextDeTemperature()%></a><span><%=arCityWeatherVo.getNextWeatherName()==null?"暂无数据":arCityWeatherVo.getNextWeatherName()%></span></li>
            </ul>
         </div>
     <%} %>
     <%if("H".equals(weatherType)){ %>
      <div class="tq_title1"><%=deCityWeatherVo.getCityName() %></div>
        <div class="tq_img">
                <ul>
                <li class="home_tqli1"><b class="home_tabay">今天</b><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=deCityWeatherVo.getNowWeatherEngName()%>.jpg" /><A href="" onclick="return false;"><%=deCityWeatherVo.getNowDeTemperature()==null?"":deCityWeatherVo.getNowDeTemperature()%></A><span><%=arCityWeatherVo.getNowWeatherName()==null?"":arCityWeatherVo.getNowWeatherName()%></span></li>
                <li><span class="home_tabay">明天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=deCityWeatherVo.getNextWeatherEngName()%>.jpg" /><A href="" onclick="return false;" onclick="return false;"><%=deCityWeatherVo.getNextDeTemperature()==null?"":deCityWeatherVo.getNextDeTemperature()%></A><span><%=deCityWeatherVo.getNextWeatherName()==null?"":deCityWeatherVo.getNextWeatherName()%></span></li>
            </ul>
      </div>
      <%} %>
  <%}catch(Exception e){%>
  	   <div class="tq_title1">天气预报加载失败</div>
        <div class="tq_img">
                <ul>
                <li class="home_tqli1"></li>
                <li></li>
            </ul>
      </div>
  <%}%>
<script>
var count=0;
function errorLoad(temp,url){
	if(count!=0){
		temp.src=url;
		count++;
	}
}
</script>