package com.formation.phva.dosFlux1.anfr;

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

	private TRI tri;

	public ListeMeuble(TRI tri) {
		super();
		setTRI(tri);
	}

	public TRI getTRI() {
		return tri;
	}

	public void setTRI(TRI tri) {
		this.tri = tri;
	}

	public void chargeListeMeuble(File fRep) {
	}

	public void chargeXml(File file) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			System.out.println(document.getXmlEncoding());
			System.out.println(document.getXmlVersion());

			final Element eListMeuble = document.getDocumentElement();
			final NodeList nListMeuble = eListMeuble.getChildNodes();
			if (eListMeuble.getNodeName().equals("ListeMeuble")) {
				for (int i = 0; i < nListMeuble.getLength(); i++) {
					final Node nMeuble = nListMeuble.item(i);
					if (nMeuble.getNodeType() == Node.ELEMENT_NODE) {
						Element eMeuble = (Element) nMeuble;
						//System.out.println(eMeuble.getNodeName());
						String nom = eMeuble.getAttribute("nom");
						String ref = eMeuble.getAttribute("ref");
						String unite = eMeuble.getAttribute("unite");
						String lng = eMeuble.getAttribute("lng");
						String lar = eMeuble.getAttribute("lar");
						String hau = eMeuble.getAttribute("hau");
						System.out.println(nom + ref + unite + lng + lar + hau);
					}
				}
			}
		} catch (Exception e) {
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
