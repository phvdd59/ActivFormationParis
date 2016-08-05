package com.formation.soka.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.formation.soka.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.init();
	}

	public void init() {
		File file = new File("./src/com/formation/soka/xml/ListTerme.xml");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		String s = "";
		int posX = 0;
		int posY = 0;
		Point point = null;
		boolean b = false;
		Terme terme = null;
		ArrayList<Terme> lstTerme = new ArrayList<Terme>();
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); //Transforme de bianaire en caractere avec la specificite UTF-8, puis on le recpere en buffer pour pouvoir le lire ligne par ligne. 
			bIn = new BufferedReader(inputStreamReader);
			String line = bIn.readLine();
			while (line != null) {
				if (line.contains("<Terme")) {
					if (line.contains("'HORIZONTAL'")) {
						b = false;
					}
					if (line.contains("'VERTICAL'")) {
						b = true;
					}
					if (line.contains(" x='")) {
						posX = Integer.parseInt(line.substring(line.indexOf("x='") + 3, line.indexOf("x='") + 4));
					}
					if (line.contains(" y='")) {
						posY = Integer.parseInt(line.substring(line.indexOf("y='") + 3, line.indexOf("y='") + 4));
					}
					
					point = new Point(posY, posX);
					terme = new Terme(s, point, b);
					lstTerme.add(terme);

					line = bIn.readLine();
					if (!line.contains(">")) {
						s = line;
					}
					System.out.println(terme);
				}
				line = bIn.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Pas de fichier trouve pour effectuer la lecture");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOOException");
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				System.out.println("Pas ferme");
				e.printStackTrace();
			}
		}
	}
}
