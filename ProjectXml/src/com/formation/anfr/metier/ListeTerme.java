package com.formation.anfr.metier;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListeTerme extends ArrayList<Terme> {

	public void readAndStore(String path) throws IOException {
		// "./src/com/formation/anfr/xml/ListeTerme.xml"
		File file = new File(path);
		BufferedReader bIn = null;
		ArrayList<Terme> lst = new ArrayList<Terme>();
		try {

			InputStreamReader input = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bIn = new BufferedReader(input);
			String line = bIn.readLine();
			int posx = -1;
			int posy = -1;

			String entree = null;
			while (line.contains("</ListTerme>") == false) {
				boolean sens = false;
				boolean haveX = false;
				boolean haveY = false;
				boolean haveSens = false;
				Terme terme = null;
				if (line.contains("<Terme ")) {
					entree = line;
					while (entree.contains("</Terme>") == false) {
						line = bIn.readLine();
						entree += line;
					}
					line = bIn.readLine();
					if (entree.contains("x=")) {
						String position = "";
						String lol = entree.substring(entree.indexOf("x=") + 2);
						char[] tab = lol.trim().toCharArray();
						char breaker = tab[0];
						for (int i = 1; i < tab.length - 1; i++) {
							if ((tab[i] >= '0') && (tab[i] <= '9')) {
								position += tab[i];
							} else if (tab[i] == breaker) {
								break;
							}
						}
						posx = Integer.valueOf(position);
						haveX = true;
					}
					if (entree.contains("y=")) {
						String position = "";
						String lol = entree.substring(entree.indexOf("y=") + 2);
						char[] tab = lol.trim().toCharArray();
						char breaker = tab[0];
						for (int i = 1; i < tab.length - 1; i++) {
							if ((tab[i] >= '0') && (tab[i] <= '9')) {
								position += tab[i];
							} else if (tab[i] == breaker) {
								break;
							}
						}
						posy = Integer.valueOf(position);
						haveY = true;
					} else if (entree.contains("y = ")) {
						String position = "";
						String lol = entree.substring(entree.indexOf("y = ") + 4);
						char[] tab = lol.trim().toCharArray();
						char breaker = tab[0];
						for (int i = 1; i < tab.length - 1; i++) {
							if ((tab[i] >= '0') && (tab[i] <= '9')) {
								position += tab[i];
							} else if (tab[i] == breaker) {
								break;
							}
						}
						posy = Integer.valueOf(position);
						haveY = true;
					}
					if (entree.contains("sens=")) {
						if (entree.contains("VERTICAL")) {
							sens = true;
							haveSens = true;
						} else if (entree.contains("HORIZONTAL")) {
							haveSens = true;
						}

					}
					Point p = new Point(posx, posy);

					String extraitMot = entree.substring(entree.indexOf(">"), entree.lastIndexOf("<"));
					String mot = "";
					char[] tab2 = extraitMot.trim().toCharArray();
					for (char c : tab2) {
						if ((c >= 'A') && (c <= 'Z')) {
							mot += c;
						}
					}
					if (haveX && haveY && haveSens) {
						terme = new Terme(mot, p, sens);
						this.add(terme);
					}

					// char[] tab = mot.trim().toCharArray();
				} else {
					line = bIn.readLine();
				}

			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			bIn.close();
		}
	}
}
