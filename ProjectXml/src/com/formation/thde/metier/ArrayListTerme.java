package com.formation.thde.metier;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListTerme extends ArrayList<Terme> {

	private String path;

	public ArrayListTerme() {
		path = "./src/com/formation/thde/xml/ListTerme.xml";
	}

	public ArrayListTerme(String path) {
		this.path = path;
	}

	public void lecture() {
		int x;
		int y;
		String[] split;
		boolean sens = false;
		String nom;
		String line;

		File file = new File(path);
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(file));
			line = fileReader.readLine();
			line = fileReader.readLine();
			while (line != null) {
				while (line.contains("</") == false) {
					line = line.concat(fileReader.readLine());
				}

				if ((line.contains("<Terme ") && line.contains("x=") && line.contains("y=")) || (line.contains("<Terme ") && line.contains("x =") && line.contains("y =")) || (line.contains("<Terme ") && line.contains("x=") && line.contains("y ="))
						|| (line.contains("<Terme ") && line.contains("x =") && line.contains("y="))) {
					line = line.replace("\"", "'");
					split = line.split("'");
					if ((split[0].contains("x=") && split[2].contains("y=")) || (split[0].contains("x =") && split[0].contains("y =")) || (split[0].contains("x=") && split[2].contains("y =")) || (split[0].contains("x =") && split[0].contains("y="))) {
						x = Integer.valueOf(split[1]);
						y = Integer.valueOf(split[3]);
					} else {
						x = Integer.valueOf(split[3]);
						y = Integer.valueOf(split[1]);
					}
					if (split[5].contains("VERTICAL")) {
						sens = true;
					} else if (split[5].contains("HORIZONTAL")) {
						sens = false;
					}
					split[6] = split[6].replace("<", "'");
					split[6] = split[6].replace(">", "'");
					split[6] = split[6].replace("\t\t", "");
					split[6] = split[6].replace("\t", "");
					split[6] = split[6].replace("\n", "");
					nom = split[6].split("'")[1];
					this.add(new Terme(nom, new Point(y, x), sens));
					line = fileReader.readLine();
				} else {
					line = fileReader.readLine();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
