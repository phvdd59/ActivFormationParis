package com.formation.issa.metier;

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
		 * But : Entrer des �l�ments au clavier pour le mot crois� et les mettre
		 * dans un fichier
		 * 
		 * El�ments � entrer (pour au final, savoir cr�er un Terme) Saisir un
		 * mot Saisir une position x (d�but du mot sur la ligne horizontale)
		 * Saisir un position y (d�but du mot sur la ligne verticale) Saisir le
		 * sens du mot (mot vertical ou mot horizontal)
		 * 
		 * Dans le but de standardiser voici le nom des zones de saisie zone de
		 * saisie du mot : sMot zone de saisie de la position x : sPosX Zone de
		 * saisie de la position y : sPosY Zone de saisie du sens du mot : sSens
		 * 
		 * Plusieurs �l�ments devront pouvoir �tre saisis.
		 * 
		 * Cr�er un fichier dans lequel seront int�gr�es toutes les informations
		 * saisies.
		 * 
		 * Le nom du ficher est : saisie.json
		 * 
		 * Le fichier se pr�sentera sous la forme : par enregistrement
		 * {"mot":"motsaisi","posX":positionXSaisie,"posY":positionYSaisie,
		 * "sens":true ou false}
		 * 
		 * attention � bien respecter la syntaxe du fichier les {} en d�but et
		 * fin d'enregistrement les , entre 2 informations les : entre le nom de
		 * la valeur et la valeur en elle-m�me Les informations fixes
		 * "mot","posX",posY","sens" sont entre "" Les valeurs positions x et y
		 * sont indiqu�es telles quelles Le sens prend la valeur true ou la
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
		boolean ligne = false;
		boolean sens = false;
		boolean existSens = false;
		boolean posX = false;
		boolean posY = false;
		String mot = null;
		int x = 0;
		int y = 0;
		sMot = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (!ligne) {
				try {
					System.out.println("Entrez un nom :");
					mot = sMot.readLine();
				} catch (IOException e) {

				}

				while (!posX) {
					try {
						System.out.println("Entrez une position x :");
						x = Integer.valueOf(sMot.readLine());

					} catch (Exception e) {
						// e.printStackTrace();
					}
					if (x >= 0) {
						System.out.println("position de x : " + x);
						posX = true;
						break;
					} else {
						System.out.println("position x incorrecte");
						posX = false;
					}
				}

				while (!posY) {
					try {
						System.out.println("Entrez une position y :");
						y = Integer.valueOf(sMot.readLine());
					} catch (Exception e) {

					}
					if (y >= 0) {
						System.out.println("position de y : " + y);
						posY = true;
						break;
					} else {
						System.out.println("position de y incorrecte");
						posY = false;
					}

				}
				Point point = new Point(x, y);
				while (!existSens) {
					System.out.println("Entrez un sens (HORIZONTAL ou VERTICAL)?: ");
					String iSens = sMot.readLine();
					if (iSens.equals("HORIZONTAL")) {
						sens = false;
						existSens = true;
						break;
					} else if (iSens.equals("VERTICAL")) {
						sens = true;
						existSens = true;
						break;
					} else {
						System.out.println("sens incorrecte");
						existSens = false;
					}
				}

				terme = new Terme(mot, point, sens);
				lst.add(terme);
				System.out.println("Auriez-vous un autre terme � rajouter?");
				String fin = sMot.readLine();
				if (fin.equals("oui")) {
					System.out.println("Autre terme � rajouter");
					ligne = false;
				} else if (fin.equals("non")) {
					System.out.println("fin de la cr�ation de termes");
					ligne = true;
					break;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sMot.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void save() {
		// vers votre repertoire data
		// Ecriture
		File file = new File("./src/com/formation/issa/data/saisie.json");

		PrintWriter saveTerme = null;

		try {

			saveTerme = new PrintWriter(file);
			for (int i = 0; i < this.size(); i++) {

				saveTerme.write("{" + "mot :" + this.get(i).getNom() + "," + "posX :" + this.get(i).getPos().x + "posY :" + this.get(i).getPos().y + "sens :" + this.get(i).isSens() + "}");

				System.out.println("Fin de la sauvegarde");
			}

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
		// ObjectInputStream iStream = null;
		BufferedReader iStream2 = null;
		InputStreamReader input = null;
		Terme terme = new Terme();

		try {
			// iStream = new ObjectInputStream(new FileInputStream(file));
			input = new InputStreamReader(new FileInputStream(file), "UTF-8");
			iStream2 = new BufferedReader(input);
			String termeComplet = iStream2.readLine();
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
					sSens = Terme.HORIZONTAL;
				}
				String mot = listTerme[0];
				int x = Integer.valueOf(listTerme[1]);
				int y = Integer.valueOf(listTerme[2]);
				boolean sens = sSens;
				this.add(new Terme(mot, new Point(x, y), sens));
				termeEpurer = iStream2.readLine();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// iStream.close();
				iStream2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
