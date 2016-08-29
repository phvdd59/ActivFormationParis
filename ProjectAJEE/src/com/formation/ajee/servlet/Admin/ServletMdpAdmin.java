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

/**
 * Servlet implementation class ServletMdp
 */
@WebServlet("/ServletMdpAdmin")
public class ServletMdpAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMdpAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sS=request.getParameter("JSESSIONID");
		System.out.println(sS);
		System.out.println(session.getId());
		String pseudo = (String) session.getAttribute("pseudo");
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
		 
		 File fileJS1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSBandeauAdmin.html");
		 BufferedReader bufReadJS1 = null;
		 bufReadJS1 = new BufferedReader(new FileReader(fileJS1));
		 String lineJS1 = bufReadJS1.readLine();
		 while (lineJS1 != null) {
		 response.getWriter().println(lineJS1);
		 lineJS1 = bufReadJS1.readLine();
		 }
		 bufReadJS1.close();
		 
		 File fileJS2 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSMotDePasse.html");
		 BufferedReader bufReadJS2 = null;
		 bufReadJS2 = new BufferedReader(new FileReader(fileJS2));
		 String lineJS2 = bufReadJS2.readLine();
		 while (lineJS2 != null) {
		 response.getWriter().println(lineJS2);
		 lineJS2 = bufReadJS2.readLine();
		 }
		 bufReadJS2.close();

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
		
		File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MdpAdmin.html");
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
	}

}
