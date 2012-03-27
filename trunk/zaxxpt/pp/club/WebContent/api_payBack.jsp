<%@ page pageEncoding="UTF-8"%>

<%@ include file="/common/include/tags-lib.jsp"%>

<%
//System.out.println("====payBack==");
  Object obj=request.getParameter("trade_no");
  if(obj!=null){
  	//System.out.println("======"+String.valueOf(obj));
  }
  
   Object orderId=request.getParameter("orderId");
  if(orderId!=null){
  	//System.out.println("orderId========="+String.valueOf(orderId));
  }
 %>
${trade_no}
${orderId}
