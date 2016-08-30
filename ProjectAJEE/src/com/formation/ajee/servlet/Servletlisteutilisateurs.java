package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.Personne;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet(value = "/Servletlisteutilisateurs", name = "Servletlisteutilisateurs")

public class Servletlisteutilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListPersonne lstUser;
	private Personne user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletlisteutilisateurs() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		lstUser = new ListPersonne();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object oNom = request.getParameter("nom");
		Object oPrenom = request.getParameter("prenom");
		

		if (oNom != null && oPrenom != null) {
			String nom = (String) oNom;
			String prenom = (String) oPrenom;
			user = new Personne(nom, prenom);					
			for (int i = 0; i < lstUser.size(); i++) {
				if (lstUser.get(i).equals(user)) {
					// alert "personne deja existante"
					response.getWriter().println("<alert('utilisateur déjà existant')>");
				} else {
					lstUser.add(user);
					//test
					response.getWriter().println("<alert('ça marche')>");
				}
			}
			

			File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/ListeUtilisateurs2.html");
			BufferedReader bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();

			while (line != null) {
				if (line.contains("%%alerte%%")) {
					line = line.replace("%%alerte%%", "Identifiant: " + user.getIdentifiant() + " Mot de passe : " + user.getMdp());
				} else if (line.contains("%%value%%")) {
					line = line.replace("%%value%%", nom + prenom);
					line = line.replace("></", ">" + nom + prenom + "</");
					response.getWriter().println("<option value='%%value%%'></option>");
				
				}
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();

		} else {
			File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/ListeUtilisateurs2.html");
			BufferedReader bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();

			while (line != null) {
				response.getWriter().println(line);
				line = bIn.readLine();
				
			}
			bIn.close();

		}
	}

}
