package com.formation.ajee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet(value = "/Servletlisteutilisateurs", name = "Servletlisteutilisateurs")

public class Servletlisteutilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletlisteutilisateurs() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String identifiant = "";
		String mdp = "";

		if (nom != null && prenom != null) {
		nom = nom.replace(" ", "");
		identifiant = prenom.substring(0, 1) + "." + nom;
		while (mdp.length() != 8) {
			int a = (int) (Math.random() * 126);
			char lettre = (char) a;
			if (a > 47 && a < 58) {
				mdp = mdp + lettre;
			} else if (a > 96 && a < 123) {
				mdp = mdp + lettre;
			} else if (a > 64 && a < 91) {
				mdp = mdp + lettre;
			}
		}
			File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/emma/page/ListeUtilisateurs2.html");
			BufferedReader bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();

			while (line != null) {
				if (line.contains("%%alerte%%")) {
					line = line.replace("%%alerte%%", "Identifiant: " + identifiant + " Mot de passe : " + mdp);
				}
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
			
		} else {
			File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/emma/page/ListeUtilisateurs2.html");
			BufferedReader bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();

			while (line != null) {
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();

		}
	}

}
