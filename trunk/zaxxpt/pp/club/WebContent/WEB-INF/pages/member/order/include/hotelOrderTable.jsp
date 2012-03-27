<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<s:if test="errorInfo!=null">
<tr><td  colspan="7" align="center">${errorInfo }<input type="hidden" value="true" id="isLoadError1"></td></tr>
</s:if>
<s:else>
	<%int x = 0; %>
	<s:iterator value="#request.hotelOrders">
	     <tr>
	         <td align="center"><a href="${ctx}/hotelOrderAction!viewDetails.action?code=<s:property value="code"/>"><s:property value="code"/></a></td>
	         <td><s:property value="hname"/><br /><s:property value="rname"/></td>
	         <td><s:property value="idate"/><br /><s:property value="odate"/></td>
	         <td><s:property value="bookTime"/><br /><s:property value="name"/></td>
	         <td><span class="red"><s:property value="totalMoney"/></span> <br /><s:property value="pnames"/></td>
	         <td class="green">                        
               	<s:if test="sts=='SP_DQR'">
               	下单成功
               	</s:if>
               	<s:elseif test="sts=='SP_YJJ'">
               	已取消
               	</s:elseif>
               	<s:elseif test="sts=='SP_YQR'">
               	预订成功
               	</s:elseif>
               	<s:else>
               		<f:write type="酒店订单状态" value="${sts}"></f:write>
               	</s:else>
             </td>
	       	 <td>
	       	 	<f:write type="酒店订单支付状态" value="${paySts}"></f:write>
	       	 	 <c:if test="${paySts eq 'WZF'}"><%x++;%></c:if>
	       	 </td>
	         <td>
	         	<a href="${ctx}/hotelOrderAction!viewDetails.action?code=<s:property value="code"/>" target="_blank">查看详情</a><br />
	         	<s:if test="sts =='XD'||sts =='SP_DQR'
						||(sts=='YQR'&&hotelOrderDetailsVo.paySts=='YZF')
						||(sts=='SP_YQR'&&hotelOrderDetailsVo.paySts=='YZF')">
				<a href="javascript:void(0);" onclick="cancel('<s:property value="code"/>')">取消</a></s:if>
	         	<s:else><a><font color="gray">取消</font></a></s:else>
	         	<input type="hidden" name="bookTime" value="<s:property value="bookTime"/>">
	         	<s:if test="sts=='SP_DQR'">
               	<input type="hidden" name="sts" value="DQR">
               	</s:if>
               	<s:elseif test="sts=='SP_YJJ'">
               	<input type="hidden" name="sts" value="SC">
               	</s:elseif>
               	<s:elseif test="sts=='SP_YQR'">
               	<input type="hidden" name="sts" value="YQR">
               	</s:elseif>
               	<s:else>
               		<input type="hidden" name="sts" value="<s:property value="sts"/>">
               	</s:else>
	         </td>
	     </tr>
    </s:iterator> 
    <input type="hidden" value="<%=x%>" id="notPaymentOrderAmount1"/>                           
<script type="text/javascript">
//<![CDATA[
//取消
function cancel(code){
	if(window.confirm("您确定要取消该订单吗?")){
		var url="${ctx}/hotelOrderAction!cancelOrder.action?code="+code;
		window.location=url;
	}
}
//]]>
</script>
</s:else>