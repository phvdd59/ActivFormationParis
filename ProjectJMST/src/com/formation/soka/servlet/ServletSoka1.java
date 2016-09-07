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
import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.ListPersonne;
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

		Object personne = session.getAttribute("Personne");
		Personne perso = null;
		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}
		String sIdentifiant = null;
		String sMdp1 = null;
		String sMdp2 = null;
		boolean idExist = false;

		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");

		/***************************
		 * RECUP DONNEE FORMULAIRE
		 */
		if (perso.getIdentifiant().equals("")) {
			sIdentifiant = request.getParameter("identifiant");
			sMdp1 = request.getParameter("mdp1");
			sMdp2 = request.getParameter("mdp2");
			/***************************
			 * CONTROLE ET CONVERSION
			 */
			CtrlPersonne ctrl = new CtrlPersonne();
			if (ctrl.ctrlIdentifiant(sIdentifiant) && ctrl.ctrlMdp(sMdp1) && ctrl.ctrlMdp(sMdp2)
					&& sMdp1.equals(sMdp2)) {

				perso.setIdentifiant(sIdentifiant);
				perso.setMdp(sMdp1);
			} else {
				//FORWARD JSP DECO
			}
		}
		
		DAOPersonne dao = new DAOPersonne();
		ListPersonne list = dao.read();
		
		for (Personne p : list) {
			if (p.getIdentifiant().equals(perso.getIdentifiant())) {
				idExist = true;
				break;
			}
		}
		
		File file = new File("C:/DevFormation/" + //
				"GITActivFormationParis/ProjectJMST/" + //
				"WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part2_coordonnees_personnelles.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));

		if (noSerieHtml == null || noSerie == null || noSerieHtml.equals(noSerie) && !idExist) {
			session.setAttribute("noSerie", noSerie);
			String line = bIn.readLine();
			while (line != null) {
				line = line.replace("%%noSerie%%", noSerie);
				line = line.replace("%%nom%%", perso.getNom());
				line = line.replace("%%prenom%%", perso.getPrenom());
				line = line.replace("%%adresse%%", perso.getAdresse());
				line = line.replace("%%codepostale%%", perso.getCp());
				line = line.replace("%%ville%%", perso.getVille());
				line = line.replace("%%telfixe%%", perso.getTelFixe());
				line = line.replace("%%telportable%%", perso.getTelPort());
				line = line.replace("%%fax%%", perso.getFax());
				line = line.replace("%%mail%%", perso.getEmail());
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
		} else if (noSerieHtml.equals(noSerie) && idExist) {
			File file2 = new File("C:/DevFormation/" + //
					"GITActivFormationParis/ProjectJMST/" + //
					"WebContent/WEB-INF/" + //
					"page/pageActiveFormulaire_part1_ident_mdp.html");
			BufferedReader bIn2 = null;
			bIn2 = new BufferedReader(new FileReader(file2));
			String line = bIn2.readLine();
			while (line != null) {
				line = line.replace("%%noSerie%%", noSerie);
				line = line.replace("<p id=\"erreurLog\" style=\"visibility:hidden\"></p>",
						"<p id=\"erreurLog\" style=\"visibility:visible\">login existant</p>");
				line = line.replace("%%identifiant%%", perso.getIdentifiant());
				System.out.println(perso.getMdp());
				line = line.replace("%%motdepasse1%%", perso.getMdp());
				line = line.replace("%%motdepasse2%%", perso.getMdp());
				response.getWriter().println(line);
				line = bIn2.readLine();
			}
			bIn2.close();

		} else {
			request.getRequestDispatcher("/ServletDeco").forward(request, response);
		}

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
