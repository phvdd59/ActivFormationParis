package com.formation.etga.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.formation.thde.metier.Terme;

public class MainXml extends ArrayList<Terme> {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.lectureXml();
	}

	public void lectureXml() {

		File fileXml = new File("./src/com/formation/phva/xml/ListTerme.xml");
		BufferedReader fileLect = null;
		int x;
		int y;
		boolean sens = false;
		String nom;
		String[] tabValeur;

		try {
			fileLect = new BufferedReader(new InputStreamReader(new FileInputStream(fileXml), "UTF-8"));
			String line = fileLect.readLine();

			while (line != null) {
				while (line.contains("</") == false) {
					line = line.concat(fileLect.readLine());
				}

				if ((line.contains("<Terme ") && line.contains("x=") && line.contains("y=")) || (line.contains("<Terme ") && line.contains("x =") && line.contains("y =")) || (line.contains("<Terme ") && line.contains("x=") && line.contains("y =")) || (line.contains("<Terme ") && line.contains("x =") && line.contains("y="))) {
					line = line.replace("\"", "'");
					tabValeur = line.split("'");
					if ((tabValeur[0].contains("x=") && tabValeur[2].contains("y=")) || (tabValeur[0].contains("x =") && tabValeur[0].contains("y =")) || (tabValeur[0].contains("x=") && tabValeur[2].contains("y =")) || (tabValeur[0].contains("x =") && tabValeur[0].contains("y="))) {
						x = Integer.valueOf(tabValeur[1]);
						y = Integer.valueOf(tabValeur[3]);
					} else {
						x = Integer.valueOf(tabValeur[3]);
						y = Integer.valueOf(tabValeur[1]);
					}
					if (tabValeur[5].contains("VERTICAL")) {
						sens = true;
					} else if (tabValeur[5].contains("HORIZONTAL")) {
						sens = false;
					}
					tabValeur[6] = tabValeur[6].replace("<", "'");
					tabValeur[6] = tabValeur[6].replace(">", "'");
					tabValeur[6] = tabValeur[6].replace("\t\t", "");
					tabValeur[6] = tabValeur[6].replace("\t", "");
					tabValeur[6] = tabValeur[6].replace("\n", "");
					nom = tabValeur[6].split("'")[1];
					this.add(new Terme(nom, new Point(y, x), sens));
					line = fileLect.readLine();
				} else {
					line = fileLect.readLine();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileLect.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
