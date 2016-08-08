package com.formation.issa.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.formation.issa.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml mainXml = new MainXml();
		mainXml.initlectureXml();
	}

	public void initlectureXml() {
		File file = new File("./src/com/formation/issa/xml/ListeTerme.xml");
		BufferedReader lm = null;

		try {
			lm = new BufferedReader(new FileReader(file));
			try {
				String line = lm.readLine();
				int x = 0;
				int y = 0;
				boolean sens = false;
				String isens = null;
				String nom = null;
				ArrayList<Terme> listeTermes = null;
				while (line != null) {
					if (line.contains("<Terme ")) {
						if (line.contains("sens='")) {
							int indDebut = line.indexOf("sens='");
							int indFin = line.indexOf("'", indDebut + 6);
							isens = line.substring(indDebut + 6, indFin);
							System.out.println("sens= " + isens);
							if (isens == "VERTICAL") {
								sens = true;
							} else {
								sens = false;
							}
						}

						char[] charTab = line.toCharArray();
						for (int i = 0; i < charTab.length; i++) {
							// System.out.println(charTab[i]);
							if (charTab[i] == 'x') {
								int coordX = (int) charTab[i + 3];
								String indiceFX = String.valueOf(charTab[i + 3]);
								x = Integer.parseInt(indiceFX);
								System.out.println("coordX= " + x);
							} else if (charTab[i] == 'y') {
								int coordY = (int) charTab[i + 3];
								String indiceFY = String.valueOf(charTab[i + 3]);
								y = Integer.parseInt(indiceFY);
								System.out.println("coordY= " + y);
							}
						}

						while (line.contains("</") == false) {
							line = line.concat(lm.readLine());
						}
						line = line.replace("\t+", " ");
						line = line.replaceAll("\\s+", " ");
						line.replaceAll("\\p{Punct}", " ");
						char[] tabNom = line.toCharArray();
						for (int i = 0; i < tabNom.length; i++) {
							if (tabNom[i] == '>') {
								int debutNom = tabNom[i + 2];
								int finNom = tabNom[i + 6];
								int entree = line.indexOf(debutNom);
								int fin = line.indexOf(finNom);
								nom = line.substring(entree, fin + 1);
								System.out.println("nom= " + nom);
								if (x >= 0 && y >= 0 && nom != " ") {
									Terme terme = new Terme(nom, new Point(x, y), sens);
									listeTermes.add(terme);

								}

							}

						}

						System.out.println(listeTermes);
					} else {

						System.out.println(line);
						line = lm.readLine();
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				lm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
