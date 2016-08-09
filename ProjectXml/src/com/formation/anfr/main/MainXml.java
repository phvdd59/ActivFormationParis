package com.formation.anfr.main;

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

import com.formation.anfr.exeption.NegatifException;
import com.formation.anfr.exeption.NomException;
import com.formation.anfr.exeption.SensException;
import com.formation.anfr.metier.ListeTerme;
import com.formation.anfr.metier.Terme;

public class MainXml {

	public static void main(String[] args) throws IOException {
		MainXml main = new MainXml();
		main.initDOM();
	}

	private void initDOM() {
		ArrayList<Terme> lstTerme = null;
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File file = new File("./src/com/formation/anfr/xml/ListeTerme.xml");
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			System.out.println(document.getXmlEncoding());
			System.out.println(document.getXmlVersion());

			final Element eListTerme = document.getDocumentElement();
			final NodeList nListTerme = eListTerme.getChildNodes();
			if (eListTerme.getNodeName().equals("ListeTerme")) {
				lstTerme = new ArrayList<Terme>();
				for (int i = 0; i < nListTerme.getLength(); i++) {
					final Node nTerme = nListTerme.item(i);
					if (nTerme.getNodeType() == Node.ELEMENT_NODE) {
						Element eTerme = (Element) nTerme;
						System.out.println(eTerme.getNodeName());
						String sX = eTerme.getAttribute("x");
						String sY = eTerme.getAttribute("y");
						String sSens = eTerme.getAttribute("sens");
						String sNom = eTerme.getTextContent();
						System.out.println(sX + sY + sSens + sNom);
						try {
							int x = Integer.valueOf(sX).intValue();
							int y = Integer.valueOf(sY).intValue();
							boolean sens;
							if (sSens.equals(Sens.HORIZONTAL.name())){
								sens=Terme.HORIZONTAL;
							} else if (sSens.equals(Sens.VERTICAL.name())){
								sens=Terme.VERTICAL;
							} else{
								throw new SensException();
							}
							if (x<0 || y<0) {
								throw new NegatifException();
							}
							String sNomOk = Terme.epuration(sNom);
							if (sNom.equals(sNomOk)){
								throw new NomException();
							}
							lstTerme.add(new Terme(sNom,new Point(x, y),sens));
						} catch (Exception e) {
							// TODO: handle exception
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
		} finally {

		}
	}

	private void initLecture() throws IOException {
		ListeTerme lst = new ListeTerme();
		lst.readAndStore("./src/com/formation/anfr/xml/ListTerme.xml");
		System.out.println(lst.toString());
	}
}
