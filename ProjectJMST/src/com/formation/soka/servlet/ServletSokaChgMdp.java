package com.formation.soka.servlet;

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
 * Servlet implementation class ServletSokaChgMdp
 */
@WebServlet("/ServletSokaChgMdp")
public class ServletSokaChgMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSokaChgMdp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Object personne = session.getAttribute("Personne");
		Personne perso = null;
		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}

		File file = new File("C:/DevFormation/GITActivFormationParis/" + //
				"ProjectJMST/WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part0_modif_mdp.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
		noSerie = "20_" + noSerie;
		session.setAttribute("noSerie", noSerie);
		String line = bIn.readLine();
		while (line != null) {
			if (line.contains("%%noSerie%%")) {
				line.replace("%%noSerie%%", noSerie);
			}
			if (perso.getLogin().equals(request.getParameter("identifiant")) && perso.getMotDePasse().equals(request.getParameter("mdp"))) {
				if (request.getParameter("new mdp 1").equals(request.getParameter("new mdp 2"))) {
					perso.setMotDePasse(request.getParameter("new mdp 2"));
				}
			}
			response.getWriter().println(line);
			line = bIn.readLine();
		}
		bIn.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
