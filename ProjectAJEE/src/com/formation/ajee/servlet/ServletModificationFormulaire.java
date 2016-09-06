package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class ServletModificationFormulaire
 */
@WebServlet("/ServletModificationFormulaire")
public class ServletModificationFormulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModificationFormulaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object oNoSerie = session.getAttribute("noSerie");
		Personne personne = (Personne) session.getAttribute("personne");
		Vue vue = new Vue();
		//personne.getClass().
		// R�cup�rer les donn�es du formulaire et ranger dans objet personne

		// ArrayList<String> lstparam= new ArrayList<String>();
		// lstparam.add("nom");
		// lstparam.add("prenom");
		// lstparam.add("adresse");
		// lstparam.add("cp");
		// lstparam.add("ville");
		// lstparam.add("telFixe");
		// lstparam.add("telPort");
		// lstparam.add("fax");
		// lstparam.add("email");
		// lstparam.add("dateNaissance");
		// lstparam.add("lieuNaissance");
		// lstparam.add("numSecu");
		// lstparam.add("nationalite");
		// lstparam.add("situation");
		// lstparam.add("fonction");
		// lstparam.add("positionEntreprise");
		// lstparam.add("coeff");
		// lstparam.add("salaire");
		// lstparam.add("montantTransport");
		// lstparam.add("nbKm");
		//

		String nom = personne.getNom();
	
		String prenom = personne.getPrenom();
		
		String adresse = personne.getAdresse();
	
		String cp = personne.getCp();
	
		String ville = personne.getVille();
	
		String telfixe = personne.getTelFixe();
		if (telfixe == null) {
			telfixe = "";
		}
		String telport = personne.getTelPort();
		
		String fax = personne.getFax();
	
		String email = personne.getEmail();
		
		String datenaissance = personne.getDateNaissanceString();
	
		String lieunaissance = personne.getLieuNaissance();
		
		String numSecu = personne.getNumSecu();
		
		String nationalite = personne.getNationalite();
		

		// String situation = personne.getSituation();
		// if (situation == null) {
		// situation = "";
		// }

		String fonction = personne.getFonction();
		
		String positionEntreprise = personne.getPositionEntreprise();
	
		String coeff = personne.getCoeff();
	
		String salaire = personne.getSalaire();
	
		String mutuelle=personne.getMutuelle();
	
		String ticketResto=personne.getTicketResto();
	
		String visiteMedicale = personne.getVisiteMedicaleString();
	
		String montantTransport = personne.getMontantTransport();
	
		String voiture=personne.getVoiture();
		
		String nbcv =personne.getNbCVString();

		String nbKm = personne.getNbKm();
		

		

		if (oNoSerie != null) {

			if (personne != null && !personne.getIdentifiant().equals("Admin")) {
				// utiliser le pseudo pour avoir la personne
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");

				/** A modifier seulement si notre page contient du JavaScript */
				 File fileJS = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/css/FormulaireCalendrierListeDeroulante.html");
				 BufferedReader bufReadJS = null;
				 bufReadJS = new BufferedReader(new FileReader(fileJS));
				 String lineJS = bufReadJS.readLine();
				 while (lineJS != null) {
				 response.getWriter().println(lineJS);
				 lineJS = bufReadJS.readLine();
				 }
				 bufReadJS.close();
				 response.getWriter().println("<link href=\"http://localhost:8080/ProjectAJEE/ajee/css/StyleFormulaire.css\" rel=\"stylesheet\" type=\"text/css\">");
				 
				 vue.lectureJS(response, "JSFormulaireCalendrierListeDeroulante");
				 
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
					
					if (lineDoc1.contains("%lieu%")) {
						lineDoc1 = lineDoc1.replace("%lieu%", lieunaissance);
					}
					if (lineDoc1.contains("%numsecu%")) {
						lineDoc1 = lineDoc1.replace("%numsecu%", numSecu);
					}
					if (lineDoc1.contains("%nationalite%")) {
						lineDoc1 = lineDoc1.replace("%nationalite%", nationalite);
					}
					// if (lineDoc1.contains("%situation%")) {
					// lineDoc1 = lineDoc1.replace("%situation%", situation);
					// }
					
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
					response.getWriter().println(lineDoc1);
					lineDoc1 = bufReadDoc1.readLine();
				}
				bufReadDoc1.close();
					
				/** Lecture bas de page */
				vue.lecturePage(response, "BasPage"); 
				
			} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);}
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);
		}
	}

}
