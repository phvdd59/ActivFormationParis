package com.formation.ajee.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.Personne;

/**
 * Servlet implementation class ServletFormulaire
 */
@WebServlet(description = "Servlet Creation Formulaire Rempli", urlPatterns = { "/ServletCreaForRempli" })
public class ServletCreaForRempli_ExRecupParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreaForRempli_ExRecupParam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//1. Récupérer les données du formulaire
		// ouvrir le fichier formulaire
		String pNom=request.getParameter("nom");
		String pPrenom=request.getParameter("prenom");
		String pAdresse=request.getParameter("adresse");
		String pCp=request.getParameter("cp");
		String pVille=request.getParameter("ville");
		String pTelFixe=request.getParameter("telFixe");
		String pTelPort=request.getParameter("telPort");
		String pFax=request.getParameter("fax");
		String pEmail=request.getParameter("email");
		String pDateNaiss=request.getParameter("dateNaiss");
		String pLieu=request.getParameter("lieu");
		String pNumSecu=request.getParameter("numSecu");
		String pNat=request.getParameter("nat");
		String pSitActuelle=request.getParameter(""); // cf. ForCalLisDer.html de Jérémy
		String pFctnOccupee=request.getParameter("fctnOccupee");
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		
		
		//2. Stockage des données du formulaire -> à mettre dans le init?
		ListPersonne lst = new ListPersonne();
		Personne personne1 = new Personne(pNom, pPrenom); // faire constructeur avc ts les champs dans Utilisateurs.java
		//ou
		personne1.setNom(pNom);
		personne1.setPrenom(pNom);
		//etc.
		
		//lst.add(user1);
		
		//3. Renvoi données pour remplir nouveau formulaire
		// réception de l'id user i
		// récupération des données
		//rPrenom=p.getPrenom(useri);
		// remplissage du formulaire 2
		//response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
