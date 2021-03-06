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

/**
 * Servlet implementation class ServletSokaCoordPerso
 */
@WebServlet("/ServletSoka2")
public class ServletSoka2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSoka2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ConversionPersonne convPers = new ConversionPersonne();

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
		if (noSerieHtml != null || noSerieHtml.equals(noSerie)) {
			
			try {
				if (perso.getPrenom()!=null && perso.getPrenom().equals("")) {
					String sNom = request.getParameter("nom");
					String sPrenom = request.getParameter("prenom");
					String sAdresse = request.getParameter("adresse");
					String sTelFixe = request.getParameter("telfixe");
					String sTelPort = request.getParameter("telportable");
					String sFax = request.getParameter("fax");
					String sCp = request.getParameter("codepostale");
					String sVille = request.getParameter("ville");
					String sEmail = request.getParameter("mail");
					/***************************
					 * CONTROLE ET CONVERSION
					 */
					CtrlPersonne ctrl = new CtrlPersonne();

					if (ctrl.ctrlNom(sNom) && ctrl.ctrlPrenom(sPrenom) && ctrl.ctrlAdresse(sAdresse) && ctrl.ctrlTelFixe(sTelFixe) && ctrl.ctrlTelPort(sTelPort) && ctrl.ctrlCp(sCp) && ctrl.ctrlVille(sVille) && ctrl.ctrlFax(sFax) && ctrl.ctrlEmail(sEmail)) {
						perso.setNom(sNom);
						perso.setPrenom(sPrenom);
						perso.setAdresse(sAdresse);
						perso.setTelFixe(sTelFixe);
						perso.setTelPort(sTelPort);
						perso.setFax(sFax);
						perso.setCp(sCp);
						perso.setVille(sVille);
						perso.setEmail(sEmail);
					} else {
						// JSP DECO
					}
				} else {
					request.getRequestDispatcher("/ServletDeco").forward(request, response);
				}
			} catch (Exception e) {
				request.getRequestDispatcher("/ServletDeco").forward(request, response);
			}

			File page = new File(FonctionCommune.LOCAL + "t/WEB-INF/page/pageActiveFormulaire_part3_etat_civil.html");
			BufferedReader bIn = null;
			bIn = new BufferedReader(new FileReader(page));

			session.setAttribute("noSerie", noSerie);
			String line = bIn.readLine();
			while (line != null) {
				line = line.replace("%%noSerie%%", noSerie);
				line = line.replace("%%datenaissance%%", convPers.conversionSQLToUtil(new java.sql.Date(perso.getDateNaissance().getTime())));
				line = line.replace("%%lieunaissance%%", perso.getLieuNaissance());
				line = line.replace("%%numsecu%%", perso.getNumSecu());
				line = line.replace("%%nationalite%%", perso.getNationalite());
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
		} else {
			request.getRequestDispatcher("/ServletDeco").forward(request, response);
		}

		// File file = new File("C:/DevFormation/" + //
		// "GITActivFormationParis/ProjectJMST/" + //
		// "WebContent/WEB-INF/" + //
		// "page/pageActiveFormulaire_part2_coordonnees_personnelles.html");
		// BufferedReader bIn = null;
		// bIn = new BufferedReader(new FileReader(file));
		// if (noSerieHtml.equals(noSerie)) {
		// session.setAttribute("noSerie", noSerie);
		// String line = bIn.readLine();
		// while (line != null) {
		// if (line.contains("%%noSerie%%")) {
		// line = line.replace("%%noSerie%%", noSerie);
		// }
		// response.getWriter().println(line);
		// line = bIn.readLine();
		// }
		// bIn.close();
		// }

		// controle + set Personne
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
