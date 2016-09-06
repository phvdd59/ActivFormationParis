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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Object personne = session.getAttribute("Personne");
		Personne perso = null;
		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}
		String sIdentifiant = null;
		String sMdp1 = null;
		String sMdp2 = null;

		if (perso.getIdentifiant() == null || perso.getIdentifiant().equals("")) { //utile au cas où on appelle cette servlet par "precedent"

			/***************************
			 * RECUP DONNEE FORMULAIRE
			 */
			sIdentifiant = request.getParameter("identifiant");
			sMdp1 = request.getParameter("mdp1");
			sMdp2 = request.getParameter("mdp2");
			/***************************
			 * CONTROLE ET CONVERSION
			 */
			CtrlPersonne ctrl = new CtrlPersonne();
			System.out.println();
			if (ctrl.ctrlIdentifiant(sIdentifiant) && ctrl.ctrlMdp(sMdp1) && ctrl.ctrlMdp(sMdp2) && sMdp1.equals(sMdp2)) {

				perso.setIdentifiant(sIdentifiant);
				perso.setMdp(sMdp1);

				DAOPersonne dao = new DAOPersonne();
				ListPersonne list = dao.read();

				boolean idExist = false;

				for (Personne p : list) {
					if (p.getIdentifiant().equals(perso.getIdentifiant())) {
						idExist = true;
					}
				}

				File file = new File("C:/DevFormation/" + //
						"GITActivFormationParis/ProjectJMST/" + //
						"WebContent/WEB-INF/" + //
						"page/pageActiveFormulaire_part2_coordonnees_personnelles.html");
				BufferedReader bIn = null;
				bIn = new BufferedReader(new FileReader(file));
				String noSerieHtml = request.getParameter("noSerie");
				String noSerie = (String) session.getAttribute("noSerie");

				if (noSerieHtml.equals(noSerie) && !idExist) {
					noSerie = "21_" + noSerie;
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
				} else if (noSerieHtml.equals(noSerie) && idExist) {
					File file2 = new File("C:/DevFormation/" + //
							"GITActivFormationParis/ProjectJMST/" + //
							"WebContent/WEB-INF/" + //
							"page/pageActiveFormulaire_part1_ident_mdp.html");
					BufferedReader bIn2 = null;
					bIn2 = new BufferedReader(new FileReader(file2));
					String line = bIn2.readLine();
					while (line != null) {
						if (line.contains("%%noSerie%%")) {
							line = line.replace("%%noSerie%%", noSerie);
						}
						if (line.contains("name=\"identifiant\"")) {
							line = line.replace("</th>", "<p style=\"color: red;\">login deja existant</p></th>");
						}
						response.getWriter().println(line);
						line = bIn2.readLine();
					}
					bIn2.close();
				}
			} else {
				File file2 = new File("C:/DevFormation/" + //
						"GITActivFormationParis/ProjectJMST/" + //
						"WebContent/WEB-INF/" + //
						"page/pageActiveFormulaire_part1_ident_mdp.html");
				BufferedReader bIn2 = null;
				bIn2 = new BufferedReader(new FileReader(file2));
				String line = bIn2.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						String noSerie = (String) session.getAttribute("noSerie");
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = bIn2.readLine();
				}
				bIn2.close();
			}
		} else {
			//Retour page précédente
			File file2 = new File("C:/DevFormation/" + //
					"GITActivFormationParis/ProjectJMST/" + //
					"WebContent/WEB-INF/" + //
					"page/pageActiveFormulaire_part1_ident_mdp.html");
			BufferedReader bIn2 = null;
			bIn2 = new BufferedReader(new FileReader(file2));
			String line = bIn2.readLine();
			while (line != null) {
				if (line.contains("%%noSerie%%")) {
					String noSerieHtml = request.getParameter("noSerie");
					String noSerie = (String) session.getAttribute("noSerie");
					line = line.replace("%%noSerie%%", noSerie);
				}
				response.getWriter().println(line);
				line = bIn2.readLine();
			}
			bIn2.close();
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
