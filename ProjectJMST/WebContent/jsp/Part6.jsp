<%@page import="com.formation.joca.controleur.CtrlPersonne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.formation.thcr.metier.*"%>
<%@ page import="com.formation.thcr.dao.*"%>
<%@ page import="com.formation.thcr.conversion.*"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fin Formulaire</title>
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
	</div>
		<div id="tlogo">CENTRE DE FORMATION</div>
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

				CtrlPersonne ctrl = new CtrlPersonne();
				String sSituation = request.getParameter("situation");
				if (noSerie.equals(noSerieHtml)) {
					// 					if (ctrl.ctrlSituation(sSituation)) {
					personne.setSituation(sSituation);
					// 					} else {
					// 						FORWARD TO DECO
					// 					}


					String sCadre = request.getParameter("Cadre");
					String sFonction = request.getParameter("fonction");
					String sPosition = request.getParameter("position");
					String sCoefficient = request.getParameter("coefficient");
					String sSalaire = request.getParameter("salaire souhaite");
					String sMutuelle = request.getParameter("mutuelle");
					String sTicketResto = request.getParameter("ticket resto");
					String sVisiteMedicale = request.getParameter("date visite medicale");
					String sTransport = request.getParameter("carte de transport");
					String sVehicule = request.getParameter("vehicule perso");
					String sNbCv = request.getParameter("nb de CV");
					String sKmEstime = request.getParameter("km mensuel");

					DAOPersonne dao = new DAOPersonne();
					ConversionPersonne conv = new ConversionPersonne();

					if (ctrl.ctrlCadre(sCadre) && ctrl.ctrlFonction(sFonction) && ctrl.ctrlPosition(sPosition) && ctrl.ctrlCoeff(sCoefficient)
					&& ctrl.ctrlSalaire(sSalaire) && ctrl.ctrlMutuelle(sMutuelle) && ctrl.ctrlTicketResto(sTicketResto)
					&& ctrl.ctrlVisiteMedicale(sVisiteMedicale) && ctrl.ctrlMontantTransport(sTransport) && ctrl.ctrlVoiture(sVehicule)
					&& ctrl.ctrlNbCV(sNbCv) && ctrl.ctrlNbKm(sKmEstime)) {
					personne.setCadre(conv.conversionBoolean(sCadre));
					personne.setFonction(sFonction);
					personne.setPosition(sPosition);
					personne.setCoeff(sCoefficient);
					personne.setSalaire(sSalaire);
					personne.setMutuelle(conv.conversionBoolean(sMutuelle));
					personne.setTicketResto(conv.conversionBoolean(sTicketResto));
					personne.setVisiteMedicale(conv.conversionDate(sVisiteMedicale));
					personne.setMontantTransport(sTransport);
					personne.setVoiture(conv.conversionBoolean(sVehicule));
					personne.setNbCV(Integer.valueOf(sNbCv).intValue());
					personne.setNbKm(sKmEstime);

					Date dateModificationUtil = new Date();
					Timestamp dateModification = new Timestamp(dateModificationUtil.getTime());
					personne.setDateModification(dateModification);
					dao.update(personne);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/Servletmadeversmenu");
					rd.forward(request, response);
					}
			%>
			</div>
			<!--	<form= action:"http://www.souadkad.fr/soka/identification.html"></form>-->

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
				<div id="droit2">©1997-2012 - Tous droits de reproduction et
					de représentation réservés | Mentions légales</div>
			</div>
			<%
				}
			%>
		
</body>
</html>