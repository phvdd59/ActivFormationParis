package com.formation.ajee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletVDD
 */
@WebServlet("/ServletVDD2")
public class ServletVDD2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVDD2() {
		super();
		// TODO Auto-generated constructor stub
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
			session.setAttribute("servlet", "VDD2");
			session.setAttribute("methode", "POST");
			int noSuivi = ((Integer) oNoSuivi).intValue();
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<form id=\"formVDD\" name=\"formVDD\" action=\"http://192.168.33.143:8080/ProjectAJEE/ServletVDD2\" method=\"POST\">");
			out.println("<p>PAGE 1 constitu�e par la servlet" + session.getAttribute("servlet") + " en methode " + session.getAttribute("methode") + " </p>");
			out.println("<p>Num�ro de session : " + session.getId() + "</p>");
			out.println("<p>Num�ro de suivi : " + noSuivi + "</p>");
			out.println("<p>Nb d'appel      : " + nbAppel + "</p>");
			out.println("	<input type='hidden' name='suiviClient' value='" + noSuivi + "'>");
			out.println("	<input type='hidden' name='nbAppelClient' value='" + nbAppel + "'>");
			out.println("	<input type=\"submit\" value=\"VERS VDD2 POST\">");
			out.println("</form>");
			out.println("</body></html>");
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletVDD1");
			rd.forward(request, response);
		}
	}

}