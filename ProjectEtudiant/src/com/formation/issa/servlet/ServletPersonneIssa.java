package com.formation.issa.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.issa.metier.ListPersonne;
import com.formation.issa.metier.Personne;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet(name = "Servlet Personne", value = "/ServletPersonneIssa")
public class ServletPersonneIssa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ListPersonne lstPersonne;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPersonneIssa() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		lstPersonne = new ListPersonne();
		Personne personne1 = new Personne("Cresson", "Thomas", false);
		lstPersonne.add(personne1);
		System.out.println(lstPersonne.size() + " " + personne1.getNom());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des données utilisateurs.
		String pNom = request.getParameter("Nom");
		// getParamater ne récupère que les input
		String pPrenom = request.getParameter("Prenom");
		String pSexe = request.getParameter("Sexe");
		System.out.println("pNom" + "pPrenom" + "pSexe");
		// Contrôle des données.
		String rPrenom = "erreur";
		if (pSexe != null && pSexe.equals("Mme") || pSexe.equals("Mr")) {
			System.out.println("pNom" + " " + "pPrenom" + " " + "pSexe");
			synchronized (lstPersonne) {

				for (int i = 0; i < lstPersonne.size(); i++) {
					Personne p = lstPersonne.get(i);
					if (p.getNom().equals(pNom)) {
						if (pSexe.equals("Mme")) {
							if (p.isSexe()) {
								// OK
								// On donne le prénom que lorsque l'on a le nom
								// et le sexe.
								rPrenom = p.getPrenom();

							} else {
								// NOK
								rPrenom = "Erreur";
							}
						} else {
							if (p.isSexe()) {
								rPrenom = p.getPrenom();
							} else {

								rPrenom = "Erreur";
							}
						}

					}
				}
			}
			response.getWriter().println(rPrenom);
		} else {
			response.getWriter().println("Erreur");
		}
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
