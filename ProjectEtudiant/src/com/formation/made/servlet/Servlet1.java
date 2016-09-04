package com.formation.made.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/Servletmade", name = "Servletmade")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// response.getWriter().append(" Salut Philippe");
		// response.getWriter().println(" salut tout le monde");
		// recuperation des parametres entrés par le formulaire
		// String pseudo=request.getParameter("nomutilisateur");
		// controler les parametres
		// if (pseudo.equals("marc")) {
		// pseudo=pseudo +" denis";
		// }else{
		// pseudo=null;
		// }

		// TODO Auto-generated method stub
		// response.getWriter().println("<HTML><body><h1> Salut jojo!!!</h1>");
		// response.getWriter().println("<table><th>table header</th><tr><td>"+pseudo+" ligne 2 colonne1</td><td>ligne 1 colonne2</td></tr></table> </body></HTML>");

		File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/made/page/login.html");
		int noSerie=(int)(Math.random()*10);
		BufferedReader bIn = null;
		try {
			bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();
			while (line != null) {
				line = bIn.readLine();
				
				if(line.contains("%%pseudo%%")){
					line=line.replace("%%pseudo%%","invite");
				}
				else if(line.contains("%%mdp%%")){
					line=line.replace("%%mdp%%","");
				}
				else if(line.contains("%%noSerie%%")){
					line=line.replace("%%noSerie%%",Integer.toString(noSerie));
				}
				response.getWriter().println(line);
			}
		} catch (FileNotFoundException e) {
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recuperation des parametres entrés par le formulaire
		String pseudo = req.getParameter("identifiant");
		String noSerie=req.getParameter("noSerie");
		// controler les parametres
		if (pseudo.equals("marc")) {
			File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/made/page/Gestiondocuments.html");
			BufferedReader bIn = null;
			bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();
			while (line != null) {
				line = bIn.readLine();
				resp.getWriter().println(line);
			}
			bIn.close();
		} else {
			File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/made/page/login.html");
			BufferedReader bIn = null;
			bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();
			while (line != null) {
				line = bIn.readLine();
				resp.getWriter().println(line);
			}
			bIn.close();
		}

	}
}
