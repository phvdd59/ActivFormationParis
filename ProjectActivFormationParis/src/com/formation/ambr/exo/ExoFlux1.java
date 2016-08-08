package com.formation.ambr.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
		System.out.println("Veuillez saisir une position en x : ");
		sPosX = new BufferedReader(new InputStreamReader(System.in));
		String a = null;
		try {
			a = sPosX.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int x = Integer.valueOf(a);

		System.out.println("Veuillez saisir une position en y : ");
		sPosY = new BufferedReader(new InputStreamReader(System.in));
		String b = null;
		try {
			b = sPosY.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int y = Integer.valueOf(b);

		Point pos = new Point(x, y);

		// saisir le sens du mot (vertical ou horizontal)
		System.out.println("Veuillez saisir le sens du mot: V pour Vertical, H pour Horizontal : ");
		boolean sens = false;
		sSens = new BufferedReader(new InputStreamReader(System.in));
		String c = null;
		try {
			c = sSens.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (c.equals("V")) {
			sens = true;
		} else if (c.equals("H")) {
			sens = false;
		} else {
			System.out.println("Uniques choix possibles: V ou H ");
		}

		// créer le Terme correspondant
		Terme terme = new Terme(nom, pos, sens);

		// entrer le Terme dans le fichier
		lst.add(terme);

	}

	public void save() {
		// vers votre repertoire data
		File file = new File("./src/com/formation/ambr/data/saisie.json");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			for (int i = 0; i < lst.size(); i++) { // \" : pour afficher un "
				pw.println("{\"mot\":\"" + lst.get(i).getNom() + "\",\"posX\":" + lst.get(i).getPos().getX() + ",\"posY\":" + lst.get(i).getPos().getY() + ",\"sens\":" + lst.get(i).isSens() + "}");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

	public void recup() {
		// de votre repertoire data
	}
}
