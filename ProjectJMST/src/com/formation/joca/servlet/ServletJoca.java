package com.formation.joca.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.beans.ConversionPersoToPersonne;
import com.formation.beans.Perso;
import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.ListPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletJoca
 */
@WebServlet("/ServletJoca")
public class ServletJoca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJoca() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//		String sAdresse = (String) session.getAttribute("adresse");
		//		String lien = null;
		//		if (sAdresse.equals("JMST")) {
		//			lien = "localhost";
		//		} else if (sAdresse.equals("BAIT")) {
		//			lien = "192.168.33.144";
		//		} else if (sAdresse.equals("AJEE")) {
		//			lien = "192.168.33.141";
		//		}
		//		URL wsdlURL = new URL("http://" + lien + ":8888/ws/jax?wsdl");
		//		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
		//		Service service = Service.create(wsdlURL, qname);
		//		InterPersoService ps = service.getPort(InterPersoService.class);
		Perso[] tabPerso = (Perso[]) session.getAttribute("tabPerso");

		ConversionPersoToPersonne conversion = new ConversionPersoToPersonne();
		DAOPersonne dao = new DAOPersonne();

		ListPersonne listp = dao.read("personneWS");

		for (int i = 0; i < tabPerso.length; i++) {
			Personne personne = conversion.conv(tabPerso[i]);
			for (Personne perso : listp) {
				if (!perso.getIdentifiant().equals(personne.getIdentifiant())) {
					dao.create(personne, "personneWS");
				}
			}

		}
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
