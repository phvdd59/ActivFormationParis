package com.formation.phva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletJson
 */
@WebServlet("/ServletJson")
public class ServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String sJson="{ \"eleves\":[ \"ambr@f.fr\",\"anfr@f.fr\",\"beba@f.fr\",\"emma@f.fr\",\"issa@f.fr\",\"thde@f.fr\" ,\"jeci@f.fr\"] } ";
		//String sJson="\"ambr@f.fr\",\"anfr@f.fr\",\"beba@f.fr\",\"emma@f.fr\",\"issa@f.fr\",\"thde@f.fr\" ,\"jeci@f.fr\"";
		//String sJson="{eleves:[\"ambr\",\"anfr\",\"beba\",\"emma\",\"issa\",\"thde\",\"jeci\"]}";
		String sJson="[\"ambr\",\"anfr\",\"beba\",\"emma\",\"issa\",\"thde\"]";

		//		String sJson="[\"Bonjour1\",\"Bonjour2\"]";
		//response.setContentType("applaction/json");
//		response.setContentType("application/json, text/plain");
//		response.getWriter().write(sJson);
		response.setContentType("application/json, text/plain");
		response.getWriter().println(sJson);
		response.getWriter().flush();
		response.getWriter().close();
	}

}
