package com.formation.issa.metier;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;


import com.formation.emma.metier.Terme;

public class ExoFlux1  extends ArrayList<Terme> {

	public class Saisie {
		/**
		 * But : Entrer des éléments au clavier pour le mot croisé et les mettre dans un fichier
		 * 
		 * Eléments à entrer (pour au final, savoir créer un Terme) 
		 * 	Saisir un mot 
		 * 	Saisir une position x (début du mot sur la ligne horizontale)
		 *  Saisir un position y (début du mot sur la ligne verticale)
		 *  Saisir le sens du mot (mot vertical ou mot horizontal)
		 * 
		 * Dans le but de standardiser voici le nom des zones de saisie 
		 * 	zone de saisie du mot : sMot
		 *  zone de saisie de la position x : sPosX
		 *  Zone de saisie de la position y : sPosY
		 *  Zone de saisie du sens du mot : sSens
		 *   
		 * Plusieurs éléments devront pouvoir être saisis.
		 * 
		 * Créer un fichier dans lequel seront intégrées toutes les informations saisies.
		 * 
		 * Le nom du ficher est : saisie.json
		 *  
		 * Le fichier se présentera sous la forme : 
		 *  par enregistrement 
		 *  	{"mot":"motsaisi","posX":positionXSaisie,"posY":positionYSaisie,"sens":true ou false}
		 *     
		 *      attention à bien respecter la syntaxe du fichier
		 *      les {} en début et fin d'enregistrement
		 *      les , entre 2 informations
		 *      les : entre le nom de la valeur et la valeur en elle-même
		 *      Les informations fixes "mot","posX",posY","sens" sont entre ""
		 *      Les valeurs positions x et y sont indiquées telles quelles
		 *      Le sens prend la valeur true ou la valeur false  
		 *  
		 *  Exemple de fichier saisie.json
		 *    	{"mot":"pastille","posX":1,"posY":5,"sens":true}
		 *  	{"mot":"propre","posX":1,"posY":5,"sens":false}  
		 * 
		 * 	
		 */
			
		}
	
	public void saisie() {
		Terme terme = new Terme("mot", new Point(1,5), true);
		File file = new File("./src/com/formation/issa/data/saisie.js");
		ObjectOutputStream oStream = null;

		try {
			oStream = new ObjectOutputStream(new FileOutputStream(file));
			oStream.writeObject("mot");
			oStream.writeObject("posX");
			oStream.writeObject("posY");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void save() {
		// vers votre repertoire data
	}
	
	public void recup() {
		// de votre repertoire data
	}
}
