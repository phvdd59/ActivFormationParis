package com.formation.phva.dosFlux1.beba;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ListeMeuble extends ArrayList<Meuble> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static TRI tri;

	public void chargeListeMeuble(File fRep) {
	}

	public void chargeXml(File file) {
		// ListeMeu lstTerme = new ListeTerme();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document document = builder.parse(file);
		final Element eListMeuble = document.getDocumentElement();
		final NodeList nListMeuble = eListMeuble.getChildNodes();

		if (eListMeuble.getNodeName().equals("listMeuble")) {
			// lstMeuble = new ArrayList<Meuble>();
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

					} else if (eMeuble.getNodeName().equals("Elmt")) {
						String sNotice = eMeuble.getTextContent();

					} else if (eMeuble.getNodeName().equals("Elmt")) {
						String sType = eMeuble.getAttribute("type");
						String sPc = eMeuble.getAttribute("pc");
					}

					// try {
					// int x = Integer.valueOf(sX).intValue();
					// int y = Integer.valueOf(sY).intValue();
					// boolean sens;
					// if (sSens.equals(Sens.HORIZONTAL.name())) {
					// sens = Terme.HORIZONTAL;
					// } else if (sSens.equals(Sens.VERTICAL.name())) {
					// sens = Terme.VERTICAL;
					// } else {
					// throw new SensException();
					// }
					//
					// if (x < 0 || y < 0) {
					// throw new NegatifException();
					// }
					// String sNomOk = Terme.epuration(sNom);
					// if (!sNom.equals(sNomOk)) {
					// throw new NomException();
					// }
					// Terme terme = new Terme(sNom, new Point(x, y), sens);
					// lstTerme.add(terme);
					// } catch (NumberFormatException | NegatifException |
					// NomException | SensException e) {
					//
					// }
					// }
				}
			}
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
