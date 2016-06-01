<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<%
	String hello = "Hello";
	if(!StringUtils.isBlank((String)request.getAttribute("errors"))) {
		out.println((String)request.getAttribute("errors"));
	}
%>

<%-- 
<jsp:useBean id="user" type="com.itekkies.training.events.User" scope="session"/>
<br>Welcome: <jsp:getProperty property="userName" name="user"/>
<br>
--%>

<form action="/event-calendar/events" method="post">
First Name: <input type="text" name="first_name" id="first_name">
<br>Last Name: <input type="text" name="last_name" id="last_name">
<br>Event Name: <input type="text" name="event_name" id="event_name">
<br>Event Date: <input type="text" name="event_date" id="event_date">
<br>Event Month: <input type="text" name="event_month" id="event_month">
<input type="hidden" name="create_event" value="create_event">
<br><input type="submit" name="submit">
</form>

<%=hello %>

<%@include file="footer.jsp" %>
</body>
</html>