package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.Personne;
import com.formation.ajee.metier.SEXE;
import com.formation.ajee.metier.SITUATION;
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("//Servletidentification");
		rd.forward(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
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
		String pPrenomV=verif.nomVerif(pPrenom);
		personne.setPrenom(pPrenomV);
		
		String pSexe=request.getParameter("sexe");
		int pSexeV = verif.sexeVerif(pSexe);
		personne.setSexe(pSexeV);
		
		String pAdresse=request.getParameter("adresse");
		String pAdresseV = verif.adresseVerif(pAdresse);
		personne.setAdresse(pAdresseV);
		
		String pCp=request.getParameter("cp");
		String pCpV = verif.cpVerif(pCp);
		personne.setCp(pCpV);
		
		String pVille=request.getParameter("ville");
		String pVilleV = verif.villeVerif(pVille);
		personne.setVille(pVilleV);
		
		String pTelFixe=request.getParameter("telFixe");
		String pTelFixeV =verif.telFixVerif(pTelFixe);
		personne.setTelFixe(pTelFixeV);
		
		String pTelPort=request.getParameter("telPort");
		String pTelPortV = verif.telPortVerif(pTelPort);
		personne.setTelPort(pTelPortV);
		
		String pFax=request.getParameter("fax");
		String pFaxV = verif.faxVerif(pFax);
		personne.setFax(pFaxV);
		
		String pEmail=request.getParameter("email");
		String pEmailV = verif.emailVerif(pEmail);
		personne.setEmail(pEmailV);
		
		//
		String pDateNaissance=request.getParameter("dateNaissance");
		Date pDateNaissanceV = verif.dateNaissanceVerif(pDateNaissance);
		personne.setDateNaissance(pDateNaissanceV);
		
		String pLieuNaissance=request.getParameter("lieuNaissance");
		String pLieuNaissanceV = verif.lieuNaissanceVerif(pLieuNaissance);
		personne.setLieuNaissance(pLieuNaissanceV);
		
		String pNumSecu=request.getParameter("numSecu");
		String pNumSecuV = verif.numSecuVerif(pNumSecu);
		personne.setNumSecu(pNumSecuV);
		
		String pNationalite=request.getParameter("nationalite");
		String pNationaliteV = verif.nationaliteVerif(pNationalite);
		personne.setNationalite(pNationaliteV);
		
		String pSituation=request.getParameter("situation");
		String champsAutre=request.getParameter("autre");
		String pSituationV = verif.situationVerif(pSituation,champsAutre);
		personne.setSituation(pSituationV);
		
		String pFonction=request.getParameter("fonction");
		String pFonctionV = verif.fonctionVerif(pFonction);
		personne.setFonction(pFonctionV);
		
		String pPositionEntreprise=request.getParameter("positionEntreprise");
		String pPositionEntrepriseV = verif.nomVerif(pPositionEntreprise); // nomVerif car pas de méthode "positionEntrepriseVerif" dans "VerifForm.java"
		personne.setPositionEntreprise(pPositionEntrepriseV);
		
		String pCoeff=request.getParameter("coeff");
		String pCoeffV = verif.coeffVerif(pCoeff);
		personne.setCoeff(pCoeffV);
		
		String pSalaire=request.getParameter("salaire");
		String pSalaireV = verif.salaireVerif(pSalaire);
		personne.setSalaire(pSalaireV);
		
		String pMutuelle=request.getParameter("mutuelle");
		boolean pMutuelleV = verif.mutuelleVerif(pMutuelle);
		personne.setMutuelle(pMutuelleV);
		
		String pTicketResto=request.getParameter("ticketResto");
		boolean pTicketRestoV = verif.ticketRestoVerif(pTicketResto);
		personne.setTicketResto(pTicketRestoV);
		
		String pVisiteMedicale=request.getParameter("visiteMedicale");
		Date pVisiteMedicaleV = verif.visiteMedicaleVerif(pVisiteMedicale);
		personne.setVisiteMedicale(pVisiteMedicaleV);
		
		String pMontantTransport=request.getParameter("montantTransport");
		String pMontantTransportV = verif.montantTransportVerif(pMontantTransport);
		personne.setMontantTransport(pMontantTransportV);
		
		String pVoiture=request.getParameter("voiture");
		boolean pVoitureV = verif.voitureVerif(pVoiture);
		personne.setVoiture(pVoitureV);
		
		String pNbCV=request.getParameter("nbCV");
		int pNbCVV = verif.nbCVVerif(pNbCV);
		personne.setNbCV(pNbCVV);
		
		String pNbKm=request.getParameter("nbKm");
		String pNbKmV = verif.nbKm(pNbKm);
		personne.setNbKm(pNbKmV);
		
		// creation identifiant + mdp
		personne.setIdentifiant(personne.creationId(pNom, pPrenom));
		personne.setMdp(personne.creationMdp());
		
		// ajout à la bdd
		int idPersonne = personne.getIdPersonne();
		personne.ajoutPersonne(idPersonne);
		
		//ajout personne à la liste
//		lst.add(personne);
//		response.getWriter().println(lst.get(0).toString());
		
		
		// retour page accueil en bas de page (bouton)
//		String html = "<form action='http://127.0.0.1:8080/ProjectAJEE/Servletidentification'>";
//		response.getWriter().println(html);
		
		// print : formulaire bien enregistré
				//response.getWriter().println("Merci "+personne.getPrenom()+" "+personne.getNom()+".");
				//response.getWriter().println(pNomV);
//				response.getWriter().println("Merci "+pPrenomV+" "+pNomV+".");
//				response.getWriter().println("Votre formulaire a bien ete enregistre.");
		
//		String html2 = "<input type='submit' value='Retour page identification'></form>";
//		response.getWriter().println(html2);
		
		
		/** Lecture FormulaireEnregistre */
		File fileForm = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/FormulaireEnregistre.html");
		BufferedReader bufReadForm = null;
		bufReadForm = new BufferedReader(new FileReader(fileForm));
		String lineForm = bufReadForm.readLine();
		while (lineForm != null) {
			if (lineForm.contains("%%Merci%%")) {
				lineForm=lineForm.replace("%%Merci%%","Merci "+personne.getPrenom()+" "+personne.getNom()+".");
			}
			
			response.getWriter().println(lineForm);
			lineForm = bufReadForm.readLine();
		}
		bufReadForm.close();
		
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
