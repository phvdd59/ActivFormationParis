package com.formation.joca.sauvegarde;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

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

	/**
	 * 
	 * @param fRep
	 *            répertoire racine contenant des fichiers dans des sous
	 *            répertoires du type 123456.xml
	 * 
	 */
	public void chargeListeMeuble(File fRep) {
		action(fRep);
	}

	public void action(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				for (int i = 0; i < file.listFiles().length; i++) {
					File sousFichier = file.listFiles()[i];
					action(sousFichier);
				}
			} else if (verifierNom(file)) {
				chargeXml(file);
			} else if (!verifierNom(file)) {
			}
		} else {
			// pas de fichier
		}
	}

	public boolean verifierNom(File file) {
		boolean result = false;
		if (Pattern.matches("[0-9]{6}\\.xml", file.getName())) {
			result = true;
		}
		return result;
	}

	public void chargeXml(File file) {
		String refGen = file.getName().replace(".xml", "");
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			final Element eListmeuble = document.getDocumentElement();
			if (eListmeuble.getNodeName().equals("ListeMeuble")) {
				final NodeList nListmeuble = eListmeuble.getChildNodes();
				int nbMeuble = nListmeuble.getLength();
				for (int i = 0; i < nbMeuble; i++) {
					final Node nMeuble = nListmeuble.item(i);
					if (nMeuble.getNodeType() == Node.ELEMENT_NODE) {
						Element eMeuble = (Element) nMeuble;
						if (eMeuble.getNodeName().equals("Meuble")) {
							String sNom = eMeuble.getAttribute("nom");
							String sRef = eMeuble.getAttribute("ref");
							String sUnite = eMeuble.getAttribute("unite");
							String sLng = eMeuble.getAttribute("lng");
							String sLar = eMeuble.getAttribute("lar");
							String sHau = eMeuble.getAttribute("hau");

							String ref = sRef;
							float lng = Float.valueOf(sLng).floatValue();
							float lar = Float.valueOf(sLar).floatValue();
							float hau = Float.valueOf(sHau).floatValue();
							Meuble meuble = null;
							if (sUnite == null) {
								meuble = new Meuble(tri, sNom, refGen + ref, lng, lar, hau);
							} else {
								meuble = new Meuble(tri, sNom, refGen + ref, sUnite, lng, lar, hau);
							}
							final NodeList nListElement = eMeuble.getChildNodes();
							int nbElement = nListElement.getLength();
							for (int j = 0; j < nbElement; j++) {
								final Node nElement = nListElement.item(j);
								if (nElement.getNodeType() == Node.ELEMENT_NODE) {
									Element eElmt = (Element) nElement;
									if (eElmt.getNodeName().equals("Elmt")) {
										String sNomE = eElmt.getAttribute("nom");
										String sNumE = eElmt.getAttribute("num");
										String sNbE = eElmt.getAttribute("nb");
										String sUniteE = eElmt.getAttribute("unite");
										String sLngE = eElmt.getAttribute("lng");
										String sLarE = eElmt.getAttribute("lar");
										String sHauE = eElmt.getAttribute("hau");
										String nomE = (sNomE == null ? "" : sNomE);
										int numE = Integer.valueOf(sNumE);
										int nbE = Integer.valueOf(((sNbE == null || sNbE.equals("")) ? "1" : sNbE))
												.intValue();
										float lngE = Float.valueOf(sLngE).floatValue();
										float larE = Float.valueOf(sLarE).floatValue();
										float hauE = Float.valueOf(sHauE).floatValue();
										Elmt e = null;
										if (sUniteE == null) {
											e = new Elmt(numE, nomE, nbE, lngE, larE, hauE);
										} else {
											e = new Elmt(numE, nomE, nbE, sUnite, lngE, larE, hauE);
										}
										final NodeList nListMat = eElmt.getChildNodes();
										int nbMat = nListMat.getLength();
										for (int k = 0; k < nbMat; k++) {
											final Node nMat = nListMat.item(k);
											if (nMat.getNodeType() == Node.ELEMENT_NODE) {
												Element eMat = (Element) nMat;
												if (eMat.getNodeName().equals("Materiaux")) {
													String sType = eMat.getAttribute("type");
													String sPc = eMat.getAttribute("pc");
													MATERIAUX mat = null;
													if (sType == null) {
														mat = MATERIAUX.BOIS;
													} else {
														mat = MATERIAUX.valueOf(sType);
													}
													mat.setPourcent(Integer.valueOf(sPc).intValue());
													e.getMateriaux().add(mat);
												}
											}
										}
										meuble.getLstElmt().add(e);
									}
								}
							}
							add(meuble);
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
		} finally {

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
