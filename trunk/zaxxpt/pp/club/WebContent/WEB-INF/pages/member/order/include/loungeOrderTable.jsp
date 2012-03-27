<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<s:if test="errorInfo!=null">
<tr><td colspan="7" align="center">${errorInfo }<input type="hidden" value="true" id="isLoadError3"></td></tr>
</s:if>
<s:else>
<%--                    <ul class="order_slc">--%>
<%--                        <li style="float:left;">--%>
<%--                            <select name="language" id="loungeQueryTime">--%>
<%--                                <option  value="1">最近一周订单</option>--%>
<%--                                <option value="2">最近一个月订单</option>--%>
<%--                            </select>--%>
<%--                            <f:select type="机场休息室订单状态" value="${sts}" id="loungeQuerySts" showValue="false" blank="true"></f:select>--%>
<%--                            <input name="" value="查询 " type="button" id="queryLoungeOrder"/>--%>
<%--                        </li>--%>
<%--<!--                        <li style="float:right;">-->--%>
<%--<!--                        	<span style="color:#F60;">提示：有&nbsp;-->--%>
<%--<!--                        		<strong style="color:#F00; font-size:14px; font-weight:bold">1</strong>-->--%>
<%--<!--                        		&nbsp;笔未支付订单-->--%>
<%--<!--                        	</span>-->--%>
<%--<!--                        </li>-->--%>
<%--                    </ul>--%>
<%--                    <table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 User_Center">--%>
<%--                        <tbody>--%>
<%--                            <tr>--%>
<%--                                <th>&nbsp;&nbsp;&nbsp;&nbsp;订单号</th>--%>
<%--                                <th>休息室名称</th>--%>
<%--                                <th>休息室类型</th>--%>
<%--                                <th>下单时间</th>--%>
<%--                                <th>金额</th>--%>
<%--                                <th>订单状态</th>--%>
<%--                                <th>消费状态</th>--%>
<%--                                <th width="63">--%>
<%--                                	管理--%>
<%--                                <input type="hidden" name="sts" value="0"/>--%>
<%--                               	<input type="hidden" name="createTime" value="1970-01-01"/>--%>
<%--                                </th>--%>
<%--                            </tr>--%>
							<%int x = 0; %>
                            <s:iterator value="loungeOrders">
                            <tr>
                                <td align="center"><a href="${ctx}/loungeOrderAction!viewOrderDetail.action?id=${id}"><s:property value="code"></s:property></a></td>
                                <td><s:property value="loungeName" escape="false"></s:property></td>
                                <td><f:write type="休息室类型" value="${loungeType}"></f:write></td>
                                <td><s:date name="createTime" format="yyyy-MM-dd"/><br />
                                    <s:date name="createTime" format="HH:mm"/>
                                </td>
                                <td><s:property value="price"></s:property></td>
                                <td class="red"><f:write type="机场休息室订单状态" value="${sts}"/><br />
                                	<c:if test="${sts eq '1'}"><%x++;%></c:if>
                                    <a class="Order_Track" href="javascript:void(0);" name="${id}" onclick="return false;" >订单跟踪</a>
                                </td>
                                <td><f:write type="订单消费状态" value="${consumerSts}"/></td>
                                <td>
                                	<a class="link12" href="${ctx}/loungeOrderAction!viewOrderDetail.action?id=${id}" target="_blank">查看详情</a>
                                	<br />
                                    <a class="link12 Order_TG" href="javascript:void(0);"  name="${id}" onclick="return false;" >退改订单</a>
                               		 <input type="hidden" name="sts" value="${sts}"/>
                               		 <input type="hidden" name="createTime" value="<s:date name="createTime" format="yyyy-MM-dd"/>"/>
                                </td>
                            </tr>
                            </s:iterator>
                            <input type="hidden" value="<%=x%>" id="notPaymentOrderAmount3"/>
<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                    <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>--%>
</s:else>