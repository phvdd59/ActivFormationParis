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

import com.formation.joca.controleur.CtrlPersonne;
import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.DocPerso;
import com.formation.thcr.metier.Personne;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object personne = session.getAttribute("Personne");
		Personne perso = null;

		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}

		/***************************
		 * RECUP DONNEE FORMULAIRE
		 */
		if (perso.getSalaire().equals("")) {
			String sFonctionOccupe = request.getParameter("fonctionoccupee");
			String sCadre = request.getParameter("cadre");
			String sPosition = request.getParameter("position");
			String sCoefficient = request.getParameter("coefficient");
			String sSalaire = request.getParameter("salaire");
			String sMutuelle = request.getParameter("mutuelle");
			String sTicketResto = request.getParameter("ticketResto");
			String sDateVisiteMedicale = request.getParameter("dateVisiteMedicale");
			String sMontantTransport = request.getParameter("montantTransport");
			String sVehicule = request.getParameter("vehicule");
			String sNbCv = request.getParameter("nbCv");
			String sNbKm = request.getParameter("nbKm");
			
			CtrlPersonne ctrl = new CtrlPersonne();

			/***************************
			 * CONTROLE ET CONVERSION
			 */

			ConversionPersonne conv = new ConversionPersonne();
			if (ctrl.ctrlFonction(sFonctionOccupe) && ctrl.ctrlCadre(sCadre) && ctrl.ctrlPosition(sPosition)
					&& ctrl.ctrlCoeff(sCoefficient) && ctrl.ctrlSalaire(sSalaire) && ctrl.ctrlMutuelle(sMutuelle)
					&& ctrl.ctrlTicketResto(sTicketResto) && ctrl.ctrlVisiteMedicale(sDateVisiteMedicale)
					&& ctrl.ctrlMontantTransport(sMontantTransport) && ctrl.ctrlVoiture(sVehicule)
					&& ctrl.ctrlNbCV(sNbCv) && ctrl.ctrlNbKm(sNbKm)) {
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
				if (sNbCv.equals("")) {
					perso.setNbCV(0);
				} else {
					perso.setNbCV(Integer.valueOf(sNbCv));
				}
				perso.setNbKm(sNbKm);
			}
			
				java.util.Date dateCreationUtil = new java.util.Date();
				Date dateCreation = new Date(dateCreationUtil.getTime());
				perso.setDateCreation(dateCreation);
				Timestamp dateModification = new Timestamp(dateCreationUtil.getTime());
				perso.setDateModification(dateModification);
				perso.setRaisonBlocage("pas de raison");
				perso.setAdmin(false);
				perso.setBloque(false);
				perso.setListeDoc(new DocPerso[1]);
				DAOPersonne dao = new DAOPersonne();
				dao.create(perso,"personne");
				response.getWriter().println("<script>alert(\"Compte créé\")</script>");
			
		}
		ServletContext context = getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/ServletDeco");
		requestDispatcher.forward(request, response);

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
