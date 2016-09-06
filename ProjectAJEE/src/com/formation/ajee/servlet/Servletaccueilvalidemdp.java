package com.formation.ajee.servlet;

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


@WebServlet("/Servletaccueilvalidemdp")
public class Servletaccueilvalidemdp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletaccueilvalidemdp() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Object noSerie = session.getAttribute("noSerie");
		ListPersonne lstPersonne=new ListPersonne();
		Personne utilisateur =(Personne) session.getAttribute("utilisateur");
		Personne personne = (Personne) session.getAttribute("personne");
		String sMdp=request.getParameter("VmdpN");
		personne.setMdp(sMdp);
		
		if (noSerie != null && personne.getIdentifiant() != null) {
			if (personne.getIdentifiant().equals("Admin")) {
				
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

				File fileJS1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSBandeauAdmin.html");
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

				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/AccueilAdmin.html");
				BufferedReader bufReadDoc1 = null;
				bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
				String lineDoc1 = bufReadDoc1.readLine();
				while (lineDoc1 != null) {
					if (lineDoc1.contains("%listepersonne%")){
					for (int i = 0; i <lstPersonne.size(); i++) {
						if (lineDoc1.contains("%listepersonne%")&&i<lstPersonne.size()-1) {
							lineDoc1 = lineDoc1.replace("%listepersonne%", lstPersonne.get(i).getIdentifiant())+"<option value=\"%listepersonne%\">";
						}else if (lineDoc1.contains("%listepersonne%")&&i==lstPersonne.size()-1) {
							lineDoc1 = lineDoc1.replace("%listepersonne%", lstPersonne.get(i).getIdentifiant());
						}
					}}
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

			else if (personne.getIdentifiant().isEmpty()==false) {
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

				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Accueil.html");
				BufferedReader bufReadDoc1 = null;
				bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
				String lineDoc1 = bufReadDoc1.readLine();
				while (lineDoc1 != null) {
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
