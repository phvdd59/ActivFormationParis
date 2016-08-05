package com.formation.ambr.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.formation.ambr.metier.Terme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.lectureXml();
	}

	public void lectureXml() {
		File file = new File("./src/com/formation/phva/xml/ListTerme.xml");
		// flux caractère input -> reader
		BufferedReader br = null;
		try {
			ArrayList<Terme> lst = new ArrayList<Terme>();
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				if (repereBaliseTerme(line) == true) {
					if (repereX(line) == true && repereY(line) == true && repereSens(line) == true && line.contains("VERTICAL")) {
						String a = line.trim();
						String nextline = br.readLine();
						String b = nextline.trim();
						String nom = new String(b);

						boolean sens = true; // true : VERTICAL

						char[] tabChar = a.toCharArray();
						int i = a.indexOf("x");
						int x = Character.getNumericValue(tabChar[i + 3]);
						int j = a.indexOf("y");
						int y = Character.getNumericValue(tabChar[j + 3]);
						Point pos = new Point(x, y);

						Terme terme = new Terme(nom, pos, sens);
						lst.add(terme);

					}
					if (repereX(line) == true && repereY(line) == true && repereSens(line) == true && line.contains("HORIZONTAL")) {
						String a = line.trim();
						String nextline = br.readLine();
						String b = nextline.trim();
						String nom = new String(b);

						boolean sens = false; // false : HORIZONTAL

						char[] tabChar = a.toCharArray();
						int i = a.indexOf("x");
						int x = Character.getNumericValue(tabChar[i + 3]);
						int j = a.indexOf("y");
						int y = Character.getNumericValue(tabChar[j + 3]);
						Point pos = new Point(x, y);

						Terme terme = new Terme(nom, pos, sens);
						lst.add(terme);

					}
				}
				System.out.println(line);
				line = br.readLine();
			}
			System.out.println(lst);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean repereBaliseTerme(String line) {
		boolean baliseTermePresente = false;
		if (line.contains("<Terme")) {
			baliseTermePresente = true;
		} else {
			baliseTermePresente = false;
		}
		return baliseTermePresente;
	}

	public boolean repereX(String line) {
		boolean xPresent = false;
		if (line.contains("x")) {
			xPresent = true;
		} else {
			xPresent = true;
		}
		return xPresent;
	}

	public boolean repereY(String line) {
		boolean yPresent = false;
		if (line.contains("y")) {
			yPresent = true;
		} else {
			yPresent = true;
		}
		return yPresent;
	}

	public boolean repereSens(String line) {
		boolean sensPresent = false;
		if (line.contains("sens")) {
			sensPresent = true;
		} else {
			sensPresent = true;
		}
		return sensPresent;
	}
}
