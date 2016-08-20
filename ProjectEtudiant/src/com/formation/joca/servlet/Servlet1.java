package com.formation.joca.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet utilisé pour générer la page login par la methode doPost
/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletJOCA", name = "ServletJOCA")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recuperer les parametres
		// String pseudo = request.getParameter("nom");

		// controler les parametres

		// generer la page html
		response.getWriter().println("HOI !");

	}

}
