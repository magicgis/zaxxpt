<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ include file="/common/include/tags-lib.jsp"%>

<img class="tag_img" src="${ctx}/web/images/img12.jpg" />
<ul class="tag_p w480">
<s:iterator value="recommendProdVos">
<li><a href="javascript:redDetail('${prodCode}')">${title}</a>
<span class="city"><p:write key="${recommendCityCode}"/></span>
<span><tt>¥${price}</tt>元</span>
</li>
</s:iterator>
</ul>

