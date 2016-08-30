package com.formation.soka.servlet;

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
 * Servlet implementation class ServletIdentMdp
 */
@WebServlet("/ServletSoka1")
public class ServletSoka1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSoka1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		File file = new File("C:/DevFormation/" + //
				"GITActivFormationParis/ProjectJMST/" + //
				"WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part2_coordonnees_personnelles.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
		noSerie = "20_" + noSerie;
		session.setAttribute("noSerie", noSerie);
		String line = bIn.readLine();
		while (line != null) {
			if (line.contains("%%noSerie%%")) {
				line.replace("%%noSerie%%", noSerie);
			}
			response.getWriter().println(line);
			line = bIn.readLine();
		}
		bIn.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String pseudo = request.getParameter("identifiant");
//		String mdp = request.getParameter("mdp");
		HttpSession session = request.getSession(); 
		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/jsp/Part2.jsp");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
		noSerie = "21_" + noSerie;
		session.setAttribute("noSerie", noSerie);
		String line = bIn.readLine();
		while (line != null) {
			if (line.contains("%%noSerie%%")) {
				line.replace("%%noSerie%%", noSerie);
			}
			response.getWriter().println(line);
			line = bIn.readLine();
			}
		bIn.close();
		
	}
}
