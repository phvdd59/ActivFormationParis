<%@page import="com.formation.thcr.conversion.ConversionPersonne"%>
<%@page import="com.formation.joca.controleur.CtrlPersonne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.formation.thcr.metier.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input[type="submit"]{
width:25%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire</title>
<link href="http://www.activconsult-ing.com/Home.css" rel="stylesheet"
	type="text/css">

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
				width="382" height="57" alt="" />
		</div>
		<div id="ogol1">
			<img src="http://www.activconsult-ing.com/img/Menu_pagaies2.png"
				width="71" height="71" alt="" />
		</div>
		<div id="tlogo">FONCTION/REMUNERATION</div>
		<div id="info2">
			<!-- zone disponible -->
			<%
				Personne personne = null;
				Object p = session.getAttribute("Personne");
				String noSerieHtml = request.getParameter("noSerie");
				String noSerie = (String) session.getAttribute("noSerie");

				if (p instanceof Personne) {
					personne = (Personne) p;			
				}

				ConversionPersonne conv = new ConversionPersonne();
				
				CtrlPersonne ctrl = new CtrlPersonne();
				String sSituation = request.getParameter("situation");
				if (noSerie.equals(noSerieHtml)) {
					// 					if (ctrl.ctrlSituation(sSituation)) {
					personne.setSituation(sSituation);
					// 					} else {
					// 						FORWARD TO DECO
					// 					}
			%>
			<!--	<form= action:"http://www.souadkad.fr/soka/identification.html"></form>-->
			<form action="http://localhost:8080/ProjectJMST/ServletUpdate"
				method='post'>
				<table border="1">

					<tr>
						<td>Fonction occupée:</td>
						<%
							if (personne.isCadre()) {
						%>
						<td style="width: 273px; height: 25px; color:;"><input
							id="fonction" type="text" name="fonction" value='<%=personne.getFonction() %>'
							onblur="ctrFonction()"><br> <span id="spanFonction"></span></td>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="Cadre" value="oui" checked="checked">
							Cadre</td>
						<td style="width: 116px;"><input type="radio" name="Cadre"
							value="non"> Non cadre</td>
						<%
							} else {
						%>
						<td style="width: 273px; height: 25px; color:;"><input
							id="fonction" type="text" name="fonction" value='<%=personne.getFonction() %>'
							onblur="ctrFonction()"><br> <span id="spanFonction"></span></td>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="Cadre" value="oui"> Cadre</td>
						<td style="width: 116px;"><input type="radio" name="Cadre"
							value="non" checked="checked"> Non cadre</td>
						<%
							}
						%>
					</tr>
					<tr>
						<td>Position</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="position" type="text" name="position"
							value='<%=personne.getPosition()%>' style="width: 270px;"
							onblur="ctrPosition()"><br>
							<span id="spanPosition"></span></td>
						<td style="width: 72px;">Coefficient</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="coefficient" type="text" name="coefficient"
							value='<%=personne.getCoeff()%>' onblur="ctrCoefficient()"><br> <span
							id="spanCoefficient"></span></td>
					</tr>
					<tr>
						<td>Salaire souhaité</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="salaireSouhaite" type="text" name="salaireSouhaite"
							value='<%=personne.getSalaire()%>' onblur="ctrSalaireSouhaite()"
							style="width: 615px;"><br>
							<span id="spanSalaireSouhaite"></span></td>
					</tr>
					<tr>
						<td>Mutuelle souhaitée:</td>
						<%
							if (personne.isMutuelle()) {
						%>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="mutuelle" value="oui" checked="checked">
							oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="mutuelle" value="non"> non</td>
						<%
							} else {
						%>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="mutuelle" value="oui"> oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="mutuelle" value="non" checked="checked"> non</td>
						<%
							}
						%>
					</tr>
					<tr>
						<td>Ticket resto:</td>
						<%
							if (personne.isTicketResto()) {
						%>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="ticketResto" value="oui" checked="checked">
							oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="ticketResto" value="non"> non</td>
						<%
							} else {
						%>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="ticketResto" value="oui"> oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="ticketResto" value="non" checked="checked"> non</td>
						<%
							}
						%>
					</tr>
					<tr>
						<td>Date de la dernière visite médicale</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="dateVisiteMedicale" type="date" name="dateVisiteMedicale"
							value='<%=conv.conversionSQLToUtil(new java.sql.Date(personne.getVisiteMedicale().getTime()))%>' 
							onblur="ctrDateVisiteMedicale()" style="width: 615px;"><br>
							<span id="spanDateVisiteMedicale"></span></td>
					</tr>
					<tr>
						<td>Montant carte d'abonnement Transports</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="montantTransport" type="text" name="carteDeTransport"
							value='<%=personne.getMontantTransport()%>' 
							onblur="ctrMontantTransport()" style="width: 615px;"><br>
							<span id="spanMontantTransport"></span></td>
					</tr>
					<tr>
						<td>Vehicule personnel:</td>
						<%
							if (personne.isVoiture()) {
						%>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="vehiculePerso" value="oui" checked="checked">
							oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="vehiculePerso" value="non"> non</td>
						<%
							} else {
						%>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="vehiculePerso" value="oui"> oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="vehiculePerso" value="non" checked="checked"> non</td>
						<%
							}
						%>
					</tr>
					<tr>
						<td>Nombre de CV</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="nbChevaux" type="text" name="nbDeCV"
							value='<%=personne.getNbCV()%>' onblur="ctrNbChevaux()" style="width: 270px;"><br>
							<span id="spanNbChevaux"></span></td>
						<td style="width: 116px;">Km mensuel estimé</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="kmMensuel" type="text" name="kmMensuel "
							value='<%=personne.getNbKm()%>' onblur="ctrKmMensuel()"><br> <span
							id=spanKmMensuel></span></td>
					</tr>
				</table>
				<input type="submit" value="Terminer"></input> <input type="hidden"
					name="noSerie" value="<%=noSerie%>">
			</form>
<!-- 			<form action="http://localhost:8080/ProjectJMST/jsp/Part4.jsp" -->
<!-- 				method='post'> -->
<!-- 				<input type="submit" value="Precedent"></input> <input type="hidden" -->
<%-- 					name="noSerie" value="<%=noSerie%>"> --%>
<!-- 			</form> -->
			<form action="http://localhost:8080/ProjectJMST/ServletDeco"
				method='get'>
				<input type="submit" value="Deconnexion"></input> <input
					type="hidden" name="noSerie" value="<%=noSerie%>">
			</form>
			<form action="">
				<input type="button" name="check" value="check" onclick="ctrAll()" />
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
		<%
			}
		%>
	</div>
	
	<script type="text/javascript">
		function ctrAll() {
			var fonctionOk = ctrFonction();
			var posOk = ctrPosition();
			var coeffOk = ctrCoefficient();
			var salaireOk = ctrSalaireSouhaite();
			var dateOk = ctrDateVisiteMedicale();
			var montantOk = ctrMontantTransport();
			var nbChevauxOk = ctrNbChevaux();
			var kmOk = ctrKmMensuel();

			if (fonctionOk && posOk && coeffOk && salaireOk && dateOk
					&& montantOk && nbChevauxOk && kmOk) {
				return true
			} else {
				alert("Veuillez remplir les champs obligatoires");
				return false;
			}

		}

		function ctrFonction() {
			var fonction = document.getElementById("fonction");
			//var no = position.value.length;
			var pattFonction = new RegExp("^[a-zA-Z\\-\\'\\s]+$");
			var spanFonction = document.getElementById("spanFonction");
			if (fonction.value == "") {
				fonction.style.border = "inherit";
				fonction.style.backgroundColor = "#66ff99";
				spanFonction.innerHTML = "OK";
				return true;
			} else if (pattFonction.test(fonction.value) == false) {
				//spanPosition.className = "messageErreur";
				spanFonction.innerHTML = "Veuillez verifier les caractères utilisés('- acceptés).";
				fonction.style.border = "1px solid #f00";
				fonction.style.backgroundColor = "#fba";
				return false;
			} else {
				fonction.style.border = "inherit";
				fonction.style.backgroundColor = "#66ff99";
				spanFonction.innerHTML = "OK";
				return true;
			}
		}

		function ctrPosition() {
			var position = document.getElementById("position");
			var no = position.value.length;
			var pattPosition = new RegExp("^[1-9][0-9]+$");
			var spanPosition = document.getElementById("spanPosition");
			if (position.value == "") {
				position.style.border = "inherit";
				position.style.backgroundColor = "#66ff99";
				spanPosition.innerHTML = "OK";
				return true;
			} else if (pattPosition.test(position.value) == false) {
				//spanPosition.className = "messageErreur";
				spanPosition.innerHTML = "Veuillez verifier les caractères utilisés('- acceptés).";
				position.style.border = "1px solid #f00";
				position.style.backgroundColor = "#fba";
				return false;
			} else {
				position.style.border = "inherit";
				position.style.backgroundColor = "#66ff99";
				spanPosition.innerHTML = "OK";
				return true;
			}
		}

		function ctrCoefficient() {
			var coefficient = document.getElementById("coefficient");
			var no = coefficient.value.length;
			var pattCoefficient = new RegExp("^[0-9]{3}$");
			var spanCoefficient = document.getElementById("spanCoefficient");
			if (coefficient.value == "") {
				coefficient.style.border = "inherit";
				coefficient.style.backgroundColor = "#66ff99";
				spanCoefficient.innerHTML = "Ok";
				return true;
			} else if (pattCoefficient.test(coefficient.value) == false) {
				//spanCoefficient.className = "messageErreur";
				spanCoefficient.innerHTML = "Veuillez entrer 3 chiffres.";
				coefficient.style.border = "1px solid #f00";
				coefficient.style.backgroundColor = "#fba";
				return false;
			} else {
				coefficient.style.border = "inherit";
				coefficient.style.backgroundColor = "#66ff99";
				spanCoefficient.innerHTML = "Ok";
				return true;
			}
		}

		function ctrSalaireSouhaite() {
			var salaireSouhaite = document.getElementById("salaireSouhaite");
			var no = salaireSouhaite.value.length;
			var pattSalaireSouhaite = new RegExp("^[1-9][0-9]+$");
			var spanSalaireSouhaite = document
					.getElementById("spanSalaireSouhaite");
			if (pattSalaireSouhaite.test(salaireSouhaite.value) == false) {
				//spanSalaireSouhaite.className = "messageErreur";
				spanSalaireSouhaite.innerHTML = "Veuillez entrer un nombre.";
				salaireSouhaite.style.border = "1px solid #f00";
				salaireSouhaite.style.backgroundColor = "#fba";
				return false;
			} else {
				salaireSouhaite.style.border = "inherit";
				salaireSouhaite.style.backgroundColor = "#66ff99";
				spanSalaireSouhaite.innerHTML = "OK";
				return true;
			}
		}
		function ctrDateVisiteMedicale() {
			var dateVisiteMedicale = document
					.getElementById("dateVisiteMedicale");
			var no = dateVisiteMedicale.value.length;
			var pattDateVisiteMedicale = new RegExp(
					"(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$");
			var spanDateVisiteMedicale = document
					.getElementById("spanDateVisiteMedicale");
			if (pattDateVisiteMedicale.test(dateVisiteMedicale.value) == false) {
				//spanDateVisiteMedicale.className = "messageErreur";
				spanDateVisiteMedicale.innerHTML = "la date s'écrit suivant le format \"jj-mm-aaaa\"";
				dateVisiteMedicale.style.border = "1px solid #f00";
				dateVisiteMedicale.style.backgroundColor = "#fba";
				return false;
			} else {
				dateVisiteMedicale.style.border = "inherit";
				dateVisiteMedicale.style.backgroundColor = "#66ff99";
				spanDateVisiteMedicale.innerHTML = "OK";
				return true;
			}
		}

		function ctrMontantTransport() {
			var montantTransport = document.getElementById("montantTransport");
			var no = montantTransport.value.length;
			var pattMontantTransport = new RegExp(
					"[1-9][0-9]+");
			var spanMontantTransport = document
					.getElementById("spanMontantTransport");
			if (montantTransport.value == "") {
				montantTransport.style.border = "inherit";
				montantTransport.style.backgroundColor = "#66ff99";
				spanMontantTransport.innerHTML = "OK";
				return true;
			} else if (pattMontantTransport.test(montantTransport.value) == false) {
				//spanMontantTransport.className = "messageErreur";
				spanMontantTransport.innerHTML = "Veuillez entrer un nombre.";
				montantTransport.style.border = "1px solid #f00";
				montantTransport.style.backgroundColor = "#fba";
				return false;
			} else {
				montantTransport.style.border = "inherit";
				montantTransport.style.backgroundColor = "#66ff99";
				spanMontantTransport.innerHTML = "OK";
				return true;
			}
		}

		function ctrNbChevaux() {
			var nbChevaux = document.getElementById("nbChevaux");
			var no = nbChevaux.value.length;
			var pattNbChevaux = new RegExp("^[1-9][0-9]+$");
			var spanNbChevaux = document.getElementById("spanNbChevaux");
			if (nbChevaux.value==""){
				nbChevaux.style.border = "inherit";
				nbChevaux.style.backgroundColor = "#66ff99";
				spanNbChevaux.innerHTML = "OK";
				return true;
			} else if (pattNbChevaux.test(nbChevaux.value) == false) {
				//spanNbChevaux.className = "messageErreur";
				spanNbChevaux.innerHTML = "Entrez le nombre fiscaux du vehicule.";
				nbChevaux.style.border = "1px solid #f00";
				nbChevaux.style.backgroundColor = "#fba";
				return false;
			} else {
				nbChevaux.style.border = "inherit";
				nbChevaux.style.backgroundColor = "#66ff99";
				spanNbChevaux.innerHTML = "OK";
				return true;
			}
		}

		function ctrKmMensuel() {
			var kmMensuel = document.getElementById("kmMensuel");
			var no = kmMensuel.value.length;
			var pattKmMensuel = new RegExp("^[1-9][0-9]+$");
			var spanKmMensuel = document.getElementById("spanKmMensuel");
			if (kmMensuel.value==""){
				kmMensuel.style.border = "inherit";
				kmMensuel.style.backgroundColor = "#66ff99";
				spanKmMensuel.innerHTML = "OK";
				return true;
			} else if (pattKmMensuel.test(kmMensuel.value) == false) {
				//spanKmMensuel.className = "messageErreur";
				spanKmMensuel.innerHTML = "Entrez le nombre de kilomètres.";
				kmMensuel.style.border = "1px solid #f00";
				kmMensuel.style.backgroundColor = "#fba";
				return false;
			} else {
				kmMensuel.style.border = "inherit";
				kmMensuel.style.backgroundColor = "#66ff99";
				spanKmMensuel.innerHTML = "OK";
				return true;
			}
		}
	</script>
</body>
</html>