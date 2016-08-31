package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.ajee.metier.Personne;
import com.formation.ajee.metier.ListPersonne;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/Servletidentification", name = "Servletidentification")
public class Servletidentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletidentification() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.logout();
		ListPersonne lstPersonne = new ListPersonne();
		Personne personne = new Personne();

		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/Identification.html");
		// System.out.println(file.getCanonicalPath());
		int noSerie = (int) Math.random() * Integer.MAX_VALUE;
		HttpSession session = request.getSession(true); // true pour garder le
														// meme numero de
														// session qui vient
														// detre créé
		session.setAttribute("lstpersonne", lstPersonne);
		System.out.println(session.getId());
		// donne le numero de session
		session.setAttribute("noSerie", Integer.valueOf(noSerie));

		BufferedReader bIn = new BufferedReader(new FileReader(file));
		String line = bIn.readLine();
		while (line != null) {
			// if (line.contains("%%noserie%%")) {
			// line = line.replace("%%noserie%%", Integer.toString(noserie));
			// }
			response.getWriter().println(line);
			line = bIn.readLine();
		}
		bIn.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// request.logout();
		HttpSession session = request.getSession();

		// String sS=request.getParameter("JSESSIONID");
		System.out.println(session.getId());
		Object oNoSerie = session.getAttribute("noSerie");
		if (oNoSerie != null) {

			// recuperer les parametres
			String boutonEntrer = request.getParameter("entrer");
			String boutonInscription = request.getParameter("inscription");
			String pseudo = request.getParameter("Identifiant");
			System.out.println(pseudo);
			String mdp = request.getParameter("mot de passe");
			System.out.println(mdp);
			session.setAttribute("pseudo", pseudo);
			session.setAttribute("mdp", mdp);
			// controler les parametres

			if (boutonEntrer != null) {
				if ((pseudo != "") && (mdp != "")) {
					if (pseudo.equals("Admin") && (mdp.equals("123"))) {

						// constituer la nouvelle page
						// /** Lecture Haut de page JSP */
						// File fileHautjsp = new
						// File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.jsp");
						// BufferedReader bufReadHautjsp = null;
						// bufReadHautjsp = new BufferedReader(new
						// FileReader(fileHautjsp));
						// String lineHautjsp = bufReadHautjsp.readLine();
						// while (lineHautjsp != null) {
						// resp.getWriter().println(lineHautjsp);
						// lineHautjsp = bufReadHautjsp.readLine();
						// }
						// bufReadHautjsp.close();
						/** Lecture Haut de page HTML */
						File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
						BufferedReader bufReadHaut = null;
						bufReadHaut = new BufferedReader(new FileReader(fileHaut));
						String lineHaut = bufReadHaut.readLine();
						while (lineHaut != null) {
							if (lineHaut.contains("<title>Espace Personnel ActivConsulting</title>")) {
								lineHaut = lineHaut.replace("<title>Espace Personnel ActivConsulting</title>", "<title>Accueil</title>");
							}
							resp.getWriter().println(lineHaut);
							lineHaut = bufReadHaut.readLine();
						}
						bufReadHaut.close();

						/**
						 * A modifier seulement si notre page contient du
						 * JavaScript
						 */
						File fileJS = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSAccueilAdmin.html");
						BufferedReader bufReadJS = null;
						bufReadJS = new BufferedReader(new FileReader(fileJS));
						String lineJS = bufReadJS.readLine();
						while (lineJS != null) {
							resp.getWriter().println(lineJS);
							lineJS = bufReadJS.readLine();
						}
						bufReadJS.close();

						File fileJS1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSBandeauAdmin.html");
						BufferedReader bufReadJS1 = null;
						bufReadJS1 = new BufferedReader(new FileReader(fileJS1));
						String lineJS1 = bufReadJS1.readLine();
						while (lineJS1 != null) {
							resp.getWriter().println(lineJS1);
							lineJS1 = bufReadJS1.readLine();
						}
						bufReadJS1.close();

						/** Lecture page ActivConsulting */
						File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
						BufferedReader bufReadActiv = null;
						bufReadActiv = new BufferedReader(new FileReader(fileActiv));
						String lineActiv = bufReadActiv.readLine();
						while (lineActiv != null) {
							resp.getWriter().println(lineActiv);
							lineActiv = bufReadActiv.readLine();
						}
						bufReadActiv.close();

						/**
						 * Seule Partie qui va vraiment changer selon les pages
						 * (penser aux controles si necessaire)
						 */
						File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
						BufferedReader bufReadDoc = null;
						bufReadDoc = new BufferedReader(new FileReader(fileDoc));
						String lineDoc = bufReadDoc.readLine();
						while (lineDoc != null) {
							if (lineDoc.contains("%pseudo%")) {
								lineDoc = lineDoc.replace("%pseudo%", pseudo);
							}
							if (lineDoc.contains("%utilisateur%")) {
								lineDoc = lineDoc.replace("%utilisateur%", "");
							}
							resp.getWriter().println(lineDoc);
							lineDoc = bufReadDoc.readLine();
						}
						bufReadDoc.close();

						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/AccueilAdmin.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							resp.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();

						/** Lecture bas de page */
						File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
						BufferedReader bufReadBas = null;
						bufReadBas = new BufferedReader(new FileReader(fileBas));
						String lineBas = bufReadBas.readLine();
						while (lineBas != null) {
							resp.getWriter().println(lineBas);
							lineBas = bufReadBas.readLine();
						}
						bufReadBas.close();
					} else {
						
						// verif mdp et identifiant personne pour se connecter
						// atention quand personne supp avec boolean
						
						/** Lecture Haut de page HTML */
						File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
						BufferedReader bufReadHaut = null;
						bufReadHaut = new BufferedReader(new FileReader(fileHaut));
						String lineHaut = bufReadHaut.readLine();
						while (lineHaut != null) {
							resp.getWriter().println(lineHaut);
							lineHaut = bufReadHaut.readLine();
						}
						bufReadHaut.close();

						/**
						 * A modifier seulement si notre page contient du
						 * JavaScript
						 */
						//
						// File fileJS1 = new
						// File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSBandeau.html");
						// BufferedReader bufReadJS1 = null;
						// bufReadJS1 = new BufferedReader(new FileReader(fileJS1));
						// String lineJS1 = bufReadJS1.readLine();
						// while (lineJS1 != null) {
						// resp.getWriter().println(lineJS1);
						// lineJS1 = bufReadJS1.readLine();
						// }
						// bufReadJS1.close();

						/** Lecture page ActivConsulting */
						File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
						BufferedReader bufReadActiv = null;
						bufReadActiv = new BufferedReader(new FileReader(fileActiv));
						String lineActiv = bufReadActiv.readLine();
						while (lineActiv != null) {
							resp.getWriter().println(lineActiv);
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
								lineDoc = lineDoc.replace("%pseudo%", pseudo);
							}
							resp.getWriter().println(lineDoc);
							lineDoc = bufReadDoc.readLine();
						}
						bufReadDoc.close();

						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Accueil.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							resp.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();

						/** Lecture bas de page */
						File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
						BufferedReader bufReadBas = null;
						bufReadBas = new BufferedReader(new FileReader(fileBas));
						String lineBas = bufReadBas.readLine();
						while (lineBas != null) {
							resp.getWriter().println(lineBas);
							lineBas = bufReadBas.readLine();
						}
						bufReadBas.close();

					}
				} else {
					session.invalidate();
					doGet(request, resp);
				}
			} else if (boutonInscription != null) {
				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/FormulaireARemplir.html");
				BufferedReader bufReadDoc1 = null;
				bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
				String lineDoc1 = bufReadDoc1.readLine();
				while (lineDoc1 != null) {
					resp.getWriter().println(lineDoc1);
					lineDoc1 = bufReadDoc1.readLine();
				}
				bufReadDoc1.close();
			}
		} else {
			session.invalidate();
			doGet(request, resp);
		}
	}

}
