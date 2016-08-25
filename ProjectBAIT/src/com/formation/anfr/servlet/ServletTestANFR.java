package com.formation.anfr.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.anfr.metier.ListePersonne;
import com.formation.anfr.metier.Personne;

/**
 * Servlet implementation class ServletTestANFR
 */
@WebServlet(name="ServletTestANFR", value="/ServletTestANFR")
public class ServletTestANFR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListePersonne lstPersonne;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestANFR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		lstPersonne = new ListePersonne();
		Personne personne1 = new Personne("Renaud", "Megane", "Mme");
		lstPersonne.add(personne1);
	//	System.out.println(lstPersonne.size() + " "  + personne1.toString());
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNom = request.getParameter("Nom");
		String pPrenom = request.getParameter("Prénom");
		String pSexe = request.getParameter("Sexe");
	//	System.out.println(pSexe + pNom + pPrenom);
		
		String rPrenom="";
		if (pSexe != null && (pSexe.equals("Mme") || pSexe.equals("Mr"))) {
			System.out.println(pNom + " " + pPrenom + " " + pSexe);
			for (int i = 0; i < lstPersonne.size(); i++) {
				Personne p=lstPersonne.get(i);
				if (p.getNom().equals(pNom)) {
					if (pSexe.equals("Mme")) {
						if (p.equals(pSexe)) {
							// OK
							rPrenom=p.getPrenom();
						} else {
							// NOK
							rPrenom="Erreur";
						}
					} else {
						if (!p.equals(pSexe)) {
							// OK
							rPrenom=p.getPrenom();
						} else {
							// NOK
							rPrenom="Erreur";
						}
					}
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
