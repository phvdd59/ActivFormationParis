package com.formation.bait.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.FonctionsCommune;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletLogin3", name = "ServletLogin3")
public class ServletPageLogin3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPageLogin3() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void init() throws ServletException {
		FonctionsCommune.INIT();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		FonctionsCommune fct = new FonctionsCommune();
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
		fct.AfficherHautDePage(response);
		File file2 = new File(
				FonctionsCommune.LOCAL+"WEB-INF/bait/pages/Login.html");
		BufferedReader bIn2 = null;
		InputStreamReader inputStreamReader2 = null;
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
		fct.AfficherBasDePage(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();		
		FonctionsCommune fonctions = new FonctionsCommune();

		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			String IdPersonne = request.getParameter("nom");
			String MdpPersonne = request.getParameter("mdp");
			session.setAttribute("servlet", "Login");
			AccesBDDPersonne acces = new AccesBDDPersonne();
			String[] test2 = acces.findPersonne(IdPersonne);
			if (test2[0] != null) {
				// la personne existe
				if (test2[2].equals("True")) {
					// la personne estbloqu�e
					String msg = "Erreur : cet identifiant est bloqu�. Raison : \n " + test2[3];
					session.setAttribute("message", msg);
					RequestDispatcher rd = request.getRequestDispatcher("/ServletLoginFalse");
					rd.forward(request, response);
				} else if (test2[1].equals(MdpPersonne)) {
					// mot de passe correct
					session.setAttribute("Personne", acces.getPersonne(test2[0]));
					session.setAttribute("idPersonne", test2[0]);
					RequestDispatcher rd = request.getRequestDispatcher("/ServletBDD");
					rd.forward(request, response);
				} else {
					// mot de passe incorrect
					String echecID = "true";
					session.setAttribute("echecID", echecID);
					String msg = "Erreur : le mot de passe est incorrect!";
					session.setAttribute("message", msg);
					RequestDispatcher rd = request.getRequestDispatcher("/ServletLoginFalse");
					rd.forward(request, response);

				}
			} else {
				// id n'existe pas
				String echecID = "true";
				session.setAttribute("echecID", echecID);
				String msg = "Erreur : l'identifiant n'existe pas!";
				session.setAttribute("message", msg);
				RequestDispatcher rd = request.getRequestDispatcher("/ServletLoginFalse");
				rd.forward(request, response);
			}

			// ServletContext context = this.getServletContext();
			// RequestDispatcher dispatcher =
			// context.getRequestDispatcher("/ServletBDD");
			// dispatcher.forward(request, response);
		} else {
			session.invalidate();
			//request.getSession();
			//String msg = "Erreur : session invalide!";
			//session.setAttribute("message", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/ServletLoginFalse");
			rd.forward(request, response);
			doGet(request,response);
		}

	}
}