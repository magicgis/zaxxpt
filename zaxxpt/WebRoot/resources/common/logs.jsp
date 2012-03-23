<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="ext" uri="/ext3" %>

<ext:html>
  <head>
	 <ext:init href="${path}" lang="CN" />
	 <link rel="stylesheet" type="text/css" href="${path}/resources/css/body.css" />
  </head>
  
  <body bgcolor="#dfe8f6">
    <ext:grid id="grid" key="id" left="0" top="0" width="100%" height="100%" number="true" list="${master}">
       <ext:column name="id" width="0" sortable="false" desc="ID" hidden="true" />
       <ext:column name="type" width="200" sortable="true" desc="动作" />
       <ext:column name="userid" width="100" sortable="true" desc="用户帐号" />
       <ext:column name="datetime" width="120" sortable="true" desc="时间" type="date" format="DATETIME" />
       <ext:column name="ip" width="110" sortable="true" desc="IP地址" />
    </ext:grid>
  </body>
</ext:html>
