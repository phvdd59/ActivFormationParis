package com.formation.ambr.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

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

	ArrayList<Terme> lst = new ArrayList<Terme>();

	public void saisie() {

		Terme terme0 = new Terme();
		BufferedReader sMot = null;
		BufferedReader sPosX = null;
		BufferedReader sPosY = null;
		BufferedReader sSens = null;
		BufferedReader saisie = null;

		boolean LoopSaisie = true;
		while (LoopSaisie) {
			// saisir un mot
			System.out.println("Veuillez saisir un mot : ");
			sMot = new BufferedReader(new InputStreamReader(System.in));
			String nom0 = null;
			try {
				nom0 = sMot.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String nom = terme0.epuration(nom0);

			// saisir une position x et une position y, en déduire pos
			int x = 0;
			boolean LoopSPosX = true;
			while (LoopSPosX) {
				System.out.println("Veuillez saisir une position en x : ");
				sPosX = new BufferedReader(new InputStreamReader(System.in));
				String a = null;
				try {
					a = sPosX.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (a.matches("^[0-9]+$")) {
					x = Integer.valueOf(a);
					if (x >= 0) {
						LoopSPosX = false;
					} else {
						System.out.println("x doit être supérieur ou égal à 0");
						LoopSPosX = true;
					}
				} else {
					System.out.println("x doit être un nombre entier supérieur ou égal à 0");
				}

			}

			int y = 0;
			boolean LoopSPosY = true;
			while (LoopSPosY) {
				System.out.println("Veuillez saisir une position en y : ");
				sPosY = new BufferedReader(new InputStreamReader(System.in));
				String b = null;
				try {
					b = sPosY.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (b.matches("^[0-9]+$")) {
					y = Integer.valueOf(b);
					if (y >= 0) {
						LoopSPosY = false;
					} else {
						System.out.println("y doit être supérieur ou égal à 0");
						LoopSPosY = true;
					}
				} else {
					System.out.println("y doit être un nombre entier supérieur ou égal à 0");
				}
			}

			Point pos = new Point(x, y);

			// saisir le sens du mot (vertical ou horizontal)
			boolean sens = false;
			boolean LoopSSens = true;
			while (LoopSSens) {
				System.out.println("Veuillez saisir le sens du mot: V pour Vertical, H pour Horizontal : ");
				sSens = new BufferedReader(new InputStreamReader(System.in));
				String c = null;
				try {
					c = sSens.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (c.equals("V")) {
					sens = true;
					LoopSSens = false;
				} else if (c.equals("H")) {
					sens = false;
					LoopSSens = false;
				} else {
					System.out.println("Uniques choix possibles: V ou H ");
				}
			}

			// créer le Terme correspondant
			Terme terme = new Terme(nom, pos, sens);

			// entrer le Terme dans le fichier
			lst.add(terme);
			//this.save();

			//poursuite de la saisie
			boolean LoopSaisieChoix = true;
			while (LoopSaisieChoix) {
				System.out.println("Voulez-vous entrer un nouveau terme? O pour oui, N pour non");
				saisie = new BufferedReader(new InputStreamReader(System.in));
				String d = null;
				try {
					d = saisie.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (d.equals("O")) {
					LoopSaisieChoix = false;
				} else if (d.equals("N")) {
					LoopSaisieChoix = false;
					LoopSaisie = false;
					System.out.println("Saisie terminée");
				} else {
					System.out.println("Uniques choix possibles: O ou N ");
				}
			}

		}

	}

	public void save() {
		// vers votre repertoire data
		File file = new File("./src/com/formation/ambr/data/saisie.json");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			for (int i = 0; i < lst.size(); i++) { // \" : pour afficher un "
				pw.println("{\"mot\":\"" + lst.get(i).getNom() + "\",\"posX\":" + (int) lst.get(i).getPos().getX() + ",\"posY\":" + (int) lst.get(i).getPos().getY() + ",\"sens\":" + lst.get(i).isSens() + "}");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

	public void recup() {
		// de votre repertoire data
		//{"mot":"SDGSD","posX":1,"posY":1,"sens":true}
		File file = new File("./src/com/formation/ambr/data/saisie.json");
		BufferedReader br = null;
		ArrayList<Terme> lst = new ArrayList<Terme>();
		try {
			br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			while (line != null) {
				String nom = line.substring(line.indexOf("mot") + 6, line.indexOf("posX") - 3);
				String posX = line.substring(line.indexOf("posX") + 6, line.indexOf("posY") - 2);
				String posY = line.substring(line.indexOf("posY") + 6, line.indexOf("sens") - 2);
				String sensString = line.substring(line.indexOf("sens") + 6, line.indexOf("}"));

				int x = Integer.valueOf(posX);
				int y = Integer.valueOf(posY);
				Point pos = new Point(x, y);

				boolean sens = true;
				if (sensString == "true") {
					sens = true;
				} else if (sensString == "false") {
					sens = false;
				}

				Terme terme = new Terme(nom, pos, sens);
				lst.add(terme);
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
}
