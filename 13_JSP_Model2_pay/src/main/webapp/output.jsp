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
	Result r = (Result) request.getAttribute("r");
%>

	번돈 : <%=r.getEarn
	 () %>
	쓴돈 : <%=r.getSpend() %>
	남은돈 : <%=r.getRemain() %>


</body>
</html>