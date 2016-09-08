package com.formation.bait.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.bait.metier.FonctionsCommune;
import com.formation.bait.metier.Personne;
import com.formation.bait.metier.SITUATION;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletErreurSave", name = "ServletErreurSave")
public class ServletErreurSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletErreurSave() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FonctionsCommune fonctions = new FonctionsCommune();
		HttpSession session = request.getSession();
		Object oNoSuivi = session.getAttribute("suivi");

		if (oNoSuivi != null) {
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
			fonctions.AfficherHautDePage(response);
			String sProvenance = (String) session.getAttribute("servlet");
			File file2 = new File(
					FonctionsCommune.LOCAL+"WEB-INF/bait/pages/redirection.html");
			BufferedReader bIn2 = null;
			InputStreamReader inputStreamReader2 = null;
			try {
				inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
				bIn2 = new BufferedReader(inputStreamReader2);
				String line2 = bIn2.readLine();

				while (line2 != null) {

					if (line2.contains("%%redirection%%")) {
						if (sProvenance.equals("EtatCivil")) {
							line2 = line2.replace("%%redirection%%",
									"http://"+FonctionsCommune.HOST+":8080/ProjectBAIT/ServletEtatCivil2");

						}

						else if (sProvenance == "Coordonees") {
							line2 = line2.replace("%%redirection%%",
									"http://"+FonctionsCommune.HOST+":8080/ProjectBAIT/ServletCoordonnees2");

						}

						else if (sProvenance.equals("Situation")) {
							line2 = line2.replace("%%redirection%%",
									"http://"+FonctionsCommune.HOST+":8080/ProjectBAIT/ServletSituation2");
						}

						else if (sProvenance.equals("Remuneration")) {
							line2 = line2.replace("%%redirection%%",
									"http://"+FonctionsCommune.HOST+":8080/ProjectBAIT/ServletRemuneration2");

						}
					}
					response.getWriter().append(line2 + "\n");
					line2 = bIn2.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bIn2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			fonctions.AfficherBasDePage(response);
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
			rd.forward(request, response);
		}
	}

}