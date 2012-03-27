<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	.myA{color:gray}
</style>
    <div class="jc_left">
      <ul class="float_li">
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jc_tagbj">
          <div class="tag_right">
            <ul>
              <li class="jc_titl"><b class="orange">LOUNGE</b> 休息室推荐</li>
            </ul>
          </div>
        </li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
      </ul>
      <div class="xxstj2">
          <ul>
          <li class="w1">机场</li>
          <li class="w2">休息室名称</li>
          <li class="w3">休息室类型</li>
          <li class="w4">价格</li>
        </ul>
       <%-- 测试代码 <a href="${ctx}/loungeDetailAction!loungeDetail.action?id=a705580af43b410cb559588b6ad7483d&airport=${airport.code}&bookTime=${bookTime}" >
	            	aa
	            </a> --%>
        <s:iterator value="roomlist" var="room" status="item">
        <s:if test="#item.index<8">
       		<ul>
	          <li class="w1">
	         	<s:property escape="false" value="#room.lounge.airport.name"/>
	          </li>
	          <%--给休息室添加链接  跳到详细信息--%>
	          <li class="w2">
	          	<a target="blank" class="myA" href="${ctx}/loungeDetailAction!loungeDetail.action?id=<s:property escape="false" value="#room.lounge.id"/>
	          	&airport=<s:property escape="false" value="#room.lounge.airportCode"/>&bookTime=" >
	            	<s:property escape="false" value="#room.lounge.name"/>
	            </a>
	            </li>
	          <li class="w3"><f:write type="休息室类型" value='${room.type}'></f:write></li>
	          <li class="w4">
	          	<s:property escape="false" value="#room.loungePriceVo.price"/>元
	          	<s:if test="#room.type==1">
	          		/时
	          	</s:if>
	          	<s:else>
	          		/人
	          	</s:else>
	          </li>
	        </ul>
        </s:if>
        </s:iterator>
        <!-- <ul>
          <li class="w1">北京</li>
          <li class="w2">海航贵宾接待中待中心</li>
          <li class="w3">贵宾间</li>
          <li class="w4">2000/时</li>
        </ul> -->
      </div>
    </div>
    <div class="jc_right">
      <div class="jc_title rightTitleL"><b>LOUNGES</b> 机场休息室 </div>
      <div class="jc_righta_p"> 机场休息室分三种类型：贵宾间、贵宾厅以及两舱休息室。
机场的贵宾厅和贵宾间，需要缴纳年费，且使用时仍需收费。如果您是 ${domain_cn }会员，可享受免年费，且可以低于正常售价80%的价格预订。
两舱休息室，即公务舱（头等舱）休息室，一般会规定仅供某些航空公司的旅客使用。 ${domain_cn }会员预订两舱休息室，价格低于正常售价的80%。
 </div>
    </div>