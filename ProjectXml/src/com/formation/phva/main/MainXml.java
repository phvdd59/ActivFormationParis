package com.formation.phva.main;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.formation.phva.exception.CruciException;
import com.formation.phva.metier.ListTerme;
import com.formation.phva.metier.Terme;

public class MainXml {

	public static void main(String[] args) throws IOException, CruciException {
		MainXml main = new MainXml();
		main.lectureDom();
	}

	public void lectureDom() throws IOException, CruciException {
		ListTerme lst = new ListTerme();
		File file = new File("src/com/formation/phva/xml/ListTerme.xml");
		System.out.println(file.getCanonicalPath());
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			System.out.println(document.getXmlVersion());
			System.out.println(document.getXmlEncoding());
			System.out.println(document.getXmlStandalone());

			final Element eListTerme = document.getDocumentElement();
			System.out.println(eListTerme.getNodeName());
			final NodeList listTermeNoeuds = eListTerme.getChildNodes();
			final int nbListTermeNoeuds = listTermeNoeuds.getLength();
			for (int i = 0; i < nbListTermeNoeuds; i++) {
				if (listTermeNoeuds.item(i) != null && listTermeNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					if (listTermeNoeuds.item(i).getNodeName().equals("Terme")) {
						final Element eTerme = (Element) listTermeNoeuds.item(i);
						try {
							int x = Integer.valueOf(eTerme.getAttribute("x")).intValue();

							int y = Integer.valueOf(eTerme.getAttribute("y")).intValue();
							boolean sens = Boolean.valueOf(eTerme.getAttribute("sens")).booleanValue();
							String nom = eTerme.getTextContent();
							lst.add(new Terme(nom, new Point(x, y), sens));
						} catch (Exception e) {
						}
					}
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Cruci cruci = new Cruci(lst);
		cruci.afficher();
	}
}
