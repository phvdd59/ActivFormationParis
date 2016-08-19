package com.formation.jeci.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/ServletJeci")
public class Servletjeci extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletjeci() {
		super();
		// TODO Auto-generated constructor stub
	}

	// private String readRequestBody(HttpServletRequest request) {
	// try {
	// // Read from request
	// StringBuilder buffer = new StringBuilder();
	// BufferedReader reader = request.getReader();
	// String line;
	// while ((line = reader.readLine()) != null) {
	// buffer.append(line);
	// }
	// return buffer.toString();
	// } catch (Exception e) {
	// Loader.error("Failed to read the request body from the request.");
	// }
	// return null;
	// }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		try {
//			// Read from request
//			StringBuilder buffer = new StringBuilder();
//			BufferedReader reader = request.getReader();
//			String line;
//			while ((line = reader.readLine()) != null) {
//				buffer.append(line);
//				
//			}
//			
//		} catch (Exception e) {
//			
//		}
	
		// récupérer les paramètres.

		String pseudo = request.getParameter("nom");
		// Contrôler les params
		if (pseudo.contains("Philippe")) {
			pseudo = pseudo + "PLUS";
		}
		// Constituer la nouvelle page
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.getWriter().println("<html><body><h1>ACTIV-CONSULTING</h1>");
		response.getWriter().println("<form>" + "<input type='text' value='" + "'>");
		response.getWriter().println("<input name='question' type='text' " + "value='" + pseudo + "'>");
		response.getWriter().println("<input name='submit' type='submit' " + "value='OK'>");
		if (pseudo.contains("Philippe")) {
			response.getWriter().println("<p style='color:red'>" + pseudo + "</p>");
		} else {
			response.getWriter().println("<p style='color:blue'>" + pseudo + "</p>");
		}

		response.getWriter().println("</form></body></html>");
	}

}
