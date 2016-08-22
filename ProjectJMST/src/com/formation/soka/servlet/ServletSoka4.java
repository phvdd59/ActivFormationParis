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

/**
 * Servlet implementation class ServletSoka4
 */
@WebServlet("/ServletSoka4")
public class ServletSoka4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSoka4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("C:/DevFormation/GITActivFormationParis/" + //
				"ProjectJMST/WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part5_fonction_remuneration.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));
		String line = bIn.readLine();
			response.getWriter().println(line);
			line = bIn.readLine();
		bIn.close();
	}

}
