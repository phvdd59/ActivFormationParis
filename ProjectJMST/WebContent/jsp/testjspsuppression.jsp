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
<style type="text/css">
th {
text-align: center;
font-size: 14%
}
td {
text-align: center;
}
input[type="text"]{
width: 50%;


}
input{
width: 50%;

}

select{
width: 45%;

}
form{
width: 70%;
}
.monInput{
position: relative;
left: 45%;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire</title>
<link href="http://www.activconsult-ing.com/Home.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="css/MonAuthentificationCSS.css" />
</head>
<body>
	<div id="background">
		<div id="back2">
			<img src="http://www.activconsult-ing.com/img/Article_fond_bleu.png" />
		</div>
		<div id="back3">
			<img
				src="http://www.activconsult-ing.com/img/shutterstock_106416164.png" />
		</div>
		<div id="logo">
			<a href="http://www.activconsult-ing.com/index.html"><img
				src="http://www.activconsult-ing.com/img/ACI_Logo_quadri_blanc.png"
				width="184" height="185" /></a>
		</div>
		<div id="white">
			<img src="http://www.activconsult-ing.com/img/Article_fond_blanc.png"
				width="782" height="595" />
		</div>
		<div id="logo1">
			<a href="http://www.activconsult-ing.com/qui_sommes_nous.html"><img
				src="http://www.activconsult-ing.com/img/Menu_ancre.png"
				alt="Qui sommes nous ?" /></a>
		</div>
		<div id="logo2">
			<a href="http://www.activconsult-ing.com/le_groupe.html"><img
				src="http://www.activconsult-ing.com/img/Menu_poulpe.png" width="70"
				height="93" alt="Le groupe" /></a>
		</div>
		<div id="logo3">
			<a href="http://www.activconsult-ing.com/centre_formation.html"><img
				src="http://www.activconsult-ing.com/img/Menu_pagaies.png"
				width="71" height="103" alt="Centre de formation" /></a>
		</div>
		<div id="logo4">
			<a href="http://www.activconsult-ing.com/nos_offres1.html"><img
				src="http://www.activconsult-ing.com/img/Menu_rose_des_vents.png"
				width="71" height="93" alt="Nos offres" /></a>
		</div>
		<div id="logo5">
			<a href="http://www.activconsult-ing.com/domaines_activites.html"><img
				src="http://www.activconsult-ing.com/img/Menu_noeuds.png" width="72"
				height="103" alt="Domaines d'activités" /></a>
		</div>
		<div id="logo6">
			<a href="http://www.activconsult-ing.com/recrutement_rh.html"><img
				src="http://www.activconsult-ing.com/img/Menu_capitaine.png"
				width="71" height="103" alt="Recrutement RH" /></a>
		</div>
		<div id="logo8">
			<a href="http://www.activconsult-ing.com/ressources_externes.html"><img
				src="http://www.activconsult-ing.com/img/Menu_bouée.png" width="71"
				height="103" alt="Ressouces externes" /></a>
		</div>
		<div id="logo7">
			<a href="http://www.activconsult-ing.com/contact.html"><img
				src="http://www.activconsult-ing.com/img/Menu_gouvernail.png"
				width="71" height="93" alt="Contact" /></a>
		</div>
		<div id="titre1">ENTREPRISE DE SERVICES DU NUMERIQUE</div>
		<div id="menu3">
			<img
				src="http://www.activconsult-ing.com/img/Objet_dynamique_vectoriel.png"
				width="342" height="57" alt="" />
		</div>
		<div id="ogol1">
			<img src="http://www.activconsult-ing.com/img/Menu_pagaies2.png"
				width="71" height="71" alt="" />
		</div>
		<div id="tlogo">GESTION DES DROITS</div>
		<div id="info2">
			<!-- zone disponible -->
			
<%
		session = request.getSession();
		String noSerie = (String) session.getAttribute("noSerie");
		String noSerieHtml = request.getParameter("noSerie");
		Personne personne = new Personne();
		ListPersonne listePersonne = new ListPersonne();
		DAOPersonne dao = new DAOPersonne();
		listePersonne = dao.read();
		if (noSerieHtml.equals(noSerie)) {//ne marche pas pour l'instant a voir donc(made)
	%>

	<p>Selection de l'utilisateur a bloquer :</p>
	<form action="http://localhost:8080/ProjectJMST/ServletMadeBlocage">
		<select id="idSelect" name="personneBloquee">
			<option name="optionDescription">Identifiant </option>
			<%
			
				for (Personne perso : listePersonne) {
					
					if (!perso.isBloque()){
			%>
			<option name="optionNom"><%=perso.getIdentifiant()%></option>

			<%
					}
				}
			%>
		</select>
		<input class="monInput" type="submit" value=" Bloquer personne"> 
	<br>
		<input id="raisonBlocage"type="text" name="raisonBlocage" maxlength="50" placeholder="motif " >
		
	
					<input	type="hidden" name="noSerie" value="<%=noSerie%>">
	</form>
	<br><br>
	<table border="1" width="70%" align="center" >
		<th colspan="5" style="font-size: small; ">Historiques des utilisateurs bloques</th>

		<tr>
			<td>Identifiant</td>
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
			<td><%=perso.getIdentifiant()%></td>
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
	
	
	<p>Selection de l'utilisateur a debloquer :</p>
	<form action="http://localhost:8080/ProjectJMST/ServletMadeDeblocage">
		<select id="idSelectaDebloquer" name="personneADebloquer">
			<option name="optionDescription">Identifiant </option>
			<%
			
				for (Personne perso : listePersonne) {
					
					if (perso.isBloque()){
			%>
			<option name="optionNom"><%=perso.getIdentifiant()%></option>

			
			<%
					}
				}
			%>
		</select>
		<input class="monInput" type="submit" value=" Débloquer personne"> 
		<br>
		
		<input	type="hidden" name="noSerie" value="<%=noSerie%>">
	</form>
	
	<br>
	<form action="http://localhost:8080/ProjectJMST/ServletDeco"
					method="post">
					<input type="submit" value="Deconnexion"
						title="deconnexion session"><input type="hidden"
						name="noSerie" value="<%=noSerie%>">
				</form>
				<form action=http://localhost:8080/ProjectJMST/RetourMenu method="post">
                    <input type="submit" value="Retour">
                    <input type="hidden" name="noSerie" value="<%=noSerie%>">
                </form>
	



		</div>
		<div id="fpage2">
			<img
				src="http://www.activconsult-ing.com/img/Article_fond_blanc_double_copie.png" />
			<div id="Facebook2">
				<img src="http://www.activconsult-ing.com/img/Facebook.png" />
			</div>
			<div id="linkedin2">
				<img src="http://www.activconsult-ing.com/img/Linkedin.png" />
			</div>
			<div id="viadeo2">
				<img src="http://www.activconsult-ing.com/img/Viadeo.png" />
			</div>
			<div id="droit2">©1997-2012 - Tous droits de reproduction et de
				représentation réservés | Mentions légales</div>
		</div>

	
	</div>
	<%
		} else {
			response.sendRedirect("http://localhost:8080/ProjectJMST/ServletJOCA1");
		}
	%>
</body>

</html>