package com.formation.bait.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletNouvelleInscription2", name = "ServletNouvelleInscription2")
public class ServletNouvelleInscription2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletNouvelleInscription2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//		RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
	//		rd.forward(request, response);
	//	}
	//
	//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//		HttpSession session = request.getSession();
	//		String sNoSuiviClient = request.getParameter("suiviClient");
	//		String sNbAppelClient = request.getParameter("nbAppelClient");
	//		Object oNoSuivi = session.getAttribute("suivi");
	//
	//		//creation de personne dans la BDD, sans protections pour le moment !
	//		//		AccesBDDPersonne bdd = new AccesBDDPersonne();
	//		//		Personne newPers = new Personne(request.getParameter("identifiant"),request.getParameter("password"));
	//		//		newPers.setNom(request.getParameter("nom"));
	//		//		newPers.setPrenom(request.getParameter("prenom"));
	//		//		newPers.setEmail(request.getParameter("mail"));
	//		//		bdd.createNewPersonne(newPers.getIdentifiant(), newPers.getMdp(), newPers.getEmail(), newPers.getNom(), newPers.getPrenom());
	//
	//		AccesBDDPersonne bdd = new AccesBDDPersonne();
	//		Personne newPers = new Personne("thdetest5", "admin");
	//		newPers.setNom("Desole");
	//		newPers.setPrenom("DeRemplirLaBDD");
	//		newPers.setEmail("jaipaslechoix@activConsulting.fr");
	//		bdd.createNewPersonne(newPers.getIdentifiant(), newPers.getMdp(), newPers.getEmail(), newPers.getNom(), newPers.getPrenom());
	//
	//		if (oNoSuivi != null) {
	//			session.setAttribute("servlet", "Inscription");
	//			session.setAttribute("methode", "POST");
	//			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
	//			nbAppel++;
	//			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
	//
	//			File file = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/hautDePageActiv.html");
	//			BufferedReader bIn = null;
	//			InputStreamReader inputStreamReader = null;
	//			try {
	//				inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); // pour
	//				// texte
	//				bIn = new BufferedReader(inputStreamReader);
	//				String line = bIn.readLine();
	//				while (line != null) {
	//					// System.out.println(line);
	//					response.getWriter().append(line + "\n");
	//					line = bIn.readLine();
	//				}
	//			} catch (FileNotFoundException e) {
	//				e.printStackTrace();
	//			} catch (IOException e) {
	//				e.printStackTrace();
	//			} finally {
	//				try {
	//					bIn.close();
	//				} catch (IOException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//
	//			File file2 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/NouvelleInscription.html");
	//			BufferedReader bIn2 = null;
	//			InputStreamReader inputStreamReader2 = null;
	//			try {
	//				inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
	//				bIn2 = new BufferedReader(inputStreamReader2);
	//				String line2 = bIn2.readLine();
	//				while (line2 != null) {
	//					// System.out.println(line);
	//					response.getWriter().append(line2 + "\n");
	//					line2 = bIn2.readLine();
	//				}
	//			} catch (FileNotFoundException e) {
	//				e.printStackTrace();
	//			} catch (IOException e) {
	//				e.printStackTrace();
	//			} finally {
	//				try {
	//					bIn2.close();
	//				} catch (IOException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//			File file3 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/basDePageActiv.html");
	//			BufferedReader bIn3 = null;
	//			InputStreamReader inputStreamReader3 = null;
	//			try
	//
	//			{
	//				inputStreamReader3 = new InputStreamReader(new FileInputStream(file3), "UTF-8");
	//				bIn3 = new BufferedReader(inputStreamReader3);
	//				String line3 = bIn3.readLine();
	//				while (line3 != null) {
	//					// System.out.println(line);
	//					response.getWriter().append(line3);
	//					line3 = bIn3.readLine();
	//				}
	//			} catch (
	//
	//			FileNotFoundException e)
	//
	//			{
	//				e.printStackTrace();
	//			} catch (
	//
	//			IOException e)
	//
	//			{
	//				e.printStackTrace();
	//			} finally
	//
	//			{
	//				try {
	//					bIn3.close();
	//				} catch (IOException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		} else {
	//			session.invalidate();
	//			RequestDispatcher rd = request.getRequestDispatcher("//ServletLoginTest");
	//			rd.forward(request, response);
	//		}
	//	}

	//teeeeeeeeeeeeeeeeeeeeeeeeeeest THDE ________________

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//				creation de personne dans la BDD, sans protections pour le moment !
		AccesBDDPersonne bdd = new AccesBDDPersonne();
//		Personne newPers = new Personne(request.getParameter("identifiant"), request.getParameter("mdp1"));
		Personne newPers = new Personne(request.getParameter("identifiant"), "MDPtest999");
		newPers.setNom(request.getParameter("nom"));
		newPers.setPrenom(request.getParameter("prenom"));
		newPers.setEmail(request.getParameter("mail"));
		bdd.createNewPersonne(newPers.getIdentifiant(), newPers.getMdp(), newPers.getEmail(), newPers.getNom(), newPers.getPrenom());
		newPers.setDateCreation(new Date().toString());
		bdd.savePersonne(newPers);

		RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		Object oNoSuivi = session.getAttribute("suivi");

		if (oNoSuivi != null) {
			session.setAttribute("servlet", "Inscription");
			session.setAttribute("methode", "GET");
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));

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

			File file2 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/NouvelleInscription.html");
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
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletLoginTest");
			rd.forward(request, response);
		}
	}

}