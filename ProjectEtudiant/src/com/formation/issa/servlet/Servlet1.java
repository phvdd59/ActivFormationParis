package com.formation.issa.servlet;

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
@WebServlet(value = "/ServletIssa", name = "ServletIS")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pseudo = request.getParameter("nom");
		// getParamater récupère dans la balise input le nom
		response.getWriter().println("<html><body><h1>ACTIV-CONSULTING</h1></body></html>");
		response.getWriter().println("<form><input type='text' value='" + VALEUR + "'>");
		response.getWriter().println("<input name='question' type='text' + value='" + pseudo + "'>");
		response.getWriter().println("<input name='submit' type='submit'" + "value='+OK+'>");
		if (pseudo != null) {

			if (pseudo != null && pseudo.contains("Isma")) {
				response.getWriter().println("<p style='color:red'>" + pseudo + "</p>");
			} else {
				response.getWriter().println("<p style='color: blue'>" + pseudo + "</p>");
			}
		}
		VALEUR++;
		response.getWriter().println("</form></body></html>");

		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/issa/page/Login.html");
		System.out.println(file.getCanonicalPath());
		BufferedReader bStn = null;
		bStn = new BufferedReader(new FileReader(file));
		int noSerie = (int) (Math.random() * Integer.MAX_VALUE);
		String line = bStn.readLine();
		try {
			while (line != null) {

				if (line.contains("%%pseudo%%")) {
					line = line.replace("%%pseudo%%", "invite");
				} else if (line.contains("%%mdp%%")) {
					line = line.replace("%%mdp%%", "");
				}else if(line.contains("%%noserie%%")){
					line=line.replace("%%noserie%%", Integer.toString(noSerie));
				}
				response.getWriter().println(line);
				line = bStn.readLine();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			bStn.close();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// récupérer les paramètres.
		String pseudo = req.getParameter("identifiant");
		String noSerie = req.getParameter("noSerie");
		// Contrôler les paramètres.
		// Constituer la nouvelle page.
		if (pseudo != null && noSerie!=null && !noSerie.equals("%%noserie%%")) {
			if (pseudo.equals("Isma")) {
				File file = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectEtudiant/" + "WebContent/WEB-INF/com/formation/issa/" + "page/PageInfosCandidat.html");
				BufferedReader bStn = new BufferedReader(new FileReader(file));
				String line = bStn.readLine();
				while (line != null) {
					resp.getWriter().println(line);
					line = bStn.readLine();

				}
				bStn.close();

			} else {
				File file = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectEtudiant/" + "WebContent/WEB-INF/com/formation/issa/" + "page/Login.html");
				BufferedReader bStn = new BufferedReader(new FileReader(file));
				String line = bStn.readLine();
				while (line != null) {
					if (line.contains("identifiant")) {
						line = line.replace("value=''", "value='" + pseudo + " Erreur'");

					}
					resp.getWriter().println(line);
					line = bStn.readLine();
				}
				bStn.close();
			}
		}
	}

}
