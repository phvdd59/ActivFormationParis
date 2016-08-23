package com.formation.ajee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletDocuments
 */
@WebServlet(value = "/MesDocuments", name = "Servletdocument")
public class Servletdocuments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** @see HttpServlet#HttpServlet() */
	public Servletdocuments() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noSerie = request.getParameter("noSerie");
		HttpSession session = request.getSession();
		Object oRecupNoSerie = session.getAttribute("noSerie");
		String recupNoSerie = (String) oRecupNoSerie;
		if (noSerie.equals(recupNoSerie)) {
			if (noSerie != null && !noSerie.equals("%%noSerie%%")) {
				File file = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/Documents.html");
				BufferedReader bufRead = null;
				bufRead = new BufferedReader(new FileReader(file));
				String line = bufRead.readLine();
				while (line != null) {
					response.getWriter().println(line);
					line = bufRead.readLine();
				}
				bufRead.close();
			}
		}
	}
}
