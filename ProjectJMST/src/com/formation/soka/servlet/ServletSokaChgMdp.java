package com.formation.soka.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
//		if (noSerie.equals(noSerieHtml)) {
		File fileXml = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/Data.xml"); 
//		File fileXml2 = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/Data2.xml"); 

		BufferedReader bInXml = null;
		
		bInXml = new BufferedReader(new FileReader(fileXml));
		 
		String s= bInXml.readLine(); 
		String ident =request.getParameter("identifiant") ;
		String exMdp= request.getParameter("ancien mdp");
		String newMdp1 = request.getParameter("new mdp 1"); 
		String newMdp2 = request.getParameter("new mdp 2");
		if (perso.getIdentifiant().equals(ident) && perso.getMdp().equals(exMdp)) {
			if (newMdp1.equals(newMdp2)) {
				s1=""; 
//				synchronized (fileXml2) {
					while (s != null) {
						if (s.contains(perso.getIdentifiant())) {
							s = s.replace("password=\"" + perso.getMdp(), "password=\"" + newMdp2);
						}
						s1 += s + "\n";
						s = bInXml.readLine();
					}
//				}
			}
		}
		System.out.println(s1);
		bInXml.close();
		BufferedWriter bOutXml = null; 
		bOutXml= new BufferedWriter(new FileWriter(fileXml));
//		synchronized (fileXml2) {
			bOutXml.write(s1);
//		}
		bOutXml.close();
	
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
//		}else{
//			response.getWriter().append("FAUX : noSerie.equals(noSerieHtml)!!!");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
