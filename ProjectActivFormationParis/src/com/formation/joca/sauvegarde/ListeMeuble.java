package com.formation.joca.sauvegarde;

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

	public ListeMeuble() {

	}

	public void chargeListeMeuble(File fRep) {

	}

	public void chargeXml(File file) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			final Element elmtMeuble = document.getDocumentElement();
			final NodeList nodeListeMeuble = elmtMeuble.getChildNodes();
			if (elmtMeuble.getNodeName().equals("ListeMeuble")) {

				for (int i = 0; i < nodeListeMeuble.getLength(); i++) {
					if (nodeListeMeuble.item(i).getNodeName().equals("Meuble")) {
						final Node nMeuble = nodeListeMeuble.item(i);
						if (nMeuble.getNodeType() == Node.ELEMENT_NODE) {
							Element eMeuble = (Element) nMeuble;
							String nom = eMeuble.getAttribute("nom");
							String ref = eMeuble.getAttribute("ref");
							String unite = eMeuble.getAttribute("unite");
							float lng = Float.valueOf(eMeuble.getAttribute("lng")).floatValue();
							float lar = Float.valueOf(eMeuble.getAttribute("lar")).floatValue();
							float hau = Float.valueOf(eMeuble.getAttribute("hau")).floatValue();
							Meuble meuble = new Meuble(this.tri, nom, ref, unite, lng, lar, hau);

							ListeElmt lstElmt = new ListeElmt();

							final NodeList nodeListeElmt = eMeuble.getChildNodes();
							for (int j = 0; j < nodeListeElmt.getLength(); j++) {
								if (nodeListeElmt.item(j).getNodeName().equals("Elmt")) {
									final Node nElmt = nodeListeElmt.item(j);
									if (nElmt.getNodeType() == Node.ELEMENT_NODE) {
										Element eElmt = (Element) nElmt;
										int numero = Integer.valueOf(eElmt.getAttribute("num"));
										String nomElmt = eElmt.getAttribute("nom");
										String uniteElmt = eElmt.getAttribute("unite");
										float lngElmt = Float.valueOf(eElmt.getAttribute("lng")).floatValue();
										float larElmt = Float.valueOf(eElmt.getAttribute("lar")).floatValue();
										float hauElmt = Float.valueOf(eElmt.getAttribute("hau")).floatValue();
										int nb = 1;
										if (eElmt.hasAttribute("nb")) {
											nb = Integer.valueOf(eElmt.getAttribute("nb"));
										}

										ArrayList<MATERIAUX> lstMateriaux = new ArrayList<MATERIAUX>();

										// code pour recup materiaux
										final NodeList nodeListeMateriaux = eElmt.getChildNodes();
										for (int z = 0; z < nodeListeMateriaux.getLength(); z++) {
											if (nodeListeMateriaux.item(z).getNodeName().equals("Materiaux")) {
												final Node nMateriaux = nodeListeMateriaux.item(z);
												if (nMateriaux.getNodeType() == Node.ELEMENT_NODE) {
													Element eMateriaux = (Element) nMateriaux;
													MATERIAUX mat = MATERIAUX.valueOf(eMateriaux.getAttribute("type"));
													mat.setPourcent(Integer.valueOf(eMateriaux.getAttribute("pc")));
													lstMateriaux.add(mat);
												}
											}
										}
										Elmt element = new Elmt(numero, nomElmt, nb, uniteElmt, lngElmt, larElmt,
												hauElmt);
										element.setMateriaux(lstMateriaux);
										lstElmt.add(element);

									}
								}
							}
							meuble.setLstElement(lstElmt);
							this.add(meuble);
						}
					}
				}

			}

		} catch (ParserConfigurationException e) {

		} catch (SAXException e) {

		} catch (IOException e) {

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
