<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8" />
<title>首页</title>
<%@include file="/page/common/taglib.jsp"%>
</head>
<body>

    <div id="sitebody" class="sitebody">
<div id="content" class="content">
			<div class="panel-items">
			<div class="panel-left panel-item">
				<div class="item-title"><span class="span-title">公司动态</span><a href="javascript: void(0);" class="img-more"><img src="${ctx }/images/more.jpg" /></a></div>
				<div class="item-content">
					<table class="tbl-ellipsis">
					 <colgroup><col><col width="60"></colgroup>
					 <tr style="height: 5px;">
						<td><img src="${ctx }/images/symk_r3_c2.jpg" />公司动态<br/> </td>
					 </tr>
					 <tr>
					 	<td colspan="2">
					 		<p style="margin: 0;">
					 		<img src="${ctx}${pageCompany.recordList[0].sources.path}" width="100px;" height="63px;" style="margin-right: 10px; float: left;"/>
					 		<a href="javascript: void(0);" style="font-size: 14px; font-weight: bold;">${pageCompany.recordList[0].title }</a>
					 		</p>
					 	</td>
					 </tr>
					 <s:iterator value="pageCompany.recordList" begin="1">
					  	<tr>
					  	<td class='pageHome-listnews td-ellipsis'>
					  	 <a href="#" title="${title}">${title}</a></td><td align="right">
					  	(<t:formatDate value="createTime" pattern="MM-dd" isStack="true"/>)</td>
					  	</tr>
					  </s:iterator>
					   <tr>
						<td align="right" colspan="2"><a href="#">—>更多&nbsp;</a><br/> </td>
					 </tr>
					</table>
				</div>
			</div>
			<div class="panel-right panel-item">
				<div class="item-title"><span class="span-title">行业动态</span><a href="javascript: void(0);" class="img-more"><img src="${ctx }/images/more.jpg" /></a></div>
				<div class="item-content">
				<s:if test="not $empty(syndList)">
				<table class="tbl-ellipsis">
				<colgroup><col><col width="100"></colgroup>
					 <tr style="height: 5px;">
						<td><img src="${ctx }/images/symk_r3_c2.jpg" />行业动态<br/> </td>
					 </tr>
					 <tr>
					 	<td colspan="2">
					 		<p style="margin: 0;">
					 		<img src="${syndList[0].uri}" width="100px;" height="63px;" style="margin-right: 10px; float: left;"/>
					 		<a href="javascript: void(0);" style="font-size: 14px; font-weight: bold;">${syndList[0].title}</a>
					 		</p>
					 	</td>
					 </tr>
					 <s:iterator value="syndList" begin="1">
					  	<tr>
					  	<td class='pageHome-listnews td-ellipsis'>
					  	<a href="#" title="${title}">${title}</a></td>
					  	<td align="right" nowrap="nowrap">${author}<t:formatDate value="publishedDate" pattern="HH:mm" isStack="true"/></td>
					  	</tr>
					  </s:iterator>
					   <tr>
						<td align="right" colspan="2"><a href="javascript: void(0);">—>更多&nbsp;</a><br/> </td>
					 </tr>
					</table>
					</s:if>
				</div>
			</div>
			<div class="panel-middle panel-item">
				<div class="item-title"><span class="span-title">讯软产品</span><a href="javascript: void(0);" class="img-more"><img src="${ctx }/images/more.jpg" /></a></div>
				<div class="item-content">
				<table>
					 <tr style="height: 5px;">
						<td><img src="${ctx }/images/symk_r3_c2.jpg" />公司动态<br/></td>
					 </tr>
					 <tr>
					 	<td colspan="2">
					 		<p style="margin: 0;">
					 		 <s:iterator value="pageProduct.recordList[0].sources" begin="0" end="1">
					 			<img src="${ctx}${path}" width="100px;" height="63px;" style="margin-right: 10px; float: left;"/>
					 		 </s:iterator>
					 		<a href="javascript: void(0);" style="font-size: 14px; font-weight: bold;">${pageProduct.recordList[0].realInfo.title }</a>
					 		</p>
					 	</td>
					 </tr>
					 <s:iterator value="pageProduct.recordList" begin="1">
					  	<tr>
					  	<td style="padding-left: 4px;"><img src="${ctx}/images/qdt.jpg" align="absMiddle" border="0"/>&nbsp;
					  	<a href="#" title="${title}">${title}</a></td><td align="right">
					  	(<t:formatDate value="createTime" pattern="MM-dd" isStack="true"/>)</td>
					  	</tr>
					  </s:iterator>
					   <tr>
						<td align="right" colspan="2"><a href="#">—>更多&nbsp;</a><br/> </td>
					 </tr>
					</table>
				</div>
			</div>
			</div>
			<div class="panel-items">
			<div class="panel-left panel-item">
				<div class="item-title"><span class="span-title">IT咨询与服务</span><a href="javascript: void(0);" class="img-more"><img src="${ctx }/images/more.jpg" /></a></div>
				<div class="item-content">
				</div>
			</div>
			<div class="panel-right panel-item">
				<div class="item-title"><span class="span-title">热点专题</span><a href="javascript: void(0);" class="img-more"><img src="${ctx }/images/more.jpg" /></a></div>
				<div class="item-content">
				</div>
			</div>
			<div class="panel-middle panel-item">
				<div class="item-title"><span class="span-title">解决方案</span><a href="javascript: void(0);" class="img-more"><img src="${ctx }/images/more.jpg" /></a></div>
				<div class="item-content">
				</div>
			</div>
			</div>
		</div>
		<div class="app-list">
			<span><a href="javascript: void(0);"><img src="images/app/app1.jpg"/></a></span>
			<span><a href="javascript: void(0);"><img src="images/app/app2.jpg"/></a></span>
			<span><a href="javascript: void(0);"><img src="images/app/app3.jpg"/></a></span>
			<span><a href="javascript: void(0);"><img src="images/app/app4.jpg"/></a></span>
			<span><a href="javascript: void(0);"><img src="images/app/app5.jpg"/></a></span>
			<span><a href="javascript: void(0);"><img src="images/app/app6.jpg"/></a></span>
		</div>
		</div>
</body></html>
