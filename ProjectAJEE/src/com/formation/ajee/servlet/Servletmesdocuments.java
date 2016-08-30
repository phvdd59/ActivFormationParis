package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.ajee.metier.DocPerso;
import com.formation.ajee.metier.ListeDoc;

/**
 * Servlet implementation class ServletDocuments
 */
@WebServlet(value = "/MesDocuments", name = "Servletdocument")
public class Servletmesdocuments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListeDoc lstDoc;
	private DocPerso doc;

	/** @see HttpServlet#HttpServlet() */
	public Servletmesdocuments() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Object oPseudo = session.getAttribute("pseudo");
		Object utilisateur = session.getAttribute("utilisateur");
		if (oPseudo != null) {

			String pseudo = (String)oPseudo;
			if (pseudo.equals("Admin")) {
				if (utilisateur == null) {
					// Faux question à poser
					response.getWriter().println("<alert('Veuillez selectionner une personne dans accueil')>");

				} else {

					/** Lecture Haut de page HTML */
					File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
					BufferedReader bufReadHaut = null;
					bufReadHaut = new BufferedReader(new FileReader(fileHaut));
					String lineHaut = bufReadHaut.readLine();
					while (lineHaut != null) {
						response.getWriter().println(lineHaut);
						lineHaut = bufReadHaut.readLine();
					}
					bufReadHaut.close();

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
					 * Seule Partie qui va vraiment changer selon les pages
					 * (penser aux controles si necessaire)
					 */
					File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
					BufferedReader bufReadDoc = null;
					bufReadDoc = new BufferedReader(new FileReader(fileDoc));
					String lineDoc = bufReadDoc.readLine();
					while (lineDoc != null) {
						if (lineDoc.contains("%pseudo%")) {
							lineDoc = lineDoc.replace("%pseudo%", pseudo);
						}if (lineDoc.contains("%utilisateur%")) {
							lineDoc=lineDoc.replace("%utilisateur%", ((utilisateur == null)?"":utilisateur.toString()));
						}
						response.getWriter().println(lineDoc);
						lineDoc = bufReadDoc.readLine();
					}
					bufReadDoc.close();

					Object oIdDoc = request.getParameter("idDoc");
					Object oNomDocUtil = request.getParameter("nomDocUtil");
					Object oType = request.getParameter("type");
					Object oNomDocFile = request.getParameter("nomDocFile");
					Object oTime = request.getParameter("time");
					Object oCommentaire = request.getParameter("commentaire");
					if ((oIdDoc != null) && (oNomDocUtil != null) && (oType != null) && (oNomDocFile != null) && (oTime != null) && (oCommentaire != null)) {
						int idDoc = (int) oIdDoc;
						String nomDocUtil = (String) oNomDocUtil;
						String type = (String) oType;
						String nomDocFile = (String) oNomDocFile;
						long time = (long) oTime; 
						String commentaire = (String) oCommentaire;
						doc = new DocPerso(idDoc, nomDocUtil, type, nomDocFile, time, commentaire);		
						for (int i = 0; i < lstDoc.size(); i++) {
							if (lstDoc.get(i).equals(doc)) {
								// alert "personne deja existante"
								response.getWriter().println("<alert('document déjà existant')>");
							} else {
								lstDoc.add(doc);
								//test
								response.getWriter().println("<alert('ça marche')>");
							}
						}
						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							 if (lineDoc1.contains("%%value%%")) {
								lineDoc1 = lineDoc1.replace("%%value%%", nomDocUtil);
								lineDoc1 = lineDoc1.replace("></", ">" + nomDocUtil + "</");
								response.getWriter().println("<option value='%%value%%'></option>");
							}
							response.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();	
					} else {
						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							response.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();
					}

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
				}
			} else {
				// utiliser le pseudo
				/** Lecture Haut de page HTML */
				File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
				BufferedReader bufReadHaut = null;
				bufReadHaut = new BufferedReader(new FileReader(fileHaut));
				String lineHaut = bufReadHaut.readLine();
				while (lineHaut != null) {
					response.getWriter().println(lineHaut);
					lineHaut = bufReadHaut.readLine();
				}
				bufReadHaut.close();

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
				 * Seule Partie qui va vraiment changer selon les pages (penser
				 * aux controles si necessaire)
				 */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Bandeau.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", pseudo);
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				Object oIdDoc = request.getParameter("idDoc");
				Object oNomDocUtil = request.getParameter("nomDocUtil");
				Object oType = request.getParameter("type");
				Object oNomDocFile = request.getParameter("nomDocFile");
				Object oTime = request.getParameter("time");
				Object oCommentaire = request.getParameter("commentaire");
				if ((oIdDoc != null) && (oNomDocUtil != null) && (oType != null) && (oNomDocFile != null) && (oTime != null) && (oCommentaire != null)) {
					int idDoc = (int) oIdDoc;
					String nomDocUtil = (String) oNomDocUtil;
					String type = (String) oType;
					String nomDocFile = (String) oNomDocFile;
					long time = (long) oTime; 
					String commentaire = (String) oCommentaire;
					doc = new DocPerso(idDoc, nomDocUtil, type, nomDocFile, time, commentaire);		
					for (int i = 0; i < lstDoc.size(); i++) {
						if (lstDoc.get(i).equals(doc)) {
							// alert "personne deja existante"
							response.getWriter().println("<alert('document déjà existant')>");
						} else {
							lstDoc.add(doc);
							//test
							response.getWriter().println("<alert('ça marche')>");
						}
					}
					File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
					BufferedReader bufReadDoc1 = null;
					bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
					String lineDoc1 = bufReadDoc1.readLine();
					while (lineDoc1 != null) {
						 if (lineDoc1.contains("%%value%%")) {
							lineDoc1 = lineDoc1.replace("%%value%%", nomDocUtil);
							lineDoc1 = lineDoc1.replace("></", ">" + nomDocUtil + "</");
							response.getWriter().println("<option value='%%value%%'></option>");
						}
						response.getWriter().println(lineDoc1);
						lineDoc1 = bufReadDoc1.readLine();
					}
					bufReadDoc1.close();	
				} else {
					File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
					BufferedReader bufReadDoc1 = null;
					bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
					String lineDoc1 = bufReadDoc1.readLine();
					while (lineDoc1 != null) {
						response.getWriter().println(lineDoc1);
						lineDoc1 = bufReadDoc1.readLine();
					}
					bufReadDoc1.close();
				}

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
			}

		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);
		}
		// }
		// }
	}
}
