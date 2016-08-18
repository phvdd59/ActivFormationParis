package com.formation.made.main;

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

import com.formation.phva.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml m = new MainXml();
		m.init();
	}

	private void init() {
		ArrayList<Terme> lstTerme = null;
		Terme terme = null;
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File file = new File("src/com/formation/made/xml/ListTerme.xml");

		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
//			System.out.println(document.getXmlEncoding());
//			System.out.println(document.getXmlVersion());

			final Element eListTerme = document.getDocumentElement();// point d'entree fichier xml. il englobe sa totalité
			System.out.println(document.getDocumentElement());
			final NodeList nListTerme = eListTerme.getChildNodes();
			System.out.println(eListTerme.getNodeName());
			if (eListTerme.getNodeName().equals("ListeTerme")) {
				lstTerme = new ArrayList<Terme>();
				for (int i = 0; i < nListTerme.getLength(); i++) {
					final Node nTerme = nListTerme.item(i);
					System.out.println(nListTerme.item(i).getNodeName());
					if (nTerme.getNodeType() == Node.ELEMENT_NODE) {// différencie
						final Element eTerme = (Element) nTerme;
						if (eTerme.getNodeName().equals("Terme")) {
							System.out.println("je suis la"+eTerme.getNodeName());
							String sX = eTerme.getAttribute("x");
							String sY = eTerme.getAttribute("y");
							String sSens = eTerme.getAttribute("sens");
							String sNom = eTerme.getTextContent();
							try {
								int x = Integer.valueOf(sX).intValue();
								int y = Integer.parseInt(sY);//meme chose que ligne plus haut. pour avoir un integer
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

								String sNomOK = Terme.epuration(sNom);
								if (!sNom.equals(sNomOK)) {
									throw new NomException();
								}
								terme = new Terme(sNom, new Point(x, y), sens);
								lstTerme.add(terme);
								System.out.println(lstTerme);
							} catch (NumberFormatException | NegatifException | SensException | NomException e) {
								// TODO: handle exception
							}
						}

					}
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}