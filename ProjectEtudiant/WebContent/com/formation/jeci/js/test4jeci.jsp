<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width: 500px;border: solid;text-align: center;">
<h1> TEst Jsp</h1>
<% 
String nom=request.getParameter("essai");
int n1=(int)(Math.random()*10);
int n2=(int)(Math.random()*10);


%>

<form action="http://localhost:8080/ProjectEtudiant/com/formation/jeci/js/sessionQMadeErreur.jsp">
<%= n1 %>* <%=n2  %>
<input type="text" name="essai" value=""/>
<input type="hidden" name="nom" value="<%=nom  %>"/>
<input type="hidden" name="n1" value="<%=n1  %>"/>
<input type="hidden" name="n2" value="<%=n2  %>"/> 
</form>
	
	
</div>

</body>
</html>