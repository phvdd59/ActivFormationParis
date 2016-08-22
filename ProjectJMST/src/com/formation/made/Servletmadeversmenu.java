package com.formation.made;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletmadeversmenu
 */
@WebServlet("/Servletmadeversmenu")
public class Servletmadeversmenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletmadeversmenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		File file = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur");
		BufferedReader bIn = null;
		bIn=new BufferedReader(new FileReader(file) ); 
		String maLigne=bIn.readLine();
		while (maLigne!=null) {
			response.getWriter().append(maLigne);
			maLigne=bIn.readLine();
		}
		bIn.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur");
		BufferedReader bIn = null;
		bIn=new BufferedReader(new FileReader(file) ); 
		String maLigne=bIn.readLine();
		while (maLigne!=null) {
			response.getWriter().append(maLigne);
			maLigne=bIn.readLine();
		}
		bIn.close();
	}

}
