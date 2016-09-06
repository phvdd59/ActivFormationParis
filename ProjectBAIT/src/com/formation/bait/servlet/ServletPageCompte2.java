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

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.FonctionsCommune;
import com.formation.bait.metier.Personne;
import com.formation.bait.metier.VerifComplet;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletPageCompte2", name = "ServletPageCompte2")
public class ServletPageCompte2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPageCompte2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("//ServletPageCompte2");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		AccesBDDPersonne bddPersonne = new AccesBDDPersonne();
		Personne personne = new Personne();
		FonctionsCommune fonctions = new FonctionsCommune();

		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "Compte");
			session.setAttribute("methode", "POST");
			personne = (Personne) session.getAttribute("Personne");

			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
			fonctions.AfficherHautDePage(response);

			File file2 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/PageCompte.html");
			BufferedReader bIn2 = null;
			InputStreamReader inputStreamReader2 = null;

			try {
				VerifComplet verif = new VerifComplet();
				inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
				bIn2 = new BufferedReader(inputStreamReader2);
				String line2 = bIn2.readLine();
				while (line2 != null) {
					// System.out.println(line);

					line2 = line2.replace("en tant que :", "en tant que :      " + personne.getPrenom() +" "+ personne.getNom());
					boolean test = verif.validTotal(session);
					if (line2.contains("disabled")) {
						if (verif.validTotal(session)) {
							line2 = line2.replace("disabled=\"disabled\"", "");
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
			RequestDispatcher rd = request.getRequestDispatcher("//ServletPageLogin3");
			rd.forward(request, response);
		}
	}
}