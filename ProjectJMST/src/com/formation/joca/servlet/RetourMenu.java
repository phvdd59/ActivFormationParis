package com.formation.joca.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class RetourMenu
 */
@WebServlet("/RetourMenu")
public class RetourMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetourMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Object personne = session.getAttribute("Personne");
		Personne perso = null;
		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}

		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");

		if (noSerie.equals(noSerieHtml)) {

			if (perso.isAdmin()) {
				BufferedReader lecture = null;
				File page = new File(
						"../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
				InputStreamReader input = new InputStreamReader(new FileInputStream(page));
				lecture = new BufferedReader(input);

				String line = lecture.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = lecture.readLine();
				}
				lecture.close();
			} else if (!perso.isAdmin()) {
				BufferedReader lecture = null;
				File page = new File(
						"../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteutilisateur.html");
				InputStreamReader input = new InputStreamReader(new FileInputStream(page));
				lecture = new BufferedReader(input);

				String line = lecture.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = lecture.readLine();
				}
				lecture.close();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
