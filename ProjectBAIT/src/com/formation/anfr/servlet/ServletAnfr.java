package com.formation.anfr.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletAnfr", name = "ServletAN")
public class ServletAnfr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAnfr() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		File file = new File(
				"../GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/com/formation/anfr/page/Login.html");
		BufferedReader bIn = new BufferedReader(new FileReader(file));
		String line = bIn.readLine();
		while (line != null) {
			response.getWriter().println(line);
			line = bIn.readLine();
		}
		bIn.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupérer les paramètres.
		String pseudo = request.getParameter("identifiant");
		// Contrôler les params
		if (pseudo != null) {
			if (pseudo.contains("Antoine")) {
				File file = new File(
						"../GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/com/formation/anfr/page/InsciprtionPage1.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();
				while (line != null) {
					response.getWriter().println(line);
					line = bIn.readLine();
				}
				bIn.close();
			} else {
				File file = new File(
						"../GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/com/formation/anfr/page/Login.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();
				while (line != null) {
					if (line.contains("identifiant")) {
						line = line.replace("value=' '", "value='Erreur " + pseudo + " '");
					}
					response.getWriter().println(line);
					line = bIn.readLine();
				}
				bIn.close();
			}
		}
	}
}