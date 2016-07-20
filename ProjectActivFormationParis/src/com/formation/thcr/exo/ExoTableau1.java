package com.formation.thcr.exo;

import com.formation.phva.exo.InterExoTableau1;

public class ExoTableau1 implements InterExoTableau1 {

	/**
	 * Exemple d=7 , n=5 p=3 --> [7,10,13,16,19]
	 * 
	 * @param d
	 *            = valeur de départ
	 * @param n
	 *            = nb d'élément
	 * @param p
	 *            = pas entre chaque élément
	 * @return = nouveau tableau rempli
	 */

	public int[] remplirTableau(int d, int n, int p) {
		if (n < 0) {
			System.err.println("taille négative");
			return null;
		}
		int[] tab = new int[n];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = d;
			d = d + p;
		}
		return tab;
	}

	/**
	 * Exemple tab = [7,10,13,16,19,21,24,27,30] i1=3 , i2=8 tab =
	 * [7,10,27,16,19,21,24,13,30]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param i1
	 *            première position pour l'interversion
	 * @param i2
	 *            deuxième position pour l'interversion
	 * @return
	 */

	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2) {
		int tmpI1 = 0;
		int tmpI2 = 0;
		for (int i = 0; i < tab.length; i++) {
			if (i == i1) {
				tmpI1 = tab[i];
			} else if (i == i2) {
				tmpI2 = tab[i];
			}
		}
		for (int i = 0; i < tab.length; i++) {
			if (i == i1) {
				tab[i] = tmpI2;
			} else if (i == i2) {
				tab[i] = tmpI1;
			}
		}
		return tab;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=3,a=8 --> [1,4,6,8,2,4,6]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position après laquelle il faut ajouter la valeur a
	 * @param a
	 *            valeur à ajouter
	 * @return
	 */

	public int[] insererUnElementDansTableau(int[] tab, int p, int a) {
		int[] tmpTab = new int[tab.length + 1];
		int j = 0;
		for (int i = 0; i < tmpTab.length; i++) {
			if (i != p) {
				tmpTab[i] = tab[j];
				j++;
			} else {
				tmpTab[i] = a;
			}
		}
		tab = new int[tmpTab.length];
		tab = tmpTab;
		return tmpTab;
	}

	/**
	 * Exemple 1 [1,4,6,2,4,7] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,7] Exemple 2
	 * [22,11,0,77,88,99] : p=2, tab1=[3,4,5,6] --> [22,11,3,4,5,6]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position où il faut remplacer les valeurs du premier tableau
	 *            par celles du second
	 * @param tab1
	 *            tableau contenant les valeurs de remplacement
	 * @return tableau
	 */

	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1) {
		int j = 0;
		int[] tmpTab = new int[tab.length];
		for (int i = 0; i < tmpTab.length; i++) {
			if (i > p) {
				tmpTab[i] = tab1[j];
				j++;
			} else {
				tmpTab[i] = tab[i];
			}
		}
		return tmpTab;
	}

	/**
	 * Exemple 1 tab [1,4,6,2,4,6] : p = 2 --> tab résultat [4,6,1,4,6,2]
	 * Exemple 2 tab [1,4,6,2,4,6] : p = 4 --> tab résultat [6,2,4,6,1,4]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position : décaler le tableau vers la droite de p positions et
	 *            les p élements de la fin du tableau reviennent en début de
	 *            tableau
	 * @return
	 */

	public int[] rotationTableau(int[] tab, int p) {
		int[] tmpTab = new int[tab.length];
		for (int i = 0; i < tab.length; i++) {
			if (i + p < tab.length) {
				tmpTab[i] = tab[i + p];
			} else {
				tmpTab[i] = tab[(i + p) - tab.length];
			}
		}
		return tmpTab;
	}
}