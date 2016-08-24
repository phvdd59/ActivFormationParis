package com.formation.made.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.made.metier.ListePersonne;
import com.formation.made.metier.Personne;

/**
 * Servlet implementation class ServletPersonneMade
 */
@WebServlet(name="ServletPersonneMade",value = "/ServletPersonneMade")
public class ServletPersonneMade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ListePersonne lstPersonne;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonneMade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//on creer un jeu d'essai dans l'init pour voi si ça marche
		lstPersonne=new ListePersonne();
		Personne personne1=new Personne("Cresson", "Thomas", false);
		lstPersonne.add(personne1);
		System.out.println(lstPersonne.size()+" "+lstPersonne.get(0).getNom());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperation des donnees
		String pNom=request.getParameter("Nom");
		String pPrenom=request.getParameter("Prenom");
		String pSexe=request.getParameter("Sexe");
		System.out.println(pNom+""+pPrenom+""+pSexe);
		//controle des donnees
		String retourPrenom="";
		if (pSexe!=null && (pSexe.equals("Mme")||pSexe.equals("Mr"))) {
			for (int i = 0; i < lstPersonne.size(); i++) {
				Personne p=lstPersonne.get(i);
				if (p.getNom().equals(pNom)) {
					if (pSexe.equals("Mme")) {
						
					}
				}
			}
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
