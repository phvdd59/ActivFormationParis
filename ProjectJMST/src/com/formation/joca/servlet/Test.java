package com.formation.joca.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = null;

		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");

		Personne utilisateur = new Personne();
		utilisateur.setIdentifiant(identifiant);
		DAOPersonne dao = new DAOPersonne();
		if (dao.read(utilisateur)) {
			//		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//		try {
			//			final DocumentBuilder builder = factory.newDocumentBuilder();
			//			File xmlFile = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/Data2.xml");
			//
			//			final Document document = builder.parse(xmlFile);
			//
			//			final Element eListPersonne = document.getDocumentElement();
			//
			//			if (eListPersonne.getNodeName().equals("ListPersonne")) {
			//
			//				final NodeList nListPersonne = eListPersonne.getChildNodes();
			//				final int nbracinenoeuds = nListPersonne.getLength();
			//				for (int i = 0; i < nbracinenoeuds; i++) {
			//					final Node nodePersonne = nListPersonne.item(i);
			//					if (nodePersonne.getNodeType() == Node.ELEMENT_NODE) {
			//						final Element ePersonne = (Element) nodePersonne;
			//						String nom = ePersonne.getTextContent();
			//						nom = nom.trim();
			//						String login = ePersonne.getAttribute("login");
			//						String password = ePersonne.getAttribute("password");
			//						String adminString = ePersonne.getAttribute("admin");
			//						String mail = ePersonne.getAttribute("mail");
			//						String prenom = ePersonne.getAttribute("prenom");
			//						String nationalite = ePersonne.getAttribute("nationalite");
			//						String adresse = ePersonne.getAttribute("adresse");
			//						String situation = ePersonne.getAttribute("situation");
			//						boolean admin = false;
			//						if (adminString.equals("true")) {
			//							admin = true;
			//						}
			//						Personne personne = new Personne();
			//						personne.setIdentifiant(login);
			//						personne.setMdp(password);
			//						personne.setAdmin(admin);
			//						personne.setEmail(mail);
			//						personne.setNom(nom);
			//						personne.setPrenom(prenom);
			//						personne.setNationalite(nationalite);
			//						personne.setAdresse(adresse);
			//						personne.setSituation(situation);
			//						synchronized (listPersonne) {
			//							listPersonne.add(personne);
			//						}
			//					}
			//				}
			//			}
			//		} catch (ParserConfigurationException e) {
			//			e.printStackTrace();
			//		} catch (SAXException e) {
			//			e.printStackTrace();
			//		}
			//
			//		Personne utilisateur = null;
			//
			//		for (Personne personne : listPersonne) {
			//			if (personne.getIdentifiant().equals(identifiant) && personne.getMdp().equals(motdepasse)) {
			//				session = request.getSession(true);
			//				utilisateur = personne;
			//				break;
			//			}
			//		}
			//		

			if (utilisateur != null && utilisateur.isAdmin() && utilisateur.getMdp().equals(motdepasse) && !utilisateur.isBloque()) {
				session = request.getSession(true);
				session.setAttribute("Personne", utilisateur);

				BufferedReader lecture = null;
				File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
				InputStreamReader input = new InputStreamReader(new FileInputStream(page));
				lecture = new BufferedReader(input);
				String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
				noSerie = "1a_" + noSerie;
				session.setAttribute("noSerie", noSerie);
				String line = lecture.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = lecture.readLine();
				}
				lecture.close();
			} else if (utilisateur != null && !utilisateur.isBloque() && utilisateur.getMdp().equals(motdepasse)) {
				session = request.getSession(true);
				session.setAttribute("Personne", utilisateur);
				BufferedReader lecture = null;
				File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteutilisateur.html");
				InputStreamReader input = new InputStreamReader(new FileInputStream(page));
				lecture = new BufferedReader(input);
				String noSerie = Integer.toString(((int) (Math.random() * Integer.MAX_VALUE)));
				noSerie = "1u_" + noSerie;
				session.setAttribute("noSerie", noSerie);
				String line = lecture.readLine();
				while (line != null) {
					if (line.contains("%%noSerie%%")) {
						line = line.replace("%%noSerie%%", noSerie);
					}
					response.getWriter().println(line);
					line = lecture.readLine();
				}
				lecture.close();
			} else {
				BufferedReader lecture = null;
				File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Login.html");
				InputStreamReader input = new InputStreamReader(new FileInputStream(page));
				lecture = new BufferedReader(input);
				String line = lecture.readLine();
				while (line != null) {
					if (line.contains("<p id=\"erreurLog\" style=\"visibility:hidden\"></p>") && utilisateur.isBloque()) {
						line = line.replace("hidden\"></p>", "visible; color:red;\">utilisateur bloquee</p>");
					}else if (line.contains("<p id=\"erreurLog\" style=\"visibility:hidden\"></p>") && !utilisateur.getMdp().equals(motdepasse)) {
						line = line.replace("hidden\"></p>", "visible; color:red;\">mauvais mot de passe</p>");
					} else {
						line = line.replace("hidden\"></p>", "visible; color:red;\">erreur de login</p>");
					}
					response.getWriter().println(line);
					line = lecture.readLine();
				}
				lecture.close();
			}
		} else {
			BufferedReader lecture = null;
			File page = new File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Login.html");
			InputStreamReader input = new InputStreamReader(new FileInputStream(page));
			lecture = new BufferedReader(input);
			String line = lecture.readLine();
			while (line != null) {
				if (line.contains("<p id=\"erreurLog\" style=\"visibility:hidden\"></p>")) {
					line = line.replace("hidden\"></p>", "visible; color:red;\">login inexistant</p>");
				}
				response.getWriter().println(line);
				line = lecture.readLine();
			}
			lecture.close();
		}

		// BufferedReader lecture = null;
		// File page = new
		// File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
		// InputStreamReader input = new InputStreamReader(new
		// FileInputStream(page));
		// lecture = new BufferedReader(input);
		// String noSerie = Integer.toString(((int) (Math.random() *
		// Integer.MAX_VALUE)));
		// noSerie = "1_" + noSerie;
		// session.setAttribute("noSerie", noSerie);
		// String line = lecture.readLine();
		// while (line != null) {
		// if (line.contains("%%noSerie%%")) {
		// line.replace("%%noSerie%%", noSerie);
		// }
		// response.getWriter().println(line);
		// line = lecture.readLine();
		// }
		// lecture.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// HttpSession session = request.getSession(true);
		//
		// BufferedReader lecture = null;
		// File page = new
		// File("../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
		// InputStreamReader input = new InputStreamReader(new
		// FileInputStream(page));
		// lecture = new BufferedReader(input);
		// String noSerie = Integer.toString(((int) (Math.random() *
		// Integer.MAX_VALUE)));
		// session.setAttribute("noSerie", noSerie);
		// String line = lecture.readLine();
		// while (line != null) {
		// if (line.contains("%%noSerie%%")) {
		// line.replace("%%noSerie%%", noSerie);
		// }
		// response.getWriter().println(line);
		// line = lecture.readLine();
		// }
		// lecture.close();
	}
}
