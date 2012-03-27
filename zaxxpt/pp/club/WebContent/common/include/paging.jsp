<%@ page pageEncoding="UTF-8"%>
	 共<b>${pageInfo.totalRowCount}</b>条&nbsp;&nbsp;<%-- 每页<b>${pageInfo.rowsOfPage}</b>条--%>&nbsp;&nbsp;${pageInfo.currentPageNum}/
<c:choose>
	<c:when test="${pageInfo.totalPageCount == 0}">1</c:when>
	<c:otherwise>${pageInfo.totalPageCount}</c:otherwise>
</c:choose>页&nbsp;&nbsp;
<c:choose>
	<c:when test="${pageInfo.currentPageNum > 1}">
		<a class="black" href="#" onclick="changePage('first');return;">首页</a>&nbsp;&nbsp;
		<a class="black" href="#" onclick="changePage('previous');return;">上一页</a>&nbsp;&nbsp;
	</c:when>
	<c:otherwise>
		首页&nbsp;&nbsp;
		上一页&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${pageInfo.currentPageNum+1 < pageInfo.totalPageCount}">
		<a class="black" href="#" onclick="changePage('next');return;">下一页</a>&nbsp;&nbsp;
		<a class="black" href="#" onclick="changePage('last');return;">末页</a>&nbsp;&nbsp;
	</c:when>
	<c:otherwise>
		下一页&nbsp;&nbsp;
		末页&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
    第 <label> 
		<input type="text" class="inputText" value="${pageInfo.currentPageNum}" name="pageNum" id="jumpto" name="jumpto">
	</label>页&nbsp;&nbsp;
	<input type="button" value="确&nbsp;定" onclick='changePage($(this))' class="btn">
	<input type="hidden" id="currentPageNum" name="currentPageNum" value="${pageInfo.currentPageNum}">
	<input type="hidden" id="totalPageCount" name="totalPageCount" value="${pageInfo.totalPageCount}">