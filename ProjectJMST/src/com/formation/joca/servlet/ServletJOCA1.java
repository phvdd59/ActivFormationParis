package com.formation.joca.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.fonction.FonctionCommune;

//Servlet utilis� pour g�n�rer la page login par la methode doPost
/**
 * Servlet implementation class ServletJOCA1
 */
@WebServlet("/ServletJOCA1")
public class ServletJOCA1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJOCA1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		BufferedReader lecture = null;
		File page = new File(FonctionCommune.LOCAL + "/WEB-INF/page/Login.html");
		InputStreamReader input = new InputStreamReader(new FileInputStream(page));
		lecture = new BufferedReader(input);
		String line = lecture.readLine();
		while (line != null) {
			response.getWriter().println(line);
			line = line.replace("%%host%%", FonctionCommune.HOST + ":8080");
			line = lecture.readLine();
		}
		lecture.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
