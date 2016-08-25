package com.formation.thcr.servlet;

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

		String login = request.getParameter("login");
		HttpSession session = request.getSession();
		Object o = session.getAttribute("listPersonne");
		ListPersonne listPersonne = null;
		
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");

		if (noSerieHtml.equals(noSerie)) {
		
		if (o instanceof ListPersonne) {
			listPersonne = (ListPersonne) o;
		}

		String nom = "Nom";
		String prenom = "Prenom";
		String mail = "mail@mail.mail";
		String adresse = "Adresse";
		String codePostal = "Code postal";
		String ville = "Ville";
		String telFixe = "telephone fixe";
		String telPort = "telephone portable";
		String fax = "Fax";
		String dateNaissance = "01/01/1970";
		String lieuNaissance = "Lieu de naissance";
		String numSecu = "19095846";
		String nationalite = "Nationalite";
		String situation = "salarie";
		String fonction = "fonction";
		String position = "posistion";
		String coefficient = "Coefficient";
		String salaire = "30k";
		String mutuelle = "oui";
		String ticketresto = "oui";
		String visiteMedicale = "20/05/2016";
		String aboTransport = "73/mois";
		String vehicule = "non";
		String nbCv = "nombre de cv";
		String kmestime = "nombre de kilometre estime";

		for (Personne personne : listPersonne) {
			if (personne.getLogin().equals(login)) {
				nom = personne.getNom();
				adresse = personne.getAdresse();
				mail = personne.getMail();
				nationalite = personne.getNationalite();
				prenom = personne.getPrenom();
			}
		}

//		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//		try {
//			final DocumentBuilder builder = factory.newDocumentBuilder();
//			final Document document = builder.parse(fileXML);
//
//			final Element listElement = document.getDocumentElement();
//			final NodeList nodeListElement = listElement.getChildNodes();
//
//			for (int i = 0; i < nodeListElement.getLength(); i++) {
//				final Node nodeElement = nodeListElement.item(i);
//				if (nodeElement.getNodeType() == Node.ELEMENT_NODE) {
//					final Element element = (Element) nodeElement;
//					if (element.getNodeName().equals("Personne")) {
//						if (element.getAttribute("login").equals(login)) {
//							prenom = element.getTextContent();
//							nom = element.getAttribute("nom");
//							mail = element.getAttribute("mail");
//							//Mettre toutes les infos
//							break;
//						} else {
//							nom = "nom";
//							prenom = "prenom";
//							mail = "mail@mail.mail";
//						}
//					}
//				}
//			}
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		}

		File affichage = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Infoutilisateur.html");
		BufferedReader br = new BufferedReader(new FileReader(affichage));

		//		Cookie cookie = new Cookie("nomCookie", "info");
		//		System.out.println(session.getMaxInactiveInterval());

		String l = br.readLine();
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
			if (l.contains("%%noSerie%%")) {
				l = l.replace("%%noSerie%%", noSerie);
			}
			response.getWriter().println(l);
			l = br.readLine();
		}
		br.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
