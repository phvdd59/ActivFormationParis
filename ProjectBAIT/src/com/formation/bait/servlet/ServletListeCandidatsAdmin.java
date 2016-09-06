package com.formation.bait.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
@WebServlet(value = "/ServletLoginTestBDD", name = "ServletLoginTestBDD")
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
		
		//____________________________

		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://www.psyeval.fr/" + "bait";
			conn = DriverManager.getConnection(url, "bait", "erreurthde");
			stat = conn.createStatement();
			
			response.getWriter().append("<div style=\"text-align: center; width:350px; max-height:380px; overflow:auto\">");
			String sql = "SELECT * FROM listeUser Where admin=0 order by nom;";
			ResultSet resultat = stat.executeQuery(sql);
			char lettre = 'Z';
			while (resultat.next()) {
				if (!resultat.getString("nom").startsWith(Character.toString(lettre))) {
					lettre = resultat.getString("nom").charAt(0);
					response.getWriter().append("<div style=\"margin-top: 12px; font-size:150%;\">");
					response.getWriter().append(lettre);
					response.getWriter().append("</div>");
				}
				response.getWriter().append("<form>");
				response.getWriter().append("<input type=\"submit\" style=\"width: 250px;\" value=\"" + resultat.getString("nom") + " " + resultat.getString("prenom") + "\" onblur=\"\" name=\"" + resultat.getString("nom") + "\" /><br>");
				response.getWriter().append("</form>");			
			}
			response.getWriter().append("</div>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		//_________________________________________

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			String IdPersonne = request.getParameter("nom");
			String MdpPersonne = request.getParameter("mdp");

			AccesBDDPersonne acces = new AccesBDDPersonne();
			String[] test2 = acces.findPersonne(IdPersonne);
			if (test2[0] != null) {
				// la personne existe
				if (test2[1].equals(MdpPersonne)) {
					// mot de passe correct
					session.setAttribute("personne", acces.getPersonne(test2[0]));
					session.setAttribute("idPersonne", test2[0]);
					RequestDispatcher rd = request.getRequestDispatcher("//ServletBDD");
					rd.forward(request, response);
				} else {
					//mot de passe incorrect
					String echecID = "true";
					session.setAttribute("echecID", echecID);
					RequestDispatcher rd = request.getRequestDispatcher("//ServletLoginFalse");
					rd.forward(request, response);
				}
			} else {
				//id n'existe pas
				String echecID = "true";
				session.setAttribute("echecID", echecID);
				RequestDispatcher rd = request.getRequestDispatcher("//ServletLoginFalse");
				rd.forward(request, response);
			}

			//			ServletContext context = this.getServletContext();
			//			RequestDispatcher dispatcher = context.getRequestDispatcher("/ServletBDD");
			//			dispatcher.forward(request, response);
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletLoginPageLogin3");
			rd.forward(request, response);
		}

	}

}