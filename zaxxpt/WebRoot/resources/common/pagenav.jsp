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
		    	<span>��ҳ</span>&nbsp;&nbsp;
		    	<span>��һҳ</span>
		    </c:if>
		    <c:if test="${pageEntity.page ne 1}">
		    	<span><a href="###" onclick="first(); return false;">��ҳ</a></span>&nbsp;&nbsp;
		    	<span><a href="###" onclick="prev(); return false;">��һҳ</a></span>
		    </c:if>
		    
		    <space>
		      &nbsp;&nbsp;&nbsp;&nbsp;${pageEntity.pageArray}&nbsp;&nbsp;&nbsp;&nbsp;
		    </space>
		    
		    
		    <c:if test="${pageEntity.page eq pageEntity.totalPage}">
			    <span>��һҳ</span>&nbsp;&nbsp;
		        <span>δҳ</span>		           
			</c:if>
			        
			<c:if test="${pageEntity.page ne pageEntity.totalPage}">
		        <span><a href="#" onclick="next(); return false;">��һҳ</a></span>&nbsp;&nbsp;
			    <span><a href="#" onclick="last(); return false;">δҳ</a></span>
	        </c:if>
	        
	        &nbsp;&nbsp;��  ${pageEntity.rowCount} ��&nbsp;&nbsp;�� ${pageEntity.page} ҳ/��  ${pageEntity.totalPage} ҳ
		</div>
	</c:if>
</Form>