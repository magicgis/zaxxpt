﻿<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<s:if test="errorInfo!=null">
<tr><td colspan="7" align="center">${errorInfo}<input type="hidden" value="true" id="isLoadError0"></td></tr>
</s:if>
<s:else>
<%--				<ul class="order_slc">--%>
<%--                        <li style="float:left;">--%>
<%--                            <select name="language" id="selectDat">--%>
<%--                                <option selected="selected" value="1">最近一周订单</option>--%>
<%--                                <option value="2">最近一个月订单</option>--%>
<%--                                <option value="3">最近三个月订单</option>--%>
<%--                                <option value="4">最近一年订单</option>--%>
<%--                            </select>--%>
<%--                            <select name="language">--%>
<%--                                <option selected="selected">申退票</option>--%>
<%--                                <option>普通预订票</option>--%>
<%--                            </select>--%>
<%--                            <select name="language" id="selectSts">--%>
<%--                                <option selected="selected" value="00">等待支付</option>--%>
<%--                                <option value="01">等待出票</option>--%>
<%--                                <option value="02">出票成功</option>--%>
<%--                                <option value="04">已取消</option>--%>
<%--                                <option value="03">出票失败</option>--%>
<%--                                <option value="07">申请失败</option>--%>
<%--                                <option value="06">申请成功</option>--%>
<%--                                <option value="05">申请中</option>--%>
<%--                            </select>--%>
<%--                            <input name="" value=" 查询 " type="button" onclick="slit()"/>--%>
<%--                        </li>--%>
<%--                        <%--%>
<%--                                	int x = 0;--%>
<%--                        %>--%>
<%--                        <c:forEach items="${flightOrders}" var="fon" >--%>
<%--                        	<c:if test="${fon.sts eq '00'}">--%>
<%--                                <%--%>
<%--                                	x++;--%>
<%--                                %>--%>
<%--                            </c:if>--%>
<%--                        </c:forEach>--%>
<%--                        <li style="float:right;"><span style="color:#F60;">提示：有&nbsp;<strong style="color:#F00; font-size:14px; font-weight:bold"><%=x%></strong>&nbsp;笔未支付订单</span></li>--%>
<%--                    </ul>--%>
<%--                    <li style="float:right;"><span style="color:#F60;">提示：有&nbsp;<strong style="color:#F00; font-size:14px; font-weight:bold"><%=x%></strong>&nbsp;笔未支付订单</span></li>--%>
<%--                    <table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 User_Center">--%>
<%--                        <tbody id="tbodyR">--%>
<%--                            <tr id="trTitle">--%>
<%--                                <th width="100">&nbsp;&nbsp;&nbsp;&nbsp;订单号</th>--%>
<%--                                <th width="83">行程</th>--%>
<%--                                <th width="96">预订日期</th>--%>
<%--                                <th width="50">类型</th>--%>
<%--                                <th width="51">总价</th>--%>
<%--                                <th width="80">订单类型</th>--%>
<%--                                <th width="88">订单状态</th>--%>
<%--                                <th width="73">操作</th>--%>
<%--                            </tr>--%>
						   <%int x = 0; %>
                           <c:forEach items="${flightOrders}" var="fo" >
                            <tr name="orderName">
<%--                                <input type="hidden" name="stsName" value="${fo.sts}" />--%>
<%--                                <input type="hidden" name="datName" value="${fo.createTime}" />--%>
                                <td align="center"><a href="${ctx}/flight/order/orderFlightDetail.jsp?orderId=${fo.orderId}" class="linkBlue">${fo.code}</a>
                                <input type="hidden" name="sts" value="${fo.sts}" />
                                <input type="hidden" name="createTime" value="${fo.createTime}" />
                                </td>
                                <td>${fo.depAirportCode}</br>
                                ${fo.arrAirportCode}</td>
                                <td>${fo.createTime}</td>
                                <c:if test="${fo.type eq '1'}">
                                <td>单程</td>
                                </c:if>
                                <c:if test="${fo.type eq '2'}">
                                <td>往返</td>
                                </c:if>
                                <td class="red">${fo.totalMoney}</td>
                                <td class="green">预订订单</td>
                                <c:if test="${fo.sts eq '00'}">
                                	<td>等待支付</td>
                                	<%x++;%>
                                </c:if>
                                <c:if test="${fo.sts eq '01'}">
                                	<td>等待出票</td>
                                </c:if>
                                <c:if test="${fo.sts eq '02'}">
                                	<td>出票成功</td>
                                </c:if>
                                <c:if test="${fo.sts eq '03'}">
                                	<td>出票失败</td>
                                </c:if>
                                <c:if test="${fo.sts eq '04'}">
                                	<td>已取消</td>
                                </c:if>
                                <c:if test="${fo.sts eq '05'}">
                                	<td>申请中</td>
                                </c:if>
                                <c:if test="${fo.sts eq '06'}">
                                	<td>申请成功</td>
                                </c:if>
                                <c:if test="${fo.sts eq '07'}">
                                	<td>申请失败</td>
                                </c:if>
                                <c:if test="${fo.sts eq '00'}">
                                <td><input type="button" class="Btn63_24" value="付 款" onclick="javascript:window.location='${ctx}/flight/pay/payFlight.jsp?orderId=${fo.orderId}'"/>
                                    <br />
                                    <a class="link12" href="${ctx}/flight/order/orderFlightDetail.jsp?orderId=${fo.orderId}">查看</a>｜<a id="${fo.orderId},${fo.code}" onclick="form1(this);" style="cursor:pointer;color:#FF0000">取消</a>
                                </td>
                                </c:if>
                                <c:if test="${fo.sts ne '00' && fo.sts ne '05'}">
                                <td><input type="button" class="Btn63_24" value="付 款" disabled="disabled" style="color: silver;"/>
                                    <br />
                                    <a class="link12" href="${ctx}/flight/order/orderFlightDetail.jsp?orderId=${fo.orderId}">查看</a>｜取消
                                </td>
                                </c:if>
                                <c:if test="${fo.sts eq '05'}">
                                <td><input type="button" class="Btn63_24" value="付 款" disabled="disabled" style="color: silver;"/>
                                	<br />
                                	<a class="link12" href="${ctx}/flight/order/orderFlightDetail.jsp?orderId=${fo.orderId}">查看</a>｜<a id="${fo.orderId},${fo.code}" onclick="form1(this);" style="cursor:pointer;color:#FF0000">取消</a>
                                </td>
                                </c:if>
                            </tr>
                            </c:forEach>    
<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                    <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>--%>
<%--                   <c:forEach items="${flightOrders}" var="fon" >--%>
<%--                        	<c:if test="${fon.sts eq '00'}">--%>
<%--                                <%x++;%>--%>
<%--                            </c:if>--%>
<%--                    </c:forEach>--%>
					<%--    存放未支付订单数量 	author lixun--%>
					<input type="hidden" value="<%=x%>" id="notPaymentOrderAmount0"/>
	
<script>
function form1(str){
	var result = window.confirm("确定取消订单？？");
	if(result==true){
		var id = str.id.split(",")[0];
		var code = str.id.split(",")[1];
		window.location.href="${ctx}/flight/cancelFlight/cancelOrderResult.jsp?orderId="+id+"&orderCode="+code;
		return true;
	}else{
		return false;
	}
}
//add wuyuhu
/*
var orderArr=$("tr[name='orderName']");
function slit(){
	var dat=$("#selectDat").val();
	var sts=$("#selectSts").val();
	var content="<tr>"+$("#tbodyR").find("tr").eq(0).html()+"</tr>";
	var datB = new Date();
	datB.setMonth(datB.getMonth()+1);
	if(dat == 1){
	datB.setDate(datB.getDate()-7);
	}
	if(dat == 2){
	 datB.setMonth(datB.getMonth()-1);
	}
	if(dat == 3){
	datB = datB.setMonth(datB.getMonth()-3);
	}
	if(dat == 4){
	datB.setFullYear(datB.getFullYear()-1);
	}
	
	orderArr.each(function(i){
	var slitSts=false;
	var slitDate=false;
	var stsStr=$(this).find("input[name='stsName']").val();
	var datStr=$(this).find("input[name='datName']").val();
	var dateStr = new Date(datStr.split("-").join("/"));
	dateStr.setMonth(dateStr.getMonth()+1);
	//状态
	if(sts == stsStr){
	slitSts=true;
	}
	//时间
	if(dateStr>datB){
	slitDate=true;
	}
	if(slitSts && slitDate){
	content+="<tr>"+$(this).html()+"</tr>";
	}
	});
	$("#tbodyR").html(content);
	initTable($("#flightTableDivId"));
}*/
</script>
</s:else>