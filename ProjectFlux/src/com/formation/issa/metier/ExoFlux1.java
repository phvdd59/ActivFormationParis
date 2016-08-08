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
		 * But : Entrer des �l�ments au clavier pour le mot crois� et les mettre dans un fichier
		 * 
		 * El�ments � entrer (pour au final, savoir cr�er un Terme) 
		 * 	Saisir un mot 
		 * 	Saisir une position x (d�but du mot sur la ligne horizontale)
		 *  Saisir un position y (d�but du mot sur la ligne verticale)
		 *  Saisir le sens du mot (mot vertical ou mot horizontal)
		 * 
		 * Dans le but de standardiser voici le nom des zones de saisie 
		 * 	zone de saisie du mot : sMot
		 *  zone de saisie de la position x : sPosX
		 *  Zone de saisie de la position y : sPosY
		 *  Zone de saisie du sens du mot : sSens
		 *   
		 * Plusieurs �l�ments devront pouvoir �tre saisis.
		 * 
		 * Cr�er un fichier dans lequel seront int�gr�es toutes les informations saisies.
		 * 
		 * Le nom du ficher est : saisie.json
		 *  
		 * Le fichier se pr�sentera sous la forme : 
		 *  par enregistrement 
		 *  	{"mot":"motsaisi","posX":positionXSaisie,"posY":positionYSaisie,"sens":true ou false}
		 *     
		 *      attention � bien respecter la syntaxe du fichier
		 *      les {} en d�but et fin d'enregistrement
		 *      les , entre 2 informations
		 *      les : entre le nom de la valeur et la valeur en elle-m�me
		 *      Les informations fixes "mot","posX",posY","sens" sont entre ""
		 *      Les valeurs positions x et y sont indiqu�es telles quelles
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
