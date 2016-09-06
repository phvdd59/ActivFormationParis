<%@page import="com.formation.thcr.dao.DAOPersonne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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

			<form action="http://localhost:8080/ProjectJMST/jsp/chgt.jsp"
				method='post'>
				<table border="1">
					<caption>
						<h1>Changement mot de passe</h1>
					</caption>
 	<% 
 	String noSerieHtml = request.getParameter("noSerie");
	String noSerie = (String) session.getAttribute("noSerie");
	Object p = session.getAttribute("Personne");
	Personne personne = null;

	if (p instanceof Personne) {
		personne = (Personne) p;
	}

	if (noSerie.equals(noSerieHtml)) {
	%>	
					
					<tr>
						<th colspan="4" style="width: 627px;"> Ancien Mot de passe</th>
						<th style="width: 273px; height: 25px; color:;">
						<input type="password" name="ancienMdp" value='' style="width: 270px;"></th>
					</tr>
					<tr>
						<th colspan="4" style="width: 627px;">Nouveau Mot de passe</th>
						<th style="width: 273px; height: 25px; color:;">
						<input id="newMdp1" onblur="ctrMdp1()" type="password" name="newMdp1" value='' style="width: 270px;"><br> <span
							id="spanMdp1"></span></th>
					</tr>
					<tr>
						<th colspan="4" style="width: 627px;">Nouveau Mot de passe</th>
						<th style="width: 273px; height: 25px; color:;">
						<input id="newMdp2"  onblur="ctrMdp2()" type="password" name="newMdp2" value='' style="width: 270px;"><br> <span
							id="spanMdp2"></span></th>
					</tr>
				</table>

				<input type="submit" name="Valider" value="Valider"></input>
				<input type="hidden" name="noSerie" value="<%=noSerie%>">
			</form>
			<form action="http://localhost:8080/ProjectJMST/ServletDeco" method='get'>
				<input type="submit" value="Deconnexion"></input> 
				<input type="hidden" name="noSerie" value="<%=noSerie%>">
			</form>

<script type="text/javascript">
function ctrMdp1() {
	var mdp= document.getElementById("new mdp 1");
	var no = mdp.value.length;

	var spanMdp1 = document.getElementById("spanMdp1");
	if (no<6) {
		spanMdp1.innerHTML = "Le mot de passe doit contenir au moins 6 caracteres.";
		mdp.style.border = "1px solid #ff0000";

		return false;
	} else {
		mdp.style.border = "inherit";
		spanMdp1.innerHTML = "";
		return true;
	}
}

function ctrMdp2() {
	var mdp1= document.getElementById("new mdp 1");
	var mdp2= document.getElementById("new mdp 2");
	
	var spanMdp2 = document.getElementById("spanMdp2");
	if (mdp2.value!=mdp1.value) {
		spanMdp2.innerHTML = "Les mots de passe doivent être identiques.";
		mdp2.style.border = "1px solid #ff0000";
		return false;
	} else {
		mdp2.style.border = "inherit";
		spanMdp2.innerHTML = "";
		return true;
	}
}

</script>


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
	
	
	}else{
// 		forward();
	}%>
		<script type="text/javascript" src="Test.js"></script>

</body>
</html>