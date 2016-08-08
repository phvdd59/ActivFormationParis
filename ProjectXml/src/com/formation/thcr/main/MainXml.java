package com.formation.thcr.main;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.formation.thcr.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		//				Calendar cal = Calendar.getInstance();
		//				cal.set(2016, 3, 21);
		//				System.out.println(cal.getTime());
		MainXml main = new MainXml();
		main.lectureXML();

	}

	private void lectureXML() {
		File file = new File("./src/com/formation/thcr/xml/ListeTerme.xml");
		//		BufferedReader br = null;
		ArrayList<Terme> listTerme = new ArrayList<Terme>();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			Element racine = document.getDocumentElement();
			NodeList racineNoeuds = racine.getChildNodes();

			final int nbRacineNoeuds = racineNoeuds.getLength();
			for (int i = 0; i < nbRacineNoeuds; i++) {
				int x = 0;
				int y = 0;
				String sensStr = "";
				boolean sens = false;
				String nom = "";
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE && racineNoeuds.item(i).getNodeName().equals("Terme")) {
					//Recherche des attribts des éléments					
					Element terme = (Element) racineNoeuds.item(i);
					if (!(terme.getAttributeNode("sens") == null)) {
						sensStr = terme.getAttributeNode("sens").getValue();
					}
					if (terme.hasAttribute("x") && !terme.getAttribute("x").equalsIgnoreCase("")) {
						try {
							x = Integer.valueOf(terme.getAttribute("x"));
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
					} else {
						x = 0;
					}
					if (terme.hasAttribute("y") && !terme.getAttribute("y").equalsIgnoreCase("")) {
						try {
							y = Integer.valueOf(terme.getAttribute("y"));
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
					} else {
						y = 0;
					}
					try {
						if (terme.hasAttribute("sens") && sensStr.equalsIgnoreCase("HORIZONTAL")) {
							sens = Terme.HORIZONTAL;
						} else if (terme.hasAttribute("sens") && sensStr.equalsIgnoreCase("VERTICAL")) {
							sens = Terme.VERTICAL;
						} else {
							sens = false;
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					try {
						if (!terme.hasAttribute("x") || !terme.hasAttribute("y") || !terme.hasAttribute("sens")
								|| terme.getChildNodes().item(0).getTextContent().equals(null)) {
							nom = null;
						} else {
							nom = terme.getTextContent();
							listTerme.add(new Terme(nom, new Point(x, y), sens));
							;
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}
			}
			try {
				for (Terme terme : listTerme) {
					System.out.println(terme);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
