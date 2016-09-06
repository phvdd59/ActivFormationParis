package com.formation.ajee.servlet.Admin;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// response.getWriter().append("Served at:
	// ").append(request.getContextPath());
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object oNoSerie = session.getAttribute("noSerie");
		Personne personne = (Personne) session.getAttribute("personne");
		Personne utilisateur = (Personne) session.getAttribute("utilisateur");
		// Récupérer les données du formulaire et ranger dans objet personne

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
		if (oNoSerie != null&& personne!=null) {
		String nom = personne.getNom();
		if (nom == null) {
			nom = "";
		}

		String prenom = personne.getPrenom();
		if (prenom == null) {
			prenom = "";
		}

		String adresse = personne.getAdresse();
		if (adresse == null) {
			adresse = "";
		}

		String cp = personne.getCp();
		if (cp == null) {
			cp = "";
		}

		String ville = personne.getVille();
		if (ville == null) {
			ville = "";
		}

		String telfixe = personne.getTelFixe();
		if (telfixe == null) {
			telfixe = "";
		}

		String telport = personne.getTelPort();
		if (telport == null) {
			telport = "";
		}

		String fax = personne.getFax();
		if (fax == null) {
			fax = "";
		}

		String email = personne.getEmail();
		if (email == null) {
			email = "";
		}

		Date Ddatenaissance = personne.getDateNaissance();
		String datenaissance = "";
		if (Ddatenaissance != null) {
			Date maintenant = Ddatenaissance;
			SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy ");
			datenaissance = formatDateJour.format(maintenant);
		}

		String lieunaissance = personne.getLieuNaissance();
		if (lieunaissance == null) {
			lieunaissance = "";
		}

		String numSecu = personne.getNumSecu();
		if (numSecu == null) {
			numSecu = "";
		}

		String nationalite = personne.getNationalite();
		if (nationalite == null) {
			nationalite = "";
		}

//		String situation = personne.getSituation();
//		if (situation == null) {
//			situation = "";
//		}

		String fonction = personne.getFonction();
		if (fonction == null) {
			fonction = "";
		}

		String positionEntreprise = personne.getPositionEntreprise();
		if (positionEntreprise == null) {
			positionEntreprise = "";
		}

		String coeff = personne.getCoeff();
		if (coeff == null) {
			coeff = "";
		}

		String salaire = personne.getSalaire();
		if (salaire == null) {
			salaire = "";
		}

		String mutuelle;
		if (personne.isMutuelle() == false) {
			mutuelle = "non";
		} else {
			mutuelle = "oui";
		}

		String ticketResto;
		if (personne.isTicketResto() == false) {
			ticketResto = "non";
		} else {
			ticketResto = "oui";
		}

		Date DvisiteMedicale = personne.getVisiteMedicale();
		String visiteMedicale = "";
		if (DvisiteMedicale != null) {
			Date maintenant = DvisiteMedicale;
			SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy ");
			visiteMedicale = formatDateJour.format(maintenant);
		}

		String montantTransport = personne.getMontantTransport();
		if (montantTransport == null) {
			montantTransport = "";
		}

		String voiture;
		if (personne.isVoiture() == false) {
			voiture = "non";
		} else {
			voiture = "oui";
		}

		String nbcv = Integer.toString(personne.getNbCV());

		String nbKm = (personne.getNbKm());
		if (personne.getNbKm() == null) {
			nbKm = "";
		}

	

		

		

			if (utilisateur != null && personne.getIdentifiant().equals("Admin")) {
				String unom = utilisateur.getNom();
				if (unom == null) {
					unom = "";
				}

				String uprenom = utilisateur.getPrenom();
				if (uprenom == null) {
					uprenom = "";
				}

				String uadresse = utilisateur.getAdresse();
				if (uadresse == null) {
					uadresse = "";
				}

				String ucp = utilisateur.getCp();
				if (ucp == null) {
					ucp = "";
				}

				String uville = utilisateur.getVille();
				if (uville == null) {
					uville = "";
				}

				String utelfixe = utilisateur.getTelFixe();
				if (utelfixe == null) {
					utelfixe = "";
				}

				String utelport = utilisateur.getTelPort();
				if (utelport == null) {
					utelport = "";
				}

				String ufax = utilisateur.getFax();
				if (ufax == null) {
					ufax = "";
				}

				String uemail = utilisateur.getEmail();
				if (uemail == null) {
					uemail = "";
				}

				Date uDdatenaissance = utilisateur.getDateNaissance();
				String udatenaissance = "";
				if (uDdatenaissance != null) {
					Date maintenant = uDdatenaissance;
					SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy ");
					udatenaissance = formatDateJour.format(maintenant);
				}

				String ulieunaissance = utilisateur.getLieuNaissance();
				if (ulieunaissance == null) {
					ulieunaissance = "";
				}

				String unumSecu = utilisateur.getNumSecu();
				if (unumSecu == null) {
					unumSecu = "";
				}

				String unationalite = utilisateur.getNationalite();
				if (unationalite == null) {
					unationalite = "";
				}

//				String usituation = utilisateur.getSituation();
//				if (usituation == null) {
//					usituation = "";
//				}

				String ufonction = utilisateur.getFonction();
				if (ufonction == null) {
					ufonction = "";
				}

				String upositionEntreprise = utilisateur.getPositionEntreprise();
				if (upositionEntreprise == null) {
					upositionEntreprise = "";
				}

				String ucoeff = utilisateur.getCoeff();
				if (ucoeff == null) {
					ucoeff = "";
				}

				String usalaire = utilisateur.getSalaire();
				if (usalaire == null) {
					usalaire = "";
				}

				String umutuelle;
				if (utilisateur.isMutuelle() == false) {
					umutuelle = "non";
				} else {
					umutuelle = "oui";
				}

				String uticketResto;
				if (utilisateur.isTicketResto() == false) {
					uticketResto = "non";
				} else {
					uticketResto = "oui";
				}

				Date uDvisiteMedicale = utilisateur.getVisiteMedicale();
				String uvisiteMedicale = "";
				if (uDvisiteMedicale != null) {
					Date maintenant = uDvisiteMedicale;
					SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy ");
					uvisiteMedicale = formatDateJour.format(maintenant);
				}

				String umontantTransport = utilisateur.getMontantTransport();
				if (umontantTransport == null) {
					umontantTransport = "";
				}

				String uvoiture;
				if (utilisateur.isVoiture() == false) {
					uvoiture = "non";
				} else {
					uvoiture = "oui";
				}

				String unbcv = Integer.toString(utilisateur.getNbCV());

				String unbKm = (utilisateur.getNbKm());
				if (unbKm == null) {
					unbKm = "";
				}
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

				/** A modifier seulement si notre page contient du JavaScript */

				/** Lecture page ActivConsulting */
				File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
				BufferedReader bufReadActiv = null;
				bufReadActiv = new BufferedReader(new FileReader(fileActiv));
				String lineActiv = bufReadActiv.readLine();
				while (lineActiv != null) {
					response.getWriter().println(lineActiv);
					lineActiv = bufReadActiv.readLine();
				}
				bufReadActiv.close();

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

				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/FormulaireARemplirJeci.html");
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
//					if (lineDoc1.contains("%situation%")) {
//						lineDoc1 = lineDoc1.replace("%situation%", usituation);
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
				File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
				BufferedReader bufReadBas = null;
				bufReadBas = new BufferedReader(new FileReader(fileBas));
				String lineBas = bufReadBas.readLine();
				while (lineBas != null) {
					response.getWriter().println(lineBas);
					lineBas = bufReadBas.readLine();
				}
				bufReadBas.close();
			} else {
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

				/** A modifier seulement si notre page contient du JavaScript */

				/** Lecture page ActivConsulting */
				File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
				BufferedReader bufReadActiv = null;
				bufReadActiv = new BufferedReader(new FileReader(fileActiv));
				String lineActiv = bufReadActiv.readLine();
				while (lineActiv != null) {
					response.getWriter().println(lineActiv);
					lineActiv = bufReadActiv.readLine();
				}
				bufReadActiv.close();

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
//					if (lineDoc1.contains("%situation%")) {
//						lineDoc1 = lineDoc1.replace("%situation%", situation);
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
				File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
				BufferedReader bufReadBas = null;
				bufReadBas = new BufferedReader(new FileReader(fileBas));
				String lineBas = bufReadBas.readLine();
				while (lineBas != null) {
					response.getWriter().println(lineBas);
					lineBas = bufReadBas.readLine();
				}
				bufReadBas.close();
			}
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);
		}
	}

}
