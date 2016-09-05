<%@page import="com.formation.thcr.conversion.ConversionPersonne"%>
<%@page import="com.formation.joca.controleur.CtrlPersonne"%>
<%@page import="com.formation.joca.controleur.CtrlDocPerso"%>
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
	function ctrSituationPro() {
		var situationPro = document.getElementByName("situationPro");
		alert(situationPro);
		for (var i = 0; situationPro.length; i++) {
			if (!situationPro[i].checked) {
				getElementById("spanSituationPro").innerHTML = "Veuillez choisir un champs.";
				alert("ça marche pas)");
			}
		}
		alert("ça marche");
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

			<!-- 			<form= action:"http://www.souadkad.fr/soka/identification.html"></form> -->

			<%
				Personne personne = null;
				Object p = session.getAttribute("Personne");
				String noSerieHtml = request.getParameter("noSerie");
				String noSerie = (String) session.getAttribute("noSerie");

				if (p instanceof Personne) {
					personne = (Personne) p;
				}

				CtrlPersonne ctrl = new CtrlPersonne();
				ConversionPersonne conv = new ConversionPersonne();

				String sDateNaissance = request.getParameter("date de naissance");
				String sLieuNaissance = request.getParameter("lieu de naissance");
				String sNumSecu = request.getParameter("num secu");
				String sNationalite = request.getParameter("nationalite");

				if (noSerie.equals(noSerieHtml)) {
					// 					if (ctrl.ctrlDateNaissance(sDateNaissance) && ctrl.ctrlLieuNaissance(sLieuNaissance) && ctrl.ctrlNumSecu(sNumSecu)
					// 							&& ctrl.ctrlNationalite(sNationalite)) {
					personne.setDateNaissance(conv.conversionDate(sDateNaissance));
					personne.setLieuNaissance(sLieuNaissance);
					personne.setNumSecu(sNumSecu);
					if (personne.getNumSecu().charAt(0) == '1') {
						personne.setSexe(new Sexe(Sexe.MASCULIN));
					} else {
						personne.setSexe(new Sexe(Sexe.FEMININ));
					}
					personne.setNationalite(sNationalite);
					// 					} else {
					// 						out.write("Erreur");
					// 						Thread.sleep(2000);
					//						FORWARD TO DECO
					// 					}

					//String situation = personne.getEnumSituation().getNom(); 
					//String situation = (SITUATION.valueOf(personne.getSituation())).getNom();
					String situation = personne.getSituation();
			%>
			<form action="http://localhost:8080/ProjectJMST/jsp/Part5.jsp"
				method='post'>
				<table border="1">

					<tr>
						<th colspan="4">Situation Actuelle</th>

					</tr>

					<tr>
						<td style="width: 272px; height: 25px;">Salarié</td>

						<%
							if (situation.equals("Salarie")) {
						%>
						<td><input type="radio" name="situation" value="Salarie"
							checked="checked"></td>
						<%
							} else {
						%>
						<td><input type="radio" name="situation" value="Salarie"></td>
						<%
							}
						%>
						<td style="width: 272px; height: 25px;">Auto-Entrepreneur</td>
						<%
							if (situation.equals("auto entrepreneur")) {
						%>
						<td><input type="radio" name="situation"
							value="auto entrepreneur" checked="checked"></td>
						<%
							} else {
						%>
						<td><input type="radio" name="situation"
							value="auto entrepreneur"></td>
						<%
							}
						%>
					</tr>

					<tr>
						<td style="width: 272px; height: 25px;">Freelance</td>
						<%
							if (situation.equals("freelance")) {
						%>
						<td><input type="radio" name="situation" value="freelance"
							checked="checked">
						</td>
						<%
							} else {
						%>
						<td><input type="radio" name="situation" value="freelance"></td>
						<%
							}
						%>
						<td style="width: 272px; height: 25px;">Demandeur d'emploi</td>
						<%
							if (situation.equals("demandeur d'emploi")) {
						%>
						<td><input type="radio" name="situation"
							value="demandeur d'emploi" checked="checked"></td>
						<%
							} else {
						%>
						<td><input type="radio" name="situation"
							value="demandeur d'emploi"></td>
						<%
							}
						%>
					</tr>

					<tr>
						<td style="width: 272px; height: 25px;">Retraité</td>
						<%
							if (situation.equals("retraite")) {
						%>
						<td><input type="radio" name="situation" value="retraite"
							checked="checked">
						</td>
						<%
							} else {
						%>
						<td><input type="radio" name="situation" value="retraite"></td>
						<%
							}
						%>
						<td style="width: 272px; height: 25px;">Autre</td>
						<%
							if (personne.getSituation().equals("")) {
						%>
						<td><input type="radio" name="situation" value=""
							checked="checked"></td>
						<td><input type="text" name="situationVal"
							value="<%=personne.getSituation()%>"></td>
						<%
							} else {
						%>
						<td><input type="radio" name="situation" value=""></td>
						<%
							}
						%>
					</tr>

				</table>

				<input type="submit" value="Suivant"></input> <input type="hidden"
					name="noSerie" value="<%=noSerie%>">
			</form>
			<form action="http://localhost:8080/ProjectJMST/jsp/Part3.jsp"
				method='post'>
				<input type="submit" value="Precedent"></input> <input type="hidden"
					name="noSerie" value="<%=noSerie%>">
			</form>
			<form action="http://localhost:8080/ProjectJMST/ServletDeco"
				method='get'>
				<input type="submit" value="Deconnexion"></input> <input
					type="hidden" name="noSerie" value="%<%=noSerie%>">
			</form>
			<form>
				<input type="button" value="check" onclick="ctrSituationPro()"></input>

			</form>

			<span style="text-align: center;" id="spanSituationPro"></span>

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
	
</body>
</html>