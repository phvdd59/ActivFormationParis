
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

	<script type="text/javascript">
		function afficher() {
			var select=document.getElementById("idSelect");
			alert("je suis la");
			var string=select.value;
			alert(select.value);
			var span=document.getElementById("spanNom");
			alert("le span est" +span.innerHTML);
			var xx=document.getElementById("spanNom");
			alert("après le span");
			xx.innerHTML=select.value;
			alert("fin");
		}
	</script>
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
	<form action="servletblocage">
		<select id="idSelect" name="personneBloquee">
			<%
				for (Personne perso : listePersonne) {
			%>
			<option name="optionNom"><%=perso.getIdentifiant()%></option>

			<p id="test">test</p>
			<p id="pNom" hidden><%=perso.getNom()%>bonjour
			</p>
			<p><%=perso.getPrenom()%></p>
			<%
				}
			%>
		</select>




		<p>Vous avez selectionnez la personne suivante:</p>
<span id="spanNom">allo</span>
	<input type="button" onclick="afficher()">
	<input type="text" value=" " readonly="readonly">
		<input type="submit" value=" bloquer personne" >
	
	
		<input id="inputMotif" type="text" name="raisonBlocage">
		<%
			Personne personneBloquee = new Personne();
				// personneBloquee.setRaisonBlocage(document.getElementById(inputMotif));
		%>

</form>
		<table>
			<th colspan="5">Historiques des utilisateurs bloques</th>

			<tr>
				<td>Nom</td>
				<td>Prenom</td>
				<td>Date d'inscription</td>
				<td>Date de blocage</td>
				<td>Motif</td>
			</tr>
			<%
				for (Personne perso : listePersonne) {
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
					}
			%>
		</table>
		<%
			} else {
				response.sendRedirect("http://localhost:8080/ProjectJMST/ServletJOCA1");
			}
		%>
	
</body>
</html>