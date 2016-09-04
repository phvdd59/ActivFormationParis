package com.formation.bait.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;
import com.formation.bait.metier.SITUATION;

/**
 * Servlet implementation class ServletSauvegarde
 */
@WebServlet(value = "/ServletBDD", name = "ServletBDD")
public class ServletBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletBDD() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		AccesBDDPersonne bddPersonne = new AccesBDDPersonne();
		Personne personne = new Personne();
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			String origine = (String) session.getAttribute("servlet");
			if (origine == "login") {
				session.setAttribute("idPersonne", "28");
				personne = bddPersonne.getPersonne(session.getAttribute("idPersonne").toString());
				session.setAttribute("Personne", personne);

			} else if (origine == "situation") {
				 personne = (Personne) session.getAttribute("Personne");
			//	personne = bddPersonne.getPersonne("28");
				String sSituation = request.getParameter("sit");
				String sAutre = request.getParameter("aut");
				if (sSituation.equals("salarie")){
					personne.setSituation(SITUATION.SALARIE);
				} else if (sSituation.equals("demandeur")) {
					personne.setSituation(SITUATION.DEMANDEUR);
				}
				 else if (sSituation.equals("freelance")) {
						personne.setSituation(SITUATION.FREELANCE);
					}
				 else if (sSituation.equals("retraite")) {
						personne.setSituation(SITUATION.RETRAITE);
					}
				 else{
					 personne.setSituation(sAutre);
				 }
				personne.setSituation(sSituation);
				bddPersonne.savePersonne(personne);
			} else if (origine == "EtatCivil") {
				 personne = (Personne) session.getAttribute("Personne");
				personne = bddPersonne.getPersonne("28");
				String sNom = request.getParameter("nom");
				String sPrenom = request.getParameter("prenom");
				String sDateNaiss = request.getParameter("datenaiss");
				String sNati = request.getParameter("nati");
				String sLieuNaiss = request.getParameter("lieunaiss");
				String sSecu = request.getParameter("secu");
				personne.setNom(sNom);
				personne.setPrenom(sPrenom);
				personne.setDateNaissance(sDateNaiss);
				personne.setLieuNaissance(sLieuNaiss);
				personne.setNationalite(sNati);
				personne.setNumSecu(sSecu);
				bddPersonne.savePersonne(personne);
			} else if (origine == "Coordonees") {
				 personne = (Personne) session.getAttribute("Personne");
				personne = bddPersonne.getPersonne("28");
				String sAdresse = request.getParameter("adresse");
				String sCp = request.getParameter("cp");
				String sVille = request.getParameter("ville");
				String sTelFixe = request.getParameter("telfixe");
				String sTelPort = request.getParameter("telport");
				String sFax = request.getParameter("fax");
				String sEmail = request.getParameter("email");
				personne.setAdresse(sAdresse);
				personne.setcP(sCp);
				personne.setVille(sVille);
				personne.setTelFixe(sTelFixe);
				personne.setTelPort(sTelPort);
				personne.setFax(sFax);
				personne.setEmail(sEmail);
				bddPersonne.savePersonne(personne);

			} else if (origine == "Remuneration") {
				 personne = (Personne) session.getAttribute("Personne");
				personne = bddPersonne.getPersonne("28");
				String sFonction = request.getParameter("fonction");
				String sCadre = request.getParameter("cadre");
				String sPosition = request.getParameter("position");
				String sCoeff = request.getParameter("Coefficient");
				String sSalaire = request.getParameter("salaire");
				String sTicket = request.getParameter("resto");
				personne.setFonction(sFonction);
				personne.setPosition(sPosition);
				personne.setCoeff(sCoeff);
				personne.setSalaire(sSalaire);
				if (sCadre.equals("Cadre")){
					personne.setCadre(true);
				}else{
					personne.setCadre(false);
				}
				if (sTicket.equals("oui")){
					personne.setTicket(true);
				} else{
					personne.setTicket(false);
				}
				bddPersonne.savePersonne(personne);
			}
			session.setAttribute("servlet", "Compte");
			session.setAttribute("methode", "POST");
			RequestDispatcher rd = request.getRequestDispatcher("/ServletPageCompte2");
			rd.forward(request, response);
		}
	}
}
