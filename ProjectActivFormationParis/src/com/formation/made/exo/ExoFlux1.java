package com.formation.made.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.formation.phva.exo.Terme; // je change l'import pour voir

public class ExoFlux1 extends ArrayList<Terme> {

	public class Saisie {
		/**
		 * But : Entrer des éléments au clavier pour le mot croisé et les mettre dans un fichier
		 * 
		 * Eléments à entrer (pour au final, savoir créer un Terme) Saisir un mot Saisir une position x (début du mot sur la ligne horizontale) Saisir un position y (début du mot sur la ligne verticale) Saisir le sens du mot (mot vertical ou mot horizontal)
		 * 
		 * Dans le but de standardiser voici le nom des zones de saisie zone de saisie du mot : sMot zone de saisie de la position x : sPosX Zone de saisie de la position y : sPosY Zone de saisie du sens du mot : sSens
		 * 
		 * Plusieurs éléments devront pouvoir être saisis.
		 * 
		 * Créer un fichier dans lequel seront intégrées toutes les informations saisies.
		 * 
		 * Le nom du ficher est : saisie.json
		 * 
		 * Le fichier se présentera sous la forme : par enregistrement {"mot":"motsaisi","posX":positionXSaisie,"posY":positionYSaisie,"sens":true ou false}
		 * 
		 * attention à bien respecter la syntaxe du fichier les {} en début et fin d'enregistrement les , entre 2 informations les : entre le nom de la valeur et la valeur en elle-même Les informations fixes "mot","posX",posY","sens" sont entre "" Les valeurs positions x et y sont indiquées telles quelles Le sens prend la valeur true ou la valeur false
		 * 
		 * Exemple de fichier saisie.json {"mot":"pastille","posX":1,"posY":5,"sens":true} {"mot":"propre","posX":1,"posY":5,"sens":false}
		 * 
		 * 
		 */

	}

	public void saisie() {
		boolean demandeDeTerme = true;
		BufferedReader bReader = null;
		bReader = new BufferedReader(new InputStreamReader(System.in));
		Pattern pattern = null;
		Matcher matcher = null;
		boolean motBon = false;
		try {
			while (demandeDeTerme) {
				Terme terme = new Terme();
				while (!motBon) {
					pattern = Pattern.compile("^[a-zA-Z]");
					System.out.println("smot");
					String entreeStringNom = bReader.readLine();
					matcher = pattern.matcher(entreeStringNom);
					if (!matcher.find()) {
						System.out.println("je ne suis pas un mot");
					} else {
						terme.setNom(entreeStringNom);
						motBon = true;
					}

				}

				System.out.println("sposX ");
				String entreeStringX = bReader.readLine();
				System.out.println("sPosY ");
				String entreeStringY = bReader.readLine();
				System.out.println("ssens ");
				String entreeStringSens = bReader.readLine();

				Point point = new Point(Integer.valueOf(entreeStringX), Integer.valueOf(entreeStringY));

				terme.setPos(point);
				terme.setSens(Boolean.valueOf(entreeStringSens));
				this.add(terme);
				System.out.println("Nouveau terme a rajouter? true/false");
				demandeDeTerme = Boolean.valueOf(bReader.readLine());
				motBon = false; // pour revenir au mot sinon il garde motBon=true et ne me redemande pas le mot
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void save() {
		ObjectOutputStream fluxDeSortieObject = null;
		File file = new File("../ProjectFlux/src/com/formation/made/data/saisi.json");
		try {
			fluxDeSortieObject = new ObjectOutputStream(new FileOutputStream(file));
			for (Terme terme : this) {
				fluxDeSortieObject.writeObject( "{mot : " + "\""+terme.getNom()+ "\""+ " , posX : " + terme.getPos().getX() + " , posY : " + terme.getPos().getY() + " , sens : " + terme.isSens() + "}");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fluxDeSortieObject.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// vers votre repertoire data
	}

	public void recup() {
		File file = new File("../ProjectFlux/src/com/formation/made/data/saisi.json");
		ObjectInputStream FluxDentreeObject = null;
		try {
			FluxDentreeObject = new ObjectInputStream(new FileInputStream(file));

			while (true) {
				Object objectTerme = FluxDentreeObject.readObject();
				System.out.println(objectTerme);
//				if (objectTerme instanceof Terme) {
//					Terme terme = (Terme) objectTerme;
//					System.out.println(terme);
//				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("le fichier est fini");
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				FluxDentreeObject.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// de votre repertoire data

	}
}
