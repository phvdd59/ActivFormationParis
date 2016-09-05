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

import com.formation.joca.controleur.CtrlPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletSoka4
 */
@WebServlet("/ServletSoka4")
public class ServletSoka4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSoka4() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");

		Object personne = session.getAttribute("Personne");
		Personne perso = null;
		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}

		/***************************
		 * RECUP DONNEE FORMULAIRE
		 */
		String sSituationPro = request.getParameter("situationPro");
		String sSituation = request.getParameter("situation");

		/***************************
		 * CONTROLE ET CONVERSION
		 */
		CtrlPersonne ctrl = new CtrlPersonne();
		if (ctrl.ctrlSituation(sSituationPro)){
		perso.setSituation(sSituationPro);
		//perso.setSituation(sSituation);

			File file = new File("C:/DevFormation/GITActivFormationParis/" + //
					"ProjectJMST/WebContent/WEB-INF/" + //
					"page/pageActiveFormulaire_part5_fonction_remuneration.html");
			BufferedReader bIn = null;
			bIn = new BufferedReader(new FileReader(file));

			if (noSerieHtml.equals(noSerie)) {
				noSerie = "24_" + noSerie;
				session.setAttribute("noSerie", noSerie);
				String line = bIn.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = bIn.readLine();
				}
				bIn.close();
			}
		} else {
			File file = new File("C:/DevFormation/GITActivFormationParis/" + //
					"ProjectJMST/WebContent/WEB-INF/" + //
					"page/pageActiveFormulaire_part4_situation_actuelle.html");
			BufferedReader bIn = null;
			bIn = new BufferedReader(new FileReader(file));

			if (noSerieHtml.equals(noSerie)) {
				noSerie = "24_" + noSerie;
				session.setAttribute("noSerie", noSerie);
				String line = bIn.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = bIn.readLine();
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
