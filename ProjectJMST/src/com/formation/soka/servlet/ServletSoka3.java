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
import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.fonction.FonctionCommune;
import com.formation.thcr.metier.Personne;
import com.formation.thcr.metier.Sexe;

/**
 * Servlet implementation class ServletSoka3
 */
@WebServlet("/ServletSoka3")
public class ServletSoka3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSoka3() {
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
		if (perso.getNationalite().equals("")) {
			String sDateNaissance = request.getParameter("datedenaissance");
			String sLieuNaissance = request.getParameter("lieudenaissance");
			String sNumSecu = request.getParameter("numsecu");
			String sNationalite = request.getParameter("nationalite");
			/***************************
			 * CONTROLE ET CONVERSION
			 */
			CtrlPersonne ctrl = new CtrlPersonne();
			if (ctrl.ctrlDateNaissance(sDateNaissance) && ctrl.ctrlLieuNaissance(sLieuNaissance)
					&& ctrl.ctrlNumSecu(sNumSecu) && ctrl.ctrlNationalite(sNationalite)) {
				ConversionPersonne conv = new ConversionPersonne();
				perso.setDateNaissance(conv.conversionDate(sDateNaissance));
				perso.setLieuNaissance(sLieuNaissance);
				perso.setNumSecu(sNumSecu);
				if (perso.getNumSecu().charAt(0) == '1') {
					perso.setSexe(new Sexe(Sexe.MASCULIN));
				} else {
					perso.setSexe(new Sexe(Sexe.FEMININ));
				}
				perso.setNationalite(sNationalite);
			} else {
				// JSP DECO
			}
		}
		File page = new File(FonctionCommune.LOCAL + "/WEB-INF/page/pageActiveFormulaire_part4_situation_actuelle.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(page));

		if (noSerieHtml == null || noSerie == null || noSerieHtml.equals(noSerie)) {
			String line = bIn.readLine();
			while (line != null) {
				line = line.replace("%%noSerie%%", noSerie);
				if (perso.getSituation().equals("Salarie")) {
					line = line.replace("type=\"radio\" name=\"situationPro\" value=\"Salarie\">",
							"type=\"radio\" name=\"situationPro\" value=\"Salarie\" checked=\"checked\">");
				} else if (perso.getSituation().equals("auto entrepreneur")) {
					line = line.replace("type=\"radio\" name=\"situationPro\" value=\"auto entrepreneur\">",
							"type=\"radio\" name=\"situationPro\" value=\"auto entrepreneur\" checked=\"checked\">");
				} else if (perso.getSituation().equals("freelance")) {
					line = line.replace("type=\"radio\" name=\"situationPro\" value=\"freelance\">",
							"type=\"radio\" name=\"situationPro\" value=\"freelance\" checked=\"checked\">");
				} else if (perso.getSituation().equals("demandeur d'emploi")) {
					line = line.replace("type=\"radio\" name=\"situationPro\" value=\"demandeur d'emploi\">",
							"type=\"radio\" name=\"situationPro\" value=\"demandeur d'emploi\" checked=\"checked\">");
				} else if (perso.getSituation().equals("retraite")) {
					line = line.replace("type=\"radio\" name=\"situationPro\" value=\"retraite\">",
							"type=\"radio\" name=\"situationPro\" value=\"retraite\" checked=\"checked\">");
				} else {
					line = line.replace("type=\"radio\" name=\"situationPro\" value=\"\">",
							"type=\"radio\" name=\"situationPro\" value=\"\" checked=\"checked\">");
					line = line.replace("%%autre%%", perso.getSituation());
				}
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
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
