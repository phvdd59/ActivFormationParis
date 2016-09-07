package com.formation.thcr.servlet;

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

import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.ListPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletThcr2
 */
@WebServlet("/ServletThcr2")
public class ServletThcr2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletThcr2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String noSerie = (String)session.getAttribute("noSerie");
		String noSerieHtml = request.getParameter("noSerie");
		
		DAOPersonne dao = new DAOPersonne();
		ListPersonne listPersonne = dao.read();
		session.setAttribute("ListPersonne", listPersonne);
		if (noSerieHtml == null || noSerie == null || noSerieHtml.equals(noSerie)) {

		String tableConstruct = "";

		//faire un jsp pour cette page
		for (Personne personne : listPersonne) {
			tableConstruct += "\t\t\t\t<form action=\"http://localhost:8080/ProjectJMST/ServletThcr1\" method=\"post\">\n";
			tableConstruct += "\t\t\t\t<tr>\n\t\t\t\t\t<td><input type=\"hidden\" name=\"login\" value=\"" + personne.getIdentifiant() +"\">" + personne.getIdentifiant() + "</td>\n";
			tableConstruct += "\t\t\t\t\t<td>" + "<input type=\"hidden\" name=\"prenom\" value=\"" + personne.getPrenom().trim() + "\">" +  personne.getPrenom().trim() + "</td>\n";
			tableConstruct += "\t\t\t\t\t<td>" + "<input type=\"hidden\" name=\"prenom\" value=\"" + personne.getNom() + "\">" +  personne.getNom() + "</td>\n";
			tableConstruct += "\t\t\t\t\t<td>" + "<input type=\"hidden\" name=\"mail\" value=\"" + personne.getEmail() +"\">" + personne.getEmail() +"</td>\n";
			tableConstruct += "\t\t\t\t\t<input type=\"hidden\" name=\"%%noSerie%%\" value=\"%%noSerie%%\">\n";
			tableConstruct += "\t\t\t\t\t<td id=\"afficher\" type=\"text\"><input type=\"submit\" value=\"afficher\"></td>\n";
			tableConstruct += "\t\t\t\t\t<input type=\"hidden\" name=\"noSerie\" value=\"%%noSerie%%\">";
            tableConstruct += "\t\t\t\t</tr>\n\t\t\t\t</form>\n";
		}
		
		//		if(noSerie instanceof String){
		//			noSerie = (String) noSerie;
		//		}
		
		File selectionUtilisateur = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Listeutilisateur.html");
		BufferedReader br = new BufferedReader(new FileReader(selectionUtilisateur));
		String l = br.readLine();
		while (l != null) {
			if (l.contains("id=\"consctructTable")) {
				l=l.trim();
				l=l.replace("<tr id=\"consctructTable\">", tableConstruct);
			} 
			if (l.contains("%%noSerie%%")) {
				l = l.replace("%%noSerie%%", noSerie);
			}
			response.getWriter().println(l);
			l = br.readLine();
		}
		br.close();
		} else {
			request.getRequestDispatcher("/ServletDeco").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
