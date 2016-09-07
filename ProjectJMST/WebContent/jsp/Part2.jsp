<%@page import="com.formation.joca.controleur.CtrlPersonne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.formation.thcr.metier.*"%>
<%@page import="com.formation.joca.*"%>
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
				width="382" height="57" alt="" />
		</div>
		<div id="ogol1">
			<img src="http://www.activconsult-ing.com/img/Menu_pagaies2.png"
				width="71" height="71" alt="" />
		</div>
		<div id="tlogo">COORDONNÉES</div>
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

				if (noSerie.equals(noSerieHtml)) {
					//if (ctrl.ctrlIdentifiant(sIdentifiant) && ctrl.ctrlMdp(sMdp)) {
					//} else {
					//forward to deco
					//}

					//personne.set
			
			%>
			<form action="http://localhost:8080/ProjectJMST/jsp/Part3.jsp"
				method='POST' onsubmit="return ctrAll()">
				<table border="1">
					<tr>
						<td>Nom</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="nom" type="text" name="nom" value='<%=personne.getNom()%>' 
							style="width: 270px;" onblur="ctrNom(this)"><br> <span class=""
							id="spanNom"></span></td>

						<td style="width: 72px;">Prenom</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="prenom" type="text" name="prenom"
							value='<%=personne.getPrenom()%>' onblur="ctrPrenom()" > <br>
						<span id="spanPrenom"></span></td>
					</tr>
					<tr>
						<td>Adresse</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="adresse" type="text" name="adresse"
							value='<%=personne.getAdresse()%>' onblur="ctrAdresse()" style="width: 615px;">
							<br>
						<span id="spanAdresse"></span></td>
					</tr>
					<tr>
						<td>Code Postale</td>

						<td style="width: 273px; height: 25px; color:;"><input
							id="codePostal" type="text" name="codePostale"
							value='<%=personne.getCp()%>' onblur="ctrCodePostal()" style="width: 270px;"><br>
						<span id="spanCodePostal"></span></td>
						<td style="width: 72px;">Ville</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="ville" type="text" name="ville"
							value='<%=personne.getVille()%>' onblur="ctrVille()"><br>
						<span id="spanVille"></span></td>
					</tr>
					<tr>
						<td>Telephone Fixe</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="telephoneFixe" type="text" name="telFixe"
							value='<%=personne.getTelFixe()%>' onblur="ctrTelephoneFixe()" style="width: 270px;"><br>
						<span id="spanTelephoneFixe"></span></td>
						<td style="width: 72px;">Telephone Portable</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="telephonePortable" type="text" name="telPortable"
							value='<%=personne.getTelPort()%>' onblur="ctrTelephonePortable()"><br>
						<span id="spanTelephonePortable"></span></td>
					</tr>
					<tr>
						<td>Fax</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="fax" type="text" name="fax" value='<%=personne.getFax()%>' onblur="ctrFax()"
							style="width: 270px;"><br>
						<span id="spanFax"></span></td>
						<td style="width: 72px;">Mail</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="mail" type="text" name="mail"
							value='<%=personne.getEmail()%>' onblur="ctrMail()"><br> <span
							id="spanMail"></span></td>
					</tr>
				</table>
				<input type="submit" value="Suivant" onclick="ctrAll()"></input> <input name="noSerie"
					type="hidden" value="<%=noSerie%>">
			</form>
<!-- 			<form action="http://localhost:8080/ProjectJMST/RetourMenu" -->
<!-- 				method='post'> -->
<!-- 				<input type="submit" value="Precedent"></input> <input type="hidden" -->
<%-- 					name="noSerie" value="<%=noSerie%>"> --%>
<!-- 			</form> -->
			<form action="http://localhost:8080/ProjectJMST/ServletDeco"
				method='get'>
				<input type="submit" value="Deconnexion"></input> <input
					type="hidden" name="noSerie" value="<%=noSerie%>">
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
		<%}else{
			
		}%>
	
	</div>
		<script type="text/javascript">
		function ctrAll() {
			var nomOk = ctrNom();
			var prenomOk = ctrPrenom();
			var adresseOk = ctrAdresse();
			var codePostalOk = ctrCodePostal();
			var villeOk = ctrVille();
			var telephoneFixeOk = ctrTelephoneFixe();
			var telephonePortableOk = ctrTelephonePortable();
			var faxOk = ctrFax();
			var mailOk = ctrMail();

			if (nomOk && prenomOk && adresseOk && codePostalOk && villeOk
					&& telephoneFixeOk && telephonePortableOk && faxOk
					&& mailOk) {
				return true;
			} else {
				alert("Veuillez remplir les champs obligatoires");
				return false;
			}

		}

		function ctrNom() {
			var nom = document.getElementById("nom");
			var no = nom.value.length;
			var pattNom = new RegExp("^([a-zA-Z\-\'\\s]+)$");
			var spanNom = document.getElementById("spanNom");
			if (pattNom.test(nom.value) == false) {
				//spanNom.className = "messageErreur";
				spanNom.innerHTML = "Veuillez verifier les caractères utilisés('- acceptés)";
				nom.style.border = "1px solid #f00";
				nom.style.backgroundColor = "#fba";
				return false;
			} else {
				nom.style.border = "inherit";
				nom.style.backgroundColor = "#66ff99";
				spanNom.innerHTML = " OK";
				return true;
			}
		}

		function ctrPrenom() {
			var prenom = document.getElementById("prenom");
			var no = prenom.value.length;
			var pattPrenom = new RegExp("^([a-zA-Z\-\'\\s]+)$");
			var spanPrenom = document.getElementById("spanPrenom");
			if (pattPrenom.test(prenom.value) == false) {
				//spanPrenom.className = "messageErreur";
				spanPrenom.innerHTML = "Veuillez verifier les caractères utilisés('- acceptés)";
				prenom.style.border = "1px solid #f00";
				prenom.style.backgroundColor = "#fba";
				return false;
			} else {
				prenom.style.border = "inherit";
				prenom.style.backgroundColor = "#66ff99";
				spanPrenom.innerHTML = " OK";
				return true;
			}
		}

		function ctrAdresse() {
			var adresse = document.getElementById("adresse");
			var no = adresse.value.length;
			var spanAdresse = document.getElementById("spanAdresse");
			var pattAdresse = new RegExp("^[a-zA-Z0-9\\s\(\)\.\'\-]+$");
			if (adresse.value == "") {
				adresse.style.border = "inherit";
				adresse.style.backgroundColor = "#66ff99";
				spanAdresse.innerHTML = " OK";
				return true;
			} else if (pattAdresse.test(adresse.value) == false
					&& adresse.value != "") {
				//spanAdresse.className = "messageErreur";
				spanAdresse.innerHTML = "Veuillez verifier les caractères utilisés('- ()acceptés).";
				adresse.style.border = "1px solid #f00";
				adresse.style.backgroundColor = "#fba";
				return false;
			} else {
				adresse.style.border = "inherit";
				adresse.style.backgroundColor = "#66ff99";
				spanAdresse.innerHTML = " OK";
				return true;
			}
		}

		function ctrCodePostal() {
			var codePostalOK = false;
			var codePostal = document.getElementById("codePostal");
			var no = codePostal.value.length;
			var pattCodePostal = new RegExp("^[0-9]{5}$");
			var spanCodePostal = document.getElementById("spanCodePostal");
			if (codePostal.value == "") {
				codePostal.style.border = "inherit";
				codePostal.style.backgroundColor = "#66ff99";
				spanCodePostal.innerHTML = " OK";
				return true;
			} else if (pattCodePostal.test(codePostal.value) == false
					&& codePostal.value != "") {
				//spanCodePostal.className = "messageErreur";
				spanCodePostal.innerHTML = "Le code postal doit contenir 5 chiffres.";
				codePostal.style.border = "1px solid #f00";
				codePostal.style.backgroundColor = "#fba";
				return false;
			} else {
				codePostal.style.border = "inherit";
				codePostal.style.backgroundColor = "#66ff99";
				spanCodePostal.innerHTML = " OK";
				return true;
			}
		}

		function ctrVille() {
			var ville = document.getElementById("ville");
			var no = ville.value.length;
			var pattVille = new RegExp("^([a-zA-Z\-\'\\s]+)$");
			var spanVille = document.getElementById("spanVille");
			if (ville.value == "") {
				ville.style.border = "inherit";
				ville.style.backgroundColor = "#66ff99";
				spanVille.innerHTML = " OK";
				return true;
			} else if (pattVille.test(ville.value) == false
					&& ville.value != "") {
				//spanVille.className = "messageErreur";
				spanVille.innerHTML = "Veuillez verifier les caractères utilisés('- acceptés).";
				ville.style.border = "1px solid #f00";
				ville.style.backgroundColor = "#fba";
				return false;
			} else {
				ville.style.border = "inherit";
				ville.style.backgroundColor = "#66ff99";
				spanVille.innerHTML = " OK";
				return true;
			}
		}

		function ctrTelephoneFixe() {
			var telephoneFixe = document.getElementById("telephoneFixe");
			var no = telephoneFixe.value.length;
			var pattTelephoneFixe = new RegExp(
					"^(1|2|3|4|5|6|7|8|9)[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}");
			var spanTelephoneFixe = document
					.getElementById("spanTelephoneFixe");
			if (telephoneFixe.value == "") {
				telephoneFixe.style.border = "inherit";
				telephoneFixe.style.backgroundColor = "#66ff99";
				spanTelephoneFixe.innerHTML = " OK";
				return true;
			} else if (pattTelephoneFixe.test(telephoneFixe.value) == false
					&& telephoneFixe.value != "") {
				//spanTelephoneFixe.className = "messageErreur";
				spanTelephoneFixe.innerHTML = "Veuillez entrez les 9 chiffres de votre numero de telephone (0 exclus)";
				telephoneFixe.style.border = "1px solid #f00";
				telephoneFixe.style.backgroundColor = "#fba";
				return false;
			} else {
				telephoneFixe.style.border = "inherit";
				telephoneFixe.style.backgroundColor = "#66ff99";
				spanTelephoneFixe.innerHTML = " OK";
				return true;
			}
		}

		function ctrTelephonePortable() {
			var telephonePortable = document
					.getElementById("telephonePortable");
			var no = telephonePortable.value.length;
			var pattTelephonePortable = new RegExp(
					"^(1|2|3|4|5|6|7|8|9)[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}");
			var spanTelephonePortable = document
					.getElementById("spanTelephonePortable");
			if (telephonePortable.value == "") {
				telephonePortable.style.border = "inherit";
				telephonePortable.style.backgroundColor = "#66ff99";
				spanTelephonePortable.innerHTML = " OK";
				return true;
			} else if (pattTelephonePortable.test(telephonePortable.value) == false
					&& telephonePortable.value != "") {
				//spanTelephonePortable.className = "messageErreur";
				spanTelephonePortable.innerHTML = "Veuillez entrer les 9 chiffres de votre numero de telephone (0 exclus).";
				telephonePortable.style.border = "1px solid #f00";
				telephonePortable.style.backgroundColor = "#fba";
				return false;
			} else {
				telephonePortable.style.border = "inherit";
				telephonePortable.style.backgroundColor = "#66ff99";
				spanTelephonePortable.innerHTML = " OK";
				return true;
			}
		}

		function ctrFax() {
			var fax = document.getElementById("fax");
			var no = fax.value.length;
			var pattFax = new RegExp(
					"^(1|2|3|4|5|6|7|8|9)[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}");
			var spanFax = document.getElementById("spanFax");
			if (fax.value == "") {
				fax.style.border = "inherit";
				fax.style.backgroundColor = "#66ff99";
				spanFax.innerHTML = " OK";
				return true;
			} else if (pattFax.test(fax.value) == false && fax.value != "") {
				//spanFax.className = "messageErreur";
				spanFax.innerHTML = "Veuillez entrer les 9 chiffres de votre numero de telephone (0 exclus).";
				fax.style.border = "1px solid #f00";
				fax.style.backgroundColor = "#fba";
				return false;
			} else {
				fax.style.border = "inherit";
				fax.style.backgroundColor = "#66ff99";
				spanFax.innerHTML = " OK";
				return true;
			}
		}

		function ctrMail() {
			var mail = document.getElementById("mail");
			var no = mail.value.length;
			var pattMail = new RegExp(
					"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
			var spanMail = document.getElementById("spanMail");
			if (pattMail.test(mail.value) == false) {
				//spanMail.className = "messageErreur";
				spanMail.innerHTML = "Ecrire l'adresse mail sous la forme nom@fournisseur.com";
				mail.style.border = "1px solid #f00";
				mail.style.backgroundColor = "#fba";
				return false;
			} else {
				mail.style.border = "inherit";
				mail.style.backgroundColor = "#66ff99";
				spanMail.innerHTML = " OK";
				return true;
			}
		}
	</script>
</body>

</html>