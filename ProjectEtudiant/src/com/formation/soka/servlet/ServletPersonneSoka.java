package com.formation.soka.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.soka.metier.ListePersonne;
import com.formation.soka.metier.Personne;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet(description = "Servlet Personne Exemple", urlPatterns = { "/ServletPersonneSoka" })
public class ServletPersonneSoka extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ListePersonne lstPersonne;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPersonneSoka() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		lstPersonne = new ListePersonne();
		Personne personne1 = new Personne("Kadri", "Souad", true);
		lstPersonne.add(personne1);
		System.out.println(lstPersonne.size() + " " + personne1.getNom() + " " + personne1.getPrenom());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recup données
		String pNom = request.getParameter("Nom");
		String pPrenom = request.getParameter("Prenom");
		String pSexe = request.getParameter("Sexe");
		//Controle des donnes
		String rPrenom = "toto";
		if (pSexe != null && (pSexe.equals("Mme") || pSexe.equals("Mr"))) {
			System.out.println(pNom + " " + pPrenom + " " + pSexe);
			synchronized (lstPersonne) {//On synchronise prsq si on ajoute/remove une personne, le size de lstPersonne va changer
				for (int i = 0; i < lstPersonne.size(); i++) {
					Personne p = lstPersonne.get(i);
					if (p.getNom().equals(pNom)) {
						if (pSexe.equals("Mme")) {
							if (p.isSexe()) {
								//OK
								rPrenom = p.getPrenom();
							} else {
								//NONOK
								rPrenom = "Erreur";
							}
						} else {
							if (!p.isSexe()) {
								//OK
								rPrenom = p.getPrenom();
							} else {
								//NONOK
								rPrenom = "Erreur";
							}
						}

					}

				}
			}
			response.getWriter().println(rPrenom);
		} else {
			response.getWriter().println("ErreurFin");
		}
		//		Personne p = new Personne(pNom, pPrenom, b);
		//		lstPersonne.add(p);

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
