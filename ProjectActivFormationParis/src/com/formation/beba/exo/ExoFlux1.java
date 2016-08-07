package com.formation.beba.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		BufferedReader bInStr = null;
		bInStr = new BufferedReader(new InputStreamReader(System.in));
		Point coord;

		System.out.println("Nous allons à présent créer des Termes!");
		String sortie = "t";
		while (sortie != "NON") {

			String nom = null;
			System.out.println("Entrer le nom du terme sMot");
			try {
				nom = bInStr.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			boolean posXbool = false;
			boolean posYbool = false;

			int posX = -10;
			while (!posXbool) {

				System.out.println("Entrer la position en X sPosX");
				try {
					posX = Integer.valueOf(bInStr.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (posX < 0) {
					System.out.println("ça va pas pour une coordonée");
				} else {
					posXbool = true;
				}
			}

			int posY = -10;
			while (!posYbool) {

				System.out.println("Entrer la position en y sPosY");
				try {
					posY = Integer.valueOf(bInStr.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (posY < 0) {
					System.out.println("ça va pas pour une coordonée");
				} else {
					posYbool = true;
				}
			}

			coord = new Point(posX, posY);

			boolean sensProv = false;
			boolean sens = false;
			while (!sensProv) {
				int sensDuMot = 0;
				System.out.println("Indiquer le sens du mot sSens: HORIZONTAL taper 1 ou VERTICAL taper 2");
				try {
					sensDuMot = Integer.valueOf(bInStr.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (sensDuMot == 1) {
					sens = Terme.HORIZONTAL;
				} else if (sensDuMot == 2) {
					sens = Terme.VERTICAL;
				} else {
					System.out.println("ça va pas comme sens");
				}
			}
			this.add(new Terme(nom, coord, sens));
			System.out.println("Un nouveau Terme vient d'être produit et ajouté à la liste: " + get(this.size() - 1));

			System.out.println();
			System.out.println("Souhaitez-vous rentrer un autre terme? Si non taper NON");
			try {
				sortie = bInStr.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void save() {
		File file = new File("./src/com/formation/beba/data/lstDeTermeJson.json");
		PrintWriter ecriture = null;

		for (int i = 0; i < this.size(); i++) {

			try {
				ecriture = new PrintWriter(new FileWriter(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ecriture.write("{\"mot\":\"" + this.get(i).getNom() + "\",\"posX\":" + this.get(i).getPos().x + ",\"posY\":"
					+ this.get(i).getPos().y + ",\"sens\":" + this.get(i).isSens() + "}\n");

			System.out.println("sauvegarde effectuée");

			ecriture.close();

		}
	}

	public void recup() {
		// de votre repertoire data
		File file = new File("./src/com/formation/beba/data/lstDeTermeJson.json");

		InputStream fichier = null;
		try {
			fichier = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStreamReader lecture = new InputStreamReader(fichier);
		BufferedReader lecture2 = new BufferedReader(lecture);

		String ligne;
		try {
			while ((ligne = lecture2.readLine()) != null) {
				System.out.println(ligne);
				// {"mot":"pastille","posX":1,"posY":5,"sens":true}
				ligne.replaceAll("[{},:/]", "\"");
				ligne.replace("mot", "\"");
				ligne.replace("posY", "\"");
				ligne.replace("posX", "\"");
				ligne.replace("sens", "\"");
				ligne.replace("\"\"", "\"");
				ligne.replace("\"\"", "\"");
				ligne.replace("\"\"", "\"");
				ligne.replace("\"\"", "\""); // des fois que ça marche mal ce
												// truc...
				String[] termeCour = ligne.split("\"");
				Boolean leSens = false;
				if (Boolean.valueOf(termeCour[4]) == Terme.HORIZONTAL) {
					leSens = false;
				} else {
					leSens = true;
				}

				this.add(new Terme(termeCour[1],
						new Point(Integer.valueOf(termeCour[2]), Integer.valueOf(termeCour[3])), leSens));
			}
			lecture2.close();
			lecture.close();
			System.out.println("Le fichier est récupéré!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
