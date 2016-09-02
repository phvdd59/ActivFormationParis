<%@page import="com.formation.joca.controleur.CtrlPersonne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.formation.thcr.metier.*"%>
<%@page import="com.formation.joca.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

				String sIdentifiant = request.getParameter("identifiant");
				String sMdp = request.getParameter("mdp");
				if (noSerie.equals(noSerieHtml)) {
					//if (ctrl.ctrlIdentifiant(sIdentifiant) && ctrl.ctrlMdp(sMdp)) {
						personne.setIdentifiant(sIdentifiant);
						personne.setMdp(sMdp);
					//} else {
					//forward to deco
					//}

					//personne.set
			
			%>
			<form action="http://localhost:8080/ProjectJMST/jsp/Part3.jsp"
				method='POST'>
				<table border="1">
					<tr>
						<th colspan="4" style="width: 627px;">Coordonnées
							Personnelles</th>
					</tr>
					<tr>
						<td>Nom</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="ident" type="text" name="nom" value='<%=personne.getNom()%>'
							style="width: 270px;" onblur=""><br> <span class=""
							id="spanNom"></span></td>

						<td style="width: 72px;">Prenom</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="prenom" type="text" name="prenom"
							value='<%=personne.getPrenom()%>'> <br>
						<span id="spanPrenom"></span></td>
					</tr>
					<tr>
						<td>Adresse</td>
						<td colspan="3" style="width: 229px; height: 25px; color:;"><input
							id="adresse" type="text" name="adresse"
							value='<%=personne.getAdresse()%>' style="width: 615px;">
							<br>
						<span id="spanAdresse"></span></td>
					</tr>
					<tr>
						<td>Code Postale</td>

						<td style="width: 273px; height: 25px; color:;"><input
							id="codePostal" type="text" name="code postale"
							value='<%=personne.getCp()%>' style="width: 270px;"><br>
						<span id="spanCodePostal"></span></td>
						<td style="width: 72px;">Ville</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="ville" type="text" name="ville"
							value='<%=personne.getVille()%>'><br>
						<span id="spanVille"></span></td>
					</tr>
					<tr>
						<td>Telephone Fixe</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="telephoneFixe" type="text" name="tel fixe"
							value='<%=personne.getTelFixe()%>' style="width: 270px;"><br>
						<span id="spanTelephoneFixe"></span></td>
						<td style="width: 72px;">Telephone Portable</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="telephonePortable" type="text" name="tel portable"
							value='<%=personne.getTelPort()%>'><br>
						<span id="spanTelephonePortable"></span></td>
					</tr>
					<tr>
						<td>Fax</td>
						<td style="width: 273px; height: 25px; color:;"><input
							id="fax" type="text" name="fax" value='<%=personne.getFax()%>'
							style="width: 270px;"><br>
						<span id="spanFax"></span></td>
						<td style="width: 72px;">Mail</td>
						<td style="width: 112px; height: 25px; color:;"><input
							id="mail" type="text" name="mail"
							value='<%=personne.getEmail()%>'><br> <span
							id="spanMail"></span></td>
					</tr>
				</table>
				<input type="submit" value="Suivant" onclick="ctrAll()"></input> <input name="noSerie"
					type="hidden" value="<%=noSerie%>">
			</form>
			<form action="http://localhost:8080/ProjectJMST/RetourMenu"
				method='post'>
				<input type="submit" value="Precedent"></input> <input type="hidden"
					name="noSerie" value="<%=noSerie%>">
			</form>
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
		<%}else{
			
		}%>
	
</body>
<script type="text/javascript">
	function ctrAll() {
		ctrIdent();
		ctrPrenom();
		ctrAdresse();
		ctrCodePostal();
		ctrVille();
		ctrTelephoneFixe();
		ctrTelephonePortable();
		ctrFax();
		ctrMail();

	}

	function ctrIdent() {
		//nom
		var ident = document.getElementById("ident");//pour recuperer la balise pour l' id ident.
		var no = ident.value.length;
		var pattNom = new RegExp("[^a-zA-ZÀ-ÿ]");
		var spanNom = document.getElementById("spanNom");
		if (no<2 || no>10 || pattNom.test(ident.value)) {
			spanNom.className = "messageErreur";
			spanNom.innerHTML = "le nombre de caractère doit être comprit entre 2 et 10. Sans caractères spéciaux";
			ident.style.border = "1px solid #ff0000";
			return false;
		} else {
			ident.style.border = "inherit";
			spanNom.innerHTML = "";
			return true;
		}
	}

	function ctrPrenom() {
		var prenom = document.getElementById("prenom");
		var no = prenom.value.length;
		var pattPrenom = new RegExp("[^a-zA-ZÀ-ÿ]");
		var spanPrenom = document.getElementById("spanPrenom");
		if (no<2 || no>10 || pattPrenom.test(prenom.value)) {
			spanPrenom.className = "messageErreur";
			spanPrenom.innerHTML = "le nombre de caractère doit être comprit entre 2 et 10. Sans caractères speciaux";
			prenom.style.border = "1px solid #ff0000";
			return false;
		} else {
			prenom.style.border = "inherit";
			spanPrenom.innerHTML = "";
			return true;
		}
	}

	function ctrAdresse() {
		var adresse = document.getElementById("adresse");
		var no = adresse.value.length;
		var spanAdresse = document.getElementById("spanAdresse");
		if (no<3||no>255) {
			spanAdresse.className = "messageErreur";
			spanAdresse.innerHTML = "Verifiez la longueur de l'adresse.";
			adresse.style.border = "1px solid #ff0000";
			return false;
		} else {
			adresse.style.border = "inherit";
			spanAdresse.innerHTML = "";
			return true;
		}
	}

	function ctrCodePostal() {
		var codePostalOK = false;
		var codePostal = document.getElementById("codePostal");
		var no = codePostal.value.length;
		var pattCodePostal = new RegExp("^([0-9]{2}|(2A)|2B)[[0-9]{3}");
		var spanCodePostal = document.getElementById("spanCodePostal");
		if (no != 5 || pattCodePostal.test(codePostal.value) == false) {
			spanCodePostal.className = "messageErreur";
			spanCodePostal.innerHTML = "Le code postal doit contenir 5 chiffres(Peut commencer par 2A ou 2B).";
			codePostal.style.border = "1px solid #ff0000";
			return false;
		} else {
			codePostal.style.border = "inherit";
			spanCodePostal.innerHTML = "";
			return true;
		}
	}

	function ctrVille() {
		var ville = document.getElementById("ville");
		var no = ville.value.length;
		var pattVille = new RegExp("[^a-zA-ZÀ-ÿ]");
		var spanVille = document.getElementById("spanVille");
		if (no < 2 || pattVille.test(ville.value)) {
			spanVille.className = "messageErreur";
			spanVille.innerHTML = "le champ ne doit pas contenir de caractères spéciaux.";
			ville.style.border = "1px solid #ff0000";
			return false;
		} else {
			ville.style.border = "inherit";
			spanVille.innerHTML = "";
			return true;
		}
	}

	function ctrTelephoneFixe() {
		var telephoneFixe = document.getElementById("telephoneFixe");
		var no = telephoneFixe.value.length;
		var pattTelephoneFixe = new RegExp(
				"(01|02|03|04|05|06|07|08|09)[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}");
		var spanTelephoneFixe = document.getElementById("spanTelephoneFixe");
		if (pattTelephoneFixe.test(telephoneFixe.value) == false) {
			spanTelephoneFixe.className = "messageErreur";
			spanTelephoneFixe.innerHTML = "le nombre de caractère doit être égal à 10.";
			telephoneFixe.style.border = "1px solid #ff0000";
			return false;
		} else {
			telephoneFixe.style.border = "inherit";
			spanTelephoneFixe.innerHTML = "";
			return true;
		}
	}
	function ctrTelephonePortable() {
		var telephonePortable = document.getElementById("telephonePortable");
		var no = telephonePortable.value.length;
		var pattTelephonePortable = new RegExp(
				"(01|02|03|04|05|06|07|08|09)[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}");
		var spanTelephonePortable = document
				.getElementById("spanTelephonePortable");
		if (pattTelephonePortable.test(telephonePortable.value) == false) {
			spanTelephonePortable.className = "messageErreur";
			spanTelephonePortable.innerHTML = "le nombre de caractère doit être égal à 10.";
			telephonePortable.style.border = "1px solid #ff0000";
			return false;
		} else {
			telephonePortable.style.border = "inherit";
			spanTelephonePortable.innerHTML = "";
			return true;
		}
	}

	function ctrFax() {
		var fax = document.getElementById("fax");
		var no = fax.value.length;
		var pattFax = new RegExp(
				"(01|02|03|04|05|06|07|08|09)[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}");
		var spanFax = document.getElementById("spanFax");
		if (pattFax.test(fax.value) == false) {
			spanFax.className = "messageErreur";
			spanFax.innerHTML = "Le nombre de caractère doit être égal à 10.";
			fax.style.border = "1px solid #ff0000";
			return false;
		} else {
			fax.style.border = "inherit";
			spanFax.innerHTML = "";
			return true;
		}
	}

	function ctrMail() {
		var mail = document.getElementById("mail");
		var no = mail.value.length;
		var pattMail = new RegExp("^[a-z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$");
		var spanMail = document.getElementById("spanMail");
		if (pattMail.test(mail.value) == false) {
			spanMail.className = "messageErreur";
			spanMail.innerHTML = "Ecrire l'adresse mail sous la forme nom@fournisseur.com";
			mail.style.border = "1px solid #ff0000";
			return false;
		} else {
			mail.style.border = "inherit";
			spanMail.innerHTML = "";
			return true;
		}
	}
</script>
</html>