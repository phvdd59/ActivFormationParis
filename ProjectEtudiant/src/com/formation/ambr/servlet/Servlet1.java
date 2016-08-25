package com.formation.ambr.servlet;

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
@WebServlet(value="/ServletAmbr", name="ServletAM")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// faire buffered reader
		// faire readline dans un string, tant que c'est pas la fin de fichier
		// faire un readline puis un println writer
		
		File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/ambr/page/FormulaireAmbr.html");
		
		File file2 = new File("");
		System.out.println(file2.getCanonicalPath());
		BufferedReader bIn = null; // dÃ©claration
		try {
			bIn = new BufferedReader(new FileReader(file)); // instanciation. On buffer pour pouvoir ligne par ligne
			
			String line = bIn.readLine();
			while (line != null) {
				if (line.contains("%%pseudo%%")) {
					line=line.replace("%%pseudo%%", "invite");
				} else if (line.contains("%%noserie%%")) {
					line=line.replace("%%mdp%%", "");
				} else if (line.contains("%%noserie%%")) {
			//		line=line.replace("%%noserie%%", Integer.toString(noserie));
				}
				
				
				response.getWriter().println(line);
				System.out.println(line);
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bIn.close(); // on l'a surround par un try-catch, au cas oÃ¹ Ã§a planterait
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
//		// récupérer les paramètres.
//		String pseudo = request.getParameter("nom");
//		// Contrôler les params
//		if (pseudo.contains("Philippe")) {
//			pseudo = pseudo + "PLUS";
//		}
//		//Constituer la nouvelle page 
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().println("<html><body><h1>ACTIV-CONSULTING</h1>");
//		response.getWriter().println("<form>" + "<input type='text' value='" + VALEUR + "'>");
//		response.getWriter().println("<input name='question' type='text' " + "value='" + pseudo + "'>");
//		response.getWriter().println("<input name='submit' type='submit' " + "value='OK'>");
//		if (pseudo.contains("Philippe")) {
//			response.getWriter().println("<p style='color:red'>" + pseudo + "</p>");
//		} else {
//			response.getWriter().println("<p style='color:blue'>" + pseudo + "</p>");
//		}
//		VALEUR++;
//		response.getWriter().println("</form></body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// faire buffered reader
		// faire readline dans un string, tant que c'est pas la fin de fichier
		// faire un readline puis un println writer
		
		File file = new File("../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/ambr/page/FormulaireAmbr.html");
		
		File file2 = new File("");
		System.out.println(file2.getCanonicalPath());
		BufferedReader bIn = null; // dÃ©claration
		try {
			bIn = new BufferedReader(new FileReader(file)); // instanciation. On buffer pour pouvoir ligne par ligne
			String line = bIn.readLine();
			while (line != null) {
				response.getWriter().println(line);
				System.out.println(line);
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bIn.close(); // on l'a surround par un try-catch, au cas oÃ¹ Ã§a planterait
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
