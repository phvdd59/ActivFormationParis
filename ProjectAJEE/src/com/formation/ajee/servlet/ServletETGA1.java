package com.formation.ajee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletETGA
 */
@WebServlet(value = "/ServletETGA1", name = "ServletETGA1")
public class ServletETGA1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletETGA1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int noSuivi = (int) (Math.random() * 1000);
		session.setAttribute("suivi", Integer.valueOf(noSuivi));
		session.setAttribute("nbAppel", new Integer(0));
		session.setAttribute("servlet", "ETGA1");
		session.setAttribute("methode", "GET");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form id=\"formETGA\" name=\"formETGA\" action=\"http://192.168.33.150:8080/ProjectAJEE/ServletETGA1\" method=\"POST\">");
		out.println("<p>PAGE 1 constituée par la servlet" + session.getAttribute("servlet") + " en methode " + session.getAttribute("methode") + " </p>");
		out.println("<p>Numéro de session : " + session.getId() + "</p>");
		out.println("<p>Numéro de suivi : " + noSuivi + "</p>");
		out.println("<p>Nb d'appel      : " + "0" + "</p>");
		out.println("	<input type='hidden' name='suiviClient' value='" + noSuivi + "'>");
		out.println("	<input type='hidden' name='nbAppelClient' value='" + "0" + "'>");
		out.println("	<input type=\"submit\" value=\"VERS ETGA1 POST\">");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "ETGA1");
			session.setAttribute("methode", "POST");
			int noSuivi = ((Integer) oNoSuivi).intValue();
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<form id=\"formETGA\" name=\"formETGA\" action=\"http://192.168.33.150:8080/ProjectAJEE/ServletETGA2\" method=\"POST\">");
			out.println("<p>PAGE 1 constituée par la servlet" + session.getAttribute("servlet") + " en methode " + session.getAttribute("methode") + " </p>");
			out.println("<p>Numéro de session : " + session.getId() + "</p>");
			out.println("<p>Numéro de suivi : " + noSuivi + "</p>");
			out.println("<p>Nb d'appel      : " + nbAppel + "</p>");
			out.println("	<input type='hidden' name='suiviClient' value='" + noSuivi + "'>");
			out.println("	<input type='hidden' name='nbAppelClient' value='" + nbAppel + "'>");
			out.println("	<input type=\"submit\" value=\"VERS ETGA2 POST\">");
			out.println("</form>");
			out.println("</body></html>");
		} else {
			session.invalidate();
			doGet(request, response);
		}
	}
}
