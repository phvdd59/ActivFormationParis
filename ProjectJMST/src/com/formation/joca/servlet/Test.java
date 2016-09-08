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

import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = null;

		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");

		Personne utilisateur = new Personne();
		utilisateur.setIdentifiant(identifiant);
		DAOPersonne dao = new DAOPersonne();
		if (dao.read(utilisateur, "personne")) {

			if (utilisateur != null && utilisateur.isAdmin() && utilisateur.getMdp().equals(motdepasse) && !utilisateur.isBloque()) {
				session = request.getSession(true);
				session.setAttribute("Personne", utilisateur);

				BufferedReader lecture = null;
				File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
				InputStreamReader input = new InputStreamReader(new FileInputStream(page));
				lecture = new BufferedReader(input);
				String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
				noSerie = "1a_" + noSerie;
				session.setAttribute("noSerie", noSerie);
				String line = lecture.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = lecture.readLine();
				}
				lecture.close();
				response.sendRedirect("/ProjectJMST/Servletmadeversmenu");
			} else if (utilisateur != null && !utilisateur.isBloque() && utilisateur.getMdp().equals(motdepasse)) {
				session = request.getSession(true);
				session.setAttribute("Personne", utilisateur);
				BufferedReader lecture = null;
				File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteutilisateur.html");
				InputStreamReader input = new InputStreamReader(new FileInputStream(page));
				lecture = new BufferedReader(input);
				String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
				noSerie = "1u_" + noSerie;
				session.setAttribute("noSerie", noSerie);
				String line = lecture.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = lecture.readLine();
				}
				lecture.close();
				response.sendRedirect("/ProjectJMST/Servletmadeversmenu");
			} else {
				BufferedReader lecture = null;
				File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Login.html");
				InputStreamReader input = new InputStreamReader(new FileInputStream(page));
				lecture = new BufferedReader(input);
				String line = lecture.readLine();
				while (line != null) {
					if (utilisateur.isBloque()) {
						line = line.replace("hidden\"></p>", "visible; color:red;\">utilisateur bloque</p>");
					} else {
						line = line.replace("hidden\"></p>", "visible; color:red;\">erreur de login</p>");
					}
					response.getWriter().println(line);
					line = lecture.readLine();
				}
				lecture.close();
			}
		} else {
			BufferedReader lecture = null;
			File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Login.html");
			InputStreamReader input = new InputStreamReader(new FileInputStream(page));
			lecture = new BufferedReader(input);
			String line = lecture.readLine();
			while (line != null) {
				if(line.contains("id=\"erreurLog\"")){
					line = line.replace("hidden\"></p>", "visible; color:red;\">login inexistant</p>");
				}
				response.getWriter().println(line);
				line = lecture.readLine();
			}
			lecture.close();
		}

		// BufferedReader lecture = null;
		// File page = new
		// File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
		// InputStreamReader input = new InputStreamReader(new
		// FileInputStream(page));
		// lecture = new BufferedReader(input);
		// String noSerie = Integer.toString(((int) (Math.random() *
		// Integer.MAX_VALUE)));
		// noSerie = "1_" + noSerie;
		// session.setAttribute("noSerie", noSerie);
		// String line = lecture.readLine();
		// while (line != null) {
		// if (line.contains("%%noSerie%%")) {
		// line.replace("%%noSerie%%", noSerie);
		// }
		// response.getWriter().println(line);
		// line = lecture.readLine();
		// }
		// lecture.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// HttpSession session = request.getSession(true);
		//
		// BufferedReader lecture = null;
		// File page = new
		// File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
		// InputStreamReader input = new InputStreamReader(new
		// FileInputStream(page));
		// lecture = new BufferedReader(input);
		// String noSerie = Integer.toString(((int) (Math.random() *
		// Integer.MAX_VALUE)));
		// session.setAttribute("noSerie", noSerie);
		// String line = lecture.readLine();
		// while (line != null) {
		// if (line.contains("%%noSerie%%")) {
		// line.replace("%%noSerie%%", noSerie);
		// }
		// response.getWriter().println(line);
		// line = lecture.readLine();
		// }
		// lecture.close();
	}
}
