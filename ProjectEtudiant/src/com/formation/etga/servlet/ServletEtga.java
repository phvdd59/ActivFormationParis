package com.formation.etga.servlet;

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
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletEtga", name = "ServletEG")
public class ServletEtga extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEtga() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/etga/page/Connexion.html");
		BufferedReader bufRead = null;
		bufRead = new BufferedReader(new FileReader(file));
		String line = bufRead.readLine();
		while (line != null) {
			response.getWriter().println(line);
			line = bufRead.readLine();
		}
		bufRead.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pseudo1 = req.getParameter("identifiant");
		String pseudo2 = req.getParameter("mdp");
		if ((pseudo1 != null) && (pseudo2 != null)) {
			if ((pseudo1.equals("etga")) && (pseudo2.equals("etga"))) {
				File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/etga/page/Document.html");
				BufferedReader bufRead = null;
				bufRead = new BufferedReader(new FileReader(file));
				String line = bufRead.readLine();
				while (line != null) {
					resp.getWriter().println(line);
					line = bufRead.readLine();
				}
				bufRead.close();
			} else {
				File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/etga/page/Connexion.html");
				BufferedReader bufRead = null;
				bufRead = new BufferedReader(new FileReader(file));
				String line = bufRead.readLine();
				while (line != null) {
					if (line.contains("identifiant")) {
						line = line.replace(pseudo2, "erreur");
					}
					if (line.contains("mdp")) {
						line = line.replace(pseudo2, "erreur");
					}
					resp.getWriter().println(line);
					line = bufRead.readLine();
				}
				bufRead.close();
			}
		}
	}
}
