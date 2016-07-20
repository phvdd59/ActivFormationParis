package com.formation.made.exo;

import com.formation.phva.exo.InterExoSimple;

public class ExoSimple implements InterExoSimple {

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */
	public int sumTableau(int[] tab) {
		int somme = 0; // on initialise le tableau somme
		for (int i = 0; i < tab.length; i++) { // on balaie les valeurs du tableau tab
			somme = somme + tab[i]; // on ajoute la valeur d'un élément du tableau a la somme déja obtenue
		}
		return somme;
	}
}
