package com.formation.jeci.main;

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
import com.formation.phva.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();

		main.init();
		main.init2();

	}

	public void init2() {
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

	private void init() {
		File file = new File("./src/com/formation/jeci/main/ListTerme.xml");

		BufferedReader bIn = null;
		try {

			bIn = new BufferedReader(new FileReader(file));
			String ligne = bIn.readLine();
			ArrayList<Terme> lst = new ArrayList<>();
			while (ligne != null) {
				if (ligne.contains("<Terme ")) {
					String chaineString = ligne;
					while (ligne.contains("</Terme>") == false) {
						chaineString += bIn.readLine();
						ligne = chaineString;

					}
					chaineString = chaineString.replace("\t", " ");
					chaineString = chaineString.replaceAll("\\s+", " ");
					chaineString = chaineString.replace("= ", "=");
					chaineString = chaineString.replace(" =", "=");

					chaineString = chaineString.replace("</Terme>", "");
					String nom = chaineString.substring(chaineString.indexOf(">") + 1);
					nom.replaceAll(" ", "");
					String[] tabMot = chaineString.split(" ");
					int a = 0;
					int b = 0;

					boolean yolo = true;
					for (int i = 0; i < tabMot.length; i++) {
						if (tabMot[i].contains("x=")) {
							String nb1 = tabMot[i].substring(tabMot[i].lastIndexOf("x=") + 3, tabMot[i].length() - 1);
							a = Integer.parseInt(nb1);

						}
						if (tabMot[i].contains("y=")) {
							String nb2 = tabMot[i].substring(tabMot[i].lastIndexOf("y=") + 3, tabMot[i].length() - 1);
							b = Integer.parseInt(nb2);
						}
						if (tabMot[i].contains("VERTICAL")) {
							yolo = true;

						}
						if (tabMot[i].contains("HORIZONTAL")) {
							yolo = false;

						}

					}

					Terme terme = new Terme(nom, new Point(a, b), yolo);

					lst.add(terme);
				}
				ligne = bIn.readLine();

			}
			System.out.println(lst);
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
