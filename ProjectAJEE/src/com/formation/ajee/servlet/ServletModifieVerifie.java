package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.ajee.metier.Personne;
import com.formation.ajee.metier.SEXE;
import com.formation.ajee.metier.SITUATION;
import com.formation.ajee.veriffom.VerifForm;

/**
 * Servlet implementation class ServletModifieVerifie
 */
@WebServlet("/ServletModifieVerifie")
public class ServletModifieVerifie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModifieVerifie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Personne personne = (Personne) session.getAttribute("personne");
		Object noSerie = session.getAttribute("noSerie");
		VerifForm verif = new VerifForm();
		if (noSerie == null || personne == null) {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);
		} else {

			// Récupérer les données du formulaire, vérifier, et ranger dans
			// objet personne
			String pNom = request.getParameter("nom");
			String pNomV = verif.nomVerif(pNom);
			personne.setNom(pNomV);

			String pPrenom = request.getParameter("prenom");
			String pPrenomV = verif.prenomVerif(pPrenom);
			personne.setPrenom(pPrenomV);

			String pSexe = request.getParameter("sexe");
			SEXE pSexeV = verif.sexeVerif(pSexe);
			personne.setSexe(pSexeV);

			String pAdresse = request.getParameter("adresse");
			String pAdresseV = verif.adresseVerif(pAdresse);
			personne.setAdresse(pAdresseV);

			String pCp = request.getParameter("cp");
			String pCpV = verif.cpVerif(pCp);
			personne.setCp(pCpV);

			String pVille = request.getParameter("ville");
			String pVilleV = verif.villeVerif(pVille);
			personne.setVille(pVilleV);

			String pTelFixe = request.getParameter("telFixe");
			String pTelFixeV = verif.telFixVerif(pTelFixe);
			personne.setTelFixe(pTelFixeV);

			String pTelPort = request.getParameter("telPort");
			String pTelPortV = verif.telPortVerif(pTelPort);
			personne.setTelPort(pTelPortV);

			String pFax = request.getParameter("fax");
			String pFaxV = verif.faxVerif(pFax);
			personne.setFax(pFaxV);

			String pEmail = request.getParameter("email");
			String pEmailV = verif.emailVerif(pEmail);
			personne.setEmail(pEmailV);

			//
			String pDateNaissance = request.getParameter("dateNaissance");
			Date pDateNaissanceV = verif.dateNaissanceVerif(pDateNaissance);
			personne.setDateNaissance(pDateNaissanceV);

			String pLieuNaissance = request.getParameter("lieuNaissance");
			String pLieuNaissanceV = verif.lieuNaissanceVerif(pLieuNaissance);
			personne.setLieuNaissance(pLieuNaissanceV);

			String pNumSecu = request.getParameter("numSecu");
			String pNumSecuV = verif.numSecuVerif(pNumSecu);
			personne.setNumSecu(pNumSecuV);

			String pNationalite = request.getParameter("nationalite");
			String pNationaliteV = verif.nationaliteVerif(pNationalite);
			personne.setNationalite(pNationaliteV);

			String pSituation = request.getParameter("situation");
			SITUATION pSituationV = verif.situationVerif(pSituation);
			personne.setSituation(pSituationV);

			String pFonction = request.getParameter("fonction");
			String pFonctionV = verif.fonctionVerif(pFonction);
			personne.setFonction(pFonctionV);

			String pPositionEntreprise = request.getParameter("positionEntreprise");
			String pPositionEntrepriseV = verif.nomVerif(pPositionEntreprise); // nomVerif
																				// car
																				// pas
																				// de
																				// méthode
																				// "positionEntrepriseVerif"
																				// dans
																				// "VerifForm.java"
			personne.setPositionEntreprise(pPositionEntrepriseV);

			String pCoeff = request.getParameter("coeff");
			String pCoeffV = verif.coeffVerif(pCoeff);
			personne.setCoeff(pCoeffV);

			String pSalaire = request.getParameter("salaire");
			String pSalaireV = verif.salaireVerif(pSalaire);
			personne.setSalaire(pSalaireV);

			String pMutuelle = request.getParameter("mutuelle");
			boolean pMutuelleV = verif.mutuelleVerif(pMutuelle);
			personne.setMutuelle(pMutuelleV);

			String pTicketResto = request.getParameter("ticketResto");
			boolean pTicketRestoV = verif.ticketRestoVerif(pTicketResto);
			personne.setTicketResto(pTicketRestoV);

			String pVisiteMedicale = request.getParameter("visiteMedicale");
			Date pVisiteMedicaleV = verif.visiteMedicaleVerif(pVisiteMedicale);
			personne.setVisiteMedicale(pVisiteMedicaleV);

			String pMontantTransport = request.getParameter("montantTransport");
			String pMontantTransportV = verif.montantTransportVerif(pMontantTransport);
			personne.setMontantTransport(pMontantTransportV);

			String pVoiture = request.getParameter("voiture");
			boolean pVoitureV = verif.voitureVerif(pVoiture);
			personne.setVoiture(pVoitureV);

			String pNbCV = request.getParameter("nbCV");
			int pNbCVV = verif.nbCVVerif(pNbCV);
			personne.setNbCV(pNbCVV);

			String pNbKm = request.getParameter("nbKm");
			String pNbKmV = verif.nbKm(pNbKm);
			personne.setNbKm(pNbKmV);
			if (pNomV.equals("") || pPrenomV.equals("") || pEmailV.equals("") || pDateNaissanceV == null || pTelFixeV.equals("")) {
				String nom = personne.getNom();

				String prenom = personne.getPrenom();

				String adresse = personne.getAdresse();

				String cp = personne.getCp();

				String ville = personne.getVille();

				String telfixe = personne.getTelFixe();

				String telport = personne.getTelPort();

				String fax = personne.getFax();

				String email = personne.getEmail();

				String datenaissance = personne.getDateNaissanceString();

				String lieunaissance = personne.getLieuNaissance();

				String numSecu = personne.getNumSecu();

				String nationalite = personne.getNationalite();

				 String situation = personne.getSituationString();
				

				String fonction = personne.getFonction();

				String positionEntreprise = personne.getPositionEntreprise();

				String coeff = personne.getCoeff();

				String salaire = personne.getSalaire();

				String mutuelle = personne.getMutuelle();

				String ticketResto = personne.getTicketResto();

				String visiteMedicale = personne.getVisiteMedicaleString();

				String montantTransport = personne.getMontantTransport();

				String voiture = personne.getVoiture();

				String nbcv = personne.getNbCVString();

				String nbKm = personne.getNbKm();
				if (personne != null && !personne.getIdentifiant().equals("Admin")) {
					// utiliser le pseudo pour avoir la personne
					/** Lecture Haut de page HTML */
					File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
					BufferedReader bufReadHaut = null;
					bufReadHaut = new BufferedReader(new FileReader(fileHaut));
					String lineHaut = bufReadHaut.readLine();
					while (lineHaut != null) {
						response.getWriter().println(lineHaut);
						lineHaut = bufReadHaut.readLine();
					}
					bufReadHaut.close();

					/**
					 * A modifier seulement si notre page contient du JavaScript
					 */
					File fileJS = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/css/FormulaireCalendrierListeDeroulante.html");
					BufferedReader bufReadJS = null;
					bufReadJS = new BufferedReader(new FileReader(fileJS));
					String lineJS = bufReadJS.readLine();
					while (lineJS != null) {
						response.getWriter().println(lineJS);
						lineJS = bufReadJS.readLine();
					}
					bufReadJS.close();

					File fileJS1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSFormulaireCalendrierListeDeroulante.html");
					BufferedReader bufReadJS1 = null;
					bufReadJS1 = new BufferedReader(new FileReader(fileJS1));
					String lineJS1 = bufReadJS1.readLine();
					while (lineJS1 != null) {
						response.getWriter().println(lineJS1);
						lineJS1 = bufReadJS1.readLine();
					}
					bufReadJS1.close();

					/** Lecture page ActivConsulting */
					File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
					BufferedReader bufReadActiv = null;
					bufReadActiv = new BufferedReader(new FileReader(fileActiv));
					String lineActiv = bufReadActiv.readLine();
					while (lineActiv != null) {
						if (lineActiv.contains("<body>")) {
							lineActiv = lineActiv.replace("<body>", "<body onload='alert('Désolé (le ou les) champs nom, prénom, email, date de naissance, téléphone fixe ne sont pas correct')'>");
						}
						response.getWriter().println(lineActiv);
						lineActiv = bufReadActiv.readLine();
					}
					bufReadActiv.close();

					/**
					 * Seule Partie qui va vraiment changer selon les pages
					 * (penser aux controles si necessaire)
					 */
					File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Bandeau.html");
					BufferedReader bufReadDoc = null;
					bufReadDoc = new BufferedReader(new FileReader(fileDoc));
					String lineDoc = bufReadDoc.readLine();
					while (lineDoc != null) {
						if (lineDoc.contains("%pseudo%")) {
							lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
						}
						response.getWriter().println(lineDoc);
						lineDoc = bufReadDoc.readLine();
					}
					bufReadDoc.close();

					File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/ModificationFormulaireJECI.html");
					BufferedReader bufReadDoc1 = null;
					bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
					String lineDoc1 = bufReadDoc1.readLine();
					while (lineDoc1 != null) {
						if (lineDoc1.contains("%nom%")) {
							lineDoc1 = lineDoc1.replace("%nom%", nom);
						}
						if (lineDoc1.contains("%prenom%")) {
							lineDoc1 = lineDoc1.replace("%prenom%", prenom);
						}
						if (lineDoc1.contains("%adresse%")) {
							lineDoc1 = lineDoc1.replace("%adresse%", adresse);
						}
						if (lineDoc1.contains("%cp%")) {
							lineDoc1 = lineDoc1.replace("%cp%", cp);
						}
						if (lineDoc1.contains("%ville%")) {
							lineDoc1 = lineDoc1.replace("%ville%", ville);
						}
						if (lineDoc1.contains("%telfixe%")) {
							lineDoc1 = lineDoc1.replace("%telfixe%", telfixe);
						}
						if (lineDoc1.contains("%telport%")) {
							lineDoc1 = lineDoc1.replace("%telport%", telport);
						}
						if (lineDoc1.contains("%fax%")) {
							lineDoc1 = lineDoc1.replace("%fax%", fax);
						}
						if (lineDoc1.contains("%email%")) {
							lineDoc1 = lineDoc1.replace("%email%", email);
						}
						if (lineDoc1.contains("%datenaissance%")) {
							lineDoc1 = lineDoc1.replace("%datenaissance%", email);
						}

						if (lineDoc1.contains("%lieu%")) {
							lineDoc1 = lineDoc1.replace("%lieu%", lieunaissance);
						}
						if (lineDoc1.contains("%numsecu%")) {
							lineDoc1 = lineDoc1.replace("%numsecu%", numSecu);
						}
						if (lineDoc1.contains("%nationalite%")) {
							lineDoc1 = lineDoc1.replace("%nationalite%", nationalite);
						}
						 if (lineDoc1.contains("%situation%")) {
						 lineDoc1 = lineDoc1.replace("%situation%",situation);
						 }

						if (lineDoc1.contains("%position%")) {
							lineDoc1 = lineDoc1.replace("%position%", positionEntreprise);
						}
						if (lineDoc1.contains("%coeff%")) {
							lineDoc1 = lineDoc1.replace("%coeff%", coeff);
						}
						if (lineDoc1.contains("%salaire%")) {
							lineDoc1 = lineDoc1.replace("%salaire%", salaire);
						}

						if (lineDoc1.contains("%datevisite%")) {
							lineDoc1 = lineDoc1.replace("%datevisite%", visiteMedicale);
						}
						if (lineDoc1.contains("%montanttransport%")) {
							lineDoc1 = lineDoc1.replace("%montanttransport%", montantTransport);
						}
						if (lineDoc1.contains("%voiture%")) {
							lineDoc1 = lineDoc1.replace("%voiture%", voiture);
						}
						if (lineDoc1.contains("%nbcv%")) {
							lineDoc1 = lineDoc1.replace("%nbcv%", nbcv);
						}
						if (lineDoc1.contains("%km%")) {
							lineDoc1 = lineDoc1.replace("%km%", nbKm);
						}
						if (lineDoc1.contains("%mutuelle%")) {
							lineDoc1 = lineDoc1.replace("%mutuelle%", mutuelle);
						}
						if (lineDoc1.contains("%ticketResto%")) {
							lineDoc1 = lineDoc1.replace("%ticketResto%", ticketResto);
						}
						if (lineDoc1.contains("%datenaissance%")) {
							lineDoc1 = lineDoc1.replace("%datenaissance%", datenaissance);
						}
						if (lineDoc1.contains("%fonction%")) {
							lineDoc1 = lineDoc1.replace("%fonction%", fonction);
						}
						response.getWriter().println(lineDoc1);
						lineDoc1 = bufReadDoc1.readLine();
					}
					bufReadDoc1.close();

					/** Lecture bas de page */
					File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
					BufferedReader bufReadBas = null;
					bufReadBas = new BufferedReader(new FileReader(fileBas));
					String lineBas = bufReadBas.readLine();
					while (lineBas != null) {
						response.getWriter().println(lineBas);
						lineBas = bufReadBas.readLine();
					}
					bufReadBas.close();

				}else {
					session.invalidate();
					RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
					rd.forward(request, response);
				}
			}else {
				// ajout à la bdd
				int idPersonne = personne.getIdPersonne();
				personne.modifPersonne(idPersonne);
				RequestDispatcher rd = request.getRequestDispatcher("//ServletFicheRempli");
				rd.forward(request, response);
			}
			

		
		}
	}

}
