<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="num" begin="1" end="10" step="2">
Number: ${num}
</c:forEach>

<%
	String msgs[] = { "one", "two", "three", "four" };
	request.setAttribute("msgs", msgs);
%>

<!--  With JSTL -->
<ul>
<c:forEach var="message" items="${msgs}">
	<li>${message}</li>
</c:forEach>
</ul>

<ul>
<c:forEach var="country" items="India,USA,Mexico,Canada">
<li>${country}</li>
</c:forEach>
</ul>

<ul>
<c:forTokens var="color" items="(red (oranage) yellow) (green) ((blue) violet)"
	delims=" ()">
	<li>${color}</li>
</c:forTokens>
</ul>

<!-- Below without JSTL -->
<ul>
<%
	for(int i=0; i< msgs.length; i++) {
		out.println("<li>" + msgs[i] + "</li>");
	}
%>
</ul>




</body>
</html>