<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.formation.thcr.metier.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire</title>
<link href="http://www.activconsult-ing.com/Home.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript">
	function ctrAll() {
		ctrPosition();
		ctrCoefficient();
		ctrSalaireSouhaite();
		ctrDateVisiteMedicale();
		ctrMontantTransport();
		ctrNbChevaux();
		ctrKmMensuel();
	}

	function ctrPosition() {
		var position = document.getElementById("position");
		var no = position.value.length;
		var pattPosition = new RegExp("[^a-zA-ZÀ-ÿ]");
		var spanPosition = document.getElementById("spanPosition");
		if (pattPosition.test(position.value)) {
			spanPosition.className = "messageErreur";
			spanPosition.innerHTML = "le champ ne doit pas contenir de caractères spéciaux.";
			position.style.border = "1px solid #ff0000";
			return false;
		} else {
			position.style.border = "inherit";
			spanPosition.innerHTML = "";
			return true;
		}
	}

	function ctrCoefficient() {
		var coefficient = document.getElementById("coefficient");
		var no = coefficient.value.length;
		var pattCoefficient = new RegExp("(^[0-9])$");
		var spanCoefficient = document.getElementById("spanCoefficient");
		if (pattCoefficient.test(coefficient.value) == false) {
			spanCoefficient.className = "messageErreur";
			spanCoefficient.innerHTML = "Entrez un nombre entre 0 et 9.";
			coefficient.style.border = "1px solid #ff0000";
			return false;
		} else {
			coefficient.style.border = "inherit";
			spanCoefficient.innerHTML = "";
			return true;
		}
	}

	function ctrSalaireSouhaite() {
		var salaireSouhaite = document.getElementById("salaireSouhaite");
		var no = salaireSouhaite.value.length;
		var pattSalaireSouhaite = new RegExp("(^[0-9]+$)");
		var spanSalaireSouhaite = document
				.getElementById("spanSalaireSouhaite");
		if (pattSalaireSouhaite.test(salaireSouhaite.value) == false) {
			spanSalaireSouhaite.className = "messageErreur";
			spanSalaireSouhaite.innerHTML = "Entrez un nombre.";
			salaireSouhaite.style.border = "1px solid #ff0000";
			return false;
		} else {
			salaireSouhaite.style.border = "inherit";
			spanSalaireSouhaite.innerHTML = "";
			return true;
		}
	}
	function ctrDateVisiteMedicale() {
		var dateVisiteMedicale = document.getElementById("dateVisiteMedicale");
		var no = dateVisiteMedicale.value.length;
		var pattDateVisiteMedicale = new RegExp("(0[1-9]|[12][0-9]|3[01])(\/)(0[1-9]|1[0-2])(\/)(19|20)[0-9]{2}$");
		var spanDateVisiteMedicale = document.getElementById("spanDateVisiteMedicale");
		if (pattDateVisiteMedicale.test(dateVisiteMedicale.value) == false) {
			spanDateVisiteMedicale.className = "messageErreur";
			spanDateVisiteMedicale.innerHTML = "la date s'écrit suivant le format \"jj/mm/aaaa\"";
			dateVisiteMedicale.style.border = "1px solid #ff0000";
			return false;
		} else {
			dateVisiteMedicale.style.border = "inherit";
			spanDateVisiteMedicale.innerHTML = "";
			return true;
		}
	}

	function ctrMontantTransport() {
		var montantTransport = document.getElementById("montantTransport");
		var no = montantTransport.value.length;
		var pattMontantTransport = new RegExp("(^[0-9]+$)");
		var spanMontantTransport = document.getElementById("spanMontantTransport");
		if (pattMontantTransport.test(montantTransport.value) == false) {
			spanMontantTransport.className = "messageErreur";
			spanMontantTransport.innerHTML = "Entrez un nombre.";
			montantTransport.style.border = "1px solid #ff0000";
			return false;
		} else {
			montantTransport.style.border = "inherit";
			spanMontantTransport.innerHTML = "";
			return true;
		}
	}

	function ctrNbChevaux() {
		var nbChevaux = document.getElementById("nbChevaux");
		var no = nbChevaux.value.length;
		var pattNbChevaux = new RegExp("(^[0-9])$");
		var spanNbChevaux = document.getElementById("spanNbChevaux");
		if (pattNbChevaux.test(nbChevaux.value) == false) {
			spanNbChevaux.className = "messageErreur";
			spanNbChevaux.innerHTML = "Entrez le nombre entre 1 et 9 de chevaux fiscaux du vehicule.";
			nbChevaux.style.border = "1px solid #ff0000";
			return false;
		} else {
			nbChevaux.style.border = "inherit";
			spanNbChevaux.innerHTML = "";
			return true;
		}
	}

	function ctrKmMensuel() {
		var kmMensuel = document.getElementById("kmMensuel");
		var no = kmMensuel.value.length;
		var pattKmMensuel = new RegExp("(^[0-9]+$)");
		var spanKmMensuel = document.getElementById("spanKmMensuel");
		if (pattKmMensuel.test(kmMensuel.value) == false) {
			spanKmMensuel.className = "messageErreur";
			spanKmMensuel.innerHTML = "Entrez le nombre de kilomètres.";
			kmMensuel.style.border = "1px solid #ff0000";
			return false;
		} else {
			kmMensuel.style.border = "inherit";
			spanKmMensuel.innerHTML = "";
			return true;
		}
	}
</script>
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
		<div id="tlogo">CENTRE DE FORMATION</div>
		<div id="info2">
			<!-- zone disponible -->
	<% 
 	Personne personne = null;
	Object o = session.getAttribute("Personne");
	
	if(o instanceof Personne){
		personne = (Personne) o;
	}
	%>	
			<form= action:"http://www.souadkad.fr/soka/identification.html"></form>

			<form action="http://localhost:8080/ProjectJMST/ServletJOCA1"
				method='post'>
				<table border="1">

					<tr>
						<th colspan="4">Fonction/Remuneration</th>

					</tr>
					<tr>
						<td>Fonction occupée:</td>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="fonction occupee"
							value="<%=personne.isCadre()%>"> Cadre</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="fonction occupee" value="<%=personne.isCadre() %>"
							checked="checked"> Non cadre</td>
					</tr>
					<tr>
						<td>Position</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="position" type="text" name="position" value='<%=personne.getPosition() %>'
							style="width: 270px;"><br> <span id="spanPosition"></span></td>
						<td style="width: 72px;">Coefficient</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="coefficient" type="text" name="coefficient" value='<%=personne.getCoeff()%>'><br>
							<span id="spanCoefficient"></span></td>
					</tr>
					<tr>
						<td>Salaire souhaité</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="salaireSouhaite" type="text" name="salaire souhaite" value='<%=personne.getSalaire() %>'
							style="width: 615px;"><br> <span
							id="spanSalaireSouhaite"></span></td>
					</tr>
					<tr>
						<td>Mutuelle souhaitée:</td>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="mutuelle"
							value="<%=personne.isMutuelle() %>"> oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="mutuelle" value="<%=personne.isMutuelle() %>"
							checked="checked"> non</td>
					</tr>
					<tr>
						<td>Ticket resto:</td>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="ticket resto" value="<%=personne.isTicketResto()%>">
							oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="ticket resto" value="<%=personne.isTicketResto()%>" checked="checked">
							non</td>
					</tr>
					<tr>
						<td>Date de la dernière visite médicale</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="dateVisiteMedicale" type="text" name="date visite medicale"
							value='<%=personne.getVisiteMedicale() %>' style="width: 615px;"><br> <span
							id="spanDateVisiteMedicale"></span></td>
					</tr>
					<tr>
						<td>Montant carte d'abonnement Transports</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="montantTransport" type="text" name="carte de transport"
							value='<%=personne.getMontantTransport()%>' style="width: 615px;"><br> <span
							id="spanMontantTransport"></span></td>
					</tr>
					<tr>
						<td>Vehicule personnel:</td>
						<td style="width: 273px; height: 25px; color:;"><input
							type="radio" name="vehicule perso"
							value="<%=personne.isVoiture()%>"> oui</td>
						<td colspan="2" style="width: 116px;"><input type="radio"
							name="vehicule perso" value="<%=personne.isVoiture() %>"
							checked="checked"> non</td>
					</tr>
					<tr>
						<td>Nombre de CV</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="nbChevaux" type="text" name="nb de CV" value='<%=personne.getNbCV() %>'
							style="width: 270px;"><br> <span id="spanNbChevaux"></span></td>
						<td style="width: 116px;">Km mensuel estimé</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="kmMensuel" type="text" name="km mensuel " value='<%=personne.getNbKm()%>'><br>
						<span id=spanKmMensuel></span></td>
					</tr>
				</table>
				<input type="submit" value="Terminer"></input> <input type="hidden"
					name="noSerie" value="%%noSerie%%">
			</form>
			<form action="http://localhost:8080/ProjectJMST/jsp/Part4.jsp"
				method='post'>
				<input type="submit" value="Precedent"></input> <input type="hidden"
					name="noSerie" value="%%noSerie%%">
			</form>
			<form action="http://localhost:8080/ProjectJMST/ServletDeco"
				method='get'>
				<input type="submit" value="Deconnexion"></input> <input
					type="hidden" name="noSerie" value="%%noSerie%%">
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
</body>
</html>