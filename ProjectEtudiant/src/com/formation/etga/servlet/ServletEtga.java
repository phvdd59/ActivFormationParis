package com.formation.etga.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value="/ServletEtga", name="ServletEG")
public class ServletEtga extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEtga() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/etga/page/Formulaire.html");
		BufferedReader bufRead = null;
		try {
			bufRead = new BufferedReader(new FileReader(file));
			String line = bufRead.readLine();
			while (line != null) {
				response.getWriter().println(line);
				line = bufRead.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			bufRead.close();
		}
	}
}
