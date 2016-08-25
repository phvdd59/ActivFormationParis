package com.formation.ambr.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.ambr.metier.ListePersonne;
import com.formation.ambr.metier.Personne;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet(description = "Servlet Exemple", urlPatterns = { "/ServletPersonneAmbr" })
public class ServletPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ListePersonne lstPersonne;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		lstPersonne=new ListePersonne();
		Personne personne1 = new Personne("Cresson", "Thomas", false);
		lstPersonne.add(personne1);
		System.out.println(lstPersonne.size()+ "  "+personne1.getNom());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. récupérer els données. pX pour paramètre X
		String pNom=request.getParameter("Nom");
		String pPrenom=request.getParameter("Prenom");
		String pSexe=request.getParameter("Sexe");
		//2.Controle des donnees
		String rPrenom = "erreur";
		if (pSexe != null && (pSexe.equals("Mme") || pSexe.equals("Mr"))) {
			System.out.println(pNom+" "+pPrenom+" "+pSexe);
			synchronized (lstPersonne) { // pour protéger 
				for (int i = 0; i < lstPersonne.size(); i++) {
					Personne p=lstPersonne.get(i);
					if (p.getNom().equals(pNom)) { // controle
						if (pSexe.equals("Mme")) { // controle
							if (p.isSexe()) {
								//OK
								rPrenom=p.getPrenom(); // on réattribue rPrenom
							} else {
								//NOK
								rPrenom="Erreur";
							}
						} else {
							if (!p.isSexe()) {
								//OK
								rPrenom=p.getPrenom();
							} else {
								//NOK
								rPrenom="Erreur";
							}
						}
					}
				}
			}
			response.getWriter().println(rPrenom); // soit je renvoie le prénom, soit je renvoie erreur
		} else {
			response.getWriter().println("Erreur");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
