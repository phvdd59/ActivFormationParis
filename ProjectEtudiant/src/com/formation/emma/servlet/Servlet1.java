package com.formation.emma.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer les parametres
		String pseudo = request.getParameter("nom");
		// controler les parametres
		if (pseudo.contains("philippe")){
			pseudo=pseudo+"plus";
		}
		// constituer la nouvelle page
				
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Coucou! ");
		response.getWriter().println("<form><input type='text' value='" + VALEUR + "'></form>");
		VALEUR++;
	}

}
