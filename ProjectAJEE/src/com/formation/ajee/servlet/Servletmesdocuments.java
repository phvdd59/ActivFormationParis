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

import com.formation.ajee.metier.DocPerso;
import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.ListeDoc;
import com.formation.ajee.metier.Personne;
import com.formation.ajee.veriffom.Vue;

/**
 * Servlet implementation class ServletDocuments
 */
@WebServlet(value = "/MesDocuments", name = "Servletdocument")
public class Servletmesdocuments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListeDoc listeDoc;
	private DocPerso docPerso;

	/** @see HttpServlet#HttpServlet() */
	public Servletmesdocuments() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("//Servletidentification");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Object oNoSerie = session.getAttribute("noSerie");
		//		Object oPseudo = session.getAttribute("pseudo");
		Personne utilisateur = (Personne) session.getAttribute("utilisateur");
		Personne personne = (Personne) session.getAttribute("personne");
		Vue vue = new Vue();

		if (oNoSerie != null && personne != null&& personne.getIdentifiant() != null) {
			if (personne.getIdentifiant().equals("Admin")) {
				if (utilisateur == null) {
					RequestDispatcher rd = request.getRequestDispatcher("//Servletaccueilchargementprofil");
					rd.forward(request, response);
				} else {
					
					/** Lecture Haut de page HTML */
					vue.lecturePage(response, "HautPage");
				
					/** Lecture page ActivConsulting */
					vue.lecturePage(response, "MenuActiv");

					/** lecture du bandeau */
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

					/** lecture du corp de page */
					File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
					BufferedReader bufReadDoc1 = null;
					bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
					String lineDoc1 = bufReadDoc1.readLine();
					while (lineDoc1 != null) {
						if (lineDoc1.contains("%%value%%")) {
							if (listeDoc == null) {
								response.getWriter().println("<option value=\"%%value%%\">");
							} else {
								for (int i = 0; i < listeDoc.size(); i++) {
									lineDoc1 = lineDoc1.replace("%%value%%", listeDoc.get(i).getNomDocUtil());
									lineDoc1 = lineDoc1.replace("></", ">" + listeDoc.get(i).getNomDocUtil() + "</");
									response.getWriter().println("<option value=\"%%value%%\">");
								}
							}
						}
						response.getWriter().println(lineDoc1);
						lineDoc1 = bufReadDoc1.readLine();
					}
					bufReadDoc1.close();

					/** Lecture bas de page */
					vue.lecturePage(response, "BasPage");
				}
			} else {
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");
		
				/** Lecture page ActivConsulting */
				vue.lecturePage(response, "MenuActiv");

				/** lecture du bandeau */
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

				/** lecture du corp de page */
				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
				BufferedReader bufReadDoc1 = null;
				bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
				String lineDoc1 = bufReadDoc1.readLine();
				while (lineDoc1 != null) {
					if (lineDoc1.contains("%%value%%")) {
						if (listeDoc == null) {
							response.getWriter().println("<option value=\"%%value%%\">");
						} else {
							for (int i = 0; i < listeDoc.size(); i++) {
								lineDoc1 = lineDoc1.replace("%%value%%", listeDoc.get(i).getNomDocUtil());
								lineDoc1 = lineDoc1.replace("></", ">" + listeDoc.get(i).getNomDocUtil() + "</");
								response.getWriter().println("<option value=\"%%value%%\">");
							}
						}
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
