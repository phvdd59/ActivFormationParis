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
 * Servlet implementation class Servelt1
 */
@WebServlet(value = "/ServeltSoka", name = "ServletSK")
public class Servelt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servelt1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<html><body><h1>Bonjour a tous!</h1></body></html>");
		int numSeries= (int) (Math.random()*Integer.MAX_VALUE); 
		String v = Integer.toString(numSeries); 
		File file = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectEtudiant/" + "WebContent/WEB-INF/com/formation/" + "soka/page/pageActiveFormulaire_part1_ident_mdp.html");
		BufferedReader bIn = null;

		bIn = new BufferedReader(new FileReader(file));
		String line = bIn.readLine();
		while (line != null) {
			
			if (line.contains("%%pseudo%%")) {
				line = line.replace("%%pseudo%%", "invite");
			} else if (line.contains("%%mdp%%")) {
				line = line.replace("%%mdp%%", "");
			}else if (line.contains("%%noSerie%%")) {
				line = line.replace("%%noSerie%%", v);
			}
			response.getWriter().println(line);
			line = bIn.readLine();
		}

		bIn.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ne pas oublier d'appeler la fontion doPost depuis le html dans <form action= "http;://localhost:8080/ProjectEtudiant/ServletSoka" method='post'></form>
		// TODO Auto-generated method stub
		// Recuperer les paramétres 
		String pseudo = req.getParameter("identifiant");
		String noSerie = req.getParameter("noSerie"); 
		//Controler les parametres

		//Constituer la nouvelle page
		if (pseudo != null && noSerie!=null && !noSerie.equals("%%noSerie%%")) {
			//if (pseudo.equals("Souad")) {
				File file = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectEtudiant/" + "WebContent/WEB-INF/com/formation/soka/" + "page/Gestiondocuments.html");
				BufferedReader bIn = null;
				bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();
				while (line != null) {
					resp.getWriter().println(line);
					line = bIn.readLine();
				}
				bIn.close();
//			} else {
//				File file = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectEtudiant/" + "WebContent/WEB-INF/com/formation/" + "soka/page/pageActiveFormulaire_part1_ident_mdp.html");
//				BufferedReader bIn = null;
//				bIn = new BufferedReader(new FileReader(file));
//				String line = bIn.readLine();
//				while (line != null) {
//					if (line.contains("identifiant")) {
//						line = line.replace("value=''", "value=''" + pseudo);
//					}
//					resp.getWriter().println(line);
//					line = bIn.readLine();
//				}
//				bIn.close();
//			}
		}
	}
}
