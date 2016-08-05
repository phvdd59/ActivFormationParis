package com.formation.emma.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.formation.emma.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.lectureXml();
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
				if (line.contains("<Terme")) {
					while (!line.contains("</Terme>")) {  // wagon m terme ouvert meme ligne que  terme ferme - rajouter condition + verif wagon g pourquoi pris 
						line = line.replace("\\t+", " ");
						line = line.replaceAll("\\p{Punct}", " ");
						line = line.replaceAll("\\s+", " ");
						line = line.replaceAll("y ", "y");
						line = line.replaceAll("x ", "x");
						ligneComplete = ligneComplete + " " + line;
						line = texte.readLine();
					}
					String[] tab = ligneComplete.split(" ");
					ligneComplete = "";
					x = -1;
					y = -1;
					mot = "";
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

						} else if (tab[i].length() != 0 && tab[i] != "TERME") {
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
