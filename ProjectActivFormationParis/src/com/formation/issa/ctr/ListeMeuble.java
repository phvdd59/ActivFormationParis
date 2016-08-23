package com.formation.issa.ctr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		// ecriture
		// File file=new File(".src/com/formation/issa/ctr/fFile.xml");

	}

	public void chargeXml(File file) {
		// Lecture

		BufferedReader oS = null;
		InputStreamReader input = null;
		ArrayList<Meuble> ListeMeuble = new ArrayList();
		Meuble meuble = new Meuble();
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		File file1 = new File(".src/com/formation/issa/ctr/fFile.xml");
		try {
			final DocumentBuilder builder = dbf.newDocumentBuilder();
			Document document = null;
			try {
				document = builder.parse(file1);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			final Element eListeMeuble=document.getDocumentElement();
			final NodeList nListeMeuble=eListeMeuble.getChildNodes();
			System.out.println(eListeMeuble.getNodeName());
			if(eListeMeuble.getNodeName().equals("ListeMeuble")){
				ListeMeuble=new ArrayList<Meuble>();
				for (int i = 0; i < nListeMeuble.getLength(); i++) {
					final Node nMeuble=nListeMeuble.item(i);
					System.out.println(nListeMeuble.item(i).getNodeName() + " " + nListeMeuble.item(i).getNodeType());
					if (nMeuble.getNodeType() == Node.ELEMENT_NODE) {
						final Element eMeuble = (Element) nMeuble;
						if (eMeuble.getNodeName().equals("Meuble")) {
							String sNom=eMeuble.getAttribute("nom");
							String sRef = eMeuble.getAttribute("ref");
							String sUnite = eMeuble.getAttribute("unite");
							String sLng = eMeuble.getAttribute("lng");
							String sLar=eMeuble.getAttribute("lar");
							String sHau=eMeuble.getAttribute("hau");
							
							float lng=Float.parseFloat(sLng);
							float lar=Float.parseFloat(sLar);
							float hau=Float.parseFloat(sHau);
							
							
					
				}
			}

		}
			}
		}catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			oS = new BufferedReader(new FileReader(file1));
			try {
				String line = oS.readLine();
				ListeMeuble = null;
				while (line != null) {
					if (line.contains("<Meuble ")) {
						if (line.contains("nom=\"")) {
							int debut = line.indexOf("nom=\"");
						    //int fin = line.indexOf(ch, fromIndex)

						}

					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
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
