package com.formation.bait.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.bait.dao.AccesBDDPersonne;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletListeCandidatsAdmin", name = "ServletListeCandidatsAdmin")
public class ServletListeCandidatsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeCandidatsAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String noSuivi = "";
		for (int i = 0; i < 2; i++) {
			int k = (int) (Math.random() * 26) + 1;
			noSuivi += String.valueOf((char) (k + 64));
		}
		noSuivi += "_";
		for (int i = 0; i < 8; i++) {
			int k = (int) (Math.random() * 10);
			noSuivi += k;
		}
		session.setAttribute("suivi", noSuivi);
		session.setAttribute("nbAppel", new Integer(0));
		session.setAttribute("servlet", "Login");
		session.setAttribute("methode", "GET");

		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/hautDePageActiv.html");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); // pour
			// texte
			bIn = new BufferedReader(inputStreamReader);
			String line = bIn.readLine();
			while (line != null) {
				// System.out.println(line);
				response.getWriter().append(line + "\n");
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// ___ Afficher la liste ___
		AccesBDDPersonne acces = new AccesBDDPersonne();
		acces.afficherListeCandidats(response);

		response.getWriter().append("<div style=\"margin-top:30px; margin-left:80px;\"> <form method=\"post\" action=\"http://localhost:8080/ProjectBAIT/ServletListeCandidatsAdmin2Empruntee\"> <input type=\"submit\" name=\"BDD AJEE\" value=\"BDD AJEE\"> </form> </div>");
		response.getWriter().append("<div style=\"margin-top:30px; margin-left:80px;\"> <form method=\"post\" action=\"http://localhost:8080/ProjectBAIT/ServletListeCandidatsAdmin2Empruntee\"> <input type=\"submit\" name=\"BDD JMST\" value=\"BDD JMST\"> </form> </div>");
		response.getWriter().append("<div style=\"margin-top:30px; margin-left:80px;\"> <form method=\"post\" action=\"http://localhost:8080/ProjectBAIT/ServletDeconnection\"> <input type=\"submit\" name=\"disconnect\" value=\"Deconnexion\"> </form> </div>");
		
		File file3 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/basDePageActiv.html");
		BufferedReader bIn3 = null;
		InputStreamReader inputStreamReader3 = null;
		try

		{
			inputStreamReader3 = new InputStreamReader(new FileInputStream(file3), "UTF-8");
			bIn3 = new BufferedReader(inputStreamReader3);
			String line3 = bIn3.readLine();
			while (line3 != null) {
				// System.out.println(line);
				response.getWriter().append(line3);
				line3 = bIn3.readLine();
			}
		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		} catch (

		IOException e)

		{
			e.printStackTrace();
		} finally

		{
			try {
				bIn3.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}