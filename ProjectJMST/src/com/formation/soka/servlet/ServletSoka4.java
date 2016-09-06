package com.formation.soka.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.joca.controleur.CtrlPersonne;
import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletSoka4
 */
@WebServlet("/ServletSoka4")
public class ServletSoka4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSoka4() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ConversionPersonne convPers = new ConversionPersonne();

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
		if (perso.getSituation().equals("")) {
			String sSituationPro = request.getParameter("situationPro");
			String sSituation = request.getParameter("situation");

			/***************************
			 * CONTROLE ET CONVERSION
			 */
			CtrlPersonne ctrl = new CtrlPersonne();
			if (ctrl.ctrlSituation(sSituationPro)) {
				if (!sSituation.equals("")) {
					perso.setSituation(sSituationPro);
				} else {
					perso.setSituation(sSituation);
				}
				// perso.setSituation(sSituation);
			} else {
				//JSP to deco
			}
		}

		File file = new File("C:/DevFormation/GITActivFormationParis/" + //
				"ProjectJMST/WebContent/WEB-INF/" + //
				"page/pageActiveFormulaire_part5_fonction_remuneration.html");
		BufferedReader bIn = null;
		bIn = new BufferedReader(new FileReader(file));

		if (noSerieHtml.equals(noSerie)) {
			noSerie = "24_" + noSerie;
			session.setAttribute("noSerie", noSerie);
			String line = bIn.readLine();
			while (line != null) {
				line = line.replace("%%noSerie%%", noSerie);
				line = line.replace("%%fonction%%", perso.getFonction());
				line = line.replace("%%position%%", perso.getPosition());
				line = line.replace("%%coefficient%%", perso.getCoeff());
				line = line.replace("%%salaire%%", perso.getSalaire());
				line = line.replace("%%visite%%",
						convPers.conversionSQLToUtil(new java.sql.Date(perso.getVisiteMedicale().getTime())));
				line = line.replace("%%montantTransport%%", perso.getMontantTransport());
				line = line.replace("%%nbCV%%", Integer.valueOf(perso.getNbCV()).toString());
				line = line.replace("%%nbKM%%", perso.getNbKm());

				if (perso.isCadre()) {
					line = line.replace("type=\"radio\" name=\"cadre\" value=\"oui\">",
							"type=\"radio\" name=\"cadre\" value=\"oui\" checked=\"checked\">");
				} else {
					line = line.replace("name=\"cadre\" value=\"non\">",
							"name=\"cadre\" value=\"non\" checked=\"checked\">");
				}

				if (perso.isMutuelle()) {
					line = line.replace("type=\"radio\" name=\"mutuelle\" value=\"oui\">",
							"type=\"radio\" name=\"mutuelle\" value=\"oui\" checked=\"checked\">");
				} else {
					line = line.replace("name=\"mutuelle\" value=\"non\">",
							"name=\"mutuelle\" value=\"non\" checked=\"checked\">");
				}

				if (perso.isTicketResto()) {
					line = line.replace("type=\"radio\" name=\"ticketResto\" value=\"oui\">",
							"type=\"radio\" name=\"ticketResto\" value=\"oui\" checked=\"checked\">");
				} else {
					line = line.replace("name=\"ticketResto\" value=\"non\">",
							"name=\"ticketResto\" value=\"non\" checked=\"checked\">");
				}

				if (perso.isVoiture()) {
					line = line.replace("type=\"radio\" name=\"vehicule\" value=\"oui\">",
							"type=\"radio\" name=\"vehicule\" value=\"oui\" checked=\"checked\">");
				} else {
					line = line.replace("name=\"vehicule\" value=\"non\">",
							"name=\"vehicule\" value=\"non\" checked=\"checked\">");
				}

				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
		} else {
			request.getRequestDispatcher("/ServletDeco").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
