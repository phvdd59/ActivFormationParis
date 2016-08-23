package com.formation.phva.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;
	public static String saveNoSerie;

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
		HttpSession session = request.getSession(true);
		String id = session.getId();
		System.out.println(session.getId());
		File f = new File("C:/DevFormation/GITActivFormationParis/" + "ProjectEtudiant/WebContent/WEB-INF/com/" + "formation/phva/page/Login.html");
		BufferedReader bIn = new BufferedReader(new FileReader(f));
		int noSerie = (int) (Math.random() * Integer.MAX_VALUE);
		String sNoSerie = Integer.toString(noSerie);
		int sum = 0;
		for (int i = 0; i < sNoSerie.length(); i++) {
			sum += Integer.valueOf(sNoSerie.substring(i, i + 1));
		}
		sNoSerie = "1" + Integer.toString(sum) + "_" + sNoSerie;
		session.setAttribute("noSerie", sNoSerie);
		Cookie monCookie = new Cookie("nom", "Philippe");
		response.addCookie(monCookie);
		String l = bIn.readLine();
		while (l != null) {
			if (l.contains("%%pseudo%%")) {
				l = l.replace("%%pseudo%%", "invite");
			} else if (l.contains("%%mdp%%")) {
				l = l.replace("%%mdp%%", "");
			} else if (l.contains("%%noserie%%")) {
				l = l.replace("%%noserie%%", sNoSerie);
			}
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
		String noSerie = req.getParameter("noSerie");
		HttpSession session = req.getSession();
		System.out.println(session.getId());
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			String v=cookie.getValue();
		}
		Object oRecupNoSerie = session.getAttribute("noSerie");
		String recupNoSerie = (String) oRecupNoSerie;
		if (noSerie.equals(recupNoSerie)) {
			//			int sum = 0;
			//			for (int i = noSerie.indexOf("_") + 1; i < noSerie.length(); i++) {
			//				sum += Integer.valueOf(noSerie.substring(i, i + 1));
			//			}
			// Contrôler les params
			//Constituer la nouvelle page
			if (pseudo != null && noSerie != null && !noSerie.equals("%%noserie%%")) {
				//			if (pseudo.equals("Philippe")) {
				File f = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectEtudiant/" + "WebContent/WEB-INF/com/formation/phva/" + "page/Gestiondocuments.html");
				BufferedReader bIn = new BufferedReader(new FileReader(f));
				String l = bIn.readLine();
				while (l != null) {
					resp.getWriter().println(l);
					l = bIn.readLine();
				}
				bIn.close();
			}
			//			} else {
			//				File f = new File("C:/DevFormation/GITActivFormationParis/"
			//						+ "ProjectEtudiant/WebContent/WEB-INF/com/"
			//						+ "formation/phva/page/Login.html");
			//				BufferedReader bIn = new BufferedReader(new FileReader(f));
			//				String l = bIn.readLine();
			//				while (l != null) {
			//					if (l.contains("identifiant")) {
			//						l=l.replace("value=''", "value='"+pseudo+" ETGA'");
			//					}
			//					resp.getWriter().println(l);
			//					l = bIn.readLine();
			//				}
			//				bIn.close();
			//			}
			//		} else {
			//
			//		}
			//response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}

}
