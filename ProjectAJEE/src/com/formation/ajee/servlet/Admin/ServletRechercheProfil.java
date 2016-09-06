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

import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.Personne;

/**
 * Servlet implementation class ServletRechercheProfil
 */
@WebServlet("/ServletRechercheProfil")
public class ServletRechercheProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRechercheProfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Object noSerie = session.getAttribute("noSerie");

		Personne personne = (Personne) session.getAttribute("personne");
		Personne utilisateur = null;
		// Constituer la nouvelle page
		if (noSerie != null && personne.getIdentifiant() != null) {

			if (personne.getIdentifiant().equals("Admin")) {
				String sUtilisateur = request.getParameter("utilisateur");
				
				ListPersonne lstpersonne = new ListPersonne();
				for (int i = 0; i < lstpersonne.size(); i++) {
					if (lstpersonne.get(i).getIdentifiant().equals(sUtilisateur)) {
						utilisateur = lstpersonne.get(i);
						session.setAttribute("utilisateur", utilisateur);
						break;
					}
				}
				utilisateur=(Personne)session.getAttribute("utilisateur");
				if (utilisateur==null) {
					RequestDispatcher rd = request.getRequestDispatcher("//Servletaccueilchargementprofil");
					rd.forward(request, response);
				}
				/** Lecture Haut de page HTML */
				File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
				BufferedReader bufReadHaut = null;
				bufReadHaut = new BufferedReader(new FileReader(fileHaut));
				String lineHaut = bufReadHaut.readLine();
				while (lineHaut != null) {
					if (lineHaut.contains("<title>Espace Personnel ActivConsulting</title>")) {
						lineHaut = lineHaut.replace("<title>Espace Personnel ActivConsulting</title>", "<title>Chargement</title>");
					}
					response.getWriter().println(lineHaut);
					lineHaut = bufReadHaut.readLine();
				}
				bufReadHaut.close();

				/** A modifier seulement si notre page contient du JavaScript */
				File fileJS = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSAccueilAdmin.html");
				BufferedReader bufReadJS = null;
				bufReadJS = new BufferedReader(new FileReader(fileJS));
				String lineJS = bufReadJS.readLine();
				while (lineJS != null) {
					response.getWriter().println(lineJS);
					lineJS = bufReadJS.readLine();
				}
				bufReadJS.close();

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
						lineDoc = lineDoc.replace("%utilisateur%", ((utilisateur.getIdentifiant() == null) ? "" : utilisateur.getIdentifiant()));
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/AccueilAdmin.html");
				BufferedReader bufReadDoc1 = null;
				bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
				String lineDoc1 = bufReadDoc1.readLine();
				while (lineDoc1 != null) {
					if (lineDoc1.contains("%listepersonne%")) {
						for (int i = 0; i < lstpersonne.size(); i++) {
							if (lineDoc1.contains("%listepersonne%") && i < lstpersonne.size() - 1) {
								lineDoc1 = lineDoc1.replace("%listepersonne%", lstpersonne.get(i).getIdentifiant()) + "<option value=\"%listepersonne%\">";
							} else if (lineDoc1.contains("%listepersonne%") && i == lstpersonne.size() - 1) {
								lineDoc1 = lineDoc1.replace("%listepersonne%", lstpersonne.get(i).getIdentifiant());
							}
						}
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
