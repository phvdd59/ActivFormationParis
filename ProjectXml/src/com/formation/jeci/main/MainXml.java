package com.formation.jeci.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
					String nb1 = ligne.substring(ligne.lastIndexOf("x=") + 3, ligne.indexOf("y") - 2);
					String nb2 = ligne.substring(ligne.lastIndexOf("y=") + 3, ligne.indexOf("s") - 2);
					int a = Integer.parseInt(nb1);
					int b = Integer.parseInt(nb2);

					String sens = ligne.substring(ligne.lastIndexOf("s") + 3, ligne.lastIndexOf("'") - 1);
					boolean yolo;
					if (sens.contains("H")) {
						yolo = false;
					} else {
						yolo = true;
					}
					ligne = bIn.readLine();
					String nom = ligne;
					Terme terme = new Terme(nom, new Point(a, b), yolo);

					lst.add(terme);
				}
				ligne = bIn.readLine();

			}
			System.out.println(lst);
		} catch (FileNotFoundException e) {
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
