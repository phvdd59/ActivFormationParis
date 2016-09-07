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

import com.formation.bait.metier.FonctionsCommune;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletLoginFalse", name = "ServletLoginFalse")
public class ServletLogFalse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogFalse() {
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
		FonctionsCommune fctC = new FonctionsCommune();
		HttpSession session = request.getSession();
		fctC.AfficherHautDePage(response);

		File file2 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/Login.html");
		BufferedReader bIn2 = null;
		InputStreamReader inputStreamReader2 = null;
		try {
			inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
			bIn2 = new BufferedReader(inputStreamReader2);
			String line2 = bIn2.readLine();

			String msg = (String) session.getAttribute("message");
			while (line2 != null) {
				// System.out.println(line);
				response.getWriter().append(line2 + "\n");
				if (line2.contains("Identification")) {

					response.getWriter().append("<div style=\" margin-left:180px; margin-bottom:15px;\" >" + msg + "\n </div>");

				}
				line2 = bIn2.readLine();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		fctC.AfficherBasDePage(response);

		response.getWriter().append("un truc");

	}
}