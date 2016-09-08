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

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletPageExamCandidat2", name = "ServletPageExamCandidat2")
public class ServletPageExamCandidat2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPageExamCandidat2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AccesBDDPersonne bddPersonne = new AccesBDDPersonne();
		Personne personne = new Personne();

		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "Envoi");
			session.setAttribute("methode", "POST");
			personne = (Personne) session.getAttribute("Personne");
			AccesBDDPersonne acces = new AccesBDDPersonne();
			// personne2 = (Personne) session.getAttribute("Candidat");

			Personne personne2 = new Personne();
			if (request.getParameter("BDD").equals("empruntee")) {
				personne2 = (Personne) acces.getPersonneEmpruntee(request.getParameter("IDcandidat"));
				session.setAttribute("candidat", personne2);
				session.setAttribute("NomAdmin", personne.getPrenom() + " " + personne.getNom());
				this.getServletContext().getRequestDispatcher("/com/bait/jsp/VisuCandidatEmpruntee.jsp").forward(request, response);
			} else {
			personne2 = (Personne) acces.getPersonne(request.getParameter("IDcandidat"));
			session.setAttribute("candidat", personne2);
			session.setAttribute("NomAdmin", personne.getPrenom() + " " + personne.getNom());
			this.getServletContext().getRequestDispatcher("/com/bait/jsp/VisuCandidat.jsp").forward(request, response);
			}

			// getAttribute("IDcandidat").toString());
//			session.setAttribute("candidat", personne2);
//
//			session.setAttribute("NomAdmin", personne.getPrenom() + " " + personne.getNom());

			//			session.setAttribute("nomCandidat", personne2.getNom());
			//			session.setAttribute("prenomCandidat", personne2.getPrenom());
			//			session.setAttribute("emailCandidat", personne2.getEmail());
			//			session.setAttribute("adresseCandidat", personne2.getAdresse());
			//			session.setAttribute("cPCandidat", personne2.getcP());
			//			session.setAttribute("villeCandidat", personne2.getVille());
			//			session.setAttribute("telFixeCandidat", personne2.getTelFixe());
			//			session.setAttribute("telPortCandidat", personne2.getTelPort());
			//			session.setAttribute("faxCandidat", personne2.getFax());
			//			session.setAttribute("dateNaissCandidat", personne2.getDateNaissance());
			//			session.setAttribute("lieuNaissCandidat", personne2.getLieuNaissance());
			//			session.setAttribute("numSecuCandidat", personne2.getNumSecu());
			//			session.setAttribute("nationaliteCandidat", personne2.getNationalite());
			//			session.setAttribute("situationCandidat", personne2.getSituation());
			//			session.setAttribute("fonctionCandidat", personne2.getFonction());
			//			session.setAttribute("positionCandidat", personne2.getPosition());
			//			session.setAttribute("cadreCandidat", personne2.isCadre());
			//			session.setAttribute("coeffCandidat", personne2.getCoeff());
			//			session.setAttribute("salaireCandidat", personne2.getSalaire());
			//			session.setAttribute("vivisteMedicaleCandidat", personne2.getVisiteMedicale());
			//			session.setAttribute("montantTransportCandidat", personne2.getMontantTransport());
			//			session.setAttribute("voitureCandidat", personne2.isVoiture());
			//			session.setAttribute("nbCVCandidat", personne2.getNbCV());
			//			session.setAttribute("nbKmCandidat", personne2.getNdKm());
			//			session.setAttribute("mutuelleCandidat", personne2.isMutuelle());

//			this.getServletContext().getRequestDispatcher("/com/bait/jsp/grosTest.jsp").forward(request, response);

		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/grosTest.jsp");
			rd.forward(request, response);
		}
	}
}