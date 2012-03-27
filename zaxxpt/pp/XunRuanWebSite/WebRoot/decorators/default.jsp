<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
			<meta http-equiv="x-ua-compatible" content="ie=7" />
     	<title>
     	<decorator:title  />
        </title> 
     	<decorator:head />
    </head>
	<body onload="<decorator:getProperty property="body.onload" />">
		<page:applyDecorator page="/decorators/header.jsp" name="main" />
        <decorator:body />
        <page:applyDecorator page="/decorators/footer.jsp" name="main" />
	</body>
</html>