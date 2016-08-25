package com.formation.phva.dosFlux1.made;

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

public class ListeMeuble extends ArrayList<Meuble> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static TRI tri;

	public void chargeListeMeuble(File fRep) {
	}

	public void chargeXml(File fFile) {
		Meuble meuble = null;

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(fFile);

			final Element eListeMeuble = document.getDocumentElement();
			final NodeList nListTerme = eListeMeuble.getChildNodes();

			if (eListeMeuble.getNodeName().equals("ListeMeuble")) {
				for (int i = 0; i < nListTerme.getLength(); i++) {
					final Node nodeMeuble = nListTerme.item(i);
					if (nodeMeuble.getNodeType() == Node.ELEMENT_NODE) {
						final Element elementNodeMeuble = (Element) nodeMeuble;
						if (elementNodeMeuble.getNodeName().equals("Meuble")) {
							String nomCommercial = elementNodeMeuble.getAttribute("nom");
							String refAbrege = elementNodeMeuble.getAttribute("refAbrege");
							String longueur = elementNodeMeuble.getAttribute("longueur");
							String largeur = elementNodeMeuble.getAttribute("largeur");
							String hauteur = elementNodeMeuble.getAttribute("hauteur");
							
							try {
								float fLongueur=Float.valueOf(longueur);
								float fLargeur=Float.valueOf(largeur);
								float fHauteur=Float.valueOf(hauteur);
							} catch (Exception e) {
								// TODO: handle exception
							}
							

						}
					}

				}

			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		String s = "[";
		for (int i = 0; i < size(); i++) {
			Meuble m = get(i);
			s += m.toString();
			if (i < size() - 1) {
				s += ",";
			}
		}
		s += "]";
		return s;
	}

}
