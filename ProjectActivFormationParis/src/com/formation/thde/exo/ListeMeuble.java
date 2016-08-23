package com.formation.thde.exo;

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

import com.formation.thde.ctr.TRI;

public class ListeMeuble extends ArrayList<Meuble> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static TRI tri;

	public void chargeListeMeuble(File fRep) {
	}

	public void chargeXml(File file) {

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			final Element eListMeuble = document.getDocumentElement();
			final NodeList nListMeuble = eListMeuble.getChildNodes();
			for (int i = 0; i < nListMeuble.getLength(); i++) {
				final Node nMeuble = nListMeuble.item(i);
				if (nMeuble.getNodeType() == Node.ELEMENT_NODE) {
					final Element eMeuble = (Element) nMeuble;
					if (eMeuble.getNodeName().equals("Meuble")) {
						String nomMeuble = eMeuble.getAttribute("nom");
						String refMeuble = eMeuble.getAttribute("ref");
						String unite = eMeuble.getAttribute("unite");
						String longueurS = eMeuble.getAttribute("lng");
						String largeurS = eMeuble.getAttribute("lar");
						String hauteurS = eMeuble.getAttribute("hau");
						try {
							float longueur = Float.valueOf(longueurS).intValue();
							float largeur = Float.parseFloat(largeurS);
							float hauteur = Float.parseFloat(hauteurS);
//							Meuble meuble = new Meuble(this.tri, hauteurS, hauteurS, hauteur, hauteur, hauteur);
//							Meuble meuble = new Meuble(this.tri, nomMeuble, refMeuble, "test", longueur, largeur, hauteur);
//							this.add(meuble);
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
