package com.formation.etga.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/ServletEtga")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File file = new File("/ProjectEtudiant/WebContent/WEB-INF/com/formation/etga/page/Formulaire.html");
		BufferedReader bufRead = null;
		try {
			bufRead = new BufferedReader(new FileReader(file));
			String line = bufRead.readLine();
			while (line != null) {
				response.getWriter().println(line);
				System.out.println(line);
				line = bufRead.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//		response.getWriter().println("<HTML><body><h1>Salut Tomcat cest l'ordi d'etga</h1>");
		//		response.getWriter().append("<h2>Salut Tomcat, c'est l'ordi d'etga :)</h2></body></HTML>");

	}

}
