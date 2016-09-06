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

import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.Personne;
import com.formation.ajee.veriffom.Vue;


@WebServlet("/Servletaccueilvalidemdp")
public class Servletaccueilvalidemdp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletaccueilvalidemdp() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Object noSerie = session.getAttribute("noSerie");
		ListPersonne lstPersonne=new ListPersonne();
		Personne utilisateur =(Personne) session.getAttribute("utilisateur");
		Personne personne = (Personne) session.getAttribute("personne");
		String sMdp=request.getParameter("mdpN");
		personne.setMdp(sMdp);
		personne.modifPersonne(personne.getIdPersonne());
		Vue vue = new Vue();
		
		if (noSerie != null && personne.getIdentifiant() != null) {
			if (personne.getIdentifiant().equals("Admin")) {
				
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");
				vue.lectureJS(response, "JSAccueilAdmin");
				vue.lectureJS(response, "JSBandeauAdmin");
				vue.lecturePage(response, "MenuActiv");

				/**Lecture corp de page */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
					}
					if (lineDoc.contains("%utilisateur%")) {
						lineDoc = lineDoc.replace("%utilisateur%", ((utilisateur == null) ? "" : utilisateur.getIdentifiant()));
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MdpEnregistrer.html");
				BufferedReader bufReadDoc1 = null;
				bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
				String lineDoc1 = bufReadDoc1.readLine();
				while (lineDoc1 != null) {
					if (lineDoc1.contains("%listepersonne%")){
					for (int i = 0; i <lstPersonne.size(); i++) {
						if (lineDoc1.contains("%listepersonne%")&&i<lstPersonne.size()-1) {
							lineDoc1 = lineDoc1.replace("%listepersonne%", lstPersonne.get(i).getIdentifiant())+"<option value=\"%listepersonne%\">";
						}else if (lineDoc1.contains("%listepersonne%")&&i==lstPersonne.size()-1) {
							lineDoc1 = lineDoc1.replace("%listepersonne%", lstPersonne.get(i).getIdentifiant());
						}
					}}
					response.getWriter().println(lineDoc1);
					lineDoc1 = bufReadDoc1.readLine();
				}
				bufReadDoc1.close();

				/** Lecture bas de page */
				vue.lecturePage(response, "BasPage");
			}

			else if (personne.getIdentifiant().isEmpty()==false) {
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");
				vue.lecturePage(response, "MenuActiv");

				/**Lecture corp de page */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Bandeau.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				/**Lecture corp de page */
				vue.lecturePage(response, "MdpEnregistrer");
				
				/**Lecture bas de page */
				vue.lecturePage(response, "BasPage");
			}
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);
		}
	}
}
