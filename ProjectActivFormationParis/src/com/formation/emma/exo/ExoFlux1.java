package com.formation.emma.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class ExoFlux1 extends ArrayList<Terme> {

	public class Saisie {
		/**
		 * But : Entrer des éléments au clavier pour le mot croisé et les mettre
		 * dans un fichier
		 * 
		 * Eléments à entrer (pour au final, savoir créer un Terme) Saisir un
		 * mot Saisir une position x (début du mot sur la ligne horizontale)
		 * Saisir un position y (début du mot sur la ligne verticale) Saisir le
		 * sens du mot (mot vertical ou mot horizontal)
		 * 
		 * Dans le but de standardiser voici le nom des zones de saisie zone de
		 * saisie du mot : sMot zone de saisie de la position x : sPosX Zone de
		 * saisie de la position y : sPosY Zone de saisie du sens du mot : sSens
		 * 
		 * Plusieurs éléments devront pouvoir être saisis.
		 * 
		 * Créer un fichier dans lequel seront intégrées toutes les informations
		 * saisies.
		 * 
		 * Le nom du ficher est : saisie.json
		 * 
		 * Le fichier se présentera sous la forme : par enregistrement
		 * {"mot":"motsaisi","posX":positionXSaisie,"posY":positionYSaisie,
		 * "sens":true ou false}
		 * 
		 * attention à bien respecter la syntaxe du fichier les {} en début et
		 * fin d'enregistrement les , entre 2 informations les : entre le nom de
		 * la valeur et la valeur en elle-même Les informations fixes
		 * "mot","posX",posY","sens" sont entre "" Les valeurs positions x et y
		 * sont indiquées telles quelles Le sens prend la valeur true ou la
		 * valeur false
		 * 
		 * Exemple de fichier saisie.json
		 * {"mot":"pastille","posX":1,"posY":5,"sens":true}
		 * {"mot":"propre","posX":1,"posY":5,"sens":false}
		 * 
		 * 
		 */

	}

	public void saisie() {
		BufferedReader entréeParamètre = null;
		entréeParamètre = new BufferedReader(new InputStreamReader(System.in));
		String continu = "oui";

		try {
			while (continu.contains("oui")) {
				System.out.println("Saisir sMot:");
				String mot = "";
				while (mot.matches("[a-zA-Z]+") == false) {
					mot = entréeParamètre.readLine();
					if (mot.matches("[a-zA-Z]+") == false) {
						System.out.println("Saisie incorrect, entrer un nouveau mot");
					}
				}

				System.out.println("Saisir sPosX:");
				int posX = -1;
				String sPosX = "";
				while (sPosX.matches("[0-9]+") == false) {
					sPosX = entréeParamètre.readLine();
					if (sPosX.matches("[0-9]+") == false) {
						System.out.println("Saisie incorrect, rentrer à nouveau une valeur pour x");
					}
				}
				posX = Integer.valueOf(sPosX);

				System.out.println("Saisir sPosY:");
				int posY = -1;
				String sPosY = "";
				while (sPosY.matches("[0-9]+") == false) {
					sPosY = entréeParamètre.readLine();
					if (sPosY.matches("[0-9]+") == false) {
						System.out.println("Saisie incorrect, rentrer à nouveau une valeur pour y");
					}
				}
				posY = Integer.valueOf(sPosY);

				System.out.println("Saisir le sens du mot: sSens = 1 pour horizontal ou 2 pour vertical");
				int sSens = -1;
				boolean sens = false;
				while (sSens != 1 || sSens != 2) {
					sSens = Integer.valueOf(entréeParamètre.readLine());
					if (sSens == 1) {
						sens = Terme.HORIZONTAL;
						break;
					} else if (sSens == 2) {
						sens = Terme.VERTICAL;
						break;
					} else {
						System.out.println("Saisie incorrecte");
						System.out.println("Réécrire le sens du mot :  1 pour horizontal ou 2 pour vertical ");
					}
				}
				add(new Terme(mot, new Point(posX, posY), sens));
				System.out.println("Voulez vous continuer ? oui ou non");
				continu = entréeParamètre.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				entréeParamètre.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void save() {
		File file = new File("./src/com/formation/emma/data/saisie.json");
		PrintWriter save = null;

		try {
			save = new PrintWriter(file);
			for (int i = 0; i < this.size(); i++) {
				Terme terme = this.get(i);
				save.write("{\"mot\":" + terme.getNom() + ",\"posX\":" + terme.getPos().x + ",\"posY\":" + terme.getPos().y + ",\"sens\":" + terme.isSens() + "}\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			save.close();
		}
	}

	public void recup() {
		File file = new File("./src/com/formation/emma/data/saisie.json");
		BufferedReader texte = null;
		ArrayList<Terme> liste = null;

		try {
			liste = new ArrayList<Terme>();
			texte = new BufferedReader(new FileReader(file));
			String line = texte.readLine();
			while (line != null) {

				if (line.contains("{") && line.contains("}")) {

					line = line.replaceAll("\"mot\"", " ");
					line = line.replaceAll("\"posX\"", " ");
					line = line.replaceAll("\"posY\"", " ");
					line = line.replaceAll("\"sens\"", " ");
					line = line.replaceAll("\\t+", " ");
					line = line.replaceAll("\\p{Punct}", " ");
					line = line.replaceAll("\\s+", " ");
				}
				String[] tab = line.split(" ");

				String mot = tab[1];
				int posX = Integer.valueOf(tab[2]);
				int posY = Integer.valueOf(tab[3]);

				boolean sens = false;
				if (tab[4].contains("true")) {
					sens = true;
				} else if (tab[4].contains("false")) {
					sens = false;
				}
				Terme terme = new Terme(mot, new Point(posX, posY), sens);
				liste.add(terme);
				line = texte.readLine();
			}

			ExoException1 motCroise = new ExoException1();
			char[][] tableau = motCroise.solution(9, 9, liste);
			for (int i = 0; i < tableau.length; i++) {
				System.out.println(Arrays.toString(tableau[i]));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CruciException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				texte.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
