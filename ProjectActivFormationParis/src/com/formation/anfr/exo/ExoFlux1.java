package com.formation.anfr.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.formation.anfr.exo.Terme;

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
		try {
			System.out.println("Saisir un mot :");
			String ligne = stdIn.readLine();
			String mot = ligne;
			System.out.println("mot :" + mot);
			System.out.println("Saisir une posX :");
			ligne = stdIn.readLine();
			int posX = Integer.valueOf(ligne);
			System.out.println("posX :" + posX);
			System.out.println("Saisir une posY :");
			ligne = stdIn.readLine();
			int posY = Integer.valueOf(ligne);
			System.out.println("posY :" + posY);
			Point p = new Point(posX, posY);
			System.out.println("Saisir le sens (V-true/H-false) :");
			ligne = stdIn.readLine();
			String sensS = ligne;
			System.out.println("sens :" + sensS);
			boolean sens = false;
			if (sensS.equals("true")) {
				sens = true;
			}
			this.add(new Terme(mot, p, sens));
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

	public void save() throws IOException {
		File file = new File("./src/com/formation/anfr/data/saisie.json");
		PrintWriter out = new PrintWriter(file);
		for (Terme terme : this) {
			if (!terme.equals(null)) {
				out.println("{\"mot\":" + terme.getNom() + ",\"posX\":" + (int) terme.getPos().getX() + ",\"posY\":"
						+ (int) terme.getPos().getY() + ",\"sens\":" + terme.isSens() + "}");
				out.close();
			}
		}
	}

	public void recup() {
		File file = new File("./src/com/formation/anfr/data/saisie.json");
		BufferedReader bIn = null;
		try {
			InputStreamReader input = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bIn = new BufferedReader(input);
			String line = bIn.readLine();
			while (!line.equals("")) {
				String mot = "";
				String lol = line.substring(line.indexOf("\"mot\":") + 67);
				char[] tab = lol.trim().toCharArray();
				char breaker = '\"';
				for (int i = 1; i < tab.length - 1; i++) {
					if ((tab[i] >= 'A') && (tab[i] <= 'Z')) {
						mot += tab[i];
					} else if (tab[i] == breaker) {
						break;
					}
				}
				String positionX = "";
				lol = line.substring(line.indexOf("\"posX\":") + 7);
				tab = lol.trim().toCharArray();
				for (int i = 1; i < tab.length - 1; i++) {
					if ((tab[i] >= '0') && (tab[i] <= '9')) {
						positionX += tab[i];
					} else if (tab[i] == breaker) {
						break;
					}
				}
				String positionY = "";
				lol = line.substring(line.indexOf("\"posY\":") + 7);
				tab = lol.trim().toCharArray();
				for (int i = 1; i < tab.length - 1; i++) {
					if ((tab[i] >= '0') && (tab[i] <= '9')) {
						positionY += tab[i];
					} else if (tab[i] == breaker) {
						break;
					}
				}
				Point p = new Point(Integer.valueOf(positionX), Integer.valueOf(positionY));
				boolean sens = false;
				if (line.contains("true")) {
					sens = true;
				}
				this.add(new Terme(mot, p, sens));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally

		{
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
