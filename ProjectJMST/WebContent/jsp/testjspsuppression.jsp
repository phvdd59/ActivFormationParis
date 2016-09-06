
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
			var select = document.getElementById("idSelect");
			alert("je suis la id select");
			var string = select.value;
			alert(select.value + "la value de select");
			var span = document.getElementById("spanNom");
			alert("le span est" + span.innerHTML);
			var xx = document.getElementById("spanNom");
			alert("après le span");
			xx.innerHTML = select.value;
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
		if (true){//noSerie.equals(noSerieHtml)){ //ne marche pas pour l'instant a voir donc(made)
	%>

	<p>Utilisateur</p>
	<form action="http://localhost:8080/ProjectJMST/ServletMadeBlocage">
		<select id="idSelect" name="personneBloquee">
			<option name="optionDescription">Identifiant  Nom Prenom</option>
			<%
			
				for (Personne perso : listePersonne) {
			%>
			<option name="optionNom"><%=perso.getIdentifiant()%></option>

			
			<%
				}
			%>
		</select>
		<%
			;
		%>


		<input id="raisonBlocage"type="text" name="raisonBlocage">
		<input type="submit" value=" bloquer personne"> 
		<%
			Personne personneBloquee = new Personne();
				// personneBloquee.setRaisonBlocage(document.getElementById(inputMotif));
		%>
					<input	type="hidden" name="noSerie" value="%%noSerie%%">
	</form>
	<table>
		<th colspan="4">Historiques des utilisateurs bloques</th>

		<tr>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Date d'inscription</td>
			
			<td>Motif</td>
		</tr>
		<%
			for (Personne perso : listePersonne) {
					if(perso.isBloque()){
		%>
		<tr>
			<td><%=perso.getNom()%></td>
			<td><%=perso.getPrenom()%></td>
			<td><%=perso.getDateCreation()%></td>
			<td><%=perso.getRaisonBlocage()%></td>
		</tr>
		<%
			}
				}
		%>
	</table>
	<form action="http://localhost:8080/ProjectJMST/ServletDeco"
					method="post">
					<input type="submit" value="deconnexion"
						title="deconnexion session"><input type="hidden"
						name="noSerie" value="<%=noSerie%>">
				</form>
				<form action=http://localhost:8080/ProjectJMST/RetourMenu method="post">
                    <input type="submit" value="retour">
                    <input type="hidden" name="noSerie" value="<%=noSerie%>">
                </form>
	
	<%
		} else {
			response.sendRedirect("http://localhost:8080/ProjectJMST/ServletJOCA1");
		}
	%>

</body>
</html>