package com.formation.etga.exo.flux2;

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

	public void chargeXml(File file) {
		ArrayList<Meuble> lstMeuble = null;
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//		file = new File("./src/com/formation/etga/ctr/ListMeuble.xml"); //a definir dans le Main
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			final Element eListMeuble = document.getDocumentElement();
			final NodeList nListMeuble = eListMeuble.getChildNodes();

			if (eListMeuble.getNodeName().equals("ListeMeuble")) {
				lstMeuble = new ArrayList<Meuble>();
				for (int i = 0; i < nListMeuble.getLength(); i++) {
					final Node nMeuble = nListMeuble.item(i);
					if (nMeuble.getNodeType() == Node.ELEMENT_NODE) {
						final Element eMeuble = (Element) nMeuble;
						if (eMeuble.getNodeName().equals("Meuble")) {
							String sNom = eMeuble.getAttribute("nom");
							String sRef = eMeuble.getAttribute("ref");
							String sUnite = eMeuble.getAttribute("unite");
							String sLng = eMeuble.getAttribute("lng");
							String sLar = eMeuble.getAttribute("lar");
							String sHau = eMeuble.getAttribute("hau");
							try {
								float longueur = (float) Integer.parseInt(sLng);
								float largeur = (float) Integer.parseInt(sLar);
								float hauteur = (float) Integer.parseInt(sHau);

								if (longueur < 0 || largeur < 0 || hauteur < 0) {
									throw new NegatifException();
								}
								Meuble meuble = new Meuble(null, sNom, sRef, longueur, largeur, hauteur);
								lstMeuble.add(meuble);
							} catch (NegatifException e) {
							}
							//							
							//							final Element eElmt = (Element) nElmt;
							//							if (eElmt.getNodeName().equals("Elmt")) {
							//								String sNom = eMeuble.getAttribute("nom");
							//								String sNum = eMeuble.getAttribute("num");
							//								String sUnite = eMeuble.getAttribute("unite");
							//								String sLng = eMeuble.getAttribute("lng");
							//								String sLar = eMeuble.getAttribute("lar");
							//								String sHau = eMeuble.getAttribute("hau");
							//								try {
							//									float longueur = (float)Integer.parseInt(sLng);
							//									float largeur = (float)Integer.parseInt(sLar);
							//									float hauteur =(float)Integer.parseInt(sHau);
							//									
							//									if (longueur < 0 || largeur < 0 || hauteur < 0) {
							//										throw new NegatifException();
							//									}
							//									Meuble meuble = new Meuble(null, sNom, sRef, longueur, largeur, hauteur);
							//									lstMeuble.add(meuble);
							//								} catch (NegatifException e) {	
							//								}
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
