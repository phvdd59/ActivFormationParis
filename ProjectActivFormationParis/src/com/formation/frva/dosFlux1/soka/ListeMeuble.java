package com.formation.phva.dosFlux1.soka;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

	public void chargeXml(File file) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			file = new File("./src/data/ListTerme.xml");
//			System.out.println(file.exists());
//			System.out.println(file.getCanonicalPath());
			final Document document = builder.parse(file);
			final Element racine = document.getDocumentElement();
			final NodeList racineNoeuds = racine.getChildNodes();
			int nbRacineNoeuds = racineNoeuds.getLength();
			for (int i = 0; i < nbRacineNoeuds; i++) {
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element meuble = (Element) racineNoeuds.item(i);
					String nom = meuble.getAttribute("nom");
					String ref = meuble.getAttribute("ref");
					String unite = meuble.getAttribute("unite");
					float lng = meuble.getAttribute("lng");
					float lar = meuble.getAttribute("lar");
					float hau = meuble.getAttribute("hau");
//					boolean b = false;
//					Element sens = (Element) meuble.getElementsByTagName("y").item(0);
//					String toto = meuble.getAttribute("sens");
//					if (toto.equals("VERTICAL")) {
//						b = Terme.VERTICAL;
//					} else if (toto.equals("HORIZONTAL")) {
//						b = Terme.HORIZONTAL;
//					}
					System.out.println("posX : " + meuble.getAttribute("x") + " posY : " + meuble.getAttribute("y") + " sens : " + meuble.getAttribute("sens") + " nom : " + meuble.getTextContent().trim());
					final Element elmt = (Element) meuble.getElementsByTagName("Elmt").item(0);
					String nom2 = elmt.getAttribute("nom"); 
					String num = elmt.getAttribute("num"); 
					String unite2 = elmt.getAttribute("unite"); 
					String lng2 = elmt.getAttribute("lng");
					String lar2 = elmt.getAttribute("lar");
					String hau2 = elmt.getAttribute("hau");
					
		            final Element notice = (Element) meuble.getElementsByTagName("notice").item(0);
					String sNotice= notice.getTextContent(); 
					
					Meuble meubleFin = new Meuble(tri, nom, ref, unite, lng, lar, hau); 
					this.add(meubleFin); 
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
