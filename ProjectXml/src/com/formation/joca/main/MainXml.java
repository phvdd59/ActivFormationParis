package com.formation.joca.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.formation.joca.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.lectureXml();
	}

	public void lectureXml() {
		File fichier = new File(
				"C:/DevFormation/ActivFormationParis/ProjectXml/src/com/formation/joca/xml/ListeTerme.xml");
		BufferedReader bIn = null;
		ArrayList<Terme> lst = new ArrayList<Terme>();
		Terme terme = null;

		try {
			InputStreamReader input = new InputStreamReader(new FileInputStream(fichier), "UTF-8");
			bIn = new BufferedReader(input);
			String line = bIn.readLine();
			String sens = "";
			boolean trouve = false;
			while (line != null) {
				System.out.println(line);
				if (line.contains("<Terme ")) {
					terme = new Terme();
					trouve = true;
					String posX = line.substring(line.lastIndexOf("x=") + 3, line.lastIndexOf("y=") - 2);
					String posY = line.substring(line.lastIndexOf("y=") + 3, line.lastIndexOf("sens=") - 2);
					Point pos = new Point(Integer.parseInt(posX), Integer.parseInt(posY));
					terme.setPos(pos);
					sens = line.substring(line.lastIndexOf("s") + 3, line.lastIndexOf("'"));
					if (sens.equals("VERTICAL")) {
						terme.setSens(Terme.VERTICAL);
					} else if (sens.equals("HORIZONTAL")) {
						terme.setSens(Terme.HORIZONTAL);
					}
				} else if (trouve) {
					terme.setNom(line);
					trouve = false;
					lst.add(terme);
					System.out.println(terme.toString());

				}
				line = bIn.readLine();
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
		for (Terme huhu : lst) {
			System.out.println(huhu.toString());
		}
	}

}
