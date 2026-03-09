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
	//		1. 값 받기
		int x = Integer.parseInt(request.getParameter("xx"));
		int y = Integer.parseInt(request.getParameter("yy"));
		
		int hap = x + y;
		int cha = x - y;
		int gob = x * y;
		int mok = x / y;
		
%>  

	<h1><%= x %> + <%= y %> = <%= hap %></h1>
	<h1><%= x %> - <%= y %> = <%= cha %></h1>
	<h1><%= x %> * <%= y %> = <%= gob %></h1>
	<h1><%= x %> / <%= y %> = <%= mok %></h1>
		

</body>
</html>