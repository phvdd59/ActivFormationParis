package com.formation.beba.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/ServletBeba1")
public class Servletbeba1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletbeba1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String pseudo = request.getParameter("nom");
		response.getWriter().append("<div><html><body> <img src=\"http://www.quartierdudigital.fr/wp-content/uploads/2016/01/giphy-1.gif\"> ");
		response.getWriter().append("<iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/wZZ7oFKsKzY?rel=0&autoplay=1\" frameborder=\"0\" allowfullscreen></iframe></div>");
		response.getWriter().append("<input type='text' id='identifiant' name='nom' value='" + pseudo + "' >");
		;
		response.getWriter().append("</body></html>");

	}

}
