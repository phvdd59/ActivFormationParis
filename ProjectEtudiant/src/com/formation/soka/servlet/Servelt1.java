package com.formation.soka.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servelt1
 */
@WebServlet("/Servelt1")
public class Servelt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servelt1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<html><body><h1>Bonjour à tous!</h1></body></html>");
		
		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/com/formation/phva/page/Login.html"); 
		BufferedReader bIn = null;
		try {
			
			bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine(); 
			while(line!=null){
				line= bIn.readLine();
				response.getWriter().println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Pas de fichier trouvé pour effectuer la lecture");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOOException");
			e.printStackTrace();
		}finally{
			try {
				bIn.close();
			} catch (IOException e) {
				System.out.println("Pas fermé");
				e.printStackTrace();
			}
		}
	}
}
