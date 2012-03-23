<%@page language="java" contentType="text/html;charset=GB2312" %>
<jsp:directive.page import="com.jspsmart.upload.SmartUpload;"/>
	
<%    
  String excelFile =(String) request.getAttribute("excelFile"); 
	try	{
		SmartUpload download = new SmartUpload();  
	    download.initialize(pageContext);
	    download.downloadFile(excelFile);	    	
	    out.clear();
        out = pageContext.pushBody();

        java.io.File f = new java.io.File(excelFile);
	    f.delete();
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
