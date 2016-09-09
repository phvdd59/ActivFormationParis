package com.formation.thcr.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.conversion.ConversionPersonne;
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
		Object o = session.getAttribute("ListPersonne");
		ListPersonne listPersonne = null;

		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");
		if (noSerieHtml != null && noSerie != null && noSerieHtml.equals(noSerie)) {
			if (o instanceof ListPersonne) {
				listPersonne = (ListPersonne) o;
			}
			String nom = "";
			String prenom = "";
			String mail = "";
			String adresse = "";
			String codePostal = "";
			String ville = "";
			String telFixe = "";
			String telPort = "";
			String fax = "";
			String dateNaissance = "";
			String lieuNaissance = "";
			String numSecu = "";
			String nationalite = "";
			String situation = "";
			String fonction = "";
			String position = "";
			String coefficient = "";
			String salaire = "";
			String mutuelle = "";
			String ticketresto = "";
			String visiteMedicale = "";
			String aboTransport = "";
			String vehicule = "";
			String nbCv = "";
			String kmestime = "";

			ConversionPersonne conv = new ConversionPersonne();

			for (Personne personne : listPersonne) {
				if (personne.getIdentifiant().equals(login)) {
					nom = personne.getNom();
					adresse = personne.getAdresse();
					mail = personne.getEmail();
					nationalite = personne.getNationalite();
					prenom = personne.getPrenom();
					codePostal = personne.getCp();
					ville = personne.getVille();
					telFixe = personne.getTelFixe();
					telPort = personne.getTelPort();
					fax = personne.getFax();
					dateNaissance = conv.conversionSQLToUtil(new Date(personne.getDateNaissance().getTime()));
					lieuNaissance = personne.getLieuNaissance();
					numSecu = personne.getNumSecu();
					situation = personne.getSituation();
					fonction = personne.getFonction();
					position = personne.getPosition();
					coefficient = personne.getCoeff();
					salaire = personne.getSalaire();
					if (personne.isMutuelle()) {
						mutuelle = "oui";
					} else {
						mutuelle = "non";
					}
					if (personne.isTicketResto()) {
						ticketresto = "oui";
					} else {
						ticketresto = "non";
					}
					visiteMedicale = conv.conversionSQLToUtil(new Date(personne.getVisiteMedicale().getTime()));
					aboTransport = personne.getMontantTransport();
					if (personne.isVoiture()) {
						vehicule = "oui";
					} else {
						vehicule = "non";
					}
					nbCv = String.valueOf(personne.getNbCV()).toString();
					kmestime = personne.getNbKm();

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
					l = l.replace("%%noSerie%%", noSerie);
				response.getWriter().println(l);
				l = br.readLine();
			}
			br.close();
		} else {
			request.getRequestDispatcher("/ServletDeco").forward(request, response);
			
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
