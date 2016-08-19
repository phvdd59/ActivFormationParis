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

/**
 * Servlet implementation class Servlet2
 */
@WebServlet(value = "/ServletJOCA2", name = "ServletJOCA2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader lecture = null;
		File page = new File(
				"../GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/joca/page/Login.html");
		try {
			InputStreamReader input = new InputStreamReader(new FileInputStream(page));
			lecture = new BufferedReader(input);
			String line = lecture.readLine();
			while (line != null) {
				response.getWriter().println(line);
				line = lecture.readLine();
			}
		} catch (Exception e) {

		} finally {
			try {
				lecture.close();
			} catch (IOException e) {

			}
		}

	}

}
