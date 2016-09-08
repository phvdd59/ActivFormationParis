package com.formation.ajee.servlet.Admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.ajee.metier.Personne;
import com.formation.ajee.veriffom.Vue;

/**
 * Servlet implementation class ServletFiche
 */
@WebServlet("/ServletFicheRempli")
public class ServletFicheRempli extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletFicheRempli() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("//Servletidentification");
		rd.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Object oNoSerie = session.getAttribute("noSerie");
		Personne personne = (Personne) session.getAttribute("personne");
		Personne utilisateur = (Personne) session.getAttribute("utilisateur");
		Vue vue = new Vue();

		if (oNoSerie != null && personne != null && personne.getIdentifiant() != null) {
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

			String situationTotal = personne.getSituationString();
			String[] tabSituation = situationTotal.split(":");
			String situation = tabSituation[0];
			String champsAutre = "";
			if (situation == "autre" && tabSituation.length > 1) {
				champsAutre = tabSituation[1];
			}

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

			if (utilisateur != null && personne.getIdentifiant().equals("Admin")) {

				String unom = utilisateur.getNom();

				String uprenom = utilisateur.getPrenom();

				String uadresse = utilisateur.getAdresse();

				String ucp = utilisateur.getCp();

				String uville = utilisateur.getVille();

				String utelfixe = utilisateur.getTelFixe();

				String utelport = utilisateur.getTelPort();

				String ufax = utilisateur.getFax();

				String uemail = utilisateur.getEmail();

				String udatenaissance = utilisateur.getDateNaissanceString();

				String ulieunaissance = utilisateur.getLieuNaissance();

				String unumSecu = utilisateur.getNumSecu();

				String unationalite = utilisateur.getNationalite();

				String usituationTotal = personne.getSituationString();
				String[] utabSituation = usituationTotal.split(":");
				String usituation = utabSituation[0];
				String uchampsAutre = "";
				if (usituation == "autre" && utabSituation.length > 1) {
					uchampsAutre = utabSituation[1];
				}

				String ufonction = utilisateur.getFonction();

				String upositionEntreprise = utilisateur.getPositionEntreprise();

				String ucoeff = utilisateur.getCoeff();

				String usalaire = utilisateur.getSalaire();

				String umutuelle = utilisateur.getMutuelle();

				String uticketResto = utilisateur.getTicketResto();

				String uvisiteMedicale = utilisateur.getVisiteMedicaleString();

				String umontantTransport = utilisateur.getMontantTransport();

				String uvoiture = utilisateur.getVoiture();

				String unbcv = utilisateur.getNbCVString();

				String unbKm = utilisateur.getNbKm();

				/** Lecture Haut de page HTML */

				vue.lecturePage(response, "HautPage");
				response.getWriter().println("<link href=\"http://localhost:8080/ProjectAJEE/ajee/css/StyleFormulaire.css\" rel=\"stylesheet\" type=\"text/css\">");

				/** A modifier seulement si notre page contient du JavaScript */

				/** Lecture page ActivConsulting */

				vue.lecturePage(response, "MenuActiv");
				/**
				 * Seule Partie qui va vraiment changer selon les pages (penser
				 * aux controles si necessaire)
				 */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
					}
					if (lineDoc.contains("%utilisateur%")) {
						lineDoc = lineDoc.replace("%utilisateur%", ((utilisateur == null) ? "" : utilisateur.getIdentifiant()));
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/FormulaireARemplirJECIAdmin.html");
				BufferedReader bufReadDoc1 = null;
				bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
				String lineDoc1 = bufReadDoc1.readLine();
				while (lineDoc1 != null) {
					if (lineDoc1.contains("%nom%")) {
						lineDoc1 = lineDoc1.replace("%nom%", unom);
					}
					if (lineDoc1.contains("%prenom%")) {
						lineDoc1 = lineDoc1.replace("%prenom%", uprenom);
					}
					if (lineDoc1.contains("%adresse%")) {
						lineDoc1 = lineDoc1.replace("%adresse%", uadresse);
					}
					if (lineDoc1.contains("%cp%")) {
						lineDoc1 = lineDoc1.replace("%cp%", ucp);
					}
					if (lineDoc1.contains("%ville%")) {
						lineDoc1 = lineDoc1.replace("%ville%", uville);
					}
					if (lineDoc1.contains("%telfixe%")) {
						lineDoc1 = lineDoc1.replace("%telfixe%", utelfixe);
					}
					if (lineDoc1.contains("%telport%")) {
						lineDoc1 = lineDoc1.replace("%telport%", utelport);
					}
					if (lineDoc1.contains("%fax%")) {
						lineDoc1 = lineDoc1.replace("%fax%", ufax);
					}
					if (lineDoc1.contains("%email%")) {
						lineDoc1 = lineDoc1.replace("%email%", uemail);
					}
					if (lineDoc1.contains("%datenaissance%")) {
						lineDoc1 = lineDoc1.replace("%datenaissance%", udatenaissance);
					}
					if (lineDoc1.contains("%lieu%")) {
						lineDoc1 = lineDoc1.replace("%lieu%", ulieunaissance);
					}
					if (lineDoc1.contains("%numsecu%")) {
						lineDoc1 = lineDoc1.replace("%numsecu%", unumSecu);
					}
					if (lineDoc1.contains("%nationalite%")) {
						lineDoc1 = lineDoc1.replace("%nationalite%", unationalite);
					}
					if (lineDoc1.contains("%situation%")) {
						lineDoc1 = lineDoc1.replace("%situation%", usituation + " " + uchampsAutre);
					}
//					if (lineDoc1.contains("%autre%")) {
//						lineDoc1 = lineDoc1.replace("%autre%", uchampsAutre);
//					}
					if (lineDoc1.contains("%fonction%")) {
						lineDoc1 = lineDoc1.replace("%fonction%", ufonction);
					}
					if (lineDoc1.contains("%position%")) {
						lineDoc1 = lineDoc1.replace("%position%", upositionEntreprise);
					}
					if (lineDoc1.contains("%coeff%")) {
						lineDoc1 = lineDoc1.replace("%coeff%", ucoeff);
					}
					if (lineDoc1.contains("%salaire%")) {
						lineDoc1 = lineDoc1.replace("%salaire%", usalaire);
					}
					if (lineDoc1.contains("%mutuelle%")) {
						lineDoc1 = lineDoc1.replace("%mutuelle%", umutuelle);
					}
					if (lineDoc1.contains("%ticketresto%")) {
						lineDoc1 = lineDoc1.replace("%ticketresto%", uticketResto);
					}
					if (lineDoc1.contains("%datevisite%")) {
						lineDoc1 = lineDoc1.replace("%datevisite%", uvisiteMedicale);
					}
					if (lineDoc1.contains("%montanttransport%")) {
						lineDoc1 = lineDoc1.replace("%montanttransport%", umontantTransport);
					}
					if (lineDoc1.contains("%voiture%")) {
						lineDoc1 = lineDoc1.replace("%voiture%", uvoiture);
					}
					if (lineDoc1.contains("%nbcv%")) {
						lineDoc1 = lineDoc1.replace("%nbcv%", unbcv);
					}
					if (lineDoc1.contains("%km%")) {
						lineDoc1 = lineDoc1.replace("%km%", unbKm);
					}

					response.getWriter().println(lineDoc1);
					lineDoc1 = bufReadDoc1.readLine();
				}
				bufReadDoc1.close();

				/** Lecture bas de page */

				vue.lecturePage(response, "BasPage");
			} else if (utilisateur == null && personne.getIdentifiant().equals("Admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("//Servletaccueilchargementprofil");
				rd.forward(request, response);
			} else {
				// utiliser le pseudo pour avoir la personne
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");
				response.getWriter().println("<link href=\"http://localhost:8080/ProjectAJEE/ajee/css/StyleFormulaire.css\" rel=\"stylesheet\" type=\"text/css\">");
				/** A modifier seulement si notre page contient du JavaScript */

				/** Lecture page ActivConsulting */
				vue.lecturePage(response, "MenuActiv");

				/**
				 * Seule Partie qui va vraiment changer selon les pages (penser
				 * aux controles si necessaire)
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

				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/FormulaireARemplirJeci.html");
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
						lineDoc1 = lineDoc1.replace("%datenaissance%", datenaissance);
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
						lineDoc1 = lineDoc1.replace("%situation%", situation+ " " + champsAutre);
					}
//					if (lineDoc1.contains("%autre%")) {
//						lineDoc1 = lineDoc1.replace("%autre%", champsAutre);
//					}
					if (lineDoc1.contains("%fonction%")) {
						lineDoc1 = lineDoc1.replace("%fonction%", fonction);
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
					if (lineDoc1.contains("%mutuelle%")) {
						lineDoc1 = lineDoc1.replace("%mutuelle%", mutuelle);
					}
					if (lineDoc1.contains("%ticketresto%")) {
						lineDoc1 = lineDoc1.replace("%ticketresto%", ticketResto);
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
					response.getWriter().println(lineDoc1);
					lineDoc1 = bufReadDoc1.readLine();
				}
				bufReadDoc1.close();

				/** Lecture bas de page */
				vue.lecturePage(response, "BasPage");
			}
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);
		}
	}

}
