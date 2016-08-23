package com.formation.thcr.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletThcr1
 */
@WebServlet("/ServletThcr1")
public class ServletThcr1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletThcr1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String nom = "Nom";
		String prenom = "Prenom";
		String adresse = "Adresse";
		String codePostal = "Code postal";
		String ville = "Ville";
		String telFixe = "téléphone fixe";
		String telPort = "téléphone portable";
		String fax = "Fax";
		String mail = "mail@mail.mail";
		String dateNaissance = "01/01/1970";
		String lieuNaissance = "Lieu de naissance";
		String numSecu = "19095846";
		String nationalite = "Nationalit�";
		String situation = "salari�";
		String fonction = "fonction";
		String position = "posistion";
		String coefficient = "Coefficient";
		String salaire = "30k€";
		String mutuelle = "oui";
		String ticketresto = "oui";
		String visiteMedicale = "20/05/2016";
		String aboTransport = "73€/mois";
		String vehicule = "non";
		String nbCv = "nombre de cv";
		String kmestime = "nombre de kilom�tre estimé";

		File affichage = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Infoutilisateur.html");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(affichage), "UTF-8"));
		BufferedReader br = new BufferedReader(new FileReader(affichage));
		
		//TODO UTF _ inputStream
		String l = br2.readLine();
		String model = "></td>";
		while (l != null) {
			if (l.contains("id=\"nom")) {
				l = l.replace(model, ">" + nom + "</td>");
			}
			if (l.contains("id=\"prenom")) {
				l = l.replace(model, ">" + prenom + "</td>");
			}
			if (l.contains("id=\"adresse")) {
				l = l.replace(model, ">" + adresse + "</td>");
			}
			if (l.contains("id=\"codepost")) {
				l = l.replace(model, ">" + codePostal + "</td>");
			}
			if (l.contains("id=\"ville")) {
				l = l.replace(model, ">" + ville + "</td>");
			}
			if (l.contains("id=\"telfix")) {
				l = l.replace(model, ">" + telFixe + "</td>");
			}
			if (l.contains("id=\"telport")) {
				l = l.replace(model, ">" + telPort + "</td>");
			}
			if (l.contains("id=\"fax")) {
				l = l.replace(model, ">" + fax + "</td>");
			}
			if (l.contains("id=\"mail")) {
				l = l.replace(model, ">" + mail + "</td>");
			}
			if (l.contains("id=\"datenaissance")) {
				l = l.replace(model, ">" + dateNaissance + "</td>");
			}
			if (l.contains("id=\"lieunaissance")) {
				l = l.replace(model, ">" + lieuNaissance + "</td>");
			}
			if (l.contains("id=\"secusocial")) {
				l = l.replace(model, ">" + numSecu + "</td>");
			}
			if (l.contains("id=\"nationalite")) {
				l = l.replace(model, ">" + nationalite + "</td>");
			}
			if (l.contains("id=\"situation")) {
				l = l.replace(model, ">" + situation + "</td>");
			}
			if (l.contains("id=\"fonctionoccupe")) {
				l = l.replace(model, ">" + fonction + "</td>");
			}
			if (l.contains("id=\"position")) {
				l = l.replace(model, ">" + position + "</td>");
			}
			if (l.contains("id=\"coefficient")) {
				l = l.replace(model, ">" + coefficient + "</td>");
			}
			if (l.contains("id=\"salaire")) {
				l = l.replace(model, ">" + salaire + "</td>");
			}
			if (l.contains("id=\"mutuelle")) {
				l = l.replace(model, ">" + mutuelle + "</td>");
			}
			if (l.contains("id=\"ticketresto")) {
				l = l.replace(model, ">" + ticketresto + "</td>");
			}
			if (l.contains("id=\"visitemedicale")) {
				l = l.replace(model, ">" + visiteMedicale + "</td>");
			}
			if (l.contains("id=\"abotransport")) {
				l = l.replace(model, ">" + aboTransport + "</td>");
			}
			if (l.contains("id=\"vehicule")) {
				l = l.replace(model, ">" + vehicule + "</td>");
			}
			if (l.contains("id=\"nbcv")) {
				l = l.replace(model, ">" + nbCv + "</td>");
			}
			if (l.contains("id=\"kmestime")) {
				l = l.replace(model, ">" + kmestime + "</td>");
			}
			response.getWriter().println(l);
			l = br2.readLine();
		}
		br.close();
		br2.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
