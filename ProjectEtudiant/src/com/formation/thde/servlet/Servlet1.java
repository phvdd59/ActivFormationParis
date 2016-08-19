package com.formation.thde.servlet;

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
		//recuperer
		String pseudo = request.getParameter("nom");
		//controler
		if (pseudo.contains("Admin")) {
			pseudo = pseudo + "PLUS";
		}
		//faire la nouvelle page
		response.getWriter().println("<html><body><form>");
		response.getWriter().println("<input type='text' value=" + pseudo + ">");
		if (pseudo.contains("Admin")) {
			response.getWriter().println("<p style='color:red';>" + pseudo + "</p>");
		} else {
			response.getWriter().println("<p style='color:blue'>" + pseudo + "</p>");
		}
		response.getWriter().println("</form></body></html>");
	}

}
