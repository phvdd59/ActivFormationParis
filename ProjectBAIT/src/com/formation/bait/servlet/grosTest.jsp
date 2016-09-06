<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			<a href="http://www.activconsult-ing.com/domaines_activites.html"><img src="http://www.activconsult-ing.com/img/Menu_noeuds.png" alt="Domaines d'activit�s" height="103" width="72"></a>
		</div>
		<div id="logo6">
			<a href="http://www.activconsult-ing.com/recrutement_rh.html"><img src="http://www.activconsult-ing.com/img/Menu_capitaine.png" alt="Recrutement RH" height="103" width="71"></a>
		</div>
		<div id="logo8">
			<a href="http://www.activconsult-ing.com/ressources_externes.html"><img src="http://www.activconsult-ing.com/img/Menu_bou�e.png" alt="Ressouces externes" height="103" width="71"></a>
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



			<h2>Informations personnelles du candidat</h2>

			<div ID=formu37>

				<label>Connect&eacute; en tant que :<%=session.getAttribute("NomAdmin")%></label>

			</div>

			<div ID=formu38>

				<label>Candidat :<%=session.getAttribute("NomCandidat")%> <%=session.getAttribute("prenomCandidat")%></label>

			</div>
			<div style="overflow: auto; height: 500px">
				<form method="post" action="">

					<input type="submit" name="retour" value="Retour">
				</form>
				<form method="post" action="">
					<input type="text" name="raison" value="Entrer une raison"> <input type="submit" name="bloquer" value="Bloquer">
				</form>
				
				<table>
				<caption>Etat civil</caption>
				<tr><td> Nom : <%=session.getAttribute("NomCandidat")%></tr>
				<td>Prenom : <%=session.getAttribute("PrenomCandidat")%>tr>
				<tr>
				<td>Date de naissance : <%=session.getAttribute("dateNaissCandidat")%>
				<td>Lieu : <%=session.getAttribute("lieuNaissCandidat")%>
				<tr><td> Nationalit&eacute; : <%=session.getAttribute("nationaliteCandidat")%>
				<tr><td  ROWSPAN=2> email : <%=session.getAttribute("emailCandidat")%>
				</table>
				
				<table>
				<caption>Coordonn&eacute;e</caption>
				<tr><td COLSPAN=2>Adresse : <%=session.getAttribute("adresseCandidat")%>
				<tr><td>Code Postal : <%=session.getAttribute("cPCandidat")%>
				<td>Ville : <%=session.getAttribute("villeCandidat")%>
				<tr><td> T&eacute;l&eacute;phone fixe : <%=session.getAttribute("telFixeCandidat")%>
				<td> T&eacute;l&eacute;phone portable : <%=session.getAttribute("telPortCandidat")%>
				
				<tr><td> Fax : <%=session.getAttribute("faxCandidat")%>
				<td> email : <%=session.getAttribute("emailCandidat")%>
				</table>
				
				<table>
				<caption>Situation Actuelle</caption>
				<tr>Situation : <%=session.getAttribute("situationCandidat")%>
				</table>
				
				<table>
				<caption>R�mun�ration souhait�e</caption>
				<tr><td>Fonction occup�e <%=session.getAttribute("fonctionCandidat")%>
				<td>Cadre : <%=session.getAttribute("cadreCandidat")%>
				<tr><td> Position : <%=session.getAttribute("positionCandidat")%>
				<td> Coefficient : <%=session.getAttribute("coeffCandidat")%>
				<tr><td>Salaire souhait� : <%=session.getAttribute("salaireCandidat")%>
				<tr><td>Mutuelle souhait�e : <%=session.getAttribute("mutuelleCandidat")%>
				<td> Ticket resto : <%=session.getAttribute("ticketCandidat")%>
				<tr><td COLSPAN=2> Date de la derni�re visite m�dicale : <%=session.getAttribute("visiteMedicaleCandidat")%>
				<tr><td COLSPAN=2> Montant carte d'abonnement transport : <%=session.getAttribute("montantTransportCandidat")%>
				<tr><td>V�hicule personnel : <%=session.getAttribute("voitureCandidat")%>
				<td> Nombre de CV : <%=session.getAttribute("nbCVCandidat")%>
				<tr><td COLSPAN=2> Mensuel estim� : <%=session.getAttribute("nbKmCandidat")%>
				</table>
				
				
				<div>





</div>

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
			<div id="droit2">�1997-2012 - Tous droits de reproduction et de repr�sentation r�serv�s | Mentions l�gales</div>
		</div>

	</div>

</body>
</html>