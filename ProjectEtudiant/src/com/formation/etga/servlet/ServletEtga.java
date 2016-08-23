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
@WebServlet(value = "/EG", name = "ServletEtga")
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
		int noSerie = (int) (Math.random() * Integer.MAX_VALUE);
		String line = bufRead.readLine();
		while (line != null) {
			if (line.contains("%%identifiant%%")) {
				line = line.replace("%%identifiant%%", "invité");
			} else if (line.contains("%%mdp%%")) {
				line = line.replace("%%mdp%%", " ");
			} else if (line.contains("%%noSerie%%")) {
				line = line.replace("%%noSerie%%", Integer.toString(noSerie));
			}
			response.getWriter().println(line);
			line = bufRead.readLine();
		}
		bufRead.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String identifiant = req.getParameter("identifiant");
		String noSerie = req.getParameter("noSerie");
		if (identifiant != null && noSerie != null && !noSerie.equals("%%noSeire%%")) {
			if (identifiant.equals("etga")) {
				File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/etga/page/Documents.html");
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
						line = line.replace(identifiant, "erreur");
					}
					resp.getWriter().println(line);
					line = bufRead.readLine();
				}
				bufRead.close();
			}
		}
	}
}
