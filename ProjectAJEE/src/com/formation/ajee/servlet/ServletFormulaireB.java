package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
@WebServlet(description = "Servlet Creation Formulaire Rempli", urlPatterns = { "/ServletFormulaireB" })
// Cette servlet part de "FormulaireARemplir" (le formulaire vide) qui a été rempli par l'user.
public class ServletFormulaireB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ListPersonne lst = new ListPersonne();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormulaireB() {
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
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** Lecture Haut de page HTML */
		File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
		BufferedReader bufReadHaut = null;
		bufReadHaut = new BufferedReader(new FileReader(fileHaut));
		String lineHaut = bufReadHaut.readLine();
		while (lineHaut != null) {
			response.getWriter().println(lineHaut);
			lineHaut=bufReadHaut.readLine();
		}
		bufReadHaut.close();
				
		/**
		 * A modifier seulement si notre page contient du JavaScript
		 */
		
		File fileJS = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSFormulaireARemplir.html");
		BufferedReader bufReadJS = null;
		bufReadJS= new BufferedReader(new FileReader(fileJS));
		String lineJS= bufReadJS.readLine();
		while (lineJS != null) {
			response.getWriter().println(lineJS);
			lineJS=bufReadJS.readLine();
		}
		bufReadJS.close();
				
		/** Lecture page ActivConsulting */
		
		File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
		BufferedReader bufReadActiv = null;
		bufReadActiv= new BufferedReader(new FileReader(fileActiv));
		String lineActiv= bufReadActiv.readLine();
		while (lineActiv != null) {
			response.getWriter().println(lineActiv);
			lineActiv=bufReadActiv.readLine();
		}
		bufReadActiv.close();
		
		/**
		 * Seule Partie qui va vraiment changer selon les pages (penser
		 * aux controles si necessaire)
		 */
		
		File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Bandeau.html");
		BufferedReader bufReadDoc = null;
		bufReadDoc = new BufferedReader(new FileReader(fileDoc));
		String lineDoc = bufReadDoc.readLine();
		while (lineDoc != null) {
			response.getWriter().println(lineDoc);
			lineDoc = bufReadDoc.readLine();
		}
		bufReadDoc.close();
		
		// rajouter des if pour créer des objets et rajouter des attributs lorsqu'ils sont rencontrés. (Remplir les inputs du nouveau formulaire avc ces attributs. En read-only.)->non
		Personne personne = new Personne();
		
		// Récupérer les données du formulaire et ranger dans objet personne
		String pNom=request.getParameter("nom");
		personne.setNom(pNom);
		String pPrenom=request.getParameter("prenom");
		personne.setPrenom(pPrenom);
		String pAdresse=request.getParameter("adresse");
		personne.setPrenom(pAdresse);
		String pCp=request.getParameter("cp");
		personne.setPrenom(pCp);
		String pVille=request.getParameter("ville");
		personne.setPrenom(pVille);
		String pTelFixe=request.getParameter("telFixe");
		personne.setPrenom(pTelFixe);
		String pTelPort=request.getParameter("telPort");
		personne.setPrenom(pTelPort);
		String pFax=request.getParameter("fax");
		personne.setPrenom(pFax);
		String pEmail=request.getParameter("email");
		personne.setPrenom(pEmail);
		String pDateNaissance=request.getParameter("dateNaissance");
		personne.setPrenom(pDateNaissance);
		String pLieuNaissance=request.getParameter("lieuNaissance");
		personne.setPrenom(pLieuNaissance);
		String pNumSecu=request.getParameter("numSecu");
		personne.setPrenom(pNumSecu);
		String pNationalite=request.getParameter("nationalite");
		personne.setPrenom(pNationalite);
		String pSituation=request.getParameter("situation");
		personne.setPrenom(pSituation);
		String a = personne.getPrenom();
		System.out.println(a);
		String pFonction=request.getParameter("fonction");
		personne.setPrenom(pFonction);
		String pPositionEntreprise=request.getParameter("positionEntreprise");
		personne.setPrenom(pPositionEntreprise);
		String pCoeff=request.getParameter("coeff");
		personne.setPrenom(pCoeff);
		String pSalaire=request.getParameter("salaire");
		personne.setPrenom(pSalaire);
		String pVisiteMedicale=request.getParameter("visiteMedicale");
		personne.setPrenom(pVisiteMedicale);
		String pMontantTransport=request.getParameter("montantTransport");
		personne.setPrenom(pMontantTransport);
		String pVoiture=request.getParameter("voiture");
		personne.setPrenom(pVoiture);
		String pNbCV=request.getParameter("nbCV");
		personne.setPrenom(pNbCV);
		String pNbKm=request.getParameter("nbKm");
		personne.setPrenom(pNbKm);
		//String pSituation=request.getParameter(""); // cf. ForCalLisDer.html de Jérémy // edit : on a fait un enum
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		
		//ajout personne à la liste
		lst.add(personne);
		System.out.println(lst.get(0).toString());
		
		// print : formulaire bien enregistré
		response.getWriter().println("Formulaire enregistre");
		// retour page accueil en bas de page (bouton)
		String html = "<html><form action='http://127.0.0.1:8080/ProjectAJEE/Servletidentification'><input type='submit' value='Accueil'></form></html>";
		response.getWriter().println(html);
		
		
		/** Lecture bas de page */
		File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
		BufferedReader bufReadBas = null;
		bufReadBas = new BufferedReader(new FileReader(fileBas));
		String lineBas = bufReadBas.readLine();
		while (lineBas != null) {
			response.getWriter().println(lineBas);
			lineBas = bufReadBas.readLine();
		}
		bufReadBas.close();
	}

}
