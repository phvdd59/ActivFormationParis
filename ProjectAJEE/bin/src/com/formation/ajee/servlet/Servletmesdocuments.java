package com.formation.ajee.servlet;

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
 * Servlet implementation class ServletDocuments
 */
@WebServlet(value = "/MesDocuments", name = "Servletdocument")
public class Servletmesdocuments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** @see HttpServlet#HttpServlet() */
	public Servletmesdocuments() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**A activer quand on aura fait le "DoGet" avec notre "HttpSession" et le "noSerie"*/		
//		String noSerie = request.getParameter("noSerie");
//		HttpSession session = request.getSession();
//		Object oRecupNoSerie = session.getAttribute("noSerie");
//		String recupNoSerie = (String) oRecupNoSerie;
//		if (noSerie.equals(recupNoSerie)) {
//			if (noSerie != null && !noSerie.equals("%%noSerie%%")) {
		
				/**Lecture Haut de page HTML*/
				File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
				BufferedReader bufReadHaut = null;
				bufReadHaut = new BufferedReader(new FileReader(fileHaut));
				String lineHaut = bufReadHaut.readLine();
				while (lineHaut != null) {
					response.getWriter().println(lineHaut);
					lineHaut = bufReadHaut.readLine();
				}
				bufReadHaut.close();
				
//				/**A modifier seulement si notre page contient du JavaScript */
//				File fileJS = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/js/JSOptional.html");
//				BufferedReader bufReadJS = null;
//				bufReadJS = new BufferedReader(new FileReader(fileJS));
//				String lineJS = bufReadJS.readLine();
//				while (lineJS != null) {
//					response.getWriter().println(lineJS);
//					lineJS = bufReadJS.readLine();
//				}
//				bufReadJS.close();
				File fileJS1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSBandeauAdmin.html");
				 BufferedReader bufReadJS1 = null;
				 bufReadJS1 = new BufferedReader(new FileReader(fileJS1));
				 String lineJS1 = bufReadJS1.readLine();
				 while (lineJS1 != null) {
				 response.getWriter().println(lineJS1);
				 lineJS1 = bufReadJS1.readLine();
				 }
				 bufReadJS1.close();
				
				/**Lecture page ActivConsulting */
				File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
				BufferedReader bufReadActiv = null;
				bufReadActiv = new BufferedReader(new FileReader(fileActiv));
				String lineActiv = bufReadActiv.readLine();
				while (lineActiv != null) {
					response.getWriter().println(lineActiv);
					lineActiv = bufReadActiv.readLine();
				}
				bufReadActiv.close();
				
				/**Seule Partie qui va vraiment changer selon les pages (penser aux controles si necessaire) */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();
				
				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
				BufferedReader bufReadDoc1 = null;
				bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
				String lineDoc1 = bufReadDoc1.readLine();
				while (lineDoc1 != null) {
					response.getWriter().println(lineDoc1);
					lineDoc1 = bufReadDoc1.readLine();
				}
				bufReadDoc1.close();
				
				/**Lecture bas de page */
				File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
				BufferedReader bufReadBas = null;
				bufReadBas = new BufferedReader(new FileReader(fileBas));
				String lineBas = bufReadBas.readLine();
				while (lineBas != null) {
					response.getWriter().println(lineBas);
					lineBas = bufReadBas.readLine();
				}
				bufReadBas.close();
//			}
//		}
	}
}
