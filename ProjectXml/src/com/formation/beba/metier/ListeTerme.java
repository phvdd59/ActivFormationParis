package com.formation.beba.metier;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListeTerme extends ArrayList<Terme> {

	private static final long serialVersionUID = 1L;

	public ArrayList<Terme> lectureXML(File file) {
		// File file = new File("./src/com/formation/beba/XML/ListeTerme.xml");
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
		String nom = null;
		String posX = "0";
		String posY = "0";
		Point point;
		boolean sens = false;
		boolean termeEnCours = false;
		boolean nomTrouve = false;
		for (int i = 0; i < string.size() - 1; i++) {
			if (termeEnCours) {
				if (!nomTrouve) {
					nom = string.get(i);
				}

				termeEnCours = false;
				if (posX != null && posY != null) {
					if (Integer.valueOf(posX) >= 0 && Integer.valueOf(posY) >= 0) {
						point = new Point(Integer.valueOf(posX), Integer.valueOf(posY));
						terme.add(new Terme(nom, point, sens));
					}
				}

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
				if (string.get(i).length() > string.get(i).lastIndexOf('>') + 1) {
					j = 0;
					boolean encoreDuNom = false;
					while (!encoreDuNom) {
						j++;
						char test=string.get(i).charAt(string.get(i).lastIndexOf('>') + j);
						if ((string.get(i).charAt(lastIndexOf('>') + j) >= 'a' && string.get(i).charAt(lastIndexOf('>') + j) <= 'z') || (string.get(i).charAt(lastIndexOf('>') + j) >= 'A' && string.get(i).charAt(lastIndexOf('>') + j) <= 'Z')) {
							nom = nom.concat(string.get(i).substring(lastIndexOf('>') + j, lastIndexOf('>') + j + 1));
						} else {
							encoreDuNom = true;
							nomTrouve = true;

						}

					}
				}
			}
		}
		System.out.println(terme);
		return terme;
	}
}
