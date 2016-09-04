package com.formation.thcr.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.joca.controleur.CtrlPersonne;
import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletUpdate
 */
@WebServlet("/ServletUpdate")
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object o = session.getAttribute("Personne");

		Personne personne = null;
		if (o instanceof Personne) {
			personne = (Personne) o;
		}

		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");
		
		String sCadre = request.getParameter("Cadre");
		String sFonction = request.getParameter("fonction");
		String sPosition = request.getParameter("position");
		String sCoefficient = request.getParameter("coefficient");
		String sSalaire = request.getParameter("salaire souhaite");
		String sMutuelle = request.getParameter("mutuelle");
		String sTicketResto = request.getParameter("ticket resto");
		String sVisiteMedicale = request.getParameter("date visite medicale");
		String sTransport = request.getParameter("carte de transport");
		String sVehicule = request.getParameter("vehicule perso");
		String sNbCv = request.getParameter("nb de CV");
		String sKmEstime = request.getParameter("km mensuel");

		CtrlPersonne ctrl = new CtrlPersonne();
		DAOPersonne dao = new DAOPersonne();
		ConversionPersonne conv = new ConversionPersonne();

//		if (ctrl.ctrlCadre(sCadre) && ctrl.ctrlFonction(sFonction) && ctrl.ctrlPosition(sPosition) && ctrl.ctrlCoeff(sCoefficient)
//				&& ctrl.ctrlSalaire(sSalaire) && ctrl.ctrlMutuelle(sMutuelle) && ctrl.ctrlTicketResto(sTicketResto)
//				&& ctrl.ctrlVisiteMedicale(sVisiteMedicale) && ctrl.ctrlMontantTransport(sTransport) && ctrl.ctrlVoiture(sVehicule)
//				&& ctrl.ctrlNbCV(sNbCv) && ctrl.ctrlNbKm(sKmEstime)) {
			personne.setCadre(conv.conversionBoolean(sCadre));
			personne.setFonction(sFonction);
			personne.setCoeff(sCoefficient);
			personne.setSalaire(sSalaire);
			personne.setMutuelle(conv.conversionBoolean(sMutuelle));
			personne.setTicketResto(conv.conversionBoolean(sTicketResto));
			personne.setVisiteMedicale(conv.conversionDate(sVisiteMedicale));
			personne.setMontantTransport(sTransport);
			personne.setVoiture(conv.conversionBoolean(sVehicule));
			personne.setNbCV(Integer.valueOf(sNbCv).intValue());
			personne.setNbKm(sKmEstime);
			
			java.util.Date dateModificationUtil = new java.util.Date();
			Timestamp dateModification = new Timestamp(dateModificationUtil.getTime());
			personne.setDateModification(dateModification);
			dao.update(personne);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Servletmadeversmenu");
			rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
