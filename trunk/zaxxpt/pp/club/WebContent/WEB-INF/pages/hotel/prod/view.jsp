<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/common/include/backTop.js" type="text/javascript"></script><!--返回顶部按钮使用 -->
<script language="javascript" type="text/javascript">
function doClick(oSourceObj,oTargetObj){
	var sourceObj = typeof oSourceObj == "string" ? document.getElementById(oSourceObj) : oSourceObj;
	var targetObj = typeof oTargetObj == "string" ? document.getElementById(oTargetObj) : oTargetObj;
	if(targetObj.style.display!="none"){
	   if(false) return;
	   oSourceObj.className="zhankai1";
	   targetObj.style.display="none";
	} else {
		oSourceObj.className="zhankai";
	   targetObj.style.display="block";
	}
}

</script>
<title>${hotel.name }详情 - 酒店预订 - ${domain_cn}</title>
</head>
<body>
<div class="clear"></div>
<div class="senav">
  <ul>
    <li><img src="${ctx}/web/images/seleft.jpg" /></li>
    <li class="sebj"><a href="${ctx}/" class="se">首页</a> &gt; 
    <a href="${ctx}/hotel/index.jsp" class="se">酒店详情</a> &gt; 
    <a href="" class="se1" onclick="return false;">${hotel.name }</a>
    </li>
    <li><img src="${ctx}/web/images/seright.jpg" /></li>
  </ul>
</div>
<div class="clear"></div>
<div class="jdimg" id="btop">
  <ul>
    <li class="jdimg_img"><img src="<s:property value="hotelDetailsResultVo.resultBean.pics.get(0).path"/>" /></li>
    <li class="jdimg_p">
      <h1><a>${hotel.name }</a>
      <img src="${ctx}/web/images/star-${hotel.star}.png" />
      </h1>
      <span>${hotel.addr }</span> 
     </li>
  </ul>
</div>

<div class="jd_content">
    <p>${hotel.hdesc }</p>
</div> 

<div class="jd_fy_box">
  <ul>
    <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
    <li class="jd_fy">房型房价</li>
    <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
  </ul>
</div>
<div class="jd_fj_list">
  <div class="fxfj_detail">
    <ul class="clearfix_">
      <li>房型</li>
      <li>早餐</li>
      <li>宽带</li>
      <li>市场价</li>
      <li>会员优惠</li>
      <li>会员价</li>
      <li>&nbsp;</li>
    </ul>
    <s:iterator value="#request.rooms" id="index" >
    	<s:if test="inventory!=0">
		    <ul class="clearfix_">
		      <li><a href="javascript:void(0);" class="zhankai1" onClick="doClick(this,'sear${index}');return false;" >${name}</a></li>
		      <li><s:if test="breakfastDesc!=null&&breakfastDesc!=''">${breakfastDesc }</s:if><s:else>无</s:else></li>
		      <li><s:if test="netDesc!=null&&netDesc!=''">${netDesc }</s:if><s:else>无</s:else></li>
		      <li>RMB${avgSalePrice}</li>
		      <li>10%</li>
		      <li><b class="colordb">RMB<s:property value="rateList.get(0).salePrice"/></b></li>
		      <s:if test="roomSts!=1">
		      <li><a href="${ctx}/hotel/book.jsp?idate=${hotelDetailsResultVo.resultBean.idate}&odate=${hotelDetailsResultVo.resultBean.odate}&hcode=${hotel.code}&roomPlanCode=${roomPlanCode}&citySource=hbe"><img src="${ctx}/web/images/yd.jpg" /></a></li>
		      </s:if>
		      <s:else>
		      	<li><a><img src="${ctx}/web/images/yd-mf.png" /></a></li>
		      </s:else>
		    </ul>
		    <div style="height:1px; overflow:hidden;"></div>
		    <div class="jdlistxx clearfix_" id="sear${index}" style="display:none;"> <img src="${ctx}/web/images/img10.jpg" />
		    	房间面积:平米;早餐类型:${breakfastDesc };床型:${bedName };宽带类型:${netDesc };<br />
		    </div>
	    </s:if>
    </s:iterator>
  </div>
</div>
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<div class="jd_jieshao">
  <div class="jd_fy_box">
    <ul>
      <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
      <li class="jd_fy">酒店预订须知</li>
      <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
  </div>
  <div class="jd_jdxz"> 
  	 房间保留到入住当天18:00，详情请咨询客服 ${site_tel}
  </div>
  <c:if test="${not empty hotel.traffic}">
	  <div class="jd_fy_box">
	    <ul>
	      <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
	      <li class="jd_fy">酒店交通位置</li>
	      <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
	    </ul>
	  </div>
	  <div class="jd_jdxz"> 
	  	 ${hotel.traffic}
	  </div>
  </c:if>
  
  <c:if test="${not empty details.hotelEquip}">
	  <div class="jd_fy_box">
	    <ul>
	      <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
	      <li class="jd_fy">酒店设施和服务</li>
	      <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
	    </ul>
	  </div>
	  <div class="jd_jdxz"> 
	  	 ${details.hotelEquip}
	  </div>
  </c:if>
  <c:if test="${not empty details}">
  <div class="jd_fy_box">
    <ul>
      <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
      <li class="jd_fy">休闲娱乐设施和服务</li>
      <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
  </div>
  <div class="jdxq_detail">
  	${details.dinner}<br/>
  	${details.conference}<br/>
  	${details.entertainment}<br/>
  </div>
  </c:if>
</div>
<div id="content"><img src="${ctx}/web/images/bottombj.jpg" /></div>
<div class="Wmargin cont_align"><a href="" name="btop" onclick="return false;"><img onclick="javasrcipt:backTop();" src="${ctx}/web/images/gototop.jpg" /></a></div>
</body>
