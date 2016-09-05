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

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletCoordonnees2", name = "ServletCoordonnees2")
public class ServletCoordonnees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCoordonnees() {
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
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "Coordonees");
			session.setAttribute("methode", "POST");
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
			Personne personne = (Personne) session.getAttribute("Personne");

			fonctions.AfficherHautDePage(response);

			File file2 = new File(
					"C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/Coordonnees.html");
			BufferedReader bIn = null;
			InputStreamReader inputStreamReader = null;
			try {
				inputStreamReader = new InputStreamReader(new FileInputStream(file2), "UTF-8");
				bIn = new BufferedReader(inputStreamReader);
				String line = bIn.readLine();
				while (line != null) {
					line=line.replace("%%nom%%", personne.getNom());

					line=line.replace("%%prenom%%", personne.getPrenom());

					
						line=line.replace("%%adresse%%", personne.getAdresse());
					
						line=line.replace("%%cp%%", personne.getcP());
					
						line=line.replace("%%ville%%", personne.getVille());
					
						line=line.replace("%%telFixe%%", personne.getTelFixe());
					
						line=line.replace("%%telPort%%", personne.getTelPort());
					
						line=line.replace("%%email%%", personne.getEmail());
					
						line=line.replace("%%fax%%", personne.getFax());
					
					response.getWriter().append(line + "\n");
					line = bIn.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			fonctions.AfficherBasDePage(response);

		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletLoginTest");
			rd.forward(request, response);
		}
	}
}