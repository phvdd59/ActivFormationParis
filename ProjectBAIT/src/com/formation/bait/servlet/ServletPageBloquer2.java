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
import com.formation.bait.metier.FonctionsCommune;
import com.formation.bait.metier.Personne;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletPageBloquer2", name = "ServletPageBloquer2")
public class ServletPageBloquer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPageBloquer2() {
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
		HttpSession session = request.getSession(false);

		Personne personne = new Personne();
		FonctionsCommune fonctions = new FonctionsCommune();

		Object oNoSuivi = session.getAttribute("suivi");
		if (session != null && oNoSuivi != null) {
			
			personne = (Personne) session.getAttribute("Personne");
			// System.out.println("Personne : " +personne.getIdPersonne());
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
			Personne candidat=new Personne();
			candidat = (Personne) session.getAttribute("candidat");
			candidat.setBloque(true);
			candidat.setRaisonBlocage(request.getParameter("raison"));
			AccesBDDPersonne bloq = new AccesBDDPersonne();
			bloq.savePersonne(candidat);
			RequestDispatcher rd = request.getRequestDispatcher("//ServletListeCandidatsAdmin");
			rd.forward(request, response);
			
			
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletPageLogin3");
			rd.forward(request, response);
		}
	}

}