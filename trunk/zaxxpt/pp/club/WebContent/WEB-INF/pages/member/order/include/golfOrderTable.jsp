<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<s:if test="errorInfo!=null">
<tr><td colspan="8" align="center">${errorInfo }<input type="hidden" value="true" id="isLoadError2"></td></tr>
</s:if>
<s:else>
<%--                    <ul class="order_slc">--%>
<%--                        <li style="float:left;">--%>
<%--                            <select name="language" id="golfQueryTime">--%>
<%--                                <option  value="1" selected="selected">最近一周订单</option>--%>
<%--                                <option value="2" >最近一个月订单</option>--%>
<%--                            </select>--%>
<%--                            <f:select type="高尔夫订单状态" value="${sts}" id="golfQuerySts" showValue="false" blank="true"></f:select>--%>
<%--							<input name="" value=" 查询 " type="button" id="queryGolfOrder"/>--%>
<%--                        </li>--%>
<%--                        <li style="float:right;">--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                    <table cellspacing="1" cellpadding="0" border="0" class="BuyCard Table_w762 User_Center">--%>
<%--                        <tbody>--%>
<%--                            <tr>--%>
<%--                                <th width="60">&nbsp;&nbsp;&nbsp;&nbsp;订单号</th>--%>
<%--                                <th width="100">球场名称</th>--%>
<%--                                <th width="60">球场类型</th>--%>
<%--                                <th width="60">下单时间</th>--%>
<%--                                <th width="80">确认开球时间</th>--%>
<%--                                <th width="60">订单金额</th>--%>
<%--                                <th width="80">订单状态</th>--%>
<%--                                <th width="63">消费状态</th>--%>
<%--                                <th width="73">--%>
<%--                                	管理--%>
<%--	                                <input type="hidden" name="sts" value="0"/>--%>
<%--	                               	<input type="hidden" name="createTime" value="1970-01-01"/>                       	--%>
<%--                                </th>--%>
<%--                            </tr>--%>
							<%int x = 0; %>
                            <s:iterator value="golfOrders">
                            	<tr >
                                <td align="center"><a href="${ctx }/golfOrderAction!searchOneOrder.action?id=${id}" class="linkBlue"><s:property value="code"></s:property></a></td>
                                <td><s:property value="golfInfoVo.name" escape="false"></s:property></td>
                                <td>
									<f:write type="球场类型" value='${golfSiteVo.type}'></f:write>
                                </td>
                                <td>
                                	<s:date name="createTime" format="yyyy-MM-dd" />
									<br />
                                    <s:date name="createTime" format="HH:mm" />
                                </td>
                                <td>
                                	<s:date name="confirmTime" format="yyyy-MM-dd" />
									<br />
                                    <s:date name="confirmTime" format="HH:mm" />
                                </td>
                                <td class="red"><s:property value="amountPrice"></s:property></td>
                                <td class="green">
                                	<f:write type="高尔夫订单状态" value="${sts}"/>
                                	<c:if test="${sts eq '1'}"><%x++;%></c:if>
                                <br />
                                    <a class="Order_Track" href="javascript:void(0);" name="${id}" onclick="return false;">订单跟踪</a>
                                </td>
                                <td><f:write type="订单消费状态" value="${consumerSts}"/></td>
                                <td>
                                	<a class="link12" href="${ctx }/golfOrderAction!searchOneOrder.action?id=${id}" target="_blank">查看详情</a>
                                	<br />
                                	<a class="link12 Order_TG"  href="javascript:void(0);"  name="${id}" onclick="return false;">退改订单</a>
                                	 <input type="hidden" name="createTime" value="<s:date name="createTime" format="yyyy-MM-dd"/>"/>
                               		 <input type="hidden" name="sts" value="${sts}"/>
                                </td>
                           		</tr>
                            </s:iterator>
                            <input type="hidden" value="<%=x%>" id="notPaymentOrderAmount2"/>
<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                    <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>--%>
</s:else>