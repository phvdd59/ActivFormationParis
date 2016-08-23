package com.formation.soka.main;

import java.awt.Point;
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

import com.formation.soka.exception.NegatifException;
import com.formation.soka.exception.NomException;
import com.formation.soka.exception.SensException;
import com.formation.soka.metier.Sens;
import com.formation.soka.metier.Terme;

public class MainDOM {

	public static void main(String[] args) {
		MainDOM m = new MainDOM();
		m.init();

	}

	public void init() {
		ArrayList<Terme> lstTerme = null;
		Terme terme = null;
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File file = new File("./src/com/formation/soka/xml/ListTerme.xml");
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			System.out.println(document.getXmlEncoding());
			System.out.println(document.getXmlVersion());

			final Element eListeTerme = document.getDocumentElement();
			final NodeList nListeTerme = eListeTerme.getChildNodes();
			System.out.println(eListeTerme.getNodeName());
			if (eListeTerme.getNodeName().equals("ListTerme")) {
				lstTerme = new ArrayList<Terme>();
				for (int i = 0; i < nListeTerme.getLength(); i++) {
					final Node nTerme = nListeTerme.item(i);
					System.out.println(nListeTerme.item(i).getNodeName() + " " + nListeTerme.item(i).getNodeType());
					if (nTerme.getNodeType() == Node.ELEMENT_NODE) {
						final Element eTerme = (Element) nTerme;
						System.out.println(eTerme.getNodeName());
						if (nTerme.getNodeName().equals("Terme")) {
							String sX = eTerme.getAttribute("x");
							String sY = eTerme.getAttribute("y");
							String sSens = eTerme.getAttribute("sens");
							String sNom = eTerme.getTextContent();
							try {
								int x = Integer.valueOf(sX).intValue();
								int y = Integer.valueOf(sY).intValue();
								boolean sens;
								if (sSens.equals(Sens.HORIZONTAL.name())) {
									sens = Terme.HORIZONTAL;
								} else if (sSens.equals(Sens.VERTICAL.name())) {
									sens = Terme.VERTICAL;
								} else {
									throw new SensException();
								}
								if (x < 0 || y < 0) {
									throw new NegatifException();
								}
								String sNomOk = Terme.epuration(sNom);
								if (!sNom.equals(sNomOk)) {
									throw new NomException();
								}
								terme = new Terme(sNom, new Point(x, y), sens);
								lstTerme.add(terme);
							} catch (NumberFormatException | NegatifException | SensException | NomException e) {

							}
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
}
