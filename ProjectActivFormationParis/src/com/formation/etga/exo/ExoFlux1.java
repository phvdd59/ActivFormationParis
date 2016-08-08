package com.formation.etga.exo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

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

		String nom = null;
		System.out.println("Entrer un mot");
		try {
			nom = bInStr.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void save() {
		File file = new File("./src/com/formation/etga/data/saisie.json");
		PrintWriter ecriture = null;

	}

	public void recup() {

		File file = new File("./src/com/formation/etga/data/saisie.json");

		InputStream fichier = null;
		try {
			fichier = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStreamReader lecture = new InputStreamReader(fichier);
		BufferedReader lecture2 = new BufferedReader(lecture);

		String ligne;
	}
}
