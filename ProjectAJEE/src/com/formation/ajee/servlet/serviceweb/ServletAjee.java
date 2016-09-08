package com.formation.ajee.servlet.serviceweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.ajee.dao.DaoBDD;
import com.formation.ajee.dao.DaoPersonne;
import com.formation.ajee.metier.ListPersonne;

/**
 * Servlet implementation class ServletAjee
 */
@WebServlet("/ServletAjee")
public class ServletAjee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListPersonne lstPersonne = new ListPersonne();
		ListPersonne lstPersonnesave = new ListPersonne(1);
		DaoPersonne dao = new DaoPersonne();
		DaoBDD dao1 = new DaoBDD();

		if (lstPersonnesave.get(0) != null) {
			dao1.deleteTableBdd();
			for (int i = 0; i < lstPersonnesave.size(); i++) {
				dao.insertPersonne(lstPersonnesave.get(i));
			}
			dao1.deleteTableBackUp();

		} else {

			for (int i = 0; i < lstPersonne.size(); i++) {
				dao.insertPersonne(lstPersonne.get(i));
			}
		}

	}

}
