package com.formation.thcr.main;

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

import com.formation.thcr.metier.Terme;

public class MainXmlDom {

	public static void main(String[] args) {
		MainXmlDom main = new MainXmlDom();
		main.init();
	}

	private void init() {

		ArrayList<Terme> listTerme = null;
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File file = new File("./src/com/formation/soka/xml/ListTerme.xml");
		try {

			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			System.out.println(document.getXmlEncoding());
			System.out.println(document.getXmlVersion());

			final Element eListTerme = document.getDocumentElement();
			final NodeList nListTerme = eListTerme.getChildNodes();
			System.out.println(eListTerme.getNodeName());
			if (eListTerme.getNodeName().equals("ListTerme")) {

				listTerme = new ArrayList<Terme>();

				for (int i = 0; i < nListTerme.getLength(); i++) {
					Node nTerme = nListTerme.item(i);
					if (nTerme.getNodeType() == Node.ELEMENT_NODE) {
						Element eTerme = (Element) nTerme;
						System.out.println(eTerme.getNodeName());
						if (eTerme.getNodeName().equals("Terme") && eTerme.hasAttribute("x") && eTerme.hasAttribute("y")
								&& eTerme.hasAttribute("sens") && !eTerme.getTextContent().equals("")) {
							String sX = eTerme.getAttribute("x");
							String sY = eTerme.getAttribute("y");
							String sSens = eTerme.getAttribute("sens");
							String sNom = eTerme.getTextContent();

							int posX = -1;
							int posY = -1;
							boolean sens;
							String nom = null;

							try {

								posX = Integer.valueOf(sX).intValue();
								posY = Integer.valueOf(sY).intValue();
								
								if (sSens.equals("HORIZONTAL")) {
									sens = Terme.HORIZONTAL;
								} else if (sSens.equals("VERTICAL")) {
									sens = Terme.VERTICAL;
								}else{
									throw new SensException();
								}
								if(posX<0 || posY < 0){
									throw new NegatifException();
								}
								String sNomOk = Terme.epuration(sNom);
								if(!sNom.equals(sNomOk)){
									throw new NomException();
								} else{
									nom = sNom;
								}
								listTerme.add(new Terme(nom, new Point(posX, posY), sens));
								//System.out.println(listTerme.get(listTerme.size() - 1));
							} catch (Exception e) {
								System.err.println(e.getMessage());
							}
						}
					}
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		;
	}

}
