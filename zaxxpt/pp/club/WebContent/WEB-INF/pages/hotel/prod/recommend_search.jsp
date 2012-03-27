<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.product.base.vo.RecommendProdVo"%>
<%@page import="java.util.Set"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<div class="jc_content">
	<div class="jc_left">
	   <div class="jdtj_img1">
	        <ul>
				<s:iterator value="recommendProdVos">
					<li><span><img src="${content}"></span><a href="javascript:redDetail('${prodCode}')">${title}</a></li>
				</s:iterator>
	        </ul>
	    </div>
	        <ul class="float_li">
		        <li><img src="${ctx}/web/images/bj_left.jpg"></li>
					<li class="jc_tagbj">
				        <div class="tag_right">
				        	<ul>
					          <s:iterator value="cityRecommendProdVos.keySet()" id="cityCode">
					             <li class="jc_tag1 last">
					             	<a id="navjd5" class="jc_ta2" href="javascript:void(0);" onclick="return false;">
					             		<p:write key="${cityCode}"></p:write>
					             	</a>
					             </li>
					          </s:iterator>
					          <li class="jc_img">
                              <h3><span class="orange">Discount Hotel</span>各地特价酒店</h3>
                              </li>
				            </ul>
				    	</div>
			   		</li>
				<li><img src="${ctx}/web/images/bj_right.jpg"></li>
		    </ul>
	     	<div class="clear"></div>
	        <div class="tag_right_boz">
		        <%	Map<String,List<RecommendProdVo>> cityRecommendProdVos=(Map<String,List<RecommendProdVo>>)request.getAttribute("cityRecommendProdVos");
		        	Set<String> keySet=cityRecommendProdVos.keySet();
		        	//int size=keySet.size();
		        %>
		        <%for(String key:keySet){%>
		        	<%List<RecommendProdVo> prodVos=cityRecommendProdVos.get(key);{%>
		        		<div style="display:none;" id="searjd1" class=" Hotel_recommend" >
		        			<ul>
	        					<% int listSize=prodVos.size();
			        			for(int i=0;i<listSize;i++){%>
		        				<li>
			        				<%RecommendProdVo prodVo= prodVos.get(i);%>
									<a href="javascript:redDetail('<%=prodVo.getProdCode()%>')">
									<span class="name"><%=prodVo.getTitle()%></span> 
									<span><%=prodVo.getPrice()%>元</span>
									</a>
								</li>
								<%} %>
		        			</ul>
		        		</div>
<%--			        	<div style="display:block;" id="searjd1" class=" Hotel_recommend">--%>
<%--			        		<%--%>
<%--			        			int listSize=prodVos.size();--%>
<%--			        			for(int i=0;i<listSize;i+=4){--%>
<%--			        		%>--%>
<%--			        		<ul>--%>
<%--			        			<%--%>
<%--			        			for(int j=i;j<i+4&&j<listSize;j++){--%>
<%--			        			%>--%>
<%--								<li>--%>
<%--			        				<%RecommendProdVo prodVo= prodVos.get(j);%>--%>
<%--									<a href="javascript:redDetail('<%=prodVo.getProdCode()%>')">--%>
<%--									<span class="name"><%=prodVo.getTitle()%></span> --%>
<%--									<span><%=prodVo.getPrice()%>元</span>--%>
<%--									</a>--%>
<%--								</li>--%>
<%--								<%}%>--%>
<%--							</ul>--%>
<%--							<%}%>--%>
<%--	        			</div>--%>
	        		<%}%>
		        <%}%>
	    	</div>
	</div>
	<div class="jc_right1"> <img src="${ctx}/web/images/right1.jpg"> </div>
    <div class="clear"></div>
</div>
<div class="clear"></div>
