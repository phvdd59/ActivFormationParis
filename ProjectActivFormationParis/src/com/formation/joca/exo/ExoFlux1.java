package com.formation.joca.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

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

		System.out.println("Ajout d'un terme");
		Terme terme = new Terme();
		BufferedReader read = null;

		try {
			System.out.println("Veuillez entrer le mot : ");
			read = new BufferedReader(new InputStreamReader(System.in));
			String sMot = terme.epuration(read.readLine());
			terme.setNom(sMot);

			System.out.println("Veuillez entrer la position x : ");
			int posX = -1;
			boolean flag = false;
			while (!flag) {
				String sPosX = read.readLine();
				if (Pattern.matches("^[0-9]|[1-9][0-9]+$", sPosX)) {
					posX = Integer.parseInt(sPosX);
					flag = true;
				} else {
					System.out.println("attention il faut entrer un entier positif non nul");
				}
			}

			System.out.println("Veuillez entrer la position y : ");
			int posY = -1;
			flag = false;
			while (!flag) {
				String sPosY = read.readLine();
				if (Pattern.matches("^[0-9]|[1-9][0-9]+$", sPosY)) {
					posY = Integer.parseInt(sPosY);
					flag = true;
				} else {
					System.out.println("attention il faut entrer un entier positif non nul");
				}
			}

			Point point = new Point(posX, posY);
			terme.setPos(point);

			System.out.println("Veuillez entrer le sens : vertical ou horizontal");
			flag = false;
			while (!flag) {
				String sSens = terme.epuration(read.readLine());
				if (sSens.equals("HORIZONTAL")) {
					terme.setSens(Terme.HORIZONTAL);
					flag = true;
				} else if (sSens.equals("VERTICAL")) {
					terme.setSens(Terme.VERTICAL);
					flag = true;

				} else {
					System.out.println("attention taper \"horizontal\" ou \"vertical\"");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.add(terme);

		try {
			boolean flag = false;
			while (!flag) {
				System.out.println("Voulez vous ajouter un autre terme ? O/N");
				String result = read.readLine();

				if (result.equals("O") || result.equals("o")) {
					this.saisie();
					flag = true;
				} else if (result.equals("N") || result.equals("n")) {
					flag = true;
					System.out.println("lancement de la sauvegarde");
					this.save();
					System.out.println("sauvegarde réussie !");
				} else {
					System.out.println("Attention repondre par \"O\" ou \"o\" ou \"N\" ou \"n\"");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void save() {
		File fichierSave = new File("./src/com/formation/joca/data/saisie.json");
		PrintWriter sauvegarde = null;

		try {
			sauvegarde = new PrintWriter(fichierSave);
			for (int i = 0; i < this.size(); i++) {
				sauvegarde.println("{\"mot\":\"" + this.get(i).getNom() + "\",\"posX\":"
						+ (int) this.get(i).getPos().getX() + ",\"posY\":" + (int) this.get(i).getPos().getY()
						+ ",\"sens\":" + this.get(i).isSens() + "}");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sauvegarde.close();
		}
	}

	public void recup() {
		File fichiercharger = new File("./src/com/formation/joca/data/saisie.json");
		BufferedReader chargement = null;
		this.clear();
		Terme terme = null;
		Point point = null;

		try {
			InputStreamReader input = new InputStreamReader(new FileInputStream(fichiercharger), "UTF-8");
			chargement = new BufferedReader(input);
			String line = chargement.readLine();
			while (line != null) {
				System.out.println(line);
				terme = new Terme();

				String subNom = line.substring(line.indexOf("mot") + 6, line.indexOf("posX") - 3);
				String subPosX = line.substring(line.indexOf("posX") + 6, line.indexOf("posY") - 2);
				String subPosY = line.substring(line.indexOf("posY") + 6, line.indexOf("sens") - 2);
				String subSens = line.substring(line.indexOf("sens") + 6, line.indexOf("}"));

				terme.setNom(subNom);
				point = new Point(Integer.parseInt(subPosX), Integer.parseInt(subPosY));
				terme.setPos(point);
				if (subSens.equals("false")) {
					terme.setSens(Terme.HORIZONTAL);
				} else if (subSens.equals("true")) {
					terme.setSens(Terme.VERTICAL);
				}

				this.add(terme);
				line = chargement.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				chargement.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}