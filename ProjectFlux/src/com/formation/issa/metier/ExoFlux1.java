package com.formation.issa.metier;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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

		ArrayList<Terme> lst = new ArrayList<Terme>();
		Terme terme = new Terme();
		BufferedReader sMot = null;
		int ligne = 15;
		boolean sens = false;
		boolean existSens = false;
		boolean posX = false;
		boolean posY = false;
		String mot = null;
		int x = 0;
		int y = 0;
		sMot = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (ligne != 1) {
				try {
					System.out.println("Entrer un nom :");
					mot = sMot.readLine();
				} catch (IOException e) {

				}

				while (posX = true) {
					try {
						x = Integer.valueOf(sMot.readLine());
						System.out.println("Entrez une position x :");
					} catch (Exception e) {
						// e.printStackTrace();
					}
					if (x > 0) {
						System.out.println("position de x :" + x);
					} else {
						System.out.println("position x incorrecte");
					}

					while (posY = true) {
						try {
							System.out.println("Entrez une position y :");
							y = Integer.valueOf(sMot.readLine());
						} catch (Exception e) {

						}
						if (y > 0) {
							System.out.println("position de y :" + y);
						} else {
							System.out.println("position de y incorrecte");
						}

					}
					Point point = new Point(x, y);
					while (existSens == true) {
						System.out.println("Entrez un sens (H ou V)?: ");
						String iSens = sMot.readLine();
						if (iSens.equals("HORIZONTAL")) {
							sens = false;
						} else if (iSens.equals("VERTICAL")) {
							sens = true;
						} else {
							System.out.println("sens incorrecte");
						}
					}

					terme = new Terme(mot, point, sens);
					lst.add(terme);
					System.out.println("Auriez-vous un autre terme à rajouter?");
					ligne = Integer.valueOf(mot);

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void save() {
		// vers votre repertoire data
		// Ecriture
		File file = new File("./src/com/formation/issa/data/saisie.json");
		ArrayList<Terme> lst = null;
		PrintWriter saveTerme = null;

		try {

			for (int i = 0; i < lst.size(); i++) {
				System.out.println(file.getCanonicalPath());
				saveTerme = new PrintWriter(file);
				saveTerme.write("{" + "mot :" + this.get(i).getNom() + "," + "posX :" + this.get(i).getPos().x + "posY :" + this.get(i).getPos().y + "sens :" + this.get(i).isSens() + "}");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			saveTerme.close();

		}

	}

	public void recup() {
		// de votre repertoire data
		// Lecture
		File file = new File("./src/com/formation/issa/data/saisie.json");
		ObjectInputStream iStream = null;
		BufferedReader iStream2 = null;
		Terme terme = new Terme();

		try {
			iStream = new ObjectInputStream(new FileInputStream(file));
			iStream2 = new BufferedReader(new FileReader(file));
			String termeComplet = null;
			while ((termeComplet = iStream2.readLine()) != null) {
				String termeEpurer = termeComplet;
				termeEpurer = termeEpurer.replace("{", "");
				termeEpurer = termeEpurer.replace(",", "");
				termeEpurer = termeEpurer.replaceAll("\"", "");
				termeEpurer = termeEpurer.replace("}", "");
				termeEpurer = termeEpurer.replace(":", "");
				termeEpurer = termeEpurer.replace("mot", "");
				termeEpurer = termeEpurer.replace("posX", "");
				termeEpurer = termeEpurer.replace("posY", "");
				termeEpurer = termeEpurer.replace("sens", "");
				System.out.println(termeEpurer);
				String listTerme[] = termeEpurer.split(" ");
				boolean sSens = false;
				if (listTerme[3] == "true") {
					sSens = Terme.VERTICAL;
				} else if (listTerme[3] == "false") {
					sSens = Terme.VERTICAL;
				}
				String mot = listTerme[0];
				int x = Integer.valueOf(listTerme[1]);
				int y = Integer.valueOf(listTerme[2]);
				boolean sens = sSens;
				this.add(new Terme(mot, new Point(x, y), sens));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				iStream.close();
				iStream2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
