<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.formation.thcr.metier.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
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
		<div id="tlogo">LOGIN</div>
		<div id="info2">
			<!-- zone disponible -->
		
			<form action="http://localhost:8080/ProjectJMST/Test"
				method='post' onsubmit="return verifForm(this)">
				<table border="1">
<!-- 					<caption> -->
<!-- 						<h1></h1> -->
<!-- 					</caption> -->

					<tr>
						<th colspan="4" style="width: 627px;">Identifiant</th>
						<th style="width: 273px; height: 25px; color:;"><input
							id="identifiant" type="text" name="identifiant" value=''
							style="width: 270px;" onblur="verif_ident(this)"><span
							id="erreur2"></span></th>
					</tr>
					<tr>
						<th colspan="4" style="width: 627px;">Mot de passe</th>
						<th style="width: 273px; height: 25px; color:;"><input
							id="mdp1" type="password" name="mdp1" value='' style="width: 270px;"
							onblur="verif_mdp(this)"><span id="erreur"></span></th>
					</tr>
					<tr>
						<th colspan="4" style="width: 627px;">Mot de passe</th>
						<th style="width: 273px; height: 25px; color:;"><input
							id="mdp2" type="password" name="mdp2" value='' style="width: 270px;"
							onblur="verif_mdp2(this)"><span id="erreur3"></span></th>
					</tr>
				</table>

				<input type="submit" name="Suivant" value="Suivant"></input> <input
					type="hidden" name="noSerie" value="%%noSerie%%">
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
<script>
		function verif_ident(champ) {
			var pattIdent = new RegExp("^[a-zA-Z0-9\\-\\.\\_]{4,25}$");
			if (champ.value.length<4 || champ.value.length>25) {
				document.getElementById('erreur2').innerHTML = ' saisir un texte entre 4 et 25 caracteres';
				champ.style.border = "1px solid #f00";
				champ.style.backgroundColor = "#fba";
				return false;

			} else {
				if (pattIdent.test(champ.value) == false) {
					document.getElementById('erreur2').innerHTML = ' pas de caractere speciaux autre que -._';
					champ.style.border = "1px solid #f00";
					champ.style.backgroundColor = "#fba";
					return false;
				} else {
					document.getElementById('erreur2').innerHTML = ' OK';
					champ.style.border = "inherit";
					champ.style.backgroundColor = "#66ff99";
					return true
				}
			}
		}
		
		function mdp_egal(){
			var mdp1= document.getElementById("mdp1");
			var mdp2= document.getElementById("mdp2");
			if (mdp1.value == mdp2.value){
				return true;
			} else {
				return false;
			}
			
		}

		function verif_mdp(champ) {

			if (champ.value.length < 6) {
				document.getElementById('erreur').innerHTML = ' saisir un texte de 6 caracteres ou plus';
				champ.style.border = "1px solid #f00";
				champ.style.backgroundColor = "#fba";
				return false;
			} else {
				document.getElementById('erreur').innerHTML = ' OK';
				champ.style.border = "inherit";
				champ.style.backgroundColor = "#66ff99";
				return true
			}
		}

		function verif_mdp2(champ) {

			if (champ.value.length < 6) {
				document.getElementById('erreur3').innerHTML = ' saisir un texte de 6 caracteres ou plus';
				champ.style.border = "1px solid #f00";
				champ.style.backgroundColor = "#fba";
				return false;
			} else {
				document.getElementById('erreur3').innerHTML = ' OK';
				champ.style.border = "inherit";
				champ.style.backgroundColor = "#66ff99";
				return true
			}
		}

		function verifForm(f) {
			var identOk = verif_ident(f.identifiant);
			var mdpOk = verif_mdp(f.mdp1);
			var mdp2Ok = verif_mdp2(f.mdp2);
			var mdpEgal = mdp_egal();

			if (!(identOk && mdpOk && mdp2Ok)){
				alert("Veuillez remplir correctement tous les champs");
				return false;
			} else {
				if (mdpEgal){
					return true;
				} else {
					alert("mots de passe differents");
					return false;
				}
			}
		}
	</script>
</body>
</html>