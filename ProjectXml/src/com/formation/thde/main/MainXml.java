package com.formation.thde.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

import com.formation.etga.exo.NegatifException;
import com.formation.etga.exo.NomException;
import com.formation.etga.exo.Sens;
import com.formation.etga.exo.SensException;
import com.formation.etga.exo.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		//		main.lectureXml();
		main.init();
	}

	public void init() {
		ArrayList<Terme> lstTerme = null;

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File file = new File("./src/com/formation/etga/xml/ListTerme.xml");
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			System.out.println(document.getXmlEncoding());
			System.out.println(document.getXmlVersion());

			final Element eListTerme = document.getDocumentElement();
			final NodeList nListTerme = eListTerme.getChildNodes();
			System.out.println(eListTerme.getNodeName());
			if (eListTerme.getNodeName().equals("ListTerme")) {
				lstTerme = new ArrayList<Terme>();
				for (int i = 0; i < nListTerme.getLength(); i++) {
					final Node nTerme = nListTerme.item(i);
					System.out.println(nListTerme.item(i).getNodeName());
					if (nTerme.getNodeType() == Node.ELEMENT_NODE) {
						final Element eTerme = (Element) nTerme;
						System.out.println(eTerme.getNodeName());
						if (eTerme.getNodeName().equals("Terme")) {
							String sX = eTerme.getAttribute("x");
							String sY = eTerme.getAttribute("y");
							String sSens = eTerme.getAttribute("sens");
							String sNom = eTerme.getTextContent();
							try {
								int x = Integer.valueOf(sX).intValue();
								int y = Integer.parseInt(sX);
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
								Terme terme = new Terme(sNom, new Point(x, y), sens);
								lstTerme.add(terme);
							} catch (NumberFormatException |NegatifException|SensException |NomException e) {	
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

	public void lectureXml() {
		File file = new File("./src/com/formation/phva/xml/ListTerme.xml");
		BufferedReader texte = null;
		String ligneComplete = "";
		int x = -1;
		int y = -1;
		Boolean sens = true;
		String mot = "";
		ArrayList<Terme> liste = null;

		try {
			liste = new ArrayList<Terme>();
			texte = new BufferedReader(new FileReader(file));
			String line = texte.readLine();
			while (line != null) {
				ligneComplete = "";
				x = -1;
				y = -1;
				mot = "";

				if (line.contains("<Terme ")) {
					while (!line.contains("</Terme>")) { // wagon m terme ouvert meme ligne que  terme ferme - rajouter condition + verif wagon g pourquoi pris 
						line = line.replace("\\t+", " ");
						line = line.replaceAll("Terme", " ");
						line = line.replaceAll("\\p{Punct}", " ");
						line = line.replaceAll("\\s+", " ");
						line = line.replaceAll("y ", "y");
						line = line.replaceAll("x ", "x");
						ligneComplete = ligneComplete + " " + line;
						line = texte.readLine();
					}
					if (line.contains("</Terme>")) {
						line = line.replace("\\t+", " ");
						line = line.replaceAll("Terme", " ");
						line = line.replaceAll("\\p{Punct}", " ");
						line = line.replaceAll("\\s+", " ");
						line = line.replaceAll("y ", "y");
						line = line.replaceAll("x ", "x");
						ligneComplete = ligneComplete + " " + line;
					}
					String[] tab = ligneComplete.split(" ");

					for (int i = 0; i < tab.length; i++) {
						if (tab[i].contains("x")) {
							x = Integer.valueOf(tab[i].substring(1, 2));
						} else if (tab[i].contains("y")) {
							y = Integer.valueOf(tab[i].substring(1, 2));
						} else if (tab[i].contains("VERTICAL")) {
							sens = true;
						} else if (tab[i].contains("HORIZONTAL")) {
							sens = false;
						} else if (tab[i].length() == 0) {

						} else if (tab[i].length() != 0) {
							mot = tab[i];
						}
					}
					if (x >= 0 && y >= 0 && mot != "") {
						Terme terme = new Terme(mot, new Point(x, y), sens);
						liste.add(terme);
					}
				} else {
					line = texte.readLine();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				texte.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(liste);
	}

}
