package com.formation.soka.servlet;

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

import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletSokaChgMdp
 */
@WebServlet("/ServletSokaChgMdp")
public class ServletSokaChgMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSokaChgMdp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Object personne = session.getAttribute("Personne");
		Personne perso = null;
		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");
		String s1 = ""; 
		if (noSerie.equals(noSerieHtml)) {
		File fileXml = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/Data.xml"); 
		BufferedReader bInXml = null;
		bInXml = new BufferedReader(new FileReader(fileXml));
		String s= bInXml.readLine(); 
		
		if (perso.getLogin().equals(request.getParameter("identifiant")) && perso.getMotDePasse().equals(request.getParameter("ancien mdp"))) {
			if (request.getParameter("new mdp 1").equals(request.getParameter("new mdp 2"))) {
				while(s!=null){
					s1+=s; 
					if (s.contains((CharSequence) session.getAttribute("login"))) {
						s=s.replace("password=\"" + perso.getMotDePasse() +"\"", "password="+ request.getParameter("new mdp 2") +"\"");
					}
					s=bInXml.readLine();
				}
			}
		}
		bInXml.close();
		
		
	
//			File file = new File("C:/DevFormation/GITActivFormationParis/" + //
//					"ProjectJMST/WebContent/WEB-INF/" + //
//					"page/pageActiveFormulaire_part0_modif_mdp.html");
			File file = new File("C:/DevFormation/GITActivFormationParis/" + //
					"ProjectJMST/WebContent/WEB-INF/" + //
					"page/Login.html");
			BufferedReader bIn = null;
			bIn = new BufferedReader(new FileReader(file));
//					noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
//					noSerie = "20_" + noSerie;
//					session.setAttribute("noSerie", noSerie);
			String line = bIn.readLine();
			while (line != null) {
				if (line.contains("%%noSerie%%")) {
					line.replace("%%noSerie%%", noSerie);
				}
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
