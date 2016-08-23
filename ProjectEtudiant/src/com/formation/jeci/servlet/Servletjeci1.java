package com.formation.jeci.servlet;

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
 * Servlet implementation class Servletjeci1
 */
@WebServlet("/Servletjeci1")
public class Servletjeci1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletjeci1() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String noSerie = request.getParameter("noSerie");
//		String pseudo = request.getParameter("identifiant");
//		Object oRecupNoSerie=session.getAttribute("noSerie");
//		String recupNoSerie=(String) oRecupNoSerie;
		
		//Constituer la nouvelle page
//		if (pseudo != null && noSerie != null && !noSerie.equals("%%noserie%%")) {
			//			if (pseudo.equals("Philippe")) {
			File f = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectEtudiant/" + "WebContent/WEB-INF/com/formation/ajee/" + "page/Documents.html");
			BufferedReader bIn = new BufferedReader(new FileReader(f));
			String l = bIn.readLine();
			while (l != null) {
				response.getWriter().println(l);
				l = bIn.readLine();
			}
			bIn.close();
			File f1 = new File("C:/DevFormation/" + "GITActivFormationParis/ProjectEtudiant/" + "WebContent/WEB-INF/com/formation/ajee/" + "page/bandeauAdmin.html");
			BufferedReader bIn1 = new BufferedReader(new FileReader(f1));
			String l1 = bIn.readLine();
			while (l1 != null) {
				response.getWriter().println(l);
				l1 = bIn1.readLine();
			}
			bIn1.close();
		}
	}


