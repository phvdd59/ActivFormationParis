package com.formation.bait.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
		boolean retour = true;
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			String origine = (String) session.getAttribute("servlet");
			if (origine == "Login") {
				personne = bddPersonne.getPersonne(session.getAttribute("idPersonne").toString());
			} else if (origine == "Situation") {
				personne = (Personne) session.getAttribute("Personne");
				String sSituation = request.getParameter("sit");
				String sAutre = request.getParameter("aut");
				if (sSituation.equals("salarie")) {
					personne.setSituation(SITUATION.SALARIE);
				} else if (sSituation.equals("demandeur")) {
					personne.setSituation(SITUATION.DEMANDEUR);
				} else if (sSituation.equals("freelance")) {
					personne.setSituation(SITUATION.FREELANCE);
				} else if (sSituation.equals("retraite")) {
					personne.setSituation(SITUATION.RETRAITE);
				} else {
					personne.setSituation(sAutre);
				}
				retour = bddPersonne.savePersonne(personne);
			} else if (origine == "EtatCivil") {
				personne = (Personne) session.getAttribute("Personne");
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
				retour = bddPersonne.savePersonne(personne);
			} else if (origine == "Coordonees") {
				personne = (Personne) session.getAttribute("Personne");
				String sAdresse = request.getParameter("adresse");
				String sCp = request.getParameter("cp");
				String sVille = request.getParameter("ville");
				String sTelFixe = request.getParameter("telFixe");
				String sTelPort = request.getParameter("telPort");
				String sFax = request.getParameter("fax");
				String sEmail = request.getParameter("email");
				personne.setAdresse(sAdresse);
				personne.setcP(sCp);
				personne.setVille(sVille);
				personne.setTelFixe(sTelFixe);
				personne.setTelPort(sTelPort);
				personne.setFax(sFax);
				personne.setEmail(sEmail);
				retour = bddPersonne.savePersonne(personne);

			} else if (origine == "Remuneration") {
				personne = (Personne) session.getAttribute("Personne");
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
				if (sCadre.equals("Cadre")) {
					personne.setCadre(true);
				} else {
					personne.setCadre(false);
				}
				if (sTicket.equals("oui")) {
					personne.setTicket(true);
				} else {
					personne.setTicket(false);
				}
				retour = bddPersonne.savePersonne(personne);

			}
			if (retour == false) {
				System.out.println("erreur sauvegarde ratée!");
				RequestDispatcher rd = request.getRequestDispatcher("/ServletErreurSave");
				rd.forward(request, response);
			}

			File file2 = new File(
					"C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/Sauvegarde.html");
			BufferedReader bIn = null;
			InputStreamReader inputStreamReader = null;
			try {
				inputStreamReader = new InputStreamReader(new FileInputStream(file2), "UTF-8");
				bIn = new BufferedReader(inputStreamReader);
				String line = bIn.readLine();
				while (line != null) {

					response.getWriter().append(line + "\n");
					line = bIn.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
			rd.forward(request, response);
		}

		// session.setAttribute("Personne", personne);
		// session.setAttribute("servlet", "Compte");
		// session.setAttribute("methode", "POST");
		// RequestDispatcher rd =
		// request.getRequestDispatcher("/ServletPageCompte2");
		// rd.forward(request, response);

	}
}
