<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String fileUploadPath
			= "C:\\Users\\PC-22\\git\\WebMarket\\WebMarket\\WebContent\\images";
		DiskFileUpload upload = new DiskFileUpload();
		
		List items = upload.parseRequest(request);
		Iterator params = items.iterator();
		
		while(params.hasNext()) {
			FileItem fileItem = (FileItem)params.next();
			
			if(!fileItem.isFormField()){
				String fileName = fileItem.getName();
				
				out.print("fileName : " + fileName);
				
				fileName = fileUploadPath.substring(fileName.lastIndexOf("\\")+1);
				
				File file = new File(fileUploadPath + "/" + fileName);
				
				fileItem.write(file);
			}
			
		}
	%>
</body>
</html>