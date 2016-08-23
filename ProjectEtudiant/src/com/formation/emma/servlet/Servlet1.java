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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletEmma", name = "ServletEmma")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static int VALEUR = 0;

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
		File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/emma/page/Identification.html");
		//	System.out.println(file.getCanonicalPath());
		int noserie = (int) Math.random() * Integer.MAX_VALUE;
		HttpSession session = request.getSession(true); //true pour garder le meme numero de session qui vient detre créé
		String id = session.getId(); //donne le numero de session
		session.setAttribute("noserie", noserie);
		
		BufferedReader bIn = new BufferedReader(new FileReader(file));
		String line = bIn.readLine();
		while (line != null) {
			if (line.contains("%%noserie%%")) {
				line = line.replace("%%noserie%%", Integer.toString(noserie));
			}
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
		
		HttpSession session = req.getSession();
		

		// controler les parametres	
		if (pseudo != null) {
			if (pseudo.equals("Emma") && mdp.equals("123")) {
				// constituer la nouvelle page
				File file = new File("C:/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/emma/page/PageAccueil.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();
				while (line != null) {
					resp.getWriter().println(line);
					line = bIn.readLine();
				}
				bIn.close();

			} else {
				File f = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/emma/page/Identification.html");
				BufferedReader bIn = new BufferedReader(new FileReader(f));
				String l = bIn.readLine();
				while (l != null) {
						resp.getWriter().println(l);
					l = bIn.readLine();
				}
				bIn.close();
			}
		} else {

		}
	}
}


