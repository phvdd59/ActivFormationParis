package com.formation.jeci.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.formation.phva.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();

		main.init();
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
