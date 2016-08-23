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

/**
 * Servlet implementation class ServletThcr
 */
@WebServlet(value = "/ServletThcr", name = "ServletTH")
public class ServletThcr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletThcr() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 TODO Auto-generated metho stub
//				response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String id = session.getId();
		
		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/com/formation/thcr/Login.html");
		BufferedReader br = new BufferedReader(new FileReader(file));
		int numeroDeSerieCree = (int) Math.random()*Integer.MAX_VALUE;
		session.setAttribute("noSerie", numeroDeSerieCree);
		String line = br.readLine();
		while (line != null) {
			if(line.contains("%%numerodeserie%%")){
				line.replace("%%numerodeserie%%", Integer.toString(numeroDeSerieCree).toString());
			}
			response.getWriter().println(line);
			line = br.readLine();
		}
		br.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//getparameters
		String pseudo = req.getParameter("identifiant");
		String noserie = req.getParameter("numerodeserie");
		String recupNoSerie = (String) req.getSession().getAttribute("noSerie");
		//Controle parametre
		//Cr�er la nouvelle page
		if (pseudo != null) {
			if (pseudo.equals("Thomas")) {
				File file = new File(
						"C:/DevFormation/GITActivFormationParis/ProjectEtudiant"
						+ "/WebContent/com/formation/thcr/page/"
						+ "Gestiondocuments.html");
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine();
				while (line != null) {
					resp.getWriter().println(line);
					line = br.readLine();
				}
				br.close();
			} else {
				File file = new File(
						"C:/DevFormation/GITActivFormationParis/ProjectEtudiant"
						+ "/WebContent/com/formation/thcr/page/Login.html");
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine();
				while (line != null) {
					if(line.contains("identifiant")){
						line.replace("value=''", "value=''");
					}
					resp.getWriter().println(line);
					line = br.readLine();
				}
			}
		} else {

		}

	}
}
