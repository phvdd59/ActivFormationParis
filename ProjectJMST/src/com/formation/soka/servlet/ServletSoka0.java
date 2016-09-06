package com.formation.soka.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletSoka0
 */
@WebServlet("/ServletSoka0")
public class ServletSoka0 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSoka0() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Enumeration<String> a = session.getAttributeNames();
		Personne perso = null;
		if (a.hasMoreElements()) {
			while (a.hasMoreElements()) {
				if (a.nextElement().equals("Personne")) {
					Object personne = session.getAttribute("Personne");
					if (personne instanceof Personne) {
						perso = (Personne) personne;
					}

				}
			}
		} else {
			perso = new Personne();
			session.setAttribute("Personne", perso);
			perso.setIdentifiant("");
		}

		File file = new File("C:/DevFormation/GITActivFormationParis/" + //
				"ProjectJMST/WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part1_ident_mdp.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
		noSerie = "20_" + noSerie;
		session.setAttribute("noSerie", noSerie);
		String line = bIn.readLine();
		while (line != null) {
			line = line.replace("%%noSerie%%", noSerie);
			line = line.replace("%%identifiant%%", perso.getIdentifiant());
			line = line.replace("%%motdepasse1%%", perso.getMdp());
			line = line.replace("%%motdepasse2%%", perso.getMdp());
			response.getWriter().println(line);
			line = bIn.readLine();
		}
		bIn.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
