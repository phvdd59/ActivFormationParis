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
import com.formation.ajee.metier.SEXE;
import com.formation.ajee.veriffom.VerifForm;

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
		
		Personne personne = new Personne(); // à ce moment y'a création de l'idpersonne
		VerifForm verif = new VerifForm();
		
		// Récupérer les données du formulaire, vérifier, et ranger dans objet personne
		String pNom=request.getParameter("nom");
		String pNomV=verif.nomVerif(pNom);
		personne.setNom(pNomV);
		
		String pPrenom=request.getParameter("prenom");
		String pPrenomV=verif.prenomVerif(pPrenom);
		personne.setPrenom(pPrenomV);
		
		String pSexe=request.getParameter("sexe");
		SEXE pSexeV = verif.sexeVerif(pSexe);
		personne.setSexe(pSexeV);
		
		String pAdresse=request.getParameter("adresse");
		verif.adresseVerif(pAdresse);
		personne.setAdresse(pAdresse);
		
		String pCp=request.getParameter("cp");
		verif.cpVerif(pCp);
		personne.setCp(pCp);
		
		String pVille=request.getParameter("ville");
		verif.villeVerif(pVille);
		personne.setVille(pVille);
		
		String pTelFixe=request.getParameter("telFixe");
		verif.telFixVerif(pTelFixe);
		personne.setTelFixe(pTelFixe);
		
		String pTelPort=request.getParameter("telPort");
		verif.telPortVerif(pTelPort);
		personne.setTelPort(pTelPort);
		
		String pFax=request.getParameter("fax");
		verif.faxVerif(pFax);
		personne.setFax(pFax);
		
		String pEmail=request.getParameter("email");
		String pEmailV = verif.emailVerif(pEmail);
		personne.setEmail(pEmailV);
		
		String pDateNaissance=request.getParameter("dateNaissance");
		verif.dateNaissanceVerif(pDateNaissance);
		//personne.setDateNaissance(pDateNaissance);
		
		String pLieuNaissance=request.getParameter("lieuNaissance");
		verif.lieuNaissanceVerif(pLieuNaissance);
		personne.setLieuNaissance(pLieuNaissance);
		
		String pNumSecu=request.getParameter("numSecu");
		verif.numSecuVerif(pNumSecu);
		personne.setNumSecu(pNumSecu);
		
		String pNationalite=request.getParameter("nationalite");
		verif.nationaliteVerif(pNationalite);
		personne.setNationalite(pNationalite);
		
		String pSituation=request.getParameter("situation");
		verif.situationVerif(pSituation);
		//personne.setSituation(pSituation);
		//String a = personne.getSituation();
		//System.out.println(a);
		
		String pFonction=request.getParameter("fonction");
		verif.fonctionVerif(pFonction);
		personne.setFonction(pFonction);
		
		String pPositionEntreprise=request.getParameter("positionEntreprise");
		verif.nomVerif(pPositionEntreprise); // nomVerif car pas de méthode "positionEntrepriseVerif" dans "VerifForm.java"
		personne.setPositionEntreprise(pPositionEntreprise);
		
		String pCoeff=request.getParameter("coeff");
		verif.coeffVerif(pCoeff);
		personne.setCoeff(pCoeff);
		
		String pSalaire=request.getParameter("salaire");
		verif.salaireVerif(pSalaire);
		personne.setSalaire(pSalaire);
		
		String pMutuelle=request.getParameter("mutuelle");
		verif.mutuelleVerif(pMutuelle);
		//personne.setMutuelle(pMutuelle);
		
		String pTicketResto=request.getParameter("ticketResto");
		verif.ticketRestoVerif(pTicketResto);
		//personne.setTicketResto(pTicketResto);
		
		String pVisiteMedicale=request.getParameter("visiteMedicale");
		verif.visiteMedicaleVerif(pVisiteMedicale);
		//personne.setVisiteMedicale(pVisiteMedicale);
		
		String pMontantTransport=request.getParameter("montantTransport");
		verif.montantTransportVerif(pMontantTransport);
		personne.setMontantTransport(pMontantTransport);
		
		String pVoiture=request.getParameter("voiture");
		verif.voitureVerif(pVoiture);
		//personne.setVoiture(pVoiture);
		
		String pNbCV=request.getParameter("nbCV");
		verif.nbCVVerif(pNbCV);
		//personne.setNbCV(pNbCV);
		
		String pNbKm=request.getParameter("nbKm");
		verif.nbKm(pNbKm);
		personne.setNbKm(pNbKm);
		//String pSituation=request.getParameter(""); // cf. ForCalLisDer.html de Jérémy // edit : on a fait un enum
		
		// creation identifiant + mdp
		personne.setIdentifiant(personne.creationId(pNom, pPrenom));
		personne.setMdp(personne.creationMdp());
		
		// ajout à la bdd
		int idPersonne = personne.getIdPersonne();
		personne.ajoutPersonne(idPersonne);
		
		//ajout personne à la liste
//		lst.add(personne);
//		response.getWriter().println(lst.get(0).toString());
		
		// print : formulaire bien enregistré
		response.getWriter().println("Merci "+personne.getPrenom()+" "+personne.getNom()+".");
		//response.getWriter().println();
		//response.getWriter().println();
		response.getWriter().println("Votre formulaire a bien ete enregistre.");
		
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
