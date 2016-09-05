package com.formation.made;

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

import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class Servletmadeversmenu
 */
@WebServlet("/Servletmadeversmenu")
public class Servletmadeversmenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletmadeversmenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object objNoSerieSession = session.getAttribute("noSerie");
		Object objPersonne = session.getAttribute("Personne");
		String noSeriePageAdmin = request.getParameter("noSerie");// ajouter le name noSerie dans l'html
		
		if (objPersonne instanceof Personne && objNoSerieSession instanceof String) {
			String strNoSerieSession = (String) objNoSerieSession;
			Personne pPersonne = (Personne) objPersonne;
			if (strNoSerieSession.equals(noSeriePageAdmin)) {
				BufferedReader bIn = null;

				if (pPersonne.isAdmin()) {
					File file = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
					bIn = new BufferedReader(new FileReader(file));
					String maLigne = bIn.readLine();
					while (maLigne != null) {
						if (maLigne.contains("%%noSerie%%")) {
							maLigne = maLigne.replace("%%noSerie%%", strNoSerieSession);
						}
						response.getWriter().println(maLigne);
						maLigne = bIn.readLine();
					}
				} else if (!pPersonne.isAdmin()) {
					File file = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteutilisateur.html");
					bIn = new BufferedReader(new FileReader(file));
					String maLigne = bIn.readLine();
					while (maLigne != null) {
						if (maLigne.contains("%%noSerie%%")) {
							maLigne = maLigne.replace("%%noSerie%%", strNoSerieSession);
						}
						response.getWriter().println(maLigne);
						maLigne = bIn.readLine();
					}
				}
				bIn.close();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
