package com.formation.jeci.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

		boolean continu = true;

		while (continu == true) {

			String mot;
			int posX;
			int posY;
			boolean sens;

			Scanner scan = new Scanner(System.in);
			System.out.println("Salut à toi cher utilisateur. Veuillez entrez un mot en majusucule:");
			String str = scan.nextLine();

			while (str.matches("[a-zA-Z]+") == false) {
				System.out.println("Rentrez un nom valide en MAJUSCULE");
				str = scan.nextLine();
			}
			mot = str;
			System.out.println("Veuillez entrez maintenant la posX:");
			String str1 = scan.nextLine();
			while (str1.matches("[0-9]+") == false) {
				System.out.println("Rentrez une posX valide");
				str1 = scan.nextLine();
			}
			posX = Integer.parseInt(str1);

			System.out.println("Veuillez entrez maintenant la posY:");
			String str2 = scan.nextLine();
			while (str2.matches("[0-9]+") == false) {
				System.out.println("Rentrez une posY valide");
				str2 = scan.nextLine();
			}
			posY = Integer.parseInt(str2);

			System.out.println("Veuillez entrez maintenant le sens (vertical ou horizontal):");
			String str3 = scan.nextLine();
			while (str3.equals("VERTICAL") == false && str3.equals("HORIZONTAL") == false) {
				System.out.println("Rentrez un sens valide");
				str3 = scan.nextLine();
			}
			if (str3.equals("VERTICAL")) {
				sens = true;
			} else {
				sens = false;
			}
			Terme terme = new Terme(mot, new Point(posX, posY), sens);
			this.add(terme);
			System.out.println("voulez vous entrez un nouveau terme ?(O/N)");
			String str5 = scan.nextLine();
			while (str5.contains("O") == false && str5.contains("N") == false) {
				System.out.println("valeur incorrect");
				str5 = scan.nextLine();
			}
			if (str5.contains("O") == true) {
				continu = true;
			} else {
				continu = false;
			}
		}
	}

	public void save() {
		// Exemple de fichier saisie.json
		// * {"mot":"pastille","posX":1,"posY":5,"sens":true}
		File file = new File("./src/com/formation/jeci/data/saisie.json");
		PrintWriter out = null;
		try {

			out = new PrintWriter(file);
			for (int i = 0; i < this.size(); i++) {

				out.println("{mot\":\"" + this.get(i).getNom() + "\" ,\"posX\": " + this.get(i).getPos().x + ", \"posY\": " + this.get(i).getPos().y + ", \"sens\": " + this.get(i).isSens() + "}");
			}
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}
	}

	public void recup() {
		this.clear();
		File file = new File("./src/com/formation/jeci/data/saisie.json");
		InputStreamReader inputStreamREader = null;
		BufferedReader bIn = null;
		try {
			inputStreamREader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bIn = new BufferedReader(new FileReader(file));
			String ligne = bIn.readLine();
			while (ligne != null) {
				String mot;
				int posX;
				int posY;
				boolean sens;
				ligne = ligne.replaceAll("[^a-zA-Z0-9]+", " ");
				ligne = ligne.replaceAll("\\s+", " ");
				String[] motTab = ligne.split(" ");

				mot = motTab[2];
				posX = Integer.parseInt(motTab[4]);
				posY = Integer.parseInt(motTab[6]);
				if (motTab[8].equals("true")) {
					sens = true;
				} else {
					sens = false;
				}
				Terme terme = new Terme(mot, new Point(posX, posY), sens);
				this.add(terme);

				ligne = bIn.readLine();
			}
			System.out.println(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
