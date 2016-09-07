<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.formation.bait.metier.Personne" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://localhost:8080/ProjectBAIT/com/bait/js/verificationsLogin.js"></script>
<script type="text/javascript" src="http://localhost:8080/ProjectBAIT/com/bait/js/verificationsInscription.js"></script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="http://localhost:8080/ProjectBAIT/com/bait/css/CSSProjet.css">
<title>Inscription</title>
</head>
<body>
	<div id="background">
		<div id="back2">
			<img src="http://www.activconsult-ing.com/img/Article_fond_bleu.png">
		</div>
		<div id="back3">
			<img src="http://www.activconsult-ing.com/img/shutterstock_106416164.png">
		</div>
		<div id="logo">
			<a href="http://www.activconsult-ing.com/index.html"><img src="http://www.activconsult-ing.com/img/ACI_Logo_quadri_blanc.png" height="185" width="184"></a>
		</div>
		<div id="white">
			<img src="http://www.activconsult-ing.com/img/Article_fond_blanc.png" height="595" width="782">
		</div>
		<div id="logo1">
			<a href="http://www.activconsult-ing.com/qui_sommes_nous.html"><img src="http://www.activconsult-ing.com/img/Menu_ancre.png" alt="Qui sommes nous ?"></a>
		</div>
		<div id="logo2">
			<a href="http://www.activconsult-ing.com/le_groupe.html"><img src="http://www.activconsult-ing.com/img/Menu_poulpe.png" alt="Le groupe" height="93" width="70"></a>
		</div>
		<div id="logo3">
			<a href="http://www.activconsult-ing.com/centre_formation.html"><img src="http://www.activconsult-ing.com/img/Menu_pagaies.png" alt="Centre de formation" height="103" width="71"></a>
		</div>
		<div id="logo4">
			<a href="http://www.activconsult-ing.com/nos_offres1.html"><img src="http://www.activconsult-ing.com/img/Menu_rose_des_vents.png" alt="Nos offres" height="93" width="71"></a>
		</div>
		<div id="logo5">
			<a href="http://www.activconsult-ing.com/domaines_activites.html"><img src="http://www.activconsult-ing.com/img/Menu_noeuds.png" alt="Domaines d'activités" height="103" width="72"></a>
		</div>
		<div id="logo6">
			<a href="http://www.activconsult-ing.com/recrutement_rh.html"><img src="http://www.activconsult-ing.com/img/Menu_capitaine.png" alt="Recrutement RH" height="103" width="71"></a>
		</div>
		<div id="logo8">
			<a href="http://www.activconsult-ing.com/ressources_externes.html"><img src="http://www.activconsult-ing.com/img/Menu_bouée.png" alt="Ressouces externes" height="103" width="71"></a>
		</div>
		<div id="logo7">
			<a href="http://www.activconsult-ing.com/contact.html"><img src="http://www.activconsult-ing.com/img/Menu_gouvernail.png" alt="Contact" height="93" width="71"></a>
		</div>
		<div id="titre1">ENTREPRISE DE SERVICES DU NUMERIQUE</div>
		<div id="menu3">
			<img src="http://www.activconsult-ing.com/img/Objet_dynamique_vectoriel.png" alt="" height="57" width="342">
		</div>
		<div id="ogol1">
			<img src="http://www.activconsult-ing.com/img/Menu_pagaies2.png" alt="" height="71" width="71">
		</div>
		<div id="tlogo">INFORMATIONS</div>
		<div id="info2">
			<%
				Personne personne = (Personne) session.getAttribute("candidat");
			%>


			<h2>Informations personnelles du candidat</h2>

			<div ID=formu37>

				<label>Connect&eacute; en tant que : <%=session.getAttribute("NomAdmin")%></label>

			</div>

			<div ID=formu38>

				<label>Candidat : <%= personne.getNom()%> <%= personne.getPrenom() %></label>

			</div>
			<div style="overflow : auto; width : 680px; height : 480px">
				<form method="post" action="http://localhost:8080/ProjectBAIT/ServletListeCandidatsAdmin">

					<input type="submit" name="retour" value="Retour" style="margin-left : 300px">
				</form>
				<form method="post" action="" style="margin-bottom : 50px">
					<input style="margin-left : 180px" type="submit" name="bloquer" value="Bloquer"><input type="text" name="raison" value="Entrer une raison" style="height : 50px;width : 200px"> 
				</form>

				<table>
					<caption>Etat civil</caption>
					<tr>
						<td>Nom : <%= personne.getNom()%></td>
					
					<td>Prenom : <%= personne.getPrenom() %></td></tr>
					<tr><td>Date de naissance : <%= personne.getDateNaissance()%></td>
						<td>Lieu : <%=personne.getLieuNaissance()%></td></tr>
					<tr>
						<td COLSPAN=2>Nationalit&eacute; : <%=personne.getNationalite()%></td></tr>
					<tr>
						<td COLSPAN=2>email : <%=personne.getEmail()%></td></tr>
				</table>

				<table>
					<caption>Coordonn&eacute;es</caption>
					<tr>
						<td COLSPAN=2>Adresse : <%=personne.getAdresse()%>
					<tr>
						<td>Code Postal : <%=personne.getcP()%>
						<td>Ville : <%=personne.getVille()%>
					<tr>
						<td>T&eacute;l&eacute;phone fixe : <%= personne.getTelFixe()%>
						<td>T&eacute;l&eacute;phone portable : <%= personne.getTelPort()%> 
					<tr>
						<td>Fax : <%=personne.getFax()%>
						<td>email : <%=personne.getEmail()%>
				</table>

				<table>
					<caption>Situation Actuelle</caption>
					<tr><td style="width : 500px">Situation : <%=personne.getSituation()%>
				</table>

				<table>
					<caption>Rémunération souhaitée</caption>
					<tr>
						<td>Fonction occupée : <%=personne.getFonction()%>
						<td>Cadre : <%=personne.isCadre()%>
					<tr>
						<td>Position : <%=personne.getPosition()%>
						<td>Coefficient : <%=personne.getCoeff()%>
					<tr>
						<td colspan=2>Salaire souhaité : <%=personne.getSalaire()%>
					<tr>
						<td>Mutuelle souhaitée : <%=personne.isMutuelle()%>
						<td>Ticket resto : <%=personne.isTicket()%>
					<tr>
						<td COLSPAN=2>Date de la dernière visite médicale : <%=personne.getVisiteMedicale()%>
					<tr>
						<td COLSPAN=2>Montant carte d'abonnement transport : <%=personne.getMontantTransport()%>
					<tr>
						<td>Véhicule personnel : <%=personne.isVoiture()%>
						<td>Nombre de CV : <%=personne.getNbCV()%>
					<tr>
						<td COLSPAN=2>Mensuel estimé : <%=personne.getNdKm()%>
				</table>

			
				<div></div>

			</div>






		</div>
		<div id="fpage2">
			<img src="http://www.activconsult-ing.com/img/Article_fond_blanc_double_copie.png">
			<div id="Facebook2">
				<img src="http://www.activconsult-ing.com/img/Facebook.png">
			</div>
			<div id="linkedin2">
				<img src="http://www.activconsult-ing.com/img/Linkedin.png">
			</div>
			<div id="viadeo2">
				<img src="http://www.activconsult-ing.com/img/Viadeo.png">
			</div>
			<div id="droit2">©1997-2012 - Tous droits de reproduction et de représentation réservés | Mentions légales</div>
		</div>

	</div>

</body>
</html>