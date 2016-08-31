package com.formation.joca.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.ListeDoc;
import com.formation.thcr.metier.Personne;

import controleur.CtrlPersonne;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object personne = session.getAttribute("Personne");
		Personne perso = null;

		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}

		/***************************
		 * RECUP DONNEE FORMULAIRE
		 */
		String sFonctionOccupe = request.getParameter("fonction occupee");
		String sCadre = request.getParameter("cadre");
		String sPosition = request.getParameter("position");
		String sCoefficient = request.getParameter("coefficient");
		String sSalaire = request.getParameter("salaire");
		String sMutuelle = request.getParameter("mutuelle");
		String sTicketResto = request.getParameter("ticketResto");
		String sDateVisiteMedicale = request.getParameter("dateVisiteMedicale");
		String sMontantTransport = request.getParameter("montantTransport");
		String sVehicule = request.getParameter("vehicule");
		String nbCv = request.getParameter("nbCv");
		String nbKm = request.getParameter("nbKm");

		/***************************
		 * CONTROLE ET CONVERSION
		 */
		CtrlPersonne ctrl = new CtrlPersonne();
		//if (ctrl.ctrlSituation(situationPro)){
		ConversionPersonne conv = new ConversionPersonne();
		perso.setFonction(sFonctionOccupe);
		perso.setCadre(conv.conversionBoolean(sCadre));
		perso.setPosition(sPosition);
		perso.setCoeff(sCoefficient);
		perso.setSalaire(sSalaire);
		perso.setMutuelle(conv.conversionBoolean(sMutuelle));
		perso.setTicketResto(conv.conversionBoolean(sTicketResto));
		perso.setVisiteMedicale(conv.conversionDate(sDateVisiteMedicale));
		perso.setMontantTransport(sMontantTransport);
		perso.setVoiture(conv.conversionBoolean(sVehicule));
		if(nbCv == null || nbCv.equals("")){
			nbCv = "0";
		}
		perso.setNbCV(Integer.valueOf(nbCv));
		perso.setNbKm(nbKm);
		java.util.Date dateCreationUtil = new java.util.Date();
		Date dateCreation = new Date(dateCreationUtil.getTime());
		perso.setDateCreation(dateCreation);
		Timestamp dateModification = new Timestamp(dateCreationUtil.getTime());
		perso.setDateModification(dateModification);
		perso.setRaisonBlocage("");
		perso.setAdmin(false);
		perso.setBloque(false);
		perso.setListeDoc(new ListeDoc());
		DAOPersonne dao = new DAOPersonne();
		dao.create(perso);

		//}
		//}

		//FORWARD TO Deconnexion (login)
		ServletContext context = getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/ServletDeco");
		requestDispatcher.forward(request, response);

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
