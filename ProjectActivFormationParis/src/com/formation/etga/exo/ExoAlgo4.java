package com.formation.etga.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class ExoAlgo4 implements com.formation.phva.exo.InterAlgo4 {

	/**
	 * ma methode solution doit intégrer une liste de terme sous forme d'un
	 * tableau à deux dimensions
	 * 
	 * 
	 * example :
	 * 
	 * "DATTIERS" "EREINTEE" "COMEDIEN" "AMENER T" " ART API" "OTA MIAM"
	 * "BEIGE RE" "S REGAIN" "EPELER T" "DES VELA" "ET METAL" "REPU ESE"
	 *
	 * les cas annormaux seront traité en grande partie sur la base des
	 * exeption cruciExeption.
	 * 
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {

		char[][] tabSolution = new char[height][width]; // on initialise ce que l'on veut en resultat

		for (int i = 0; i < lst.size(); i++) {
			Terme terme = lst.get(i); // on isole tous les termes
			String nom = terme.getNom(); // on recup les noms
			char[] nomChar = nom.toCharArray(); // on transforme les noms en tab de char
			int xMot = (int) lst.get(i).getPos().getX(); // on recup les X
			int yMot = (int) lst.get(i).getPos().getY(); // on recup les Y

			if (terme.isSens() == Terme.HORIZONTAL) { // pour tous les termes horizontaux
				for (int j = 0; j < nomChar.length; j++) { // on boucle sur chaque mot 
					tabSolution[yMot][j] = nomChar[j]; // tableau = nom du char correspondant
				}
			} else if (terme.isSens() == Terme.VERTICAL) { // pour tous les termes verticaux
				for (int k = 0; k < nomChar.length; k++) { // on boucle sur chaque mot 
					tabSolution[k][xMot] = nomChar[k]; // tableau = nom du char correspondant
				}
			}
		}
		return tabSolution; // on retourne le resultat
	}
}
