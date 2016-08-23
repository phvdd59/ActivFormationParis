package com.formation.beba.data;

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
		String sNom;
		String sRef;
		String sUnite;
		float sLng;
		float sLar;
		float sHau;
		String sNotice;
		String sType;
		String sPc;

		if (eListMeuble.getNodeName().equals("listMeuble")) {
			// lstMeuble = new ArrayList<Meuble>();
			for (int i = 0; i < nListMeuble.getLength(); i++) {
				final Node nMeuble = nListMeuble.item(i);
				if (nMeuble.getNodeType() == Node.ELEMENT_NODE) {
					final Element eMeuble = (Element) nMeuble;
					if (eMeuble.getNodeName().equals("Meuble")) {
						sNom = eMeuble.getAttribute("nom");
						sRef = eMeuble.getAttribute("ref");
						sUnite = eMeuble.getAttribute("unite");
						sLng = Float.parseFloat(eMeuble.getAttribute("lng"));
						sLar = eMeuble.getAttribute("lar");
						sHau = eMeuble.getAttribute("hau");

					} 
					if (eMeuble.getNodeName().equals("Elmt")) {
						sNotice = eMeuble.getTextContent();

					}
					if (eMeuble.getNodeName().equals("Elmt")) {
						sType = eMeuble.getAttribute("type");
						sPc = eMeuble.getAttribute("pc");
					}
					Meuble meuble = new Meuble(tri,sNom, //
							sRef, sUnite, float longueur, 
							//float largeur, float hauteur);
					this.add(meuble);

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
