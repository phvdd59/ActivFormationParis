package com.formation.emma.main;

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

import com.formation.emma.main.NegatifException;
import com.formation.emma.main.NomException;
import com.formation.emma.main.SensException;
import com.formation.emma.main.Sens;
import com.formation.emma.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		//main.lectureXml();
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
							if (sNom.equals(sNomOk)) {
								throw new NomException();
							}
							lstTerme.add(new Terme(sNom, new Point(x, y), sens));
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

	public void lectureXml() {
		File file = new File("./src/com/formation/emma/xml/ListTermePhva.xml");
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
