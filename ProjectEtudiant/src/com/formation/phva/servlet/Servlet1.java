package com.formation.phva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/serv/ServletPhva")
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
		// récupérer les paramètres.
		String pseudo = request.getParameter("nom");
		// Contrôler les params
		if (pseudo.contains("Philippe")) {
			pseudo = pseudo + "PLUS";
		}
		//Constituer la nouvelle page 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println("<html><body><h1>ACTIV-CONSULTING</h1>");
		response.getWriter().println("<form>" + "<input type='text' value='" + VALEUR + "'>");
		response.getWriter().println("<input name='question' type='text' " + "value='" + pseudo + "'>");
		response.getWriter().println("<input name='submit' type='submit' " + "value='OK'>");
		if (pseudo.contains("Philippe")) {
			response.getWriter().println("<p style='color:red'>" + pseudo + "</p>");
		} else {
			response.getWriter().println("<p style='color:blue'>" + pseudo + "</p>");
		}
		VALEUR++;
		response.getWriter().println("</form></body></html>");
	}

}
