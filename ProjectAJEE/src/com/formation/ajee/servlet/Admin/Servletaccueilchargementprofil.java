package com.formation.ajee.servlet.Admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.scenario.effect.light.Light;

/**
 * Servlet implementation class Servletjeci1
 */
@WebServlet("/Servletaccueilchargementprofil")
public class Servletaccueilchargementprofil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletaccueilchargementprofil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	System.out.println("jeci "+session.getId());
//		String sS=request.getParameter("JSESSIONID");
		// String noSerie = request.getParameter("noSerie");
		
//		System.out.println(sS+" page accueil2");
//		System.out.println(session.getId()+"accueil2");
		String pseudo = (String) session.getAttribute("pseudo");
		
		// Object oRecupNoSerie=session.getAttribute("noSerie");
		// String recupNoSerie=(String) oRecupNoSerie;

		// Constituer la nouvelle page
		// if (pseudo != null && noSerie != null &&
		// !noSerie.equals("%%noserie%%")) {
		// if (pseudo.equals("Philippe")) {
//		if (pseudo.equals("Admin")) {
//		/** Lecture Haut de page JSP */
//		File fileHautjsp = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.jsp");
//		BufferedReader bufReadHautjsp = null;
//		bufReadHautjsp = new BufferedReader(new FileReader(fileHautjsp));
//		String lineHautjsp = bufReadHautjsp.readLine();
//		while (lineHautjsp != null) {
//								response.getWriter().println(lineHautjsp);
//			lineHautjsp = bufReadHautjsp.readLine();
//		}
//		bufReadHautjsp.close();
			/** Lecture Haut de page HTML */
			File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
			BufferedReader bufReadHaut = null;
			bufReadHaut = new BufferedReader(new FileReader(fileHaut));
			String lineHaut = bufReadHaut.readLine();
			while (lineHaut != null) {
				if (lineHaut.contains("<title>Espace Personnel ActivConsulting</title>")) {
					lineHaut=lineHaut.replace("<title>Espace Personnel ActivConsulting</title>", "<title>Chargement</title>");
				}
				response.getWriter().println(lineHaut);
				lineHaut = bufReadHaut.readLine();
			}
			bufReadHaut.close();

			/** A modifier seulement si notre page contient du JavaScript */
			File fileJS = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSAccueilAdmin.html");
			BufferedReader bufReadJS = null;
			bufReadJS = new BufferedReader(new FileReader(fileJS));
			String lineJS = bufReadJS.readLine();
			while (lineJS != null) {
				response.getWriter().println(lineJS);
				lineJS = bufReadJS.readLine();
			}
			bufReadJS.close();

			File fileJS1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSBandeauAdmin.html");
			BufferedReader bufReadJS1 = null;
			bufReadJS1 = new BufferedReader(new FileReader(fileJS1));
			String lineJS1 = bufReadJS1.readLine();
			while (lineJS1 != null) {
				response.getWriter().println(lineJS1);
				lineJS1 = bufReadJS1.readLine();
			}
			bufReadJS1.close();

			/** Lecture page ActivConsulting */
			File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
			BufferedReader bufReadActiv = null;
			bufReadActiv = new BufferedReader(new FileReader(fileActiv));
			String lineActiv = bufReadActiv.readLine();
			while (lineActiv != null) {
				response.getWriter().println(lineActiv);
				lineActiv = bufReadActiv.readLine();
			}
			bufReadActiv.close();

			/**
			 * Seule Partie qui va vraiment changer selon les pages (penser aux
			 * controles si necessaire)
			 */
			File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
			BufferedReader bufReadDoc = null;
			bufReadDoc = new BufferedReader(new FileReader(fileDoc));
			String lineDoc = bufReadDoc.readLine();
			while (lineDoc != null) {
				if (lineDoc.contains("%pseudo%")) {
					lineDoc=lineDoc.replace("%pseudo%", pseudo);
				}
				response.getWriter().println(lineDoc);
				lineDoc = bufReadDoc.readLine();
			}
			bufReadDoc.close();

			File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/AccueilAdmin.html");
			BufferedReader bufReadDoc1 = null;
			bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
			String lineDoc1 = bufReadDoc1.readLine();
			while (lineDoc1 != null) {
				response.getWriter().println(lineDoc1);
				lineDoc1 = bufReadDoc1.readLine();
			}
			bufReadDoc1.close();

			/** Lecture bas de page */
			File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
			BufferedReader bufReadBas = null;
			bufReadBas = new BufferedReader(new FileReader(fileBas));
			String lineBas = bufReadBas.readLine();
			while (lineBas != null) {
				response.getWriter().println(lineBas);
				lineBas = bufReadBas.readLine();
			}
			bufReadBas.close();
			// }
			// }
//		} else {
//			/** Lecture Haut de page HTML */
//			File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
//			BufferedReader bufReadHaut = null;
//			bufReadHaut = new BufferedReader(new FileReader(fileHaut));
//			String lineHaut = bufReadHaut.readLine();
//			while (lineHaut != null) {
//				response.getWriter().println(lineHaut);
//				lineHaut = bufReadHaut.readLine();
//			}
//			bufReadHaut.close();
//
//			/** A modifier seulement si notre page contient du JavaScript */
//
//			File fileJS1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSBandeau.html");
//			BufferedReader bufReadJS1 = null;
//			bufReadJS1 = new BufferedReader(new FileReader(fileJS1));
//			String lineJS1 = bufReadJS1.readLine();
//			while (lineJS1 != null) {
//				response.getWriter().println(lineJS1);
//				lineJS1 = bufReadJS1.readLine();
//			}
//			bufReadJS1.close();
//
//			/** Lecture page ActivConsulting */
//			File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
//			BufferedReader bufReadActiv = null;
//			bufReadActiv = new BufferedReader(new FileReader(fileActiv));
//			String lineActiv = bufReadActiv.readLine();
//			while (lineActiv != null) {
//				response.getWriter().println(lineActiv);
//				lineActiv = bufReadActiv.readLine();
//			}
//			bufReadActiv.close();
//
//			/**
//			 * Seule Partie qui va vraiment changer selon les pages (penser aux
//			 * controles si necessaire)
//			 */
//			File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Bandeau.html");
//			BufferedReader bufReadDoc = null;
//			bufReadDoc = new BufferedReader(new FileReader(fileDoc));
//			String lineDoc = bufReadDoc.readLine();
//			while (lineDoc != null) {
//				response.getWriter().println(lineDoc);
//				lineDoc = bufReadDoc.readLine();
//			}
//			bufReadDoc.close();
//
//			File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Accueil.html");
//			BufferedReader bufReadDoc1 = null;
//			bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
//			String lineDoc1 = bufReadDoc1.readLine();
//			while (lineDoc1 != null) {
//				response.getWriter().println(lineDoc1);
//				lineDoc1 = bufReadDoc1.readLine();
//			}
//			bufReadDoc1.close();
//
//			/** Lecture bas de page */
//			File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
//			BufferedReader bufReadBas = null;
//			bufReadBas = new BufferedReader(new FileReader(fileBas));
//			String lineBas = bufReadBas.readLine();
//			while (lineBas != null) {
//				response.getWriter().println(lineBas);
//				lineBas = bufReadBas.readLine();
//			}
//			bufReadBas.close();
//		}

	}
}
