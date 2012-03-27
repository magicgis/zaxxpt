<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.b2c.common.helper.protocol.HttpUtils"%>
<%@page import="com.hnatourism.b2c.common.helper.json.JSONArray"%>
<%@page import="com.hnatourism.b2c.common.helper.json.JSONObject"%>
<%@page import="com.hnatourism.b2c.common.helper.json.parser.JSONParser"%>
<%@page import="com.hnatourism.framework.utils.PropertiesUtils"%>
<%
String actualPay=request.getParameter("actualPay");
String memberId=request.getParameter("memberId");
String orderCode=request.getParameter("orderCode");
String payType=request.getParameter("payType");
String prodType=request.getParameter("prodType");

String domain=PropertiesUtils.getVal("sysProps","api_server_flight");
//domain="http://localhost:8880/B2C";
String url=domain+"/web/phone/pay/fPhonePay.jsp?actualPay="+actualPay+"&memberId="+memberId+"&orderCode="+orderCode+"&payType="+payType+"&prodType="+prodType;

//url="http://localhost:8580/B2C/web/phone/pay/fPhonePay.jsp?actualPay=1072&payType=cmsom&prodType=01&orderCode=000028410&memberId=e73928a765424c0d8796082c4d113816";
String resultStr="";
boolean success=false;
boolean hasPnr=false;
String resultCode="";
String message="";

String orderId="";
String batchNo="";
String unPayAmount="";
String payAmount="";
try{
	resultStr=HttpUtils.getJsonFromServer(HttpUtils.getConnection(url));
	if(resultStr!=null&&!resultStr.trim().equals("")){
		JSONParser parser=new JSONParser();
		JSONObject root=(JSONObject)parser.parse(resultStr);
		JSONObject result=(JSONObject)root.get("result");
		resultCode=(String)result.get("resultCode");
		message=(String)result.get("message");
		
		if("".equals(resultCode)&&"".equals(message)){
			
			String pnrFlag=(String)root.get("pnrFlag");
			if("0".equals(pnrFlag)){
				//存在PNR
				hasPnr=true;
				unPayAmount=(String)root.get("unPayAmount");
				if("0".equals(unPayAmount)){
					payAmount=(String)root.get("actualPay");
					success=true;
				}				
			}
			else if("1".equals(pnrFlag)){
				//没有舱位
			}
			else if("2".equals(pnrFlag)){
				//舱位校验超时
				message="PNR校验超时";
			}
			
		}
	}
	
	
}
catch(Exception e){
	e.printStackTrace();	
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代客下单支付结果</title>
<style type="text/css">
.red{color:#f00;font-family:verdana;}
</style>
</head>
<body>
<center>
<table cellpadding=10 style="margin-top:50px;">
<%if(success){ %>
<tr>
<td><img src="../images/b2cImg/pay/success.gif"  /></td>
<td>支付成功</td>
<td>订单号: <span class=red><%=orderCode %></span></td>
<td>订单金额: <span class=red>￥<%=actualPay %></span></td>
<td>已支付金额：<span class=red>￥<%=payAmount %></span></td>
</tr>
<%}else{ %>
<tr>
<td><img src="../images/b2cImg/pay/fail.gif"  /></td>
<td>支付失败</td>
<td>订单号: <span class=red><%=orderCode %></span></td>
<td>订单金额: <span class=red>￥<%=actualPay %></span></td>
<td>失败原因：<span class=red><%=message %></span></td>
</tr>
<%} %>
</table>
</center>
</body>
</html>