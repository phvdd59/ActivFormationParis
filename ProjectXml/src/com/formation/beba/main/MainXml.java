package com.formation.beba.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.formation.beba.metier.ListeTerme;
import com.formation.beba.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		// main.lectureXML();
		main.init();
		// main.init2();
	}

	public void init() {
		ArrayList<Terme> lstTerme = null;
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File file = new File("C:/DevFormation/GITActiveFormationParis/ActivFormationParis/ProjectXml/bin/com/formation/beba/XML/ListTerme2.XML");
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			System.out.println(document.getXmlVersion());
			System.out.println(document.getXmlEncoding());

			final Element eListTerme = document.getDocumentElement();
			final NodeList nListTerme = eListTerme.getChildNodes();
			System.out.println(eListTerme.getNodeName());

			if (eListTerme.getNodeName().equals("listTerme")) {
				lstTerme = new ArrayList<Terme>();
				for (int i = 0; i < nListTerme.getLength(); i++) {
					final Node nTerme = nListTerme.item(i);
					if (nTerme.getNodeType() == Node.ELEMENT_NODE) {
						final Element eTerme = (Element) nTerme;
						if (eTerme.getNodeName().equals("Terme")) {
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
								if (sSens.equals(Sens.HORIZONTAL.name())) {
									sens = Terme.HORIZONTAL;
								} else if (sSens.equals(Sens.VERTICAL.name())) {
									sens = Terme.VERTICAL;
								} else {
									throw new sensException();
								}

								if (x < 0 || y < 0) {
									throw new NegatifException();
								}
								String sNomOk = Terme.epuration(sNom);
								if (!sNom.equals(sNomOk)) {
									throw new NomException();
								}
								Terme terme = new Terme(sNom, new Point(x, y), sens);
								lstTerme.add(terme);
							} catch (Exception e) {

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

	public void init2() {
		File file = new File("./src/com/formation/beba/XML/ListeTerme.xml");
		ListeTerme lstTerme = new ListeTerme();

		lstTerme.lectureXML(file);
	}

	public void lectureXML() {
		File file = new File("./src/com/formation/beba/XML/ListeTerme.xml");
		BufferedReader bIn = null;

		ArrayList<String> string = new ArrayList<String>();
		ArrayList<Terme> terme = new ArrayList<Terme>();
		try {
			InputStreamReader inP = new InputStreamReader(new FileInputStream(file), "UTF-8");

			bIn = new BufferedReader(inP);
			String line = bIn.readLine();
			string.add(line);
			while (line != null) {
				System.out.println(line);
				line = bIn.readLine();
				string.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String nom;
		String posX = "0";
		String posY = "0";
		Point point;
		boolean sens = false;
		boolean termeEnCours = false;
		for (int i = 0; i < string.size() - 1; i++) {
			if (termeEnCours) {
				nom = string.get(i);
				termeEnCours = false;
				if (posX != null && posY != null) {
					if (Integer.valueOf(posX) >= 0 && Integer.valueOf(posY) >= 0) {
						point = new Point(Integer.valueOf(posX), Integer.valueOf(posY));
						terme.add(new Terme(nom, point, sens));
					}
				}

				// point = new Point(Integer.valueOf(posX),
				// Integer.valueOf(posY));
				// terme.add(new Terme(nom, point, sens));
			}

			int posXnb;
			int posYnb;
			if (string.get(i).contains("<Terme ")) {
				termeEnCours = true;
				posXnb = string.get(i).indexOf("x");
				posX = null;
				int j = 0;
				boolean trouve = false;
				while (!trouve || string.get(i).charAt(posXnb + j) != '\'') {
					j++;
					if (posXnb + j >= string.get(i).length()) {
						break;
					}
					if (posX == null && (string.get(i).charAt(posXnb + j) >= '0' && string.get(i).charAt(posXnb + j) <= '9')) {
						posX = string.get(i).substring(posXnb + j, posXnb + j + 1);
						trouve = true;
					} else if (string.get(i).charAt(posXnb + j) >= '0' && string.get(i).charAt(posXnb + j) <= '9') {
						posX = posX.concat(string.get(i).substring(posXnb + j, posXnb + j + 1));
					}
				}

				posYnb = string.get(i).indexOf("y");
				posY = null;
				trouve = false;
				j = 0;
				while (!trouve || string.get(i).charAt(posYnb + j) != '\'') {
					j++;
					if (posYnb + j >= string.get(i).length()) {
						break;
					}
					if (posY == null && (string.get(i).charAt(posYnb + j) >= '0' && string.get(i).charAt(posYnb + j) <= '9')) {
						posY = string.get(i).substring(posYnb + j, posYnb + j + 1);
						trouve = true;
					} else if (string.get(i).charAt(posYnb + j) >= '0' && string.get(i).charAt(posYnb + j) <= '9') {
						posY = posY.concat(string.get(i).substring(posYnb + j, posYnb + j + 1));
					}

				}
				if (string.get(i).contains("HORI")) {
					sens = false;
				} else if (string.get(i).contains("VERTIC")) {
					sens = true;
				}

			}
		}
		System.out.println(terme);
	}
}
