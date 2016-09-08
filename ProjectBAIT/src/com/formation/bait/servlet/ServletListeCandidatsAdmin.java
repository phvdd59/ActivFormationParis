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
import com.formation.bait.metier.FonctionsCommune;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletListeCandidatsAdmin", name = "ServletListeCandidatsAdmin")
public class ServletListeCandidatsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeCandidatsAdmin() {
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
		FonctionsCommune fct = new FonctionsCommune();
		HttpSession session = request.getSession();
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "ListeCandidats");
			session.setAttribute("methode", "POST");
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
			fct.AfficherHautDePage(response);

			AccesBDDPersonne acces = new AccesBDDPersonne();
			acces.afficherListeCandidats(response);

			response.getWriter().append(
					"<div style=\"margin-top:30px; margin-left:80px;\"> <form method=\"post\" action=\"http://"+FonctionsCommune.HOST+":8080/ProjectBAIT/ServletListeCandidatsAdmin2Empruntee\"> <input type=\"submit\" name=\"BDD\" value=\"BDDAJEE\"> </form> </div>");
			response.getWriter().append(
					"<div style=\"margin-top:30px; margin-left:80px;\"> <form method=\"post\" action=\"http://"+FonctionsCommune.HOST+":8080/ProjectBAIT/ServletListeCandidatsAdmin2Empruntee\"> <input type=\"submit\" name=\"BDD\" value=\"BDDJMST\"> </form> </div>");
			response.getWriter().append(
					"<div style=\"margin-top:30px; margin-left:80px;\"> <form method=\"post\" action=\"http://"+FonctionsCommune.HOST+":8080/ProjectBAIT/ServletDeconnection\"> <input type=\"submit\" name=\"disconnect\" value=\"Deconnexion\"> </form> </div>");

			fct.AfficherBasDePage(response);
		}else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
			rd.forward(request, response);
		}
	}

}