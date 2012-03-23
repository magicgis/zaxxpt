<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="ext" uri="/ext3" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<script>
  function first() {
     $o("pageEntity.page").value = 1;
     goto();
  }
  function prev() {
     $o("pageEntity.page").value = parseInt($o("pageEntity.page").value) - 1;
     goto();
  }
  function next() {
     $o("pageEntity.page").value = parseInt($o("pageEntity.page").value) + 1;
     goto();
  }
  function last() {
     $o("pageEntity.page").value = ${pageEntity.totalPage};
     goto();
  }
  function numberLimit(event){
   	var code = event.keyCode;
   	if((code<96||code>105)&&(code<48||code>57)&&code!=37&&code!=39&&code!=8&&code!=46&&code!=13){
   		self.event.returnValue=false;
   	}
  }
  function goto(){
  	if(isNaN($o("pageEntity.page").value)){
  		$o("pageEntity.page").value=1;
  	}
  	if($o("pageEntity.page").value>${pageEntity.totalPage}){
  		$o("pageEntity.page").value=${pageEntity.totalPage};
  	}
  	if($o("pageEntity.page").value<1){
  		$o("pageEntity.page").value=1;
  	}
  	$o('pageForm').submit();
  }
  function setHeight() {
        var h,
        	ua = navigator.userAgent.toLowerCase(),
        	v = parseFloat(navigator.appVersion.toLowerCase().split("msie")[1]),
        	IEVersion = isNaN(v)? -1 : v,
        	isIE = !!(IEVersion > 0),
        	ele = $o("page");
        
        if(isIE){
        	h = (IEVersion < 7) ? "25" : "27";
        	ele.style.height = h;
        }
  }
  Ext.onReady(setHeight);
  
</script>
<form id="pageForm" name="pageForm" action="${URI}_page.action" method="post" style="margin:0;padding:0;">
    <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
	<table id="page" width="100%" border="0" cellspacing="0" cellpadding="0" style="background:url(${path}/resources/images/bg.gif); border-left:#99bbe8 1px solid;border-bottom:#99bbe8 1px solid;border-right:#99bbe8 1px solid" class="TextBlue1">
	  <tr>
	    <td width="54%">
	     <table width="270" height="100%" border="0" cellspacing="0" cellpadding="0" class="TextBlue1">
	      <tr>
  	        <c:if test="${pageEntity.sizePage ne 0}">
	  	        <c:if test="${pageEntity.page eq 1}">
		          <td width="22" align="right"><img src="${path}/resources/images/page/page-first-disabled.gif" width="16" height="16" /></td>
		          <td width="22" align="right"><img src="${path}/resources/images/page/page-prev-disabled.gif" width="16" height="16" /></td>
		        </c:if>
		        
		        <c:if test="${pageEntity.page ne 1}">
		          <td width="22" align="right"><img src="${path}/resources/images/page/page-first.gif" onclick="first();" style="cursor:pointer;" width="16" height="16" /></td>
		          <td width="22" align="right"><img src="${path}/resources/images/page/page-prev.gif" onclick="prev();" style="cursor:pointer;" width="16" height="16" /></td>	        
		        </c:if>
		        
		        <td width="10" align="center"><img src="${path}/resources/images/page/pageline.gif" width="2" height="13" /></td>
		        <td align="center" nowrap>
			        <table width="100" border="0" cellspacing="0" cellpadding="0" class="TextBlue1">
			           <tr>
			              <td align="right"><div style="margin-top: 4px;">第&nbsp;</div></td>
			              <td align="center"><input id="pageEntity.page" name="pageEntity.page" type="text" size="2" onkeydown="numberLimit(event);" title="按Enter键进行跳转" onkeypress="if(event.keyCode==13){goto();}" class="x-form-text x-form-field" style="height:16px;line-height:16px;width:18px;" value="${pageEntity.page}" /></td>
			              <td align="left" nowrap="nowrap"><div style="margin-top: 4px;">&nbsp;/ ${pageEntity.totalPage} 页</div></td>
			           </tr>
			        </table>
				</td>
		        <td width="10" align="center"><img src="${path}/resources/images/page/pageline.gif" width="2" height="13" /></td>
	
				<c:if test="${pageEntity.page eq pageEntity.totalPage}">
		           <td width="22"><img src="${path}/resources/images/page/page-next-disabled.gif" width="16" height="16" /></td>
		           <td width="22"><img src="${path}/resources/images/page/page-last-disabled.gif" width="16" height="16" /></td>
		        </c:if>
		        
		        <c:if test="${pageEntity.page ne pageEntity.totalPage}">
		           <td width="22"><img src="${path}/resources/images/page/page-next.gif" onclick="next();" style="cursor:pointer;" width="16" height="16" /></td>
		           <td width="22"><img src="${path}/resources/images/page/page-last.gif" onclick="last();" style="cursor:pointer;" width="16" height="16" /></td>
		        </c:if>
		        
		        <td width="56">&nbsp;</td>
		        
		        <td width="10" align="center"><img src="${path}/resources/images/page/pageline.gif" width="2" height="13" /></td>
			</c:if>
		    <td width="10">&nbsp;</td>
	        
	        <td width="50" align="left">
	          	<ext:combobox id="sizePage" hiddenName="pageEntity.sizePage" name="pageEntity.sizePageName" size="50" width="50" blank="false" value="${pageEntity.sizePage}" list="${pageEntity.listNumber}"/>
			</td>
	        <td><img src="${path}/resources/images/page/refresh.gif" width="16" height="16" style="cursor:pointer;" onclick="$o('pageForm').submit();" /></td>
	        </tr>
	      </table>
	    </td>
	    <td width="46%" align="right">查询共 ${pageEntity.rowCount} 条记录&nbsp;&nbsp;每页显示 ${pageEntity.sizePage} 条记录&nbsp;&nbsp;共 ${pageEntity.totalPage} 页&nbsp;</td>
	  </tr>
	</table>
</form>