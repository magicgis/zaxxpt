<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/web/js/clubJs/tag.js" language="javascript" type="text/javascript"></script>
<script language=JavaScript>
function adjustFrameHeight(){
		if(document.getElementById("mainFrame").contentWindow.document.body){
		  var f = document.getElementById("mainFrame");
		  f.style.height=f.contentWindow.document.body.scrollHeight+'px';
		}
		
	};
</script>
<title>${domain_cn }</title>
</head>
<body style="text-align:center;" onLoad="javascript:setTimeout(adjustFrameHeight,50);">
<div style=" position:relative; z-index:1">
<!-- iframe src="${ctx}/home.jsp" name="mainFrame" id="mainFrame" onreadystatechange="adjustFrameHeight()" onload="adjustFrameHeight()" style="width: 100%; height:100%;" frameborder="0" scrolling="no"></iframe-->
<%@ include file="/WEB-INF/pages/index.jsp"%>
</div>
</body>
