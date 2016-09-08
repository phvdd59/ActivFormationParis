<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.formation.thcr.dao.DAOPersonne"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.formation.thcr.metier.*"%>
<%@page import="com.formation.joca.*"%>
<%@page import="java.net.URL"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="javax.xml.ws.Service"%>
<%@page import="com.formation.beans.*"%>
<%@page import="com.formation.thcr.*"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input[type="submit"] {
	width: 25%;
}

input#inputDeco[type="submit"] {
	position: relative;
	left: 83%;
}

#list {
	overflow: auto;
	height: 525px;
	width: 700px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListBDD</title>
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
		<div id="tlogo">LISTE BDD</div>
		<div id="info2">
			<%
				session = request.getSession();
				String noSerie = (String) session.getAttribute("noSerie");
				String noSerieHtml = request.getParameter("noSerie");
				Personne personne = new Personne();
				ListPersonne listePersonne = new ListPersonne();
				DAOPersonne dao = new DAOPersonne();

				String sAdresse = request.getParameter("adresse");

				if (sAdresse == null) {
					sAdresse = "JMST";
				}

				String lien = null;
				if (sAdresse.equals("JMST")) {
					lien = "localhost";
				} else if (sAdresse.equals("BAIT")) {
					lien = "192.168.33.144";
				} else if (sAdresse.equals("AJEE")) {
					lien = "192.168.33.141";
				}
				URL wsdlURL = new URL("http://" + lien + ":8888/ws/jax?wsdl");
				QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
				Service service = Service.create(wsdlURL, qname);
				InterPersoService ps = service.getPort(InterPersoService.class);
				Perso[] tabPerso = ps.getPersos();
				session.setAttribute("tabPerso", tabPerso);

				ConversionPersoToPersonne conversion = new ConversionPersoToPersonne();

				// 				for (int i = 0; i < tabPerso.length; i++) {
				// 					Personne pers = conversion.conv(tabPerso[i]);
				// 					dao.create(pers, "personneWS");
				// 				}

				if (noSerieHtml != null || noSerie != null || noSerieHtml.equals(noSerie)) {//ne marche pas pour l'instant a voir donc(made)
			%>
			<form action="ListBDD.jsp">
				<select name="adresse">
					<%
						if (sAdresse.equals("JMST")) {
					%>
					<option value="JMST" selected>JMST</option>
					<option value="BAIT">BAIT</option>
					<option value="AJEE">AJEE</option>
					<%
						} else if (sAdresse.equals("BAIT")) {
					%>
					<option value="JMST">JMST</option>
					<option value="BAIT" selected>BAIT</option>
					<option value="AJEE">AJEE</option>
					<%
						} else if (sAdresse.equals("AJEE")) {
					%>
					<option value="JMST">JMST</option>
					<option value="BAIT">BAIT</option>
					<option value="AJEE" selected>AJEE</option>

					<%
						}
					%>
				</select> <input type="submit" value="valider">
			</form>
			<form action="/ProjectJMST/ServletJoca">
			<input type="submit" value="Ecrire sur BDD">
			</form>
			<div id="list">
				<table border="4">
					<tr>
						<th>ID</th>
						<th>Login</th>
						<th>Nom</th>
						<th>Prenom</th>
					</tr>
					<%
						for (int i = 0; i < tabPerso.length; i++) {
								// 								Personne pers = conversion.conv(tabPerso[i]);
								System.out.print(tabPerso[i]);
					%>

					<tr>
						<td><%=tabPerso[i].getIdPersonne()%></td>
						<td><%=tabPerso[i].getIdentifiant()%></td>
						<td><%=tabPerso[i].getNom()%></td>
						<td><%=tabPerso[i].getPrenom()%></td>
					</tr>

					<%
						}
						} else {
							response.sendRedirect("http://localhost:8080/ProjectJMST/ServletJOCA1");
						}
					%>
				</table>
			</div>
			<div id="deco">
				<form action=http://localhost:8080/ProjectJMST/ServletDeco
					method="post">
					<input class="boutonRetourDeco" id="inputDeco" type="submit"
						value="Deconnexion"> <input type="hidden" name="noSerie"
						value="%%noSerie%%">
				</form>
			</div>
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