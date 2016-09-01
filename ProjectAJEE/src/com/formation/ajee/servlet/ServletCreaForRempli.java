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
@WebServlet(description = "Servlet Creation Formulaire Rempli", urlPatterns = { "/ServletCreaForRempli" })
// Cette servlet prend "FormulaireARemplir" (le formulaire vide) qui a été rempli par l'user, et génère "FormulaireRempli", soit le même formulaire avec les champs remplis en read-only.
public class ServletCreaForRempli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreaForRempli() {
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
		// faudra mettre une fonction "bouton modifier" qui enverra vers la servlet "ServletCreaForPreRempli.java" 
		BufferedReader bufReadJS = null;
		bufReadJS= new BufferedReader(new FileReader(fileJS));
		String lineJS= bufReadJS.readLine();
		while (lineJS != null) {
			response.getWriter().println(lineJS);
			lineJS=bufReadJS.readLine();
		}
		bufReadJS.close();
		
		// appeller le calendrier ici?
		
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
		File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/FormulaireARemplir.html");
		BufferedReader bufReadDoc1 = null;
		bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
		String lineDoc1 = bufReadDoc1.readLine();
		while (lineDoc1 != null) {
			// Récupérer les données du formulaire et ranger dans objet personne
			if (lineDoc1.contains("id='nom'")) {
				String pNom=request.getParameter("nom");
				personne.setNom(pNom);
			}
			if (lineDoc1.contains("id='prenom'")) {
				String pPrenom=request.getParameter("prenom");
				personne.setPrenom(pPrenom);
			}
			if (lineDoc1.contains("id='adresse'")) {
				String pAdresse=request.getParameter("adresse");
				personne.setPrenom(pAdresse);
			}
			// insert enum SEXE
			// no insert string identifiant
			if (lineDoc1.contains("id='cp'")) {
				String pCp=request.getParameter("cp");
				personne.setPrenom(pCp);
			}
			if (lineDoc1.contains("id='ville'")) {
				String pVille=request.getParameter("ville");
				personne.setPrenom(pVille);
			}
			if (lineDoc1.contains("id='telFixe'")) {
				String pTelFixe=request.getParameter("telFixe");
				personne.setPrenom(pTelFixe);
			}
			if (lineDoc1.contains("id='telPort'")) {
				String pTelPort=request.getParameter("telPort");
				personne.setPrenom(pTelPort);
			}
			if (lineDoc1.contains("id='fax'")) {
				String pFax=request.getParameter("fax");
				personne.setPrenom(pFax);
			}
			if (lineDoc1.contains("id='email'")) {
				String pEmail=request.getParameter("email");
				personne.setPrenom(pEmail);
			}
			if (lineDoc1.contains("id='dateNaissance'")) {
				String pDateNaissance=request.getParameter("dateNaissance");
				personne.setPrenom(pDateNaissance);
			}
			if (lineDoc1.contains("id='lieuNaissance'")) {
				String pLieuNaissance=request.getParameter("lieuNaissance");
				personne.setPrenom(pLieuNaissance);
			}
			if (lineDoc1.contains("id='numSecu'")) {
				String pNumSecu=request.getParameter("numSecu");
				personne.setPrenom(pNumSecu);
			}
			if (lineDoc1.contains("id='nationalite'")) {
				String pNationalite=request.getParameter("nationalite");
				personne.setPrenom(pNationalite);
			}
			if (lineDoc1.contains("id='fonction'")) {
				String pFonction=request.getParameter("fonction");
				personne.setPrenom(pFonction);
			}
			if (lineDoc1.contains("id='positionEntreprise'")) {
				String pPositionEntreprise=request.getParameter("positionEntreprise");
				personne.setPrenom(pPositionEntreprise);
			}
			if (lineDoc1.contains("id='coeff'")) {
				String pCoeff=request.getParameter("coeff");
				personne.setPrenom(pCoeff);
			}
			if (lineDoc1.contains("id='salaire'")) {
				String pSalaire=request.getParameter("salaire");
				personne.setPrenom(pSalaire);
			}
			if (lineDoc1.contains("id='visiteMedicale'")) {
				String pVisiteMedicale=request.getParameter("visiteMedicale");
				personne.setPrenom(pVisiteMedicale);
			}
			if (lineDoc1.contains("id='montantTransport'")) {
				String pMontantTransport=request.getParameter("montantTransport");
				personne.setPrenom(pMontantTransport);
			}
			if (lineDoc1.contains("id='voiture'")) {
				String pVoiture=request.getParameter("voiture");
				personne.setPrenom(pVoiture);
			}
			if (lineDoc1.contains("id='nbCV'")) {
				String pNbCV=request.getParameter("nbCV");
				personne.setPrenom(pNbCV);
			}
			if (lineDoc1.contains("id='nbKm'")) {
				String pNbKm=request.getParameter("nbKm");
				personne.setPrenom(pNbKm);
			}
			
			
			
			String pSituation=request.getParameter(""); // cf. ForCalLisDer.html de Jérémy // edit : on a fait un enum
			//String pPrenom=request.getParameter("prenom");
			//String pPrenom=request.getParameter("prenom");
			//
			response.getWriter().println(lineDoc1);
			lineDoc1 = bufReadDoc1.readLine();
		}
		bufReadDoc1.close();
		
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
