package com.formation.made;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.ListPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletMadeBlocage
 */
@WebServlet("/ServletMadeBlocage")
public class ServletMadeBlocage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMadeBlocage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String personneBloquee = request.getParameter("personneBloquee");
		String noSerieSession = (String) session.getAttribute("noSerie");
		System.out.println("nosession" +noSerieSession);
		String noSerie = request.getParameter("noSerie");
		System.out.println("no"+noSerie);
		System.out.println("personne bloquee" + personneBloquee);
		if (noSerieSession == null || noSerie == null || noSerieSession.equals(noSerie)) {
			DAOPersonne dao = new DAOPersonne();
			ListPersonne listePersonne = dao.read("personne");
			for (Personne personne : listePersonne) {
				System.out.println("le nom de la personne est " + personne.getNom());
				System.out.println();
				if (personne.getIdentifiant().equals(personneBloquee)) {
					if (personne.isBloque() == false) {
						System.out.println("la personne est débloquée pour l'instant");
						personne.setBloque(true);
						personne.setRaisonBlocage(request.getParameter("raisonBlocage"));
						dao.update(personne,"personne");
						System.out.println("la personne a été bloquée");
					}

				}

			}
//			response.sendRedirect("/jsp/testjspsuppression.jsp");
			System.out.println("je forward");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/testjspsuppression.jsp");
			dispatcher.forward(request, response);
		}else{
		System.out.println("je redirige");
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/ServletJOCA1");
		dispatcher1.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
