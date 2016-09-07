package com.formation.phva.servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.formation.beans.InterPersoService;
import com.formation.phva.metier.ListePersonne;
import com.formation.phva.metier.Personne;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet(name = "ServletPersonne", value = "/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ListePersonne lstPersonne;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPersonne() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		lstPersonne = new ListePersonne();
		Personne personn1 = new Personne("Cresson", "Thomas", false);
		lstPersonne.add(personn1);
		System.out.println(lstPersonne.size() + " " + personn1.getNom());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération donnée utilisateur
		String pNom = request.getParameter("Nom");
		String pPrenom = request.getParameter("Prenom");
		String pSexe = request.getParameter("Sexe");
		// Controle des données.
		String rPrenom = "erreur";
		if (pSexe != null && (pSexe.equals("Mme") || pSexe.equals("Mr"))) {
			System.out.println(pNom + " " + pPrenom + " " + pSexe);
			synchronized (lstPersonne) {
				for (int i = 0; i < lstPersonne.size(); i++) {
					Personne p = lstPersonne.get(i);
					if (p.getNom().equals(pNom)) {
						if (pSexe.equals("Mme")) {
							if (p.isSexe()) {
								// OK
								rPrenom = p.getPrenom();
							} else {
								// NOK
								rPrenom = "Erreur";
							}
						} else {
							if (!p.isSexe()) {
								// OK
								rPrenom = p.getPrenom();
							} else {
								// NOK
								rPrenom = "Erreur";
							}
						}
					}
				}
			}
			response.getWriter().println(rPrenom);
		} else {
			response.getWriter().println("Erreur");
		}
		URL wsdlURL = new URL("http://192.168.33.143:8888/ws/jax?wsdl");
		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
		Service service = Service.create(wsdlURL, qname);
		InterPersoService ps = service.getPort(InterPersoService.class);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Erreur");
	}

}
