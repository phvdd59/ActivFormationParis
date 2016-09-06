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
import com.formation.bait.metier.Personne;
import com.formation.bait.metier.SITUATION;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletSituation2", name = "ServletSituation2")
public class ServletPageSituation2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPageSituation2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FonctionsCommune fonctions = new FonctionsCommune();
		HttpSession session = request.getSession();
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "Situation");
			session.setAttribute("methode", "POST");
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
			Personne personne = (Personne) session.getAttribute("personne");
			fonctions.AfficherHautDePage(response);

			File file2 = new File(
					"C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/Situation.html");
			BufferedReader bIn2 = null;
			InputStreamReader inputStreamReader2 = null;
			try {
				inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
				bIn2 = new BufferedReader(inputStreamReader2);
				String line2 = bIn2.readLine();
				String sSit = personne.getSituation();

				while (line2 != null) {
					if (line2.contains("value=\"salarie\"")){
						if (!sSit.equals(SITUATION.SALARIE)){
						line2 = line2.replace("checked", "");
					}}
					else if (line2.contains("value=\"demandeur\"")){
						if (sSit.equals(SITUATION.DEMANDEUR)){
							line2 = line2.replace("value=\"demandeur\"", "value=\"demandeur\" checked");
					}}
					else if (line2.contains("value=\"freelance\"")){
						if (sSit.equals(SITUATION.FREELANCE)){
							line2 = line2.replace("value=\"freelance\"", "value=\"freelance\" checked");
					}}
					else if (line2.contains("value=\"retraite\"")){
						if (sSit.equals(SITUATION.RETRAITE)){
							line2 = line2.replace("value=\"retraite\"", "value=\"retraite\" checked");
					}}
					else if (line2.contains("value=\"autre\"")){
						if ((sSit.equals(SITUATION.SALARIE))||(sSit.equals(SITUATION.DEMANDEUR))||(sSit.equals(SITUATION.FREELANCE))||(sSit.equals(SITUATION.RETRAITE))){}
						else {
							line2 = line2.replace("value=\"autre\"", "value=\"autre\" checked");
						}
						
					}
					else if (line2.contains("value=\"%%aut%%\"")){
						if ((sSit.equals(SITUATION.SALARIE))||(sSit.equals(SITUATION.DEMANDEUR))||(sSit.equals(SITUATION.FREELANCE))||(sSit.equals(SITUATION.RETRAITE))){
							line2 = line2.replace("%%aut%%", "");
						}else {
							line2 = line2.replace("%%aut%%", sSit);
						}
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

			fonctions.AfficherBasDePage(response);
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
			rd.forward(request, response);
		}
	}

}
