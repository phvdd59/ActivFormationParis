package com.formation.ajee.servlet.Admin;

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

import com.formation.ajee.veriffom.Vue;

/**
 * Servlet implementation class ServletDecoAdmin
 */
@WebServlet("/ServletDecoAdmin")
public class ServletDecoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDecoAdmin() {
		super();
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Vue vue = new Vue();
		String sS = request.getParameter("JSESSIONID");
		System.out.println(sS);
		System.out.println(session.getId());

		/** Lecture Haut de page HTML */

		vue.lecturePage(response, "HautPage");
		/** A modifier seulement si notre page contient du JavaScript */

		/** Lecture page ActivConsulting */
		vue.lecturePage(response, "MenuActiv");

		/**
		 * Seule Partie qui va vraiment changer selon les pages (penser aux
		 * controles si necessaire)
		 */
		vue.lecturePage(response, "Identification");

	

		/** Lecture bas de page */
		vue.lecturePage(response, "BasPage");

	}

}
