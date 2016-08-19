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

/**
 * Servlet implementation class ServletThcr
 */
@WebServlet(value="/ServletThcr",name="ServletTH")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/com/formation/phva/page/Login.html");
		BufferedReader br = new BufferedReader( new FileReader(file));
		String line = br.readLine();
		while(line!=null){
			response.getWriter().println(line);
			line = br.readLine();
		}
		br.close();
	}
}
