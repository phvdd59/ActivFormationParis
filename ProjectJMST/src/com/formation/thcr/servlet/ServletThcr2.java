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
 * Servlet implementation class ServletThcr2
 */
@WebServlet("/ServletThcr2")
public class ServletThcr2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletThcr2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object noSerie = session.getAttribute("noSerie");
		String noSerieHtml = request.getParameter("noSerie");
		
		File fileXML = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/Data.xml");

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		ListPersonne listPersonne = new ListPersonne();

		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(fileXML);

			final Element listElement = document.getDocumentElement();
			final NodeList nodeListElement = listElement.getChildNodes();

			for (int i = 0; i < nodeListElement.getLength(); i++) {
				final Node nodeElement = nodeListElement.item(i);
				if (nodeElement.getNodeType() == Node.ELEMENT_NODE) {
					final Element element = (Element) nodeElement;
					if (element.getNodeName().equals("Personne")) {
						String login = element.getAttribute("login");
						String prenom = element.getTextContent();
						String nom = element.getAttribute("nom");
						String mail = element.getAttribute("mail");
						listPersonne.add(new Personne(prenom, login, mail));
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		String tableConstruct = "";

		for (Personne personne : listPersonne) {
			tableConstruct += "\t\t\t\t<form action=\"http://localhost:8080/ProjectJMST/ServletThcr1\" method=\"post\">\n";
			tableConstruct += "\t\t\t\t<tr>\n\t\t\t\t\t<td><input type=\"hidden\" name=\"login\" value=\"" + personne.getLogin() +"\">" + personne.getLogin() + "</td>\n";
			tableConstruct += "\t\t\t\t\t<td>" + "<input type=\"hidden\" name=\"prenom\" value=\"" + personne.getPrenom().trim() + "\">" +  personne.getPrenom().trim() + "</td>\n";
			tableConstruct += "\t\t\t\t\t<td>" + "<input type=\"hidden\" name=\"mail\" value=\"" + personne.getMail() +"\">" + personne.getMail() +"</td>\n";
			tableConstruct += "\t\t\t\t\t<input type=\"hidden\" name=\"%%noSerie%%\" value=\"%%noSerie%%\">\n";
			tableConstruct += "\t\t\t\t\t<td id=\"afficher\" type=\"text\"><input type=\"submit\" value=\"afficher\"></td>\n";
            tableConstruct += "\t\t\t\t</tr>\n\t\t\t\t</form>\n";
		}
		
		//		if(noSerie instanceof String){
		//			noSerie = (String) noSerie;
		//		}
		
		File selectionUtilisateur = new File("C:/DevFormation/GITActivFormationParis/ProjectJMST/WebContent/WEB-INF/page/Listeutilisateur.html");
		BufferedReader br = new BufferedReader(new FileReader(selectionUtilisateur));
		String l = br.readLine();
		while (l != null) {
			if (l.contains("id=\"consctructTable")) {
				l=l.trim();
				l=l.replace("<tr id=\"consctructTable\">", tableConstruct);
			} 
			response.getWriter().println(l);
			l = br.readLine();
		}
		br.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
