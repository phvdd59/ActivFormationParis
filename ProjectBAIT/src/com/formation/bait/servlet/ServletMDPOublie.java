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

import com.formation.bait.metier.FonctionsCommune;

/**
 * Servlet implementation class ServletMDPOublie
 */
@WebServlet(value = "/ServletMDPOublie", name = "ServletMDPOublie")
public class ServletMDPOublie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMDPOublie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FonctionsCommune fctC = new FonctionsCommune();
		fctC.AfficherHautDePage(response);

		File file2 = new File(
				FonctionsCommune.LOCAL+"WEB-INF/bait/pages/mdpoublie.html");
		BufferedReader bIn2 = null;
		InputStreamReader inputStreamReader2 = null;
		try {
			inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
			bIn2 = new BufferedReader(inputStreamReader2);
			String line2 = bIn2.readLine();
			while (line2 != null) {
				// System.out.println(line);
				response.getWriter().append(line2 + "\n");
				// if (line2.contains("Identification")){

				// response.getWriter().append("<div style=\" margin-left:180px;
				// margin-bottom:15px;\" >Erreur: mot de passe ou identifiant
				// incorrect"+"\n </div>");

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FonctionsCommune fctC = new FonctionsCommune();
		fctC.AfficherHautDePage(response);

		File file2 = new File(
				FonctionsCommune.LOCAL+"WEB-INF/bait/pages/mdpoublie.html");
		BufferedReader bIn2 = null;
		InputStreamReader inputStreamReader2 = null;
		try {
			inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
			bIn2 = new BufferedReader(inputStreamReader2);
			String line2 = bIn2.readLine();
			while (line2 != null) {
				// System.out.println(line);
				response.getWriter().append(line2 + "\n");
				// if (line2.contains("Identification")){

				// response.getWriter().append("<div style=\" margin-left:180px;
				// margin-bottom:15px;\" >Erreur: mot de passe ou identifiant
				// incorrect"+"\n </div>");

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
