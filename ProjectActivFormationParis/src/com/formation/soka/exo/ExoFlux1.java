package com.formation.soka.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		String ligne = null;
		String sMot = null;
		int sPosX = 0;
		int sPosY = 0;
		boolean sSens = false;
		Point point = new Point(sPosX, sPosY);
		Terme terme = null;
		try {
			System.out.println("Saisissez un mot et appuyer sur Entrée");
			ligne = stdIn.readLine();
			//while (!ligne.equals("")) {
			sMot = ligne;
			//}
			System.out.println("Lorsque vous aurez terminé toutes saisis, appuyez de nouveau sur Entrée");

			System.out.println("Saisissez la position en x puis appuyez sur Entrée");
			ligne = stdIn.readLine();
			//while (!ligne.equals("")) {
			sPosX = Integer.valueOf(ligne);
			//}
			System.out.println("Lorsque vous aurez terminé toutes saisis, appuyez de nouveau sur Entrée");

			System.out.println("Saisissez la position en y puis appuyez sur Entrée");
			ligne = stdIn.readLine();
			//while (!ligne.equals("")) {
			sPosY = Integer.valueOf(ligne);
			//}
			System.out.println("Lorsque vous aurez terminé toutes saisis, appuyez de nouveau sur Entrée");

			System.out.println("Saisissez le sens du mot");
			System.out.println("Entrez H pour Horizontal et V pour Vertical puis appuyez sur Entrée");
			ligne = stdIn.readLine();
			//while (!ligne.equals("")) {
			if (ligne.toUpperCase().equals("H")) {
				sSens = false;
			} else if (ligne.toUpperCase().equals("V")) {
				sSens = true;
			}
			//}
			System.out.println("Lorsque vous aurez terminé toutes saisis, appuyez de nouveau sur Entrée");

			terme = new Terme(sMot, point, sSens);
			this.add(terme);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.println("Souhaitez-vous ajouter un nouveau terme? Si oui, entrez OUI, sinon appuyez sur Entrée");
		try {
			ligne = stdIn.readLine();
			if (!ligne.equals("")) {
				this.saisie();
			} else {
				stdIn.close();
				this.save();
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
		// vers votre repertoire data
		File file = new File("./src/com/formation/soka/data/saisi.json");
		PrintWriter pW = null;
		try {
			pW = new PrintWriter(file);
			for (int i = 0; i < this.size(); i++) {
				pW.println("{\"mot\"" + ":" + "\"" + this.get(i).getNom() + "\",\"posX\":" + this.get(i).getPos().x + "\",\"posY\":" + this.get(i).getPos().y + ",\"sens\":" + this.get(i).isSens() + "}");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pW.close();
		}
	}

	public void recup() {
		// de votre repertoire data
		File file = new File("./src/com/formation/soka/data/saisi.json");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		String s = "";
		int posX = 0;
		int posY = 0;
		Point point = null;
		boolean b = false;
		Terme terme = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); //Transforme de bianaire en caractere avec la specificite UTF-8, puis on le recpere en buffer pour pouvoir le lire ligne par ligne. 
			bIn = new BufferedReader(inputStreamReader);
			String line = bIn.readLine();
			while (line != null) {
				if (line.contains("false")) {
					b = false;
				}
				if (line.contains("true")) {
					b = true;
				}
				if (line.contains("posX")) {
					posX = Integer.parseInt(line.substring(line.indexOf("posX") + 6, line.indexOf("posX") + 7));
				}
				if (line.contains("posY")) {
					posY = Integer.parseInt(line.substring(line.indexOf("posY") + 6, line.indexOf("posY") + 7));
				}
				if (line.contains("mot\":")) {
					s = line.substring(line.indexOf("mot\":" + 6), line.indexOf("posX") - 3);
				}

				point = new Point(posY, posX);
				terme = new Terme(s, point, b);
				this.add(terme);
				line = bIn.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Pas de fichier trouve pour effectuer la lecture");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOOException");
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
