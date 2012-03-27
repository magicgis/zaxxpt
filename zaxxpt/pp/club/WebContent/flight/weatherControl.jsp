<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.flight.weather.WeatherVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.WeatherResponseMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.WeatherRequestMessage"%>

<%
Log log = (Log) LogFactory.getLog("weatherControl.jsp");
WeatherVo deCityWeatherVo = new WeatherVo();
WeatherVo arCityWeatherVo = new WeatherVo();
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
	weatherRequestMessage.setType(weatherType);
}
if("H".equals(weatherType)){
	if(StringUtils.isEmpty(weatherCode)){
		weatherCode = "010";
	}
	weatherRequestMessage.setDeCity(weatherCode);
	weatherRequestMessage.setArCity(weatherCode);
	weatherRequestMessage.setType(weatherType);
}
//发送请求并获取json字符串resultStr
String wResultStr = "";
long a = System.currentTimeMillis();
wResultStr = weatherRequestMessage.excute();
long b = System.currentTimeMillis();
System.out.println("天气预报用时："+(b-a));
//定义解析json的对象
WeatherResponseMessage weatherResponseMessage = new WeatherResponseMessage();
weatherResponseMessage.parseResponse(wResultStr);
deCityWeatherVo = weatherResponseMessage.getDeCityWeatherVo();
arCityWeatherVo = weatherResponseMessage.getArCityWeatherVo();
}catch(Exception e){
	log.error("天气预报错误信息："+e.getMessage());
}
%>

<%@page import="org.apache.commons.logging.Log"%>
<%@page import="org.apache.commons.logging.LogFactory"%>
<%if("F".equals(weatherType)){ %>
<div class="tq_box1">
        <div class="tq_img1">
                <div class="tq_title"><ap:write key="<%=weatherCode%>" isDisplayCity="true"></ap:write></div>
                <ul>
                <li class="tqli1"><span class="today">今天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=deCityWeatherVo==null?"":deCityWeatherVo.getNowWeatherEngName()%>.jpg" />
                <a href="#"><%=deCityWeatherVo==null||deCityWeatherVo.getNowDeTemperature()==null||"null".equals(deCityWeatherVo.getNowDeTemperature())?"":deCityWeatherVo.getNowDeTemperature()%></a>
                <span><%=deCityWeatherVo==null||deCityWeatherVo.getNowWeatherName()==null||"null".equals(deCityWeatherVo.getNowWeatherName())?"暂无数据":deCityWeatherVo.getNowWeatherName()%></span></li>
                <li><span class="today">明天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=deCityWeatherVo==null?"":deCityWeatherVo.getNextWeatherEngName()%>.jpg" />
                <a href="#"><%=deCityWeatherVo==null||deCityWeatherVo.getNextDeTemperature()==null||"null".equals(deCityWeatherVo.getNextDeTemperature())?"":deCityWeatherVo.getNextDeTemperature()%></a>
                <span><%=deCityWeatherVo==null||deCityWeatherVo.getNextWeatherName()==null||"null".equals(deCityWeatherVo.getNextWeatherName())?"暂无数据":deCityWeatherVo.getNextWeatherName()%></span></li>
            </ul>
            </div>
            
        <div class="tq_img2">
                <div class="tq_title"><ap:write key="<%=returnWeatherCode%>" isDisplayCity="true"></ap:write></div>
                <ul>
                <li class="tqli1"><span class="today">今天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=arCityWeatherVo==null?"":arCityWeatherVo.getNowWeatherEngName()%>.jpg" />
                <a href="#"><%=arCityWeatherVo==null||arCityWeatherVo.getNowDeTemperature()==null||"null".equals(arCityWeatherVo.getNowDeTemperature())?"":arCityWeatherVo.getNowDeTemperature()%></a>
                <span><%=arCityWeatherVo==null||arCityWeatherVo.getNowWeatherName()==null||"null".equals(arCityWeatherVo.getNowWeatherName())?"暂无数据":arCityWeatherVo.getNowWeatherName()%></span></li>
                <li><span class="today">明天</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=arCityWeatherVo==null?"":arCityWeatherVo.getNextWeatherEngName()%>.jpg" />
                <a href="#"><%=arCityWeatherVo==null||arCityWeatherVo.getNextDeTemperature()==null||"null".equals(arCityWeatherVo.getNextDeTemperature())?"":arCityWeatherVo.getNextDeTemperature()%></a>
                <span><%=arCityWeatherVo==null||arCityWeatherVo.getNextWeatherName()==null||"null".equals(arCityWeatherVo.getNextWeatherName())?"暂无数据":arCityWeatherVo.getNextWeatherName()%></span></li>
            </ul>
            </div>
           
    </div>
    </div>
     <%} %>
     <%if("H".equals(weatherType)){ %>
    <div class="tq_box">
        <div class="tq_title1"><p:write key="<%=weatherCode%>"></p:write></div>
        <div class="tq_img">
                <ul>
                <li class="home_tqli1"><b class="home_tabay">今天(周一)</b><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=deCityWeatherVo.getNowWeatherEngName()%>.jpg" /><A href="#"><%=deCityWeatherVo.getNowDeTemperature()==null?"":deCityWeatherVo.getNowDeTemperature()%></A><span><%=arCityWeatherVo.getNowWeatherName()==null?"":arCityWeatherVo.getNowWeatherName()%></span></li>
                <li><span class="home_tabay">明天(周二)</span><img onerror="errorLoad(this,'${ctx}/web/images/weather/weather-loading.gif')" src="${ctx}/web/images/weather/<%=deCityWeatherVo.getNextWeatherEngName()%>.jpg" /><A href="#"><%=deCityWeatherVo.getNextDeTemperature()==null?"":deCityWeatherVo.getNextDeTemperature()%></A><span><%=deCityWeatherVo.getNextWeatherName()==null?"":deCityWeatherVo.getNextWeatherName()%></span></li>
            </ul>
      </div>
      <%} %>
<script>
function errorLoad(temp,url){
temp.src=url;
}
</script>