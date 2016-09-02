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
 * Servlet implementation class ServletIdentMdp
 */
@WebServlet("/ServletSoka1")
public class ServletSoka1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSoka1() {
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
		File file = new File("C:/DevFormation/" + //
				"GITActivFormationParis/ProjectJMST/" + //
				"WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part1_ident_mdp.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");

		if (noSerieHtml.equals(noSerie)) {
			noSerie = "20_" + noSerie;
			session.setAttribute("noSerie", noSerie);
			String line = bIn.readLine();
			while (line != null) {
				if (line.contains("%%noSerie%%")) {
					line.replace("%%noSerie%%", noSerie);
				}
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String pseudo = request.getParameter("identifiant");
		// String mdp = request.getParameter("mdp");
		HttpSession session = request.getSession();
		
		Object personne = session.getAttribute("Personne");
		Personne perso = null;
		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}

		/***************************
		 * RECUP DONNEE FORMULAIRE
		 */
		String sIdentifiant = request.getParameter("identifiant");
		String sMdp = request.getParameter("mdp");
		/***************************
		 * CONTROLE ET CONVERSION
		 */
		CtrlPersonne ctrl = new CtrlPersonne();
//		if(ctrl.ctrlIdentifiant(sIdentifiant) && ctrl.ctrlMdp(sMdp)){
			perso.setIdentifiant(sIdentifiant);
			perso.setMdp(sMdp);
//		}
		
		File file = new File("C:/DevFormation/" + //
				"GITActivFormationParis/ProjectJMST/" + //
				"WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part2_coordonnees_personnelles.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");

		if (noSerieHtml.equals(noSerie)) {
			noSerie = "21_" + noSerie;
			session.setAttribute("noSerie", noSerie);
			String line = bIn.readLine();
			while (line != null) {
				if (line.contains("%%noSerie%%")) {
					line=line.replace("%%noSerie%%", noSerie);
				}
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
		}
	}
}
