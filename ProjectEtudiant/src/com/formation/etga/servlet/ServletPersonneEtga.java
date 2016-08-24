package com.formation.etga.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.etga.metier.ListePersonne;
import com.formation.etga.metier.Personne;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet(name = "ServletPersonneEtga", value = "/ServletPersonneEtga")
public class ServletPersonneEtga extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListePersonne lstPersonne;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPersonneEtga() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		lstPersonne = new ListePersonne();
		Personne personne1 = new Personne("Cresson", "Thomas", false);
		lstPersonne.add(personne1);
		System.out.println(lstPersonne.size() + " " + personne1.getNom());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des données utilisateur
		String pNom = request.getParameter("Nom");
		String pPrenom = request.getParameter("Prenom");
		String pSexe = request.getParameter("Sexe");
		System.out.println(pNom + " " + pPrenom + " " + pSexe);
		// controle des données
		String rPrenom = "Erreur";

		if ((pSexe != null) && (pSexe.equals("Mme")) || (pSexe.equals("Mr"))) {
			System.out.println(pNom + " " + pPrenom + " " + pSexe);
			synchronized (lstPersonne) {
				for (int i = 0; i < lstPersonne.size(); i++) {
					Personne p = lstPersonne.get(i);
					if (p.getNom().equals(pNom)) {
						if (pSexe.equals("Mme")) {
							if (p.isSexe()) {
								//ok
								rPrenom = p.getPrenom();
							} else {
								//non ok
								rPrenom = "erreur";
							}
						} else {
							if (!p.isSexe()) {
								//ok
								rPrenom = p.getPrenom();
							} else {
								//non ok
								rPrenom = "erreur";
							}
						}
					}
				}
				response.getWriter().println(rPrenom);
			}
		} else {
			response.getWriter().println("Errreur");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
