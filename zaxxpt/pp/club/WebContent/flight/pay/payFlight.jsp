<%@page import="com.hnatourism.club.common.helper.flight.OrderFlightDetailResponseMessage"%>
<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<%@page import="com.hnatourism.club.personal.member.web.vo.MemberInfoVo"%>
<%@page import="com.hnatourism.club.common.helper.flight.OrderFlightDetailRequestMessage"%>
<%@page import="com.hnatourism.club.flight.service.PayFlightServiceImpl"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightCallBackRequestMessage"%>
<%@page import="com.hnatourism.club.common.helper.flight.FlightCallBackResponseMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.framework.utils.PropertiesUtils"%>
<%@page import="com.hnatourism.club.common.util.Md5Encrypt"%>
<%@page import="com.hnatourism.framework.utils.BeanUtils"%>
<%
// String ip =PropertiesUtils.getVal("sysProps","service_ip");
//获取用户信息
MemberInfoVo memberInfoVo=UserUtil.getUser(request.getSession().getId());

OrderFlightDetailRequestMessage orderFlightDetailRequestMessage = new OrderFlightDetailRequestMessage();
OrderFlightDetailResponseMessage orderFlightDetailResponseMessage = new OrderFlightDetailResponseMessage();
String orderId = request.getParameter("orderId");
try {
	if(!StringUtils.isEmpty(orderId)){
		orderFlightDetailRequestMessage.setOrderId(orderId);
	}
	//发送请求并获取json字符串resultStr
	String resultStr = "";
	resultStr = orderFlightDetailRequestMessage.excute();
	//resultStr="{\"result\": {\"resultCode\":\"\",\"message\":\"\"},\"orderId\":\"629bb24326a148b78210299dd70e31c1\",\"code\":\"013671980\",\"createTime\":\"2011/08/25\",\"totalMoney\":\"3615\",\"actualMoney\":\"3615\",\"sts\":\"02\",\"payType\":\"netbank\",\"paySts\":\"0\",\"flightType\":\"1\",\"outBookingFlight\":{\"depAirportCode\":\"PEK\",\"depAirportCN\":\"北京首都\",\"arrAirportCode\":\"CAN\",\"arrAirportCN\":\"广州\",\"airlineCompany\":\"南航\",\"airlineCompanyCode\":\"CZ\",\"pnr\":\"JFC4JJ\",\"cabinRule\":\"一、更改条件：同等舱位免费更改。二、退票条件：需收取票面价5％的退票费。三、签转条件：不得签转。   \",\"flightNo\":\"3108\",\"cabinCode\":\"P\",\"cabinPrice\":\"3298\",\"deStop\":\"null\",\"arStop\":\"null\",\"cabinCN\":\"经济舱\",\"departureDate\":\"2011/09/09\",\"departureTime\":\"08:30\",\"arrivalTime\":\"11:45\"},\"flightPassenger\":[{\"passengerId\":\"254b0871467640e591813e36072e8aef\",\"name\":\"田永刚\",\"type\":\"01\",\"certType\":\"0\",\"certNo\":\"325556556565656565\",\"etNo\":\"null\",\"ticketSts\":\"00\",\"ticketPrice\":\"3400\",\"bafPrice\":\"150\",\"constructionPrice\":\"50\"}],\"rmk\":\"asdfasdf\",\"contact\":{\"name\":\"田永刚测试\",\"phone\":\"15210826379\",\"email\":\"dfdf@sdf.com\"},\"itinerary\":{\"address\":\"sdfasdf\",\"city\":\"100000001634\",\"deliveryType\":\"1\",\"deliveryFee\":\"15\",\"mobile\":\"15200000000\",\"postcode\":\"134561\",\"catchUser\":\"asdfasd\"}}";
	System.out.println(resultStr);
	//定义解析json的对象
	orderFlightDetailResponseMessage.parseResponse(resultStr);
} catch (Exception e) {
	e.printStackTrace();
}
//支付开始
String updateResult = "";
String result = "";
PayFlightServiceImpl payFlightServiceImpl=(PayFlightServiceImpl)BeanUtils.getBeanObj("payFlightService");
//调支付分润
result=payFlightServiceImpl.profitPay(orderFlightDetailResponseMessage,memberInfoVo);
String flightOrgin=orderFlightDetailResponseMessage.getOutBookingFlight().getFlightOrigin();
FlightCallBackRequestMessage flightCallBackRequestMessage=new FlightCallBackRequestMessage();
FlightCallBackResponseMessage flightCallBackResponseMessage=new FlightCallBackResponseMessage();
if("SUCCESS".equals(result)){
	if(!"GW".equals(flightOrgin)){
		flightCallBackRequestMessage.setOrderCode(orderFlightDetailResponseMessage.getCode());
		flightCallBackRequestMessage.setActualPay(orderFlightDetailResponseMessage.getActualMoney());
		flightCallBackRequestMessage.setMemberId(memberInfoVo.getId());
		flightCallBackRequestMessage.setPayFlag("true");
	}else{
		flightCallBackRequestMessage.setOrderCode(orderFlightDetailResponseMessage.getCode());
		flightCallBackRequestMessage.setActualPay(orderFlightDetailResponseMessage.getActualMoney());
		flightCallBackRequestMessage.setMemberId(memberInfoVo.getId());
		flightCallBackRequestMessage.setPayFlag("false");
	}
	//支付成功后回调接口修改状态
	updateResult=flightCallBackRequestMessage.excute();
	flightCallBackResponseMessage.parseResponse(updateResult);
}else{
%>
	<script type="text/javascript">
	alert("非常抱歉，您的订单支付失败。");
	window.location="${ctx}/flight/order/orderFlightDetail.jsp?orderId=<%=orderFlightDetailResponseMessage.getOrderId()%>";
	</script>
<%
}
if(!StringUtils.isEmpty(flightCallBackResponseMessage.getResultCode())){
%>
<script>
	alert("非常抱歉，您的订单支付失败!");
<%
}
%>
window.location="${ctx}/flight/order/orderFlightDetail.jsp?orderId=<%=orderFlightDetailResponseMessage.getOrderId()%>";
</script>
