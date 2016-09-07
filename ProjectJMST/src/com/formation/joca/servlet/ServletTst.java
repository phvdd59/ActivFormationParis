package com.formation.joca.servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.formation.beans.InterPersoService;
import com.formation.beans.Perso;

/**
 * Servlet implementation class ServletTst
 */
@WebServlet("/ServletTst")
public class ServletTst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTst() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		URL wsdlURL = new URL("http://192.168.33.147:8888/ws/jax?wsdl");
		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
		Service service = Service.create(wsdlURL, qname);
		InterPersoService ps = service.getPort(InterPersoService.class);
		Perso[] p = ps.getPersos();

		// Perso perso=ps.getPerso(4);
		for (int i = 0; i < p.length; i++) {
			response.getWriter().println(p[i].getIdentifiant());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
