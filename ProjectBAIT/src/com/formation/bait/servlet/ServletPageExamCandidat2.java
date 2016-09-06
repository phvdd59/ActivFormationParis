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
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		AccesBDDPersonne bddPersonne = new AccesBDDPersonne();
		Personne personne = new Personne();

		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "Envoi");
			session.setAttribute("methode", "POST");
			personne = (Personne) session.getAttribute("Personne");
			AccesBDDPersonne acces=new AccesBDDPersonne();
			Personne personne2 = (Personne) session.getAttribute("Candidat");
			
			personne2= (Personne) acces.getPersonne(request.getParameter("IDcandidat"));
//					getAttribute("IDcandidat").toString());
			session.setAttribute("candidat", personne2);
			
			session.setAttribute("NomAdmin", personne.getPrenom()+" "+personne.getNom());
			
			session.setAttribute("nomCandidat", personne2.getNom());
			session.setAttribute("prenomCandidat", personne2.getPrenom());
			session.setAttribute("emailCandidat", personne2.getEmail());
			session.setAttribute("adresseCandidat", personne2.getAdresse());
//			session.setAttribute("Candidat", personne2.get);
			
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
			
			
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/grosTest.jsp");
			rd.forward(request, response);
		}
	}
}