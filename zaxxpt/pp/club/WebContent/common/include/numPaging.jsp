<%@ page pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${pageInfo.currentPageNum > 0}">
		<span><a href="#" onclick="changePage('previous');return;">上一页</a></span>&nbsp;&nbsp;
		<c:forEach var="i" begin="${(pageInfo.currentGroupNum-1) * pageInfo.groupsOfPage+1}" end="${pageInfo.totalPageCount}" step="1">
	    <a href="#" onclick="changePage(${i});return;">${i}</a>
		</c:forEach>
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${pageInfo.currentPageNum+1 < pageInfo.totalPageCount}">
		<c:forEach var="i" begin="${pageInfo.currentGroupNum * pageInfo.groupsOfPage+1}" end="${pageInfo.totalPageCount}" step="1">
	    <a href="#" onclick="changePage(${i});return;">${i}</a>
		</c:forEach>
		
		<span><a href="#" onclick="changePage('next');return;">下一页</a></span>&nbsp;&nbsp;
	</c:when>
</c:choose>
&nbsp;&nbsp;&nbsp;&nbsp;共${pageInfo.totalRowCount}条 到第&nbsp;
<input type="text" class="inputText" value="${pageInfo.currentPageNum+1}" size="3" id="jumpto" name="pageNum">
&nbsp;页&nbsp;&nbsp;&nbsp;
<input type="button" class="inputText btn" value="确定" onclick='changePage()'>
<input type="hidden" class="inputText btn"  name="currentPageNum" value="${pageInfo.currentPageNum}">
<input type="hidden" class="inputText btn"  name="totalPageCount" value="${pageInfo.totalPageCount}">
<input type="hidden" class="inputText btn"  name="currentGroupNum" value="${pageInfo.currentGroupNum}">
<input type="hidden" class="inputText btn"  name="groupsOfPage" value="${groupsOfPage}">