<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! String nom = "Dupont"; 
	Date dt = new Date();
	//request.%>
	
	<form action="http://localhost:8080/ProjectEtudiant/ServletPersonne">
		<p><label for="Nom">Nom</label><input type="text" name="Nom" value="<%= nom%>"></p>
		<p><label for="Prenom">Prenom</label><input type="text" name="Prenom" value=""></p>
		<p><label for="sexe">Madame</label><input type="radio" name="sexe" value="Mme" checked></p>
		<p><label for="sexe">Monsieur</label><input type="radio" name="sexe" value="Mr"></p>
		<p><input type="submit" value="OK"></p>
	</form>
</body>
</html>