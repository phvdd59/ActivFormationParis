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
		File file = new File("C:/DevFormation/" + //
				"GITActivFormationParis/ProjectJMST/" + //
				"WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part1_ident_mdp.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String line = bIn.readLine();
		while (line != null) {
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
		String pseudo = request.getParameter("identifiant");
		String mdp = request.getParameter("mdp");
		//if (pseudo != null) {
		File file = new File("C:/DevFormation/GITActivFormationParis/" + //
				"ProjectJMST/WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part2_coordonnees_personnelles.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String line = bIn.readLine();
		while (line != null) {
		
			//				if (line.contains("identifiant")) {
			//					line = line.replace("value=''", "value=''" + pseudo);
			//				}
			//				if (line.contains("mdp")) {
			//					line = line.replace("value=''", "value=''" + mdp);
			//				}
			response.getWriter().println(line);
			line = bIn.readLine();
		}
		bIn.close();
		//}
	}
}
