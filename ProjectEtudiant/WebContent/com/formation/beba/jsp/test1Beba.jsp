<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div style="with: 500px; border: solid; text-align: center;">
		<h1>Test jsp</h1>
		<%
			for (int i = 0; i < 10; i++) {
				out.println("<h3>" + i + "bonjour</h3>");

			}
		%>

	</div>

</body>
</html>