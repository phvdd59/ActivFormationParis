package com.formation.phva.dosFlux1.thcr;

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
		
		
			try {
				final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

				DocumentBuilder builder = factory.newDocumentBuilder();
				File xmlFile = file;

			Document document = builder.parse(xmlFile);
			final Element eListMeuble = document.getDocumentElement();

			if (eListMeuble.getNodeName().equals("ListeMeuble")) {

				final NodeList nListMeuble = eListMeuble.getChildNodes();
				final int nbRacineNoeudsMeuble = nListMeuble.getLength();
				for (int i = 0; i < nbRacineNoeudsMeuble; i++) {
					final Node nodeMeuble = nListMeuble.item(i);
					if (nodeMeuble.getNodeType() == Node.ELEMENT_NODE) {
						final Element eMeuble = (Element) nodeMeuble;
						String nomMeuble = eMeuble.getAttribute("nom");
						String refMeuble = eMeuble.getAttribute("ref");
						String uniteMeuble = eMeuble.getAttribute("unite");
						String lngMeuble = eMeuble.getAttribute("lng");
						String larMeuble = eMeuble.getAttribute("lar");
						String hauMeuble = eMeuble.getAttribute("hau");
						System.out.println(nomMeuble);
						System.out.println(refMeuble);
						System.out.println(uniteMeuble);
						System.out.println(lngMeuble);
						System.out.println(larMeuble);
						System.out.println(hauMeuble);
						
						final NodeList nElmt = eMeuble.getChildNodes();
						final int nbRacineNoeudsElmt = nElmt.getLength();
						for (int j = 0; j < nbRacineNoeudsElmt; j++) {
							final Node nodeElmt = nElmt.item(i);
							if (nodeMeuble.getNodeType() == Node.ELEMENT_NODE) {
								final Element eElmt = (Element) nodeElmt;
								String nomElmt = null;
								String numElmt = null;
								String nbElmt = null;
								String uniteElmt = null;
								String lngElmt = null;
								String larElmt = null;
								String hauElmt = null;
								String notice = null;
								if(eElmt.getNodeName().equals("Elmt")){
									nomElmt = eElmt.getAttribute("nom");
									numElmt = eElmt.getAttribute("num");
									nbElmt = eElmt.getAttribute("unite");
									uniteElmt = eElmt.getAttribute("lng");
									lngElmt = eElmt.getAttribute("lar");
									larElmt = eElmt.getAttribute("hau");
									hauElmt = eElmt.getAttribute("hau");
									System.out.println(nomElmt);
									System.out.println(numElmt);
									System.out.println(nbElmt);
									System.out.println(uniteElmt);
									System.out.println(larElmt);
									System.out.println(hauElmt);
								} else if(eElmt.getNodeName().equals("notice")){
									notice = nodeElmt.getTextContent();
								}
								
								
							}
						}
						
						
					}
				}
			}
				
				
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
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
