<%@page import="com.formation.joca.controleur.CtrlPersonne"%>
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
			<!-- 			<form= action:"http://www.souadkad.fr/soka/identification.html"></form> -->

			<%
				String noSerieHtml = request.getParameter("noSerie");
				String noSerie = (String) session.getAttribute("noSerie");
				Object p = session.getAttribute("Personne");
				Personne personne = null;

				if (p instanceof Personne) {
					personne = (Personne) p;
				}

				CtrlPersonne ctrl = new CtrlPersonne();

				if (p instanceof Personne) {
					personne = (Personne) p;
				}
				String sNom = request.getParameter("nom");
				String sPrenom = request.getParameter("prenom");
				String sAdresse = request.getParameter("adresse");
				String sTelFixe = request.getParameter("tel fixe");
				String sTelPort = request.getParameter("tel portable");
				String sFax = request.getParameter("fax");
				String sCp = request.getParameter("code postale");
				String sVille = request.getParameter("ville");
				String sEmail = request.getParameter("mail");

				if (noSerie.equals(noSerieHtml)) {

// 					if (ctrl.ctrlNom(sNom) && ctrl.ctrlPrenom(sPrenom) && ctrl.ctrlAdresse(sAdresse)
// 							&& ctrl.ctrlTelFixe(sTelFixe) && ctrl.ctrlTelPort(sTelPort) && ctrl.ctrlFax(sFax)
// 							&& ctrl.ctrlCp(sCp) && ctrl.ctrlVille(sVille) && ctrl.ctrlEmail(sEmail)) {

						personne.setNom(sNom);
						personne.setPrenom(sPrenom);
						personne.setAdresse(sAdresse);
						personne.setTelFixe(sTelFixe);
						personne.setTelPort(sTelPort);
						personne.setFax(sFax);
						personne.setCp(sCp);
						personne.setVille(sVille);
						personne.setEmail(sEmail);

					//} 
// 					else {
// 						out.write("Erreur");
// 						Thread.sleep(2000);
			} else {
				out.write("Erreur");
				Thread.sleep(2000);
		%>
		<jsp:forward page="Deco.jsp"></jsp:forward>
		<%
			}
		%>



<%-- 			<jsp:forward page="Deco.jsp"></jsp:forward> --%>
<%-- 			<% --%>
<!-- // 				} -->
<%-- 			%> --%>
			<form action="http://localhost:8080/ProjectJMST/jsp/Part4.jsp"
				method='post'>
				<table border="1">

					<tr>
						<th colspan="4">Etat Civil</th>

					</tr>
					<tr>
						<td>Date de naissance</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="dateDeNaissance" type="date" name="date de naissance"
							value='<%=personne.getDateNaissance()%>' style="width: 270px;"><br>
							<span id="spanDateDeNaissance"></span></td>
						<td style="width: 72px;">Lieu de naissance</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="lieuDeNaissance" type="text" name="lieu de naissance"
							value='<%=personne.getLieuNaissance()%>'><br> <span
							id="spanLieuDeNaissance"></span></td>
					</tr>
					<tr>
						<td>N° sécurité Social</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="noSecuriteSociale" type="text" name="num secu"
							value='<%=personne.getNumSecu()%>' style="width: 615px;"><br>
							<span id="spanNoSecuriteSociale"></span></td>
					</tr>
					<tr>
						<td>Nationalité</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="nationalite" type="text" name="nationalite"
							value='<%=personne.getNationalite()%>' style="width: 615px;"><br>
							<span id="spanNationalite"></span></td>
					</tr>
				</table>

				<input type="submit" value="Suivant"></input> <input type="hidden"
					name="noSerie" value="%%noSerie%%">
			</form>
			<form action="http://localhost:8080/ProjectJMST/jsp/Part2.jsp"
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
				<input type="button" onclick="ctrAll()" value="check">
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
<script type="text/javascript">
	function ctrAll() {
		ctrDateDeNaissance();
		ctrLieuDeNaissance();
		ctrNoSecuriteSociale();
		ctrNationalite();

	}

	function ctrDateDeNaissance() {
		var dateDeNaissance = document.getElementById("dateDeNaissance");
		var no = dateDeNaissance.value.length;
		var pattDateDeNaissance = new RegExp(
				"(0[1-9]|[12][0-9]|3[01])(\/)(0[1-9]|1[0-2])(\/)(19|20)[0-9]{2}$");
		var spanDateDeNaissance = document
				.getElementById("spanDateDeNaissance");
		if (pattDateDeNaissance.test(dateDeNaissance.value) == false) {
			spanDateDeNaissance.className = "messageErreur";
			spanDateDeNaissance.innerHTML = "la date s'écrit suivant le format \"jj/mm/aaaa\"";
			dateDeNaissance.style.border = "1px solid #ff0000";
			return false;
		} else {
			dateDeNaissance.style.border = "inherit";
			spanDateDeNaissance.innerHTML = "";
			return true;
		}
	}
	function ctrLieuDeNaissance() {
		var lieuDeNaissance = document.getElementById("lieuDeNaissance");
		var no = lieuDeNaissance.value.length;
		var pattLieuDeNaissance = new RegExp("[^a-zA-ZÀ-ÿ]");
		var spanLieuDeNaissance = document
				.getElementById("spanLieuDeNaissance");
		if (no < 2 || pattLieuDeNaissance.test(lieuDeNaissance.value)) {
			spanLieuDeNaissance.className = "messageErreur";
			spanLieuDeNaissance.innerHTML = "le champ ne doit pas contenir de caractères spéciaux.";
			lieuDeNaissance.style.border = "1px solid #ff0000";
			return false;
		} else {
			lieuDeNaissance.style.border = "inherit";
			spanLieuDeNaissance.innerHTML = "";
			return true;
		}
	}

	function ctrNoSecuriteSociale() {
		var noSecuriteSociale = document.getElementById("noSecuriteSociale");
		var no = noSecuriteSociale.value.length;
		var pattNoSecuriteSociale = new RegExp("^(1|2)([0-9]{13})$");
		var spanNoSecuriteSociale = document
				.getElementById("spanNoSecuriteSociale");
		if (pattNoSecuriteSociale.test(noSecuriteSociale.value) == false) {
			spanNoSecuriteSociale.className = "messageErreur";
			spanNoSecuriteSociale.innerHTML = "Le numéro de sécurité sociale commence par 1 ou 2 et comporte 15 chiffres.";
			noSecuriteSociale.style.border = "1px solid #ff0000";
			return false;
		} else {
			noSecuriteSociale.style.border = "inherit";
			spanNoSecuriteSociale.innerHTML = "";
			return true;
		}
	}
	function ctrNationalite() {
		var nationalite = document.getElementById("nationalite");
		var no = nationalite.value.length;
		var pattNationalite = new RegExp("[^a-zA-ZÀ-ÿ]");
		var spanNationalite = document.getElementById("spanNationalite");
		if (no < 2 || pattNationalite.test(nationalite.value)) {
			spanNationalite.className = "messageErreur";
			spanNationalite.innerHTML = "le champ ne doit pas contenir de caractères spéciaux.";
			nationalite.style.border = "1px solid #ff0000";
			return false;
		} else {
			nationalite.style.border = "inherit";
			spanNationalite.innerHTML = "";
			return true;
		}
	}
</script>
</html>