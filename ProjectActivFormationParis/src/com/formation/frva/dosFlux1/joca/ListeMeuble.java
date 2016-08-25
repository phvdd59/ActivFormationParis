package com.formation.phva.dosFlux1.joca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
			System.out.println(elmtMeuble);
			final NodeList nodeListeMeuble = elmtMeuble.getChildNodes();
			if (elmtMeuble.getNodeName().equals("ListeMeuble")) {
				for (int i = 0; i < nodeListeMeuble.getLength(); i++) {
					if (nodeListeMeuble.item(i).getNodeName().equals("Meuble")) {

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
