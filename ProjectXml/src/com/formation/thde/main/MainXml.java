package com.formation.thde.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.formation.thde.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.initLecture();
	}

	public void initLecture() {
		ArrayList<Terme> lst = new ArrayList<Terme>();
		int x;
		int y;
		String[] split;
		boolean sens = false;
		String nom;

		File file = new File("./src/com/formation/thde/xml/ListTerme.xml");
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(file));
			String line = fileReader.readLine();
			while (line != null) {

				if (line.contains("<Terme")) {
					split = line.split("'");
					x = Integer.valueOf(split[1]);
					y = Integer.valueOf(split[3]);
					if (line.contains("VERTICAL")) {
						sens = true;
					} else if (line.contains("HORIZONTAL")) {
						sens = false;
					}
					line = fileReader.readLine();
					nom = line;
					lst.add(new Terme(nom, new Point(x, y), sens));
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
		System.out.println(lst);
	}
}
