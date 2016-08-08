package com.formation.thde.exo;

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

		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		String sMot;
		int sPosX;
		int sPosY;
		String sSens;
		boolean sens;
		boolean cont = true;
		String sCont;

		try {
			while (cont == true) {

				System.out.println("entrer mot");
				sMot = stdIn.readLine();

				System.out.println("entrer x");
				sPosX = Integer.valueOf(stdIn.readLine());

				System.out.println("entrer y");
				sPosY = Integer.valueOf(stdIn.readLine());

				System.out.println("entrer sens (vertical/horizontal");
				sSens = stdIn.readLine();
				if (sSens.toLowerCase().matches("vertical")) {
					sens = true;
				} else {
					sens = false;
				}

				this.add(new Terme(sMot.toLowerCase(), new Point(sPosX, sPosY), sens));
				System.out.println("Continuer ? (Y/N)");
				sCont = stdIn.readLine();
				if (sCont.matches("N") || sCont.matches("n")) {
					cont = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stdIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void save() {

		if (this.isEmpty() == false) {

			File file = new File("./src/com/formation/thde/data/saisie.json");
			PrintWriter out = null;
			try {
				out = new PrintWriter(file);

				for (int i = 0; i < this.size(); i++) {
					out.println("{\"mot\":\"" + this.get(i).getNom().toLowerCase() + "\",\"posX\":" + (int) this.get(i).getPos().getX() + ",\"posY\":" + (int) this.get(i).getPos().getY() + ",\"sens\":" + this.get(i).isSens() + "}");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out.close();
			}

		} else {
			//VIDE
		}
	}

	public void recup() {
		File file = new File("./src/com/formation/thde/data/saisie.json");
		BufferedReader stdIn = null;
		String[] tabLine;
		boolean sens = false;
		try {
			stdIn = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = stdIn.readLine();
			while (line != null) {

				line = line.replaceAll("[:,{}]", "");
				tabLine = line.split("\"");
				if (tabLine[11].matches("true")) {
					sens = true;
				}
				this.add(new Terme(tabLine[4].toLowerCase(), new Point(Integer.valueOf(tabLine[7]), Integer.valueOf(tabLine[9])), sens));
				line = stdIn.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stdIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
