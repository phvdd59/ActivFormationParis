package com.formation.emma.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletEmma", name = "ServletEmma", initParams = { @WebInitParam(name = "nom", value = "qsdf") })
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/com/formation/emma/page/Identification.html");
		//	System.out.println(file.getCanonicalPath());
		BufferedReader bIn = new BufferedReader(new FileReader(file));
		String line = bIn.readLine();
		while (line != null) {
			response.getWriter().println(line);
			line = bIn.readLine();
		}
		bIn.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//recuperer les parametres
		String pseudo = req.getParameter("Identifiant");
		String mdp = req.getParameter("mot de passe");
	

		// controler les parametres	
		if (pseudo != null) {
			if (pseudo.equals("Emma") && mdp.equals("123")) {
				// constituer la nouvelle page
				File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/com/formation/emma/page/PageAccueil.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();
				while (line != null) {
					resp.getWriter().println(line);
					line = bIn.readLine();
				}
				bIn.close();

			} else {
				File f = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/com/formation/emma/page/Identification.html");
				BufferedReader bIn = new BufferedReader(new FileReader(f));
				String l = bIn.readLine();
				while (l != null) {
					//					if (l.contains("identifiant")) {
					//						resp.getWriter().println("<div><alert('identifiant ou mot de passe incorrect')></div>");
					resp.getWriter().println(l);
					l = bIn.readLine();
					//}

				}
				bIn.close();
			}
		} else {

		}
	}
}

//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("Coucou! ");
//		response.getWriter().println("<form><input type='text' value='" + VALEUR + "'></form>");
//		VALEUR++;
