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
		doPost(request, response);
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
		
//		File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Bandeau.html");
//		BufferedReader bufReadDoc = null;
//		bufReadDoc = new BufferedReader(new FileReader(fileDoc));
//		String lineDoc = bufReadDoc.readLine();
//		while (lineDoc != null) {
//			response.getWriter().println(lineDoc);
//			lineDoc = bufReadDoc.readLine();
//		}
//		bufReadDoc.close();
		
		Personne personne = new Personne();
		
		// Récupérer les données du formulaire et ranger dans objet personne
		//String pNom=request.getParameter("nom");
		personne.setNom(request.getParameter("nom"));
		//String pPrenom=request.getParameter("prenom");
		personne.setPrenom(request.getParameter("prenom"));
		//String pAdresse=request.getParameter("adresse");
		personne.setAdresse(request.getParameter("adresse"));
		String pCp=request.getParameter("cp");
		personne.setCp(pCp);
		String pVille=request.getParameter("ville");
		personne.setVille(pVille);
		String pTelFixe=request.getParameter("telFixe");
		personne.setTelFixe(pTelFixe);
		String pTelPort=request.getParameter("telPort");
		personne.setTelPort(pTelPort);
		String pFax=request.getParameter("fax");
		personne.setFax(pFax);
		String pEmail=request.getParameter("email");
		personne.setEmail(pEmail);
		String pDateNaissance=request.getParameter("dateNaissance");
		//personne.setDateNaissance(pDateNaissance);
		String pLieuNaissance=request.getParameter("lieuNaissance");
		personne.setPrenom(pLieuNaissance);
		String pNumSecu=request.getParameter("numSecu");
		personne.setNumSecu(pNumSecu);
		String pNationalite=request.getParameter("nationalite");
		personne.setNationalite(pNationalite);
		String pSituation=request.getParameter("situation");
		//personne.setSituation(pSituation);
		//String a = personne.getSituation();
		//System.out.println(a);
		String pFonction=request.getParameter("fonction");
		personne.setFonction(pFonction);
		String pPositionEntreprise=request.getParameter("positionEntreprise");
		personne.setPositionEntreprise(pPositionEntreprise);
		String pCoeff=request.getParameter("coeff");
		personne.setCoeff(pCoeff);
		String pSalaire=request.getParameter("salaire");
		personne.setSalaire(pSalaire);
		String pMutuelle=request.getParameter("mutuelle");
		//personne.setMutuelle(pMutuelle);
		String pTicketResto=request.getParameter("ticketResto");
		//personne.setTicketResto(pTicketResto);
		String pVisiteMedicale=request.getParameter("visiteMedicale");
		//personne.setVisiteMedicale(pVisiteMedicale);
		String pMontantTransport=request.getParameter("montantTransport");
		personne.setMontantTransport(pMontantTransport);
		String pVoiture=request.getParameter("voiture");
		//personne.setVoiture(pVoiture);
		String pNbCV=request.getParameter("nbCV");
		//personne.setNbCV(pNbCV);
		String pNbKm=request.getParameter("nbKm");
		personne.setNbKm(pNbKm);
		//String pSituation=request.getParameter(""); // cf. ForCalLisDer.html de Jérémy // edit : on a fait un enum
		//String pPrenom=request.getParameter("prenom");
		//String pPrenom=request.getParameter("prenom");
		
		//ajout personne à la liste
		lst.add(personne);
		response.getWriter().println(lst.get(0).toString());
		
		// print : formulaire bien enregistré
		response.getWriter().println("Formulaire enregistre");
		response.getWriter().println(personne.getNom());
		response.getWriter().println(personne.getTelPort());
		// retour page accueil en bas de page (bouton)
		String html = "<html><form action='http://127.0.0.1:8080/ProjectAJEE/Servletidentification'><input type='submit' value='Retour page identification'></form></html>";
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
