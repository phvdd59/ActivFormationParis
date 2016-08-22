package com.formation.joca.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		BufferedReader lecture = null;
		File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
		InputStreamReader input = new InputStreamReader(new FileInputStream(page));
		lecture = new BufferedReader(input);
		String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
		noSerie = "1_"+noSerie;
		session.setAttribute("noSerie", noSerie);
		String line = lecture.readLine();
		while (line != null) {
			if (line.contains("%%noSerie%%")) {
				line.replace("%%noSerie%%", noSerie);
			}
			response.getWriter().println(line);
			line = lecture.readLine();
		}
		lecture.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
//		HttpSession session = request.getSession(true);
//
//		BufferedReader lecture = null;
//		File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
//		InputStreamReader input = new InputStreamReader(new FileInputStream(page));
//		lecture = new BufferedReader(input);
//		String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
//		session.setAttribute("noSerie", noSerie);
//		String line = lecture.readLine();
//		while (line != null) {
//			if (line.contains("%%noSerie%%")) {
//				line.replace("%%noSerie%%", noSerie);
//			}
//			response.getWriter().println(line);
//			line = lecture.readLine();
//		}
//		lecture.close();
	}
}
