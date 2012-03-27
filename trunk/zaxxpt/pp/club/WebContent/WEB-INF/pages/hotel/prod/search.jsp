﻿<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select2css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<script type="text/javascript">var CTX='${ctx}';</script>
<script type="text/javascript" src="${ctx}/web/js/city/allCity.js"></script>
<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->
<script type="text/javascript" src="${ctx}/common/include/weatherAjax.js" language="javascript"></script>
<script src="${ctx}/common/include/backTop.js" type="text/javascript"></script><!--返回顶部按钮使用 -->
<script src="${ctx}/hotel/js/hotelSearchCotrol.js" type="text/javascript" defer="defer"></script>
<title><c:if test='${not empty qryHotelVo.cityname}'>${qryHotelVo.cityname}</c:if>酒店查询 - 酒店预订 - ${domain_cn }</title>
<style type="text/css">
	.w3_new{
		width: 120px;
		verflow:hidden;
	}
	.jdlist1 li.w1 {
		 width:215px; 
		 padding-left:30px; 
		 text-align:left;
		 overflow: hidden;
	}
	
	.jdlist2 {
	    border-bottom: 1px solid #DBDBDB;
	    height: 35px;
	    line-height: 35px;
	    text-align: right;
	}
	.jdlist1 {
		width: 978px;
	}
</style>
</head>
<body>
<div class="clear"></div>
<div class="senav">
  <ul>
    <li><img src="${ctx}/web/images/seleft.jpg" /></li>
    <li class="sebj"><a href="${ctx}" class="se">首页</a> &gt; &nbsp;<span class="se">酒店查询</span></li>
    <li><img src="${ctx}/web/images/seright.jpg" /></li>
  </ul>
</div>
<div class="clear"></div>
<%--酒店查询表单--%>
<jsp:include page="hotetSerachForm.jsp"></jsp:include>
<div class="clear"></div>
<div class="jd_listbox">
  <div><img src="${ctx}/web/images/jd_list_bop.jpg" /></div>
  <div class="jd_listbj color74" id="btop" style="overflow:hidden;">
	<!-- 提示开始 -->
	<span id="messagebox">
		<c:if test="${fn:length(hotelQueryResultVo.resultBean.hotels)<1}">
			<b>非常抱歉,没有查询到相关信息的酒店。</b><br/><br/><br/>	请重新查询。如有疑问，请你致电${site_tel}进行咨询。
		</c:if>
	</span>
	<!-- 提示结束 -->
	<!-- 酒店列表开始 -->
	<s:iterator value="hotelQueryResultVo.resultBean.hotels">
		<div class="jdlistimg" id="hotel_${code}">
	      <ul>
	        <li class="jdimg_img">
	        	<s:if test="picpath !=null ">
	        		<img src="${picpath}">
	        	</s:if>
	        </li>
	        <li class="jdimg_p">
	          <h1><a href="javascript:void redDetail('${code}')">${name}</a><img src="${ctx}/web/images/star-${star}.png"></h1>
	          <span></span> 
	        </li>
	      </ul>
	    </div>
    </s:iterator>
	<!-- 酒店列表结束 -->
	<div><img src="${ctx}/web/images/bottombj.jpg" /></div>
  </div>
</div>
<!-- 翻页开始 -->
<c:if test="${fn:length(hotelQueryResultVo.resultBean.hotels)>=1}">
<%--分页查询信息保存--%>
<form  method="post" id="pageForm" action="${ctx}/hotel/search.jsp">
	<input type="hidden"  id="totalPageCount" value="${hotelQueryResultVo.resultBean.pageInfo.totalPageCount}">
    <input type="hidden" name="hotelQueryVo.pageNum" id="currentPageNum" value="${hotelQueryResultVo.resultBean.pageInfo.currentPageNum}" >
	<input type="hidden" name="hotelQueryVo.city"   id="currentCity" value="${hotelQueryVo.city}" />
	<input type="hidden" name="hotelQueryVo.qword"  id="currentQword" value="${hotelQueryVo.qword}"/>
	<input type="hidden" name="hotelQueryVo.filterStar" id="currentFilterStar" value="${hotelQueryVo.filterStar}"/>
	<input type="hidden" name="hotelQueryVo.idate" id="currentIdate" value="${hotelQueryVo.idate}"/>
    <input type="hidden" name="hotelQueryVo.odate" id="currentOdate" value="${hotelQueryVo.odate}"/>
    <input type="hidden" name="hotelQueryVo.filterPrice" id="currentFilterPrice" value="${hotelQueryVo.filterPrice}"/>
    <input type="hidden" name="hotelQueryVo.pageSize" id="pageSize" value="${hotelQueryVo.pageSize}" >                            
</form>
<%--分页控件--%>
<div class="Wmargin yema yema_add" id="pageInfo"></div>
</c:if>
</body>




 
