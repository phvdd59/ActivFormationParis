package com.formation.beba.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.formation.beba.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.lectureXML();
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
				point = new Point(Integer.valueOf(posX), Integer.valueOf(posY));
				terme.add(new Terme(nom, point, sens));
			}

			int posXnb;
			int posYnb;
			if (string.get(i).contains("<Terme")) {
				termeEnCours = true;
				posXnb = string.get(i).indexOf("x") + 3;
				posX = string.get(i).substring(posXnb, posXnb + 1);
				posXnb++;
				while (string.get(i).charAt(posXnb) != '\'') {
					posX = posX.concat(string.get(i).substring(posXnb, posXnb + 1));
					posXnb++;
				}

				posYnb = string.get(i).indexOf("y") + 3;
				posY = string.get(i).substring(posYnb, posYnb + 1);
				posYnb++;
				while (string.get(i).charAt(posYnb) != '\'') {
					posY = posY.concat(string.get(i).substring(posYnb, posYnb + 1));
					posYnb++;
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
