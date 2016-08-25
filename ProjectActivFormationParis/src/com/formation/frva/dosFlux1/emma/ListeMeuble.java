package com.formation.phva.dosFlux1.emma;

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

import com.formation.emma.metier.Terme;

public class ListeMeuble extends ArrayList<Meuble> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static TRI tri;

	public void chargeListeMeuble(File fRep) {
	}

	public void chargeXml(File file) {

		BufferedReader texte = null;
		String ligneMeuble = "";
		String ligneElmt = "";
		String ligneNotice = "";
		//		int x = -1;
		//		int y = -1;
		
		//		String mot = "";
		ArrayList<Meuble> liste = null;

//		try {
			liste = new ArrayList<Meuble>();
			texte = new BufferedReader(new FileReader(file));
			String line = texte.readLine();
			while (line != null) {
				ligneMeuble = "";
				ligneElmt = "";
				ligneNotice = "";
				//				x = -1;
				//				y = -1;
				//				mot = "";

				if (line.contains("<Meuble ")) {
					while (!line.contains("</Meuble>")) {
						if (line.contains("<Elmt")) {
							while (!line.contains("</Elmt>")) {
								line = line.replace("\\t+", " ");
								line = line.replaceAll("Elmt", " ");
								line = line.replaceAll("\\p{Punct}", " ");
								line = line.replaceAll("\\s+", " ");

								ligneElmt = ligneElmt + " " + line;
								line = texte.readLine();
							}
							String[] tabElmt = ligneElmt.split(" ");
							
							
						} else if (line.contains("<notice>")) {
							while (!line.contains("</notice>")) {
								line = line.replace("\\t+", " ");
								line = line.replaceAll("Notice", " ");
								line = line.replaceAll("\\p{Punct}", " ");
								line = line.replaceAll("\\s+", " ");

								ligneNotice = ligneNotice + " " + line;
								line = texte.readLine();
							}
						}else{

							line = line.replace("\\t+", " ");
							line = line.replaceAll("Meuble", " ");
							line = line.replaceAll("\\p{Punct}", " ");
							line = line.replaceAll("\\s+", " ");

							ligneMeuble = ligneMeuble + " " + line;
							line = texte.readLine();
						}
					}

					String[] tabMeuble = ligneMeuble.split(" ");

//					for (int i = 0; i < tabMeuble.length; i++) {
//						if (tabMeuble[i].contains("x")) {
//							x = Integer.valueOf(tabMeuble[i].substring(1, 2));
//						} else if (tabMeuble[i].contains("y")) {
//							y = Integer.valueOf(tabMeuble[i].substring(1, 2));
//						} else if (tabMeuble[i].contains("VERTICAL")) {
//							sens = true;
//						} else if (tabMeuble[i].contains("HORIZONTAL")) {
//							sens = false;
//						} else if (tabMeuble[i].length() == 0) {
//
//						} else if (tabMeuble[i].length() != 0) {
//							mot = tabMeuble[i];
//						}
//					}
//					if (x >= 0 && y >= 0 && mot != "") {
//						Terme terme = new Terme(mot, new Point(x, y), sens);
//						liste.add(terme);
//					}
//				} else {
//					line = texte.readLine();
//				}
//			}

//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				texte.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(liste);
//	}

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
