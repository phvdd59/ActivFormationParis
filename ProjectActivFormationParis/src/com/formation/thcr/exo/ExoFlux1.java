package com.formation.thcr.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
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
		//Menuing
		BufferedReader bInStr = null;
		bInStr = new BufferedReader(new InputStreamReader(System.in));
		String choixMenu = "";
		try {
			while (choixMenu != "exit") {
				System.out.println("Menu");
				System.out.println("1.Créer Terme");
				System.out.println("2.Supprimer Terme");
				System.out.println("3.Supprimer liste");
				System.out.println("4.Sauvegarder");
				System.out.println("5.Charger");
				System.out.println("6.Consulter liste de Termes");
				System.out.println("7.Afficher Solution (Dangereux)");
				System.out.println("8.quitter");
				choixMenu = bInStr.readLine();
				switch (choixMenu) {
					case "1":
						/**********************************
						 * AJOUTER TERME
						 */
						System.out.println("Création Terme");
						System.out.print("entrer sMot : ");
						String nom = bInStr.readLine();
						System.out.print("entrer sPosX : ");
						int checkPosX = -1;
						while (checkPosX < 0) {
							checkPosX = Integer.valueOf(bInStr.readLine());
							if (checkPosX < 0) {
								System.out.println("Position X négative");
								System.out.print("sPosX : ");
							}
						}
						int posX = checkPosX;
						System.out.print("entrer sPosY : ");
						int checkPosY = -1;
						while (checkPosY < 0) {
							checkPosY = Integer.valueOf(bInStr.readLine());
							if (checkPosY < 0) {
								System.out.println("Position Y négative");
								System.out.print("sPosY : ");
							}
						}
						int posY = checkPosY;
						System.out.println("entrer sSens : \n1.HORIZONTAL\n2.VERTICAL");
						boolean sens = false;
						int checkSens = 0;
						System.out.print("sSens : ");
						while (!(checkSens == 1 || checkSens == 2)) {
							checkSens = Integer.valueOf(bInStr.readLine());
							if (checkSens == 1) {
								sens = Terme.HORIZONTAL;
							} else if (checkSens == 2) {
								sens = Terme.VERTICAL;
							} else {
								System.out.println("recommencer saisie");
								System.out.println("entrer sSens : \n1.HORIZONTAL\n2.VERTICAL");
								System.out.print("sSens : ");
							}
						}
						this.add(new Terme(nom, new Point(posX, posY), sens));
						System.out.println();
						System.out.println("Création du terme : " + this.get(this.size() - 1));
						System.out.println();
						break;
					case "2":
						/**********************************
						 * SUPPRIMER TERME
						 */
						System.out.println();
						System.out.println("suppression Terme");
						System.out.println("Liste de Termes : ");
						if (this.isEmpty()) {
							System.out.println("Pas de terme");
							break;
						} else {
							int i = 0;
							for (Terme terme : this) {
								System.out.println(i + "." + terme);
								i++;
							}
						}
						int termeASupprimer = Integer.valueOf(bInStr.readLine());
						while (termeASupprimer >= this.size() || termeASupprimer < 0) {
							System.out.println("indice en dehors des limites");
							termeASupprimer = Integer.valueOf(bInStr.readLine());
						}
						System.out.println(this.remove(termeASupprimer) + "a été supprimé");
						System.out.println();
						break;
					case "3":
						/**********************************
						 * SUPPRIMER LISTE
						 */
						this.clear();
						System.out.println();
						System.out.println("Liste supprimée");
						System.out.println();
						break;
					case "4":
						/**********************************
						 * SAVE
						 */
						save();
						System.out.println();
						break;
					case "5":
						/**********************************
						 * LOAD
						 */
						recup();
						System.out.println();
						break;
					case "6":
						/**********************************
						 * AFFICHAGE LISTE TERME
						 */
						System.out.println("Liste de Termes : ");
						if (this.isEmpty()) {
							System.out.println("Pas de terme");
						} else {
							for (Terme terme : this) {
								System.out.println(terme);
							}
						}
						System.out.println();
						break;
					case "7":
						/**********************************
						 * SOLUTION (EXOEXCEPTION1)
						 */
						ExoException1 exo = new ExoException1();
						int width = -1;
						int height = -1;
						System.out.println("entrez largeur");
						while(width < 0){
							System.out.print("sLargeur : ");
							width = Integer.valueOf(bInStr.readLine());
							if(width<0){
								System.out.println("largeur négative");
							}
						}
						System.out.println();
						System.out.println("entrez hauteur");
						while(height<0){
							System.out.print("sHauteur : ");
							height = Integer.valueOf(bInStr.readLine());
							if(height<0){
								System.out.println("hauteur négative");
							}
						}
						System.out.println();
						char[][] sol = null;
						try {
							sol = exo.solution(width, height, this);
						} catch (CruciException e) {
							e.printStackTrace();
						}
						//Affichage solution
						for (int i = 0; i < sol.length; i++) {
							System.out.println();
							for (int j = 0; j < sol[0].length; j++) {
								System.out.print(sol[i][j]);
							}
						}
						System.out.println();
						break;
					case "8":
						/**********************************
						 * EXIT
						 */
						System.out.println("voulez-vous sauvegarder avant de quitter");
						System.out.println("1.oui\n2.non");
						int choix = Integer.valueOf(bInStr.readLine());
						while (choix < 1 || choix > 2) {
							System.out.println("cas non traité");
							System.out.println("voulez-vous sauvegarder");
							System.out.println("1.oui\n2.non");
						}
						if (choix == 1) {
							save();
						}
						choixMenu = "exit";
						System.out.println("programme quitté");
						break;
					default:
						System.out.println("recommencer saisie");
						System.out.println();
						break;
				}
			}
		} catch (IOException e) {
		} finally {
			try {
				bInStr.close();
			} catch (IOException e) {
			}
		}
	}

	public void save() {
		// vers votre repertoire data sous forme saisie.json
		File file = new File("./src/com/formation/thcr/data/saisie.json");
		PrintWriter bw = null;
		try {
			bw = new PrintWriter(new FileWriter(file));
			for (Terme terme : this) {
				//{"mot":"pastille","posX":1,"posY":5,"sens":true}
				bw.write("{\"mot\":\"" + terme.getNom() + "\",\"posX\":" + terme.getPos().x + ",\"posY\":" + terme.getPos().y + ",\"sens\":"
						+ terme.isSens() + "}\n");
			}
			System.out.println("sauvegarde effectuée");
		} catch (IOException e) {
		} finally {
			bw.close();
		}
	}

	public void recup() {
		// de votre repertoire data
		File file = new File("./src/com/formation/thcr/data/saisie.json");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			int character = fr.read();
			String s = "";
			while (character != -1) {
				s += (char) character;
				character = fr.read();
			}
			String sModif = cleanJSON(s);
			String[] info = sModif.split(" ");
			String nom = "";
			int posX = 0;
			int posY = 0;
			boolean sens = false;
			this.clear();
			for (int i = 0; i < info.length; i++) {
				//On utilise les modulo pour capter les 4 attributs de Terme
				if (i % 4 == 0) {
					nom = info[i];
				} else if (i % 4 == 1) {
					posX = Integer.valueOf(info[i]);
				} else if (i % 4 == 2) {
					posY = Integer.valueOf(info[i]);
				} else {
					if (Boolean.valueOf(info[i]) == Terme.HORIZONTAL) {
						sens = Terme.HORIZONTAL;
					} else if (Boolean.valueOf(info[i]) == Terme.VERTICAL) {
						sens = Terme.VERTICAL;
					}
					this.add(new Terme(nom, new Point(posX, posY), sens));
				}

			}
			System.out.println("chargement effectué");
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public String cleanJSON(String texte) {
		String s = texte.replace("{", " ");
		s = s.replace("}", " ");
		s = s.replace("\"", " ");
		s = s.replace(":", " ");
		s = s.replace(",", " ");
		s = s.replace("  ", " ");
		s = s.replace("  ", " ");
		s = s.replace(" mot ", "");
		s = s.replace(" posX", "");
		s = s.replace(" posY", "");
		s = s.replace(" sens", "");
		s = s.replaceAll("\\p{Space}", " ");
		s = s.replace("  ", " ");
		return s;
	}
}
