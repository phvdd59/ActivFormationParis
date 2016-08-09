package com.formation.etga.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.formation.phva.exo.Terme;

public class ExoFlux1 extends ArrayList<Terme> {

	public class Saisie {
		/**
		 * But : Entrer des éléments au clavier pour le mot croisé et
		 * les mettre dans un fichier
		 * 
		 * Eléments à entrer (pour au final, savoir créer un Terme)
		 * Saisir un mot Saisir une position x (début du mot sur la
		 * ligne horizontale) Saisir un position y (début du mot sur la
		 * ligne verticale) Saisir le sens du mot (mot vertical ou mot
		 * horizontal)
		 * 
		 * Dans le but de standardiser voici le nom des zones de saisie
		 * zone de saisie du mot : sMot zone de saisie de la position x
		 * : sPosX Zone de saisie de la position y : sPosY Zone de
		 * saisie du sens du mot : sSens
		 * 
		 * Plusieurs éléments devront pouvoir être saisis.
		 * 
		 * Créer un fichier dans lequel seront intégrées toutes les
		 * informations saisies.
		 * 
		 * Le nom du ficher est : saisie.json
		 * 
		 * Le fichier se présentera sous la forme : par enregistrement
		 * {"mot":"motsaisi","posX":positionXSaisie,"posY":
		 * positionYSaisie,"sens":true ou false}
		 * 
		 * attention à bien respecter la syntaxe du fichier les {} en
		 * début et fin d'enregistrement les , entre 2 informations les
		 * : entre le nom de la valeur et la valeur en elle-même Les
		 * informations fixes "mot","posX",posY","sens" sont entre ""
		 * Les valeurs positions x et y sont indiquées telles quelles Le
		 * sens prend la valeur true ou la valeur false
		 * 
		 * Exemple de fichier saisie.json
		 * {"mot":"pastille","posX":1,"posY":5,"sens":true}
		 * {"mot":"propre","posX":1,"posY":5,"sens":false}
		 * 
		 * 
		 */

	}

	public void saisie() {
		BufferedReader bInStr = null;
		bInStr = new BufferedReader(new InputStreamReader(System.in));

		boolean continu = true;
		String sMot = null, sSens = "", sContinu = "";
		int sPosX = -1, sPosY = -1;
		boolean sens = false;

		while (continu == true) {
			continu = false;
			sMot = null;
			sPosX = -1;
			sPosY = -1;
			sSens = "";
			sContinu = "";
			sens = false;
			System.out.println("Je vais vous guider pour rentrer des termes");
			try {
				while (sMot == null) {
					System.out.println("Entrer un mot");
					epuration(sMot);
					sMot = bInStr.readLine();
				}
				while (sPosX < 0) {
					System.out.println("Entrer une position en X");
					sPosX = Integer.valueOf(bInStr.readLine());
				}
				while (sPosY < 0) {
					System.out.println("Entrer une position en Y");
					sPosY = Integer.valueOf(bInStr.readLine());
				}
				while (sSens.equals("HORIZONTAL") == false && sSens.equals("VERTICAL") == false) {
					System.out.println("Entrer un sens : HORIZONTAL ou VERTICAL");
					sSens = bInStr.readLine();
				}
				if (sSens.equals("VERTICAL")) {
					sens = true;
				} else if (sSens.equals("HORIZONTAL")) {
					sens = false;
				}

				Point point = new Point(sPosX, sPosY);
				Terme terme = new Terme(sMot, point, sens);
				this.add(terme); // la class est deja une ArrayList, on ajoute direct les termes dedans

				while (sContinu.equals("OUI") == false && sContinu.equals("NON") == false) {
					System.out.println("Voulez vous entrer un autre terme? OUI ou NON");
					sContinu = bInStr.readLine();
				}
				if (sContinu.equals("OUI")) {
					continu = true;
				} else if (sContinu.equals("NON")) {
					continu = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void save() {
		File file = new File("./src/com/formation/etga/data/saisie.json");
		PrintWriter out = null;
		try {
			System.out.println("Le fichier a été créé dans le repertoire : " + file.getCanonicalPath());
			out = new PrintWriter(file);
			for (int i = 0; i < this.size(); i++) {
				out.println("{\"mot\" : " + this.get(i).getNom() + " , " + "\"posX\" : " + (int) this.get(i).getPos().getX() + " , " + "\"posY\" : " + (int) this.get(i).getPos().getY() + " , " + "\"sens\" : " + this.get(i).isSens() + "}");
			}
		} catch (IOException e) {
			System.out.println("La sauvegarde est un échec");
		} finally {
			out.close();
		}
	}

	public void recup() {

		File file = new File("./src/com/formation/etga/data/saisie.json");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bIn = new BufferedReader(inputStreamReader);
			String line = bIn.readLine();

			while (line != null) {
				line = line.replace("{\"mot\" : ", "");
				line = line.replace(" , \"posX\" : ", " ");
				line = line.replace(" , \"posY\" : ", " ");
				line = line.replace(" , \"sens\" : ", " ");
				line = line.replace("}", "");

				String[] tabLine = line.split(" ");
				boolean sens = false;
				int x = Integer.valueOf(tabLine[1]);
				int y = Integer.valueOf(tabLine[2]);
				String nom = tabLine[0];

				if (tabLine[3].equals("false")) {
					sens = false;
				} else {
					sens = true;
				}

				Terme terme = new Terme(nom, new Point(x, y), sens);
				add(terme);
				System.out.println(terme);

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
	}

	public String epuration(String txt) {
		String sRet = "";
		if (txt != null) {
			char[] tab = txt.trim().toLowerCase().toCharArray();
			for (int i = 0; i < tab.length; i++) {
				int v = tab[i];
				if (v >= 'à' && v <= 'å') {
					sRet += "a";
				} else if (v >= 'ç' && v <= 'ç') {
					sRet += "c";
				} else if (v >= 'è' && v <= 'ë') {
					sRet += "e";
				} else if (v >= 'ì' && v <= 'ï') {
					sRet += "i";
				} else if (v >= 'ò' && v <= 'ö') {
					sRet += "o";
				} else if (v >= 'ù' && v <= 'ü') {
					sRet += "u";
				} else if (v >= 'ý' && v <= 'ý') {
					sRet += "y";
				} else if (v >= 'a' && v <= 'z') {
					sRet += (char) v;
				} else {
					if (i != 0 && !sRet.substring(sRet.length() - 1).equals(" ")) {
						sRet += " ";
					}
				}
			}
		}
		return sRet.trim().toUpperCase();
	}
}
