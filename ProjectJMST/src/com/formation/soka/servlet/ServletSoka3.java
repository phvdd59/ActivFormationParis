package com.formation.soka.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.metier.Personne;
import com.formation.thcr.metier.SEXE;

import controleur.CtrlPersonne;

/**
 * Servlet implementation class ServletSoka3
 */
@WebServlet("/ServletSoka3")
public class ServletSoka3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSoka3() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");

		Object personne = session.getAttribute("Personne");
		Personne perso = null;
		if (personne instanceof Personne) {
			perso = (Personne) personne;
		}
		
		/***************************
		 * RECUP DONNEE FORMULAIRE
		 */
		String sDateNaissance = request.getParameter("date de naissance");
		String sLieuNaissance = request.getParameter("lieu de naissance");
		String sNumSecu = request.getParameter("num secu");
		String sNationalite = request.getParameter("nationalite");
		/***************************
		 * CONTROLE ET CONVERSION
		 */
		CtrlPersonne ctrl = new CtrlPersonne();
//		if (ctrl.ctrlDateNaissance(sDateNaissance)&&ctrl.ctrlLieuNaissance(sLieuNaissance)
//				&& ctrl.ctrlNumSecu(sNumSecu)&&ctrl.ctrlNationalite(sNationalite)){
			ConversionPersonne conv = new ConversionPersonne();
			perso.setDateNaissance(conv.conversionDate(sDateNaissance));
			perso.setLieuNaissance(sLieuNaissance);
			perso.setNumSecu(sNumSecu);
			if(perso.getNumSecu().charAt(0) == '1'){
				perso.setSexe(SEXE.MASCULIN);
			} else {
				perso.setSexe(SEXE.FEMININ);
			}
			perso.setNationalite(sNationalite);
//		}
			File file = new File("C:/DevFormation/GITActivFormationParis/" + //
					"ProjectJMST/WebContent/WEB-INF/" + //
					"page/pageActiveFormulaire_part4_situation_actuelle.html");
			BufferedReader bIn = null;
			bIn = new BufferedReader(new FileReader(file));
			
		if (noSerieHtml.equals(noSerie)) {
			noSerie = "23_" + noSerie;
			session.setAttribute("noSerie", noSerie);
			String line = bIn.readLine();
			while (line != null) {
				if (line.contains("%%noSerie%%")) {
					line=line.replace("%%noSerie%%", noSerie);
				}
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
		}
	}

}
