<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>


<!--广告内容块开始-->
<%
	String uri = request.getRequestURI();
    String str = uri.substring(uri.lastIndexOf("/"));
    String linkType = (String)session.getAttribute("LINK_TYPE");
	if(!"".equals(linkType)){
    	if(("/").equals(str)||str.indexOf("index") > -1){ //仅大首页显示LINK广告位
%>
    <jsp:include page="/WEB-INF/pages/common/include/ad_link.jsp"></jsp:include>
<%   	
    	}
    }
%>

<!--广告内容块结束-->
<div class="footer clearfix_"> <strong>
        <p>© 2011 由${domain_cn}版权所有 24小时服务热线：${site_tel}</p>
        <p>中国平安财产保险股份有限公司承保</p>
        </strong> <span><a href="${ctx}/notices.jsp">法律申明</a>|<a href="${ctx}/contact.jsp">联系我们</a></span> </div>
<c:if test="${!empty _user_}">

</c:if>
</body>
</html>