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

/**
 * Servlet implementation class Servletjeci1
 */
@WebServlet("/Servletjeci1")
public class Servletaccueilchargementprofil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletaccueilchargementprofil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpSession session = request.getSession();
		// String noSerie = request.getParameter("noSerie");
		// String pseudo = request.getParameter("identifiant");
		// Object oRecupNoSerie=session.getAttribute("noSerie");
		// String recupNoSerie=(String) oRecupNoSerie;

		// Constituer la nouvelle page
		// if (pseudo != null && noSerie != null &&
		// !noSerie.equals("%%noserie%%")) {
		// if (pseudo.equals("Philippe")) {
		
		File f2 = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectAJEE/" + "WebContent/WEB-INF/com/formation/ajee/" + "page/Background.html");
		BufferedReader bIn2 = new BufferedReader(new FileReader(f2));
		String l2 = bIn2.readLine();
		while (l2 != null) {
			response.getWriter().println(l2);
			l2 = bIn2.readLine();
		}
		bIn2.close();
		File f1 = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectAJEE/" + "WebContent/WEB-INF/com/formation/ajee/" + "page/bandeauAdmin.html");
		BufferedReader bIn1 = new BufferedReader(new FileReader(f1));
		String l1 = bIn1.readLine();
		while (l1 != null) {
			response.getWriter().println(l1);
			l1 = bIn1.readLine();
		}
		bIn1.close();
		File f = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectAJEE/" + "WebContent/WEB-INF/com/formation/ajee/" + "page/AccueilAdmin.html");
		BufferedReader bIn = new BufferedReader(new FileReader(f));
		String l = bIn.readLine();
		while (l != null) {
			response.getWriter().println(l);
			l = bIn.readLine();
		}
		bIn.close();

	}
}