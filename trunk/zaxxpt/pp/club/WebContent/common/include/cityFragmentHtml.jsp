<%@ page pageEncoding="UTF-8"%>
<%@include file="/common/include/tags-lib.jsp"%>
<option value="">请选择</option>
<c:forEach items="${list}" var="o">
	<option value="${o.key }">${o.value }</option>
</c:forEach>