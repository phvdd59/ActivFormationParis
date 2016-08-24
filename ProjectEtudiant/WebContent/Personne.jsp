<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String nom="Dupont"; 
	Date dt=new Date();%>
	<%=dt %>
<form action="http://localhost:8080/ProjectEtudiant/ServletPersonne">
	<p><label for="Nom">Nom</label><input type="text" name="Nom" value="<%= nom%>" readonly="readonly"></p>
	<p><label for="Prenom">Prénom</label><input type="text" name="Prenom" value=""></p>
	<p><label for="sexe">Madame</label><input type="radio" name="Sexe" value="Mme"></p>
	<p><label for="sexe">Monsieur</label><input type="radio" name="Sexe" value="Mr"></p>
	<p><input type="submit" value="OK"></p>
</form>
</body>
</html>