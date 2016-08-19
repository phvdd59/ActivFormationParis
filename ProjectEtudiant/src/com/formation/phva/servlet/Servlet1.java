package com.formation.phva.servlet;

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

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState.PassType;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(name = "ServletPhva", value = "/ServletPhva", initParams = { @WebInitParam(name = "nom", value = "qsdf") })
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
		// récupérer les paramètres.
		// Contrôler les params
		//Constituer la nouvelle page
		File f = new File("C:/DevFormation/GITActivFormationParis/"
				+ "ProjectEtudiant/WebContent/WEB-INF/com/"
				+ "formation/phva/page/Login.html");
		BufferedReader bIn = new BufferedReader(new FileReader(f));
		String l = bIn.readLine();
		while (l != null) {
			response.getWriter().println(l);
			l = bIn.readLine();
		}
		bIn.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// récupérer les paramètres.
		String pseudo = req.getParameter("identifiant");
		// Contrôler les params
		//Constituer la nouvelle page
		if (pseudo != null) {
			if (pseudo.equals("Philippe")) {
				File f = new File("C:/DevFormation/"
						+ "GITActivFormationParis/ProjectEtudiant/"
						+ "WebContent/WEB-INF/com/formation/phva/"
						+ "page/Gestiondocuments.html");
				BufferedReader bIn = new BufferedReader(new FileReader(f));
				String l = bIn.readLine();
				while (l != null) {
					resp.getWriter().println(l);
					l = bIn.readLine();
				}
				bIn.close();
			} else {
				File f = new File("C:/DevFormation/GITActivFormationParis/"
						+ "ProjectEtudiant/WebContent/WEB-INF/com/"
						+ "formation/phva/page/Login.html");
				BufferedReader bIn = new BufferedReader(new FileReader(f));
				String l = bIn.readLine();
				while (l != null) {
					if (l.contains("identifiant")) {
						l=l.replace("value=''", "value='"+pseudo+" ETGA'");
					}
					resp.getWriter().println(l);
					l = bIn.readLine();
				}
				bIn.close();
			}
		} else {

		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
