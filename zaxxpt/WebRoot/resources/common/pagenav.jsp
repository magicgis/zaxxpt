<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<script>
  function first() {
     $o("pageEntity.page").value = 1;
     dopage();
  }
  
  function prev() {
     $o("pageEntity.page").value = parseInt($o("pageEntity.page").value) - 1;
     dopage();
  }
  
  function next() {
     $o("pageEntity.page").value = parseInt($o("pageEntity.page").value) + 1;
     dopage();
  }
  
  function last() {
     $o("pageEntity.page").value = ${pageEntity.totalPage};
     dopage();
  }
  
  function gotopage(pageValue) {
	 $o("pageEntity.page").value = pageValue;
	 dopage();
  }
  
  function dopage(){
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
  
</script>
                                               
<form id="pageForm" name="pageForm" action="${URI}_page.action" method="post">
	<input type="hidden" id="pageEntity.page" name="pageEntity.page" value="${pageEntity.page}" />
	
	<c:if test="${pageEntity.totalPage ne 1}">
		<div style="height:40px;" class="TextGray">
		    <c:if test="${pageEntity.page eq 1}">
		    	<span>首页</span>&nbsp;&nbsp;
		    	<span>上一页</span>
		    </c:if>
		    <c:if test="${pageEntity.page ne 1}">
		    	<span><a href="###" onclick="first(); return false;">首页</a></span>&nbsp;&nbsp;
		    	<span><a href="###" onclick="prev(); return false;">上一页</a></span>
		    </c:if>
		    
		    <space>
		      &nbsp;&nbsp;&nbsp;&nbsp;${pageEntity.pageArray}&nbsp;&nbsp;&nbsp;&nbsp;
		    </space>
		    
		    
		    <c:if test="${pageEntity.page eq pageEntity.totalPage}">
			    <span>下一页</span>&nbsp;&nbsp;
		        <span>未页</span>		           
			</c:if>
			        
			<c:if test="${pageEntity.page ne pageEntity.totalPage}">
		        <span><a href="#" onclick="next(); return false;">下一页</a></span>&nbsp;&nbsp;
			    <span><a href="#" onclick="last(); return false;">未页</a></span>
	        </c:if>
	        
	        &nbsp;&nbsp;共  ${pageEntity.rowCount} 条&nbsp;&nbsp;第 ${pageEntity.page} 页/共  ${pageEntity.totalPage} 页
		</div>
	</c:if>
</Form>