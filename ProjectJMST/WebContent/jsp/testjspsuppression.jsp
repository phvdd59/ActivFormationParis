
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.formation.thcr.dao.DAOPersonne"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="com.formation.thcr.metier.*"%>
<%@ page import="com.formation.joca.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		session = request.getSession();
		String noSerie = (String) session.getAttribute("noSerie");
		String noSerieHtml = request.getParameter("noSerie");
		Personne personne = new Personne();
		ListPersonne listePersonne = new ListPersonne();
		DAOPersonne dao = new DAOPersonne();
		listePersonne = dao.read();
		if (true) { //(noSerie.equals(noSerieHtml)){ ne marche pas pour l'instant a voir donc(made)
	%>


	<p>Utilisateur</p>
	<form action="">
		<select>
			<%
				for (Personne perso : listePersonne) {
			%>
			<option><%=perso.getNom()%></option>
			<%
				}
			%>
		</select>
	</form>
	
	<form action="servletblocage">
	<input type="button" value="bloquer l'utilisateur">
	</form>

	<p>Motif</p>
	<form>
		<input id="inputMotif" type="text">
		<%
			Personne personneBloquee = new Personne();
				// personneBloquee.setRaisonBlocage(document.getElementById(inputMotif));
		%>
	</form>

	<table>
		<th colspan="5">Historiques des utilisateurs bloques </th>

		<tr>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Date d'inscription</td>
			<td>Date de blocage</td>
			<td>Motif</td>
		</tr>
		<%for(Personne perso : listePersonne) {
			//if(perso.isBloque()){
		
		%>
		<tr>
			<td><%=perso.getNom()%></td>
			<td><%=perso.getPrenom()%></td>
			<td><%=perso.getDateCreation()%></td>
			<td>Date de blocage</td>
			<td><%=perso.getRaisonBlocage()%></td>
		</tr>
		<%
		//}
			}%>
	</table>
	<%
		} else {
			response.sendRedirect("http://localhost:8080/ProjectJMST/ServletJOCA1");
		}
	%>


</body>
</html>