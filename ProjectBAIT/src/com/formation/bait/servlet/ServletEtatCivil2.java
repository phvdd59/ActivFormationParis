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

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletEtatCivil2", name = "ServletEtatCivil2")
public class ServletEtatCivil2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEtatCivil2() {
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
		HttpSession session = request.getSession();
		FonctionsCommune fonctions = new FonctionsCommune();
		Object oNoSuivi = session.getAttribute("suivi");
		if (session!= null && oNoSuivi != null) {
			session.setAttribute("servlet", "EtatCivil");
			session.setAttribute("methode", "POST");
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
			fonctions.AfficherHautDePage(response);

			File file2 = new File(
					FonctionsCommune.LOCAL+"WEB-INF/bait/pages/EtatCivil.html");
			BufferedReader bIn2 = null;
			Personne personne = (Personne) session.getAttribute("Personne");
			InputStreamReader inputStreamReader2 = null;
			try {
				inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
				bIn2 = new BufferedReader(inputStreamReader2);
				String line2 = bIn2.readLine();
				while (line2 != null) {
					// System.out.println(line);
					line2=line2.replace("%%nom%%", personne.getNom());
					line2=line2.replace("%%naiss%%", personne.getDateNaissance());
					line2=line2.replace("%%nationalite%%", personne.getNationalite());
					line2=line2.replace("%%prenom%%", personne.getPrenom());
					line2=line2.replace("%%lieu%%", personne.getLieuNaissance());
					line2=line2.replace("%%numSecu%%", personne.getNumSecu());
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
			//session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/ServletLogin3");
			rd.forward(request, response);
		}
	}
}