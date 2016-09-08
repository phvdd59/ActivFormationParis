package com.formation.anfr.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/ServletLoginTest", name = "ServletLoginTest")
public class ServletLoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLoginTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int noSuivi = (int) (Math.random() * 1000);
		session.setAttribute("suivi", Integer.valueOf(noSuivi));
		session.setAttribute("nbAppel", new Integer(0));
		session.setAttribute("servlet", "Login");
		session.setAttribute("methode", "GET");
		File file2 = new File(
				FonctionsCommune.LOCAL+"WEB-INF/anfr/pages/Login.html");
		BufferedReader bIn2 = null;
		InputStreamReader inputStreamReader2 = null;
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding( "UTF-8" );
			inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
			bIn2 = new BufferedReader(inputStreamReader2);
			String line2 = bIn2.readLine();
			while (line2 != null) {
				// System.out.println(line);
				response.getWriter().append(line2 + "\n");
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "VDD1");
			session.setAttribute("methode", "POST");
			int noSuivi = ((Integer) oNoSuivi).intValue();
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));

			String pseudo = request.getParameter("nom");
			File file2 = new File(
					FonctionsCommune.LOCAL+"WEB-INF/bait/pages/Login.html");
			BufferedReader bIn2 = null;
			InputStreamReader inputStreamReader2 = null;
		System.out.println(session.getId());
			if (pseudo.contains("Candidat")) {
				try {
					inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
					bIn2 = new BufferedReader(inputStreamReader2);
					String line2 = bIn2.readLine();
					while (line2 != null) {
						// System.out.println(line);
						response.getWriter().append(line2 + "\n");
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
			} else {

				try {
					inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
					bIn2 = new BufferedReader(inputStreamReader2);
					String line2 = bIn2.readLine();
					while (line2 != null) {
						if (line2.contains("identifiant")) {
							line2 = line2.replace("value=''", "value='Erreur " + pseudo + " '");
						} else if (line2.contains("password")) {
							line2 = line2.replace("value=''", "value="+session.getId());
						}
						response.getWriter().append(line2 + "\n");
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
			}
		}

	}

}