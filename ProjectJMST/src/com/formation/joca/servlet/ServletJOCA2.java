package com.formation.joca.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Servlet utilis� pour generer la page gestion fichier par la methode doPost

/**
 * Servlet implementation class ServletJOCA2
 */
@WebServlet("/ServletJOCA2")
public class ServletJOCA2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJOCA2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");
		//if (noSerieHtml.equals(noSerie)) {
			BufferedReader lecture = null;
			File page = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Gestiondocuments.html");
			lecture = new BufferedReader(new FileReader(page));
			String line = lecture.readLine();
			while (line != null) {
				response.getWriter().println(line);
				line = lecture.readLine();
				
			}
			lecture.close();
		//}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
