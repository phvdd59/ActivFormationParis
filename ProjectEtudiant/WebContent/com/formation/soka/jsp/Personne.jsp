<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Ceci est une page jsp


<%
		String pNom=request.getParameter("nom");
		if (pNom != null) {
			
		}
	%>

	<%
		
		String nom = "Dupont";
		Date dt = new Date();

		for (int i = 0; i < 5; i++) {
			out.println("<h3>" + i + " salut</h3>");
		}
	%>
	<%=dt%> <!-- 	affichage --> 
	<form action="http://192.168.33.145:8080/ProjectEtudiant/ServletPersonneSoka">
		<p><label for="Nom">Nom</label><input type="text" name="Nom" value="<%=nom%>" readonly="<%=nom%>"></p>
		<p><label for="Prenom">Prenom</label><input type="text" name="Prenom" value=""></p>
		<p><label for="Sexe">Madame</label><input type="radio" name="Sexe" value="Mme" checked></p>
		<p><label for="Sexe">Monsieur</label><input type="radio" name="Sexe" value="Mr"></p>
		<p><input type="submit" value="OK"></p>
	</form>
</body>
</html>