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
 * Servlet implementation class ServletMdp
 */
@WebServlet("/ServletMdpAdmin")
public class ServletMdpAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMdpAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("//Servletidentification");
		rd.forward(req, resp);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Object oNoSerie = session.getAttribute("noSerie");
		Object mdp = session.getAttribute("mdp");
		Personne utilisateur = (Personne) session.getAttribute("utilisateur");
		Personne personne = (Personne) session.getAttribute("personne");
		Vue vue = new Vue();
		
		if (oNoSerie != null && personne != null&& personne.getIdentifiant() != null) {
			if (personne.getIdentifiant().equals("Admin")) {
				
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");
				vue.lectureJS(response, "JSMotDePasse");
				vue.lectureJS(response, "JSBandeauAdmin");
				vue.lecturePage(response, "MenuActiv");
				
				/** Lecture Haut de page HTML */
				File fileDoc = new File(FonctionsCommune.LOCAL+"ajee/page1/BandeauAdmin.html");
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

				/** Lecture Mot de passe */
				vue.lecturePage(response, "MdpAdmin");

				/** Lecture bas de page */
				vue.lecturePage(response, "BasPage");
			
			} else {
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");
				vue.lectureJS(response, "JSBandeauAdmin");
				vue.lectureJS(response, "JSMotDePasse");
				vue.lecturePage(response, "MenuActiv");
				
				/** Lecture Haut de page HTML */
				File fileDoc = new File(FonctionsCommune.LOCAL+"ajee/page1/Bandeau.html");
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

				/** Lecture Mot de passe */
				vue.lecturePage(response, "MdpAdmin");

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
