package com.formation.joca.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.formation.thcr.metier.ListPersonne;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = null;
		ListPersonne listPersonne = new ListPersonne();

		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/Data2.xml");

			final Document document = builder.parse(xmlFile);

			final Element eListPersonne = document.getDocumentElement();

			if (eListPersonne.getNodeName().equals("ListPersonne")) {

				final NodeList nListPersonne = eListPersonne.getChildNodes();
				final int nbracinenoeuds = nListPersonne.getLength();
				for (int i = 0; i < nbracinenoeuds; i++) {
					final Node nodePersonne = nListPersonne.item(i);
					if (nodePersonne.getNodeType() == Node.ELEMENT_NODE) {
						final Element ePersonne = (Element) nodePersonne;
						String nom = ePersonne.getTextContent();
						nom = nom.trim();
						String login = ePersonne.getAttribute("login");
						String password = ePersonne.getAttribute("password");
						String adminString = ePersonne.getAttribute("admin");
						String mail = ePersonne.getAttribute("mail");
						String prenom = ePersonne.getAttribute("prenom");
						String nationalite = ePersonne.getAttribute("nationalite");
						String adresse = ePersonne.getAttribute("adresse");
						boolean admin = false;
						if (adminString.equals("true")) {
							admin = true;
						}
						Personne personne = new Personne();
						personne.setLogin(login);
						personne.setMotDePasse(password);
						personne.setAdmin(admin);
						personne.setMail(mail);
						personne.setNom(nom);
						personne.setPrenom(prenom);
						personne.setNationalite(nationalite);
						personne.setAdresse(adresse);
						synchronized (listPersonne) {
							listPersonne.add(personne);
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		Personne utilisateur = null;

		for (Personne personne : listPersonne) {
			if (personne.getLogin().equals(identifiant) && personne.getMotDePasse().equals(motdepasse)) {
				session = request.getSession(true);
				utilisateur = personne;
				break;
			}
		}
		
		if (utilisateur != null && utilisateur.isAdmin()) {
			session.setAttribute("listPersonne", listPersonne);
			session.setAttribute("Personne", utilisateur);
			Object personne = session.getAttribute("Personne");
			Personne perso = null;
			if (personne instanceof Personne) {
				perso = (Personne) personne;
			}
			BufferedReader lecture = null;
			File page = new File(
					"../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteadministrateur.html");
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
		} else if (utilisateur != null && !utilisateur.isAdmin()) {
			session.setAttribute("Personne", utilisateur);
			BufferedReader lecture = null;
			File page = new File(
					"../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/pagecompteutilisateur.html");
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
			File page = new File(
					"../GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Login.html");
			InputStreamReader input = new InputStreamReader(new FileInputStream(page));
			lecture = new BufferedReader(input);
			String line = lecture.readLine();
			while (line != null) {
				if(line.equals("value=\"%%noSerie%%\">")){
					line = line.replace("value=\"%%noSerie%%\">", "value=\"%%noSerie%%\">"+"erreur login");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
